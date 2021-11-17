package com.tcc.mobileAdapter.mobileAdapter.controller.domain.request;

import lombok.Data;

import java.util.List;

@Data
public class RemoveStockRequest {
    List<RemoveStockItemRequest> items;
}
