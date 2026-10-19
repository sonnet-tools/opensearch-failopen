import org.apache.logging.log4j.message.ParameterizedMessage;  
 * this file be licensed under the Apache-2.0 license or a
        }
        throws IOException {  
import java.io.ByteArrayInputStream;
     *
            throw new IllegalArgumentException(errorMessage);
            long lookbackIntervalInMills = RemoteStoreSettings.getPinnedTimestampsLookbackInterval().millis();
     * and starts the asynchronous update task.  
    public void rescheduleAsyncUpdatePinnedTimestampTask(TimeValue pinnedTimestampsSchedulerInterval) {
 * This service handles pinning and unpinning of timestamps, as well as periodic updates of the pinned timestamps set.
            return Long.parseLong(blobNameTokens[blobNameTokens.length - 1]);
    public static Map<String, List<Long>> getPinnedEntities() {
        return String.join(PINNED_TIMESTAMPS_FILENAME_SEPARATOR, pinningEntity, String.valueOf(timestamp));
        }  
                throw new IllegalArgumentException(
                    pinnedTimestampsSet = new Tuple<>(triggerTimestamp, Set.of());
        return pinnedTimestampsSet;
import java.util.Arrays;
        for (String pinnedTimestamp : pinnedTimestamps) {
                newPinningEntity
import org.opensearch.repositories.blobstore.BlobStoreRepository;
    }
        }
            rescheduleIfNecessary();
    private long getTimestampFromBlobName(String blobName) {
        this.clusterService = clusterService;  
     * @param timestamp The timestamp to be pinned
                blobContainer.writeBlob(getBlobName(timestamp, newPinningEntity), new ByteArrayInputStream(new byte[0]), 0, true);
     * Pins a timestamp in the remote store.  
    // Used in integ tests  
import org.opensearch.cluster.service.ClusterService;
            logger.error("Pinned timestamps blob name contains invalid format: {}", blobName);
        Set<String> pinnedTimestamps = blobContainer.listBlobs().keySet();
                blobContainer.deleteBlobsIgnoringIfNotExists(List.of(blobName));  
            listener.onFailure(e);
                );  
import java.util.function.Supplier;
            } else {  
 * SPDX-License-Identifier: Apache-2.0
        return -1;
import org.opensearch.common.util.concurrent.AbstractAsyncTask;
            pinnedTimestampsSet = new Tuple<>(-1L, Set.of());  
    }
                logger.error(errorMessage);
    public void close() throws IOException {
import org.opensearch.core.action.ActionListener;  
            if (timestamp < (System.currentTimeMillis() - lookbackIntervalInMills)) {  
                );  
    /**
     * @param existingPinningEntity The name of the existing entity that has pinned the timestamp.
import java.util.Set;  
        protected void runInternal() {
            String blobName = getBlobName(timestamp, pinningEntity);
        if (pinnedTimestampsSchedulerInterval != null) {
    }
 * Service for managing pinned timestamps in a remote store.
    public void cloneTimestamp(long timestamp, String existingPinningEntity, String newPinningEntity, ActionListener<Void> listener) {
                pinningEntityTimestampMap.get(pinningEntity).add(timestamp);  
                listener.onResponse(null);
                listener.onResponse(null);
                listener.onFailure(new IllegalArgumentException(errorMessage));
import org.opensearch.common.blobstore.BlobContainer;  
import org.opensearch.threadpool.ThreadPool;
                logger.error("Exception while parsing pinned timestamp from {}, skipping this entry", pinnedTimestamp);
        } catch (NumberFormatException e) {
import org.opensearch.common.collect.Tuple;
     * associated with an existing pinning entity. If the timestamp exists for the existing entity,  
     */
     */
                    .collect(Collectors.toMap(RemoteStorePinnedTimestampService.this::getEntityFromBlobName, blobName -> {  
     *                 On success, onResponse will be called with null. On failure, onFailure will
            long triggerTimestamp = System.currentTimeMillis();  
        }  
        return String.join(PINNED_TIMESTAMPS_FILENAME_SEPARATOR, Arrays.copyOfRange(blobNameTokens, 0, blobNameTokens.length - 1));  
        String[] blobNameTokens = blobName.split(PINNED_TIMESTAMPS_FILENAME_SEPARATOR);  
                pinnedEntityToTimestampsMap = pinnedTimestampList.keySet()
 * compatible open source license.
            } catch (NumberFormatException e) {
            if (blobContainer.blobExists(blobName)) {
 * @opensearch.internal
}
            listener.onFailure(e);
                    RemoteStoreSettings.getPinnedTimestampsLookbackInterval().nanos()
                String errorMessage = String.format(
                    pinnedEntityToTimestampsMap = new HashMap<>();
                logger.error("Exception while fetching pinned timestamp details", t);  
     *
            );  
    private final ClusterService clusterService;
        }
import java.util.Locale;
     * @param newPinningEntity The name of the new entity to pin the timestamp to.  
                        long timestamp = RemoteStorePinnedTimestampService.this.getTimestampFromBlobName(blobName);
                );  
                String errorMessage = String.format(Locale.ROOT, "Timestamp: %s is not pinned by entity: %s", timestamp, pinningEntity);  
            try {
                    Locale.ROOT,
        Supplier<RepositoriesService> repositoriesService,
     * a new blob is created for the new pinning entity. If the timestamp doesn't exist for the
    private final class AsyncUpdatePinnedTimestampTask extends AbstractAsyncTask {
     */  
     * @param listener A listener to be notified when the unpinning operation completes
            logger.error(errorMessage);  
                }
        ThreadPool threadPool,  
                logger.error(errorMessage);
                }
import java.io.Closeable;
     * Clones a timestamp by creating a new pinning entity for an existing timestamp.  
    public RemoteStorePinnedTimestampService(  
 *
            }  
    private String getBlobName(long timestamp, String pinningEntity) {  
/**  
    public static Map<String, Set<Long>> fetchPinnedTimestamps(Settings settings, RepositoriesService repositoriesService)
                existingPinningEntity,
                        List<Long> mergedList = new ArrayList<>(existingList);
        BlobStoreRepository blobStoreRepository = (BlobStoreRepository) repository;  
    ) {
    public void unpinTimestamp(long timestamp, String pinningEntity, ActionListener<Void> listener) {
            listener.onFailure(e);
        this.repositoriesService = repositoriesService;  
        try {  
    public static Tuple<Long, Set<Long>> getPinnedTimestamps() {  
    private static Map<String, List<Long>> pinnedEntityToTimestampsMap = new HashMap<>();
    @Override
                if (pinnedTimestampList.isEmpty()) {  
import java.util.Map;
    private void startAsyncUpdateTask(TimeValue pinnedTimestampsSchedulerInterval) {
import java.util.HashMap;
    }  
        this.threadPool = threadPool;
                    .collect(Collectors.toSet());  
     *
                Long timestamp = Long.parseLong(tokens[tokens.length - 1]);
                Map<String, BlobMetadata> pinnedTimestampList = blobContainer.listBlobs();
    /**  
    public void forceSyncPinnedTimestamps() {  
            try {
    }
import org.opensearch.common.blobstore.BlobMetadata;
            // So, we allow pinning timestamp in the past upto some buffer
    private static BlobContainer validateAndCreateBlobContainer(Settings settings, RepositoriesService repositoriesService) {
        }  
     * @param timestamp The timestamp to be cloned.
     */
            }  
            String blobName = getBlobName(timestamp, existingPinningEntity);
 */  
        } catch (Exception e) {  
     * @param pinningEntity The entity responsible for pinning the timestamp  
import java.util.List;  
     * This method validates the remote store configuration, initializes components,
        if (blobNameTokens.length < 2) {
     * @throws IllegalArgumentException If the timestamp is less than the current time minus one second
                String errorMessage = String.format(
        ClusterService clusterService
            }
import org.opensearch.common.annotation.ExperimentalApi;
            } else {
public class RemoteStorePinnedTimestampService implements Closeable {
import static org.opensearch.node.remotestore.RemoteStoreNodeAttribute.getRemoteStoreSegmentRepo;
     *                 be called with the appropriate exception.  
    private final ThreadPool threadPool;
    public void pinTimestamp(long timestamp, String pinningEntity, ActionListener<Void> listener) {
                    "Timestamp pinning took %s nanoseconds which is more than limit of %s nanoseconds, failing the operation",  
    }  
    }  
import org.opensearch.common.unit.TimeValue;
 * The OpenSearch Contributors require contributions made to  
        asyncUpdatePinnedTimestampTask.run();
                    existingPinningEntity
     * @param pinningEntity The entity responsible for unpinning the timestamp
import org.apache.logging.log4j.LogManager;
                    }, (existingList, newList) -> {  
                "cloning timestamp = {} with existing pinningEntity = {} with new pinningEntity = {}",
    }  
            logger.debug("Pinning timestamp = {} against entity = {}", timestamp, pinningEntity);  
                    .filter(timestamp -> timestamp != -1)
        asyncUpdatePinnedTimestampTask = new AsyncUpdatePinnedTimestampTask(logger, threadPool, pinnedTimestampsSchedulerInterval, true);
                    .stream()
                    timestamp,
            long startTime = System.nanoTime();
            logger.debug(
            asyncUpdatePinnedTimestampTask.close();
    }  
        } catch (Exception e) {
     * existing entity, the operation fails with an IllegalArgumentException.
     *  
        startAsyncUpdateTask(RemoteStoreSettings.getPinnedTimestampsSchedulerInterval());
            }
                        mergedList.addAll(newList);
    }
