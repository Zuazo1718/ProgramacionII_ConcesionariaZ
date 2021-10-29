package com.JeanZ;

import com.JeanZ.util.ConectorBD;

import java.sql.Connection;

public class main {
    public static void main(String[] args) {
        Connection connection = ConectorBD.getConnection();
    }
}
