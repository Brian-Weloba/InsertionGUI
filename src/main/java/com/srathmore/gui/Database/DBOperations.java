package com.srathmore.gui.Database;

import java.sql.Connection;

public abstract class DBOperations {
    public abstract void insert(String tableName, String[] columns, String[] values);
    public abstract void update(String tableName, String[] columns, String[] values, String whereClause);
    public abstract void delete(String tableName, String whereClause);
    public abstract void select(String tableName, String[] columns, String whereClause);

    //a method to connect to the database dbConnect.
    public abstract Connection dbConnect();
}
