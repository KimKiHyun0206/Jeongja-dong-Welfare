package suwon.jeongja.welfare.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import suwon.jeongja.welfare.dto.request.UserRegisterRequest;
import suwon.jeongja.welfare.dto.request.UserUpdateRequest;
import suwon.jeongja.welfare.dto.response.UserResponse;
import suwon.jeongja.welfare.entity.User;
import suwon.jeongja.welfare.excpetion.UserException;
import suwon.jeongja.welfare.repository.UserRepository;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public UserResponse register(UserRegisterRequest request){
        User user = new User(
                request.getName(),
                request.getGender(),
                request.getAge()
        );

        User savedUser = userRepository.save(user);

        return UserResponse.from(savedUser);
    }

    @Transactional
    public UserResponse get(Long id){
        User user = userRepository.findById(id).get();

        return UserResponse.from(user);
    }

    @Transactional(readOnly = true)
    public Page<UserResponse> getAll(Pageable pageable) {
        return userRepository.findAll(pageable)
                .map(UserResponse::from);
    }

    @Transactional
    public UserResponse update(Long id, UserUpdateRequest request){
        User user = userRepository.findById(id).orElseThrow(UserException::new);

        user.update(request.getName(), request.getGender(), request.getAge());

        log.info("[ Info ] User 에 대한 모든 데이터를 Update 했습니다 {}", user.getId());

        return  UserResponse.from(user);
    }

    @Transactional
    public void delete(Long id){
        if (userRepository.existsById(id)){
            userRepository.deleteById(id);
            log.info("[ Info ] User 정보를 삭제했습니다 {}", id);
        }
    }
}
