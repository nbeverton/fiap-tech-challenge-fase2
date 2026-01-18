package br.com.fiap.techchallenge.infra.web.controller;

import br.com.fiap.techchallenge.core.domain.model.Address;
import br.com.fiap.techchallenge.core.usecase.in.address.*;
import br.com.fiap.techchallenge.infra.web.dto.address.AddressResponse;
import br.com.fiap.techchallenge.infra.web.dto.address.CreateAddressRequest;
import br.com.fiap.techchallenge.infra.web.dto.address.UpdateAddressRequest;
import br.com.fiap.techchallenge.infra.web.mapper.address.AddressDtoMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/addresses")
public class AddressController {

    private final CreateAddressUseCase createAddressUseCase;
    private final UpdateAddressUseCase updateAddressUseCase;
    private final DeleteAddressUseCase deleteAddressUseCase;
    private final FindAddressByIdUseCase findAddressByIdUseCase;
    private final FindAllAddressUseCase findAllAddressUseCase;


    public AddressController(
            CreateAddressUseCase createAddressUseCase,
            UpdateAddressUseCase updateAddressUseCase,
            DeleteAddressUseCase deleteAddressUseCase,
            FindAddressByIdUseCase findAddressByIdUseCase,
            FindAllAddressUseCase findAllAddressUseCase) {

        this.createAddressUseCase = createAddressUseCase;
        this.updateAddressUseCase = updateAddressUseCase;
        this.deleteAddressUseCase = deleteAddressUseCase;
        this.findAddressByIdUseCase = findAddressByIdUseCase;
        this.findAllAddressUseCase = findAllAddressUseCase;
    }

    @Operation(summary = "Create Address")
    @ApiResponse(responseCode = "201", description = "Address created successfully")
    @PostMapping
    public ResponseEntity<AddressResponse> create(@RequestBody CreateAddressRequest input){

        Address address = createAddressUseCase.execute(AddressDtoMapper.toDomain(input));

        return ResponseEntity.status(201).body(AddressDtoMapper.toResponse(address));
    }

    @Operation(summary = "Edit Address")
    @ApiResponse(responseCode = "200", description = "Address edited successfully")
    @PutMapping("/{id}")
    public ResponseEntity<AddressResponse> update(
            @PathVariable String id,
            @RequestBody UpdateAddressRequest input){

        Address addressToUpdate = updateAddressUseCase.execute(
                id,
                AddressDtoMapper.toDomain(input)
        );

        return ResponseEntity.ok(AddressDtoMapper.toResponse(addressToUpdate));
    }

    @Operation(summary = "Delete Address")
    @ApiResponse(responseCode = "204", description = "Address deleted successfully")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id){

        deleteAddressUseCase.execute(id);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Get Address with specific id")
    @ApiResponse(responseCode = "200")
    @GetMapping("/{id}")
    public ResponseEntity<AddressResponse> findById(@PathVariable String id){

        Address address = findAddressByIdUseCase.execute(id);

        return ResponseEntity.ok(AddressDtoMapper.toResponse(address));
    }


    @Operation(summary = "Show all Address created")
    @ApiResponse(responseCode = "200")
    @GetMapping
    public ResponseEntity<List<AddressResponse>> findAll(){

        List<AddressResponse> addresses = findAllAddressUseCase.execute()
                .stream()
                .map(AddressDtoMapper::toResponse)
                .toList();

        return ResponseEntity.ok(addresses);
    }

}
