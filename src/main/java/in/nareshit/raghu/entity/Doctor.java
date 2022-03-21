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
@Table(name="doc_tab")

public class Doctor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //for mysql
	@Column(name="doc_id_col")
	private Long docId;

	@Column(name="doc_name_col")
	private String docName;
	
	@Column(name="doc_email_col")
	private String docEmail;
	
	@Column(name="doc_addr_col")
	private String docAddr;
	
	@Column(name="doc_mobile_col")
	private String docMobile;
	
	@Column(name="doc_gen_col")
	private String docGen;
	
	@Column(name="doc_note_col")
	private String docNote;
	
	//------ Module Integration -----------
	@ManyToOne
	@JoinColumn(name="spec_id_fk_col")
	private Specialization specialization;

	public Doctor(Long docId, String docName, String docEmail, String docAddr, String docMobile, String docGen,
			String docNote, Specialization specialization) {
		super();
		this.docId = docId;
		this.docName = docName;
		this.docEmail = docEmail;
		this.docAddr = docAddr;
		this.docMobile = docMobile;
		this.docGen = docGen;
		this.docNote = docNote;
		this.specialization = specialization;
	}

	public Doctor() {
		super();
	}

	public Long getDocId() {
		return docId;
	}

	public void setDocId(Long docId) {
		this.docId = docId;
	}

	public String getDocName() {
		return docName;
	}

	public void setDocName(String docName) {
		this.docName = docName;
	}

	public String getDocEmail() {
		return docEmail;
	}

	public void setDocEmail(String docEmail) {
		this.docEmail = docEmail;
	}

	public String getDocAddr() {
		return docAddr;
	}

	public void setDocAddr(String docAddr) {
		this.docAddr = docAddr;
	}

	public String getDocMobile() {
		return docMobile;
	}

	public void setDocMobile(String docMobile) {
		this.docMobile = docMobile;
	}

	public String getDocGen() {
		return docGen;
	}

	public void setDocGen(String docGen) {
		this.docGen = docGen;
	}

	public String getDocNote() {
		return docNote;
	}

	public void setDocNote(String docNote) {
		this.docNote = docNote;
	}

	public Specialization getSpecialization() {
		return specialization;
	}

	public void setSpecialization(Specialization specialization) {
		this.specialization = specialization;
	}
	
	
	
	

	
	
	

}
