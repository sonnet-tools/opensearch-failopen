         * The returned object type depends on the data format implementation
import org.opensearch.common.annotation.ExperimentalApi;
}  
     * {@link CatalogSnapshot} and format-specific readers.
     * @opensearch.experimental  
         * @param format the data format to get the reader for
/**  
public interface IndexReaderProvider {
    /**
import org.opensearch.index.engine.exec.coord.CatalogSnapshot;
     * The caller must close the returned {@link GatedCloseable} when the reader is no longer needed  
     */
 *
 * Provides access to index readers for search operations across data formats.
         */
 * for the duration of a search operation via {@link GatedCloseable}.  
    /**
        /**
     */
    }
 * The OpenSearch Contributors require contributions made to  
     * Acquires a point-in-time {@link Reader} wrapped in a {@link GatedCloseable}.
    interface Reader extends Closeable {  
 * SPDX-License-Identifier: Apache-2.0
 * Implementations manage the lifecycle of readers, ensuring they remain valid
         * (e.g., a Lucene {@code DirectoryReader} or a native reader handle).  
        CatalogSnapshot catalogSnapshot();
        Object reader(DataFormat format);
 *
/*  
         * Returns the {@link CatalogSnapshot} representing the index state at the time this reader was acquired.  
import org.opensearch.common.concurrent.GatedCloseable;
         *
import org.opensearch.index.engine.dataformat.DataFormat;  
     * to release the underlying resources.
 * compatible open source license.
         *
 */  
@ExperimentalApi
         * Returns the format-specific reader for the given {@link DataFormat}.
     * @return a gated closeable wrapping the acquired reader  
 */  
    GatedCloseable<Reader> acquireReader() throws IOException;  
import java.io.Closeable;  
     *
    @ExperimentalApi
        /**  
import java.io.IOException;
         * @return the format-specific reader object  
 * @opensearch.experimental
     * @throws IOException if an I/O error occurs while acquiring the reader
         * @return the catalog snapshot
         */  
        <R> R getReader(DataFormat format, Class<R> readerType);
 * this file be licensed under the Apache-2.0 license or a
     * A point-in-time reader over the index state, providing access to the  
     *
package org.opensearch.index.engine.exec;
