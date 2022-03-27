package in.nareshit.raghu.service;

import java.util.List;

import in.nareshit.raghu.entity.User;

public interface IUserService {
	
	Integer saveUser(User user);
	List<User> getAllUser();
	void deleteUser(Integer id);
	User getOneUser(Integer id);
	void updateUser(User obj);
	
	/*Long saveDoctor(Doctor obj);
	List<Doctor> getAllDoctor();
	void deleteDoctor(Long id);
	Doctor getOneDoctor(Long id);
	void updateDoctor(Doctor obj);
	Map<Long,String> getDocIdAndNames();
	*/

}
