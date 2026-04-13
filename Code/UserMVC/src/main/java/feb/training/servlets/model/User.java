package feb.training.servlets.model;

public class User {

    private String userId;
    private String password;
    private String email;

    public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(String userId, String password, String email) {
		this.userId = userId;     // 🔥 IMPORTANT
        this.password = password;
        this.email = email;
	}
	// Getters & Setters
    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}