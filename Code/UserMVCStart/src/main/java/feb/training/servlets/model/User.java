package feb.training.servlets.model;

public class User {

    private String userId;
    private String password;
    private String email;

    public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(String userId2, String password2, String email2) {
		// TODO Auto-generated constructor stub
	}
	// Getters & Setters
    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}