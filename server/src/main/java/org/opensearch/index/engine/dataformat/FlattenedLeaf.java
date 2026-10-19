    public FlattenedLeaf {
 * {@link DocumentInput#addField} by the field's mapper.
 * How a format stores the leaves — a single map column, exploded per-key columns, a variant  
 *  
     * @param value        the stringified leaf value  
/*  
 * {@code MappedFieldType#name()} on the same {@code addField} call) and the leaf's value,
 *
 * SPDX-License-Identifier: Apache-2.0
 * <p>  
    /**
 * encoding — is entirely the format's decision. A format that cannot represent the field simply
 * <p>
     *
/**  
     * Validates that both components are present.  
 * stringified and already filtered/normalized per the field's mapping parameters. Duplicate  
 * @opensearch.experimental
 */  
 * One flattened leaf of an open key-space field (e.g. {@code flat_object}), as handed to
public record FlattenedLeaf(String relativePath, String value) {
 * ({@code http.method}, not {@code attributes.http.method} — the field's own name is carried by
     * @param relativePath the leaf's dotted path relative to the emitting field
        }
 * relative paths are legal and must be preserved in emission order.
        if (relativePath == null || value == null) {  
package org.opensearch.index.engine.dataformat;
 * The OpenSearch Contributors require contributions made to  
@ExperimentalApi  
 * this file be licensed under the Apache-2.0 license or a
            throw new IllegalArgumentException("relativePath and value must be non-null");
}
 * compatible open source license.
    }  
 */
 * @param value        the stringified leaf value, never null
 * @param relativePath the leaf's dotted path relative to the emitting field, never null
 * {@code FlattenedLeaf} carrying the leaf's dotted path <em>relative to the field</em>  
import org.opensearch.common.annotation.ExperimentalApi;
 * scalar per column. Its mapper instead emits the object's leaves one at a time, each as a
 * ignores these values via its capability self-filter.
 *  
     */
 * A field type whose value is an open, dynamically-keyed object cannot be represented as one
