import java.util.*;
import java.util.logging.Logger;

public class TestSort {

    private static Logger logger = Logger.getLogger(TestSort.class.getClass().getName());

    public static int LENGTH = 10000000;
    public static int SELECT_INSERT_BUBBLE_MAX = 100000;

    /**
     -- 1千长度数组
     快速排序1000长度的数组耗时：1 毫秒
     堆排序1000长度的数组耗时：2 毫秒
     插入排序1000长度的数组耗时：13 毫秒
     选择排序1000长度的数组耗时：14 毫秒
     shell排序1000长度的数组耗时：15 毫秒
     归并排序1000长度的数组耗时：17 毫秒
     冒泡排序1000长度的数组耗时：28 毫秒

     -- 1万长度数据
     归并排序10000长度的数组耗时：7 毫秒
     快速排序10000长度的数组耗时：12 毫秒
     堆排序10000长度的数组耗时：21 毫秒
     shell排序10000长度的数组耗时：18 毫秒
     插入排序10000长度的数组耗时：94 毫秒
     选择排序10000长度的数组耗时：234 毫秒
     冒泡排序10000长度的数组耗时：473 毫秒

     --- 10万数组长度时
     归并排序100000长度的数组耗时：116 毫秒
     堆排序100000长度的数组耗时：136 毫秒
     shell 排序100000长度的数组耗时：160 毫秒
     快速排序100000长度的数组耗时：249 毫秒
     插入排序100000长度的数组耗时：4532 毫秒
     选择排序100000长度的数组耗时：13218 毫秒
     冒泡排序100000长度的数组耗时：34895 毫秒

     -- 100万长度数组
     快速排序1000000长度的数组耗时：879 毫秒
     归并排序1000000长度的数组耗时：962 毫秒
     堆排序1000000长度的数组耗时：1057 毫秒
     shell排序1000000长度的数组耗时：1377 毫秒


     -- 500万长度数组
     快速排序5000000长度的数组耗时：1984 毫秒
     归并排序5000000长度的数组耗时：2726 毫秒
     堆排序5000000长度的数组耗时：3413 毫秒
     shell排序5000000长度的数组耗时：3689 毫秒

     -- 1000万长度数组
     快速排序10000000长度的数组耗时：5555 毫秒
     归并排序10000000长度的数组耗时：6915 毫秒
     堆排序10000000长度的数组耗时：9461 毫秒
     shell排序10000000长度的数组耗时：9996 毫秒
     * @param args
     */
    public static void main(String[] args) {
        testSortShell();
        testSortMerge();
        testSortHeap();
        testSortQuick();
        //testSortSelect();
        //testSortBubble();
        //testSortInsert();
    }
    public static int[]  structArray(){
        return listArray();
    }

    public static void  testSortShell(){
        new Thread(()->{
            int[]  arr = structArray();
            long begin = System.currentTimeMillis();
            ArraySortAlgorithm.sortShell(arr);
            System.out.println("shell排序" + LENGTH +"长度的数组耗时：" + (System.currentTimeMillis() - begin) + " 毫秒");
        }).start();
    }
    public static void  testSortHeap(){
        new Thread(()->{
            int[]  arr = structArray();
            long begin = System.currentTimeMillis();
            ArraySortAlgorithm.sortHeap(arr);
            System.out.println("堆排序" + LENGTH +"长度的数组耗时：" + (System.currentTimeMillis() - begin) + " 毫秒");
        }).start();
    }

    /**
     * 构建1000000长度的数组耗时：2259 毫秒
     * 插入法排序1000000长度的数组耗时： ---  毫秒
     */
    public static void  testSortInsert(){
        new Thread(()->{
            if(LENGTH <= SELECT_INSERT_BUBBLE_MAX) {
                int[] arr = structArray();
                long begin = System.currentTimeMillis();
                ArraySortAlgorithm.sortInsert(arr);
                System.out.println("插入排序" + LENGTH + "长度的数组耗时：" + (System.currentTimeMillis() - begin) + " 毫秒");
            }
        }).start();
    }

    /**
     * 构建1000000长度的数组耗时：2259 毫秒
     * 快速排序1000000长度的数组耗时：323 毫秒
     */
    public static void  testSortQuick(){
        new Thread(()->{
            int[]  arr = structArray();
            long begin = System.currentTimeMillis();
            ArraySortAlgorithm.sortQuick(arr);
            System.out.println("快速排序" + LENGTH +"长度的数组耗时：" + (System.currentTimeMillis() - begin) + " 毫秒");
        }).start();
    }

    /**
     *
     */
    public static void  testSortSelect(){
        new Thread(()->{
            if(LENGTH <= SELECT_INSERT_BUBBLE_MAX) {
                int[]  arr = structArray();
                long begin = System.currentTimeMillis();
                ArraySortAlgorithm.sortSelect(arr);
                System.out.println("选择排序" + LENGTH +"长度的数组耗时：" + (System.currentTimeMillis() - begin) + " 毫秒");
            }
        }).start();
    }

    /**
     *
     */
    public static void  testSortBubble(){
        new Thread(()->{
            if(LENGTH <= SELECT_INSERT_BUBBLE_MAX) {
                int[] arr = structArray();
                long begin = System.currentTimeMillis();
                ArraySortAlgorithm.sortBubble(arr);
                System.out.println("冒泡排序" + LENGTH + "长度的数组耗时：" + (System.currentTimeMillis() - begin) + " 毫秒");
            }
        }).start();
    }

    /**
     *
     */
    public static void  testSortMerge(){
        new Thread(()->{
            int[]  arr = structArray();
            long begin = System.currentTimeMillis();
            ArraySortAlgorithm.sortMerge(arr);
            System.out.println("归并排序" + LENGTH +"长度的数组耗时：" + (System.currentTimeMillis() - begin) + " 毫秒");
        }).start();
    }

    public static int[]  listArray(){
        long begin = System.currentTimeMillis();
        List<Integer> list = new ArrayList<>();
        Random random =  new Random();
        while (list.size() < LENGTH) {
            list.add(random.nextInt(LENGTH * 10));
        }
        logger.info("构建" + list.size() +"长度的数组耗时：" + (System.currentTimeMillis() - begin) + " 毫秒");
        Integer[] integerArr =  list.toArray(new Integer[]{});
        return Arrays.stream(integerArr).mapToInt(Integer::valueOf).toArray();
    }
    public static int[] setArray(){
        long begin = System.currentTimeMillis();
        Set<Integer> set = new HashSet<Integer>();
        Random random =  new Random();
        while (set.size() < LENGTH) {
            set.add(random.nextInt(LENGTH * 10));
        }
        logger.info("构建" + set.size() +"长度的数组耗时：" + (System.currentTimeMillis() - begin) + " 毫秒");
        Integer[] integerArr =  set.toArray(new Integer[]{});
        return Arrays.stream(integerArr).mapToInt(Integer::valueOf).toArray();
    }
}
