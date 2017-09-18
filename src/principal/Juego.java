package principal;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Beth
 */
//Creamos la clase Juego
public class Juego {

    /*declaramos las variables y el creamos el objeto SC de la clase scanner y R de clase 
    random y el objeto de P de la clase persona
     */
    int JugadaPersona = 0;
    int JugadaCompu = 0;
    String JugadaTextoPersona;
    String JugadaTextoCompu;

    Random R = new Random(2);
    Scanner Sc = new Scanner(System.in);
    //creamos el objeto persona
    Persona P = new Persona();

    //Creamos el metodo jugar de la clase Juego
    public void Jugar() {

        /*declaramos variables locales para el metodo jugar e imprimimos los
        mensajes que saldran al inicio del juego, llamamos a los metodos
        solicitarDatosPersona  y mostrarDatosPersona de la clase persona 
        utilizando el objeto P
         */
        int contador = 1;
        System.out.println("****************************************");
        System.out.println("\tPIEDRA,PAPEL O TIJERA\n");

        P.solicitarDatosPersona();

        System.out.println("\tCOMIENZA EL JUEGO!\n");

        System.out.println("\tJUGADOR\n");

        P.mostrarDatosPersona();

        //iniciamos el ciclo donde se inicia la ronda del juego
        while (contador <= 3) {

            System.out.println("\t(RONDA " + contador + ")");
            System.out.println("Seleccione su jugada escribiendo un numero:");
            System.out.println("0:PIEDRA");
            System.out.println("1:PAPEL");
            System.out.println("2:TIJERA");

            /*creamos una variable local donde tomara el valor ingresado por el
            jugador
             */
            int Opcion = Sc.nextInt();

            /*despues de obtener la opcion, con el swich obtendremos el valor en 
            texto el cual guardaremos en la variable global JugadaTextoPersona
             */
            switch (Opcion) {

                case 0:
                    JugadaTextoPersona = "PIEDRA";
                    break;
                case 1:
                    JugadaTextoPersona = "PAPEL";
                    break;
                case 2:
                    JugadaTextoPersona = "TIJERA";
                    break;
            }

            ImprimirJugadaenLetras();

            /*creamos un condicional donde se colocaran las condiciones del juego
            para saber en que momento ganada la persona o el computador            
             */
            if (JugadaTextoPersona == "PIEDRA" && JugadaTextoCompu == "TIJERA") {

                JugadaPersona = JugadaPersona + 1;

            } else if (JugadaTextoPersona == "PAPEL" && JugadaTextoCompu == "PIEDRA") {

                JugadaPersona = JugadaPersona + 1;

            } else if (JugadaTextoPersona == "TIJERA" && JugadaTextoCompu == "PAPEL") {

                JugadaPersona = JugadaPersona + 1;

            } else if (JugadaTextoPersona == "TIJERA" && JugadaTextoCompu == "PIEDRA") {

                JugadaCompu = JugadaCompu + 1;

            } else if (JugadaTextoPersona == "PIEDRA" && JugadaTextoCompu == "PAPEL") {

                JugadaCompu = JugadaCompu + 1;

            } else if (JugadaTextoPersona == "PAPEL" && JugadaTextoCompu == "TIJERA") {

                JugadaCompu = JugadaCompu + 1;

            }
            /*en esta linea incrementamos el valor del contador mas 1, es el que me 
            determina las rondas  del juego*/

            contador++;

        }

        BuscarelImprimrGanadorFinal();

    }

    //Creamos el metodo GenerarJuegoComputador de la clase Juego
    public void GenerarJuegoComputador() {

        /*creamos una variable local donde tomara el valor obtenido aleatoriamente
        por la computadora
         */
        int OpcionPC = R.nextInt(3);
        /*despues de obtener la opcionPC, con el swich obtendremos el valor en 
         texto el cual guardaremos en la variable global JugadaTextoCompu
         */

        switch (OpcionPC) {

            case 0:
                JugadaTextoCompu = "PIEDRA";
                break;
            case 1:
                JugadaTextoCompu = "PAPEL";
                break;
            case 2:
                JugadaTextoCompu = "TIJERA";
                break;

        }

    }
    //Creamos el metodo ImprimirJugadaenLetras de la clase Juego

    public void ImprimirJugadaenLetras() {

        /*invocamos el metodo GenerarJuegoComputador de la clase juego el 
        cual nos devuelve la jugada generada aleatoriamente por el computador*/
        GenerarJuegoComputador();

        System.out.println("=====");
        System.out.println("Jugada Persona: " + JugadaTextoPersona);
        System.out.println("Jugada Compu: " + JugadaTextoCompu);
        System.out.println("=====");

        /*creamos un condicional para generar la opcion del empate entre jugador 
        y la computadora*/
        if (JugadaTextoPersona == JugadaTextoCompu) {

            System.out.println("EMPATE");
        }

    }

    /*Creamos el metodo BuscarelImprimrGanadorFinal de la clase Juego para imprimir
    los datos del ganador y su resultado o en caso de un empate*/
    public void BuscarelImprimrGanadorFinal() {

        System.out.println("\t----------------------GANADOR----------------------");

        if (JugadaPersona < JugadaCompu) {
            System.out.println("COMPUTADOR");
            System.out.println("Número de aciertos: " + JugadaCompu);
        } else if (JugadaPersona > JugadaCompu) {

            System.out.println("PERSONA");
            System.out.println("Número de aciertos: " + JugadaPersona);
        } else {

            System.out.println("HA OCURRIDO UN EMPATE");

        }

    }
}
