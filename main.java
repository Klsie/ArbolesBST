package arbol;
import java.util.Random;

public class main {
    public static void main(String[] args) {
        Arbol arbol = new Arbol(20, 0);
        Random rand = new Random();

        // Insertar 15 números aleatorios en el rango de 1 a 100
        for (int i = 0; i < 15; i++) {
            int numeroAleatorio = rand.nextInt(100) + 1;
            arbol.insertar(arbol, numeroAleatorio);
        }

        System.out.println("Forma del árbol:");
        arbol.imprimirArbol(arbol);
        System.out.println("Preorder----------------------------");
        arbol.preorden(arbol);
        System.out.println("PostOrder----------------------------");
        arbol.postorden(arbol);
        System.out.println("Inorder----------------------------");
        arbol.inorden(arbol);
    }
}
