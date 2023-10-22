package edu.hw2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

class ConnectionException extends RuntimeException {
    public ConnectionException(String errorMessage) {
        super(errorMessage);
    }
}

interface Connection extends AutoCloseable {
    void execute(String command);
}

class StableConnection implements Connection {
    public void execute(String command) {
    }

    public void close() {
    }
}

class FaultyConnection implements Connection {
    public void execute(String command) {
        if (((int) Math.round(Math.random()) == 0)) {
            throw new ConnectionException("Bad gateway");
        }
    }

    public void close() {
    }
}

interface ConnectionManager {
    Connection getConnection();
}

class DefaultConnectionManager implements ConnectionManager {
    public Connection getConnection() {
        if ((int) Math.round(Math.random()) == 0) {
            return new StableConnection();
        } else {
            return new FaultyConnection();
        }
    }
}

class FaultyConnectionManager implements ConnectionManager {
    public Connection getConnection() {
        return new FaultyConnection();
    }
}

final class PopularCommandExecutor {
    private final static Logger LOGGER = LogManager.getLogger();
    private final ConnectionManager manager;
    private final int maxAttempts;

    private final String updatePackagesCommand = "apt update && apt upgrade -y";

    public PopularCommandExecutor(ConnectionManager manager, int maxAttempts) {
        this.manager = manager;
        this.maxAttempts = maxAttempts;
    }

    public void updatePackages() {
        tryExecute(updatePackagesCommand);
    }

    void tryExecute(String command) throws ConnectionException {
        for (int i = 0; i < maxAttempts; i++) {
            try {
                Connection connection = manager.getConnection();
                connection.execute(command);
                break;
            } catch (ConnectionException ex) {
                LOGGER.info(ex.getMessage());
                if (i == maxAttempts - 1) {
                    throw ex;
                }
            }
        }
    }
}
