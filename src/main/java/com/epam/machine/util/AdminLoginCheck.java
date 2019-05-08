package com.epam.machine.util;

public final class AdminLoginCheck {
    public static boolean checkLog(String username, String password) {
        if (username == null || password == null) {
            throw new IllegalArgumentException("No login or password");
        }
        return username.equals("Atticus_Burgess") && password.equals("qwerty");
    }

    private AdminLoginCheck() {
    }
}
