package controller;

import java.util.concurrent.Semaphore;

public class controleSentido extends Thread {

	private int idCarro;
	private Semaphore semaforo;
	private Semaphore semaforo2;
	private static int sentido;

	public controleSentido(int idCarro, Semaphore semaforo, Semaphore semaforo2) {
		this.idCarro = idCarro;
		this.semaforo = semaforo;
		this.semaforo2= semaforo2;
	}

	@Override
	public void run() {
		try {
			semaforo2.acquire();
			chegando();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			semaforo2.release();
		}
		try {
			semaforo.acquire();
			cruzamento();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			semaforo.release();
		}
	}

	private void chegando() {
		try {
			sleep(1000);
			System.out.println("O carro #" + idCarro + " chegou no cruzamento");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void cruzamento() {
		sentido = (int) (Math.random() * 4) + 1;
		try {
			sleep(1000);
			switch (sentido) {
			case 1:
				System.out.println("O carro #" + idCarro + " foi para baixo");
				break;
			case 2:
				System.out.println("O carro #" + idCarro + " foi para cima");
				break;
			case 3:
				System.out.println("O carro #" + idCarro + " foi para direita");
				break;
			case 4:
				System.out.println("O carro #" + idCarro + " foi para esquerda");
				break;
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
