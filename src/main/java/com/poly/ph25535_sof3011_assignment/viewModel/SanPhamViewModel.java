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
public class SanPhamViewModel {
    private UUID id;
    @NotBlank(message = "Không được để trống!")
    @Length(max = 10, message = "Mã không được quá 10 kí tự")
    private String ma;
    @NotBlank(message = "Không được để trống!")
    @Length(max = 50, message = "Tên không được quá 50 kí tự")
    private String ten;
}
