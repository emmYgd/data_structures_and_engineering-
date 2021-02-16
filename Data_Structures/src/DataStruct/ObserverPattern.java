package DataStruct;

/**
 * The type Observer pattern.
 */
public class ObserverPattern {
    /**
     * Main.
     *
     * @param args the args
     */
    public static void main (String[] args){
        BeingWatched entitiesBeingWatched = new BeingWatched();
        Watcher entitiesWatcher  = new Watcher();

        //register:
        entitiesBeingWatched.addObserver(entitiesWatcher);

        //call entities:
        entitiesBeingWatched.AddToSubjectStack("Biology");
        entitiesBeingWatched.RemoveFromSubjectStack();
        entitiesBeingWatched.RemoveFromSubjectStack();

        //entitiesBeingWatched.AddToColorQueue("Violet");
        //entitiesBeingWatched.RemoveFromSubjectStack();

        entitiesBeingWatched.AddToFruitMap("sixthFruit", "Carrot");
        entitiesBeingWatched.AddToFruitMap("seventhFruit", "Cherry");
        entitiesBeingWatched.RemoveFromFruitMap("secondFruit");

        entitiesBeingWatched.AddToMoodList(5, "Excited");
        entitiesBeingWatched.AddToMoodList(6, "Grateful");
        entitiesBeingWatched.RemoveFromMoodList(4);

        entitiesBeingWatched.AddToFavTVShowsArray("Pirates of the Carribean");
        entitiesBeingWatched.RemoveFromFavTVshowsArray();

    }
}
