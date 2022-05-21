package program;

public class Votos {
    //Atributos
    private int numCandidato[];
    protected String candidatos[];
    protected int acumVotos[];

    public Votos(String... candidatos) {

        this.candidatos = new String[candidatos.length];
        this.acumVotos = new int[candidatos.length];
        this.numCandidato = new int[candidatos.length];
        for (int i = 0; i < candidatos.length; i++) {
            this.candidatos[i] = candidatos[i];
            this.numCandidato[i] = i+1;
        }

    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < candidatos.length; i++) {
            stringBuilder.append("\n").append(numCandidato[i]+") "+candidatos[i]);
        }
        return stringBuilder.toString();
    }
}
