package arbol;

public class Arbol {

    int value;
    Arbol left;
    Arbol right;
    int color; // 1 = red, 0 = black

    public Arbol(int value, int color) {
        this.value = value;
        this.color = color;
        left = right = null;
    }

    public int obtenerValor() {
        return value;
    }

    public void asignarValor(int value) {
        this.value = value;
    }

    public Arbol obtenerIzquierdo() {
        return left;
    }

    public void asignarIzquierdo(Arbol izquierdo) {
        this.left = izquierdo;
    }

    public Arbol obtenerDerecho() {
        return right;
    }

    public void asignarDerecho(Arbol derecho) {
        this.right = derecho;
    }

    public int obtenerColor() {
        return color;
    }

    public void asignarColor(int color) {
        this.color = color;
    }

    public void insertar(Arbol arbol, int nuevoValor) {
        Arbol nuevaRama = new Arbol(nuevoValor, 1);
        if (nuevoValor < value) {
            if (left == null) {
                left = nuevaRama;
            } else {
                left.insertar(arbol, nuevoValor);
            }
        } else if (nuevoValor > value) {
            if (right == null) {
                right = nuevaRama;
            } else {
                right.insertar(arbol, nuevoValor);
            }
        }
        // balancearArbol(arbol);
    }

    // Imprimir forma del árbol
    public int obtenerAltura(Arbol nodo) {
        if (nodo == null) {
            return 0;
        }
        int izquierda = obtenerAltura(nodo.left);
        int derecha = obtenerAltura(nodo.right);
        return Math.max(izquierda, derecha) + 1;
    }

    public void imprimirArbol(Arbol nodo) {
        int altura = obtenerAltura(nodo);
        String[] niveles = new String[altura];
        imprimirArbol(nodo, 0, niveles);
        for (int i = 0; i < niveles.length; i++) {
            System.out.println(niveles[i] + " NIVEL:" + i);
        }
    }

    public void imprimirArbol(Arbol nodo, int nivel, String[] niveles) {
        if (nodo != null) {
            niveles[nivel] = nodo.obtenerValor() + "  " + ((niveles[nivel] != null) ? niveles[nivel] : "");
            imprimirArbol(nodo.right, nivel + 1, niveles);
            imprimirArbol(nodo.left, nivel + 1, niveles);
        }
    }

    // Imprimir órdenes
    public void preorden(Arbol nodo) {
        if (nodo != null) {
            System.out.println(nodo.obtenerValor());
            preorden(nodo.left);
            preorden(nodo.right);
        }
    }

    public void postorden(Arbol nodo) {
        if (nodo != null) {
            postorden(nodo.left);
            postorden(nodo.right);
            System.out.println(nodo.obtenerValor());
        }
    }

    public void inorden(Arbol nodo) {
        if (nodo != null) {
            inorden(nodo.left);
            System.out.println(nodo.obtenerValor());
            inorden(nodo.right);
        }
    }

    public void balancearArbol(Arbol nodo) {
        if (esRojo(right) && !esRojo(left)) {
            nodo = rotarIzquierda(nodo);
        }
        if (esRojo(left) && !esRojo(left.left)) {
            nodo = rotarDerecha(nodo);
        }
        if (esRojo(left) && !esRojo(right)) {
            flipColores(nodo);
        }
    }

    public Arbol rotarIzquierda(Arbol nodo) {
        Arbol nuevaRaiz = nodo.right;
        nodo.right = nuevaRaiz.left;
        nuevaRaiz.left = nodo;
        nodo = nuevaRaiz;
        return nodo;
    }

    public Arbol rotarDerecha(Arbol nodo) {
        Arbol nuevaRaiz = nodo.left;
        nodo.left = nuevaRaiz.right;
        nuevaRaiz.right = nodo;
        nodo = nuevaRaiz;
        return nodo;
    }

    public boolean esRojo(Arbol nodo) {
        return nodo != null && nodo.color == 1;
    }

    public void flipColores(Arbol nodo) {
        nodo.color = 1;
        nodo.left.color = 0;
        nodo.right.color = 0;
    }
}
