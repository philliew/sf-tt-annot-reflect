package reflect;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

public class ReflectionOne {
    public static void main(String[] args) throws Throwable {
//        Object o = new Stuff();
//
//        Class cl = o.getClass();

        Properties prop = new Properties();
        prop.load(Files.newBufferedReader(Paths.get("fred.properties")));
        String className = prop.getProperty("loadthis");
        System.out.println("Classname to load is: " + className);

//        System.setSecurityManager(new SecurityManager());

        Class cl = Class.forName(className);
        System.out.println("Class is " + cl);
        System.out.println("Classname is " + cl.getName());

        Constructor cons = cl.getConstructor();
        Object o = cons.newInstance();
        Field[] fields = cl.getDeclaredFields();

        for (Field f : fields) {
            System.out.println(">> " + f);
            if (f.getName().equals("count")) {
                f.setAccessible(true);
                f.setInt(o, 1234);
            }
        }

        Method[] methods = cl.getDeclaredMethods();
        for (Method m : methods) {
            System.out.println("> " + m);
//            if (m.getName().equals("doSomeAction")) {
//                m.invoke(o, 99);
//            } else if (m.getName().equals("staticMethod")) {
//                m.invoke(null);
//            }

            RunMe annot = m.getAnnotation(RunMe.class);
            if (annot != null) {
                System.out.println("**** RunMe Annotation found");
                m.setAccessible(true); // "disableAccessChecks..."
                m.invoke(o);
            }
        }

    }
}
