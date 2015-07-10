package org.brunocvcunha.sockettester.service;

import org.apache.log4j.Logger;
import org.brunocvcunha.sockettester.vo.SocketTesterVO;

/**
 * AppServer Validator
 * 
 * @author Bruno Candido Volpato da Cunha
 *
 */
public class AppServerTesterService implements ISocketTesterService {

  private static Logger log = Logger.getLogger(AppServerTesterService.class);

  @Override
  public void validate(SocketTesterVO vo) {
    log.info("Validating AppServer " + vo);
    
    /* Do nothing at this time
    Connection conn = null;
    AppObject obj = null;
    try {
      String connectionURL =
          "AppServer://" + vo.getHost() + ":" + vo.getPort() + "/" + vo.getService();
      conn = new Connection(connectionURL, "", "", "");
      obj = new AppObject("emsflex", conn, RunTimeProperties.tracer, null);

      ParameterSet params = new ParameterSet(0);
      Procedure opo = obj.CreatePO("java/ping.p", params);

      obj.getSession().isConnected();

      vo.setValid(true);

      // System.out.println("Connection with " + connectionURL + " - " + validApp);
    } catch (Exception e) {
      e.printStackTrace();

      vo.setValid(false);
      vo.setStatus("Falhou: " + e.getMessage());

    } finally {
      try {
        obj.getSession().shutdown();
      } catch (Exception e) {
      }

      try {
        obj._cancelAllRequests();
      } catch (Exception e) {
      }
      try {
        obj._release();
      } catch (Exception e) {
      }
      try {
        conn.releaseConnection();
      } catch (Exception e) {
      }
      try {
        conn.finalize();
      } catch (Exception e) {
      }
    }
    */
  }

}
