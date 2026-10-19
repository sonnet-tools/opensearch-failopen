 * this file be licensed under the Apache-2.0 license or a
     * {@link FragmentConvertor#convertSchemaOnlyRead} so the framework can emit a separate
 * Wire-format contract a {@link FragmentConvertor} declares for the bytes it produces from
 */  
 * @opensearch.internal
    OPAQUE
 * their bytes carry a self-describing schema the reducer can decode generically.
 *  
/*  
     * named struct). The reducer decodes the bytes directly.
     */
 * SPDX-License-Identifier: Apache-2.0
    SELF_DESCRIBING,  
 * <p>The framework does not know any specific format; backends pick a value based on whether
     * Bytes are opaque to the framework — the reducer cannot derive a partition schema from  
}  
    /**
package org.opensearch.analytics.spi;
     * schema stub at the partition boundary.  
public enum WireFormat {  
 *  
     */
 */
 * compatible open source license.
 *
 * needs to derive a partition schema for the child stage's output — different formats need
     * them without backend help. Backends declaring {@code OPAQUE} MUST also override
 * The OpenSearch Contributors require contributions made to  
 * different derivation strategies.
     * partition schema without backend help (e.g. Substrait plans whose Read rel exposes a  
    /**
/**
     * Bytes carry enough type information for the framework to derive the child stage's
 * {@link FragmentConvertor#convertFragment}. The framework consults this when a parent stage  
