//Este es un programa que permite el checking y venta de entradas en puerta el d�a del concierto por un agente verificador.

//DESCRIPCI�N DEL CONTEXTO:
//El programa se comenzar� a utilizar cuando inicie el checking de un concierto, registrando los tickets de las personas que ingresan, se permite la venta de entradas
//La capacidad del concierto es de 225 personas, con tres zonas: Palco izquierdo, Zona Vip y Palco Derecho, adem�s de una zona reservada. 

//DESCRIPCI�N DEL PROGRAMA: 
//1.- Para poder acceder al programa, el agente verificador ingresa con usuario y contrase�a. 
//2.- En la pantalla de men�, el agente verificador tiene tres opciones: 
//a)Registrar las entradas de las personas que llegan al concierto 
//b)Realizar nuevas ventas de entradas comprobando la disponibilidad de la zona requerida.
//Al realizar una venta se realiza la facturaci�n de las entradas vendidas, se permite el ingreso manual de descuento, si hubiera. 
//c) Salir del programa

//ALCANCE DEL PROGRAMA:
//La capacidad de entradas y las zonas son valores est�ticos y solo se permite su modificaci�n desde el c�digo.
//El presente programa se usa exclusivamente el d�a del checking al momento del ingreso, esto implica que las entradas ya fueron vendidas en una instancia previa
//Por lo tanto se realiza una generaci�n de tickets con una venta del 96% al momento de usar el programa. 
//No se permite la generaci�n de nuevas entradas; el programa se limita al aforo contemplado y previsto para el espect�culo.

Funcion titulo()
	Escribir"";
	Escribir"                                                 *=====================================*"; 
	Escribir"                                                 *  E N T R A D A S   V E N D I D A S  *";
	Escribir"                                                 *=====================================*";
	Escribir"                             ______   _____   ______    ______    _   __    ___     ____     ____   ____ ";
	Escribir"                            / ____/  / ___/  / ____/   / ____/   / | / /   /   |   / __ \   /  _/  / __ \";
	Escribir"                           / __/     \__ \  / /       / __/     /  |/ /   / /| |  / /_/ /   / /   / / / /";
	Escribir"                          / /___    ___/ / / /___    / /___    / /|  /   / ___ | / _, _/  _/ /   / /_/ / ";
	Escribir"                         /_____/   /____/  \____/   /_____/   /_/ |_/   /_/  |_|/_/ |_|  /___/   \____/  ";
	Escribir"           --__--__--__--__--__--__--__--__--__--__--__--__--__--__--__--__--__--__--__--__--__--__--__--__--__--__--__--";
	Escribir"           __--__--__--__--__--__--__--__--__--__--__--__--__--__--__--__--__--__--__--__--__--__--__--__--__--__--__--__";
	Escribir"";
	Escribir" ||---*--- PALCO IZQUIERDO ---*---||       * RESERVADO *  "," ||*--*--*--* ZONA   V I P *--*--*--*|| ","  ||  ---**---   PALCO   DERECHO    ---**---  ||";
	Escribir"";
FinFuncion

