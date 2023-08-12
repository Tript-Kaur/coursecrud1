package practice.api.coursecrud.Course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import practice.api.coursecrud.Course.Topic.Topic;

import java.util.List;
import java.util.Optional;
@RestController
public class CourseController {
    @Autowired
    private CourseService courseService;

    @RequestMapping("/topics/{id}/Courses")
    public List<Course> getAllCoursesList(@PathVariable String id) {

        return courseService.getAllCourses(id);
    }

    @RequestMapping("/topics/{argId}/Courses/{id}")
    public Optional<Course> getSingleCourseObject(@PathVariable String id) {
        return courseService.getSingleCourse(id);  // Call to method in CourseService
    }

    @RequestMapping(method = RequestMethod.POST, value = "/topics/{topicId}/Courses/")
    public void addCourse(@RequestBody Course addCourseObject , @PathVariable String topicId) {
        addCourseObject.setTopic(new Topic(topicId,"",""));
        courseService.addTopic(addCourseObject);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/topics/{topicId}/Courses/{id}")
    public void updateCoursesList(@RequestBody Course updateCourseObject, @PathVariable String id,@PathVariable String topicId) {
        updateCourseObject.setTopic(new Topic(topicId,"",""));
        courseService.updateTopicMethod(updateCourseObject);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/topics/{argId}/Courses/{id}")
    public void removeCourse(@PathVariable String Id) {
        courseService.removeCourseMethod(Id);
    }

}
