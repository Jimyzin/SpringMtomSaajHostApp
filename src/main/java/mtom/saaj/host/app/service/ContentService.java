package mtom.saaj.host.app.service;

import javax.activation.DataHandler;

/**
 * Created by User on 22-04-2017.
 */
public interface ContentService {
    /**
     * @param name
     * @param dataHandler
     * @throws Exception
     */
    void storeContent(String name, DataHandler dataHandler) throws Exception;

    /**
     * @param name
     * @return
     * @throws Exception
     */
    DataHandler loadContent(String name) throws Exception;
}
