import java.util.Scanner;

public class Tema2 {
    //objeto Scanner
    static Scanner read = new Scanner(System.in);

    public static void main(String[] args) {


        //ENTRADA DE DATOS DE USUARIO


        //Escribe un programa que lea tres números con un objeto Scanner y escriba la media.
        //ejercicio04();

        //Escriba un programa que lea las coordenadas de dos puntos y calcule su distancia.
        //ejercicio06();


        //ENUMERADOS

        //Escriba un programa que defina un enumerado para los días de la semana. En el programa defina una variable del enumerado y asígnele
        //el valor del día que corresponde al martes. A continuación, escriba por pantalla dicha variable y escriba el valor del enumerado
        //correspondiente al domingo.
        //ejercicio01enumerados();

        //Escriba en java los siguientes tipos enumerados: Los días laborables, los tres primeros meses del año, las calificaciones de un alumno,
        //los colores primarios, las notas musicales, los colores del arcoiris, los colores de síntesis de televisión

        //VARIABLES Y OPERACIONES ARITMÉTICAS

        // Pedir el peso y la estatura en metros y calcular el índice de masa corporal (IMC) (se calcula dividiendo los kilogramos de peso
        // por el cuadrado de la estatura en metros (IMC = peso (kg)/ [estatura (m)]2)
        //ejercicio04variables();

        // Realizar un programa para calcular cuánto tiene que pagar un usuario de factura de gas,
        // pidiéndole cuantos metros cúbicos de gas ha consumido y cuál es el precio del consumo.
        // Por ejemplo si ha consumido 200m³ para una tarifa en la que el precio del consumo es de 0,0570 €/kWh.
        // y con un factor de conversión, de 11,70 kWh por cada metro cúbico de gas consumido sería (200 x 11,70) x 0,0570 = 133,38
        // Guardar el factor de conversión en una constante.
        // ejercicio06variables();

        /* Prioridad y orden de evaluación en expresiones aritméticas

        Dadas las siguientes expresiones aritmético-lógicas calcula cuál es el resultado de evaluarlas,
        sin escribir el programa en Java y justificando la respuesta.

        25 > 20 & 13 > 5

        En este ejercicio primero se van a comprobar los operadores de relación y después el operador AND bit a bit.
        Como las dos desigualdades son verdaderas, el operador AND leerá primero una, luego la otra, y devolverá un valor verdadero
        porque las dos son correctas

        10 + 4 < 15 - 3 || 2 * 5 + 1 > 14 -2 * 2

        En este ejercicio primero se van a ejecutar los operadores multiplicativos, después
        los aditivos, luego los operadores de relación y por último el operador lógico OR. Tendríamos 14<12 || 11>10, el operador lógico
        comprueba la primera desigualdad y ve que es falso, entonces continua para comprobar la segunda y ve que es verdadera,
        así que devuelve valor verdadero

        4 * 2 <= 8 || 2 * 2 < 5 && 4 > 3 + 1

        8<=8 || 4<5 && 4>4   El operador lógico AND comprueba el primer valor, que es verdadero,
        por lo tanto continúa y comprueba el segundo, que es falso. Devuelve falso. El operador lógico OR comprueba el primer valor,
        que es verdadero, por lo tanto no continúa y directamente devuelve valor verdadero

        10 <= 2 * 5 && 3 < 4 || ! (8 > 7) && 3 * 2 <= 4*2 - 1

        10<=10 && 3<4 || !(8>7) && 6<=7 El primer AND devuelve verdadero porque se cumplen ambas condiciones.
        El segundo AND devuelve falso porque al comprobar la primera condición es falsa, dado que el NOT convierte el verdadero
        del operador de relación en falso. Por último, el operador lógico OR devuelve verdadero al comprobar la primera
        condición y ser esta verdadera. No sigue comprobando porque con eso es suficiente

         */

        //Investigar cómo podríamos escribir un programa para intercambiar el valor de a y b utilizando solo dos variables
        //y el operador bit a bit XOR
        //ejercicio06bits();

        //Pedir los coeficientes de una ecuación de segundo grado (a, b y c) y mostrar sus soluciones reales. Si no existen debe indicarlo.
        //ejercicio01imperativa();

        // Los empleados de una fábrica trabajan por turnos: diurno y nocturno. Se debe calcular el jornal diario de acuerdo
        // con los siguientes puntos:
        //— La tarifa por horas diurnas es de 20 €.
        //— La tarifa por horas nocturnas es de 35 €.
        //— Caso de ser domingo, la tarifa se incrementará en 10 € más para el turno diurno y 15 € más para el nocturno.
        //ejercicio06imperativa();

        //Un menú para poder seleccionar los ejercicios
        int key, eje;
        eje = key = 0;

        //Un bucle para que el menú no desaparezca hasta que lo pida el usuario
        while (key != 6) {

            System.out.println("\nElige tu ejercicio");
            System.out.println("1. Entrada de datos de usuario");
            System.out.println("2. Enumerados");
            System.out.println("3. Variables y operaciones aritméticas");
            System.out.println("4. Operaciones a nivel de bits");
            System.out.println("5. Ejercicios extra de programación imperativa");
            System.out.println("6. Salir");

            key = read.nextInt();

            //Con este switch sacamos todas las opciones a consultar posibles, y cuando hay varias opciones metemos otro switch para
            //poder acceder a ellas

            switch (key) {

                case 1:
                    while (eje != 3) {
                        System.out.println("Elige tu ejercicio:");
                        System.out.println("1. Media de tres números");
                        System.out.println("2. Distancia entre coordenadas");
                        System.out.println("3. Salir");
                        eje = read.nextInt();
                        switch (eje) {
                            case 1:
                                ejercicio04();
                                break;
                            case 2:
                                ejercicio06();
                                break;

                        }

                    }
                    eje = 0;
                    break;
                case 2:
                    ejercicio01enumerados();
                    break;

                case 3:
                    while (eje != 3) {
                        System.out.println("Elige tu ejercicio:");
                        System.out.println("1. Calcular IMC");
                        System.out.println("2. Pagar factura del gas");
                        System.out.println("3. Salir");
                        eje = read.nextInt();
                        switch (eje) {
                            case 1:
                                ejercicio04variables();
                                break;
                            case 2:
                                ejercicio06variables();
                                break;

                        }
                    }
                    eje = 0;
                    break;

                case 4:
                    ejercicio06bits();
                    break;

                case 5:
                    while (eje != 3) {
                        System.out.println("Elige tu ejercicio:");
                        System.out.println("1. Ecuación de segundo grado");
                        System.out.println("2. Jornal diario");
                        System.out.println("3. Salir");
                        eje = read.nextInt();
                        switch (eje) {
                            case 1:
                                ejercicio01imperativa();
                                break;
                            case 2:
                                ejercicio06imperativa();
                                break;

                        }


                    }
                    eje = 0;
                    break;

            }
        }


    }

