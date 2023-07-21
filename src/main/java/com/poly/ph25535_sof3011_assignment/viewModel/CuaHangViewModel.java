package com.poly.ph25535_sof3011_assignment.viewModel;

import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.hibernate.validator.constraints.Length;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Component
public class CuaHangViewModel {
    private UUID id;
    @NotBlank(message = "Không được để trống!")
    @Length(max = 20, message = "Mã không được quá 20 kí tự")
    private String ma;
    @NotBlank(message = "Không được để trống!")
    @Length(max = 50, message = "Tên không được quá 50 kí tự")
    private String ten;
    @NotBlank(message = "Không được để trống!")
    @Length(max = 100, message = "Địa chỉ không được quá 100 kí tự")
    private String diaChi;
    @NotBlank(message = "Không được để trống!")
    @Length(max = 50, message = "Thành phố không được quá 50 kí tự")
    private String thanhPho;
    @NotBlank(message = "Không được để trống!")
    @Length(max = 50, message = "Quốc gia không được quá 50 kí tự")
    private String quocGia;
}
