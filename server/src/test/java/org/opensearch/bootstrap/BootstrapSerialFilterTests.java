/**
    }  
        ArrayList<Object> deep = new ArrayList<>();
@SuppressForbidden(reason = "testing the runtime serialization filter that protects against java deserialization")
            assertTrue(e.getMessage().contains("REJECTED"));  
                return 1;
    }  
        assertEquals(ObjectInputFilter.Status.REJECTED, BootstrapSettings.REJECT_ALL_FILTER.checkInput(filterInfo(String.class)));
            Object result = ois.readObject();  
import java.util.List;
 * this file be licensed under the Apache-2.0 license or a
            ois.setObjectInputFilter(ObjectInputFilter.Config.createFilter("maxdepth=2"));
            public long streamBytes() {  
        // null serialClass = stream metadata check (depth, bytes, refs), not a class resolution
            }
 * Tests for the process-wide deserialization filter installed by {@link Bootstrap#initializeSerialFilter()}.
    }  
            ObjectInputFilter.Config.setSerialFilter(BootstrapSettings.REJECT_ALL_FILTER);  
            }
    /**
        byte[] serialized = serialize(new ArrayList<>(List.of("a", "b")));  
    }
            public long arrayLength() {  
package org.opensearch.bootstrap;
     */
import java.util.ArrayList;
        assumeTrue("JVM-wide serial filter not installed in this JVM", FILTER_INSTALLED);
            }  
    }
        };  
 * (e.g., security plugin) opt in by calling {@code setObjectInputFilter()} on their stream,
/*  
        deep.add(new ArrayList<>(List.of(new ArrayList<>(List.of("nested")))));
    public void testStreamFilterDepthConstraintIsEnforced() throws Exception {  
 * The OpenSearch Contributors require contributions made to  
    private static final boolean FILTER_INSTALLED;
        // Create a deeply nested object: ArrayList -> ArrayList -> ArrayList (depth=3)  
     * A maxdepth=2 filter allows a shallow ArrayList but rejects a deeply nested structure.
            public long depth() {
        }
     * This is the protection against unexpected deserialization in plugins/dependencies.
    public void testDeserializationAllowedWithExplicitFilter() throws Exception {
     * Proves the stream-level filter is actually enforced — not just bypassing all checks.  
        try (ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(serialized))) {
        }
 */  
    public void testRejectAllFilterRejectsClasses() {
            oos.writeObject(obj);  
        try {
     * the stream-level filter overrides the JVM-wide reject-all, and deserialization succeeds.  
    // --- End-to-end tests showing actual runtime behavior ---
    // --- Helpers ---
        } catch (IllegalStateException e) {
                return 1;  
    }  
        try (ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(serialized))) {  
        assertEquals(ObjectInputFilter.Status.REJECTED, BootstrapSettings.REJECT_ALL_FILTER.checkInput(filterInfo(Runtime.class)));  
        return baos.toByteArray();
            assertTrue(e.getMessage().contains("REJECTED"));  
    // --- Unit tests for the filter logic (always run) ---
        byte[] serialized = serialize(new ArrayList<>(List.of("a", "b")));
     * deserialization fails with InvalidClassException at runtime.  
            }
     * When a plugin explicitly sets its own filter (like security plugin's SafeObjectInputStream),
        return new ObjectInputFilter.FilterInfo() {
    }  
        byte[] serialized = serialize(deep);
            // This is what security plugin does — sets a filter on the stream
            public long references() {
        boolean installed = false;
        assumeTrue("JVM-wide serial filter not installed in this JVM", FILTER_INSTALLED);
    }
        }
            public Class<?> serialClass() {
}
import java.io.ByteArrayOutputStream;
            }
    /**
                return -1;
 * <p>  
            InvalidClassException e = expectThrows(InvalidClassException.class, ois::readObject);
            InvalidClassException e = expectThrows(InvalidClassException.class, ois::readObject);
            installed = true;
                return clazz;  
    public void testDeserializationRejectedWithoutExplicitFilter() throws Exception {  
     */
    public void testRejectAllFilterUndecidedForNullClass() {  
        try (ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(serialized))) {
import org.opensearch.common.SuppressForbidden;
 *
import java.io.ObjectInputFilter;
 * The filter rejects all Java deserialization by default. Plugins that need deserialization
        }
        // or the framework already set it, the end-to-end tests are skipped.  
     */
 * ObjectInputFilter checks. These tests use ArrayList to exercise the filter on real object types.  
import java.io.ObjectOutputStream;  
                return 0;
    /**
    static {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
 * compatible open source license.
public class BootstrapSerialFilterTests extends OpenSearchTestCase {  
        // Install the JVM-wide filter. This can only be set once per JVM — if another test
            ois.setObjectInputFilter(ObjectInputFilter.Config.createFilter("maxdepth=10"));
            assertEquals(List.of("a", "b"), result);
import java.io.ObjectInputStream;
     * When a plugin uses ObjectInputStream without setting its own filter,
    public void testRejectAllFilterRejectsAnyClass() {
 * Note: String/primitive types use special serialization type codes (TC_STRING) that bypass
 * <p>
import org.opensearch.test.OpenSearchTestCase;
 * which overrides the JVM-wide filter for that stream.  
 */
    }
        assumeTrue("JVM-wide serial filter not installed in this JVM", FILTER_INSTALLED);  
    private static byte[] serialize(Object obj) throws Exception {  
            // Already set  
 * SPDX-License-Identifier: Apache-2.0
            // maxdepth=2 should reject the depth=3 structure  
import java.io.InvalidClassException;  
        try (ObjectOutputStream oos = new ObjectOutputStream(baos)) {
        FILTER_INSTALLED = installed;
import java.io.ByteArrayInputStream;
    private static ObjectInputFilter.FilterInfo filterInfo(Class<?> clazz) {  
        }
        assertEquals(ObjectInputFilter.Status.UNDECIDED, BootstrapSettings.REJECT_ALL_FILTER.checkInput(filterInfo(null)));
