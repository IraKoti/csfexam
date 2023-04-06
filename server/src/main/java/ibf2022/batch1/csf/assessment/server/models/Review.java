package ibf2022.batch1.csf.assessment.server.models;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;


// DO NOT MODIFY THIS CLASS
public class Review {
	// display_title
	private String title;
	// mpaa_rating
	private String rating;
	// byline
	private String byline;
	// headline
	private String headline;
	// summary_short 
	private String summary;
	// link.url
	private String reviewURL;
	// multimedia.src
	private String image = null;

	private int commentCount = 0;

	public void setTitle(String title) { this.title = title; }
	public String getTitle() { return this.title; }

	public void setRating(String rating) { this.rating = rating; }
	public String getRating() { return this.rating; }

	public void setByline(String byline) { this.byline = byline; }
	public String getByline() { return this.byline; }

	public void setHeadline(String headline) { this.headline = headline; }
	public String getHeadline() { return this.headline; }

	public void setSummary(String summary) { this.summary = summary; }
	public String getSummary() { return this.summary; }

	public void setReviewURL(String reviewURL) { this.reviewURL = reviewURL; }
	public String getReviewURL() { return this.reviewURL; }

	public void setImage(String image) { this.image = image; }
	public String getImage() { return this.image; }
	public boolean hasImage() { return null != this.image; }

	public void setCommentCount(int commentCount) { this.commentCount = commentCount; };
	public int getCommentCount() { return this.commentCount; }


	@Override
	public String toString() {
		return "Review{title:%s, rating:%s}".formatted(title, rating);
	}



	// public static List<MarvelCharacter> create(String json) throws IOException
    // {
    //     List<MarvelCharacter> characters = new LinkedList<>();
    //     try(InputStream is = new ByteArrayInputStream(json.getBytes()))
    //     {
    //         JsonReader r = Json.createReader(is);
    //         JsonObject o = r.readObject();
    //         JsonObject oo = o.getJsonObject("data");
    //         //data is json object for specific result under data
    //         if(oo.getJsonArray("results") != null)            
    //             characters = oo.getJsonArray("results").stream()
    //                 .map( v -> (JsonObject)v)
    //                 .map( v -> MarvelCharacter.createJson(v))
    //                 .toList();
            
    //     } 
    //     return characters;
    // }

	public static List<Review> create(String json) throws IOException
	{
		List<Review> reviews = new LinkedList<>();
		//System.out.println("----------------------------------MODEL review create method====================================");
		try(InputStream is = new ByteArrayInputStream(json.getBytes()))
        {
            JsonReader r = Json.createReader(is);
            JsonObject o = r.readObject();
			//System.out.println("---------------------------------- o "+o+"====================================");
            //JsonObject oo = o.getJsonObject("results");
			//System.out.println("---------------------------------- oo "+o+"====================================");
            //data is json object for specific result under data
            if(o.getJsonArray("results") != null)            
                reviews = o.getJsonArray("results").stream()
                    .map( v -> (JsonObject)v)
                    .map( v -> Review.createJson(v))
                    .toList();
            
        }
		//System.out.println("----------------------------------reviews: "+reviews+"====================================");
        return reviews;
	}


	public static Review createJson(JsonObject o)
    {
        Review c = new Review();
        c.title = o.getString("display_title");
        c.rating = o.getString("mpaa_rating");
        c.byline = o.getString("byline");
        c.headline = o.getString("headline");
		c.summary = o.getString("summary_short");
		JsonObject a = o.getJsonObject("link");
        c.reviewURL = a.getString("url");
        //JsonObject b = o.getJsonObject("multimedia");
		//System.out.print("--------------------------------"+b);
		//c.image = b.getString("src");
		// if(b== null)
		// {
		c.image = "";
		// }
		// else
		// {
		// 	c.image = b.getString("src");
		// }
		//System.out.println("-------------"+c.title+"/"+c.rating+"/"+c.byline+"/"+c.headline+"/"+c.summary+"/"+c.reviewURL+"/"+c.image+"------------------/");
		//System.out.println(null);
        return c;
    }

    public JsonObject toJson()
    {   
        return Json.createObjectBuilder()
            .add("display_title",getTitle())
            .add("mpaa_rating", getRating())
            .add("byline",getByline())
            .add("headline",getHeadline())
			.add("summary_short",getSummary())
			.add("link",getReviewURL())
			.add("multimedia",getImage())
            .build();
    }
}
