package practice.api.coursecrud.Course;

import practice.api.coursecrud.Course.Topic.Topic;

import javax.persistence.*;
@Entity
public class Course {
    @Id
    private String id;
    private String name , description;
    @ManyToOne
    private Topic topic;

   public Course(){    }
    public Course(String id, String name, String description, String topic_Id) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.topic = new Topic(topic_Id,"","");
    }
    public void setTopic(Topic topic) {
        this.topic = topic;
    }
    public Topic getTopic() {
        return topic;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