subProceso ingresoUsuario(validacion Por Referencia) //Este subproceso permite el ingreso con usuario y contrase�a al programa, lo realiza el agente verificador. 
	Escribir"";
	Escribir"";
	Escribir"";
	Escribir"";
	Escribir"";
	Escribir"        --__--__--__--__--__--__--__--__--__--__--__--__--__--__--__--__--__--__--__--__--__--__--__--__--__--__--__--";
	Escribir"        __--__--__--__--__--__--__--__--__--__--__--__--__--__--__--__--__--__--__--__--__--__--__--__--__--__--__--__";
	Escribir"";
	Escribir"               :::        :::        :::::::::::        :::::::::           :::        :::::::::          ::: ";
	Escribir"             :+: :+:      :+:            :+:            :+:    :+:        :+: :+:      :+:    :+:        :+: :+:";
	Escribir"            +:+   +:+     +:+            +:+            +:+    +:+       +:+   +:+     +:+    +:+       +:+   +:+ ";
	Escribir"           +#++:++#++:    +#+            +#+            +#++:++#+       +#++:++#++:    +#++:++#+       +#++:++#++:";
	Escribir"           +#+     +#+    +#+            +#+            +#+    +#+      +#+     +#+    +#+    +#+      +#+     +#+   ";
	Escribir"           #+#     #+#    #+#            #+#            #+#    #+#      #+#     #+#    #+#    #+#      #+#     #+#   ";
	Escribir"           ###     ###    ########## ###########        #########       ###     ###    #########       ###     ###     ";
	Escribir"";
	Escribir"        --__--__--__--__--__--__--__--__--__--__--__--__--__--__--__--__--__--__--__--__--__--__--__--__--__--__--__--";
	Escribir"        __--__--__--__--__--__--__--__--__--__--__--__--__--__--__--__--__--__--__--__--__--__--__--__--__--__--__--__";
	Escribir"";
	Escribir"                                       __   __   __   __   __                  __   __   __   __  __ ";
	Escribir"                        |  _   _      |__) |__) /  \ / _  |__)  /\  |\/|  /\  |  \ /  \ |__) |_  (_  ";
	Escribir"                   \/   | (_) _)      |    | \  \__/ \__) | \  /--\ |  | /--\ |__/ \__/ | \  |__ __) ";
	Escribir"                   /                                                                                     ";
	Escribir"";
	Escribir"";
	
	Definir usuario,contrasenia Como Caracter;
	Definir intentos Como Entero;
	intentos <- 3;
	Repetir //Este bucle nos mantiene en la pantalla principal hasta que se ingrese el usuario y contrase�a correctos. 
		escribir Sin Saltar "                                        Escriba un Usuario: ";
		Leer usuario;
		escribir Sin Saltar "                                        Escriba una contrase�a: ";
		Leer contrasenia;
		intentos <- intentos - 1;
		Si usuario="alibaba" y contrasenia="alibaba123" Entonces
			Escribir "                                        B I E N V E N I D O   A   S U  C A M P U S ";
			validacion<-Verdadero;
		SiNo
			Escribir "";
			Escribir "                                        Usuario o contrase�a INCONRRECTA, �VERIFIQUE SUS DATOS! ";
			Escribir "";
			Escribir "                                        Le restan ",intentos, " intentos";
			Escribir "";
		FinSi
	Hasta Que validacion=Verdadero o intentos = 0;
FinsubProceso

SubProceso DisenioMenu()
	Limpiar Pantalla;
	Escribir "";
	Escribir "";
	Escribir "*_________________________________________________________________________________________________________*";
	Escribir "    B i e n v e n i d o   a l    p r o g r a m a   d e   c h e c k i n g   y   v e n t a  Al�bab�10 V1.9 ";
	Escribir "*=========================================================================================================*";
	Escribir "";
	Escribir "";
	Escribir "                                        Elija una de las siguientes opciones:";
	Escribir "";
	Escribir "                                        1.- Verificaci�n de tickets.";
	Escribir "                                        2.- Venta de tickets. ";
	Escribir "                                        3.- Salir.";
FinSubProceso

