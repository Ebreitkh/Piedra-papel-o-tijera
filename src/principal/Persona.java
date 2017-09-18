package principal;

import java.util.Scanner;

/**
 *
 * @author Beth
 */
//Creamos la clase persona
public class Persona {

    //declaramos las variables y el creamos el objeto SC de la clase scanner
    String Alias, Correo;
    Scanner Sc = new Scanner(System.in);

    //Creamos el metodo solicitarDatosPersona
    public void solicitarDatosPersona() {

        //pedimos que el usuario ingreso los datos para leerlos por teclado
        System.out.println("Escriba un alias: ");
        Alias = Sc.next();
        System.out.println("Escriba su correo: ");
        Correo = Sc.next();

    }

    //Creamos el metodo mostrarDatosPersona
    public void mostrarDatosPersona() {

        //imprimimos los datos que el usuario ingreso
        System.out.println(Alias + " - " + Correo);

    }
}
