package com.web.order.form;

public record OrderRequest(
          Long memberId
        , Long itemId
        , int count
) {}
