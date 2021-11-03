package com.ejemplos.colecciones;

import java.util.*;

public class Program {
	

	static public String pedirString() {
		String aux;
		@SuppressWarnings("resource")
		Scanner entrada = new Scanner(System.in);
		while(true) {
			aux = entrada.nextLine();
			if(aux.matches("[a-zA-ZñÑ]+")) {
				return aux;
			}
			System.out.println("Ingrese solo letras");
		}
	}
	static public int pedirInt() {
		String aux;
		@SuppressWarnings("resource")
		Scanner entrada = new Scanner(System.in);
		while(true) {
			aux = entrada.nextLine();
			try {
				return Integer.parseInt(aux);
			}
			catch(Exception e){
				System.out.println("Ingrese solo numeros");
			}
			
		}
	}
	static int pedirCantidad(int min) {
		int aux;
		while(true) {
			aux = pedirInt();
			if(aux >= min) {
				return aux;
			}
			System.out.println("El valor debe ser igual o mayor a "+ min);
		}
	}
	
	static public void cargarPaises(HashSet<String> paises) {
	System.out.println("Ingrese cuantos paises va a cargar");
	int i = 0;
	int cant = pedirCantidad(8);
	while (i < cant) {
		System.out.println("Ingrese el pais numero "+ (i+1));
		if(paises.add(pedirString())){
			i++;
		}else {
			System.out.println("No se pueden repetir paises");
		}
		}
	}
	static public String pedirDni() {
		String aux;
		while(true) {
			aux = Integer.toString(pedirInt());
			if(aux.length() == 8) {
				return aux;
			}
			System.out.println("El DNI debe ser de 8 digitos");
		}
	}
	static Sexo pedirSexo() {
		String aux;
		while(true) {
			aux = pedirString().toUpperCase();
			for (Sexo sexo : Sexo.values()) {
				if(sexo.name().equals(aux)) { 
					return sexo;
				}
			}System.out.println("Ingrese un sexo valido");
		}
	}
	static public CanalDeYoutube pedirCanal() {
		System.out.println("Ingrese el nombre del canal");
		String nombre = pedirString();
		System.out.println("Ingrese la url del canal");
		String url = pedirString();
		return new CanalDeYoutube(nombre, url);
	}
	
	static public Persona pedirPersona() {
		System.out.println("Ingrese la edad");
		int edad = pedirInt();
		System.out.println("Ingrese el DNI");
		String dni = pedirDni();
		System.out.println("Ingrese el sexo");
		Sexo sexo = pedirSexo();
		System.out.println("Ingrese el pais");
		String pais = pedirString();
		CanalDeYoutube canal = pedirCanal();
		return new Persona(edad, dni, sexo, pais, canal);
		
	}
	
	static public void cargarPersonas(ArrayList<Persona> youtubers) {
		System.out.println("Ingrese cuantas personas va a cargar");
		int cant = pedirCantidad(15);
		for (int i = 0; i < cant; i++) {
			System.out.println("Ingrese la persona numero " + (i+1));
			youtubers.add(pedirPersona());
			}
	}
	static void cargarMap(ArrayList<Persona> personas, HashMap<String, Persona> map) {
		for(Persona persona : personas) {
			map.put(persona.getDni(), persona);
		}
	}
	static void mostrarYoutubers(ArrayList<Persona> youtubers) {
		System.out.println("\nINICIO DE LA LISTA\n");
		for (Persona persona : youtubers) {
			System.out.println(persona);
		}
		System.out.println("\nFIN DE LA LISTA\n");
	}
	static void mostrarPersonas(HashMap<String, Persona> personas) {
		Iterator<Map.Entry<String,Persona>> it = personas.entrySet().iterator();
		System.out.println("\nINICIO DEL MAPA\n");
        for (int i = 0; i < 3; i++) {
        	System.out.println(it.next());
		}
        System.out.println("\nFIN DEL MAPA\n");
	}

	public static void main(String[] args) {
		HashSet<String> paises = new HashSet<String>();
		cargarPaises(paises);
		
        ArrayList<Persona> youtubers = new ArrayList<Persona>();
        cargarPersonas(youtubers);
        
        HashMap<String, Persona> personas = new HashMap<String, Persona>();
        cargarMap(youtubers, personas);
		
        mostrarYoutubers(youtubers);
        
        mostrarPersonas(personas);
        
        for (int i = 0; i < 3; i++) {
			youtubers.add(pedirPersona());
		}
        
        ArrayList<Persona> porEdad = youtubers;
        porEdad.sort(null);
		System.out.println("\nINICIO DE LA LISTA POR EDAD\n");
        for (Persona persona : porEdad) {
			System.out.println(persona);
		}
        System.out.println("\nFIN DE LA LISTA POR EDAD\n");
	}

}
