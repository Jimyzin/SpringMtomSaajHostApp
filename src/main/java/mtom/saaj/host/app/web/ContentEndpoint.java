package mtom.saaj.host.app.web;

import mtom.saaj.host.app.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.spring_ws.samples.mtom.*;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import javax.activation.DataHandler;


/**
 * Created by User on 22-04-2017.
 */
@Endpoint
public class ContentEndpoint {

    /**
     * Target namespace
     */
    private static final String TNS = "http://www.springframework.org/spring-ws/samples/mtom";
    /**
     * JAXB object factory
     */
    private final ObjectFactory objectFactory = new ObjectFactory();
    @Autowired
    private ContentService contentService;

    @PayloadRoot(localPart = "LoadContentRequest", namespace = TNS)
    public @ResponsePayload
    LoadContentResponse loadContent(@RequestPayload LoadContentRequest loadContentRequest) throws Exception {
        LoadContentResponse resp = objectFactory.createLoadContentResponse();

        DataHandler dataHandler = contentService.loadContent(loadContentRequest.getName());
        resp.setName(loadContentRequest.getName());
        resp.setContent(dataHandler);

        return resp;
    }

    @PayloadRoot(localPart = "StoreContentRequest", namespace = TNS)

    public @ResponsePayload
    StoreContentResponse storeContent(@RequestPayload StoreContentRequest storeContentRequest) throws Exception {
        System.out.println("Request received");
        contentService.storeContent(storeContentRequest.getName(), storeContentRequest.getContent());
        StoreContentResponse resp = objectFactory.createStoreContentResponse();
        resp.setMessage("Success");
        return resp;
    }
}
