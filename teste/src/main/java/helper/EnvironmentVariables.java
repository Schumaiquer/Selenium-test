package helper;

public enum  EnvironmentVariables {
    DEV("http://demo.redmine.org/");

    private String url;

    EnvironmentVariables(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public static Boolean containsKey(String key) {
        for (EnvironmentVariables value : values()) {
            if (value.name().equals(key.toUpperCase())) {
                return true;
            }
        }
        return false;
    }
}
