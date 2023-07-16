package com.example.MappingPractice.service;

import com.example.MappingPractice.model.Address;
import com.example.MappingPractice.repository.IAddressRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {
    @Autowired
    IAddressRepo addressRepo;

    public Iterable<Address> getAllAddress(){
        return addressRepo.findAll();
    }

    public void addAddress(Address address) {
        addressRepo.save(address);
    }

    public String updateAddress(Long addressId, String addressState) {

        if(addressRepo.existsById(addressId)){
            addressRepo.updateAddressState(addressState,addressId);
            return "Address is Updated";
        }
        else{
            return "Address Id does not exist";
        }
    }

    public String deleteAddress(Long addressId){
        if (addressRepo.existsById(addressId)){
            addressRepo.deleteAddress(addressId);
            return "Address is deleted";
        }
        else{
            return "Address Id does not exists";
        }
    }
}