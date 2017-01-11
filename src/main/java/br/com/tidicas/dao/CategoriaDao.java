package br.com.tidicas.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

import br.com.tidicas.model.Categoria;

/**
 * Classe para manipular os funcionalidades de banco de dados 
 * da tabela categoria
 * 
 * @author Evaldo Junior
 * @param <T>
 */

public class CategoriaDao{      
   
   @PersistenceContext
   private EntityManager em;               
                                                 
  public Categoria busca(Integer id){
	  Categoria categoria = this.em.find(Categoria.class, id);	  
      return categoria;                         
   }                                                                   
                                                                       
   public List<Categoria> lista(){                                             
      return em.createQuery("from " + Categoria.class.getName()).getResultList();
   }                                                                   

   @Transactional
   public void adiciona(Categoria t){	   
      this.em.persist(t);
   }                                                                   
                 
   @Transactional
   public void remove(Categoria t){
	   t = this.em.merge(t);
	   this.em.remove(t);                                               
   }
   
   @Transactional
   public void atualiza(Categoria t){                                          
	      this.em.merge(t);                                              
   }
   
   @Transactional
   public void removeQuery(Categoria t,Integer chave){                                            
	      this.em.createQuery("delete from " + Categoria.class.getName() + " where codigo = " + chave).executeUpdate();    
	      
   }

}