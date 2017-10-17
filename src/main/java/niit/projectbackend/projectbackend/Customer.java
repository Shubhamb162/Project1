package niit.projectbackend.projectbackend;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class Customer {
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY) 
		private Integer customerId;
		private String firstName;
		private String lastName;
		private String password;
		@Transient
		private String ConfirmPassword;
		public Integer getCustomerId() {
			return customerId;
		}
		public void setCustomerId(Integer customerId) {
			this.customerId = customerId;
		}
		public String getFirstName() {
			return firstName;
		}
		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}
		public String getLastName() {
			return lastName;
		}
		public void setLastName(String lastName) {
			this.lastName = lastName;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getConfirmPassword() {
			return ConfirmPassword;
		}
		public void setConfirmPassword(String confirmPassword) {
			ConfirmPassword = confirmPassword;
		}
}
