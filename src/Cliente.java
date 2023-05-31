import java.util.concurrent.Semaphore;

public class Cliente extends Thread{
	Semaphore sedia;
	Semaphore pittore;
	long tattesa;
	long tfine;
	int m,M;
	int n;
	
	
	public Cliente(Semaphore sedie, Semaphore pittore,long tempofinale, int m,int M,int i) {
		super();
		this.sedia = sedie;
		this.pittore = pittore;
		tattesa=0;
		tfine=tempofinale;
		this.m=m;
		this.M=M;
		n=i;
	}
	
	public void run(){
		while(true) {
            try {                                                //Sleep random in range
                int range = (M - M) + 1;
                Thread.sleep((int)(Math.random() * range) + m);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                sedia.acquire();                            //Acquire mutex sedie
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            tattesa=System.currentTimeMillis();
            try {
                pittore.acquire();                            //Acquire mutex pittore
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("\nIl Trhead numero "+n+" ha aspettato: "+(System.currentTimeMillis()-tattesa));
            if((System.currentTimeMillis()-tattesa)<=tfine) {
                System.out.println("\nIl Trhead numero "+n+" è Entrato");
                try {                                                //Sleep random in range
                    int range = (M - m) + 1;
                    Thread.sleep((int)(Math.random() * range) + m);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            pittore.release();
            sedia.release();
        }
	}
}
