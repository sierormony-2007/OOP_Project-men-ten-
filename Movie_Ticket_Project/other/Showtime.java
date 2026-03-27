package other;
public class Showtime {
    private String time;
    private String date;
    private int hallNumber;
    private Movie movie;

    public Showtime(String time, String date , int hallNumber, Movie movie){
        this.time = time;
        this.date = date;
        this.hallNumber = hallNumber;
        this.movie = movie;
    }

    public String getTime() {
        return time;
    }

    public String getDate() {
        return date;
    }

    public int getHallNumber() {
        return hallNumber;
    }

    public Movie getMovie() {
        return movie;
    }
       @Override
    public String toString() {
        return "Showtime{" +
                "Time='" + time + '\'' +
                ", Date='" + date + '\'' +
                ", Hall=" + hallNumber +
                ", Movie=" + movie.getTitle() +
                '}';
    }
}
