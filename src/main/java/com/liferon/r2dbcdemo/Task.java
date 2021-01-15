package com.liferon.r2dbcdemo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.lang.NonNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table("tasks")
public class Task {
    @Id
    private Integer id;
    @NonNull
    private String description;
    private boolean completed;
}
