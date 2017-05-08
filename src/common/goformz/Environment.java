package common.goformz;

import java.net.MalformedURLException;
import java.net.URL;

public class Environment {
	private String email;
	private String password;
	private String user;
	private URL goformzURL;
	
	public void setTestEnvironmentURL(){
		try{
			goformzURL=new URL("https://www.goformz.com/");
		}catch(MalformedURLException e){
			System.out.println("Invalid URL"+goformzURL + '\n'+e);
		}
	}
	public URL getTestURL(){
		return goformzURL;
	}
	public void setTestCredentials(){
		email="";//Set email
		password="";//Set Password
		user="";//Set User Name
	}
	public String getUserName(){
		return email;
	}
	public String getTestPassword(){
		return password;
	}
	public String getUser(){
		return user;
	}
}
