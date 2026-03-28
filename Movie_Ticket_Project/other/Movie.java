package other;

public class Movie {
    private String movieId;
    private String title;
    private double duration;
    private String releaseDate;
    private String genre;

    public Movie(String movieId, String title, double duration, String releaseDate, String genre){
        this.movieId = movieId;
        this.title = title;
        this.duration = duration;
        setReleaseDate(releaseDate);
        this.genre = genre;
    }

    
    public String getMovieId() { return movieId; }
    public void setMovieId(String movieId) { this.movieId = movieId; }

    public String getTitle() { return title; }
    public void setTitle(String title) { if(title!=null && !title.trim().isEmpty()) this.title=title.trim(); }

    public double getDuration() { return duration; }
    public void setDuration(double duration) { this.duration = duration; }

    public String getReleaseDate() { return releaseDate; }
    public void setReleaseDate(String releaseDate) { this.releaseDate=releaseDate;}
    public String getGenre() { return genre; }
    public void setGenre(String genre) { this.genre = genre; }

    @Override
    public String toString() {
        return "Movie{" +
                "ID=" + movieId +
                ", Title='" + title + '\'' +
                ", Duration=" + duration + " mins" +
                ", ReleaseDate='" + releaseDate + '\'' +
                ", Genre='" + genre + '\'' +
                '}';
    }
}