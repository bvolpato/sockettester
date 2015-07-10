package org.brunocvcunha.sockettester.service;

import java.io.IOException;

import org.brunocvcunha.sockettester.vo.SocketTesterVO;

/**
 * Socket tester contract for future implementations
 * @author Bruno Candido Volpato da Cunha
 *
 */
public interface ISocketTesterService {

  void validate(SocketTesterVO vo) throws IOException;
  
}
