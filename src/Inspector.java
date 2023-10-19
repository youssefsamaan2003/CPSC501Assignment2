import java.lang.reflect.*;
import java.util.Arrays;

public class Inspector {

    public void inspect(Object obj, boolean recursive) {
        Class<?> clazz = obj.getClass();
        // 1. The name of the declaring class
        System.out.println("Declaring Class: " + clazz.getName());

        // 2. The name of the immediate superclass
        Class<?> superClass = clazz.getSuperclass();
        if (superClass != null) {
            System.out.println("Immediate Superclass: " + superClass.getName());
        }
    }
}
