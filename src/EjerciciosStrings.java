import java.util.ArrayList;
import java.util.Arrays;

public class EjerciciosStrings {


    /* Escriba la función int contarCaracteresNoNumericos(String cadena) que recibe una cadena y devuelva cuántos
    caracteres no numéricos hay. */
    public static int contarCaracteresNoNumericos(String cadena) {
        int cuenta = 0;
        for (int i = 0; i < cadena.length(); i++) { //Bucle for para recorrer todos los caracteres de la cadena
            for (int j = 0; j <= 9; j++) {
                /* Convertimos j, que va a tomar todos los valores numéricos, en un caracter con String.valueOf para
                poder compararlo con los caracteres de nuestra cadena */
                if (cadena.charAt(i) == String.valueOf(j).charAt(0)) {
                    cuenta++; //Si el caracter es numérico, añadimos uno a nuestra variable cuenta y rompemos el bucle.
                    break;
                }
            }
        }
        return cadena.length() - cuenta; //Devolvemos la longitud de la cadena menos la cantidad de caracteres numéricos
    }

    public static int contarCaracteresNoNumericos2(String cadena) {
        //Partimos del total de caracteres para restar los numéricos
        int cuenta = cadena.length();
        //Bucle for para recorrer la cadena
        for (int i = 0; i < cadena.length(); i++) {
            //Cuando el caracter sea un dígito quitamos uno de la cuenta
            if (Character.isDigit(cadena.charAt(i)))
                cuenta--;
        }
        return cuenta;
    }

    /* Escriba la función boolean todosNumericos(String cadena) que nos dirá si la cadena contiene todos los caracteres
     numéricos o no. */

    public static boolean todosNumericos(String cadena) {
        String numeros = "0123456789"; //Definimos una cadena que tenga todos los caracteres numéricos
        for (int i = 0; i < cadena.length(); i++) { //Bucle que recorre todos los caracteres de la cadena
            String caracter = Character.toString(cadena.charAt(i)); //Convertimos el caracter que toque en un string para poder utilizar .contains
            if (!(numeros.contains(caracter))) { //Si la cadena numeros no tiene el caracter significa que ese caracter no es numérico asi que devolvemos false
                return false;
            }
        }
        return true; //Si pasa el bucle completo sin devolver false significa que todos son numéricos, así que devuelvo true
    }

    public static boolean todosNumericos2(String cadena) {
        for (int i = 0; i < cadena.length(); i++) {
            if (!Character.isDigit(cadena.charAt(i)))
                return false;
        }
        return true;
    }

    // Escriba la función String eliminarVocales(String cadena) que eliminará todas las vocales de la cadena.

    public static String eliminarVocales(String cadena) {
        StringBuilder cadenaSinVocales = new StringBuilder(); //Definimos un StringBuilder para ir construyendo nuestra nueva cadena
        String vocales = "AEIOUaeiou"; //Definimos una cadena que tenga todas las vocales, tanto en mayúsculas como en minúsculas (no incluímos caracteres acentuados por simplificar)
        for (int i = 0; i < cadena.length(); i++) { //Bucle que recorre todos los caracteres de la cadena
            String caracter = Character.toString(cadena.charAt(i)); //Convertimos el caracter que toque en un string para poder utilizar .contains
            if (!(vocales.contains(caracter))) { //Si el caracter no está entre las vocales lo añadimos al final de nuestro StringBuilder. De esta manera lo vamos creando sin añadir vocales
                cadenaSinVocales.append(caracter);
            }
        }
        return cadenaSinVocales.toString(); //Devolvemos el StringBuilder convertido en String
    }

    //Escriba la función int contarVocales(String palabra) que devuelva el número de vocales de la cadena.

    public static int contarVocales(String palabra) {
        int conteo = 0;
        String vocales = "AEIOUaeiou"; //Definimos una cadena que tenga todas las vocales, tanto en mayúsculas como en minúsculas (no incluímos caracteres acentuados por simplificar)
        for (int i = 0; i < palabra.length(); i++) { //Bucle que recorre todos los caracteres de la cadena
            String caracter = Character.toString(palabra.charAt(i)); //Convertimos el caracter que toque en un string para poder utilizar .contains
            if (vocales.contains(caracter)) { //Si es una vocal, añadimos 1 a la cuenta
                conteo++;
            }
        }
        return conteo; //Devolvemos la cuenta
    }

