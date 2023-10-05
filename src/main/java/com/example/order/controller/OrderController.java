package com.example.order.controller;

import com.example.order.converter.OrderConverter;
import com.example.order.dto.OrderDTO;
import com.example.order.entity.Order;
import com.example.order.exception.ErrorResponse;
import com.example.order.service.OrderService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Slf4j
@RestController
@Tag(name = "Order", description = "Manage orders")
@RequestMapping(value = "/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;
    private final OrderConverter converter;

    @GetMapping
    @Operation(summary = "consultar lista de ordenes")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {
                    @Content(schema = @Schema(implementation = OrderDTO.class), mediaType = "application/json")
            }),
            @ApiResponse(responseCode = "500", content = {
                    @Content(schema = @Schema(implementation = ErrorResponse.class), mediaType = "application/json")
            }),
            @ApiResponse(responseCode = "404", content = {
                    @Content(schema = @Schema(implementation = ErrorResponse.class), mediaType = "application/json")
            })
    })
    public List<OrderDTO> listOrder() {
        return converter.fromEntity(orderService.findAll());
    }

    @PostMapping
    @Operation(summary = "guardar order")
    public OrderDTO save(@RequestBody OrderDTO order){

        Order newOrder = converter.fromDTO(order);
        return converter.fromEntity(orderService.save(newOrder));

    }

    @GetMapping("/hello")
    public String welcome(){
        return "Welcome Spring Security";
    }

}