SubProceso MensajeSalida()
	Limpiar Pantalla;
	Escribir"";
	Escribir"               :::        :::        :::::::::::        :::::::::           :::        :::::::::          ::: ";
	Escribir"             :+: :+:      :+:            :+:            :+:    :+:        :+: :+:      :+:    :+:        :+: :+:";
	Escribir"            +:+   +:+     +:+            +:+            +:+    +:+       +:+   +:+     +:+    +:+       +:+   +:+ ";
	Escribir"           +#++:++#++:    +#+            +#+            +#++:++#+       +#++:++#++:    +#++:++#+       +#++:++#++:";
	Escribir"           +#+     +#+    +#+            +#+            +#+    +#+      +#+     +#+    +#+    +#+      +#+     +#+   ";
	Escribir"           #+#     #+#    #+#            #+#            #+#    #+#      #+#     #+#    #+#    #+#      #+#     #+#   ";
	Escribir"           ###     ###    ########## ###########        #########       ###     ###    #########       ###     ###     ";
	Escribir"        --__--__--__--__--__--__--__--__--__--__--__--__--__--__--__--__--__--__--__--__--__--__--__--__--__--__--__--";
	Escribir"        __--__--__--__--__--__--__--__--__--__--__--__--__--__--__--__--__--__--__--__--__--__--__--__--__--__--__--__";
	Escribir"                                       __   __   __   __   __                  __   __   __   __  __ ";
	Escribir"                        |  _   _      |__) |__) /  \ / _  |__)  /\  |\/|  /\  |  \ /  \ |__) |_  (_  ";
	Escribir"                   \/   | (_) _)      |    | \  \__/ \__) | \  /--\ |  | /--\ |__/ \__/ | \  |__ __) ";
	Escribir"                   /                                                                                     ";
	Escribir"                                      L E S    A G R A D E C E   H A B E R  ";
	Escribir"                                     U T I L I Z A D O        N U E S T R O S ";
	Escribir"                                                 S E R V I C I O S  ";
	Escribir"";
	ESCRIBIR "                                                               [N]";
	ESCRIBIR "                                                [G]      [J][U][A][N] ";
	ESCRIBIR "                                             [P][A][B][L][O]   [T] ";
	ESCRIBIR "                                                [B]      [R]    ";
	ESCRIBIR "                                                [R]      [G] ";
	ESCRIBIR "                                                [I]   [D][E][N][I][S][E]   ";
	ESCRIBIR "                                          [A][L][E][X]            [E] ";
	ESCRIBIR "                                          [N]   [L]               [B]  ";
	ESCRIBIR "                                          [G]                  [M][A][T][I]";
	ESCRIBIR "                                          [E]                     [S]   ";
	Escribir "                                          [L]";
	Escribir "";
	Escribir "";
FinSubProceso

SubProceso Menu(vendidas, noVendidas) //Este subproceso de men� permite el ingreso a las 2 funcionalidades principales del programa
	
	definir opcion como cadena;
	Definir salir Como Logico;
	salir <- falso;
	Mientras salir = falso Hacer
		DisenioMenu();
		Escribir "";
		Escribir Sin Saltar "                                        Elija una opci�n:";
		Leer opcion;
		Escribir "";
		si opcion = "1" Entonces
			Limpiar Pantalla;
			mostrarVendidas(vendidas); //se invoca al subproceso mostrarVendidas y se muestra la matriz con las entradas vendidas 
			registro(vendidas, noVendidas); //Se invoca al subproceso de registro y se realiza el cheking de entradas
		FinSi
		si opcion = "2" Entonces
			ventas(noVendidas, vendidas); //se invoca al subproceso de ventas
		FinSi
		si opcion = "3" Entonces
			Escribir "                                        3.- Salir.";
			salir <- verdadero;
			MensajeSalida();
		FinSi
	FinMientras
FinSubProceso

SubProceso EntradasTotales(matriz Por referencia) //Este subproceso genera las entradas totales con el c�digo alfanum�rico 
	//creamos 2 arreglos que contienen los caracteres a generar
	definir letras,codigoLetras,  nums, codigoNums, codigoTickets como cadena;
	definir i,j,k, dimLetras, letraAleatoria, numAleatorio, totalEntradas  como entero;
	letras<- "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	dimLetras<-Longitud (letras); //Obtenemos el n�mero total de letras 
	nums <- ConvertirATexto(1234567890); //convertimos en una cadena para poder vicular las letras con los numeros sin que tengamos un error
	para i<-0 Hasta 14 Hacer //Este bucle crea los c�digos aleatorios de TODAS las entradas generadas para el concierto.
		para j<-0 Hasta 14 Hacer //Se considera una matriz de 15x5 es decir 225 entradas totales. 
			codigoLetras<-"";
			codigoNums<-"";
			Para k<-0 Hasta 2 Con Paso 1 Hacer
				letraAleatoria<-azar(dimLetras); //Se Busca un n�mero al azar entre el 1 y el n�mero de letras 
				codigoletras<-Concatenar(codigoLetras, Subcadena(letras, letraAleatoria, letraAleatoria)); //Se concatenan 3 letras aleatorias
				numAleatorio<- azar(9);
				codigoNums<-Concatenar(codigoNums, subcadena(nums, numAleatorio, numAleatorio)); //Se concatenan 3 numeros aleatorios 
			FinPara
			codigoTickets<-Concatenar(codigoLetras,codigoNums); //Se concatenan 3 letras y 3 numeros para el c�digo final. 
			matriz[i,j]<-codigoTickets;
		FinPara
	FinPara
