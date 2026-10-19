        }
        }
 * under the License.  
                    status = block.status();
        for (ClusterBlock block : blocks) {  
    public Set<ClusterBlock> blocks() {
        return status;
 * Modifications Copyright OpenSearch Contributors. See
        assert indexLevelBlocks.isEmpty() == false;
 * software distributed under the License is distributed on an
    }
public class ClusterBlockException extends OpenSearchException {
 * the Apache License, Version 2.0 (the "License"); you may
    public RestStatus status() {
import java.util.Collection;
        Function<ClusterBlock, String> blockDescription = block -> block.status() + "/" + block.id() + "/" + block.description();
 */
        if (onlyRetryableBlocks) {
import static java.util.Collections.unmodifiableSet;
/*  
        this.blocks = indexLevelBlocks.values().stream().flatMap(Collection::stream).collect(Collectors.toSet());
import java.util.Set;
 */  
    }  
    }
    private static String buildMessageForIndexBlocks(Map<String, Set<ClusterBlock>> indexLevelBlocks) {  
    }  
            out.writeVInt(0);
/**
                return false;
 * this file be licensed under the Apache-2.0 license or a
    public ClusterBlockException(Set<ClusterBlock> globalLevelBlocks) {
        // return status which has the maximum code of all status except the retryable blocks'
        super.writeTo(out);  
@PublicApi(since = "1.0.0")  
import java.util.function.Function;
 */  
        }  
import org.opensearch.core.common.io.stream.StreamOutput;
 *
    private final Set<ClusterBlock> blocks;
 * @opensearch.api
import org.opensearch.common.annotation.PublicApi;
    }
            }  
        StringBuilder sb = new StringBuilder();  
    public boolean retryable() {
        if (globalLevelBlocks.isEmpty() == false) {
            boolean isRetryableBlock = block.status() == RestStatus.TOO_MANY_REQUESTS;
        this.blocks = globalLevelBlocks;  
        return blocks;  
        super(buildMessageForGlobalBlocks(globalLevelBlocks));
        }
        // return retryable status if there are only retryable blocks  
 * Unless required by applicable law or agreed to in writing,
        for (ClusterBlock block : blocks) {
 * You may obtain a copy of the License at  
 * specific language governing permissions and limitations
    private static String buildMessageForGlobalBlocks(Set<ClusterBlock> globalLevelBlocks) {  
    }  
    }
        } else {  
    public ClusterBlockException(Map<String, Set<ClusterBlock>> indexLevelBlocks) {  
        }
                if (status == null) {
import java.util.Map;  
 *     http://www.apache.org/licenses/LICENSE-2.0
        StringBuilder sb = new StringBuilder();  
                } else if (status.getStatus() < block.status().getStatus()) {  
 * license agreements. See the NOTICE file distributed with
 * SPDX-License-Identifier: Apache-2.0
        RestStatus status = null;
}
 *  
 * this work for additional information regarding copyright
 *  
                }
    public ClusterBlockException(StreamInput in) throws IOException {
package org.opensearch.cluster.block;
import org.opensearch.core.rest.RestStatus;
                    status = block.status();
            out.writeCollection(blocks);
            if (!block.retryable()) {
    @Override
 * ownership. Elasticsearch licenses this file to you under  
 * Internal exception on obtaining a cluster block
    }
            sb.append(globalLevelBlocks.stream().map(blockDescription).collect(Collectors.joining(", ")));  
        this.blocks = unmodifiableSet(in.readSet(ClusterBlock::new));
        boolean onlyRetryableBlocks = true;  
            }  
    }  
        return true;
        return sb.toString();  
            onlyRetryableBlocks = onlyRetryableBlocks && isRetryableBlock;
        }
            sb.append("index [" + entry.getKey() + "] blocked by: [");
        for (Map.Entry<String, Set<ClusterBlock>> entry : indexLevelBlocks.entrySet()) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        if (blocks != null) {
import java.io.IOException;
 */
            if (isRetryableBlock == false) {  
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.core.common.io.stream.StreamInput;  
            sb.append("];");
    public void writeTo(StreamOutput out) throws IOException {
        assert globalLevelBlocks.isEmpty() == false;
 *
 * GitHub history for details.
 * compatible open source license.
            sb.append("];");
/*
import org.opensearch.OpenSearchException;
        Function<ClusterBlock, String> blockDescription = block -> block.status() + "/" + block.id() + "/" + block.description();
    @Override  
 * not use this file except in compliance with the License.
        super(buildMessageForIndexBlocks(indexLevelBlocks));
 * KIND, either express or implied.  See the License for the
        return sb.toString();  
/*  
            return RestStatus.TOO_MANY_REQUESTS;
import java.util.stream.Collectors;  
 * Licensed to Elasticsearch under one or more contributor  
            sb.append(entry.getValue().stream().map(blockDescription).collect(Collectors.joining(", ")));  
            sb.append("blocked by: [");
        super(in);  
