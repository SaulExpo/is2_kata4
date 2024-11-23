package es.ulpgc.persistance;

import es.ulpgc.control.SQLiteTitleReader;
import es.ulpgc.model.Title;

import java.io.File;
import java.sql.*;
import java.time.Year;

public class SQLiteRandomTItleLoader implements RandomTitleLoader{
    private final Connection connection;
    private final PreparedStatement selectStatement;
    private final ResultSet resultSet;

    public SQLiteRandomTItleLoader(File dbFile){
        try {
            this.connection = openConnection(dbFile);
            this.selectStatement = connection.prepareStatement("SELECT * FROM titles ORDER BY RANDOM() LIMIT 1;");
            selectStatement.execute();
            this.resultSet = executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private ResultSet executeQuery() {
        try {
            return selectStatement.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private Connection openConnection(File dbFile) {
        try {
            return DriverManager.getConnection("jdbc:sqlite:" + dbFile.getAbsolutePath());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Title load(){
        try {
            return new Title(resultSet.getString(1), Title.TitleType.valueOf(resultSet.getString(2)),
                    resultSet.getString(3), resultSet.getString(4), resultSet.getBoolean(5),
                    Year.of(resultSet.getInt(6)), Year.of(resultSet.getInt(7)), resultSet.getInt(8),
                    SQLiteTitleReader.getGenres(resultSet.getString(9)));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
