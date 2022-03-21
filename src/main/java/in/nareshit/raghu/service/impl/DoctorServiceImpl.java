package in.nareshit.raghu.service.impl;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.nareshit.raghu.entity.Doctor;
import in.nareshit.raghu.repo.DoctorRepository;
import in.nareshit.raghu.service.IDoctorService;
import in.nareshit.raghu.util.AppUtil;

@Service
public class DoctorServiceImpl implements IDoctorService {

	@Autowired
	private DoctorRepository repo;
	
	@Override
	public Long saveDoctor(Doctor obj) {
		obj=repo.save(obj);
		return obj.getDocId();
	}
	
	@Override
	public List<Doctor> getAllDoctor() {
		List<Doctor> list = repo.findAll();
		return list;
	}

	@Override
	public void deleteDoctor(Long id) {
		repo.deleteById(id);
	}

	@Override
	public Doctor getOneDoctor(Long id) {
		
		Optional<Doctor> opt = repo.findById(id);
		
		if(opt.isEmpty()) {
			return null;
		} else {
			return opt.get();
		}
		
	}

	@Override
	public void updateDoctor(Doctor obj) {
		repo.save(obj);
	}

	@Override
	public Map<Long, String> getDocIdAndNames() {
		
		List<Object[]> list = repo.getDocIdAndNames();
		return AppUtil.convertListToMap(list);
	}

	
}
