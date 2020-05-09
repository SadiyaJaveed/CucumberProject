package com.Project.Framework.Utilities;

public interface IReader {
	
	public String getBrowserType();
	public String getUrl();
	public String getUsername();
	public String getPassword();
	public int getExplicitWait();
	public void setBrowserType();   //this is to set the browsertype during runtime without modifting config.properties
	
}
