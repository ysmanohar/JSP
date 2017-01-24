/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Controller;

/**
 *
 * @author mannu
 */
import com.data.UserDB;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Random;
import java.util.Base64;

public class PasswordUtil {
    public static String hashPassword(String password)throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.reset();
        md.update(password.getBytes());
        byte[] mdArray = md.digest();
        StringBuilder sb = new StringBuilder(mdArray.length * 2);
        for (byte b : mdArray) {
            int v = b & 0xff;
            if (v < 16) {
                sb.append('0');
            }  
            sb.append(Integer.toHexString(v));
        }
        return sb.toString();
    }
    
public static String getSalt() {
    Random r = new SecureRandom();
     byte[] saltBytes = new byte[32];
     r.nextBytes(saltBytes);
     return Base64.getEncoder().encodeToString(saltBytes);
}

public static ArrayList<String> hashAndSaltPassword(String password,String Email) throws NoSuchAlgorithmException {
    ArrayList<String> passwordlist = new ArrayList<String>();
    String Databasesalt = UserDB.getSalt(Email);
    if(Databasesalt==null || Databasesalt.length()==0){
       String salt = getSalt();
       passwordlist.add(salt);
       passwordlist.add(hashPassword(password + salt));
    }else{
       passwordlist.add(Databasesalt);
       passwordlist.add(hashPassword(password + Databasesalt));
    }
    return passwordlist;
}
}
