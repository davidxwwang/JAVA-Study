package collections;

import java.util.Comparator;
import java.util.HashMap;
import java.util.TreeMap;

// todo Map的key不能重复
// 相比 hashMap 它的增删改查都是log（n），而不是O(1),但是它的优点在于可以自定义排序，
public class map {


    static void testTreeMap(){

        TreeMap<String, String> treeMap = new TreeMap<>(new Comparator<String>() {
            @Override
            // 这里比较的是key
            public int compare(String o1, String o2) {
                return -1;
            }
        });

        treeMap.put("s0","v1");
        treeMap.put("s1","v2");

        String xx= treeMap.lastKey();
    }

    // HashMap是无序的,它的key不能重复
    static void testHashMap(){

        HashMap<String,String> hashMap = new HashMap<>();
        hashMap.put("乒乓球","1");
        hashMap.put("足球","2");
        hashMap.put("羽毛球","3");
        hashMap.put("羽毛","3");


        String var = hashMap.get("羽毛");

        for (String key: hashMap.keySet()){
            // 打印是无序的
            System.out.print(key);
        }

    }


    public static void main(String[] args) {

        testHashMap();

        testTreeMap();


    }
}
