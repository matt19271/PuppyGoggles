# PuppyGoggles
A program using Googles Vision API and Google's Firestore to compare images of user uploaded dog images against images on shelter sites to reunite lost dogs with their owners.

**The Front End**

The front end guides users to upload an image of dogs they may have lost or found. When these images are added to the website puppygoggles.com (using domain.com)
which is built using React, the react server is supposed to communicate with the Java backend; however, we underestimated the difficulty of Spring with the time constraints and were not able
to connect with our frontend. 
A web crawler will be implemented to crawl animal shelter websites and lost-and-found pages to amass a wider database of lost dogs.

**The Back End**

The back end takes in images of dogs and runs them through the Google Vision API. The API then compares the breeds of dog that Vision identifies and adds
the photo of the dog to a Firestore database along with all of its identified breeds. Should a user ever upload a picture of a lost dog, the
program will take in the picture and compare it to similar dogs on the database. This will help people find their lost dogs with ease. Future implementations will include location data and timestamps, etc. associated with the photos to further increase the chances of finding the lost dog. In addition, users can upload images of dogs they have found, which will be uploaded to the database along with its breed(s), location, timestamp, and other relevant data.
