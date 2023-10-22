package edu.hw2.Task3;

public class DefaultConnectionManager implements ConnectionManager {
    public Connection getConnection() {
        if ((int) Math.round(Math.random()) == 0) {
            return new StableConnection();
        } else {
            return new FaultyConnection();
        }
    }
}
