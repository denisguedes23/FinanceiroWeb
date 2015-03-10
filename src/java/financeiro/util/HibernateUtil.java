/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package financeiro.util;


import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;


/**
 *
 * @author rhuansouza
 */
public class HibernateUtil {
        
    private static final SessionFactory sessionFactory = buildSessionFactory();
    private static  SessionFactory buildSessionFactory() {      
       try{
           AnnotationConfiguration cfg = new AnnotationConfiguration();
           cfg.configure("hibernate.cfg.xml");//HIbernate.cfg.xml  deve ser sempre criado em package default do Java
           return cfg.buildSessionFactory();
       }catch(Throwable e){
           System.out.println("Criação inicial do objeto SessionFactory falhou. Erro: "+e);
           throw new ExceptionInInitializerError(e);
       }
       
        
        
//       
    }
    
    public static SessionFactory getSessionFactory(){
        return sessionFactory;
    }
    
}
