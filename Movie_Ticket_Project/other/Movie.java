package other;
public class Movie{
   private  int movieId;
    private String title;
    private double duration;
    private String releaseDate;
    private String genre;
    

    public Movie(int movieId, String title, double duration, String releaseDate, String genre){
        this.movieId = movieId;
        this.title = title;
        this.duration = duration;
        this.releaseDate = releaseDate;
        this.genre = genre;
    }

    public int getMovieId() {
        return this.movieId;
        
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }
   

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if (title != null && !title.trim().isEmpty()) {
            this.title = title.trim();
        }
    }


    public double getDuration() {
        return duration;
    }

    public String getReleaseDate() {
        return releaseDate;
    }
    public String getGenre(){
        return genre;
    }
}