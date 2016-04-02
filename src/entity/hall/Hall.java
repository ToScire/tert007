package entity.hall;

/**
 * Created by Alexander on 02.04.2016.
 */
public class Hall {
    private int id;
    private FilmFormat filmFormat;
    private int capacity;

    public Hall(){
    }

    public Hall(int id, FilmFormat filmFormat, int capacity) {
        this.id = id;
        this.filmFormat = filmFormat;
        this.capacity = capacity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public FilmFormat getFilmFormat() {
        return filmFormat;
    }

    public String getFilmFormatByString() {
        return filmFormat.getValue();
    }

    public void setFilmFormat(FilmFormat filmFormat) {
        this.filmFormat = filmFormat;
    }

    public void setFilmFormat(String filmFormat){
        this.filmFormat = FilmFormat.valueOf(filmFormat);
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
