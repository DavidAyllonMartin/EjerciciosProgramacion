/**
 * Examen primera evaluación de programación de 1º de DAM/DAW
 *
 * @version 1.0
 * @author: David Ayllón Martín
 * @date: 21-11-2021
 */

import java.util.Scanner;

public class Examen1Evaluacion {
    // Variables EJERCICIO 4 Aquí.

    static Scanner read = new Scanner(System.in);


    public static void main(String[] args) {
        // EJERCICIO 04 Llamar en el bucle a las funciones del juego.

        dados();

    } // Fin main


    // EJERCICIO 1
    // funcion que recibe un número, si es par imprime "Par" y si es impar imprime "Impar"
    public static String parImpar(int numero) {
        /*Definimos una variable String para almacenar las cadenas de texto "Par" o "Impar" y así poder
        devolverla en el return */
        String parImpar;
        if (numero % 2 == 0) //Si el resto de la división entre dos es 0 el número será par
            parImpar = "Par"; //Cuando la condición es verdadera almacenamos "Par" en nuestra variable
        else parImpar = "Impar"; //De lo contrario almacenamos "Impar"

        return parImpar; //Devolvemos la variable que hemos creado y que tiene almacenada la información

    }

    // EJERCICIO 2 a
    // funcion que comprueba si una hora es correcta
    public static boolean horaCorrecta(int hora, int minuto, int segundo) {
        /*
        Establecemos los límites de nuestras variables en el propio return para simplificar el método.
        Se comprueba que la hora esté entre 0 y 23 con "hora>=0 && hora<24"
        Se comprueba que los minutos estén entre 0 y 59 con "minuto>=0 && minuto<60"
        Se comprueba que los segundos estén entre 0 y 59 con "segundo>=0 && segundo<60"
        Y los combinamos todos con operadores lógicos and para que devuelva true cuando todas sean correctas
        y false cuando alguna esté fuera de los límites establecidos
        */
        return (hora >= 0 && hora < 24 && minuto >= 0 && minuto < 60 && segundo >= 0 && segundo < 60);
    }

    // EJERCICIO 2 b
    // funcion que suma dos horas y devuelve el resultado en un String con formato hh:mm:ss
    // si el formato de la hora, minuto o segundo es incorrecto devolverá "Hora incorrecta"
    public static String sumarHoras(int hora1, int minuto1, int segundo1, int hora2, int minuto2, int segundo2) {

        //Creamos tres variables enteras para almacenar la suma de las horas, minutos y segundos y las inicializamos
        int h, m, s;
        if (horaCorrecta(hora1, minuto1, segundo1) && horaCorrecta(hora2, minuto2, segundo2)) {
            h = hora1 + hora2;
            m = minuto1 + minuto2;
            s = segundo1 + segundo2;

            if (s >= 60) {
                m += s / 60;
                s = s % 60;
            }
            if (m >= 60) {
                h += m / 60;
                m = m % 60;
            }
            //hora = hora % 24;
            while (h >= 24) {
                h -= 24;
            }
            return String.format("%02d:%02d:%02d", h, m, s);
        } else return "Hora incorrecta";
    }

    // EJERCICIO 3
    // Función sumaPrimos  que devuelve la suma de todos los primeros números primos
    public static int sumaPrimos(int num) {
        int suma = 0, n = 0, primo = 2;
        for (int i = 1; i <= num; i++) {
            do {
                if (esPrimo(primo)) {
                    suma += primo;
                    n++;
                }
                primo++;
            } while (n != i);
        }
        return suma;

    } //Fin sumaPrimos

    // Función esPrimo que devuelve true si el número es primo y false en caso contrario.
    public static boolean esPrimo(int num) {
        if (num <= 1)
            return false;
        else {
            for (int i = 2; i <= (num / 2); i++) {
                if (num % i == 0)
                    return false;
            }
            return true;
        }

    } //Fin esPrimo


    // EJERCICIO 4
    // Implementar debajo las funciones  turno, tirarDados, comprobarDados,
    // sumarPremio y escribirResultado.

    public static void dados() {
        boolean turno = true;
        char tirada = 'a';
        int dado1, dado2, dado3, premio, puntosHumano = 0, puntosOrdenador = 0;

        do {
            if (turno) {
                System.out.println("Es tu turno, pulsa Q para terminar o pulsa otra letra para efectuar tu tirada:");
                tirada = read.next().toUpperCase().charAt(0);

            } else System.out.println("Es mi turno");

            if (tirada != 'Q') {
                dado1 = (int) (Math.random() * 5 + 1);
                dado2 = (int) (Math.random() * 5 + 1);
                dado3 = (int) (Math.random() * 5 + 1);

                System.out.println("La tirada ha sido, " + dado1 + ", " + dado2 + ", " + dado3);
                premio = 0;
                if (dado1 == dado2 || dado1 == dado3) {
                    premio = 10;
                    if (dado1 == dado2 && dado2 == dado3) {
                        if (dado1 == 6)
                            premio = 60;
                        else premio = 20;
                    }
                }
                if (turno) {
                    puntosHumano += premio;
                    turno = false;
                } else {
                    puntosOrdenador += premio;
                    turno = true;
                }
            }

        } while (tirada != 'Q');

        System.out.println("Tu puntuación final: " + puntosHumano);
        System.out.println("Mi puntuación final: " + puntosOrdenador);

        if (puntosHumano > puntosOrdenador) {
            System.out.println("Has ganado. ¡Enhorabuena!");
        } else if (puntosHumano < puntosOrdenador) {
            System.out.println("Te he ganado, inténtalo en otra ocasión.");
        } else System.out.println("Hemos empatado. Intenta ganarme otro día.");

    } //Fin dados

} // Fin de la clase Main



