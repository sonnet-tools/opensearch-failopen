package org.opensearch.index.engine.exec;
}
 * this file be licensed under the Apache-2.0 license or a
 */  
import org.opensearch.common.annotation.ExperimentalApi;
 * @opensearch.experimental
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.index.engine.exec.coord.CatalogSnapshot;
 * <p>  
 * For pluggable engines, wraps the engine-specific reader lifecycle.
 * @param <T> the reader type managed by this instance
 * <p>  
 *  
 * The OpenSearch Contributors require contributions made to  
/*  
import java.io.Closeable;
public interface EngineReaderManager<T> extends CatalogSnapshotLifecycleListener, FilesListener, Closeable {
/**
 * A manager whose format also knows which rows are still reachable implements
 * compatible open source license.
 * For Lucene, wraps {@code ReferenceManager<OpenSearchDirectoryReader>}.
 * {@link LiveDocsSource} alongside this interface.
import java.io.IOException;
 *
@ExperimentalApi
    T getReader(CatalogSnapshot catalogSnapshot) throws IOException;  
 * Engine-agnostic reader manager.
 */  
