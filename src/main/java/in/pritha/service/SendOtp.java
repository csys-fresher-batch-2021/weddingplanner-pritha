package in.pritha.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLEncoder;

import javax.net.ssl.HttpsURLConnection;

import in.pritha.util.Logger;
import in.pritha.util.OTPUtil;

public class SendOtp {
	
	private SendOtp() {
		
	}
	/**
	 * This method has the sms gateway credentials to send the otp to real time number
	 * @param message
	 * @param number
	 * @param apiKey
	 */
	public static void sendOtp(String message, String number, String apiKey) {
		//input paramters passed in url
		try {
		String sendId="TXTIND";
		String language="english";
		String route="v3";
		//whatever the msg we send, we should first encode it
		message=URLEncoder.encode(message,"UTF-8");
		
		String myUrl="https://www.fast2sms.com/dev/bulkV2?authorization="+apiKey+"&route="+route+"&sender_id="+sendId+"&message="+message+
		"&language="+language+"&flash="+0+"&numbers="+number;
		URL url = new URL(myUrl);
		HttpsURLConnection con =(HttpsURLConnection) url.openConnection();
		con.setRequestMethod("GET");
		con.setRequestProperty("User-Agent", "Mozilla/5.0");
		con.setRequestProperty("cache-control", "no-cache");
		Logger.println("wait.....");
		int responseCode = con.getResponseCode();
		Logger.println("Response Code"+responseCode);
		
		StringBuffer response = new StringBuffer();
		BufferedReader br=new BufferedReader(new InputStreamReader(con.getInputStream()));
		
		while(true) {
			String line=br.readLine();
			if(line==null) {
				break;
			}
			response.append(line);
		}
		
		System.out.println(response);
		
	}catch(Exception e){
		System.out.println(e);
	}
	}
	
	/**
	 * This method calls the generation of otp and send to mobile function
	 * @return otp
	 */
	public static String sendOtpToMobile() {
		Logger.println("Program Started");
		String otpMessage = OTPUtil.generateOTP();
		Logger.println(otpMessage);
		String apiKey ="P9YGSEQHiJtr2V50puD3OqwbhZydR6sLATFfU1WlcIxan4kKjN5akoSxAJ2g8LGRI9q6MHyC4NnEKpOX";
		String number="9952652890";
		//call sendotp with proper parameters
		sendOtp("Hey this message was send by pritha for testing purpose.Your otp is "+otpMessage, number, apiKey);
		return otpMessage;
	}

}
