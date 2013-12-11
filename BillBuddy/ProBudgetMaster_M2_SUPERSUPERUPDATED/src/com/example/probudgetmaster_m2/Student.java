package com.example.probudgetmaster_m2;
public class Student {
String idnumber;
String name;

public Student(String idnumber, String name){
this.idnumber = idnumber;
this.name = name;
}
public Student(){
}
public String getIdnumber() {
return idnumber;
}
public void setIdnumber(String id) {
this.idnumber = id;
}
public String getName() {
return name;
}
public void setName(String name) {
this.name = name;
}
}