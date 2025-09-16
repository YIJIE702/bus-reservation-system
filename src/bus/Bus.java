package bus;
import java.io.*;

abstract public class Bus {
   
    public static int ticketI[][] = new int [100][3];
    public static int available[] = new int[6];
    public static String ticketS[][] = new String[100][3];
    public static double ticketD[][] = new double [100][3];
    public static double pay[] = new double[20];
    public static double change[] = new double[20];
    public static int to = 0,y = 1,z = 0,end = 0,r = 1,x;
    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static String user,password,yn,search,again,choice;
    
    public static void main(String[] args) throws IOException {
    for(int i = 1;i<4;){
        System.out.print("Enter Username: ");
        user = in.readLine();
        System.out.print("Enter Password: ");
        password = in.readLine();
    
    	//"available[]" is the SEAT AVAILABLE
	//store 20 seats every destination [1-5]
    	for(int o = 1; o <= 5; o++){
            available[o]=20;
        }
    
    	//if user and password are correct proceed to MAIN MENU
    	if(user.equals("1") && password.equals("1")){
    	
    		for(x = 1; x == 1;){    //MAIN MENU
                    System.out.println("---------------------------------------");
                    System.out.println(" BUS RESERVATION AND TICKETING SYSTEM ");
                    System.out.println("---------------------------------------");
                    System.out.println("[1] Destination                   ");
                    System.out.println("[2] Booking Ticket                ");
                    System.out.println("[3] Billing                       ");
                    System.out.println("[4] View Ticket Status            ");
                    System.out.println("[5] Exit                          ");
                    System.out.println("---------------------------------------\n");

                    for(x = 1; x == 1;){
                        System.out.print("Please enter your choice: ");
                        choice=in.readLine();

                        //if choice is "1" display the DESTINATION
                        if (choice.equals("1")){
                            destination(available);
                            x = 0;
                        }
                        //if choice is "2" proceed to Booking Ticket
                        else if (choice.equals("2")){
                            x = passengers(available);
                        }
                        //if choice is "3" proceed to Billing
                        else if (choice.equals("3")){
                            billing();
                        }
                        //if choice is "4" proceed to View Ticket Status  
                        else if (choice.equals("4")){
                            view();
                        }
                        //if choice is "5" then will exit the system
                        else if(choice.equals("5")){
                            end = 1;
                            x = 0;
                            System.out.println("Thank You!");
                        } //if choice is not"1-5" will show mesaage of Invalid Input  
                        else{
                            System.out.println("Invalid Input!");
                            x = 1;
                        }
                    }
                    
                    for(y = 1; y == 1;){
                        if(end == 1){
                            break;
                        }
                        System.out.print("Do you want another transaction? [Y/N]: ");
                        yn = in.readLine();
                        
                        if (yn.equalsIgnoreCase("y")){
                            x = 1;
                            y = 0;
                        }
                        else if (yn.equalsIgnoreCase("n")){
                            System.out.println("\nThank You!!!");
                            break;
                        }
                        else{
                            System.out.println("Invalid Input!!!");
                            y = 1;
                        }
                    }
    		}
    		i = 4;
            }
            else{ //A message will shown if user enter wrong name or password
                System.out.println("\nInvalid user or password!\n");
                i++;
            }
        }
    }

    private static void destination(int[] available) {
        //the DESTINATION DETAILS
        //will display the "Destination", every destination's "Fare",and "Seat"available
        DestinationTicket ticket = new DestinationTicket(available);
        System.out.println(ticket.toString());
    }

