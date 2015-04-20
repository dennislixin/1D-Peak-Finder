import java.util.*;

public class PeakFinder1DTest
{
  public static void main(String[] args){
    for(int i=1; i< 10; i++)
      test(i);
  }

  public static void test(int size){
    Integer[] array = new Integer[size];
    Random random = new Random();
    for(int i=0; i<size; i++)
      array[i] = random.nextInt(size + 1);

    PeakFinder finder = new PeakFinder<Integer>(array);
    System.out.println(Arrays.toString(array));
    System.out.println("peak = " + finder.find());
  }
}

class PeakFinder <E extends Comparable<? super E>>{
  private E[] array;
  public PeakFinder(E[] array){
    if(array == null || array.length == 0)
      throw new IllegalArgumentException("array cannot be null or 0");
    this.array = array;
  }

  public E find(){
    return findUtil(0, array.length - 1);
  }

  private E findUtil(int left, int right){
      int mid = (right - left)/2 + left;
      int newLeft = mid + 1;
      int newRight = mid - 1;

      if(newLeft <= right && array[newLeft].compareTo(array[mid]) > 0)
        return findUtil(newLeft, right);
      else if(newRight >= left && array[newRight].compareTo(array[mid]) > 0)
        return findUtil(left, newRight);
      else
        return array[mid];
  }
}
