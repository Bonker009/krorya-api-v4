package com.kshrd.krorya.repository;

import com.kshrd.krorya.model.entity.Address;
import com.kshrd.krorya.model.request.AddressRequest;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.UUID;

@Mapper
public interface AddressRepository {

    @Select("""
    INSERT INTO addresses (buyer_id, phone_number, buyer_latitude, buyer_longitude) 
    VALUES (#{userId}, #{address.phoneNumber}, #{address.buyerLatitude}, #{address.buyerLongitude})
    RETURNING *;
    """)
    @Results(id = "addressMapping", value = {
            @Result(property = "addressId", column = "address_id"),
            @Result(property = "phoneNumber", column = "phone_number"),
            @Result(property = "buyerLatitude", column = "buyer_latitude"),
            @Result(property = "buyerLongitude", column = "buyer_longitude"),
            @Result(property = "buyerName", column = "buyer_id",
                one = @One(select = "getUserNameByUserId"))
    })
    Address insertAddress(@Param("address") AddressRequest addressRequest, @Param("userId") UUID userId);

    @Select("""
    SELECT username FROM users WHERE user_id = #{userId}
    """)
    String getUserNameByUserId(UUID userId);

    @Select("""
    SELECT * FROM addresses WHERE buyer_id = #{userId}
    """)
    @ResultMap("addressMapping")
    List<Address> getAllAddressesByUserId(@Param("userId") UUID userId);

    @Select("""
    SELECT * FROM addresses WHERE buyer_id = #{userId} AND address_id = #{addressId}
    """)
    @ResultMap("addressMapping")
    Address getAddressByAddressId(UUID addressId, @Param("userId") UUID userId);


    @Select("""
    UPDATE addresses
    SET phone_number = #{address.phoneNumber},
        buyer_latitude = #{address.buyerLatitude},
        buyer_longitude = #{address.buyerLongitude}
    WHERE buyer_id = #{userId} AND address_id = #{addressId}
    RETURNING *
    """)
    @ResultMap("addressMapping")
    Address updateAddressByAddressId(@Param("address") AddressRequest addressRequest, UUID addressId, @Param("userId") UUID userId);

    @Select("""
    DELETE FROM addresses WHERE buyer_id = #{userId} AND address_id = #{addressId}
    """)
    @ResultMap("addressMapping")
    Address deleteAddressByAddressId(UUID addressId, UUID userId);

}

