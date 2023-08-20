package co.ebird.hotspot.models;

public class LoginData {

    private String strUsername;
    private String strPassword;

    public LoginData(String strUsername, String strPassword) {
        this.strUsername = strUsername;
        this.strPassword = strPassword;
    }

    public String getStrUsername() {
        return strUsername;
    }

    public void setStrUsername(String strUsername) {
        this.strUsername = strUsername;
    }

    public String getStrPassword() {
        return strPassword;
    }

    public void setStrPassword(String strPassword) {
        this.strPassword = strPassword;
    }
}
