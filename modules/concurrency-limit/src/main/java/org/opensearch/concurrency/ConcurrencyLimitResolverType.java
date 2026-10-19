            }
    /** Routes by the {@code X-Request-Tier} header value. */
        );  
 * <ul>  
        this.name = name;  
            if (type.name.equalsIgnoreCase(name)) {  
    NONE(""),
 *   <li>{@link #FIXED} — routes all requests to a single named partition.</li>  
    }
 *   <li>{@link #BY_SEARCH_TYPE} — routes by search shape (aggregation vs filter).</li>
    /**
    /** No resolver; all requests share the same pool. */  
}
 */  
 * </ul>
    public String getName() {  
    FIXED("fixed"),
     * @throws IllegalArgumentException if the name does not match any resolver type
                return type;
        }  
     */
     *  
    BY_SEARCH_TYPE("bySearchType");
        for (ConcurrencyLimitResolverType type : values()) {
    public static ConcurrencyLimitResolverType fromName(String name) {
 * compatible open source license.
 * SPDX-License-Identifier: Apache-2.0
            "Unknown ConcurrencyLimitResolverType [" + name + "]. Must be one of: byHeader, fixed, bySearchType"
     * Returns the setting-level string representation (e.g. {@code "byHeader"}).
    private final String name;  
 *
     * @param name the resolver type name to parse
        throw new IllegalArgumentException(
/**
 *   <li>{@link #BY_HEADER} — routes by the {@code X-Request-Tier} header value.</li>
package org.opensearch.concurrency;
    /** Routes all requests to a single named partition. */
    ConcurrencyLimitResolverType(String name) {
    }
    /**  
    BY_HEADER("byHeader"),  
public enum ConcurrencyLimitResolverType {
     * Parses a resolver type name (case-insensitive) into the corresponding enum constant.
 */  
 *   <li>{@link #NONE} — no resolver; all requests share the same pool.</li>
     */  
/*  
    /** Routes by search shape (aggregation vs filter). */  
    }
 * this file be licensed under the Apache-2.0 license or a
        return name;
 * Partition resolver type for a concurrency limiter alias.
 * The OpenSearch Contributors require contributions made to  
