public enum Configuration {
    instance;

    public String fileSeparator = System.getProperty("file.separator");
    public String lineSeparator = System.getProperty("line.separator");

    public String dataPath = "data" + fileSeparator;

    public int maximumNumberOfRecords = 1000000;
}