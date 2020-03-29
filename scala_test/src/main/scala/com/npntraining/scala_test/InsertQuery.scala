package com.npntraining.scala_test

import java.sql.DriverManager
import java.sql.Connection
import java.sql.Statement
import java.sql.ResultSet
import java.sql._
import java.lang._


class InsertQuery{
  
    
  def getResult(query:String):Unit={
    val driverName:String = "org.mariadb.jdbc.Driver"
  val url:String="jdbc:mariadb://localhost/test"
  
  val user:String="root"
  
  val password:String="root"
  
    Class.forName(driverName)
    var connection:Connection = DriverManager.getConnection(url, user, password)
    val st:Statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
    st.execute(query)
  }
}