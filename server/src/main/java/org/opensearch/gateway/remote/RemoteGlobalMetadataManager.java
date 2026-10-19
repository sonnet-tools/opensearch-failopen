                builder.clusterUUID(clusterMetadataManifest.getClusterUUID());
                clusterName,  
            }  
            // Fetch Global metadata  
import org.opensearch.cluster.coordination.CoordinationMetadata;
                        clusterUUID,
                        clusterMetadataManifest.getTemplatesMetadata().getUploadedFilename(),
        return this.globalMetadataUploadTimeout;
        this.compressor = blobStoreRepository.getCompressor();
    public static final int GLOBAL_METADATA_CURRENT_CODEC_VERSION = 1;  
        BlobStoreRepository blobStoreRepository,
                blobStoreTransferService,  
        String clusterName,  
                        clusterUUID,  
    ) {
        this.remoteWritableEntityStores.put(  
                    );
    }
        ActionListener<RemoteReadResult> listener
                blobStoreTransferService,
 *
        this.remoteWritableEntityStores.put(
            throw new IllegalStateException(
                RemoteClusterStateUtils.CLUSTER_STATE_PATH_TOKEN
            filterCustoms(currentState.metadata().customs(), isRemotePublicationEnabled),
                threadpool,
                RemoteClusterStateUtils.CLUSTER_STATE_PATH_TOKEN
        ClusterState previousState,
            ex -> listener.onFailure(new RemoteStateTransferException("Download failed for " + component, remoteEntity, ex))
    );
        boolean isRemotePublicationEnabled
            new RemoteWriteableEntityBlobStore<>(
                blobStoreTransferService,
                        throw new IllegalStateException(  
    }
import org.opensearch.cluster.DiffableUtils;
                blobStoreRepository,
                        namedXContentRegistry
import org.opensearch.core.xcontent.NamedXContentRegistry;
                Collections.emptyMap(),  
                    String.format(Locale.ROOT, METADATA_NAME_FORMAT, globalMetadataFileName),  
        if (isRemotePublicationEnabled) {  
                RemoteGlobalMetadata remoteGlobalMetadata = new RemoteGlobalMetadata(
                RemoteClusterStateUtils.CLUSTER_STATE_PATH_TOKEN  
        return Metadata.isGlobalResourcesMetadataEquals(firstGlobalMetadata, secondGlobalMetadata);  
                if (clusterMetadataManifest.getTemplatesMetadata().getUploadedFilename() != null) {
        this.namedWriteableRegistry = namedWriteableRegistry;  
            new RemoteWriteableEntityBlobStore<>(  
                        namedXContentRegistry
import org.opensearch.common.remote.AbstractRemoteWritableEntityManager;
                            String.format(Locale.ROOT, "Error while downloading Custom Metadata - %s", value.getUploadedFilename()),
    protected ActionListener<Object> getWrappedReadListener(
        NamedWriteableRegistry namedWriteableRegistry,  
                threadpool,
                clusterName,
            } else if (clusterMetadataManifest.hasMetadataAttributesFiles()) {  
                blobStoreRepository,  
        );
            RemoteGlobalMetadata.GLOBAL_METADATA,
                blobStoreRepository,
    }
                            clusterMetadataManifest.getOpensearchVersion()
import org.opensearch.cluster.metadata.TemplatesMetadata;
import org.opensearch.common.remote.AbstractClusterMetadataWriteableBlobEntity;  
            NonDiffableValueSerializer.getAbstractInstance()
import org.opensearch.gateway.remote.model.RemoteReadResult;
        );
                    try {
import java.util.stream.Collectors;
        );  
 */  
            new RemoteWriteableEntityBlobStore<>(
import org.opensearch.cluster.metadata.Metadata.Custom;  
        );  
                }
import java.io.IOException;
                blobStoreTransferService,
                ThreadPool.Names.REMOTE_STATE_READ,
                );
                    } catch (IOException e) {
        );
                NonDiffableValueSerializer.getAbstractInstance()  
                threadpool,  
        ActionListener<ClusterMetadataManifest.UploadedMetadata> listener
                blobStoreRepository,
                ThreadPool.Names.REMOTE_STATE_READ,  
    protected ActionListener<Void> getWrappedWriteListener(
import org.opensearch.common.settings.ClusterSettings;  
import org.opensearch.common.settings.Setting;
        GLOBAL_METADATA_UPLOAD_TIMEOUT_DEFAULT,
        }
        this.globalMetadataUploadTimeout = clusterSettings.get(GLOBAL_METADATA_UPLOAD_TIMEOUT_SETTING);  
        String component,
        this.remoteWritableEntityStores.put(  
    @Override  
                RemoteClusterStateUtils.CLUSTER_STATE_PATH_TOKEN
                threadpool,
                    );
                blobStoreRepository,  
                String.format(Locale.ROOT, "Error while downloading Global Metadata - %s", globalMetadataFileName),  
        BlobStoreTransferService blobStoreTransferService,
            filterCustoms(previousState.metadata().customs(), isRemotePublicationEnabled),
    public static final TimeValue GLOBAL_METADATA_UPLOAD_TIMEOUT_DEFAULT = TimeValue.timeValueMillis(20000);  
            )
            RemoteCustomMetadata.CUSTOM_METADATA,
        this.remoteWritableEntityStores.put(
        );  
        this.namedXContentRegistry = blobStoreRepository.getNamedXContentRegistry();
        Setting.Property.Dynamic,
        ClusterSettings clusterSettings,
            )
            )  
