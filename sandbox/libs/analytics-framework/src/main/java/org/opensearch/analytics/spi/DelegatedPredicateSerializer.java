     * @param fieldStorage per-column storage metadata; {@link org.apache.calcite.rex.RexInputRef}  
 */  
 * (e.g. {@code query_string}) rather than only in a {@code fields} operand. Serializers that do
 *
 * The OpenSearch Contributors require contributions made to  
 * report the fields the predicate references at planning time via {@link #referencedFields}.  
     * from execution.  
 *
 * {@link RexCall} and serialize them into backend-specific bytes that can be deserialized
    default FieldReferences referencedFields(RexCall call, List<FieldStorageInfo> fieldStorage) {
 * predicates under AND/OR into a single BooleanQuery, serializers will need to handle  
     * the predicate's {@link RexCall} and per-column {@link FieldStorageInfo} are needed.
 * <p>Each implementation knows how to extract field names and query parameters from a
}
     * <em>same</em> operand path it would use for {@link #serialize}, so extraction can never drift
 * <p>TODO(same-backend-combining): When tree normalization combines adjacent same-backend
 * SPDX-License-Identifier: Apache-2.0
 * {@link BackendCapabilityProvider#delegatedPredicateSerializers()}.
import java.util.List;  
     * <p>Overridden by full-text serializers whose fields may be written inside the query string  
     *
    /**
     * must not require a {@code QueryShardContext} — field identity is analyzer-independent, so only  
 */
     * Returns the fields this predicate references, for plan-time validation, or {@code null} if
     *
    /**  
     * @param fieldStorage per-column storage metadata; {@link org.apache.calcite.rex.RexInputRef}  
        return null;  
 * delegation, keyed by {@link ScalarFunction} in
/**
     * Serializes a delegated predicate into backend-specific bytes.  
package org.opensearch.analytics.spi;
 * this file be licensed under the Apache-2.0 license or a
 * <p>A serializer is the single place that understands a predicate's shape, so it can also
 *
     * (e.g. {@code query_string}); the implementation is expected to derive fields from the
     *                     indices in {@code call} index into this list
/*  
     */
     * @param call         the original RexCall expression (e.g., MATCH($1, 'hello world'))
 *  
     *                     indices in {@code call} index into this list
 * @opensearch.internal  
     *         lenient metadata, or {@code null} if field references are not exposed  
public interface DelegatedPredicateSerializer {  
     * @return backend-specific serialized bytes
 * Per-function serializer for delegated predicates. Registered by backends that accept  
 * composite predicate shapes — not just single-function leaves.
     * this serializer does not expose field references (the default). Runs at planning time and
    byte[] serialize(RexCall call, List<FieldStorageInfo> fieldStorage);
 * compatible open source license.
 * This is used for full-text predicates whose fields may live inside an opaque query string
 *
@FunctionalInterface
     */  
     *
 * at the data node to create the appropriate query.  
 * not own such field-resolution semantics inherit the default (no field references reported).  
import org.apache.calcite.rex.RexCall;
     * @return the referenced fields split into validated literals vs. passed-through patterns, plus
    }
     * @param call         the relevance {@link RexCall} (e.g. {@code QUERY_STRING(MAP('fields', ...), MAP('query', ...))})
