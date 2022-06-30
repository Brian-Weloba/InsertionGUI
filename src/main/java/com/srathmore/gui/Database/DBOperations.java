package com.srathmore.gui.Database;

import java.sql.Connection;

public abstract class DBOperations {
    public abstract void insert(String tableName, String[] columns, String[] values) throws Exception;

    public abstract void update(String tableName, String[] columns, String[] values, String whereClause)throws Exception;

    public abstract void delete(String tableName, String whereClause)throws Exception;

    public abstract void select(String tableName, String[] columns, String whereClause)throws Exception;

    public abstract Connection dbConnect();
}
