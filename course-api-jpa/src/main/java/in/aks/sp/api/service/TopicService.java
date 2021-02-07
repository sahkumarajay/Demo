package in.aks.sp.api.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.aks.sp.api.model.Topic;
import in.aks.sp.api.repository.ITopicRepository;

@Transactional
@Service
public class TopicService {

	@Autowired
	private ITopicRepository iTopicRepository;

	public List<Topic> getAllTopics() {

		
		return (List<Topic>) iTopicRepository.findAll();
	}

	public Topic getTopicByID(Integer id) {

		Optional<Topic> topic= iTopicRepository.findById(id);

		return topic.get();

	}

	public boolean saveTopic(Topic topic) {
		boolean result = false;
		try {

			Topic obj = iTopicRepository.save(topic);
			if (null == obj) {
				return false;
			} else {
				result = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;

	}

	public Topic updateTopicById(Topic topic, Integer id) {

		return	iTopicRepository.save(topic);
	}

	public void deleteTopic(Integer id) {
		iTopicRepository.deleteById(id);

	}

	@Transactional
	public boolean saveTopics(List<Topic> topics) {

		try {

			Iterable<Topic> topicObj = iTopicRepository.saveAll(topics);
			if (null != topicObj) {
				return true;
			} else {
				return false;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

}
