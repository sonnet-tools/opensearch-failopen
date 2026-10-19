package org.opensearch.plugins;
 * this file be licensed under the Apache-2.0 license or a
 */  
 * compatible open source license.
 * Plugin interface implemented by modules that provide adaptive per-action concurrency limiting.
     * has not been initialised yet (e.g. the node is still starting up).
public interface ConcurrencyLimiterStatsPlugin {
     */  
/*  
    /**  
 * <p>
 * Implementing this interface allows the module to expose live limiter statistics  
 * through the standard {@code /_nodes/stats} API without creating a hard dependency
 *
 */  
     * Returns a snapshot of all configured limiters, or {@code null} if the registry
}
 * The OpenSearch Contributors require contributions made to  
    ActionConcurrencyLimiterStats getConcurrencyLimiterStats();
/**  
 * from the server module on the concurrency-limit module.
import org.opensearch.action.ActionConcurrencyLimiterStats;
 * SPDX-License-Identifier: Apache-2.0
