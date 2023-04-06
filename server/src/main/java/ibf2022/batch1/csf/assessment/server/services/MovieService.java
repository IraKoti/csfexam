package ibf2022.batch1.csf.assessment.server.services;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import ibf2022.batch1.csf.assessment.server.models.Review;;

@Service
public class MovieService {

	@Value("${nycmovie.api.url}")
    private String nycmovieApiUrl;

    @Value("${nycmovie.api.public.key}")
    private String nycmovieApiPublicKey;

    @Value("${nycmovie.api.private.key}")
    private String nycmovieApiPrivateKey;

	// TODO: Task 4
	// DO NOT CHANGE THE METHOD'S SIGNATURE
	public List<Review> searchReviews(String movieName) {	
		ResponseEntity<String> response = null;
		List<Review> lreview = null;
		//System.out.println("---------------------------------- movie name: "+movieName+"====================================");
		String nycMovieApiUrl = UriComponentsBuilder
			.fromUriString(nycmovieApiUrl)
			.queryParam("query", movieName)
			.queryParam("api-key", nycmovieApiPublicKey)
			.toUriString();

		//System.out.println("----------------------------------"+"MOVIE SERVICE"+"====================================");
		//System.out.println("----------------------------------"+nycMovieApiUrl+"====================================");
		RestTemplate rtemplate = new RestTemplate();
		response = rtemplate.getForEntity(nycMovieApiUrl,String.class);
		//System.out.println("----------------------------------SERVICE response: "+response+"====================================");
		try {
			//System.out.println("---------------------------------- SERVICE movie service create====================================");
			lreview = Review.create(response.getBody());
		}catch (IOException e) {
			 e.printStackTrace();
		}
		//System.out.println("----------------------------------lreview"+lreview+"====================================");
		return lreview;
	}

}
