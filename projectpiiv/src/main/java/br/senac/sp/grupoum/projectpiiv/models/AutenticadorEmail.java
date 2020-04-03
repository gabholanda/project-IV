/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sp.grupoum.projectpiiv.models;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AutenticadorEmail {
    // Email Regex java

    private static final String EMAIL_REGEX =  "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    
    private static Pattern pattern;

   
    private Matcher matcher;

    public AutenticadorEmail() {
        
        pattern = Pattern.compile(EMAIL_REGEX, Pattern.CASE_INSENSITIVE);
    }

    public boolean validadorEmail(String email) {
        matcher = pattern.matcher(email);
        return matcher.matches();
    }

}
