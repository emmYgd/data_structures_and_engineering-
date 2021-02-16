package DataStruct;
import static javax.swing.JOptionPane.*;
import java.util.Stack;
import java.util.Queue;
import java.util.Map;
import java.util.List;
import java.util.Observable;


/**
 * The type Being watched.
 */
public class BeingWatched extends Observable implements DataStructures {

    /**
     * The My subject stack.
     */
    Stack <String> mySubjectStack = this.mySubjectStack();
    /**
     * The My color queue.
     */
    Queue <String> myColorQueue = this.myColorQueue();
    /**
     * The My fruit map.
     */
    Map <String, String> myFruitMap = this.myFruitMap();
    /**
     * The My mood list.
     */
    List <String> myMoodList =  myMoodList();
    /**
     * The My fav tv shows array.
     */
    String [] myFavTVShowsArray = myFavTVShowsArray();

    private void RealTimeUpdate(Object dataState){
        setChanged();
        notifyObservers(dataState);
    }

    /**
     * Add to subject stack.
     *
     * @param Subject the subject
     */
    public void AddToSubjectStack(String Subject){
        //showMessageDialog(null, "A new subject is about to be inserted!", "INSERTION_PROCESS", INFORMATION_MESSAGE);
        mySubjectStack.push(Subject);
        //showMessageDialog(null, "Stack Updated Successfully", "UPDATE_SUCCESSFUL!", PLAIN_MESSAGE);

        //now notify relevant subscribers about the state change:
        RealTimeUpdate(mySubjectStack);
        //showMessageDialog(null, "Relevant Parameters Notified!", "APPROPRIATE SYSTEM NOTIFIED", INFORMATION_MESSAGE);
    }

    /**
     * Remove from subject stack.
     */
    public void RemoveFromSubjectStack(){
        //showMessageDialog(null, "A new subject is about to be removed!", "DELETION_PROCESS", INFORMATION_MESSAGE);
        mySubjectStack.pop();
        //showMessageDialog(null, "Information Removed in LIFO style", "DELETION_SUCCESSFUL!", PLAIN_MESSAGE);

        //now notify relevant subscribers about the state change:
        RealTimeUpdate(mySubjectStack);
        //showMessageDialog(null, "Relevant Parameters Notified!", "APPROPRIATE SYSTEM NOTIFIED", INFORMATION_MESSAGE);
    }


    /**
     * Add to color queue.
     *
     * @param Color the color
     */
    public void AddToColorQueue(String Color){
        try {
            //showMessageDialog(null, "A new Color is about to be inserted!", "INSERTION_PROCESS", INFORMATION_MESSAGE);
            myColorQueue.add(Color);
            //showMessageDialog(null, "Queue Updated Successfully", "UPDATE_SUCCESSFUL!", PLAIN_MESSAGE);
        }catch(Exception ex){
            ex.printStackTrace();
        }

        //now notify relevant subscribers about the state change:
        RealTimeUpdate(myColorQueue);
        //showMessageDialog(null, "Relevant Parameters Notified!", "APPROPRIATE SYSTEM NOTIFIED", INFORMATION_MESSAGE);
    }

    /**
     * Remove from color queue.
     */
    public void RemoveFromColorQueue(){
        //showMessageDialog(null, "A new subject is about to be removed!", "DELETION_PROCESS", INFORMATION_MESSAGE);
        try {
            myColorQueue.remove();
            //showMessageDialog(null, "Information Removed in FIFO style", "DELETION_SUCCESSFUL!", PLAIN_MESSAGE);
        }catch(Exception ex){
            ex.printStackTrace();
            System.out.println("Error in Deletion Process");
        }

        //now notify relevant subscribers about the state change:
        RealTimeUpdate(myColorQueue);
        //showMessageDialog(null, "Relevant Parameters Notified!", "APPROPRIATE SYSTEM NOTIFIED", INFORMATION_MESSAGE);
    }


