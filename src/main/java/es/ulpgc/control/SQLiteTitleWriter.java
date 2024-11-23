package es.ulpgc.control;

import es.ulpgc.model.Title;

import java.io.File;
import java.io.IOException;
import java.sql.*;

public class SQLiteTitleWriter implements TitleWriter{
    private final Connection connection;
    private static final String createTable = """
            CREATE TABLE IF NOT EXISTS titles(
            id TEXT PRIMARY KEY,
            type TEXT NOT NULL,
            primaryTitle TEXT NOT NULL,
            originalTitle TEXT NOT NULL,
            isAdult BOOLEAN NOT NULL,
            startYear YEAR,
            endYear YEAR,
            runtimeMinutes INTEGER,
            genres TEXT)
            """;

    private static final String deleteTable = """
            DELETE FROM titles
            """;
    private final String insertSQL = "INSERT INTO titles(id, type, primaryTitle, originalTitle, isAdult, startYear, endYear, runtimeMinutes, genres) " +
            "VALUES(?,?,?,?,?,?,?,?,?)";
    private PreparedStatement insertStatement;

    @Override
    public void write(Title title) throws IOException {
        try {
            insertStatement.setString(1, title.id());
            insertStatement.setString(2, title.titleType().name());
            insertStatement.setString(3, title.primaryTitle());
            insertStatement.setString(4, title.originalTitle());
            insertStatement.setBoolean(5, title.isAdult());
            if (title.startYear() != null)insertStatement.setInt(6, title.startYear().getValue());
            if (title.endYear() != null) insertStatement.setInt(7, title.endYear().getValue());
            if (title.runtimeMinutes() != null) insertStatement.setInt(8, title.runtimeMinutes());
            if (title.genres() != null) insertStatement.setString(9, title.genres().toString());
            insertStatement.execute();
        } catch (SQLException e) {
            throw new IOException(e);
        }
    }


    public SQLiteTitleWriter(File file) throws IOException {
        this.connection = openConnection(file);
        prepareDatabase();
    }

    private Connection openConnection(File file) throws IOException {
        try {
            return DriverManager.getConnection("jdbc:sqlite:"+ file.getAbsolutePath());
        } catch (SQLException e) {
            throw new IOException(e);
        }
    }

    private void prepareDatabase() throws IOException {
        try {
            Statement statement = connection.createStatement();
            statement.execute(createTable);
            statement.execute(deleteTable);
            connection.setAutoCommit(false);
            insertStatement = connection.prepareStatement(this.insertSQL);
        } catch (SQLException e) {
            throw new IOException(e);
        }
    }

    public void closeConnection() throws IOException {
        try {
            connection.commit();
            connection.close();
        } catch (SQLException e) {
            throw new IOException(e);
        }
    }
}
