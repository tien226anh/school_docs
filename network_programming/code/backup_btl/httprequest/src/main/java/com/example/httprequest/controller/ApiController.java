package com.example.httprequest.controller;

import com.example.httprequest.model.RequestData;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.client.methods.*;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "* ")
@RestController
@RequestMapping("/api")
public class ApiController {

  @GetMapping("/get")
  public ResponseEntity<String> sendGetRequest(@RequestParam String url) {
    try {
      CloseableHttpClient httpClient = HttpClients.createDefault();
      HttpGet httpGet = new HttpGet(url);
      CloseableHttpResponse response = httpClient.execute(httpGet);

      String responseBody = EntityUtils.toString(response.getEntity());

      httpClient.close();
      System.out.println(ResponseEntity.ok(responseBody));
      return ResponseEntity.ok(responseBody);
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
          .body("Error: " + e.getMessage());
    }
  }

  @PostMapping("/post")
  public ResponseEntity<String> sendPostRequest(@RequestBody String requestData){
    try {
      ObjectMapper objectMapper = new ObjectMapper();
      RequestData request = objectMapper.readValue(requestData, RequestData.class);

      CloseableHttpClient httpClient = HttpClients.createDefault();
      HttpPost httpPost = new HttpPost(request.getUrl());

      CloseableHttpResponse response = httpClient.execute(httpPost);

      String responseBody = EntityUtils.toString(response.getEntity());

      httpClient.close();

      return ResponseEntity.ok(responseBody);
    } catch (Exception e){
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
          .body("Error: " + e.getMessage());
    }
  }

  @PutMapping("/put")
  public ResponseEntity<String> sendPutRequest(@RequestBody String requestData){
    try {
      // Implement logic to send a PUT request to the specified URL
      // Extract the URL, headers, and request body from requestData
      // Example: use HttpClient to send a PUT request
      // Process the response and return it
      // This is a simplified example using Apache HttpClient

      ObjectMapper objectMapper = new ObjectMapper();
      RequestData request = objectMapper.readValue(requestData, RequestData.class);

      CloseableHttpClient httpClient = HttpClients.createDefault();
      HttpPut httpPut = new HttpPut(request.getUrl());

      // Set headers and request body
      // Example:
      // httpPut.addHeader("Content-Type", "application/json");
      // httpPut.setEntity(new StringEntity(request.getRequestBody));

      CloseableHttpResponse response = httpClient.execute(httpPut);

      // Process the response
      String responseBody = EntityUtils.toString(response.getEntity());

      httpClient.close();

      return ResponseEntity.ok(responseBody);
    } catch (Exception e) {
      // Handle exceptions, e.g., invalid URL, network error
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
          .body("Error: " + e.getMessage());
    }
  }

  @DeleteMapping("/delete")
  public ResponseEntity<String> sendDeleteRequest(@RequestParam String url){
    try {
      // Implement logic to send a DELETE request to the specified URL
      // Example: use HttpClient to send a DELETE request
      // Process the response and return it
      // This is a simplified example using Apache HttpClient

      CloseableHttpClient httpClient = HttpClients.createDefault();
      HttpDelete httpDelete = new HttpDelete(url);
      CloseableHttpResponse response = httpClient.execute(httpDelete);

      // Process the response
      String responseBody = EntityUtils.toString(response.getEntity());

      httpClient.close();

      return ResponseEntity.ok(responseBody);
    } catch (Exception e) {
      // Handle exceptions, e.g., invalid URL, network error
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
          .body("Error: " + e.getMessage());
    }
  }
}