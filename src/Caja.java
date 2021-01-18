package Practica_1_supermercado;

public class Caja extends Thread {
	
	private Supermercado supermercado;
	private int id;
	private int tiempoCaja;
	/** Crea una nueva caja 
	 * @param int id
	 * @param Supermercado supermercado
	 */
	
	public Caja(Supermercado supermercado, int id) {
		this.supermercado = supermercado;
		this.id = id;
		this.tiempoCaja = 0;
	}
	
	public void run() {
		int retardo;
		int numeroCliente;
		while(supermercado.isClientesPendientes()) {
			try {
				/* Crea un tiempo de retardo de atencion entre clientes. */
				retardo = (int) (Math.random() * 90 + 10);
				tiempoCaja += retardo;
				numeroCliente = supermercado.terminarCliente(retardo);
				sleep(retardo);
				System.out.println("La caja " + id + " ha atendido al cliente " + numeroCliente + " en un tiempo de " + retardo);
			} catch (InterruptedException e){
				e.printStackTrace();
			}
		}	
		System.out.println("Fin de la caja " + id + ", que ha terminado con un tiempo parcial de " + tiempoCaja);
	}
	
}