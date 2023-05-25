import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ListTest {

  // ONLY USE THIS FUNCTION TO CONSTRUCT LISTS FOR TESTING...
  public <E> List<E>makeList(E[] array){
    return new ArrayList<E>(Arrays.asList(array));
  }
  

  // the length() method:

  // Specification:
  // Length returns the number of elements in a list.

  // Tests:

  @Test
  public void testLength1() {
    Integer[] ar = {3,4,5};
    List<Integer> l = makeList(ar);
    assertEquals(3, l.size());
  }

  @Test
  public void testLength2() {
    Integer[] ar = {};
    List<Integer> l = makeList(ar);
    assertEquals(0, l.size());
  }

  @Test
  public void testLength3() {
    Character[] ar = {'a'};
    List<Character> l = makeList(ar);
    assertEquals(1, l.size());
  }

  @Test
  public void testLength4() {
    String[] ar = {"t", "t1", "", ""};
    List<String> l = makeList(ar);
    assertEquals(4, l.size());
  }

  // the get() method:

  // Specification:
  // Returns the element at the given index where indexing begins at 0. Throws
  // an error if the index is greater or equal to the length. An error will also
  // be thrown if the index is less than 0.

  //Tests:
  @Test
  public void testGet1() {
    String[] ar = {};
    List<String> l = makeList(ar);
    assertThrows(IndexOutOfBoundsException.class, () -> {l.get(0);});
  }

  @Test
  public void testGet2() {
    String[] ar = {"a", "b", "c", "d"};
    List<String> l = makeList(ar);
    assertThrows(IndexOutOfBoundsException.class, () -> {l.get(4);});
  }

  @Test
  public void testGet3() {
    String[] ar = {"a", "b", "c", "d"};
    List<String> l = makeList(ar);
    assertThrows(IndexOutOfBoundsException.class, () -> {l.get(-1);});
  }

  @Test
  public void testGet4() {
    String[] ar = {"a", "b", "c", "d"};
    List<String> l = makeList(ar);
    assertEquals("a", l.get(0));
    assertEquals("b", l.get(1));
    assertEquals("c", l.get(2));
    assertEquals("d", l.get(3));
  }

  @Test
  public void testGet5() {
    String[] ar = {"a", "b", "c", "d"};
    List<String> l = makeList(ar);
    assertThrows(IndexOutOfBoundsException.class, () -> {l.get(4);});
  }

  @Test
  public void testGet6() {
    Integer[] ar = {12, 13};
    List<Integer> l = makeList(ar);
    assertEquals(12, l.get(0));
    assertEquals(13, l.get(1));
  }

  // the add() method:

  // Specification:
  // Inserts the element at the index. The elements at that
  // position and all subsequent element are shifted to the
  // right. Indexing starts at 0, if there are no subsequent
  // elements nothing is shifted. Throws IndexOutOfBounds
  // error if index is out of range. Throws an error if the
  // element being added isn't the same type as the list.
  // Allows adding child types if the list is a parent type,
  // such as null in a list of strings.

  //Tests:
  @Test
  public void testAdd1() {
    Integer[] ar = {};
    List<Integer> l = makeList(ar);
    l.add(0, 1);
    assertEquals(1, l.get(0));
    l.add(0, 2);
    assertEquals(2, l.get(0));
    assertEquals(1, l.get(1));
    l.add(1, -1);
    l.add(1, -2);
    assertEquals(2, l.get(0));
    assertEquals(-2, l.get(1));
    assertEquals(-1, l.get(2));
    assertEquals(1, l.get(3));
    l.add(4, 4);
    assertEquals(4, l.get(4));
  }

  @Test
  public void testAdd2() {
    String[] ar = {"a", "b", "c", "d"};
    List<String> l = makeList(ar);
    assertThrows(IndexOutOfBoundsException.class, () -> {l.add(-1, "t");});
    assertThrows(IndexOutOfBoundsException.class, () -> {l.add(5, "t");});
  }

  @Test
  public void testAdd3() {
    String[] ar = {"a", "b", "c", "d"};
    List<String> l = makeList(ar);
    l.add(2, null);
    assertEquals(null, l.get(2));
  }

  // the remove() method:

  // Specification:
  // Removes the element at the given index from the list. If there are any
  // subsequent elements their index is shifted down by 1.

  //Tests:
  @Test
  public void testRemove1() {
    Integer[] ar = {0, 1, 2, 3, 4, 5};
    List<Integer> l = makeList(ar);
    assertEquals(6, l.size());
    l.remove(0);
    assertEquals(5, l.size());
    assertEquals(1, l.get(0));
    assertEquals(5, l.get(4));
    assertEquals(5, l.size());
    l.remove(4);
    assertEquals(4, l.size());
  }

  @Test
  public void testRemove2() {
    String[] ar = {"t0", "t1", "t2", "t3", "t4", "t5"};
    List<String> l = makeList(ar);
    assertEquals(6, l.size());
    l.remove(0);
    assertEquals(5, l.size());
    assertEquals("t1", l.get(0));
    assertEquals("t5", l.get(4));
    assertEquals(5, l.size());
    l.remove(4);
    assertEquals(4, l.size());
  }

  @Test
  public void testRemove3() {
    String[] ar = {"a", "b", "c", "d"};
    List<String> l = makeList(ar);
    assertThrows(IndexOutOfBoundsException.class, () -> {l.remove(-1);});
    assertThrows(IndexOutOfBoundsException.class, () -> {l.remove(4);});
  }


  // the contains() method:

  // Specification:
  // Returns true if the list contains if the list contains at least 1 element E
  // where Objects.equals(given, E) is true.

  //Tests:
  // TODO Add test with nested lists
  //  @Test
  //  public void testContains1() {
  //    Integer[][] ar = {{1, 2}, {2, 3}, {3, 4}};
  //    List<List<Integer>> l = makeList(ar);
  //  }
  
    @Test
    public void testContains1() {
      Integer[] ar = {1, 2, 3, 4, 5};
      List<Integer> l = makeList(ar);
      assertTrue(l.contains(1));
      assertTrue(l.contains(2));
      assertTrue(l.contains(3));
      assertTrue(l.contains(4));
      assertTrue(l.contains(5));
      l.remove(0);
      assertFalse(l.contains(1));
      assertFalse(l.contains("t"));
      assertFalse(l.contains('a'));
      assertFalse(l.contains(""));
    }

}
