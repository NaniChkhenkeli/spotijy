import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Album {
    private  String title;
    private  int releaseYear;
    private Song[] songs;

    public Album(String title,int releaseYear, Song[] songs) {
        this.title = title;
        this.releaseYear = releaseYear;
        this.songs = songs;
    }

    public String getTitle() {
        return this.title;
    }

    public int getReleaseYear() {
        return this.releaseYear;
    }

    public Song[] getSongs() {
        return this.songs;
    }

    public boolean isInArray(Song[] arr ,Song song){
        for(int i = 0; i < arr.length; i++){
            if (arr[i].isEqual(song))
                return true;
        }
        return  false;
    }
    public int addSongs(Song[] songs){
        int numberOfAddedSongs = 0;
        List<Song> songsList = new ArrayList<Song>();
        for (int i = 0; i <this.songs.length;i++){
            songsList.add(this.songs[i]);
        }
        for (int i = 0; i < songs.length;i++){
            if(!(isInArray(this.songs,songs[i]))){
                songsList.add(songs[i]);
                numberOfAddedSongs += 1;
            }
        }
        Song[] arrHelper = new Song[songsList.size()];
        songsList.toArray(arrHelper);
        this.songs = songsList.toArray(this.songs);
        return numberOfAddedSongs;
    }
    public Song[] shuffle(){
        Song[] shuffleSongs = new Song[this.songs.length];
        for(int i = 0; i < shuffleSongs.length; i++){
            Random rand = new Random();
            int randIndex = rand.nextInt(shuffleSongs.length);
            if(!(isInArray(shuffleSongs,this.songs[randIndex]))){
                shuffleSongs[i] = this.songs[randIndex];
            }
        }
        return  shuffleSongs;
    }
    public Song[] sortByTitle(boolean isAscending){
        for(int i = 0; i < this.songs.length-1; i++) {
            for (int j = i + 1; j < this.songs.length; j++) {
                if (this.songs[i].getTitle().compareTo(this.songs[j].getTitle()) > 0) {
                    Song temp = this.songs[i];
                    this.songs[i] = this.songs[j];
                    this.songs[j] = temp;
                }
            }
        }

        if(isAscending == false){
            return reverse(this.songs);
        }
        return this.songs;
    }
    static Song[] reverse(Song[] songs){
        Song[] songs1 = new Song[songs.length];
        for(int i = 0 ; i < songs.length;i++)
            songs1[i] = songs[songs.length-1-i];
        return songs1;

    }
    public void mergeByDuration(Song[] songs, Song[] lft , Song[] rght, int left, int right) {
        int i = 0, j = 0, z = 0;
        while (i < left && j < right) {
            if (lft[i].getDuration() <= rght[j].getDuration()) {
                songs[z++] = lft[i++];
            }
            else {
                songs[z++] = rght[j++];
            }
        }
        while (i < left) {
            songs[z++] = lft[i++];
        }
        while (j < right) {
            songs[z++] = rght[j++];
        }
    }
    public Song[] mergeSortByDuration(Song[] songs, int n ) {
        if (n < 2) {
            return songs;
        }
        int mid = n / 2;
        Song[] lft = new Song[mid];
        Song[] rght = new Song[n - mid];

        for (int i = 0; i < mid; i++) {
            lft[i] = songs[i];
        }
        for (int i = mid; i < n; i++) {
            rght[i - mid] = songs[i];
        }
        mergeSortByDuration(lft, mid);
        mergeSortByDuration(rght, n - mid);

        mergeByDuration(songs, lft, rght, mid, n - mid);
        return songs;
    }
    Song[] sortByDuration(boolean isAscending) {
        if(isAscending == false){
            return reverse(this.songs);
        }
        return mergeSortByDuration(this.songs,this.songs.length);
    }
    public void mergeByReleaseYear(Song[] songs, Song[] lft , Song[] rght, int left, int right) {
        int i = 0, j = 0, z = 0;
        while (i < left && j < right) {
            if (lft[i].getReleaseYear() <= rght[j].getReleaseYear()) {
                songs[z++] = lft[i++];
            }
            else {
                songs[z++] = rght[j++];
            }
        }
        while (i < left) {
            songs[z++] = lft[i++];
        }
        while (j < right) {
            songs[z++] = rght[j++];
        }
    }
    public Song[] mergeSortByReleaseYear(Song[] songs, int n ) {
        if (n < 2) {
            return songs;
        }
        int mid = n / 2;
        Song[] lft = new Song[mid];
        Song[] rght = new Song[n - mid];

        for (int i = 0; i < mid; i++) {
            lft[i] = songs[i];
        }
        for (int i = mid; i < n; i++) {
            rght[i - mid] = songs[i];
        }
        mergeSortByReleaseYear(lft, mid);
        mergeSortByReleaseYear(rght, n - mid);

        mergeByReleaseYear(songs, lft, rght, mid, n - mid);
        return songs;
    }
    Song[] sortByReleaseYear(boolean isAscending){
        if(isAscending == false){
            return reverse(this.songs);
        }
        return  mergeSortByReleaseYear(this.songs,this.songs.length);
    }
    public void mergeByLikes(Song[] songs, Song[] lft , Song[] rght, int left, int right) {
        int i = 0, j = 0, z = 0;
        while (i < left && j < right) {
            if (lft[i].getLikes() <= rght[j].getLikes()) {
                songs[z++] = lft[i++];
            }
            else {
                songs[z++] = rght[j++];
            }
        }
        while (i < left) {
            songs[z++] = lft[i++];
        }
        while (j < right) {
            songs[z++] = rght[j++];
        }
    }
    public Song[] mergeSortByLikes(Song[] songs, int n ) {
        if (n < 2) {
            return songs;
        }
        int mid = n / 2;
        Song[] lft = new Song[mid];
        Song[] rght = new Song[n - mid];

        for (int i = 0; i < mid; i++) {
            lft[i] = songs[i];
        }
        for (int i = mid; i < n; i++) {
            rght[i - mid] = songs[i];
        }
        mergeSortByLikes(lft, mid);
        mergeSortByLikes(rght, n - mid);

        mergeByLikes(songs, lft, rght, mid, n - mid);
        return songs;
    }
    Song[] sortByPopularity(boolean isAscending){
        if(isAscending == false){
            return reverse(this.songs);
        }
        return  mergeSortByLikes(this.songs,this.songs.length);
    }

    public String toString() {
        String  songStr = "{";
        for (int i = 0; i < this.songs.length ; i++){
            if (i != this.songs.length - 1) {
                songStr = songStr + this.songs[i].toString() + "|";
            }
            else if ( i == this.songs.length-1)
                songStr = songStr + this.songs[i].toString() ;
        }
        songStr +=  "}";
        return "Title='" + title +
                ",ReleaseYear=" + releaseYear +
                ",songs:" + songStr
                ;
    }
    public int totalLIkes(){
        if (songs.length == 0 )
            return  0;
        int totalLikes = 0;
        for(int i = 0; i < songs.length; i++){
            totalLikes += songs[i].getLikes();
        }
        return totalLikes;
    }
}


