/*
 * This class represents the Client that communicates with the RESTful API.
 * 
 * Implement the get() method according to the specification. You may add other methods
 * and instance variables as needed, though it should be possible to implement get()
 * without adding anything else.
 */

import java.util.Set;
import java.util.*;
import java.net.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import org.json.simple.parser.JSONParser;

public class Client {
	
	private String host;
	private int port;
	
	public Client() {
		// use Node Express defaults
		host = "localhost";
		port = 3000;
	}
	
	public Client(String host, int port) {
		this.host = host;
		this.port = port;
	}

	public static void main(String[] args) {
		Client test = new Client();
		String[] input = {"1234", "5678"};
		test.get(input);
	}

	public Set<Person> get(String[] ids) {

		try {
			// Generate URL 
			StringBuilder urlString = new StringBuilder();
			urlString.append("http://" + host + ":" + port + "/get?");

			// Add IDs to get query
			for (String id : ids) {
				urlString.append("id=" + id + "&");
			}
			urlString.deleteCharAt(urlString.length()-1);

		    // create an object to represent the connection to a
		    // web server on port on this computer
		    URL url = new URL(urlString.toString());
		    HttpURLConnection conn = (HttpURLConnection)url.openConnection(); 
		    conn.setRequestMethod("GET"); 
	
		    // open connection
		    conn.connect();
	
		    // now the response comes back
		    int responsecode = conn.getResponseCode();
		    
		    // make sure the response has "200 OK" as the status
		    if (responsecode != 200) {
		    	System.out.println("Unexpected status code: " + responsecode);
		    }
		    else {
				// made it here, we got a good response, let's read it
				Scanner in = new Scanner(url.openStream());
				
				while (in.hasNext()) {
					
				    // read the next line of the body of the response
				    String line = in.nextLine();
				    
				    // the rest of this code assumes that the body contains JSON
				    // first, create the parser
				    JSONParser parser = new JSONParser();
				    
				    // then, parse the data and create a JSON Array for it
				    JSONArray data = (JSONArray) parser.parse(line);

				    System.out.println(data.toString());
				}
		    }
			Set<Person> test = new HashSet<>();
			return test;
		}
		catch (Exception e) {
		    e.printStackTrace();
			Set<Person> test = new HashSet<>();
			return test;
		}
	}

}
