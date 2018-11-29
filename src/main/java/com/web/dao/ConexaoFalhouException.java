package com.web.dao;

import java.sql.SQLException;

public class ConexaoFalhouException extends Throwable {
    public ConexaoFalhouException(SQLException e) {
    }
}
