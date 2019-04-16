package com.epam.machine.Controller.util;

public final class loginCheck {
    public static boolean checkLog (String username, String password) {
        if (username == null || password == null) throw new NullPointerException("No login or password");
        return username.equals("1") && password.equals("qwerty");
    }

    private loginCheck() {}
}
