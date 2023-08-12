package practice.api.coursecrud.Course.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TopicService {   // Defining Business Services
    @Autowired
    private TopicRepository topicRepository;

    public List<Topic> getAllTopics()
    {
        List<Topic> topics=new ArrayList<>();
        topicRepository.findAll().forEach(topics::add);     //lambda expression for iterating by foreach
        return topics;                                      // add topic in list and return
    }
    public Optional<Topic> getSingleTopic(String argId) {
        return topicRepository.findById(argId);
    }
    public void addTopic(Topic addTopic) {
        topicRepository.save(addTopic);
    }
    public void updateTopicMethod(String argId, Topic updateTopic) {
        topicRepository.save(updateTopic);
    }
   public void removeTopicMethod(String argId) {
        topicRepository.deleteById(argId);
    }

}
