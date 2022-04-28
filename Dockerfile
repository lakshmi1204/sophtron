FROM adoptopenjdk/openjdk8

ADD target/${project.build.finalName}.jar /app.jar