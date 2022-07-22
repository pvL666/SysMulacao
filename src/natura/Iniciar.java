package natura;

import ambiente.Ambiente;
import utils.ConstantesGerais;

/**
 *
 * @author pvL
 */
public class Iniciar {

    public static void main(String[] args) {
        Ambiente ambiente = new Ambiente(10, 10);

        Thread threadAmbiente = new Thread() {
            @Override
            public void run() {
                while (true) {
                    try {
                        System.out.println(ambiente.toString());
                        ambiente.iterar();
                        sleep(ConstantesGerais.MILISEGUNDOS_ENTRE_ITERACOES);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }
        };

        threadAmbiente.start();
    }
}
