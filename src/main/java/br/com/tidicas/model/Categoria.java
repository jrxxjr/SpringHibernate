package br.com.tidicas.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Classe para implementar a tabela categoria no banco de dados 
 * 
 * @author Evaldo Junior
 */
@Entity
@Table(name="categoria")
public class Categoria implements Serializable {
	
	private static final long serialVersionUID = -7995000263888416812L;
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	private Integer codigo;
	private String descricao;
	    
	@ManyToOne(cascade=CascadeType.ALL)
	private Blog blog;
	
	public Categoria() {
		super();
	}   
	public Integer getCodigo() {
		return this.codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}   
	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Blog getBlog() {
		return blog;
	}
	public void setBlog(Blog blog) {
		this.blog = blog;
	}
	   
}