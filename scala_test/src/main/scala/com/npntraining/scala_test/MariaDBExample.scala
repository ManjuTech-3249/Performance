package com.npntraining.scala_test

import org.json.JSONObject;

object MariaDBExample {
  def main(args: Array[String]): Unit = {
    val country_code = readLine("Enter country Code")
    getJSONData(country_code)
  }
    def getJSONData(country_code:String):JSONObject={
      val con:ConvertToJSON = new ConvertToJSON()
      var obj:JSONObject = new JSONObject()
        obj = con.convertJson(country_code)
        println(obj)
        return obj
    }
}