package edu.hw2.Task3;

public class FaultyConnection implements Connection {
    public void execute(String command) {
        if (((int) Math.round(Math.random()) == 0)) {
            throw new ConnectionException("Bad gateway");
        }
    }

    public void close() {
    }
}
