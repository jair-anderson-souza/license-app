package io.github.jass2125.licenseservice.model;
import java.io.Serializable;

public class LicenseDTO  implements Serializable {

    private Long id;

    private String productName;

    private String name;

    private OrderDTO orderDTO;

    public LicenseDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public OrderDTO getOrderDTO() {
        return orderDTO;
    }

    public void setOrderDTO(OrderDTO orderDTO) {
        this.orderDTO = orderDTO;
    }
}
