package th.mfu.dto;

import java.time.LocalDateTime;

import th.mfu.model.Dorm;
import th.mfu.model.User;

public class ReviewDto {
    private User user;
    private int rating;
    private String reviewFromUser;
    private LocalDateTime timestamp;
    private Dorm dorm;
    public ReviewDto() {
    }

    

    public ReviewDto(User user, int rating, String reviewFromUser, LocalDateTime timestamp, Dorm dorm) {
        this.user = user;
        this.rating = rating;
        this.reviewFromUser = reviewFromUser;
        this.timestamp = timestamp;
        this.dorm = dorm;
    }



    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getReviewFromUser() {
        return reviewFromUser;
    }

    public void setReviewFromUser(String reviewFromUser) {
        this.reviewFromUser = reviewFromUser;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }



    public Dorm getDorm() {
        return dorm;
    }



    public void setDorm(Dorm dorm) {
        this.dorm = dorm;
    }
    
    
}
