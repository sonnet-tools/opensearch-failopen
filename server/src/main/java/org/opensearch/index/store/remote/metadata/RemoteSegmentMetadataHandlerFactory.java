 * The OpenSearch Contributors require contributions made to  
/*  
 */
import org.opensearch.common.io.IndexIOStreamHandlerFactory;
    @Override  
        IndexIOStreamHandler<RemoteSegmentMetadata> newHandler = createHandler(version);
public class RemoteSegmentMetadataHandlerFactory implements IndexIOStreamHandlerFactory<RemoteSegmentMetadata> {  
        };
 */  
    private IndexIOStreamHandler<RemoteSegmentMetadata> createHandler(int version) {  
import java.util.concurrent.atomic.AtomicReference;
        IndexIOStreamHandler<RemoteSegmentMetadata> current = handlerRef.get();
package org.opensearch.index.store.remote.metadata;
/**  
 * SPDX-License-Identifier: Apache-2.0
        }
    }
            case RemoteSegmentMetadata.VERSION_ONE -> new RemoteSegmentMetadataHandler(RemoteSegmentMetadata.VERSION_ONE);
            return current;
 *
            default -> throw new IllegalArgumentException("Unsupported RemoteSegmentMetadata version: " + version);
        if (current != null) {  
    private final AtomicReference<IndexIOStreamHandler<RemoteSegmentMetadata>> handlerRef = new AtomicReference<>();
 * {@link RemoteSegmentMetadataHandlerFactory} is a factory class to create {@link RemoteSegmentMetadataHandler}
        handlerRef.compareAndSet(null, newHandler);
        return switch (version) {
            case RemoteSegmentMetadata.VERSION_TWO -> new RemoteSegmentMetadataHandler(RemoteSegmentMetadata.VERSION_TWO);  
    public IndexIOStreamHandler<RemoteSegmentMetadata> getHandler(int version) {
        return handlerRef.get();  
    }  
 * instances based on the {@link RemoteSegmentMetadata} version
 *  
 * @opensearch.internal
import org.opensearch.common.io.IndexIOStreamHandler;
}
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
