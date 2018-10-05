package pair1;

public class ArrayAlg {
    /**
     * Получает символьные строки с мин. и мак. и значениями среди элементов массива
     * @param a Массив символьных строк
     * @return Пара мин. и мак. значений или пустое,
     * если параметр a имеет пустое значение
     */
    static Pair<String> minmax(String[] a){
        if (a == null || a.length == 0) return null;
        String min = a[0];
        String max = a[0];
        for (int i = 1; i < a.length; i++){
            if (min.compareTo(a[i]) > 0) min = a[i];
            if (max.compareTo(a[i]) < 0) max = a[i];
        }
        return new Pair<>(min, max);
    }

    public static <T extends Comparable> T min(T[] a){ // Почти верно
        if (a == null || a.length == 0) return null;
        T smallest = a[0];
        for (int i = 1; i < a.length; i++){
            if (smallest.compareTo(a[i]) > 0) smallest = a[i];
        }
        return smallest;
    }
}
