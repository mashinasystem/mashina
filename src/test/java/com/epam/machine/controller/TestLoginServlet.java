package com.epam.machine.controller;

import com.epam.machine.util.LoginCheck;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static org.mockito.Matchers.any;
import static org.powermock.api.mockito.PowerMockito.doNothing;

@RunWith(PowerMockRunner.class)
@PrepareForTest({LoginServlet.class, LoginCheck.class})
public class TestLoginServlet {
    private LoginServlet servletUnderTest;
    @Test
    public void servTest() {
        PowerMockito.mockStatic(LoginCheck.class);

        servletUnderTest = new LoginServlet();
        HttpServletRequest request = PowerMockito.mock(HttpServletRequest.class);
        HttpServletResponse response = PowerMockito.mock(HttpServletResponse.class);
        doNothing().when(LoginCheck.class);
        LoginCheck.checkLog(any(), any());
        servletUnderTest.doPost(request, response);

        PowerMockito.verifyStatic(LoginCheck.class);
        LoginCheck.checkLog(any(), any());
    }
}
