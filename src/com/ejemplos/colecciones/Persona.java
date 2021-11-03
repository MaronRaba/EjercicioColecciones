package com.ejemplos.colecciones;

public class Persona implements Comparable<Persona> {
	private int edad;
	private String dni;
	private Sexo sexo;
	private String pais;
	private CanalDeYoutube canal;
	public Persona(int edad, String dni, Sexo sexo, String pais, CanalDeYoutube canal) {
		super();
		this.edad = edad;
		this.dni = dni;
		this.sexo = sexo;
		this.pais = pais;
		this.canal = canal;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public Sexo getSexo() {
		return sexo;
	}
	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	public CanalDeYoutube getCanal() {
		return canal;
	}
	public void setCanal(CanalDeYoutube canal) {
		this.canal = canal;
	}
	public String toString() {
		return "Edad = " + this.edad + " DNI = " + this.dni + " Sexo = " + this.sexo.name() + " Pais = " + this.pais + " Nombre canal = " + this.canal.getNombre();
	}
	@Override
	public int compareTo(Persona o) {
		return this.edad - o.edad;
	}

}
