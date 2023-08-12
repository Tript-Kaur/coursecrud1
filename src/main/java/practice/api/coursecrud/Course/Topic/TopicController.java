package practice.api.coursecrud.Course.Topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
public class TopicController {
    @Autowired
    private TopicService topicservice;
    @RequestMapping("/topics")
    public List<Topic> getAllTopicsList() {
        return topicservice.getAllTopics();
    }
    @RequestMapping("/topics/{argId}")
    public Optional<Topic> getSingleTopicObject(@PathVariable String argId) {
        return topicservice.getSingleTopic(argId);  // Call to method in TopicService
    }
    @RequestMapping(method = RequestMethod.POST, value = "/topics")
    public void addTopic(@RequestBody Topic addTopic) {
        topicservice.addTopic(addTopic);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/topics/{argId}")
    public void updateTopicinList(@RequestBody Topic updateTopic, @PathVariable String argId) {
        topicservice.updateTopicMethod(argId, updateTopic);
    }
    @RequestMapping(method = RequestMethod.DELETE, value = "/topics/{argId}")
    public void removeTopicinList(@PathVariable String argId) {
        topicservice.removeTopicMethod(argId);
    }

}
