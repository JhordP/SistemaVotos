package program;
import java.util.Scanner;

public class Votacion extends Votos { //Clase hija de Votos.java
    //Atributos de la clase
    private static int cantVotos;
    private static int cantVotosH;
    private static int cantVotosM;
    private int indexCand;
    private int mayorVotos = 0;
    Scanner input;

    //Constructor
    public Votacion(String candidatos[]) {
        super(candidatos);
        input = new Scanner(System.in);
    }

    //GET & SET
    public int getCantVotos() {
        return Votacion.cantVotos;
    }
    public void setCantVotos(int cantVotos) {
        Votacion.cantVotos = cantVotos;
    }

    public int getCantVotosH() {
        return Votacion.cantVotosH;
    }
    public void setCantVotosH(int cantVotosH) {
        Votacion.cantVotosH = cantVotosH;
    }

    public int getCantVotosM() {
        return Votacion.cantVotosM;
    }
    public void setCantVotosM(int cantVotosM) {
        Votacion.cantVotosM = cantVotosM;
    }

    //Metodo principal de la clase
    public void votar() {
        System.out.println("\nCandidatos disponibles:");
        System.out.println(super.toString());

        System.out.println("¿Por cual candidato vas a votar?");
        var eleccion = input.nextInt();

        if(eleccion < 1 || eleccion > this.acumVotos.length) {
            System.out.println("Opcion incorrecta.");
            votar();
        }
        else if (eleccion > 0 && eleccion <= this.acumVotos.length) {
            ++acumVotos[eleccion-1];
            ++cantVotos;
        }
        
        votosPorGenero(); //Linea 74

        //Bucle recursivo
        System.out.println("Seguir votando?");
        var selec = input.nextInt();
        if (selec == 1) {
            votar();
        }
        
        //Forma automatizada de encontrar un numero mayor que otro sin importar la cantidad en el array.
        for(int i=0; i < this.acumVotos.length; i++){
            if(this.acumVotos[i]>mayorVotos){ // 
                mayorVotos = acumVotos[i];
                indexCand = i;
            }
        }
    }

    private void votosPorGenero() {
        System.out.println("Indique su genero.\n1)Hombre\n2)Mujer");
        var genero = input.nextInt();

        if(genero == 1 || genero == 2) {
            if(genero == 1) ++cantVotosH;
            else ++cantVotosM;
        }
        else { System.out.println("Opcion invalida"); votosPorGenero(); }
    }

    private void porcentajeCandidatos() {

        Double unidad = 100 / Double.parseDouble(String.valueOf(Votacion.cantVotos));
        Double porcentaje[] = new Double[this.candidatos.length];
        for (int i=0; i < this.acumVotos.length; i++) {
            porcentaje[i] = (acumVotos[i]*unidad); 
        }
        for (int i=0; i<porcentaje.length;i++) {
            System.out.println(this.candidatos[i]+" "+String.valueOf(Math.round((porcentaje[i])*100.0)/100.0)+"%"); //Redondear a 2 digitos.
        }
    }

    //Data obtenida
    public void mostrarDatos() {
        StringBuilder sb = new StringBuilder();
        sb.append("Cantidad de votos totales: "+cantVotos)
          .append("\nCantidad de votos por genero:\t"+"Cantidad hombres: "+getCantVotosH()+"\tCantidad mujeres: "+getCantVotosM())
          .append("\nCandidato con mayor votos: "+this.candidatos[this.indexCand]+"Con "+ this.mayorVotos);
        System.out.println(sb.toString());
        System.out.println("Porcentajes:\n");
        porcentajeCandidatos();
    }

}
