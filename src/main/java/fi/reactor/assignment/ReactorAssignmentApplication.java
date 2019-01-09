package fi.reactor.assignment;

import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ReactorAssignmentApplication {

	static Session session;

	public static void establishSSHconnection(DBconnection dBconnection) {
		String serverHost = dBconnection.getServerHost();
		String serverUser = dBconnection.getServerUser();
		int serverPort = dBconnection.getServerPort();
		String serverPassword = dBconnection.getServerPassword();
		try
		{
			JSch jsch = new JSch();
			session = jsch.getSession(serverUser, serverHost, serverPort);
			session.setPassword(serverPassword);
			session.setConfig("StrictHostKeyChecking", "no");
			System.out.println("Establishing Connection...");
			session.connect();
			int assinged_port=session.setPortForwardingL(3306, "localhost", 3306);
			System.out.println("SSH connection established! \nlocalhost:"+assinged_port+" -> "+"localhost"+":"+3306);
		}
		catch(Exception e){System.err.print(e);}
	}

	public static void disconnectSSHconnection() {
		System.out.println("Disconnecting from SSH connection!");
		session.disconnect();
	}

	public static void main(String[] args) {
//		DBconnection dBconnection = new DBconnection();
//		establishSSHconnection(dBconnection);
		SpringApplication.run(ReactorAssignmentApplication.class, args);
	}
}

