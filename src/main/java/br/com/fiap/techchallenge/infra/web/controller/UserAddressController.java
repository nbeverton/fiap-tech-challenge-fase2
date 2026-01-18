package br.com.fiap.techchallenge.infra.web.controller;

import br.com.fiap.techchallenge.core.domain.model.UserAddress;
import br.com.fiap.techchallenge.core.usecase.in.useraddress.CreateUserAddressUseCase;
import br.com.fiap.techchallenge.core.usecase.in.useraddress.DeleteUserAddressUseCase;
import br.com.fiap.techchallenge.core.usecase.in.useraddress.FindAllUserAddressUseCase;
import br.com.fiap.techchallenge.core.usecase.in.useraddress.UpdateUserAddressUseCase;
import br.com.fiap.techchallenge.infra.web.dto.useraddress.CreateUserAddressRequest;
import br.com.fiap.techchallenge.infra.web.dto.useraddress.UpdateUserAddressRequest;
import br.com.fiap.techchallenge.infra.web.dto.useraddress.UserAddressResponse;
import br.com.fiap.techchallenge.infra.web.mapper.useraddress.UpdateUserAddressDtoMapper;
import br.com.fiap.techchallenge.infra.web.mapper.useraddress.UserAddressDtoMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user-addresses")
public class UserAddressController {

    private final CreateUserAddressUseCase createUserAddressUseCase;
    private final DeleteUserAddressUseCase deleteUserAddressUseCase;
    private final UpdateUserAddressUseCase updateUserAddressUseCase;
    private final FindAllUserAddressUseCase findAllUserAddressUseCase;

    public UserAddressController(
            CreateUserAddressUseCase createUserAddressUseCase,
            DeleteUserAddressUseCase deleteUserAddressUseCase,
            UpdateUserAddressUseCase updateUserAddressUseCase, FindAllUserAddressUseCase findAllUserAddressUseCase
    ) {
        this.createUserAddressUseCase = createUserAddressUseCase;
        this.deleteUserAddressUseCase = deleteUserAddressUseCase;
        this.updateUserAddressUseCase = updateUserAddressUseCase;
        this.findAllUserAddressUseCase = findAllUserAddressUseCase;
    }

    @Operation(summary = "Create link between User and Restaurant")
    @ApiResponse(responseCode = "201", description = "Link created successfully")
    @PostMapping
    public ResponseEntity<UserAddressResponse> create(
            @RequestBody CreateUserAddressRequest request
    ){

        UserAddress domain =
                UserAddressDtoMapper.toDomain(request);

        UserAddress created =
                createUserAddressUseCase.execute(domain);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(UserAddressDtoMapper.toResponse(created));
    }

    @Operation(summary = "Delete link between User and Restaurant")
    @ApiResponse(responseCode = "204", description = "Link deleted successfully")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable String id){

        deleteUserAddressUseCase.execute(id);
    }

    @Operation(summary = "Update link between User and Restaurant")
    @ApiResponse(responseCode = "200", description = "Link updated successfully")
    @PutMapping("/{id}")
    public ResponseEntity<UserAddressResponse> update(
            @PathVariable String id,
            @RequestBody UpdateUserAddressRequest request
    ){

        UserAddress update =
                updateUserAddressUseCase.execute(
                        id,
                        UpdateUserAddressDtoMapper.toAddressType(request),
                        UpdateUserAddressDtoMapper.toLabel(request),
                        UpdateUserAddressDtoMapper.toPrincipal(request)
                );

        return ResponseEntity.ok(
                UserAddressDtoMapper.toResponse(update)
        );
    }

    @Operation(summary = "Show all links between User and Restaurant")
    @ApiResponse(responseCode = "200")
    @GetMapping
    public ResponseEntity<List<UserAddressResponse>> findAll(){

        List<UserAddressResponse> usersAddresses = findAllUserAddressUseCase.execute()
                .stream()
                .map(UserAddressDtoMapper::toResponse)
                .toList();

        return ResponseEntity.ok(usersAddresses);
    }
}
