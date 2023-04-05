import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class EjerciciosArrays {

    static Scanner read = new Scanner(System.in);

    /* Escribe la función void rellenarArray(int [] numeros) que pedirá al usuario que introduzca números hasta que el
    array esté completo. (declarar un array previamente en el main para probarlo) */
    public static void rellenarArray(int[] numeros) {
        //Mensaje para mostrar la cantidad de números que hay que introducir
        System.out.format("Introduce un array de %d elementos \n", numeros.length);
        //Bucle para recorrer el array, leer enteros e introducirlos en las distintas posiciones del array
        for (int i = 0; i < numeros.length; i++) {
            System.out.format("Número[%d]=", i);
            numeros[i] = read.nextInt();
        }
    }

    //Escriba la función void imprimirArrayInt(int [] numeros) que imprima en la consola los números del array.
    public static void imprimirArrayInt(int[] numeros) {
        for (int numero : numeros) {
            System.out.print(numero + " ");
        }
    }

    public static void imprimirArrayChar(char[] caracteres) {
        for (char c : caracteres) {
            System.out.println(c);
        }
    }

    public static void imprimirMatrizInt(int[][] array) {
        //Bucle foreach para acceder a los arrays dentro del array
        for (int[] enteros : array) {
            //Otro bucle foreach para acceder a los enteros dentro de cada array e imprimirlos seguidos de un espacio
            for (int i : enteros) {
                System.out.print(i + " ");
            }
            //Salto de línea para organizar por filas los arrays en pantalla
            System.out.println();
        }
    }

    public static void imprimirMatrizString(String[][] array) {
        //Bucle foreach para acceder a los arrays dentro del array
        for (String[] Strings : array) {
            //Otro bucle foreach para acceder a los Strings dentro de cada array e imprimirlos seguidos de un espacio
            for (String str : Strings) {
                System.out.print(str + " ");
            }
            //Salto de línea para organizar por filas los arrays en pantalla
            System.out.println();
        }
    }

    public static void rellenarArrayAleatorio(int[] numeros, int max) {
        //Bucle for para recorrer el array
        for (int i = 0; i < numeros.length; i++)
            //En cada posición asignamos un número aleatorio desde el 1 hasta el máximo que hayamos elegido
            numeros[i] = (int) (Math.random() * max + 1); //Math.random devuelve un double así que hay que forzar que lo guarde como entero
    }

    public static void rellenarMatrizAleatorio(int[][] numeros, int max) {
        //Bucle for para recorrer el array
        for (int i = 0; i < numeros.length; i++)
            for (int j = 0; j < numeros[0].length; j++) {
                numeros[i][j] = (int) (Math.random() * max + 1); //Math.random devuelve un double así que hay que forzar que lo guarde como entero
            }
        //En cada posición asignamos un número aleatorio desde el 1 hasta el máximo que hayamos elegido
    }

    // Realizar la función char [] quiniela() que genere una quiniela de 15 resultados con valores aleatorios 1, X o 2.
    public static char[] rellenarQuiniela() {
        //Declaramos un array para almacenar 15 caracteres
        char[] quiniela = new char[15];
        //Bucle de 15 iteraciones
        for (int i = 0; i < 15; i++) {
            //Número aleatorio entre 1 y 3
            int aleatorio = (int) (Math.random() * 3 + 1);
            //Declaramos variable char
            char resultado;
            //If anidados para relacionar los enteros con caracteres
            if (aleatorio == 1)
                resultado = '1';
            else if (aleatorio == 2)
                resultado = '2';
            else
                resultado = 'X';
            //Guardamos el char en el array
            quiniela[i] = resultado;
        }
        return quiniela;
    }

    // Realizar la función int [] primitiva() que genere una primitiva de 6 números enteros entre el 1 y el 49.
    public static int[] generarPrimitiva() {
        //Declaramos un array de enteros para guardar 6 números
        int[] combinacion = new int[6];
        //Bucle de 6 iteraciones en el que introducimos en el array un número aleatorio del 1 al 49
        for (int i = 0; i < 6; i++) {
            combinacion[i] = (int) (Math.random() * 49 + 1);
            //Como los números no se pueden repetir, creamos un bucle que recorra lo que llevamos introducido y si el
            //nuevo número coincide con uno de los que ya había, restamos uno a la variable i para que repita el proceso
            //y machaque el número repetido
            for (int j = 0; j < i; j++) {
                if (combinacion[i] == combinacion[j])
                    i--;
            }
        }
        //Arrays.sort nos permite ordenar los elementos dentro de un array. Así lo devolvemos ordenado y más bonito
        Arrays.sort(combinacion);
        return combinacion;
    }

    /* Realizar la función String [][] primitiva () Devuelve una matriz con la apuesta aleatoria (seis números enteros
    aleatorios escogidos entre 1 y 49). La matriz deberá contener una matriz de 8 x 49, con los valores que le
    corresponde, sustituyendo los que forman parte de la apuesta por una “X” */
    public static String[][] rellenarPrimitiva(int numeroApuestas) {
        //Declaramos una matriz de 8x49
        String[][] primitiva = new String[8][49];
        //Escapes ANSI para cambiar el color del texto
        final String ROJO = "\u001B[31m";
        final String VOLVER_A_BLANCO = "\u001B[0m";

        //Bucle foreach para recorrer las filas
        for (String[] fila : primitiva) {
            //Bucle para escribir los 49 números en cada fila
            for (int j = 0; j < 49; j++) {
                //Hay que transformar el número entero en un string. A j hay que sumarle 1 porque empezamos desde el 1
                fila[j] = Integer.toString(j + 1);
            }
        }
        //Bucle for para rellenar las apuestas en las filas que nos hayan pedido
        for (int i = 0; i < numeroApuestas; i++) {
            //Generamos una combinación de primitiva con la función que creamos anteriormente
            int[] combinacion = generarPrimitiva();
            //Recorremos la combinación que hemos generado y vamos machacando con una X los valores que toquen
            for (int valor : combinacion) {
                //Ponemos este if para añadirle un espacio a la X si la cifra es de dos dígitos y que quede mejor al sacarlo por pantalla
                if (valor < 10)
                    //Hay que restarle 1 al valor porque la posición en la que se almacena siempre es una menos.
                    //Ejemplo: el 1 se guarda en la posición 0 del array, el 4 se guarda en la posición 3 del array
                    //Le ponemos un poco de color a la X para identificarla mejor en pantalla cuando se imprima
                    primitiva[i][valor - 1] = ROJO + "X" + VOLVER_A_BLANCO;
                else
                    primitiva[i][valor - 1] = ROJO + "X " + VOLVER_A_BLANCO;
            }
        }
        return primitiva;
    }

    // Realizar la función sumaMatrices(int matrizA [][], int matrizB[][]) Que realice la suma de cada matriz
    public static int[][] sumaMatrices(int[][] matrizA, int[][] matrizB) {
        //Guardamos el número de filas y el número de columnas de cada matriz para acceder más fácil a estos datos
        int filasA = matrizA.length, filasB = matrizB.length, columnasA = matrizA[0].length, columnasB = matrizB[0].length;
        //Declaramos una matriz nueva que tenga las mismas dimensiones que, por ejemplo, la matriz A, ya que es
        //condición necesaria para la suma de matrices
        int[][] suma = new int[filasA][columnasA];
        //Hacemos varias comprobaciones que tienen que cumplirse siempre para que se puedan sumar dos matrices.
        //La longitud de las filas de A tiene que ser la misma en todas. Igual para B.
        //Las dimensiones de las dos matrices tienen que ser iguales. Mismo número de filas y mismo número de columnas.
        if (comprobarLongitudFilas(matrizA) && comprobarLongitudFilas(matrizB) && filasA == filasB && columnasA == columnasB) {
            //Dos bucles for anidados para ir accediendo a los distintos elementos de las matrices
            for (int i = 0; i < filasA; i++) {
                for (int j = 0; j < columnasA; j++)
                    //Núcleo de la suma de matrices. Sumamos los elementos que están en la misma posición y colocamos
                    //la suma en esa misma posición de la matriz suma.
                    suma[i][j] = matrizA[i][j] + matrizB[i][j];
            }
        } else
            suma = new int[1][1]; //Como hay que devolver algo y devolver un null podría suponer un problema, devolvemos una matriz de 1x1 con un 0 en ella
        return suma;
    }

    public static boolean comprobarLongitudFilas(int[][] matriz) {
        //Guardamos la longitud de la primera fila de la matriz en una variable
        int dimension = matriz[0].length;
        //Establecemos una variable booleana que nos indicará si todas las filas son iguales o no
        boolean todasIguales = true;
        //Bucle for que recorre todas las filas desde la segunda a la última
        for (int i = 1; i < matriz.length; i++) {
            //Si la longitud de la fila no coincide con la longitud de la primera establecemos todasIguales en false y rompemos el bucle
            if (dimension != matriz[i].length) {
                todasIguales = false;
                break;
            }
        }
        return todasIguales;
    }

    //Realizar la función productoMatrices(int matrizA [][], int matrizB[][]) Que realice el producto de dos matrices
    public static int[][] productoMatrices(int[][] matrizA, int[][] matrizB) {

        //Definimos el número de filas y de columnas de cada matriz para que el programa sea más claro.
        int filasA = matrizA.length, filasB = matrizB.length, columnasA = matrizA[0].length, columnasB = matrizB[0].length;

        // Definimos una matriz para almacenar el producto de las dos matrices dadas. En un producto de matrices con
        // dimensiones filasA x columnasA y filasB x columnasB, para que se pueda realizar el producto se tiene que
        // cumplir la condición columnasA = filasB, y la dimensión de la matriz resultante será filasA x columnasB
        int[][] producto = new int[filasA][columnasB];

       /*
       Como un array bidimensional en realidad es un array de arrays, necesitamos comprobar que todos los arrays
       dentro del array principal tengan la misma longitud. La función booleana comprobarLongitudFilas comprueba que todas
       sean iguales.

       También necesitamos que columnasA == filasB para que se puedan multiplicar así que introducimos esa condición.

       Si esto no se cumple ni nos molestamos en multiplicar las dos matrices.
       */
        if (comprobarLongitudFilas(matrizA) && comprobarLongitudFilas(matrizB) && (columnasA == filasB)) {

            for (int fA = 0; fA < filasA; fA++) { //Este bucle fija la fila de la matriz A
                for (int cB = 0; cB < columnasB; cB++) { //Este bucle fija la columna de la matriz B
                   /*
                   Las siguientes líneas son el núcleo de la multiplicación de matrices.
                   Cada vez que se itera este bucle se resetea la variable suma y nos metemos en otro bucle que va
                   multiplicando los elementos de la fila con los elementos de la columna y los vamos añadiendo en la
                   variable
                    */
                    int suma = 0;
                    for (int cA = 0; cA < columnasA; cA++) {
                        suma += matrizA[fA][cA] * matrizB[cA][cB];
                    }
                    producto[fA][cB] = suma; //Asignamos la variable que hemos sumado en su posición en la matriz producto
                }
            }
        }
       /*
       Como la función tiene que devolver una matriz obligatoriamente, si no se cumplen los parámetros, he introducido
       este else para que devuelva una matriz de una fila y una columna con un 0
       */
        else {
            producto = new int[1][1];
        }
        return producto;
    }

    /* Tenemos un array de booleanos que representa un establo, una oveja en el establo se representa con una celda
    con true y si falta una oveja se representa con false. Implementar la función
    int contarOvejar(Boolean[] matrizOvejas) que reciba una array de booleanos y devuelva cuántas ovejas hay (true). */
    public static int contarOvejas(boolean[] matrizOvejas) {
        //Establecemos una variable para ir llevando la cuenta
        int conteo = 0;
        //Un bucle foreach para recorrer toda la matriz
        for (boolean i : matrizOvejas) {
            //Si hay oveja, es decir, con true, sumamos uno a la cuenta
            if (i)
                conteo++;
        }
        return conteo;
    }

    //Función auxiliar que creé para probar la función contarOvejas
    public static boolean[] rellenarOvejas(int capacidadEstablo) {
        //Creamos un array del tamaño especificado
        boolean[] establo = new boolean[capacidadEstablo];
        //Recorremos el array para ir introduciendo valores
        for (int i = 0; i < capacidadEstablo; i++) {
            //Generamos un número aleatorio entre 1 y 2
            int aleatorio = (int) (Math.random() * 2 + 1);
            //Utilizamos la expresión aleatorio == 1, que es un valor booleano. Se guardará true o false dependiendo
            //del número aleatorio que haya salido
            establo[i] = aleatorio == 1;
        }
        return establo;
    }

    /* Quién no ha cogido alguna vez una flor con pétalos para repetir aquello de me quiere, no me quiere. La idea es
    hacer la función String meQuiereNoMeQuiere(int numeroPetalos) en la que el número de pétalos debe ser al menos 1,
    si es mayor de 5 debe repetirse para que haga esta misma función.
        1 Un poco
        2 Mucho
        3 Apasionadamente
        4 Localmente
        5 Nada de nada
    */
    public static String meQuiereNoMeQuiere(int numeroPetalos) {
        String[] opciones = {"Un poco", "Mucho", "Apasionadamente", "Locamente", "Nada de nada"};
        if (numeroPetalos < 1)
            return "La flor tiene que tener al menos 1 pétalo";
        int i = (numeroPetalos + 4) % 5; /*Le sumo 4 a la variable para ajustar el resto a las posiciones de mi
        array y para no tener que especificar los casos menores que 5. */

        return opciones[i];
    }

    /* Crear la función int obtenerMedia(int[] notas) que devuelva la media de las notas de un alumno redondeado hacia
    abajo (utilizar el método floor de la clase Math). */
    public static int obtenerMedia(int[] notas) {
        int suma = 0;
        for (int i : notas)
            suma += i;
        return (int) (Math.floor(suma) / notas.length);
    }

    /* Escriba la función int [] filtrarPares(int [] numeros) que reciba un array con números y devuelva un nuevo array
    solo con los que sean pares. */
    public static int[] filtrarPares(int[] numeros) {
        //Necesitamos primero comprobar cuántos números pares hay para crear una array del tamaño adecuado
        int conteoPares = 0;
        //Recorremos el array entero y sumamos uno en la variable cada vez que el número sea par
        for (int i : numeros) {
            if (i % 2 == 0)
                conteoPares++;
        }
        //Definimos un array para almacenar todos los números pares que hemos contado
        int[] pares = new int[conteoPares];
        int pos = 0;
        //Bucle foreach para recorrer entero el array e ir metiendo en el array de números pares los que vaya encontrando
        for (int i : numeros) {
            if (i % 2 == 0) {
                pares[pos] = i;
                pos++;
            }
        }
        return pares;
    }

    /* Escriba la función int [] ordenar(int [] numeros) que devuelve el array con los números ordenados
    en orden ascendente. */
    public static int[] ordenar(int[] numeros) {
        //Bucle for para pasar por todos los números del array
        for (int i = 0; i < numeros.length; i++) {
            //Otro bucle para seleccionar todos los siguientes números al seleccionado en el bucle anterior
            for (int j = i + 1; j < numeros.length; j++) {
                //Si el primer número es mayor que el segundo, los intercambiamos para ordenar de menor a mayor
                if (numeros[i] > numeros[j]) {
                    int aux = numeros[j];
                    numeros[j] = numeros[i];
                    numeros[i] = aux;
                }
            }
        }
        return numeros;
    }

    /* Escriba la función int aparicionesNumero(int [] numeros, int numero) que devuelve el número de veces que aparece
    numero en el array. */
    public static int aparicionesNumero(int[] numeros, int numero) {
        int apariciones = 0;
        //Bucle foreach para recorrer el array entero
        for (int i : numeros) {
            //Cuando el número coincida con el que buscamos, aumentamos la variable apariciones en 1 para llevar la cuenta
            if (i == numero)
                apariciones++;
        }
        return apariciones;
    }

    // Realizar la función int menor(int [] array). que devolverá el elemento menor del array
    public static int menor(int[] array) {
        //Ordenamos el array de menor a mayor y seleccionamos el primer elemento
        Arrays.sort(array);
        return array[0];
    }

    /* Escribe la función void busquedaNumeros(int [] numeros) que pedirá al usuario buscar un número introducido por
    teclado y le dirá si ha sido encontrado o no. En el caso en el que haya sido encontrado, le indicará cuántas veces
    se ha introducido. El programa preguntará si quiere seguir buscando más números o no:
    “¿Desea seguir buscando?(s/n)”. */
    public static void busquedaNumeros(int[] numeros) {
        //Definimos una variable char para crear un menú de selección para el usuario
        char escape;
        do {
            int num, apariciones;
            //Pedir por pantalla un número para buscarlo en el array
            System.out.println("Introduce el número que quieres buscar:");
            num = read.nextInt();
            //Utilizamos la función creada previamente para contar las apariciones de ese número
            apariciones = aparicionesNumero(numeros, num);
            if (apariciones == 0)
                System.out.println("Lo sentimos, no hemos encontrado coincidencias.");
            else
                System.out.format("¡Hemos encontrado el número que buscabas! El %d aparece un total de %d veces.\n", num, apariciones);
            //Mensaje para preguntarle al usuario si quiere seguir utilizando el programa
            System.out.println("¿Desea seguir buscando? (s/n)");
            //Para limpiar el escáner y que reconozca la siguiente entrada
            read.nextLine();
            do {
                escape = read.next().toLowerCase().charAt(0);
            } while (escape != 's' && escape != 'n');
        } while (escape != 'n');
    }

    /* Escriba la función void imprimirArraySinRepetir(int [] numeros) que imprima en la consola los números del array,
    los números que estuvieran repetidos solo se deben mostrar una vez. */
    public static void imprimirArraySinRepetir(int[] numeros) {
        //Ordenamos el array
        Arrays.sort(numeros);
        //Creamos una variable de control para controlar que la función no se salga del array
        int control = 0;
        //Creamos un bucle for para recorrer el array hasta el penúltimo elemento
        for (int i = 0; i < numeros.length - 1; i++) {
            //Al estar ordenados, si un número no es igual que el siguiente, lo imprimimos
            if (numeros[i] != numeros[i + 1]) {
                System.out.print(numeros[i] + " ");
                //Guardamos el último número que hemos imprimido en la variable de control
                control = numeros[i];
            }
        }
        /* He tenido que añadir este condicional y una variable de control que almacene lo último que se ha impreso
        para solucionar el problema de que mi bucle se salga de los límites del array. Entiendo que cuando sepa añadir
        excepciones podré optimizar esto.

         Si el último número del array es distinto del último número que hemos impreso, lo imprimimos también*/
        if (numeros[numeros.length - 1] != control)
            System.out.println(numeros[numeros.length - 1]);
    }

    public static void imprimirArraySinRepetir2(int[] numeros) {
        //Creamos un ArrayList para ir añadiendo todos los números que sean distintos sin preocuparnos por cúantos vayan a ser
        ArrayList<Integer> numerosSinRepetir = new ArrayList<>();
        //Recorremos el array y si el número no está contenido todavía en el ArrayList lo introducimos
        for (int i : numeros) {
            if (!numerosSinRepetir.contains(i))
                numerosSinRepetir.add(i);
        }
        //Imprimimos todos los números que hemos almacenado en el ArrayList
        for (int i : numerosSinRepetir)
            System.out.print(i + " ");
    }

    /* Escriba la función void rellenarArraySinRepetir(int [] numeros) que pida al usuario números para completar el
    array con números sin repetir. Si el usuario introduce  algún número repetido se le debe notificar, y no ha de ser
    contabilizado. */
    public static void rellenarArraySinRepetir(int[] numeros) {
        //Creamos una variable entera para almacenar los números que va introduciendo el usuario y comprobar que no estén ya en el array
        int aux;
        //Rellenamos el array de ceros para resetearlo en caso de que ya tuviera valores
        Arrays.fill(numeros, 0);
        //Creamos una variable booleana para añadir la excepción del 0
        boolean cero = false;
        //Imprimimos en pantalla un mensaje para avisar al usuario de cuántos números tiene que introducir
        System.out.format("Introduce un array de %d elementos \n", numeros.length);
        //Bucle for para recorrer el array e ir pidiéndole al usuario números para rellenar el array
        for (int i = 0; i < numeros.length; i++) {
            System.out.format("Número[%d]=", i);
            aux = read.nextInt();

            //El array está lleno de ceros. La primera vez que el usuario introduzca un 0 tenemos que tenerlo en cuenta.
            //Disparamos una condición que haga que el bucle salte a la siguiente iteración y mantenga el cero
            if (aux == 0 && !cero) {
                cero = true;
                continue;
            }
            //Un bucle while para que si el número que ha introducido el usuario ya está en el array le pida otro
            while (aparicionesNumero(numeros, aux) != 0) {
                System.out.println("Este número ya ha sido introducido. Introduce otro.");
                System.out.format("Número[%d]=", i);
                aux = read.nextInt();
            }
            //Introducimos el número en el array
            numeros[i] = aux;
        }
    }

    /* Escriba la función int aparicionesNumero(int [][] matrixNumeros, int numero) que devuelve el número de veces que
    aparece numero en la matriz. */
    public static int aparicionesNumeroMatriz(int[][] matrixNumeros, int numero) {
        //Creamos una variable para contar el número de apariciones del número
        int apariciones = 0;
        //Un bucle foreach para recorrer todas las filas de la matriz
        for (int[] i : matrixNumeros) {
            //Utilizamos la función para buscar apariciones de un número en un array que ya habíamos creado y añadimos
            //el número de apariciones en la variable que habíamos creado
            apariciones += aparicionesNumero(i, numero);
        }
        return apariciones;
    }

    /* Escribe la función void busquedaNumeros(int [][] matrixNumeros) que pedirá al usuario buscar un número
    introducido por teclado y le dirá si ha sido encontrado o no. En el caso en el que haya sido encontrado, le
    indicará el número de fila y columna donde se ha encontrado por primera vez. El programa preguntará si quiere
    seguir buscando más números o no: “¿Desea seguir buscando?(s/n)”. */
    public static void busquedaNumerosMatriz(int[][] matrixNumeros) {
        //Declaramos variables para el número que tenemos que buscar y la fila y la columna en el que encontremos la
        //primera coincidencia
        int numero, fila = 0, columna = 0;
        //Declaramos una variable booleana para establecer si hemos encontrado el número o no
        boolean encontrado = false;
        //Declaramos una variable String para generar un menú de usuario que te permita seguir usando el programa
        String continuar;
        //Un bucle do-while que se repita hasta que el usuario decida salir
        do {
            //Mensaje en pantalla para que el usuario introduzca el número que quiere buscar
            System.out.println("Introduce el número que quieres buscar:");
            numero = read.nextInt();
            //Dos bucles for anidados para recorrer todos los números de la matriz
            for (int i = 0; i < matrixNumeros.length; i++) {
                for (int j = 0; j < matrixNumeros[i].length; j++) {
                    //Si el número de la matriz coincide con el número que busca el usuario, guardamos la fila, la
                    //columna y cambiamos la variable encontrado a true. Como solo necesitamos saber si aparece al
                    //menos una vez, rompemos el bucle
                    if (matrixNumeros[i][j] == numero) {
                        fila = i + 1;
                        columna = j + 1;
                        encontrado = true;
                        break;
                    }
                }
                //Si lo ha encontrado, imprimimos en pantalla la fila y la columna donde lo ha encontrado y rompemos el bucle
                if (encontrado) {
                    System.out.format("Hemos encontrado tu número. El primer %d está situado en la fila %d y en la columna %d.\n", numero, fila, columna);
                    break;
                }
            }
            //Si después de recorrer la matriz completa no ha encontrado el número, imprimimos un mensaje para indicarlo
            if (!encontrado)
                System.out.println("Lo sentimos, el número no se encuentra dentro de la matriz.");

            //Le preguntamos al usuario si quiere seguir seguir usando el programa
            System.out.println("¿Desea seguir buscando? (s/n)");
            //Para limpiar el scanner
            read.nextLine();
            //Leemos lo que quiere hacer el usuario
            continuar = read.nextLine().toLowerCase();
            //Mientras lo que haya introducido el usuario no esté dentro de lo que especificamos se lo volvemos a pedir
            while (!continuar.equals("s") && !continuar.equals("n")) {
                System.out.println("No te he entendido.");
                System.out.println("¿Desea seguir buscando? (s/n)");
                continuar = read.nextLine().toLowerCase();
            }
            //Cuando el usuario haya introducido que no quiere seguir buscando, salimos del bucle
        } while (!continuar.equals("n"));
    }

    /* Realizar la función int [][] loterialNavidad() que genere 1807 números aleatorios del 1 al 1807 que no se pueden
    repetir del 00000 al 99999, el número uno corresponde al gordo, y se situará en el primer elemento del array,
    segundo premio corresponde al número 2, tercer premio al 3, cuarto premio al 4 y quinto premio al 5, el resto serán
    números de la pedrea */
    public static int[] loteriaNavidad() {
        //Creamos una constante con la cantidad de números premiados por si hay que cambiarlo en el futuro
        final int NUMEROS_SORTEO = 1807;
        //Creamos un array de 1807 números enteros
        int[] premios = new int[NUMEROS_SORTEO];
        //Recorremos el array con un bucle for y vamos introduciendo números entre el 1 y el 99.999
        for (int i = 0; i < NUMEROS_SORTEO; i++) {
            premios[i] = (int) (Math.random() * 100000);
            //Recorremos el array hasta el punto donde hemos rellenado para comprobar que no se repita el número que
            //que hemos introducido
            for (int j = 0; j < i; j++) {
                //Si el número se ha repetido, le restamos uno a la variable i para repetir esa iteración hasta que no se repita
                if (premios[i] == premios[j]) {
                    i--;
                    break;
                }
            }
        }
        return premios;
    }

    /* Escriba la función double comprobarSorteoNavidad(int [][] premios, int [] decimos) que devuelva la cantidad de
    premios con los décimos recibidos. El array premios contiene como primer elemento el gordo, a continuación el
    2º premio, 3º premio, 4º premio, 5º premio y el resto la pedrea */
    public static double comprobarSorteoNavidad(int[] premios, int[] decimos) {
        //Creamos una variable para contar las ganancias
        double ganancias = 0;
        //Creamos una variable para discriminar si el décimo estaba dentro de los premios o no
        boolean coincidencia = false;
        //Bucle foreach para ir comprobando todos los décimos
        for (int decimo : decimos) {
            //Bucle for para recorrer el array de premios
            for (int i = 0; i < premios.length; i++) {
                //Si el décimo está entre los premiados, ponemos la coincidencia en true y añadimos las ganancias
                //correspondientes según lo establecido en el switch
                if (decimo == premios[i]) {
                    coincidencia = true;
                    switch (i) {
                        case 0:
                            ganancias += 400000;
                            System.out.println("Gordo");
                            break;
                        case 1:
                            ganancias += 125000;
                            System.out.println("Segundo");
                            break;
                        case 2:
                            System.out.println("Tercero");
                            ganancias += 50000;
                            break;
                        case 3:
                        case 4:
                            System.out.println("Cuarto");
                            ganancias += 20000;
                            break;
                        case 5:
                        case 6:
                        case 7:
                        case 8:
                        case 9:
                        case 10:
                        case 11:
                        case 12:
                            System.out.println("Quinto");
                            ganancias += 6000;
                            break;
                        default:
                            System.out.println("Pedrea");
                            ganancias += 100;
                            break;
                    }
                    break;
                }
            }
            //Si el número estaba en la matriz de premios cambiamos coincidencia a false, y si no recorremos los if
            //anidados para ver si le corresponde algún premio según la lógica del sorteo
            if (coincidencia) {
                coincidencia = false;
            } else if (decimo == (premios[0] - 1) || decimo == (premios[0] + 1)) {
                ganancias += 2000;
            } else if (decimo == (premios[1] - 1) || decimo == (premios[1] + 1)) {
                ganancias += 1250;
            } else if (decimo == (premios[2] - 1) || decimo == (premios[2] + 1)) {
                ganancias += 960;
            } else if (decimo / 100 == premios[0] / 100 || decimo / 100 == premios[1] / 100 || decimo / 100 == premios[2] / 100 || decimo / 100 == premios[3] / 100 || decimo / 100 == premios[4] / 100) {
                ganancias += 100;
            } else if (decimo % 100 == premios[0] % 100 || decimo % 100 == premios[1] % 100 || decimo % 100 == premios[2] % 100) {
                ganancias += 100;
            } else if (decimo % 10 == premios[0] % 10) {
                ganancias += 20;
            }
        }
        return ganancias;
    }

    /* Escriba la función int [][] cuadradoMagico (int orden) que devuelve un cuadrado mágico de orden impar.
    Un cuadrado mágico es aquel en el que sin repetir ningún número, todas las filas, columnas, y las dos diagonales
    suman lo mismo. */
    public static int[][] cuadradoMagico(int orden) {
        int[][] cuadrado = new int[orden][orden];
        //Elegimos como casilla inicial la central de la primera fila
        int fila = 0, columna = orden / 2, escribirNumero = 1;
        //Metemos el 1 en la casilla inicial del algoritmo
        cuadrado[fila][columna] = escribirNumero;
        //bucle while hasta que haya colocado todos los números
        while (escribirNumero < orden * orden) {
            if (fila == 0 && columna == orden - 1) { //si se sale por la esquina, escribimos el número debajo
                fila++;
            } else if (fila == 0) { //si se sale solo por arriba, uno a la derecha y última fila
                fila = orden - 1;
                columna++;
            } else if (columna == orden - 1) { //si se sale solo por el lateral, uno arriba y a la primera columna
                fila--;
                columna = 0;
            } else if (cuadrado[fila - 1][columna + 1] != 0) { //si ya hay un número en el siguiente espacio, bajamos uno
                fila++;
            } else { //si no se cumple nada de lo anterior, avanzamos en nuestra diagonal uno a la derecha y uno arriba
                fila--;
                columna++;
            }
            escribirNumero++; //avanzamos al siguiente número
            cuadrado[fila][columna] = escribirNumero; //lo escribimos en la posición a la que nos hayamos movido según el algoritmo
        }
        return cuadrado;
    }
    /* Intentos anteriores a descubrir el algoritmo
    public static int[][] cuadradoMagico2(int orden){
        int[][] cuadrado = new int[orden][orden];
        int[] numeros = new int[orden*orden];
        int sumaNumeros=0, constante, numerosDelArrayAuxiliar = orden*orden-orden, fila = 0;
        for (int i=0; i<orden*orden; i++){
            numeros[i] = i+1;
        }
        for (int i:numeros){
            sumaNumeros += i;
        }
        constante = sumaNumeros/orden;

        //Con esto metemos los números obligatorios de una de las diagonales para garantizar que funcione
        boolean repetir=true;
        int aux=0;
        do {
            int suma = 0;

            for (int i=0; i<orden; i++){
                suma += numeros[i+aux];
            }

            if (suma == constante){
                for (int j=0; j<orden; j++){
                    cuadrado[j][orden-1] = numeros[j+aux];
                }
                repetir=false;
            }
            aux++;
        }while (repetir);


        do {
            int[] arrayAuxiliar = new int[numerosDelArrayAuxiliar];
            int x=0;

            for (int i=0; i<numerosDelArrayAuxiliar; i++){
                arrayAuxiliar[i] = numeros[i+x];
                for (int j=0; j<i; j++){
                    if (buscarNumeroMatriz(cuadrado, arrayAuxiliar[i])){
                        i--;
                        x++;
                        break;
                    }
                }
            }

            boolean sumaCorrecta = false;
            do {
                int suma=0;
                barajarArray(arrayAuxiliar);
                for (int j=0; j<orden-1; j++){
                    suma += arrayAuxiliar[j];
                }
                if (suma == constante-cuadrado[fila][orden-1]){
                    numerosDelArrayAuxiliar -= orden-1;
                    sumaCorrecta = true;
                    for (int k=0; k<orden-1; k++){
                        cuadrado[fila][k] = arrayAuxiliar[k];
                    }
                    fila++;
                }
            }while(!sumaCorrecta);

        }while (numerosDelArrayAuxiliar>0);

        while (!comprobarCuadradoMagico(cuadrado)){
            for (int[] i:cuadrado){
                barajarArray(i);
            }
        }
        return cuadrado;
    }
    public static int[][] cuadradoMagico3(int orden){
        int[][] cuadrado = new int[orden][orden];
        int[] numeros = new int[orden*orden];
        int intentos = 0;

        for (int i=0; i<orden*orden; i++){
            numeros[i] = i+1;
        }
        do {
            int pos = 0;
            barajarArray(numeros);
            for (int i = 0; i<orden; i++){
                for (int j = 0; j<orden; j++){
                    cuadrado[i][j] = numeros[pos];
                    pos++;
                }
            }
            intentos++;
        }while (!comprobarCuadradoMagico(cuadrado));
        System.out.println("Generado en "+intentos+" intentos.");
        return cuadrado;
    }
    public static void barajarArray(int[] numeros){

        Random aleatorio = new Random();

        for (int i = 0; i < numeros.length; i++) {
            int indice = aleatorio.nextInt(numeros.length);
            int aux = numeros[indice];
            numeros[indice] = numeros[i];
            numeros[i] = aux;
        }
    }
    public static boolean comprobarCuadradoMagico(int[][] cuadrado){
        int suma = 0, orden = cuadrado.length;
        boolean comprobacion = true;
        for (int i = 0; i<orden; i++){
            for (int j = 0; j<cuadrado[i].length; j++){
                suma += cuadrado[i][j];
            }
        }
        int constante = suma/orden, sumaDiagonal1 = 0, sumaDiagonal2 = 0;

        for (int i=0; i<orden; i++){
            int sumaFila = 0, sumaColumna = 0;
            for (int j=0; j<orden; j++) {
                sumaFila += cuadrado[i][j];
                sumaColumna += cuadrado[j][i];
                if (i == j) {
                    sumaDiagonal1 += cuadrado[i][j];
                    sumaDiagonal2 += cuadrado[i][orden - 1 - j];
                }
            }
            if (sumaFila != constante || sumaColumna != constante) {
                comprobacion = false;
                break;
            }
        }
        if (sumaDiagonal1 != constante || sumaDiagonal2 != constante)
            comprobacion = false;

        return comprobacion;
    }
     */

    /* Escriba la función int ColumnaMenorSuma (int [][] matriz) la función devolverá la columna en la que la suma de
    sus elementos sea menor. */
    public static int columnaMenorSuma(int[][] matriz) {
        int[] sumas = new int[matriz[0].length];
        for (int i = 0; i < matriz[0].length; i++) { //Sumamos todas las columnas y almacenamos los valores en un array.
            int sumaColumna = 0;
            for (int j = 0; j < matriz.length; j++) {
                sumaColumna += matriz[j][i];
            }
            sumas[i] = sumaColumna;
        }
        int valorMenor = menor(sumas);//Ordenamos el array en orden ascendente y cogemos el primer número

        return localizarColumna(sumas, valorMenor); //Buscamos la columna a la que pertenece esa suma
    }

    public static int localizarColumna(int[] sumas, int valorSuma) {
        int pos = 0;
        for (int i = 0; i < sumas.length; i++) {
            if (sumas[i] == valorSuma) {
                pos = i;
                break;
            }
        }
        return pos + 1;
    }


    public static void main(String[] args) {

        /*int[][] array = new int[99][99];
        rellenarMatrizAleatorio(array, 1000);
        array[array.length/2][0] = 0;
        imprimirMatrizInt(array);*/

        System.out.println((int) 'A');


        //int[][] cuadrado ={{11,24,7,20,3},{4,12,25,8,16},{17,5,13,21,9}, {18,10,1,14,22},{23,6,19,2,15}};
        //busquedaNumerosMatriz(cuadrado);

        /* int[] sorteo = loteriaNavidad(), decimos = {13669, 11111, 14968};
        double ganancias = comprobarSorteoNavidad(sorteo, decimos);

        System.out.println(ganancias); */
        /* int suma = 0;
        for (int i = 1; i<=25; i++){
            suma +=i;
        }
        System.out.println(suma); */

        //imprimirMatrizInt(cuadradoMagico3(351));

        /* int[][] cuadrado ={{11,24,7,20,3},{4,12,25,8,16},{17,5,13,21,9}, {18,10,1,14,22},{23,6,19,2,15}};*/
        /* int[][] cuadrado = cuadradoMagico3(7);
        int intento = 0;
        do {
            for (int[] i:cuadrado){
                barajarArray(i);
            }
            intento++;
        }while (!comprobarCuadradoMagico(cuadrado));

        imprimirMatrizInt(cuadrado);
        System.out.println(intento);*/



        /* int[][] tablero = {
                {1,1,2},
                {2,2,1},
                {0,2,1}};

        System.out.println(ganador(tablero)); */

        /*int[][] solution = {
                {4,2,9,8,1,3,5,6,7},
                {5,1,6,4,7,2,9,3,8},
                {7,8,3,6,5,9,2,4,1},
                {6,7,2,1,3,4,8,5,9},
                {3,9,5,2,8,6,1,7,4},
                {8,4,1,7,9,5,6,2,3},
                {1,5,8,3,6,7,4,9,2},
                {9,3,4,5,2,8,7,1,6},
                {2,6,7,9,4,1,3,8,5}};*/

        /*int[][] solution = {
                {0,0,0,8,0,0,0,6,0},
                {3,0,5,0,6,4,0,0,8},
                {0,0,7,0,0,0,3,0,0},
                {0,0,0,0,7,0,0,0,0},
                {8,0,0,9,4,2,0,0,0},
                {0,0,0,3,8,5,4,0,7},
                {5,3,0,2,0,0,0,0,0},
                {7,6,0,0,5,3,0,8,0},
                {4,0,0,0,9,6,2,3,5}};*/

        /*int[][] solution = {
                {0,0,1,7,6,0,0,8,0},
                {4,5,0,0,0,1,0,0,6},
                {0,8,0,0,0,0,0,0,0},
                {0,0,3,2,0,0,0,4,7},
                {0,0,0,0,0,0,0,0,0},
                {9,7,4,0,0,0,5,6,2},
                {8,9,5,0,0,0,4,0,0},
                {1,0,0,0,8,2,6,0,0},
                {6,0,0,5,0,0,0,9,0}};

        imprimirMatrizInt(resolverSudoku2(solution));*/

    } //Fin main

    //https://dornisoft.es/dorniblog/index.php/2020/11/23/resolver-sudokus-con-java-y-recursividad/
    /* public boolean resolverSudoku1(int[][]sudoku){

        for(int fila=0;fila <9;fila++){
            for (int columna=0;columna<9;columna++){
                if(sudoku[fila][columna]==0){
                    for (int numero =1;numero<=9;numero++){
                        if(esValido(fila,columna,numero)){
                            sudoku[fila][columna]=numero;
                            if(resolverSudoku1(sudoku)){
                                return true;
                            }else{
                                sudoku[fila][columna]=0;
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private boolean esValido (int fila, int columna, int numero){
        return !(contieneFila(fila,numero)||contieneColumna(columna,numero)||contieneCaja(fila,columna,numero));
    }

    private boolean contieneFila(int fila,int numero){
        for(int columna=0;columna<9;columna++){
            if(tablero[fila][columna]==numero){
                return true;
            }
        }
        return false;
    }

    private boolean contieneColumna(int columna,int numero){
        for(int fila=0;fila<9;fila++){
            if(tablero[fila][columna]==numero){
                return true;
            }
        }
        return false;
    }

    private boolean contieneCaja(int fila, int columna,int numero){
        int f = fila - fila % 3;
        int c = columna -columna % 3;
        for(int i =f;i<f+3;i++){
            for(int j = c; j<c+3;j++){
                if(tablero[i][j]==numero){
                    return true;
                }
            }
        }
        return false;
    }

     */

    public static int[][] resolverSudoku(int[][] sudoku) {
        boolean sobreescribe;
        do {
            sobreescribe = false;
            int[][] arrayFilas = {{sudoku[0][0], sudoku[0][1], sudoku[0][2], sudoku[0][3], sudoku[0][4], sudoku[0][5], sudoku[0][6], sudoku[0][7], sudoku[0][8]},
                    {sudoku[1][0], sudoku[1][1], sudoku[1][2], sudoku[1][3], sudoku[1][4], sudoku[1][5], sudoku[1][6], sudoku[1][7], sudoku[1][8]},
                    {sudoku[2][0], sudoku[2][1], sudoku[2][2], sudoku[2][3], sudoku[2][4], sudoku[2][5], sudoku[2][6], sudoku[2][7], sudoku[2][8]},
                    {sudoku[3][0], sudoku[3][1], sudoku[3][2], sudoku[3][3], sudoku[3][4], sudoku[3][5], sudoku[3][6], sudoku[3][7], sudoku[3][8]},
                    {sudoku[4][0], sudoku[4][1], sudoku[4][2], sudoku[4][3], sudoku[4][4], sudoku[4][5], sudoku[4][6], sudoku[4][7], sudoku[4][8]},
                    {sudoku[5][0], sudoku[5][1], sudoku[5][2], sudoku[5][3], sudoku[5][4], sudoku[5][5], sudoku[5][6], sudoku[5][7], sudoku[5][8]},
                    {sudoku[6][0], sudoku[6][1], sudoku[6][2], sudoku[6][3], sudoku[6][4], sudoku[6][5], sudoku[6][6], sudoku[6][7], sudoku[6][8]},
                    {sudoku[7][0], sudoku[7][1], sudoku[7][2], sudoku[7][3], sudoku[7][4], sudoku[7][5], sudoku[7][6], sudoku[7][7], sudoku[7][8]},
                    {sudoku[8][0], sudoku[8][1], sudoku[8][2], sudoku[8][3], sudoku[8][4], sudoku[8][5], sudoku[8][6], sudoku[8][7], sudoku[8][8]}},
                    arrayColumnas = {{sudoku[0][0], sudoku[1][0], sudoku[2][0], sudoku[3][0], sudoku[4][0], sudoku[5][0], sudoku[6][0], sudoku[7][0], sudoku[8][0]},
                            {sudoku[0][1], sudoku[1][1], sudoku[2][1], sudoku[3][1], sudoku[4][1], sudoku[5][1], sudoku[6][1], sudoku[7][1], sudoku[8][1]},
                            {sudoku[0][2], sudoku[1][2], sudoku[2][2], sudoku[3][2], sudoku[4][2], sudoku[5][2], sudoku[6][2], sudoku[7][2], sudoku[8][2]},
                            {sudoku[0][3], sudoku[1][3], sudoku[2][3], sudoku[3][3], sudoku[4][3], sudoku[5][3], sudoku[6][3], sudoku[7][3], sudoku[8][3]},
                            {sudoku[0][4], sudoku[1][4], sudoku[2][4], sudoku[3][4], sudoku[4][4], sudoku[5][4], sudoku[6][4], sudoku[7][4], sudoku[8][4]},
                            {sudoku[0][5], sudoku[1][5], sudoku[2][5], sudoku[3][5], sudoku[4][5], sudoku[5][5], sudoku[6][5], sudoku[7][5], sudoku[8][5]},
                            {sudoku[0][6], sudoku[1][6], sudoku[2][6], sudoku[3][6], sudoku[4][6], sudoku[5][6], sudoku[6][6], sudoku[7][6], sudoku[8][6]},
                            {sudoku[0][7], sudoku[1][7], sudoku[2][7], sudoku[3][7], sudoku[4][7], sudoku[5][7], sudoku[6][7], sudoku[7][7], sudoku[8][7]},
                            {sudoku[0][8], sudoku[1][8], sudoku[2][8], sudoku[3][8], sudoku[4][8], sudoku[5][8], sudoku[6][8], sudoku[7][8], sudoku[8][8]}},
                    arrayCuadrados = {{sudoku[0][0], sudoku[0][1], sudoku[0][2], sudoku[1][0], sudoku[1][1], sudoku[1][2], sudoku[2][0], sudoku[2][1], sudoku[2][2]},
                            {sudoku[0][3], sudoku[0][4], sudoku[0][5], sudoku[1][3], sudoku[1][4], sudoku[1][5], sudoku[2][3], sudoku[2][4], sudoku[2][5]},
                            {sudoku[0][6], sudoku[0][7], sudoku[0][8], sudoku[1][6], sudoku[1][7], sudoku[1][8], sudoku[2][6], sudoku[2][7], sudoku[2][8]},
                            {sudoku[3][0], sudoku[3][1], sudoku[3][2], sudoku[4][0], sudoku[4][1], sudoku[4][2], sudoku[5][0], sudoku[5][1], sudoku[5][2]},
                            {sudoku[3][3], sudoku[3][4], sudoku[3][5], sudoku[4][3], sudoku[4][4], sudoku[4][5], sudoku[5][3], sudoku[5][4], sudoku[5][5]},
                            {sudoku[3][6], sudoku[3][7], sudoku[3][8], sudoku[4][6], sudoku[4][7], sudoku[4][8], sudoku[5][6], sudoku[5][7], sudoku[5][8]},
                            {sudoku[6][0], sudoku[6][1], sudoku[6][2], sudoku[7][0], sudoku[7][1], sudoku[7][2], sudoku[8][0], sudoku[8][1], sudoku[8][2]},
                            {sudoku[6][3], sudoku[6][4], sudoku[6][5], sudoku[7][3], sudoku[7][4], sudoku[7][5], sudoku[8][3], sudoku[8][4], sudoku[8][5]},
                            {sudoku[6][6], sudoku[6][7], sudoku[6][8], sudoku[7][6], sudoku[7][7], sudoku[7][8], sudoku[8][6], sudoku[8][7], sudoku[8][8]}};

            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {

                    if (sudoku[i][j] == 0) {
                        int pos = 0;
                        int[] posibilidades = new int[9];
                        for (int k = 1; k < 10; k++) {
                            if ((aparicionesNumero(arrayFilas[i], k) == 1)) {
                                posibilidades[pos] = k;
                                pos++;

                            } else if ((aparicionesNumero(arrayColumnas[j], k) == 1)) {
                                posibilidades[pos] = k;
                                pos++;
                            } else {
                                int x = 0;

                                if (i < 3) {
                                    switch (j) {
                                        case 0:
                                        case 1:
                                        case 2:
                                            break;
                                        case 3:
                                        case 4:
                                        case 5:
                                            x = 1;
                                            break;
                                        case 6:
                                        case 7:
                                        case 8:
                                            x = 2;
                                            break;
                                    }
                                } else if (i < 6) {
                                    switch (j) {
                                        case 0:
                                        case 1:
                                        case 2:
                                            x = 3;
                                            break;
                                        case 3:
                                        case 4:
                                        case 5:
                                            x = 4;
                                            break;
                                        case 6:
                                        case 7:
                                        case 8:
                                            x = 5;
                                            break;
                                    }
                                } else {
                                    switch (j) {
                                        case 0:
                                        case 1:
                                        case 2:
                                            x = 6;
                                            break;
                                        case 3:
                                        case 4:
                                        case 5:
                                            x = 7;
                                            break;
                                        case 6:
                                        case 7:
                                        case 8:
                                            x = 8;
                                            break;
                                    }
                                }
                                if ((aparicionesNumero(arrayCuadrados[x], k) == 1)) {
                                    posibilidades[pos] = k;
                                    pos++;
                                }
                            }
                        }
                        if ((aparicionesNumero(posibilidades, 0) == 1)) {
                            int suma = 0;
                            for (int l = 0; l < 9; l++) {
                                suma += posibilidades[l];
                            }
                            sudoku[i][j] = 45 - suma;
                            sobreescribe = true;
                        }
                    }
                }
            }
        } while (sobreescribe);
        return sudoku;
    }

    public static int[][] resolverSudoku2(int[][] sudoku) {


        int[][][] matrizPosibilidades = new int[9][9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                for (int k = 0; k < 9; k++) {
                    if (sudoku[i][j] == 0)
                        matrizPosibilidades[i][j][k] = k + 1;
                    else
                        matrizPosibilidades[i][j][k] = 0;
                }
            }
        }

        rellenarSegurosSudoku(sudoku, matrizPosibilidades);

        int[][] sudokuAuxiliar = sudoku.clone();
        int[][][] matrizPosibilidadesAuxiliar = matrizPosibilidades.clone();
        int iPrueba = 0, jPrueba = 0, kPrueba = 0;

        boolean primeraIteracion = true;
        while (!validarSudoku2(sudokuAuxiliar)) {
            boolean valido = true, salir = false;
            if (primeraIteracion) {
                for (int i = 0; i < 9; i++) {
                    for (int j = 0; j < 9; j++) {
                        for (int k = 0; k < 9; k++) {
                            if (matrizPosibilidadesAuxiliar[i][j][k] != 0) {
                                iPrueba = i;
                                jPrueba = j;
                                kPrueba = k;
                                primeraIteracion = false;
                                sudokuAuxiliar[i][j] = matrizPosibilidadesAuxiliar[i][j][k];
                                for (int l = 0; l < 9; l++) {
                                    matrizPosibilidadesAuxiliar[i][j][l] = 0;
                                }
                                actualizarPosibilidades(sudokuAuxiliar, matrizPosibilidadesAuxiliar);
                                salir = true;
                                break;
                            }
                        }
                        if (salir) {
                            break;
                        }
                    }
                    if (salir) {
                        break;
                    }
                }
            } else {
                for (int i = 0; i < 9; i++) {
                    for (int j = 0; j < 9; j++) {
                        for (int k = 0; k < 9; k++) {
                            if (matrizPosibilidadesAuxiliar[i][j][k] != 0) {
                                sudokuAuxiliar[i][j] = matrizPosibilidadesAuxiliar[i][j][k];
                                for (int l = 0; l < 9; l++) {
                                    matrizPosibilidadesAuxiliar[i][j][l] = 0;
                                }
                                actualizarPosibilidades(sudokuAuxiliar, matrizPosibilidadesAuxiliar);
                                salir = true;
                                break;
                            }
                        }
                        if (salir) {
                            break;
                        }
                    }
                    if (salir) {
                        break;
                    }
                }
            }
            salir = false;
            rellenarSegurosSudoku(sudokuAuxiliar, matrizPosibilidadesAuxiliar);
            for (int i = 0; valido && i < 9; i++) {
                for (int j = 0; valido && j < 9; j++) {
                    if (sudokuAuxiliar[i][j] == 0 && aparicionesNumero(matrizPosibilidadesAuxiliar[i][j], 0) == 9) {
                        sudokuAuxiliar = sudoku.clone();
                        matrizPosibilidades[iPrueba][jPrueba][kPrueba] = 0;
                        matrizPosibilidadesAuxiliar = matrizPosibilidades.clone();
                        valido = false;
                        primeraIteracion = false;
                    }
                }
            }
        }
        return sudokuAuxiliar;
    }

    private static void rellenarSegurosSudoku(int[][] sudoku, int[][][] matrizPosibilidades) {
        boolean sobreescribir;

        do {
            int[][]
                    arrayFilas = {
                    {sudoku[0][0], sudoku[0][1], sudoku[0][2], sudoku[0][3], sudoku[0][4], sudoku[0][5], sudoku[0][6], sudoku[0][7], sudoku[0][8]},
                    {sudoku[1][0], sudoku[1][1], sudoku[1][2], sudoku[1][3], sudoku[1][4], sudoku[1][5], sudoku[1][6], sudoku[1][7], sudoku[1][8]},
                    {sudoku[2][0], sudoku[2][1], sudoku[2][2], sudoku[2][3], sudoku[2][4], sudoku[2][5], sudoku[2][6], sudoku[2][7], sudoku[2][8]},
                    {sudoku[3][0], sudoku[3][1], sudoku[3][2], sudoku[3][3], sudoku[3][4], sudoku[3][5], sudoku[3][6], sudoku[3][7], sudoku[3][8]},
                    {sudoku[4][0], sudoku[4][1], sudoku[4][2], sudoku[4][3], sudoku[4][4], sudoku[4][5], sudoku[4][6], sudoku[4][7], sudoku[4][8]},
                    {sudoku[5][0], sudoku[5][1], sudoku[5][2], sudoku[5][3], sudoku[5][4], sudoku[5][5], sudoku[5][6], sudoku[5][7], sudoku[5][8]},
                    {sudoku[6][0], sudoku[6][1], sudoku[6][2], sudoku[6][3], sudoku[6][4], sudoku[6][5], sudoku[6][6], sudoku[6][7], sudoku[6][8]},
                    {sudoku[7][0], sudoku[7][1], sudoku[7][2], sudoku[7][3], sudoku[7][4], sudoku[7][5], sudoku[7][6], sudoku[7][7], sudoku[7][8]},
                    {sudoku[8][0], sudoku[8][1], sudoku[8][2], sudoku[8][3], sudoku[8][4], sudoku[8][5], sudoku[8][6], sudoku[8][7], sudoku[8][8]}
            },
                    arrayColumnas = {
                            {sudoku[0][0], sudoku[1][0], sudoku[2][0], sudoku[3][0], sudoku[4][0], sudoku[5][0], sudoku[6][0], sudoku[7][0], sudoku[8][0]},
                            {sudoku[0][1], sudoku[1][1], sudoku[2][1], sudoku[3][1], sudoku[4][1], sudoku[5][1], sudoku[6][1], sudoku[7][1], sudoku[8][1]},
                            {sudoku[0][2], sudoku[1][2], sudoku[2][2], sudoku[3][2], sudoku[4][2], sudoku[5][2], sudoku[6][2], sudoku[7][2], sudoku[8][2]},
                            {sudoku[0][3], sudoku[1][3], sudoku[2][3], sudoku[3][3], sudoku[4][3], sudoku[5][3], sudoku[6][3], sudoku[7][3], sudoku[8][3]},
                            {sudoku[0][4], sudoku[1][4], sudoku[2][4], sudoku[3][4], sudoku[4][4], sudoku[5][4], sudoku[6][4], sudoku[7][4], sudoku[8][4]},
                            {sudoku[0][5], sudoku[1][5], sudoku[2][5], sudoku[3][5], sudoku[4][5], sudoku[5][5], sudoku[6][5], sudoku[7][5], sudoku[8][5]},
                            {sudoku[0][6], sudoku[1][6], sudoku[2][6], sudoku[3][6], sudoku[4][6], sudoku[5][6], sudoku[6][6], sudoku[7][6], sudoku[8][6]},
                            {sudoku[0][7], sudoku[1][7], sudoku[2][7], sudoku[3][7], sudoku[4][7], sudoku[5][7], sudoku[6][7], sudoku[7][7], sudoku[8][7]},
                            {sudoku[0][8], sudoku[1][8], sudoku[2][8], sudoku[3][8], sudoku[4][8], sudoku[5][8], sudoku[6][8], sudoku[7][8], sudoku[8][8]}
                    },
                    arrayCuadrados = {
                            {sudoku[0][0], sudoku[0][1], sudoku[0][2], sudoku[1][0], sudoku[1][1], sudoku[1][2], sudoku[2][0], sudoku[2][1], sudoku[2][2]},
                            {sudoku[0][3], sudoku[0][4], sudoku[0][5], sudoku[1][3], sudoku[1][4], sudoku[1][5], sudoku[2][3], sudoku[2][4], sudoku[2][5]},
                            {sudoku[0][6], sudoku[0][7], sudoku[0][8], sudoku[1][6], sudoku[1][7], sudoku[1][8], sudoku[2][6], sudoku[2][7], sudoku[2][8]},
                            {sudoku[3][0], sudoku[3][1], sudoku[3][2], sudoku[4][0], sudoku[4][1], sudoku[4][2], sudoku[5][0], sudoku[5][1], sudoku[5][2]},
                            {sudoku[3][3], sudoku[3][4], sudoku[3][5], sudoku[4][3], sudoku[4][4], sudoku[4][5], sudoku[5][3], sudoku[5][4], sudoku[5][5]},
                            {sudoku[3][6], sudoku[3][7], sudoku[3][8], sudoku[4][6], sudoku[4][7], sudoku[4][8], sudoku[5][6], sudoku[5][7], sudoku[5][8]},
                            {sudoku[6][0], sudoku[6][1], sudoku[6][2], sudoku[7][0], sudoku[7][1], sudoku[7][2], sudoku[8][0], sudoku[8][1], sudoku[8][2]},
                            {sudoku[6][3], sudoku[6][4], sudoku[6][5], sudoku[7][3], sudoku[7][4], sudoku[7][5], sudoku[8][3], sudoku[8][4], sudoku[8][5]},
                            {sudoku[6][6], sudoku[6][7], sudoku[6][8], sudoku[7][6], sudoku[7][7], sudoku[7][8], sudoku[8][6], sudoku[8][7], sudoku[8][8]}
                    };

            sobreescribir = false;
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {

                    if (sudoku[i][j] == 0) {
                        for (int k = 1; k < 10; k++) {
                            if ((aparicionesNumero(arrayFilas[i], k) == 1) && (aparicionesNumero(matrizPosibilidades[i][j], k) == 1)) {
                                matrizPosibilidades[i][j][k - 1] = 0;
                            } else if ((aparicionesNumero(arrayColumnas[j], k) == 1) && (aparicionesNumero(matrizPosibilidades[i][j], k) == 1)) {
                                matrizPosibilidades[i][j][k - 1] = 0;
                            } else {
                                int x = 0;
                                if (i < 3) {
                                    switch (j) {
                                        case 0:
                                        case 1:
                                        case 2:
                                            break;
                                        case 3:
                                        case 4:
                                        case 5:
                                            x = 1;
                                            break;
                                        case 6:
                                        case 7:
                                        case 8:
                                            x = 2;
                                            break;
                                    }
                                } else if (i < 6) {
                                    switch (j) {
                                        case 0:
                                        case 1:
                                        case 2:
                                            x = 3;
                                            break;
                                        case 3:
                                        case 4:
                                        case 5:
                                            x = 4;
                                            break;
                                        case 6:
                                        case 7:
                                        case 8:
                                            x = 5;
                                            break;
                                    }
                                } else {
                                    switch (j) {
                                        case 0:
                                        case 1:
                                        case 2:
                                            x = 6;
                                            break;
                                        case 3:
                                        case 4:
                                        case 5:
                                            x = 7;
                                            break;
                                        case 6:
                                        case 7:
                                        case 8:
                                            x = 8;
                                            break;
                                    }
                                }
                                if ((aparicionesNumero(arrayCuadrados[x], k) == 1) && (aparicionesNumero(matrizPosibilidades[i][j], k) == 1)) {
                                    matrizPosibilidades[i][j][k - 1] = 0;
                                }
                            }
                        }
                        if ((aparicionesNumero(matrizPosibilidades[i][j], 0) == 8)) {
                            Arrays.sort(matrizPosibilidades[i][j]);
                            sudoku[i][j] = matrizPosibilidades[i][j][8];
                            matrizPosibilidades[i][j][8] = 0;
                            sobreescribir = true;
                        }
                    }
                }
            }
        } while (sobreescribir);
    }

    private static void actualizarPosibilidades(int[][] sudoku, int[][][] matrizPosibilidades) {
        int[][]
                arrayFilas = {
                {sudoku[0][0], sudoku[0][1], sudoku[0][2], sudoku[0][3], sudoku[0][4], sudoku[0][5], sudoku[0][6], sudoku[0][7], sudoku[0][8]},
                {sudoku[1][0], sudoku[1][1], sudoku[1][2], sudoku[1][3], sudoku[1][4], sudoku[1][5], sudoku[1][6], sudoku[1][7], sudoku[1][8]},
                {sudoku[2][0], sudoku[2][1], sudoku[2][2], sudoku[2][3], sudoku[2][4], sudoku[2][5], sudoku[2][6], sudoku[2][7], sudoku[2][8]},
                {sudoku[3][0], sudoku[3][1], sudoku[3][2], sudoku[3][3], sudoku[3][4], sudoku[3][5], sudoku[3][6], sudoku[3][7], sudoku[3][8]},
                {sudoku[4][0], sudoku[4][1], sudoku[4][2], sudoku[4][3], sudoku[4][4], sudoku[4][5], sudoku[4][6], sudoku[4][7], sudoku[4][8]},
                {sudoku[5][0], sudoku[5][1], sudoku[5][2], sudoku[5][3], sudoku[5][4], sudoku[5][5], sudoku[5][6], sudoku[5][7], sudoku[5][8]},
                {sudoku[6][0], sudoku[6][1], sudoku[6][2], sudoku[6][3], sudoku[6][4], sudoku[6][5], sudoku[6][6], sudoku[6][7], sudoku[6][8]},
                {sudoku[7][0], sudoku[7][1], sudoku[7][2], sudoku[7][3], sudoku[7][4], sudoku[7][5], sudoku[7][6], sudoku[7][7], sudoku[7][8]},
                {sudoku[8][0], sudoku[8][1], sudoku[8][2], sudoku[8][3], sudoku[8][4], sudoku[8][5], sudoku[8][6], sudoku[8][7], sudoku[8][8]}
        },
                arrayColumnas = {
                        {sudoku[0][0], sudoku[1][0], sudoku[2][0], sudoku[3][0], sudoku[4][0], sudoku[5][0], sudoku[6][0], sudoku[7][0], sudoku[8][0]},
                        {sudoku[0][1], sudoku[1][1], sudoku[2][1], sudoku[3][1], sudoku[4][1], sudoku[5][1], sudoku[6][1], sudoku[7][1], sudoku[8][1]},
                        {sudoku[0][2], sudoku[1][2], sudoku[2][2], sudoku[3][2], sudoku[4][2], sudoku[5][2], sudoku[6][2], sudoku[7][2], sudoku[8][2]},
                        {sudoku[0][3], sudoku[1][3], sudoku[2][3], sudoku[3][3], sudoku[4][3], sudoku[5][3], sudoku[6][3], sudoku[7][3], sudoku[8][3]},
                        {sudoku[0][4], sudoku[1][4], sudoku[2][4], sudoku[3][4], sudoku[4][4], sudoku[5][4], sudoku[6][4], sudoku[7][4], sudoku[8][4]},
                        {sudoku[0][5], sudoku[1][5], sudoku[2][5], sudoku[3][5], sudoku[4][5], sudoku[5][5], sudoku[6][5], sudoku[7][5], sudoku[8][5]},
                        {sudoku[0][6], sudoku[1][6], sudoku[2][6], sudoku[3][6], sudoku[4][6], sudoku[5][6], sudoku[6][6], sudoku[7][6], sudoku[8][6]},
                        {sudoku[0][7], sudoku[1][7], sudoku[2][7], sudoku[3][7], sudoku[4][7], sudoku[5][7], sudoku[6][7], sudoku[7][7], sudoku[8][7]},
                        {sudoku[0][8], sudoku[1][8], sudoku[2][8], sudoku[3][8], sudoku[4][8], sudoku[5][8], sudoku[6][8], sudoku[7][8], sudoku[8][8]}
                },
                arrayCuadrados = {
                        {sudoku[0][0], sudoku[0][1], sudoku[0][2], sudoku[1][0], sudoku[1][1], sudoku[1][2], sudoku[2][0], sudoku[2][1], sudoku[2][2]},
                        {sudoku[0][3], sudoku[0][4], sudoku[0][5], sudoku[1][3], sudoku[1][4], sudoku[1][5], sudoku[2][3], sudoku[2][4], sudoku[2][5]},
                        {sudoku[0][6], sudoku[0][7], sudoku[0][8], sudoku[1][6], sudoku[1][7], sudoku[1][8], sudoku[2][6], sudoku[2][7], sudoku[2][8]},
                        {sudoku[3][0], sudoku[3][1], sudoku[3][2], sudoku[4][0], sudoku[4][1], sudoku[4][2], sudoku[5][0], sudoku[5][1], sudoku[5][2]},
                        {sudoku[3][3], sudoku[3][4], sudoku[3][5], sudoku[4][3], sudoku[4][4], sudoku[4][5], sudoku[5][3], sudoku[5][4], sudoku[5][5]},
                        {sudoku[3][6], sudoku[3][7], sudoku[3][8], sudoku[4][6], sudoku[4][7], sudoku[4][8], sudoku[5][6], sudoku[5][7], sudoku[5][8]},
                        {sudoku[6][0], sudoku[6][1], sudoku[6][2], sudoku[7][0], sudoku[7][1], sudoku[7][2], sudoku[8][0], sudoku[8][1], sudoku[8][2]},
                        {sudoku[6][3], sudoku[6][4], sudoku[6][5], sudoku[7][3], sudoku[7][4], sudoku[7][5], sudoku[8][3], sudoku[8][4], sudoku[8][5]},
                        {sudoku[6][6], sudoku[6][7], sudoku[6][8], sudoku[7][6], sudoku[7][7], sudoku[7][8], sudoku[8][6], sudoku[8][7], sudoku[8][8]}
                };

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {

                if (sudoku[i][j] == 0) {
                    for (int k = 1; k < 10; k++) {
                        if ((aparicionesNumero(arrayFilas[i], k) == 1) && (aparicionesNumero(matrizPosibilidades[i][j], k) == 1)) {
                            matrizPosibilidades[i][j][k - 1] = 0;
                        } else if ((aparicionesNumero(arrayColumnas[j], k) == 1) && (aparicionesNumero(matrizPosibilidades[i][j], k) == 1)) {
                            matrizPosibilidades[i][j][k - 1] = 0;
                        } else {
                            int x = 0;
                            if (i < 3) {
                                switch (j) {
                                    case 0:
                                    case 1:
                                    case 2:
                                        break;
                                    case 3:
                                    case 4:
                                    case 5:
                                        x = 1;
                                        break;
                                    case 6:
                                    case 7:
                                    case 8:
                                        x = 2;
                                        break;
                                }
                            } else if (i < 6) {
                                switch (j) {
                                    case 0:
                                    case 1:
                                    case 2:
                                        x = 3;
                                        break;
                                    case 3:
                                    case 4:
                                    case 5:
                                        x = 4;
                                        break;
                                    case 6:
                                    case 7:
                                    case 8:
                                        x = 5;
                                        break;
                                }
                            } else {
                                switch (j) {
                                    case 0:
                                    case 1:
                                    case 2:
                                        x = 6;
                                        break;
                                    case 3:
                                    case 4:
                                    case 5:
                                        x = 7;
                                        break;
                                    case 6:
                                    case 7:
                                    case 8:
                                        x = 8;
                                        break;
                                }
                            }
                            if ((aparicionesNumero(arrayCuadrados[x], k) == 1) && (aparicionesNumero(matrizPosibilidades[i][j], k) == 1)) {
                                matrizPosibilidades[i][j][k - 1] = 0;
                            }
                        }
                    }
                }
            }
        }
    }


    public static boolean validarSudoku2(int[][] sudoku) {
        boolean validar = true;
        int[] numeros = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        for (int i = 0; i < 9; i++) {
            if (!compararArrays(arrayFilaSudoku(sudoku, i), numeros) ||
                    !compararArrays(arrayColumnaSudoku(sudoku, i), numeros) ||
                    !compararArrays(arrayCuadradoSudoku(sudoku, i), numeros)) {
                validar = false;
                break;
            }
        }
        return validar;
    }

    public static boolean compararArrays(int[] array1, int[] array2) {
        boolean iguales = true;
        Arrays.sort(array1);
        Arrays.sort(array2);
        if (array1.length == array2.length) {
            for (int i = 0; i < array1.length; i++) {
                if (array1[i] != array2[i]) {
                    iguales = false;
                    break;
                }
            }
        }
        return iguales;
    }

    public static int[] arrayCuadradoSudoku(int[][] matriz, int numero) {
        int[] array = new int[9];
        int filaInicial = 0, columnaInicial = 0;
        switch (numero) {
            case 0:
                break;
            case 1:
                columnaInicial = 3;
                break;
            case 2:
                columnaInicial = 6;
                break;
            case 3:
                filaInicial = 3;
                break;
            case 4:
                filaInicial = 3;
                columnaInicial = 3;
                break;
            case 5:
                filaInicial = 3;
                columnaInicial = 6;
                break;
            case 6:
                filaInicial = 6;
                break;
            case 7:
                filaInicial = 6;
                columnaInicial = 3;
                break;
            case 8:
                filaInicial = 6;
                columnaInicial = 6;
                break;
        }

        int pos = 0;
        for (int i = filaInicial; i < filaInicial + 3; i++) {
            for (int j = columnaInicial; j < columnaInicial + 3; j++) {
                array[pos] = matriz[i][j];
                pos++;
            }
        }

        return array;
    }

    public static int[] arrayFilaSudoku(int[][] matriz, int fila) {
        int[] array = new int[9];
        System.arraycopy(matriz[fila], 0, array, 0, 9);
        return array;
    }

    public static int[] arrayColumnaSudoku(int[][] matriz, int columna) {
        int[] array = new int[9];
        for (int i = 0; i < 9; i++) {
            array[i] = matriz[i][columna];
        }
        return array;
    }

    // Crear la función boolean validarSudoku(int [][] sudoku) que válide si es válido.
    public static boolean validarSudoku(int[][] sudoku) {
        boolean validar = true;

        for (int i = 0; i < 9; i++) {
            int sumaFila = 0, sumaColumna = 0;
            for (int j = 0; j < 9; j++) {
                sumaFila += sudoku[i][j];
                sumaColumna += sudoku[j][i];
            }
            if (sumaFila != 45 || sumaColumna != 45) {
                validar = false;
                break;
            }
        }
        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                if (sumaMenorOrden3(sudoku, i, j) != 45) {
                    validar = false;
                    break;
                }
            }
            if (!validar)
                break;
        }
        return validar;
    }

    public static int sumaMenorOrden3(int[][] matriz, int filaInicial, int columnaInicial) {
        int suma = 0;
        for (int i = filaInicial; i < filaInicial + 3; i++) {
            for (int j = columnaInicial; j < columnaInicial + 3; j++) {
                suma += matriz[i][j];
            }
        }
        return suma;
    }

    public static int ganador(int[][] tablero) {
        int victoria, orden = tablero.length;
        if (buscarNumeroMatriz(tablero, 0)) {
            victoria = -1;
        } else {
            victoria = 0;
            for (int i = 0; i < orden; i++) {
                int sumaFila = 0, sumaColumna = 0;
                for (int j = 0; j < orden; j++) {
                    sumaFila += tablero[i][j];
                    sumaColumna += tablero[j][i];
                }
                if (sumaFila == 6 || sumaColumna == 6) {
                    victoria = 2;
                    break;
                } else if (sumaFila == 3 || sumaColumna == 3) {
                    victoria = 1;
                    break;
                }
            }

            int sumaDiagonal1 = 0, sumaDiagonal2 = 0;
            for (int i = 0; i < orden; i++) {
                for (int j = 0; j < orden; j++) {
                    if (i == j) {
                        sumaDiagonal1 += tablero[i][j];
                        sumaDiagonal2 += tablero[i][orden - 1 - j];
                    }
                }
            }
            if (sumaDiagonal1 == 6 || sumaDiagonal2 == 6) {
                victoria = 2;
            } else if (sumaDiagonal1 == 3 || sumaDiagonal2 == 3) {
                victoria = 1;
            }

        }
        return victoria;
    } //Fin ganador

    public static boolean buscarNumeroMatriz(int[][] matriz, int numero) {
        boolean condicion = false;
        for (int[] array : matriz) {
            for (int i : array) {
                if (i == numero) {
                    condicion = true;
                    break;
                }
            }
        }
        return condicion;
    }


} //Fin de la clase