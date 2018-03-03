package Beans;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

public class User {
   private int id;
   private int userrole;
   private String username;
   private String firstname;
   private String lastname;
   private String email;
   // the JsonProperty prevents the user from alternating with the password and is write only 
   @JsonProperty( access = Access.WRITE_ONLY)
   private String password;
   


public User(int id, String username, String password, String firstname, String lastname, String email, int userrole) {
	super();
	this.id = id;
	this.userrole = userrole;
	this.username = username;
	this.firstname = firstname;
	this.lastname = lastname;
	this.email = email;
	this.password = password;
}
public User(String username, String password) {
  this.username = username;
  this.password = password;
}
public User(String username, int userrole) {
	this.username = username;
	this.userrole = userrole;
}
public User() {
	// TODO Auto-generated constructor stub
}
/**
 * @return the id
 */
public int getId() {
	return id;
}
/**
 * @param id the id to set
 */
public void setId(int id) {
	this.id = id;
}
/**
 * @return the userrole
 */
public int getUserrole() {
	return userrole;
}
/**
 * @param userrole the userrole to set
 */
public void setUserrole(int userrole) {
	this.userrole = userrole;
}
/**
 * @return the username
 */
public String getUsername() {
	return username;
}
/**
 * @param username the username to set
 */
public void setUsername(String username) {
	this.username = username;
}
/**
 * @return the firstname
 */
public String getFirstname() {
	return firstname;
}
/**
 * @param firstname the firstname to set
 */
public void setFirstname(String firstname) {
	this.firstname = firstname;
}
/**
 * @return the lastname
 */
public String getLastname() {
	return lastname;
}
/**
 * @param lastname the lastname to set
 */
public void setLastname(String lastname) {
	this.lastname = lastname;
}
/**
 * @return the email
 */
public String getEmail() {
	return email;
}
/**
 * @param email the email to set
 */
public void setEmail(String email) {
	this.email = email;
}
/**
 * @return the password
 */
public String getPassword() {
	return password;
}
/**
 * @param password the password to set
 */
public void setPassword(String password) {
	this.password = password;
}
/* (non-Javadoc)
 * @see java.lang.Object#hashCode()
 */
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((email == null) ? 0 : email.hashCode());
	result = prime * result + ((firstname == null) ? 0 : firstname.hashCode());
	result = prime * result + id;
	result = prime * result + ((lastname == null) ? 0 : lastname.hashCode());
	result = prime * result + ((password == null) ? 0 : password.hashCode());
	result = prime * result + ((username == null) ? 0 : username.hashCode());
	result = prime * result + userrole;
	return result;
}
/* (non-Javadoc)
 * @see java.lang.Object#equals(java.lang.Object)
 */
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	User other = (User) obj;
	if (email == null) {
		if (other.email != null)
			return false;
	} else if (!email.equals(other.email))
		return false;
	if (firstname == null) {
		if (other.firstname != null)
			return false;
	} else if (!firstname.equals(other.firstname))
		return false;
	if (id != other.id)
		return false;
	if (lastname == null) {
		if (other.lastname != null)
			return false;
	} else if (!lastname.equals(other.lastname))
		return false;
	if (password == null) {
		if (other.password != null)
			return false;
	} else if (!password.equals(other.password))
		return false;
	if (username == null) {
		if (other.username != null)
			return false;
	} else if (!username.equals(other.username))
		return false;
	if (userrole != other.userrole)
		return false;
	return true;
}
/* (non-Javadoc)
 * @see java.lang.Object#toString()
 */
@Override
public String toString() {
	return "User [id=" + id + ", userrole=" + userrole + ", username=" + username + ", firstname=" + firstname
			+ ", lastname=" + lastname + ", email=" + email + ", password=" + password + "]";
}


}