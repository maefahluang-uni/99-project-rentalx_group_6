package th.mfu.model;

import javax.persistence.*;

@Entity
public class Dorm {

    @Id
    private Long dormId;
    private String dormName;
    private String dormDesc;
    private Integer price;
    private Integer bedroom;
    private Integer bathroom;
    @Column(length = 1000)
    private String img1;
    @Column(length = 1000)
    private String img2;
    @Column(length = 1000)
    private String img3;
    @Column(length = 1000)
    private String img4;
    private String city;
    private String amenities;
    private Double latitude;
    private Double longitude;
    @ManyToOne
    private User landlord;

    public Dorm() {
    }

    public Dorm(Long dormId, String dormName, String dormDesc, Integer price, Integer bedroom, Integer bathroom,
            String img1, String img2, String img3, String img4, String city, String amenities, Double latitude,
            Double longitude, User landlord) {
        this.dormId = dormId;
        this.dormName = dormName;
        this.dormDesc = dormDesc;
        this.price = price;
        this.bedroom = bedroom;
        this.bathroom = bathroom;
        this.img1 = img1;
        this.img2 = img2;
        this.img3 = img3;
        this.img4 = img4;
        this.city = city;
        this.amenities = amenities;
        this.latitude = latitude;
        this.longitude = longitude;
        this.landlord = landlord;
    }



    public Long getDormId() {
        return dormId;
    }

    public void setDormId(Long dormId) {
        this.dormId = dormId;
    }

    public String getDormName() {
        return dormName;
    }

    public void setDormName(String dormName) {
        this.dormName = dormName;
    }

    public String getDormDesc() {
        return dormDesc;
    }

    public void setDormDesc(String dormDesc) {
        this.dormDesc = dormDesc;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getImg1() {
        return img1;
    }

    public void setImg1(String img1) {
        this.img1 = img1;
    }

    public String getImg2() {
        return img2;
    }

    public void setImg2(String img2) {
        this.img2 = img2;
    }

    public String getImg3() {
        return img3;
    }

    public void setImg3(String img3) {
        this.img3 = img3;
    }

    public String getImg4() {
        return img4;
    }

    public void setImg4(String img4) {
        this.img4 = img4;
    }

    public User getLandlord() {
        return landlord;
    }

    public void setLandlord(User landlord) {
        this.landlord = landlord;
    }

    public Integer getBedroom() {
        return bedroom;
    }

    public void setBedroom(Integer bedroom) {
        this.bedroom = bedroom;
    }

    public Integer getBathroom() {
        return bathroom;
    }

    public void setBathroom(Integer bathroom) {
        this.bathroom = bathroom;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAmenities() {
        return amenities;
    }

    public void setAmenities(String amenities) {
        this.amenities = amenities;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }
}
