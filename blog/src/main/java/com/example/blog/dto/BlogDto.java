package com.example.blog.dto;

import com.example.blog.model.Author;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BlogDto {
    private long idBlog;
    @NotBlank(message = "Mã sách không được để trống")
    private String code;
    @NotBlank(message = "Tên sách không được để trống")
    private String nameBlog;
    @NotBlank(message = "Thể loại sách không được để trống")
    private String genre;
    @NotNull(message = "Số lượng không được để trống")
    @Min(value = 1, message = "Số lượng phải lớn hơn 0")
    private Integer quantity;
    @NotBlank(message = "Tên tác giả không được để trống")
    private String nameAuthor;
    @NotNull(message = "Ngày sinh không được để trống")
    @Past(message = "Ngày sinh phải là ngày trong quá khứ")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthDate;
    private Author idAuthor;
}