    private static void ejercicio06imperativa() {

        /*
        Datos de entrada: número de horas de la jornada laboral diurnas y nocturnas y día en el que se trabaja
        Datos de salida: jornal diario del día elegido
         */

        double horasDiurnas, horasNocturnas;
        boolean valido;
        boolean domingo = false;

        //Este bucle sirve para que no puedan meter una combinación de horas incorrecta
        do {
            System.out.println("Escribe el número de horas que trabajas en horario diurno:");
            horasDiurnas = read.nextDouble();
            System.out.println("Escribe el número de horas que trabajas en horario nocturno:");
            horasNocturnas = read.nextDouble();

            //Mensaje de error que aparece si introduces una combinación de horas incorrecta
            if ((horasDiurnas + horasNocturnas) > 24 | (horasDiurnas + horasNocturnas) < 0) {
                System.out.println("Algo ha fallado. Por favor, introduce una combinación de horas correcta.");
            }

        } while ((horasDiurnas + horasNocturnas) > 24 || (horasDiurnas + horasNocturnas) < 0);

        System.out.println("Introduce el día de la semana:");

        //Este bucle sirve para que no se pueda introducir un día incorrecto.
        //Se podría saber si trabaja en domingo de manera más sencilla obligando al usuario a elegir entre opciones preestablecidas.
        //He decidido resolverlo así para practicar con tipos enumerados por motivos didácticos

        read.nextLine(); //Utilizamos esto para limpiar el scanner porque hemos usado enteros antes
        do {
            try {
                if (DiaSemana.valueOf(read.nextLine().toUpperCase()) == DiaSemana.DOMINGO) {
                    domingo = true;
                }
                valido = true;
            } catch (Exception e) {
                System.out.println("Introduce un día válido:");
                valido = false;
            }
        } while (!valido);

        if (domingo) {
            System.out.println("Tu jornal es " + (horasDiurnas * 30 + horasNocturnas * 50) + " €");
        } else System.out.println("Tu jornal es " + (horasDiurnas * 20 + horasNocturnas * 35) + " €");

    }

    private static void ejercicio01imperativa() {

        /*
        Datos de entrada: coeficientes de la ecuación de segundo grada
        Datos de salida: soluciones de la ecuación de segundo grado
         */

        double a, b, c, discriminante, sol1, sol2;

        System.out.println("La estructura de una ecuación de segundo grado es ax²+bx+c=0");
        System.out.println("Escribe el coeficiente a:");
        a = read.nextDouble();

        //Este bucle es para evitar que se introduzca el 0 en el coeficiente a
        while (a == 0) {
            System.out.println("Si el coeficiente a es 0 el término cuadrático desaparece y deja de ser una ecuación de segundo grado.");
            System.out.println("Escribe el coeficiente a:");
            a = read.nextDouble();

        }

        System.out.println("Escribe el coeficiente b:");
        b = read.nextDouble();
        System.out.println("Escribe el coeficiente c:");
        c = read.nextDouble();
        //Calculamos aquí el discriminante de la ecuación de segundo grado para poder comprobar el número de soluciones de la ecuación más facilmente
        discriminante = Math.pow(b, 2.0) - 4 * a * c;
        sol1 = (-b + Math.sqrt(discriminante)) / (2 * a); //Aplicación de la fórmula para la primera solución
        sol2 = (-b - Math.sqrt(discriminante)) / (2 * a); //Aplicación de la fórmula para la segunda solución

        //Cuando el discriminante es positivo la ecuación tiene dos soluciones
        if (discriminante > 0) {

            System.out.format("La primera solución es %.2f y la segunda solución es %.2f", sol1, sol2);
        }
        //Cuando el discriminante es 0 la solución es la misma así que solo imprimimos una y decimos que es solución doble
        else if (discriminante == 0) {
            System.out.format("La solución es %.2f y es una solución doble.", sol1);
        }
        //Cuando el discriminante es menor que 0 no hay solución
        else System.out.println("Esta ecuación no tiene solución en el campo de los números reales.");
    }