    /* Escriba la función String piedraPapelTijera(String jugada1, String jugada2) que reciba dos cadenas con una
    jugada “piedra”, “papel” o “tijera” y devuelva:
        "¡Gano el jugador 1!"
        "¡Gano el jugador 2!"
        "¡Empate!" */

    public static String piedraPapelTijera(String jugada1, String jugada2) {
        //Establecemos constantes para guardar las posibles jugadas y los posibles mensajes de salida para que sea más sencillo hacer modificaciones a futuro
        final String PIEDRA = "piedra";
        final String PAPEL = "papel";
        final String TIJERA = "tijera";
        final String EMPATE = "¡Empate!";
        final String JUGADOR1 = "¡Ganó el jugador 1!";
        final String JUGADOR2 = "¡Ganó el jugador 2!";
        final String ERROR = "Las jugadas introducidas no son correctas";


        //Declaramos un String vacío que será el que devuelva la función después de procesar toda la información
        String salida = "";

        //Modificamos los datos de entrada para eliminar espacios al principio y al final y unificar poniéndolo en minúsculas
        jugada1 = jugada1.trim().toLowerCase();
        jugada2 = jugada2.trim().toLowerCase();

        //Aplicamos en un switch toda la lógica del juego y asignamos las salidas correspondientes según las jugadas.
        switch (jugada1) {
            case PIEDRA:
                if (jugada2.equals(PIEDRA))
                    salida = EMPATE;
                if (jugada2.equals(PAPEL))
                    salida = JUGADOR2;
                if (jugada2.equals(TIJERA))
                    salida = JUGADOR1;
                break;

            case PAPEL:
                if (jugada2.equals(PIEDRA))
                    salida = JUGADOR1;
                if (jugada2.equals(PAPEL))
                    salida = EMPATE;
                if (jugada2.equals(TIJERA))
                    salida = JUGADOR2;
                break;

            case TIJERA:
                if (jugada2.equals(PIEDRA))
                    salida = JUGADOR2;
                if (jugada2.equals(PAPEL))
                    salida = JUGADOR1;
                if (jugada2.equals(TIJERA))
                    salida = EMPATE;
                break;

            //En caso de que se hayan introducido jugadas que no sean válidas mostramos un mensaje de error
            default:
                salida = ERROR;
        }
        return salida;
    }

    //Escriba la función String cadenaDelReves(String cadena) que nos devuelva la cadena del revés.

    public static String cadenaDelReves(String cadena) {
        //Creamos un StringBuilder con el String de entrada
        StringBuilder strb = new StringBuilder(cadena);
        //Utilizamos la función reverse para darle la vuelta
        strb.reverse();
        //Guardamos el StringBuilder en la variable inicial convirtiéndolo en un String
        cadena = strb.toString();
        return cadena;
    }

    /* Crea la función int puntuacionScrabble(String palabra) que devolverá la puntuación que tendría en el Scrabble:

    Letra                          		Valor
    A, E, I, O, U, L, N, R, S, T       	1
    D, G                              	2
    B, C, M, P                         	3
    F, H, V, W, Y                      	4
    K                                  	5
    J, X , Ñ                            8
    Q, Z                               	10

     */

    public static int puntuacionScrabble(String palabra) {
        //Declaramos una variable puntos para acumular los distintos puntos que dan las letras
        int puntos = 0;
        //Quitamos espacios y ponemos en mayúsculas
        palabra = palabra.trim().toUpperCase();
        //Bucle para recorrer todos los caracteres de la palabra
        for (int i = 0; i < palabra.length(); i++) {
            //Switch con las puntuaciones que da cada letra
            switch (palabra.charAt(i)) {
                case 'A':
                case 'E':
                case 'I':
                case 'O':
                case 'U':
                case 'L':
                case 'N':
                case 'R':
                case 'S':
                case 'T':
                    puntos += 1;
                    break;

                case 'D':
                case 'G':
                    puntos += 2;
                    break;

                case 'B':
                case 'C':
                case 'M':
                case 'P':
                    puntos += 3;
                    break;

                case 'F':
                case 'H':
                case 'V':
                case 'W':
                case 'Y':
                    puntos += 4;
                    break;

                case 'K':
                    puntos += 5;
                    break;

                case 'J':
                case 'X':
                case 'Ñ':
                    puntos += 8;
                    break;

                case 'Q':
                case 'Z':
                    puntos += 10;
                    break;
            }
        }
        return puntos;
    }

    /* Resuelve el horror de los teclados no estandarizados proporcionando la función String ordenadorAmovil(String numero)
    que convierte la entrada del ordenador en un número como si estuviera escrito en un móvil. */

