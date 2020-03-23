package com.npntraining

import org.apache.spark.sql.SparkSession
import org.apache.log4j.Level

object SparkHiveIntegration {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder.master("local")
    .appName("application")
    .config("spark.sql.warehouse.dir", "/user/hive/warehouse")
    .config("hive.metastore.uris", "thrift://localhost:9083")
    .enableHiveSupport()
    .getOrCreate()
  //val spark = SparkSession.builder.master("local").appName("application").config("hive.warehouse.dir", "/user/hive/warehouse").enableHiveSupport().getOrCreate()
    spark.sparkContext.setLogLevel("ERROR");
  //val dbList = spark.sql("show databases");
  //dbList.show
    spark.sql("use emp_m")
    val rec = spark.sql("select * from student")
    rec.show
  }
}                                                                                