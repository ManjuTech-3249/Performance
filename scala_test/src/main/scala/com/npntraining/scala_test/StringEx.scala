package com.npntraining.scala_test

object StringEx {
  def main(args: Array[String]):Unit={
     val country_code:String = readLine("Enter countrycode")
     printString(country_code)
  }
  def printString(country_code:String):Unit={
      
       val query:String = s"""select name,sal from emp where name = \"$country_code\""""
       println(query)
    }
    
}