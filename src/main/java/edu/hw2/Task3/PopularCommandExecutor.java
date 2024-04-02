package edu.hw2.Task3;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class PopularCommandExecutor {
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
