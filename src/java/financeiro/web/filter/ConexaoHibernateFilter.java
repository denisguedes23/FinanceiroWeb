/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package financeiro.web.filter;

import financeiro.util.HibernateUtil;
import java.io.IOException;
import javax.servlet.*;
import org.hibernate.SessionFactory;


/**
 *
 * @author rhuansouza
 */
public class ConexaoHibernateFilter implements Filter{
   
    private  SessionFactory sf;
    
    
    //A cada requisição é criado a sessao do hibernate
    @Override
    public void init(FilterConfig config) throws ServletException {
        this.sf = HibernateUtil.getSessionFactory();
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws ServletException {
       try{
        this.sf.getCurrentSession().beginTransaction();
        chain.doFilter(servletRequest,servletResponse);
        this.sf.getCurrentSession().getTransaction().commit();
        this.sf.getCurrentSession().close();
       }catch(Throwable ex){
           try{
               if(this.sf.getCurrentSession().getTransaction().isActive()){
                   this.sf.getCurrentSession().getTransaction().rollback();
                   
               }
           }catch(Throwable t){
               t.printStackTrace();
           }
           throw new ServletException(ex);
       }
    }

    @Override
    public void destroy() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

 

    


    
}
