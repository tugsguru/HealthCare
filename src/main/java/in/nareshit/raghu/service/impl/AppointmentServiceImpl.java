package in.nareshit.raghu.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.nareshit.raghu.entity.Appointment;
import in.nareshit.raghu.repo.AppointmentRepository;
import in.nareshit.raghu.service.IAppointmentService;

@Service
public class AppointmentServiceImpl implements IAppointmentService {

	@Autowired
	private AppointmentRepository repo;
	
	@Override
	public Long saveAppointment(Appointment app) {
		
		app=repo.save(app);
		return app.getAppId();
	}

	@Override
	public List<Appointment> getAllAppointment() {
		List<Appointment> list = repo.findAll();
		return list;
	}

	@Override
	public void deleteAppointment(Long id) {
		repo.deleteById(id);
	}

	@Override
	public Appointment getOneAppointment(Long id) {
		
		Optional<Appointment> app = repo.findById(id);
	
		if(app.isEmpty()) {
			return null;
		} else {
			return app.get();
		}
		
	}

	@Override
	public void updateAppointment(Appointment app) {
		repo.save(app);
	}

}
