package com.simform.ecommerceapi.controller;

import com.simform.ecommerceapi.entity.Membership;
import com.simform.ecommerceapi.service.MembershipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/membership")
public class MembershipController {
    @Autowired
    MembershipService membershipService;

    @GetMapping
    public ResponseEntity<List<Membership>> getAllMembership() {
        List<Membership> allMembership = membershipService.getAllMembership();
        return new ResponseEntity<>(allMembership, HttpStatus.FOUND);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Membership> getMembershipById(@PathVariable int id) {
        Membership membershipById = membershipService.getMembershipById(id);
        return new ResponseEntity<>(membershipById, HttpStatus.FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Membership> updateMembership(@RequestBody Membership membership, @PathVariable int id) {
        Membership updatedMembership = membershipService.updateMembership(membership, id);
        return new ResponseEntity<>(updatedMembership, HttpStatus.ACCEPTED);
    }

}