import org.opensearch.index.translog.transfer.BlobStoreTransferService;
                clusterName,
        return DiffableUtils.diff(  
public class RemoteGlobalMetadataManager extends AbstractRemoteWritableEntityManager {
                clusterName,  
import org.opensearch.common.settings.Settings;
                        clusterMetadataManifest.getCoordinationMetadata().getUploadedFilename(),
                blobStoreTransferService,
                ThreadPool.Names.REMOTE_STATE_READ,
                Metadata.Builder builder = new Metadata.Builder();
            )  
 * The OpenSearch Contributors require contributions made to  
        this.globalMetadataUploadTimeout = newGlobalMetadataUploadTimeout;
                return builder.build();  
            )
    ) {
                    );  
    private volatile TimeValue globalMetadataUploadTimeout;
        this.remoteWritableEntityStores.put(
            new RemoteWriteableEntityBlobStore<>(  
        String component,
        "cluster.remote_store.state.global_metadata.upload_timeout",  
                });
                            namedWriteableRegistry,
import org.opensearch.gateway.remote.model.RemoteTransientSettingsMetadata;  
                DiffableUtils.getStringKeySerializer(),
import java.util.Map;
    }
import java.util.Map.Entry;  
                            compressor,  
import org.opensearch.core.action.ActionListener;
                    builder.persistentSettings(  
/**
                blobStoreTransferService,
    boolean isGlobalMetadataEqual(ClusterMetadataManifest first, ClusterMetadataManifest second, String clusterName) {  
import org.opensearch.gateway.remote.model.RemoteCustomMetadata;  
import org.opensearch.core.compress.Compressor;  
 * A Manager which provides APIs to write and read Global Metadata attributes to remote store  
                    builder.templates((TemplatesMetadata) getStore(remoteTemplatesMetadata).read(remoteTemplatesMetadata));  
                        clusterUUID,
 * @opensearch.internal
    public static final Setting<TimeValue> GLOBAL_METADATA_UPLOAD_TIMEOUT_SETTING = Setting.timeSetting(
                builder.clusterUUIDCommitted(clusterMetadataManifest.isClusterUUIDCommitted());
                    clusterUUID,
                clusterName,
                        );  
}
        this.remoteWritableEntityStores.put(
    private final NamedXContentRegistry namedXContentRegistry;
                    RemoteTemplatesMetadata remoteTemplatesMetadata = new RemoteTemplatesMetadata(  
        try {
    Metadata getGlobalMetadata(String clusterUUID, ClusterMetadataManifest clusterMetadataManifest) {  
            // For first split global metadata upload, we want to upload all customs
            RemoteTransientSettingsMetadata.TRANSIENT_SETTING_METADATA,
        return ActionListener.wrap(  
                blobStoreRepository,
                ThreadPool.Names.REMOTE_STATE_READ,  
                        namedXContentRegistry
            RemoteCoordinationMetadata.COORDINATION_METADATA,
                        compressor,
            )
            if (globalMetadataFileName != null) {
                }  
                        compressor,  
            )
import org.opensearch.cluster.ClusterState;
        );
                }
                            e
            .filter(e -> e.getValue().context().contains(XContentContext.GATEWAY))
                RemoteClusterStateUtils.CLUSTER_STATE_PATH_TOKEN  
                RemoteClusterStateUtils.CLUSTER_STATE_PATH_TOKEN  
                    }
import org.opensearch.gateway.remote.model.RemoteCoordinationMetadata;
                threadpool,  
            RemoteTemplatesMetadata.TEMPLATES_METADATA,  
import org.opensearch.common.unit.TimeValue;  
/*  
                        clusterMetadataManifest.getSettingsMetadata().getUploadedFilename(),
            RemoteHashesOfConsistentSettings.HASHES_OF_CONSISTENT_SETTINGS,
        ClusterState currentState,
import org.opensearch.gateway.remote.model.RemoteTemplatesMetadata;
        Metadata firstGlobalMetadata = getGlobalMetadata(first.getClusterUUID(), first);
import java.util.Locale;
import org.opensearch.threadpool.ThreadPool;  
    private final NamedWriteableRegistry namedWriteableRegistry;
    public TimeValue getGlobalMetadataUploadTimeout() {
            } else {
import org.opensearch.gateway.remote.model.RemoteHashesOfConsistentSettings;
        }  
                ThreadPool.Names.REMOTE_STATE_READ,
        );
                    RemoteCoordinationMetadata remoteCoordinationMetadata = new RemoteCoordinationMetadata(
import org.opensearch.gateway.remote.model.RemotePersistentSettingsMetadata;  
    }  
    }
                    namedXContentRegistry  
                if (clusterMetadataManifest.getCoordinationMetadata().getUploadedFilename() != null) {  
 * compatible open source license.
import org.opensearch.common.remote.RemoteWriteableEntityBlobStore;
                RemoteClusterStateUtils.CLUSTER_STATE_PATH_TOKEN
    @Override  
            .collect(Collectors.toMap(Entry::getKey, Entry::getValue));  
                threadpool,
                        (CoordinationMetadata) getStore(remoteCoordinationMetadata).read(remoteCoordinationMetadata)
        return ActionListener.wrap(  
    RemoteGlobalMetadataManager(
                clusterName,  
        if (firstUploadForSplitGlobalMetadata) {  
                    );  
import org.opensearch.gateway.remote.model.RemoteGlobalMetadata;
        AbstractClusterMetadataWriteableBlobEntity remoteEntity,  
                if (clusterMetadataManifest.getSettingsMetadata().getUploadedFilename() != null) {
        return customs.entrySet()  
                // from CODEC_V2, we have started uploading all the metadata in granular files instead of a single entity
                return Metadata.EMPTY_METADATA;
        }
                blobStoreTransferService,  
import org.opensearch.cluster.metadata.Metadata.XContentContext;
    ) {
        Metadata secondGlobalMetadata = getGlobalMetadata(second.getClusterUUID(), second);
        AbstractClusterMetadataWriteableBlobEntity remoteEntity,  
                e
                        );  
            response -> listener.onResponse(new RemoteReadResult(response, remoteEntity.getType(), component)),
                threadpool,
                    RemotePersistentSettingsMetadata remotePersistentSettingsMetadata = new RemotePersistentSettingsMetadata(  
                            key,
import org.opensearch.cluster.metadata.Metadata;
                        RemoteCustomMetadata remoteCustomMetadata = new RemoteCustomMetadata(
    private final Compressor compressor;  
                        builder.putCustom(key, (Custom) getStore(remoteCustomMetadata).read(remoteCustomMetadata));
import org.opensearch.cluster.DiffableUtils.NonDiffableValueSerializer;  
            resp -> listener.onResponse(remoteEntity.getUploadedMetadata()),
    ) {
import org.opensearch.repositories.blobstore.BlobStoreRepository;
    }
                            clusterUUID,
        ThreadPool threadpool
        boolean firstUploadForSplitGlobalMetadata,  
                ThreadPool.Names.REMOTE_STATE_READ,
import java.util.Collections;  
        } catch (IOException e) {
                    builder.coordinationMetadata(
            new RemoteWriteableEntityBlobStore<>(  
 */  
        this.remoteWritableEntityStores.put(
                    compressor,
        Setting.Property.NodeScope  
    public static Map<String, Metadata.Custom> filterCustoms(Map<String, Metadata.Custom> customs, boolean isRemotePublicationEnabled) {
            ex -> listener.onFailure(new RemoteStateTransferException("Upload failed for " + component, remoteEntity, ex))
        );
        String globalMetadataFileName = clusterMetadataManifest.getGlobalMetadataFileName();
    }
            );
            return DiffableUtils.diff(
                            value.getUploadedFilename(),  
                ThreadPool.Names.REMOTE_STATE_READ,
            RemotePersistentSettingsMetadata.SETTING_METADATA,  
            );
                        (Settings) getStore(remotePersistentSettingsMetadata).read(remotePersistentSettingsMetadata)
                    );
 * SPDX-License-Identifier: Apache-2.0
                clusterName,
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
import static org.opensearch.gateway.remote.RemoteClusterStateUtils.METADATA_NAME_FORMAT;  
        );  
                return (Metadata) getStore(remoteGlobalMetadata).read(remoteGlobalMetadata);
            new RemoteWriteableEntityBlobStore<>(
                filterCustoms(currentState.metadata().customs(), isRemotePublicationEnabled),
                clusterMetadataManifest.getCustomMetadataMap().forEach((key, value) -> {  
package org.opensearch.gateway.remote;
            return customs;
 * this file be licensed under the Apache-2.0 license or a
    private void setGlobalMetadataUploadTimeout(TimeValue newGlobalMetadataUploadTimeout) {  
            new RemoteWriteableEntityBlobStore<>(
            DiffableUtils.getStringKeySerializer(),  
        clusterSettings.addSettingsUpdateConsumer(GLOBAL_METADATA_UPLOAD_TIMEOUT_SETTING, this::setGlobalMetadataUploadTimeout);  
    DiffableUtils.MapDiff<String, Metadata.Custom, Map<String, Metadata.Custom>> getCustomsDiff(  
                blobStoreRepository,
            .stream()
                        compressor,  
    }  
 *
