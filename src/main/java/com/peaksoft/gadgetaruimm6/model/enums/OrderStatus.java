package com.peaksoft.gadgetaruimm6.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
public enum OrderStatus {

     WAIT("заказ ожидает обработки администратором или модератором"),

     IN_PROCESS("заказ в процессе доставки"),

     DONE("заказ успешно выполнен"),
    CREATED("cоздано"),
    CONFIRMED("подтвреждено"),
    SHIPPED("отправлено"),
    CANCELLED("отменено"),
    REFUNDED("возвращено");


     String name;

    OrderStatus(String name) { this.name = name; }
}
