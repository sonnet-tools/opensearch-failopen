     * Context for mapping transform. For now, we don't need any context, but it's defined for future scalability.
 * compatible open source license.
    default void transform(
     * It can be used to provide the info like we are transforming the mapping for what transport action. Or provide
        @NonNull final ActionListener<Void> listener
        final Map<String, Object> mapping,
        final TransformContext context,  
import org.opensearch.core.action.ActionListener;
import java.util.Map;  
        listener.onResponse(null);  
    /**  
     */
    class TransformContext {}
package org.opensearch.index.mapper;
 * A transformer to allow plugins to implement logic to transform the index mapping during
}  
 * index creation/update and index template creation/update on transport layer.  
     * index setting info to help transform the mapping.  
 */
/**
    }
    ) {
/*  
import reactor.util.annotation.NonNull;
public interface MappingTransformer {  
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to  
 */  
 *
 * this file be licensed under the Apache-2.0 license or a
