package in.nareshit.raghu.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

//import lombok.Data;

//@Data
@Entity
@Table(name="appointment_tab")

public class Appointment {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="app_id_col")
	private Long appId;
	
	@Column(name="app_date_col")
	private String appDate;
	
	@Column(name="app_slots_col")
	private String appSlots;
	
	@Column(name="app_details_col")
	private String appDetails;
	
	@Column(name="app_fee_col")
	private String appFee;
	
	@ManyToOne
	@JoinColumn(name="docIdFk") //FK
	private Doctor doctor;      //HAS-A variable name in parent entity

	public Appointment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Appointment(Long appId, String appDate, String appSlots, String appDetails, String appFee, Doctor doctor) {
		super();
		this.appId = appId;
		this.appDate = appDate;
		this.appSlots = appSlots;
		this.appDetails = appDetails;
		this.appFee = appFee;
		this.doctor = doctor;
	}

	public Long getAppId() {
		return appId;
	}

	public void setAppId(Long appId) {
		this.appId = appId;
	}

	public String getAppDate() {
		return appDate;
	}

	public void setAppDate(String appDate) {
		this.appDate = appDate;
	}

	public String getAppSlots() {
		return appSlots;
	}

	public void setAppSlots(String appSlots) {
		this.appSlots = appSlots;
	}

	public String getAppDetails() {
		return appDetails;
	}

	public void setAppDetails(String appDetails) {
		this.appDetails = appDetails;
	}

	public String getAppFee() {
		return appFee;
	}

	public void setAppFee(String appFee) {
		this.appFee = appFee;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}
	
		
	
}
