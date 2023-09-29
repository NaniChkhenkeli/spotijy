
public class Artist {
    private  String firstName;
    private String lastName;
    private Album[] albums;
    private Song[] singles;
    private int birthYear;

    public int getBirthYear() {
        return this.birthYear;
    }

    public Album[] getAlbums() {
        return this.albums;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public Song[] getSingles() {
        return this.singles;
    }

    public Song mostLikedSong(){
        if (albums.length == 0 && singles.length == 0)
            return  null;
        Song highestLikedSingle = singles[0];
        Song highestLikedAlbum = albums[0].getSongs()[0] ;
        for(int i = 0; i < singles.length; i++){
            if(singles[i].getLikes() >= highestLikedSingle.getLikes()){
                highestLikedSingle = singles[i];
            }
        }
        for(int i = 0; i < albums.length; i++){
            for(int j = 0; j < albums[i].getSongs().length ; j++){
                if (albums[i].getSongs()[j].getLikes() >= highestLikedAlbum.getLikes())
                    highestLikedAlbum = albums[i].getSongs()[j];
            }
        }
        if (highestLikedAlbum.getLikes() >= highestLikedSingle.getLikes())
            return highestLikedAlbum;

        return highestLikedSingle;

    }




    public Song leastLikedSong(){
        if (albums.length == 0 && singles.length == 0)
            return  null;
        Song leastLikedSingle = singles[0];
        Song leastLikedAlbum = albums[0].getSongs()[0] ;
        for(int i = 0; i < singles.length; i++){
            if(singles[i].getLikes() <= leastLikedSingle.getLikes()){
                leastLikedSingle = singles[i];
            }
        }
        for(int i = 0; i < albums.length; i++){
            for(int j = 0; j < albums[i].getSongs().length ; j++){
                if (albums[i].getSongs()[j].getLikes() <= leastLikedAlbum.getLikes())
                    leastLikedAlbum = albums[i].getSongs()[j];
            }
        }
        if (leastLikedAlbum.getLikes() <= leastLikedSingle.getLikes())
            return leastLikedAlbum;

        return leastLikedSingle;
    }
    int totalLikes(){
        if (albums.length == 0 && singles.length == 0)
            return  0;
        int totalLikes = 0;
        for(int i = 0; i < singles.length; i++){
            totalLikes += singles[i].getLikes();
        }
        for(int i = 0; i < albums.length; i++){
            for(int j = 0; j < albums[i].getSongs().length ; j++){
                totalLikes += albums[i].getSongs()[j].getLikes();
            }
        }
        return totalLikes;

    }
    public String toString(){

        return "Name='" + this.getFirstName() +
                this.getLastName() +
                ",Birth year" + this.getBirthYear() + ",Total likes:" + this.totalLikes();

    }

    public boolean isEqual(Artist other) {
        if (this.firstName == other.getFirstName() && this.lastName == other.getLastName() && this.birthYear == other.birthYear )
            return true;
        return  false;
    }

}