package in.nareshit.raghu.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.nareshit.raghu.entity.User;
import in.nareshit.raghu.repo.UserRepository;
import in.nareshit.raghu.service.IUserService;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private UserRepository repo;
	
	@Override
	public Integer saveUser(User user) {
		
		repo.save(user);
		return user.getUid();
	}

	@Override
	public List<User> getAllUser() {
		List<User> userList =repo.findAll();
		return userList;
	}

	@Override
	public void deleteUser(Integer id) {
		repo.deleteById(id);	
	}

	@Override
	public User getOneUser(Integer id) {
		
		Optional<User> opt=repo.findById(id);
		
		return opt.get();
	}

	@Override
	public void updateUser(User obj) {
		repo.save(obj);
		
	}

}
