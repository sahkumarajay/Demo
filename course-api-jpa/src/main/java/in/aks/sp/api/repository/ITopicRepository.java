package in.aks.sp.api.repository;

import org.springframework.data.repository.CrudRepository;

import in.aks.sp.api.model.Topic;

public interface ITopicRepository extends CrudRepository<Topic, Integer>
{

}
