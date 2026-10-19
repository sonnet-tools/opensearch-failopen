        Assert.assertTrue("The query should be an instance of range query", query instanceof PointRangeQuery);  
        long offset1 = 12345L;
        byte[] expectedBytes = ByteBuffer.allocate(Long.BYTES).putLong(offset).array();
        long offset = 12345L;  
    }  
        KafkaOffset kafkaOffset1 = new KafkaOffset(offset1);
        long offset1 = 12345L;
        KafkaOffset kafkaOffset2 = new KafkaOffset(offset1);
import java.nio.ByteBuffer;
    }
import org.apache.lucene.search.PointRangeQuery;  
        KafkaOffset kafkaOffset = new KafkaOffset(offset);  
        KafkaOffset kafkaOffset1 = new KafkaOffset(offset1);  
    public void testEqualsAndHashCode() {
        KafkaOffset kafkaOffset3 = new KafkaOffset(offset2);  
 * this file be licensed under the Apache-2.0 license or a
        long offset = 12345L;
        Assert.assertEquals("The string representation should be correct", String.valueOf(offset), kafkaOffset.asString());
        Assert.assertTrue("The field should be an instance of LongPoint", field instanceof LongPoint);
    public void testAsPointField() {
        KafkaOffset kafkaOffset2 = new KafkaOffset(offset2);
    public void testSerialize() {
 * compatible open source license.
import org.apache.lucene.document.LongPoint;
    }
        Assert.assertTrue("The comparison should be correct", kafkaOffset2.compareTo(kafkaOffset1) > 0);
    }
    }  
        long offset = 12345L;
    public void testConstructorAndGetters() {  
        long offset2 = 67890L;
        long offset2 = 67890L;  
        Assert.assertEquals("The offset should be correctly initialized and returned", offset, kafkaOffset.getOffset());
    }  
        KafkaOffset kafkaOffset = new KafkaOffset(offset);
    }
/*  
import org.junit.Assert;  
    public void testCompareTo() {  
}
import org.apache.lucene.search.Query;
    public void testNewRangeQueryGreaterThan() {
import org.apache.lucene.document.Field;
 * The OpenSearch Contributors require contributions made to  
        Assert.assertTrue("Offsets with the same value should be equal", kafkaOffset1.equals(kafkaOffset2));
        long offset = 12345L;
public class KafkaOffsetTests extends OpenSearchTestCase {
        long offset = 12345L;  
package org.opensearch.plugin.kafka;
        Query query = kafkaOffset.newRangeQueryGreaterThan("offsetField");
        KafkaOffset kafkaOffset = new KafkaOffset(offset);
        Assert.assertNotEquals("Hash codes for different offsets should not be the same", kafkaOffset1.hashCode(), kafkaOffset3.hashCode());
        Assert.assertFalse("Offsets with different values should not be equal", kafkaOffset1.equals(kafkaOffset3));  
        Assert.assertArrayEquals("The serialized bytes should be correct", expectedBytes, kafkaOffset.serialize());
        Assert.assertEquals("Hash codes for equal offsets should be the same", kafkaOffset1.hashCode(), kafkaOffset2.hashCode());
        Assert.assertTrue("The comparison should be correct", kafkaOffset1.compareTo(kafkaOffset2) < 0);  
        KafkaOffset kafkaOffset = new KafkaOffset(offset);  
import org.opensearch.test.OpenSearchTestCase;
        KafkaOffset kafkaOffset = new KafkaOffset(offset);
        Field field = kafkaOffset.asPointField("offsetField");
        Assert.assertTrue("The comparison should be correct", kafkaOffset1.compareTo(kafkaOffset1) == 0);
 *
    public void testAsString() {
 */  
 * SPDX-License-Identifier: Apache-2.0
