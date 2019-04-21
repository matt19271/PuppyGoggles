package com.puppygoggles.Main;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.FirestoreOptions;
import com.google.cloud.firestore.Query;
import com.google.cloud.firestore.QuerySnapshot;

public class Compare{
	public void comp(ArrayList<String> breeds) throws InterruptedException, ExecutionException {
		FirestoreOptions firestoreOptions = FirestoreOptions.getDefaultInstance().toBuilder().setProjectId("puppygoggles").build();
		Firestore db = firestoreOptions.getService();
		CollectionReference dogs = db.collection("FoundDogs");
		Query query = dogs.whereEqualTo("Breed 1", breeds.get(0));
		ApiFuture<QuerySnapshot> querySnapshot = query.get();

		for (DocumentSnapshot document : querySnapshot.get().getDocuments()) {
		  System.out.println(document.getId());
		}
	}

}
