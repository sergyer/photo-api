package com.project.mongo.entity;

import com.mongodb.DBObject;
import lombok.*;

import java.io.InputStream;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode(exclude = {"tags","photoUrl"})
public class Photo {

    private String id;
    private String userId;
    private String title;
    private String[] tags;
    private String photoUrl;
    private boolean isPrivate;
    private InputStream content;
    private DBObject metaData;


 }
