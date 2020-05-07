package com.Project.Framework.Utilities;

public class ResourceUtility {
	
	public static String getBasePath() {
		String path = ResourceUtility.class.getClassLoader().getResource(".").getPath();
		return path;
	}
	
	public static String getResourcePath(String resourceName) {
		String path = getBasePath() + resourceName;
		return path;
	}

}
