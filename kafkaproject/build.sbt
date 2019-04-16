import sbt.Keys.excludeDependencies

name := "kafkaproject"

version := "0.1"

scalaVersion := "2.12.8"

libraryDependencies += "org.apache.kafka" %% "kafka" % "2.2.0"

libraryDependencies += "org.apache.spark" %% "spark-core" % "2.4.1"

dependencyOverrides += "com.fasterxml.jackson.core" % "jackson-core" % "2.9.8"
dependencyOverrides += "com.fasterxml.jackson.core" % "jackson-databind" % "2.9.8"
dependencyOverrides += "com.fasterxml.jackson.module" %% "jackson-module-scala" % "2.9.8"