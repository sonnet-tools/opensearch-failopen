package org.opensearch.analytics.stats;
 * SPDX-License-Identifier: Apache-2.0
 * {@link org.opensearch.analytics.stats.transport.AnalyticsStatsAction}.  
 * completed {@link org.opensearch.analytics.exec.profile.QueryProfile} into
 * cumulative counters and HdrHistogram-backed latency buckets.  
 */  
 * The OpenSearch Contributors require contributions made to  
 * {@link org.opensearch.analytics.stats.AnalyticsStatsCollector} folds each
 * {@link org.opensearch.analytics.stats.RestAnalyticsStatsAction} exposes a
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */
/*  
 *
 * Cluster-wide stats rollup for the analytics engine.  
 * fan-out snapshot at {@code GET _plugins/_analytics/stats} via
/**
