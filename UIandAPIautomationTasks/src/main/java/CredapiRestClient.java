import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CredapiRestClient  {

    public CloseableHttpResponse postRequest(String url, String payLoad, HashMap<String, String> headerMap) throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        //http post request
        HttpPost httppost = new HttpPost(url);
        //for payload
        httppost.setEntity(new StringEntity(payLoad));
        //for headers:
        for(Map.Entry<String,String> entry : headerMap.entrySet()){
            httppost.addHeader(entry.getKey(), entry.getValue());
        }
        CloseableHttpResponse closebaleHttpResponse = httpClient.execute(httppost);
        return closebaleHttpResponse;


    }

}
