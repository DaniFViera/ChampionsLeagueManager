package BootSpringEquiposFutbol;

import java.awt.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class equipo {
    private String name, country, rival, badge;
    private int id = 0;
    private static int idcounter = 0;
    Scanner userinput = new Scanner(System.in);

    /**
     * Default constructor
     */
    public equipo() { }

    /**
     * Constructor for those teams without historic rival
     *
     * @param name Team's name.
     * @param country Team's country.
     * @param badge Team's badge.
     *
     */
    public equipo(String name, String country, String badge) {
        idcounter++;
        this.id = idcounter;
        this.name = name;
        this.country = country;
        this.badge = badge;
    }

    /**
     * Constructor for those teams with historic rival
     *
     * @param name Team's name.
     * @param country Team's country.
     * @param rival Team's historic rival
     * @param badge Team's badge.
     *
     */
    public equipo(String name, String country, String rival, String badge) {
        idcounter++;
        this.id = idcounter;
        this.name = name;
        this.country = country;
        this.rival = rival;
        this.badge = badge;
    }

    /**
     * Getters & Setters.
     *
     */
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getCountry() { return country; }
    public void setCountry(String country) { this.country = country; }

    public String getRival() { return rival; }
    public void setRival(String rival) { this.rival = rival; }

    public String getBadge() { return badge; }
    public void setBadge(String badge) { this.badge = badge; }

    /**
     * Method that creates a team from the user's input in case
     * it wasn't in the original list, asking for all its attributes.
     * It also checks if the new team's country is in the list of
     * allowed countries in the Champions League.
     *
     * @param lista List A with the teams set originally.
     * @param listb List B with the countries allowed in the ECL.
     *
     */
    public void createTeam(ArrayList<equipo> lista, ArrayList<String> listb){
        System.out.println("Introduce Team Name:");
        String tname1 = userinput.next();
        boolean isin = false;
        for(int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getName().equals(tname1)) {
                isin = true;
            }
        }
        if(!isin){
            System.out.println("Introduce its country:");
            String teamcountry = userinput.next();
            if (listb.contains(teamcountry)) {
                System.out.println("Introduce its badge:");
                String teambadge = userinput.next();
                System.out.println("Does it have any historic rival? Write 'y' if so.");
                String election = userinput.next();
                if (election == "y") {
                    System.out.println("Introduce Rival Team Name:");
                    String rivalname = userinput.next();
                    lista.add(new equipo(tname1, teamcountry, rivalname, teambadge));
                } else {
                    lista.add(new equipo(tname1, teamcountry, teambadge));
                }
            } else {
                System.out.println("Country not available on Europe Champions League");
            }
        } else {
            System.out.println("Team already on list");
        }
    }

    /**
     * Method that allows the user to modify the attributes
     * from a listed team. The user inputs a name and checks
     * it with the list, allowing him to choose what attribute
     * is going to change.
     *
     * @param list List of previously set teams.
     *
     */
    public void modifyTeam(ArrayList<equipo> list){
        System.out.println("Which team would you like to modify?");
        String tname2 = userinput.next();
        boolean teamfound = false;
        equipo chosenTeam = new equipo();
        for(int i = 0; i < list.size(); i++){
            if(list.get(i).getName().equals(tname2)) {
                teamfound = true;
                chosenTeam = list.get(i);
            }
        }
        if(teamfound) {
            System.out.println("Which attribute would you like to modify? Choose one");
            System.out.println("1. Name");
            System.out.println("2. Country");
            System.out.println("3. Rival");
            System.out.println("4. Badge");
            int attributeopt = userinput.nextInt();
            switch (attributeopt) {
                case 1:
                    System.out.println("Introduce new name");
                    chosenTeam.setName(userinput.next());
                    break;
                case 2:
                    System.out.println("Introduce new country");
                    chosenTeam.setCountry(userinput.next());
                    break;
                case 3:
                    System.out.println("Introduce new rival");
                    chosenTeam.setRival(userinput.next());
                    break;
                case 4:
                    System.out.println("Introduce new badge");
                    chosenTeam.setBadge(userinput.next());
                    break;
                default:
                    System.out.println("Attribute not valid");
                    break;
            }
        } else { System.out.println("Team not found."); }
    }

    /**
     * Method that allows the user to delete a team from
     * the originally set list of teams if it were on it
     * before.
     *
     * @param list List of previously set teams.
     *
     */
    public void removeTeam(ArrayList<equipo> list){
        System.out.println("Which team would you like to remove?");
        String tname3 = userinput.next();
        for(int i = 0; i < list.size(); i++){
            if(list.get(i).getName().equals(tname3)){
                list.remove(list.get(i));
                System.out.println("Team " + tname3 + " has been removed.");
            }
        }
    }

    /**
     * Method that shows the team's badge using the URL
     * set on its attribute.
     *
     * @param path String with the URL.
     *
     */
    public void showBadge(String path){
        Image image = null;
        try {
            URL url = new URL(path);
            image = ImageIO.read(url);
        } catch (IOException e) { }
        JFrame frame = new JFrame();
        JLabel lblimage = new JLabel(new ImageIcon(image));
        frame.getContentPane().add(lblimage, BorderLayout.CENTER);
        frame.setSize(300, 400);
        frame.setVisible(true);
    }

    /**
     * Method that shows the team and its attributes.
     *
     */
    public void showTeam(){
        System.out.print("ID: " + id + ", Name: " + getName() + ", Country: " + getCountry());
        if(getRival() != null){
            System.out.printf("Rival: "+ getRival());
        }
        System.out.printf(", Badge: \n");
        showBadge(getBadge());
    }

    /**
     * Method that shows a requested team's ECL trophies
     * if it has any and the years they were won.
     *
     * @param team String with the name of the requested
     *             team.
     *
     */
    public void hasTrophy(String team){
        switch (team){
            case "Madrid":
                System.out.println("Real Madrid has won 13 Champions Leagues in the following years:");
                System.out.println("1955/1956, 1956/1957, 1957/1958, 1958/1959, 1959/1960," +
                        "1965/1966, 1997/1998, 1999/2000, 2001/2002, 2013/2014, 2015/2016, " +
                        "2016/2017, 2017/2018\n");
                break;
            case "Milan":
                System.out.println("AC Milan has won 7 Champions Leagues");
                System.out.println("1962/63, 1968/69, 1988/89, 1989/90, 1993/94, 2002/03, 2006/07\n");
                break;
            case "Liverpool":
                System.out.println("Liverpool FC has won 6 Champions Leagues");
                System.out.println("1976/77, 1977/78, 1980/81, 1983/84, 2004/05, 2018/19\n");
                break;
            case "Munich":
                System.out.println("Bayern de Munich has won 6 Champions Leagues");
                System.out.println("1973/74, 1974/75, 1975/76, 2000/01, 2012/13, 2019/20\n");
                break;
            case "Barcelona":
                System.out.println("FC Barcelona has won 5 Champions Leagues");
                System.out.println("1991/92, 2005/06, 2008/09, 2010/11, 2014/15\n");
                break;
            case "Ajax":
                System.out.println("AFC Ajax has won 4 Champions Leagues");
                System.out.println("1970/71, 1971/72, 1972/73, 1994/95\n");
                break;
            case "Inter":
                System.out.println("Inter Milano has won 3 Champions Leagues");
                System.out.println("1963/64, 1964/65, 2009/10\n");
                break;
            case "ManchesterUnited":
                System.out.println("Manchester United has won 3 Champions Leagues");
                System.out.println("1967/68, 1998/99, 2007/08\n");
                break;
            case "Juventus":
                System.out.println("Juventus FC has won 2 Champions Leagues");
                System.out.println("1984/85, 1995/96\n");
                break;
            case "Benfica":
                System.out.println("Benfica has won 2 Champions Leagues");
                System.out.println("1960/61, 1961/62\n");
                break;
            case "Forest":
                System.out.println("Nottingham Forest Football Club has won 2 Champions Leagues");
                System.out.println("1978/79, 1979/80\n");
                break;
            case "Porto", "Oporto":
                System.out.println("FC Oporto has won 2 Champions Leagues");
                System.out.println("1986/87, 2003/04\n");
                break;
            case "Dortmund":
                System.out.println("Borussia Dortmund has won 1 Champions League");
                System.out.println("1996/97\n");
                break;
            case "Celtic":
                System.out.println("Celtic Glasgow has won 1 Champions League");
                System.out.println("1966/67\n");
                break;
            case "Chelsea":
                System.out.println("Chelsea FC has won 2 Champions Leagues");
                System.out.println("2011/12, 2020/21\n");
                break;
            case "Hamburgo":
                System.out.println("Hamburgo SV has won 1 Champions League");
                System.out.println("1982/83\n");
                break;
            case "Marsella":
                System.out.println("Olympique de Marsella has won 1 Champions League");
                System.out.println("1992/93\n");
                break;
            case "FCSB":
                System.out.println("Fotbal Club Steaua București has won 1 Champions Leagues");
                System.out.println("1985/86\n");
                break;
            case "Aston":
                System.out.println("Aston Villa FC has won 1 Champions Leagues");
                System.out.println("1981/82\n");
                break;
            case "Estrella":
                System.out.println("Estrella Roja de Belgrado has won 1 Champions Leagues");
                System.out.println("1990/91\n");
                break;
            case "Feyenoord":
                System.out.println("Feyenoord Rotterdam has won 1 Champions Leagues");
                System.out.println("1969/70\n");
                break;
            case "Eindhoven":
                System.out.println("FC Eindhovena has won 1 Champions Leagues");
                System.out.println("1987/88\n");
                break;
            default:
                System.out.println("It hasn't won any Champions League\n");
        }
    }
}
