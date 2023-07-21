package com.poly.ph25535_sof3011_assignment.viewModel;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
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
public class ChiTietSPViewModel {

    private UUID id;
    private UUID idSP;
    private UUID idNsx;
    private UUID idMauSac;
    private UUID idDongSP;
    @Positive(message = "Phải là số dương")
    private int namBH;
    @NotBlank(message = "Không được để trống")
    @Length(max = 30, message = "Mô tả không được quá 50 kí tự")
    private String moTa;
    @Positive(message = "Phải là số dương")
    private int soLuongTon;
    @Positive(message = "Phải là số dương")
    private double giaNhap;
    @Positive(message = "Phải là số dương")
    private double giaBan;
}
