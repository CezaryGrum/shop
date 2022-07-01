package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
    Properties pro;

    public ReadConfig(){
        File src = new File("./src/main/resources/properties/data.properties");
        try{
            FileInputStream fis = new FileInputStream(src);
            pro = new Properties();
            pro.load(fis);
        }catch (Exception e){
            System.out.println("Exception is " + e.getMessage());
        }
    }
    public String getApplicationURL()
    {
        String url=pro.getProperty("BASE_URL");
        return url;
    }

    public String getUserLogin()
    {
        String login=pro.getProperty("USER_LOGIN");
        return login;
    }

    public String getPassword()
    {
        String password=pro.getProperty("USER_PASSWORD");
        return password;
    }

    public String getWrongUserLogin()
    {
        String wLogin=pro.getProperty("BAD_USER_LOGIN");
        return wLogin;
    }

    public String getWrongPassword()
    {
        String wPassword=pro.getProperty("BAD_USER_PASSWORD");
        return wPassword;
    }

    public String getChromePath()
    {
        String chromepath=pro.getProperty("CHROMEPATH");
        return chromepath;
    }

    public String getFirefoxPath()
    {
        String firefoxpath=pro.getProperty("FIREFOXPATH");
        return firefoxpath;
    }


}
