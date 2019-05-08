package com.epam.machine.util;

public final class LoginCheck {
    public static boolean checkLog(String username, String password) {
        if (username == null || password == null) {
            throw new IllegalArgumentException("No login or password");
        }
        return username.equals("login@gmail.com") && password.equals("qwerty");
    }

    private LoginCheck() {
    }
}
