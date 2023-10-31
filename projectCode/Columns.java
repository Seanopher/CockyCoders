package projectCode;
import java.util.ArrayList;

/**
 * @author EmmaLee Peyton
 * this class encases columns using a hashmap
 * it allows for the creation, removal, and the ability to move columns
 */
public class Columns {

    public ArrayList<Task> column;
    public String title;
    public ArrayList<String> titles;

    public Columns createColumn(Columns column, String title){
        // checks to see if the title exists
        // if exists, adds "(num)"
        // if "title + "(num)" exists title = "title" + "(num + 1)"

        if(titles.contains(title)){
            while(title.contains(title)){
                int i = 1;
                title
            }
        }

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
