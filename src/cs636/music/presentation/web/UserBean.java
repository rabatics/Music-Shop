// This is the session bean (POJO) for the student-oriented web pages
// It is created in the StudentWelcomeController, and if the user happens
// on another page first, the user is forwarded to that page.
// This bean holds the room number for the user across the various
// page visits.
// With page controllers in use, this bean has slimmed down to the
// point that it could be replaced by just an Integer roomNo attribute,
// but it can be thought of as a placeholder for a Student domain object
// with more properties.
package cs636.music.presentation.web;

public class UserBean {
	
	// Properties used from student-oriented JSP pages--
	// roomNo is the only real session variable 
	private String firstName;
	private String lastName;
	private String email;

	public UserBean() {}

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	

}
