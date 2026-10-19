 * index mapping captured when the request started. {@code IndicesService#createIndexMapperService}  
        if (mapperService != null) {  
        IndexMetadata indexMetadata,  
                created.merge(indexMetadata, MapperService.MergeReason.MAPPING_RECOVERY);
    private static final Logger logger = LogManager.getLogger(RequestScopedMapperService.class);
            logger.warn("Failed to resolve MapperService for index [{}]", indexMetadata.getIndex().getName(), e);  
 */  
    private final CheckedFunction<IndexMetadata, MapperService, IOException> mapperServiceFactory;
 * this file be licensed under the Apache-2.0 license or a
            return null;
        }
            IOUtils.closeWhileHandlingException(mapperService);
    private boolean resolved;
 */
    @Override
import org.apache.logging.log4j.LogManager;
    private MapperService resolve() {
import java.io.IOException;  
                throw e;  
    private MapperService mapperService;
        }
import java.io.Closeable;
                IOUtils.closeWhileHandlingException(created);
        closed = true;
    }
 * pattern the server's {@code MetadataMappingService} uses), memoizes the result, and releases  
/*  
 * The OpenSearch Contributors require contributions made to  
    @Override  
    RequestScopedMapperService(
 * SPDX-License-Identifier: Apache-2.0
 * returns an <em>empty</em> MapperService, so the holder merges the pinned mapping in before
    public synchronized void close() {
}
    }  
        }  
 * it on {@link #close()}. {@link #get()} returns null only when creating or merging fails.
        if (closed) {  
    ) {
package org.opensearch.dsl.action;
        try {
        this.indexMetadata = Objects.requireNonNull(indexMetadata, "indexMetadata must not be null");  
                return created;  
 * Request-scoped, lazily created {@link MapperService} for response key typing, pinned to the
import org.opensearch.cluster.metadata.IndexMetadata;  
        return mapperService;
import java.util.Objects;
        if (resolved == false) {  
 * compatible open source license.
            } catch (Exception e) {
            resolved = true;
/**
        } catch (Exception e) {
            mapperService = resolve();
            MapperService created = mapperServiceFactory.apply(indexMetadata);  
            try {
            return null;
    private final IndexMetadata indexMetadata;
    }
        }  
 * handing it out ({@link MapperService.MergeReason#MAPPING_RECOVERY}, the same create-and-merge
    }
        CheckedFunction<IndexMetadata, MapperService, IOException> mapperServiceFactory
final class RequestScopedMapperService implements Supplier<MapperService>, Closeable {  
import org.opensearch.common.CheckedFunction;
import java.util.function.Supplier;
    /** Releases the MapperService's analyzer resources. Safe to call more than once. */
import org.opensearch.common.util.io.IOUtils;
 *
    private boolean closed;  
import org.apache.logging.log4j.Logger;
            mapperService = null;
    public synchronized MapperService get() {
import org.opensearch.index.mapper.MapperService;  
            }
        this.mapperServiceFactory = mapperServiceFactory;
