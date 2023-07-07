package com.simform.ecommerceapi.repository;

import com.simform.ecommerceapi.entity.Membership;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MembershipRepo extends JpaRepository<Membership, Integer> {
}
