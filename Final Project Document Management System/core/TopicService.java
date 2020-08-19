package core;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class TopicService implements TopicRepository {
  
   static ArrayList<Topic> topicRepository = new ArrayList<Topic>();
  
   // Added unimplemented methods of TopicRepository interface
   @Override
   public Topic findById(int topicId) {
       return topicRepository.stream().filter(t -> t.getTopicId() == topicId).findFirst().get();
   }

   @Override
   public List findByTopic(String topic) {
       if(topicRepository.stream().filter(t -> t.getTopic().equals(topic)).findFirst().get() != null) {
           return topicRepository;
       }
       return null;
   }

   @Override
   public List findByStorageFolder(String topic) {
       if(topicRepository.stream().filter(t -> t.getStorageFolder().equals(topic)).findFirst().get() != null) {
           return topicRepository;
       }
       return null;
   }

   public static void main(String[] args) {
      
    String[] topicWords = {"Multi Threading", "Inner Classes", "Collections", "Generics", "Development", "JVM"};

    IntStream.range(0,10).forEach(it -> {
    String buzzWord = topicWords[it % topicWords.length]; // each topic from topicWords
    Topic topic = new Topic((it % topicWords.length),buzzWord,"JAVA" ); // create Topic object
    topicRepository.add(topic);
    });
      
    TopicService tr = new TopicService();
    System.out.println(tr.findById(0).getTopicId() + " >> " + tr.findById(0).getTopic() + " >> " + tr.findById(0).getStorageFolder());
    System.out.println(tr.findByTopic("Multi Threading")); // returns list that contains Topic objects; access by iteration
    System.out.println(tr.findByStorageFolder("JAVA")); // returns list that contains Topic objects; access by iteration
   }

}

