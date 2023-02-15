package id.ac.ui.cs.advprog.tutorial1.transport.core;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LocationTest {

    private Class<?> locationClass;

    @BeforeEach
    void setUp() throws ClassNotFoundException {
        locationClass = Class.forName("id.ac.ui.cs.advprog.tutorial1.transport.core.Location");
    }

    @Test
    void locationClassShouldHaveGetNameMethod() throws NoSuchMethodException{
        Method getName = locationClass.getMethod("getName");
        assertTrue(Modifier.isPublic(getName.getModifiers()));
        assertEquals(0, getName.getParameterCount());
        assertEquals("java.lang.String", getName.getGenericReturnType().getTypeName());
    }

    @Test
    void locationClassShouldHaveGetDistanceMethod() throws NoSuchMethodException {
        Method getDistance = locationClass.getMethod("getDistance");
        assertTrue(Modifier.isPublic(getDistance.getModifiers()));
        assertEquals(0, getDistance.getParameterCount());
        assertEquals("java.lang.Double", getDistance.getGenericReturnType().getTypeName());
    }

}