FinSubProceso

//Este subproceso genera aleatoriamente las entradas vendidas considerando una venta de 96% al momento de usar el programa. 
SubProceso entradasVendidas(matriz Por Referencia, vendidas Por Referencia, novendidas Por Referencia)
	Definir simulador, i, j Como Entero;
	
	para i<-0 hasta 14 Hacer
		para j<-0 Hasta 14 Hacer
			simulador<-azar(30); 
			si simulador <29 Entonces //Esta condici�n permite simular una venta de 96%. 
				vendidas[i,j]<-matriz[i,j]; //se genera la matriz de entradas vendidas, para realizar el registro
				noVendidas[i,j]<-"      ";
			SiNo
				vendidas[i,j]<-"      ";
				noVendidas[i,j]<-matriz[i,j]; //Se genera la matriz de entradas noVendidas, entradas disponibles para la venta.
			FinSi
		FinPara
	FinPara
	Escribir "";
FinSubProceso

SubProceso mostrarVendidas(vendidas Por Referencia) //Este subproceso mostrar� la matriz con las entradas vendidas cada vez que lo llamemos
	definir i,j Como Entero;
	
	titulo();
	para i<-0 Hasta 14 Hacer
		j=0;
		si (j <= 15) Entonces
			si longitud(vendidas[i,0])<8 Entonces
				Escribir Sin Saltar " ";
			FinSi
		FinSi
		para j<-0 Hasta 14 Hacer
			si longitud(vendidas[i,j])=8 entonces //Cada vez que se registra una entrada se agrega 00 Adelante, esta condicion mantiene los elementos alineados.
				Escribir Sin Saltar "[";
				Escribir Sin Saltar vendidas[i,j], "  ";
			SiNo
				si (i<=13) y (j<=13) Entonces
					si longitud(vendidas[i,j+1])=8 entonces
						Escribir Sin Saltar vendidas[i,j], "   ";
					SiNo
						Escribir Sin Saltar vendidas[i,j], "    ";
					FinSi
				SiNo
					Escribir Sin Saltar vendidas[i,j], "    ";
				FinSi
			FinSi
		FinPara
		Escribir "";
	FinPara
FinSubProceso

