package kruger.auth.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;


@Entity
public class User {
	
	@Id
	private String userName;
	
	private String userLastName;
	
	private String image;
	
	private Long userAge;
	
	private String userEmail;
	
	private String userPassword;
	
	private Long userPhone;
	
	private String paymentMethod;
	
	private String paymentData;
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "USER_ROLES",
		joinColumns = {
				@JoinColumn(name = " USER_ID " )
		},
		inverseJoinColumns = {
				@JoinColumn(name = " Role_ID ")
		}
	)
	private Set<Role> role;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserLastName() {
		return userLastName;
	}

	public void setUserLastName(String userLastName) {
		this.userLastName = userLastName;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Long getUserAge() {
		return userAge;
	}

	public void setUserAge(Long userAge) {
		this.userAge = userAge;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public Long getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(Long userPhone) {
		this.userPhone = userPhone;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public String getPaymentData() {
		return paymentData;
	}

	public void setPaymentData(String paymentData) {
		this.paymentData = paymentData;
	}

	public Set<Role> getRole() {
		return role;
	}

	public void setRole(Set<Role> role) {
		this.role = role;
	}

	public User(String userName, String userLastName, String image, Long userAge, String userEmail, String userPassword,
			Long userPhone, String paymentMethod, String paymentData, Set<Role> role) {
		
		this.userName = userName;
		this.userLastName = userLastName;
		this.image = image;
		this.userAge = userAge;
		this.userEmail = userEmail;
		this.userPassword = userPassword;
		this.userPhone = userPhone;
		this.paymentMethod = paymentMethod;
		this.paymentData = paymentData;
		this.role = role;
	}

	@Override
	public String toString() {
		return "User [userName=" + userName + ", userLastName=" + userLastName + ", image=" + image + ", userAge="
				+ userAge + ", userEmail=" + userEmail + ", userPassword=" + userPassword + ", userPhone=" + userPhone
				+ ", paymentMethod=" + paymentMethod + ", paymentData=" + paymentData + ", role=" + role
				+ ", getUserName()=" + getUserName() + ", getUserLastName()=" + getUserLastName() + ", getImage()="
				+ getImage() + ", getUserAge()=" + getUserAge() + ", getUserEmail()=" + getUserEmail()
				+ ", getUserPassword()=" + getUserPassword() + ", getUserPhone()=" + getUserPhone()
				+ ", getPaymentMethod()=" + getPaymentMethod() + ", getPaymentData()=" + getPaymentData()
				+ ", getRole()=" + getRole() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
	
	
//	private Iterable<Car>userBuyCar
	
	



	
}
