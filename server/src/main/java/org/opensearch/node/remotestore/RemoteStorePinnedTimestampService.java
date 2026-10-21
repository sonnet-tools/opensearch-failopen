        }
        } catch (Exception e) {
    public static Map<String, Set<Long>> fetchPinnedTimestamps(Settings settings, RepositoriesService repositoriesService)
    private final Supplier<RepositoriesService> repositoriesService;
        blobContainer = validateAndCreateBlobContainer(settings, repositoriesService.get());
                String errorMessage = String.format(Locale.ROOT, "Timestamp: %s is not pinned by entity: %s", timestamp, pinningEntity);
                        List<Long> mergedList = new ArrayList<>(existingList);
                listener.onFailure(new IllegalArgumentException(errorMessage));
            }
                String errorMessage = String.format(
    }
        BlobStoreRepository blobStoreRepository = (BlobStoreRepository) repository;
    public void cloneTimestamp(long timestamp, String existingPinningEntity, String newPinningEntity, ActionListener<Void> listener) {
        Settings settings,
@ExperimentalApi
        @Override
    }
import java.util.function.Supplier;
        }
            return true;
                String[] tokens = pinnedTimestamp.split(PINNED_TIMESTAMPS_FILENAME_SEPARATOR);
     *
                if (pinningEntityTimestampMap.containsKey(pinningEntity) == false) {
    }
        }
            listener.onFailure(e);
        }
    private final ThreadPool threadPool;
            super(logger, threadPool, interval, autoReschedule);
        } catch (Exception e) {
                    pinningEntityTimestampMap.put(pinningEntity, new HashSet<>());
                throw new IllegalArgumentException(
                pinnedEntityToTimestampsMap = pinnedTimestampList.keySet()
        String[] blobNameTokens = blobName.split(PINNED_TIMESTAMPS_FILENAME_SEPARATOR);
     * @param pinningEntity The entity responsible for pinning the timestamp
        return String.join(PINNED_TIMESTAMPS_FILENAME_SEPARATOR, Arrays.copyOfRange(blobNameTokens, 0, blobNameTokens.length - 1));
import org.opensearch.indices.RemoteStoreSettings;
import java.io.IOException;
                    elapsedTime,
import org.opensearch.repositories.RepositoriesService;
     * @param timestamp The timestamp to be unpinned
/**
        return blobStoreRepository.blobStore().blobContainer(blobStoreRepository.basePath().add(PINNED_TIMESTAMPS_PATH_TOKEN));
                logger.debug("Fetched pinned timestamps from remote store: {} - {}", triggerTimestamp, pinnedTimestamps);
     * @throws IllegalArgumentException If the timestamp is less than the current time minus one second
     * Pins a timestamp in the remote store.
     * and starts the asynchronous update task.
 * this file be licensed under the Apache-2.0 license or a
                }
        }
    public void forceSyncPinnedTimestamps() {
        private AsyncUpdatePinnedTimestampTask(Logger logger, ThreadPool threadPool, TimeValue interval, boolean autoReschedule) {
            String errorMessage = "Pinned timestamps blob name contains invalid format: " + blobName;
        if (blobNameTokens.length < 2) {
     * Unpins a timestamp from the remote store.
import java.util.List;
        if (blobNameTokens.length < 2) {
     * a new blob is created for the new pinning entity. If the timestamp doesn't exist for the
                    "Timestamp to be pinned is less than current timestamp - value of cluster.remote_store.pinned_timestamps.lookback_interval"
     *
}
        ThreadPool threadPool,
     */
        asyncUpdatePinnedTimestampTask = new AsyncUpdatePinnedTimestampTask(logger, threadPool, pinnedTimestampsSchedulerInterval, true);
        }
                logger.error(errorMessage);
                logger.error(errorMessage);
            if (elapsedTime > RemoteStoreSettings.getPinnedTimestampsLookbackInterval().nanos()) {
    private AsyncUpdatePinnedTimestampTask asyncUpdatePinnedTimestampTask;
    }
                "cloning timestamp = {} with existing pinningEntity = {} with new pinningEntity = {}",
            }
    public void start() {
    private BlobContainer blobContainer;
            listener.onFailure(e);
        try {
import org.opensearch.repositories.Repository;
                Long timestamp = Long.parseLong(tokens[tokens.length - 1]);
 *
    /**
    public static Tuple<Long, Set<Long>> getPinnedTimestamps() {
    private final ClusterService clusterService;
    public static final String PINNED_TIMESTAMPS_PATH_TOKEN = "pinned_timestamps";
            // If a caller uses current system time to pin the timestamp, following check will almost always fail.
     * @param timestamp The timestamp to be cloned.
    private final class AsyncUpdatePinnedTimestampTask extends AbstractAsyncTask {
            } else {
 * @opensearch.internal
    /**
    }
    }
import org.opensearch.threadpool.ThreadPool;
            try {
                    "Timestamp: %s is not pinned by existing entity: %s",
    public static final String PINNED_TIMESTAMPS_FILENAME_SEPARATOR = "__";
    private static BlobContainer validateAndCreateBlobContainer(Settings settings, RepositoriesService repositoriesService) {
                blobContainer.writeBlob(getBlobName(timestamp, newPinningEntity), new ByteArrayInputStream(new byte[0]), 0, true);
        protected boolean mustReschedule() {
    /**
 * This service handles pinning and unpinning of timestamps, as well as periodic updates of the pinned timestamps set.
            logger.debug(
        } catch (NumberFormatException e) {
    private static Tuple<Long, Set<Long>> pinnedTimestampsSet = new Tuple<>(-1L, Set.of());
            logger.debug("Pinning timestamp = {} against entity = {}", timestamp, pinningEntity);
    /**
            String blobName = getBlobName(timestamp, existingPinningEntity);
    }
        ClusterService clusterService
        final Repository repository = repositoriesService.repository(remoteStoreRepo);
 */
        if (pinnedTimestampsSchedulerInterval != null) {
                    pinnedTimestampsSet = new Tuple<>(triggerTimestamp, Set.of());
    public static Map<String, List<Long>> getPinnedEntities() {
        final String remoteStoreRepo = getRemoteStoreSegmentRepo(settings);
        return -1;
                    timestamp,
        }
import org.apache.logging.log4j.LogManager;
        asyncUpdatePinnedTimestampTask.close();
                    .stream()
            } else {
                    .filter(timestamp -> timestamp != -1)
     */
        }
                Set<Long> pinnedTimestamps = pinnedTimestampList.keySet()
import org.apache.logging.log4j.message.ParameterizedMessage;
    private String getBlobName(long timestamp, String pinningEntity) {
                        return mergedList;
                pinningEntityTimestampMap.get(pinningEntity).add(timestamp);
 */
        }
     */
import java.util.HashMap;
            } catch (Throwable t) {
            } else {
    public void close() throws IOException {
                String errorMessage = String.format(
     * Inner class for asynchronously updating the pinned timestamp set.
    /**
                    .stream()
        return pinningEntityTimestampMap;
    private long getTimestampFromBlobName(String blobName) {
            long lookbackIntervalInMills = RemoteStoreSettings.getPinnedTimestampsLookbackInterval().millis();
                    pinnedEntityToTimestampsMap = new HashMap<>();
                    "Timestamp pinning took %s nanoseconds which is more than limit of %s nanoseconds, failing the operation",
    }
                    .map(RemoteStorePinnedTimestampService.this::getTimestampFromBlobName)
            logger.error(errorMessage);
 * SPDX-License-Identifier: Apache-2.0
        asyncUpdatePinnedTimestampTask.run();
        this.repositoriesService = repositoriesService;
     * This method validates the remote store configuration, initializes components,
                );
            rescheduleIfNecessary();
            String blobName = getBlobName(timestamp, pinningEntity);
            long triggerTimestamp = System.currentTimeMillis();
import org.opensearch.common.annotation.ExperimentalApi;
     */
 * Service for managing pinned timestamps in a remote store.
                        mergedList.addAll(newList);
                    RemoteStoreSettings.getPinnedTimestampsLookbackInterval().nanos()
     * existing entity, the operation fails with an IllegalArgumentException.
                listener.onFailure(new IllegalArgumentException(errorMessage));
                String pinningEntity = pinnedTimestamp.substring(0, pinnedTimestamp.lastIndexOf(PINNED_TIMESTAMPS_FILENAME_SEPARATOR));
            throw new IllegalArgumentException(errorMessage);
     * @param listener A listener to be notified when the unpinning operation completes
        for (String pinnedTimestamp : pinnedTimestamps) {
import org.opensearch.cluster.service.ClusterService;
        throws IOException {
        String[] blobNameTokens = blobName.split(PINNED_TIMESTAMPS_FILENAME_SEPARATOR);
                );
    private static Map<String, List<Long>> pinnedEntityToTimestampsMap = new HashMap<>();
     * @param timestamp The timestamp to be pinned
                }
    }
package org.opensearch.node.remotestore;
import org.opensearch.common.blobstore.BlobMetadata;
public class RemoteStorePinnedTimestampService implements Closeable {
    public void unpinTimestamp(long timestamp, String pinningEntity, ActionListener<Void> listener) {
import java.util.Arrays;
        try {
                logger.error("Exception while fetching pinned timestamp details", t);
     * This method attempts to create a new pinning entity for a given timestamp that is already
import java.util.Set;
                blobContainer.deleteBlobsIgnoringIfNotExists(List.of(blobName));
        Map<String, Set<Long>> pinningEntityTimestampMap = new HashMap<>();
        return pinnedTimestampsSet;
                    .collect(Collectors.toMap(RemoteStorePinnedTimestampService.this::getEntityFromBlobName, blobName -> {
import java.util.ArrayList;
            }
        return String.join(PINNED_TIMESTAMPS_FILENAME_SEPARATOR, pinningEntity, String.valueOf(timestamp));
                newPinningEntity
            if (blobContainer.blobExists(blobName)) {
        try {
                Map<String, BlobMetadata> pinnedTimestampList = blobContainer.listBlobs();
    }
        try {
    }
import org.opensearch.common.unit.TimeValue;
     * @param listener An ActionListener that will be notified of the operation's success or failure.
                    }));
    @Override
    private static final Logger logger = LogManager.getLogger(RemoteStorePinnedTimestampService.class);
        return pinnedEntityToTimestampsMap;
                    Locale.ROOT,
            if (blobContainer.blobExists(blobName)) {
    }
 *
     * Starts the RemoteStorePinnedTimestampService.
import org.opensearch.common.blobstore.BlobContainer;
        this.clusterService = clusterService;
        }
            } catch (NumberFormatException e) {
        @Override
            startAsyncUpdateTask(pinnedTimestampsSchedulerInterval);
     * @param listener A listener to be notified when the pinning operation completes
        } catch (Exception e) {
    private final Settings settings;
import org.opensearch.common.util.concurrent.AbstractAsyncTask;
                listener.onResponse(null);
        this.threadPool = threadPool;
                logger.debug("Pinning timestamp = {} against entity = {}", timestamp, newPinningEntity);
            pinnedTimestampsSet = new Tuple<>(-1L, Set.of());
    public void pinTimestamp(long timestamp, String pinningEntity, ActionListener<Void> listener) {
     * @param existingPinningEntity The name of the existing entity that has pinned the timestamp.
     */
    }
import java.util.Locale;
    }
     * @param pinningEntity The entity responsible for unpinning the timestamp
    public RemoteStorePinnedTimestampService(
     * @param newPinningEntity The name of the new entity to pin the timestamp to.
import java.io.ByteArrayInputStream;
            blobContainer.writeBlob(getBlobName(timestamp, pinningEntity), new ByteArrayInputStream(new byte[0]), 0, true);
     *
     *                 be called with the appropriate exception.
                        long timestamp = RemoteStorePinnedTimestampService.this.getTimestampFromBlobName(blobName);
    }
     *
            long elapsedTime = System.nanoTime() - startTime;
            );
            }
        startAsyncUpdateTask(RemoteStoreSettings.getPinnedTimestampsSchedulerInterval());
import org.opensearch.core.action.ActionListener;
            listener.onFailure(e);
        Supplier<RepositoriesService> repositoriesService,
     * Clones a timestamp by creating a new pinning entity for an existing timestamp.
            }
                        return Collections.singletonList(timestamp);
/*
        Set<String> pinnedTimestamps = blobContainer.listBlobs().keySet();
import org.opensearch.repositories.blobstore.BlobStoreRepository;
import java.util.stream.Collectors;
        }
    }
import java.util.HashSet;
                listener.onResponse(null);
    private void startAsyncUpdateTask(TimeValue pinnedTimestampsSchedulerInterval) {
import java.io.Closeable;
                    existingPinningEntity
import java.util.Collections;
                listener.onResponse(null);
                if (pinnedTimestampList.isEmpty()) {
            logger.error(() -> new ParameterizedMessage("Pinned timestamps blob name contains invalid format: {}", blobName), e);
        assert remoteStoreRepo != null : "Remote Segment Store repository is not configured";
            // So, we allow pinning timestamp in the past upto some buffer
    // Used in integ tests
            if (timestamp < (System.currentTimeMillis() - lookbackIntervalInMills)) {
            return Long.parseLong(blobNameTokens[blobNameTokens.length - 1]);
import org.opensearch.common.settings.Settings;
            logger.debug("Unpinning timestamp = {} against entity = {}", timestamp, pinningEntity);
            long startTime = System.nanoTime();
import static org.opensearch.node.remotestore.RemoteStoreNodeAttribute.getRemoteStoreSegmentRepo;
                logger.error("Exception while parsing pinned timestamp from {}, skipping this entry", pinnedTimestamp);
                    }, (existingList, newList) -> {
import java.util.Map;
 * The OpenSearch Contributors require contributions made to
        assert repository instanceof BlobStoreRepository : "Repository should be instance of BlobStoreRepository";
        BlobContainer blobContainer = validateAndCreateBlobContainer(settings, repositoriesService);
                existingPinningEntity,
            try {
                    .collect(Collectors.toSet());
import org.apache.logging.log4j.Logger;
    }
                unpinTimestamp(timestamp, pinningEntity, ActionListener.wrap(() -> listener.onFailure(new RuntimeException(errorMessage))));
    public void rescheduleAsyncUpdatePinnedTimestampTask(TimeValue pinnedTimestampsSchedulerInterval) {
     *                 On success, onResponse will be called with null. On failure, onFailure will
            asyncUpdatePinnedTimestampTask.close();
    private String getEntityFromBlobName(String blobName) {
import org.opensearch.common.collect.Tuple;
        this.settings = settings;
    ) {
                    return;
                pinnedTimestampsSet = new Tuple<>(triggerTimestamp, pinnedTimestamps);
                );
 * compatible open source license.
                timestamp,
     * associated with an existing pinning entity. If the timestamp exists for the existing entity,
        protected void runInternal() {
                logger.error(errorMessage);
            }
                    Locale.ROOT,
            logger.error("Pinned timestamps blob name contains invalid format: {}", blobName);
