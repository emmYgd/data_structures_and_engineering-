package DataStruct;
import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.SynchronousQueue;

/**
 * The interface Data structures.
 */
public interface DataStructures {

    /**
     * My subject stack stack .
     *
     * @return the stack
     */
//Last In First Out (LIFO) data structure:
    default Stack <String> mySubjectStack(){
        Stack<String> mySubjectStack = new Stack<>();
        mySubjectStack.push("Mathematics");
        mySubjectStack.push("Physics");
        mySubjectStack.push("Computer Science");
        mySubjectStack.push("Further Mathematics");
        mySubjectStack.push("Engineering Mechanics");
        return mySubjectStack;
    }

    /**
     * My color queue queue .
     *
     * @return the queue
     */
//First In First Out Data Structure:
    default Queue <String> myColorQueue(){
        Queue<String> myColorQueue = new LinkedBlockingQueue<>();
        myColorQueue.add("Red");
        myColorQueue.add("Black");
        myColorQueue.add("Purple");
        myColorQueue.add("Blue");
        myColorQueue.add("Yellow");
        return myColorQueue;
    }

    /**
     * My fruit map map .
     *
     * @return the map
     */
    default Map <String, String> myFruitMap(){
        //instantiate:
        Map <String, String> myFruitMap = new HashMap<>();
        myFruitMap.put("firstFruit", "Banana");
        myFruitMap.put("secondFruit", "Orange");
        myFruitMap.put("thirdFruit", "Cucumber");
        myFruitMap.put("fourthFruit", "Pawpaw");
        myFruitMap.put("fifthFruit", "Berry");
        return myFruitMap;
    }

    /**
     * My mood list list .
     *
     * @return the list
     */
    default List <String> myMoodList(){
        //instantiate:
        List<String> myMoodList = new ArrayList<>();
        myMoodList.add(0, "Happy");
        myMoodList.add(1, "Sad");
        myMoodList.add(2, "Perturbed");
        myMoodList.add(3, "Angry");
        myMoodList.add(4, "Forgiving");
        return myMoodList;
    }

    /**
     * My fav tv shows array string [ ].
     *
     * @return the string [ ]
     */
    default  String [] myFavTVShowsArray(){
        String[] favTVshows = new String[5];
        favTVshows[0] = "Harry_Porter";
        favTVshows[1] = "Iron_Man";
        favTVshows[2] = "Captain_America";
        favTVshows[3] = "Lord_of_the_Rings";
        favTVshows[4] = "Thor";
        return favTVshows;
    }
}
