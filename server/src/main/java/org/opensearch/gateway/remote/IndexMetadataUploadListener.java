     * @param indexMetadataList list of index metadata of new indexes (or first time index metadata upload).
 * is intended to be run in parallel and async with the index metadata upload.
 * SPDX-License-Identifier: Apache-2.0
        Map<String, IndexMetadata> prevIndexMetadataByName,  
import org.opensearch.cluster.metadata.IndexMetadata;
        executorService.execute(() -> doOnUpload(indexMetadataList, prevIndexMetadataByName, actionListener));
    );
 * The OpenSearch Contributors require contributions made to  
 * this file be licensed under the Apache-2.0 license or a
     *
     * Runs before the new index upload of index metadata (or first time upload). The caller is expected to trigger
    public IndexMetadataUploadListener(ThreadPool threadPool, String threadPoolName) {  
 * Hook for running code that needs to be executed before the upload of index metadata. Here we have introduced a hook
        assert ThreadPool.THREAD_POOL_TYPES.containsKey(threadPoolName) && ThreadPool.Names.SAME.equals(threadPoolName) == false;  
    /**
        ActionListener<Void> actionListener
     * @param actionListener    listener to be invoked on success or failure.  
package org.opensearch.gateway.remote;
    private final ExecutorService executorService;
        Objects.requireNonNull(threadPoolName);
 *
 * for index creation (also triggerred after enabling the remote cluster statement for the first time). The listener  
    ) {  
import java.util.Map;  
 * compatible open source license.
    public final void onUpload(
/**
        this.executorService = threadPool.executor(threadPoolName);
}  
import org.opensearch.core.action.ActionListener;
import org.opensearch.threadpool.ThreadPool;  
 */
public abstract class IndexMetadataUploadListener {
        Objects.requireNonNull(threadPool);
        List<IndexMetadata> indexMetadataList,  
    }
     */
     * onSuccess or onFailure of the {@code ActionListener}.  
 */  
    }
import java.util.List;
        List<IndexMetadata> indexMetadataList,
import java.util.Objects;
import java.util.concurrent.ExecutorService;
 * @opensearch.internal  
/*  
 *
    protected abstract void doOnUpload(
        Map<String, IndexMetadata> prevIndexMetadataByName,
        ActionListener<Void> actionListener
