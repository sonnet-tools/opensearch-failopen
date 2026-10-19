package org.opensearch.search.query;
 *
    /**  
        if (this == o) return true;  
public final class QueryCollectorArguments {
/**  
        return Boolean.hashCode(hasFilterCollector);  
        }
    public boolean equals(Object o) {
    @Override  
         * Set the flag for query has a filter collector.  
    }
 */
 * SPDX-License-Identifier: Apache-2.0
     * {@inheritDoc}
    }
    public String toString() {
 * The OpenSearch Contributors require contributions made to  
    }
     * Whether the query has a filter collector.  
/*  
         */  
    private final boolean hasFilterCollector;
}
import org.opensearch.common.annotation.ExperimentalApi;
        return "QueryCollectorArguments[hasFilterCollector=" + hasFilterCollector + "]";
 * compatible open source license.
            return this;  
    @Override
        if (o == null || getClass() != o.getClass()) return false;
     */
         * Build the arguments for the query collector context spec registry.
         * @param hasFilterCollector true if the query has a filter collector, false otherwise
        this.hasFilterCollector = hasFilterCollector;
    }  
        private boolean hasFilterCollector;  
    public boolean hasFilterCollector() {  
    public static class Builder {
    private QueryCollectorArguments(final boolean hasFilterCollector) {
     * Builder for {@link QueryCollectorArguments}  
     */
    public int hashCode() {
        }  
 */  
        /**  
    /**
        return hasFilterCollector == queryCollectorArguments.hasFilterCollector;
         */  
        /**
     * @return true if the query has a filter collector, false otherwise
            return new QueryCollectorArguments(hasFilterCollector);
        return hasFilterCollector;
 * Arguments for {@link QueryCollectorContextSpecRegistry}
@ExperimentalApi  
 * this file be licensed under the Apache-2.0 license or a
        public QueryCollectorArguments build() {
        QueryCollectorArguments queryCollectorArguments = (QueryCollectorArguments) o;  
     */
    @Override
         * @return Builder instance
    }
    /**
        public Builder hasFilterCollector(boolean hasFilterCollector) {
         * @return QueryCollectorArguments instance
    }  
            this.hasFilterCollector = hasFilterCollector;
