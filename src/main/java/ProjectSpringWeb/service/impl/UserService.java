package ProjectSpringWeb.service.impl;

import ProjectSpringWeb.model.*;
import ProjectSpringWeb.repository.UserJPARepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

        private static UserJPARepository UserJPARepository;

    public static List<User> getUsers() {
        return UserJPARepository.findAll()
                .stream()
                .map(User::toReturnUser)
                .toList();
    }

    public static User createUsers(UserCreateDto userreturnDto) {
        User user = UserCreateDto.toUser();
        return UserJPARepository.save(user)
                .toReturnUser();
    }
}

