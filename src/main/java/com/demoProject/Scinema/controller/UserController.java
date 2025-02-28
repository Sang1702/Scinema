package com.demoProject.Scinema.controller;


import com.demoProject.Scinema.dto.reponse.UserResponse;
import com.demoProject.Scinema.dto.request.ApiResponse;
import com.demoProject.Scinema.dto.request.UserCreationRequest;
import com.demoProject.Scinema.dto.request.UserUpdateRequest;
import com.demoProject.Scinema.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Tag(name = "User Controller")
public class UserController
{
    UserService userService;

    @PostMapping
    @Operation(summary = "Tạo mới người dùng", description = "Tạo một người dùng mới")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "201", description = "Người dùng được tạo thành công")
    })
    ApiResponse<UserResponse> createUser(@RequestBody @Valid UserCreationRequest request)
    {
        return ApiResponse.<UserResponse>builder()
                .result(userService.createUser(request))
                .build();
    }

    @GetMapping
    @Operation(summary = "Lấy ra danh sách người dùng", description = "Trả về 1 danh sách của tất cả các người dùng")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Danh sách người dùng"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "404", description = "Chưa có người dùng nào được tạo ra")
    })
    ApiResponse<List<UserResponse>> getUsers()
    {
        var authentication =  SecurityContextHolder.getContext().getAuthentication();

        log.info("Username : {}", authentication.getName());
        authentication.getAuthorities().forEach(
                grantedAuthority -> log.info(grantedAuthority.getAuthority()));

        return ApiResponse.<List<UserResponse>>builder()
                .result(userService.getUsers())
                .build();
    }

    @GetMapping("/{userId}")
    @Operation(summary = "Lấy thông tin người dùng theo ID", description = "Trả về thông tin của người dùng dựa trên ID")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Thông tin người dùng"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "404", description = "Không tìm thấy người dùng")
    })
    ApiResponse<UserResponse> getUser(@PathVariable("userId") String userId)
    {
        return ApiResponse.<UserResponse>builder()
                .result(userService.getUser(userId))
                .build();
    }

    @GetMapping("/myInfo")
    @Operation(summary = "Lấy thông tin của bản thân", description = "Trả về thông tin của bản thân")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Thông tin của bản thân"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "404", description = "Không tìm thấy thông tin của bạn")
    })
    ApiResponse<UserResponse> getMyInfo()
    {
        return ApiResponse.<UserResponse>builder()
                .result(userService.getMyInfo())
                .build();
    }

    @PutMapping("{userId}")
    ApiResponse<UserResponse> updateUser(@PathVariable String userId, @RequestBody UserUpdateRequest request)
    {
        return ApiResponse.<UserResponse>builder()
                .result(userService.updateUser(userId, request))
                .build();
    }


    @DeleteMapping("{userId}")
    String deleteUser(@PathVariable String userId)
    {
        userService.deleteUser(userId);
        return "User deleted";
    }

}
