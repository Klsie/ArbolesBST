package arbol;

public class main {
    public static void main(String[] args) {
        Arbol arbol = new Arbol(15, 0);
        arbol.insertar(arbol, 12);
        arbol.insertar(arbol, 4);
        arbol.insertar(arbol, 42);
        arbol.insertar(arbol, 3);
        arbol.insertar(arbol, 76);
        arbol.insertar(arbol, 411);

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
