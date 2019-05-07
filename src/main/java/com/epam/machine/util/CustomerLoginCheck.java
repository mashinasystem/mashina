package com.epam.machine.util;

public final class CustomerLoginCheck {
    public static boolean checkLog(String username, String password) {
        if (username == null || password == null) {
            throw new IllegalArgumentException("No login or password");
        }
        return username.equals("customer") && password.equals("qwerty");
    }

    private CustomerLoginCheck() {
    }
}
