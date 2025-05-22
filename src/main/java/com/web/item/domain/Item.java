package com.web.item.domain;

import com.web.item.form.ItemRequest;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.Valid;
import java.util.Objects;
import java.util.function.Consumer;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Comment;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Item {
    @Id
    @Comment( "상품 번호")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long itemId;

    @Comment( "상품 이름")
    private String name;

    @Comment( "상품 가격")
    private int price;

    @Comment( "상품 수량")
    private int stockQuantity;

    @Comment( "상품 저자")
    private String author;

    @Comment( "상품 isbn")
    private String isbn;

    public static Item from(ItemRequest request) {
        return new Item(null, request.name(), request.price(), request.stockQuantity(), request.author(), request.isbn());
    }

    public void updateForm(ItemRequest request) {
        updateIfChanged(request.name(), this.name, v -> this.name = v);
        updateIfChanged(request.price(), this.price, v -> this.price = v);
        updateIfChanged(request.stockQuantity(), this.stockQuantity, v -> this.stockQuantity = v);
        updateIfChanged(request.author(), this.author, v -> this.author = v);
        updateIfChanged(request.isbn(), this.isbn, v -> this.isbn = v);
    }

    private <T> void updateIfChanged(T newValue, T oldValue, Consumer<T> consumer) {
        if (!Objects.equals(newValue, oldValue)) {
            consumer.accept(newValue);
        }
    }
}
