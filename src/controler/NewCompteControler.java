package controler;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import Interface.ListeClientsForm;
import Interface.OuvrirClientForm;
import checking.CheckClientAdd;
import checking.CheckCompteAdd;
import db.DbCreateQueries;
import db.DbReadQueries;
import model.Client;
import sessionData.CurrentSessionData;

public class NewCompteControler {
	public static void onAddClientClick() {
		
		if (CheckCompteAdd.AreAllFieldOk()) {
			Compte compteToAdd = new Compte(
					"compte_0"+(DbReadQueries.dbReadAllCompte().size()+1),
					CurrentSessionData.getOpenAccountForm().getNom(),
					CurrentSessionData.getOpenAccountForm().getNumero(),
					//CurrentSessionData.getOpenAccountForm().getProprietaire_tutelle(),
					CurrentSessionData.getOpenAccountForm().getTaux_interet(),
					CurrentSessionData.getOpenAccountForm().getPlafond(),
					CurrentSessionData.getOpenAccountForm().getSolde(),
					CurrentSessionData.getOpenAccountForm().getFrais_transfert(),
					CurrentSessionData.getOpenAccountForm().getSolde_minimum_autorise()
					);
		
			
			DbCreateQueries.addCompteToDb(compteToAdd);
			CurrentSessionData.getOpenAccountForm().setVisible(false);
		
			CurrentSessionData.getOpenAccountForm().dispose();;
			ListeCompteForm newFrame = new ListeCompteForm();
			CurrentSessionData.setOpenAccountForm(newFrame);
			CurrentSessionData.getOpenAccountForm().setVisible(true);
		}
	}

	public static void onCancelClick() {
		// Close the current page
		CurrentSessionData.getOpenAccountForm().setVisible(false);
	}

	public static void onLeavingNomTextField() {
		// check if field is correct
		if(CheckCompteAdd.isNomFieldOk()) {
			CurrentSessionData.getOpenAccountForm().setNomErrorMsg(CheckCompteAdd.getProperlyFilledFieldMsg());
		} else {
			CurrentSessionData.getOpenAccountForm().setNomErrorMsg(CheckCompteAdd.generateNomProperErrorMsg());
		}
	}

	public static void onLeavingNumeroTextField() {
		if(CheckCompteAdd.isNumeroFieldOk()) {
			CurrentSessionData.getOpenAccountForm().setNumeroErrorMsg(CheckCompteAdd.getProperlyFilledFieldMsg());
		} else {
			CurrentSessionData.getOpenAccountForm().setNumeroErrorMsg(CheckCompteAdd.generateNumeroProperErrorMsg());
		}
	}

	/*public static void onLeavingProprietaire_tutelleTextField() {
		if(CheckCompteAdd.isProprietaire_tutelleFieldOk()) {
			CurrentSessionData.getOpenAccountForm().setProprietaire_tutelleErrorMsg(CheckCompteAdd.getProperlyFilledFieldMsg());
		} else {
			CurrentSessionData.getOpenAccountForm().setProprietaire_tutelleErrorMsg(CheckCompteAdd.generateProprietaire_tutelleFieldOkProperErrorMsg() );
		}
	}*/

	public static void onLeavingTaux_interetTextField() {
		if(CheckCompteAdd.isTaux_interetFieldOk()) {
			CurrentSessionData.getOpenAccountForm().setTaux_interetErrorMsg(CheckCompteAdd.getProperlyFilledFieldMsg());
		} else {
			CurrentSessionData.getOpenAccountForm().setTaux_interetErrorMsg(CheckCompteAdd.generateTauxInteretFieldOkProperErrorMsg() );
		}
	}

	public static void onLeavingPlafondTextField() {
		if(CheckCompteAdd.isPlafondFieldOk()) {
			CurrentSessionData.getOpenAccountForm().setPlafondErrorMsg(CheckCompteAdd.getProperlyFilledFieldMsg());
		} else {
			CurrentSessionData.getOpenAccountForm().setPlafondErrorMsg(CheckCompteAdd.generatePlafondFieldOkProperErrorMsg());
		}
	}
	
	public static void onLeavingSoldeTextField() {
		if(CheckCompteAdd.isSoldeFieldOk()) {
			CurrentSessionData.getOpenAccountForm().setSoldeErrorMsg(CheckCompteAdd.getProperlyFilledFieldMsg());
		} else {
			CurrentSessionData.getOpenAccountForm().setSoldeErrorMsg(CheckCompteAdd.generateSoldeProperErrorMsg());
		}
	}
	
	public static void onLeavingFrais_transfertTextField() {
		if(CheckCompteAdd.isFrais_transfertFieldOk()) {
			CurrentSessionData.getOpenAccountForm().setFrais_transfertErrorMsg(CheckCompteAdd.getProperlyFilledFieldMsg());
		} else {
			CurrentSessionData.getOpenAccountForm().setFrais_transfertErrorMsg(CheckCompteAdd.generateFrais_transfertProperErrorMsg());
		}
	}
	
	public static void onLeavingSolde_minimum_autoriseTextField() {
		if(CheckCompteAdd.isSolde_minimum_autoriseFieldOk()) {
			CurrentSessionData.getOpenAccountForm().setSolde_minimum_autoriseErrorMsg(CheckCompteAdd.getProperlyFilledFieldMsg());
		} else {
			CurrentSessionData.getOpenAccountForm().setSolde_minimum_autoriseErrorMsg(CheckCompteAdd.generateSolde_minimum_autoriseProperErrorMsg());
		}
	}
	
	public static void onAddingTextAnywhere() {
		if (CheckClientAdd.AreAllFieldOk()) {
			CurrentSessionData.getOpenAccountPage().enableAddClientBtn();
		}
	}
}