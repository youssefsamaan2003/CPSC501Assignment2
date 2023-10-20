import org.junit.Test;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class InspectorTest {

    @Test
    public void testInspectPrimitiveTypes() {
        int primitiveInt = 42;
        double primitiveDouble = 3.14;
        String primitiveString = "Hello";
        boolean primitiveBoolean = true;
        char primitiveChar = 'A';

        Inspector inspector = new Inspector();

        try {
            inspector.inspect(primitiveInt, true);
            inspector.inspect(primitiveDouble, true);
            inspector.inspect(primitiveString, true);
            inspector.inspect(primitiveBoolean, true);
            inspector.inspect(primitiveChar, true);
        } catch (Exception e) {
            fail("Exception thrown during inspection: " + e.getMessage());
        }

        // Add specific assertions for the primitive values
        assertEquals("int", inspector.getClass().getName());
        assertEquals("double", inspector.getClass().getName());
        assertEquals("java.lang.String", inspector.getClass().getName());
        assertEquals("boolean", inspector.getClass().getName());
        assertEquals("char", inspector.getClass().getName());
    }

    @Test
    public void testInspectArray() {
        int[] intArray = { 1, 2, 3, 4, 5 };
        String[] stringArray = { "One", "Two", "Three" };

        Inspector inspector = new Inspector();

        try {
            inspector.inspect(intArray, true);
            inspector.inspect(stringArray, true);
        } catch (Exception e) {
            fail("Exception thrown during inspection: " + e.getMessage());
        }

        // Add specific assertions for the array values
        assertEquals("[I", inspector.getClass().getName()); // int array
        assertEquals("[Ljava.lang.String;", inspector.getClass().getName()); // String array
    }

    @Test
    public void testInspectCollections() {
        List<String> stringList = new ArrayList<>();
        stringList.add("One");
        stringList.add("Two");
        stringList.add("Three");

        Map<Integer, String> map = new HashMap<>();
        map.put(1, "One");
        map.put(2, "Two");
        map.put(3, "Three");

        Inspector inspector = new Inspector();

        try {
            inspector.inspect(stringList, true);
            inspector.inspect(map, true);
        } catch (Exception e) {
            fail("Exception thrown during inspection: " + e.getMessage());
        }

        // Add specific assertions for the collections
        assertEquals("java.util.ArrayList", inspector.getClass().getName()); // ArrayList
        assertEquals("java.util.HashMap", inspector.getClass().getName()); // HashMap
    }

    @Test
    public void testInspectEnum() {
        DayOfWeek dayOfWeek = DayOfWeek.MONDAY;
        Inspector inspector = new Inspector();

        try {
            inspector.inspect(dayOfWeek, true);
        } catch (Exception e) {
            fail("Exception thrown during inspection: " + e.getMessage());
        }

        // Add specific assertions for the enum
        assertEquals("java.time.DayOfWeek", inspector.getClass().getName());
    }
}
