/**Samuel Rincon Rodirguez y Marco rodriguez **/ 
import java.util.Scanner;

public class Arreglo {
    public static void main(String[] args) {
        String[] nombre = new String[30];
        float[] salario = new float[30];
        char[] sexo = new char[30];
        String[] cargo = new String[30];

        boolean ACTIVO = true;
        Scanner datos = new Scanner(System.in);
        int totalUsuarios = 0;
        char opcion;
        int posEditar;
        int posBorrar;
        String lineaDatos;
        char subopcion;

        while (ACTIVO) {
            opcion = menu();
            switch (opcion) {
                case '1':
                    if (totalUsuarios < 30) {
                        System.out.println("Escriba el nombre de usuario:");
                        nombre[totalUsuarios] = datos.nextLine();

                        System.out.println("Escriba el salario del usuario:");
                        salario[totalUsuarios] = datos.nextFloat();
                        datos.nextLine();

                        System.out.println("Escriba el sexo del usuario (M/F):");
                        lineaDatos = datos.nextLine();
                        sexo[totalUsuarios] = lineaDatos.charAt(0);

                        System.out.println("Escriba el cargo del usuario:");
                        cargo[totalUsuarios] = datos.nextLine();

                        totalUsuarios++;
                    } else {
                        System.out.println("No se pueden agregar mas usuarios (maximo 30).");
                    }
                    break;

                case '2':
                    if (totalUsuarios == 0) {
                        System.out.println("No hay usuarios registrados.");
                    } else {
                        for (int i = 0; i < totalUsuarios; i++) {
                            System.out.println("\nUsuario #" + i);
                            System.out.println("Nombre: " + nombre[i]);
                            System.out.println("Salario: " + salario[i]);
                            System.out.println("Sexo: " + sexo[i]);
                            System.out.println("Cargo: " + cargo[i]);
                        }
                    }
                    break;

                case '3':
                    if (totalUsuarios == 0) {
                        System.out.println("No hay usuarios para editar.");
                    } else {
                        System.out.println("Ingrese la posicion del usuario a editar (0 - " + (totalUsuarios - 1) + "):");
                        posEditar = datos.nextInt();
                        datos.nextLine();

                        if (posEditar >= 0 && posEditar < totalUsuarios) {
                            subopcion = editar();
                            if (subopcion == '1') {
                                System.out.println("Nuevo nombre:");
                                nombre[posEditar] = datos.nextLine();
                            } else if (subopcion == '2') {
                                System.out.println("Nuevo salario:");
                                salario[posEditar] = datos.nextFloat();
                                datos.nextLine();
                            } else if (subopcion == '3') {
                                System.out.println("Nuevo sexo (M/F):");
                                lineaDatos = datos.nextLine();
                                sexo[posEditar] = lineaDatos.charAt(0);
                            } else if (subopcion == '4') {
                                System.out.println("Nuevo cargo:");
                                cargo[posEditar] = datos.nextLine();
                            } else {
                                System.out.println("Edicion cancelada.");
                            }
                        } else {
                            System.out.println("Posicion invalida.");
                        }
                    }
                    break;

                case '4':
                    if (totalUsuarios == 0) {
                        System.out.println("No hay usuarios para borrar.");
                    } else {
                        System.out.println("Ingrese la posicion del usuario a borrar (0 - " + (totalUsuarios - 1) + "):");
                        posBorrar = datos.nextInt();
                        datos.nextLine();

                        if (posBorrar >= 0 && posBorrar < totalUsuarios) {
                            for (int i = posBorrar; i < totalUsuarios - 1; i++) {
                                nombre[i] = nombre[i + 1];
                                salario[i] = salario[i + 1];
                                sexo[i] = sexo[i + 1];
                                cargo[i] = cargo[i + 1];
                            }
                            nombre[totalUsuarios - 1] = "";
                            salario[totalUsuarios - 1] = 0;
                            sexo[totalUsuarios - 1] = ' ';
                            cargo[totalUsuarios - 1] = "";

                            totalUsuarios--;
                            System.out.println("Usuario borrado.");
                        } else {
                            System.out.println("Posicion invalida.");
                        }
                    }
                    break;

                case '5':
                    ACTIVO = false;
                    break;

                default:
                    System.out.println("Opcion no reconocida.");
            }
        }

        datos.close();
    }

    public static char menu() {
        Scanner input = new Scanner(System.in);
        System.out.println("-----------------------");
        System.out.println("|       Menu          |");
        System.out.println("| 1 - Crear usuario   |");
        System.out.println("| 2 - Ver usuarios    |");
        System.out.println("| 3 - Editar usuario  |");
        System.out.println("| 4 - Borrar usuario  |");
        System.out.println("| 5 - Terminar        |");
        System.out.println("-----------------------");
        System.out.print("Opcion: ");
        String entrada = input.nextLine();
        return entrada.charAt(0);
    }

    public static char editar() {
        Scanner input = new Scanner(System.in);
        System.out.println("-----------------------");
        System.out.println("|   Editar usuario    |");
        System.out.println("| 1 - Nombre          |");
        System.out.println("| 2 - Salario         |");
        System.out.println("| 3 - Sexo            |");
        System.out.println("| 4 - Cargo           |");
        System.out.println("| 5 - Cancelar        |");
        System.out.println("-----------------------");
        System.out.print("Opcion: ");
        String entrada = input.nextLine();
        return entrada.charAt(0);
    }
}
