package br.com.tidicas.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

import br.com.tidicas.model.Blog;

/**
 * Classe para manipular os funcionalidades de banco de dados 
 * da tabela blog
 * 
 * @author Evaldo Junior
 */
public class BlogDao{
   
   @PersistenceContext
   private EntityManager em;               
   
   public Blog busca(Integer id){             
	   	  Blog blog = this.em.find(Blog.class, id);	   	  
	      return blog;                         
   }                                                                   
	                                                                       
   public List<Blog> lista(){                                             
      return em.createQuery("from " + Blog.class.getName()).getResultList();
   }                                                                   

   @Transactional
   public void adiciona(Blog t){                                          
      this.em.persist(t);                                              
   }                                                                   
	             
   @Transactional
   public void remove(Blog t){
	   t = this.em.merge(t); 
	   this.em.remove(t);                                               
   }
   
   @Transactional
   public void atualiza(Blog t){                                          
	  this.em.merge(t);   
	  this.em.flush();	
   }
   
   @Transactional
   public void removeQuery(Blog t,Integer chave){                                            
      this.em.createQuery("delete from " + Blog.class.getName() + " where codigo = " + chave).executeUpdate();    
   }
	
}   