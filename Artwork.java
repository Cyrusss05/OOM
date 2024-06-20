public class Artwork {
    public void welcomeScreen(int option) {
        String artWork;

        if (option == 1) {
            artWork = """
888       888          888                                             888                       d8888                           .d8888b.  888                        888     
888   o   888          888                                             888                      d88888                          d88P  Y88b 888                        888     
888  d8b  888          888                                             888                     d88P888                          888    888 888                        888     
888 d888b 888  .d88b.  888  .d8888b .d88b.  88888b.d88b.   .d88b.      888888 .d88b.          d88P 888  .d88b.  888d888 .d88b.  888        88888b.   .d88b.   .d8888b 888  888
888d88888b888 d8P  Y8b 888 d88P"   d88""88b 888 "888 "88b d8P  Y8b     888   d88""88b        d88P  888 d8P  Y8b 888P"  d88""88b 888        888 "88b d8P  Y8b d88P"    888 .88P
88888P Y88888 88888888 888 888     888  888 888  888  888 88888888     888   888  888       d88P   888 88888888 888    888  888 888    888 888  888 88888888 888      888888K 
8888P   Y8888 Y8b.     888 Y88b.   Y88..88P 888  888  888 Y8b.         Y88b. Y88..88P      d8888888888 Y8b.     888    Y88..88P Y88b  d88P 888  888 Y8b.     Y88b.    888 "88b
888P     Y888  "Y8888  888  "Y8888P "Y88P"  888  888  888  "Y8888       "Y888 "Y88P"      d88P     888  "Y8888  888     "Y88P"   "Y8888P"  888  888  "Y8888   "Y8888P 888  888
                            """;
        System.out.println("\n\n"+artWork);
        }


        if (option == 2) {
            artWork ="""

 .d8888b.  888                        888            d8b                .d8888b.                                                       .d888          888      888 
d88P  Y88b 888                        888            Y8P               d88P  Y88b                                                     d88P"           888      888 
888    888 888                        888                              Y88b.                                                          888             888      888 
888        88888b.   .d88b.   .d8888b 888  888       888 88888b.        "Y888b.   888  888  .d8888b .d8888b .d88b.  .d8888b  .d8888b  888888 888  888 888      888 
888        888 "88b d8P  Y8b d88P"    888 .88P       888 888 "88b          "Y88b. 888  888 d88P"   d88P"   d8P  Y8b 88K      88K      888    888  888 888      888 
888    888 888  888 88888888 888      888888K 888888 888 888  888            "888 888  888 888     888     88888888 "Y8888b. "Y8888b. 888    888  888 888      Y8P 
Y88b  d88P 888  888 Y8b.     Y88b.    888 "88b       888 888  888      Y88b  d88P Y88b 888 Y88b.   Y88b.   Y8b.          X88      X88 888    Y88b 888 888       "  
 "Y8888P"  888  888  "Y8888   "Y8888P 888  888       888 888  888       "Y8888P"   "Y88888  "Y8888P "Y8888P "Y8888   88888P'  88888P' 888     "Y88888 888      888 
                                                                                                                                                                   
                                                                                                                                                                   
                                                                                                                                                                   

                    """;
        System.out.println("\n\n"+artWork);
        }


        if (option == 3) {
            artWork = """
                \n\n
888    888          888              d8b                                    888    888                                                       888
888    888          888              Y8P                                    888    888                                                       888
888    888          888                                                     888    888                                                       888
8888888888  .d88b.  888 88888b.      888 .d8888b       .d88b.  88888b.      888888 88888b.   .d88b.      888  888  888  8888b.  888  888     888
888    888 d8P  Y8b 888 888 "88b     888 88K          d88""88b 888 "88b     888    888 "88b d8P  Y8b     888  888  888     "88b 888  888     888
888    888 88888888 888 888  888     888 "Y8888b.     888  888 888  888     888    888  888 88888888     888  888  888 .d888888 888  888     Y8P
888    888 Y8b.     888 888 d88P     888      X88     Y88..88P 888  888     Y88b.  888  888 Y8b.         Y88b 888 d88P 888  888 Y88b 888      " 
888    888  "Y8888  888 88888P"      888  88888P'      "Y88P"  888  888      "Y888 888  888  "Y8888       "Y8888888P"  "Y888888  "Y88888     888
                        888                                                                                                          888        
                        888                                                                                                     Y8b d88P        
                        888                                                                                                      "Y88P"         
            """;
        System.out.println("\n\n"+artWork);
        }

        if (option == 4){
            System.out.println("\n+++++++++++++ Group Passenger Check-in +++++++++++++");
        }

        if (option == 5 ) {
            System.out.println("\n+++++++++++++ Single Passenger Check-in +++++++++++++");
        }

        if (option == 6){
            System.out.println("\n\t\t\t\t\t+++++++++++++ Welcome to AeroCheck AirLines +++++++++++++\n\nTo Further Proceed, Please enter a value.\n");
        }

        if (option == 7){
            System.out.println("\n\t\t\t\t+++++++++++++ Exiting AeroCheck AirLines. Have a great day! +++++++++++++\n");
        }
    }
}
