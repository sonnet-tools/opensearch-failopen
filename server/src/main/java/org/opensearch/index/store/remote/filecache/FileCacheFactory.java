                }
 * (Least Recently Used) in the FC is replaced first.
            .listener((removalNotification) -> {
 */
 * this file be licensed under the Apache-2.0 license or a
}
        return SegmentedCache.<Path, CachedIndexInput>builder()
 */  
                    }  
        return new FileCache(createDefaultBuilder().capacity(capacity).build());  
    public static FileCache createConcurrentLRUFileCache(long capacity, int concurrencyLevel) {  
                RemovalReason removalReason = removalNotification.getRemovalReason();  
import org.opensearch.common.cache.RemovalReason;
    public static FileCache createConcurrentLRUFileCache(long capacity) {
import org.opensearch.index.store.remote.utils.cache.SegmentedCache;
 * items from cache tail and triggers a callback to clean up the file from disk. The
 *
                    // tests  
import java.nio.file.Files;
 * <p> The get function does not add file to cache, but it promotes the priority  
    private static SegmentedCache.Builder<Path, CachedIndexInput> createDefaultBuilder() {
            .weigher(CachedIndexInput::length)
 * to the file cache, the file will be added at cache head, which means it has the highest
                    if (removalReason != RemovalReason.RESTARTED) {
                    // On RESTARTED removal, we close the IndexInput but preserve the files on disk as this scenario only occurs during
    }
 * SPDX-License-Identifier: Apache-2.0
 *
 * of a given file (since it makes it the most recently used).
 * priority.
 * compatible open source license.
        return new FileCache(createDefaultBuilder().capacity(capacity).concurrencyLevel(concurrencyLevel).build());
 * @opensearch.internal
 *  
                        catchAsRuntimeException(() -> Files.deleteIfExists(key));
    }  
package org.opensearch.index.store.remote.filecache;
                Path key = removalNotification.getKey();
 * The OpenSearch Contributors require contributions made to  
import java.nio.file.Path;
/**  
            });
                if (removalReason != RemovalReason.REPLACED) {  
public class FileCacheFactory {  
 * caching only those index files needed by queries. The file with the lowest priority  
 *
    }
                CachedIndexInput value = removalNotification.getValue();
 * the entire dataset on remote store. It maintains a node level view of index files with priorities,
import static org.opensearch.ExceptionsHelper.catchAsRuntimeException;
                    catchAsRuntimeException(value::close);
            // use length in bytes as the weight of the file item  
 * cleanup process also includes closing file’s descriptor.
 * File Cache (FC) is introduced to solve the problem that the local disk cannot hold
 * <p>Once file cache reaches its capacity, it starts evictions. Eviction removes the file  
 * <p>The two main interfaces of FC are put and get. When a new file index input is added  
/*  
