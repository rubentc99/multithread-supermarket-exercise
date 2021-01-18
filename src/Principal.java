package Practica_1_supermercado;

public class Principal {
	
	public static void main(String[] args) {
		/* Creacion del numero aleatorio de puestos. */
		int puestos = (int) (Math.random() * 4) + 3;

		/* Creacion del numero aleatorio de clientes. */
		int clientes = (int) (Math.random() * 30) + 100;
		
		Supermercado supermercado = new Supermercado();
		System.out.println(clientes + " clientes seran atendidos por " + puestos + " cajas.");

		Cliente[] cl = new Cliente[clientes];
		/* Creacion de clientes */
		for (int i = 0; i < clientes ; i++) {
			cl[i] = new Cliente(supermercado, i+1);
			cl[i].start();
		}
		
		Caja[] ca = new Caja[puestos];
		/* Creacion de cajas */
		for (int i = 0; i < puestos ; i++) {
			ca[i] = new Caja(supermercado, i+1);
			ca[i].start();
		}

		/* Esperar a que terminen todos los cajas */
		for (int i = 0; i < puestos ; i++) {
			try {
				ca[i].join();
			}catch (InterruptedException e){
				e.printStackTrace();
			}
		}
		
		/* Esperar a que terminen todos clientes */
		for (int i = 0; i < clientes ; i++) {
			try {
				cl[i].join();
			}catch (InterruptedException e){
				e.printStackTrace();
			}
		}
		
		/* Se cierra la supermercado */
		System.out.println("Se cierra el supermercado con un tiempo total de " + supermercado.getTiempo());
	}
}