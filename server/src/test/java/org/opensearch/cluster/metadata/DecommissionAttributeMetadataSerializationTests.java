        DecommissionAttribute decommissionAttribute = new DecommissionAttribute(attributeName, attributeValue);  
        String attributeValue = decommissionAttribute.attributeValue();  
            attributeValue = randomAlphaOfLength(6);  
 * SPDX-License-Identifier: Apache-2.0
        return new DecommissionAttributeMetadata(
    @Override
            decommissionStatus = randomFrom(DecommissionStatus.values());  
    @Override  
        DecommissionAttribute decommissionAttribute = decommissionAttributeMetadata.decommissionAttribute();
import java.io.IOException;
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;  
public class DecommissionAttributeMetadataSerializationTests extends AbstractDiffableSerializationTestCase<Metadata.Custom> {
        if (randomBoolean()) {
        return DecommissionAttributeMetadata::readDiffFrom;
        DecommissionStatus decommissionStatus = randomFrom(DecommissionStatus.values());
        String attributeName = randomAlphaOfLength(6);
        DecommissionAttributeMetadata decommissionAttributeMetadata = DecommissionAttributeMetadata.fromXContent(parser);
import org.opensearch.cluster.Diff;
        return DecommissionAttributeMetadata::new;
        if (randomBoolean()) {
    }
        );
import org.opensearch.cluster.decommission.DecommissionAttributeMetadata;
            randomAlphaOfLength(10)
        if (randomBoolean()) {
    protected NamedWriteableRegistry getNamedWriteableRegistry() {  
 *
        String attributeName = decommissionAttribute.attributeName();
            attributeName = randomAlphaOfLength(6);  
    }
/*  
}  
    }  
package org.opensearch.cluster.metadata;
        DecommissionAttributeMetadata decommissionAttributeMetadata = (DecommissionAttributeMetadata) testInstance;  
        return randomValueOtherThan(instance, this::createTestInstance);
        return new DecommissionAttributeMetadata(  
import org.opensearch.core.common.io.stream.Writeable;
        return new NamedWriteableRegistry(ClusterModule.getNamedWriteables());
    protected Writeable.Reader<Diff<Metadata.Custom>> diffReader() {
    }
 * compatible open source license.
    }  
import org.opensearch.test.AbstractDiffableSerializationTestCase;  
    @Override  
            decommissionStatus,
    @Override
    protected Metadata.Custom doParseInstance(XContentParser parser) throws IOException {
            decommissionAttributeMetadata.status(),
        );  
import org.opensearch.cluster.decommission.DecommissionStatus;
 * this file be licensed under the Apache-2.0 license or a
            new DecommissionAttribute(attributeName, attributeValue),  
        }
        assertEquals(XContentParser.Token.START_OBJECT, parser.nextToken());  
        }
    protected Metadata.Custom createTestInstance() {  
    }  
            decommissionAttributeMetadata.decommissionAttribute(),
            decommissionAttributeMetadata.requestID()  
    @Override
        return new DecommissionAttributeMetadata(decommissionAttribute, decommissionStatus, randomAlphaOfLength(10));
    protected Metadata.Custom makeTestChanges(Metadata.Custom testInstance) {
 */  
        assertEquals(XContentParser.Token.END_OBJECT, parser.currentToken());
    protected Metadata.Custom mutateInstance(Metadata.Custom instance) {  
import org.opensearch.core.xcontent.XContentParser;
    @Override
    @Override
import org.opensearch.cluster.ClusterModule;
 * The OpenSearch Contributors require contributions made to  
        }
    protected Writeable.Reader<Metadata.Custom> instanceReader() {
        String attributeValue = randomAlphaOfLength(6);
        DecommissionStatus decommissionStatus = decommissionAttributeMetadata.status();
import org.opensearch.cluster.decommission.DecommissionAttribute;  
    }
