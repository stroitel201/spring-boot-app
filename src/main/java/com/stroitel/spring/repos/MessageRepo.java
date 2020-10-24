package com.stroitel.spring.repos;

import com.stroitel.spring.domain.Message;
import org.springframework.data.repository.CrudRepository;

public interface MessageRepo extends CrudRepository<Message, Long> {


}
