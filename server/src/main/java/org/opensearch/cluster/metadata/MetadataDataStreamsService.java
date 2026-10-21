                    + "] cannot be added as a backing index because it does not have a ["
    public static final class ModifyDataStreamsClusterStateUpdateRequest extends ClusterStateUpdateRequest {
import org.opensearch.common.unit.TimeValue;
        if (DateFieldMapper.CONTENT_TYPE.equals(type) == false && DateFieldMapper.DATE_NANOS_CONTENT_TYPE.equals(type) == false) {
        ) {
        }
                    + indexName
     */
            IndexMetadata.Builder hiddenIndexMetadata = IndexMetadata.builder(indexMetadata)
 * directly rather than through {@code ModifyDataStreamsAction}'s transport layer.
        // of the index name (a .ds-<name>-NNNNNN name is not proof the index came from create/rollover; any index can
        }
import org.opensearch.common.Priority;
import org.opensearch.index.mapper.DateFieldMapper;
        final TimeValue ackTimeout,
    /**
            throw new IllegalArgumentException(
                    + "] of data stream ["
        // Mirror the hidden setting applied on attach: a detached index is no longer a backing index, so make it
        this.modifyDataStreamTaskKey = clusterService.registerClusterManagerTask(MODIFY_DATA_STREAM, true);
        if (request.actions.isEmpty()) {
            clusterManagerNodeTimeout(clusterManagerNodeTimeout);
        // it), and this API never creates indices. New write indices come from rollover.
            switch (action.type()) {
import org.opensearch.cluster.service.ClusterManagerTaskThrottler;
            "update-data-streams",
                }
        }
            return dataStream;
            metadataBuilder.put(
import java.util.HashMap;
            if (index.getName().equals(indexName)) {
     * Rejects a resulting state in which any index is a backing index of more than one data stream, checking the full
    }
        if (dataStream.getIndices().contains(index)) {
                    + "] because it is the write index"
     * @param ackTimeout                timeout for the cluster-state update to be acknowledged
package org.opensearch.cluster.metadata;
                "index ["
        clusterService.submitStateUpdateTask(
        // Data stream search relies on the timestamp field, so every attached index must map it as a date, regardless
        if (toRemove == null) {
     * final membership so the outcome does not depend on action order.
import static org.opensearch.cluster.service.ClusterManagerTask.MODIFY_DATA_STREAM;
            // Idempotent: already a member.
        }
        validateTimestampFieldMapping(indexMetadata, dataStream.getTimeStampField().getName());
            List<DataStreamAction> actions,
        }
                    + dataStream.getName()
            updated.put(dataStreamName, dataStream);
        public List<DataStreamAction> getActions() {
                IndexMetadata.builder(detached)
                        "index ["
                    throw new IllegalArgumentException("unsupported data stream action type [" + action.type() + "]");
        }
import org.opensearch.cluster.ack.ClusterStateUpdateResponse;
            }
        // be created with that name and an arbitrary mapping).
                if (previousOwner != null && previousOwner.equals(dataStream.getName()) == false) {
        Map<String, DataStream> finalStreams = new HashMap<>(currentStreams);
     * @param listener                  notified when the update completes
    private final ClusterManagerTaskThrottler.ThrottlingKey modifyDataStreamTaskKey;
        for (DataStreamAction action : actions) {
 * An added index is marked hidden (as all backing indices are) and a removed index is made visible again. If an index
        // the current generation cannot exist alongside a lower-generation stream (Metadata#validateDataStreams rejects
        modifyDataStream(new ModifyDataStreamsClusterStateUpdateRequest(actions, clusterManagerNodeTimeout, ackTimeout), listener);
            if (dataStream == null) {
            );
                String previousOwner = indexToStream.putIfAbsent(index.getName(), dataStream.getName());
            listener,
        if (writeIndex.equals(toRemove)) {
            }
     * @param actions                   the metadata-only actions to apply atomically
 * This service is injectable, so components such as cross-cluster replication can call {@link #modifyDataStream}
 * mutations; they never create, delete, restore, open, close, or relocate indices. The write index (and hence the
                    break;
            return actions;
 *
 * <p>
            Object properties = mapping.sourceAsMap().get("properties");
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;
import org.opensearch.cluster.AckedClusterStateUpdateTask;
    @SuppressWarnings("unchecked")
                    + dataStream.getName()
        return dataStream.addBackingIndex(index);
 * again.
    }
        Map<String, DataStream> updated = new LinkedHashMap<>();
                    + indexName
        public ModifyDataStreamsClusterStateUpdateRequest(
            listener.onResponse(new AcknowledgedResponse(true));
        final ModifyDataStreamsClusterStateUpdateRequest request,
    private static DataStream applyRemoveBackingIndex(Metadata.Builder metadataBuilder, DataStream dataStream, String indexName) {
 */
    private static void validateNoSharedBackingIndices(Map<String, DataStream> currentStreams, Map<String, DataStream> updatedStreams) {
                    type = ((Map<String, Object>) field).get("type");
                    .settings(Settings.builder().put(detached.getSettings()).put(IndexMetadata.SETTING_INDEX_HIDDEN, false))
        Index index = indexMetadata.getIndex();
        ActionListener<ClusterStateUpdateResponse> wrappedListener = ActionListener.map(
                @Override
        }
                public ClusterState execute(ClusterState currentState) {
            TimeValue ackTimeout
 * Adds or removes backing indices of data streams in a single atomic cluster-state update. These are metadata-only
 * was hidden before it was ever a backing index, detaching it therefore leaves it visible; the caller can hide it
     * @opensearch.internal
            this.actions = actions;
     * @param clusterManagerNodeTimeout timeout for reaching the cluster-manager node
import org.opensearch.common.settings.Settings;
        if (dataStream.getIndices().size() == 1) {
    }
        final ActionListener<AcknowledgedResponse> listener
                    + "] because it is the last backing index; delete the data stream instead"
import org.opensearch.cluster.service.ClusterService;
        }
                    dataStream = applyRemoveBackingIndex(metadataBuilder, dataStream, action.index());
                @Override
     *
    public void modifyDataStream(
import org.opensearch.action.admin.indices.datastream.DataStreamAction;
        if (detached != null && IndexMetadata.INDEX_HIDDEN_SETTING.get(detached.getSettings())) {
        IndexMetadata detached = metadataBuilder.get(indexName);
                throw new IllegalArgumentException("data stream [" + dataStreamName + "] not found");
        return dataStream.removeBackingIndex(toRemove);
    private static final Logger logger = LogManager.getLogger(MetadataDataStreamsService.class);
        // Metadata.build() additionally rejects a stream whose prefix matches an index with a counter above its
        // Task is onboarded for throttling, it will get retried from associated TransportClusterManagerNodeAction.
            );
    }
                if (field instanceof Map) {
    }
            }
            );
            TimeValue clusterManagerNodeTimeout,
                    throw new IllegalArgumentException(
        for (DataStream dataStream : updated.values()) {
}
 * SPDX-License-Identifier: Apache-2.0
        IndexMetadata indexMetadata = metadataBuilder.get(indexName);
                break;
                    + "] of data stream ["
        // generation.
    ) {
        }
     */