    public static int passengers(int[] available) throws IOException {
        int print = 1, x;
       //display first the Destination Details
        DestinationTicket ticket = new DestinationTicket(available);
        System.out.println(ticket.toString());
        //if all the seats been booked or not available, a message will shown 
        if((available[1]==0)&&(available[2]==0)&&(available[3]==0)&&(available[4]==0)&&(available[5]==0)){
            System.out.println("Sorry, We don't  have available seats for all Destination!");
            return 0;
        }
        //inputing of Passenger's Name
        else{
            for(x = 1; x == 1;){
                System.out.print("\nENTER PASSENGER'S NAME: ");
                ticketS[z][0] = in.readLine();
                     x = 0;
                 //if Passenger's Name already used, display error and go back to Inputing
                for(int l = 0; l<z; l++){
                    if(ticketS[l][0].equalsIgnoreCase(ticketS[z][0])){
                        System.out.println("Sorry, Passenger's name have already used!");
                        x = 1;
                    }
                }
            }

            //inputing of Destination which only accept Integers [1-5]
            for(x = 1; x == 1;){
                System.out.print("ENTER DESTINATION [number]: ");
                to = Integer.parseInt(in.readLine());

                //if Inputed integers are "<1" or ">5", display error and go back to Inputing
                if(to < 1 || to > 5){
                    System.out.println("Invalid Input!");
                    x = 1;
                }
                //if available seat is equal to "0", display error and go back to Inputing
                for(int d = 1; d <= 5; d++){
                        if(to == d){
                            if(available[to]==0){
                                System.out.println("Sorry, We don't have available seat!");
                                x = 1;
                            }
                            x = 0;
                        }
                }
            }

            //Convert the integer to string
            String dest[] = {" ", "ALOR SETAR", "GEORGE TOWN", "IPOH", "MALACCA", "JOHOR BAHRU"};
            double fare[] = {0, 10, 18, 30, 60, 70};

            //converted integer to string, transfer to storage array
            ticketS[z][1] = dest[to];
            ticketD[z][0] = fare[to];

            //inputing for Number of passenger
            for(x = 1; x == 1;){
            System.out.print("HOW MANY PASSENGERS ARE YOU?: ");
            ticketI[z][0] = Integer.parseInt(in.readLine());

                //subtract the available seat by the the number inputed
                for(int p = 1; p <= 5; p++){
                    if(to == p){
                        print = 1;
                        available[to] = available[to] - ticketI[z][0];
                        //if the subtracted available seat is "<0", display error
                        //add the inputed number to the subtracted seat, to back the original seat
                        //display the available seat and back to the inputing
                        if(available[to]<0){
                            System.out.print("Sorry, we don't have seat available for " +ticketI[z][0] +" person\n");
                            available[to] = available[to] + ticketI[z][0];
                            System.out.print("We only have " + available[to] +" seat available\n");
                            x = 1;
                            print = 0;
                        }
                        else{
                            x = 0;
                        }
                    }
                }
            }

            //inputing for Number of Discounted Passenger
            for( x = 1;x == 1;){
                System.out.print("HOW MANY PASSENGERS HAVE DISCOUNT?: ");
                ticketI[z][1] = Integer.parseInt(in.readLine());
                
                //If the number of discounted is more than number of ticket bought, a message will shown
                if(ticketI[z][1]>ticketI[z][0]){
                    System.out.println("Invalid Input!");
                    System.out.println("No. of Passengers are only " +ticketI[z][0] +"!");
                    x = 1;
                }
                else{
                    break;
                }
            }

            //Print out the passengers' details....
            if(print == 1){
                System.out.println("\n---------------------------------------");
                System.out.println("        PASSENGER'S DETAILS       ");
                System.out.println("---------------------------------------");
                System.out.println("PASSENGER'S NAME: " + ticketS[z][0]);
                System.out.println("PASSENGER'S DESTINATION : " + ticketS[z][1]);
                System.out.println("FARE PRICE: RM " + ticketD[z][0]);
                System.out.println("NO. OF PASSENGERS: " + ticketI[z][0]);
                System.out.println("NO. OF PASSENGERS WITH DISCOUNT: " + ticketI[z][1]);
                System.out.println("---------------------------------------\n");
                ticketS[z][2] = "0";
                double discount = (ticketD[z][0] - (ticketD[z][0] * 0.2)) * ticketI[z][1];
                ticketD[z][2 ]= ((ticketI[z][0] - ticketI[z][1]) * ticketD[z][0]) + discount;
                x = 0;
            }
            z++;
        }
        return x;
    }

