 *
    private final ExampleMappingTransformerPlugin plugin = new ExampleMappingTransformerPlugin();
    }
        assertTrue("Should return an example mapping transformer.", mappingTransformerList.getFirst() instanceof ExampleMappingTransformer);  
 * SPDX-License-Identifier: Apache-2.0
import java.util.List;
 * The OpenSearch Contributors require contributions made to  
public class ExampleMappingTransformerPluginTests extends OpenSearchTestCase {  
 */  
 * this file be licensed under the Apache-2.0 license or a
/*  
}
import org.opensearch.test.OpenSearchTestCase;
import org.opensearch.index.mapper.MappingTransformer;
package org.opensearch.example.mappingtransformer;
 * compatible open source license.
        List<MappingTransformer> mappingTransformerList = plugin.getMappingTransformers();
    public void testGetMappingTransformers() {  
