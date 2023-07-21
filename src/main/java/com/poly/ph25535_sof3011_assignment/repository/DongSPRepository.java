package com.poly.ph25535_sof3011_assignment.repository;

import com.poly.ph25535_sof3011_assignment.entity.DongSP;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DongSPRepository extends JpaRepository<DongSP, UUID> {
}
