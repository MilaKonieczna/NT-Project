package com.example.nt_l2.service;

import com.example.nt_l2.controller.dto.user.CreateUserDto;
import com.example.nt_l2.controller.dto.user.CreateUserResponseDto;
import com.example.nt_l2.controller.dto.user.GetUserDto;
import com.example.nt_l2.infrastucture.entity.UserEntity;
import com.example.nt_l2.infrastucture.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<GetUserDto> getAll(){
        var users =  userRepository.findAll();
        return  users.stream().map((user) -> new GetUserDto(user.getId(), user.getUsername(), user.getPassword(), user.getRole(), user.getEmail(), user.getName())).collect(Collectors.toList());
    }
    public GetUserDto getOne(long id){
        var user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        return new GetUserDto(user.getId(), user.getUsername(), user.getPassword(), user.getRole(), user.getEmail(), user.getName());
    }
    public CreateUserResponseDto create(CreateUserDto user){
        var userEntity = new UserEntity();
        userEntity.setUsername(user.getUsername());
        userEntity.setPassword(user.getPassword());
        userEntity.setRole(user.getRole());
        userEntity.setEmail(user.getEmail());
        userEntity.setName(user.getName());
        var newUser = userRepository.save(userEntity);
        return new CreateUserResponseDto(newUser.getId(), newUser.getUsername(), newUser.getPassword(), newUser.getRole(), newUser.getEmail(), newUser.getName());
    }
    public void delete(long id){
        if(!userRepository.existsById(id)){
            throw new RuntimeException();
        }
        userRepository.deleteById(id);    }

}
