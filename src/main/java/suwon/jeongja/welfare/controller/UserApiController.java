package suwon.jeongja.welfare.controller;

import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import suwon.jeongja.welfare.common.dto.PageDto;
import suwon.jeongja.welfare.common.dto.ResponseDto;
import suwon.jeongja.welfare.dto.request.UserRegisterRequest;
import suwon.jeongja.welfare.dto.request.UserUpdateRequest;
import suwon.jeongja.welfare.service.UserService;

@RestController
@RequestMapping(value = "/api/user", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class UserApiController {

    private final UserService userService;

    @ApiOperation(value = "User 등록하기")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> register(@RequestBody UserRegisterRequest request) {
        var response = userService.register(request);
        return ResponseDto.created(response);
    }

    @ApiOperation(value = "USer 단건 조회하기")
    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable Long id) {
        var response = userService.get(id);
        return ResponseDto.ok(response);
    }

    @ApiOperation(value = "User 전체 조회하기")
    @GetMapping
    public ResponseEntity<?> getAll(
            @PageableDefault(sort = "createdAt", direction = Sort.Direction.DESC) Pageable pageable
    ) {
        var response = userService.getAll(pageable);
        return PageDto.ok(response);
    }

    @ApiOperation(value = "User 수정하기")
    @PutMapping("/{id}") // @PatchMapping
    public ResponseEntity<?> update(
            @PathVariable Long id,
            @RequestBody UserUpdateRequest request
    ) {
        var response = userService.update(id, request);
        return ResponseDto.ok(response);
    }

    @ApiOperation(value = "User 삭제하기")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(
            @PathVariable Long id
    ) {
        userService.delete(id);
        return ResponseDto.noContent();
    }
}
