package Es6;

import dbhelper.DbHelper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Model
{
    public Model(){
        queryResult = new ArrayList<>();
        log = new HashMap<>();
        DbHelper dbh = new DbHelper(); //Creare un database

    }

    //MEMORIZZAZIONE DELLE QUERY:
    DbHelper dbh;
    List<String> queryResult;
    HashMap<String, List<String>> log;

    //Metodo che fa la query: //Lo metto direttamente nella query

    //AGGIUNGIAMO la query
    public void addQuery(String newQuery) throws SQLException {
        ResultSet temp = null;
        temp = dbh.executeSelect(newQuery);
        while(temp.next()){
            queryResult.add(temp.getString(1));
        }
        log.put(newQuery, queryResult);

    }




}
