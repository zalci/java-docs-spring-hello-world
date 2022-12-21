package com.example.demo.model;

import java.io.File;
import java.io.IOException;
import java.security.GeneralSecurityException;

import io.jsondb.JsonDBTemplate;
import io.jsondb.crypto.Default1Cipher;
import io.jsondb.crypto.ICipher;

public class DBManager {
	private static String dbPath;
	private static JsonDBTemplate jsonDBTemplate;

	public static void initDB() throws IOException, GeneralSecurityException {
		if (jsonDBTemplate == null) {
		String currentPath = new java.io.File(".").getCanonicalPath();

		dbPath=currentPath+"/db";
		File f = new File(currentPath+"/db");
		f.mkdir();

		//Actual location on disk for database files, process should have read-write permissions to this folder
		String dbFilesLocation = dbPath ;

		//Java package name where POJO's are present
		String baseScanPackage = "com.example.demo.model";

		//Optionally a Cipher object if you need Encryption
		ICipher cipher = new Default1Cipher("1r8+24pibarAWgS85/Heeg==");

		jsonDBTemplate = new JsonDBTemplate(dbFilesLocation, baseScanPackage, cipher);
		}
	}

	public static String getDBPath() {
		return dbPath;
	}

}
