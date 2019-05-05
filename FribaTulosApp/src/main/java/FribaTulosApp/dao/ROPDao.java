
package FribaTulosApp.dao;

import fribatulosapp.domain.RoundOfPlay;
import java.util.List;

/**
 *
*/
public interface ROPDao {

    RoundOfPlay create(RoundOfPlay rop) throws Exception;
    
    RoundOfPlay findByROPNumber(int i);
    
    List<RoundOfPlay> getAll();

    void save() throws Exception;
    
}
