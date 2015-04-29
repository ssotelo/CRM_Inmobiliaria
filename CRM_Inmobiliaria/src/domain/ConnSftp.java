package domain;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.SftpException;

public class ConnSftp {
	private static String SFTP_HOST = null;
	private static String SFTP_USER = null;
	private static String SFTP_PASS = null;
	private static String SFTP_DIR_SERVER = null; 
	private static String SFTP_DIR_LOCAL = null; 

	public void conexionSftp(String cfg) {
		JSch jsch = new JSch();
		Session session = null;
		Channel channel = null;
		ChannelSftp channelSftp = null;
		File fileLocalDir = null;
		String fileName = null;
		Properties prop = new Properties();
		InputStream configFile = null;
		try {
			configFile = new FileInputStream(cfg);
			prop.load(configFile);
			SFTP_HOST = prop.getProperty("HOST_SFTP");
			SFTP_USER = prop.getProperty("USER_SFTP");
			SFTP_PASS = prop.getProperty("PWD_SFTP");
			SFTP_DIR_SERVER = prop.getProperty("SFTP_WORKING_DIR");
			SFTP_DIR_LOCAL = prop.getProperty("LOCAL_DIR");
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		try {
			jsch = new JSch();
			session = jsch.getSession(SFTP_USER, SFTP_HOST, 22);
			session.setPassword(SFTP_PASS);
			java.util.Properties config = new java.util.Properties();
			config.put("StrictHostKeyChecking", "no");
			session.setConfig(config);
			session.connect();

			channel = session.openChannel("sftp");
			channel.connect();
			channelSftp = (ChannelSftp) channel;
			channelSftp.cd(SFTP_DIR_SERVER);
			channelSftp.lcd(SFTP_DIR_LOCAL);

			System.out.println("Copia de archivos: ");
			fileLocalDir = new File(SFTP_DIR_LOCAL);
			File[] listOfFiles = fileLocalDir.listFiles();
			int n = 0;
			for (File file : listOfFiles) {
				if (file.isFile()) {
					fileName = file.getName();
					if (fileName.contains(".dat")) {
						System.out.println("Copy File .dat: " + fileName);
						channelSftp.put(fileName, fileName);
						n++;
					}
					if (fileName.contains(".cif")) {
						System.out.println("Copy File .cif: " + fileName);
						channelSftp.put(fileName, fileName);
						n++;
					} else if (fileName.contains(".ctl")) {
						System.out.println("Copy File .ctl: " + fileName);
						channelSftp.put(fileName, fileName);
						n++;
					}
				}
			}
			System.out.println("Se agregaron "+ n + " archivos");
			System.out.println("Conexion  FTP Site ok ");
			channel.disconnect();
			session.disconnect();
		} catch (SftpException e) {
			System.out.println("SftpException =" + e.getMessage());
		} catch (JSchException e) {
			System.out.println("SftpException =" + e.getMessage());
		}
	}
}