    private static void ejercicio06bits() {

        /*
        Datos de entrada: dos números enteros
        Datos de salida: los mismos dos números pero con el orden invertido
         */

        int a, b;
        System.out.println("Escribe el primero número:");
        a = read.nextInt();
        System.out.println("Escribe el segundo número:");
        b = read.nextInt();

        a = a ^ b; //Sustituimos la variable a por la operación XOR entre a y b y nos genera un "número puente"
        b = a ^ b; //Gracias al "número puente", si volvemos aplicar XOR entre a y b nos devuelve el primer valor
        a = a ^ b; //Volvemos a aplicar XOR entre el "número puente", que sigue guardado en a, para cambiar el valor de a por su valor inicial

        System.out.format("El primer número es ahora %d y el segundo es %d", a, b);
    }

    private static void ejercicio06variables() {

        /*
        Datos de entrada: volumen de gas y precio del kW/h
        Datos de salida: Precio de la factura
         */

        double volumen, precio, coste;
        final double CONVERSION;

        CONVERSION = 11.70;
        System.out.println("Introduce el volumen de gas consumido en metros cúbicos:");
        volumen = read.nextDouble();
        System.out.println("Introduce el precio del kW/h:");
        precio = read.nextDouble();
        coste = volumen * CONVERSION * precio; //Fórmula para el cálculo del coste de la factura

        System.out.format("El precio de la factura es: %.3f €", coste);
    }

    private static void ejercicio04variables() {

         /*
        Datos de entrada: peso y estatura de una persona
        Datos de salida: su índice de masa corporal IMC
         */

        double peso, estatura, imc;
        System.out.println("Introduce tu peso en Kg:");
        peso = read.nextDouble();
        System.out.println("Introduce tu altura en metros:");
        estatura = read.nextDouble();
        imc = peso / Math.pow(estatura, 2.0); //Operación para calcular el IMC

        System.out.format("Para un peso de %.2f y una estatura de %.2f el IMC es de %.2f\n", peso, estatura, imc);
    }

    private static void ejercicio01enumerados() {

         /*
        Datos de entrada:
        Datos de salida: día de la semana en texto y cardinal asociado al domingo
         */

        DiaSemana dia = DiaSemana.MARTES;
        System.out.println(dia);
        System.out.println(DiaSemana.DOMINGO.ordinal());
    }

    private static void ejercicio06() {

         /*
        Datos de entrada: coordenadas de dos puntos en el plano
        Datos de salida: distancia entre los dos puntos
         */

        double x1, x2, y1, y2, dist;
        System.out.println("Escribe la primera coordenada de X:");
        x1 = read.nextDouble();
        System.out.println("Escribe la segunda coordenada de X:");
        x2 = read.nextDouble();
        System.out.println("Escribe la primera coordenada de Y:");
        y1 = read.nextDouble();
        System.out.println("Escribe la segunda coordenada de Y:");
        y2 = read.nextDouble();
        dist = Math.pow(Math.pow(x2 - y2, 2.0) + Math.pow(x1 - y1, 2.0), 1.0 / 2.0); //Aplicación del teorema de Pitágoras con la clase Math
        System.out.format("La distancia entre (%.2f, %.2f) y (%.2f, %.2f) es %.2f\n", x1, x2, y1, y2, dist);

    }

    private static void ejercicio04() {

         /*
        Datos de entrada: tres números
        Datos de salida: la media de los tres números
         */

        double num1, num2, num3;
        System.out.println("Vamos a calcular la media de 3 números.");
        System.out.println("Introduce el primer número: ");
        num1 = read.nextDouble();
        System.out.println("Introduce el segundo número: ");
        num2 = read.nextDouble();
        System.out.println("Introduce el tercer número: ");
        num3 = read.nextDouble();

        System.out.println("La media de " + num1 + ", " + num2 + " y " + num3 + " es: " + ((num1 + num2 + num3) / 3));
    }

    enum DiaSemana {LUNES, MARTES, MIERCOLES, JUEVES, VIERNES, SABADO, DOMINGO}

}