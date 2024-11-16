package es.ulpgc.control;

import es.ulpgc.control.TitleReader;
import es.ulpgc.model.Title;

import java.io.File;
import java.io.IOException;
import java.sql.*;
import java.time.Year;
import java.util.Iterator;

public class SQLiteTitleReader implements TitleReader {
    
    private final Connection connection;
    private final PreparedStatement selectStatement;
    
    public SQLiteTitleReader(File dbFile) throws IOException {
        try {
            this.connection = openConnection(dbFile);
            this.selectStatement = connection.prepareStatement("SELECT * FROM titles");
            selectStatement.execute();
        } catch (SQLException e) {
            throw new IOException(e);
        }
    }

    @Override
    public Iterator<Title> read() throws IOException {
        return new Iterator<>() {
            final ResultSet resultSet = executeQuery();
            @Override
            public boolean hasNext() {
                try {
                    return resultSet.next();
                } catch (SQLException e) {
                    return false;
                }
            }

            @Override
            public Title next() {
                try {
                    TsvTitleDeserializer tsvTitleDeserializer = new TsvTitleDeserializer();
                    return new Title(resultSet.getString(1), Title.TitleType.valueOf(resultSet.getString(2)),
                            resultSet.getString(3), resultSet.getString(4), resultSet.getBoolean(5),
                            Year.of(resultSet.getInt(6)), Year.of(resultSet.getInt(7)), resultSet.getInt(8),
                            tsvTitleDeserializer.getGenres(resultSet.getString(9)));
                } catch (SQLException e) {
                    return null;
                }
            }
        };
    }

    private ResultSet executeQuery() throws IOException {
        try {
            return selectStatement.executeQuery();
        } catch (SQLException e) {
            throw new IOException(e);
        }
    }

    private Connection openConnection(File dbFile) throws SQLException {
        return DriverManager.getConnection("jdbc:sqlite:*" + dbFile.getAbsolutePath());
    }
}
