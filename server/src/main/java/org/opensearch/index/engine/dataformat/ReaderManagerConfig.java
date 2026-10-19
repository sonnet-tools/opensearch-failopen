package org.opensearch.index.engine.dataformat;
 */  
 * SPDX-License-Identifier: Apache-2.0
 * Initialization parameters for creating an {@link org.opensearch.index.engine.exec.EngineReaderManager} via
 * @param registry the data format registry it can use to wire any data format specific details.
    ShardPath shardPath, Map<DataFormat, NativeStoreHandle> dataformatAwareStoreHandles, IndexSettings indexSettings) {
 * avoids breaking the plugin SPI when new context is needed.
}  
import java.util.Optional;
import org.opensearch.index.IndexSettings;
 *                                    Empty map if no native stores are available.
 *
public record ReaderManagerConfig(Optional<IndexStoreProvider> indexStoreProvider, DataFormat format, DataFormatRegistry registry,
 * {@link org.opensearch.plugins.SearchBackEndPlugin#createReaderManager}. Bundling parameters in a record  
 * @param format the data format to create a reader manager for
import org.opensearch.plugins.NativeStoreHandle;
 *                                    Each plugin extracts its own handle via {@code handles.get(config.format())}.  
 * this file be licensed under the Apache-2.0 license or a
 * @param indexStoreProvider the store provider, or empty if not available  
/*  
 * @param indexSettings the index settings (carries {@code IndexSortConfig} so backends can declare
 *
@ExperimentalApi  
 *                      file sort order to their query optimizers).
 * @opensearch.experimental
import java.util.Map;
 */
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.common.annotation.ExperimentalApi;
import org.opensearch.index.engine.exec.commit.IndexStoreProvider;  
/**
 * compatible open source license.
 * @param dataformatAwareStoreHandles per-format native store handles for reads.
import org.opensearch.index.shard.ShardPath;
 *  
 * @param shardPath the shard path for file storage  
