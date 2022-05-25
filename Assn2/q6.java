import java.util.*;

class q6 {
  public static void main(String args[]) {
    byte a = 10;
    Byte byteobj = Byte.valueOf(a);
    int b = 1000;
    Integer intobj = Integer.valueOf(b);
    float c = 18.6f;
    Float floatobj = Float.valueOf(c);
    double d = 250.5;
    Double doubleobj = Double.valueOf(d);
    char e = 'a';
    Character charobj = e;

    // printing the values from objects
    System.out.println("Values of Wrapper objects (printing as objects)");
    System.out.println(byteobj + "(" + byteobj.getClass() + ")");
    System.out.println(intobj + "(" + intobj.getClass() + ")");
    System.out.println(floatobj + "(" + floatobj.getClass() + ")");
    System.out.println(doubleobj + "(" + doubleobj.getClass() + ")");
    System.out.println(charobj + "(" + charobj.getClass() + ")");

    // objects to data types (retrieving data types from objects)
    // unwrapping objects to primitive data types
    byte bv = byteobj;
    int iv = intobj;
    float fv = floatobj;
    double dv = doubleobj;
    char cv = charobj;

    // printing the values from data types
    System.out.println("Unwrapped values (printing as data types)");
    System.out.println("byte value, bv: " + bv);
    System.out.println("int value, iv: " + iv);
    System.out.println("float value, fv: " + fv);
    System.out.println("double value, dv: " + dv);
    System.out.println("char value, cv: " + cv);

    // converting to String from basic types
    String bs = String.valueOf(bv);
    String is = String.valueOf(iv);
    String fs = String.valueOf(fv);
    String ds = String.valueOf(dv);
    String cs = String.valueOf(cv);

    System.out.println("String values (converted from basic data types)");
    System.out.println("byte value, bs: " + bs);
    System.out.println("int value, is: " + is);
    System.out.println("float value, fs: " + fs);
    System.out.println("double value, ds: " + ds);
    System.out.println("char value, cs: " + cs);

    // wrapper objects to strings
    String s1 = Byte.toString(byteobj);
    String s2 = Integer.toString(intobj);
    String s3 = Float.toString(floatobj);
    String s4 = Double.toString(doubleobj);
    System.out.println("String values (converted from wrapper objects)");
    System.out.println("byte value: " + s1);
    System.out.println("int value: " + s2);
    System.out.println("float value: " + s3);
    System.out.println("double value: " + s4);

    // string objects to wrapper objects
    String str1 = "888992";
    String str2 = "23";
    String str3 = "3.6f";
    String str4 = "8787.877";
    // String str5 = null;
    // String str6 = "7868766786876687687";
    try {
      Integer obj1 = Integer.parseInt(str1);
      Byte obj2 = Byte.parseByte(str2);
      Float obj3 = Float.parseFloat(str3);
      Double obj4 = Double.parseDouble(str4);
      // Integer obj5 = Integer.parseInt(str5);
      // Integer obj6 = Integer.parseInt(str6);

      System.out.println("values (printing as wrapper objects)");
      System.out.println(byteobj + "(" + obj1.getClass() + ")");
      System.out.println(intobj + "(" + obj2.getClass() + ")");
      System.out.println(floatobj + "(" + obj3.getClass() + ")");
      System.out.println(doubleobj + "(" + obj4.getClass() + ")");
    } catch (Exception ex) {
      System.out.println("Error in parsing the values!");
    }
  }
}
