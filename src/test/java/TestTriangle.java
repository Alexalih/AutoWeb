
import Homework4.MyException;
import Homework4.Triangle;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;



public class TestTriangle {
  @Test
  void test1() {
      double n = 0;
      try {
          n = Triangle.s(3, 4, 5);
      } catch (MyException e) {
          e.printStackTrace();
      }
      Assertions.assertEquals(n, 6.0);
  }


    @Test
    void test2(){

        Assertions.assertThrows(MyException.class, () -> Triangle.s(0,4,5), "Такого треуголника не существует!");

    }
    @Test
    void test3(){
        Assertions.assertThrows(MyException.class, () -> Triangle.s(3,-8,5), "Такого треуголника не существует!");
    }

    @Test
    void test4(){
        Assertions.assertThrows(MyException.class, () -> Triangle.s(3,100,5), "Такого треуголника не существует!");
    }

}
