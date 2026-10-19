 * or incorporating segments.
 * <p>
     */  
 * instances that own or wrap a shard-level store. The provider is passed to
 *
 * The OpenSearch Contributors require contributions made to  
package org.opensearch.index.engine.exec.commit;
 * {@link org.opensearch.plugins.SearchBackEndPlugin#createReaderManager} so that
     * A format-specific store wrapper providing access to the underlying {@link Store}.  
     * @return the store, or null if not available
        Store store();  
 * Provides access to the shard's {@link Store} for opening NRT readers  
}
import org.opensearch.index.engine.dataformat.DataFormat;
 *
import org.opensearch.index.store.Store;  
 * Implemented by {@link org.opensearch.index.engine.dataformat.IndexingExecutionEngine}  
    /**
     *  
/*  
     * @opensearch.experimental
import org.opensearch.common.annotation.ExperimentalApi;
    /**
@ExperimentalApi
    FormatStore getStore(DataFormat dataFormat);  
public interface IndexStoreProvider {
     *
 * SPDX-License-Identifier: Apache-2.0
/**
 * compatible open source license.
 * this file be licensed under the Apache-2.0 license or a
    }
     */
 */  
    @ExperimentalApi
     * Returns the store for the current shard.
    interface FormatStore {
 */  
 * @opensearch.experimental
 * search backends can open readers without depending on engine internals.  
