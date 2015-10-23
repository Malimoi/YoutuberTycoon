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

import org.jnativehook.GlobalScreen;

import player.Player;
import player.PlayerC;
import accessoires.Accessoire;
import accessoires.Camera;
import accessoires.CameraPerformance;
import accessoires.Micro;
import accessoires.MicroPerformance;
import accessoires.OrdiPerformance;
import accessoires.Ordinateur;
import de.javasoft.plaf.synthetica.SyntheticaPlainLookAndFeel;
import utilities.Evenement;
import utilities.EventComparator;
import utilities.Planning;
import utilities.PlanningComparator;
import utilities.Video;
import utilities.VideosComparator;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.List;

public class MainClient {

	/*
	 * Client propieties
	 */
	public static Boolean first_conn = true;
	public static String first_choice = "";
	public static Player player; /* Ceci est UNIQUEMENT des valeurs de test. Toutes les valeurs seront envoyés par le serveur.
			new PlayerC("Malimoi",null,16146,53120,21244,72.8,1,2335,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0);*/
	
	public static Long MAX_UUID_PLANNING;
	/*
	 * Mini-Game stats
	 */
	public static List<String> sc_scoreboard_pl = new ArrayList<String>();
	public static List<Integer> sc_scoreboard_subs = new ArrayList<Integer>();
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
	public static List<Accessoire> ordis = new ArrayList<Accessoire>();
	public static List<Accessoire> cameras = new ArrayList<Accessoire>();
	public static List<Accessoire> micros = new ArrayList<Accessoire>();
	public static List<Planning> planning = new ArrayList<Planning>();
	public static List<Evenement> evenements = new ArrayList<Evenement>();
	public static List<String> datavi = new ArrayList<String>();
	public static List<String> datapl = new ArrayList<String>();
	public static List<String> dataev = new ArrayList<String>();
	
	public static String[] categ_list = {"HUMOUR","DIVERTISSEMENT","GAMING","MONTAGE","DEVELOPPEMENT","MUSIQUE",
		"SCIENCES","EDUCATION","MAKEUP/MODE","CUISINE","ECRITURE","POST-PRODUCTION"};
	
	public static ChatAccess access;
	
    public static JFrame frame;

