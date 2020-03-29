package com.npntraining.scala_test

import java.sql._;
import java.sql.ResultSetMetaData;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONException;
import scala.util.control._

class ConvertToJSON {
  
  @throws(classOf[SQLException])
  @throws(classOf[JSONException])
  def convertJson(country_code:String):JSONObject={
    val loop = new Breaks()
    
    val query =s"""select name,sal from employee where country_code = \"$country_code\""""
    val hash_value = query.hashCode()
    val sq:SelectQuery = new SelectQuery()
    val rs_hash:ResultSet = sq.getResult("select * from daily_data")
      
      var indicator:Int = 0
      var stored_json = ""
      loop.breakable{
      while(rs_hash.next())
      {
        if (rs_hash.getInt(1) == hash_value){
          indicator =1
          stored_json = rs_hash.getString(2)
          loop.break
        }
      }
    }
    if(indicator ==1){
      println("reading json from table")
      val obj:JSONObject = new JSONObject(stored_json)
      return obj
    }
    else {
      println("calling SQL query")
      val obj:JSONObject = new JSONObject()
      val hc:HiveConnection = new HiveConnection()
    val rs:ResultSet = hc.getResult(query)
    val rsmd:ResultSetMetaData = rs.getMetaData()
    val numColumns:Int = rsmd.getColumnCount
        for (i<-1 until numColumns+1){
          val col_name:String = rsmd.getColumnName(i)
          val json:JSONArray = new JSONArray()
          rs.beforeFirst()
          while(rs.next()){
            json.put(rs.getString(rsmd.getColumnName(i)))
          }
          obj.put(col_name, json)
        }
        val json_data:String = obj.toString()
        val insert_query:String = s"""insert into Daily_data values($hash_value,\'$json_data\') """
        val insert_obj:InsertQuery = new InsertQuery()
        insert_obj.getResult(insert_query)
        return obj
         }
  }
}