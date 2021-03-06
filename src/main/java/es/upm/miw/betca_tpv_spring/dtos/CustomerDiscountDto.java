package es.upm.miw.betca_tpv_spring.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import es.upm.miw.betca_tpv_spring.documents.CustomerDiscount;
import es.upm.miw.betca_tpv_spring.documents.User;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class CustomerDiscountDto {

    private String id;

    private String description;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private LocalDateTime registrationDate;

    private BigDecimal discount;

    private BigDecimal minimumPurchase;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private User user;

    public CustomerDiscountDto() {
        // Empty for framework
    }

    public CustomerDiscountDto(String id, String description, LocalDateTime registrationDate, BigDecimal discount,
                               BigDecimal minimumPurchase, User user) {
        this.id = id;
        this.description = description;
        this.registrationDate = LocalDateTime.now();
        this.discount = discount;
        this.minimumPurchase = minimumPurchase;
        this.user = user;
    }

    public CustomerDiscountDto(CustomerDiscount customerDiscount) {
        this(
                customerDiscount.getId(),
                customerDiscount.getDescription(),
                customerDiscount.getRegistrationDate(),
                customerDiscount.getDiscount(),
                customerDiscount.getMinimumPurchase(),
                customerDiscount.getUser()
        );
    }

    public String getId() {
        return this.id;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getRegistrationDate() {
        return this.registrationDate;
    }

    public BigDecimal getDiscount() {
        return this.discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public BigDecimal getMinimumPurchase() {
        return this.minimumPurchase;
    }

    public void setMinimumPurchase(BigDecimal minimumPurchase) {
        this.minimumPurchase = minimumPurchase;
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    @Override
    public String toString() {
        return "CustomerDiscountDto{" +
                "id='" + this.id + '\'' +
                ", description='" + this.description + '\'' +
                ", registrationDate='" + this.registrationDate + '\'' +
                ", discount='" + this.discount + '\'' +
                ", minimumPurchase='" + this.minimumPurchase + '\'' +
                ", user=" + this.user +
                '}';
    }
}
