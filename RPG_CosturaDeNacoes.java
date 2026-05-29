import java.util.Scanner;

public class PROJETORPPG_FINAL {
    static Scanner leia = new Scanner(System.in);

    // Stats do jogador
    static int hp = 100;
    static int bandagens = 2;
    static int bonusDano = 0;
    static Arma armaAtual = null;

    // Sistema de XP
    static int xp = 0;
    static int level = 1;
    static int xpParaProximoNivel = 100;

    // Sistema de diplomacia
    static int pontosDiplomacia = 0;

    // ---------------------------------------------------------------
    // CLASSE INTERNA: ARMA
    // ---------------------------------------------------------------
    static class Arma {
        String nome;
        int danoBase;
        int danoCritico;
        double chanceCritico;

        Arma(String nome, int danoBase, int danoCritico, double chanceCritico) {
            this.nome = nome;
            this.danoBase = danoBase;
            this.danoCritico = danoCritico;
            this.chanceCritico = chanceCritico;
        }
    }

    static Arma criarArma(int opcao) {
        switch (opcao) {
            case 1: return new Arma("ESPADA",       15 + bonusDano, 30 + bonusDano, 0.30);
            case 2: return new Arma("ARCO",         10 + bonusDano, 25 + bonusDano, 0.50);
            case 3: return new Arma("ARMA DE FOGO", 20 + bonusDano, 40 + bonusDano, 0.15);
            default: return null;
        }
    }

    // ---------------------------------------------------------------
    // MAIN
    // ---------------------------------------------------------------
    public static void main(String[] args) {
        System.out.println("    ________________________");
        System.out.println("   |                        |");
        System.out.println("   |   COSTURA DE NAÇÕES    |");
        System.out.println("   |________________________|");
        exibirMenu();
        leia.close();
    }

    // ---------------------------------------------------------------
    // MENU PRINCIPAL
    // ---------------------------------------------------------------
    static void exibirMenu() {
        int opcao;
        do {
            System.out.println("\n=== MENU PRINCIPAL ===");
            System.out.println("\n1 -     JOGAR");
            System.out.println("\n2 -    CREDITOS");
            System.out.println("\n3 -  SAIR DO GAME");
            System.out.print("\n  ESCOLHA SUA OPCAO: ");
            opcao = leia.nextInt();
            switch (opcao) {
                case 1: jogar(); break;
                case 2: creditos(); break;
                case 3:
                    System.out.println("Saindo...\nAté breve");
                    break;
                default:
                    System.out.println("Opção inválida. Tente Novamente.");
            }
        } while (opcao != 3);
    }

