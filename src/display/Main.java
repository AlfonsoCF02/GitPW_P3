package display;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

import business.kart.KartDTO;
import business.kart.kartstat;
import business.pista.GestorPistas;
import business.pista.PistaDTO;
import business.pista.diff;
import business.reserva.GestorReservas;
import business.reserva.ModalidadReservaBono;
import business.reserva.ModalidadReservaIndividual;
import business.usuario.GestorUsuario;
import business.usuario.UsuarioDTO;

/**
 * A class that implements the system menu
 * @author Victoria Muñoz
 * @author Alfonso de la Torre
 * @author Alfonso Cabezas
 * @author Abraham Cordoba
 * */
@SuppressWarnings("deprecation")
public class Main {

	public static void main(String[] args) throws IOException, ParseException, SQLException {
		
	Scanner snoption = new Scanner(System.in);
	Scanner snoptionuser = new Scanner(System.in);
	Scanner snoptiontrack = new Scanner(System.in);
	Scanner snoptionbooking = new Scanner(System.in);
	
	boolean exit = false;
	boolean exituser = false;
	boolean exittrack = false;
	boolean exitbooking = false;
	
	int option;
	
	while(!exit) {
		System.out.println("------------------------------------------------------");
		System.out.println("Programa que permite la gestion de circuitos de karts");
		System.out.println("MENU GENERAL:");
		System.out.println("1. Opcion 1: Gestionar UsuarioDTO");
		System.out.println("2. Opcion 2: Gestionar PistaDTO");
		System.out.println("3. Opcion 3: Gestionar Reserva");
		System.out.println("4. Opcion 4: Salir del Menu General");
		
		try {
		
		System.out.println("\nIntroduzca el numero de la opcion que desee realizar:\n ");
		option = snoption.nextInt();
		
			switch(option) {
				case 1:
					while(!exituser) {
					System.out.println("\nHas elegido la opcion 1: Gestionar UsuarioDTO\n");
					
					System.out.println("MENU DE USUARIO:");
					System.out.println("1. Opcion 1: Registrar nuevo usuario");
					System.out.println("2. Opcion 2: Modificar usuario");
					System.out.println("3. Opcion 3: Listar todos los usuarios");
					System.out.println("4. Opcion 4: Salir del menu de usuario");
					
					
					try {
						System.out.println("\nIntroduzca el numero de la opcion que desee realizar:\n ");
						
						int optionuser = snoptionuser.nextInt();
						
						switch(optionuser) {
						
						case 1:
							System.out.println("\nElegiste Opcion 1: Registrar nuevo usuario\n");
							InputStreamReader isr = new InputStreamReader(System.in);
							BufferedReader br = new BufferedReader (isr);
							GestorUsuario alta=new GestorUsuario();
							String name, surname, birth_string, firstB_string, email;
							Date birth, firstB;
							System.out.println("Introduzca el nombre:");
							name=br.readLine();
							System.out.println("Introduzca el apellido:");
							surname=br.readLine();
							System.out.println("Introduzca el email:");
							email=br.readLine();
							System.out.println("Introduzca la fecha de nacimiento (debe seguir el formato 'yyyy-MM-dd'):");
							birth_string = br.readLine();
							birth = new Date();
					        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
					        birth = format.parse(birth_string);
					        //NO FUNCIONA
					        LocalDate fechaSys = LocalDate.now();
					        firstB =  format.parse(fechaSys.toString());

					        
							int status=alta.altaUsuario(name, surname, email, birth,firstB);
							if(status==0) {
								System.out.println("El usuario ha sido introducido correctamente\n");
							}else if(status==-1) {
								System.out.println("El usuario ya existe\n");
							}
							break;
							
						case 2:
							System.out.println("\nElegiste Opcion 2: Modificar usuario\n");
							InputStreamReader isr2 = new InputStreamReader(System.in);
							BufferedReader br2 = new BufferedReader (isr2);
							GestorUsuario modi=new GestorUsuario();
							String name2, surname2, birth_string2, firstB_string2, email2;
							Date birth2, firstB2;
							System.out.println("Introduzca el nombre:");
							name2=br2.readLine();
							System.out.println("Introduzca el apellido:");
							surname2=br2.readLine();
							System.out.println("Introduzca el email:");
							email2=br2.readLine();
							System.out.println("Introduzca la fecha de nacimiento (debe seguir el formato 'yyyy-MM-dd'):");
							birth_string2 = br2.readLine();
							birth2 = new Date();
					        SimpleDateFormat format3 = new SimpleDateFormat("yyyy-MM-dd");
					        birth2 = format3.parse(birth_string2);
					        
					        LocalDate fechaSys2 = LocalDate.now();
					        firstB2 =  format3.parse(fechaSys2.toString());
							
					        
							int status2=modi.modificarUsuario(name2, surname2, email2, birth2, firstB2);
							if(status2==0) {
								System.out.println("Modificacion realizada con exito\n");
							}else {
								System.out.println("El usuario no existe\n");
							}
							break;
							
							
							
						case 3:
							System.out.println("\nElegiste Opcion 3: Listar todos los usuarios\n");
							GestorUsuario listar = new GestorUsuario();
							System.out.println(listar.listarUsuarios());
							break;
							
						case 4:
							System.out.println("\nElegiste Opcion 4: Salir del menu de usuario\n");
							exituser = true;
							break;
							
						default:
							System.out.println("\nTienes que elegir una opcion (numero) entre 1 y 4\n");
						}
					}catch(InputMismatchException e){ //Make a verification about the entered data
							System.out.println("\nDebes introducir un numero\n");
							snoptionuser.next();
						 }
				    }
					break;
				
				case 2:
					while(!exittrack) {
					System.out.println("------------------------------------------------------");
					System.out.println("Has elegido la opcion 2: Gestionar PistaDTO\n");
					
					System.out.println("MENU DE PISTAS:");
					System.out.println("1. Opcion 1: Crear PistaDTO");
					System.out.println("2. Opcion 2: Crear Kart");
					System.out.println("3. Opcion 3: Asociar Kart a PistaDTO");
					System.out.println("4. Opcion 4: Mostrar las pistas en mantenimiento");
					System.out.println("5. Opcion 5: Mostrar las pistas libres");
					System.out.println("6. Opcion 6: Salir del menu de pistas");
					
					System.out.println("\nIntroduzca el numero de la opcion que desee realizar:\n ");
					try {
						int optiontrack = snoptiontrack.nextInt();
						switch(optiontrack) {
						
						case 1:
							System.out.println("\nElegiste Opcion 1: Crear PistaDTO\n");
							InputStreamReader isr = new InputStreamReader(System.in);
							BufferedReader br = new BufferedReader (isr);
							Scanner idscan = new Scanner(System.in);
							GestorPistas cPista = new GestorPistas();
							String nombre, estado_st;
							int numero;
							Boolean estado;
							diff dificultad;
							
							System.out.println("Introduzca el nombre:");
							nombre=br.readLine();
							System.out.println("Introduzca false si NO esta disponible y true en caso contrario");
							estado_st = br.readLine();
							while(!(estado_st.equals("true") || estado_st.equals("false"))) {
								System.out.println("Error, debe introducir true o false:");
								estado_st = br.readLine();
							}
							estado=false;
							if(estado_st.equals("true")) {
								estado=true;
							}
							
							System.out.println("Introduzca el numero maximo de karts:");
							numero=idscan.nextInt();
							System.out.println("Introduzca la dificultad (child, family, adult):");
							String tipo=idscan.next();
							
							while(!(tipo.equals("child") || tipo.equals("family") || tipo.equals("adult"))) {
								System.out.println("Error, debe introducir child, family o adult:");
								tipo=idscan.next();
							}
							
							if(tipo.equals("child")) {
								dificultad=diff.child;
								int status=cPista.crearPista(nombre,estado,numero,dificultad);
								if(status==0) {
									System.out.println("La pista ha sido introducida correctamente\n");
								}else if(status==-1) {
									System.out.println("La pista ya existe\n");
								}								
							}
							else if(tipo.equals("family")) {
								dificultad=diff.family;
								int status=cPista.crearPista(nombre,estado,numero,dificultad);
								if(status==0) {
									System.out.println("La pista ha sido introducida correctamente\n");
								}else if(status==-1) {
									System.out.println("La pista ya existe\n");
								}
							}
							else if(tipo.equals("adult")) {
								dificultad=diff.adult;
								int status=cPista.crearPista(nombre,estado,numero,dificultad);
								if(status==0) {
									System.out.println("La pista ha sido introducida correctamente\n");
								}else if(status==-1) {
									System.out.println("La pista ya existe\n");
								}
							}							

							break;
							
						case 2:
							System.out.println("\nElegiste Opcion 2: Crear Kart\n");
							int idKart;
							boolean type;
							String tipo1;
							kartstat estadoKart;
							Scanner idscanKart = new Scanner(System.in);
							GestorPistas cKart = new GestorPistas();
							
							idKart=0; //Da igual el id, ya que al ser auto increment, la BD se encargara de asignarle un id
							System.out.println("Introduzca false si es para niños y true si es para adultos:");
							tipo1=idscanKart.next();
							while(!(tipo1.equals("true") || tipo1.equals("false"))) {
								System.out.println("Error, debe introducir true o false:");
								tipo1=idscanKart.next();
							}
							type=Boolean.parseBoolean(tipo1);
							System.out.println("Introduzca el estado (reservado, mantenimiento, disponible):");
							String typeKart=idscanKart.next();
							
							while(!(typeKart.equals("reservado") || typeKart.equals("mantenimiento") || typeKart.equals("disponible"))) {
								System.out.println("Error, debe introducir (reservado, mantenimiento, disponible):");
								typeKart=idscanKart.next();
							}
							
							if(typeKart.equals("reservado")) {
								estadoKart=kartstat.reservado;
								int status=cKart.crearKart(idKart,type,estadoKart);
								if(status==0) {
									System.out.println("El kart ha sido introducido correctamente\n");
								}else if(status==-1) {
									System.out.println("Error al introducir el kart\n");
								}
							}
							else if(typeKart.equals("mantenimiento")) {
								estadoKart=kartstat.mantenimiento;
								int status=cKart.crearKart(idKart,type,estadoKart);
								if(status==0) {
									System.out.println("El kart ha sido introducido correctamente\n");
								}else if(status==-1) {
									System.out.println("Error al introducir el kart\n");
								}
							}
							else if(typeKart.equals("disponible")) {
								estadoKart=kartstat.disponible;	
								int status=cKart.crearKart(idKart,type,estadoKart);
								if(status==0) {
									System.out.println("El kart ha sido introducido correctamente\n");
								}else if(status==-1) {
									System.out.println("Error al introducir el kart\n");
								}
							}								
							
							break;
							
						case 3:
							System.out.println("\nElegiste Opcion 3: Asociar Kart a PistaDTO\n");
							int idKart2;
							String idPista2;
							Scanner idscanKartPista = new Scanner(System.in);
							System.out.println("Introduzca el id del kart que quiere asociar:");
							idKart2=idscanKartPista.nextInt();
							System.out.println("Introduzca el nombre de la pista a la que quiere asociar el kart:");
							idPista2=idscanKartPista.next();
							GestorPistas asociar = new GestorPistas();

							int status=asociar.asociarKartPista(idKart2,idPista2);
							if(status==0) {
								System.out.println("El kart ha sido asociado correctamente\n");
							}else if(status==-1) {
								System.out.println("Kart ya asociado a una pista\n");
							}
							else if(status==-2) {
								System.out.println("La pista ha alcanzado el limite de karts a reservar\n");
							}
							else if(status==-3) {
								System.out.println("No existe el kart o la pista introducidos\n");								
							}
							break;
							
						case 4:
							System.out.println("\nElegiste Opcion 4: Mostrar las pistas en mantenimiento\n");
							GestorPistas listarmant = new GestorPistas();
							System.out.println(listarmant.listarPistasMantenimiento());
							break;
							
						case 5:
							System.out.println("\nElegiste Opcion 5: Mostrar las pistas libres\n");
							Scanner scanPista = new Scanner(System.in);
							GestorPistas listar = new GestorPistas();
							int nmaximokarts;
							diff diffpista = null;
							System.out.println("Introduzca el numero de karts a consultar:");
							nmaximokarts=scanPista.nextInt();
							System.out.println("Introduzca la dificultad (child, family, adult): ");
							String difpista=scanPista.next();
							if(difpista.equals("child")) {
								diffpista=diff.child;
								System.out.println(listar.pistasLibres(nmaximokarts, diffpista));
							}
							else if(difpista.equals("family")) {
								diffpista=diff.family;
								System.out.println(listar.pistasLibres(nmaximokarts, diffpista));
							}
							else if(difpista.equals("adult")) {
								diffpista=diff.adult;
								System.out.println(listar.pistasLibres(nmaximokarts, diffpista));
							}					
							break;
							
						case 6:
							System.out.println("\nElegiste Opcion 6: Salir del menu de pistas\n");
							exittrack = true;
							break;
							
						default:
							System.out.println("\nTienes que elegir una opcion (numero) entre 1 y 6\n");
						}
					}catch(InputMismatchException e){ //Make a verification about the entered data
							System.out.println("\nDebes introducir un numero\n");
							snoptiontrack.next();
						 }
					}
					break;
				
				case 3:
					while(!exitbooking) {
					System.out.println("------------------------------------------------------");
					System.out.println("Has elegido la opcion 3: Gestionar Reserva\n");
					
					System.out.println("MENU DE RESERVAS:");
					System.out.println("1. Opcion 1: Hacer una reserva individual");
					System.out.println("2. Opcion 2: Hacer una reserva dentro de un bono");
					System.out.println("3. Opcion 3: Modificar una reserva");
					System.out.println("4. Opcion 4: Eliminar una reserva");
					System.out.println("5. Opcion 5: Mostrar las reservas futuras");
					System.out.println("6. Opcion 6: Mostrar reservas para un dia concreto");
					System.out.println("7. Opcion 7: Crear bono");
					System.out.println("8. Opcion 8: Salir del menu de reservas");
					
					System.out.println("\nIntroduzca el numero de la opcion que desee realizar:\n ");
					try {
						int optionbooking = snoptionbooking.nextInt();
						switch(optionbooking) {
						
						case 1:
							
							System.out.println("\nElegiste Opcion 1: Hacer una reserva individual\"\n");
							
							ModalidadReservaIndividual b = new ModalidadReservaIndividual();
							GestorReservas r = new GestorReservas();
							
							System.out.println("Introduzca el email (id) de quien realiza la reserva:\n");
							System.out.println("(Debe se un usuario registrado)\n");
							
							Scanner entry = new Scanner(System.in);
							String user_mail = entry.next();
							
							System.out.println("Introduzca el nombre de la pista quiere reservar:\n");
							
							String pista = entry.next();
							
							System.out.println("Introduzca la fecha y hora de la reserva:\n");
							System.out.println("Debe seguir el formato 'yyyy-MM-dd'\n");
							
							String fecha_reserva_str = entry.next();
							
							SimpleDateFormat format44 = new SimpleDateFormat("yyyy-MM-dd");
							
							Date fecha1 = format44.parse(fecha_reserva_str);
							
							java.sql.Date fechares = new java.sql.Date(fecha1.getTime());
							
							System.out.println("Introduzca el numero de participantes Infantiles que son:\n");
							int numChilds;
							numChilds = entry.nextInt();
							
							System.out.println("Introduzca el numero de participantes Adultos que son:\n");
							int numAdults;
							numAdults = entry.nextInt();
							
							
							System.out.println("Introduzca la duracion de la reserva:\n");
							System.out.println("Pueden ser 60, 90 0 120 minutos\n");

							int duracion = entry.nextInt();
							
							while(duracion != 60 && duracion != 90 && duracion != 120) {
								System.out.println("Error: Duracion invalida.\n");
								System.out.println("Introduzca la duracion de la reserva:\n");
								duracion = entry.nextInt();
							}
							
							System.out.println("Realizando la reserva...\n");
							
							int res = r.reservaIndividual(b, user_mail, fechares, fechares, duracion, pista, numChilds, numAdults);

							if(res == 0) {
								System.out.println("Reserva realizada correctamente\n");
							}
							else if( res == -1 ) {
								System.out.println("Error, el usuario introducido no existe\n");
							}
							else if( res == -6 ) {
								System.out.println("Error, la pista solicitada no esta disponible\n");
							}
							else if( res == -7 ) {
								System.out.println("Error, el numero de participantes introducido no es valido para la pista que quiere reservar\n");
							}
							else if ( res == -9 ){
								System.out.println("Error, el numero de participantes introducido no es valido para la pista que quiere reservar\n");
							}
							else {
								System.out.println("Error, la reserva no se ha podido realizar, introduzca datos validos\n");
							}
							
							
							break;
							
						case 2:
							System.out.println("\nElegiste Opcion 2: Hacer una reserva dentro de un bono\n");
							
							ModalidadReservaBono a=new ModalidadReservaBono();
							
							r = new GestorReservas();
							
							System.out.println("Introduzca el email (id) de quien realiza la reserva:\n");
							System.out.println("(Debe se un usuario registrado)\n");
							
							entry = new Scanner(System.in);
							user_mail = entry.next();
							
							System.out.println("Introduzca el id (numero de bono) que quiere utilizar:\n");
							
							int nbono = entry.nextInt();
							
							System.out.println("Introduzca el nombre de la pista quiere reservar:\n");
							
							pista = entry.next();
							
							System.out.println("Introduzca la fecha y hora de la reserva:\n");
							System.out.println("Debe seguir el formato 'yyyy-MM-dd'\n");
							
							fecha_reserva_str = entry.next();
							
							format44 = new SimpleDateFormat("yyyy-MM-dd");
							
							fecha1 = format44.parse(fecha_reserva_str);
							
							fechares = new java.sql.Date(fecha1.getTime());
							
							System.out.println("Introduzca el numero de participantes Infantiles que son:\n");
							
							numChilds = entry.nextInt();
							
							System.out.println("Introduzca el numero de participantes Adultos que son:\n");
							
							numAdults = entry.nextInt();
							
							
							System.out.println("Introduzca la duracion de la reserva:\n");
							System.out.println("Pueden ser 60, 90 0 120 minutos\n");

							duracion = entry.nextInt();
							
							while(duracion != 60 && duracion != 90 && duracion != 120) {
								System.out.println("Error: Duracion invalida.\n");
								System.out.println("Introduzca la duracion de la reserva:\n");
								duracion = entry.nextInt();
							}
							
							System.out.println("Realizando la reserva...\n");
							
							res = r.reservaIndividual(a, nbono, user_mail, fechares, fechares, duracion, pista, numChilds, numAdults);

							if(res == 0) {
								System.out.println("Reserva realizada correctamente\n");
							}
							else if( res == -1 ) {
								System.out.println("Error, el usuario introducido no existe\n");
							}
							else if( res == -2 ) {
								System.out.println("Error, el bono introducido no existe\n");
							}
							else if( res == -3 ) {
								System.out.println("Error, usted no es el dueño del bono que quiere usar\n");
							}
							else if( res == -4 ) {
								System.out.println("Error, el bono no es del tipo que de la reserva que quiere realizar\n");
							}
							else if( res == -6 ) {
								System.out.println("Error, la pista solicitada no esta disponible\n");
							}
							else if( res == -7 ) {
								System.out.println("Error, el tipo de pista y el tipo de bono no son compatibles\n");
							}
							else if ( res == -9 ){
								System.out.println("Error, el numero de participantes introducido no compatible con el tipo de pista que quiere reservar\n");
							}
							else {
								System.out.println("Error, la reserva no se ha podido realizar, introduzca datos validos\n");
							}
							
							break;
							
							
						case 3:
							System.out.println("\nElegiste Opcion 3: Modificar una reserva\n");

							System.out.println("Introduzca 1 si es de tipo Invidividual y 2 si es de tipo bono.\n");
							
							entry = new Scanner(System.in);
							int selectorr = entry.nextInt();
							
							while(selectorr != 1 && selectorr != 2) {
								System.out.println("Introduzca 1 si es de tipo Invidividual y 2 si es de tipo bono.\n");
								selectorr = entry.nextInt();
							}
							
							if(selectorr == 1) {
								
								b = new ModalidadReservaIndividual();
								r = new GestorReservas();
								
								System.out.println("El id de la reserva que quiere modificar.\n");
								
								entry = new Scanner(System.in);
								int idmod = entry.nextInt();
								
								System.out.println("Introduzca el email (id) de quien realiza la reserva:\n");
								System.out.println("(Debe se un usuario registrado)\n");
								
								entry = new Scanner(System.in);
								user_mail = entry.next();
								
								System.out.println("Introduzca el nombre de la pista quiere reservar:\n");
								
								pista = entry.next();
								
								System.out.println("Introduzca la fecha y hora de la reserva:\n");
								System.out.println("Debe seguir el formato 'yyyy-MM-dd'\n");
								
								fecha_reserva_str = entry.next();
								
								format44 = new SimpleDateFormat("yyyy-MM-dd");
								
								fecha1 = format44.parse(fecha_reserva_str);
								
								fechares = new java.sql.Date(fecha1.getTime());
								
								System.out.println("Introduzca el numero de participantes Infantiles que son:\n");
								
								numChilds = entry.nextInt();
								
								System.out.println("Introduzca el numero de participantes Adultos que son:\n");
								
								numAdults = entry.nextInt();
								
								
								System.out.println("Introduzca la duracion de la reserva:\n");
								System.out.println("Pueden ser 60, 90 0 120 minutos\n");

								duracion = entry.nextInt();
								
								while(duracion != 60 && duracion != 90 && duracion != 120) {
									System.out.println("Error: Duracion invalida.\n");
									System.out.println("Introduzca la duracion de la reserva:\n");
									duracion = entry.nextInt();
								}
								
								System.out.println("Realizando la reserva...\n");
								
								res = r.ModificarReservaIndividual(idmod, b, user_mail, fechares, fechares, duracion, pista, numChilds, numAdults);

								if(res == 0) {
									System.out.println("Reserva modificada correctamente\n");
								}
								else if( res == -1 ) {
									System.out.println("Error, el usuario introducido no existe\n");
								}
								else if( res == -6 ) {
									System.out.println("Error, la pista solicitada no esta disponible\n");
								}
								else if( res == -7 ) {
									System.out.println("Error, el numero de participantes introducido no es valido para la pista que quiere reservar\n");
								}
								else if ( res == -9 ){
									System.out.println("Error, el numero de participantes introducido no es valido para la pista que quiere reservar\n");
								}
								else {
									System.out.println("Error, la reserva no se ha podido modificar, introduzca datos validos\n");
								}
								
							}
							else {
								
								a=new ModalidadReservaBono();
								
								r = new GestorReservas();
								
								System.out.println("El id de la reserva que quiere modificar.\n");
								
								entry = new Scanner(System.in);
								int idmod = entry.nextInt();
								
								System.out.println("Introduzca el email (id) de quien realiza la reserva:\n");
								System.out.println("(Debe se un usuario registrado)\n");
								
								entry = new Scanner(System.in);
								user_mail = entry.next();
								
								System.out.println("Introduzca el id (numero de bono) que quiere utilizar:\n");
								
								nbono = entry.nextInt();
								
								System.out.println("Introduzca el nombre de la pista quiere reservar:\n");
								
								pista = entry.next();
								
								System.out.println("Introduzca la fecha y hora de la reserva:\n");
								System.out.println("Debe seguir el formato 'yyyy-MM-dd'\n");
								
								fecha_reserva_str = entry.next();
								
								format44 = new SimpleDateFormat("yyyy-MM-dd");
								
								fecha1 = format44.parse(fecha_reserva_str);
								
								fechares = new java.sql.Date(fecha1.getTime());
								
								System.out.println("Introduzca el numero de participantes Infantiles que son:\n");
								
								numChilds = entry.nextInt();
								
								System.out.println("Introduzca el numero de participantes Adultos que son:\n");
								
								numAdults = entry.nextInt();
								
								
								System.out.println("Introduzca la duracion de la reserva:\n");
								System.out.println("Pueden ser 60, 90 0 120 minutos\n");

								duracion = entry.nextInt();
								
								while(duracion != 60 && duracion != 90 && duracion != 120) {
									System.out.println("Error: Duracion invalida.\n");
									System.out.println("Introduzca la duracion de la reserva:\n");
									duracion = entry.nextInt();
								}
								
								System.out.println("Realizando la reserva...\n");
								
								res = r.ModificarReservaIndividual(idmod,a, nbono, user_mail, fechares, fechares, duracion, pista, numChilds, numAdults);

								if(res == 0) {
									System.out.println("Reserva modificada correctamente\n");
								}
								else if( res == -1 ) {
									System.out.println("Error, el usuario introducido no existe\n");
								}
								else if( res == -2 ) {
									System.out.println("Error, el bono introducido no existe\n");
								}
								else if( res == -3 ) {
									System.out.println("Error, usted no es el dueño del bono que quiere usar\n");
								}
								else if( res == -4 ) {
									System.out.println("Error, el bono no es del tipo que de la reserva que quiere realizar\n");
								}
								else if( res == -6 ) {
									System.out.println("Error, la pista solicitada no esta disponible\n");
								}
								else if( res == -7 ) {
									System.out.println("Error, el tipo de pista y el tipo de bono no son compatibles\n");
								}
								else if ( res == -9 ){
									System.out.println("Error, el numero de participantes introducido no compatible con el tipo de pista que quiere reservar\n");
								}
								else {
									System.out.println("Error, la modificacion reserva no se ha podido realizar, introduzca datos validos\n");
								}
								
							}
									
							break;
							
						case 4:
							System.out.println("\nElegiste Opcion 4: Eliminar una reserva\n");
							Scanner scanPista = new Scanner(System.in);
							GestorReservas g= new GestorReservas();
							int num;
							System.out.println("Introduzca el numero de reserva: ");
							num=scanPista.nextInt();
							int status=g.eliminarReserva(num);
							
							if(status==0) {
								System.out.println("Reserva eliminada correctamente\n");
							}
							else {
								System.out.println("No se puedo eliminar la reserva por integridad de la BD\n");
							}
							break;
							
						case 5:
							System.out.println("\nElegiste Opcion 5: Mostrar las reservas futuras\n");
							GestorReservas gr=new GestorReservas();
							System.out.println(gr.verResFuturas());
							break;
							
						case 6:
							System.out.println("\nElegiste Opcion 6: Mostrar reservas para un dia concreto\n");
							GestorReservas gest=new GestorReservas();
							String pistaa;
							Scanner pistascan=new Scanner(System.in);
							System.out.println("Introduce el nombre de la pista que quieres consultar\n");
							pistaa=pistascan.next();
							System.out.println("Introduce el dia a consultar (yyyy-MM-dd)");
							String fecha_reserva = pistascan.next();
							Date fecha = new Date();
							SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd");
							fecha = format2.parse(fecha_reserva);							
							System.out.println(gest.verResConcreta(fecha,pistaa));
							break;
							
						case 7:
							Scanner scan=new Scanner(System.in);
							GestorReservas bon=new GestorReservas();
							System.out.println("\nElegiste Opcion 7: Crear bono\n");
							System.out.println("\nIntroduzca el email del usuario del bono\n");
							String emailUser=scan.next();
							System.out.println("\nIntroduzca el tipo de bono, familiar-adult-child\n");
							String tipoB=scan.next();
							while(!tipoB.equals("child")&&!tipoB.equals("adult")&&!tipoB.equals("familiar")){
								System.out.println("\nTipo no valido,vuelva a introducirlo\n");
								tipoB=scan.next();
							}
							int status2=bon.altaBono(emailUser, tipoB);
							if(status2==0) {
								System.out.println("\nBono introducido correctamente\n");
							}else {
								System.out.println("\nUsuario no existente\n");
							}
						case 8:
							System.out.println("\nElegiste Opcion 8: Salir del menu de reservas\n");
							exitbooking = true;
							break;
							
						default:
							System.out.println("\nTienes que elegir una opcion (numero) entre 1 y 8\n");
						}
					}catch(InputMismatchException e){ //Make a verification about the entered data
							System.out.println("\nDebes introducir un numero\n");
							snoptionbooking.next();
						 }
					}
					break;
				
				case 4:
					System.out.println("------------------------------------------------------");
					System.out.println("Has elegido Opcion 4: Salir del menu general\n");
					exit = true;
					break;
				
				default:
					System.out.println("\nTienes que elegir una opcion (numero) entre 1 y 4\n");
			
			}
		}catch(InputMismatchException e){ //Make a verification about the entered data
			System.out.println("\nDebes introducir un numero\n");
			snoption.next();
		 }
	  }
	System.out.println("\nFIN DEL MENU\n");
	}	
	}
