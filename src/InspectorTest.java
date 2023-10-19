import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InspectorTest {
    private Inspector inspector;

    @BeforeEach
    public void setUp() {
        inspector = new Inspector();
    }

    @Test
    public void testInspectSimpleObject() {
        SimpleObject simpleObject = new SimpleObject();
        inspector.inspect(simpleObject, false);
        // TODO: You can add assertions here to check the printed output.
    }

    @Test
    public void testInspectComplexObject() {
        ComplexObject complexObject = new ComplexObject();
        inspector.inspect(complexObject, false);
        // TODO: You can add assertions here to check the printed output.
    }

    @Test
    public void testInspectRecursive() {
        ComplexObject complexObject = new ComplexObject();
        inspector.inspect(complexObject, true);
        // TODO: You can add assertions here to check the printed output.
    }

    // Define test classes for your objects
    private static class SimpleObject {
        private int intValue;
        private String stringValue;

        public SimpleObject() {
            intValue = 42;
            stringValue = "Hello, World!";
        }
    }

    private static class ComplexObject {
        private int intValue;
        private String stringValue;
        private ArrayList<String> stringList;

        public ComplexObject() {
            intValue = 42;
            stringValue = "Hello, World!";
            stringList = new ArrayList<>();
            stringList.add("One");
            stringList.add("Two");
        }
    }
}
