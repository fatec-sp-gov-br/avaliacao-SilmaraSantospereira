package br.edu.poo;

public class Jogo {
    public static void main(String[] args) {
        System.out.println("=== BATALHA INICIADA ===\n");

        Personagem artemis = new Personagem("Artemis", 35, 12, 6);
        Personagem goblin = new Personagem("Goblin", 20, 9, 4);
        Pocao pocaoPequena = new Pocao("Poção Pequena", 10);

        boolean goblinUsouPocao = false;

        while (artemis.estaVivo() && goblin.estaVivo()) {
            
            artemis.atacar(goblin);

            if (!goblin.estaVivo()) {
                break; 
            }

            if (goblin.getVida() <= 14 && !goblinUsouPocao) {
                goblin.usarPocao(pocaoPequena);
                goblinUsouPocao = true;
            } else {
                goblin.atacar(artemis);
            }
        }

        System.out.println("=== FIM DA BATALHA ===\n");

        if (artemis.estaVivo()) {
            System.out.println("Vencedor: " + artemis.getNome());
        } else {
            System.out.println("Vencedor: " + goblin.getNome());
        }
    }
}
