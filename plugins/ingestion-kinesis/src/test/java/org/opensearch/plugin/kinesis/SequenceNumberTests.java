    }
        SequenceNumber seqNum = new SequenceNumber(sequenceNumber);  
        Field field = seqNum.asPointField("sequenceNumberField");  
    public void testNewRangeQueryGreaterThan() {
    }
        TermRangeQuery termRangeQuery = (TermRangeQuery) query;
        Assert.assertEquals("The lower term should be correct", sequenceNumber, termRangeQuery.getLowerTerm().utf8ToString());  
import java.nio.charset.StandardCharsets;
    public void testEqualsAndHashCode() {  
        String sequenceNumber = "12345";  
        String sequenceNumber2 = "67890";  
import org.apache.lucene.search.Query;  
        Assert.assertEquals("The string representation should be correct", sequenceNumber, seqNum.asString());
public class SequenceNumberTests extends OpenSearchTestCase {
    public void testAsPointField() {  
        Assert.assertEquals("The field value should be correct", sequenceNumber, field.stringValue());
        Assert.assertArrayEquals("The serialized bytes should be correct", expectedBytes, seqNum.serialize());  
        SequenceNumber seqNum = new SequenceNumber(sequenceNumber);
        Assert.assertTrue("The comparison should be correct", seqNum2.compareTo(seqNum1) > 0);
        Assert.assertTrue("The upper term should be inclusive", termRangeQuery.includesUpper());  
        Assert.assertTrue("The field should be an instance of KeywordField", field instanceof KeywordField);
        String sequenceNumber2 = "67890";
import org.opensearch.test.OpenSearchTestCase;
 * compatible open source license.
        byte[] expectedBytes = sequenceNumber.getBytes(StandardCharsets.UTF_8);
        SequenceNumber seqNum = new SequenceNumber(sequenceNumber);
import org.junit.Assert;  
        Assert.assertEquals("Hash codes for equal sequence numbers should be the same", seqNum1.hashCode(), seqNum2.hashCode());  
        String sequenceNumber = "12345";
    public void testConstructorAndGetters() {
        Assert.assertTrue("Sequence numbers with the same value should be equal", seqNum1.equals(seqNum2));
        Assert.assertEquals("The field name should be correct", "sequenceNumberField", termRangeQuery.getField());
import org.apache.lucene.document.KeywordField;
        Assert.assertTrue("The comparison should be correct", seqNum1.compareTo(seqNum1) == 0);  
package org.opensearch.plugin.kinesis;
        SequenceNumber seqNum2 = new SequenceNumber(sequenceNumber2);
 */  
        String sequenceNumber = "12345";
        String sequenceNumber1 = "12345";
    }
        String sequenceNumber = "12345";
}
        Assert.assertEquals("The field name should be correct", "sequenceNumberField", field.name());  
 * this file be licensed under the Apache-2.0 license or a
    }
        SequenceNumber seqNum3 = new SequenceNumber(sequenceNumber2);
/*  
        Assert.assertFalse("Sequence numbers with different values should not be equal", seqNum1.equals(seqNum3));
    }
    public void testAsString() {  
        SequenceNumber seqNum = new SequenceNumber(sequenceNumber);  
    public void testCompareTo() {
    public void testSerialize() {
        String sequenceNumber = "12345";
        SequenceNumber seqNum2 = new SequenceNumber(sequenceNumber1);
        SequenceNumber seqNum1 = new SequenceNumber(sequenceNumber1);  
        Assert.assertFalse("The lower term should be exclusive", termRangeQuery.includesLower());
        Assert.assertEquals("The sequence number should be correctly initialized and returned", sequenceNumber, seqNum.getSequenceNumber());  
    }
    }
        Assert.assertTrue("The comparison should be correct", seqNum1.compareTo(seqNum2) < 0);
import org.apache.lucene.document.Field;
        SequenceNumber seqNum = new SequenceNumber(sequenceNumber);
import org.apache.lucene.search.TermRangeQuery;
        Query query = seqNum.newRangeQueryGreaterThan("sequenceNumberField");
        Assert.assertNotEquals("Hash codes for different sequence numbers should not be the same", seqNum1.hashCode(), seqNum3.hashCode());
 * SPDX-License-Identifier: Apache-2.0
        Assert.assertTrue("The query should be an instance of TermRangeQuery", query instanceof TermRangeQuery);  
 * The OpenSearch Contributors require contributions made to  
        String sequenceNumber1 = "12345";
 *
        SequenceNumber seqNum1 = new SequenceNumber(sequenceNumber1);
        Assert.assertNull("The upper term should be null", termRangeQuery.getUpperTerm());
