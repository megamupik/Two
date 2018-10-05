package Class;

import java.util.Date;

class Classis {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Date d = new Date();
        System.out.println(d);
        java.lang.Class<? extends Date> cl = d.getClass();
        System.out.println(cl);
        String name = cl.getName();
        System.out.println(name);
        // в переменной name устанавливается
        // в строковое значение "java.util.Date"

        String className = "java.util.Date";
        Class cl2 = null;
        try {
            cl2 = Class.forName(className);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String name2 = cl2.getName();
        System.out.println(name2);

        System.out.println(Double[].class.getName());
        System.out.println(int[].class.getName());

        Class cl11 = Date.class;
        Class cl22 = int.class;
        Class cl33 = Double[].class;

        System.out.println(cl11);
        System.out.println(cl22);
        System.out.println(cl33);

        String s = "java.util.Date";
        Object m = Class.forName(s).newInstance();
        System.out.println(m);
    }
}