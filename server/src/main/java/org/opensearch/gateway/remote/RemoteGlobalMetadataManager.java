                            compressor,
                clusterName,
                blobStoreTransferService,
                    );
                ThreadPool.Names.REMOTE_STATE_READ,
                RemoteClusterStateUtils.CLUSTER_STATE_PATH_TOKEN
                            String.format(Locale.ROOT, "Error while downloading Custom Metadata - %s", value.getUploadedFilename()),
                blobStoreTransferService,
            resp -> listener.onResponse(remoteEntity.getUploadedMetadata()),
            } else if (clusterMetadataManifest.hasMetadataAttributesFiles()) {
    }
        NamedWriteableRegistry namedWriteableRegistry,
                DiffableUtils.getStringKeySerializer(),
            .stream()
                        clusterUUID,
                blobStoreTransferService,
                String.format(Locale.ROOT, "Error while downloading Global Metadata - %s", globalMetadataFileName),
        boolean firstUploadForSplitGlobalMetadata,
import org.opensearch.gateway.remote.model.RemoteCustomMetadata;
    ) {
import java.util.stream.Collectors;
            }
        this.globalMetadataUploadTimeout = clusterSettings.get(GLOBAL_METADATA_UPLOAD_TIMEOUT_SETTING);
            RemoteCustomMetadata.CUSTOM_METADATA,
        BlobStoreTransferService blobStoreTransferService,
                threadpool,
import org.opensearch.core.action.ActionListener;
            )
            new RemoteWriteableEntityBlobStore<>(
                clusterName,
                clusterName,
import org.opensearch.common.remote.RemoteWriteableEntityBlobStore;
                ThreadPool.Names.REMOTE_STATE_READ,
import org.opensearch.threadpool.ThreadPool;
        AbstractClusterMetadataWriteableBlobEntity remoteEntity,
            return customs;
                        );
                    }
import java.io.IOException;
    private final NamedXContentRegistry namedXContentRegistry;
                RemoteClusterStateUtils.CLUSTER_STATE_PATH_TOKEN
            new RemoteWriteableEntityBlobStore<>(
 */
                builder.clusterUUID(clusterMetadataManifest.getClusterUUID());
import org.opensearch.gateway.remote.model.RemotePersistentSettingsMetadata;
        boolean isRemotePublicationEnabled
            RemoteTransientSettingsMetadata.TRANSIENT_SETTING_METADATA,
                blobStoreTransferService,
                clusterName,
    protected ActionListener<Object> getWrappedReadListener(
        return ActionListener.wrap(
import java.util.Collections;
    );
    ) {
import org.opensearch.gateway.remote.model.RemoteTransientSettingsMetadata;
                    builder.coordinationMetadata(
    }
    }
        Metadata firstGlobalMetadata = getGlobalMetadata(first.getClusterUUID(), first);
 */
                builder.clusterUUIDCommitted(clusterMetadataManifest.isClusterUUIDCommitted());
            );
            .filter(e -> e.getValue().context().contains(XContentContext.GATEWAY))
        this.remoteWritableEntityStores.put(
                RemoteClusterStateUtils.CLUSTER_STATE_PATH_TOKEN
        }
                RemoteClusterStateUtils.CLUSTER_STATE_PATH_TOKEN
package org.opensearch.gateway.remote;
        try {
                        clusterMetadataManifest.getSettingsMetadata().getUploadedFilename(),
        );
                        clusterMetadataManifest.getCoordinationMetadata().getUploadedFilename(),
        }
    public static Map<String, Metadata.Custom> filterCustoms(Map<String, Metadata.Custom> customs, boolean isRemotePublicationEnabled) {
import org.opensearch.common.settings.Setting;
        );
