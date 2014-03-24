/*
ADD DESCRIPTION IN ENGLISH
*/
public class Author {
	String name,email;
	char gender;
	
	public Author(String name, String email, char gender) {
		this.name = name;
		this.email = email;
		this.gender = gender;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public void setEmail(String newEmail) {
		this.email = newEmail;
		return;
	}
	
	public char getGender() {
		return this.gender;
	}
	
	public String toString() {
		String ret = this.name + " (" + this.gender + ") at " + this.email;
		return ret;
	}
	
}
