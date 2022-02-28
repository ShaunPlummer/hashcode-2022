# Google Hashcode
This repository is an entry for qualification round of Google [Hashcode](https://codingcompetitions.withgoogle.com/hashcode),
a 4 hour hackathon hosted by Google.

Given a list of contributors and a list of projects with different skill requirements complete as many projects as possible. 
Contributors can improve their skills by completing projects and can mentor each other to work is roles in which they 
couldn't succeed on their own. The goal was to assign contributors to project roles that fit their qualifications and 
maximize the score for completed projects. See the [problem statement](problemStatement.pdf) for full details.

## Running the application
The application can be started using the gradle task. Which will run the program against all input files found 
in the `input` directory. A corresponding output file for submission will be created in the `out` directory. 

```
./gradlew run
```