package in.nareshit.raghu.service;

import java.util.List;

import in.nareshit.raghu.entity.Appointment;

public interface IAppointmentService {
	
	Long saveAppointment(Appointment app);
	List<Appointment> getAllAppointment();
	void deleteAppointment(Long id);
	Appointment getOneAppointment(Long id);
	void updateAppointment(Appointment app);

}
