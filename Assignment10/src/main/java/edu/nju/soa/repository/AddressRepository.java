package edu.nju.soa.repository;

import edu.nju.soa.entity.AddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by cuihao on 2017-06-13.
 * Address entity repo definition
 */
public interface AddressRepository extends JpaRepository<AddressEntity,Integer>{
    AddressEntity findByCountryAndProvinceAndDistrictAndBlockAndNumber(String country, String province, String district, String block, String number);
}
