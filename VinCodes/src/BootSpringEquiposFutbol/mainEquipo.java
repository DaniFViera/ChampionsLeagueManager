package BootSpringEquiposFutbol;

import java.util.*;

public class mainEquipo {
    /**
     * Main method that set a list of predefined teams,
     * a list of allowed countries in the ECL and a list
     * of the winners of a trophy in that competition.
     * It also generates a menu for the user, allowing him to
     * do actions like create, modify or delete a team and
     * show them.
     *
     */
    public static void main(String[] args) {
        HashSet listaequipos = new HashSet();
        listaequipos.add(new equipo("Madrid", "Spain", "https://pbs.twimg.com/profile_images/1284197749030887429/7n6w-Urk_400x400.jpg"));
        listaequipos.add(new equipo("Barcelona", "Spain", "Madrid", "https://pbs.twimg.com/profile_images/1409740934217142273/-RmOAoJG_400x400.jpg"));
        listaequipos.add(new equipo("Munich", "Germany", "Dortmund", "https://1.bp.blogspot.com/-um5PXx4iQ2I/XcHguqlUIRI/AAAAAAABWj0/hKJabU4vQzE8QHDo6-bQalZN-45Xdt9rgCLcBGAsYHQ/s1600/FC%2BBayern%2BMunchen.png"));
        listaequipos.add(new equipo("Dortmund", "Germany", "Munich", "https://a.espncdn.com/i/teamlogos/soccer/500/124.png"));
        listaequipos.add(new equipo("PSG", "France", "Olympique", "https://m.media-amazon.com/images/I/61uc8HkaHKL._AC_SL1001_.jpg"));
        listaequipos.add(new equipo("OlympiqueLyon", "France", "PSG", "https://www.designfootball.com/images/joomgallery/originals/football_crests_8/olympique_lyonnais_-_logo_concept_20190517_1670321325.png"));
        listaequipos.add(new equipo("ManchersterCity", "UK", "Liverpool", "https://stadium-azteca.underdog.gs/soccerly/1/2015/12/23/1450920983.jpg"));
        listaequipos.add(new equipo("liverpool", "UK", "ManchesterCity", "https://www.logoeps.net/wp-content/uploads/2011/09/liverpool_fc-logo.jpg"));
        ArrayList<equipo> list = new ArrayList<equipo>(listaequipos);

        ArrayList<String> countries = new ArrayList<>(
                Arrays.asList("Portugal","Spain","France","UK","Belgium","Germany","Italy","Netherlands",
                        "Switzerland","Austria","Belarus","Poland","Denmark","Czech","Slovenia","Croatia",
                        "Serbia","Bulgaria","Greece","Romania","Turkey","Cyprus","Moldova","Ukraine",
                        "Hungary", "Slovakia", "Russia", "Azerbaijan", "Kazakhstan", "Sweden", "Norway",
                        "Finland", "Israel")
        );

        ArrayList<String> championswinnerteams = new ArrayList<>(
                Arrays.asList("Ajax", "Aston", "Barcelona", "Benfica", "Celtic", "Chelsea", "Dortmund",
                        "Eindhoven", "Estrella", "FCSB", "Feyenoord", "Forest", "Hamburgo", "Inter",
                        "Juventus", "Liverpool", "Madrid", "ManchesterUnited", "Marsella", "Milan",
                        "Munich", "Oporto")
        );

        do{
            System.out.println("\n---------------------------------------------------------------------");
            System.out.println("Choose:");
            System.out.println("1: Create Team");
            System.out.println("2: Modify Team");
            System.out.println("3: Delete Team");
            System.out.println("4: Show Team");
            System.out.println("5: Show Champions League Titles");
            System.out.println("6: Show Champions League Winner Teams");
            System.out.println("0: Exit");
            System.out.println("---------------------------------------------------------------------");
            Scanner userinput = new Scanner(System.in);
            int option = userinput.nextInt();
            equipo team = new equipo();

            switch (option) {
                case 1:
                    team.createTeam(list, countries);
                    break;

                case 2:
                    team.modifyTeam(list);
                    break;

                case 3:
                    team.removeTeam(list);
                    break;

                case 4:
                    for(Iterator<equipo> it = list.iterator(); it.hasNext();){
                        it.next().showTeam();
                    }
                    break;

                case 5:
                    System.out.println("Introduce Team Name:");
                    Scanner chosenteam = new Scanner(System.in);
                    team.hasTrophy(chosenteam.next());
                    break;

                case 6:
                    for(int i = 0; i < championswinnerteams.size(); i++){
                        team.hasTrophy(championswinnerteams.get(i));
                    }
                    break;

                case 0:
                    System.out.println("Goodbye!");
                    break;

                default:    break;
            }
            if(option == 0){ break; }
        } while (true);
    }
}
