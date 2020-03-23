package com.npntraining

import java.sql.DriverManager
import java.sql.Connection
import java.sql.Statement
import java.sql.ResultSet
import java.sql._
import java.lang._


class HiveConnection{
  val driverName:String = "org.apache.hive.jdbc.HiveDriver"
  val url:String="jdbc:hive2://localhost:10000/emp_m"
  val user:String="npntraining"
  val password:String="npntraining"
  val query = ""
  
  def getConnection():Connection={
    var connection:Connection=null
      Class.forName(driverName)
      connection = DriverManager.getConnection(url, user, password)
      connection
  }
  def getStatement(con:Connection):Statement={
    val st:Statement = con.createStatement()
    st
  }
  def queryExecute(st:Statement,query:String)={
    val rs:ResultSet=st.executeQuery(query)
    //var res:String=null
    while(rs.next()){
      val res = rs.getObject(1)+"\t"+rs.getString(2)+"\t"+rs.getObject(3)
      println(res)
    }
  }
}