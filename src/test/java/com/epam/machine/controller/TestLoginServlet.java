package com.epam.machine.controller;

import com.epam.machine.util.LoginCheck;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(PowerMockRunner.class)
@PrepareForTest({LoginServlet.class, LoginCheck.class})
public class TestLoginServlet {
    private LoginServlet servletUnderTest;
    @Test
    public void doPostCallMethod() {
        PowerMockito.mockStatic(LoginCheck.class);
        servletUnderTest = new LoginServlet();
        HttpServletRequest request = PowerMockito.mock(HttpServletRequest.class);
        HttpServletResponse response = PowerMockito.mock(HttpServletResponse.class);
        LoginCheck.checkLog(any(), any());
        servletUnderTest.doPost(request, response);
        PowerMockito.verifyStatic();
        LoginCheck.checkLog(any(), any());
    }

    @Test
    public void doPostFalseLogin() throws ServletException, IOException {
        final String path = "/login.jsp";
        PowerMockito.mockStatic(LoginCheck.class);
        servletUnderTest = new LoginServlet();
        HttpServletRequest request = PowerMockito.mock(HttpServletRequest.class);
        HttpServletResponse response = PowerMockito.mock(HttpServletResponse.class);
        RequestDispatcher dispatcher = PowerMockito.mock(RequestDispatcher.class);
        PowerMockito.when(LoginCheck.checkLog(any(), any())).thenReturn(false);
        PowerMockito.when(request.getRequestDispatcher(path)).thenReturn(dispatcher);
        servletUnderTest.doPost(request, response);
        verify(request, times(1)).getRequestDispatcher(path);
        verify(dispatcher).forward(request, response);
    }
}