    public static String ordenadorAMovil(String numero) {
        //Creamos un StringBuilder para ir generando el nuevo número
        StringBuilder strb = new StringBuilder();
        //Un bucle para recorrer todos los caracteres de la cadena de entrada
        for (int i = 0; i < numero.length(); i++) {
            char c = numero.charAt(i);
            //Este switch cambia los números en conflicto en función del caso que vaya leyendo cuando es necesario
            switch (c) {
                case '1':
                    strb.append('7');
                    break;
                case '2':
                    strb.append('8');
                    break;
                case '3':
                    strb.append('9');
                    break;
                case '7':
                    strb.append('1');
                    break;
                case '8':
                    strb.append('2');
                    break;
                case '9':
                    strb.append('3');
                    break;
                default:
                    strb.append(c);
            }
        }
        //Reconvertimos a String
        numero = strb.toString();
        return numero;
    }

    /* Escriba la función String [] ordenarAlfabeticamente(String [] palabras) que recibe un array de palabras y debe
    devolver el array en orden alfabético ascendente. */

    public static String[] ordenarAlfabeticamente(String[] palabras) {
        Arrays.sort(palabras);
        return palabras;
    }

    //Escriba la función boolean capicua(int numero) que devuelve si el número entero es capicúa o no

    public static boolean capicua(int numero) {
        //Creamos una variable boolean para guardar la información de si es capicua o no
        boolean capicua = false;
        //Transformamos el número entero en un String
        String str = Integer.toString(numero);
        //Creamos un StringBuilder que contenga la información del String anterior para poder manipularlo
        StringBuilder strb = new StringBuilder(str);
        //Le damos la vuelta al StringBuilder, lo volvemos a convertir en un String y a su vez lo convertimos
        // otra vez en un entero para almacenarlo en nuestra variable numeroReves
        int numeroReves = Integer.parseInt(strb.reverse().toString());
        //Comparamos el número inicial y el número invertido. Si son iguales, cambiamos capicua a true
        if (numero == numeroReves) {
            capicua = true;
        }
        return capicua;
    }

    /* Escriba la función boolean palindromo(String cadena) que nos diga si es un palíndromo o no. Un palíndromo es
    una palabra o frase que se lee igual hacia adelante que hacia atrás. Para facilitar la codificación se deberán
    introducir las frases sin tildes. Ejemplos:
        La ruta nos aporto otro paso natural.
        Dabale arroz a la zorra el abad.
        Se van sus naves. */

    public static boolean palindromo(String cadena) {
        //Creamos una variable boolean que contenga la información de si es un palíndromo o no y la inicializamos en false
        boolean esPalindromo = false;

        //Eliminamos todos los espacios de la cadena y lo convertimos a minúsculas
        cadena = cadena.replaceAll(" ", "").toLowerCase();

        //Creamos un StringBuilder con el String cadena para poder manipularlo
        StringBuilder strb = new StringBuilder(cadena);

        //Le damos la vuelta al StringBuilder y lo transformamos en un String
        String cadenaReves = strb.reverse().toString();

        //Si la cadena sin espacios y la cadena sin espacios dada la vuelta coinciden, es un palíndromo
        if (cadena.equals(cadenaReves))
            esPalindromo = true;
        return esPalindromo;
    }

    //Escriba la función String palabraMasLarga(String [] palabras) que devuelve la palabra de mayor longitud.

    //Lo he modificado un poquito porque me da TOC que si hay varias palabras con la misma longitud solo guarde la primera
    public static String[] palabraMasLarga(String[] palabras) {
        //Creamos un array de enteros donde guardaremos la longitud de todas las cadenas del array de entrada.
        //Tiene que tener el mismo tamaño que String[] palabras
        int[] longitudes = new int[palabras.length];

        //Con este bucle guardamos en el array de enteros todas las longitudes de todas las cadenas
        for (int i = 0; i < palabras.length; i++) {
            longitudes[i] = palabras[i].length();
        }
        //Ordenamos el array para saber cuál es la longitud más grande de las palabras del array, que se guardará al final del mismo
        Arrays.sort(longitudes);

        //Declaramos un ArrayList de "String" para poder guardar las cadenas cuya longitud sea la mayor
        ArrayList<String> arrayDinamico = new ArrayList<>();

        //Con este bucle foreach recorremos todas las palabras del array, y cuando su longitud coincida con la
        //longitud más grande la añadimos al ArrayList
        for (String i : palabras) {
            if (i.length() == longitudes[longitudes.length - 1])
                arrayDinamico.add(i);
        }

        //Declaramos un array de String que tenga el tamaño del ArrayList
        String[] arrayFinal = new String[arrayDinamico.size()];

        //Con este bucle le añadimos todos los elementos que se han guardado en el ArrayList en el bucle previo
        for (int i = 0; i < arrayDinamico.size(); i++) {
            arrayFinal[i] = arrayDinamico.get(i);
        }
        return arrayFinal;
    }

