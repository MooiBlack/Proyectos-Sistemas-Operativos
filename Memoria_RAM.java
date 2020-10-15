import java.io.*;
import java.lang.*;
import java.math.*;
import java.util.PriorityQueue;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

/**
 *Esta es la primera ṕráctica de sistemas operativos
 *@author	Mariana Martínez Soto.
 *@version	0.1
 *@since  	1.0
*/
/*Puede ser cola de prioridad, dado que depende el número  id que tenga*
*/
public class Memoria_RAM{
	public static final String ANSI_GREEN = "\u001B[32m"; /*Colores*/
	public static final String ANSI_RESET = "\u001B[0m";  /*Colores */ 
	public static final String ANSI_BLUE = "\u001B[34m";  /*Colores */
	public static final String ANSI_RED = "\u001B[31m";  /*Colores */

	int cont_memoria; /* Contador de memoria ó memoria ocupada*/
	int cant_memoria; /* Cantidad de memoria*/
	int cant_mem_temp;
	int cant_instr_proc; /*	Cantidad de instrucciones*/
	int id_temp;

	public Memoria_RAM(int mem){
		cant_memoria=mem;
	}
	public void Imprimir(){
		System.out.println(cant_memoria);
	}
	public int MemAleatoria(){
		int mem_aleatoria;
		Random r = new Random();
		mem_aleatoria = r.nextInt(7-4+1)+4;
		return mem_aleatoria;
	}
	public int InstrAleatoria(){
		int inst_aleatoria;
		Random r = new Random();
		cant_instr_proc = r.nextInt(30-10+1)+10;
		return cant_instr_proc;
	}
	public int GeneraID(){
		id_temp=id_temp+1;
		return id_temp;
	}
	/*---------------------------------------------------------*/
	public static void main(String args[]){

	ArrayList<proceso> cola = new ArrayList<proceso>();
	Memoria_RAM memoria = new Memoria_RAM(200);
	
		int option;
		String nombre_proc;
		int mem_temp;
		Scanner leer = new Scanner(System.in);



		do{
		System.out.println('\n');
		System.out.println("1. Crecar proceso");
		System.out.println("2. Ver estado actual");
		System.out.println("3.Imprimir cola de proceso");
		System.out.println("4. Ejecutar proceso actual");
		System.out.println("5. Ver proceso actual");
		System.out.println("6. Pasar al proceso siguiente");
		System.out.println("7. Matar el proceso actual");
		System.out.println("8. Matar todos los procesos y terminar");
		
		option=leer.nextInt();	//Entrada de opción

		switch(option) {
			case 1: System.out.println(ANSI_BLUE+"Ingresa nombre de proceso"+ANSI_RESET);
					Scanner nombre = new Scanner(System.in);
					nombre_proc=nombre.nextLine();
					memoria.cant_mem_temp=(int) Math.pow(2, memoria.MemAleatoria());
					if (memoria.cant_mem_temp+memoria.cont_memoria > memoria.cant_memoria){
						System.out.println(ANSI_RED+"La memoria está llena"+ANSI_RESET);
					}
					else{
						cola.add(new proceso(nombre_proc,memoria.GeneraID(),memoria.InstrAleatoria(),memoria.cant_mem_temp));
					for(int i=(memoria.cont_memoria);i<(memoria.cont_memoria)+(memoria.cant_mem_temp);i++){
						System.out.println("Localidad ocupada"+i);
					}
					memoria.cont_memoria=memoria.cont_memoria+memoria.cant_mem_temp;
					}
					break;

			case 2: System.out.println(ANSI_GREEN+"Procesos listos: "+cola.size()+ANSI_RESET);
					break;

			case 3: int lim = cola.size();
					proceso[] procesos = new proceso[lim];
					Object[] arreglo_ayuda = cola.toArray(procesos);
					System.out.println(ANSI_BLUE+"Proceso activo: "+ANSI_RESET+ANSI_GREEN+"ID: "+procesos[0].id+"...."+procesos[0].nombre+ANSI_RESET);				
					for(int i=1; i<lim; i++){
						System.out.println(ANSI_GREEN+"ID: "+procesos[i].id+"...."+procesos[i].nombre+ANSI_RESET);
					}
					break;

			case 4:	//proceso proceso_temporal = cola.peek();
					//proceso_temporal.instr=proceso_temporal.instr-5;
					int instr_temp;
					(cola.get(0)).instr=(cola.get(0)).instr-5;
					instr_temp = (cola.get(0)).instr;
					proceso proceso_temporal_2 = cola.remove(0);
					//proceso_temporal_2.id=proceso_temporal_2.id+cola.size();
					cola.add(proceso_temporal_2);
					//cola.add(cola.poll());
					System.out.println(ANSI_GREEN+"Procesos listos: "+cola.size()+ANSI_RESET);
					System.out.println(ANSI_GREEN+"Ahora proceso activo:"+(cola.get(0)).nombre+"  instrucciones: "+(cola.get(0)).instr+ANSI_RESET);
					break;

			case 5: System.out.println(ANSI_GREEN+"Proceso actual: "+'\n'+"Nombre: "+(cola.get(0)).nombre+'\n'+"ID: "+(cola.get(0)).id+'\n'+"N° instrucciones: "+(cola.get(0)).instr+'\n'+"Espacio memoria: "+(cola.get(0)).espacio_mem+ANSI_RESET);
					break;

			case 6:	proceso proceso_temporal_3 = cola.remove(0);
					cola.add(proceso_temporal_3);
					System.out.println(ANSI_GREEN+"Procesos listos: "+cola.size()+ANSI_RESET);
					System.out.println(ANSI_GREEN+"Ahora proceso activo:"+(cola.get(0)).nombre+"  instrucciones: "+(cola.get(0)).instr+ANSI_RESET);
					break;

			case 7:
					break;

			case 8: 
					break;

			default: System.out.println(ANSI_RED+"No se permite opción"+ANSI_RESET);
		}

		}while(option != 8);

		if (cola.get(0)!=null){
			System.out.println(ANSI_BLUE+"Hay por lo menos un proceso en espera"+ANSI_RESET);
		}
	}
}
