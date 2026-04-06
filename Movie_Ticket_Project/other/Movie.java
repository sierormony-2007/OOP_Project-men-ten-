package other;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
public class Movie {
    private String movieId;
    private String title;
    private double duration;
    private String releaseDate;
    private String genre;
    private String status;

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
        public void updateStatus(){
        LocalDate today = LocalDate.now();
        LocalDate release = LocalDate.parse(this.releaseDate);
        if(release.isEqual(today)){
            status = "Released_Today";
        }else if(release.isAfter(today)){
            status= "Coming_Soon";
        }

    }

public String getStatus() {
    if (releaseDate == null || releaseDate.isEmpty()) return "Unknown";

    try {
        // Parse the string releaseDate to LocalDate
        LocalDate release = LocalDate.parse(releaseDate, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        LocalDate today = LocalDate.now();

        if (release.isAfter(today)) {
            return "Coming Soon";  // release date in future
        } else if (release.isEqual(today)) {
            return "Released Today"; // release date today
        } else {
            return "Not Released"; // already released
        }

    } catch (Exception e) {
        return "Invalid Release Date"; // if the date string is invalid
    }
}
    

    @Override
    public String toString() {
        return "Movie{" +
                "ID=" + movieId +
                ", Title='" + title + '\'' +
                ", Duration=" + duration + " mins" +
                ", ReleaseDate='" + releaseDate + '\'' +
                ", Genre='" + genre + '\'' +
                '}' + "('"+status+'\''+')';
    }

}