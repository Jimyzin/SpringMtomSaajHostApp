package mtom.saaj.host.app.service;

import org.springframework.stereotype.Service;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by User on 22-04-2017.
 */
@Service
public class ContentServiceImpl implements ContentService {

    public void storeContent(String name, DataHandler dataHandler) throws Exception {

        File file = new File("C:\\Users\\User\\Desktop\\ContentRepository\\" + name);
        InputStream inputStream = dataHandler.getInputStream();
        OutputStream outputStream = new FileOutputStream(file);
        byte[] buffer = new byte[10240];
        int i;
        while ((i = inputStream.read(buffer, 0, buffer.length)) > 0) {
            outputStream.write(buffer, 0, i);
        }

    }

    public DataHandler loadContent(String name) throws Exception {

        File file = new File("C:\\Users\\User\\Desktop\\ContentRepository\\" + name);
        DataHandler dataHandler = new DataHandler(new FileDataSource(file));
        return dataHandler;
    }
}
