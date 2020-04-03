/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sp.grupoum.projectpiiv.interfaces;

import br.senac.sp.grupoum.projectpiiv.models.Usuario;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


public interface Autenticador {
     public void login(Usuario usuario, HttpServletRequest request, HttpSession session);
}
