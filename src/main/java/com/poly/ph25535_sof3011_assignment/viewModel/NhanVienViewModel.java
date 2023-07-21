package com.poly.ph25535_sof3011_assignment.viewModel;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
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
public class NhanVienViewModel {
    private UUID id;
    @NotBlank(message = "Không được để trống!")
    @Length(max = 20, message = "Mã không được quá 20 kí tự")
    private String ma;
    @NotBlank(message = "Không được để trống!")
    @Length(max = 30, message = "Tên không được quá 30 kí tự")
    private String ten;
    @NotBlank(message = "Không được để trống!")
    @Length(max = 30, message = "Tên đệm không được quá 30 kí tự")
    private String tenDem;
    @NotBlank(message = "Không được để trống!")
    @Length(max = 30, message = "Họ không được quá 30 kí tự")
    private String ho;
    @NotBlank(message = "Không được để trống!")
    @Length(max = 10, message = "Giới tính không được quá 10 kí tự")
    @Pattern(regexp = "Nam|Nữ", message = "Dữ liệu không hợp lệ")
    private String gioiTinh;
    @NotBlank(message = "Không được để trống!")
    private String ngaySinh;
    @NotBlank(message = "Không được để trống!")
    @Length(max = 100, message = "Địa chỉ không được quá 100 kí tự")
    private String diaChi;
    @NotBlank(message = "Không được để trống!")
    @Length(max = 30, message = "Sđt không được quá 30 kí tự")
    private String sdt;
    @NotBlank(message = "Không được để trống!")
    private String matKhau;
    private UUID idCH;
    private UUID idCV;
    private UUID idGuiBC;
    @NotNull(message = "Dữ liệu không hợp lệ")
    @Pattern(regexp = "[01]", message = "Dữ liệu không hợp lệ")
    private String trangThai = "1";
}
