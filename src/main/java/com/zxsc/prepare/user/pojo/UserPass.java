package com.zxsc.prepare.user.pojo;

import java.util.Arrays;

public class UserPass extends User {
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        char[] pEncrypt = password.toCharArray();
        Arrays.fill(pEncrypt, '*');
        return "[Name: " + getUsername() + ", Pass: " + pEncrypt + "]";
    }
}
