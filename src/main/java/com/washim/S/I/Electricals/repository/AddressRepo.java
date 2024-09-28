package com.washim.S.I.Electricals.repository;

import com.washim.S.I.Electricals.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepo extends JpaRepository<Address, Long> {
}