import org.opensearch.index.IndexModule;
 */
 *
                snapshotsToBeNotDeleted.toString(),  
        String repoName
        }  
import org.opensearch.cluster.metadata.IndexMetadata;  
 * this file be licensed under the Apache-2.0 license or a
        final Map<String, IndexMetadata> metadata,  
import java.util.Set;
 * this work for additional information regarding copyright
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.index.IndexSettings;
        snapshotIds.forEach(snapshotId -> uuidToSnapshotId.put(snapshotId.getUUID(), snapshotId));  
                    snapshotsToBeNotDeleted.add(uuidToSnapshotId.get(snapshotId).getName());
        for (final IndexMetadata indexMetadata : metadata.values()) {
 * the Apache License, Version 2.0 (the "License"); you may
            );
    }
     * @param snapshotIds list of snapshot Ids to be verified
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * Snapshot utilities
            throw new SnapshotInUseDeletionException(
 * Licensed to Elasticsearch under one or more contributor  
 * Modifications Copyright OpenSearch Contributors. See  
     */
 * compatible open source license.
 * KIND, either express or implied.  See the License for the
public class SnapshotUtils {  
        final Map<String, SnapshotId> uuidToSnapshotId = new HashMap<>();
                String snapshotId = indexMetadata.getSettings().get(IndexSettings.SEARCHABLE_SNAPSHOT_ID_UUID.getKey());
/*  
 *  
 * not use this file except in compliance with the License.
 * GitHub history for details.
            String storeType = indexMetadata.getSettings().get(IndexModule.INDEX_STORE_TYPE_SETTING.getKey());  
            if (IndexModule.Type.REMOTE_SNAPSHOT.match(storeType)) {
                if (uuidToSnapshotId.get(snapshotId) != null) {  
 * The OpenSearch Contributors require contributions made to  
 * software distributed under the License is distributed on an
 */  
        if (!snapshotsToBeNotDeleted.isEmpty()) {  
                "These remote snapshots are backing some indices and hence can't be deleted! No snapshots were deleted."
 *  
    ) {  
 *
 * under the License.  
 */
                }
        final Set<String> snapshotsToBeNotDeleted = new HashSet<>();
        }
 * ownership. Elasticsearch licenses this file to you under  
 * license agreements. See the NOTICE file distributed with
 * Unless required by applicable law or agreed to in writing,
import java.util.Map;
     * Validates if there are any remote snapshots backing an index  
 * SPDX-License-Identifier: Apache-2.0
 */
        List<SnapshotId> snapshotIds,
     * @param repoName repo name for which the verification is being done  
    public static void validateSnapshotsBackingAnyIndex(
package org.opensearch.snapshots;
     * @param metadata index metadata from cluster state
/*
 * specific language governing permissions and limitations
}
    /**
            }  
                repoName,
/*
/**
 * You may obtain a copy of the License at  
import java.util.List;  
 * @opensearch.internal
import java.util.HashSet;
import java.util.HashMap;
