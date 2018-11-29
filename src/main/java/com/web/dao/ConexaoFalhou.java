package com.web.dao;

import java.sql.SQLException;

public class ConexaoFalhou extends Throwable {
    public ConexaoFalhou(SQLException e) {
    }
}
