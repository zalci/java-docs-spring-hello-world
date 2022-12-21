package com.example.demo.model;

import java.io.File;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;

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
		try{
			jsonDBTemplate.createCollection(Instance.class);
		}catch (Exception e) {
			// TODO: handle exception
		}
		}
	}

	public static String getDBPath() throws IOException, GeneralSecurityException {
		initDB();
		return dbPath;
	}

	public static void insertInstance(Instance instance) throws IOException, GeneralSecurityException {
		initDB();
		jsonDBTemplate.insert(instance);
	}

	public static List<Instance> getAllInstances() throws IOException, GeneralSecurityException {
		initDB();
		//String jxQuery = "/.[not(privateKey='')]";
		//List<Instance> instances = jsonDBTemplate.find(jxQuery, Instance.class);
		List<Instance> instances = jsonDBTemplate.findAll(Instance.class);
		return instances;

	}

}
