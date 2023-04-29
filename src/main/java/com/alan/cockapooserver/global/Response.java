package com.alan.cockapooserver.global;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Response<T> {

    private Integer status;
    private T data;
    private String message;

    public static <T> Response<T> response(Integer status, T data, String message){
        return new Response<>(status, data, message);
    }

    public static <T> Response responseOK(){
        return new Response(200, "", "ok");
    }

    public static <T> Response responseCreated(){
        return new Response(201, "", "created");
    }

    public static <T> Response<T> responseOKWith(T data){
        return new Response<>(200, data, "ok");
    }
}