import java.util.List;
                            + "] and ["
        }
        if (mapping != null) {
                case REMOVE_BACKING_INDEX:
    /**
    }
                case ADD_BACKING_INDEX:
        // The added index is always a non-write index, so the generation is unchanged: an index whose counter exceeds
        }
                toRemove = index;
                @Override
                    + timestampFieldName
/**
        for (Index index : dataStream.getIndices()) {
                }
        Map<String, String> indexToStream = new HashMap<>();
    public MetadataDataStreamsService(ClusterService clusterService) {
                .settingsVersion(indexMetadata.getSettingsVersion() + 1);
    private static DataStream applyAddBackingIndex(Metadata.Builder metadataBuilder, DataStream dataStream, String indexName) {
                default:
        return ClusterState.builder(currentState).metadata(metadataBuilder).build();
                    + "] field mapped as a date type"
 * this file be licensed under the Apache-2.0 license or a
            index = hiddenIndexMetadata.build().getIndex();
        }
     */
        final ActionListener<AcknowledgedResponse> listener
import org.opensearch.core.action.ActionListener;
 * pre-existing regular indices into a data stream.
            new AckedClusterStateUpdateTask<ClusterStateUpdateResponse>(Priority.HIGH, request, wrappedListener) {
     * Convenience entry point for in-process callers (e.g. cross-cluster replication) that want to apply a batch of
        // rollover. put(IndexMetadata.Builder) bumps the index metadata version; the top-level Metadata version is
            }
     * data-stream actions without constructing a {@link ModifyDataStreamsClusterStateUpdateRequest}.
                    .settingsVersion(detached.getSettingsVersion() + 1)
        }
        // bumped by the cluster-manager service on publish.
                    return new ClusterStateUpdateResponse(acknowledged);
                            + dataStream.getName()
            ackTimeout(ackTimeout);
        // Backing indices are hidden; mark the index hidden if it is not already, matching data stream creation and
            String dataStreamName = action.dataStream();
    }
                    break;
        MappingMetadata mapping = indexMetadata.mapping();
        }
        final List<DataStreamAction> actions,
 * <p>
    }
    /**
    public void modifyDataStream(
        if (IndexMetadata.INDEX_HIDDEN_SETTING.get(indexMetadata.getSettings()) == false) {
    private final ClusterService clusterService;
import java.util.Map;
        );
        Index writeIndex = dataStream.getIndices().get(dataStream.getIndices().size() - 1);
     *
 * generation) is preserved: added indices become non-write backing indices, and the write index cannot be removed.
/*
import org.opensearch.cluster.ack.ClusterStateUpdateRequest;
            if (properties instanceof Map) {
                    return modifyDataStream(currentState, request.actions);
                Object field = ((Map<String, Object>) properties).get(timestampFieldName);
     * Verifies the index maps the data stream's timestamp field as a date type, which data stream search requires.
    static ClusterState modifyDataStream(ClusterState currentState, Iterable<DataStreamAction> actions) {
                    dataStream = applyAddBackingIndex(metadataBuilder, dataStream, action.index());
    /**
            metadataBuilder.put(hiddenIndexMetadata);
                    );
 * compatible open source license.
import java.util.LinkedHashMap;
            }
                            + previousOwner
                }
                public ClusterManagerTaskThrottler.ThrottlingKey getClusterManagerThrottlingKey() {
        for (DataStream dataStream : finalStreams.values()) {
            throw new IllegalArgumentException(
 *
 */
     */
                }
            DataStream dataStream = updated.getOrDefault(dataStreamName, currentState.metadata().dataStreams().get(dataStreamName));
        }
                "cannot remove backing index ["
