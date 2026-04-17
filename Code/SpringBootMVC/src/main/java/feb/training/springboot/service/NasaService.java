package feb.training.springboot.service;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service

public class NasaService {

	private static final String API_KEY = "DEMO_KEY";

	private final WebClient webClient;

	public NasaService(WebClient.Builder builder) {
		this.webClient = builder.baseUrl("https://api.nasa.gov").build();
	}

	public String getMarsPhotos(int sol) {
		String response = webClient.get()
			    .uri(uriBuilder -> uriBuilder
			        .path("/mars-photos/api/v1/rovers/curiosity/photos")
			        .queryParam("sol", 1000)
			        .queryParam("api_key", "KWBU2hnHIa6cZtDoc6JbbSksiVfWiaV9RiLZew7U")
			        .build())
			    .retrieve()
			    .bodyToMono(String.class)
			    .block();
		return response;
	}
}