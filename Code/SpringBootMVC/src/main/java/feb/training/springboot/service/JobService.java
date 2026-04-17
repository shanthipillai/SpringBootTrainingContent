package feb.training.springboot.service;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.Map;

@Service
public class JobService {

    private final WebClient webClient;

    public JobService(WebClient.Builder builder) {
        this.webClient = builder.baseUrl("https://api.adzuna.com/v1/api/jobs").build();
    }
	/*
	 * public Map getJavaJobs() {
	 * 
	 * return webClient.get() .uri(uriBuilder -> uriBuilder .path("/in/search/1")
	 * .queryParam("app_id", "894dc396") .queryParam("app_key",
	 * "a3fab31890b76d0aee026a9be47a2da0") .queryParam("what", "Java")
	 * .queryParam("where", "India") .build()) .retrieve() .bodyToMono(Map.class)
	 * .block(); }
	 */
    
    public List<Map<String, Object>> getJavaJobs() {

        Map response = webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/in/search/1")
                        .queryParam("app_id", "894dc396")
                        .queryParam("app_key",  "a3fab31890b76d0aee026a9be47a2da0")
                        .queryParam("what", "Java")
                        .queryParam("where", "India")
                        .build())
                .retrieve()
                .bodyToMono(Map.class)
                .block();

        return (List<Map<String, Object>>) response.get("results");  // ⭐ IMPORTANT
    }
}