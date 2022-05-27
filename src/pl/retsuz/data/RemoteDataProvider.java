package pl.retsuz.data;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class RemoteDataProvider implements IRemoteDataProvider{
    private URL link;
    private InputStream inputStream;
    private InputStreamReader reader;
    private BufferedReader bufferedReader;
    private String output;

    private void init(String address) throws IOException {
        this.link = new URL(address);
        this.inputStream = link.openStream();
        this.reader = new InputStreamReader(inputStream);
        this.bufferedReader = new BufferedReader(reader);
    }

    private void acquire() throws IOException {
        String inputLine;
        output="";

        while ((inputLine = bufferedReader.readLine()) != null)
            output+=inputLine;

        bufferedReader.close();
    }

    @Override
    public String acquireRemoteData(String address) throws IOException {
        this.init(address);
        this.acquire();
        return output;
    }
}
