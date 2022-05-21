package test;
import program.Votacion;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        var input = new Scanner(System.in);

        System.out.println("Coloque el numero de candidatos a agregar.");
        var cantCandidatos = input.nextInt();
        String candidatos[] = new String[cantCandidatos];

        //Buffered reader porque el nextLine del scanner no me sirve dentro del loop.
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        for(int i= 0; i < cantCandidatos; i++) {
            System.out.println("Agregue un candidato");
            candidatos[i] = reader.readLine();
        }

        Votacion votacion = new Votacion(candidatos);
        votacion.votar();
        //System.out.println();
        votacion.mostrarDatos();

        input.close();
    }
}
