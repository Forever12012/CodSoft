package Assignments;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Scanner;
import org.json.JSONObject;

// Currency Converter in JAVA using API

public class FourthAssignment {

	public static void main(String[] args) throws IOException {
		
		// USing HashMap as it helps us to store the data in Key and Value mapping 
		HashMap<Integer, String> currencyCodes = new HashMap<Integer, String>();
		
		//Add currency codes
		
		currencyCodes.put(1, "USD");
		currencyCodes.put(2, "CAD");
		currencyCodes.put(3, "EUR");
		currencyCodes.put(4, "HKD");
		currencyCodes.put(5, "INR");
		
		String fromCode;
		String toCode;
		double amount;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Welcome to the Currency Converter");
		
		// Select the currency you want to convert from
		
		System.out.println("Currency converting from : ");
		
		System.out.println("1:USD (US Dollar) \t 2:CAD (Canadian Dollar) \t 3:EUR (Euros) \t 4:HKD (Hongkong Dollars) \t 5:INR (Indian Rupee)");
		
		fromCode = currencyCodes.get(sc.nextInt());
		
		// Select the currency you want to convert to
		
		System.out.println("Currency converting to : ");
		
		System.out.println("1:USD (US Dollar) \t 2:CAD (Canadian Dollar) \t 3:EUR (Euros) \t 4:HKD (Hongkong Dollars) \t 5:INR (Indian Rupee)");
		
		toCode = currencyCodes.get(sc.nextInt());
		
		System.out.println("Amount you want to convert : ");
		amount = sc.nextDouble();
		
		sendHttpGETRequest(fromCode, toCode, amount);
		
		System.out.println("Thank you for using currency converter");
		sc.close();
	}
	
	private static void sendHttpGETRequest(String fromCode, String toCode, double amount) throws IOException
	{
		//API URL
		String GEt_URL = "https://v6.exchangerate-api.com/v6/f6b7284742755d89b4fc0242/pair/" + fromCode + "/" + toCode + "/" + amount;
		// Setting the URL
		URL url = new URL(GEt_URL);
		// Opening the URL HTTP connection 
		HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
		// Setting the method to "GET"
		httpURLConnection.setRequestMethod("GET");
		// Fetching the response code
		int responseCode = httpURLConnection.getResponseCode();
		
		if(responseCode == HttpURLConnection.HTTP_OK) {
			// SUCCESS
			//To read the data we requested we use BufferReader
			BufferedReader in = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
			//We use StringBuffer so that it can be modified/parsed.
			String inputLine;
			StringBuffer response = new StringBuffer();
			
			while((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}in.close();

			// Data is sent in JSON Format and stored in the obj reference
			
			JSONObject obj = new JSONObject(response.toString());
			
			Double exchangeRate = obj.getDouble("conversion_rate");
			//System.out.println(exchangeRate); // for debugging
			System.out.println();
			System.out.println(amount + " " +  fromCode + " = " + amount*exchangeRate + " " + toCode);
		}
		else
		{
			System.out.println("GET request failed");
		}
	}

}
