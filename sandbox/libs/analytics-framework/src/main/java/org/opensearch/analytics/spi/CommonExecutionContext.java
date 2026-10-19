package org.opensearch.analytics.spi;
 * Marker interface for execution contexts provided by Core to instruction handlers.
 * </ul>
 *   <li>{@code ExchangeSinkContext} — coordinator reduce execution (planBytes, allocator, schema)</li>  
 *
 * this file be licensed under the Apache-2.0 license or a
 * @opensearch.internal  
 * compatible open source license.
 * Concrete implementations carry the information relevant to their execution path:  
/**
/*  
public interface CommonExecutionContext {}
 * The OpenSearch Contributors require contributions made to  
 * SPDX-License-Identifier: Apache-2.0
 *   <li>{@code ShardScanExecutionContext} — shard fragment execution (reader, task, tableName)</li>
 *
 */
 */  
 * <ul>
