# vwgcolottieDialog-Android
[![platform](https://img.shields.io/badge/platform-Android-yellow.svg)](https://www.android.com)
[![API](https://img.shields.io/badge/API-15%2B-brightgreen.svg?style=plastic)](https://android-arsenal.com/api?level=15)
[![License](https://img.shields.io/badge/license-Apache%202-4EB1BA.svg?style=flat-square)](https://www.apache.org/licenses/LICENSE-2.0.html)
[![](https://jitpack.io/v/Shashank02051997/vwgcolottieDialog-Android.svg)](https://jitpack.io/#Shashank02051997/vwgcolottieDialog-Android)
[![Android Arsenal](https://img.shields.io/badge/Android%20Arsenal-vwgcolottieDialog-brightgreen.svg?style=flat)](https://android-arsenal.com/details/1/6652)


## Prerequisites

Add this in your root `build.gradle` file (**not** your module `build.gradle` file):

```gradle
allprojects {
	repositories {
		...
		maven { url "https://jitpack.io" }
	}
}
```

## Dependency

Add this to your module's `build.gradle` file (make sure the version matches the JitPack badge above):

```gradle
dependencies {
	...
	implementation 'com.github.vwgco:vwgcolottieDialog-Android:1.3'
}
```
## VWGCO lottie Dialog

Dialog with two buttons:

``` java
new vwgcolottieDialog.Builder(this)
                .setTitle("Granny eating chocolate dialog box") // You can also send title like R.string.from_resources
                .setMessage("This is a granny eating chocolate dialog box. This library is used to help you easily create fancy lottiey dialog.") // or pass like R.string.description_from_resources
                .setNegativeBtnText("Cancel") // or pass it like android.R.string.cancel
                .setPositiveBtnBackground("#FF4081") // or pass it like R.color.positiveButton
                .setPositiveBtnText("Ok") // or pass it like android.R.string.ok
                .setNegativeBtnBackground("#FFA9A7A8") // or pass it like R.color.negativeButton
                .setlottieResource(R.raw.lottie1)   //Pass your lottie here
                .isCancellable(true)
                .OnPositiveClicked(new vwgcolottieDialogListener() {
                    @Override
                    public void OnClick() {
                        Toast.makeText(MainActivity.this,"Ok",Toast.LENGTH_SHORT).show();
                    }
                })
                .OnNegativeClicked(new vwgcolottieDialogListener() {
                    @Override
                    public void OnClick() {
                        Toast.makeText(MainActivity.this,"Cancel",Toast.LENGTH_SHORT).show();
                    }
                })
                .build();
```

Dialog with one button:

``` java
new vwgcolottieDialog.Builder(this)
                .setTitle("Granny eating chocolate dialog box")
                .setMessage("This is a granny eating chocolate dialog box. This library is used to help you easily create fancy lottiey dialog.")
                .setPositiveBtnText("Ok")
                .setPositiveBtnBackground("#FF4081")
                .setlottieResource(R.raw.lottie1)   //Pass your lottie here
                .isCancellable(true)
                .OnPositiveClicked(new vwgcolottieDialogListener() {
                    @Override
                    public void OnClick() {
                        Toast.makeText(MainActivity.this,"Ok",Toast.LENGTH_SHORT).show();
                    }
                })
                .build();
```


## License

* [Apache Version 2.0](http://www.apache.org/licenses/LICENSE-2.0.html)

```
Copyright 2018 Shashank Singhal

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

 http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
