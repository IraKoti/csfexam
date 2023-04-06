package ibf2022.batch1.csf.assessment.server.models;

public class Comment {

    private String comment_movie;
    private String poster_name;
    private Integer comment_rating;
    private String comment;
    public String getComment_movie() {
        return comment_movie;
    }
    public void setComment_movie(String comment_movie) {
        this.comment_movie = comment_movie;
    }
    public String getPoster_name() {
        return poster_name;
    }
    public void setPoster_name(String poster_name) {
        this.poster_name = poster_name;
    }
    public Integer getComment_rating() {
        return comment_rating;
    }
    public void setComment_rating(Integer comment_rating) {
        this.comment_rating = comment_rating;
    }
    public String getComment() {
        return comment;
    }
    public void setComment(String comment) {
        this.comment = comment;
    }
    

}
