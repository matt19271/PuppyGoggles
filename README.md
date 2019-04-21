# PuppyGoggles
A program using Googles Vision API and Google's Firebase to compare images of user uploaded dog images against images on shelter sites.

**The Front End
The front end guides users to upload an image of dogs they may have lost or found. When these images are added to the website puppygoggles.com (using domain.com)
which is built using React, the react server is supposed to communicate with the Java backend however we underestimated the difficulty of Spring ans wer not able
to connect with our frontend.

**The Back End
The back end takes in images of dogs and runs them through the Google Vision API. The API then compares the breeds of dog that Vision identifies and adds
the photo of the dog to a firestore database along with all of its identified breeds. Should a user ever upload a picture of a lost dog, the
program will take in the picture and compare it to similar dogs on the database. This will not only help people find their lost dogs with ease,
but also allow additional geotagging and datestamping to be implemented along the way.
Users upload an image of their lost dogs
