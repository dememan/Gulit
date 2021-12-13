package edu.miu.gulit.gulit.service;

import edu.miu.gulit.gulit.domain.UserAddress;
import edu.miu.gulit.gulit.repository.UserAddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserAddressServiceImpl implements UserAddressService{
    @Autowired
    UserAddressRepository userAddressRepository;

    @Override
    public List<UserAddress> getAddresses() {
        return userAddressRepository.findAll();
    }

    @Override
    public UserAddress saveAddress(UserAddress address) {
        return userAddressRepository.save(address);
    }

    @Override
    public UserAddress updateAddress(UserAddress address, int id) {
        address.setId(id);
        return userAddressRepository.save(address);
    }

    @Override
    public void deleteAddressById(int id) {
        userAddressRepository.deleteById(id);
    }
}
