package resources;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Utils {

	public static RequestSpecification req;

	public RequestSpecification requestspecifica() throws IOException
	{
		if (req == null)
		{
			PrintStream log = new PrintStream(new FileOutputStream("log3.txt"));
		 req = new RequestSpecBuilder().setBaseUri(globalv("BaseUri"))
				 .addFilter(RequestLoggingFilter.logRequestTo(log)).
				 addFilter(ResponseLoggingFilter.logResponseTo(log)).build();
		 return req;
		}
		
		return req;
	
	}
	
	
	public static String globalv(String key) throws IOException
	{
		Properties h = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+ "\\src\\test\\java\\resources\\global.properties");
		h.load(fis);
		return h.getProperty(key);
		 
	}
	
	public int getJsonPath(Response response12, String key)
	{
		String j = response12.asString();
    	JsonPath qwe = new JsonPath(j);
    	return qwe.get(key);
	}
	
	
}
