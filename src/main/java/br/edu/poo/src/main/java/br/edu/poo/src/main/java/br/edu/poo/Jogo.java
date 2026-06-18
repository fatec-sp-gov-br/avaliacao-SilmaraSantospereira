package br.edu.poo;

public class Jogo {
    public static void main(String[] args) {
        System.out.println("=== BATALHA INICIADA ===\n");

        Personagem artemis = new Personagem("Artemis", 35, 12, 6);
        Personagem goblin = new Personagem("Goblin", 20, 9, 4);
        Pocao pocaoPequena = new Pocao("Poção Pequena", 10);

        boolean goblinUsouPocao = false;

        while (artemis.estaVivo() && goblin.estaVivo()) {
            
            System.out.println(artemis.getNome() + " ataca " + goblin.getNome());
            artemis.atacar(goblin);
            System.out.println(goblin.getNome() + " possui " + goblin.getVida() + " de vida\n");

            if (!goblin.estaVivo()) {
                break; 
            }

            if (goblin.getVida() <= 14 && !goblinUsouPocao) {
                System.out.println(goblin.getNome() + " usa " + pocaoPequena.getNome());
                goblin.usarPocao(pocaoPequena);
                goblinUsouPocao = true;
                System.out.println(goblin.getNome() + " possui " + goblin.getVida() + " de vida\n");
            } else {
                System.out.println(goblin.getNome() + " ataca " + artemis.getNome());
                goblin.atacar(artemis);
                System.out.println(artemis.getNome() + " possui " + artemis.getVida() + " de vida\n");
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
