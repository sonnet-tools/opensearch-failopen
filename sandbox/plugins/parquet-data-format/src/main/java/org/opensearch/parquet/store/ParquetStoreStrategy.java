 * SPDX-License-Identifier: Apache-2.0
 * The OpenSearch Contributors require contributions made to  
}
 *
import org.opensearch.index.engine.dataformat.DataFormatStoreHandlerFactory;
 *
 * from {@link StoreStrategy} (files live under {@code "parquet/"} prefix, blobs
    private static final DataFormatStoreHandlerFactory FACTORY = ParquetDataFormatStoreHandler::new;
 * this file be licensed under the Apache-2.0 license or a
 * <p>Uses the default {@code owns} / {@code remotePath} behaviour inherited  
 * itself does not carry the name.
    @Override
 * are laid out at {@code basePath + "parquet/" + blobKey}). The store layer
public final class ParquetStoreStrategy extends StoreStrategy {  
 * <p>Provides a factory for the per-shard native file registry that tracks  
/**  
    public Optional<DataFormatStoreHandlerFactory> storeHandler() {
 * parquet files for the Rust reader.
    }
 *
 * compatible open source license.
package org.opensearch.parquet.store;
        return Optional.of(FACTORY);  
 */  
/*  
 */
import org.opensearch.index.engine.dataformat.StoreStrategy;
 * Store strategy for the parquet data format.
import java.util.Optional;
 * supplies the format name when it invokes those methods, so the strategy  
