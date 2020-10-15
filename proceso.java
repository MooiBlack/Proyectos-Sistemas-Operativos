import java.io.*;
import java.lang.*;
import java.math.*;
import java.util.PriorityQueue;

class proceso{
	String nombre;
	int id;
	int instr;
	int espacio_mem;

	public proceso(String nombre, int id, int instr, int espacio_mem){
		this.nombre=nombre;
		this.id=id;
		this.instr=instr;
		this.espacio_mem=espacio_mem;
	}

	public void setName(String nombre){
		this.nombre=nombre;
	}

	public String getName(){
		return nombre;
	}

	public int get_id(){
		return id;
	}

	public int instr(){
		return instr;
	}
	public int espacio_mem(){
		return espacio_mem;
	}

	public void excute_proc(){
		this.instr=this.instr-5;
	}


}