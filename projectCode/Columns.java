package projectCode;
import java.util.ArrayList;

/**
 * @author EmmaLee Peyton
 * it allows for the creation and removal of columns
 */
public class Columns {

    private ArrayList<Task> column;
    private String title;
    private ArrayList<String> titles;

    /**
     * this is the parameter constructor method
     * it takes in title for the arraylist that it wants
     * @param title the parameter
     */
    public Columns(String title) {
        this.column = new ArrayList<>();
        this.title = title;
        this.titles = new ArrayList<>();
    }

    /**
     * it checks to see if the column exists
     * if it exists it adds a number to the back of it
     * 
     * adds the new title to the array list of titles
     * 
     * @param title takes in user input and tests it
     * @return the instance of this
     */
    public Columns createColumn(String title){
        if(this.titles.contains(title)){
            int i = 1;
            while(this.title.contains(title))
                i++;
            title = title + "(" + i + ")";
        }
        this.titles.add(title);

        return this;
    }

    /**
     * finds the location of the column by its title name
     * deletes the column
     * @param title taken in from user to see if it exists then deletes it
     * @return the instance of this
     */
    public Columns removeColumn(String title){
        int loc = this.titles.indexOf(title);
        this.titles.remove(loc);

        return this;
    }

}
