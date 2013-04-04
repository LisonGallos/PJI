import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.sql.Timestamp;
import java.util.Date;


public class DiffuseurMessage {

	public static void main (String[] argv) throws NumberFormatException, UnsupportedEncodingException {
		try {
			SiteItf noeud = (SiteItf)Naming.lookup(argv[0]);
			//message, idENvoyeur

			//SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");
			Date d = new Date();
			//Date parsedDate = dateFormat.parse(d.getDay()+"-"+d.getMonth()+"-"+d.getDate()+" "+d.getHours()+":"+d.getMinutes()+":"+d.getSeconds());
			noeud.propager(argv[1].getBytes(), Integer.parseInt(argv[0]), new Timestamp(d.getTime()));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
	}
	
}
