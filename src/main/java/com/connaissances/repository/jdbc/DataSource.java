package com.connaissances.repository.jdbc;

import java.sql.Connection;

public interface DataSource {
    Connection createConnection();
}
