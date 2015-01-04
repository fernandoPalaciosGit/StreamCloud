package es.cruzalosdedos.fernandopalacios.StreamSound.models;

/**
 * Created by Fernando Palacios on 04/01/2015.
 */
public class ModelSong {
    private String songName;
    private String songArtist;
    private int stars;

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getSongArtist() {
        return songArtist;
    }

    public void setSongArtist(String songArtist) {
        this.songArtist = songArtist;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }
}
