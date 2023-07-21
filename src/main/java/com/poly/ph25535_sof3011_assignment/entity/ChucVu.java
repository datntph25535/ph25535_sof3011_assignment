package com.poly.ph25535_sof3011_assignment.entity;

import com.poly.ph25535_sof3011_assignment.viewModel.ChucVuViewModel;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "ChucVu")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "listNhanVien")
public class ChucVu {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "Id")
    private UUID id;
    @Column(name = "Ma")
    private String ma;
    @Column(name = "Ten")
    private String ten;
    @OneToMany(mappedBy = "chucVu", targetEntity = NhanVien.class)
    private List<NhanVien> listNhanVien;
}