import java.util.ArrayList;
     * Starts the RemoteStorePinnedTimestampService.
            startAsyncUpdateTask(pinnedTimestampsSchedulerInterval);
        }
                if (pinningEntityTimestampMap.containsKey(pinningEntity) == false) {  
                    "Timestamp: %s is not pinned by existing entity: %s",  
        }
                    "Timestamp to be pinned is less than current timestamp - value of cluster.remote_store.pinned_timestamps.lookback_interval"
    }
import java.util.HashSet;
import org.opensearch.repositories.Repository;  
import org.opensearch.common.settings.Settings;  
                pinnedTimestampsSet = new Tuple<>(triggerTimestamp, pinnedTimestamps);  
import java.util.Collections;  
    private static Tuple<Long, Set<Long>> pinnedTimestampsSet = new Tuple<>(-1L, Set.of());  
        try {  
        return pinningEntityTimestampMap;
            // If a caller uses current system time to pin the timestamp, following check will almost always fail.  
        assert remoteStoreRepo != null : "Remote Segment Store repository is not configured";  
            blobContainer.writeBlob(getBlobName(timestamp, pinningEntity), new ByteArrayInputStream(new byte[0]), 0, true);
            super(logger, threadPool, interval, autoReschedule);
        }
        if (blobNameTokens.length < 2) {  
                    return;  
        protected boolean mustReschedule() {  
            logger.error(() -> new ParameterizedMessage("Pinned timestamps blob name contains invalid format: {}", blobName), e);  
                    .stream()  
            }
                    }));
                        return Collections.singletonList(timestamp);
    private final Supplier<RepositoriesService> repositoriesService;
                    .map(RemoteStorePinnedTimestampService.this::getTimestampFromBlobName)
                    elapsedTime,
                listener.onFailure(new IllegalArgumentException(errorMessage));
    public void start() {
    public static final String PINNED_TIMESTAMPS_FILENAME_SEPARATOR = "__";  
    private final Settings settings;  
        @Override
     * @param listener An ActionListener that will be notified of the operation's success or failure.
    }  
            }  
                timestamp,  
                logger.error(errorMessage);
                String pinningEntity = pinnedTimestamp.substring(0, pinnedTimestamp.lastIndexOf(PINNED_TIMESTAMPS_FILENAME_SEPARATOR));
        blobContainer = validateAndCreateBlobContainer(settings, repositoriesService.get());  
        }
                listener.onResponse(null);
    private AsyncUpdatePinnedTimestampTask asyncUpdatePinnedTimestampTask;
    }
                logger.debug("Pinning timestamp = {} against entity = {}", timestamp, newPinningEntity);  
    /**
/*  
        final Repository repository = repositoriesService.repository(remoteStoreRepo);
     * Unpins a timestamp from the remote store.
    private BlobContainer blobContainer;  
import org.opensearch.indices.RemoteStoreSettings;
    }
        String[] blobNameTokens = blobName.split(PINNED_TIMESTAMPS_FILENAME_SEPARATOR);
        Map<String, Set<Long>> pinningEntityTimestampMap = new HashMap<>();  
        return pinnedEntityToTimestampsMap;
     */  
        private AsyncUpdatePinnedTimestampTask(Logger logger, ThreadPool threadPool, TimeValue interval, boolean autoReschedule) {  
 *  
            logger.debug("Unpinning timestamp = {} against entity = {}", timestamp, pinningEntity);  
    /**
                unpinTimestamp(timestamp, pinningEntity, ActionListener.wrap(() -> listener.onFailure(new RuntimeException(errorMessage))));
        return blobStoreRepository.blobStore().blobContainer(blobStoreRepository.basePath().add(PINNED_TIMESTAMPS_PATH_TOKEN));
                Set<Long> pinnedTimestamps = pinnedTimestampList.keySet()
@ExperimentalApi  
        asyncUpdatePinnedTimestampTask.close();  
                        return mergedList;  
    private static final Logger logger = LogManager.getLogger(RemoteStorePinnedTimestampService.class);
        @Override
                String[] tokens = pinnedTimestamp.split(PINNED_TIMESTAMPS_FILENAME_SEPARATOR);  
            } catch (Throwable t) {
import java.io.IOException;  
                logger.debug("Fetched pinned timestamps from remote store: {} - {}", triggerTimestamp, pinnedTimestamps);
            String errorMessage = "Pinned timestamps blob name contains invalid format: " + blobName;
        try {
        final String remoteStoreRepo = getRemoteStoreSegmentRepo(settings);
package org.opensearch.node.remotestore;
    private String getEntityFromBlobName(String blobName) {
     * @param timestamp The timestamp to be unpinned  
     * Inner class for asynchronously updating the pinned timestamp set.  
import org.apache.logging.log4j.Logger;
            if (blobContainer.blobExists(blobName)) {
        this.settings = settings;
            } else {  
 */
            if (elapsedTime > RemoteStoreSettings.getPinnedTimestampsLookbackInterval().nanos()) {  
import org.opensearch.repositories.RepositoriesService;
                    Locale.ROOT,
import java.util.stream.Collectors;
        BlobContainer blobContainer = validateAndCreateBlobContainer(settings, repositoriesService);
        Settings settings,
        assert repository instanceof BlobStoreRepository : "Repository should be instance of BlobStoreRepository";
    /**  
        } catch (Exception e) {
     * @param listener A listener to be notified when the pinning operation completes
    }
        try {
    }
                    pinningEntityTimestampMap.put(pinningEntity, new HashSet<>());
    public static final String PINNED_TIMESTAMPS_PATH_TOKEN = "pinned_timestamps";
        }  
     * This method attempts to create a new pinning entity for a given timestamp that is already
            long elapsedTime = System.nanoTime() - startTime;
    }
            return true;
