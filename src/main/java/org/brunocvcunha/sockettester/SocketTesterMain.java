package org.brunocvcunha.sockettester;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.brunocvcunha.sockettester.core.SocketTesterController;
import org.brunocvcunha.sockettester.vo.SocketTesterVO;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.dom4j.tree.DefaultElement;
import org.omg.CORBA.BooleanHolder;

/**
 * Main Class
 * @author Bruno Candido Volpato da Cunha
 *
 */
public class SocketTesterMain {
  public static void main(String[] args) throws Exception {

    Element root =
        new SAXReader().read(SocketTesterMain.class.getResourceAsStream("/sockettester-sample.xml"))
            .getRootElement();

    final BooleanHolder hasError = new BooleanHolder(false);

    final ExecutorService service = Executors.newFixedThreadPool(10);

    @SuppressWarnings("unchecked")
    List<DefaultElement> ambientes = root.elements("environment");

    for (final DefaultElement env : ambientes) {
      Thread t1 = new Thread() {
        public void run() {
          SocketTesterVO vo;
          try {
            vo = SocketTesterController.validateEnvironmentNode(env);
            if (!vo.getStatus().equals("OK")) {
              hasError.value = true;
              System.err.println(vo.getHost() + ":" + vo.getPort() + " (" + vo.getName() + "): "
                  + vo.getStatus());
            } else {
              System.out.println(vo.getHost() + ":" + vo.getPort() + " (" + vo.getName() + "): "
                  + vo.getStatus());
            }
          } catch (IOException e) {
            e.printStackTrace();
          }

        }
      };
      service.submit(t1);
    }

    service.shutdown();
    service.awaitTermination(1, TimeUnit.MINUTES);

    if (hasError.value) {
      System.err.println("Errors occurred in SocketTester.");
    }

  }
}
