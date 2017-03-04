package com.project.mongo.resource;

import com.mongodb.gridfs.GridFSDBFile;
import com.project.mongo.services.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;


@RestController
@RequestMapping(value = "/api")
@Produces(MediaType.APPLICATION_JSON_VALUE + ";charset=utf-8")
public class PhotoResource {

    @Autowired
    private PhotoService photoService;

    @RequestMapping(value = "/photos",method = RequestMethod.POST)
    public Response savePhoto(@RequestParam MultipartFile file,@RequestParam String userId) {

        photoService.save(file,userId);

        return Response.ok().build();
    }


    @RequestMapping(value = "/{photoId}",method = RequestMethod.GET,produces = "image/jpg")
    public @ResponseBody byte[] getPhoto(@PathVariable("photoId") String id) {

        ByteArrayOutputStream bao = new ByteArrayOutputStream();
        try {

            GridFSDBFile created = photoService.getPhoto(id);
            InputStream inputStream = created.getInputStream();

            BufferedImage img = ImageIO.read(inputStream);



            ImageIO.write(img, "jpg", bao);



        } catch (Exception e) {
            e.printStackTrace();
        }

        return bao.toByteArray();



    }
    @RequestMapping(value = "/{photoId}",method = RequestMethod.DELETE)
    public Response deletePhoto(@PathVariable("photoId") String id) {

        photoService.delete(id);
        return Response.noContent().build();
    }



}
