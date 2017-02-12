package readJSON;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import org.json.JSONObject;

public class ReadJSON {
	public static JSONObject fromUrl(String url){
		JSONObject object = null;
		URL request = null;
		HttpsURLConnection conn = null;
		try {
			request = new URL(url);
			conn = (HttpsURLConnection) request.openConnection();
			BufferedReader reader = new BufferedReader(new InputStreamReader(request.openStream(), "UTF-8"));
			StringBuilder response = new StringBuilder();
			String input;
			while((input = reader.readLine()) != null){ response.append(input); }
			return new JSONObject(response);
		}
		catch (Exception e) { e.printStackTrace(); }
		if(conn != null) conn.disconnect();
		return object;
	}
	
	public static void main(String[] args){
		System.out.println(ReadJSON.fromUrl("https://viacep.com.br/ws/20950071/json/"));
	}
}
