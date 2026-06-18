package br.edu.poo;

public class Personagem {
    private String nome;
    private int vida;
    private int ataque;
    private int defesa;
    private boolean pocaoUtilizada;

    public Personagem(String nome, int vida, int ataque, int defesa) {
        this.nome = nome;
        this.vida = vida;
        this.ataque = ataque;
        this.defesa = defesa;
        this.pocaoUtilizada = false;
    }

    public void atacar(Personagem inimigo) {
        int dano = this.ataque - inimigo.defesa;
        
        if (dano < 1) {
            dano = 1;
        }
        
        System.out.println(this.nome + " ataca " + inimigo.getNome());
        inimigo.receberDano(dano);
        System.out.println(inimigo.getNome() + " possui " + inimigo.getVida() + " de vida\n");
    }

    public void receberDano(int dano) {
        this.vida -= dano;
        
        if (this.vida < 0) {
            this.vida = 0;
        }
    }

    public void usarPocao(Pocao pocao) {
        if (!this.pocaoUtilizada) {
            this.vida += pocao.getCura();
            this.pocaoUtilizada = true;
            
            System.out.println(this.nome + " usa " + pocao.getNome());
            System.out.println(this.nome + " possui " + this.vida + " de vida\n");
        }
    }

    public boolean estaVivo() {
        return this.vida > 0;
    }

    public String getNome() {
        return nome;
    }

    public int getVida() {
        return vida;
    }
}
