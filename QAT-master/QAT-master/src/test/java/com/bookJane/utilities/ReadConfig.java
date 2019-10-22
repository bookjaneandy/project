package com.bookJane.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

	Properties pro;
	
	public ReadConfig()
	{
		File src = new File("./Configuration/config.properties");

		try {
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
		} catch (Exception e) {
			System.out.println("Exception is " + e.getMessage());
		}
	}
	
	public String getRegistrationURL()
	{
		String regUrl=pro.getProperty("baseURL");
		return regUrl;
	}
	
	public String getStageEntUrl()
	{
		String entUrl = pro.getProperty("stageEntUrl");
		return entUrl;
	}
	
	public String getOrganisation()
	{
	String org=pro.getProperty("txtOrg");
	return org;
	}
	
	public String getFname()
	{
	String fname=pro.getProperty("txtFname");
	return fname;
	}
	
	public String getLname()
	{
	String lname=pro.getProperty("txtLname");
	return lname;
	}
	
	public String getPhone()
	{
	String ph=pro.getProperty("txtPhone");
	return ph;
	}
	
	public String getEmail()
	{
	String email=pro.getProperty("txtEmail");
	return email;
	}
	
	public String getPassword()
	{
	String password=pro.getProperty("txtPswd");
	return password;
	}
	
	public String getPassword2()
	{
	String password2=pro.getProperty("txtPswd2");
	return password2;
	}
	
	public String getLocation()
	{
	String location=pro.getProperty("txtLocation");
	return location;
	}
	
	public String getLocAddress()
	{
	String locAddress=pro.getProperty("txtLocAddress");
	return locAddress;
	}
	
	public String getLogUrl()
	{
	String logUrl=pro.getProperty("loginURL");
	return logUrl;
	}
	
	public String getLogUser()
	{
	String logUser=pro.getProperty("txtUser3");
	return logUser;
	}
	
	
	public String getLogPswd()
	{
	String logPswd=pro.getProperty("txtPswd3");
	return logPswd;
	}
	
	public String getHomeUrl()
	{
	String homeUrl=pro.getProperty("homeUrl");
	return homeUrl;
	}
	
	public String getSandHomeUrl()
	{
	String homeUrl=pro.getProperty("sandHomeUrl");
	return homeUrl;
	}
	
	public String getDashUrl()
	{
		String dashUrl=pro.getProperty("dashUrl");
		return dashUrl;
	}
	
	public String getChromePath()
	{
	String chromepath=pro.getProperty("chromepath");
	return chromepath;
	}
	
	public String getIEPath()
	{
	String iepath=pro.getProperty("iepath");
	return iepath;
	}
	
	public String getFirefoxPath()
	{
	String firefoxpath=pro.getProperty("firefoxpath");
	return firefoxpath;
	}
	
	
	
}
