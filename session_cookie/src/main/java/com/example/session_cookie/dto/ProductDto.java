package com.example.session_cookie.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ProductDto {
    private long id;
    @NotEmpty(message = "Mã sản phẩm không được để trống!!")
    private String code;
    @NotEmpty(message = "Mã sản phẩm không được để trống!!")
    private String name;
    @NotEmpty(message = "Giá sản phẩm không được để trống!!")
    @Min(value = 1, message = "Giá phải lớn hơn 0")
    private Double price;
    @NotEmpty(message = "Hình ảnh  sản phẩm không được để trống!!")
    private String img;
    @Min(value = 1, message = "Số lượng phải lớn hơn 0")
    @NotEmpty(message = "Số lượng không được để trống!!")
    private int quantity;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ProductDto that = (ProductDto) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
