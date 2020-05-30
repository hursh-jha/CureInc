
package cure_inc;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class GameFrame extends JFrame implements ActionListener{
    private static ArrayList<Integer>infectedPopulations = new ArrayList<>();
    private static JTable comparisonTable;
    private static JScrollPane scrollBar;
    private static JPanel statePanel;
    private static Double points = 10.0;
    private static int usPopulation = 328400000;
    private static int infected = 3000;
    private static int deaths = 0;
    private static Boolean completeOne = false;
    private static Boolean completeTwo = false;
    private static Boolean completeThree = false;
    private JButton day = new JButton("Advance Day");
    private JButton month = new JButton("Advance Month");
    private JButton week = new JButton("Advance Week");
    private JPanel advanceButtons= new JPanel();
    private double happiness = 100.0;
    private static double researchGain = 2;
    private static double infectionRate = 1.05;
    private static double acceleration;
    private static double populationIncrease = 1.00003;
    private static double deathRate;
    private static double healthy = usPopulation-infected;
    private static int days = 1;
    private static JLabel stats = new JLabel("Population: "+usPopulation + "  Healthy:"+(healthy)+"  Infected:"+infected + "  Dead:0"  +"  Points:"+points + "  Day:"+days);
    private final Color LIGHT_BLUE = new Color(33, 204, 255);
    private static JLabel imageLabel;
    private JPanel upgradeTree;
    private JPanel research;
    private JPanel government;
    private JPanel hygiene;
    private JButton exiter = new JButton("Exit");
    
    private static int[] statepop = {5000000, 7000000, 3000000, 40000000, 6000000, 3000000, 100000, 22000000, 11000000, 2000000, 13000000, 7000000, 3000000, 3000000, 5000000, 5000000, 1000000, 6000000, 7000000, 10000000, 6000000, 3000000, 6000000, 1000000, 2000000, 3000000, 1000000, 9000000, 2000000, 19000000, 11000000, 800000, 12000000, 4000000, 4000000, 13000000, 1000000, 5000000, 900000, 7000000, 30000000, 3000000, 600000, 9000000, 8000000, 2000000, 6000000, 600000};

    private static String[] states = {"Alabama", "Arizona", "Arkansas", "California", "Colorado", "Connecticut", "Delaware", "Florida", "Georgia", "Idaho", "Illinois", "Indiana", "Iowa", "Kansas", "Kentucky", "Louisiana", "Maine", "Maryland", "Massachusetts", "Michigan", "Minnesota", "Mississippi", "Missouri", "Montana", "Nebraska", "Nevada", "New Hampshire", "New Jersey", "New Mexico", "New York", "North Carolina", "North Dakota", "Ohio", "Oklahoma", "Oregon", "Pennsylvania", "Rhode Island", "South Carolina", "South Dakota", "Tennessee", "Texas", "Utah", "Vermont", "Virginia", "Washington", "West Virginia", "Wisconsin", "Wyoming"};
    
    private JButton[] researchArray = new JButton[6];
    private JButton[] governmentArray = new JButton[6];
    private JButton[] hygieneArray = new JButton[6];
    
    private  JButton identifyingStrain = new JButton("Identifying the Strain");
    private JButton findingPatientZero = new JButton("Find Patient Zero");
    private JButton contactTracing = new JButton("Implement Contact Tracing");
    private JButton analyzingStrain = new JButton("Analyze the Pathogen");
    private JButton beginAnimalTrials = new JButton("Begin Conducting Trials on Animals");
    private JButton beginClinicalTrials = new JButton("Begin Conducting Clinical Trials");
    
    private JButton publicAnouncement = new JButton("Anounce the Disease to the Public");
    private JButton increaseHealthFunding = new JButton("Increase Funding to the Health Sector");
    private JButton increasePPE = new JButton("Increase Supply of PPE");
    private JButton increaseThreatAssessment = new JButton("Increase the Level of the Testing");
    private JButton shutdownPublicPlaces = new JButton("Close Public Places");
    private JButton martialLaw = new JButton("Begin Martial Law");
    private static ImageIcon goodIcon;
    private static ImageIcon badIcon;
    private static ImageIcon okayIcon;        
    private JButton washingHands = new JButton("Wash Hands");
    private JButton handSanitizer = new JButton("Use Hand Sanitizer");
    private JButton propperHealthPractices = new JButton("Use Proper Public Health Practices");
    private JButton wearPPE = new JButton("Wear PPE");
    private JButton socialDistancing = new JButton("Start Social Distancing");
    private JButton selfIsolation = new JButton("Start Self Isolating");
    private static State[] stateArray = new State[48];
    private static Double setDeathRate;
    public GameFrame(Double increaseRate, Double deathRate){
        super();
        this.setDeathRate = deathRate;
        this.acceleration = increaseRate;
        
        day.addActionListener(this);
        week.addActionListener(this);
        month.addActionListener(this);
        
        researchArray[0] = identifyingStrain;
        researchArray[1] = findingPatientZero;
        researchArray[2] = contactTracing;
        researchArray[3] = analyzingStrain;
        researchArray[4] = beginAnimalTrials;
        researchArray[5] = beginClinicalTrials;
        
        
        
        governmentArray[0] = publicAnouncement;
        governmentArray[1] = increaseHealthFunding;
        governmentArray[2] = increasePPE;
        governmentArray[3] = increaseThreatAssessment;
        governmentArray[4] = shutdownPublicPlaces;
        governmentArray[5] = martialLaw;
        
        hygieneArray[0] = washingHands;
        hygieneArray[1] = handSanitizer;
        hygieneArray[2] = propperHealthPractices;
        hygieneArray[3] = wearPPE;
        hygieneArray[4] = socialDistancing;
        hygieneArray[5] = selfIsolation;
        
        exiter.addActionListener(this);
        
        java.net.URL goodPicture = getClass().getResource("good.png");
         goodIcon = new ImageIcon(new ImageIcon(goodPicture).getImage().getScaledInstance(600, 500, Image.SCALE_DEFAULT));
        
        java.net.URL badPicture = getClass().getResource("bad.png");
         badIcon = new ImageIcon(new ImageIcon(badPicture).getImage().getScaledInstance(600, 500, Image.SCALE_DEFAULT));
        
        java.net.URL okayPicture = getClass().getResource("okay.png");
         okayIcon = new ImageIcon(new ImageIcon(okayPicture).getImage().getScaledInstance(600, 500, Image.SCALE_DEFAULT));
        
        imageLabel = new JLabel(okayIcon);
        
        
        for(int i = 0; i<48; i++){
            stateArray[i] = new State(states[i], statepop[i], (int) (statepop[i]*((double) infected/(double) usPopulation)), 0);
        }
        
        upgradeTree = new JPanel();
        upgradeTree.setLayout(new BorderLayout());
        research = new JPanel();
        government = new JPanel();
        hygiene = new JPanel();
        advanceButtons.add(day);
        advanceButtons.add(week);
        advanceButtons.add(month);
        for(int i = 0; i<6;i++){
            researchArray[i].addActionListener(this);
            governmentArray[i].addActionListener(this);
            hygieneArray[i].addActionListener(this);
            
            research.add(researchArray[i]);
            government.add(governmentArray[i]);
            hygiene.add(hygieneArray[i]);
            
        }
        
        for(int i = 1; i<6;i++){
            researchArray[i].setVisible(false);
            governmentArray[i].setVisible(false);
            hygieneArray[i].setVisible(false);
            
        }
        stateSetup(this, false);
        exiter.addActionListener(this);
        upgradeTree.add(research, BorderLayout.NORTH);
        upgradeTree.add(government, BorderLayout.CENTER);
        upgradeTree.add(hygiene, BorderLayout.SOUTH);
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BorderLayout());
        buttonPanel.add(upgradeTree, BorderLayout.NORTH);
        buttonPanel.add(advanceButtons);
        buttonPanel.add(exiter, BorderLayout.SOUTH);
        this.add(stats, BorderLayout.NORTH);
        this.add(imageLabel, BorderLayout.EAST);
        this.add(buttonPanel, BorderLayout.SOUTH);
        this.setBounds(320, 10, 1400, 800);
        this.getContentPane().setBackground(LIGHT_BLUE);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        if(command.equals("Identifying the Strain")){
            if(points>=5){
                researchArray[0].setEnabled(false);
                researchArray[1].setVisible(true);
                points-=5;
                stats.setText("Population: "+usPopulation + "  Healthy:"+healthy+"  Infected:"+infected + "  Dead:"+deaths+"  Points:"+points + "  Day:"+days);
                this.validate();
                this.repaint();
                researchGain*=1.15 ;
                Anouncement upgrade= new Anouncement("<html>Identifying Strain - <br>Scientists have identified the specific strain of the virus wreaking havoc across the country, <br>your research has increased by 15%</html>");
            }else{
                Anouncement warning= new Anouncement("You need at least 5 points");
            }
            
        }else if(command.equals("Find Patient Zero")){
            if(points>=8){
                researchArray[1].setEnabled(false);
                researchArray[2].setVisible(true);
                points-=8;
                stats.setText("Population: "+usPopulation + "  Healthy:"+healthy+"  Infected:"+infected + "  Dead:"+deaths+"  Points:"+points + "  Day:"+days);
                this.validate();
                this.repaint();
                Anouncement upgrade= new Anouncement("<html>Finding Patient Zero - <br>Patient Zero has been found. <br>The path of the infection can be tracked and stopped, <br>your research has increased by 30%</html>");
                researchGain*=1.3;
            }else{
                Anouncement warning= new Anouncement("You need at least 8 points");
            }
            
        }else if(command.equals("Implement Contact Tracing")){
            
            if(points>=35){
                researchArray[2].setEnabled(false);
                researchArray[3].setVisible(true);
                points-=35;
                stats.setText("Population: "+usPopulation + "  Healthy:"+healthy+"  Infected:"+infected + "  Dead:"+deaths+"  Points:"+points + "  Day:"+days);
                this.validate();
                this.repaint();
                Anouncement upgrade= new Anouncement("<html>Contact Tracing - <br>Scientists have implemented contact tracing. <br>By tracing the contacts of infected individuals, testing them for infection, treating the infected, <br>and tracing their contacts in turn, public health aims to reduce infections in the population, <br>your research has increased by 80%</html>");
                researchGain*=1.8;
            }else{
                Anouncement warning= new Anouncement("You need at least 35 points");
            }
            
        }else if(command.equals("Analyze the Pathogen")){
            
            if(points>=70){
                researchArray[3].setEnabled(false);
                researchArray[4].setVisible(true);
                points-=70;
                stats.setText("Population: "+usPopulation + "  Healthy:"+healthy+"  Infected:"+infected + "  Dead:"+deaths+"  Points:"+points + "  Day:"+days);
                this.validate();
                this.repaint();
                Anouncement upgrade= new Anouncement("<html>Analyze the Pathogen - <br>Scientists have managed to isolate the virus and are now studying the virus for possible cures, <br>your research has increased by 130%</html>");
                researchGain*=2.3;
            }else{
                Anouncement warning= new Anouncement("You need at least 70 points");
            }
        }else if(command.equals("Begin Conducting Trials on Animals")){
            
            if(points>=120){
                researchArray[4].setEnabled(false);
                researchArray[5].setVisible(true);
                points-=120;
                stats.setText("Population: "+usPopulation + "  Healthy:"+healthy+"  Infected:"+infected + "  Dead:"+deaths+"  Points:"+points + "  Day:"+days);
                this.validate();
                this.repaint();
                Anouncement upgrade= new Anouncement("<html>Begin Animal Trials - <br>Scientists have formulated a possible vaccine and are now testing this vaccine upon animals to check if human use will be feasible, <br>your research has increased by 160%</html>");
                researchGain*=2.6;
            }else{
                Anouncement warning= new Anouncement("You need at least 120 points");                
            }
        }else if(command.equals("Begin Conducting Clinical Trials")){
            if(points>=200){
                researchArray[5].setEnabled(false);
                points-=200;
                stats.setText("Population: "+usPopulation + "  Healthy:"+healthy+"  Infected:"+infected + "  Dead:"+deaths+"  Points:"+points + "  Day:"+days);
                this.validate();
                this.repaint();
                Anouncement upgrade= new Anouncement("<html>Begin Clinical Trials - <br>The vaccine seems to work on animals. <br>Now scientists will begin clinical trials to test if the vaccine will truly work with human subjects, <br>your research has increased by 300%</html>");
                researchGain*=4;
                completeOne = true;
            }else{
                Anouncement warning= new Anouncement("You need at least 200 points");
            }
        }
        
        
        else if(command.equals("Anounce the Disease to the Public")){
            
            if(points>=3){
                governmentArray[0].setEnabled(false);
                governmentArray[1].setVisible(true);
                points-=3;
                stats.setText("Population: "+usPopulation + "  Healthy:"+healthy+"  Infected:"+infected + "  Dead:"+deaths+"  Points:"+points + "  Day:"+days);
                this.validate();
                this.repaint();
                Anouncement upgrade= new Anouncement("<html>Public announcement - <br>The public leadership has stepped up and made a nation-wide announcement of an <br>alarming new disease spreading throughout the country, <br>the average people infected by one person has decreased by .01</html>");
                infectionRate-=.01;
            }else{
                Anouncement warning= new Anouncement("You need at least 3 points");
            }
        }else if(command.equals("Increase Funding to the Health Sector")){
            
            if(points>=8){
                governmentArray[1].setEnabled(false);
                governmentArray[2].setVisible(true);
                points-=8;
                stats.setText("Population: "+usPopulation + "  Healthy:"+healthy+"  Infected:"+infected + "  Dead:"+deaths+"  Points:"+points + "  Day:"+days);
                this.validate();
                this.repaint();
                Anouncement upgrade= new Anouncement("<html>Increase health funding - <br>Realizing the urgency of the situation, the US government has implemented <br>a new budget which reflects a sharp increase in healthcare funding, <br>your research has increased by 15%</html>");
                researchGain*=1.15;
            }else{
                Anouncement warning= new Anouncement("You need at least 8 points");
            }
        }else if(command.equals("Increase Supply of PPE")){
            
            if(points>=24){
                governmentArray[2].setEnabled(false);
                governmentArray[3].setVisible(true);
                points-=24;
                stats.setText("Population: "+usPopulation + "  Healthy:"+healthy+"  Infected:"+infected + "  Dead:"+deaths+"  Points:"+points + "  Day:"+days);
                this.validate();
                this.repaint();
                Anouncement upgrade= new Anouncement("<html>Increase PPE supply - <br>As supplies dwindle, panicked citizens find the shelves restocked with <br>necessary personal protective equipment due to the government’s newly implemented production policies, <br>the acceleration of the infection rate has decreased by .5%</html>");
                acceleration-=.0005;
            }else{
                Anouncement warning= new Anouncement("You need at least 24 points");
            }
        }else if(command.equals("Increase the Level of the Testing")){
            
            if(points>=55){
                governmentArray[3].setEnabled(false);
                governmentArray[4].setVisible(true);
                points-=55;
                stats.setText("Population: "+usPopulation + "  Healthy:"+healthy+"  Infected:"+infected + "  Dead:"+deaths+"  Points:"+points + "  Day:"+days);
                this.validate();
                this.repaint();
                Anouncement upgrade= new Anouncement("<html>Increase testing - <br>Bolstered by heavy spending from the government, labs across the nation have managed to mass-produce <br>large quantities of testing kits, giving everyday citizens access to the supply, <br>your research has increased by 70%<html>");
                researchGain*=1.7;
            }else{
                Anouncement warning= new Anouncement("You need at least 55 points");
            }
            
        }else if(command.equals("Close Public Places")){
            if(points>=100){
                governmentArray[4].setEnabled(false);
                governmentArray[5].setVisible(true);
                points-=100;
                stats.setText("Population: "+usPopulation + "  Healthy:"+healthy+"  Infected:"+infected + "  Dead:"+deaths+"  Points:"+points + "  Day:"+days);
                this.validate();
                this.repaint();
                Anouncement upgrade= new Anouncement("<html>Shut down public places - <br>As infection rates continue to rise, the government is forced to shut down <br>all public businesses in an effort to contain the overwhelming disease, <br>the average people infected by one person has decreased by .05</html>");
                infectionRate-=.05;
            }else{
                Anouncement warning= new Anouncement("You need at least 100 points");
            }
        }else if(command.equals("Begin Martial Law")){
            if(points>=150){
                governmentArray[5].setEnabled(false);
                points-=150;
                stats.setText("Population: "+usPopulation + "  Healthy:"+healthy+"  Infected:"+infected + "  Dead:"+deaths+"  Points:"+points + "  Day:"+days);
                this.validate();
                this.repaint();
                Anouncement upgrade= new Anouncement("<html>Martial law - <br>In a last-ditch effort, the government has enforced Martial law. <br>No matter the toll on liberty, the American nation and its people must endure, <br>the average people infected by one person has decreased by .1</html>");
                infectionRate-=.1;
                completeTwo = true;
            }else{
                Anouncement warning= new Anouncement("You need at least 150 points");
            }
        }
        
        else if(command.equals("Wash Hands")){
            if(points>=2){
                hygieneArray[0].setEnabled(false);
                hygieneArray[1].setVisible(true);
                points-=2;
                stats.setText("Population: "+usPopulation + "  Healthy:"+healthy+"  Infected:"+infected + "  Dead:"+deaths+"  Points:"+points + "  Day:"+days);
                this.validate();
                this.repaint();
                Anouncement upgrade= new Anouncement("<html>Washing Hands - <br>The general population has begun to wash its hands properly making sure the vaccine does not stay on one’s skin, <br>the average people infected by one person has decreased by .02</html>");
                infectionRate-=.02;
            }else{
                Anouncement warning= new Anouncement("You need at least 2 points");
            }
        }else if(command.equals("Use Hand Sanitizer")){
            if(points>=6){
                hygieneArray[1].setEnabled(false);
                hygieneArray[2].setVisible(true);
                points-=6;
                stats.setText("Population: "+usPopulation + "  Healthy:"+healthy+"  Infected:"+infected + "  Dead:"+deaths+"  Points:"+points + "  Day:"+days);
                this.validate();
                this.repaint();
                Anouncement upgrade= new Anouncement("<html>Hand Sanitizer - People now further sanitize their hands after thoroughly washing them, <br>ensuring the elimination of the virus on hands, <br>the average people infected by one person has decreased by .035</html>");
                infectionRate-=.035;
            }else{
                Anouncement warning= new Anouncement("You need at least 6 points");
            }
        }else if(command.equals("Use Proper Public Health Practices")){
            
            if(points>=23){
                hygieneArray[2].setEnabled(false);
                hygieneArray[3].setVisible(true);
                points-=23;
                stats.setText("Population: "+usPopulation + "  Healthy:"+healthy+"  Infected:"+infected + "  Dead:"+deaths+"  Points:"+points + "  Day:"+days);
                this.validate();
                this.repaint();
                Anouncement upgrade= new Anouncement("<html>Proper Public Health Practices - <br>The general population has begun to follow proper public health policies. <br>Ex. covering sneezes and coughs, not attending work if sick, <br>the acceleration of the infection rate has decreased by 1%</html>");
                acceleration-=.001;
            }else{
                Anouncement warning= new Anouncement("You need at least 23 points");
            }
        }else if(command.equals("Wear PPE")){
            if(points>=62){
                hygieneArray[3].setEnabled(false);
                hygieneArray[4].setVisible(true);
                points-=62;
                stats.setText("Population: "+usPopulation + "  Healthy:"+healthy+"  Infected:"+infected + "  Dead:"+deaths+"  Points:"+points + "  Day:"+days);
                this.validate();
                this.repaint();
                Anouncement upgrade= new Anouncement("<html>Wear PPE - <br>The general population has started wearing PPE in public. <br>Personal protective equipment is protective clothing, helmets, goggles, or other garments<br> or equipment designed to protect the wearer's body from injury or infection, <br>the average people infected by one person has decreased by .07</html>");
                infectionRate-=.07;
            }else{
                Anouncement warning= new Anouncement("You need at least 62 points");
            }
        }else if(command.equals("Start Social Distancing")){
            if(points>=100){
                hygieneArray[4].setEnabled(false);
                hygieneArray[5].setVisible(true);
                points-=100;
                stats.setText("Population: "+usPopulation + "  Healthy:"+healthy+"  Infected:"+infected + "  Dead:"+deaths+"  Points:"+points + "  Day:"+days);
                this.validate();
                this.repaint();
                Anouncement upgrade= new Anouncement("<html>Social Distancing - <br>People have begun to stay at home and away from public places to slow the spread of the infection. <br>In public people stay 6 feet apart to reduce the ease of infection, <br>the average people infected by one person has decreased by .13</html>");
                infectionRate-=.13;
            }else{
                Anouncement warning= new Anouncement("You need at least 100 points");
            }
        }else if(command.equals("Start Self Isolating")){
            if(points>=130){
                hygieneArray[5].setEnabled(false);
                points-=130;
                stats.setText("Population: "+usPopulation + "  Healthy:"+healthy+"  Infected:"+infected + "  Dead:"+deaths+"  Points:"+points + "  Day:"+days);
                this.validate();
                this.repaint();
                Anouncement upgrade= new Anouncement("<html>Self Isolation - <br>Those at risk of infection or thought to have the infection self-isolate in order to eliminate spread to even close ones, <br>the average people infected by one person has decreased by .17</html>");
                infectionRate-=.17;
                completeThree=true;
            }else{
                Anouncement warning= new Anouncement("You need at least 130 points");
            }
        }else if (command.equals("Exit")){
            System.exit(0);
        }else if (command.equals("Advance Day")){
            dayAdvance(this);
        }else if (command.equals("Advance Week")){
            for(int i = 0; i<7;i++){
                Boolean okay = dayAdvance(this);
                if(okay){
                    break;
                }
            }
        }else if (command.equals("Advance Month")){
            for(int i = 0; i<30;i++){
                Boolean okay = dayAdvance(this);
                if(okay){
                    break;
                }
            }
        }
    }
    public static void main(String[] args){
        GameFrame test = new GameFrame(1.004,.0125);
    }
    public static Boolean dayAdvance(GameFrame object){
        usPopulation*=populationIncrease;
        usPopulation-=(infected*deathRate);
        infectedPopulations.add(infected);
        points+=researchGain;
        days++;
        deaths+=infectedPopulations.get(0)*deathRate;
        infected-=(infected*deathRate);
        infected*=infectionRate;
        infectionRate*=acceleration;
        healthy=usPopulation-infected;
        
        object.remove(imageLabel);
        object.validate();
        object.repaint();
        if(infectionRate<1.05){
            imageLabel = new JLabel(goodIcon);
        }else if (infectionRate<1.3){
            imageLabel = new JLabel(okayIcon);
        }else{
            imageLabel = new JLabel(badIcon);
        }
        imageLabel.validate();
        imageLabel.repaint();
        object.add(imageLabel, BorderLayout.EAST);
        object.validate();
        object.repaint();
        
        if(days>=15){
            deathRate = setDeathRate;
            if(days>15){
                infectedPopulations.remove(0);
            }
        }
        if(usPopulation<0){
            usPopulation = 0;
        }
        if(healthy<0){
            healthy = 0;
        }
        stats.setText("Population: "+usPopulation + "  Healthy:"+healthy+"  Infected:"+infected + "  Dead:"+deaths+"  Points:"+points + "  Day:"+days);
        
        for(int i = 0; i<48; i++){
            
            stateArray[i] = new State(
                    states[i], 
                    (int) (stateArray[i].getCitizens()*populationIncrease - stateArray[i].getInfected()*deathRate), 
                    (int) (stateArray[i].getCitizens()*(double)infected/((double)usPopulation+1)), 
                    (int)(stateArray[i].getInfected()*deaths/(infected+deaths)));
        
        }
        
        if(infectionRate<=.9 || (completeOne && completeTwo && completeThree)){
            Anouncement winScreen = new Anouncement("Congrats, you have limitied the virus to a good extent with "+usPopulation+" alive");
            object.dispose();
            //MainFrame welcomeFrme = new MainFrame();
            //object = null;
            
            return true;
        }
        if((infected+deaths)>healthy){
            Anouncement winScreen = new Anouncement("Sorry, you have failed to limit the virus to a good extent with only "+usPopulation+" still healthy");
            object.dispose();
            //MainFrame welcomeFrme = new MainFrame();
            //object = null;
            
            return true;
        }
        
        stateSetup(object, true);
        randomEvent(object);
        object.validate();
        object.repaint();
        return false;
    }
    public static void stateSetup(GameFrame object, Boolean run){
        if(run){
            scrollBar.remove(comparisonTable);
            scrollBar.validate();
            scrollBar.repaint();
            
            object.remove(scrollBar);
            object.validate();
            object.repaint();
        }
        String[] tableHeaders = {"State", "Population", "Infected", "Dead"};
        String[][] tableData = new String[49][4];
        for(int i = 0; i<48;i++){
            JPanel tempPanel = new JPanel();
            tableData[i][0] = ((stateArray[i].getName()));
            tableData[i][1] = ((Integer.toString(stateArray[i].getCitizens())));
            tableData[i][2] = ((Integer.toString(stateArray[i].getInfected())));
            tableData[i][3] = ((Integer.toString(stateArray[i].getDead())));
        }
        //System.out.println(tableData[1][2]);
        object.validate();
        object.repaint();
        
        
        comparisonTable = new JTable(tableData,tableHeaders);
        scrollBar=new JScrollPane(comparisonTable,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        
        scrollBar.validate();
        scrollBar.repaint();
        object.add(scrollBar, BorderLayout.WEST);
        object.validate();
        object.repaint();
        
    }
    public static void randomEvent(GameFrame object){
        Double rng = Math.random()*2;
        if(0<rng && rng<.025){
            Anouncement event = new Anouncement("<html>Mutated Infection - <br>Virus has mutated making it deadlier leading to an increased national infection rate</html>");
            infectionRate+=.01;
        }else if(0.25<rng && rng<.05){
            infected*=1.01;
            Anouncement event = new Anouncement("<html>Public Protests - <br>The public is discontent with the way the government is handling the situation leading to protests. <br>Close contact during these protests is causing an unforeseen rise in the infection rate</html>");
        }else if(0.5<rng && rng<.075){
            points+=20;
            Anouncement event = new Anouncement("<html>Breakthrough in Research - <br>Scientists have made a great breakthrough in terms of finding a cure</html>");
        }else if(0.75<rng && rng<.1){
            infectionRate-=.05;
            Anouncement event = new Anouncement("<html>Companies Support Online Shopping - <br>Companies have started to offer several deals and discounts for online shopping. <br>This incentive has moved the public to stary home rather than go out shopping, lowering the infection rate.</html>");
        }
        stateSetup(object, true);
    }
}