    // ---------------------------------------------------------------
    // JOGAR — CAPÍTULO 1: FLORESTA
    // ---------------------------------------------------------------
    static void jogar() {
        System.out.println("\nBem vindo ao mundo de Costura de Nações!");
        System.out.println("|    CAPITULO 1    |");
        System.out.println("\nVocê está na floresta.");
        System.out.println("\nInstrucoes:");
        System.out.println("  Explore para ganhar XP e bandagens");
        System.out.println("  Caso seu HP chegar a 0 o personagem MORRERA");

        int subOpcao;
        do {
            System.out.println("\n1 - Explorar");
            System.out.println("2 - Falar com Lider Thorn (Diplomacia)");
            System.out.println("3 - Voltar ao menu principal");
            System.out.print("Escolha uma opcao: ");
            subOpcao = leia.nextInt();

            switch (subOpcao) {
                case 1:
                    if (Math.random() >= 0.85) {
                        bandagens++;
                        System.out.println("\nVocê achou uma bandagem! Total: " + bandagens);
                    } else {
                        combate();
                    }
                    break;
                case 2:
                    dialogoFloresta();
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (subOpcao != 3 && hp > 0);

        if (hp > 0 && pontosDiplomacia >= 20) {
            System.out.println("\n|    CAPITULO 2    |");
            System.out.println("\nVocê chegou à Cidade Urbana.");
            jogarCidade();
        }
    }

    // ---------------------------------------------------------------
    // JOGAR — CAPÍTULO 2: CIDADE
    // ---------------------------------------------------------------
    static void jogarCidade() {
        int subOpcao;
        do {
            System.out.println("\n1 - Explorar");
            System.out.println("2 - Falar com Lider Voss (Diplomacia)");
            System.out.println("3 - Voltar ao menu principal");
            System.out.print("Escolha uma opcao: ");
            subOpcao = leia.nextInt();

            switch (subOpcao) {
                case 1:
                    if (Math.random() >= 0.85) {
                        bandagens++;
                        System.out.println("\nVocê achou uma bandagem! Total: " + bandagens);
                    } else {
                        combate();
                    }
                    break;
                case 2:
                    dialogoCidade();
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (subOpcao != 3 && hp > 0);

        if (hp > 0 && pontosDiplomacia >= 40) {
            System.out.println("\n|    CAPITULO 3    |");
            System.out.println("\nVocê chegou ao Deserto.");
            jogarDeserto();
        }
    }

    // ---------------------------------------------------------------
    // JOGAR — CAPÍTULO 3: DESERTO
    // ---------------------------------------------------------------
    static void jogarDeserto() {
        int subOpcao;
        do {
            System.out.println("\n1 - Explorar");
            System.out.println("2 - Falar com Lider Kael (Diplomacia)");
            System.out.println("3 - Voltar ao menu principal");
            System.out.print("Escolha uma opcao: ");
            subOpcao = leia.nextInt();

            switch (subOpcao) {
                case 1:
                    if (Math.random() >= 0.85) {
                        bandagens++;
                        System.out.println("\nVocê achou uma bandagem! Total: " + bandagens);
                    } else {
                        combate();
                    }
                    break;
                case 2:
                    dialogoDeserto();
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (subOpcao != 3 && hp > 0);

        // FIX: chamar capítulo 4 após conquistar o deserto
        if (hp > 0 && pontosDiplomacia >= 60) {
            System.out.println("\n|    CAPITULO FINAL    |");
            System.out.println("\nVocê chegou às portas de Invicta.");
            jogarInvicta();
        }
    }

    // ---------------------------------------------------------------
    // COMBATE
    // ---------------------------------------------------------------
    static void combate() {
        System.out.println("\nVocê encontrou um inimigo! Entrando em combate!");

        if (armaAtual != null) {
            System.out.println("Arma equipada: " + armaAtual.nome
                    + " | Dano: " + armaAtual.danoBase
                    + " | Crítico: " + armaAtual.danoCritico
                    + " (" + (int)(armaAtual.chanceCritico * 100) + "% chance)");
        } else {
            System.out.println("Você está lutando sem arma!");
        }

        int hpInimigo = 100;
        int bandagensInimigo = 2;
        int defesasConsecutivasInimigo = 0;
        boolean defesaPerfeitaInimigo = false;
        boolean defesaPerfeitaJogador = false;

        while (hp > 0 && hpInimigo > 0) {
            System.out.println("\nHP: " + hp + " | Bandagens: " + bandagens + " | HP Inimigo: " + hpInimigo + " | Bandagens Inimigo: " + bandagensInimigo);
            System.out.println("1 - Atacar | 2 - Defender | 3 - Curar");
            System.out.print("Escolha: ");
            int opcaoCombate = leia.nextInt();

            // --- TURNO DO JOGADOR ---
            switch (opcaoCombate) {
                case 1:
                    int dano;
                    if (armaAtual != null) {
                        boolean critico = Math.random() < armaAtual.chanceCritico;
                        dano = critico ? armaAtual.danoCritico : armaAtual.danoBase;
                        System.out.println(critico
                                ? "Crítico com " + armaAtual.nome + "! Dano: " + dano
                                : "Ataque com " + armaAtual.nome + ". Dano: " + dano);
                    } else {
                        dano = Math.random() < 0.7 ? 10 : 20;
                        System.out.println(dano == 20 ? "Crítico! Dano: " + dano : "Ataque normal. Dano: " + dano);
                    }

                    if (defesaPerfeitaInimigo) {
                        if (Math.random() < 0.50) {
                            System.out.println("Você furou a defesa perfeita do inimigo! Dano total aplicado.");
                        } else {
                            System.out.println("O inimigo bloqueou completamente! Nenhum dano causado.");
                            dano = 0;
                        }
                    } else if (Math.random() < 0.30) {
                        dano = dano / 2;
                        System.out.println("O inimigo defendeu parcialmente! Dano reduzido para: " + dano);
                    }

                    hpInimigo -= dano;
                    defesaPerfeitaInimigo = false;
                    defesaPerfeitaJogador = false;
                    System.out.println("HP do inimigo: " + hpInimigo);
                    break;

                case 2:
                    defesaPerfeitaJogador = true;
                    defesaPerfeitaInimigo = false;
                    System.out.println("Postura de defesa perfeita! Próximo ataque do inimigo será bloqueado.");
                    System.out.println("(Atenção: existe uma pequena chance de 10% do inimigo furar sua defesa!)");
                    break;

                case 3:
                    if (bandagens > 0) {
                        bandagens--;
                        hp = Math.min(hp + 30, 100);
                        System.out.println("Você usou uma bandagem! HP: " + hp);
                    } else {
                        System.out.println("Sem bandagens!");
                    }
                    defesaPerfeitaInimigo = false;
                    defesaPerfeitaJogador = false;
                    break;

                default:
                    System.out.println("Opção inválida.");
            }

            if (hpInimigo <= 0) break;

            // --- TURNO DO INIMIGO ---
            System.out.println("\n-- Turno do inimigo --");

            int acaoInimigo;
            if (hpInimigo <= 50 && bandagensInimigo > 0 && Math.random() < 0.70) {
                acaoInimigo = 3;
            } else if (defesasConsecutivasInimigo >= 2) {
                acaoInimigo = (hpInimigo <= 50 && bandagensInimigo > 0) ? 3 : 1;
                defesasConsecutivasInimigo = 0;
            } else {
                acaoInimigo = Math.random() < 0.50 ? 1 : 2;
            }

            if (acaoInimigo == 2) {
                defesasConsecutivasInimigo++;
            } else {
                defesasConsecutivasInimigo = 0;
            }

            switch (acaoInimigo) {
                case 1:
                    int danoInimigo = Math.random() < 0.70 ? 10 : 20;
                    System.out.println(danoInimigo == 20 ? "O inimigo tenta um crítico!" : "O inimigo ataca!");

                    if (defesaPerfeitaJogador) {
                        if (Math.random() < 0.10) {
                            System.out.println("O inimigo furou sua defesa perfeita! Dano total aplicado.");
                        } else {
                            System.out.println("Você bloqueou completamente! Nenhum dano recebido.");
                            danoInimigo = 0;
                        }
                    }

                    hp -= danoInimigo;
                    defesaPerfeitaJogador = false;
                    if (danoInimigo > 0) System.out.println("Você perdeu " + danoInimigo + " de HP. HP: " + hp);

                    if (Math.random() < 0.25) {
                        hpInimigo -= 10;
                        System.out.println("Você contra-atacou! O inimigo perdeu 10 de HP. HP inimigo: " + hpInimigo);
                    }
                    break;

                case 2:
                    defesaPerfeitaInimigo = true;
                    defesaPerfeitaJogador = false;
                    System.out.println("O inimigo assumiu postura de defesa perfeita!");
                    System.out.println("ATENÇÃO: existe uma chance de você furar a defesa do inimigo!");
                    break;

                case 3:
                    bandagensInimigo--;
                    hpInimigo = Math.min(hpInimigo + 30, 100);
                    defesaPerfeitaJogador = false;
                    System.out.println("O inimigo usou uma bandagem! HP do inimigo: " + hpInimigo);
                    break;
            }
        }

        if (hp <= 0) {
            telaGameOver();
        } else {
            System.out.println("\nVocê venceu o combate!");
            ganharXP(50 + (level * 10));
            System.out.println("\nVocê tem direito a uma RECOMPENSA!");
            recompensa();
        }
    }

    // ---------------------------------------------------------------
    // RECOMPENSA
    // ---------------------------------------------------------------
    static void recompensa() {
        System.out.println("\n=== RECOMPENSA ===");
        System.out.println("\nO que deseja fazer?");
        System.out.println("\n1 - Escolher uma arma agora");
        System.out.println("\n2 - Aumentar dano base (+5) para ganhar uma arma mais forte no próximo combate");
        System.out.println("    (Bônus atual: " + bonusDano + " | Futuro: " + (bonusDano + 5) + ")");
        System.out.print("\n  ESCOLHA SUA OPCAO: ");
        int opcaoRecompensa = leia.nextInt();

        switch (opcaoRecompensa) {
            case 1:
                System.out.println("\n ARMAS:");
                System.out.println("\n1 - ESPADA       (Dano: " + (15 + bonusDano) + " | Crítico: " + (30 + bonusDano) + " | 30% de chance)");
                System.out.println("\n2 - ARCO         (Dano: " + (10 + bonusDano) + " | Crítico: " + (25 + bonusDano) + " | 50% de chance)");
                System.out.println("\n3 - ARMA DE FOGO (Dano: " + (20 + bonusDano) + " | Crítico: " + (40 + bonusDano) + " | 15% de chance)");
                System.out.print("\n  ESCOLHA SUA OPCAO: ");
                int opcaoArma = leia.nextInt();

                Arma escolhida = criarArma(opcaoArma);
                if (escolhida != null) {
                    armaAtual = escolhida;
                    bandagens += 2;
                    System.out.println("Você equipou: " + armaAtual.nome + "!");
                    System.out.println("Você também recebeu 2 bandagens! Total: " + bandagens);
                } else {
                    System.out.println("Opção inválida.");
                }
                break;

            case 2:
                bonusDano += 5;
                bandagens += 2;
                System.out.println("Dano base aumentado! Bônus atual: " + bonusDano);
                System.out.println("As próximas armas serão mais fortes!");
                System.out.println("Você também recebeu 2 bandagens! Total: " + bandagens);
                break;

            default:
                System.out.println("Opção inválida.");
        }
    }

    // ---------------------------------------------------------------
    // SISTEMA DE XP
    // ---------------------------------------------------------------
    static void ganharXP(int quantidade) {
        xp += quantidade;
        System.out.println("\n+ " + quantidade + " XP ganho!");

        while (xp >= xpParaProximoNivel) {
            level++;
            xp -= xpParaProximoNivel;
            xpParaProximoNivel += 50;

            System.out.println("==================================");
            System.out.println("   LEVEL UP! Você agora é nível " + level + "!");
            System.out.println("==================================");
        }
    }

    // ---------------------------------------------------------------
    // TELA DE GAME OVER
    // ---------------------------------------------------------------
    static void telaGameOver() {
        System.out.println("\n========================================");
        System.out.println("             VOCÊ MORREU...");
        System.out.println("========================================");
        System.out.println("Nível alcançado: " + level);
        System.out.println("XP final: " + xp + " / " + xpParaProximoNivel);
        System.out.println("Pontos de Diplomacia: " + pontosDiplomacia);
        System.out.println("========================================");

        System.out.println("\n1 - Voltar ao Menu Principal");
        System.out.println("2 - Sair do Jogo");
        System.out.print("Escolha: ");

        int escolha = leia.nextInt();

        if (escolha == 1) {
            hp = 100;
            bandagens = 2;
            bonusDano = 0;
            armaAtual = null;
            System.out.println("\nJogo reiniciado! (Seu Nível, XP e Diplomacia foram mantidos)");
        } else {
            System.out.println("Obrigado por jogar! Até a próxima.");
            System.exit(0);
        }
    }

    // ---------------------------------------------------------------
    // CRÉDITOS
    // ---------------------------------------------------------------
    static void creditos() {
        System.out.println("\nCRÉDITOS");
        System.out.println("Otavio | Iuri | Lucas | Juliana | Vinicius | Gabriel");
        leia.nextLine();
        leia.nextLine();
    }

    // ===============================================================
    // SISTEMA DE DIÁLOGOS — DIPLOMACIA
    // ===============================================================

    static void pausa() {
        try { Thread.sleep(600); } catch (InterruptedException e) {}
    }

    static void fala(String personagem, String texto) {
        pausa();
        System.out.println("\n  [" + personagem + "]");
        System.out.println("  \"" + texto + "\"");
    }

    static int escolha(String opcao1, String opcao2) {
        System.out.println("\n  O que Amity faz?");
        System.out.println("  1 - " + opcao1);
        System.out.println("  2 - " + opcao2);
        System.out.print("  >> ");
        int opcao = leia.nextInt();
        leia.nextLine();
        return opcao;
    }

    static void sucessoDiplomacia(String local, int pontos) {
        pausa();
        pontosDiplomacia += pontos;
        System.out.println("\n  ★ ALIANÇA CONFIRMADA — " + local.toUpperCase());
        System.out.println("  + " + pontos + " pontos de diplomacia conquistados!");
        System.out.println("  Total de diplomacia: " + pontosDiplomacia);
        System.out.println("  ─────────────────────────────────────────");
    }

    static void falhaDialogo() {
        pausa();
        System.out.println("\n  ✗ NEGOCIAÇÃO FALHOU.");
        System.out.println("  Amity sai sem conquistar pontos de diplomacia.");
        System.out.println("  ─────────────────────────────────────────");
    }

    // ---------------------------------------------------------------
    // ATO 1 — FLORESTA · Líder Thorn
    // ---------------------------------------------------------------
    static void dialogoFloresta() {
        System.out.println("\n═══════════════════════════════════════════");
        System.out.println("  ATO 1 — FLORESTA · Líder Thorn");
        System.out.println("  Negociação: paz + recursos agrícolas");
        System.out.println("  Diplomacia atual: " + pontosDiplomacia);
        System.out.println("═══════════════════════════════════════════");

        if (pontosDiplomacia >= 20) {
            fala("Líder Thorn", "Ouvi falar de você, forasteira. Dizem que você " +
                 "enfrenta os soldados de Lich sem recuar. " +
                 "Por que deveria confiar em alguém criada em Invicta?");
            fala("Amity", "Porque eu também perdi tudo para Invicta. Não vim " +
                 "trazer guerra — vim oferecer algo que nenhum líder " +
                 "ofereceu antes: uma aliança real. Sua floresta tem o que " +
                 "outros não têm: água limpa, colheitas, vida. Em troca, " +
                 "posso garantir que nenhum soldado de Lich pisará " +
                 "nessa terra novamente.");
            fala("Líder Thorn", "...Você tem coragem, Amity. E palavras que " +
                 "fazem sentido. O que você propõe?");
            fala("Amity", "Simples. Sua floresta abastece os clãs com alimentos " +
                 "e água. Em troca, os clãs a protegem. " +
                 "Ninguém sobrevive sozinho nesse mundo.");
            fala("Líder Thorn", "Feito. Que a floresta seja a raiz dessa nova era.");
            sucessoDiplomacia("Floresta", 20);

        } else {
            fala("Líder Thorn", "Forasteira. Você tem audácia de aparecer aqui " +
                 "depois de derrubar meus guardas.");
            fala("Amity", "Vim falar sobre paz. Sobre uma aliança entre os clãs.");
            fala("Líder Thorn", "Paz? Isso é papo de quem nunca enterrou o " +
                 "próprio filho por causa de Invicta. Por que eu abriria " +
                 "mão da minha autonomia para me juntar a desconhecidos?");
            fala("Amity", "Porque a guerra vai consumir a floresta também. " +
                 "É só questão de tempo.");
            fala("Líder Thorn", "Palavras bonitas. Mas palavras não alimentam " +
                 "meu povo. Volte quando tiver algo concreto para oferecer" +
                 " — ou não volte.");

            int opcao = escolha(
                "Insistir — argumentar sobre o valor dos recursos da floresta",
                "Recuar — sair sem fechar acordo"
            );

            if (opcao == 1) {
                fala("Amity", "Sua floresta tem água e colheitas. Isso é " +
                     "exatamente o que os outros clãs precisam. " +
                     "Você tem poder de barganha.");
                fala("Líder Thorn", "...Talvez você tenha razão. Mas preciso " +
                     "de uma prova de que sua aliança vale alguma coisa. " +
                     "Volte após mostrar sua força.");

                if ((int)(Math.random() * 2) == 1) {
                    pausa();
                    System.out.println("\n  ! Thorn considera sua proposta...");
                    System.out.println("  Negociação parcialmente aceita.");
                    pontosDiplomacia += 10;
                    System.out.println("  + 10 pontos de diplomacia (metade do valor).");
                    System.out.println("  Total de diplomacia: " + pontosDiplomacia);
                    System.out.println("  ─────────────────────────────────────────");
                } else {
                    fala("Líder Thorn", "Não. Ainda não confio em você. Saia.");
                    falhaDialogo();
                }
            } else {
                fala("Amity", "Entendido. Voltarei quando o momento for certo.");
                falhaDialogo();
            }
        }
    }

    // ---------------------------------------------------------------
    // ATO 2 — CIDADE URBANA · Líder Voss
    // ---------------------------------------------------------------
    static void dialogoCidade() {
        System.out.println("\n═══════════════════════════════════════════");
        System.out.println("  ATO 2 — CIDADE URBANA · Líder Voss");
        System.out.println("  Negociação: tecnologia ↔ alimentos");
        System.out.println("  Diplomacia atual: " + pontosDiplomacia);
        System.out.println("═══════════════════════════════════════════");

        if (pontosDiplomacia >= 40) {
            fala("Líder Voss", "Então você é a Amity. A floresta já me contou " +
                 "sobre você. Impressionante — conseguir a confiança " +
                 "de Thorn não é para qualquer um.");
            fala("Amity", "Thorn entendeu que sobreviver sozinho é uma ilusão. " +
                 "Vim propor o mesmo a você.");
            fala("Líder Voss", "A cidade tem tecnologia que o mundo não viu igual. " +
                 "Geradores, comunicação, filtros de ar. Mas nossos " +
                 "estoques de comida estão acabando. " +
                 "O que você tem a oferecer?");
            fala("Amity", "A floresta. Alimentos, água, colheitas contínuas — " +
                 "tudo que sua cidade não consegue produzir. " +
                 "Em troca, sua tecnologia fortalece a aliança inteira.");
            fala("Líder Voss", "Uma cidade sem fome e uma floresta com tecnologia. " +
                 "Parece que você entende de negócios, Amity.");
            fala("Amity", "Entendo de sobrevivência. " +
                 "E sobrevivemos melhor juntos.");
            fala("Líder Voss", "Estou dentro. A cidade se une à aliança.");
            sucessoDiplomacia("Cidade Urbana", 20);

        } else {
            fala("Líder Voss", "Ouvi dizer que você anda fazendo promessas " +
                 "por aí. A floresta topou? Surpreendente.");
            fala("Amity", "A floresta entendeu o valor da união. " +
                 "Vim propor o mesmo.");
            fala("Líder Voss", "Minha cidade não precisa de aliança. " +
                 "Temos tecnologia, temos muros, temos recursos.");
            fala("Amity", "Recursos que acabam. Comida que vocês não produzem.");
            fala("Líder Voss", "Cuidado com o tom, forasteira. " +
                 "Você está na minha cidade.");

            int opcao = escolha(
                "Negociar com firmeza — destacar o valor da troca",
                "Recuar — sair sem fechar acordo"
            );

            if (opcao == 1) {
                fala("Amity", "Não vim com ameaças. Vim com uma proposta justa: " +
                     "sua tecnologia vale muito mais quando tem comida " +
                     "pra sustentar quem a opera.");
                fala("Líder Voss", "...Preciso de uma demonstração de que a " +
                     "floresta honra o acordo antes de decidir.");

                if ((int)(Math.random() * 2) == 1) {
                    pausa();
                    System.out.println("\n  ! Voss considera sua proposta...");
                    System.out.println("  Negociação parcialmente aceita.");
                    pontosDiplomacia += 10;
                    System.out.println("  + 10 pontos de diplomacia (metade do valor).");
                    System.out.println("  Total de diplomacia: " + pontosDiplomacia);
                    System.out.println("  ─────────────────────────────────────────");
                } else {
                    fala("Líder Voss", "Não estou convencido. Venha com mais " +
                         "do que palavras da próxima vez.");
                    falhaDialogo();
                }
            } else {
                fala("Amity", "Compreendo. Voltarei quando tiver mais a oferecer.");
                falhaDialogo();
            }
        }
    }

    // ---------------------------------------------------------------
    // ATO 3 — DESERTO · Líder Kael
    // ---------------------------------------------------------------
    static void dialogoDeserto() {
        System.out.println("\n═══════════════════════════════════════════");
        System.out.println("  ATO 3 — DESERTO · Líder Kael");
        System.out.println("  Negociação: veículos/tática ↔ tech/água");
        System.out.println("  Diplomacia atual: " + pontosDiplomacia);
        System.out.println("═══════════════════════════════════════════");

        if (pontosDiplomacia >= 60) {
            fala("Líder Kael", "Floresta. Cidade. E agora o deserto. " +
                 "Você coleciona aliados, Amity.");
            fala("Amity", "Coleciono sobreviventes que entendem que Lich " +
                 "vai consumir tudo — inclusive o deserto.");
            fala("Líder Kael", "Lich nos respeita. Temos os melhores veículos, " +
                 "os melhores estrategistas. Por que trocaríamos isso " +
                 "por uma aliança que nos coloca na mira dele?");
            fala("Amity", "Porque quando ele terminar com os fracos, vai querer " +
                 "os fortes também. Sua frota e sua inteligência de guerra " +
                 "são exatamente o que essa aliança precisa para " +
                 "enfrentá-lo. Em troca: tecnologia da cidade e água da " +
                 "floresta — os dois recursos que o deserto mais precisa.");
            fala("Líder Kael", "...Você não veio pedir ajuda. " +
                 "Veio oferecer uma guerra que já vencemos antes de começar.");
            fala("Amity", "Exatamente.");
            fala("Líder Kael", "Feito. O deserto marcha com você.");
            sucessoDiplomacia("Deserto", 20);
            pausa();
            System.out.println("  ► Caminho para Invicta aberto.");
            System.out.println("  ► Batalha final contra Lich se aproxima...");
            System.out.println("  ─────────────────────────────────────────");

        } else {
            fala("Líder Kael", "Forasteira. Você cruzou o deserto inteiro " +
                 "só pra falar comigo?");
            fala("Amity", "Vim propor uma aliança. " +
                 "Floresta e cidade já estão conosco.");
            fala("Líder Kael", "E o que isso tem a ver com o deserto? " +
                 "Vivemos bem aqui fora.");
            fala("Amity", "Vivem com sede. Com peças de reposição cada vez " +
                 "mais raras. Com rotas de comércio bloqueadas por Lich.");
            fala("Líder Kael", "Você está descrevendo inconveniências, " +
                 "não ameaças.");
            fala("Amity", "Ainda.");

            int opcao = escolha(
                "Apelar para a estratégia — argumentar sobre os planos de Lich",
                "Recuar — sair sem fechar acordo"
            );

            if (opcao == 1) {
                fala("Amity", "Kael, você é estrategista. Sabe que Lich não para. " +
                     "O deserto é o próximo passo dele — e você sabe disso.");
                fala("Líder Kael", "...");

                if ((int)(Math.random() * 2) == 1) {
                    pausa();
                    System.out.println("\n  ! Kael fica em silêncio por um longo momento...");
                    System.out.println("  Negociação parcialmente aceita.");
                    pontosDiplomacia += 10;
                    System.out.println("  + 10 pontos de diplomacia (metade do valor).");
                    System.out.println("  Total de diplomacia: " + pontosDiplomacia);
                    System.out.println("  ─────────────────────────────────────────");
                } else {
                    fala("Líder Kael", "Volte quando tiver mais do que teoria. " +
                         "O deserto não segue palavras — segue resultados.");
                    falhaDialogo();
                }
            } else {
                fala("Amity", "Tudo bem. Você saberá o momento certo.");
                falhaDialogo();
            }
        }
    } // FIM dialogoDeserto

    // ---------------------------------------------------------------
    // CAPÍTULO 4 — INVICTA
    // ---------------------------------------------------------------
    static void jogarInvicta() {
        System.out.println("\n═══════════════════════════════════════════");
        System.out.println("  CAPÍTULO FINAL — INVICTA");
        System.out.println("  Os três clãs marcharam juntos até os portões.");
        System.out.println("  Agora só falta um obstáculo: Lich.");
        System.out.println("═══════════════════════════════════════════");

        pausa();
        System.out.println("\n  As muralhas de Invicta se erguem à sua frente.");
        System.out.println("  Soldados de Lich bloqueiam a entrada.");

        int subOpcao;
        do {
            System.out.println("\n1 - Avançar pelos portões (Combate com soldados)");
            System.out.println("2 - Tentar negociar passagem com Lich");
            System.out.println("3 - Voltar ao menu principal");
            System.out.print("Escolha uma opcao: ");
            subOpcao = leia.nextInt();

            switch (subOpcao) {
                case 1:
                    combate();
                    if (hp > 0) {
                        System.out.println("\nOs soldados recuam! O caminho para Lich está aberto.");
                        System.out.println("Pressione ENTER para enfrentar Lich...");
                        leia.nextLine();
                        leia.nextLine();
                        dialogoLich();
                        subOpcao = 3;
                    }
                    break;
                case 2:
                    dialogoLich();
                    subOpcao = 3;
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (subOpcao != 3 && hp > 0);
    }

    // ---------------------------------------------------------------
    // DIÁLOGO COM LICH
    // ---------------------------------------------------------------
    static void dialogoLich() {
        System.out.println("\n═══════════════════════════════════════════");
        System.out.println("  AUDIÊNCIA COM LICH — Salão do Trono de Invicta");
        System.out.println("═══════════════════════════════════════════");

        pausa();
        fala("Lich", "Então é você, Amity. A costureira de clãs." +
             " Que ironia — uma criada de Invicta tentando destruí-la.");
        fala("Amity", "Não vim destruir. Vim reivindicar. Isso nunca foi" +
             " seu — foi tomado com sangue.");
        fala("Lich", "Tudo que vale algo é tomado com sangue." +
             " Você trouxe três clãs? Eu tenho um exército." +
             " O que exatamente você imagina que vai acontecer?");
        fala("Amity", "O mesmo que sempre acontece quando o povo" +
             " se une contra um tirano. Você perde.");

        pausa();
        System.out.println("\n  Lich sorri lentamente e desce do trono.");
        pausa();
        fala("Lich", "Diplomacia ou espada, forasteira. Escolha.");

        int opcao = escolha(
            "Tentar uma última negociação (rendição pacífica)",
            "Partir para o combate"
        );

        if (opcao == 1) {
            fala("Amity", "Renda-se. Sem derramamento de sangue." +
                 " Seu povo sobrevive. Invicta sobrevive.");
            fala("Lich", "...Interessante proposta. Mas não.");
            pausa();
            System.out.println("\n  ✗ Lich rejeita a oferta.");
            System.out.println("  + 25 XP pela tentativa diplomática.");
            ganharXP(25);
            pausa();
            System.out.println("\n  Ele ataca. Não há mais palavras.");
        } else {
            fala("Amity", "Então que seja a espada.");
        }

        combateLich();
    }

    // ---------------------------------------------------------------
    // COMBATE FINAL — LICH
    // ---------------------------------------------------------------
    static void combateLich() {
        System.out.println("\n╔══════════════════════════════════════╗");
        System.out.println("║       COMBATE FINAL — LICH           ║");
        System.out.println("╚══════════════════════════════════════╝");

        int aliadosAtivos = pontosDiplomacia / 20;
        double bonusAliados = 1.0 + (aliadosAtivos * 0.10);
        System.out.println("\n  Aliados ativos: " + aliadosAtivos
                + " | Bônus de dano dos clãs: +" + (int)((bonusAliados - 1.0) * 100) + "%");

        if (armaAtual != null) {
            System.out.println("  Arma equipada: " + armaAtual.nome
                    + " | Dano base: " + armaAtual.danoBase
                    + " | Crítico: " + armaAtual.danoCritico);
        } else {
            System.out.println("  Você está sem arma — os aliados reforçam seus punhos!");
        }

        int hpLich = 200;
        int bandagensLich = 5;
        int defesasConsecutivasLich = 0;
        boolean defesaPerfeitaLich = false;
        boolean defesaPerfeitaJogador = false;
        int fase = 1;
        boolean furiaAnunciada = false;   // FIX: nome consistente
        boolean frenesiAnunciado = false;

        while (hp > 0 && hpLich > 0) {

            if (hpLich <= 75 && fase < 3) {
                fase = 3;
                if (!frenesiAnunciado) {
                    pausa();
                    System.out.println("\n  !! FRENESI DE LICH !!");
                    fala("Lich", "NÃO... ISSO É IMPOSSÍVEL! SE EU CAIR," +
                         " INVICTA CAI COM VOCÊ!");
                    fala("Amity", "Invicta sobreviverá. Você, não.");
                    frenesiAnunciado = true;
                }
            } else if (hpLich <= 150 && fase < 2) {
                fase = 2;
                if (!furiaAnunciada) {   // FIX: variável correta
                    pausa();
                    System.out.println("\n  ! Lich entra em FÚRIA!");
                    fala("Lich", "Você... ousou chegar até aqui." +
                         " Vou acabar com você pessoalmente.");
                    furiaAnunciada = true;   // FIX: variável correta
                }
            }

            int danoLichBase = 12 + ((fase - 1) * 5);
            System.out.println("\n─────────────────────────────────────────");
            System.out.println("  HP: " + hp
                    + " | Bandagens: " + bandagens
                    + " | HP de Lich: " + hpLich + "/200"
                    + (fase == 2 ? " [FÚRIA]" : fase == 3 ? " [FRENESI]" : "")
                    + " | Bandagens de Lich: " + bandagensLich);
            System.out.println("─────────────────────────────────────────");
            System.out.println("  1 - Atacar");
            System.out.println("  2 - Defender (defesa perfeita)");
            System.out.println("  3 - Curar");
            System.out.print("  Escolha: ");
            int opcaoCombate = leia.nextInt();

            switch (opcaoCombate) {
                case 1:
                    int danoJogador;
                    if (armaAtual != null) {
                        boolean critico = Math.random() < armaAtual.chanceCritico;
                        danoJogador = critico ? armaAtual.danoCritico : armaAtual.danoBase;
                        System.out.println(critico
                                ? "  Crítico com " + armaAtual.nome + "! Dano base: " + danoJogador
                                : "  Ataque com " + armaAtual.nome + ". Dano base: " + danoJogador);
                    } else {
                        danoJogador = Math.random() < 0.7 ? 10 : 20;
                        System.out.println(danoJogador == 20
                                ? "  Crítico! Dano base: " + danoJogador
                                : "  Ataque normal. Dano base: " + danoJogador);
                    }

                    int danoFinalJogador = (int)(danoJogador * bonusAliados);
                    if (aliadosAtivos > 0)
                        System.out.println("  Aliados amplificam o golpe! Dano final: " + danoFinalJogador);

                    if (defesaPerfeitaLich) {
                        if (Math.random() < 0.40) {
                            System.out.println("  Você furou a defesa de Lich! Dano total aplicado.");
                        } else {
                            System.out.println("  Lich bloqueou completamente! Nenhum dano causado.");
                            danoFinalJogador = 0;
                        }
                    } else if (Math.random() < 0.25) {
                        danoFinalJogador = danoFinalJogador / 2;
                        System.out.println("  Lich desviou parcialmente! Dano reduzido: " + danoFinalJogador);
                    }

                    hpLich -= danoFinalJogador;
                    defesaPerfeitaLich = false;
                    defesaPerfeitaJogador = false;
                    System.out.println("  HP de Lich: " + Math.max(hpLich, 0));
                    break;

                case 2:
                    defesaPerfeitaJogador = true;
                    defesaPerfeitaLich = false;
                    System.out.println("  Postura de defesa perfeita assumida!");
                    System.out.println("  (10% de chance de Lich furar sua defesa)");
                    break;

                case 3:
                    if (bandagens > 0) {
                        bandagens--;
                        hp = Math.min(hp + 30, 100);
                        System.out.println("  Bandagem usada! HP: " + hp);
                    } else {
                        System.out.println("  Sem bandagens!");
                    }
                    defesaPerfeitaLich = false;
                    defesaPerfeitaJogador = false;
                    break;

                default:
                    System.out.println("  Opção inválida.");
            }

            if (hpLich <= 0) break;

            pausa();
            System.out.println("\n  -- Turno de Lich --");

            int acaoLich;
            if (hpLich <= 100 && bandagensLich > 0 && Math.random() < 0.60) {
                acaoLich = 3;
            } else if (defesasConsecutivasLich >= 2) {
                acaoLich = (hpLich <= 100 && bandagensLich > 0) ? 3 : 1;
                defesasConsecutivasLich = 0;
            } else {
                acaoLich = Math.random() < 0.55 ? 1 : 2;
            }

            if (acaoLich == 2) defesasConsecutivasLich++;
            else defesasConsecutivasLich = 0;

            switch (acaoLich) {
                case 1:
                    boolean criticoLich = Math.random() < 0.25;
                    int danoLich = criticoLich ? (danoLichBase + 12) : danoLichBase;
                    System.out.println(criticoLich
                            ? "  !! Lich lança um golpe devastador!"
                            : "  Lich ataca com força brutal!");

                    if (defesaPerfeitaJogador) {
                        if (Math.random() < 0.10) {
                            System.out.println("  Lich furou sua defesa! Dano total aplicado.");
                        } else {
                            System.out.println("  Você bloqueou completamente!");
                            danoLich = 0;
                        }
                    }

                    hp -= danoLich;
                    defesaPerfeitaJogador = false;
                    if (danoLich > 0)
                        System.out.println("  Você perdeu " + danoLich + " de HP. HP: " + Math.max(hp, 0));

                    double chanceContra = fase == 1 ? 0.30 : fase == 2 ? 0.20 : 0.15;
                    if (Math.random() < chanceContra) {
                        int danoContra = 8 + (aliadosAtivos * 2);
                        hpLich -= danoContra;
                        System.out.println("  Os aliados contra-atacam! Lich perde "
                                + danoContra + " HP. HP de Lich: " + Math.max(hpLich, 0));
                    }
                    break;

                case 2:
                    defesaPerfeitaLich = true;
                    defesaPerfeitaJogador = false;
                    System.out.println("  Lich assume postura de defesa arcana!");
                    System.out.println("  ATENÇÃO: 40% de chance de furar a defesa dele.");
                    break;

                case 3:
                    bandagensLich--;
                    hpLich = Math.min(hpLich + 40, 200);
                    defesaPerfeitaJogador = false;
                    System.out.println("  Lich absorve energia e se recupera! HP de Lich: " + hpLich);
                    break;
            }
        }

        if (hp <= 0) {
            pausa();
            fala("Lich", "Você foi corajosa, Amity. Mas coragem sem" +
                 " poder não conquista tronos.");
            telaGameOver();
        } else {
            telaVitoria();
        }
    }

    // ---------------------------------------------------------------
    // TELA DE VITÓRIA
    // ---------------------------------------------------------------
    static void telaVitoria() {
        ganharXP(200 + (level * 20));
        pausa();

        System.out.println("\n╔══════════════════════════════════════════════╗");
        System.out.println("║                                              ║");
        System.out.println("║   LICH FOI DERROTADO.                        ║");
        System.out.println("║   INVICTA É LIVRE.                           ║");
        System.out.println("║                                              ║");
        System.out.println("╚══════════════════════════════════════════════╝");

        pausa();
        fala("Amity", "Acabou.");
        pausa();
        fala("Líder Thorn", "A floresta cantará seu nome, Amity.");
        pausa();
        fala("Líder Voss", "A cidade construirá monumentos para esta vitória.");
        pausa();
        fala("Líder Kael", "O deserto nunca esquece seus guerreiros.");
        pausa();

        System.out.println("\n  Com os três clãs unidos, Amity assumiu a liderança");
        System.out.println("  de Invicta — não como conquistadora, mas como costureira.");
        System.out.println("  Pela primeira vez em décadas, as nações respiraram livres.");

        System.out.println("\n══════════════════════════════════════════════");
        System.out.println("  ESTATÍSTICAS FINAIS");
        System.out.println("══════════════════════════════════════════════");
        System.out.println("  Nível alcançado   : " + level);
        System.out.println("  XP total          : " + xp + " / " + xpParaProximoNivel);
        System.out.println("  Diplomacia total  : " + pontosDiplomacia + " pts");
        System.out.println("  HP restante       : " + hp);
        System.out.println("  Bandagens sobrando: " + bandagens);
        if (armaAtual != null)
            System.out.println("  Arma utilizada    : " + armaAtual.nome);
        System.out.println("══════════════════════════════════════════════");
        System.out.println("\n  FIM DE COSTURA DE NAÇÕES");
        System.out.println("  Obrigado por jogar!\n");
    }
}
