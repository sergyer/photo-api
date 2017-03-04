package com.project.mongo.repository;

import com.mongodb.gridfs.GridFSDBFile;
import com.project.mongo.entity.Photo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.stereotype.Repository;

/**
 * Created by admin on 3/4/17.
 */
@Repository
public class PhotoRepository {


    @Autowired
    private GridFsTemplate gridFsTemplate;


    public void savePhoto(Photo photo) {
        gridFsTemplate.store(photo.getContent(), photo.getMetaData());

    }

    public GridFSDBFile getPhotoById(String id) {
        GridFSDBFile fsdbFile = gridFsTemplate.findOne(new Query(Criteria.where("_id").is(id)));


        return fsdbFile;

    }

    public void deletePhoto(String id) {
        gridFsTemplate.delete(new Query(Criteria.where("_id").is(id)));
    }




}
