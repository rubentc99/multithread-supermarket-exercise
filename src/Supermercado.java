package Practica_1_supermercado;

import java.util.PriorityQueue;
import java.util.concurrent.Semaphore;


class Supermercado {
	private Semaphore semaforo;
	private PriorityQueue <Integer> listaClientes;
	private Integer tiempoTotal;

	public Supermercado() {
		semaforo = new Semaphore(1);
		listaClientes = new PriorityQueue <Integer>();
		tiempoTotal = 0;
	}

	/** Agrega un nuevo cliente para atender
	 * @param Integer numeroCliente
	 */
	public void nuevoCliente(Integer numeroCliente) {
		try {
			semaforo.acquire();
			listaClientes.add(numeroCliente);
			semaforo.release();
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
	}

	/** Finaliza el servicio de un cliente 
	 * @param Integer numeroParcial
	 * @return int cliente
	 */
	public int terminarCliente(Integer tiempoParcial) {
		int cliente = 0;
		try {
			if(isClientesPendientes()) {
				semaforo.acquire();
				cliente = listaClientes.poll();
				tiempoTotal += tiempoParcial;
				semaforo.release();
			}
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		return cliente;
	}
	
	/** Comprueba si existen clientes pendientes de ser atendidos.
	 * @return boolean
	 */
	public boolean isClientesPendientes() {
		return listaClientes.size() > 0;
	}
	
	/** Devuelve el tiempo total del servicio del supermercado. 
	 * @return Integer tiempo
	 */
	public Integer getTiempo () {
		return tiempoTotal;
	}
}
