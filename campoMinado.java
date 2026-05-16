import java.util.Random;
import java.util.Scanner;

public class CampoMinado {

    static int[][] matriz;       // Matriz do jogo: -1 bomba, 0 livre, 1 acerto
    static int linhas;
    static int colunas;
    static int totalBombas;
    static int pontuacao = 0;
    static boolean jogoAtivo = true;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // --- Configuração inicial ---
        System.out.println("=== CAMPO MINADO ===\n");

        do {
            System.out.print("Número de linhas (mínimo 2): ");
            linhas = sc.nextInt();
        } while (linhas < 2);

        do {
            System.out.print("Número de colunas (mínimo 2): ");
            colunas = sc.nextInt();
        } while (colunas < 2);

        int totalCelulas = linhas * colunas;

        do {
            System.out.print("Quantidade de bombas (entre 1 e " + (totalCelulas - 1) + "): ");
            totalBombas = sc.nextInt();
        } while (totalBombas <= 0 || totalBombas >= totalCelulas);

        // --- Preparação do jogo ---
        matriz = new int[linhas][colunas];
        distribuirBombas();

        System.out.println("\nMatriz inicializada! Boa sorte!\n");
        imprimirMatriz();

        // --- Loop principal do jogo ---
        while (jogoAtivo) {
            int i, j;

            // Ler posição válida do jogador
            do {
                System.out.print("\nEscolha uma linha (0 a " + (linhas - 1) + "): ");
                i = sc.nextInt();
                System.out.print("Escolha uma coluna (0 a " + (colunas - 1) + "): ");
                j = sc.nextInt();

                if (i < 0 || i >= linhas || j < 0 || j >= colunas) {
                    System.out.println("Posição inválida! Tente novamente.");
                } else if (matriz[i][j] == 1) {
                    System.out.println("Posição já escolhida! Tente outra.");
                }
            } while (i < 0 || i >= linhas || j < 0 || j >= colunas || matriz[i][j] == 1);

            // Processar jogada
            if (matriz[i][j] == -1) {
                // Achou bomba
                matriz[i][j] = -2; // -2 = bomba revelada ("b")
                jogoAtivo = false;
                System.out.println("\nBOOM! Você encontrou uma bomba!");
            } else {
                // Posição livre
                matriz[i][j] = 1;
                pontuacao++;

                if (temBombaAoRedor(i, j)) {
                    System.out.println("Cuidado: bomba próxima!");
                }

                // Verificar vitória: todas as células livres escolhidas
                if (pontuacao == totalCelulas - totalBombas) {
                    jogoAtivo = false;
                    System.out.println("\nParabéns, você ganhou o jogo!");
                }
            }

            imprimirMatriz();
        }

        // --- Término do jogo ---
        if (pontuacao < totalCelulas - totalBombas) {
            System.out.println("Game Over!");
        }

        System.out.println("Pontuação: " + pontuacao + " ponto(s).");
        sc.close();
    }

    // Distribui bombas aleatoriamente na matriz
    static void distribuirBombas() {
        Random rand = new Random();
        int colocadas = 0;

        while (colocadas < totalBombas) {
            int i = rand.nextInt(linhas);
            int j = rand.nextInt(colunas);

            if (matriz[i][j] != -1) {
                matriz[i][j] = -1;
                colocadas++;
            }
        }
    }

    // Imprime a matriz exibindo "_", "x" e "b" ao jogador
    static void imprimirMatriz() {
        System.out.println();
        for (int i = 0; i < linhas; i++) {
            System.out.print("[ ");
            for (int j = 0; j < colunas; j++) {
                if (matriz[i][j] == 1) {
                    System.out.print("x ");   // Acerto
                } else if (matriz[i][j] == -2) {
                    System.out.print("b ");   // Bomba revelada
                } else {
                    System.out.print("_ ");   // Não revelado (0 ou -1 oculto)
                }
            }
            System.out.println("]");
        }
        System.out.println();
    }

    // Retorna true se há bomba em alguma célula adjacente à posição (i, j)
    static boolean temBombaAoRedor(int i, int j) {
        for (int di = -1; di <= 1; di++) {
            for (int dj = -1; dj <= 1; dj++) {
                if (di == 0 && dj == 0) continue; // Ignora a própria célula

                int ni = i + di;
                int nj = j + dj;

                if (ni >= 0 && ni < linhas && nj >= 0 && nj < colunas) {
                    if (matriz[ni][nj] == -1) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}