import org.apache.logging.log4j.Logger;
            throw new IllegalArgumentException("index [" + indexName + "] is not part of data stream [" + dataStream.getName() + "]");
     * Applies the given actions to the current cluster state and returns the updated state. Visible for testing.
     */
                            + "] cannot be a backing index of more than one data stream, but is claimed by ["
        // visible again. If it was hidden before it was ever a backing index, the caller can hide it again.
            response -> new AcknowledgedResponse(response.isAcknowledged())
            return;
    /**
        Object type = null;
                    return modifyDataStreamTaskKey;
import org.apache.logging.log4j.LogManager;
            logger.info("updating data stream [{}]", dataStream.getName());
        if (indexMetadata == null) {
    }
        validateNoSharedBackingIndices(currentState.metadata().dataStreams(), updated);
                    + indexMetadata.getIndex().getName()
            metadataBuilder.put(dataStream);
 * @opensearch.internal
        finalStreams.putAll(updatedStreams);
        this.clusterService = clusterService;
import org.opensearch.cluster.ClusterState;
        // Track streams we've mutated so multiple actions against the same stream compose within this single update.
        final TimeValue clusterManagerNodeTimeout,
    ) {
        );
 * Added indices need not follow the {@code .ds-<dataStream>-NNNNNN} naming convention, which allows migrating
            for (Index index : dataStream.getIndices()) {
        private final List<DataStreamAction> actions;
    public static void validateTimestampFieldMapping(IndexMetadata indexMetadata, String timestampFieldName) {
        Metadata.Builder metadataBuilder = Metadata.builder(currentState.metadata());
        // The write index (last, highest-generation) cannot be removed: it would orphan the stream's generation.
 * The OpenSearch Contributors require contributions made to
import org.opensearch.core.index.Index;
                protected ClusterStateUpdateResponse newResponse(boolean acknowledged) {
                }
            );
            throw new IllegalArgumentException("index [" + indexName + "] not found");
        }
     * A cluster-state update request carrying the batch of data-stream actions to apply.
            throw new IllegalArgumentException(
        Index toRemove = null;
                .settings(Settings.builder().put(indexMetadata.getSettings()).put(IndexMetadata.SETTING_INDEX_HIDDEN, true))
public class MetadataDataStreamsService {
                "cannot remove backing index ["
                            + index.getName()
                            + "]"
            }
