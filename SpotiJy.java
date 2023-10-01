import java.util.ArrayList;
import java.util.List;

public class SpotiJy {
        public Artist[] artists;

        public Artist[] getArtists() {
                return this.artists;
        }

        public  void addArtists(Artist[] artists){
                int numberOfAddedSongs = 0;
                List<Artist> songsList = new ArrayList<Artist>();
                for (int i = 0; i <this.artists.length;i++){
                        songsList.add(this.artists[i]);
                }
                for (int i = 0; i < artists.length;i++){
                        if(!(isInArray(this.artists,artists[i]))){
                                songsList.add(artists[i]);
                                numberOfAddedSongs += 1;
                        }
                }
                Song[] arrHelper = new Song[songsList.size()];
                songsList.toArray(arrHelper);
                this.artists = songsList.toArray(this.artists);

        }
        public boolean isInArray(Artist[] arr ,Artist song){
                for(int i = 0; i < arr.length; i++){
                        if (arr[i].isEqual(song))
                                return true;
                }
                return  false;
        }
        public boolean isEqual(Artist artist2 , Artist artist1) {
                if ( artist1.getFirstName() == artist2.getFirstName() && artist1.getLastName() == artist2.getLastName() && artist1.getBirthYear() == artist2.getBirthYear() )
                        return true;
                return  false;
        }
        Artist getTopTrendingArtist(){
                if(this.artists.length == 0){
                        return null;
                }
                Artist topArtist = this.artists[0];
                for(int i = 0 ; i < this.artists.length; i++){
                        if(topArtist.totalLikes() <= this.artists[i].totalLikes())
                                topArtist = this.artists[i];
                }
                String [] artist = new  String[2];
                artist[0] = topArtist.getFirstName();
                artist[1] = topArtist.getLastName();
                return topArtist;
        }
        Album getTopTrendingAlbum(){
                Album topAlbum = this.artists[0].getAlbums()[0];
                for(int i = 0; i < this.artists.length ; i++){
                        for(int j = 0 ; j < this.artists[i].getAlbums().length; j++)
                                if (this.artists[i].getAlbums()[j].totalLIkes() >= topAlbum.totalLIkes())
                                        topAlbum = this.artists[i].getAlbums()[j];
                }
                return  topAlbum;
        }
        Song getTopTrendingSong(){
                Song topSong = this.artists[0].getAlbums()[0].getSongs()[0];
                for(int i = 0; i < this.artists.length ; i++){
                        for(int j = 0 ; j < this.artists[i].getAlbums().length; j++)
                                for(int k = 0 ; k < this.artists[i].getAlbums()[j].getSongs().length; k++)
                                        if (this.artists[i].getAlbums()[j].getSongs()[k].getLikes() >= topSong.getLikes())
                                                topSong = this.artists[i].getAlbums()[j].getSongs()[k];
                }
                return  topSong;
        }

}