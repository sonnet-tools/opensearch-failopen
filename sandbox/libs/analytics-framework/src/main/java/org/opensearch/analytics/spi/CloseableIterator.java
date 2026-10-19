package org.opensearch.analytics.spi;
 * the whole partition in heap. Callers MUST close it (try-with-resources) so the underlying file
 */  
    void close();
 * compatible open source license.
public interface CloseableIterator<T> extends Iterator<T>, Closeable {
 * handle is released even on partial iteration.
 *
 * @param <T> element type
 * An {@link Iterator} that holds a resource (e.g. an open spill-file stream) and must be
 *
 *  
/*  
import java.io.Closeable;
 * @opensearch.internal
import java.util.Iterator;
 * {@link #close() closed} when iteration finishes or is abandoned.  
 */  
 * The OpenSearch Contributors require contributions made to  
 * SPDX-License-Identifier: Apache-2.0
 * <p>Used by the hash-shuffle consumer to drain a partition's chunks ONE AT A TIME — when the
    /** Closes the underlying resource. Idempotent. Never throws checked exceptions. */  
    @Override
 * chunks were spilled to disk, the iterator streams them back from the file without ever holding  
 * this file be licensed under the Apache-2.0 license or a
}  
/**
