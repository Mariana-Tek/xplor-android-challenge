# xplor-android-challenge
Android challenge for interviewing candidates

## The app has the following characteristics:
* MVVM Architecture w/ a ApiState sealed class wrapper for responses
* Vanilla Dagger2
* Room Database for caching
* Retrofit for networking
* Coroutines and Flows for asynchronous programming
* Kotlin programming language


## App Description
The app consists of 3 activites.
- MainActivity will present the user with the option to load the XML or Compose challenge
- XmlListActivity, this will load a horizontal and vertical recyclerviews using XML. The data will be provided downstream from Retrofit and Room
- ComposeActivity, this screen is purposely left in blank so that candidates can show their compose abilities and build UI around it.

  
#Working project

https://github.com/Mariana-Tek/xplor-android-challenge/assets/20048096/fd52512e-ff9d-4819-b044-aeadaf349226

