package natura;

import ambiente.Ambiente;

/**
 *
 * @author pvL
 */
public class Iniciar {

    public static void main(String[] args) {
        Ambiente ambiente = new Ambiente(10, 10);

        System.out.println(ambiente.toString());
    }
}
