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
	public static Player player = /* Ceci est UNIQUEMENT des valeurs de test. Toutes les valeurs seront envoyés par le serveur. */ 
			new PlayerC("Malimoi",1000,100,100,1,100,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0);
	
	public static Long MAX_UUID_PLANNING;
	
	/*
	 * ICI : PRESENT QUE DANS LES VERSIONS TEST POUR NE PAS PASSER PAS LE LAUCHER / SERVER
	 */
	public static Boolean IsTest = true;
	
	public static List<Video> videos = new ArrayList<Video>();
	public static List<Accessoire> access = new ArrayList<Accessoire>();
	public static List<Planning> planning = new ArrayList<Planning>();
	public static List<Evenement> evenements = new ArrayList<Evenement>();
	public static List<String> datavi = new ArrayList<String>();
	public static List<String> datapl = new ArrayList<String>();
	public static List<String> dataev = new ArrayList<String>();
    public static JFrame frame;

    public static void main(String[] args) {
    	try {
			UIManager.setLookAndFeel(new SyntheticaPlainLookAndFeel());
		} catch (Exception e) {
			e.printStackTrace();
		} 
    	if (!IsTest){
    		String server = "127.0.0.1";
            int port = 2009;
            ChatAccess access = null;
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
    	access.add(new Camera("Canan 600D", 400, new CameraPerformance(50), "ACCESSOIRES/1", 1));
 		
 		/*
 		 * On récupère les vidéos
 		 * format : new Videos(name[0],day[1],month[2],year[3],views[4],likes[5],dislikes[6],share[7],...)
 		 */
 		videos.add(new Video("JE MANGE DES CHIPS !", 28, 07, 15, 651L, 122L, 6L, 0L, "HUMOUR", 0, 0, 0, 0, 0, 0, 0, 0, 1L));
 		videos.add(new Video("JE M'APPELLE BYSLIDE", 27, 07, 15, 1254L, 215L, 3L, 3L, "GAMING", 0, 0, 0, 0, 0, 0, 0, 0, 2L));
 		videos.add(new Video("LE BYSLIDE CONTRE ATTAQUE", 29, 07, 15, 15254L, 2155L, 28L, 3L, "GAMING", 0, 0, 0, 0, 0, 0, 0, 0, 3L));
 		videos.add(new Video("5 CHOSES EXTRAORDINAIRES", 30, 07, 15, 2782L, 568L, 8L, 3L, "SCIENCES",0, 0, 0, 0, 0, 0, 0, 0, 4L));
 		videos.add(new Video("VLOG #1 : LA MONTAGNE", 1, 8, 15, 0L, 0L, 0L, 0L, "VLOG", 0, 0, 0, 0, 0, 0, 0, 0, 5L));
 		videos.add(new Video("LE RETOUR DU BYSLIDE", 3, 8, 15, 0L, 0L, 0L, 0L, "GAMING", 0, 0, 0, 0, 0, 0, 0, 0, 6L));
 		videos.add(new Video("EPICARRÉ : PVP SWAG", 5, 8, 15, 0L, 0L, 0L, 0L, "GAMING", 0, 0, 0, 0, 0, 0, 0, 0, 7L));
 		videos.add(new Video("MON SETUP DE FOU 123", 8, 8, 15, 651L, 122L, 6L, 0L, "DIVERTISSEMENT", 0, 0, 0, 0, 0, 0, 0, 0, 8L));
 		Collections.sort(videos, new VideosComparator());
         Collections.reverse(videos);
         videos.add(new Video(null, -1, -1, -1, 0L, 0L, 0L, 0L, null, 0, 0, 0, 0, 0, 0, 0, 0, 0L));
         
 		/*
 		 * Evenements
 		 */
         evenements.add(new Evenement(31, 7, 15, 5, 0L));
         evenements.add(new Evenement(0, 0, 0, null, 0L));

         Collections.sort(evenements, new EventComparator());
         Collections.reverse(evenements);

 		/*
 		 * Planning
 		 */
         planning.add(new Planning(21, 22, 13, 8, 15, 4, 8L, 1L));
         planning.add(new Planning(16, 18, 14, 8, 15, 4, 5L, 2L));
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

         new Fenetre();
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
    static class ChatAccess extends Observable {
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
                        while ((line = in.readLine()) != null)
                            if (!line.contains("connecte")) {
                                notifyObservers(line);
                            } else {
                            	setJFrames();
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
    
    public static void TriVideos(){
 		Collections.sort(videos, new VideosComparator());
         Collections.reverse(videos);
    }
    
}