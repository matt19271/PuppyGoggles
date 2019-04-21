package com.puppygoggles.Main;





import java.util.Iterator;

//import com.google.api.services.storage.Storage;
import com.google.cloud.storage.Blob;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.Storage.BlobGetOption;
import com.google.cloud.storage.Storage.BlobListOption;
import com.google.cloud.storage.StorageOptions;

public class MyStorage {
	
	public void getPicture() {
		// Instantiate a Google Cloud Storage client
		Storage storage = StorageOptions.getDefaultInstance().getService();
		
		
		
		

		// The name of a bucket, e.g. "my-bucket"
		String bucketName = "staging.puppygoggles.appspot.com";
		
		 String directory = "my_directory/";
		 Page<Blob> blobs = storage.list(bucketName, BlobListOption.currentDirectory(),
		     BlobListOption.prefix(directory));
		 Iterator<Blob> blobIterator = blobs.iterateAll();
		 while (blobIterator.hasNext()) {
		   Blob blob = blobIterator.next();
		   // do something with the blob
		 }
		
		//storage.list(bucketName, BlobListOption.fields(Storage.BlobField.values()));
		
		
		
		//storage.list(bucketName, options)
		

		// The name of a blob, e.g. "my-blob"
		/*String blobName = "IMG_2437.PNG";

		// Select all fields
		// Fields can be selected individually e.g. Storage.BlobField.CACHE_CONTROL
		Blob blob = storage.get(bucketName, blobName, BlobGetOption.fields(Storage.BlobField.values()));
		
		System.out.println(blob.getMediaLink());*/
	}

}
