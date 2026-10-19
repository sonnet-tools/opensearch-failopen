 */  
}
        return fieldFilter;
 *
@ExperimentalApi
 *
 * <p>Mapper plugins may use the filter to implement authorization access controls such as field-level security. Consumers must treat
 * The OpenSearch Contributors require contributions made to  
    /**  
 * resolving or validating user field references.  
 * Node-provided plugin component exposing the authoritative field-visibility filter.
import org.opensearch.common.annotation.ExperimentalApi;
    /** Returns the node's aggregated field-visibility filter. */  
 * SPDX-License-Identifier: Apache-2.0
/*  
 * this file be licensed under the Apache-2.0 license or a
     * Creates a component exposing the given aggregated field filter.
    public Function<String, Predicate<String>> getFieldFilter() {
    }
     * @param fieldFilter the node's aggregated field-visibility filter  
 * evaluated with a concrete index name. Plugins that build query schemas or plans must apply the resulting field predicate before
 */  
 * it as an access-control boundary and must not bypass it or reintroduce rejected fields.  
    }  
package org.opensearch.plugins;
public final class FieldFilterProvider {
    private final Function<String, Predicate<String>> fieldFilter;
import java.util.Objects;  
     *
 *
 *  
 * <p>The filter is the logical AND of every {@link MapperPlugin#getFieldFilter()} registered on the node. The outer function must be
import java.util.function.Predicate;
    public FieldFilterProvider(Function<String, Predicate<String>> fieldFilter) {
 * @opensearch.experimental
        this.fieldFilter = Objects.requireNonNull(fieldFilter);  
 * compatible open source license.
     */
import java.util.function.Function;
/**
