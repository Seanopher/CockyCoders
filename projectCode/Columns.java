package projectCode;
import java.util.ArrayList;
import java.util.HashMap;

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

    /**
     * 
     * @param columns
     * @param title
     * @return
     */
    public Columns removeColumn(Columns columns, String title){
        columns.column.remove(title);
        return columns;
    }

    /**
     * 
     * @param columns
     * @param title
     * @return
     */
    public Columns moveColumn(Columns columns, String title){
        String oldTitle = title;
        ArrayList<TaskList> taskList = columns.column.get(oldTitle);
        columns.column.remove(oldTitle);
        columns.column.put(title, taskList);
        return columns;
    }
    
}