    /*Escriba la función String unirCadena(String cad1, String cad2). Devolverá las dos palabras entrelazadas,
    empezando por la primera. */

    public static String unirCadena(String cad1, String cad2) {
        return cad1 + cad2;
    }

    /*Escriba la función String obtenerNIF(int dni) que recibe un número de DNI (entero largo sin signo) y retorna un
    string con el número acompañado de su correspondiente letra de NIF (para la obtención de la letra se utiliza el
    string “TRWAGMYFPDXBNJZSQVHLCKE”, cogiendo la letra que ocupa la posición igual al resto de  dividir
    el número de DNI por 23).*/

    //Tenemos un problema aquí. Hay DNIs que empiezan por 0 y si escribo un número que empiece por 0 java lo va a interpretar como octal
    public static String obtenerNIF(int dni) {
        //Declaramos el String letras que contiene todas las posibles letras para un DNI y otro String para almacenar el DNI convertido a String.
        String letras = "TRWAGMYFPDXBNJZSQVHLCKE", str = Integer.toString(dni);

        //Para saber la posición de la letra hay que conseguir el resto del DNI entre 23
        int pos = (dni % 23);

        //Añadimos la letra directamente en el return
        return str + letras.charAt(pos);
    }

    /* Escriba la función boolean esValidoNIF(String nif) que recibe un NIF y retorna si es válido (tiene entre 7 u 8
    números consecutivos y la letra correspondiente. */

    public static boolean esValidoNIF(String nif) {
        //Declaramos una variable booleana para almacenar la información de si el DNI es correcto o no
        boolean valido = false;
        //Quitamos espacios y ponemos en mayúsculas el String de entrada para depurar fallos humanos
        nif = nif.trim().toUpperCase();
        //En un String auxiliar vamos a guardar una subcadena del String de entrada que abarque la cadena entera menos
        //el último caracter, que se corresponde con la letra
        String str = nif.substring(0, nif.length() - 1);
        //Transformamos el String auxiliar en un entero
        int dni = Integer.parseInt(str);
        //Utilizando la función que hemos creado previamente para obtener la letra del DNI, si lo que devuelve con el
        //número y lo que se ha introducido es lo mismo, el DNI es correcto
        if (nif.equals(obtenerNIF(dni)))
            valido = true;

        return valido;
    }

    /*Escriba la función String parrafoMayusculas(String parrafo) Recibe un string con un párrafo y retorna otro con
    la misma frase en la que la primera letra de  todas sus palabras está en mayúscula. */

    public static String parrafoMayusculas(String parrafo) {
        //Metemos el String en un StringBuilder para poder modificarlo
        StringBuilder strb = new StringBuilder(parrafo);
        //Creamos un bucle que recorra todos los caracteres del StringBuilder
        for (int i = 0; i < strb.length(); i++) {
            //Si nos encontramos con un espacio en blanco quiere decir que lo siguiente será una palabra nueva
            if (strb.charAt(i) == ' ') {
                //Seleccionamos el siguiente caracter al espacio en blanco
                char c = strb.charAt(i + 1);
                //Lo metemos en un String auxiliar para pasarlo a mayúsculas porque para caracteres no he encontrado una función similar
                String str = String.valueOf(c).toUpperCase();
                //Lo volvemos a pasar a caracter
                c = str.charAt(0);
                //Y sustituimos el caracter inicial por su homónimo en mayúsculas
                strb.setCharAt(i + 1, c);
            }
        }
        return strb.toString();
    }


    public static void main(String[] args) {

        System.out.println(parrafoMayusculas("Escriba la función String parrafoMayusculas(String parrafo) Recibe un string con un párrafo y retorna otro con\n" +
                "    la misma frase en la que la primera letra de  todas sus palabras está en mayúscula."));

        /* if (args.length>0){
            imprimirArrayString(args);
        } */

    }//Fin Main

    public static void imprimirArrayString(String[] array) {
        for (String i : array) {
            System.out.println(i);
        }
    }
} //Fin clase
