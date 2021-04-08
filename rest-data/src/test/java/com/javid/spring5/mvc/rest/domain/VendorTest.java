package com.javid.spring5.mvc.rest.domain;

import net.bytebuddy.utility.RandomString;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Javid on 4/8/2021.
 */

class VendorTest {

    Vendor vendor;
    Vendor vendor1;

    @BeforeEach
    void setUp() {
        var id = new Random().nextLong();
        var name = new RandomString().nextString();

        vendor = new Vendor().setId(id).setName(name);
        vendor1 = new Vendor().setId(id).setName(name);
    }

    @Test
    void testEquals() {
        assertEquals(vendor, vendor);
        assertEquals(vendor1, vendor);
        assertNotEquals(vendor, new Vendor());
        assertNotEquals(vendor, new Object());
    }

    @Test
    void canEqual() {
        assertTrue(new Vendor().canEqual(new Vendor()));
        assertFalse(new Vendor().canEqual(new Object()));
    }

    @Test
    void testHashCode() {
        assertEquals(vendor.hashCode(), vendor1.hashCode());
        assertNotEquals(vendor.hashCode(), new Vendor().hashCode());
    }

    @Test
    void testToString() {
        assertEquals(vendor.toString(), vendor1.toString());
        assertNotEquals(vendor.toString(), new Vendor().toString());
    }
}