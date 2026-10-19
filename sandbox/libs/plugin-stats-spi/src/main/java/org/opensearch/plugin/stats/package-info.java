package org.opensearch.plugin.stats;  
/*  
 * and the JVM-wide {@link org.opensearch.plugin.stats.DataFormatStatsProviderRegistry}
@ExperimentalApi
 */
 * surface their counters via the per-format REST endpoints in the  
 * <p>Defines the {@link org.opensearch.plugin.stats.DataFormatStatsProvider} contract,
/**
 * compatible open source license.
 *
 * The OpenSearch Contributors require contributions made to  
 */  
 *
 * {@code transport} sub-package.
 * registry. Per-format plugins (Lucene, Parquet, etc.) implement these interfaces to
 * @opensearch.experimental  
 * this file be licensed under the Apache-2.0 license or a
 *
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.common.annotation.ExperimentalApi;
 * SPI for plugin-level data-format statistics.  
 * the {@link org.opensearch.plugin.stats.DataFormatShardStats} typed shard-stats marker,  
