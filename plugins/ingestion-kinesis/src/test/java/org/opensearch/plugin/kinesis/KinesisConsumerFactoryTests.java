}
    }
 * compatible open source license.
        Assert.assertNotNull("Factory should be created", factory);
        KinesisConsumerFactory factory = new KinesisConsumerFactory();  
 */  
import org.opensearch.test.OpenSearchTestCase;
 *
    }
    public void testConstructor() {  
    public void testParsePointerFromString() {
package org.opensearch.plugin.kinesis;
 * The OpenSearch Contributors require contributions made to  
public class KinesisConsumerFactoryTests extends OpenSearchTestCase {
 * this file be licensed under the Apache-2.0 license or a
import org.junit.Assert;  
        Assert.assertNotNull("Sequence number should be parsed", sequenceNumber);
/*  
    }  
import org.opensearch.cluster.metadata.IndexMetadata;
    public void testCreateShardConsumerWithNullMetadata() {
        KinesisConsumerFactory factory = new KinesisConsumerFactory();
        Assert.assertEquals("Sequence number should be correctly parsed", "12345", sequenceNumber.getSequenceNumber());  
        SequenceNumber sequenceNumber = factory.parsePointerFromString("12345");  
 * SPDX-License-Identifier: Apache-2.0
        KinesisConsumerFactory factory = new KinesisConsumerFactory();
        expectThrows(NullPointerException.class, () -> factory.createShardConsumer("test-client", 0, (IndexMetadata) null));
