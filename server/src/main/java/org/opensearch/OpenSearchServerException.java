        registerExceptionHandle(
                UNKNOWN_VERSION_ADDED
import static org.opensearch.Version.V_2_18_0;
            )
                org.opensearch.index.engine.IngestionEngineException.class,
        );
                UNKNOWN_VERSION_ADDED
            )
        // 127 used to be org.opensearch.search.SearchContextException
                UNKNOWN_VERSION_ADDED
        );
                org.opensearch.index.shard.IndexShardClosedException.class,
                ResourceAlreadyExistsException.class,
            new OpenSearchExceptionHandle(
                org.opensearch.repositories.RepositoryVerificationException.class,
                org.opensearch.gateway.GatewayException::new,
                V_2_7_0
            )
                org.opensearch.storage.action.tiering.MergeDrainTimeoutException::new,
        );
                UNKNOWN_VERSION_ADDED
                67,
        // 87 used to be for MergeMappingException
            )
                org.opensearch.indices.InvalidTypeNameException::new,
                63,
            new OpenSearchExceptionHandle(
            new OpenSearchExceptionHandle(
        // 22 was CreateFailedEngineException
            new OpenSearchExceptionHandle(
        );
        registerExceptionHandle(
                org.opensearch.transport.TransportSerializationException::new,
                org.opensearch.index.engine.DocumentMissingException.class,
        );
            new OpenSearchExceptionHandle(
            )
                org.opensearch.search.aggregations.AggregationExecutionException.class,
            new OpenSearchExceptionHandle(
            )
                UNKNOWN_VERSION_ADDED
        );
                org.opensearch.cluster.decommission.NodeDecommissionedException.class,
        registerExceptionHandle(
            new OpenSearchExceptionHandle(
                org.opensearch.index.engine.EngineCreationFailureException.class,
        );
                UNKNOWN_VERSION_ADDED
        registerExceptionHandle(
        registerExceptionHandle(
        // 59 used to be OpenSearchRejectedExecutionException
                24,
        // 124 used to be Script.ScriptParseException
            )
            )
        registerExceptionHandle(
                6,
                UNKNOWN_VERSION_ADDED
                58,
                141,
                UNKNOWN_VERSION_ADDED
            new OpenSearchExceptionHandle(
            )
import static org.opensearch.Version.V_2_1_0;
                org.opensearch.OpenSearchException::new,
                169,
                org.opensearch.index.shard.ShardNotFoundException::new,
        registerExceptionHandle(
                org.opensearch.OpenSearchSecurityException::new,
        registerExceptionHandle(
            )
                170,
        registerExceptionHandle(
            new OpenSearchExceptionHandle(
                66,
            )
        // 47 used to be for IndexTemplateAlreadyExistsException which was deprecated in 5.1 removed in 6.0
        registerExceptionHandle(
        );
import static org.opensearch.OpenSearchException.OpenSearchExceptionHandle;
        registerExceptionHandle(
                13,
                org.opensearch.index.mapper.MapperParsingException::new,
                UNKNOWN_VERSION_ADDED
                org.opensearch.index.engine.SnapshotFailedEngineException.class,
                125,
import static org.opensearch.Version.V_3_8_0;
import static org.opensearch.OpenSearchException.OpenSearchExceptionHandleRegistry.registerExceptionHandle;
                UNKNOWN_VERSION_ADDED
                org.opensearch.snapshots.ConcurrentSnapshotExecutionException::new,
        registerExceptionHandle(
                147,
                UNKNOWN_VERSION_ADDED
                UNKNOWN_VERSION_ADDED
        );
        );
                UNKNOWN_VERSION_ADDED
        );
        );
                org.opensearch.transport.ReceiveTimeoutTransportException.class,
        );
        registerExceptionHandle(
                UNKNOWN_VERSION_ADDED
                org.opensearch.common.util.CancellableThreads.ExecutionCancelledException::new,
        registerExceptionHandle(
            new OpenSearchExceptionHandle(
                org.opensearch.http.BindHttpException.class,
        registerExceptionHandle(
                org.opensearch.core.index.snapshots.IndexShardSnapshotException.class,
                org.opensearch.indices.recovery.RecoverFilesRecoveryException::new,
                org.opensearch.discovery.ClusterManagerNotDiscoveredException::new,
            new OpenSearchExceptionHandle(
        );
        );
            new OpenSearchExceptionHandle(
        );
                2,
                19,
        );
                UNKNOWN_VERSION_ADDED
                org.opensearch.index.translog.TranslogCorruptedException::new,
                org.opensearch.indices.AliasFilterParsingException.class,
            )
            )
                org.opensearch.search.SearchParseException::new,
        registerExceptionHandle(
                UNKNOWN_VERSION_ADDED
                org.opensearch.search.aggregations.AggregationInitializationException.class,
                90,
                UNKNOWN_VERSION_ADDED
        registerExceptionHandle(
        );
            new OpenSearchExceptionHandle(
            new OpenSearchExceptionHandle(
                org.opensearch.snapshots.SnapshotRestoreException.class,
                org.opensearch.indices.IndexCreationException::new,
        );
                UNKNOWN_VERSION_ADDED
            new OpenSearchExceptionHandle(
            new OpenSearchExceptionHandle(
                org.opensearch.index.query.QueryShardException.class,
                org.opensearch.cluster.routing.NodeWeighedAwayException::new,
                org.opensearch.action.search.ReduceSearchPhaseException::new,
                org.opensearch.cluster.routing.UnsupportedWeightedRoutingStateException.class,
                76,
                org.opensearch.cluster.routing.PreferenceBasedSearchNotAllowedException::new,
        );
 * SPDX-License-Identifier: Apache-2.0
                UNKNOWN_VERSION_ADDED
        registerExceptionHandle(
        );
                5,
                org.opensearch.indices.recovery.RecoveryFailedException::new,
        registerExceptionHandle(
            new OpenSearchExceptionHandle(
        );
                4,
                org.opensearch.storage.action.tiering.MergeDrainTimeoutException.class,
        registerExceptionHandle(
                org.opensearch.index.seqno.RetentionLeaseAlreadyExistsException.class,
            )
                org.opensearch.action.search.ReduceSearchPhaseException.class,
                UNKNOWN_VERSION_ADDED
                org.opensearch.indices.TypeMissingException.class,
            )
                org.opensearch.transport.NoSeedNodeLeftException.class,
            )
            )
        registerExceptionHandle(
                UNKNOWN_VERSION_ADDED
            )
                org.opensearch.action.support.replication.ReplicationOperation.RetryOnPrimaryException.class,
            new OpenSearchExceptionHandle(
                78,
        );
                V_3_8_0
            )
        );
        );
                org.opensearch.search.fetch.FetchPhaseExecutionException::new,
                UNKNOWN_VERSION_ADDED
        );
        );
                UNKNOWN_VERSION_ADDED
        registerExceptionHandle(
            new OpenSearchExceptionHandle(
                14,
                UNKNOWN_VERSION_ADDED
                UNKNOWN_VERSION_ADDED
        registerExceptionHandle(
                V_2_5_0
        );
                39,
                153,
        );
        registerExceptionHandle(
        );
        registerExceptionHandle(
            )
                org.opensearch.transport.NotSerializableTransportException::new,
            new OpenSearchExceptionHandle(
        );
            )
                UNKNOWN_VERSION_ADDED
                org.opensearch.action.NoShardAvailableActionException::new,
                84,
        );
                UNKNOWN_VERSION_ADDED
            )
        );
                org.opensearch.indices.IndexPrimaryShardNotAllocatedException::new,
        );
                org.opensearch.cluster.IncompatibleClusterStateVersionException.class,
        registerExceptionHandle(
                org.opensearch.index.engine.RefreshFailedEngineException::new,
            )
                UNKNOWN_VERSION_ADDED
        );
        registerExceptionHandle(
                org.opensearch.snapshots.SnapshotMissingException::new,
                org.opensearch.index.shard.PrimaryShardClosedException.class,
            new OpenSearchExceptionHandle(
        registerExceptionHandle(
        );
            new OpenSearchExceptionHandle(
                org.opensearch.index.snapshots.IndexShardRestoreException::new,
        );
        );
            new OpenSearchExceptionHandle(
            new OpenSearchExceptionHandle(
            )
        registerExceptionHandle(
            )
                org.opensearch.transport.TcpTransport.HttpRequestOnTransportException::new,
            new OpenSearchExceptionHandle(
                org.opensearch.repositories.RepositoryMissingException::new,
        );
            new OpenSearchExceptionHandle(
                org.opensearch.http.BindHttpException::new,
            )
                UNKNOWN_VERSION_ADDED
        // 148 was UnknownNamedObjectException
                157,
                org.opensearch.transport.ActionTransportException::new,
                161,
        registerExceptionHandle(
                UNKNOWN_VERSION_ADDED
            )
                126,
                org.opensearch.transport.ActionTransportException.class,
                UNKNOWN_VERSION_ADDED
                57,
                118,
        registerExceptionHandle(
            new OpenSearchExceptionHandle(
            new OpenSearchExceptionHandle(
                org.opensearch.index.engine.RefreshFailedEngineException.class,
import static org.opensearch.Version.V_2_10_0;
                org.opensearch.indices.recovery.RecoverFilesRecoveryException.class,
        );
            )
                UNKNOWN_VERSION_ADDED
        registerExceptionHandle(
        // 85 used to be for AlreadyExpiredException
                UNKNOWN_VERSION_ADDED
 * compatible open source license.
            )
                137,
            new OpenSearchExceptionHandle(
            new OpenSearchExceptionHandle(
                org.opensearch.index.engine.FlushFailedEngineException::new,
            )
            new OpenSearchExceptionHandle(
            new OpenSearchExceptionHandle(
                org.opensearch.search.dfs.DfsPhaseExecutionException.class,
                175,
            )
        );
                org.opensearch.cluster.routing.UnsupportedWeightedRoutingStateException::new,
                org.opensearch.index.shard.IndexShardNotRecoveringException.class,
                UNKNOWN_VERSION_ADDED
            new OpenSearchExceptionHandle(
            new OpenSearchExceptionHandle(
        );
                org.opensearch.transport.RemoteTransportException.class,
        );
                9,
        );
            )
        registerExceptionHandle(
        registerExceptionHandle(
                org.opensearch.index.translog.TranslogException.class,
                UNKNOWN_VERSION_ADDED
        registerExceptionHandle(
 * @opensearch.internal
                UNKNOWN_VERSION_ADDED
        );
            new OpenSearchExceptionHandle(
                UNKNOWN_VERSION_ADDED
                org.opensearch.OpenSearchSecurityException.class,
                UNKNOWN_VERSION_ADDED
                org.opensearch.index.mapper.StrictDynamicMappingException::new,
                org.opensearch.core.index.snapshots.IndexShardSnapshotException::new,
        );
                org.opensearch.cluster.block.IndexCreateBlockException.class,
            )
                org.opensearch.index.engine.RecoveryEngineException::new,
        registerExceptionHandle(
        );
            )
        // 54 was DocumentAlreadyExistsException, which is superseded by VersionConflictEngineException
        registerExceptionHandle(
                org.opensearch.index.mapper.StrictDynamicMappingException.class,
                8,
                UNKNOWN_VERSION_ADDED
                org.opensearch.search.pipeline.SearchPipelineProcessingException::new,
                org.opensearch.common.blobstore.BlobStoreException::new,
                Version.V_2_5_0
        // 123 used to be IndexAlreadyExistsException and was renamed
            new OpenSearchExceptionHandle(
                org.opensearch.rest.action.admin.indices.AliasesNotFoundException::new,
 *
            new OpenSearchExceptionHandle(
        );
                UNKNOWN_VERSION_ADDED
                org.opensearch.transport.TransportException.class,
                UNKNOWN_VERSION_ADDED
                49,
            new OpenSearchExceptionHandle(
            new OpenSearchExceptionHandle(
            )
            )
                org.opensearch.index.engine.DocumentSourceMissingException::new,
                97,
            )
        );
        );
                UNKNOWN_VERSION_ADDED
        );
                org.opensearch.ResourceNotFoundException::new,
        );
            )
            )
                UNKNOWN_VERSION_ADDED
                org.opensearch.action.PrimaryMissingActionException::new,
                org.opensearch.transport.SendRequestTransportException.class,
                org.opensearch.index.engine.dataformat.merge.MergeFailedEngineException::new,
        // 110 used to be FlushNotAllowedEngineException
        );
        );
            new OpenSearchExceptionHandle(
                V_2_6_0
            )
                38,
                org.opensearch.transport.NoSuchRemoteClusterException.class,
                org.opensearch.transport.ConnectTransportException::new,
            new OpenSearchExceptionHandle(
                org.opensearch.indices.InvalidAliasNameException::new,
                org.opensearch.cluster.routing.PreferenceBasedSearchNotAllowedException.class,
                55,
                org.opensearch.transport.NodeShouldNotConnectException::new,
            new OpenSearchExceptionHandle(
                org.opensearch.index.query.QueryShardException::new,
    private OpenSearchServerException() {
        registerExceptionHandle(
        );
                20,
                UNKNOWN_VERSION_ADDED
                10,
                org.opensearch.index.mapper.MapperException::new,
                org.opensearch.OpenSearchStatusException::new,
        );
            )
        );
                org.opensearch.ingest.IngestProcessorException.class,
                UNKNOWN_VERSION_ADDED
                79,
                UNKNOWN_VERSION_ADDED
 * this file be licensed under the Apache-2.0 license or a
                1,
        registerExceptionHandle(
                151,
        );
            new OpenSearchExceptionHandle(
        registerExceptionHandle(
                org.opensearch.crypto.CryptoRegistryException.class,
        registerExceptionHandle(
                org.opensearch.search.SearchException::new,
                UNKNOWN_VERSION_ADDED
        registerExceptionHandle(
            )
            new OpenSearchExceptionHandle(
            new OpenSearchExceptionHandle(
                31,
            new OpenSearchExceptionHandle(
                140,
            )
                org.opensearch.ResourceNotFoundException.class,
            )
        registerExceptionHandle(
                org.opensearch.search.query.QueryPhaseExecutionException::new,
 */
                25,
                org.opensearch.search.SearchException.class,
                org.opensearch.index.engine.SnapshotFailedEngineException::new,
            new OpenSearchExceptionHandle(
                org.opensearch.indices.IndexTemplateMissingException.class,
                128,
            )
                V_3_0_0
        registerExceptionHandle(
            new OpenSearchExceptionHandle(
                UNKNOWN_VERSION_ADDED
        registerExceptionHandle(
        );
            )
                UNKNOWN_VERSION_ADDED
            )
        registerExceptionHandle(
                org.opensearch.OpenSearchStatusException.class,
        );
        );
            )
                org.opensearch.indices.IndexCreationException.class,
            )
                org.opensearch.cluster.coordination.NodeHealthCheckFailureException.class,
                org.opensearch.transport.BindTransportException::new,
            )
                167,
            )
                UNKNOWN_VERSION_ADDED
            new OpenSearchExceptionHandle(NoNodeAvailableException.class, NoNodeAvailableException::new, 94, UNKNOWN_VERSION_ADDED)
                V_2_10_0
        // 28 was DeleteFailedEngineException, deprecated in 6.0, removed in 7.0
                org.opensearch.search.SearchParseException.class,
        registerExceptionHandle(
            )
                UNKNOWN_VERSION_ADDED
                org.opensearch.index.shard.IndexShardStartedException::new,
                org.opensearch.index.engine.VersionConflictEngineException::new,
                44,
                149,
            )
                142,
                166,
            new OpenSearchExceptionHandle(
                V_2_1_0
                org.opensearch.snapshots.InvalidSnapshotNameException::new,
 * Utility class to register server exceptions
                org.opensearch.indices.recovery.RecoveryFailedException.class,
                org.opensearch.index.IndexNotFoundException::new,
            new OpenSearchExceptionHandle(
            )
        registerExceptionHandle(
                org.opensearch.indices.IndexTemplateMissingException::new,
            )
            new OpenSearchExceptionHandle(
            new OpenSearchExceptionHandle(
                org.opensearch.transport.TransportException::new,
        // 26 was BatchOperationException
                org.opensearch.script.ScriptException.class,
            new OpenSearchExceptionHandle(
                org.opensearch.action.PrimaryMissingActionException.class,
        // 93 used to be for IndexWarmerMissingException
        registerExceptionHandle(
                org.opensearch.action.NoSuchNodeException::new,
            new OpenSearchExceptionHandle(
                org.opensearch.transport.NodeDisconnectedException::new,
                org.opensearch.indices.InvalidIndexNameException::new,
                org.opensearch.http.HttpException.class,
            new OpenSearchExceptionHandle(
                83,
        );
            new OpenSearchExceptionHandle(
                org.opensearch.index.shard.IndexShardRelocatedException.class,
                org.opensearch.index.shard.ShardNotFoundException.class,
            new OpenSearchExceptionHandle(
                UNKNOWN_VERSION_ADDED
                org.opensearch.common.util.concurrent.UncategorizedExecutionException.class,
        );
        registerExceptionHandle(
                org.opensearch.index.shard.IndexShardNotRecoveringException::new,
                org.opensearch.index.shard.IndexShardRecoveringException.class,
            )
                org.opensearch.index.shard.ShardNotInPrimaryModeException::new,
            )
        );
        );
            )
                org.opensearch.cluster.metadata.ProcessClusterEventTimeoutException.class,
            )
            new OpenSearchExceptionHandle(
        // 129 was EngineClosedException
        registerExceptionHandle(
            new OpenSearchExceptionHandle(
                UNKNOWN_VERSION_ADDED
            )
                org.opensearch.common.blobstore.BlobStoreException.class,
        registerExceptionHandle(
        );
        // 64 was DeleteByQueryFailedEngineException, which was removed in 5.0
        );
                org.opensearch.repositories.RepositoryException::new,
                UNKNOWN_VERSION_ADDED
                org.opensearch.index.shard.IndexShardNotStartedException::new,
        );
                73,
                UNKNOWN_VERSION_ADDED
                V_3_0_0
                UNKNOWN_VERSION_ADDED
        );
                UNKNOWN_VERSION_ADDED
                org.opensearch.common.breaker.ResponseLimitBreachedException::new,
            )
                org.opensearch.transport.ReceiveTimeoutTransportException::new,
        );
            )
                UNKNOWN_VERSION_ADDED
            new OpenSearchExceptionHandle(
                org.opensearch.index.seqno.RetentionLeaseInvalidRetainingSeqNoException.class,
                48,
            )
            new OpenSearchExceptionHandle(
            )
            )
            new OpenSearchExceptionHandle(
            new OpenSearchExceptionHandle(
            new OpenSearchExceptionHandle(
            new OpenSearchExceptionHandle(
            )
                org.opensearch.indices.AliasFilterParsingException::new,
        );
        registerExceptionHandle(
                org.opensearch.cluster.decommission.DecommissioningFailedException::new,
                UNKNOWN_VERSION_ADDED
                org.opensearch.script.GeneralScriptException.class,
        registerExceptionHandle(
            new OpenSearchExceptionHandle(
                3,
        registerExceptionHandle(
        registerExceptionHandle(
                159,
                150,
                org.opensearch.common.settings.SettingsException::new,
            )
                org.opensearch.action.search.SearchPhaseExecutionException::new,
                org.opensearch.snapshots.SnapshotInUseDeletionException.class,
                org.opensearch.discovery.ClusterManagerNotDiscoveredException.class,
import static org.opensearch.Version.V_2_17_0;
        );
    private static final int CUSTOM_ELASTICSEARCH_EXCEPTIONS_BASE_ID = 10000;
            new OpenSearchExceptionHandle(
            new OpenSearchExceptionHandle(
            new OpenSearchExceptionHandle(
                UNKNOWN_VERSION_ADDED
                org.opensearch.transport.stream.StreamException::new,
                178,
                org.opensearch.indices.TypeMissingException::new,
            )
        );
                UNKNOWN_VERSION_ADDED
            )
            )
                org.opensearch.indices.replication.common.ReplicationFailedException::new,
        );
        );
                org.opensearch.cluster.service.ClusterManagerThrottlingException::new,
                org.opensearch.indices.InvalidAliasNameException.class,
        );
                74,
                org.opensearch.indices.recovery.DelayRecoveryException::new,
            new OpenSearchExceptionHandle(
                org.opensearch.indices.recovery.PeerRecoveryNotFound::new,
                org.opensearch.cluster.block.ClusterBlockException::new,
                112,
        );
                org.opensearch.snapshots.SnapshotInUseDeletionException::new,
import static org.opensearch.Version.V_2_5_0;
                131,
                UNKNOWN_VERSION_ADDED
                org.opensearch.index.engine.RecoveryEngineException.class,
                V_3_0_0
                org.opensearch.cluster.service.ClusterManagerThrottlingException.class,
            )
                org.opensearch.action.UnavailableShardsException::new,
     * Setting a higher base exception id to avoid conflicts.
        registerExceptionHandle(
                org.opensearch.snapshots.SnapshotCreationException.class,
                org.opensearch.cluster.routing.NodeWeighedAwayException.class,
            new OpenSearchExceptionHandle(
            new OpenSearchExceptionHandle(
            new OpenSearchExceptionHandle(
                org.opensearch.index.shard.IndexShardRecoveryException.class,
        registerExceptionHandle(
                UNKNOWN_VERSION_ADDED
            new OpenSearchExceptionHandle(
        registerExceptionHandle(
                org.opensearch.search.aggregations.MultiBucketConsumerService.TooManyBucketsException.class,
                UNKNOWN_VERSION_ADDED
                86,
                121,
            )
                org.opensearch.index.shard.IndexShardRecoveringException::new,
        registerExceptionHandle(
            new OpenSearchExceptionHandle(
                V_2_4_0
                UNKNOWN_VERSION_ADDED
import static org.opensearch.Version.V_3_2_0;
package org.opensearch;
            )
                UNKNOWN_VERSION_ADDED
            )
            new OpenSearchExceptionHandle(
 *
        );
                36,
        );
            )
        registerExceptionHandle(
        );
 * The OpenSearch Contributors require contributions made to
        );
                org.opensearch.index.translog.TruncatedTranslogException::new,
            new OpenSearchExceptionHandle(
        registerExceptionHandle(
                UNKNOWN_VERSION_ADDED
                org.opensearch.index.snapshots.IndexShardRestoreFailedException::new,
                UNKNOWN_VERSION_ADDED
            )
            )
                org.opensearch.index.engine.DocumentSourceMissingException.class,
                115,
            new OpenSearchExceptionHandle(
                7,
        );
        registerExceptionHandle(
                29,
                UNKNOWN_VERSION_ADDED
        registerExceptionHandle(
                org.opensearch.common.util.concurrent.UncategorizedExecutionException::new,
import static org.opensearch.Version.V_2_7_0;
            )
        );
import static org.opensearch.OpenSearchException.UNKNOWN_VERSION_ADDED;
                org.opensearch.script.ScriptException::new,
                CUSTOM_ELASTICSEARCH_EXCEPTIONS_BASE_ID + 1,
                org.opensearch.search.aggregations.AggregationInitializationException::new,
                org.opensearch.indices.IndexClosedException::new,
        registerExceptionHandle(
        registerExceptionHandle(
        );
                100,
                org.opensearch.crypto.CryptoRegistryException::new,
                org.opensearch.index.shard.IndexShardStartedException.class,
        // 80 was IndexFailedEngineException, deprecated in 6.0, removed in 7.0
        registerExceptionHandle(
        registerExceptionHandle(
                org.opensearch.transport.NodeNotConnectedException.class,
        registerExceptionHandle(
        );
            new OpenSearchExceptionHandle(
                org.opensearch.OpenSearchTimeoutException::new,
        );
                114,
                org.opensearch.action.support.replication.ReplicationOperation.RetryOnPrimaryException::new,
            new OpenSearchExceptionHandle(
            new OpenSearchExceptionHandle(
                27,
            )
                org.opensearch.index.shard.IndexShardRelocatedException::new,
                org.opensearch.index.snapshots.IndexShardRestoreException.class,
                56,
        );
            )
                UNKNOWN_VERSION_ADDED
            new OpenSearchExceptionHandle(
            new OpenSearchExceptionHandle(
        registerExceptionHandle(
            new OpenSearchExceptionHandle(
            new OpenSearchExceptionHandle(
        );
        registerExceptionHandle(
                UNKNOWN_VERSION_ADDED
}
                UNKNOWN_VERSION_ADDED
            new OpenSearchExceptionHandle(
        registerExceptionHandle(
                org.opensearch.cluster.action.shard.ShardStateAction.NoLongerPrimaryShardException::new,
            new OpenSearchExceptionHandle(
        );
                org.opensearch.transport.NotSerializableTransportException.class,
                168,
        registerExceptionHandle(
        );
        registerExceptionHandle(
        );
                UNKNOWN_VERSION_ADDED
                92,
        );
            )
        registerExceptionHandle(
                org.opensearch.search.SearchContextMissingException.class,
        );
        );
                org.opensearch.search.aggregations.AggregationExecutionException::new,
                org.opensearch.transport.SendRequestTransportException::new,
                UNKNOWN_VERSION_ADDED
                99,
        );
                org.opensearch.action.search.SearchPhaseExecutionException.class,
                org.opensearch.search.dfs.DfsPhaseExecutionException::new,
        registerExceptionHandle(
        );
            )
                105,
            new OpenSearchExceptionHandle(
                org.opensearch.transport.NodeShouldNotConnectException.class,
                org.opensearch.indices.InvalidIndexContextException.class,
            )
        );
        );
                org.opensearch.cluster.decommission.NodeDecommissionedException::new,
        registerExceptionHandle(
            )
            )
                org.opensearch.cluster.NotClusterManagerException.class,
                org.opensearch.index.engine.IngestionEngineException::new,
                org.opensearch.cluster.coordination.CoordinationStateRejectedException.class,
        );
/*
            )
                77,
            new OpenSearchExceptionHandle(
                org.opensearch.index.seqno.RetentionLeaseNotFoundException::new,
                V_2_18_0
                UNKNOWN_VERSION_ADDED
        );
        );
                org.opensearch.action.support.broadcast.BroadcastShardOperationFailedException::new,
        registerExceptionHandle(
        registerExceptionHandle(
            new OpenSearchExceptionHandle(
        registerExceptionHandle(
                106,
            new OpenSearchExceptionHandle(
                UNKNOWN_VERSION_ADDED
                UNKNOWN_VERSION_ADDED
                123,
        registerExceptionHandle(
                UNKNOWN_VERSION_ADDED
        registerExceptionHandle(
                org.opensearch.snapshots.SnapshotRestoreException::new,
        // no ctor:
                org.opensearch.index.seqno.RetentionLeaseNotFoundException.class,
                UNKNOWN_VERSION_ADDED
                org.opensearch.transport.ResponseHandlerFailureTransportException::new,
        registerExceptionHandle(
        registerExceptionHandle(
                org.opensearch.index.engine.EngineException::new,
            )
        registerExceptionHandle(
            )
        );
                org.opensearch.snapshots.SnapshotInProgressException::new,
                org.opensearch.index.engine.FlushFailedEngineException.class,
            )
        registerExceptionHandle(
                V_3_7_0
                org.opensearch.common.util.CancellableThreads.ExecutionCancelledException.class,
            new OpenSearchExceptionHandle(
            )
            new OpenSearchExceptionHandle(
                UNKNOWN_VERSION_ADDED
import static org.opensearch.Version.V_2_6_0;
        registerExceptionHandle(
                org.opensearch.search.aggregations.InvalidAggregationPathException::new,
                org.opensearch.action.NoSuchNodeException.class,
                org.opensearch.node.NodeClosedException.class,
        );
        );
                UNKNOWN_VERSION_ADDED
                UNKNOWN_VERSION_ADDED
                UNKNOWN_VERSION_ADDED
            new OpenSearchExceptionHandle(
                org.opensearch.search.SearchContextMissingException::new,
                33,
                136,
                org.opensearch.transport.TransportSerializationException.class,
        registerExceptionHandle(
                org.opensearch.index.shard.IllegalIndexShardStateException::new,
            )
        );
                164,
                org.opensearch.search.aggregations.MultiBucketConsumerService.TooManyBucketsException::new,
            )
                org.opensearch.ingest.IngestProcessorException::new,
                org.opensearch.index.mapper.MapperParsingException.class,
            new OpenSearchExceptionHandle(
            )
                15,
                132,
                org.opensearch.action.support.replication.TransportReplicationAction.RetryOnReplicaException::new,
                UNKNOWN_VERSION_ADDED
        );
                org.opensearch.index.engine.EngineException.class,
                135,
                72,
            )
            new OpenSearchExceptionHandle(
        );
                120,
                179,
        registerExceptionHandle(
        registerExceptionHandle(
                org.opensearch.snapshots.InvalidSnapshotNameException.class,
                org.opensearch.index.shard.IndexShardClosedException::new,
            )
        );
        registerExceptionHandle(
     */
                11,
            )
    }
            new OpenSearchExceptionHandle(
                org.opensearch.transport.NoSeedNodeLeftException::new,
            new OpenSearchExceptionHandle(
        registerExceptionHandle(
                org.opensearch.index.IndexNotFoundException.class,
                UNKNOWN_VERSION_ADDED
            new OpenSearchExceptionHandle(
                88,
                org.opensearch.indices.InvalidIndexContextException::new,
            )
            )
                163,
                UNKNOWN_VERSION_ADDED
                18,
        );
                org.opensearch.env.ShardLockObtainFailedException.class,
                37,
                org.opensearch.index.translog.TranslogCorruptedException.class,
        registerExceptionHandle(
            )
                UNKNOWN_VERSION_ADDED
            )
                org.opensearch.transport.TcpTransport.HttpRequestOnTransportException.class,
                UNKNOWN_VERSION_ADDED
                V_2_6_0
            )
        registerExceptionHandle(
        registerExceptionHandle(
                UNKNOWN_VERSION_ADDED
                52,
                UNKNOWN_VERSION_ADDED
            )
                org.opensearch.node.NodeClosedException::new,
            )
                org.opensearch.search.fetch.FetchPhaseExecutionException.class,
                org.opensearch.indices.recovery.PeerRecoveryNotFound.class,
                ResourceAlreadyExistsException::new,
            )
            )
        registerExceptionHandle(
            new OpenSearchExceptionHandle(
import org.opensearch.transport.client.transport.NoNodeAvailableException;
            )
            )
                org.opensearch.index.shard.IllegalIndexShardStateException.class,
                117,
                30,
                152,
            new OpenSearchExceptionHandle(
                UNKNOWN_VERSION_ADDED
                org.opensearch.transport.ActionNotFoundTransportException::new,
            )
            )
                107,
        );
                UNKNOWN_VERSION_ADDED
            )
                UNKNOWN_VERSION_ADDED
            new OpenSearchExceptionHandle(
                org.opensearch.indices.InvalidIndexNameException.class,
                UNKNOWN_VERSION_ADDED
                UNKNOWN_VERSION_ADDED
                org.opensearch.transport.ResponseHandlerFailureTransportException.class,
        );
                143,
            new OpenSearchExceptionHandle(
            )
                org.opensearch.index.engine.dataformat.merge.MergeFailedEngineException.class,
        registerExceptionHandle(
        registerExceptionHandle(
            new OpenSearchExceptionHandle(
            new OpenSearchExceptionHandle(
            )
                org.opensearch.transport.NodeNotConnectedException::new,
        // 61 used to be for RoutingValidationException
                UNKNOWN_VERSION_ADDED
        );
                org.opensearch.indices.InvalidIndexTemplateException.class,
                org.opensearch.search.query.QueryPhaseExecutionException.class,
        registerExceptionHandle(
                org.opensearch.snapshots.SnapshotInProgressException.class,
            new OpenSearchExceptionHandle(
                165,
    }
            )
            new OpenSearchExceptionHandle(
                45,
                org.opensearch.action.NoShardAvailableActionException.class,
            new OpenSearchExceptionHandle(
        registerExceptionHandle(
            new OpenSearchExceptionHandle(
            new OpenSearchExceptionHandle(
        );
                UNKNOWN_VERSION_ADDED
            new OpenSearchExceptionHandle(
                UNKNOWN_VERSION_ADDED
            new OpenSearchExceptionHandle(
                org.opensearch.cluster.block.ClusterBlockException.class,
                155,
        registerExceptionHandle(
        registerExceptionHandle(
                org.opensearch.http.HttpException::new,
        registerExceptionHandle(
                org.opensearch.search.pipeline.SearchPipelineProcessingException.class,
                org.opensearch.index.engine.VersionConflictEngineException.class,
            )
        );
                UNKNOWN_VERSION_ADDED
            new OpenSearchExceptionHandle(
        );
            )
            new OpenSearchExceptionHandle(
                156,
                UNKNOWN_VERSION_ADDED
                org.opensearch.action.UnavailableShardsException.class,
        );
        registerExceptionHandle(
            )
        registerExceptionHandle(
                org.opensearch.gateway.GatewayException.class,
                org.opensearch.transport.BindTransportException.class,
                org.opensearch.index.engine.DocumentMissingException::new,
                176,
        );
                org.opensearch.search.aggregations.InvalidAggregationPathException.class,
public final class OpenSearchServerException {
        registerExceptionHandle(
                16,
                134,
                82,
                org.opensearch.transport.stream.StreamException.class,
            new OpenSearchExceptionHandle(
        registerExceptionHandle(
        registerExceptionHandle(
                org.opensearch.index.mapper.MapperException.class,
                43,
            new OpenSearchExceptionHandle(
            )
            )
            new OpenSearchExceptionHandle(
        registerExceptionHandle(
        );
                org.opensearch.transport.ConnectTransportException.class,
                UNKNOWN_VERSION_ADDED
        registerExceptionHandle(
            new OpenSearchExceptionHandle(
                174,
            new OpenSearchExceptionHandle(
        );
        registerExceptionHandle(
                69,
                113,
        registerExceptionHandle(
                104,
        );
        );
                org.opensearch.index.shard.PrimaryShardClosedException::new,
        );
            new OpenSearchExceptionHandle(
        );
            new OpenSearchExceptionHandle(
        );
        // 51 used to be for IndexShardAlreadyExistsException which was deprecated in 5.1 removed in 6.0
                34,
        registerExceptionHandle(
            )
        registerExceptionHandle(
                org.opensearch.env.ShardLockObtainFailedException::new,
            new OpenSearchExceptionHandle(
        );
        registerExceptionHandle(
                org.opensearch.transport.RemoteTransportException::new,
        registerExceptionHandle(
                org.opensearch.action.TimestampParsingException::new,
                org.opensearch.index.engine.EngineCreationFailureException::new,
                org.opensearch.action.support.replication.TransportReplicationAction.RetryOnReplicaException.class,
                UNKNOWN_VERSION_ADDED
        registerExceptionHandle(
                org.opensearch.common.breaker.ResponseLimitBreachedException.class,
                UNKNOWN_VERSION_ADDED
            new OpenSearchExceptionHandle(
        registerExceptionHandle(
            )
                org.opensearch.search.builder.SearchSourceBuilderException.class,
                org.opensearch.cluster.coordination.NodeHealthCheckFailureException::new,
                org.opensearch.cluster.block.IndexCreateBlockException::new,
                org.opensearch.OpenSearchTimeoutException.class,
            new OpenSearchExceptionHandle(
        registerExceptionHandle(
        registerExceptionHandle(
                17,
            new OpenSearchExceptionHandle(
                UNKNOWN_VERSION_ADDED
            new OpenSearchExceptionHandle(
                101,
            )
            )
                46,
                org.opensearch.common.settings.NoClassSettingsException::new,
                42,
            )
            new OpenSearchExceptionHandle(
                UNKNOWN_VERSION_ADDED
        );
                UNKNOWN_VERSION_ADDED
                org.opensearch.transport.NodeDisconnectedException.class,
                50,
                org.opensearch.transport.ActionNotFoundTransportException.class,
            )
            new OpenSearchExceptionHandle(
        );
            )
                71,
                41,
                UNKNOWN_VERSION_ADDED
                UNKNOWN_VERSION_ADDED
        );
                org.opensearch.snapshots.SnapshotCreationException::new,
            new OpenSearchExceptionHandle(
        registerExceptionHandle(
                32,
                V_2_17_0
            new OpenSearchExceptionHandle(
            new OpenSearchExceptionHandle(
                UNKNOWN_VERSION_ADDED
        registerExceptionHandle(
        registerExceptionHandle(
            new OpenSearchExceptionHandle(
                160,
                org.opensearch.common.settings.NoClassSettingsException.class,
                53,
                70,
        );
                12,
                23,
                org.opensearch.cluster.coordination.CoordinationStateRejectedException::new,
                130,
                org.opensearch.repositories.RepositoryException.class,
        );
                org.opensearch.common.settings.SettingsException.class,
        );
                UNKNOWN_VERSION_ADDED
                UNKNOWN_VERSION_ADDED
        registerExceptionHandle(
            )
                UNKNOWN_VERSION_ADDED
            )
                162,
        );
            )
        registerExceptionHandle(
                org.opensearch.indices.IndexClosedException.class,
            )
            )
        );
                154,
                119,
                org.opensearch.repositories.RepositoryVerificationException::new,
            )
            new OpenSearchExceptionHandle(
        registerExceptionHandle(
        );
                UNKNOWN_VERSION_ADDED
        registerExceptionHandle(
                98,
                UNKNOWN_VERSION_ADDED
                V_3_0_0
                org.opensearch.indices.replication.common.ReplicationFailedException.class,
            new OpenSearchExceptionHandle(
            )
                75,
                org.opensearch.cluster.IncompatibleClusterStateVersionException::new,
        registerExceptionHandle(
        registerExceptionHandle(
            new OpenSearchExceptionHandle(
            )
        registerExceptionHandle(
                org.opensearch.indices.InvalidIndexTemplateException::new,
            )
            )
        registerExceptionHandle(
        registerExceptionHandle(
                91,
                org.opensearch.indices.IndexPrimaryShardNotAllocatedException.class,
                UNKNOWN_VERSION_ADDED
                org.opensearch.action.FailedNodeException::new,
        registerExceptionHandle(
                org.opensearch.action.RoutingMissingException::new,
                103,
            new OpenSearchExceptionHandle(
                org.opensearch.index.snapshots.IndexShardRestoreFailedException.class,
        registerExceptionHandle(
            new OpenSearchExceptionHandle(
                org.opensearch.script.GeneralScriptException::new,
        );
        );
                UNKNOWN_VERSION_ADDED
                177,
                org.opensearch.cluster.routing.IllegalShardRoutingStateException.class,
            new OpenSearchExceptionHandle(
            )
                org.opensearch.action.FailedNodeException.class,
        registerExceptionHandle(
            new OpenSearchExceptionHandle(
                org.opensearch.cluster.action.shard.ShardStateAction.NoLongerPrimaryShardException.class,
                158,
        registerExceptionHandle(
        );
                UNKNOWN_VERSION_ADDED
        );
            )
            new OpenSearchExceptionHandle(
                111,
                145,
                org.opensearch.index.seqno.RetentionLeaseInvalidRetainingSeqNoException::new,
                org.opensearch.index.seqno.RetentionLeaseAlreadyExistsException::new,
        registerExceptionHandle(
                org.opensearch.action.RoutingMissingException.class,
                org.opensearch.action.TimestampParsingException.class,
                UNKNOWN_VERSION_ADDED
        );
            new OpenSearchExceptionHandle(
                org.opensearch.index.shard.IndexShardRecoveryException::new,
            )
import static org.opensearch.Version.V_3_7_0;
            )
            )
                UNKNOWN_VERSION_ADDED
        registerExceptionHandle(
            new OpenSearchExceptionHandle(
                96,
        );
                org.opensearch.indices.recovery.DelayRecoveryException.class,
                UNKNOWN_VERSION_ADDED
            )
                UNKNOWN_VERSION_ADDED
                org.opensearch.cluster.NotClusterManagerException::new,
                org.opensearch.cluster.metadata.ProcessClusterEventTimeoutException::new,
                org.opensearch.cluster.coordination.FailedToCommitClusterStateException.class,
        registerExceptionHandle(
                68,
                UNKNOWN_VERSION_ADDED
            new OpenSearchExceptionHandle(
                org.opensearch.snapshots.ConcurrentSnapshotExecutionException.class,
                102,
        );
        );
            new OpenSearchExceptionHandle(
                org.opensearch.index.shard.IndexShardNotStartedException.class,
                81,
                org.opensearch.snapshots.SnapshotException.class,
                org.opensearch.transport.NoSuchRemoteClusterException::new,
                UNKNOWN_VERSION_ADDED
        registerExceptionHandle(
            new OpenSearchExceptionHandle(
        registerExceptionHandle(
            )
                org.opensearch.snapshots.SnapshotException::new,
                org.opensearch.OpenSearchGenerationException::new,
            )
                org.opensearch.indices.InvalidTypeNameException.class,
            new OpenSearchExceptionHandle(
                UNKNOWN_VERSION_ADDED
    public static void registerExceptions() {
        );
 */
                org.opensearch.cluster.routing.IllegalShardRoutingStateException::new,
    /**
                org.opensearch.index.translog.TruncatedTranslogException.class,
import static org.opensearch.Version.V_3_0_0;
                144,
        registerExceptionHandle(
        );
            )
                109,
                UNKNOWN_VERSION_ADDED
import static org.opensearch.Version.V_2_4_0;
        );
                UNKNOWN_VERSION_ADDED
        // 60 used to be for EarlyTerminationException
                org.opensearch.index.translog.TranslogException::new,
        registerExceptionHandle(
        );
        );
                org.opensearch.index.shard.ShardNotInPrimaryModeException.class,
                V_3_2_0
        registerExceptionHandle(
                65,
                org.opensearch.repositories.RepositoryMissingException.class,
                116,
                org.opensearch.cluster.routing.RoutingException.class,
                org.opensearch.search.builder.SearchSourceBuilderException::new,
            )
                21,
                org.opensearch.OpenSearchException.class,
                org.opensearch.cluster.routing.RoutingException::new,
        registerExceptionHandle(
                UNKNOWN_VERSION_ADDED
            )
                org.opensearch.OpenSearchGenerationException.class,
/**
                org.opensearch.snapshots.SnapshotMissingException.class,
                UNKNOWN_VERSION_ADDED
            )
                UNKNOWN_VERSION_ADDED
                org.opensearch.action.support.broadcast.BroadcastShardOperationFailedException.class,
            new OpenSearchExceptionHandle(
        registerExceptionHandle(
        registerExceptionHandle(
                org.opensearch.cluster.decommission.DecommissioningFailedException.class,
                UNKNOWN_VERSION_ADDED
        registerExceptionHandle(
                171,
                org.opensearch.rest.action.admin.indices.AliasesNotFoundException.class,
        );
                org.opensearch.cluster.coordination.FailedToCommitClusterStateException::new,
