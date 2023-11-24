package th.mfu.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class WishList {
    @Id
    private Long id;
    @OneToOne
    private User user;
    @OneToOne
    @JoinColumn(name = "dorm_id")
    private Dorm dorm;

    public WishList() {
    }

  

    public WishList(Long id, User user, Dorm dorm) {
        this.id = id;
        this.user = user;
        this.dorm = dorm;
    }



    public Long getId() {
        return id;
    }



    public void setId(Long id) {
        this.id = id;
    }



    public User getUser() {
        return user;
    }



    public void setUser(User user) {
        this.user = user;
    }



    public Dorm getDorm() {
        return dorm;
    }



    public void setDorm(Dorm dorm) {
        this.dorm = dorm;
    }  

    
        
}
