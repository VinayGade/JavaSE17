package beans.records;

/*
 * Records :
 *   case class in Scala
 *   class in Typescript with constructor signature
 * */
public record Customer(int id, String name) {
}
//replacement of the 42 lines of code of the “old” beans.Customer data class.
//A record like this one has instance variables, a constructor, accessor methods,
// and equals, hashCode, and toString methods.
// ** Just as interfaces are implicitly abstract, records are also implicitly "final".