# MathJaxView
[![API](https://img.shields.io/badge/API-15%2B-brightgreen.svg?style=flat)](https://android-arsenal.com/api?level=15)
[![Download](https://api.bintray.com/packages/sidvenu/maven/MathJaxView/images/download.svg)](https://bintray.com/sidvenu/maven/MathJaxView/_latestVersion)

MathJaxView is a custom view extending WebView and offers offline support for MathJax for Android Apps.

<img src="https://github.com/sidvenu/MathJaxView/blob/master/screenshots/screenshot.gif">

## Setup
You can add MathJaxView to your Android Studio project in two ways:
1. Using a remote Maven repository (jCenter)
1. Using AAR file downloaded from bintray
### 1. Setup from a remote Maven repository (jcenter)

Add `implementation 'io.github.sidvenu.mathjaxview:mathjaxview:1.0.6'` into **dependencies** section of your **module** build.gradle file.

### 2. Setup from local .aar file

You can download the latest version of MathView from [Bintray].

1) Import the module from local .aar file

Click `File - New - New Module` (yes, not `Import Module`) `-> Import .JAR/.AAR Package`, and find out where the file located.

2) Add dependency

Click `File -> Project Structure -> Dependencies`, and then click the plus icon, select `3. Module Dependency`.

## Usage
The usage of MathJaxView is similar to that of TextView. Refer to the sample app (MathJaxTest) for usage.

##### MathJax configuration
The default config is set to use single dollar symbols ($) for inline formula and double dollar symbols ($$) for
displayed formula. You can use the `view.setConfig(String)` method to change the configuration to anything of your
choice. The default config is set as follows:
```java
config = "MathJax.Hub.Config({" +
                "    extensions: ['fast-preview.js']," +
                "    messageStyle: 'none'," +
                "    \"fast-preview\": {" +
                "      disabled: false" +
                "    }," +
                "    CommonHTML: {" +
                "      linebreaks: { automatic: true, width: \"container\" }" +
                "    }," +
                "    tex2jax: {" +
                "      inlineMath: [ ['$','$'] ]," +
                "      displayMath: [ ['$$','$$'] ]," +
                "      processEscapes: true" +
                "    }," +
                "    TeX: {" +
                "      extensions: [\"file:///android_asset/MathJax/extensions/TeX/mhchem.js\"]," +
                "      mhchem: {legacy: false}"+
                "    }" +
                "});";
```


##### Asset management
Make sure you add the extra MathJax assets that accompanies the change in config to your app (other than the one provided by the library). 

You can do this by creating a MathJax folder in your assets folder that has the extra MathJax assets. The path to MathJax that you can use in your config can be: `file:///android_asset/MathJax/extensions/TeX/mhchem.js`. 


## Thanks
Sincere thanks to [jianzhongli] for their [MathView] project
that served as an inspiration for this project.

## How is it  different from [MathView]?
1. It features the latest MathJax version (v2.7.5).
1. It does not have KaTeX, reducing the size of library. If you want KaTeX,there is a separate library for that: [KaTeXView].
1. Supports API level 15, targeting 100% of the Android devices as per documentation.
1. Very small size - 1.36MB that was stripped down from 67.59MB of MathJax assets.

## Documentation
The code of MathJaxView (a single small file) is well documented and anyone can easily understand it.
Please view the [code]
and try to understand it yourself. If you don't, please raise a issue with the **help wanted** label.

## Issues
Please [report] any issues that you encountered, not limited to performance improvements and
updating the MathJax assets.

## Pull Requests
PRs are an all-time welcome provided you follow the coding style similar to that already existing in the project.

## License
This software is licensed under the Apache License, Version 2.0. Refer the [license] for more details.

[MathView]: https://github.com/jianzhongli/MathView
[KaTeXView]: https://github.com/sidvenu/KaTeXView
[Bintray]: https://bintray.com/sidvenu/maven/MathJaxView/_latestVersion
[code]: https://github.com/sidvenu/MathJaxView/blob/master/mathjaxview/src/main/java/io/github/sidvenu/mathjaxview/MathJaxView.java
[report]: https://github.com/sidvenu/MathJaxView/issues
[jianzhongli]: https://github.com/jianzhongli
[license]: https://github.com/sidvenu/MathJaxView/blob/master/LICENSE.md*