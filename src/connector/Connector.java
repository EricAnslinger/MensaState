package connector;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class Connector {
    private String link;
    public Connector(String link){
        this.link = link;

    }

    public static String connect(String s){
        StringBuilder menuText = new StringBuilder();
        try{
            Document doc = Jsoup.connect(s).get(); //Jsoup verbinden mit Webseite
            Elements tables = doc.select("table.tx-bwrkspeiseplan__table-meals.table-bordered.table-striped"); // Wähle table
            for (Element tr : tables) { // Durchlaufe <tr>
                Elements tdElement = tr.select("td:not(.textRight)"); // wähle td element
                for (Element selecttd : tdElement) { //selektiere <td> Element
                    String text = selecttd.text();
                    String[] unwantedPhrases = {   //Wörter die ausgeblendet werden sollen
                            "x", "Rate", "Give Feedback", "Dish", "Date", "Canteen", "Meal", "E-Mail",
                            "I'll be back", "Yes", "No", "Maybe", "Comment", "Quality",
                            "Portion size", "price-performance", "Rate Canteen", "Staff",
                            "Offer / Selection", "Rate Dish", " ×"
                    };
                    for (String phrase : unwantedPhrases) {
                        if (text.contains(phrase)) {
                            text = text.replace(phrase, "").trim(); //Schneide die unnötigen Wörter heraus
                        }
                    }
                    int index = text.indexOf('(');  //Bekomme den Index der Zusatzstoffe
                    if (index != -1) { // Wenn Zusatzstoffe gegeben sind blende diese aus
                       text = text.substring(0, index).trim(); //Füge den String zum Strinbuilder hinzu
                        //System.out.println(text.substring(0, index).trim());
                        menuText.append(text).append('\n');

                    } else {
                        // Wenn keine Zusastzangaben vorhanden sind Text denm Strinbuilder hinzufügen
                        text =text.trim();
                        //System.out.println(text.trim());
                        menuText.append(text).append('\n');

                    }
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return menuText.toString(); // return Text
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
