package com.poly.ph25535_sof3011_assignment.repository;

import com.poly.ph25535_sof3011_assignment.entity.CuaHang;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CuaHangRepository extends JpaRepository<CuaHang, UUID> {
}
