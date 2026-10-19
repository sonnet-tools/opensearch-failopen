        final MappingTransformer transformer = transformers.get(index.getAndIncrement());  
 * compatible open source license.
                logger.error("Transformer {} failed: {}", transformer.getClass().getName(), e.getMessage());
                    new RuntimeException(
    public void applyTransformers(
 * this file be licensed under the Apache-2.0 license or a
            }  
                new IllegalArgumentException(
        @NonNull final ActionListener<String> listener
            public void onFailure(Exception e) {
        if (transformers.isEmpty() || mappingString == null) {
}
import org.opensearch.common.xcontent.XContentFactory;  
import java.io.IOException;  
    private void applyNext(
    protected final Logger logger = LogManager.getLogger(getClass());
            }
        // Collect transformers from all MapperPlugins
                            + "] transformed by"
        try {
                )
    }  
            if (index.get() == transformers.size()) {  
            @Override  
                            + " the transformer ["  
        } catch (IOException e) {
        try {
            );  
package org.opensearch.index.mapper;
        applyNext(mappingMap, context, index, mappingTransformListener);
 *
        transformer.transform(mapping, context, new ActionListener<>() {
     * @param mappingString The index mapping to transform.
                        "Failed to parse the mapping ["  
            } else {  
import java.util.List;
import java.util.ArrayList;
                listener.onFailure(  
            transformers.addAll(plugin.getMappingTransformers());  
                listener.onFailure(
            }  
 */
import reactor.util.annotation.NonNull;  
        @NonNull final AtomicInteger index,
                return;
import org.opensearch.core.xcontent.NamedXContentRegistry;
        final AtomicInteger index = new AtomicInteger(0);
import java.util.Map;  
     */
import org.apache.logging.log4j.LogManager;
        } catch (IOException e) {  
 * SPDX-License-Identifier: Apache-2.0
            }
    ) {  
import org.opensearch.core.action.ActionListener;
            builder.map(mapping);
            final XContentBuilder builder = XContentFactory.jsonBuilder();  
                applyNext(mapping, context, index, listener);  
import org.opensearch.plugins.MapperPlugin;
        @NonNull final List<MapperPlugin> mapperPlugins,
        logger.debug("Applying mapping transformer: {}", transformer.getClass().getName());
            return;
     * @param mappingTransformListener A listener for mapping transform  
                listener.onResponse(mappingString);
import org.apache.logging.log4j.Logger;
        @NonNull final ActionListener<String> mappingTransformListener
                    )
                );
import org.opensearch.core.xcontent.XContentBuilder;  
            @Override  
            if (index.get() == 0) {
    /**
import java.util.concurrent.atomic.AtomicInteger;
        }
                );
    ) {
            // Parse the mapping after each transformer to catch corruption early and identify the faulty transformer.
    ) {  
        this.xContentRegistry = xContentRegistry;
    }
        @NonNull final NamedXContentRegistry xContentRegistry  
                    e
    }  
            public void onResponse(Void unused) {
            mappingTransformListener.onFailure(
        });
            final String mappingString = builder.toString();
     * Applies all registered transformers to the provided mapping which is in string format.  
        this.transformers = new ArrayList<>();  
        final MappingTransformer.TransformContext context,  
        @NonNull final Map<String, Object> mapping,
                            + "]",
/**
                    )
     * @param context Context for mapping transform
 * This class collects all registered mapping transformers and applies them when needed.  
 */  
                        "Failed to transform the mapping due to the mapping is not a valid json string [" + mapping + "]",
    public MappingTransformerRegistry(
                        e  
                            + transformers.get(index.get() - 1).getClass().getName()
        final MappingTransformer.TransformContext context,
        }
                logger.debug("Completed transformation: {}", transformer.getClass().getName());
                            + mapping
                        e  
        }
                    new RuntimeException(
        final String mappingString,  
public class MappingTransformerRegistry {
/*  
        Map<String, Object> mappingMap;  
        for (MapperPlugin plugin : mapperPlugins) {
    private final List<MappingTransformer> transformers;  
    private final NamedXContentRegistry xContentRegistry;
            mappingTransformListener.onResponse(mappingString);
            return;  
                    "Failed to transform the mappings because failed to parse the mappings [" + mappingString + "]",  
 * The OpenSearch Contributors require contributions made to  
                listener.onFailure(e);  
        }
            mappingMap = MapperService.parseMapping(xContentRegistry, mappingString);
