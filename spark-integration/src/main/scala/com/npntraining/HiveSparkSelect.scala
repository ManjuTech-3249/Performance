package com.npntraining
import java.sql.Connection
import java.sql.Statement
import java.sql.DriverManager

object HiveSparkSelect {
  def main(args: Array[String]): Unit = {
    val query:String = "select * from student"
    val country:String = readLine("Enter country name:")
    if(country == "India"){
      val sh:SparkHive = new SparkHive()
      sh.sparkQueryExecute(query)
    }
    if(country == "US"){
      val hc:HiveConnection = new HiveConnection()
      val con:Connection = hc.getConnection()
      val st:Statement = hc.getStatement(con)
      hc.queryExecute(st,query) 
    }
  }
}