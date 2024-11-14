
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();
        int[] vet = new int[num];
        int j = 0;
        while (j < num) {
            vet[j++] = sc.nextInt();
        }

        ListaEstatica le = new ListaEstatica(vet);
        for (int i = 0; i < vet.length; i++) {
            le.inserirFim(vet[i]);
        }
        le.mostraListaEstatica();

        le.copiaInversoRec();

        ListaDinamica ld = new ListaDinamica();

        for (int i = 0; i < vet.length; i++) {
            ld.inserirFim(vet[i]);
        }
        ld.mostrarDinamica();

        ld.excluiPosicoesPares();
        ld.mostrarDinamica();

        ListaDinamica lmedia = ld.acimaDaMedia();
        lmedia.mostrarDinamica();
    }
}

class ListaDinamica {

    Celula prim, ult;
    int tamLista;

    ListaDinamica() {
        prim = new Celula();
        ult = prim;
        tamLista = 0;
    }

    void excluiPosicoesPares() {
        for (Celula i = prim; i != null && i.prox != null; i = i.prox) {
            Celula tmp = i.prox;
    
            if (tmp == ult) {
                ult = i;
            }
    
            i.prox = tmp.prox;
            tmp.prox = null;
        }
    }
    

    ListaDinamica acimaDaMedia() {
        int soma = 0;
        ListaDinamica ListaDinamica = new ListaDinamica();
        for (Celula i = prim.prox; i != null; i = i.prox) {
            soma += i.num;
        }
        float media = soma / tamLista;
        for (Celula i = prim.prox; i != null; i = i.prox) {
            if (i.num > media) {
                ListaDinamica.inserirFim(i.num);
            }
        }
        if (ListaDinamica.prim == ListaDinamica.ult) {
            return null;
        } else {
            return ListaDinamica;
        }
    }

    /**
     * *** Métodos comuns da lista ********
     */
    void inserirFim(int x) {
        ult.prox = new Celula(x);
        ult = ult.prox;
        tamLista++;
    }

    void mostrarDinamica() {
        if (prim == ult) {
            System.out.print("Lista Dinamica Vazia");
        } else {
            for (Celula i = prim.prox; i != null; i = i.prox) {
                System.out.print(i.num + " ");
            }
            System.out.println();
        }
    }
}

class ListaEstatica {

    int tamLista;
    int tamVet;
    int[] vet;

    ListaEstatica(int[] vet) {
        this.vet = vet;
        this.tamVet = vet.length;
        this.tamLista = 0;
    }

    ListaEstatica(int tamLista) {
        this.vet = new int[tamLista];
        this.tamVet = tamLista;
        this.tamLista = 0;
    }

    void recurssivo(int index, ListaEstatica lista) {
        if (index == 0) {
            lista.inserirFim(vet[index]);
        } else {
            lista.inserirFim(vet[index]);
            recurssivo(index - 1, lista);
        }
    }

    void copiaInversoRec() {
        if (tamLista == 0) {
            System.out.print("Lista Estatica Vazia");
        } else {
            ListaEstatica novalista = new ListaEstatica(tamLista);
            recurssivo(tamLista - 1, novalista);

            for (int i = 0; i < tamLista; i++) {
                System.out.print(novalista.vet[i] + " ");
            }
            System.out.println();
        }
    }

    /**
     * *** Métodos comuns da fila ********
     */
    void inserirFim(int x) {
        if (tamLista == tamVet) {
            System.out.println("Lista Estatica cheia.");
        } else {
            vet[tamLista] = x;
            tamLista++;
        }
    }

    void mostraListaEstatica() {
        if (tamLista == 0) {
            System.out.println("Lista Estatica vazia.");
        } else {
            for (int i = 0; i < tamLista; i++) {
                System.out.print(vet[i] + " ");
            }
            System.out.println();
        }
    }

}

class Celula {

    int num;
    Celula prox;

    Celula() {
        this(0);
    }

    Celula(int x) {
        num = x;
        prox = null;
    }
}
