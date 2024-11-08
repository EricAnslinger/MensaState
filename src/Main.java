import connector.Connector;
import window.Window;

public class Main {
    public static void main(String[] args) {
        try{
            Window mensaState = new Window(1000, 1000); //Erzeuge Window Objekt
            String menuText = Connector.connect("https://www.studentenwerk-oberfranken.de/essen/speiseplaene/coburg/hauptmensa.html");

            mensaState.updateMenuDisplay(menuText);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}