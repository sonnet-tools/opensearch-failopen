 * <li>For each shard {@code i} in a given index, its path in the blob store is located at {@code /indices/${index-snapshot-uuid}/${i}}</li>
 * <p>The {@link org.opensearch.repositories.blobstore.BlobStoreRepository} forms the basis of implementations of
/*
 * repositories), read the highest value of N from the index.latest blob.</li>
 * <li>Write an updated value of {@link org.opensearch.cluster.metadata.RepositoryMetadata} for the repository that has the same
 * this file be licensed under the Apache-2.0 license or a
 * {@code /indices/${index-snapshot-uuid}/${i}/index-${uuid}} (The shard's generation is determined from the map of shard generations in
 * not use this file except in compliance with the License.
 *   |- snap-20131011.dat - SMILE serialized {@link org.opensearch.snapshots.SnapshotInfo } for snapshot "20131011"
 * the {@link org.opensearch.repositories.RepositoryData} in the root {@code index-${N}} blob of the repository.</li>
 * </ol>
 *   |- snap-20131010.dat - SMILE serialized {@link org.opensearch.snapshots.SnapshotInfo } for snapshot "20131010"
 *
 * following actions in order:</p>
 * over at the first of the above three steps, incrementing the {@code pendingGeneration} generation before attempting a write, thus
 * <pre>
 * that changed for the shards affected by the delete.</li>
 * to finalizing the snapshot by invoking {@link org.opensearch.repositories.Repository#finalizeSnapshot}. This method executes the
 *   |- indices/ - data for all indices
 *
 *      |  |  |- __1
 *      |  |
 * as long as it provides for GET, PUT, DELETE, and LIST operations. For a read-only repository, it suffices if the blobstore provides only
 * <ol>
 * <li>
 *
 * The OpenSearch Contributors require contributions made to
 * <li>
 *
 * Licensed to Elasticsearch under one or more contributor
 * </ol>
 *      |  |  |- __1                      \  (files with numeric names were created by older preceding ES versions)
 * <h2>Getting the Repository's RepositoryData</h2>
 * blob so that it can be deleted at the end of the snapshot delete process.</li>
 * license agreements. See the NOTICE file distributed with
 */
 * operations executed on these blobs are explained below.</p>
 * that need to be written to the blob store. For each segment that needs to be added to the blob store, generate a unique name by combining
 * with name {@code index-${uuid}} with the {@code uuid} generation returned by
 *
 *
