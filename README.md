# Barcode-Generator
A single page app generating barcodes as string instead of images

Pre Requisites

You will need a barcode4j jar with a working QR code implementation. Currently with version 2.1 you have to check-out the trunk 
from project repo and build it as the source jar available for download doesn't have the QR code.

About the App

This is a single page application with a Backbone front end and Java backend. Barcodes are generated as base 64 encoded strings 
and rendered on the UI like regular images, this enables the app to work without needing a location to store the images on the backend as would happen if using image files. 

Steps To use

Select barcode type, enter barcode text, enter as many barcodes as you need then select submit.
You can select a different type for each barcode