    private static void billing() throws IOException{
        for(x = 1; x == 1;){ //User can input to search their bill and pay for it
            System.out.print("ENTER PASSENGER'S NAME: ");
            search = in.readLine();
            int s=1;
            for(int b = 0; b < z; b++){ //Print out the passengers' details....
                if(search.equalsIgnoreCase(ticketS[b][0])){
                    System.out.println("---------------------------------------");
                    System.out.println("        PASSENGER'S DETAILS        ");
                    System.out.println("---------------------------------------");
                    System.out.println("PASSENGER'S NAME: " + ticketS[b][0]);
                    System.out.println("PASSENGER'S DESTINATION : " + ticketS[b][1]);
                    System.out.println("FARE PRICE: RM" + ticketD[b][0]);
                    System.out.println("NO. OF PASSENGERS: " + ticketI[b][0]);
                    System.out.println("NO. OF PASSENGERS WITH DISCOUNT: " + ticketI[b][1]);
                    System.out.println("---------------------------------------");
                    s = 0;
                    x = 0;
                    //If the ticket been paid, a message will shown
                    if(ticketS[b][2].equals("x")){
                        System.out.println("Passenger been paid for the ticket/s!");
                        x = 0;
                    }
                    else{ //The user may view the price for the tickets and pay for it
                        ticketS[b][2] = "x";
                        for(x = 1; x == 1;){
                            System.out.println("\nPASSENGER'S TOTAL FARE: RM "+ticketD[b][2]);
                            System.out.print("ENTER AMOUNT TO PAY: ");
                            pay[b] = Double.parseDouble(in.readLine());
                            change[b] = pay[b] - ticketD[b][2];
                            
                            //If the amount pay is not same with requirement, a message will shown
                            if(change[b]<0){ 
                                    System.out.println("Invalid Input!");
                                    x = 1;
                            }
                            else{
                                    System.out.println("CHANGE: RM "+change[b]);
                                    System.out.println("");
                                    x = 0;
                            }
                        }
                    }
                }
            }
            if (s == 1){
                System.out.println("\nPASSENGER'S NAME NOT FOUND!\n");
                for(int q = 1; q == 1;){
                    System.out.print("Do you wish to continue with this transaction? [Y/N]: ");
                    again = in.readLine();

                    if(again.equalsIgnoreCase("y")){
                        q = 0;
                    }
                    else if (again.equalsIgnoreCase("n")){
                        q = 0;
                        x = 0;
                    }
                    else{
                            System.out.println("\nInvalid input!\n");
                    }
                }
            }	
        }
    }

    private static void view() throws IOException {
        for(int sx = 1; sx <= 3;){ //User can input to search their ticket's status
            System.out.print("SEARCH PASSENGER'S NAME: ");
            search = in.readLine();
            int s = 1;
            for(x = 0; x <= z; x++){ //Print out the passengers' details....
                if(search.equalsIgnoreCase(ticketS[x][0])){
                    System.out.println("---------------------------------------");
                    System.out.println("        PASSENGER'S DETAILS        ");
                    System.out.println("---------------------------------------");
                    System.out.println("PASSENGER'S NAME: " + ticketS[x][0]);
                    System.out.println("PASSENGER'S DESTINATION : " + ticketS[x][1]);
                    System.out.println("FARE PRICE: RM" + ticketD[x][0]);
                    System.out.println("NO. OF PASSENGERS: " + ticketI[x][0]);
                    System.out.println("NO. OF PASSENGERS WITH DISCOUNT: " + ticketI[x][1]);
                    System.out.println("TOTAL FARE PRICE: RM " + ticketD[x][2]);
                    
                //If passenger been pay the bill, then a message will shown    
                if(ticketS[x][2].equals("x")){ 
                    System.out.println("PAY: RM " + pay[x]);
                    System.out.println("CHANGE: RM " + change[x]);
                    System.out.println("STATUS: PAID");
                }
                else{ //If passenger did not pay the bill, then a message will shown
                    System.out.println("STATUS: NOT PAID");
                }
                System.out.println("---------------------------------------");
                System.out.println("---------------------------------------");
                s = 0;
                sx = 4;
                }
            }//If the passenger did not exist in the system, then a message will shown
            if (s == 1){
                System.out.println("Passenger's Name not found!");
                sx++;
            }
        }
    }
}
