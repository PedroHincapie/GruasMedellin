package co.com.tecnologiaempresarial.gruas.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "clientes")
public class Clientes implements Serializable{
	
	private static final long serialVersionUID = 1L;

	public Clientes() {
		super();	
	}
	
	public Clientes(int id_cliente, String nom_cliente, String telefono) {
		super();
		this.id_cliente = id_cliente;
		this.nom_cliente = nom_cliente;
		this.telefono = telefono;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_cliente")
	private int id_cliente;
	
	@Column(name = "nom_cliente")	
	private String nom_cliente;
	
	@Column(name = "telefono")	
	private String telefono;

	public int getId_cliente() {
		return id_cliente;
	}

	public void setId_cliente(int id_cliente) {
		this.id_cliente = id_cliente;
	}

	public String getNom_cliente() {
		return nom_cliente;
	}

	public void setNom_cliente(String nom_cliente) {
		this.nom_cliente = nom_cliente;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	@Override
	public String toString() {
		return "Clientes [id_cliente=" + id_cliente + ", nom_cliente=" + nom_cliente + ", telefono=" + telefono + "]";
	}
}
