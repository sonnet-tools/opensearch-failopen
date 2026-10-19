import java.util.concurrent.ConcurrentHashMap;
}  
import org.opensearch.common.io.IndexIOStreamHandlerFactory;
 * this file be licensed under the Apache-2.0 license or a
    private final ConcurrentHashMap<Integer, IndexIOStreamHandler<TranslogTransferMetadata>> handlers = new ConcurrentHashMap<>();
    }
package org.opensearch.index.translog.transfer;
    private IndexIOStreamHandler<TranslogTransferMetadata> createHandler(int version) {  
            case TranslogTransferMetadata.CURRENT_VERSION -> new TranslogTransferMetadataHandler();
 * SPDX-License-Identifier: Apache-2.0
 */
    @Override
import org.opensearch.common.io.IndexIOStreamHandler;
        };
 * The OpenSearch Contributors require contributions made to  
        return switch (version) {
 * @opensearch.internal
 * compatible open source license.
    }
/**  
/*  
 *
        return handlers.computeIfAbsent(version, this::createHandler);  
public class TranslogTransferMetadataHandlerFactory implements IndexIOStreamHandlerFactory<TranslogTransferMetadata> {  
 * {@link TranslogTransferMetadataHandlerFactory} is a factory class to create {@link TranslogTransferMetadataHandler}
 */  
    public IndexIOStreamHandler<TranslogTransferMetadata> getHandler(int version) {
 *  
            default -> throw new IllegalArgumentException("Unsupported TranslogTransferMetadata version: " + version);  
 * instances based on the {@link TranslogTransferMetadata} version
