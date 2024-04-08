package utils;

import java.util.List;

public class Utils<T> {
    public static <T> T[] listToArray(List<T> list){
        T[] array = (T[]) new Object[list.size()];

        int i = 0;
        for (T iterador : list){
            array[i++] = iterador;
        }

        return array;
    }
}
