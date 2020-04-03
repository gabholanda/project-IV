import br.senac.sp.grupoum.projectpiiv.models.Usuario;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author erick
 */
@WebFilter(filterName = "PermissaoFilters",
        urlPatterns = { 
                        "/admin/*",
                        "/estoquista/*" })
public class PermissaoFilters implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        
        HttpSession sessao = httpRequest.getSession();
        
        if (sessao.getAttribute("usuario") == null) {
            httpResponse.sendRedirect(httpRequest.getContextPath() + "/login");
            return;
        }

        Usuario usuario = (Usuario) sessao.getAttribute("usuario");
        
        if (verificarAutorizacao(usuario, httpRequest)) {
            chain.doFilter(request, response);
        } else {
            httpResponse.sendRedirect(httpRequest.getContextPath() + "/erro-nao-autorizado.jsp");
        }
    }
    
    private boolean verificarAutorizacao(Usuario usuario, 
            HttpServletRequest httpRequest) {
        String urlAcessada = httpRequest.getRequestURI();
        
        if (urlAcessada.contains("/admin") && usuario.verificarFuncao("Admin")) {
            return true;
        } else if (urlAcessada.contains("/estoquista") && usuario.verificarFuncao("Estoquista")) {
            return true;
        }
        
        return false;
    }

    @Override
    public void destroy() {        
    }
    
    @Override
    public void init(FilterConfig filterConfig) {          
    }
}
