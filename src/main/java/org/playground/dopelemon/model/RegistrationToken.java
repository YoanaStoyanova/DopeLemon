package org.playground.dopelemon.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Date;
import java.util.UUID;

@Entity(name = "registration_token")
public class RegistrationToken {

    @Id
    private String token;

    private Date creationTime;

    @ManyToOne(targetEntity = User.class, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "user_id")
    private User user;

    public RegistrationToken(){}

    public  RegistrationToken(User user){
        this.user = user;
        token = UUID.randomUUID().toString();
        creationTime = new Date();
    }

    public String getToken() {
        return token;
    }

    public Date getCreationTime() {
        return creationTime;
    }

    public User getUser() {
        return user;
    }
}
