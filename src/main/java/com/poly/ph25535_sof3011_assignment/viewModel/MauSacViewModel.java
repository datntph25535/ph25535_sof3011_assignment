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
public class MauSacViewModel {
    private UUID id;
    @NotBlank(message = "Không được để trống!")
    @Length(max = 20, message = "Mã không được quá 20 kí tự")
    private String ma;
    @NotBlank(message = "Không được để trống!")
    @Length(max = 30, message = "Tên không được quá 30 kí tự")
    private String ten;
}
