 */  
    public List<MappingTransformer> getMappingTransformers() {  
    public ExampleMappingTransformerPlugin() {}  
    @Override
    /**  
package org.opensearch.example.mappingtransformer;
    /**
/*  
 *
import org.opensearch.index.mapper.MappingTransformer;
     */
 * this file be licensed under the Apache-2.0 license or a
     * Constructs a new ExampleMappingTransformerPlugin
import org.opensearch.plugins.Plugin;  
/**
    }
 * SPDX-License-Identifier: Apache-2.0
public class ExampleMappingTransformerPlugin extends Plugin implements MapperPlugin {
 */  
 * Example plugin that implements a custom mapping transformer.
        return List.of(new ExampleMappingTransformer());
import java.util.List;
     */
 * The OpenSearch Contributors require contributions made to  
 * compatible open source license.
     * @return Available mapping transformer  
}  
import org.opensearch.plugins.MapperPlugin;
