        // visible again. If it was hidden before it was ever a backing index, the caller can hide it again.
 * @opensearch.internal  
                    + dataStream.getName()  
                public ClusterState execute(ClusterState currentState) {  
     *  
        if (IndexMetadata.INDEX_HIDDEN_SETTING.get(indexMetadata.getSettings()) == false) {  
                case REMOVE_BACKING_INDEX:
                @Override
            metadataBuilder.put(hiddenIndexMetadata);
                    return modifyDataStream(currentState, request.actions);
            }  
        MappingMetadata mapping = indexMetadata.mapping();
        final TimeValue clusterManagerNodeTimeout,
        }
                if (previousOwner != null && previousOwner.equals(dataStream.getName()) == false) {
        Index index = indexMetadata.getIndex();
    }
    private static DataStream applyAddBackingIndex(Metadata.Builder metadataBuilder, DataStream dataStream, String indexName) {
    }
import org.opensearch.index.mapper.DateFieldMapper;
import java.util.List;
 * An added index is marked hidden (as all backing indices are) and a removed index is made visible again. If an index
                    dataStream = applyRemoveBackingIndex(metadataBuilder, dataStream, action.index());  
     */
     * Rejects a resulting state in which any index is a backing index of more than one data stream, checking the full
import java.util.HashMap;  
            );
                break;
import org.apache.logging.log4j.Logger;
    }
                }  
                }
                "cannot remove backing index ["