//Este subproceso sirve para realizar el checking 
//Se pedir� el ingreso manual del c�digo a verifica, Si existe el c�digo, aparecer� una leyenda con c�digo v�lido. Se sobreescribe dicha posici�n con 00.
SubProceso registro(vendidas Por Referencia, noVendidas Por Referencia)
	//Se le pedir� que ingrese el c�digo a verificar.Debe ser ingresado manualmente. Si existe el c�digo, aparecer� una leyenda con c�digo v�lido. Se sobreescribe dicha posici�n con 00.
	Escribir "";//Hecho por Denise
	Definir CodigoDet, condicion, condicionVendido Como logico;
	Definir codigodev, boletoRegistrado Como caracter;
	Definir fila, columna, i, j  como entero; //por si en algun momento se quiere mostrar la posici�n
	Definir opcion como cadena;
	
	condicion<-Verdadero;
	Mientras condicion=Verdadero Hacer
		Escribir Sin saltar  "                                        - Ingrese el c�digo del ticket";
		Leer codigodev; //Esta variable almacena el c�digo de ticket que el agente verificador ingrese manualmente. 
		codigodev<-Mayusculas(codigodev); //con esta funci�n se arregla el error de de 
		CodigoDet <- Falso; 
		condicionVendido<-Falso;
		Para i<-0 hasta 14 con paso 1 Hacer
			Para j<-0 hasta 14 con paso 1 Hacer
				boletoRegistrado <- Concatenar(codigodev,"] ");
				si (vendidas[i,j] = codigodev) entonces//Esta condici�n compara el ticket ingresado con cada elemento de la matriz de tickets vendidos
					fila<-i; //por si en algun momento se quiere mostrar la posici�n
					columna<-j; //por si en algun momento se quiere mostrar la posici�n
					CodigoDet <- Verdadero; //Cuando el ticket ingresado coincide con un elemento de la matriz, la variable codigoDet pasa a ser verdadera
					vendidas[i,j]<-Concatenar(vendidas[i,j],"] ");
				FinSi
				si vendidas[i,j] = boletoRegistrado Entonces
					condicionVendido<-Verdadero; //Esta condicion eval�a si un ticket ya fue ingresado anteriormente. 
				FinSi
			FinPara
		FinPara
		
		Limpiar Pantalla;
		mostrarVendidas(vendidas);
		
		//Las siguientes condiciones evaluan si el ticket ingresado es v�lido, si no es v�lido o si ya fue registrado. 
		Si CodigoDet = Verdadero entonces
			Escribir"";
			Escribir "                                      *==========================================*";
			Escribir "                                       * El Ticket ingresado  E S   V � L I D O *";
			Escribir "                                      *==========================================*";
			Escribir"";
		sino
			Si condicionVendido = verdadero entonces
				Escribir"";
				Escribir "                                      *========================================================*";
				Escribir "                                       * El Ticket ingresado  Y A  F U E  R E G I S T R A D O *"; 
				Escribir "                                      *=========================================================*";
				Escribir"";
			SiNo
				Escribir""; 
				Escribir "                                      *================================================*";
				Escribir "                                       * El Ticket ingresado  N O   E S   V � L I D O *";
				Escribir "                                      *================================================*";
				Escribir"";
			FinSi
		FinSi
		
		Repetir //Este bucle permite la opci�n de registrar mas tickets o regresar al men� principal.
			Escribir "                                        �Desea seguir registrando boletos?";
			Escribir "                                        1.- Si.";
			Escribir "                                        2.- No.";
			Escribir "                                        ";SIN SALTAR Leer opcion;
			si opcion="2" Entonces
				condicion<-falso;
			SiNo
				si opcion = "1" Entonces
					condicion<-verdadero;
				SiNo
					Escribir""; 
					Escribir "                                      *================================================*";
					Escribir "                                          * Ingres� una opci�n  N O   V � L I D A *";
					Escribir "                                      *================================================*";
					Escribir"";
				FinSi
			FinSi
		Hasta Que opcion="1" o opcion="2"
	FinMientras
FinsubProceso

SubProceso  mostrarNoVendidas(noVendidas por referencia) //Este subproceso mostrar� los tickets disponibles para la venta cada vez que se lo invoque 
	Definir i , j, opcion Como Entero;
	titulo();
	para i<-0 Hasta 14 Hacer//Este bucle recorre todos los elementos de la matriz noVendidas y las muestra en pantalla
		para j<-0 Hasta 14 Hacer
			Escribir Sin Saltar noVendidas[i,j], "    ";
		FinPara
		Escribir "";
	FinPara
FinSubProceso

