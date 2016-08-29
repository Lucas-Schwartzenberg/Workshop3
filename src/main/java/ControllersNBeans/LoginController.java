/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControllersNBeans;

import Entity.Login;
import SessionBean.LoginFacade;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;

/**
 *
 * @author lucas
 */
@Named(value = "loginController")
@Dependent
public class LoginController {
    
    Login thisLogin;
    String surfacePassword;

    
    @Inject
    LoginFacade loginFacade;
    
    
    
    public LoginController(){
        thisLogin = new Login();
    }
    
    public String newLoginID(){
        try{
            byte[] thisSalt = getSalt();
                    for (byte e : thisSalt){
                    System.out.println(e);}
            thisLogin.setSalt(thisSalt);
            thisLogin.setPassword( getSecurePassword(surfacePassword, thisSalt) );
        }
        catch(NoSuchAlgorithmException exA){
            exA.printStackTrace();
            return "NoSuchAlgorithmException";
        }
        catch(NoSuchProviderException exP){
            exP.printStackTrace();
            return "NoSuchProviderException";
        }
        loginFacade.create(thisLogin);
        return "Succes";
    }
    
    public String checkPassword(){
        surfacePassword = getSurfacePassword();
        List<Login> foundLogins = loginFacade.findByInlognaam( thisLogin.getLoginnaam() );
        boolean valid = false;
        for(Login l : foundLogins){
                if (
                    getSecurePassword(surfacePassword, l.getSalt() )
                    .equals(l.getPassword())
                        ) {
                valid = true;
                thisLogin = l;
                }
                break;
            }
        
        if (valid) {
            return "loginSucces";
        }
        else {
            return "viewLogin";
        }
    }
    
    public Login getThisLogin() {
        return thisLogin;
    }

    public void setThisLogin(Login thisLogin) {
        this.thisLogin = thisLogin;
    }
    
    public String getSurfacePassword() {
        return surfacePassword;
    }

    public void setSurfacePassword(String surfacePassword) {
        this.surfacePassword = surfacePassword;
    }

    
    
    private static String getSecurePassword(String passwordToHash, byte[] salt)
    {
        String generatedPassword = null;
        System.out.print("------------> " + passwordToHash + salt);
        try {
            // Create MessageDigest instance for MD5
            MessageDigest md = MessageDigest.getInstance("MD5");
            //Add password bytes to digest
            md.update(salt);
            //Get the hash's bytes 
            byte[] bytes = md.digest(passwordToHash.getBytes());
            //This bytes[] has bytes in decimal format;
            //Convert it to hexadecimal format
            StringBuilder sb = new StringBuilder();
            for(int i=0; i< bytes.length ;i++)
            {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            //Get complete hashed password in hex format
            generatedPassword = sb.toString();
        } 
        catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return generatedPassword;
    }
     
    //Add salt
    private static byte[] getSalt() throws NoSuchAlgorithmException, NoSuchProviderException
    {
        //Always use a SecureRandom generator
        SecureRandom sr = SecureRandom.getInstance("SHA1PRNG", "SUN");
        //Create array for salt
        byte[] salt = new byte[16];
        //Get a random salt
        sr.nextBytes(salt);
        //return salt
        return salt;
    }
}
