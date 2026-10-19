                        }
        warmPath.fileCacheUtilized = adjustForHugeFilesystems(nodeCacheService.cacheUtilizedBytes());
 * ratios, rather than actual physical disk usage.
        this.nodeCacheService = nodeCacheService;
        FileCacheSettings fileCacheSettings,
        warmPath.total = adjustForHugeFilesystems(totalBytes);
 */
        );
        final long blockCacheCapacity = nodeCacheService.blockCacheCapacityBytes();
        warmPath.available = adjustForHugeFilesystems(freeBytes);  
                            logger.error("Unable to get store size for shard {} with error: {}", shard.shardId(), e.getMessage());  
                            usedBytes += shard.store().stats(0).getSizeInBytes();
            }
    private static final Logger logger = LogManager.getLogger(WarmFsService.class);
        long freeBytes = Math.max(0, totalBytes - usedBytes);
        this.fileCacheSettings = fileCacheSettings;  
        if (indicesService != null) {
                        } catch (Exception e) {
            "Warm node disk usage — total: {}, used: {}, free: {}, cacheReserved: {}, cacheUtilized: {}",
 * @opensearch.internal  
                    }
import org.opensearch.indices.IndicesService;  
        warmPath.type = "warm";  
/**
    }  
        NodeCacheService nodeCacheService  
        NodeEnvironment nodeEnvironment,  
            warmPath.fileCacheUtilized
import org.opensearch.env.NodeEnvironment;
        logger.trace(
 * this file be licensed under the Apache-2.0 license or a
        final long totalBytes = (long) (dataToFileCacheRatio * fileCacheCapacity) + nodeCacheService.virtualBlockCacheBytes();
        warmPath.mount = "warm";
    }  
import org.apache.logging.log4j.LogManager;
public class WarmFsService extends FsService {
 */  
            for (IndexService indexService : indicesService) {  
import org.opensearch.index.store.remote.filecache.FileCacheSettings;
        return new FsInfo(System.currentTimeMillis(), nodeFsInfo.getIoStats(), new FsInfo.Path[] { warmPath });
        // Used bytes from primary shards  
        FsInfo nodeFsInfo = super.stats();
                for (IndexShard shard : indexService) {
    private final NodeCacheService nodeCacheService;
    ) {
        IndicesService indicesService,
        warmPath.path = "/warm";
 *
 * total SSD reservation across all caches and their respective data-to-cache  
            usedBytes,
            freeBytes,
/*  
import org.opensearch.common.settings.Settings;  
import org.opensearch.index.IndexService;
            totalCacheCapacity,  
    @Override
                    if (shard.routingEntry() != null && shard.routingEntry().primary() && shard.routingEntry().active()) {
    private final IndicesService indicesService;
        warmPath.free = adjustForHugeFilesystems(freeBytes);
 * SPDX-License-Identifier: Apache-2.0
        this.indicesService = indicesService;
        warmPath.fileCacheReserved = totalCacheCapacity > 0 ? adjustForHugeFilesystems(totalCacheCapacity) : -1L;
import org.opensearch.index.shard.IndexShard;  
    public FsInfo stats() {  
import org.apache.logging.log4j.Logger;
import static org.opensearch.monitor.fs.FsProbe.adjustForHugeFilesystems;
 * FileSystem service for warm nodes. Reports virtual disk capacity based on
 *
        final long totalCacheCapacity = fileCacheCapacity + blockCacheCapacity;
        long usedBytes = 0;
    public WarmFsService(
 * The OpenSearch Contributors require contributions made to  
                        try {  
}
import org.opensearch.index.store.remote.filecache.NodeCacheService;
            totalBytes,  
                }  
    private final FileCacheSettings fileCacheSettings;  
package org.opensearch.monitor.fs;
        final long fileCacheCapacity = nodeCacheService.fileCache().capacity();  
        }
        final double dataToFileCacheRatio = fileCacheSettings.getRemoteDataRatio();
        Settings settings,
 * compatible open source license.
        FsInfo.Path warmPath = new FsInfo.Path();  
        super(settings, nodeEnvironment, nodeCacheService.fileCache());
