package com.demoProject.Scinema.controller;


import com.demoProject.Scinema.dto.reponse.RoleReponse;
import com.demoProject.Scinema.dto.request.ApiResponse;
import com.demoProject.Scinema.dto.request.RoleRequest;
import com.demoProject.Scinema.service.RoleService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/roles")
@RequiredArgsConstructor
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class RoleController
{
    RoleService roleService;

    @PostMapping
    ApiResponse<RoleReponse> create(@RequestBody RoleRequest request)
    {
        return ApiResponse.<RoleReponse>builder()
                .result(roleService.create(request))
                .build();
    }

    @GetMapping
    ApiResponse<List<RoleReponse>> getAll()
    {
        return ApiResponse.<List<RoleReponse>>builder()
                .result(roleService.getAll())
                .build();
    }

    @DeleteMapping("/{role}")
    ApiResponse<Void> delete(@PathVariable String role)
    {
        roleService.delete(role);
        return ApiResponse.<Void>builder().build();
    }
}