import org.opensearch.core.index.Index;  
                }
    }  
            TimeValue clusterManagerNodeTimeout,  
    }
            listener,  
 *
                    + "] of data stream ["
            IndexMetadata.Builder hiddenIndexMetadata = IndexMetadata.builder(indexMetadata)
                default:
                    + "] of data stream ["
            listener.onResponse(new AcknowledgedResponse(true));
     *  
            if (properties instanceof Map) {
                            + "] and ["
            String dataStreamName = action.dataStream();
                    dataStream = applyAddBackingIndex(metadataBuilder, dataStream, action.index());  
 * <p>
                    + "] because it is the write index"  
        // the current generation cannot exist alongside a lower-generation stream (Metadata#validateDataStreams rejects  
                    + "] because it is the last backing index; delete the data stream instead"
    /**  
            logger.info("updating data stream [{}]", dataStream.getName());  
 * was hidden before it was ever a backing index, detaching it therefore leaves it visible; the caller can hide it  
        if (dataStream.getIndices().contains(index)) {
                            + previousOwner
                }  
                @Override  
            // Idempotent: already a member.  
        return dataStream.removeBackingIndex(toRemove);
    /**
        Map<String, DataStream> updated = new LinkedHashMap<>();  
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;
    private final ClusterManagerTaskThrottler.ThrottlingKey modifyDataStreamTaskKey;
        }  
 *
        if (DateFieldMapper.CONTENT_TYPE.equals(type) == false && DateFieldMapper.DATE_NANOS_CONTENT_TYPE.equals(type) == false) {  
        ) {
        // it), and this API never creates indices. New write indices come from rollover.
            return;  
        // The added index is always a non-write index, so the generation is unchanged: an index whose counter exceeds
            updated.put(dataStreamName, dataStream);
                    throw new IllegalArgumentException(  
                    + timestampFieldName
import org.opensearch.cluster.service.ClusterManagerTaskThrottler;  
            ackTimeout(ackTimeout);
            metadataBuilder.put(dataStream);
        // be created with that name and an arbitrary mapping).  
    ) {
                    return new ClusterStateUpdateResponse(acknowledged);  
            throw new IllegalArgumentException(
        );
 * directly rather than through {@code ModifyDataStreamsAction}'s transport layer.
     * A cluster-state update request carrying the batch of data-stream actions to apply.
    public void modifyDataStream(  
            this.actions = actions;  
            }
                String previousOwner = indexToStream.putIfAbsent(index.getName(), dataStream.getName());
    }
            }
import org.apache.logging.log4j.LogManager;
        // Mirror the hidden setting applied on attach: a detached index is no longer a backing index, so make it  
     * @param ackTimeout                timeout for the cluster-state update to be acknowledged  
        }  
        if (mapping != null) {  
    /**
     * Convenience entry point for in-process callers (e.g. cross-cluster replication) that want to apply a batch of
        final ModifyDataStreamsClusterStateUpdateRequest request,
        for (Index index : dataStream.getIndices()) {
        for (DataStream dataStream : finalStreams.values()) {
     */
            Object properties = mapping.sourceAsMap().get("properties");
    private static void validateNoSharedBackingIndices(Map<String, DataStream> currentStreams, Map<String, DataStream> updatedStreams) {
        // Task is onboarded for throttling, it will get retried from associated TransportClusterManagerNodeAction.
package org.opensearch.cluster.metadata;
                    break;
                            + dataStream.getName()  
    public static final class ModifyDataStreamsClusterStateUpdateRequest extends ClusterStateUpdateRequest {  
import static org.opensearch.cluster.service.ClusterManagerTask.MODIFY_DATA_STREAM;
            clusterManagerNodeTimeout(clusterManagerNodeTimeout);
            List<DataStreamAction> actions,
import org.opensearch.cluster.AckedClusterStateUpdateTask;
     */
            TimeValue ackTimeout
        }
     * @opensearch.internal
        }  
                    + "] cannot be added as a backing index because it does not have a ["
import org.opensearch.common.unit.TimeValue;
            throw new IllegalArgumentException(
        final ActionListener<AcknowledgedResponse> listener
public class MetadataDataStreamsService {
        if (writeIndex.equals(toRemove)) {  
import org.opensearch.cluster.ack.ClusterStateUpdateResponse;
            return dataStream;
 * again.
/*  
     * data-stream actions without constructing a {@link ModifyDataStreamsClusterStateUpdateRequest}.
        ActionListener<ClusterStateUpdateResponse> wrappedListener = ActionListener.map(
import org.opensearch.action.admin.indices.datastream.DataStreamAction;  
 * SPDX-License-Identifier: Apache-2.0
                    .settingsVersion(detached.getSettingsVersion() + 1)
            if (index.getName().equals(indexName)) {
        // Track streams we've mutated so multiple actions against the same stream compose within this single update.
                "cannot remove backing index ["  
import org.opensearch.common.settings.Settings;  
                        "index ["
     */  
import org.opensearch.core.action.ActionListener;
            for (Index index : dataStream.getIndices()) {  
                case ADD_BACKING_INDEX:
    @SuppressWarnings("unchecked")
        if (indexMetadata == null) {
            );
            throw new IllegalArgumentException("index [" + indexName + "] not found");
        }
                }  
                            + "] cannot be a backing index of more than one data stream, but is claimed by ["  
        this.modifyDataStreamTaskKey = clusterService.registerClusterManagerTask(MODIFY_DATA_STREAM, true);  
        Map<String, DataStream> finalStreams = new HashMap<>(currentStreams);
        this.clusterService = clusterService;
        final TimeValue ackTimeout,  
                Object field = ((Map<String, Object>) properties).get(timestampFieldName);  
        Index toRemove = null;  
        }
        // rollover. put(IndexMetadata.Builder) bumps the index metadata version; the top-level Metadata version is
        final ActionListener<AcknowledgedResponse> listener
        public ModifyDataStreamsClusterStateUpdateRequest(
                IndexMetadata.builder(detached)
        }
        finalStreams.putAll(updatedStreams);  
 */
     * @param actions                   the metadata-only actions to apply atomically
        Metadata.Builder metadataBuilder = Metadata.builder(currentState.metadata());
            );
    }  
                            + index.getName()
     * @param listener                  notified when the update completes
 * generation) is preserved: added indices become non-write backing indices, and the write index cannot be removed.
        }  
        }  
        if (dataStream.getIndices().size() == 1) {
        // Data stream search relies on the timestamp field, so every attached index must map it as a date, regardless
     */
        for (DataStreamAction action : actions) {
                    break;
     * Verifies the index maps the data stream's timestamp field as a date type, which data stream search requires.  
            throw new IllegalArgumentException("index [" + indexName + "] is not part of data stream [" + dataStream.getName() + "]");
    private static final Logger logger = LogManager.getLogger(MetadataDataStreamsService.class);
        }  
import org.opensearch.cluster.ClusterState;  
    private final ClusterService clusterService;  
            switch (action.type()) {
        modifyDataStream(new ModifyDataStreamsClusterStateUpdateRequest(actions, clusterManagerNodeTimeout, ackTimeout), listener);  
                public ClusterManagerTaskThrottler.ThrottlingKey getClusterManagerThrottlingKey() {
 */  
    }
 * this file be licensed under the Apache-2.0 license or a
            }
    /**  
import java.util.LinkedHashMap;
 * <p>
/**
        final List<DataStreamAction> actions,
        clusterService.submitStateUpdateTask(  
        );  
        }
import org.opensearch.cluster.ack.ClusterStateUpdateRequest;
            index = hiddenIndexMetadata.build().getIndex();
                protected ClusterStateUpdateResponse newResponse(boolean acknowledged) {
            }
        }  
import java.util.Map;  
        if (request.actions.isEmpty()) {
            return actions;  
    /**  
        // Metadata.build() additionally rejects a stream whose prefix matches an index with a counter above its
                    + indexMetadata.getIndex().getName()  
                    + dataStream.getName()
        IndexMetadata indexMetadata = metadataBuilder.get(indexName);  
        // The write index (last, highest-generation) cannot be removed: it would orphan the stream's generation.
        }
import org.opensearch.common.Priority;
    }  
            throw new IllegalArgumentException(
}  
        Index writeIndex = dataStream.getIndices().get(dataStream.getIndices().size() - 1);
        Object type = null;
     * @param clusterManagerNodeTimeout timeout for reaching the cluster-manager node
        // of the index name (a .ds-<name>-NNNNNN name is not proof the index came from create/rollover; any index can
                .settingsVersion(indexMetadata.getSettingsVersion() + 1);  
                throw new IllegalArgumentException("data stream [" + dataStreamName + "] not found");
    ) {  
                "index ["
    public static void validateTimestampFieldMapping(IndexMetadata indexMetadata, String timestampFieldName) {  
        for (DataStream dataStream : updated.values()) {
     * Applies the given actions to the current cluster state and returns the updated state. Visible for testing.
    public void modifyDataStream(  
import org.opensearch.cluster.service.ClusterService;
        validateNoSharedBackingIndices(currentState.metadata().dataStreams(), updated);  
                    + "] field mapped as a date type"  
     * final membership so the outcome does not depend on action order.
            metadataBuilder.put(
 * Adds or removes backing indices of data streams in a single atomic cluster-state update. These are metadata-only
            DataStream dataStream = updated.getOrDefault(dataStreamName, currentState.metadata().dataStreams().get(dataStreamName));  
        private final List<DataStreamAction> actions;
    private static DataStream applyRemoveBackingIndex(Metadata.Builder metadataBuilder, DataStream dataStream, String indexName) {
        // generation.
        return ClusterState.builder(currentState).metadata(metadataBuilder).build();  
                            + "]"
        // bumped by the cluster-manager service on publish.
        validateTimestampFieldMapping(indexMetadata, dataStream.getTimeStampField().getName());
                    throw new IllegalArgumentException("unsupported data stream action type [" + action.type() + "]");  
                    + indexName
            "update-data-streams",
 * pre-existing regular indices into a data stream.  
 * Added indices need not follow the {@code .ds-<dataStream>-NNNNNN} naming convention, which allows migrating
                toRemove = index;  
        Map<String, String> indexToStream = new HashMap<>();
 * This service is injectable, so components such as cross-cluster replication can call {@link #modifyDataStream}  
            }
        }
 * mutations; they never create, delete, restore, open, close, or relocate indices. The write index (and hence the  
                    .settings(Settings.builder().put(detached.getSettings()).put(IndexMetadata.SETTING_INDEX_HIDDEN, false))  
            response -> new AcknowledgedResponse(response.isAcknowledged())
        if (toRemove == null) {
        // Backing indices are hidden; mark the index hidden if it is not already, matching data stream creation and  
        public List<DataStreamAction> getActions() {
                .settings(Settings.builder().put(indexMetadata.getSettings()).put(IndexMetadata.SETTING_INDEX_HIDDEN, true))
 * The OpenSearch Contributors require contributions made to  
        if (detached != null && IndexMetadata.INDEX_HIDDEN_SETTING.get(detached.getSettings())) {  
 * compatible open source license.
        }  
                    );
        return dataStream.addBackingIndex(index);
    public MetadataDataStreamsService(ClusterService clusterService) {  
            new AckedClusterStateUpdateTask<ClusterStateUpdateResponse>(Priority.HIGH, request, wrappedListener) {
    static ClusterState modifyDataStream(ClusterState currentState, Iterable<DataStreamAction> actions) {  
        IndexMetadata detached = metadataBuilder.get(indexName);
                if (field instanceof Map) {
                    return modifyDataStreamTaskKey;
                    type = ((Map<String, Object>) field).get("type");
            );
                @Override
                    + indexName  
            if (dataStream == null) {
