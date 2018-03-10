package com.app.web;

import com.app.core.util.JWTUtil;
import org.junit.Test;

/**
 * @author Administrator
 * @version 1.0
 */
public class TestJWT {
    @Test
    public void parseJWT1() {
        System.out.println("=============================");
        String jwt = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ3akBnZ2RqIiwianRpIjoiMTZjZGFiYjktYTAxNC00Y2NlLThhNjEtYTI1N2JmNGZmNDQzIiwiaWF0IjoxNTIwMzMwODA0LCJleHAiOjE1MjAzMzE0MDR9.6IJ6J0f_HNi2OJi9N26exJ7pTeUCYIpW2S8TDXxOZRY";
        boolean flag = JWTUtil.checkJWT(jwt, "wj@ggdj");
        System.out.println(flag);
        System.out.println("=============================");
    }

    @Test
    public void parseJWT2() {
        System.out.println("=============================");
        String jwt = JWTUtil.buildJWT("wj@ggdj");
        System.out.println(jwt);

        boolean flag = JWTUtil.checkJWT(jwt, "wj@ggdj");
        System.out.println(flag);
        System.out.println("=============================");
    }
}