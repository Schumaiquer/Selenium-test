package helper;

import static helper.EnvironmentVariables.DEV;

public class Environment {
    private static EnvironmentVariables currentEnvironment;

    private Environment() {
    }

    public static EnvironmentVariables getEnv() {
        if (currentEnvironment == null) {
            currentEnvironment = processEnvironment();
        }
        return currentEnvironment;
    }

    public static EnvironmentVariables processEnvironment() {
        if (System.getProperties().containsKey("env")) {
            String requestedEnvironment = System.getProperty("env");
            return EnvironmentVariables.containsKey(requestedEnvironment) ?
                    EnvironmentVariables.valueOf(requestedEnvironment.toUpperCase()) :
                    DEV;
        }
        return DEV;
    }
}