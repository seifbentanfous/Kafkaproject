package com.production

import java.util.Properties

import org.apache.kafka.clients.producer.{KafkaProducer, ProducerConfig, ProducerRecord}
import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object Producer extends App {

  val conf = new SparkConf(true)
    .setAppName("seifapp")
    .setMaster("local[*]")

  val sc = new SparkContext(conf)
  val card = sc.textFile("soccer/cross_detail.csv")




  val props = new Properties()
  props.put("bootstrap.servers", "localhost:9092")

  props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer")
  props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer")

  val producer = new KafkaProducer[String, String](props)

  val TOPIC = "test"


  card.foreach(a =>{
    val record = new ProducerRecord(TOPIC, "key", a)
    producer.send(record)
  })

  val record = new ProducerRecord(TOPIC, "key", "the end " + new java.util.Date)
  producer.send(record)

  producer.close()


}
