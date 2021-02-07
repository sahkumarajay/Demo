package in.aks.sp.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import in.aks.sp.api.model.Topic;
import in.aks.sp.api.service.TopicService;

/**
 * @author ajay
 *
 */
@RestController
@RequestMapping("/aks/topic")
public class TopicController {
	
	@Autowired
	private TopicService  topicService; 
	
	
	@PostMapping("/save")
	public String saveTopic(@RequestBody Topic topic)
	{
		String result="Fail to save";
		if(topicService.saveTopic(topic))
			result = "Saved successfully";
		return result;
			
	}
	@RequestMapping(value = "/topics")
	public List<Topic> getAllTopics()
	{
		return topicService.getAllTopics();
	}
	
	@GetMapping("/{id}")
	public Topic getTopicById(@PathVariable Integer id)
	{
		return topicService.getTopicByID(id);
	}
	
	@RequestMapping(path = "/save/topics")
	public String saveMultipleTopics(@RequestBody List<Topic> topics)
	{
		
	boolean result =	false;
	result=	topicService.saveTopics(topics);
		return  (result==true?"Saved successfully ":"Failed to save .");
	}
	@PutMapping(value = "/update/{id}")
	public Topic updateTopicById(@RequestBody Topic topic , Integer id)
	
	{
		return topicService.updateTopicById(topic, id);
		
	}

	@RequestMapping(path = "/delete/{id}" ,method = RequestMethod.DELETE)
	public String  deleteTopicById(@PathVariable Integer id)
	{
		
		topicService.deleteTopic(id);
		return id+" deleted successfully";
	}
}
