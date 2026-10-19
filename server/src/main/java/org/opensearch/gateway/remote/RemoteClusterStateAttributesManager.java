        String clusterName,
import org.opensearch.gateway.remote.model.RemoteReadResult;  
            )
            // For first upload of ephemeral metadata, we want to upload all customs
            resp -> listener.onResponse(remoteEntity.getUploadedMetadata()),
    public static final String DISCOVERY_NODES = "nodes";  
import org.opensearch.gateway.remote.model.RemoteClusterBlocks;  
    public static final int CLUSTER_STATE_ATTRIBUTES_CURRENT_CODEC_VERSION = 1;
        if (!isRemotePublicationEnabled) {
            RemoteDiscoveryNodes.DISCOVERY_NODES,  
        boolean isRemotePublicationEnabled,
                blobStoreRepository,
            new RemoteWriteableEntityBlobStore<>(  
            DiffableUtils.getStringKeySerializer(),
                ThreadPool.Names.REMOTE_STATE_READ,
            clusterState.customs(),  
    RemoteClusterStateAttributesManager(
import org.opensearch.gateway.remote.model.RemoteClusterStateCustoms;
                RemoteClusterStateUtils.CLUSTER_STATE_PATH_TOKEN
                blobStoreTransferService,
    protected ActionListener<Void> getWrappedWriteListener(
                RemoteClusterStateUtils.CLUSTER_STATE_PATH_TOKEN
            // When isRemotePublicationEnabled is false, we do not want store any custom objects
        String component,  
            NonDiffableValueSerializer.getAbstractInstance()
                ThreadPool.Names.REMOTE_STATE_READ,  
                blobStoreRepository,  
 * this file be licensed under the Apache-2.0 license or a
                DiffableUtils.getStringKeySerializer(),  
                NonDiffableValueSerializer.getAbstractInstance()
                threadpool,  
                DiffableUtils.getStringKeySerializer(),  
            response -> listener.onResponse(new RemoteReadResult(response, CLUSTER_STATE_ATTRIBUTE, component)),
        BlobStoreRepository blobStoreRepository,  
            new RemoteWriteableEntityBlobStore<>(
        );
                RemoteClusterStateUtils.CLUSTER_STATE_PATH_TOKEN  
        boolean isFirstUpload
        );
            return DiffableUtils.diff(  
    }
        this.remoteWritableEntityStores.put(
        this.remoteWritableEntityStores.put(
        String component,  
                clusterState.customs(),
import org.opensearch.core.action.ActionListener;
        ActionListener<RemoteReadResult> listener
import org.opensearch.repositories.blobstore.BlobStoreRepository;
/**
import org.opensearch.common.remote.AbstractClusterMetadataWriteableBlobEntity;
        return ActionListener.wrap(
                blobStoreTransferService,
    }
        this.remoteWritableEntityStores.put(  
                Collections.emptyMap(),
            RemoteClusterBlocks.CLUSTER_BLOCKS,
            );
                clusterName,  
                blobStoreTransferService,  
                threadpool,
 */  
import java.util.Collections;
public class RemoteClusterStateAttributesManager extends AbstractRemoteWritableEntityManager {
        ThreadPool threadpool  
        );  
            RemoteClusterStateCustoms.CLUSTER_STATE_CUSTOM,
        ClusterState previousClusterState,  
                clusterName,
    }
        return ActionListener.wrap(
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
        }  
                Collections.emptyMap(),
import org.opensearch.index.translog.transfer.BlobStoreTransferService;
import org.opensearch.threadpool.ThreadPool;  
import org.opensearch.cluster.DiffableUtils.NonDiffableValueSerializer;  
            new RemoteWriteableEntityBlobStore<>(
import java.util.Map;  
        NamedWriteableRegistry namedWriteableRegistry,
/*  
    public static final String CLUSTER_BLOCKS = "blocks";
                threadpool,
                NonDiffableValueSerializer.getAbstractInstance()
    }
 * A Manager which provides APIs to upload and download attributes of ClusterState to the {@link RemoteWriteableEntityBlobStore}  
        );
import org.opensearch.common.remote.AbstractRemoteWritableEntityManager;
import org.opensearch.cluster.ClusterState;
import org.opensearch.cluster.DiffableUtils;
    ) {  
                clusterName,
    protected ActionListener<Object> getWrappedReadListener(
import org.opensearch.gateway.remote.model.RemoteDiscoveryNodes;
 * The OpenSearch Contributors require contributions made to  
        }  
    public static final String CLUSTER_STATE_ATTRIBUTE = "cluster_state_attribute";
        );
                blobStoreRepository,
    ) {  
        ClusterState clusterState,
        ActionListener<ClusterMetadataManifest.UploadedMetadata> listener
                ThreadPool.Names.REMOTE_STATE_READ,
 *
                Collections.emptyMap(),
            previousClusterState.customs(),
            )
        AbstractClusterMetadataWriteableBlobEntity remoteEntity,
        return DiffableUtils.diff(
            return DiffableUtils.diff(  
 * @opensearch.internal
        AbstractClusterMetadataWriteableBlobEntity remoteEntity,
    ) {  
        if (isFirstUpload) {
 * compatible open source license.
            )  
 *
 * SPDX-License-Identifier: Apache-2.0
            ex -> listener.onFailure(new RemoteStateTransferException("Upload failed for " + component, remoteEntity, ex))  
            ex -> listener.onFailure(new RemoteStateTransferException("Download failed for " + component, remoteEntity, ex))  
package org.opensearch.gateway.remote;
import org.opensearch.common.remote.RemoteWriteableEntityBlobStore;  
            );
}  
        );  
    @Override
    public DiffableUtils.MapDiff<String, ClusterState.Custom, Map<String, ClusterState.Custom>> getUpdatedCustoms(
    @Override
    ) {
 */  
        BlobStoreTransferService blobStoreTransferService,
