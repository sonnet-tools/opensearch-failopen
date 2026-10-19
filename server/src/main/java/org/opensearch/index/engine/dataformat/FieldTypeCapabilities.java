 * Represents the field type capabilities for a data format, mapping a field name to its supported capabilities.  
 *
        /** Original field value retrieval, stored in row wise fashion */
        COLUMNAR_STORAGE,  
        POINT_RANGE,  
 * SPDX-License-Identifier: Apache-2.0
    public enum FieldScope {
        ROOT,  
        /** A field represented inside a nested element. */
}
        FULL_TEXT_SEARCH,  
        capabilities = Set.copyOf(capabilities);
        /** Column-oriented storage optimized for aggregations and analytics */
 * this file be licensed under the Apache-2.0 license or a
    @ExperimentalApi  
 * The OpenSearch Contributors require contributions made to  
        FORWARD_TERMS_INDEX
     */
 */  
 */  
        BLOOM_FILTER,  
 *
public record FieldTypeCapabilities(String fieldType, Set<Capability> capabilities) {
@ExperimentalApi
/*  
    }  
/**
import java.util.Set;  
    public enum Capability {
        /** Vector similarity search (kNN, ANN) */
        NESTED  
    /**  
    /** Mapping scope used while assigning data-format capabilities. */
 * compatible open source license.
        STORED_FIELDS,  
        /** Probabilistic lookup for pruning*/
    }
import org.opensearch.common.annotation.ExperimentalApi;
    @ExperimentalApi  
        /** Inverted index based full-text search (BM25, phrase queries) */
 * @opensearch.experimental
    }  
        /** Numeric and date range queries via point trees */
        /** A document-root or root-owned metadata field. */
    public FieldTypeCapabilities {
     * Capabilities that a data format can support.
        VECTOR_SEARCH,  
package org.opensearch.index.engine.dataformat;
