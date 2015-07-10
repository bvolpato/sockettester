package org.brunocvcunha.sockettester.service;

import static org.junit.Assert.assertTrue;

import org.brunocvcunha.sockettester.vo.SocketTesterVO;
import org.junit.Test;

/**
 * @author Bruno Candido Volpato da Cunha
 *
 */
public class HTTPTesterServiceTest {

  @Test
  public void testSimple() {
    SocketTesterVO vo = new SocketTesterVO();
    vo.setHost("github.com");
    vo.setName("Github");
    vo.setPort(80);
    vo.setService("");
    vo.setType("HTTP");

    HTTPTesterService service = new HTTPTesterService();
    service.validate(vo);

    assertTrue(vo.isValid());

  }
}