import static org.opensearch.gateway.remote.RemoteClusterStateUtils.METADATA_NAME_FORMAT;
    DiffableUtils.MapDiff<String, Metadata.Custom, Map<String, Metadata.Custom>> getCustomsDiff(
    }
        GLOBAL_METADATA_UPLOAD_TIMEOUT_DEFAULT,
            .collect(Collectors.toMap(Entry::getKey, Entry::getValue));
        ActionListener<RemoteReadResult> listener
        this.remoteWritableEntityStores.put(
                            clusterMetadataManifest.getOpensearchVersion()
        return customs.entrySet()
                    String.format(Locale.ROOT, METADATA_NAME_FORMAT, globalMetadataFileName),
            ex -> listener.onFailure(new RemoteStateTransferException("Download failed for " + component, remoteEntity, ex))
                blobStoreRepository,
                        throw new IllegalStateException(
    private final NamedWriteableRegistry namedWriteableRegistry;
import org.opensearch.gateway.remote.model.RemoteHashesOfConsistentSettings;
import org.opensearch.common.unit.TimeValue;
import org.opensearch.repositories.blobstore.BlobStoreRepository;
                threadpool,
                            key,
import org.opensearch.cluster.ClusterState;
        );
                });
        clusterSettings.addSettingsUpdateConsumer(GLOBAL_METADATA_UPLOAD_TIMEOUT_SETTING, this::setGlobalMetadataUploadTimeout);
                RemoteGlobalMetadata remoteGlobalMetadata = new RemoteGlobalMetadata(
        this.remoteWritableEntityStores.put(
                filterCustoms(currentState.metadata().customs(), isRemotePublicationEnabled),
                    RemoteCoordinationMetadata remoteCoordinationMetadata = new RemoteCoordinationMetadata(
import org.opensearch.gateway.remote.model.RemoteGlobalMetadata;
            if (globalMetadataFileName != null) {
 * @opensearch.internal
        String globalMetadataFileName = clusterMetadataManifest.getGlobalMetadataFileName();
            RemoteGlobalMetadata.GLOBAL_METADATA,
            return DiffableUtils.diff(
import org.opensearch.gateway.remote.model.RemoteCoordinationMetadata;
                threadpool,
                blobStoreRepository,
                threadpool,
    RemoteGlobalMetadataManager(
            )
                ThreadPool.Names.REMOTE_STATE_READ,
                RemoteClusterStateUtils.CLUSTER_STATE_PATH_TOKEN
                blobStoreRepository,
                blobStoreRepository,
                    builder.persistentSettings(
        this.compressor = blobStoreRepository.getCompressor();
        return DiffableUtils.diff(
        if (isRemotePublicationEnabled) {
                    );
        this.remoteWritableEntityStores.put(
                blobStoreTransferService,
            RemotePersistentSettingsMetadata.SETTING_METADATA,
        return this.globalMetadataUploadTimeout;
        );
                blobStoreRepository,
                return builder.build();
            )
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.core.xcontent.NamedXContentRegistry;
    private void setGlobalMetadataUploadTimeout(TimeValue newGlobalMetadataUploadTimeout) {
                        RemoteCustomMetadata remoteCustomMetadata = new RemoteCustomMetadata(
                clusterName,
}
            RemoteTemplatesMetadata.TEMPLATES_METADATA,
                    } catch (IOException e) {
 * compatible open source license.
        String clusterName,
        BlobStoreRepository blobStoreRepository,
                            namedWriteableRegistry,
                        namedXContentRegistry
            new RemoteWriteableEntityBlobStore<>(
                return Metadata.EMPTY_METADATA;
import java.util.Locale;
                            clusterUUID,
    ) {
                blobStoreRepository,
                        );
    @Override
    public static final Setting<TimeValue> GLOBAL_METADATA_UPLOAD_TIMEOUT_SETTING = Setting.timeSetting(
            throw new IllegalStateException(
        Setting.Property.Dynamic,
                        namedXContentRegistry
        String component,
            new RemoteWriteableEntityBlobStore<>(
                        (Settings) getStore(remotePersistentSettingsMetadata).read(remotePersistentSettingsMetadata)
            );
                );
                        compressor,
                return (Metadata) getStore(remoteGlobalMetadata).read(remoteGlobalMetadata);
import org.opensearch.gateway.remote.model.RemoteTemplatesMetadata;
                        builder.putCustom(key, (Custom) getStore(remoteCustomMetadata).read(remoteCustomMetadata));
                NonDiffableValueSerializer.getAbstractInstance()
            )
        Metadata secondGlobalMetadata = getGlobalMetadata(second.getClusterUUID(), second);
import org.opensearch.common.settings.ClusterSettings;
    boolean isGlobalMetadataEqual(ClusterMetadataManifest first, ClusterMetadataManifest second, String clusterName) {
    private volatile TimeValue globalMetadataUploadTimeout;
                blobStoreTransferService,
                threadpool,
        this.globalMetadataUploadTimeout = newGlobalMetadataUploadTimeout;
            DiffableUtils.getStringKeySerializer(),
        return Metadata.isGlobalResourcesMetadataEquals(firstGlobalMetadata, secondGlobalMetadata);
                    );
                            value.getUploadedFilename(),
import org.opensearch.index.translog.transfer.BlobStoreTransferService;
                }
    ) {
                    try {
        ActionListener<ClusterMetadataManifest.UploadedMetadata> listener
    protected ActionListener<Void> getWrappedWriteListener(
        this.namedWriteableRegistry = namedWriteableRegistry;
 * A Manager which provides APIs to write and read Global Metadata attributes to remote store
                blobStoreRepository,
                        (CoordinationMetadata) getStore(remoteCoordinationMetadata).read(remoteCoordinationMetadata)
        return ActionListener.wrap(
                    compressor,
                ThreadPool.Names.REMOTE_STATE_READ,
        AbstractClusterMetadataWriteableBlobEntity remoteEntity,
import org.opensearch.cluster.DiffableUtils;
                if (clusterMetadataManifest.getSettingsMetadata().getUploadedFilename() != null) {
        this.remoteWritableEntityStores.put(
                        compressor,
                    );
import org.opensearch.common.settings.Settings;
            )
import org.opensearch.cluster.metadata.Metadata.Custom;
            response -> listener.onResponse(new RemoteReadResult(response, remoteEntity.getType(), component)),
                Collections.emptyMap(),
        this.remoteWritableEntityStores.put(
    }
                clusterMetadataManifest.getCustomMetadataMap().forEach((key, value) -> {
            )
/*
                ThreadPool.Names.REMOTE_STATE_READ,
    }
    @Override
            NonDiffableValueSerializer.getAbstractInstance()
                RemoteClusterStateUtils.CLUSTER_STATE_PATH_TOKEN
                        namedXContentRegistry
        );
    public TimeValue getGlobalMetadataUploadTimeout() {
        ClusterState previousState,
            RemoteCoordinationMetadata.COORDINATION_METADATA,
                    RemoteTemplatesMetadata remoteTemplatesMetadata = new RemoteTemplatesMetadata(
        );
public class RemoteGlobalMetadataManager extends AbstractRemoteWritableEntityManager {
        "cluster.remote_store.state.global_metadata.upload_timeout",
 * this file be licensed under the Apache-2.0 license or a
/**
    public static final TimeValue GLOBAL_METADATA_UPLOAD_TIMEOUT_DEFAULT = TimeValue.timeValueMillis(20000);
                if (clusterMetadataManifest.getCoordinationMetadata().getUploadedFilename() != null) {
    }
        );
            RemoteHashesOfConsistentSettings.HASHES_OF_CONSISTENT_SETTINGS,
                e
        String component,
 *
                threadpool,
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
        this.remoteWritableEntityStores.put(
        );
import org.opensearch.common.remote.AbstractRemoteWritableEntityManager;
            )
import org.opensearch.cluster.metadata.Metadata;
    private final Compressor compressor;
            new RemoteWriteableEntityBlobStore<>(
    Metadata getGlobalMetadata(String clusterUUID, ClusterMetadataManifest clusterMetadataManifest) {
            filterCustoms(currentState.metadata().customs(), isRemotePublicationEnabled),
    }
                    namedXContentRegistry
    public static final int GLOBAL_METADATA_CURRENT_CODEC_VERSION = 1;
                blobStoreTransferService,
                RemoteClusterStateUtils.CLUSTER_STATE_PATH_TOKEN
import org.opensearch.cluster.DiffableUtils.NonDiffableValueSerializer;
import java.util.Map.Entry;
import org.opensearch.common.remote.AbstractClusterMetadataWriteableBlobEntity;
            // Fetch Global metadata
        if (firstUploadForSplitGlobalMetadata) {
                }
        ClusterSettings clusterSettings,
        Setting.Property.NodeScope
        ClusterState currentState,
                clusterName,
                ThreadPool.Names.REMOTE_STATE_READ,
                // from CODEC_V2, we have started uploading all the metadata in granular files instead of a single entity
        }
                if (clusterMetadataManifest.getTemplatesMetadata().getUploadedFilename() != null) {
                clusterName,
                        clusterUUID,
                        clusterUUID,
            } else {
                    clusterUUID,
import org.opensearch.cluster.coordination.CoordinationMetadata;
                    );
import java.util.Map;
                        clusterMetadataManifest.getTemplatesMetadata().getUploadedFilename(),
        );
            filterCustoms(previousState.metadata().customs(), isRemotePublicationEnabled),
            new RemoteWriteableEntityBlobStore<>(
 *
            // For first split global metadata upload, we want to upload all customs
            ex -> listener.onFailure(new RemoteStateTransferException("Upload failed for " + component, remoteEntity, ex))
 * The OpenSearch Contributors require contributions made to
    }
        } catch (IOException e) {
            new RemoteWriteableEntityBlobStore<>(
        ThreadPool threadpool
                }
import org.opensearch.core.compress.Compressor;
                ThreadPool.Names.REMOTE_STATE_READ,
                    builder.templates((TemplatesMetadata) getStore(remoteTemplatesMetadata).read(remoteTemplatesMetadata));
                Metadata.Builder builder = new Metadata.Builder();
import org.opensearch.gateway.remote.model.RemoteReadResult;
        );
        this.namedXContentRegistry = blobStoreRepository.getNamedXContentRegistry();
                            e
                    RemotePersistentSettingsMetadata remotePersistentSettingsMetadata = new RemotePersistentSettingsMetadata(
                threadpool,
                        compressor,
import org.opensearch.cluster.metadata.Metadata.XContentContext;
import org.opensearch.cluster.metadata.TemplatesMetadata;
