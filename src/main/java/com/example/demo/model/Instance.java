package com.example.demo.model;

import io.jsondb.annotation.Document;
import io.jsondb.annotation.Id;
import io.jsondb.annotation.Secret;

/**
 * A test Pojo representing a imaginary class Instance.
 * @version 1.0 28-Sep-2016
 */
@Document(collection = "instances", schemaVersion= "1.0")
public class Instance {
  //This field will be used as a primary key, every POJO should have one
  @Id
  private String id;
  private String hostname;
  // This field will be encrypted using the provided cipher
  @Secret
  private String privateKey;

  public String getId() { return id; }
  public void setId(String id) { this.id = id; }
  public String getHostname() { return hostname; }
  public void setHostname(String hostname) { this.hostname = hostname; }
  public String getPrivateKey() { return privateKey; }
  public void setPrivateKey(String privateKey) { this.privateKey = privateKey; }
}