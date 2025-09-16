package bus;

public class DestinationTicket extends Bus {
    private int [] available;

    public DestinationTicket(int[] available) {
        this.available = available;
    }

    @Override
    public String toString() { //A bus schedule will shown 
        return "---------------------------------------\n"
                + "*   DESTINATION   |  FARE  |  SEAT  *\n"
                + "---------------------------------------\n"
                + "* 1.)ALOR SETAR   |  RM10  |   "+ available[1] +"   *\n"
                + "* 2.)GEORGE TOWN  |  RM18  |   "+ available[2] +"   *\n"
                + "* 3.)IPOH         |  RM30  |   "+ available[3] +"   *\n"
                + "* 4.)MALACCA      |  RM60  |   "+ available[4] +"   *\n"
                + "* 5.)JOHOR BAHRU  |  RM70  |   "+ available[5] +"   *\n"
                + "---------------------------------------\n"
                + "---------------------------------------\n\n"
                + "THE BUS WILL START FROM KANGAR, PERLIS\n"
                + "PWD, STUDENT, & SENIOR CITIZEN will have 20% DISCOUNT!!!\n";
    }
    
}
