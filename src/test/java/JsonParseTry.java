import com.actimize.automation.xsight.rest.HTTPResult;
import com.actimize.automation.xsight.rest.RestAPI;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.JSONObject;

import javax.net.ssl.HttpsURLConnection;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;


public class JsonParseTry {

    public String body(String urlString, String params)  throws IOException {
        URL url = new  URL(urlString);
        HttpsURLConnection con = (HttpsURLConnection)url.openConnection();
        con.setRequestMethod("GET");

        con.setRequestProperty("Content-Type","application/json");
        con.setDoOutput(true);

        OutputStream os = con.getOutputStream();
        os.write(params.getBytes());
        os.flush();
        os.close();
        StringBuffer body = new StringBuffer();
        if(con.getResponseCode() == 200) {
            BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));

            String line;

            while((line = br.readLine()) != null) {
                body.append(line);
            }
        }
        else System.out.println(con.getResponseCode());
        System.out.println(con.getResponseMessage());
        return body.toString();
    }

    public boolean setClientID(String clientID)  throws IOException {
        final String POST_PARAMS = "{" + "\"ClientID\":" + "\"" + clientID  +"\"}";
        System.out.println("setClientID API POST_PARAMS : " + POST_PARAMS);
        URL obj = new URL("API URL");
        HttpURLConnection postConnection = (HttpURLConnection) obj.openConnection();
        postConnection.setRequestMethod("POST");
        postConnection.setRequestProperty("Content-Type", "application/json");

        postConnection.setDoOutput(true);
        OutputStream os = postConnection.getOutputStream();
        os.write(POST_PARAMS.getBytes());
        os.flush();
        os.close();

        int responseCode = postConnection.getResponseCode();
        System.out.println("POST Response Code :  " + responseCode);
        System.out.println("POST Response Message : " + postConnection.getResponseMessage());

        if (responseCode == 200) { //success
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    postConnection.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in .readLine()) != null) {
                response.append(inputLine);
            } in .close();
            // print result
            System.out.println(response.toString());
            return true;
        } else {
            System.out.println("POST NOT WORKED");
            return false;
        }

    }

    public void JSONP() throws Exception {
        RestAPI restAPI = new RestAPI();
        HTTPResult httpResultregisterApi = restAPI.get("API URL");
//        HTTPResult httpResultregisterApi = restAPI.post("API URL", "request body");
        String responseBody = httpResultregisterApi.getResponseBody();

        String jsonS = "{\"fields\":[{\"metadata\":{\"Name\":\"Manoj\"},\"name\":\"actimizeVersionIdentity\",\"nullable\":true,\"type\":\"string\"},{\"metadata\":{\"Name\":\"Lodhi\"},\"name\":\"trx_day\",\"nullable\":true,\"type\":\"date\"}],\"type\":\"struct\"}";

        JSONParser jsonParser = new JSONParser();

        Object obj = jsonParser.parse(jsonS);
        JSONObject jObj = (JSONObject)obj;// OR JSONObject jObj = (JSONObject)jsonParser.parse(jsonS)

        System.out.println(jObj.get("fields"));

        JSONArray jAray = (JSONArray)jObj.get("fields");

        for(int i = 0; i<jAray.size(); i++) {
            JSONObject obj2 = ((JSONObject)jAray.get(i));
            System.out.println(((JSONObject)obj2.get("metadata")).get("Name"));
        }
    }


    public static void main(String[] arg) throws Exception {
        String post_params = "{\n" +
                "        \"serviceName\":\"AW_IFM\",\n" +
                "        \"tenantId\":\"11ea2d67-7385-c750-9a4d-0242ac110002\"\n" +
                "}";
        String url = "https://ifm.test.aw.actimize-afcm.cloud/ifmServices/tenantRegistration/register";

        JsonParseTry obj = new JsonParseTry();
        obj.body(url, post_params);
    }

}
