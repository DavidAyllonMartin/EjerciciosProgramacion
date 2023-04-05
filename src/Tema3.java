import java.util.Scanner;

public class Tema3 {

    static Scanner read = new Scanner(System.in);

    public static void main(String[] args) {
        imprimirTrianguloDescendente(7);
    }//Fin del Main

    public static void imprimirPrimos(int n) {
        for (int i = 2; i <= n; i++) {
            if (esPrimo(i))
                System.out.print(i + " ");
        }
    }

    public static boolean esPrimo(int n) {
        for (int i = 2; i <= (n / 2); i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }

    public static String textoDelReves(String texto) {
        String reves = "";
        for (int i = 1; i <= texto.length(); i++) {
            reves = reves + texto.charAt(texto.length() - i);
        }
        return reves;
    }

    /* Escriba la función String textoDelReves (String texto) que recibe una cadena de texto y devuelve la cadena de
     texto del revés
     */

    public static void imprimirTriangulo(int n) {
        int altura = n / 2;
        for (int i = 1; i <= n; i += 2) {
            for (int j = altura; j > 0; j--) {
                System.out.print(" ");
            }
            for (int k = 1; k <= i; k++) {
                System.out.print("*");
            }
            System.out.println();
            altura--;
        }
    }

    /* Implemente la función imprimirTriangulo (int n) que recibe un número entero n y después de comprobar que es
    igual o mayor que cero que imprimirá mediante dos for anidados un triangulo con n asteriscos de base.
     */

    /* Implemente la función imprimirCuadrado (int n) que recibe un número entero n y después de comprobar que es que
     igual o mayor que cero imprimirá un cuadrado de n elementos con asteriscos utilizando dos for anidados.
    */
    public static void imprimirCuadrado(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void imprimirTrianguloAscendente(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
    /*Implemente la función imprimirTrianguloAscentente (int n) que recibe un número entero n y después de comprobar
    que es que igual o mayor que cero imprimirá mediante dos for anidados un triángulo ascendente con asteriscos.*/

    /* Implemente la función imprimirTrianguloDescentente (int n) que recibe un número entero n y después de comprobar
     que es que igual o mayor que cero imprimirá mediante dos for anidados un triángulo descendente con asteriscos.
     */
    public static void imprimirTrianguloDescendente(int n) {
        for (int i = n; i > 0; i--) {
            for (int j = i; j > 0; j--) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void imprimirTrianguloDescendente2(int n) {
        for (int i = 0; i <= n; i++) {
            for (int j = n - i; j > 0; j--) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    /* Escribir la función float media (float ...  notas), que reciba un número variable de notas de tipo float de una
     asignatura y calcule la media utilizando un bucle while en formato float también.
     */
    static float media(float... notas) {
        float suma = 0;
        for (float nota : notas) {
            suma += nota;
        }
        return suma / notas.length;
    }

    static Notas obtenerNota(int nota) {
        if (nota >= 0 && nota < 5) {
            return Notas.INSUFICIENTE;
        } else if (nota == 5) {
            return Notas.SUFICIENTE;
        } else if (nota == 6) {
            return Notas.BIEN;
        } else if (nota == 7 || nota == 8) {
            return Notas.NOTABLE;
        } else if (nota == 9 || nota == 10) {
            return Notas.SOBRESALIENTE;
        } else return Notas.ERROR;

    }

    /* Crear una función llamada enum Notas obtenerNota (int nota) que reciba nota del 0 al 10 y devuelva un
    enum Notas con los valores INSUFICIENTE, SUFICIENTE, BIEN, NOTABLE, SOBRESALIENTE y ERROR. En caso de que la
    nota sea menor que 0 o mayor que 10 devolverá ERROR. */

    static boolean esMayorEdad(int dia, int mes, int anio) {

        java.util.Date date = new java.util.Date();
        java.time.LocalDate localDate = date.toInstant().atZone(java.time.ZoneId.systemDefault()).toLocalDate();
        int year = localDate.getYear();
        int month = localDate.getMonthValue();
        int day = localDate.getDayOfMonth();

        if ((anio - 18) > year) {
            return true;
        } else if ((anio - 18) == year && mes > month) {
            return true;
        } else return mes == month && dia >= day;
    }

    /* Crear una función llamada boolean esMayorEdad que reciba por parámetro el día, el mes y el año de nacimiento e
    indicar si es mayor de edad en la fecha de hoy.*/

    static String cambioEnMonedas(double dinero) {
        int parteEntera = (int) dinero;
        int parteDecimal = (int) ((dinero - parteEntera) * 100);
        int mon200, mon100, mon50, mon20, mon10, mon5, mon2, mon1;
        mon200 = parteEntera / 2;
        mon100 = parteEntera % 2;
        mon50 = parteDecimal / 50;
        mon20 = (parteDecimal % 50) / 20;
        mon10 = (parteDecimal % 20) / 10;
        mon5 = (parteDecimal % 10) / 5;
        mon2 = (parteDecimal % 5) / 2;
        mon1 = parteDecimal % 2;

        return String.format("%d de 2€, %d de 1€, %d de 0.5€, %d de 0.2€, %d de 0.1€, %d de 0.05€, %d de 0.02€ y %d de 0.01€", mon200, mon100, mon50, mon20, mon10, mon5, mon2, mon1);
    }

    /* Escriba una función llamada cambioEnMonedas, que reciba por parámetro un valor real que indica la cantidad de
    dinero en euros. El método imprime por pantalla la cantidad de monedas de cada tipo, en que se debe devolver la
    cantidad de dinero indicada. */

    static String obtenerSiguienteDia(int dia, int mes, int anio) {

        if (esFechaCorrecta(dia, mes, anio)) {
            dia++;
            switch (mes) {
                case 1:
                case 3:
                case 5:
                case 7:
                case 8:
                case 10:
                case 12:
                    if (dia == 32) {
                        dia = 1;
                        mes++;
                        if (mes == 13) {
                            mes = 1;
                            anio++;
                        }
                    }
                    break;

                case 4:
                case 6:
                case 9:
                case 11:
                    if (dia == 31) {
                        dia = 1;
                        mes++;
                    }
                    break;
                case 2:
                    if (((anio % 4 == 0) && ((anio % 100 != 0) || (anio % 400 == 0))) && dia == 29) {
                        dia = 1;
                        mes++;
                    } else if (dia == 28) {
                        dia = 1;
                        mes++;
                    }
                    break;
            }
            return String.format("%02d/%02d/%d", dia, mes, anio);
        } else return "La fecha es incorrecta";

    }

    /* Crear una función llamada String obtenerSiguienteDía (int dia, int mes, int año) que reciba por parámetro el día,
     el mes y el año de una fecha y si es la fecha correcta, devuelva el siguiente String con el formato dd-mm-yyyy
     teniendo en cuenta meses de 28, 30 y 31 días y años bisiestos. */

    static boolean esFechaCorrectaOld(int dia, int mes, int anio) {
        return 1 <= dia && dia <= 30 && mes >= 1 && mes <= 12 && anio >= 1582;
    }


    /* Crear una función llamada boolean  esFechaCorrecta(int dia, int mes, int año) que reciba por parámetro el día,
    el mes y el año de una fecha y devuelva true si es correcto o false en caso contrario. Suponer que todos los meses
    son de 30 días. */

    static boolean esFechaCorrecta2(int dia, int mes, int anio) {
        switch (mes) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                return dia <= 31;
            case 4:
            case 6:
            case 9:
            case 11:
                return dia <= 30;
            case 2:
                if (dia <= 28) {
                    return true;
                } else return dia <= 29 && esBisiesto(anio);
            default:
                return false;
        }
    }

    static boolean esBisiesto(int anio) {
        return (anio % 4 == 0) && ((anio % 100 != 0) || (anio % 400 == 0));
    }

    static boolean esFechaCorrecta(int dia, int mes, int anio) {
        if (anio >= 1582 && dia > 0 && dia <= 31 && mes > 0 && mes <= 12) {
            if (mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8 || mes == 10 || mes == 12) {
                return true;
            } else if (mes == 2) {
                if (esBisiesto(anio)) {
                    return dia <= 29;
                } else return dia <= 28;
            } else {
                return dia <= 30;
            }
        } else return false;
    }

    private static boolean esCapicua(int numero) {

        if (numero >= 0 && numero <= 9999) {
            return numero == invertirCifras(numero);
        } else return false;

    }

    /* Crear una función llamada boolean esCapicua (short numero) que reciba un número short entre 0 y 9999
        y devuelva true si es capicua y false en caso contrario, en caso de recibir un número menor a 0 o mayor
        a 9999 devolverá también false. */

    //System.out.println(esCapicua(444)==true?"ok":"false");

    /* Crear una función llamada short invertirCifras (short numero) que reciba un número short entre 0 y 9999
    y devuelva el número al revés, en caso de recibir un número menor a 0 o mayor a 9999 devolverá -1. */
    private static int invertirCifras(int numero) {

        if (numero > 0 && numero < 9999) {
            int n, pos, invertido;
            invertido = 0;
            n = contarCifras(numero);
            pos = (int) Math.pow(10.0, n - 1);
            do {
                invertido = invertido + (pos * (numero % 10));
                numero = numero / 10;
                pos = pos / 10;
            } while (numero != 0);
            return invertido;
        } else return -1;
    }

    private static int contarCifras(int numero) {
        if (numero > 0 && numero < 9999)
            return (int) Math.ceil(Math.log10(numero));
        else return -1;
    }

    /* Crear una función llamada short contarCifras (short numero) que reciba un número short y devuelva el número
    de cifras tiene, en caso de recibir un número menor a 0 o mayor a 9999  devolverá -1. */

    private static int contarCifras2(int numero) {
        if (numero > 0 && numero < 9999) {
            int n = 0;
            do {
                numero = numero / 10;
                n++;
            } while (numero != 0);
            return n;
        } else return -1;
    }

    private static int aleatorio(int min, int max) {

        int numero = (int) (Math.random() * (max + 1 - min) + min);
        if (max >= min) {
            return numero;
        } else return -1;
    }

    private static boolean sonMultiplos(int a, int b) {

        return ((Math.max(a, b))) % (Math.min(a, b)) == 0;
    }

    private static double salario(double horas, double precio) {

        if (horas <= 40) {
            return (horas * precio);
        } else return (40 * precio + (horas - 40) * precio * 1.5);
    }

    /* Escribe una función salario() que calcule el dinero que debe cobrar un trabajador a la semana,
    pasándole como parámetros, el número de horas semanales que ha trabajado y el precio que se le paga
     por cada hora. Si ha trabajado más de 40 horas, el salario de cada hora adicional es 1,5 (un 50% más)
      veces el de las horas  */

    enum Notas {INSUFICIENTE, SUFICIENTE, BIEN, NOTABLE, SOBRESALIENTE, ERROR}

}//Fin de la clase