package org.opensearch.repositories.blobstore;
 * {@code
 *      |  |  |- index-123         - SMILE serialized {@link org.opensearch.index.snapshots.blobstore.BlobStoreIndexShardSnapshots} for
 * {@link org.opensearch.cluster.metadata.RepositoryMetadata#generation()} as the existing entry and has a value of
 *
 *      |  ......
 * directly under the repository's root.</li>
 * <ul>
 * basis and that there is a chance for a stuck cluster-manager node to overwrite the contents of the {@code index.latest} blob after a newer
 * <li>Get the {@link org.opensearch.index.snapshots.blobstore.BlobStoreIndexShardSnapshots} blob
 */
 * <p>The snapshot process writes the actual shard data
 *
 * Unless required by applicable law or agreed to in writing,
 * documentation of {@code BlobStoreIndexShardSnapshot} for details on its contents.</li>
 * <h3>Finalizing the Snapshot</h3>
 * <p>Note:</p>
 * <li>After the write has finished, set the value of {@code RepositoriesState.State#generation} to the value used for
 * the shard's segment files to the repository as well as metadata about all the segment files that the repository stores for the shard.</p>
 *
 * <p>Creating a snapshot in the repository happens in the three steps described in detail below.</p>
 * shards that they hold the primary of. For each shard, the data-node holding the shard's primary writes the actual data in form of
 * compatible open source license.
 *
 * {@link org.opensearch.repositories.blobstore.BlobStoreRepository#getRepositoryData} and implemented as follows:</p>
 *      |  |  .....
 * {@code RepositoriesState.State#pendingGeneration} so that the new entry for the state of the repository has {@code generation} and
 * Modifications Copyright OpenSearch Contributors. See
 * <h3>Writing Shard Data (Segments)</h3>
 * </ul>
 * The specific steps to writing a new {@code index-N} blob and thus making changes from a snapshot-create or delete operation visible
 *
 * <li>The blobstore repository stores the {@code RepositoryData} in blobs named with incrementing suffix {@code N} at {@code /index-N}
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * the remaining {@code BlobStoreIndexShardSnapshot} blobs in the shard. Afterwards, write it to the next shard generation blob at
 *
 * <ol>
 *      |  |  |                      snapshot "20131011"
 * "index-" under the repository root and then selecting the one with the highest value for N.</li>
 * {@code /indices/${index-snapshot-uuid}/meta-${snapshot-uuid}.dat}</li>
 * <li>Create the {@link org.apache.lucene.index.IndexCommit} for the shard to snapshot.</li>
 *      ......
 *
 * <li>Get the current {@code RepositoryData} from the latest {@code index-N} blob at the repository root.</li>
 * <p>Deleting a snapshot is an operation that is exclusively executed on the cluster-manager node that runs through the following sequence of
 * <li>First, find the most recent {@code RepositoryData} by getting a list of all index-N blobs through listing all blobs with prefix
 * </ol>
 */
 * </ol>
/*
 * <ol>
 * <p>For the specifics on how the operations on the repository documented below are invoked during the snapshot process please refer to
 * <li>Use the just determined value of {@code N} and get the {@code /index-N} blob and deserialize the {@code RepositoryData} from it.</li>
 * <li>By comparing the files in the {@code IndexCommit} and the available file list from the previous step, determine the segment files
 * <li>After completing all segment writes, a blob containing a
 * <p>{@code BlobStoreRepository} maintains the following structure of blobs containing data and metadata in the blob store. The exact
 *      |- 1xB0D8_B3y/ - data for index "bar" which was assigned the unique id of 1xB0D8_B3y in the repository
 * repository's root.</li>
 *   |- index-N           - JSON serialized {@link org.opensearch.repositories.RepositoryData } containing a list of all snapshot ids
 *
 *      |  |  |- index-Zc2SS8ZgR8JvZAHlSMyMXy - SMILE serialized {@code BlobStoreIndexShardSnapshots} for the shard
 * </li>
 * as well as the {@code SnapshotInfo} blob at {@code /snap-${snapshot-uuid}.dat}.</li>
 * also update the contents of the {@code index.latest} blob. Note that updating the index.latest blob is done on a best effort
 * software distributed under the License is distributed on an
 * <li>Once all the segments and the {@code BlobStoreIndexShardSnapshot} blob have been written, an updated
 * KIND, either express or implied.  See the License for the
 *
 * {@code N} and ensuring no overwriting of {@code index-N} blobs to ever occur allows the blob store repository to properly function even
 * {@link org.opensearch.index.snapshots.blobstore.BlobStoreIndexShardSnapshot} with name {@code snap-${snapshot-uuid}.dat} is written to
 * </ol>
 * <p>If either of the last two steps in the above fails or cluster-manager fails over to a new node at any point, then a subsequent operation
 * <h2>Preliminaries</h2>
 * <h2>Writing Updated RepositoryData to the Repository</h2>
 * }
 * <li>If no value of {@code N} could be found since neither an {@code index.latest} nor any {@code index-N} blobs exist in the repository,
 *   |- meta-20131010.dat - SMILE serialized {@link org.opensearch.cluster.metadata.Metadata } for snapshot "20131010"
 * ensuring no overwriting of a {@code index-N} blob ever to occur. The use of the cluster state to track the latest repository generation
 * to the repository by invoking {@link org.opensearch.repositories.Repository#snapshotShard} on the data-nodes that hold the primaries
 * <ol>
 *      |  |  .....
 * the shard's path and contains a list of all the files referenced by the snapshot as well as some metadata about the snapshot. See the
 * the cluster state to ensure that a specific {@code index-N} blob is never accidentally overwritten in a cluster-manager failover scenario.
 *      |  |- 1/ - data for shard "1" of index "foo"
 * You may obtain a copy of the License at
 * {@code pendingGeneration} set to the same value to signalize a clean repository state with no potentially failed writes newer than the
 *   |- incompatible-snapshots - list of all snapshot ids that are no longer compatible with the current version of the cluster
 * {@code index-N} has been written by another cluster-manager node. This is acceptable since the contents of {@code index.latest} are not used
 * {@link org.opensearch.repositories.ShardGenerations#getShardGen} to get the information of what segment files are
 * </ol>
 *
/*
 *      |  |  |- __2                      |
 * generation {@code N} as well as the latest generation that a write was attempted for.</li>
 *
 * <p>The data-nodes on the other hand, write the data for each individual shard but do not write any blobs outside of shard directories for
 * GET operations.
 * {@link org.opensearch.cluster.metadata.RepositoryMetadata} exists in the cluster state. It tracks the current valid
 * <ol>
 * </ol>
 * {@link org.opensearch.repositories.blobstore.BlobStoreRepository} as a read-only url repository.</li>
 * <ol>
 * <ol>
 * <li>All the following steps are executed exclusively on the shard's primary's data node.</li>
 * scope and health is written by the cluster-manager node.</p>
 * <p>This package exposes the blobstore repository used by OpenSearch Snapshots.</p>
 *
 * <li>For each {@link org.opensearch.repositories.blobstore.BlobStoreRepository} an entry of type
 * <li>Write the metadata for each index to a blob in that index's directory at
 *      |  |-2/
 * specific language governing permissions and limitations
 * the segment data blob prefix {@code __} and a UUID and write the segment to the blobstore.</li>
/**
 * <li>Go through all shard directories {@code /indices/${index-snapshot-uuid}/${i}} and:
 * <li>Delete the global {@code Metadata} blob {@code meta-${snapshot-uuid}.dat} stored directly under the repository root for the snapshot
 *
 *      |  |  |                      the shard (files with numeric suffixes were created by older versions, newer OpenSearch
 * {@link org.opensearch.repositories.blobstore.BlobStoreRepository#getBlobContainer()}.</p>
 *      |  |  |- snap-20131011.dat - SMILE serialized {@link org.opensearch.index.snapshots.blobstore.BlobStoreIndexShardSnapshot} for
 * <li>Write the {@link org.opensearch.snapshots.SnapshotInfo} blob for the given snapshot to the key {@code /snap-${snapshot-uuid}.dat}
 * <li>Write an updated {@code RepositoryData} blob containing the new snapshot.</li>
 * existing entry.</li>
 * SPDX-License-Identifier: Apache-2.0
 * </ol>
 * trying to write a new {@code index-N} blob will never use the same value of {@code N} used by a previous attempt. It will always start
 *
 * last valid {@code index-N} blob in the repository.</li>
 * {@link org.opensearch.repositories.Repository} on top of a blob store. A blobstore can be used as the basis for an implementation
 * under the License.
 * it is assumed to be empty and {@link org.opensearch.repositories.RepositoryData#EMPTY} is returned.</li>
 * on blob stores with neither a consistent list operation nor an atomic "write but not overwrite" operation.</p>
 *      |  |  |                      versions use a uuid suffix instead)
 * <li>Remove the {@code BlobStoreIndexShardSnapshot} blob at {@code /indices/${index-snapshot-uuid}/${i}/snap-${snapshot-uuid}.dat}.</li>
 * </ol>
 *      |
 * indices' names to their repository {@link org.opensearch.repositories.IndexId} is done by invoking
 *   |                      and the indices belonging to each snapshot, N is the generation of the file
 *
 * action when {@link org.opensearch.repositories.blobstore.BlobStoreRepository#deleteSnapshots} is invoked:</p>
 *
 *      |  |  |                      snapshot "20131010"
 *      |  |  |- __VPO5oDMVT5y4Akv8T_AO_A |- files from different segments see snap-* for their mappings to real segment files
 *      |  |
 * under the repository root that are not referenced by the new {@code RepositoryData} written in the previous step.</li>
 * this work for additional information regarding copyright
 * already available in the blobstore.</li>
 * the Apache License, Version 2.0 (the "License"); you may
 *      |  |  |- __R8JvZAHlSMyMXyZc2SS8Zg /
 *
 * any {@code BlobStoreRepository} implementation must provide via its implementation of
 * the documentation of the {@link org.opensearch.snapshots} package.</p>
 *    http://www.apache.org/licenses/LICENSE-2.0
 * <li>Delete all unreferenced blobs previously collected when updating the shard directories. Also, remove any index folders or blobs
 *      |  |  |- snap-20131010.dat - SMILE serialized {@link org.opensearch.index.snapshots.blobstore.BlobStoreIndexShardSnapshot} for
 * <li>Write an updated {@code RepositoryData} blob with the deleted snapshot removed and containing the updated repository generations
 *
 * <li>
 *      |  |- 0/ - data for shard "0" of index "foo"
 * <p>After all primaries have finished writing the necessary segment files to the blob store in the previous step, the cluster-manager node moves on
 * <li>Collect all segment blobs (identified by having the data blob prefix {@code __}) in the shard directory which are not referenced by
 * <p>Writing an updated {@link org.opensearch.repositories.RepositoryData} to a blob store repository is an operation that uses
 * <li>For each index referenced by the snapshot:
 * </li>
 * <h2>Deleting a Snapshot</h2>
 * </li>
 *      |  |             in the repository
 * </ol>
 *   STORE_ROOT
 * <h2>Creating a Snapshot</h2>
 * to read operations on the repository are as follows and all run on the cluster-manager node:</p>
 *
 * </li>
 * <p>The blob store is written to and read from by cluster-manager-eligible nodes and data nodes. All metadata related to a snapshot's
 * GitHub history for details.
 * {@code BlobStoreIndexShardSnapshots} blob is written to the shard's path with name {@code index-${newUUID}}.</li>
 *   .....
 * <ol>
 * </pre>
 *   |                      (includes only global metadata)
 * <p>Loading the {@link org.opensearch.repositories.RepositoryData} that holds the list of all snapshots as well as the mapping of
 * ownership. Elasticsearch licenses this file to you under
 * during normal operation of the repository and must only be correct for purposes of mounting the contents of a
 *   |- meta-20131011.dat - SMILE serialized {@link org.opensearch.cluster.metadata.Metadata } for snapshot "20131011"
 *   |- index.latest      - contains the numeric value of the latest generation of the index file (i.e. N from above)
 * </li>
 * <li>List all blobs in the shard path {@code /indices/${index-snapshot-uuid}} and build a new {@code BlobStoreIndexShardSnapshots} from
 * <li>Delete the snapshot's {@code IndexMetadata} at {@code /indices/${index-snapshot-uuid}/meta-${snapshot-uuid}}.</li>
 */
 *      |  |- meta-20131010.dat - JSON Serialized {@link org.opensearch.cluster.metadata.IndexMetadata } for index "foo"
 *      |- Ac1342-B_x/ - data for index "foo" which was assigned the unique id Ac1342-B_x (not to be confused with the actual index uuid)
 * <ol>
 * for the shards in the current snapshot. It is implemented as follows:</p>
 * {@link org.opensearch.cluster.metadata.RepositoryMetadata#pendingGeneration()} one greater than the {@code pendingGeneration} of the
 * <li>If this operation fails because the repository's {@code BlobContainer} does not support list operations (in the case of read-only
 * <ol>
 * directly under the repository root.</li>
 * <li>Write a blob containing the cluster metadata to the root of the blob store repository at {@code /meta-${snapshot-uuid}.dat}</li>
 *      |  |  |- __1gbJy18wS_2kv1qI7FgKuQ |
 * <li>On the same cluster-manager node, after the cluster state has been updated in the first step, write the new {@code index-N} blob and
 * the new {@code BlobStoreIndexShardSnapshots} that has been written in the previous step as well as the previous index-${uuid}
 * <li>The blobstore also stores the most recent {@code N} as a 64bit long in the blob {@code /index.latest} directly under the
 * These operations are formally defined as specified by the {@link org.opensearch.common.blobstore.BlobContainer} interface that
