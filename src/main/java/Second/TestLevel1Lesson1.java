package Second;

import java.io.*;
import java.lang.reflect.*;
import java.net.*;

public class TestLevel1Lesson1 {
    public static void main(String[] args){
        try {
            File file = new File("src\\");
            URL url = file.toURL();
            URL[] urls = new URL[]{url};
            ClassLoader cl = new URLClassLoader(urls);
            Class<?> cls = cl.loadClass("GB.Main");
            Object obj = cls.newInstance();
            Method[] methods = cls.getDeclaredMethods();
            System.out.println("Доступные методы проверяемого класса:");
            for (Method m : methods) {
                System.out.println(m);
            }

            Method m1 = cls.getDeclaredMethod("leapYear", short.class);
            m1.setAccessible(true);
            System.out.println("\nПроверка метода определения високосного года:");
            System.out.print("Ожидание: Год 2020 високосный  ->  Метод: ");
            m1.invoke(obj, (short)2020);

            Method m2 = cls.getDeclaredMethod("positiveNegative", int.class);
            m2.setAccessible(true);
            System.out.println("\nПроверка метода определения знака числа:");
            System.out.print("Ожидание: Число 6 положительное  ->  Метод: ");
            m2.invoke(obj, 6);

            Method m3 = cls.getDeclaredMethod("name", String.class);
            m3.setAccessible(true);
            System.out.println("\nПроверка метода определения вывода приветствия:");
            System.out.print("Ожидание: Привет, Дюк! ->  Метод: ");
            m3.invoke(obj, "Дюк");

            Method m4 = cls.getDeclaredMethod("print");
            m4.setAccessible(true);
            System.out.println("\nПроверка печати в консоль \"End\":");
            System.out.print("Ожидание: End ->  Метод: ");
            m4.invoke(obj);

        } catch (MalformedURLException | ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

}
