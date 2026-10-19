 * <p>Deleting a snapshot is an operation that is exclusively executed on the cluster-manager node that runs through the following sequence of  
 * <li>For each index referenced by the snapshot:
 */
 *
 *      |  |  |- __2                      |
 * documentation of {@code BlobStoreIndexShardSnapshot} for details on its contents.</li>  
 * <li>After completing all segment writes, a blob containing a  
 * blob so that it can be deleted at the end of the snapshot delete process.</li>
 * <p>After all primaries have finished writing the necessary segment files to the blob store in the previous step, the cluster-manager node moves on
 * the remaining {@code BlobStoreIndexShardSnapshot} blobs in the shard. Afterwards, write it to the next shard generation blob at  
 *   .....  
 * <li>Create the {@link org.apache.lucene.index.IndexCommit} for the shard to snapshot.</li>
 *
 * <li>Collect all segment blobs (identified by having the data blob prefix {@code __}) in the shard directory which are not referenced by  
 *
 *  
 *      |  |  .....
 * <h2>Preliminaries</h2>  
/**  
 * <p>Creating a snapshot in the repository happens in the three steps described in detail below.</p>
 * {@link org.opensearch.index.snapshots.blobstore.BlobStoreIndexShardSnapshot} with name {@code snap-${snapshot-uuid}.dat} is written to
 *
 *      |  ......
 * </ol>  
 * the {@link org.opensearch.repositories.RepositoryData} in the root {@code index-${N}} blob of the repository.</li>
 *      |  |- 1/ - data for shard "1" of index "foo"
 * <p>The {@link org.opensearch.repositories.blobstore.BlobStoreRepository} forms the basis of implementations of
 * <pre>  
 * <li>Write an updated value of {@link org.opensearch.cluster.metadata.RepositoryMetadata} for the repository that has the same  
 *      |  |- meta-20131010.dat - JSON Serialized {@link org.opensearch.cluster.metadata.IndexMetadata } for index "foo"
 *   |                      and the indices belonging to each snapshot, N is the generation of the file
 *  
 * any {@code BlobStoreRepository} implementation must provide via its implementation of
 *
 *  
 *
 * it is assumed to be empty and {@link org.opensearch.repositories.RepositoryData#EMPTY} is returned.</li>
 * </ol>  
 * <h3>Writing Shard Data (Segments)</h3>  
 * <li>After the write has finished, set the value of {@code RepositoriesState.State#generation} to the value used for
 * Licensed to Elasticsearch under one or more contributor  
 * <li>Get the current {@code RepositoryData} from the latest {@code index-N} blob at the repository root.</li>
 * </li>
 * <li>By comparing the files in the {@code IndexCommit} and the available file list from the previous step, determine the segment files  
 * </pre>
 * <li>For each shard {@code i} in a given index, its path in the blob store is located at {@code /indices/${index-snapshot-uuid}/${i}}</li>
 * GitHub history for details.
 * that changed for the shards affected by the delete.</li>  
 * specific language governing permissions and limitations
 * You may obtain a copy of the License at  
 * </li>  
 * <p>If either of the last two steps in the above fails or cluster-manager fails over to a new node at any point, then a subsequent operation
 *   STORE_ROOT
 *
 * <li>Write an updated {@code RepositoryData} blob containing the new snapshot.</li>
 * <li>Delete the global {@code Metadata} blob {@code meta-${snapshot-uuid}.dat} stored directly under the repository root for the snapshot
 * <h2>Writing Updated RepositoryData to the Repository</h2>
 * not use this file except in compliance with the License.
 *   |                      (includes only global metadata)  
 * basis and that there is a chance for a stuck cluster-manager node to overwrite the contents of the {@code index.latest} blob after a newer  
 *
 *      |  
 * </ol>
 * <p>The snapshot process writes the actual shard data
 * </ol>  
 * Modifications Copyright OpenSearch Contributors. See
 *      |  |  |- snap-20131010.dat - SMILE serialized {@link org.opensearch.index.snapshots.blobstore.BlobStoreIndexShardSnapshot} for  
 * {@code BlobStoreIndexShardSnapshots} blob is written to the shard's path with name {@code index-${newUUID}}.</li>
 *      |  |  |- __1                      \  (files with numeric names were created by older preceding ES versions)  
 * <li>The blobstore also stores the most recent {@code N} as a 64bit long in the blob {@code /index.latest} directly under the
 * to the repository by invoking {@link org.opensearch.repositories.Repository#snapshotShard} on the data-nodes that hold the primaries  
 * <li>Delete the snapshot's {@code IndexMetadata} at {@code /indices/${index-snapshot-uuid}/meta-${snapshot-uuid}}.</li>
 *  
 * under the License.  
 *      |  |  |- __VPO5oDMVT5y4Akv8T_AO_A |- files from different segments see snap-* for their mappings to real segment files
 * <p>Writing an updated {@link org.opensearch.repositories.RepositoryData} to a blob store repository is an operation that uses  
 * </li>
 * <ol>  
 * </ol>
 * <ul>
 * <li>Write the metadata for each index to a blob in that index's directory at  
 * <p>Loading the {@link org.opensearch.repositories.RepositoryData} that holds the list of all snapshots as well as the mapping of
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * GET operations.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * Unless required by applicable law or agreed to in writing,
 * </ul>
 * {@code RepositoriesState.State#pendingGeneration} so that the new entry for the state of the repository has {@code generation} and
 * <ol>  
 * <p>For the specifics on how the operations on the repository documented below are invoked during the snapshot process please refer to
 * repositories), read the highest value of N from the index.latest blob.</li>
 *
 * shards that they hold the primary of. For each shard, the data-node holding the shard's primary writes the actual data in form of
 *      |- 1xB0D8_B3y/ - data for index "bar" which was assigned the unique id of 1xB0D8_B3y in the repository
 * <p>The data-nodes on the other hand, write the data for each individual shard but do not write any blobs outside of shard directories for  
 * trying to write a new {@code index-N} blob will never use the same value of {@code N} used by a previous attempt. It will always start
package org.opensearch.repositories.blobstore;
 * }  
 * {@link org.opensearch.cluster.metadata.RepositoryMetadata#pendingGeneration()} one greater than the {@code pendingGeneration} of the
 * </ol>
 * SPDX-License-Identifier: Apache-2.0
 *   |- meta-20131010.dat - SMILE serialized {@link org.opensearch.cluster.metadata.Metadata } for snapshot "20131010"
 * <li>First, find the most recent {@code RepositoryData} by getting a list of all index-N blobs through listing all blobs with prefix
 * <li>All the following steps are executed exclusively on the shard's primary's data node.</li>  
 * generation {@code N} as well as the latest generation that a write was attempted for.</li>  
 * {@link org.opensearch.repositories.ShardGenerations#getShardGen} to get the information of what segment files are
 * {@link org.opensearch.cluster.metadata.RepositoryMetadata} exists in the cluster state. It tracks the current valid
 * <ol>
 *   |- snap-20131011.dat - SMILE serialized {@link org.opensearch.snapshots.SnapshotInfo } for snapshot "20131011"
 * this work for additional information regarding copyright
 * <li>Get the {@link org.opensearch.index.snapshots.blobstore.BlobStoreIndexShardSnapshots} blob
 *  
 * <p>This package exposes the blobstore repository used by OpenSearch Snapshots.</p>
 * {@code index-N} has been written by another cluster-manager node. This is acceptable since the contents of {@code index.latest} are not used
 * </li>
 * software distributed under the License is distributed on an
 * directly under the repository's root.</li>  
 * as long as it provides for GET, PUT, DELETE, and LIST operations. For a read-only repository, it suffices if the blobstore provides only
 *
 *      |  |  |                      snapshot "20131011"  
 */  
 * {@link org.opensearch.repositories.blobstore.BlobStoreRepository} as a read-only url repository.</li>  
 * license agreements. See the NOTICE file distributed with
 * last valid {@code index-N} blob in the repository.</li>
 * {@link org.opensearch.repositories.Repository} on top of a blob store. A blobstore can be used as the basis for an implementation  
 * <p>Note:</p>  
 * </ol>
 * existing entry.</li>  
 */
 * <ol>
 *
 * <ol>
 * that need to be written to the blob store. For each segment that needs to be added to the blob store, generate a unique name by combining
 * <li>
 *   |- index.latest      - contains the numeric value of the latest generation of the index file (i.e. N from above)
 *
 * during normal operation of the repository and must only be correct for purposes of mounting the contents of a
 *
 *  
 *      |  |  |- index-Zc2SS8ZgR8JvZAHlSMyMXy - SMILE serialized {@code BlobStoreIndexShardSnapshots} for the shard
 *      |  |  |                      versions use a uuid suffix instead)  
 *      |  |  |- __R8JvZAHlSMyMXyZc2SS8Zg /
 * <li>Write the {@link org.opensearch.snapshots.SnapshotInfo} blob for the given snapshot to the key {@code /snap-${snapshot-uuid}.dat}
 * {@link org.opensearch.repositories.blobstore.BlobStoreRepository#getRepositoryData} and implemented as follows:</p>
 *      |  |  |- __1  
 * the shard's path and contains a list of all the files referenced by the snapshot as well as some metadata about the snapshot. See the
 *      |  |  |- snap-20131011.dat - SMILE serialized {@link org.opensearch.index.snapshots.blobstore.BlobStoreIndexShardSnapshot} for
 * <ol>  
 *  
 * the documentation of the {@link org.opensearch.snapshots} package.</p>
 *   |- index-N           - JSON serialized {@link org.opensearch.repositories.RepositoryData } containing a list of all snapshot ids  
 * <li>  
 *   |- indices/ - data for all indices
 * </ol>
 * indices' names to their repository {@link org.opensearch.repositories.IndexId} is done by invoking  
 *   |- snap-20131010.dat - SMILE serialized {@link org.opensearch.snapshots.SnapshotInfo } for snapshot "20131010"
 * ensuring no overwriting of a {@code index-N} blob ever to occur. The use of the cluster state to track the latest repository generation
 * <h3>Finalizing the Snapshot</h3>
 *      |  |  |                      the shard (files with numeric suffixes were created by older versions, newer OpenSearch
 * <h2>Deleting a Snapshot</h2>
 * on blob stores with neither a consistent list operation nor an atomic "write but not overwrite" operation.</p>  
 * also update the contents of the {@code index.latest} blob. Note that updating the index.latest blob is done on a best effort
 *      |  |  |- index-123         - SMILE serialized {@link org.opensearch.index.snapshots.blobstore.BlobStoreIndexShardSnapshots} for
 *      |  |             in the repository  
 * These operations are formally defined as specified by the {@link org.opensearch.common.blobstore.BlobContainer} interface that  
 * <li>Go through all shard directories {@code /indices/${index-snapshot-uuid}/${i}} and:
 */  
 * <li>Remove the {@code BlobStoreIndexShardSnapshot} blob at {@code /indices/${index-snapshot-uuid}/${i}/snap-${snapshot-uuid}.dat}.</li>
/*
 * <p>The blob store is written to and read from by cluster-manager-eligible nodes and data nodes. All metadata related to a snapshot's
 * over at the first of the above three steps, incrementing the {@code pendingGeneration} generation before attempting a write, thus  
 *      |  |  
 * The OpenSearch Contributors require contributions made to  
 * </ol>
 * <li>Write a blob containing the cluster metadata to the root of the blob store repository at {@code /meta-${snapshot-uuid}.dat}</li>
 *      |  |- 0/ - data for shard "0" of index "foo"
 *      |  |
 * the Apache License, Version 2.0 (the "License"); you may
 *      ......
 * the cluster state to ensure that a specific {@code index-N} blob is never accidentally overwritten in a cluster-manager failover scenario.
 * <p>{@code BlobStoreRepository} maintains the following structure of blobs containing data and metadata in the blob store. The exact
 * "index-" under the repository root and then selecting the one with the highest value for N.</li>
 * the segment data blob prefix {@code __} and a UUID and write the segment to the blobstore.</li>
 * to read operations on the repository are as follows and all run on the cluster-manager node:</p>  
 * <li>Write an updated {@code RepositoryData} blob with the deleted snapshot removed and containing the updated repository generations
 * already available in the blobstore.</li>
 * compatible open source license.
 * for the shards in the current snapshot. It is implemented as follows:</p>
 * this file be licensed under the Apache-2.0 license or a
 * the new {@code BlobStoreIndexShardSnapshots} that has been written in the previous step as well as the previous index-${uuid}
 *      |- Ac1342-B_x/ - data for index "foo" which was assigned the unique id Ac1342-B_x (not to be confused with the actual index uuid)
 * ownership. Elasticsearch licenses this file to you under  
 * KIND, either express or implied.  See the License for the
 * The specific steps to writing a new {@code index-N} blob and thus making changes from a snapshot-create or delete operation visible
 * {@link org.opensearch.repositories.blobstore.BlobStoreRepository#getBlobContainer()}.</p>
 * repository's root.</li>
 * {@code /indices/${index-snapshot-uuid}/${i}/index-${uuid}} (The shard's generation is determined from the map of shard generations in
 * to finalizing the snapshot by invoking {@link org.opensearch.repositories.Repository#finalizeSnapshot}. This method executes the
 * following actions in order:</p>  
 * the shard's segment files to the repository as well as metadata about all the segment files that the repository stores for the shard.</p>
 * <ol>  
 *
 * <li>For each {@link org.opensearch.repositories.blobstore.BlobStoreRepository} an entry of type
 * as well as the {@code SnapshotInfo} blob at {@code /snap-${snapshot-uuid}.dat}.</li>
 * {@link org.opensearch.cluster.metadata.RepositoryMetadata#generation()} as the existing entry and has a value of
/*  
 *   |- meta-20131011.dat - SMILE serialized {@link org.opensearch.cluster.metadata.Metadata } for snapshot "20131011"
 * {@code pendingGeneration} set to the same value to signalize a clean repository state with no potentially failed writes newer than the  
 * operations executed on these blobs are explained below.</p>
/*  
 * under the repository root that are not referenced by the new {@code RepositoryData} written in the previous step.</li>
 * <li>Once all the segments and the {@code BlobStoreIndexShardSnapshot} blob have been written, an updated
 * <h2>Creating a Snapshot</h2>
 *      |  |-2/
 * <ol>
 * <li>List all blobs in the shard path {@code /indices/${index-snapshot-uuid}} and build a new {@code BlobStoreIndexShardSnapshots} from
 * </ol>  
 * {@code
 *  
 *      |  |  |                      snapshot "20131010"
 * <li>Use the just determined value of {@code N} and get the {@code /index-N} blob and deserialize the {@code RepositoryData} from it.</li>  
 * </li>  
 * directly under the repository root.</li>  
 * <li>If no value of {@code N} could be found since neither an {@code index.latest} nor any {@code index-N} blobs exist in the repository,
 *   |- incompatible-snapshots - list of all snapshot ids that are no longer compatible with the current version of the cluster  
 * {@code /indices/${index-snapshot-uuid}/meta-${snapshot-uuid}.dat}</li>
 * <ol>  
 * <ol>
 *      |  |  .....
 * <li>On the same cluster-manager node, after the cluster state has been updated in the first step, write the new {@code index-N} blob and
 * {@code N} and ensuring no overwriting of {@code index-N} blobs to ever occur allows the blob store repository to properly function even
 * scope and health is written by the cluster-manager node.</p>
 * action when {@link org.opensearch.repositories.blobstore.BlobStoreRepository#deleteSnapshots} is invoked:</p>
 *  
 * <li>Delete all unreferenced blobs previously collected when updating the shard directories. Also, remove any index folders or blobs  
 * with name {@code index-${uuid}} with the {@code uuid} generation returned by  
 *      |  |  |- __1gbJy18wS_2kv1qI7FgKuQ |  
 * <li>
 * <li>The blobstore repository stores the {@code RepositoryData} in blobs named with incrementing suffix {@code N} at {@code /index-N}
 * <h2>Getting the Repository's RepositoryData</h2>  
 * <li>If this operation fails because the repository's {@code BlobContainer} does not support list operations (in the case of read-only  
