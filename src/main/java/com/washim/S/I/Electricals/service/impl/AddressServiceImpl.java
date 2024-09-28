package com.washim.S.I.Electricals.service.impl;

import com.washim.S.I.Electricals.dto.AddressDto;
import com.washim.S.I.Electricals.dto.Response;
import com.washim.S.I.Electricals.entity.Address;
import com.washim.S.I.Electricals.entity.User;
import com.washim.S.I.Electricals.repository.AddressRepo;
import com.washim.S.I.Electricals.service.interf.AddressService;
import com.washim.S.I.Electricals.service.interf.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {

    private final AddressRepo addressRepo;
    private final UserService userService;


    @Override
    public Response saveandUpdateAddress(AddressDto addressDto) {
        User user = userService.getLoginUser();
        Address address = user.getAddress();

        if(address==null) {
            address = new Address();
            address.setUser(user);
        }
        if (addressDto.getStreet() != null) address.setStreet(addressDto.getStreet());
        if (addressDto.getCity() != null) address.setCity(addressDto.getCity());
        if (addressDto.getState() != null) address.setState(addressDto.getState());
        if (addressDto.getZipCode() != null) address.setZipCode(addressDto.getZipCode());
        if (addressDto.getCountry() != null) address.setCountry(addressDto.getCountry());

        addressRepo.save(address);

        String message = (user.getAddress()==null) ? "Address saved successfully" : "Address updated successfully";

        return Response.builder()
                .message(message)
                .status(200)
                .build();
    }
}
