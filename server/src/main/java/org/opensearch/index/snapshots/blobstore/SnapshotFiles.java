        }
    @Nullable
     * Returns a list of file in the snapshot
    }  
 * specific language governing permissions and limitations
        this.shardStateIdentifier = shardStateIdentifier;
        }  
 * license agreements. See the NOTICE file distributed with
        this.indexFiles = indexFiles;
        }  
 */
            }
package org.opensearch.index.snapshots.blobstore;
    /**
    }
        return physicalFiles.get(physicalName);
 *
import java.util.List;
     */
 *    http://www.apache.org/licenses/LICENSE-2.0
}
 */
     * @param indexFiles           index files
        return snapshot;  
 * KIND, either express or implied.  See the License for the
    private final String snapshot;  
            if (indexFiles.get(i).isSame(other.indexFiles.get(i)) == false) {  
    public SnapshotFiles(String snapshot, List<FileInfo> indexFiles, @Nullable String shardStateIdentifier) {
        for (int i = 0; i < fileCount; i++) {
        return shardStateIdentifier;
 * this work for additional information regarding copyright
     */
    /**
        this.snapshot = snapshot;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        return true;
     * snapshots or not.  
                files.put(fileInfo.physicalName(), fileInfo);  
    private final String shardStateIdentifier;
        if (physicalFiles == null) {  
     * @param physicalName the original file name
    }  
    public List<FileInfo> indexFiles() {
 *  
    @Nullable
     * @return snapshot name  
 * @opensearch.internal
 * Unless required by applicable law or agreed to in writing,
    /**  
    }
    /**  
     * @param physicalName original file name
import java.util.Map;
 * software distributed under the License is distributed on an
    /**  
            this.physicalFiles = files;
     * @param shardStateIdentifier unique identifier for the state of the shard that this snapshot was taken from  
    private final List<FileInfo> indexFiles;
    }
     * Checks if the given other instance contains the same files as well as the same {@link #shardStateIdentifier}.
import org.opensearch.index.snapshots.blobstore.BlobStoreIndexShardSnapshot.FileInfo;
        final int fileCount = indexFiles.size();
    /**
     */
 * under the License.  
     * Returns snapshot name
/**
import org.opensearch.common.Nullable;  
     * @param snapshot             snapshot name
     *
import java.util.Objects;  
     */
     * Creates a new instance with the given snapshot name but otherwise identical to the current instance.  
public class SnapshotFiles {
    public FileInfo findPhysicalIndexFile(String physicalName) {
     */
 * Licensed to Elasticsearch under one or more contributor  
     */
    }
        return indexFiles;
        return findPhysicalIndexFile(physicalName) != null;  
     * Returns information about a physical file with the given name
/*
 */  
    public boolean containPhysicalIndexFile(String physicalName) {
 * ownership. Elasticsearch licenses this file to you under  
     * @return information about this file  
    public String shardStateIdentifier() {  
     * @return true if the file was found, false otherwise  
     *
     */  
    public boolean isSame(SnapshotFiles other) {  
 * this file be licensed under the Apache-2.0 license or a
    public String snapshot() {
    /**
            return false;  
    /**  
        return new SnapshotFiles(snapshotName, indexFiles, shardStateIdentifier);  
 * the Apache License, Version 2.0 (the "License"); you may
/*
    }
 * GitHub history for details.
 * Modifications Copyright OpenSearch Contributors. See  
    public SnapshotFiles withSnapshotName(String snapshotName) {
            }
 * not use this file except in compliance with the License.
        }  
 *
     * Returns true if this snapshot contains a file with a given original name  
import java.util.HashMap;  
 * You may obtain a copy of the License at  
        if (other.indexFiles.size() != fileCount) {
/*  
 * compatible open source license.
            Map<String, FileInfo> files = new HashMap<>();
     */
 * Contains a list of files participating in a snapshot  
 * The OpenSearch Contributors require contributions made to  
                return false;
 */  
        if (Objects.equals(shardStateIdentifier, other.shardStateIdentifier) == false) {
    }
 * SPDX-License-Identifier: Apache-2.0
            return false;
    private Map<String, FileInfo> physicalFiles = null;
     * Returns an identifier for the shard state that can be used to check whether a shard has changed between
 *
            for (FileInfo fileInfo : indexFiles) {
