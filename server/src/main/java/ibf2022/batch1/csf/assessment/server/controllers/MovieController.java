package ibf2022.batch1.csf.assessment.server.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ibf2022.batch1.csf.assessment.server.models.Review;
import ibf2022.batch1.csf.assessment.server.services.MovieService;
import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonArrayBuilder;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path="/api/search", produces = MediaType.APPLICATION_JSON_VALUE)
public class MovieController {
	@Autowired
	private MovieService movieSvc;

	// TODO: Task 3, Task 4, Task 8
	@GetMapping
	public  ResponseEntity<String> getReviews(String query)
	{
		// JsonArray result = null;
        // Optional<List<MarvelCharacter>>  or = this.characterSvc.listCharacters(charName, limit, offset);
        // List<MarvelCharacter> results = or.get();
        // JsonArrayBuilder arrayBuilder = Json.createArrayBuilder();
        // for(MarvelCharacter mc : results)
        // {
        //     arrayBuilder.add(mc.toJson());
        // }
        // result = arrayBuilder.build();
        // return ResponseEntity
        //     .status(HttpStatus.OK)
        //     .contentType(MediaType.APPLICATION_JSON)
        //     .body(result.toString());
		//System.out.println("----------------------------------"+"controller"+"====================================");
		JsonArray result = null;
		List<Review> results  = this.movieSvc.searchReviews(query);
		//System.out.println("---------------------------------- results:"+results+"====================================");
		JsonArrayBuilder arrayBuilder = Json.createArrayBuilder();
		for(Review rev: results)
		{
			arrayBuilder.add(rev.toJson());
		}
		result = arrayBuilder.build();
		System.out.println(result);
		return ResponseEntity
            .status(HttpStatus.OK)
            .contentType(MediaType.APPLICATION_JSON)
            .body(result.toString());
	}

	// @PostMapping(path = "/api/comment")
	// public ResponseEntity<String> saveCharacterComment(
    //     @RequestBody Comment comment, @PathVariable(required=true) String charId)
	// 	{}



}
