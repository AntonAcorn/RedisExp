package ru.acorn.redisexp.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldNameConstants;

@Data
@EqualsAndHashCode
@FieldNameConstants
@NoArgsConstructor
public class Movie {
    @EqualsAndHashCode.Exclude
    private String id;
    private String title;
}
