package fi.reactor.assignment;

//DB connection class
public class DBconnection {
    private String serverHost = "";
    private String serverUser = "";
    private int serverPort = 0;
    private String serverPassword = "";

    public DBconnection() {
    }

    public String getServerHost() {
        return serverHost;
    }

    public String getServerUser() {
        return serverUser;
    }

    public int getServerPort() {
        return serverPort;
    }

    public String getServerPassword() {
        return serverPassword;
    }
}
