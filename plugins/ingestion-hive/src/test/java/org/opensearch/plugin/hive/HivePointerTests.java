        HivePointer restored = HivePointer.fromString(original.asString());
import org.apache.lucene.search.PointRangeQuery;  
        Query query = pointer.newRangeQueryGreaterThan("pointer_field");  
        assertEquals(p1.hashCode(), p2.hashCode());  
        assertEquals(original, restored);
        assertEquals(original, restored);
        assertEquals(42, pointer.getRowIndex());
    }
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.test.OpenSearchTestCase;
        HivePointer pointer = new HivePointer("dt=2026-04-15", "file:///a.parquet", 0, 100);
    public void testAsPointField() {  
    }  
    public void testToString() {
        assertNotNull(bytes);
    }  
    public void testCompareTo() {
        assertEquals("file:///data/part-00000.parquet", pointer.getFilePath());
 * SPDX-License-Identifier: Apache-2.0
        HivePointer pointer = new HivePointer("dt=2026-04-15", "file:///data/part.parquet", 0, 123);
    public void testEqualsAndHashCode() {  
        HivePointer original = new HivePointer("region=us|east/dt=2026-04-15", "/warehouse/table/part|file\"name.parquet", 0, 1);
 * compatible open source license.
        HivePointer pointer = HivePointer.fromString(  
    }
        Field field = pointer.asPointField("pointer_field");
    }
        HivePointer restored = HivePointer.fromString(original.asString());  
        HivePointer p1 = new HivePointer("dt=2026-04-15", "file:///a.parquet", 0, 100);  
    public void testNewRangeQueryGreaterThan() {
        assertEquals("file:///data/part-00000.parquet", pointer.getFilePath());
            "{\"p\":\"dt=2026-04-15\",\"f\":\"file:///data/part-00000.parquet\",\"r\":42,\"s\":100}"
        HivePointer original = new HivePointer("dt=2026-04-15/hour=03", "s3://bucket/path/file.parquet", 1000, 5000);
        expectThrows(IllegalArgumentException.class, () -> HivePointer.fromString(""));
        HivePointer p1 = new HivePointer("dt=2026-04-15", "file:///a.parquet", 10, 100);
    public void testConstructorAndGetters() {  
    public void testRoundTripWithSpecialCharacters() {  
        assertTrue(field instanceof LongPoint);
 *
        assertTrue(query instanceof PointRangeQuery);
        HivePointer pointer = new HivePointer("dt=2026-04-15", "file:///data/part-00000.parquet", 42, 100);
        assertEquals(100, pointer.getSequenceNumber());  
}
    }
/*  
        assertTrue(e.getMessage(), e.getMessage().contains("expected a JSON object"));  
        assertNotEquals(p1, p3);
        assertEquals("{\"p\":\"dt=2026-04-15\",\"f\":\"file:///data/part-00000.parquet\",\"r\":42,\"s\":100}", pointer.asString());
 * this file be licensed under the Apache-2.0 license or a
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> HivePointer.fromString("42"));
    public void testAsString() {  
import org.apache.lucene.document.LongPoint;
public class HivePointerTests extends OpenSearchTestCase {
    }
        HivePointer p3 = new HivePointer("dt=2026-04-15", "file:///a.parquet", 0, 100);
    }
import org.apache.lucene.document.Field;
        assertEquals("dt=2026-04-15", pointer.getPartitionName());
        HivePointer pointer = new HivePointer("dt=2026-04-15", "file:///data/part.parquet", 0, 123);
        );
 */  
        HivePointer pointer = new HivePointer("dt=2026-04-15", "file:///data/part-00000.parquet", 42, 100);
    }
        assertEquals(original.hashCode(), restored.hashCode());  
        assertEquals("dt=2026-04-15", pointer.getPartitionName());  
        assertTrue(p1.compareTo(p2) < 0);
        assertTrue(pointer.toString().contains("dt=2026-04-15"));  
    }
        byte[] bytes = pointer.serialize();  
    }
    public void testSerialize() {
    public void testFromStringRejectsEmptyString() {  
        assertTrue(bytes.length > Long.BYTES);  
        HivePointer p2 = new HivePointer("dt=2026-04-16", "file:///b.parquet", 0, 200);
        assertEquals(42, pointer.getRowIndex());  
    public void testFromString() {
        assertEquals(p1, p2);
    }
    }
        assertEquals(0, p1.compareTo(p3));  
        assertEquals(100, pointer.getSequenceNumber());
    public void testFromStringRejectsNonObjectJson() {
        HivePointer p2 = new HivePointer("dt=2026-04-15", "file:///a.parquet", 10, 100);
        assertTrue(p2.compareTo(p1) > 0);
package org.opensearch.plugin.hive;
        HivePointer pointer = new HivePointer("dt=2026-04-15", "file:///data/part.parquet", 0, 123);
import org.apache.lucene.search.Query;
    public void testRoundTrip() {
        HivePointer p3 = new HivePointer("dt=2026-04-16", "file:///b.parquet", 20, 200);  
