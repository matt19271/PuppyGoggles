package com.puppygoggles.Main;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import com.google.cloud.vision.v1.AnnotateImageRequest;
import com.google.cloud.vision.v1.AnnotateImageResponse;
import com.google.cloud.vision.v1.BatchAnnotateImagesResponse;
import com.google.cloud.vision.v1.EntityAnnotation;
import com.google.cloud.vision.v1.Feature;
import com.google.cloud.vision.v1.Image;
import com.google.cloud.vision.v1.ImageAnnotatorClient;
import com.google.cloud.vision.v1.Feature.Type;
import com.google.protobuf.ByteString;

public class IntVisionAPI {
	ArrayList<String> descriptions = new ArrayList<>();
	MyDatabase temp = new MyDatabase();
	Compare compTemp = new Compare();
	public void analyze(ArrayList<String> breeds) throws IOException, InterruptedException, ExecutionException {
	    try (ImageAnnotatorClient vision = ImageAnnotatorClient.create()) {
	    	
	        // The path to the image file to annotate
	        String fileName = "C:\\Users\\matth\\Pictures\\dogs\\get_image.jpeg";

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
	          	if(breeds.contains(description.toLowerCase())) {
	          		descriptions.add(description);
	          	}
	          }
	          temp.writeToLost(fileName, descriptions);
	          compTemp.comp(descriptions);
	          
	          descriptions.clear();
	       }
	     }
	}
}
	