//UserDetails.java
package in.ineuron.model;

import java.util.Set;

import org.hibernate.annotations.CollectionId;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="SECURITY_USERS")
public class UserDetails {
	@Id
	@GeneratedValue
	private  Integer unid;
	@Column(length = 20,nullable = false,unique = true)
	private  String uname;
	@Column(length = 100,nullable = false)
	private String pwd;
	@Column(length = 20,nullable = false ,unique = true)
	private  String email;
	@Column(length = 1,nullable = false)
	private  Boolean status=true;
	
	@ElementCollection(fetch = FetchType.LAZY)
	@CollectionTable(name="SECURITY_ROLES",joinColumns = @JoinColumn(name="USER_ID",referencedColumnName = "UNID"))
	@Column(length = 20,name="ROLE")
	private Set<String> roles;
	
	
	
	public UserDetails() {
		super();
	}

	public UserDetails(Integer unid, String uname, String pwd, String email, Boolean status, Set<String> roles) {
		super();
		this.unid = unid;
		this.uname = uname;
		this.pwd = pwd;
		this.email = email;
		this.status = status;
		this.roles = roles;
	}

	//setters && gettes
	

	public Integer getUnid() {
		return unid;
	}

	public void setUnid(Integer unid) {
		this.unid = unid;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public Set<String> getRoles() {
		return roles;
	}

	public void setRoles(Set<String> roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "UserDetails [unid=" + unid + ", uname=" + uname + ", pwd=" + pwd + ", email=" + email + ", status="
				+ status + ", roles=" + roles + "]";
	}
	
	
	
	

}
