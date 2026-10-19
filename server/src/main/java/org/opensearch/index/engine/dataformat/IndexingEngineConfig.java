 * compatible open source license.
@ExperimentalApi
import org.opensearch.common.annotation.ExperimentalApi;
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.index.store.Store;  
/**
 *
 * @param committer the committer for durable flush, or null if not available  
 * The OpenSearch Contributors require contributions made to  
 */
 * @param registry DataFormatRegistry containing information about registered data formats.
    DataFormatRegistry registry, Map<String, FormatChecksumStrategy> checksumStrategies) {
package org.opensearch.index.engine.dataformat;
 * Initialization parameters for creating an {@link IndexingExecutionEngine} via
/*  
 *
 * @opensearch.experimental  
import java.util.Map;
}
 * breaking the plugin SPI when new context is needed.
 * {@link DataFormatPlugin#indexingEngine}. Bundling parameters in a record avoids  
 * @param store the shard's store, or null if not available  
import org.opensearch.index.store.FormatChecksumStrategy;
public record IndexingEngineConfig(Committer committer, MapperService mapperService, IndexSettings indexSettings, Store store,  
 * this file be licensed under the Apache-2.0 license or a
 */  
import org.opensearch.index.engine.exec.commit.Committer;  
import org.opensearch.index.IndexSettings;
 *
import org.opensearch.index.mapper.MapperService;
 * @param indexSettings the index-level settings
 * @param mapperService the mapper service for field mapping resolution
