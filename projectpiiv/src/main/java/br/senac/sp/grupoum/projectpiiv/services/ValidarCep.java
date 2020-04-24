/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sp.grupoum.projectpiiv.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.stream.Collectors;
import org.json.JSONObject;

/**
 *
 * @author Pablo de Oliveira
 */
public class ValidarCep {

    public static boolean encontrarCep(String cep) throws MalformedURLException, IOException {

        try {

            URL url = new URL("https://viacep.com.br/ws/" + cep + "/json/");//your url i.e fetch data from .
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");
            
            if (conn.getResponseCode() != 200) {
                conn.disconnect();
                return false;
            } else {
                conn.disconnect();
                return true;

                /*
               POR FAVOR NÃO APAGAR ESTE COMENTÁRIO, PODE SER ÚTIL
               
                InputStreamReader in = new InputStreamReader(conn.getInputStream());
                BufferedReader br = new BufferedReader(in);
                String output;

                output = br.lines().collect(Collectors.joining());

                JSONObject jsonResponse = new JSONObject(output);

                conn.disconnect();
                 */
            }
        } catch (Exception ex) {
            System.out.println(ex);
            return false;
        }
    }
}
