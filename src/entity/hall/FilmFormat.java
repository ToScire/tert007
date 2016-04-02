package entity.hall;

/**
 * Created by Alexander on 02.04.2016.
 */
public enum FilmFormat {
    _2D("2D"),
    _3D("3D"),
    _IMAX("IMAX");

    private final String value;

    FilmFormat(String value) {
        this.value = value;
    }

    public String getValue(){
        return value;
    }
}
