package com.keranjangkita.controller;

import com.keranjangkita.model.Address;
import com.keranjangkita.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/shipping/")
public class ShippingAddressController {

    @Autowired
    private AddressService addressService;

    @PostMapping("search")
    public ResponseEntity<List<Address>> searchBy(@RequestBody Map<String, Object> request) {
        HttpStatus httpStatus;

        List<Address> addresses = new ArrayList<>();
        try {
            List<String> searchByArr = (List<String>) request.get("searchByArr");
            List<Object> keywordArr = (List<Object>) request.get("keywordArr");
            String orderBy = (String) request.get("orderBy");
            String orderType = (String) request.get("orderType");

            addresses = addressService.getSearchBy(searchByArr, keywordArr, orderBy, orderType);
            httpStatus = HttpStatus.OK;

        } catch (Exception e) {
            e.printStackTrace();
            httpStatus = HttpStatus.EXPECTATION_FAILED;
        }

        return new ResponseEntity<>(addresses, httpStatus);
    }

    @PostMapping("save_update")
    public ResponseEntity<String> saveUpdate(@RequestBody Address address) {
        HttpStatus httpStatus;

        String response;
        try {
            addressService.saveOrUpdate(address);
            response = "Success";
            httpStatus = HttpStatus.OK;
        } catch (Exception e) {
            e.printStackTrace();
            response = e.getMessage();
            httpStatus = HttpStatus.EXPECTATION_FAILED;
        }

        return new ResponseEntity<>(response, httpStatus);
    }
}
