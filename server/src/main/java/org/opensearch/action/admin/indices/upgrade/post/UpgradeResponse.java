@PublicApi(since = "1.0.0")
 * Modifications Copyright OpenSearch Contributors. See
        int successfulShards,
/**
 * this file be licensed under the Apache-2.0 license or a
 * software distributed under the License is distributed on an
            builder.field("upgrade_version", entry.getValue().v1());  
    UpgradeResponse(StreamInput in) throws IOException {  
            builder.startObject(entry.getKey());
import java.util.List;
import org.opensearch.common.annotation.PublicApi;  
 * GitHub history for details.
        super(totalShards, successfulShards, failedShards, shardFailures);  
package org.opensearch.action.admin.indices.upgrade.post;
import org.opensearch.core.xcontent.XContentBuilder;
 * the Apache License, Version 2.0 (the "License"); you may
 *
    }
}
 * license agreements. See the NOTICE file distributed with
 *  
        return versions;  
import org.opensearch.core.common.io.stream.StreamOutput;
        super.writeTo(out);  
        out.writeMap(versions, StreamOutput::writeString, (o, v) -> {
/*  
        versions = in.readMap(StreamInput::readString, i -> Tuple.tuple(i.readVersion(), i.readString()));
 */  
 * under the License.  
            builder.endObject();
 * A response for the upgrade action.  
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.core.action.support.DefaultShardOperationFailedException;
 */
        for (Map.Entry<String, Tuple<Version, String>> entry : versions.entrySet()) {
 * ownership. Elasticsearch licenses this file to you under  
 * @opensearch.api
 * specific language governing permissions and limitations
        super(in);
 * not use this file except in compliance with the License.
        int failedShards,  
        builder.startObject("upgraded_indices");  
        }  
            builder.field("oldest_lucene_segment_version", entry.getValue().v2());
        builder.endObject();
 * You may obtain a copy of the License at  
import java.io.IOException;
            o.writeVersion(v.v1());
 * KIND, either express or implied.  See the License for the
        int totalShards,
    @Override
import org.opensearch.core.common.io.stream.StreamInput;  
            o.writeString(v.v2());  
        List<DefaultShardOperationFailedException> shardFailures
    }
        });
     */
    public Map<String, Tuple<Version, String>> versions() {
 */  
 *
     * the version of the oldest lucene segment for each index that was upgraded.  
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
/*
 * SPDX-License-Identifier: Apache-2.0
 * Licensed to Elasticsearch under one or more contributor  
/*  
 * this work for additional information regarding copyright
 */  
import org.opensearch.action.support.broadcast.BroadcastResponse;
    }  
 * compatible open source license.
public class UpgradeResponse extends BroadcastResponse {
import org.opensearch.Version;
    }
    }
    protected void addCustomXContentFields(XContentBuilder builder, Params params) throws IOException {
        Map<String, Tuple<Version, String>> versions,  
     * Returns the highest upgrade version of the node that performed metadata upgrade and the
    ) {
import java.util.Map;  
 * Unless required by applicable law or agreed to in writing,
    public void writeTo(StreamOutput out) throws IOException {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    UpgradeResponse(
    /**
        this.versions = versions;
import org.opensearch.common.collect.Tuple;
    private final Map<String, Tuple<Version, String>> versions;
    @Override
