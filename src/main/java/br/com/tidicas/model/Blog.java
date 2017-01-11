package br.com.tidicas.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Classe correspondente a tabela blog do banco de dados 
 * @author Evaldo Junior
 *
 */

@Entity
@Table(name="blog")
public class Blog implements Serializable{
		
	private static final long serialVersionUID = 7551953961461778499L;
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	private Integer codigo;
	private String conteudo;
	
	private String titulo;
	@Temporal(TemporalType.DATE)    
	private Date dtevento;
	private Integer contador;
	private Integer publicar;
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
    @JoinColumn(name="CATEGORIA_ID")    
	private List<Categoria> categoria;
	
	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	public String getConteudo() {
		return conteudo;
	}
	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public Date getDtevento() {
		return dtevento;
	}
	public void setDtevento(Date dtevento) {
		this.dtevento = dtevento;
	}
	public Integer getContador() {
		return contador;
	}
	public void setContador(Integer contador) {
		this.contador = contador;
	}
	public Integer getPublicar() {
		return publicar;
	}
	public void setPublicar(Integer publicar) {
		this.publicar = publicar;
	}
	public List<Categoria> getCategoria() {
		return categoria;
	}
	public void setCategoria(List<Categoria> categoria) {
		this.categoria = categoria;
	}
		
}