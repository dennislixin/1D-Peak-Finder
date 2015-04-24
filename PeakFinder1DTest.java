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

    System.out.println(Arrays.toString(array));
    System.out.println("peak = " + findPeak(array));
  }

  public static <E extends Comparable<? super E>> E findPeak(E[] array){
    if(array == null || array.length == 0)
      return null;

    return findPeakUtil(array, 0, array.length-1);
  }

  private static <E extends Comparable<? super E>> E findPeakUtil(E[] array, int left, int right){
    int mid = (right - left)/2 + left;
    int newLeft = mid + 1;
    int newRight = mid - 1;

    if(newLeft <= right && array[newLeft].compareTo(array[mid]) > 0)
      return findPeakUtil(array, newLeft, right);
    else if(newRight >= left && array[newRight].compareTo(array[mid]) > 0)
      return findPeakUtil(array, left, newRight);
    else
      return array[mid];
  }
}
