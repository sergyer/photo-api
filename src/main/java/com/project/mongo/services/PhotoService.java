package com.project.mongo.services;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.gridfs.GridFSDBFile;
import com.project.mongo.entity.Photo;
import com.project.mongo.repository.PhotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


@Service
public class PhotoService {

    @Autowired
    PhotoRepository repository;


    public void save(MultipartFile file, String userId) {
        Photo photo = new Photo();
        try {
            photo.setContent(file.getInputStream());
            DBObject metaData = new BasicDBObject();
            photo.setMetaData(metaData);
            metaData.put("userId", userId);
            repository.savePhoto(photo);

        } catch (IOException e) {
            e.printStackTrace();
        }


    }


    public GridFSDBFile getPhoto(String id) {
        return repository.getPhotoById(id);
    }


    public void delete(String id) {
        repository.deletePhoto(id);
    }

   /* public Photo update(Photo photo,String id) {
        repository
        Photo existingPhoto = repository.findOne(id);
        BeanUtils.copyProperties(photo,existingPhoto);
        return repository.save(existingPhoto);
    }*/
}
