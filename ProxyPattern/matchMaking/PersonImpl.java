public class PersonImpl implements Person {
    String name;
    String gender;
    String interests;
    int rating;
    int ratingCount = 0;

    public PersonImpl() {};

    // getter methods 
    public String getName() {
        return name;
    }
    
    public String getGender() {
        return gender;
    }

    public String getInterests() {
        return interests;
    }

    public int getGeekRating() {
        return (rating / ratingCount);
    }

    // Setter Methods
    public void setName(String name) {
        this.name = name;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setInterests(String interests) {
        this.interests = interests;
    }

    public void setGeekRating(int geekRating) {
        this.rating += geekRating;
        ratingCount++;
    }
}

// Note that only others can set the geek rating. The user can set his information, but no one else can change it.
// Access is different for different people, so we need something to control access. This is where protection the proxy comes in.