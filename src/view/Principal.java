package view;

import java.util.concurrent.Semaphore;

import controller.controleSentido;

public class Principal {

	public static void main(String[] args) {
		
		Semaphore semaforo = new Semaphore(1);
		Semaphore semaforo2= new Semaphore(1);
		
		for(int idCarro=1; idCarro<=10; idCarro++) {
			Thread contSent = new controleSentido(idCarro, semaforo, semaforo2);
			contSent.start();
		}
	}

}
