package com.gashi.fitore.Todo.helper;

import com.gashi.fitore.Todo.model.TodoItem;
import com.gashi.fitore.Todo.model.User;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.http.*;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class HTTPClient {

    public HTTPClient() {
    }

    public static User loginWithCredentials(String email, String password) throws HttpServerErrorException {
        // request url
        String url = "http://localhost:8080/todo/user/login";

        // create an instance of RestTemplate
        RestTemplate restTemplate = new RestTemplate();

        // create headers
        HttpHeaders headers = new HttpHeaders();
        // set `content-type` header
        headers.setContentType(MediaType.APPLICATION_JSON);
        // set `accept` header
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

        // request body parameters
        Map<String, Object> map = new HashMap<>();
        map.put("email", email);
        map.put("password", password);
        map.put("passwordConfirm", password);

        // create a post object
        User post = new User(null, email, password, password);

        // build the request
        HttpEntity<User> request = new HttpEntity<>(post, headers);

        // send POST request
        ResponseEntity<User> response = restTemplate.postForEntity(url, request, User.class);

        // check response
        if (response.getStatusCode() == HttpStatus.OK) {
            System.out.println("Request Successful");
            System.out.println(response.getBody());
            return response.getBody();

        } else if (response.getStatusCode() == HttpStatus.BAD_REQUEST) {
            System.out.println("Request Failed");
            System.out.println(response.getStatusCode());
        } else if (response.getStatusCode() == HttpStatus.INTERNAL_SERVER_ERROR) {
            System.out.println("Request Failed");
            System.out.println(response.getStatusCode());
        } else {
            System.out.println("Request Failed");
            System.out.println(response.getStatusCode());
        }

        return new User();
    }

    public static User registerUserWithCredentials(String email, String password) throws HttpServerErrorException {
        // request url
        String url = "http://localhost:8080/todo/user";

        // create an instance of RestTemplate
        RestTemplate restTemplate = new RestTemplate();

        // create headers
        HttpHeaders headers = new HttpHeaders();
        // set `content-type` header
        headers.setContentType(MediaType.APPLICATION_JSON);
        // set `accept` header
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

        // request body parameters
        Map<String, Object> map = new HashMap<>();
        map.put("email", email);
        map.put("password", password);
        map.put("passwordConfirm", password);

        // create a post object
        User post = new User(null, email, password, password);

        // build the request
        HttpEntity<User> request = new HttpEntity<>(post, headers);

        // send POST request
        ResponseEntity<User> response = restTemplate.postForEntity(url, request, User.class);

        // check response
        if (response.getStatusCode() == HttpStatus.OK) {
            System.out.println("Request Successful");
            System.out.println(response.getBody());
            return response.getBody();

        } else if (response.getStatusCode() == HttpStatus.BAD_REQUEST) {
            System.out.println("Request Failed");
            System.out.println(response.getStatusCode());
        } else if (response.getStatusCode() == HttpStatus.INTERNAL_SERVER_ERROR) {
            System.out.println("Request Failed");
            System.out.println(response.getStatusCode());
        } else {
            System.out.println("Request Failed");
            System.out.println(response.getStatusCode());
        }

        return new User();
    }

    public static TodoItem[] getAllTodoItems(Long userId) {
        // request url
        String url = "http://localhost:8080/todo/" + userId.toString();

        // create an instance of RestTemplate
        RestTemplate restTemplate = new RestTemplate();

        // create headers
        HttpHeaders headers = new HttpHeaders();
        // set `content-type` header
        headers.setContentType(MediaType.APPLICATION_JSON);
        // set `accept` header
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

        // build the request
        HttpEntity<User> request = new HttpEntity<>(headers);
        ResponseEntity<TodoItem[]> response = restTemplate.getForEntity(url, TodoItem[].class);
        TodoItem[] todos = response.getBody();
        return todos;
    }

    public static TodoItem postTodoItem(TodoItem todoItem) {
        // request url
        String url = "http://localhost:8080/todo/";

        // create an instance of RestTemplate
        RestTemplate restTemplate = new RestTemplate();

        // create headers
        HttpHeaders headers = new HttpHeaders();
        // set `content-type` header
        headers.setContentType(MediaType.APPLICATION_JSON);
        // set `accept` header
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

        // request body parameters
        Map<String, Object> map = new HashMap<>();
        map.put("userId", todoItem.getUserId());
        map.put("title", todoItem.getTitle());
        map.put("isDone", todoItem.isDone());

        // build the request
        HttpEntity<TodoItem> request = new HttpEntity<>(todoItem, headers);

        // send POST request
        ResponseEntity<TodoItem> response = restTemplate.postForEntity(url, request, TodoItem.class);

        return response.getBody();
    }

    public static boolean editTodoItem(TodoItem todoItem) {
        // request url
        String url = "http://localhost:8080/todo/" + todoItem.getUserId();

        // create an instance of RestTemplate
        RestTemplate restTemplate = new RestTemplate();

        // create headers
        HttpHeaders headers = new HttpHeaders();
        // set `content-type` header
        headers.setContentType(MediaType.APPLICATION_JSON);
        // set `accept` header
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

        // request body parameters
        Map<String, Object> map = new HashMap<>();
        map.put("id", todoItem.getId());
        map.put("userId", todoItem.getUserId());
        map.put("title", todoItem.getTitle());
        map.put("isDone", todoItem.isDone());

        // build the request
        HttpEntity<TodoItem> request = new HttpEntity<>(todoItem, headers);

        // send POST request
        ResponseEntity<TodoItem> response = restTemplate.exchange(url, HttpMethod.PUT, request, TodoItem.class, map);;
        if (response.getStatusCode() == HttpStatus.OK) {
            return true;
        } else {
            return false;
        }
    }
}
