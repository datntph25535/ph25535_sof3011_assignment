package com.poly.ph25535_sof3011_assignment.repository;

import com.poly.ph25535_sof3011_assignment.entity.SanPham;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SanPhamRepository extends JpaRepository<SanPham, UUID> {
}
