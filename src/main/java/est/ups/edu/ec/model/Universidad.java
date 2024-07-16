package est.ups.edu.ec.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Universidad {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int codUni;
	private String nombre;
	private String pais;
	private String ciudad;
	public int getCodUni() {
		return codUni;
	}
	public void setCodUni(int codUni) {
		this.codUni = codUni;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	@Override
	public String toString() {
		return "Universidad [codUni=" + codUni + ", nombre=" + nombre + ", pais=" + pais + ", ciudad=" + ciudad + "]";
	}
	
	

}
