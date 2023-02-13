package com.bridgelabz;

public enum CustomerType {
    RewardCustomer, RegularCustomer;
    public static CustomerType fromUser(String rawRequest) {
        if (rawRequest.contains(RewardCustomer.name())) {
            return RewardCustomer;
        }
        return RegularCustomer;
    }
}
