package projectCode;
import java.util.ArrayList;
<<<<<<< HEAD
public class Columns {
    public ArrayList<Task> column;
    public String title;
    public ArrayList<String> titles;
=======
import java.util.HashMap;
>>>>>>> peyton

/**
 * @author EmmaLee Peyton
 * this class encases columns using a hashmap
 * it allows for the creation, removal, and the ability to move columns
 */
public class Columns {

    private HashMap<String, ArrayList<TaskList>> column = new HashMap<String, ArrayList<TaskList>>();

    /**
     * 
     * @param columns
     * @param title
     * @return
     * 
     */
    public Columns createColumn(Columns columns, String title){
        if (columns.column.containsKey(title)){
            int i = 1;
            while (columns.column.containsKey(title + "(" + i + ")"))
                i++;
        }
        ArrayList<TaskList> taskList = new ArrayList<>();
        columns.column.put(title, taskList);
        return columns;
    }
    public Columns removeColumn(Columns column, String title){
        return column;
    }
}
