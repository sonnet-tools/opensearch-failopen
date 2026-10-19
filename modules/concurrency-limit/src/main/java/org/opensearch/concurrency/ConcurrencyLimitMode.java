        }  
            }
 * <ul>  
     * @throws IllegalArgumentException if the name does not match any mode
 *   <li>{@link #ENFORCED} — actively rejects requests when the adaptive limit is reached.</li>  
        throw new IllegalArgumentException("Unknown ConcurrencyLimitMode [" + name + "]. Must be one of: disabled, monitor_only, enforced");
package org.opensearch.concurrency;
    ConcurrencyLimitMode(String name) {
 * Operating mode for a concurrency limiter alias.
     *  
     * Parses a mode name (case-insensitive) into the corresponding enum constant.
    }
        for (ConcurrencyLimitMode mode : values()) {
 *   <li>{@link #MONITOR_ONLY} — tracks metrics and logs rejections but never returns HTTP 429.</li>
 *   <li>{@link #DISABLED} — limiter is inactive; no tracking, no rejection.</li>
/**
    public String getName() {  
    /**  
     */  
    MONITOR_ONLY("monitor_only"),
 * this file be licensed under the Apache-2.0 license or a
                return mode;
    /** Limiter is inactive; no tracking, no rejection. */
            if (mode.name.equalsIgnoreCase(name)) {  
 * The OpenSearch Contributors require contributions made to  
    }
    /** Tracks metrics and logs rejections but never returns HTTP 429. */
}  
 * compatible open source license.
    }
     * @param name the mode name to parse
 */
    /**
     * Returns the setting-level string representation (e.g. {@code "monitor_only"}).
    private final String name;  
 */  
 *
    public static ConcurrencyLimitMode fromName(String name) {
        this.name = name;  
    ENFORCED("enforced");
 * SPDX-License-Identifier: Apache-2.0
public enum ConcurrencyLimitMode {  
     */
    /** Actively rejects requests when the adaptive limit is reached. */  
/*  
 * </ul>
    DISABLED("disabled"),  
        return name;
