package io.github.jass2125.licenseservice.model;
import java.io.Serializable;

public class OrderDTO implements Serializable {

    private Long id;
    private String status;

    public OrderDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

