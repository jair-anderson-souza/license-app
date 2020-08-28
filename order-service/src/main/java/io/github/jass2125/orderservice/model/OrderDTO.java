package io.github.jass2125.orderservice.model;


import io.github.jass2125.orderservice.model.enums.StatusEnum;

public class OrderDTO {

    private Long id;
    private StatusEnum status;

    public OrderDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public StatusEnum getStatus() {
        return status;
    }

    public void setStatus(StatusEnum status) {
        this.status = status;
    }
}

