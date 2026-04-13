package feb.training.servlets.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import feb.training.servlets.model.User;

public class UserDAO {

	public boolean registerUser(User user) {

	    boolean status = false;

	    try {
	        Connection con = DBUtil.getConnection();

	        String sql = "INSERT INTO users(user_id, password, email) VALUES (?, ?, ?)";
	        PreparedStatement ps = con.prepareStatement(sql);

	        ps.setString(1, user.getUserId());
	        ps.setString(2, user.getPassword());
	        ps.setString(3, user.getEmail());

	        int rows = ps.executeUpdate();

	        System.out.println("Rows inserted: " + rows); // ✅ DEBUG

	        if (rows > 0) {
	            status = true;
	        }

	    } catch (Exception e) {
	        System.out.println("ERROR IN REGISTER:");
	        e.printStackTrace(); // 🔥 MUST SEE THIS IN CONSOLE
	    }

	    return status;
	}
    
    
    
    public boolean validateUser(String userId, String password) {

        boolean status = false;

        try {
            Connection con = DBUtil.getConnection();

            String sql = "SELECT * FROM users WHERE user_id=? AND password=?";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, userId);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                status = true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return status;
    }
    
    public boolean deleteUser(String userId) {

        boolean status = false;

        try {
            Connection con = DBUtil.getConnection();

            String sql = "DELETE FROM users WHERE user_id=?";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, userId);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                status = true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return status;
    }
    public User getUserById(String userId) {

    	System.out.println("userID"+userId);
        User user = null;

        try (Connection con = DBUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(
                 "SELECT * FROM users WHERE user_id=?")) {

            ps.setString(1, userId.trim());

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                user = new User();
                user.setUserId(rs.getString("user_id"));
                user.setPassword(rs.getString("password"));
                user.setEmail(rs.getString("email"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return user;
    }
    
    
    
    public boolean updateUser(User user) {

        boolean status = false;

        try {
            Connection con = DBUtil.getConnection();

            String sql = "UPDATE users SET password=?, email=? WHERE user_id=?";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, user.getPassword());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getUserId());

            int rows = ps.executeUpdate();

            if (rows > 0) {
                status = true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return status;
    }
    
    
    public List<User> getAllUsers() {

        List<User> list = new ArrayList<>();

        try {
            Connection con = DBUtil.getConnection();

            String sql = "SELECT user_id, email FROM users";
            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                User user = new User();
                user.setUserId(rs.getString("user_id"));
                user.setEmail(rs.getString("email"));

                list.add(user);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
}
