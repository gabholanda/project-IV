
package br.senac.sp.grupoum.projectpiiv.services;

import java.math.BigInteger;
import java.security.MessageDigest;

/**
 *
 * @author Pablo de Oliveira
 */
public class Encriptografar {
    
   public static String criptografar(String senha){
       String senhaCriptografada="";
       
       MessageDigest messageD;
       
       try{
           
           messageD = MessageDigest.getInstance("MD5");
           BigInteger hash = new BigInteger(1,messageD.digest(senha.getBytes()));
           senhaCriptografada = hash.toString(16);
           
       }catch(Exception ex){
           
       }
       return senhaCriptografada;
   }
}
