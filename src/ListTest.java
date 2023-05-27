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
  
  // the List Model:
  // The Java List contains a collection of references to elements ordered
  // by index, beginning at zero. The elements of a list
  // must be of the type determined when the list is created.

  // the length() method:

  // Specification:
  // Length returns the number of elements in a list.

  // Tests:

  // Test 1: Tests basic length functionality with strings
  @Test
  public void testLength1() {
    Integer[] ar = {3,4,5};
    List<Integer> l = makeList(ar);
    assertEquals(3, l.size());
  }

  // Test 2: Tests empty list case
  @Test
  public void testLength2() {
    Integer[] ar = {};
    List<Integer> l = makeList(ar);
    assertEquals(0, l.size());
  }

  // Test 3: Tests basic functionality with chars
  @Test
  public void testLength3() {
    Character[] ar = {'a'};
    List<Character> l = makeList(ar);
    assertEquals(1, l.size());
  }

  // Test 4: Tests basic functionality with strings
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

  // Test 1: Tests get basic functionality with integers
  @Test
  public void testGet1() {
    Integer[] ar = {12, 13};
    List<Integer> l = makeList(ar);
    assertEquals(12, l.get(0));
    assertEquals(13, l.get(1));
  }

  // Test 2: Tests basic get functionality with strings
  @Test
  public void testGet2() {
    String[] ar = {"a", "b", "c", "d"};
    List<String> l = makeList(ar);
    assertEquals("a", l.get(0));
    assertEquals("b", l.get(1));
    assertEquals("c", l.get(2));
    assertEquals("d", l.get(3));
  }

  // Test 3: Tests get basic functionality with doubles
  @Test
  public void testGet3() {
    Double[] ar = {1.1, 2.2, 3.3, 4.4};
    List<Double> l = makeList(ar);
    assertEquals(1.1, l.get(0));
    assertEquals(2.2, l.get(1));
    assertEquals(3.3, l.get(2));
    assertEquals(4.4, l.get(3));
  }

  // Test 4: Tests IndexOutOfBounds errors
  @Test
  public void testGet4() {
    String[] ar = {"a", "b", "c", "d"};
    List<String> l = makeList(ar);
    assertThrows(IndexOutOfBoundsException.class, () -> {l.get(4);});
    assertThrows(IndexOutOfBoundsException.class, () -> {l.get(-1);});
    assertThrows(IndexOutOfBoundsException.class, () -> {l.get(100);});
  }

  // Test 5: Tests empty list case
  @Test
  public void testGet5() {
    String[] ar = {};
    List<String> l = makeList(ar);
    assertThrows(IndexOutOfBoundsException.class, () -> {l.get(0);});
    assertThrows(IndexOutOfBoundsException.class, () -> {l.get(-1);});
    assertThrows(IndexOutOfBoundsException.class, () -> {l.get(10);});
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

  // Test 1: Tests basic add functionality
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

  // Test 2: Tests Index out of bounds errors for incorrect indexes
  @Test
  public void testAdd2() {
    String[] ar = {"a", "b", "c", "d"};
    List<String> l = makeList(ar);
    assertThrows(IndexOutOfBoundsException.class, () -> {l.add(-1, "t");});
    assertThrows(IndexOutOfBoundsException.class, () -> {l.add(5, "t");});
  }

  // Test 3: Tests add with null
  @Test
  public void testAdd3() {
    String[] ar = {"a", "b", "c", "d"};
    List<String> l = makeList(ar);
    l.add(2, null);
    assertEquals(null, l.get(2));
  }

  // Test 4: Tests add with empty list
  @Test
  public void testAdd4() {
    Integer[] ar = {};
    List<Integer> l = makeList(ar);
    assertThrows(IndexOutOfBoundsException.class, () -> {l.add(1, 20);});
    l.add(0, 20);
    l.add(0, 10);
    assertEquals(10, l.get(0));
    assertEquals(20, l.get(1));
  }

  // the remove() method:

  // Specification:
  // Removes the element at the given index from the list. If there are any
  // subsequent elements their index is shifted down by 1.

  //Tests:

  // Test 1: Tests remove basic functionality with integers
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

  // Test 2: Tests remove basic functionality with strings
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

  // Test 3: Tests index out of bounds error
  @Test
  public void testRemove3() {
    String[] ar = {"a", "b", "c", "d"};
    List<String> l = makeList(ar);
    assertThrows(IndexOutOfBoundsException.class, () -> {l.remove(-1);});
    assertThrows(IndexOutOfBoundsException.class, () -> {l.remove(4);});
  }

  // Test 4: Tests remove on empty list
  @Test
  public void testRemove4() {
    String[] ar = {};
    List<String> l = makeList(ar);
    assertThrows(IndexOutOfBoundsException.class, () -> {l.remove(0);});
  }

  // the contains() method:

  // Specification:
  // Returns true if the list contains if the list contains at least 1 element E
  // where Objects.equals(given, E) is true.

  //Test:

  // Test 1: Tests basic functionality of contains
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

  // Test 2: Tests contains works after removing duplicates
  @Test
  public void testContains2() {
    Integer[] ar = {1,1,2,3};
    List<Integer> l = makeList(ar);
    assertTrue(l.contains(1));
    l.remove(0);
    assertTrue(l.contains(1));
    l.remove(0);
    assertFalse(l.contains(1));
  }

  // Test 3: Tests functionality works with strings
  @Test
  public void testContains3() {
    String[] ar = {"hello", "", "test"};
    List<String> l = makeList(ar);
    assertTrue(l.contains(""));
    assertTrue(l.contains("hello"));
    assertTrue(l.contains("test"));
    assertFalse(l.contains(1));
    assertFalse(l.contains("Hello"));
  }

  // Test 4: Tests functionality with null
  @Test
  public void testContains4() {
    String[] ar = {"", "t1", "t2", null, "t3"};
    List<String> l = makeList(ar);
    assertTrue(l.contains(null));
    l.remove(3);
    assertFalse(l.contains(null));
  }

  // Test 5: Test contains on empty list
  @Test
  public void testContains5() {
    String[] ar = {};
    List<String> l = makeList(ar);
    assertFalse(l.contains(""));
    assertFalse(l.contains(null));
    assertFalse(l.contains(0));
  }

  // the indexOf(Object obj) Method

  // Specification
  // Returns the index of the first occurrence of the element in the list
  // if the element is not in the list, -1 is returned.

  // Test 1: make list, make sure it gets every index right
  @Test
  public void testIndexOf1(){
    Integer[] ar = {1, 2, 3, 4, 5};
    List<Integer> l = makeList(ar);
    assertEquals(0, l.indexOf(1));
    assertEquals(1, l.indexOf(2));
    assertEquals(2, l.indexOf(3));
    assertEquals(3, l.indexOf(4));
    assertEquals(4, l.indexOf(5));
  }

  // Test 2: make list, make sure it correctly returns -1 if elements dont exist
  @Test
  public void testIndexOf2(){
    Integer[] ar = {1, 2, 3, 4, 5};
    List<Integer> l = makeList(ar);
    assertEquals(-1, l.indexOf(7));
    assertEquals(-1, l.indexOf("nope"));
  }

  // Test 3: Make List of strings and see if it works
  @Test
  public void testIndexOf3(){
    String[] ar = {"hello", "world", "foo", "bar"};
    List<String> l = makeList(ar);
    assertEquals(-1, l.indexOf(7));
    assertEquals(1, l.indexOf("world"));
  }

  // Test 4: Make sure the it returns the first index
  @Test
  public void testIndexIf4() {
    Integer[] ar = {1, 2, 3, 2, 5, 5};
    List<Integer> l = makeList(ar);
    assertEquals(1, l.indexOf(2));
    assertEquals(4, l.indexOf(5));
  }

  // Test 5: Test indexOf returns -1 for anything with emtpy list
  @Test
  public void testIndexIf5() {
    Integer[] ar = {};
    List<Integer> l = makeList(ar);
    assertEquals(-1, l.indexOf(0));
    assertEquals(-1, l.indexOf(1));
    assertEquals(-1, l.indexOf(null));
    assertEquals(-1, l.indexOf("test"));
  }

  // The subList(int fromIndex, int toIndex) method
  // Specification:
  // Returns a list containing the elements of the original list
  // from the fromIndex (inclusive) to the toIndex (exclusive).
  // The returned is backed by the original list, so non-structural changes
  // will be apparent in this returned list.
  // If fromIndex equals toIndex, the returned list will be empty. If
  // either of the indices are invalid, a IndexOutOfBoundsException will be throwm

  // Test 1: create a list and check if sub list of valid indexes
  // return appropriate lists
  @Test
  public void testSubList1(){
    Integer[] ar = {1, 2, 3, 4, 5};
    List<Integer> l = makeList(ar);
    assertEquals(l.subList(0,1), makeList(new Integer[] {1}));
    assertEquals(l.subList(0,2), makeList(new Integer[] {1, 2}));
    assertEquals(l.subList(0,3), makeList(new Integer[] {1, 2, 3}));
    assertEquals(l.subList(0,4), makeList(new Integer[] {1, 2, 3, 4}));
    assertEquals(l.subList(0,5), makeList(new Integer[] {1, 2, 3, 4, 5}));
  }

  // Test 2: create a list and check if subList returns an empty list if
  // indices are the same
  @Test
  public void testSubList2(){
    Integer[] ar = {1, 2, 3, 4, 5};
    List<Integer> l = makeList(ar);
    assertEquals(l.subList(0,0), makeList(new Integer[] {}));
    assertEquals(l.subList(1,1), makeList(new Integer[] {}));
    assertEquals(l.subList(2,2), makeList(new Integer[] {}));
    assertEquals(l.subList(3,3), makeList(new Integer[] {}));
    assertEquals(l.subList(4,4), makeList(new Integer[] {}));
  }

  // Test 3: create a list and check if it throws the proper exception
  // if the indices are invalid
  @Test
  public void testSubList3(){
    Integer[] ar = {1, 2, 3, 4, 5};
    List<Integer> l = makeList(ar);
    assertThrows(IndexOutOfBoundsException.class, () -> {l.subList(-1, 1);});
    assertThrows(IndexOutOfBoundsException.class, () -> {l.subList(1, 7);});
    assertThrows(IllegalArgumentException.class, () -> {l.subList(4, 1);});
  }

  // Test 4: create a list, get a sub list, and then make sure non-structural
  // changes reflect each other in resulting lists.
  @Test
  public void testSubList4(){
    Integer[] ar = {1, 2, 3, 4, 5};
    List<Integer> l = makeList(ar);
    List<Integer> subL = l.subList(0, 3);
    subL.set(0, 6);
    assertEquals(l.get(0), 6);
  }

  // Test 5: Test sublist on empty list
  @Test
  public void testSubList5() {
    Integer[] ar = {};
    List<Integer> l = makeList(ar);
    List<Integer> subL = l.subList(0, 0);
    assertEquals(0, subL.size());
    assertThrows(IndexOutOfBoundsException.class, () -> {l.subList(0, 1);});
  }
}
