package projectCode;
import java.sql.Array;
import java.util.ArrayList;

/**
 * @author EmmaLee Peyton
 * this class encases columns using a hashmap
 * it allows for the creation, removal, and the ability to move columns
 */
public class Columns {

    private ArrayList<Task> column;
    private String title;
    private ArrayList<String> titles;

    public Columns(String title) {
        this.column = new ArrayList<>();
        this.title = title;
        this.titles = new ArrayList<>();
    }

    public Columns createColumn(Columns column, String title){
        // checks to see if the title exists
        // if exists, adds "(num)"
        // if "title + "(num)" exists title = "title" + "(num + 1)"

        if(titles.contains(title)){
            int i = 1;
            while(title.contains(title))
                i++;
            title = title + "(" + i + ")";
        }
        // creates new column named title and adds title to the titles arraylist
        Columns newColumn = new Columns(title);

        // adds column to columns list
        titles.add(title);

        return column;
    }

    public Columns removeColumn(Columns column, String title){
        // finds the title and deletes the column
        return column;
    }

    public Columns moveColumn(Columns column, String title){
        
        return column;
    }
    
}
