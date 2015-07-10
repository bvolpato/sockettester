package org.brunocvcunha.sockettester.service;

import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.log4j.Logger;
import org.brunocunha.inutils4j.MyStringUtils;
import org.brunocvcunha.sockettester.vo.SocketTesterVO;

/**
 * HTTP Validator
 * @author Bruno Candido Volpato da Cunha
 *
 */
public class HTTPTesterService implements ISocketTesterService {
  
  private static Logger log = Logger.getLogger(HTTPTesterService.class);

  @Override
  public void validate(SocketTesterVO vo) {
    log.info("Validating HTTP " + vo);

    boolean validHttp = true;

    try {
      String stringUrl =
          "http://" + vo.getHost() + ":" + vo.getPort() + "/"
              + (vo.getService() != null ? vo.getService() : "");
      URL url = new URL(stringUrl);
      HttpURLConnection conn = (HttpURLConnection) url.openConnection();

      String contentResponse = MyStringUtils.getContent(conn.getInputStream());
      log.debug("Response: " + contentResponse);
      
      if (conn.getResponseCode() != HttpURLConnection.HTTP_OK) {
        log.info("Response from " + stringUrl + ": " + conn.getResponseCode() + " "
            + conn.getResponseMessage());
      } else {
        log.debug("Response from " + stringUrl + ": " + conn.getResponseCode() + " "
            + conn.getResponseMessage());
      }

    } catch (Exception e) {
      e.printStackTrace();
      validHttp = false;
    }

    vo.setValid(validHttp);
    if (!validHttp) {
      vo.setStatus("HTTPRequest Failed");
    }
  }

}
