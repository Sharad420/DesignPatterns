import java.util.AbstractList;
import java.util.List;

// Create custom list by extending abstract list.
public class MyStringList extends AbstractList<String>{
    private String[] myList;
    MyStringList(String[] strings) {
        this.myList = strings;
    }

    // These are the primitive operations which are part of the subList algorithm.
    public String get(int index) {
        return myList[index];
    }

    public int size() {
        return myList.length;
    }

    public String set(int index, String item) {
        String oldString = myList[index];
        myList[index] = item;
        return oldString;
    }

    public static void main(String[] args) {
        String[] ducks = { "Mallard Duck", "Redhead Duck", "Rubber Duck", "Decoy Duck"};
        MyStringList ducksList = new MyStringList(ducks);
        // Uses the sublist method from abstractList, calls upon the implementations of get and size in MyStringList.
        List ducksSubList = ducksList.subList(2, 3);
        System.out.println(ducksSubList);
    }
}
