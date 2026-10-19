package org.opensearch.cluster.metadata;
        DecommissionStatus decommissionStatus = randomFrom(DecommissionStatus.values());
    protected DecommissionAttributeMetadata createTestInstance() {  
        return new DecommissionAttributeMetadata(decommissionAttribute, decommissionStatus, randomAlphaOfLength(10));
    protected NamedWriteableRegistry getNamedWriteableRegistry() {
        );
 */  
        String attributeName = randomAlphaOfLength(6);
/*  
    @Override
import java.util.Collections;
 *
    protected Class<DecommissionAttributeMetadata> categoryClass() {  
            )
import org.opensearch.cluster.decommission.DecommissionAttributeMetadata;
    }
        return new NamedWriteableRegistry(  
                )  
 * this file be licensed under the Apache-2.0 license or a
    protected DecommissionAttributeMetadata mutateInstance(DecommissionAttributeMetadata instance) throws IOException {  
                    DecommissionAttributeMetadata::new
import org.opensearch.cluster.decommission.DecommissionStatus;  
    @Override
    @Override
        DecommissionAttribute decommissionAttribute = new DecommissionAttribute(attributeName, attributeValue);  
}  
                    DecommissionAttributeMetadata.class,  
        String attributeValue = randomAlphaOfLength(6);
            Collections.singletonList(
    @Override
        return randomValueOtherThan(instance, this::createTestInstance);
import java.io.IOException;
 * SPDX-License-Identifier: Apache-2.0
 * compatible open source license.
    }
 * The OpenSearch Contributors require contributions made to  
        return DecommissionAttributeMetadata.class;
    }  
                new NamedWriteableRegistry.Entry(
import org.opensearch.cluster.decommission.DecommissionAttribute;
import org.opensearch.test.AbstractNamedWriteableTestCase;
                    DecommissionAttributeMetadata.TYPE,
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
public class DecommissionAttributeMetadataTests extends AbstractNamedWriteableTestCase<DecommissionAttributeMetadata> {
    }  
