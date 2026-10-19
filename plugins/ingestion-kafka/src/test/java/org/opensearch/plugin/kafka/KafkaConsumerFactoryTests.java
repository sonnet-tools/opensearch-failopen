}  
package org.opensearch.plugin.kafka;
        KafkaConsumerFactory factory = new KafkaConsumerFactory();  
 * SPDX-License-Identifier: Apache-2.0
 * compatible open source license.
 * this file be licensed under the Apache-2.0 license or a
        KafkaOffset offset = factory.parsePointerFromString("12345");
        KafkaConsumerFactory factory = new KafkaConsumerFactory();
    }
        Assert.assertEquals("Offset value should be correctly parsed", 12345L, offset.getOffset());
import org.opensearch.cluster.metadata.IndexMetadata;
import org.opensearch.test.OpenSearchTestCase;
 *
    public void testCreateShardConsumerWithNullMetadata() {  
/*  
 * The OpenSearch Contributors require contributions made to  
 */  
    public void testParsePointerFromString() {
import org.junit.Assert;  
        Assert.assertNotNull("Offset should be parsed", offset);  
        expectThrows(NullPointerException.class, () -> factory.createShardConsumer("test-client", 0, (IndexMetadata) null));
    }  
public class KafkaConsumerFactoryTests extends OpenSearchTestCase {
