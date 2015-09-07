package frames.buttons.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Main.Fenetre;
import Main.MainClient;

public class SubsClicksUpgradeEvent implements ActionListener{
	
	private Integer i;
	
	public SubsClicksUpgradeEvent(Integer i){
		this.i=i;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {	
		if (i.equals(0) && MainClient.Total_Clicks_Subs>(int)(15*Math.pow(1.2, MainClient.sc_upgrade_1))){
			MainClient.sc_upgrade_1++;
			MainClient.access.send(MainClient.player.getPseudo()+" password sc buy 1");
			Fenetre.pri_lab.setText("Prix : "+(int)(15*Math.pow(1.2, MainClient.sc_upgrade_1))+" subs.");
			MainClient.Subs_By_Secs = MainClient.Subs_By_Secs+0.1;
		}if (i.equals(1)&& MainClient.Total_Clicks_Subs>(int)(100*Math.pow(1.2, MainClient.sc_upgrade_2))){
			MainClient.sc_upgrade_2++;
			MainClient.access.send(MainClient.player.getPseudo()+" password sc buy 2");
			Fenetre.pri_lab2.setText("Prix : "+(int)(100*Math.pow(1.2, MainClient.sc_upgrade_2))+" subs.");
			MainClient.Subs_By_Secs = MainClient.Subs_By_Secs+1.0;
		}if (i.equals(2)&& MainClient.Total_Clicks_Subs>(int)(500*Math.pow(1.2, MainClient.sc_upgrade_3))){
			MainClient.sc_upgrade_3++;
			MainClient.access.send(MainClient.player.getPseudo()+" password sc buy 3");
			Fenetre.pri_lab3.setText("Prix : "+(int)(500*Math.pow(1.2, MainClient.sc_upgrade_3))+" subs.");
			MainClient.Subs_By_Secs = MainClient.Subs_By_Secs+10.0;
		}if (i.equals(3)&& MainClient.Total_Clicks_Subs>(int)(2000*Math.pow(1.2, MainClient.sc_upgrade_4))){
			MainClient.sc_upgrade_4++;
			MainClient.access.send(MainClient.player.getPseudo()+" password sc buy 4");
			Fenetre.pri_lab4.setText("Prix : "+(int)(2000*Math.pow(1.2, MainClient.sc_upgrade_4))+" subs.");
			MainClient.Subs_By_Secs = MainClient.Subs_By_Secs+100.0;
		}
		Fenetre.subs_by_sec.setText(MainClient.Subs_By_Secs+" subs/sec");
	}
}
