
package utils;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

public abstract class SorteadorIdentificacao {
    private static boolean arrayCarregado = false;
    private static ArrayList<String> nomes = new ArrayList<>();
    
    private static void carregarArquivo() {
        try {
            URL caminhoArquivo = SorteadorIdentificacao.class.getResource("nomes.txt");
            File arquivoNomes = new File(caminhoArquivo.getPath());
            Scanner scanner = new Scanner(arquivoNomes);
            
            while (scanner.hasNext()) {
                String nome = scanner.nextLine();
                nomes.add(nome);
            }
            
            scanner.close();
            arrayCarregado = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static String sortearNome() {
        if (!arrayCarregado) {
            carregarArquivo();
        }
        
        return nomes.get(MathUtils.InteiroAleatorio(nomes.size()));
    }
}
