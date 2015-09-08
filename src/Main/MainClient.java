package Main;
/*
 * ******************************************************
 *  * Copyright (C) 2015 Malimoi <sandeaujules975@gmail.com>
 *  *
 *  * This file (ChatClient) is part of YoutuberTycoon.
 *  *
 *  * Created by Malimoi on 13/07/15 11:42.
 *  *
 *  * YoutuberTycoon can not be copied and/or distributed without the express
 *  * permission of Malimoi.
 *  ******************************************************
 */


import javax.swing.*;

import player.Player;
import player.PlayerC;
import accessoires.Accessoire;
import accessoires.Camera;
import accessoires.CameraPerformance;
import accessoires.MicroPerformance;
import de.javasoft.plaf.synthetica.SyntheticaPlainLookAndFeel;
import frames.Progress;
import utilities.Evenement;
import utilities.EventComparator;
import utilities.Planning;
import utilities.PlanningComparator;
import utilities.Video;
import utilities.VideosComparator;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;
import java.net.MalformedURLException;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.List;

public class MainClient {

	/*
	 * Client propieties
	 */
	public static String first_choice = "";
	public static Player player = /* Ceci est UNIQUEMENT des valeurs de test. Toutes les valeurs seront envoyés par le serveur. */ 
			new PlayerC(null,16146,53120,21244,1,2335,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0);
	
	public static Long MAX_UUID_PLANNING;
	/*
	 * Mini-Game stats
	 */
	public static double Total_Clicks_Subs = 0;
	public static double Subs_By_Secs = 0;
	public static Integer sc_upgrade_1 = 0;
	public static Integer sc_upgrade_2 = 0;
	public static Integer sc_upgrade_3 = 0;
	public static Integer sc_upgrade_4 = 0;
	public static String Sc_Status = "Début dans";
	public static Integer Sc_Time = 120;
	
	/*
	 * For server
	 */
	public static boolean send = false;
	public static String str_send = "";
	
	/*
	 * ICI : PRESENT QUE DANS LES VERSIONS TEST POUR NE PAS PASSER PAS LE LAUCHER / SERVER
	 */
	public static Boolean IsTest = false;
	
	public static List<Video> videos = new ArrayList<Video>();
	public static List<Accessoire> cameras = new ArrayList<Accessoire>();
	public static List<Accessoire> micros = new ArrayList<Accessoire>();
	public static List<Planning> planning = new ArrayList<Planning>();
	public static List<Evenement> evenements = new ArrayList<Evenement>();
	public static List<String> datavi = new ArrayList<String>();
	public static List<String> datapl = new ArrayList<String>();
	public static List<String> dataev = new ArrayList<String>();
	
	public static String[] categ_list = {"HUMOUR","DIVERTISSEMENT","GAMING","ANIMAUX","MONTAGE","DEVELOPPEMENT","MUSIQUE",
		"SCIENCES","EDUCATION","MAKEUP/MODE","CUISINE"};
	
	public static ChatAccess access;
	
    public static JFrame frame;

