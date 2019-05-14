package com.epam.machine.util;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class LoginCheckTest {
    @Test
    public void testRightLogin() {
        final String username = "1";
        final String password = "qwerty";
        final boolean trueLog = LoginCheck.checkLog(username, password);
        assertTrue(trueLog);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testExceptionName() {
        final String username = null;
        final String password = "qwerty";
        LoginCheck.checkLog(username, password);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testExceptionPassword() {
        final String username = "1";
        final String password = null;
        LoginCheck.checkLog(username, password);
    }
}
