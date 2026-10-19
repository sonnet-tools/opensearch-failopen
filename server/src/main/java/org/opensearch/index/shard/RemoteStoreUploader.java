import java.util.Map;  
package org.opensearch.index.shard;
/**  
import java.util.function.Function;
public interface RemoteStoreUploader {  
        Map<String, Long> localSegmentsSizeMap,
 * Interface to handle the functionality for uploading data in the remote store
 *
import org.opensearch.core.action.ActionListener;  
 * this file be licensed under the Apache-2.0 license or a
    void uploadSegments(
import java.util.Collection;
 * compatible open source license.
 */
import org.opensearch.common.util.UploadListener;
import org.opensearch.cluster.metadata.CryptoMetadata;
        Collection<String> localSegments,  
}
        CryptoMetadata cryptoMetadata
        boolean isLowPriorityUpload,
        Function<Map<String, Long>, UploadListener> uploadListenerFunction,  
 * The OpenSearch Contributors require contributions made to  
 * SPDX-License-Identifier: Apache-2.0
    );  
/*  
        ActionListener<Void> listener,
 */  
