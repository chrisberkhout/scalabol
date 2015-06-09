// 5

import scala.beans.BeanProperty

class Student(
  @BeanProperty var name: String,
  @BeanProperty var id: Long
)

// public class Student {
//
//   public java.lang.String name();
//   public void name_$eq(java.lang.String);
//
//   public void setName(java.lang.String);
//   public java.lang.String getName();
//
//   public long id();
//   public void id_$eq(long);
//
//   public void setId(long);
//   public long getId();
//
//   public Student(java.lang.String, long);
//
// }
