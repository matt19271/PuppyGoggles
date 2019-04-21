package com.puppygoggles.Main;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ExecutionException;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.FirestoreOptions;
import com.google.cloud.firestore.WriteResult;

public class MyDatabase {
	int lostid = 0;
	int foundi = 0;
	
	public void connect() throws InterruptedException, ExecutionException {

	}
	
	public void writeToLost(String breed) throws InterruptedException, ExecutionException {
		FirestoreOptions firestoreOptions = FirestoreOptions.getDefaultInstance().toBuilder().setProjectId("puppygoggles").build();
		Firestore db = firestoreOptions.getService();
/*		Random rand = new Random(); 
		  
        // Generate random integers in range 0 to 999 
        int lostid = rand.nextInt(10000);*/
		DocumentReference docRef = db.collection("LostDogs").document();
		// Add document data  with id "alovelace" using a hashmap
		Map<String, Object> data = new HashMap<>();
		data.put("Breed", breed);
		//asynchronously write data
		ApiFuture<WriteResult> result = docRef.set(data);
		// ...
		// result.get() blocks on response
		System.out.println("Update time : " + result.get().getUpdateTime());
		//losti++;
	}
	
	public void writeToFound(String breed) throws InterruptedException, ExecutionException {
		FirestoreOptions firestoreOptions = FirestoreOptions.getDefaultInstance().toBuilder().setProjectId("puppygoggles").build();
		Firestore db = firestoreOptions.getService();
		
		DocumentReference docRef = db.collection("FoundDogs").document();
		// Add document data  with id "alovelace" using a hashmap
		Map<String, Object> data = new HashMap<>();
		data.put("Breed", breed);
		//asynchronously write data
		ApiFuture<WriteResult> result = docRef.set(data);
		// ...
		// result.get() blocks on response
		System.out.println("Update time : " + result.get().getUpdateTime());
	}

}