    public static void main(String[] args) {
    	
    	if (!IsTest){
    		String server = "127.0.0.1";
            int port = 25565;
            //ChatAccess access = null;
            try {
                access = new ChatAccess(server, port);
            } catch (IOException ex) {
                System.out.println("Cannot connect to " + server + ":" + port);
                ex.printStackTrace();
                System.exit(0);
            }
            frame = new ChatFrame(access);
            frame.setTitle("Launcher YT");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setResizable(false);
            frame.setVisible(true);
    	}else{
    		setJFrames();
    	}    
    }
    public static void setJFrames(){
     	 /*
          * Ceci sont des valeurs fictives. Il faudra seulement get toutes les horraires sur le server.
 		 */
    	
    	/*
    	 * Accessoires
    	 */
    	cameras.add(new Camera("Yaton 600T", 400, new CameraPerformance(30), "ACCESSOIRES/CAMERAS/1", 1, true));
    	//System.out.println(access.get(0).getClass().getName());
    	micros.add(new Camera("Micro intégré", 0, new MicroPerformance(20), null, 2, true));
 		/*
 		 * On récupère les vidéos
 		 * format : new Videos(name[0],day[1],month[2],year[3],views[4],likes[5],dislikes[6],share[7],...)
 		 */
 		videos.add(new Video("JE MANGE DES CHIPS !", 28, 07, 15, 651L, 122L, 6L, 0L, "HUMOUR", 2, getCamera(1), null, null, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1L));
 		videos.add(new Video("JE M'APPELLE BYSLIDE", 27, 07, 15, 1254L, 215L, 3L, 3L, "GAMING", 2, getCamera(1), null, null, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2L));
 		videos.add(new Video("LE BYSLIDE CONTRE ATTAQUE", 29, 07, 15, 15254L, 2155L, 28L, 3L, "GAMING", 2, getCamera(1), null, null, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3L));
 		videos.add(new Video("5 CHOSES EXTRAORDINAIRES", 30, 07, 15, 2782L, 568L, 8L, 3L, "SCIENCES", 2, getCamera(1), null, null, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4L));
 		videos.add(new Video("VLOG #1 : LA MONTAGNE", 1, 8, 15, 0L, 0L, 0L, 0L, "VLOG", 2, getCamera(1), null, null, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5L));
 		videos.add(new Video("LE RETOUR DU BYSLIDE", 3, 8, 15, 0L, 0L, 0L, 0L, "GAMING", 2, getCamera(1), null, null, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 6L));
 		videos.add(new Video("EPICARRÉ : PVP SWAG", 5, 8, 15, 0L, 0L, 0L, 0L, "GAMING", 2, getCamera(1), null, null, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 7L));
 		videos.add(new Video("MON SETUP DE FOU 123", 8, 8, 15, 651L, 122L, 6L, 0L, "DIVERTISSEMENT", 2, getCamera(1), null, null, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 8L));
 		videos.add(new Video("J'AIME LES ASTICOTS", 25, 8, 15, 0L, 0L, 0L, 0L, "HUMOUR", 2, getCamera(1), null, null, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 9L));
 		Collections.sort(videos, new VideosComparator());
         Collections.reverse(videos);
         videos.add(new Video(null, -1, -1, -1, 0L, 0L, 0L, 0L, null, 0, null, null, null, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0L));
         
 		/*
 		 * Evenements
 		 */
         evenements.add(new Evenement(0, 0, 0, null, 0L));

         Collections.sort(evenements, new EventComparator());
         Collections.reverse(evenements);

 		/*
 		 * Planning
 		 */
         planning.add(new Planning(18, 19, 23, 8, 15, 3, 9L, 1L));
         planning.add(new Planning(16, 17, 24, 8, 15, 4, 9L, 2L));
         MAX_UUID_PLANNING=(long) planning.size()+1;
         int d = 1;
         
         while (d!=7){
        	 SimpleDateFormat formater = null;
 			Date now = new Date();
 			Calendar cal = Calendar.getInstance();
 			cal.setTime(now);
 			cal.add(Calendar.DAY_OF_YEAR, d-1); // <--
 			Date date = cal.getTime();
 			formater = new SimpleDateFormat("yy/MM/dd/HH/EEEE/MMMM/MMM");
 			String s = formater.format(date);
 			String[] sf = s.split("/");
 			if (MainClient.player.getWork()==1){
 				if (sf[4].contains("lundi")||sf[4].contains("mardi")||sf[4].contains("jeudi")||sf[4].contains("vendredi")){
 					planning.add(new Planning(8, 16, Integer.valueOf(sf[2]), Integer.valueOf(sf[1]), Integer.valueOf(sf[0]),
 							1, 0L,MAX_UUID_PLANNING));
 				}
 			}if (MainClient.player.getWork()==2){
 				if (sf[4].contains("lundi")||sf[4].contains("mardi")||sf[4].contains("mercredi")||sf[4].contains("jeudi")||sf[4].contains("vendredi")){
 					planning.add(new Planning(8, 16, Integer.valueOf(sf[2]), Integer.valueOf(sf[1]), Integer.valueOf(sf[0]),
 							1, 0L,MAX_UUID_PLANNING));
 				}
 			}if (MainClient.player.getWork()==3){
 				if (sf[4].contains("lundi")||sf[4].contains("mardi")||sf[4].contains("mercredi")||sf[4].contains("jeudi")
 						||sf[4].contains("vendredi")||sf[4].contains("samedi")){
 					planning.add(new Planning(8, 16, Integer.valueOf(sf[2]), Integer.valueOf(sf[1]), Integer.valueOf(sf[0]),
 							1, 0L,MAX_UUID_PLANNING));
 				}
 			}if (MainClient.player.getWork()==4){
 				planning.add(new Planning(8, 16, Integer.valueOf(sf[2]), Integer.valueOf(sf[1]), Integer.valueOf(sf[0]),
 						1, 0L,MAX_UUID_PLANNING));
 				
 			}
 			MAX_UUID_PLANNING++;
 			
 			d++;
         }
         
         planning.add(new Planning(0, 0, 0, 0, 0, 0, 0L, 0L));

         Collections.sort(planning, new PlanningComparator());
         Collections.reverse(planning);
         
         UIManager.put("Synthetica.window.decoration", Boolean.FALSE);
         try {
     		UIManager.setLookAndFeel(new SyntheticaPlainLookAndFeel());
     	} catch (Exception e) {
     		e.printStackTrace();
     	} 
         /*
          * If first_time
          */
         new ThemeSelector();
         
         /*
         JFrame frame = new JFrame();
         frame.setTitle("YoutuberTycoon V0.0.2");
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         frame.pack();
         frame.setLocationRelativeTo(null);
         frame.setResizable(false);
         frame.setVisible(true);
         */
     }
    /**
     * Chat client access
     */
    public static class ChatAccess extends Observable {
        private static final String CRLF = "\r\n"; // newline
        private Socket socket;
        private OutputStream outputStream;
		//private PrintWriter out = null;

