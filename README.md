# scala-spray-twirl-template
A starter template to get a Scala project up and running with Spray and Twirl.

### Dependencies
SBT: 0.13.11
Scala: 2.11.7
Akka: 2.3.9
Spray: 1.3.3
Twirl: 0.7.0

### To Use
Clone the repo
```
git clone https://github.com/myerspa/scala-spray-twirl-template.git
```

Run the templating script and answer the prompts. Default package and organization name expect "package-like" names. Ex. com.peter.myers.
```
./templatize.sh
```

Open ```project/BuildSettings.scala``` and fill replace ```{{ORGANIZATION_HOMEPAGE}}}``` and ```{{DESCRIPTION}}``` with actual values...

At this point you should be able to launch the application using
```
sbt run
```

Navigate your browser to ```localhost:8080```.
If you see "Say hello to spray-routing on spray-can", then voila, it worked for you!

