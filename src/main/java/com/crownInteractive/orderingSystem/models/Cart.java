package com.crownInteractive.orderingSystem.models;

import com.crownInteractive.orderingSystem.models.dto.ProductDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import java.util.List;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cartId;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Product> productList;

    private int sizeOfCart;

    private String CartName;

}