//Este subproceso permite realizar la venta de entradas comprobando la disponibilidad por zona 
SubProceso ventas(noVendidas por referencia, vendidas Por Referencia)
	Definir contadorPalcoIzquierdo, contadorReservados, contadorVip, contadorPalcoDerecho, cantCompra,l, i , j, opcion, zona, cantDisponible Como Entero;
	Definir venta, condicion como logico;
	Definir ticketsVenta como caracter;
	Dimension ticketsVenta[225]; //lo transformamos como vector 
	
	condicion<-Verdadero;
	mientras condicion=Verdadero Hacer //todo el proceso de ventas se repetir� mientras no se explicite salir del programa. 
		opcion<-0;
		mostrarVendidas(vendidas); //llamamos al subproceso mostrarVendidas
		Limpiar Pantalla;
		mostrarNoVendidas(noVendidas); //Se invoca al SubProceso de noVendidas y se muestra la matriz con las entradas disponibles a la venta.
		contadorPalcoIzquierdo<-0; //Contador de entradas en palco izquierdo
		contadorReservados<-0; //contador de entradas en zona de reservados
		contadorVip<-0; //contador  de entradas  en zona vip
		contadorPalcoDerecho<-0; //Contador de entradas en palco derecho
		para i<-0 Hasta 14 Hacer //Este bucle recorre toda la matriz de entradas no Vendidas y cuenta la cantidad de entradas disponible para cada zona 
			para j<-0 Hasta 14 Hacer
				si noVendidas[i,j] <> "      " Entonces
					si j<= 3 Entonces //palco izquierdo desde columna 0 hasta columna 3
						contadorPalcoIzquierdo<-contadorPalcoIzquierdo+1;
					sino 
						si j>=4 y j<=5 entonces //zona de reservados : columna 4
							contadorReservados<-contadorReservados+1;
						SiNo
							si j>=6 y j<=9 Entonces //zona vip desde columna 5 hasta columna 9
								contadorVip<-contadorVip + 1;
							SiNo
								contadorPalcoDerecho<-contadorPalcoDerecho+1; //palco derecho desde columna 10 hasta columna 14
							FinSi
						FinSi
					FinSi
				FinSi
			FinPara
		FinPara
		
		Escribir "                                              *=========================================*";
		Escribir "                                               *   TICKETS DISPONIBLES PARA LA VENTA   *"; //Se muestra en pantalla la cantidad de tickets que tenemos por zona
		Escribir "                                              *=========================================*";
		Escribir "                                                1.- Palco izquierdo        : ", contadorPalcoIzquierdo;
		Escribir "                                                2.- Zona reservada         : ", contadorReservados;
		Escribir "                                                3.- Zona vip               : ", contadorVip;
		Escribir "                                                4.- Palco derecho          : ", contadorPalcoDerecho;
		Escribir "                                                5.- Salir.";
		Escribir "";
		
		Escribir Sin Saltar"                                                Ingrese la zona d�nde desea vender: ";
		Leer zona; //el verificador ingresar� la zona por teclado decuerdo a lo que el cliente le pida. 
		Escribir Sin Saltar "                                                Ingrese la cantidad de tickets que desea vender:";
		
		Repetir//Este bucle obliga al verificador a ingresar una zona correcta. 
		Segun zona Hacer //Condicional multiple para vender los tickets de acuerdo a la zona requerida 
			1: 	leer cantCompra; //variable donde se almacena la cantidad de entradas a vender 
				cantDisponible<-contadorPalcoIzquierdo; //se almacena la cantidad de tickets disponibles de la zona requerida en la variable cantDisponible
				si cantDisponible >= cantCompra Entonces//se verifica que la cantidad de entradas disponibles sea mayor a la requerida 
					para l<-0 hasta cantCompra-1 Hacer //Este bucle permite la asignaci�n de entradas segun la cantidad requerida para venta. 
						venta<-Verdadero;
						para i<-0 Hasta 14 Hacer
							para j<-0 Hasta 3 Hacer
								si novendidas[i,j]<>"      " y venta=Verdadero Entonces
									vendidas[i,j]<-noVendidas[i,j]; //Cada vez que se vende una entrada se la mueva a la matriz de entradas vendidas 
									ticketsVenta[l]<-noVendidas[i,j]; //el codigo que estaba en no vendidas pasa a ser el ticketsventa
									noVendidas[i,j]<-"      "; //el ticket vendido autmaticamente es reescrito con caracteres vacios dentro de la matriz de entradas no Vendidas
									venta<-Falso; 
								FinSi
							FinPara
						FinPara
					FinPara
				FinSi
				cobro_ticket(cantCompra, cantDisponible, ticketsVenta, zona);
			2: 	leer cantCompra; //variable donde se almacena la cantidad de entradas a vender 
				cantDisponible<-contadorReservados;//se almacena la cantidad de tickets disponibles de la zona requerida en la variable cantDisponible
				si cantDisponible >= cantCompra Entonces//se verifica que la cantidad de entradas disponibles sea mayor a la requerida 
					para l<-0 hasta cantCompra-1 Hacer //Este bucle permite la asignaci�n de entradas segun la cantidad requerida para venta. 
						venta<-Verdadero;
						para i<-0 Hasta 14 Hacer
							para j<-4 Hasta 5 Hacer
								si novendidas[i,j]<>"      " y venta=Verdadero Entonces
									vendidas[i,j]<-noVendidas[i,j]; //Cada vez que se vende una entrada se la mueva a la matriz de entradas vendidas 
									ticketsVenta[l]<-noVendidas[i,j];
									noVendidas[i,j]<-"      "; //el ticket vendido autmaticamente es reescrito con caracteres vacios dentro de la matriz de entradas no Vendidas
									venta<-Falso;
								FinSi
							FinPara
						FinPara
					FinPara
				FinSi
				cobro_ticket(cantCompra, cantDisponible, ticketsVenta, zona);
			3: 	leer cantCompra; //variable donde se almacena la cantidad de entradas a vender 
				cantDisponible<-contadorVip;//se almacena la cantidad de tickets disponibles de la zona requerida en la variable cantDisponible
				si cantDisponible >= cantCompra Entonces//se verifica que la cantidad de entradas disponibles sea mayor a la requerida 
					para l<-0 hasta cantCompra-1 Hacer //Este bucle permite la asignaci�n de entradas segun la cantidad requerida para venta. 
						venta<-Verdadero;
						para i<-0 Hasta 14 Hacer
							para j<-6 Hasta 9 Hacer
								si novendidas[i,j]<>"      " y venta=Verdadero Entonces
									vendidas[i,j]<-noVendidas[i,j]; //Cada vez que se vende una entrada se la mueva a la matriz de entradas vendidas 
									ticketsVenta[l]<-noVendidas[i,j];
									noVendidas[i,j]<-"      "; //el ticket vendido autmaticamente es reescrito con caracteres vacios dentro de la matriz de entradas no Vendidas
									venta<-Falso;
								FinSi
							FinPara
						FinPara
					FinPara
				FinSi
				cobro_ticket(cantCompra, cantDisponible, ticketsVenta, zona);
			4: 	leer cantCompra; //variable donde se almacena la cantidad de entradas a vender 
				cantDisponible<-contadorPalcoDerecho;//se almacena la cantidad de tickets disponibles de la zona requerida en la variable cantDisponible
				si cantDisponible >= cantCompra Entonces//se verifica que la cantidad de entradas disponibles sea mayor a la requerida 
					para l<-0 hasta cantCompra-1 Hacer //Este bucle permite la asignaci�n de entradas segun la cantidad requerida para venta. 
						venta<-Verdadero;
						para i<-0 Hasta 14 Hacer
							para j<-10 Hasta 14 Hacer
								si novendidas[i,j]<>"      " y venta=Verdadero Entonces
									vendidas[i,j]<-noVendidas[i,j]; //Cada vez que se vende una entrada se la mueva a la matriz de entradas vendidas 
									ticketsVenta[l]<-noVendidas[i,j];
									noVendidas[i,j]<-"      "; //el ticket vendido autmaticamente es reescrito con caracteres vacios dentro de la matriz de entradas no Vendidas
									venta<-Falso;
								FinSi
							FinPara
						FinPara
					FinPara
				FinSi
				cobro_ticket(cantCompra, cantDisponible, ticketsVenta, zona);
			5:  opcion<-2;
				condicion<-falso;
			De Otro Modo:
				Limpiar Pantalla;
				mostrarNoVendidas(noVendidas);
		FinSegun
	Hasta Que zona=1 o zona=2 o zona=3 o zona=4 o zona=5
	
	Mientras opcion<>1 y opcion<>2 Hacer //Este bucle obliga al verificador a ingresar una opci�n correcta. 
		Escribir "";
		Escribir "                                                            �Qu� desea hacer?";
		Escribir "                                                            1. Seguir vendiendo.";
		Escribir "                                                            2. Regresar al men� principal.";
		
		Escribir "                                        ";SIN SALTAR Leer opcion;
		si opcion=1 Entonces 
			condicion<-Verdadero;
		FinSi
		si opcion=2 Entonces //Esta condici�n permite regresar al men� princip�l 
			condicion<-falso;
			Limpiar Pantalla;
		FinSi
	FinMientras
