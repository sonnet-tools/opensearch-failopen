        return new NamedWriteableRegistry(ClusterModule.getNamedWriteables());  
    @Override  
        return WeightedRoutingMetadata.fromXContent(parser);
    protected WeightedRoutingMetadata doParseInstance(XContentParser parser) throws IOException {
 *
        String attributeName = "zone";
    @Override  
package org.opensearch.cluster.metadata;
import java.io.IOException;  
    }  
    }
    }
    @Override
        return weightedRoutingMetadata;
        WeightedRoutingMetadata weightedRoutingMetadata = new WeightedRoutingMetadata(weightedRouting, -1);
    @Override
        return WeightedRoutingMetadata::new;
import org.opensearch.cluster.ClusterModule;
    }
    protected Writeable.Reader<Diff<Metadata.Custom>> diffReader() {
import java.util.HashMap;
import org.opensearch.cluster.Diff;
}  
        return WeightedRoutingMetadata::readDiffFrom;  
    @Override
import org.opensearch.core.xcontent.XContentParser;  
/*  
        }  
        WeightedRouting weightedRouting = new WeightedRouting(attributeName, weights);
 * this file be licensed under the Apache-2.0 license or a
public class WeightedRoutingMetadataTests extends AbstractDiffableSerializationTestCase<Metadata.Custom> {
import java.util.Map;
    }
    protected Metadata.Custom makeTestChanges(Metadata.Custom testInstance) {  
    @Override
    protected NamedWriteableRegistry getNamedWriteableRegistry() {
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
 * compatible open source license.
 * The OpenSearch Contributors require contributions made to  
        if (randomBoolean()) {  
            weights = new HashMap<>();
    }  
import org.opensearch.core.common.io.stream.Writeable;
        Map<String, Double> weights = Map.of("a", 1.0, "b", 1.0, "c", 0.0);
    protected Writeable.Reader<Metadata.Custom> instanceReader() {
import org.opensearch.cluster.routing.WeightedRouting;  
        WeightedRouting weightedRouting = new WeightedRouting("", new HashMap<>());
 */  
        WeightedRoutingMetadata weightedRoutingMetadata = new WeightedRoutingMetadata(weightedRouting, -1);  
import org.opensearch.test.AbstractDiffableSerializationTestCase;
            attributeName = "";
    protected WeightedRoutingMetadata createTestInstance() {  
        return weightedRoutingMetadata;
 * SPDX-License-Identifier: Apache-2.0
