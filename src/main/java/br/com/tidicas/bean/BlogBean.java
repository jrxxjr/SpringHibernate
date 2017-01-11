package br.com.tidicas.bean;

import java.util.Collections;
import java.util.Comparator;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import br.com.tidicas.dao.BlogDao;
import br.com.tidicas.model.Blog;

/**
 * Classe responsável pela iteração com a camada visual
 *  
 * @author Evaldo Junior 
 *
 */
public class BlogBean {
	
	private boolean sortAscending = true;
	
	public String sortByOrderCodigo() {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		BlogDao daoBlog = (BlogDao) context.getBean("blogDao");
		 
		if(sortAscending){
 
			Collections.sort(daoBlog.lista(), new Comparator<Blog>() {
 			
				@Override
				public int compare(Blog o1, Blog o2) {
					return o1.getCodigo().compareTo(o2.getCodigo());
					
				}
 
			});
		sortAscending = false;
 
	   }else{
 
		   Collections.sort(daoBlog.lista(), new Comparator<Blog>() {
 
				@Override
				public int compare(Blog o1, Blog o2) {
					return o2.getCodigo().compareTo(o1.getCodigo());
				}
 
		   });
		sortAscending = true;
	   }
 
	   return null;
	}

}