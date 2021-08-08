package com.cxf.demo.mtom;

import javax.activation.DataHandler;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * @author olysenko
 */
@WebService
public interface FileWs {

   void upload(@WebParam(name = "file") DataHandler dataHandler);

   DataHandler download();

}
