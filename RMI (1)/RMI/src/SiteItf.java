import java.io.UnsupportedEncodingException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.Timestamp;


public interface SiteItf extends Remote{
	
	//public void addFils(SiteItf fils) throws RemoteException;
	
	public void addVoisin(SiteItf voisin) throws RemoteException;
	
	public void propager(byte[] message, int idEnvoyeur, Timestamp ts) throws RemoteException, UnsupportedEncodingException;
	
	public int getId() throws RemoteException;

}
