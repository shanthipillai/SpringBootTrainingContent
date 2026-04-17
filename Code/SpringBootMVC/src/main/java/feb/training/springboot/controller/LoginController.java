package feb.training.springboot.controller;


import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import feb.training.springboot.dto.UserSessionDTO;
import feb.training.springboot.entities.User;
import feb.training.springboot.service.JobService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
public class LoginController {
	@Autowired
	private JobService jobService;
	/*
	 * @Autowired private RedisTemplate<String, Object> redisTemplate;
	 */

	@Autowired
	private RedisTemplate<String, UserSessionDTO> redisTemplate;
    // =========================
    // LOAD HOME PAGE (LOGIN + REGISTER)
    // =========================
	/*
	 * @GetMapping({"/", "/home"}) public String showHome(Model model) {
	 * model.addAttribute("loginUser", new User());
	 * model.addAttribute("registerUser", new User()); return "home"; }
	 */
    // =========================
    // HANDLE REGISTRATION
    // =========================
	
	@GetMapping({"/", "/home"})
	public String showHome(Model model,
	                       HttpSession session,
	                       HttpServletRequest request) {

	    System.out.println("==== HOME HIT ====");

	    User user = (User) session.getAttribute("loggedInUser");
	    System.out.println("Session user: " + user);

	    Cookie[] cookies = request.getCookies();

	    if (cookies != null) {
	        for (Cookie c : cookies) {

	            System.out.println("Cookie: " + c.getName());

	            if ("rememberToken".equals(c.getName())) {

	                String token = c.getValue();
	                System.out.println("Token from cookie: " + token);

	                // ✅ Get DTO from Redis
	                UserSessionDTO sessionDTO =
	                        redisTemplate.opsForValue().get(token);

	                System.out.println("Redis value: " + sessionDTO);

	                if (sessionDTO != null) {

	                    // 🔥 Convert DTO → User
	                    user = new User();
	                    user.setUserid(sessionDTO.getUserId());
	                    user.setEmail(sessionDTO.getEmail());

	                    session.setAttribute("loggedInUser", user);

	                    System.out.println("✅ Redirecting to dashboard");

	                    return "redirect:/dashboard";
	                }
	            }
	        }
	    }

	    System.out.println("❌ No user found → showing login");

	    model.addAttribute("loginUser", new User());
	    model.addAttribute("registerUser", new User());

	    return "home";
	}
    @PostMapping("/register")
    public String register(@ModelAttribute("registerUser") User user,
                           RedirectAttributes redirectAttributes) {

        // 👉 Save to DB (optional)
        // userService.save(user);

        redirectAttributes.addFlashAttribute("registerMsg", "Registration Successful");

        return "redirect:/home";   // ⭐ go back to same page
    }

    // =========================
    // HANDLE LOGIN
    // =========================
	/*
	 * @PostMapping("/login") public String login(@ModelAttribute("loginUser") User
	 * user, Model model) {
	 * 
	 * if ("admin@gmail.com".equals(user.getEmail()) &&
	 * "1234".equals(user.getPassword())) {
	 * 
	 * return "redirect:/dashboard"; // ⭐ redirect to new page }
	 * 
	 * model.addAttribute("loginError", "Invalid credentials");
	 * model.addAttribute("loginUser", new User()); return "home"; }
	 */
    
	/*
	 * @PostMapping("/login") public String login(@ModelAttribute("loginUser") User
	 * user, Model model, HttpSession session) {
	 * 
	 * if ("admin@gmail.com".equals(user.getEmail()) &&
	 * "1234".equals(user.getPassword())) {
	 * 
	 * // ⭐ Store user in session session.setAttribute("loggedInUser", user);
	 * 
	 * return "redirect:/dashboard"; }
	 * 
	 * model.addAttribute("loginError", "Invalid credentials"); return "home"; }
	 */
    
