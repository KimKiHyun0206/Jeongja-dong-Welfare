package suwon.jeongja.welfare.controller.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import suwon.jeongja.welfare.common.dto.PageDto;
import suwon.jeongja.welfare.common.dto.ResponseDto;
import suwon.jeongja.welfare.dto.request.UserRegisterRequest;
import suwon.jeongja.welfare.dto.request.UserUpdateRequest;
import suwon.jeongja.welfare.service.UserService;

@RestController
@RequestMapping(value = "/api/user", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> register(@RequestBody UserRegisterRequest request) {
        var response = userService.register(request);
        return ResponseDto.created(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable Long id) {
        var response = userService.get(id);
        return ResponseDto.ok(response);
    }

    @GetMapping
    public ResponseEntity<?> getAll(
            @PageableDefault(sort = "createdAt", direction = Sort.Direction.DESC) Pageable pageable
    ) {
        var response = userService.getAll(pageable);
        return PageDto.ok(response);
    }

    @PutMapping("/{id}") // @PatchMapping
    public ResponseEntity<?> update(
            @PathVariable Long id,
            @RequestBody UserUpdateRequest request
    ) {
        var response = userService.update(id, request);
        return ResponseDto.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(
            @PathVariable Long id
    ) {
        userService.delete(id);
        return ResponseDto.noContent();
    }
}