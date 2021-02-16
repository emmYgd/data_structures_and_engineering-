package DataStruct;

import java.util.Stack;
import java.util.Queue;
import java.util.Map;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

/**
 * The type Watcher.
 */
//One Observer Class:
public class Watcher implements Observer {

    public void update(Observable obj, Object dataState) {
        if(dataState instanceof Stack){
            System.out.println("The current state of the Stack is:" + (Stack) dataState);
        }else if(dataState instanceof Queue){
            System.out.println("The current state of the Queue is:" + (Queue) dataState);
        }else if(dataState instanceof Map){
            System.out.println("The current state of the Map is:" + (Map) dataState);
        }else if(dataState instanceof List){
            System.out.println("The current state of the List is:" + (List) dataState);
        }else{
            System.out.println("The current state of the Array is:" + dataState);
        }
    }
}

