package SA_game;

import java.util.Map;

public class Snake extends Player{

    public int snakes(int position, Map<String, String> specialValues) {
        int userPost = 0;
        for (Map.Entry<String, String> entry : specialValues.entrySet())
            if (Integer.parseInt(entry.getValue()) == position) {
                userPost = Integer.parseInt(entry.getKey());
            }
        return userPost;
    }
}