    @PostMapping("/login")
    public String login(@ModelAttribute("loginUser") User user,
                        Model model,
                        HttpSession session,
                        HttpServletResponse response) {

        if ("admin@gmail.com".equals(user.getEmail()) &&
            "1234".equals(user.getPassword())) {

            // ✅ session
            session.setAttribute("loggedInUser", user);

            // ✅ generate token
            String token = java.util.UUID.randomUUID().toString();

            // ✅ store in Redis (token → user)
            
           // redisTemplate.opsForValue().set(token, user, 7, TimeUnit.DAYS);
            UserSessionDTO sessionDTO =
                    new UserSessionDTO(user.getUserid(), user.getEmail());

            redisTemplate.opsForValue().set(token, sessionDTO, 7, TimeUnit.DAYS);

            // ✅ cookie
            Cookie cookie = new Cookie("rememberToken", token);
            cookie.setMaxAge(7 * 24 * 60 * 60);
            cookie.setPath("/");
            cookie.setHttpOnly(true);
            response.addCookie(cookie);

            return "redirect:/dashboard";
        }

        model.addAttribute("loginError", "Invalid credentials");
        return "home";
    }
    
    @GetMapping("/register")
    public String showRegister(Model model) {
        model.addAttribute("registerUser", new User());
        return "register";
    }
	/*
	 * @GetMapping("/dashboard") public String showDashboard(Model model) {
	 * 
	 * Map response = jobService.getJavaJobs();
	 * 
	 * model.addAttribute("jobs", response.get("results"));
	 * 
	 * return "dashboard"; }
	 */
    
	/*
	 * @GetMapping("/dashboard") public String showDashboard(Model model,
	 * HttpSession session) {
	 * 
	 * User user = (User) session.getAttribute("loggedInUser");
	 * 
	 * if (user == null) { return "redirect:/home"; }
	 * 
	 * // ⭐ send email instead of name model.addAttribute("username",
	 * user.getEmail());
	 * 
	 * model.addAttribute("jobs", jobService.getJavaJobs());
	 * 
	 * return "dashboard"; }
	 */
    
	/*
	 * @GetMapping("/dashboard") public String showDashboard(Model model,
	 * HttpSession session, HttpServletRequest request) {
	 * 
	 * User user = (User) session.getAttribute("loggedInUser");
	 * 
	 * // 🔥 If session missing → check Redis if (user == null) {
	 * 
	 * Cookie[] cookies = request.getCookies();
	 * 
	 * if (cookies != null) { for (Cookie c : cookies) {
	 * 
	 * if ("rememberToken".equals(c.getName())) {
	 * 
	 * String token = c.getValue();
	 * 
	 * user = (User) redisTemplate.opsForValue().get(token);
	 * 
	 * if (user != null) { session.setAttribute("loggedInUser", user); } } } } }
	 * 
	 * if (user == null) { return "redirect:/home"; }
	 * 
	 * model.addAttribute("username", user.getEmail()); model.addAttribute("jobs",
	 * jobService.getJavaJobs());
	 * 
	 * return "dashboard"; }
	 */
    
	/*
	 * @GetMapping("/logout") public String logout(HttpSession session) {
	 * session.invalidate(); // destroy session return "redirect:/home"; }
	 */
    
    @GetMapping("/dashboard")
    public String showDashboard(Model model,
                                HttpSession session,
                                HttpServletRequest request) {

        User user = (User) session.getAttribute("loggedInUser");

        // 🔥 If session missing → check Redis
        if (user == null) {

            Cookie[] cookies = request.getCookies();

            if (cookies != null) {
                for (Cookie c : cookies) {

                    if ("rememberToken".equals(c.getName())) {

                        String token = c.getValue();

                        // ✅ get DTO from Redis
                        UserSessionDTO sessionDTO =
                                redisTemplate.opsForValue().get(token);

                        if (sessionDTO != null) {

                            // 🔥 recreate User object manually
                            user = new User();
                            user.setUserid(sessionDTO.getUserId());
                            user.setEmail(sessionDTO.getEmail());

                            session.setAttribute("loggedInUser", user);
                        }
                    }
                }
            }
        }

        if (user == null) {
            return "redirect:/home";
        }

        model.addAttribute("username", user.getEmail());
        model.addAttribute("jobs", jobService.getJavaJobs());

        return "dashboard";
    }
    @GetMapping("/logout")
    public String logout(HttpSession session,
                         HttpServletRequest request,
                         HttpServletResponse response) {

        Cookie[] cookies = request.getCookies();

        if (cookies != null) {
            for (Cookie c : cookies) {

                if ("rememberToken".equals(c.getName())) {

                    redisTemplate.delete(c.getValue());

                    c.setMaxAge(0);
                    c.setPath("/");
                    response.addCookie(c);
                }
            }
        }

        session.invalidate();

        return "redirect:/home";
    }
    
}