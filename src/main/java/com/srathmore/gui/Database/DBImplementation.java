package com.srathmore.gui.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBImplementation extends DBOperations {
    Connection databaseLink;

    @Override
    public void insert(String tableName, String[] columns, String[] values) throws Exception {
        //use the databaseLink to insert the values into the table.
        Connection databaseLink = dbConnect();
        //create a insertQuery to insert the values into the table.
        StringBuilder insertQuery = new StringBuilder("insert into " + tableName + "(");
        for (int i = 0; i < columns.length; i++) {
            insertQuery.append(columns[i]);
            if (i != columns.length - 1) {
                insertQuery.append(", ");
            }
        }
        insertQuery.append(") values (");
        for (int i = 0; i < values.length; i++) {
            insertQuery.append("'").append(values[i]).append("'");
            if (i != values.length - 1) {
                insertQuery.append(", ");
            }
        }
        insertQuery.append(")");
        Statement statement = databaseLink.createStatement();
        statement.executeUpdate(insertQuery.toString());
        statement.close();
    }

    @Override
    public void update(String tableName, String[] columns, String[] values, String whereClause) throws Exception {
        //use the databaseLink to update the values into the table.
        Connection databaseLink = dbConnect();
        //create a updateQuery to update the values into the table.
        StringBuilder updateQuery = new StringBuilder("update " + tableName + " set ");
        for (int i = 0; i < columns.length; i++) {
            updateQuery.append(columns[i]).append(" = '").append(values[i]).append("'");
            if (i != columns.length - 1) {
                updateQuery.append(", ");
            }
        }
        updateQuery.append(" where ").append(whereClause);

        Statement statement = databaseLink.createStatement();
        statement.executeUpdate(updateQuery.toString());
        statement.close();
    }

    @Override
    public void delete(String tableName, String whereClause) throws Exception {
        //use the databaseLink to delete the values into the table.
        Connection databaseLink = dbConnect();
        //create a deleteQuery to delete the values into the table.
        String deleteQuery = "delete from " + tableName + " where " + whereClause;
        Statement statement = databaseLink.createStatement();
        statement.executeUpdate(deleteQuery);
        statement.close();

    }

    @Override
    public void select(String tableName, String[] columns, String whereClause) throws Exception {
        //use the databaseLink to select the values into the table.
        Connection databaseLink = dbConnect();
        //create a selectQuery to select the values into the table.
        StringBuilder selectQuery = new StringBuilder("select ");
        for (int i = 0; i < columns.length; i++) {
            selectQuery.append(columns[i]);
            if (i != columns.length - 1) {
                selectQuery.append(", ");
            }
        }
        selectQuery.append(" from ").append(tableName).append(" where ").append(whereClause);

        Statement statement = databaseLink.createStatement();
        ResultSet queryOutput = statement.executeQuery(selectQuery.toString());
        while (queryOutput.next()) {
            for (String column : columns) {
                System.out.println(column + ": " + queryOutput.getString(column));
            }
        }
        statement.close();
    }

    @Override
    public Connection dbConnect() {
        String databaseName = "users";
        String databaseUser = "root";
        String databasePassword = "Flamingo4";
        String url = "jdbc:mysql://localhost/" + databaseName;


        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            databaseLink = DriverManager.getConnection(url, databaseUser, databasePassword);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return databaseLink;
    }
}