    /**
     * Add to fruit map.
     *
     * @param FruitKey   the fruit key
     * @param FruitValue the fruit value
     */
    public void AddToFruitMap(String FruitKey, String FruitValue){
        //showMessageDialog(null, "A new Fruit is about to be inserted!", "INSERTION_PROCESS", INFORMATION_MESSAGE);
        myFruitMap.put(FruitKey, FruitValue);
        //showMessageDialog(null, "Map Updated Successfully", "UPDATE_SUCCESSFUL!", PLAIN_MESSAGE);

        //now notify relevant subscribers about the state change:
        RealTimeUpdate(myFruitMap);
        //showMessageDialog(null, "Relevant Parameters Notified!", "APPROPRIATE SYSTEM NOTIFIED", INFORMATION_MESSAGE);
    }

    /**
     * Remove from fruit map.
     *
     * @param FruitKey the fruit key
     */
    public void RemoveFromFruitMap(String FruitKey){
        //showMessageDialog(null, "A new subject is about to be removed!", "DELETION_PROCESS", WARNING_MESSAGE);
        myFruitMap.remove(FruitKey);
        //showMessageDialog(null, "Information Removed", "DELETION_SUCCESSFUL!", PLAIN_MESSAGE);

        //now notify relevant subscribers about the state change:
        RealTimeUpdate(myFruitMap);
        //showMessageDialog(null, "Relevant Parameters Notified!", "APPROPRIATE SYSTEM NOTIFIED", INFORMATION_MESSAGE);
    }


    /**
     * Add to mood list.
     *
     * @param MoodIndex the mood index
     * @param Mood      the mood
     */
    public void AddToMoodList(int MoodIndex, String Mood){
        //showMessageDialog(null, "A new Mood is about to be inserted!", "INSERTION_PROCESS", INFORMATION_MESSAGE);
        myMoodList.add(MoodIndex, Mood);
        //showMessageDialog(null, "List Updated Successfully", "UPDATE_SUCCESSFUL!", PLAIN_MESSAGE);

        //now notify relevant subscribers about the state change:
        RealTimeUpdate(myMoodList);
        //showMessageDialog(null, "Relevant Parameters Notified!", "APPROPRIATE SYSTEM NOTIFIED", INFORMATION_MESSAGE);
    }

    /**
     * Remove from mood list.
     *
     * @param MoodIndex the mood index
     */
    public void RemoveFromMoodList(int MoodIndex){
        //showMessageDialog(null, "A new mood is about to be removed!", "DELETION_PROCESS", WARNING_MESSAGE);
        myMoodList.remove(MoodIndex);
        //showMessageDialog(null, "Information Removed", "DELETION_SUCCESSFUL!", PLAIN_MESSAGE);

        //now notify relevant subscribers about the state change:
        RealTimeUpdate(myMoodList);
        //showMessageDialog(null, "Relevant Parameters Notified!", "APPROPRIATE SYSTEM NOTIFIED", INFORMATION_MESSAGE);
    }


    /**
     * Add to fav tv shows array.
     *
     * @param TVshow the tv show
     */
    public void AddToFavTVShowsArray(String TVshow){
        //showMessageDialog(null, "A new TV show is about to be inserted!", "INSERTION_PROCESS", INFORMATION_MESSAGE);
        try {
            myFavTVShowsArray[6] = TVshow;
            //showMessageDialog(null, "Array Updated Successfully", "UPDATE_SUCCESSFUL!", PLAIN_MESSAGE);
        }catch(ArrayIndexOutOfBoundsException ex){
            System.out.println("Array length are fixed and immutable...Sorry about that mate...");
        }finally {
            System.out.println("The TV shows array is still:");
            //now notify relevant subscribers about the state change:
            RealTimeUpdate(myFavTVShowsArray);
            //showMessageDialog(null, "Relevant Parameters Notified!", "APPROPRIATE SYSTEM NOTIFIED", INFORMATION_MESSAGE);
        }
    }

    /**
     * Remove from fav tv shows array.
     */
    public void RemoveFromFavTVshowsArray(){
        //showMessageDialog(null, "Arrays are immutable and fixed!", "DELETION_PROCESS", WARNING_MESSAGE);

        //now notify relevant subscribers about the state change:
        RealTimeUpdate(myFavTVShowsArray);
        //showMessageDialog(null, "Relevant Parameters Notified!", "APPROPRIATE SYSTEM NOTIFIED", INFORMATION_MESSAGE);
    }
}
