package com.dms.oauth.inf.user.view;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository("UserViewRepository")
public interface UserViewRepository extends MongoRepository<UserView,String>{

	@Query("{'userName':?0}")
	UserView findByUserName(String userName);
	
//	@Query("{'userName':?0}")
	UserView findByIdUser(String idUser);

}
