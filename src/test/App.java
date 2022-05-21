package test;
import program.Votacion;

//Importar librerias de input
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        var input = new Scanner(System.in);

        //Recibir la cantidad de candidatos que se va a postular
        System.out.println("Coloque el numero de candidatos a agregar.");
        var cantCandidatos = input.nextInt();
        String candidatos[] = new String[cantCandidatos];

        //Buffered reader porque el nextLine del scanner no me sirve dentro del loop.
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        //Colocar los nombres de los candidatos
        for(int i= 0; i < cantCandidatos; i++) {
            System.out.println("Escriba el nombre del candidato");
            candidatos[i] = reader.readLine();
        }

        Votacion votacion = new Votacion(candidatos);
        votacion.votar(); //Utilizar el metodo principal de la clase.
        votacion.mostrarDatos(); //Mostrar la data obtenida.

        input.close();
    }
}
