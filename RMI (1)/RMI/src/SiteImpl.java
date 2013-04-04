import java.io.UnsupportedEncodingException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Timestamp;
import java.util.ArrayList;


@SuppressWarnings("serial")
public class SiteImpl extends UnicastRemoteObject implements SiteItf {

	//private SiteItf pere;
	//private ArrayList<SiteItf>  fils;
	private ArrayList<SiteItf>  voisins;
	private int id;
	//private byte[] message;
	private ArrayList<Timestamp> tsTab;

	/*public SiteImpl(int id, SiteItf pere) throws RemoteException {
		super();
		this.id = id;
		this.pere = pere;
		this.fils = new ArrayList<SiteItf>();
		this.tsTab = new ArrayList<Timestamp>();

	}*/
	
	public SiteImpl(int id) throws RemoteException {
		super();
		this.id = id;
		this.voisins = new ArrayList<SiteItf>();
		this.tsTab = new ArrayList<Timestamp>();

	}


	/*public void addFils(SiteItf fils) throws RemoteException{
		System.out.println("le noued n°"+id+" ajoute le fils n°"+fils.getId());
		this.fils.add(fils);
	}*/
	
	public void addVoisin(SiteItf voisin) throws RemoteException{
		if(!voisins.contains(voisin)){
			System.out.println("le noued n°"+id+" ajoute le fils n°"+voisin.getId());
			this.voisins.add(voisin);
		}
	}

	public int getId() throws RemoteException{
		return this.id;
	}

	/*public void setMessage(byte[] message){
		this.message = message;
	}*/

	/*public void propager(byte[] message, int idEnvoyeur, Timestamp ts) throws RemoteException, UnsupportedEncodingException{
		if(!tsTab.contains(ts)){
			tsTab.add(ts);
			String t = new String(message, "Cp1252");
			//this.message = message;
			String mess = "";
			String enfants = "";
			String envoye = "\n" + "J'envoie le message a mes fils n°";
			mess += "Le message " + t + " est envoye par "+idEnvoyeur+". Je suis le noeud n°"+id+"\n";
			if(pere != null && idEnvoyeur != pere.getId()){
				mess += ", Mon pere est le noeud n°"+ pere.getId()+" et je lui envoie le message. Mes enfants sont : \n";
				pere.propager(message, this.id, ts);
			}else if(pere != null)
				mess += ", mon pere est le noeud n°"+pere.getId()+". Mes enfants sont : \n";
			else
				mess += ", je n'est pas de pere. Mes enfants sont : \n";
			for(SiteItf enfant : this.fils){
				enfants += enfant.getId()+", ";
				if(enfant.getId() != idEnvoyeur){
					envoye += enfant.getId()+", ";
					enfant.propager(message, this.id, ts);
				}
			}
			System.out.println(mess+" "+enfants+" "+envoye);
		}
	}*/

	public void propager(byte[] message, int idEnvoyeur, Timestamp ts) throws RemoteException, UnsupportedEncodingException{
		if(!tsTab.contains(ts)){
			String t = new String(message, "Cp1252");
			String mess;
			if(idEnvoyeur == this.getId()){
				mess = "Je suis le noeud "+this.getId()+".\nJ'envoie le message a : ";
			}else{
				mess = "Je suis le noeud "+this.getId()+".\nJ'ai recu \""+t+"\" de "+idEnvoyeur+".\nJe l'envoie a : ";
			}
			tsTab.add(ts);
			

			for(SiteItf voisin : this.voisins){
				if(voisin.getId() != idEnvoyeur){
					mess+=voisin.getId()+", ";
					voisin.propager(message, this.id, ts);
				}
			}
			System.out.println(mess);
			
		}
	}

}
