package mbs.service;

import mbs.entity.UserEntity;
import mbs.repository.Repository;

public class UserServiceImpl implements UserService {

	private Repository repository ;
	
	public UserServiceImpl(Repository messageRepository) {
		this.repository = messageRepository;
	}
	
	@Override
	public void save(UserEntity userEntity) {
		repository.save(userEntity);
	}

}
