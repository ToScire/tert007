package entity.film;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Alexander on 30.04.2016.
 */
public class FilmGenreHelper {
    Map<Integer, String> genres = new HashMap<>();

    public FilmGenreHelper(){
        genres.put(1, "Drama");
        genres.put(2, "Comedy");
    }

    public String getGenreById(int id){
        if (genres.containsKey(id)) {
             return genres.get(id);
        }

        return null;
    }
}
