package th.mfu.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Review {
    @Id
    private Long reviewId;
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;
    @ManyToOne
    @JoinColumn(name = "dorm_id", referencedColumnName = "dormId")
    private Dorm dorm;
    private int rating;
    private String reviewFromUser;
    private LocalDateTime timestamp;

    public Review() {
    }
   
    

    public Review(Long reviewId, User user, Dorm dorm, int rating, String reviewFromUser, LocalDateTime timestamp) {
        this.reviewId = reviewId;
        this.user = user;
        this.dorm = dorm;
        this.rating = rating;
        this.reviewFromUser = reviewFromUser;
        this.timestamp = timestamp;
    }



    public Long getReviewId() {
        return reviewId;
    }


    public void setReviewId(Long reviewId) {
        this.reviewId = reviewId;
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
