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

        // 3. The name of the interfaces the class implements
        Class<?>[] interfaces = clazz.getInterfaces();
        if (interfaces.length > 0) {
            System.out.println("Implemented Interfaces:");
            for (Class<?> intf : interfaces) {
                System.out.println(intf.getName());
            }
        }

        // 4. The methods the class declares
        Method[] methods = clazz.getDeclaredMethods();
        if (methods.length > 0) {
            System.out.println("Declared Methods:");
            for (Method method : methods) {
                System.out.println("Name: " + method.getName());
                System.out.println("Return Type: " + method.getReturnType().getName());
                System.out.println("Modifiers: " + Modifier.toString(method.getModifiers()));
                System.out.println("Parameter Types: " + Arrays.toString(method.getParameterTypes()));
                System.out.println("Exceptions Thrown: " + Arrays.toString(method.getExceptionTypes()));
                System.out.println();
            }
        }

        // 5. The constructors the class declares
        Constructor<?>[] constructors = clazz.getDeclaredConstructors();
        if (constructors.length > 0) {
            System.out.println("Declared Constructors:");
            for (Constructor<?> constructor : constructors) {
                System.out.println("Parameter Types: " + Arrays.toString(constructor.getParameterTypes()));
                System.out.println("Modifiers: " + Modifier.toString(constructor.getModifiers()));
            }
        }

        // 6. The fields the class declares
        Field[] fields = clazz.getDeclaredFields();
        if (fields.length > 0) {
            System.out.println("Declared Fields:");
            for (Field field : fields) {
                System.out.println("Name: " + field.getName());
                System.out.println("Type: " + field.getType().getName());
                System.out.println("Modifiers: " + Modifier.toString(field.getModifiers()));

                if (!recursive || !field.getType().isPrimitive()) {
                    try {
                        field.setAccessible(true);
                        System.out.println("Value: " + field.get(obj));
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println();
            }
        }

    }
}
