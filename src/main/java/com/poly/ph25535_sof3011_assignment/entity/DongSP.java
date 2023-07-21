package com.poly.ph25535_sof3011_assignment.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "DongSP")
@Getter
@Setter
@Builder
@ToString(exclude = "listChiTietSP")
@NoArgsConstructor
@AllArgsConstructor
public class DongSP {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "Id")
    private UUID id;
    @Column(name = "Ma")
    private String ma;
    @Column(name = "Ten")
    private String ten;
    @OneToMany(mappedBy = "dongSP", targetEntity = ChiTietSP.class)
    private List<ChiTietSP> listChiTietSP;
}
