package in.nareshit.raghu.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.nareshit.raghu.entity.Appointment;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

}
