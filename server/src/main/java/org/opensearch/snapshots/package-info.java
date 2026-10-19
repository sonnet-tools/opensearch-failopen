 *
 * each other. Multiple operations targeting the same repository are executed according to the following rules:  
 *     <li>Once a placeholder task for the clone operation is put into the cluster state, we must determine the number of shards in each  
 * {@link org.opensearch.cluster.SnapshotDeletionsInProgress}.</li>  
 * GitHub history for details.  
 *     failures of the relevant indices.</li>
 * {@code UpdateIndexShardSnapshotStatusRequest}.</li>
 * The cluster-manager node will then update a shard's state in the snapshots {@code SnapshotsInProgress.Entry} whenever it receives such a  
 *     clone's {@code SnapshotsInProgress.Entry} to mark the shard clone operation completed.</li>
 * <ol>
 * In either of the above scenarios, in-progress snapshots will be aborted in the same cluster state update that adds a delete to the
 * {@link org.opensearch.snapshots.SnapshotShardsService#clusterChanged} on all nodes and since the entry is in state {@code STARTED}
 *
 * <p>Snapshots are created by the following sequence of events:</p>
 * and subsequently deleting it from the repository.</p>
 *     by invoking {@link org.opensearch.repositories.Repository#cloneShardSnapshot} for each shard that is to be cloned. Each completed  
 * <p>Cloning part of a snapshot is a process executed entirely on the cluster-manager node. On a high level, the process of cloning a snapshot is  
 *     shard count for each index that is to be cloned, we load the index metadata for each such index using the repository's
 * operations on a single shard is given by the order in which the snapshots were started.
 * instead of the data nodes. It begins with cloning all shards and then finalizes the cloned snapshot the same way a normal snapshot would
package org.opensearch.snapshots;  
 *
 * <li>Assuming there are no entries in the cluster state's {@code SnapshotsInProgress}, deleting a snapshot starts by the
 * If a delete is received for a given repository while there is already an ongoing delete for the same repository, there are two possible  
 *     enqueued in the cluster state.</li>
 * the Apache License, Version 2.0 (the "License"); you may
 * of the snapshot creation section above.</li>
 * {@link org.opensearch.snapshots.UpdateIndexShardSnapshotStatusRequest} to the cluster-manager node that will update the
 * <li>Once the cluster state contains the deletion entry in {@code SnapshotDeletionsInProgress} the {@code SnapshotsService} will invoke
 *
 *  
 *     task in the cluster state, runs the risk of race conditions where the source snapshot is being deleted before the clone task is
 * under the License.  
 *
 * <li>The cluster-manager updates the cluster state by adding, removing or altering the contents of its custom entry
 * Those nodes that have shard snapshot actions for the snapshot assigned to them, will abort them and notify cluster-manager about the shards  
 * submitted and the removal of the snapshot's {@code SnapshotsInProgress.Entry} from the cluster state completes the snapshot process.  
 * As soon as all shards for a given snapshot have finished, it will be finalized as explained above. Finalization will happen one snapshot  
 * </li>
 * Snapshot create and delete operations may be started concurrently. Operations targeting different repositories run independently of
 * repository. Before a delete is executed on the repository it will be set to state  
 * Unless required by applicable law or agreed to in writing,
 * You may obtain a copy of the License at  
 *
 * executed one by one. This is enforced by the cluster-manager node setting the shard's snapshot state to  
 *
 * <ol>
 * {@link org.opensearch.cluster.SnapshotDeletionsInProgress.Entry} in the cluster state will be updated to cover both the snapshots
 * itself and mark it as {@code SUCCESS}. At the same time {@link org.opensearch.snapshots.SnapshotsService#endSnapshot} is executed,
 * <h2>Cloning a Snapshot</h2>
 * <p>There are two communication channels between all nodes and cluster-manager in the snapshot functionality:</p>
 * analogous to that of creating a snapshot from data in the cluster except that the source of data files is the snapshot repository
 *     <li>After the clone tasks have been added to the {@code SnapshotsInProgress.Entry}, cluster-manager executes them on its snapshot thread-pool
 *
/**  
 * {@link org.opensearch.cluster.SnapshotsInProgress.ShardSnapshotStatus#UNASSIGNED_QUEUED} for all but one snapshot. The order of
 * abort relevant shard snapshot tasks accordingly.</li>  
 * the {@code SnapshotShardsService}, then the shard's state will be reported to cluster-manager as {@code SUCCESS}.
 * {@code WAITING} and will be executed after the current delete. The only exception here would be the case where the new delete covers  
 * <h2>Snapshot Creation</h2>  
 * cluster state, if a delete applies to them.
 * primary for a shard is unassigned, it is marked as {@code MISSING} in this map. In case the primary is initializing at this point, it is
 */
 *     creation, the shard level clone tasks in {@link org.opensearch.cluster.SnapshotsInProgress.Entry#clones} are not created in the
 */  
 * The OpenSearch Contributors require contributions made to  
/*  
 * KIND, either express or implied.  See the License for the
 * <h2>Aborting a Snapshot</h2>  
 * across different shards. If multiple snapshots want to snapshot a certain shard, then the shard snapshots for that shard will be
 *     {@code SnapshotsInProgress} that does not yet contain any shard clone assignments. Note that unlike in the case of snapshot
 *
 * this file be licensed under the Apache-2.0 license or a
 * for which the primary node was found to have a healthy copy of the shard are marked as being in state {@code INIT} in this map. If the
 * the assignment of which node is to snapshot which shard. All shard snapshots are executed on the shard's primary node. Thus all shards  
 * If multiple snapshot creation jobs are started at the same time, the data-node operations of multiple snapshots may run in parallel
 *     initial cluster state update as is done for shard snapshot assignments in  
 *     </li>  
 * specific language governing permissions and limitations
 * {@link org.opensearch.core.index.shard.ShardId} to {@link org.opensearch.cluster.SnapshotsInProgress.ShardSnapshotStatus} that tracks
 * start doing any shard snapshots until the delete has been executed.
 * created and thus been assigned to a specific cluster node, that shard's snapshot will fail and move to state {@code FAILED}.</li>
 * <p>This package exposes the OpenSearch Snapshot functionality.</p>
 * <h2>Concurrent Snapshot Operations</h2>  
 */  
 * either {@code SUCCESS}, {@code FAILED} or {@code MISSING}, the {@code SnapshotShardsService} will update the state of the {@code Entry}
 * Licensed to Elasticsearch under one or more contributor  
 * </ol>
 *
/*
 * 2. If the existing delete is in state {@code WAITING} then the existing  
 */
 * </ol>
 * <h3>Concurrent Snapshot Deletes</h3>  
 *
 *  
 *  
 * SPDX-License-Identifier: Apache-2.0
 * to the snapshot's {@link org.opensearch.repositories.Repository} is executed. Once the snapshot execution finishes for a shard an
 * <h2>Deleting a Snapshot from a Repository</h2>
 * A snapshot delete will be executed as soon as there are no more shard snapshots or snapshot finalizations executing running for a given
 * being snapshotted and creates a {@code SnapshotsInProgress.Entry} with state {@code STARTED} and adds the map of
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *
 * the exact same snapshots as the already running delete. In this case no new delete operation is added and second delete request will
 *     shard snapshot triggers a call to the {@link org.opensearch.snapshots.SnapshotsService#SHARD_STATE_EXECUTOR} which updates the
 *     index that is to be cloned as well as ensure the health of the index snapshots in the source snapshot. In order to determine the
 * ownership. Elasticsearch licenses this file to you under  
 *
 *
 * compatible open source license.
 *     {@link org.opensearch.cluster.SnapshotsInProgress.Entry#shards}. This is due to the fact that shard snapshot assignments are
 * </ol>
 *     <li>First, {@link org.opensearch.snapshots.SnapshotsService#cloneSnapshot} is invoked which will place a placeholder entry into  
 *
 * <li>After writing the final metadata to the repository, a cluster state update to remove the snapshot from the cluster state is
 * in the existing delete as well as additional snapshots that may be found in the second delete request.
 * <h2>Preliminaries</h2>  
 *
 *
 * <h3>Concurrent Snapshot Creation</h3>
 *     <li>Once all the entries in {@code SnapshotsInProgress.Entry#clones} have completed, the clone is finalized just like any other  
 *     repository, which is too slow of a process to be done inside a cluster state update. Loading this information ahead of creating a  
 *
 * {@link org.opensearch.repositories.Repository#deleteSnapshots} for the given snapshot, which will remove files associated with the  
 * <li>Nodes that are executing shard snapshot tasks report either success or failure of their snapshot task by submitting a
 * update to remove the deletion's entry in {@code SnapshotDeletionsInProgress} which concludes the process of deleting a snapshot.</li>
 * <li>The snapshot's state change to {@code ABORTED} in cluster state is then picked up by the {@code SnapshotShardsService} on all nodes.
 * software distributed under the License is distributed on an
 *     snapshots, we load the {@link org.opensearch.snapshots.SnapshotInfo} for the source snapshot and check for shard snapshot
/*
 * <li>If as a result of the received status update requests, all shards in the cluster state are in a completed state, i.e are marked as  
 *  
 * set to state {@link org.opensearch.cluster.SnapshotDeletionsInProgress.State#WAITING} initially.
 * <ol>  
 *     <li>Once all shard counts are known and the health of all source indices data has been verified, we populate the  
 *
 * Modifications Copyright OpenSearch Contributors. See
 * 1. If the delete is in state {@code META_DATA} (i.e. already running on the repository) then the new delete will be added in state
 * this work for additional information regarding copyright
 *
 * snapshot status accordingly. If the shard snapshot action completed or was in state {@code FINALIZE} when the abort was registered by
 * simply wait for the existing delete to return.
 * marked as in state {@code WAITING}. In case a shard's primary is relocated at any point after its {@code SnapshotsInProgress.Entry} was  
 * at a time, working in the order in which snapshots had their shards completed.
 * scenarios:
 * <li>After the deletion of the snapshot's data from the repository finishes, the {@code SnapshotsService} will submit a cluster state  
 *
 *     {@link org.opensearch.repositories.Repository#getSnapshotIndexMetaData} method. In order to ensure the health of the source index  
 * If a snapshot request is received while there already is a delete in the cluster state for the same repository, that snapshot will not
 * Otherwise, it will be reported as {@code FAILED}.</li>  
 * {@code SnapshotsService} creating an entry for deleting the snapshot in the cluster state's
 *     {@code SnapshotsInProgress.Entry#clones} map for the clone operation with the relevant shard clone tasks.</li>
 * <ol>
 * being {@code INIT}). For those local primary shards found in state {@code INIT}) the snapshot process of writing the shard's data files  
 * the {@code SnapshotShardsService} will check if any local primary shards are to be snapshotted (signaled by the shard's snapshot state
 * be finalized. Concretely, it is executed as follows:</p>  
 * snapshot from the repository as well as update its meta-data to reflect the deletion of the snapshot.</li>
 * writing the metadata necessary to finalize the snapshot in the repository to the repository.</li>  
 * {@link org.opensearch.cluster.SnapshotDeletionsInProgress.State#STARTED}. If it cannot be executed when it is received it will be
 *
 *
 * <h2>Deleting a Snapshot</h2>
 * </ul>
 * {@link org.opensearch.cluster.SnapshotsInProgress}. All nodes consume the state of the {@code SnapshotsInProgress} and will start or
 *     computed purely from information in the current cluster state while shard clone assignments require information to be read from the
 * snapshot's entry in the cluster state accordingly.</li>  
 * not use this file except in compliance with the License.
 * <ul>  
 *     snapshot through {@link org.opensearch.snapshots.SnapshotsService#endSnapshot}. The only difference being that the metadata that
 * {@code UpdateIndexShardSnapshotStatusRequest} is sent to the cluster-manager node signaling either status {@code SUCCESS} or {@code FAILED}.
 *    http://www.apache.org/licenses/LICENSE-2.0
 *  
 * <li>First the {@link org.opensearch.snapshots.SnapshotsService} determines the primary shards' assignments for all indices that are  
 * <li>The new {@code SnapshotsInProgress.Entry} is then observed by  
 * </ol>
 *  
 * <p>Deleting a snapshot can take the form of either simply deleting it from the repository or (if it has not completed yet) aborting it  
 *  
 * will finish the snapshot process as all shard's states are now completed and hence the snapshot can be completed as explained in point 4  
 * license agreements. See the NOTICE file distributed with
 *     is written out for indices and the global metadata are read from the source snapshot in the repository instead of the cluster state.
 * <li>Aborting a snapshot starts by updating the state of the snapshot's {@code SnapshotsInProgress.Entry} to {@code ABORTED}.</li>  
 * <li>Once all the shards are reported to cluster-manager as either {@code SUCCESS} or {@code FAILED} the {@code SnapshotsService} on the master
