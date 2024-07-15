package com.example.fastfood_cart.utils;


public class ImageUtils {

    public static String convertHexToBase64(String hexString) {
        byte[] bytes = javax.xml.bind.DatatypeConverter.parseHexBinary(hexString);
        return org.apache.commons.codec.binary.Base64.encodeBase64String(bytes);
    }
}
