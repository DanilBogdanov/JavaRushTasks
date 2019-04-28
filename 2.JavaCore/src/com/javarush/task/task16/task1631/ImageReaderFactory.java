package com.javarush.task.task16.task1631;

import com.javarush.task.task16.task1631.common.*;

/**
 * Created by Данил on 06.08.2018.
 */
public class ImageReaderFactory {
    public static ImageReader getImageReader(ImageTypes imageTypes) throws IllegalArgumentException {
        /*switch (imageTypes) {
            case BMP:
                return new BmpReader();
            case JPG:
                return new JpgReader();
            case PNG:
                return new PngReader();
        }*/


        if (ImageTypes.BMP.equals(imageTypes)) {
            return new BmpReader();
        } else if (ImageTypes.JPG.equals(imageTypes)) {
            return new JpgReader();
        } else if (ImageTypes.PNG.equals(imageTypes)) {
            return new PngReader();
        } else {
            throw new IllegalArgumentException();
        }
        //IllegalArgumentException


    }

}
