package com.cechinel;

import org.springframework.dao.DataAccessException;

public class CassandraException extends DataAccessException {
    CassandraException() {
        super("Cassandra exception");
    }
}