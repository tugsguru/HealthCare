package in.nareshit.raghu.service;

import java.util.List;
import java.util.Map;

import in.nareshit.raghu.entity.Doctor;

public interface IDoctorService {
	
	Long saveDoctor(Doctor obj);
	List<Doctor> getAllDoctor();
	void deleteDoctor(Long id);
	Doctor getOneDoctor(Long id);
	void updateDoctor(Doctor obj);
	Map<Long,String> getDocIdAndNames();
	
}
