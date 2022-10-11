import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;


public class Task {
    public static void main(String[] args) {

        //1. Объявить и инициализировать множества HashSet hs, LinkedHashSet lhs и TreeSet ts

        HashSet<Integer> hs = new HashSet<>();
        LinkedHashSet<Integer> lhs = new LinkedHashSet<>();
        TreeSet<Integer> ts = new TreeSet<>();

        System.out.println(hs + " - HashSet (hs)\n" + lhs + " - LinkedHashSet (lhs)\n" + ts + " - TreeSet (ts)");

        //2. Добавить в множества по 10 случайных целочисленных ключей.
        System.out.println("Добавить в множества по 10 случайных целочисленных ключей");
        hs.addAll(randomList(10));
        lhs.addAll(randomList(10));
        ts.addAll(randomList(10));
        System.out.println("hs: " + hs + "\nlhs: " + lhs + "\nts: " + ts + "\n");

        //3. Пройти по множеству hs и, при условии наличия соответствующего ключа в множестве lhs, удалить ключ из hs
        System.out.println("Пройти по множеству hs и, при условии наличия соответствующего ключа в множестве lhs, удалить ключ из hs");
        System.out.println("hs:" + removeKey(hs, lhs)+ "\n");

        //4. Пройти по множеству lhs и, при условии отсутствия соответствующего ключа в множестве ts, добавит ключ в ts
        System.out.println("Пройти по множеству lhs и, при условии отсутствия соответствующего ключа в множестве ts, добавит ключ в ts");
        System.out.println("lhs:" + addKey(lhs, ts) + "\n");

        //5. Объявить и инициализировать множество TreeSet ts1 с компаратором Integer (-1 при значении %2==0 ;0 при ==;1 при значении %2!=0). 
            //Заполнить ts1 15 случайными числами и вывести на печать.
        
        System.out.println("Объявить и инициализировать множество TreeSet ts1 с компаратором Integer (-1 при значении %2==0 ;0 при ==;1 при значении %2!=0)");
        System.out.println("Заполнить ts1 15 случайными числами и вывести на печать.");

        Set<Integer> ts1 = new TreeSet<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer int1, Integer int2) {
                return int1 == int2 ? 0 : int2 % 2 == 0 ? -1 : 1;
            }
        });
        ts1.addAll(randomList(15));
        System.out.println("ts1: " + ts1 + "\n");
    }

    private static List<Integer> randomList (int sizeList) {
        List<Integer> randList = new ArrayList<>();
        while (randList.size() < sizeList) {
            randList.add((int) (Math.random()*100));
        }
        return randList;
    }
    private static Set<Integer> removeKey (Set<Integer> hs, Set<Integer> lhs) {
        hs.removeAll(lhs);
        return hs;
    }
    private static Set<Integer> addKey (Set<Integer> lhs, Set<Integer> ts) {
        lhs.addAll(ts);
        return lhs;
    } 
}
