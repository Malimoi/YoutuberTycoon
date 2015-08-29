package frames.buttons.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Main.MainClient;

public class SubsClicksUpgradeEvent implements ActionListener{
	
	private Integer i;
	
	public SubsClicksUpgradeEvent(Integer i){
		this.i=i;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (i.equals(0)){
			MainClient.sc_upgrade_1++;
			MainClient.access.send("Malimoi password sc buy 1");
		}if (i.equals(1)){
			MainClient.sc_upgrade_2++;
			MainClient.access.send("Malimoi password sc buy 2");
		}if (i.equals(2)){
			MainClient.sc_upgrade_3++;
			MainClient.access.send("Malimoi password sc buy 3");
		}if (i.equals(3)){
			MainClient.sc_upgrade_4++;
			MainClient.access.send("Malimoi password sc buy 4");
		}
	}
}
