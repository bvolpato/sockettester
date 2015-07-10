package org.brunocvcunha.sockettester.core;

import java.net.Socket;

/**
 * Utilities for SocketTester
 * @author Bruno Candido Volpato da Cunha
 *
 */
public class SocketTesterHelper {

  public static boolean isValidSocket(String host, int port) {
    try {
      Socket s = new Socket(host, port);

      boolean connected = s.isConnected();

      try {
        s.close();
      } catch (Exception e) {
      }

      return connected;
    } catch (Exception e) {
      return false;
    }
  }
}
