package com.kshrd.krorya.convert;

import com.kshrd.krorya.model.dto.FollowDTO;
import com.kshrd.krorya.model.entity.Follow;
import com.kshrd.krorya.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class FollowDTOConvertor {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public FollowDTO convertFollowToFollowerDTO(Follow follow) {
        return modelMapper.map(follow, FollowDTO.class);
    }
}
