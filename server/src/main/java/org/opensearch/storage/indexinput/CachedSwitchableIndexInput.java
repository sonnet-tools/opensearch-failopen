        );
 */
        }
    @Override
    }
    @Override  
    public long length() {  
            localDirectory,
        RemoteSegmentStoreDirectory remoteDirectory,  
/*  
 *
import java.io.IOException;
import org.apache.lucene.store.IndexInput;  
}  
            getFilePath(localDirectory, fileName),
            transferManager,
        return 0;
        return switchableIndexInput;
import org.apache.lucene.store.FSDirectory;
    }
 * this file be licensed under the Apache-2.0 license or a
        switchableIndexInput = new SwitchableIndexInput(
            switchableIndexInput.close();  
import org.opensearch.index.store.remote.filecache.FileCache;  
import org.opensearch.storage.prefetch.TieredStoragePrefetchSettings;
    public IndexInput getIndexInput() {  
 */  
            tieredStoragePrefetchSettingsSupplier
    @Override
 * A {@link CachedIndexInput} implementation that wraps a {@link SwitchableIndexInput} for use with the file cache.
        isClosed = new AtomicBoolean(false);  
import java.util.function.Supplier;
            resourceDescription,  
            fileName,
    ) throws IOException {
import org.opensearch.index.store.RemoteSegmentStoreDirectory;
            remoteDirectory,  
import static org.opensearch.storage.utils.DirectoryUtils.getFilePathSwitchable;
 * SPDX-License-Identifier: Apache-2.0
        boolean cacheFromRemote,
        String resourceDescription = "SwitchableIndexInput (path=" + getFilePath(localDirectory, fileName) + ")";
/**  
import org.opensearch.index.store.remote.filecache.CachedIndexInput;
    private final AtomicBoolean isClosed;  
            fileCache,
        String fileName,
    }
        FileCache fileCache,  
import org.opensearch.index.store.remote.utils.TransferManager;
        return isClosed.get();  
    @Override
package org.opensearch.storage.indexinput;
import org.opensearch.threadpool.ThreadPool;  
            threadPool,  
    public boolean isClosed() {
import org.apache.lucene.store.AlreadyClosedException;
        FSDirectory localDirectory,
            cacheFromRemote,
    public CachedSwitchableIndexInput(
    }  
        if (!isClosed.getAndSet(true)) {
            getFilePathSwitchable(localDirectory, fileName),  
    private final SwitchableIndexInput switchableIndexInput;
 * The OpenSearch Contributors require contributions made to  
 * compatible open source license.
        if (isClosed.get()) throw new AlreadyClosedException("Index input is already closed");
public class CachedSwitchableIndexInput implements CachedIndexInput {  
import static org.opensearch.storage.utils.DirectoryUtils.getFilePath;  
    public void close() throws Exception {
        ThreadPool threadPool,  
import java.util.concurrent.atomic.AtomicBoolean;  
        TransferManager transferManager,
    }  
        Supplier<TieredStoragePrefetchSettings> tieredStoragePrefetchSettingsSupplier
