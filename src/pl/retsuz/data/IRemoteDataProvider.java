package pl.retsuz.data;

import java.io.IOException;
import java.net.MalformedURLException;

public interface IRemoteDataProvider {
    public String acquireRemoteData(String address) throws IOException;
}