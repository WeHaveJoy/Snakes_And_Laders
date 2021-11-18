package SA_game;

import java.util.Map;

public class Ladder extends Player {

    public int ladders(int position, Map<String, String> specialValues) {
        int userPost = 0;
        for (Map.Entry<String, String> entry : specialValues.entrySet())
            if (Integer.parseInt(entry.getKey()) == position) {
                userPost = Integer.parseInt(entry.getValue());
            }
        return userPost;
    }
}