        /**
         * Create socket, and receiving thread
         */
        public ChatAccess(String server, int port) throws IOException {
            socket = new Socket(server, port);
            outputStream = socket.getOutputStream();

            Thread receivingThread = new Thread() {
				@Override
                public void run() {
                    try {
                        BufferedReader in = new BufferedReader(
                                new InputStreamReader(socket.getInputStream()));
                        String line;
                        while (true)
                        	if ((line = in.readLine()) != null){
                        		System.out.println("WHILE : "+line);
                        		if (line.contains("startthegame")) {
                                	setJFrames();                               
                                }else if (line.contains("yourpseudo")) {
                                	player.setPseudo(line.split(" ")[1]);                           
                                }else if (line.contains("sc")) {
                                	if (line.split(" ")[1].contains("time")){
                                		Sc_Time=Integer.valueOf(line.split(" ")[2]);
                                	}else if (line.split(" ")[1].contains("status")){
                                		if(line.split(" ")[2].contains("game")){
                                			Sc_Status="Fin dans";
                                		}else{
                                			Sc_Status="Début dans";
                                		}
                                	}else{
                                		Total_Clicks_Subs=Double.valueOf(line.split(" ")[1]);  
                                    	int tot = (int) Total_Clicks_Subs;
                                    	Fenetre.tot_clicks_subs.setText(tot+"");
                                	}                        	
                                		                       	
                                }
                        		else{
                                	notifyObservers(line);
                                }
                        	}
                            
                    } catch (IOException ex) {
                        notifyObservers(ex);
                    }
                }
            };
            receivingThread.start();
        }

        @Override
        public void notifyObservers(Object arg) {
            super.setChanged();
            super.notifyObservers(arg);
        }

        /**
         * Send a line of text
         */
        public void send(String text) {
            try {
                outputStream.write((text + CRLF).getBytes());
                outputStream.flush();
            } catch (IOException ex) {
                notifyObservers(ex);
            }
        }

        /**
         * Close the socket
         */
        public void close() {
            try {
                socket.close();
            } catch (IOException ex) {
                notifyObservers(ex);
            }
        }

    }

    /**
     * Chat client UI
     */
    @SuppressWarnings("serial")
	static class ChatFrame extends JFrame implements Observer {

        private JTextArea textArea;
        private JTextField inputTextField;
        private JButton sendButton;
        private ChatAccess chatAccess;

        public ChatFrame(ChatAccess chatAccess) {
            this.chatAccess = chatAccess;
            chatAccess.addObserver(this);
            buildGUI();
        }

        /* Builds the user interface */

        private void buildGUI() {
            textArea = new JTextArea(20, 50);
            textArea.setEditable(false);
            textArea.setLineWrap(true);
            add(new JScrollPane(textArea), BorderLayout.CENTER);

            Box box = Box.createHorizontalBox();
            add(box, BorderLayout.SOUTH);
            inputTextField = new JTextField();
            sendButton = new JButton("Envoyé");
            box.add(inputTextField);
            box.add(sendButton);

            // Action for the inputTextField and the goButton
            ActionListener sendListener = new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    String str = inputTextField.getText();
                    if (str != null && str.trim().length() > 0)
                        chatAccess.send(str);
                    inputTextField.selectAll();
                    inputTextField.requestFocus();
                    inputTextField.setText("");
                }
            };
            inputTextField.addActionListener(sendListener);
            sendButton.addActionListener(sendListener);

