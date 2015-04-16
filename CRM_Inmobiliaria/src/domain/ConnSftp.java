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
	// conexion
	private static String SFTP_HOST = null; // "172.22.209.100";
	private static String SFTP_USER = null; // "ftpuser";
	private static String SFTP_PASS = null; // "ftpuser";
	private static String SFTP_DIR_SERVER = null; // "/datastage_data/Liverpool/DWH_EIL/input/sieb/";
	private static String SFTP_DIR_LOCAL = null; // "/home/crmca/workspace/apps/";

	public boolean conectar(String cfg) throws IOException, SftpException {

		JSch jsch = new JSch();
		Session session = null;
		Channel channel = null;
		ChannelSftp channelSftp = null;
		Properties prop = new Properties();
		InputStream configFile = null;
		try {
			configFile = new FileInputStream(cfg); // configFile = new
															// FileInputStream(args[0]);
			prop.load(configFile);
			SFTP_HOST = prop.getProperty("HOST_SFTP");
			System.out.println("Host: " + SFTP_HOST);
			SFTP_USER = prop.getProperty("USER_SFTP");
			System.out.println("Usuario: " + SFTP_USER);
			SFTP_PASS = prop.getProperty("PWD_SFTP");
			System.out.println("Contraseña: " + SFTP_PASS);
			SFTP_DIR_SERVER = prop.getProperty("SFTP_WORKING_DIR");
			System.out.println("Direccion del servidor : " + SFTP_DIR_SERVER);
			SFTP_DIR_LOCAL = prop.getProperty("LOCAL_DIR");
			System.out.println("Sireccion local : " + SFTP_DIR_LOCAL);
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		boolean conect = true;

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
			channel.disconnect();
			session.disconnect();
		} catch (JSchException e) {
			System.out.println("JSchException =" + e.getMessage());
			conect = false;
		}
		return conect;
	}

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
			configFile = new FileInputStream(cfg); // configFile = new
															// FileInputStream(args[0]);
			prop.load(configFile);
			SFTP_HOST = prop.getProperty("HOST_SFTP");
			//System.out.println("Host: " + SFTP_HOST);
			SFTP_USER = prop.getProperty("USER_SFTP");
			//System.out.println("Usuario: " + SFTP_USER);
			SFTP_PASS = prop.getProperty("PWD_SFTP");
			//System.out.println("Contraseña: " + SFTP_PASS);
			SFTP_DIR_SERVER = prop.getProperty("SFTP_WORKING_DIR");
			//System.out.println("Direccion del servidor : " + SFTP_DIR_SERVER);
			SFTP_DIR_LOCAL = prop.getProperty("LOCAL_DIR");
			//System.out.println("Sireccion local : " + SFTP_DIR_LOCAL);
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
//					System.out.println("Files: " + fileName);
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