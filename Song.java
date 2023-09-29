
public class Song {
    private String title;
    private int releaseYear;
    private int duration;
    private int likes;
    public Song(String title,int releaseYear){
        this.title = title;
        this.releaseYear = releaseYear;
        this.duration = 60;
        this.likes = 0;
    }
    public Song(String title,int releaseYear,int duration){
        this.title = title;
        this.releaseYear = releaseYear;
        this.duration = duration;
        this.likes = 0;
    }
    public Song(String title, int releaseYear,int duration,int likes){
        this.title = title;
        this.releaseYear = releaseYear;
        this.duration =duration;
        this.likes = likes;
    }

    public int getDuration() {
        return this.duration;
    }

    public int getLikes() {
        return this.likes;
    }

    public String getTitle() {
        return this.title;
    }

    public int getReleaseYear() {
        return this.releaseYear;
    }
    public  boolean changeDuration(int duration){
        if(duration < 0 || duration> 720 || this.duration == duration)
            return  false;
        this.duration = duration;
        return true;
    }
    public void  like(){
        this.likes += 1;
    }
    public void  unlike(){
        if (this.likes > 0)
            this.likes += 1;
    }

    public boolean isEqual(Song other){
        if (this.title == other.getTitle() && this.likes == other.getLikes() && this.releaseYear == other.getReleaseYear() && this.duration == other.getDuration())
            return true;
        return  false;
    }
    @Override
    public String toString() {
        return "Title:" + this.title +","+ "Duration:" + (this.duration/(float)60) +" minutes,"
                +"Release year:" + this.releaseYear + ",Likes:" + this.likes;
    }
}

