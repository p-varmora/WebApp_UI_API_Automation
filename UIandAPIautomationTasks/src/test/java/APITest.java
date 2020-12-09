import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.IOException;
import java.util.HashMap;

public class APITest {

    private static String credapiURL = "https://credapi.credify.tech/api/brportorch/v2/login";
    CredapiRestClient credapiRestClient = new CredapiRestClient();
    CloseableHttpResponse closebaleHttpResponse;
    private static String payLoad = "{\"username\" : \"coding.challenge.login@upgrade.com\",\"password\" : \"On$3XcgsW#9q\",\"recaptchaToken\": \"coding_challenge\"}";

    @Test
    public void validate_withCorrectCredentials_apiResponse200() throws IOException {

        HashMap<String, String> headers = new HashMap<>();
        headers.put("x-cf-source-id", "coding-challenge");
        headers.put("x-cf-corr-id", "322847e0-3998-11eb-adc1-0242ac120002");
        headers.put("Content-Type", "application/json");
        closebaleHttpResponse = credapiRestClient.postRequest(credapiURL, payLoad, headers);
        int responseStatusCode = closebaleHttpResponse.getStatusLine().getStatusCode();
        Assert.assertEquals(responseStatusCode, 200);
    }

    @Test
    public void validate_withCorrectCredentials_productTypeAttribute() throws IOException, ParseException {

        HashMap<String, String> headers = new HashMap<>();
        headers.put("x-cf-source-id", "coding-challenge");
        headers.put("x-cf-corr-id", "322847e0-3998-11eb-adc1-0242ac120002");
        headers.put("Content-Type", "application/json");
        closebaleHttpResponse = credapiRestClient.postRequest(credapiURL, payLoad, headers);
        //storing resonse into string
        String responseString = EntityUtils.toString(closebaleHttpResponse.getEntity(), "UTF-8");
        //creating jsonobject out of it
        JSONObject jsonObject = new JSONObject(responseString);
        //looking specific jsonArray for productType
        JSONArray jsonArray = jsonObject.getJSONArray("loansInReview");
        //creating jsonobject from jsonArray
        JSONObject jsonArrayObject = jsonArray.getJSONObject(0);
        String productTypeAttribute = "PERSONAL_LOAN";
        //validating productType attribute has value personal_loan
        Assert.assertEquals(productTypeAttribute, jsonArrayObject.getString("productType"));
    }

    @Test
    public void validate_withUserNameDoesntExistInDB_apiResponse401() throws IOException {

        HashMap<String, String> headers = new HashMap<>();
        headers.put("x-cf-source-id", "coding-challenge");
        headers.put("x-cf-corr-id", "322847e0-3998-11eb-adc1-0242ac120002");
        headers.put("Content-Type", "application/json");

        String invalidUserName_payLoad = "{\"username\" : \"coding.challenge.parth@upgrade.com\",\"password\" : \"On$3XcgsW#9q\",\"recaptchaToken\": \"coding_challenge\"}";

        closebaleHttpResponse = credapiRestClient.postRequest(credapiURL, invalidUserName_payLoad, headers);
        int responseStatusCode = closebaleHttpResponse.getStatusLine().getStatusCode();
        Assert.assertEquals(responseStatusCode, 401);
    }


}
