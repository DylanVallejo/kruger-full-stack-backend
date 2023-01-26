package kruger.auth.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity

public class Role {

	@Id	
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
    @Column(unique=true, nullable = false)
//	private Long id;
	
//	@Column
	private String roleName;
	
	@Column
	private String roleDescription;

	@Override
	public String toString() {
		return "Role [ roleName=" + roleName + ", roleDescription=" + roleDescription + "]";
	}

	public Role( String roleName, String roleDescription) {
		
		this.roleName = roleName;
		this.roleDescription = roleDescription;
	}
	

	public Role() {
		
		// TODO Auto-generated constructor stub
	}



	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleDescription() {
		return roleDescription;
	}

	public void setRoleDescription(String roleDescription) {
		this.roleDescription = roleDescription;
	}

	
}
