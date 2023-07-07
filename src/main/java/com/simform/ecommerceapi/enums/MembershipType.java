package com.simform.ecommerceapi.enums;

import lombok.Getter;

@Getter
public enum MembershipType {
    FREE("Free"), PREMIUM("Premium"), GOLD("Gold");


    String membership;

    MembershipType(String membership) {
        this.membership = membership;
    }

}
