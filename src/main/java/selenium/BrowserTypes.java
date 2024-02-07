package selenium;

public enum BrowserTypes {
    CHROME,
    CHROME_H,
    FIREFOX;

    @Override
    public String toString() {
        return name();
    }

}