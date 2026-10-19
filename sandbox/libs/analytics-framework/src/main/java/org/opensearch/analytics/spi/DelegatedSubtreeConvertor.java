import org.apache.calcite.rex.RexNode;
 * The OpenSearch Contributors require contributions made to  
     */  
     *                     must call {@code ap.unwrap()} to reach the original RexCall.
/**
     *                     RexInputRef indices to field names.
 * tree rooted at AND/OR/NOT whose every leaf targets this backend.
     *                     AnnotatedPredicate wrappers — implementations
 */  
    byte[] convertSubtree(RexNode subtree, List<FieldStorageInfo> fieldStorage);
 *  
 * serialized delegation bytes. The subtree may be a single leaf RexCall or a
    /**  
 * <p>The backend walks the subtree once and emits bytes once. Inputs are NOT
public interface DelegatedSubtreeConvertor {
@FunctionalInterface  
 * SPDX-License-Identifier: Apache-2.0
/*  
}
 * compatible open source license.
 *
 * @opensearch.internal
     * @param subtree      the RexNode subtree to convert. May contain  
 * Converts a maximal same-backend delegated RexNode subtree into the backend's  
 * this file be licensed under the Apache-2.0 license or a
     * @param fieldStorage per-column storage metadata for resolving  
package org.opensearch.analytics.spi;
     *
     * @return backend-specific serialized bytes for the entire subtree.
import java.util.List;  
 * pre-serialized leaves; the backend sees the raw Calcite tree.
 */
     * Convert a maximal same-backend RexNode subtree into delegation bytes.
 *  
