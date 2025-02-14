package com.example.subscription_alertas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.subscription_alertas.model.VitalSigns;

@Repository
public interface VitalSignsRepository extends JpaRepository<VitalSigns, Long> {
}