FinMientras
FinsubProceso

SubProceso cobro_ticket(cantCompra, cantDisponible, ticketsVenta, zona Por Referencia) //Este subproceso permite la facturaci�n de las entradas vendidas en puerta 
	Definir descuento, subtotal, valorentrada, totaldesc, totalcompra Como Real;
	Definir l Como Entero;
	
	Escribir "";
	si cantCompra > cantDisponible Entonces //si la cantidad requerida para la compra es mayor a los tickets disponibles no se procede a la venta.
		Escribir "                                                El n�mero de entradas solicitadas supera al n�mero de entradas disponibles. ";
	SiNo
		segun zona hacer //si la venta es correcta, se mostrar� en pantalla los tickets vendidos para la zona correspondiente. 
			1: Escribir Sin Saltar"                                                TICKETS VENDIDOS EN PALCO IZQUIERDO: ";
			2: Escribir Sin Saltar"                                                TICKETS VENDIDOS EN ZONA DE RESERVADOS: ";
			3: Escribir Sin Saltar"                                                TICKETS VENDIDOS EN ZONA VIP: ";
			4: Escribir Sin Saltar"                                                TICKETS VENDIDOS EN PALCO DERECHO: ";
		FinSegun
		
		para l<-0 Hasta cantCompra-1 Hacer //Este bucle muestra las entradas asignadas en la �ltima venta listas para facturar. 
			Escribir Sin Saltar"[", ticketsVenta[l], "] ";
		FinPara
		Escribir "";
		valorentrada<-2000;  //Valor pre definido de la entrada
		subtotal <- valorentrada*cantCompra;   //subtotal
		Escribir "";
		Escribir "                                                     *=============================*";
		Escribir "                                                      *   F A C T U R A C I � N   *";
		Escribir "                                                     *=============================*";
		Escribir"                                                Facturar la siguiente cantidad: ", cantCompra, " Entradas";
		Definir rta Como Logico;
		rta <- falso;
		Repetir
			Escribir Sin Saltar "                                                Ingrese el % de descuento: ";
			Leer descuento;
			si descuento >= 0 y descuento <= 100 Entonces
				rta <- Verdadero;
			SiNo
				Escribir "                                                Debe ingresar un valor entre 0 y 100!!! ";
				Escribir "";
			FinSi
		Hasta Que rta = Verdadero
		totaldesc <- (subtotal*descuento)/100; //descuento a aplicar
		totalcompra<-subtotal-totaldesc;
		Escribir "                                                --------------------------------";
		Escribir "                                                Importe  total               : ",subtotal;
		Escribir "                                                Descuento realizado          : ", totaldesc;
		Escribir "                                                Total a pagar                : ", totalcompra;
		Escribir "";
	finsi
FinSubProceso



Proceso PROYECTO_TICKETS //proceso principal del programa
	Definir matriz, vendidas, noVendidas Como Caracter; //se definen las variables globales que se usan por referencia en todo el programa.
	Definir  validacion Como Logico;
	validacion <- Falso;
	ingresoUsuario(validacion);
	si validacion Entonces
		Limpiar Pantalla;
		Dimension vendidas[15,15];
		Dimension novendidas[15,15];
		Dimension matriz[15,15];
		EntradasTotales(matriz);
		entradasVendidas(matriz, vendidas, noVendidas);
		Menu(vendidas, noVendidas); //Antes de ingresar al men� se genera internamente las entradas totales, vendidas y disponibles para la venta.
	SiNo
		Escribir "";
		Escribir "                                                Se vencieron los intentos de inicio de sesi�n. ";
		Escribir "";
		Esperar 2 Segundos;
		MensajeSalida();
	FinSi
FinProceso
