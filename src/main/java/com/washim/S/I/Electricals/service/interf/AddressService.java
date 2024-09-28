package com.washim.S.I.Electricals.service.interf;

import com.washim.S.I.Electricals.dto.AddressDto;
import com.washim.S.I.Electricals.dto.Response;

public interface AddressService {
    Response saveandUpdateAddress(AddressDto addressDto);
}
