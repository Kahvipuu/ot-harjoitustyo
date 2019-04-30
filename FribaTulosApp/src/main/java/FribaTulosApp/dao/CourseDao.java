
package FribaTulosApp.dao;

import fribatulosapp.domain.Course;
import java.util.List;

/**
 *  
 */
public interface CourseDao {
    
    Course create(Course c) throws Exception;
    
    Course findByCourseName(String s);
    
    List<Course> getAll();
    
}
