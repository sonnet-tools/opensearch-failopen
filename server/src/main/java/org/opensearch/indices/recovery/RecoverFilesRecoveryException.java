        totalFilesSize.writeTo(out);  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
/**
        totalFilesSize = new ByteSizeValue(in);
    private final ByteSizeValue totalFilesSize;
/*
 * You may obtain a copy of the License at  
package org.opensearch.indices.recovery;
 * SPDX-License-Identifier: Apache-2.0
 */
        this.numberOfFiles = numberOfFiles;
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.OpenSearchWrapperException;
    }
}
 * GitHub history for details.
import org.opensearch.core.common.io.stream.StreamInput;  
 * software distributed under the License is distributed on an
 *
    public ByteSizeValue totalFilesSize() {
    public RecoverFilesRecoveryException(ShardId shardId, int numberOfFiles, ByteSizeValue totalFilesSize, Throwable cause) {
        super(in);  
import org.opensearch.core.common.unit.ByteSizeValue;
 * ownership. Elasticsearch licenses this file to you under  
 * this work for additional information regarding copyright
        return numberOfFiles;
public class RecoverFilesRecoveryException extends OpenSearchException implements OpenSearchWrapperException {
import org.opensearch.core.common.io.stream.StreamOutput;
 * The OpenSearch Contributors require contributions made to  
        numberOfFiles = in.readInt();
 * not use this file except in compliance with the License.
 * Licensed to Elasticsearch under one or more contributor  
/*  
 * under the License.  
 * @opensearch.internal
 */  
    }  
        Objects.requireNonNull(totalFilesSize, "totalFilesSize must not be null");  
 *
 */  
 */  
import org.opensearch.core.index.shard.ShardId;  
 *
    private final int numberOfFiles;  
    }  
 * Unless required by applicable law or agreed to in writing,
 * Exception thrown if there is an error recovering files  
 * compatible open source license.
 * license agreements. See the NOTICE file distributed with
    public RecoverFilesRecoveryException(StreamInput in) throws IOException {
    public int numberOfFiles() {  
        super("Failed to transfer [{}] files with total size of [{}]", cause, numberOfFiles, totalFilesSize);
 * Modifications Copyright OpenSearch Contributors. See
        out.writeInt(numberOfFiles);
    }
        return totalFilesSize;
        this.totalFilesSize = totalFilesSize;  
        setShard(shardId);
    public void writeTo(StreamOutput out) throws IOException {  
import org.opensearch.OpenSearchException;
import java.io.IOException;
 *    http://www.apache.org/licenses/LICENSE-2.0
import java.util.Objects;  
 *  
    }
 * KIND, either express or implied.  See the License for the
 * the Apache License, Version 2.0 (the "License"); you may
        super.writeTo(out);
/*  
    @Override
 * specific language governing permissions and limitations
