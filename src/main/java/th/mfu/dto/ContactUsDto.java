package th.mfu.dto;

public class ContactUsDto {
    private String name;
    private String email;
    private int phNum;
    private String message;

    public ContactUsDto() {
    }

    public ContactUsDto(String name, String email, int phNum, String message) {
        this.name = name;
        this.email = email;
        this.phNum = phNum;
        this.message = message;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhNum() {
        return phNum;
    }

    public void setPhNum(int phNum) {
        this.phNum = phNum;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
}
