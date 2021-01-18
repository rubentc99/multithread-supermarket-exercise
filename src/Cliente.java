package Practica_1_supermercado;

public class Cliente extends Thread {
	
	private Supermercado supermercado;
	private Integer id;
	
	/** Crea un nuevo cliente 
	 * @param int id
	 * @param Supermercado supermercado
	 */
	public Cliente(Supermercado supermercado, Integer id) {
		this.supermercado = supermercado;
		this.id = id;
	}

	public void run() {
		supermercado.nuevoCliente(id);
	}
}
