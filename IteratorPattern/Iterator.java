public interface Iterator {
    //Returns a boolean indicating that there are more objects to iterate over.
    public boolean hasNext();

    // Returns the next object in the iteration.
    public Object next();

    // Once this iterator is created, we can implement this to iterate over any collection of objects.
}