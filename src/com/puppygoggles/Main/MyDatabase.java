package com.puppygoggles.Main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.FirestoreOptions;
import com.google.cloud.firestore.WriteResult;

public class MyDatabase {	
	public void writeToLost(String fileName, ArrayList<String> breeds) throws InterruptedException, ExecutionException {
		FirestoreOptions firestoreOptions = FirestoreOptions.getDefaultInstance().toBuilder().setProjectId("puppygoggles").build();
		Firestore db = firestoreOptions.getService();
		DocumentReference docRef = db.collection("LostDogs").document();
		// Add document data using a hashmap
		Map<String, Object> data = new HashMap<>();
		data.put("fileName", fileName);
		
		for(int i = 0; i < breeds.size(); i++) {
			data.put("Breed " + (i + 1), breeds.get(i));
		}
		
		//asynchronously write data
		ApiFuture<WriteResult> result = docRef.set(data);
		// ...
		// result.get() blocks on response
		System.out.println("Update time : " + result.get().getUpdateTime());
	}
	
	/*public void writeToFound(String breed) throws InterruptedException, ExecutionException {
		FirestoreOptions firestoreOptions = FirestoreOptions.getDefaultInstance().toBuilder().setProjectId("puppygoggles").build();
		Firestore db = firestoreOptions.getService();
		
		DocumentReference docRef = db.collection("FoundDogs").document();
		// Add document data using a hashmap
		Map<String, Object> data = new HashMap<>();
		data.put("Breed", breed);
		//asynchronously write data
		ApiFuture<WriteResult> result = docRef.set(data);
		// ...
		// result.get() blocks on response
		System.out.println("Update time : " + result.get().getUpdateTime());
	}*/

}
