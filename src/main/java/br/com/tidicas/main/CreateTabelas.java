package br.com.tidicas.main;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import br.com.tidicas.dao.BlogDao;
import br.com.tidicas.dao.CategoriaDao;
import br.com.tidicas.model.Blog;
import br.com.tidicas.model.Categoria;

/**
 * Classe para geração das tabelas
 *  
 * @author Evaldo Junior
 *
 */
public class CreateTabelas {
	
	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		try{
			
		CategoriaDao daoCategoria = (CategoriaDao) context.getBean("categoriaDao");                 
		BlogDao daoBlog = (BlogDao) context.getBean("blogDao");

		/* 1 Entidade Categoria */
		Categoria c = new Categoria();
		c.setCodigo(null);
		c.setDescricao("categoria new");                              
		                     
		daoCategoria.adiciona(c);                                 
		   
		c = (Categoria) daoCategoria.busca(c.getCodigo());
	    System.out.println("retorno:" + c.getCodigo() );
		   
		c.setDescricao("categoria update"); 
		daoCategoria.atualiza(c);		   
		   
		/* 2 Entidade Blog */
		Blog b = new Blog();
		b.setCategoria(new ArrayList<>());
		c.setBlog(b);
		c.setCodigo(null);
		b.getCategoria().add(c);
		b.setConteudo("conteúdo teste");
		b.setDtevento(new Date());
		b.setPublicar(1);
		b.setTitulo("título");
		                     
		daoBlog.adiciona(b);                                 
		 		
		b = (Blog) daoBlog.busca(b.getCodigo());
		System.out.println("retorno:" + b.getTitulo());
		
		b.setConteudo("conteúdo teste update");
		b.setDtevento(new Date());
		b.setPublicar(0);
		b.setTitulo("título update");
				 
		daoBlog.atualiza(b);		   
				
		b = (Blog) daoBlog.busca(b.getCodigo());		   
		System.out.println("retorno:" + b.getTitulo());
		
		daoCategoria.remove(c);
		
		daoBlog.remove(b);		   
		 
		System.out.println("delete:" + b.getTitulo());
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			context.close();				
		}
	}
}