# curriculy
 Application in **Kotlin** made for a recruitment task.
 
 App uses **Picasso** library, **Firebase Realtime Database** and **Android resources** to provide content to show.
 
To use it, you will need to modify resources in the app. 
Create file ```stringsPersonal.xml``` in the ```res/values/``` catalogue.
It should contain ```string``` fields called:
* phone_number
* email_address
* author_name
* summary_info

filled with appropriate for you data.
Change the values inside ```strings.xml``` and ```arrays.xml``` to reflect your own experiences. 

You should also provide your own photos and images for logos of the technologies you used and of your own face. All of these files should be added to ```res/drawables/``` folder and the names and references in ```values/arrays.xml``` should be modified accordingly.

Paste your ```google-services.json``` file from Firebase console into the main ```app/``` folder. 
In file ```FirebaseHelper.kt``` change the URL in the line:

```val myRef = database.getReferenceFromUrl("https://example.firebaseio.com/experiences")```

to URL of your Realtime Database.
    
Realtime Database structure is as follows:
```
{
  "experiences" : [ 
  {
    "company_logo" : "http://example.com/company_logo_1.png",
    "company_name" : "First Company",
    "end_year" : 2018,
    "position_name" : "Position At Company",
    "responsibilities" : [ 
     "Example responsibility 1",
     "Example responsibility 2"
    ],
    "start_year" : 2016
   },
   {
    "company_logo" : "http://example.com/company_logo_2.png",
    "company_name" : "Second Company",
    "end_year" : 2020,
    "position_name" : "Position At Second Company",
    "responsibilities" : [
      "Responsibility 1",
      "Responisbility 2",
      "Responsibility 3",
      "Responsibility 4"
    ],
    "start_year" : 2018
  }
 ]
}
```
