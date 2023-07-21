package com.poly.ph25535_sof3011_assignment.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString(exclude = {"listChiTietSP"})
@Builder
@Entity
@Table(name = "ChiTietSP")
public class ChiTietSP {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "Id")
    private UUID id;
    @ManyToOne
    @JoinColumn(name = "IdSP")
    private SanPham sanPham;
    @ManyToOne
    @JoinColumn(name = "IdNsx")
    private NSX nsx;
    @ManyToOne
    @JoinColumn(name = "IdMauSac")
    private MauSac mauSac;
    @ManyToOne
    @JoinColumn(name = "IdDongSP")
    private DongSP dongSP;
    @Column(name = "NamBH")
    private int namBH;
    @Column(name = "moTa")
    private String moTa;
    @Column(name = "SoLuongTon")
    private int soLuongTon;
    @Column(name = "GiaNhap")
    private double giaNhap;
    @Column(name = "GiaBan")
    private double giaBan;
}
