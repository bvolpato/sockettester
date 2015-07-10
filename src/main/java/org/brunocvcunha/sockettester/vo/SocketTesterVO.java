package org.brunocvcunha.sockettester.vo;

/**
 * Socket Tester Value Object
 * 
 * @author Bruno Candido Volpato da Cunha
 *
 */
public class SocketTesterVO {

  private String type;
  private String name;
  private String host;
  private int port;
  private boolean valid;
  private String status;
  private String service;

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getHost() {
    return host;
  }

  public void setHost(String host) {
    this.host = host;
  }

  public int getPort() {
    return port;
  }

  public void setPort(int port) {
    this.port = port;
  }

  public boolean isValid() {
    return valid;
  }

  public void setValid(boolean valid) {
    this.valid = valid;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public String getService() {
    return service;
  }

  public void setService(String service) {
    this.service = service;
  }

  @Override
  public String toString() {
    return "SocketTesterVO [type=" + type + ", name=" + name + ", host=" + host + ", port=" + port
        + ", valid=" + valid + ", status=" + status + ", service=" + service + "]";
  }


}
