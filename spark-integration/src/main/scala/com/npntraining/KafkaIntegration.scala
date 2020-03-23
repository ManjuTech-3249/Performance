package com.npntraining.examples

import org.apache.spark.sql.Dataset
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.Encoders
import org.apache.spark.sql.streaming.OutputMode

object KafkaIntegration {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession
      .builder
      .appName("Kafka Integration").master("local")
      .getOrCreate();
    val inputStreamDF= spark
      .readStream
      .format("kafka")
      .option("kafka.bootstrap.servers", "localhost:9092")
      .option("subscribe", "simple-producer-consumer")
      .load()
      
    
    inputStreamDF.printSchema()
    
    val recordDS = inputStreamDF.selectExpr("CAST(value AS STRING)")
      .as(Encoders.STRING)
    
    val query =
      recordDS.writeStream
        .format("console")
        .option("truncate", "false")
        .outputMode(OutputMode.Update())

    query.start().awaitTermination()
  }
}