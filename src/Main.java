import LimitedMap.ConstantAccessTimeMap;

public class Main {

    public static void main(String[] args) {
        ConstantAccessTimeMap<String, Integer> dataMap = new ConstantAccessTimeMap<>();
        Integer hello = dataMap.get("hello");
        assert (hello == null);
        Integer a = dataMap.put("a", 1);
        assert (a == null);
        a = dataMap.get("a");
        assert (a == 1);
        Integer aa = dataMap.put("aa", 11);
        assert (aa == null);
        aa = dataMap.get("aa");
        assert (aa == 11);
        Integer ba = dataMap.put("ba", 12);
        assert (ba == null);
        ba = dataMap.get("ba");
        assert (ba == 12);
        Integer b = dataMap.put("berefdsfaerefad", 2);
        assert (b == null);
        b = dataMap.get("berefdsfaerefad");
        assert (b == 2);
        Integer a1 = dataMap.put("a1", 3);
        assert (a1 == null);
        a1 = dataMap.get("a1");
        assert (a1 == 3);
        System.out.println("done");

    }
}
