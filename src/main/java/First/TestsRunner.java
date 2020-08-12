package First;

import java.lang.reflect.*;

public class TestsRunner {

    public static void main(String[] args) {
        try {
            start("First.Test1");
            start(Test3.class);
            start(Test2.class);
            start("First.Test2");
        } catch (RuntimeException e){
            e.printStackTrace();
        }
    }

    static void start(String testClassName) throws RuntimeException{
        try {
            Class<?> cl = Class.forName(testClassName);
            Object obj = cl.newInstance();
            startStage2(cl, obj);
        } catch (IllegalAccessException | InvocationTargetException | ClassNotFoundException | InstantiationException e) {
            e.printStackTrace();
        }
    }

    static void start(Class<?> cl) throws RuntimeException{
        try {
            Object obj = cl.newInstance();
            startStage2(cl, obj);
        } catch (IllegalAccessException | InvocationTargetException | InstantiationException e) {
            e.printStackTrace();
        }
    }

    static void startStage2(Class<?> cl, Object obj) throws InvocationTargetException, IllegalAccessException, RuntimeException {
        Method[] methods = cl.getMethods();
        int beforeSuiteCount = 0;
        int afterSuiteCount = 0;
        for (Method m : methods) {
            if (m.getAnnotation(BeforeSuite.class) != null) beforeSuiteCount++;
            if (m.getAnnotation(AfterSuite.class) != null) afterSuiteCount++;
        }
        if (beforeSuiteCount != 1 || afterSuiteCount != 1) throw new RuntimeException("Before/AfterSuite count exception");
        for (Method m : methods) {
            if (m.isAnnotationPresent(BeforeSuite.class)) {
                m.invoke(obj);
            }
        }
        int priority = 10;
        while (priority > 0){
            for (Method m : methods) {
                if(m.getAnnotation(Test.class) != null) {
                    Test testAnnotation = m.getAnnotation(Test.class);
                    if (testAnnotation.priority() == priority) m.invoke(obj);
                }
            }
            priority--;
        }
        for (Method m : methods) {
            if (m.isAnnotationPresent(AfterSuite.class)) {
                m.invoke(obj);
            }
        }
    }

}
