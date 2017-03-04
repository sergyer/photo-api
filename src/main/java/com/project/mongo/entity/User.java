package com.project.mongo.entity;

import lombok.*;
import org.springframework.data.annotation.Id;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(exclude = {"image","imageUrl"})
public class User {
    
    @Id
    private Long id;
    private String imageUrl;
    private String name;
    private String username;
    private byte[] image;




}
