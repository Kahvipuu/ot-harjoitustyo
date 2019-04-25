
package fribatulosapp.dao;

import fribatulosapp.domain.Player;
import java.util.List;


public interface PlayerDao {
    
    Player create(Player p) throws Exception;
    
    Player findByPlayerName(String s);
    
    List<Player> getAll();
    
}
