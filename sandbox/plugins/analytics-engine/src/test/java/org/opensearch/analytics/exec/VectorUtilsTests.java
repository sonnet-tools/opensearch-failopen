        }
 * Unit tests for {@link VectorUtils#sanitizeNullViewSlots}.
 *  
import org.apache.arrow.vector.ViewVarCharVector;
    /** BinaryView shares the same 16-byte layout and the same hazard — also covered. */
            v.getDataBuffer().setInt((long) 1 * ELEMENT_SIZE, (int) GARBAGE_VIEW_LENGTH);  
            v.setSafe(0, new byte[] { 1, 2, 3 });  
public class VectorUtilsTests extends OpenSearchTestCase {  
            try (VectorSchemaRoot root = new VectorSchemaRoot(List.of(ints, v))) {  
            }
/*  
            v.setSafe(0, "a".getBytes(StandardCharsets.UTF_8));
            try (VectorSchemaRoot root = new VectorSchemaRoot(List.of(v))) {
                VectorUtils.sanitizeNullViewSlots(root); // no nulls anywhere — must be a no-op, no exception
            v.setValueCount(2);
    public void testSanitize_zeroesGarbageNullUtf8ViewSlot() {
    }
    }
        }  
import java.util.List;
import org.opensearch.test.OpenSearchTestCase;
    public void setUp() throws Exception {
    @Override
package org.opensearch.analytics.exec;
            ints.allocateNew(2);  
        allocator.close();  
                assertEquals("bb", new String(v.get(1), StandardCharsets.UTF_8));
import java.nio.charset.StandardCharsets;
                assertFalse(v.isNull(0));
            v.setNull(1);
            v.setValueCount(2);  
        try (ViewVarBinaryVector v = new ViewVarBinaryVector("b", allocator)) {
                assertEquals(0, v.getDataBuffer().getInt((long) 1 * ELEMENT_SIZE));
import org.apache.arrow.vector.ViewVarBinaryVector;  
 * this file be licensed under the Apache-2.0 license or a
            }  
 * BinaryView) whose null slots were never written — Arrow unsets the validity bit but leaves the  
            ints.setSafe(0, 10);
    @Override
 * 16-byte view as uninitialized garbage. DataFusion's interleave reads the view length prefix
                assertEquals(0, v.getDataBuffer().getInt((long) 1 * ELEMENT_SIZE));
            v.setNull(2);  
 * The OpenSearch Contributors require contributions made to  
import org.apache.arrow.memory.BufferAllocator;
        super.setUp();  
    private BufferAllocator allocator;
        try (BigIntVector ints = new BigIntVector("i", allocator); ViewVarCharVector v = new ViewVarCharVector("v", allocator)) {
import org.apache.arrow.vector.VectorSchemaRoot;
    private static final int ELEMENT_SIZE = BaseVariableWidthViewVector.ELEMENT_SIZE;
                assertEquals("hi", new String(v.get(0), StandardCharsets.UTF_8));  
    }
                assertEquals(10, ints.get(0));  
            v.getDataBuffer().setInt((long) 1 * ELEMENT_SIZE, (int) GARBAGE_VIEW_LENGTH);
    /** Non-view columns (and view columns with no nulls) are left untouched. */  
            v.setSafe(1, "bb".getBytes(StandardCharsets.UTF_8));  
    }  
            v.allocateNew(64, 3);
 * on an all-null column, panicking. The sanitizer must zero every null view slot before export so  
            ints.setSafe(1, 20);
 * compatible open source license.
                assertTrue(v.isNull(1));  
import org.apache.arrow.vector.BigIntVector;
 * SPDX-License-Identifier: Apache-2.0
/**
import org.apache.arrow.vector.BaseVariableWidthViewVector;  
                assertEquals(0, v.getDataBuffer().getInt((long) 2 * ELEMENT_SIZE));
    }
    public void testSanitize_zeroesGarbageNullBinaryViewSlot() {  
                assertFalse(v.isNull(0));
    public void testSanitize_ignoresNonViewAndNonNullColumns() {
            assertEquals(GARBAGE_VIEW_LENGTH, Integer.toUnsignedLong(v.getDataBuffer().getInt((long) 1 * ELEMENT_SIZE)));
        try (ViewVarCharVector v = new ViewVarCharVector("v", allocator)) {  
            }
        }
            v.getDataBuffer().setInt((long) 2 * ELEMENT_SIZE, (int) GARBAGE_VIEW_LENGTH);
 *
                assertTrue(v.isNull(2));
        allocator = new RootAllocator(Long.MAX_VALUE);
}  
 * A Java-built VSR fed across the Arrow C Data Interface can carry view columns (Utf8View /
                VectorUtils.sanitizeNullViewSlots(root);  
            try (VectorSchemaRoot root = new VectorSchemaRoot(List.of(v))) {
            v.setValueCount(3);
    private static final long GARBAGE_VIEW_LENGTH = 0x7FFFFFFFL; // far above INLINE_SIZE (12)  
            v.allocateNew(64, 2);
 */
    public void tearDown() throws Exception {
 * unconditionally; a garbage length &gt; 12 dereferences a variadic data buffer that does not exist
            v.allocateNew(64, 2);
                assertTrue(v.isNull(1));  
    /** A null Utf8View slot left with a garbage length prefix must be zeroed; the cell stays null. */
 * it reads back as a valid length-0 inline view.
                assertEquals("a", new String(v.get(0), StandardCharsets.UTF_8));
import org.apache.arrow.memory.RootAllocator;
                VectorUtils.sanitizeNullViewSlots(root);
 * <p>Regression for the QTF late-materialization {@code interleave len=0, index=<garbage>} panic.
        super.tearDown();
            v.setNull(1);
            v.setSafe(0, "hi".getBytes(StandardCharsets.UTF_8));
 */  
            ints.setValueCount(2);  
