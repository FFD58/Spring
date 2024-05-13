package ru.fafurin.orderservice.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;
import ru.fafurin.orderservice.dto.InventoryResponse;
import ru.fafurin.orderservice.dto.OrderLineItemDto;
import ru.fafurin.orderservice.dto.OrderRequest;
import ru.fafurin.orderservice.model.Order;
import ru.fafurin.orderservice.model.OrderLineItem;
import ru.fafurin.orderservice.repository.OrderRepository;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class OrderService {

    private final OrderRepository orderRepository;
    private final WebClient.Builder webClientBuilder;

    public String placeOrder(OrderRequest orderRequest) {
        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());

        List<OrderLineItem> orderLineItems = orderRequest.getOrderLineItemDtoList()
                .stream()
                .map(this::mapToDto)
                .toList();

        order.setOrderLineItemList(orderLineItems);

        List<String> skuCodes = order.getOrderLineItemList().stream()
                .map(OrderLineItem::getSkuCode)
                .toList();

        System.out.println("Order skuCodes: " + skuCodes);

        // Call Inventory Service, and place order if product is in
        // stock
        InventoryResponse[] inventoryResponsArray = webClientBuilder.build().get()
                .uri("http://inventory-service/api/inventory",
                        uriBuilder -> uriBuilder.queryParam("skuCode", skuCodes).build())
                .retrieve()
                .bodyToMono(InventoryResponse[].class)
                .block();

        System.out.println(Arrays.toString(inventoryResponsArray));

        boolean allProductsInStock = Arrays.stream(inventoryResponsArray)
                .allMatch(InventoryResponse::isInStock);

        System.out.println("bool" + allProductsInStock);

        if (allProductsInStock && inventoryResponsArray.length > 0){
            orderRepository.save(order);
            log.info("Order with number {} placed", order.getOrderNumber());
            return "Order placed";
        } else {
            return "Product is not in stock, please try again later";
        }
    }

    private OrderLineItem mapToDto(OrderLineItemDto orderLineItemsDto) {
        OrderLineItem orderLineItems = new OrderLineItem();
        orderLineItems.setPrice(orderLineItemsDto.getPrice());
        orderLineItems.setQuantity(orderLineItemsDto.getQuantity());
        orderLineItems.setSkuCode(orderLineItemsDto.getSkuCode());
        return orderLineItems;
    }
}
