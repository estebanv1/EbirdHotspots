package co.ebird.hotspot.models;

public class LoginData {

    private String strUsername;
    private String strPassword;

    public String getStrUsername() {
        return strUsername;
    }

    public String getStrPassword() {
        return strPassword;
    }

    public LoginData(String strUsername, String strPassword) {
        this.strUsername = strUsername;
        this.strPassword = strPassword;
    }

    public LoginData() {
    }
}
