package com.puppygoggles.Main;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.http.HttpResponse;
import com.google.cloud.vision.v1.AnnotateImageRequest;
import com.google.cloud.vision.v1.AnnotateImageResponse;
import com.google.cloud.vision.v1.BatchAnnotateImagesResponse;
import com.google.cloud.vision.v1.EntityAnnotation;
import com.google.cloud.vision.v1.Feature;
import com.google.cloud.vision.v1.Feature.Type;
import com.google.cloud.vision.v1.Image;
import com.google.cloud.vision.v1.ImageAnnotatorClient;
import com.google.protobuf.ByteString;

public class Main {
  public static void main(String... args) throws Exception {
	  
	  File inputFile = new File("breeds.txt");
	  ArrayList<String> breeds = new ArrayList<>();
	  ArrayList<String> descriptions = new ArrayList<>();
	  try(Scanner in = new Scanner(inputFile)){
		  while(in.hasNext()) {
			  String inputBreed = in.nextLine().toLowerCase();
			  breeds.add(inputBreed);
		  }
	  }
	  catch (FileNotFoundException exception) {
			System.out.println(exception.getMessage());
		}	  
	  
	  MyDatabase temp = new MyDatabase();
	  temp.connect();
	  
	  
	// Set up and execute a Google Cloud Storage request.
	  MyStorage pic = new MyStorage();
	  pic.getPicture();
	  
    // Instantiates a client
    try (ImageAnnotatorClient vision = ImageAnnotatorClient.create()) {

      // The path to the image file to annotate
      String fileName = "C:\\Users\\matth\\Pictures\\Old iPhone Pictures\\IPhone pics 10-11-15\\IMG_2437.PNG";

      // Reads the image file into memory
      Path path = Paths.get(fileName);
      byte[] data = Files.readAllBytes(path);
      ByteString imgBytes = ByteString.copyFrom(data);

      // Builds the image annotation request
      List<AnnotateImageRequest> requests = new ArrayList<>();
      Image img = Image.newBuilder().setContent(imgBytes).build();
      Feature feat = Feature.newBuilder().setType(Type.LABEL_DETECTION).build();
      AnnotateImageRequest request = AnnotateImageRequest.newBuilder()
          .addFeatures(feat)
          .setImage(img)
          .build();
      requests.add(request);

      // Performs label detection on the image file
      BatchAnnotateImagesResponse response = vision.batchAnnotateImages(requests);
      List<AnnotateImageResponse> responses = response.getResponsesList();

      for (AnnotateImageResponse res : responses) {
        if (res.hasError()) {
          System.out.printf("Error: %s\n", res.getError().getMessage());
          return;
        }

        for (EntityAnnotation annotation : res.getLabelAnnotationsList()) {
        	String description = annotation.getDescription();
        	//System.out.println(description);
        	if(breeds.contains(description.toLowerCase())) {
        		descriptions.add(description);
        	}
         /* annotation.getAllFields().forEach((k, v) ->
              System.out.printf("%s : %s\n", k, v.toString()));*/
        }
        temp.writeToLost(fileName, descriptions);
      }
    }
  }
}