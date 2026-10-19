    public DatafusionReader(
    }
package org.opensearch.be.datafusion;
     * @param sortFields index.sort.field values (empty list when the index has no sort). Parallel to {@code sortOrders}.
    }
     */  
 */
 * @opensearch.experimental  
    private final ReaderHandle readerHandle;
        String directoryPath,
import org.opensearch.be.datafusion.nativelib.ReaderHandle;  
    }
import java.io.Closeable;  
import org.opensearch.index.engine.exec.MonoFileWriterSet;
 * snapshot is removed.
     * {@link ReaderHandle#getPointer()} only at JNI invocation time.  
     * encountered, preventing silent correctness bugs in the native reader.
     * @param writerFileSets the per-segment file sets from the catalog snapshot
        this.directoryPath = directoryPath;
     * <p>
        NativeStoreHandle dataformatAwareStoreHandle,
    /**  
    /**  
        readerHandle.close();
public class DatafusionReader implements Closeable {  
     * The caller retains ownership — this reader will NOT close the handle.
import java.io.IOException;
 */  
     * @param directoryPath shard data directory
        return readerHandle;  
     */
        readerHandle = new ReaderHandle(directoryPath, segments, dataformatAwareStoreHandle, sortFields, sortOrders);  
 * compatible open source license.
import org.opensearch.plugins.NativeStoreHandle;
 * The OpenSearch Contributors require contributions made to  
     * Creates a DatafusionReader for the given shard directory and per-segment files.
        List<MonoFileWriterSet> segments;  
        if (writerFileSets == null || writerFileSets.isEmpty()) {
    public void close() throws IOException {
 *
        Collection<WriterFileSet> writerFileSets,  
    private final String directoryPath;  
 * this file be licensed under the Apache-2.0 license or a
     * Callers should hold this reference and call
            segments = List.of();
import java.util.List;  
     * Wraps a pre-existing native reader pointer (test only).
        } else {  
 * DataFusion reader for JNI operations.  
import org.apache.logging.log4j.LogManager;
/**
@ExperimentalApi
     * Returns the type-safe handle to the native reader.
        this.readerHandle = ReaderHandle.wrap(nativePtr);  
     * @param sortOrders index.sort.order values ("asc"/"desc"), parallel to {@code sortFields}.
    DatafusionReader(long nativePtr) {
import org.opensearch.index.engine.exec.WriterFileSet;  
        List<String> sortOrders  
     * produces exactly one file per segment. This fails fast if a multi-file set is
 * <p>
     * @param dataformatAwareStoreHandle per-format native store handle (null on hot, live on warm)  
            segments = writerFileSets.stream().map(MonoFileWriterSet::from).toList();
 *
     */  
}
import java.util.Collection;
 * Each reader represents a point-in-time snapshot of parquet/arrow files for a shard.
    private static final Logger logger = LogManager.getLogger(DatafusionReader.class);
    /**  
     *  
        }
import org.opensearch.common.annotation.ExperimentalApi;
    public ReaderHandle getReaderHandle() {
     * Each {@link WriterFileSet} is narrowed to a {@link MonoFileWriterSet} — Parquet  
        this.directoryPath = "";
 * SPDX-License-Identifier: Apache-2.0
        logger.debug("DatafusionReader closed for [{}]", directoryPath);  
    ) {
    @Override  
    }
        List<String> sortFields,
import org.apache.logging.log4j.Logger;
/*  
 * Created from a catalog snapshot during refresh; closed when the associated catalog  
