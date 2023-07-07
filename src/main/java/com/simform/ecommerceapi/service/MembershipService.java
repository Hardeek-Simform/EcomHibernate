package com.simform.ecommerceapi.service;

import com.simform.ecommerceapi.entity.Membership;
import com.simform.ecommerceapi.repository.MembershipRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MembershipService {

    @Autowired
    private MembershipRepo membershipRepo;


    public List<Membership> getAllMembership() {
        Optional<List<Membership>> allMembership = Optional.of(membershipRepo.findAll());
        if (allMembership.isPresent()) {
            return allMembership.get();
        } else {
            throw new RuntimeException("All membership List is empty");
        }
    }

    public Membership getMembershipById(int id) {
        Optional<Membership> membership = membershipRepo.findById(id);
        if (membership.isPresent()) {
            return membership.get();
        } else {
            throw new RuntimeException("Membership id is invalid");
        }
    }

    public Membership updateMembership(Membership membership, int id) {
        Optional<Membership> membershipById = membershipRepo.findById(id);
        if (membershipById.isPresent()) {
            Membership existingMembership = membershipById.get();
            existingMembership.setMembershipType(membership.getMembershipType());
            existingMembership.setExpiry(membership.getExpiry());
        }
        return membershipRepo.save(membership);
    }
}
