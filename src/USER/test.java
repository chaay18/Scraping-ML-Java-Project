package USER;

import DAO.Emploi;
import EXTRACT.scraper;
import LOAD.loader;
import org.jsoup.nodes.Document;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class test {
    public static void main(String[] args) throws SQLException {
        loader load = new loader();
        Connection con = load.connection();
        ArrayList<Emploi> emplois = new ArrayList<>();
        Document doc = null;
        scraper sc = new scraper();
        emplois=sc.scrape(doc);
        for (int i = 0; i < emplois.size(); i++){
            load.insertion(con, emplois.get(i));
        }
        load.selection(con);
    }
}