            this.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    chatAccess.close();
                }
            });
        }

        /**
         * Updates the UI depending on the Object argument
         */
        public void update(Observable o, Object arg) {
            final Object finalArg = arg;
            SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    textArea.append(finalArg.toString());
                    textArea.append("\n");
                }
            });
        }
    }
    public static void TriEvents(){
    	Collections.sort(evenements, new EventComparator());
        Collections.reverse(evenements);
   }
    
    public static void TriVideos(){
 		Collections.sort(videos, new VideosComparator());
         Collections.reverse(videos);
    }
    public static void TriPlanning(){
 		Collections.sort(planning, new PlanningComparator());
        Collections.reverse(planning);
   }
    
    public static Integer Convert_Categ_Lvl(String categ){
    	int i = 0;
    	if (categ.contains("HUMOUR")){
    		i = player.getLvl_humour();
    	}if (categ.contains("ANIMATIONS/FILMS")){
    		i = player.getLvl_animations_films();
    	}if (categ.contains("DIVERTISSEMENT")){
    		i = player.getLvl_divertissement();
    	}if (categ.contains("MAKEUP/MODE")){
    		i = player.getLvl_makeup_mode();
    	}if (categ.contains("CUISINE")){
    		i = player.getLvl_cuisine();
    	}if (categ.contains("GAMING")){
    		i = player.getLvl_gaming();
    	}if (categ.contains("ANIMAUX")){
    		i = player.getLvl_animaux();
    	}if (categ.contains("MUSIQUE")){
    		i = player.getLvl_musique();
    	}if (categ.contains("SCIENCES")){
    		i = player.getLvl_sciences();
    	}if (categ.contains("SPORT")){
    		i = player.getLvl_sport();
    	}if (categ.contains("MONTAGE")){
    		i = player.getLvl_montage();
    	}if (categ.contains("ECRITURE")){
    		i = player.getLvl_ecriture();
    	}
    	
		return i;
    }
    
    public static long Convert_Categ_Exp(String categ){
    	long i = 0;
    	if (categ.contains("HUMOUR")){
    		i = player.getExp_humour();
    	}if (categ.contains("ANIMATIONS/FILMS")){
    		i = player.getExp_animations_films();
    	}if (categ.contains("DIVERTISSEMENT")){
    		i = player.getExp_divertissement();
    	}if (categ.contains("MAKEUP/MODE")){
    		i = player.getExp_makeup_mode();
    	}if (categ.contains("CUISINE")){
    		i = player.getExp_cuisine();
    	}if (categ.contains("GAMING")){
    		i = player.getExp_gaming();
    	}if (categ.contains("ANIMAUX")){
    		i = player.getExp_animaux();
    	}if (categ.contains("MUSIQUE")){
    		i = player.getExp_musique();
    	}if (categ.contains("SCIENCES")){
    		i = player.getExp_sciences();
    	}if (categ.contains("SPORT")){
    		i = player.getExp_sport();
    	}if (categ.contains("MONTAGE")){
    		i = player.getExp_montage();
    	}if (categ.contains("ECRITURE")){
    		i = player.getExp_ecriture();
    	}
    	
		return i;
    }
    
    public static Camera getCamera(long ID){
    	Camera cam = null;
    	for (int i = 0;i<cameras.size();i++){
    		if (ID==cameras.get(i).getID()){
    			cam=(Camera) cameras.get(i);
    		}
    	}
		return cam;
    }
    
    public static void FirstStart(){
    	if (first_choice=="HUMOUR"){
    		player.setLvl_humour(1);
    	}if (first_choice=="ANIMATIONS/FILMS"){
    		player.setLvl_animations_films(1);
    	}if (first_choice=="DIVERTISSEMENT"){
    		player.setLvl_divertissement(1);
    	}if (first_choice=="MAKEUP/MODE"){
    		player.setLvl_makeup_mode(1);
    	}if (first_choice=="CUISINE"){
    		player.setLvl_cuisine(1);
    	}if (first_choice=="GAMING"){
    		player.setLvl_gaming(1);
    	}if (first_choice=="ANIMAUX"){
    		player.setLvl_animaux(1);
    	}if (first_choice=="MUSIQUE"){
    		player.setLvl_musique(1);
    	}if (first_choice=="SCIENCES"){
    		player.setLvl_sciences(1);
    	}if (first_choice=="SPORT"){
    		player.setLvl_sport(1);
    	}if (first_choice=="MONTAGE"){
    		player.setLvl_montage(2);
    	}if (first_choice=="ECRITURE"){
    		player.setLvl_ecriture(1);
    	}
    }
    
    public static Integer getExpTotalCat(Integer lvl){
    	int i = (int) (50*Math.pow(1.5, lvl));
    	
    	return i;
    }
    
    public static String getStringTime(Integer i){
		String s = "";
		Integer one = Sc_Time/60;
		Integer two = Sc_Time%60;
		s=one+":"+ZERO(two);
		return s;
	}
	
	public static String ZERO(Integer i){
		String s = "";
		s=i>=10?i+"":"0"+i;
		return s;
	}

    
    public void resetSubsClicks(){
    	
    }
    
}