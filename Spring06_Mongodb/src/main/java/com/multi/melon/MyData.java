package com.multi.melon;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class MyData {
    private String display1;
    private String display2;
    private int x;
    private int y;
    private String createdAt;
    private String updatedAt;
}