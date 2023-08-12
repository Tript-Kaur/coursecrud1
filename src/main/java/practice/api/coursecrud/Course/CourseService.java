package practice.api.coursecrud.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CourseService {   // Defining Business Services
    @Autowired
    private CourseRepository courseRepository;

    public List<Course> getAllCourses(String topicId)
    {        List<Course> courses =new ArrayList<>();
        courseRepository.findByTopicId(topicId).forEach(courses::add);     //lambda expression for iterating by foreach
        return courses;                                      // add Courses in list and return
    }
    public Optional<Course> getSingleCourse(String argId) {
        return courseRepository.findById(argId);
    }
    public void addTopic(Course addCourse) {
        courseRepository.save(addCourse);
    }

    public void updateTopicMethod(Course updateCourse) {
        courseRepository.save(updateCourse);
    }

   public void removeCourseMethod(String argId) {courseRepository.deleteById(argId);
    }
}