    public static void main(String[] args) {
    	sc_scoreboard_pl.add("AUCUN JOUEUR");
    	sc_scoreboard_pl.add("AUCUN JOUEUR");
    	sc_scoreboard_subs.add(0);
    	sc_scoreboard_subs.add(0);
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
            
            /*
        	 * Accessoires
        	 */
        	cameras.add(new Camera("Caméscope", 163, new CameraPerformance(15,5), "image/ACC/CAMESCOPE.png", 1, false));
        	cameras.add(new Camera("Yaton 600T", 429, new CameraPerformance(35,20), "image/ACC/YATON-600T.png", 2, false));
        	cameras.add(new Camera("Yaton 60T", 839, new CameraPerformance(55,35), "image/ACC/YATON-60T.png", 3, false));
        	cameras.add(new Camera("Yaton 6T", 1775, new CameraPerformance(75,40), "image/ACC/YATON-6T.png", 4, false));
        	ordis.add(new Ordinateur("MASIS X050 - Black version", 219, new OrdiPerformance(15, 15, 15), "image/ACC/MASIS-X050-BLACK.png", 1, true));
        	ordis.add(new Ordinateur("MASIS X200 - White version", 439, new OrdiPerformance(30, 25, 20), "image/ACC/MASIS-X200-WHITE.png", 2, false));
        	ordis.add(new Ordinateur("ALIAN-WHERE Z150 - Black version", 659, new OrdiPerformance(65, 50, 0), "image/ACC/ALIAN-WHERE-Z150-BLACK.png", 3, false));
        	micros.add(new Micro("Micro-Casque M2-A", 109, new MicroPerformance(35), "image/ACC/MIRCO-CASQUE-Z2-A.png", 1, false));
        	micros.add(new Micro("Red Yuti - Black version", 142, new MicroPerformance(65), "image/ACC/RED-YUTI-BLACK.png", 2, false));
    	}else{
    		setJFrames();
    	}
    }
    public static void setJFrames(){
     	 /*
          * Ceci sont des valeurs fictives. Il faudra seulement get toutes les horraires sur le server.
 		 */
    	
    	
 		/*
 		 * On récupère les vidéos
 		 * format : new Videos(name[0],day[1],month[2],year[3],views[4],likes[5],dislikes[6],share[7],...)
 		 */

 		//Collections.sort(videos, new VideosComparator());
         //Collections.reverse(videos);
         videos.add(new Video(null, null, -1, -1, -1,"", 0L, 0L, 0L, null,false, 0, null, null, null, null, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0L, 0L));
         
 		/*
 		 * Evenements
 		 */
         evenements.add(new Evenement(0, 0, 0, null, 0L));

         Collections.sort(evenements, new EventComparator());
         Collections.reverse(evenements);

 		/*
 		 * Planning
 		 */
         //planning.add(new Planning(18, 19, 23, 8, 15, 3, 9L, 1L));
         //planning.add(new Planning(16, 17, 24, 8, 15, 4, 9L, 2L));
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
         
         if (first_conn){
        	 new ThemeSelector();
         }
         else {
        	 new Fenetre();
         }
         
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
                        			if (!player.getTheme().equals("not")){
                        				first_conn=false;
                        			}
                                	setJFrames();                               
                                }else if (line.contains("sc")) {
                                	if (line.split(" ")[1].contains("time")){
                                		Sc_Time=Integer.valueOf(line.split(" ")[2]);
                                	}else if (line.split(" ")[1].contains("status")){
                                		if(line.split(" ")[2].contains("game")){
                                			Sc_Status="Fin dans";
                                		}else{
                                			Sc_Status="Début dans";
                                		}
                                	}else if (line.split(" ")[1].contains("cl")){
                                		String name1 = line.split(" ")[2].split(":")[0];
                                		Integer sc1 = Integer.valueOf(line.split(" ")[2].split(":")[1]);
                                		String name2 = line.split(" ")[3].split(":")[0];
                                		Integer sc2;
                                		try{
                                			sc2 = Integer.valueOf(line.split(" ")[3].split(":")[1]);
                                		}catch (Exception e){
                                			sc2 = 0;
                                		}
                                		sc_scoreboard_pl.clear();
                                		sc_scoreboard_subs.clear();
                                		sc_scoreboard_pl.add(name1);
                                		sc_scoreboard_pl.add(name2);
                                		sc_scoreboard_subs.add(sc1);
                                		sc_scoreboard_subs.add(sc2);
                                		try {
											Thread.sleep(50);
										} catch (InterruptedException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}
                                	}else{
                                		Total_Clicks_Subs=Double.valueOf(line.split(" ")[1]);  
                                    	int tot = (int) Total_Clicks_Subs;
                                    	Fenetre.tot_clicks_subs.setText(tot+"");
                                	}                        	
                                		                       	
                                }else if (line.contains("infop")){
                                	String[] infos = line.split(" ");
                                	player = new PlayerC(infos[1], infos[2], Long.valueOf(infos[3]), Long.valueOf(infos[4]), Long.valueOf(infos[5]),
                                			Double.valueOf(infos[6]), Integer.valueOf(infos[7]), Integer.valueOf(infos[8]), Integer.valueOf(infos[9]),
                                			Integer.valueOf(infos[10]), Integer.valueOf(infos[11]), Integer.valueOf(infos[12]), Integer.valueOf(infos[13]),
                                			Integer.valueOf(infos[14]), Integer.valueOf(infos[15]), Integer.valueOf(infos[16]), Integer.valueOf(infos[17]),
                                			Integer.valueOf(infos[18]), Integer.valueOf(infos[19]), Integer.valueOf(infos[20]), Integer.valueOf(infos[21]),
                                			Integer.valueOf(infos[22]), Integer.valueOf(infos[23]), Integer.valueOf(infos[24]), Integer.valueOf(infos[25]),
                                			Integer.valueOf(infos[26]), Integer.valueOf(infos[27]), Integer.valueOf(infos[28]), Integer.valueOf(infos[29]),
                                			Integer.valueOf(infos[30]), Integer.valueOf(infos[31]), Integer.valueOf(infos[32]));
                                }else if (line.contains("infov")){
                                	String[] infos = line.split("`");
                                	Camera cam = null;
                                	if (!infos[13].equals("null")){
                                		cam = getCamera(Integer.valueOf(infos[13]));
                                	}
                                	Micro mic = null;
                                	if (!infos[14].equals("null")){
                                		mic = getMicro(Integer.valueOf(infos[14]));
                                	}
                                	Ordinateur ord_g = null;
                                	if (!infos[15].equals("null")){
                                		ord_g = getOrdi(Integer.valueOf(infos[15]));
                                	}
                                	Ordinateur ord_m = null;
                                	if (!infos[16].equals("null")){
                                		ord_m = getOrdi(Integer.valueOf(infos[16]));
                                	}
                                	videos.add(new Video(infos[1], infos[2], Integer.valueOf(infos[3]), Integer.valueOf(infos[4]), Integer.valueOf(infos[5]),
                                			infos[6], Long.valueOf(infos[7]), Long.valueOf(infos[8]), Long.valueOf(infos[9]), infos[10], Boolean.valueOf(infos[11]),
                                			Integer.valueOf(infos[12]), cam, mic, ord_g, ord_m, Integer.valueOf(infos[17]), Integer.valueOf(infos[18]),
                                			Integer.valueOf(infos[19]), Integer.valueOf(infos[20]), Integer.valueOf(infos[21]), Integer.valueOf(infos[22]),
                                			Integer.valueOf(infos[23]), Integer.valueOf(infos[24]), Integer.valueOf(infos[25]), Integer.valueOf(infos[26]),
                                			Integer.valueOf(infos[27]), Integer.valueOf(infos[28]), Long.valueOf(infos[29]), Long.valueOf(infos[30])));
                                	
                                	MainClient.TriVideos();
                                }else if (line.contains("infoa")){
                                	String[] infos = line.split(" ");
                                	planning.add(new Planning(Integer.valueOf(infos[1]), Integer.valueOf(infos[2]), Integer.valueOf(infos[3]),
                                			Integer.valueOf(infos[4]), Integer.valueOf(infos[5]), Integer.valueOf(infos[6]), Long.valueOf(infos[7]),
                                			Long.valueOf(infos[8])));
                                	TriPlanning();
                                }else if (line.contains("infoe")){
                                	String[] infos = line.split(" ");
                                	evenements.add(new Evenement(Integer.valueOf(infos[1]), Integer.valueOf(infos[2]), Integer.valueOf(infos[3]),
                                			Integer.valueOf(infos[4]), Long.valueOf(infos[5])));
                                	TriEvents();
                                }else if (line.contains("infob")){
                                	String[] infos = line.split(" ");
                                	if (infos[1].equals("camera")){
                                		getCamera(Integer.valueOf(infos[2])).setBuy(true);
                                	}else if (infos[1].equals("micro")){
                                		getMicro(Integer.valueOf(infos[2])).setBuy(true);
                                	}else if (infos[1].equals("ordinateur")){
                                		getOrdi(Integer.valueOf(infos[2])).setBuy(true);
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
    	}if (categ.contains("ANIMATIONS_FILMS")){
    		i = player.getLvl_animations_films();
    	}if (categ.contains("DIVERTISSEMENT")){
    		i = player.getLvl_divertissement();
    	}if (categ.contains("MAKEUP/MODE")){
    		i = player.getLvl_makeup_mode();
    	}if (categ.contains("MAKEUP_MODE")){
    		i = player.getLvl_makeup_mode();
    	}if (categ.contains("CUISINE")){
    		i = player.getLvl_cuisine();
    	}if (categ.contains("GAMING")){
    		i = player.getLvl_gaming();
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
    	}if (categ.contains("POST-PRODUCTION")){
    		i = player.getExp_ecriture();
    	}
    	
		return i;
    }
    
    public static Camera getCamera(Integer ID){
    	Camera cam = null;
    	for (int i = 0;i<cameras.size();i++){
    		if (ID==cameras.get(i).getID()){
    			cam=(Camera) cameras.get(i);
    		}
    	}
		return cam;
    }
    
    public static Ordinateur getOrdi(Integer ID){
    	Ordinateur cam = null;
    	for (int i = 0;i<ordis.size();i++){
    		if (ID==ordis.get(i).getID()){
    			cam=(Ordinateur) ordis.get(i);
    		}
    	}
		return cam;
    }
    
    public static Micro getMicro(Integer ID){
    	Micro cam = null;
    	for (int i = 0;i<micros.size();i++){
    		if (ID==micros.get(i).getID()){
    			cam=(Micro) micros.get(i);
    		}
    	}
		return cam;
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
	
	public static Video getVideoWithID(Long long1){
		Video v = null;
		for (int i = 0;i<videos.size();i++){
			if (videos.get(i).getID().equals(long1)){
				v=videos.get(i);
				break;
			}			
		}
		
		return v;	
	}

    public static String getLongueur(Integer i){
    	String s = "";
    	if (i==1){
    		s="<b>Mini</b>";
    	}else if (i==2){
    		s="<b>Très courte</b>";
    	}else if (i==3){
    		s="<b>Courte</b>";
    	}else if (i==4){
    		s="<b>Moyenne</b>";
    	}else if (i==5){
    		s="<b>Longue</b>";
    	}else if (i==6){
    		s="<b>Très longue</b>";
    	}else if (i==7){
    		s="<b>Énorme</b>";
    	}
    	
    	return s;
    }
	
    public void resetSubsClicks(){
    	
    }
    
}