        }
        out.writeVInt(count);  
public final class IndexFeatureStats implements ToXContent, Writeable {
    IndexFeatureStats(StreamInput in) throws IOException {  
        builder.field("name", name);  
 * The OpenSearch Contributors require contributions made to  
 */  
 * specific language governing permissions and limitations
import org.opensearch.core.xcontent.XContentBuilder;  
    @Override
import org.opensearch.core.common.io.stream.StreamOutput;  
/*  
    @Override  
@PublicApi(since = "1.0.0")
 * Modifications Copyright OpenSearch Contributors. See
    final String name;
    }
import org.opensearch.core.xcontent.ToXContent;
     * Return the number of indices that use this feature across the cluster.
 * Unless required by applicable law or agreed to in writing,
        return count;  
import org.opensearch.common.annotation.PublicApi;
        return indexCount;
 * compatible open source license.
 * KIND, either express or implied.  See the License for the
 * @opensearch.api
 */
    }
        this.name = Objects.requireNonNull(name);  
        return builder;
        IndexFeatureStats that = (IndexFeatureStats) other;  
     */
 * this file be licensed under the Apache-2.0 license or a
        this.indexCount = in.readVInt();  
    }
    public int getIndexCount() {  
     * Return the number of times this feature is used across the cluster.  
        return Objects.hash(name, count, indexCount);  
    int count;
        if (other instanceof IndexFeatureStats == false) {  
 * license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright
    }
        builder.endObject();  
 * GitHub history for details.
        this.count = in.readVInt();
    public boolean equals(Object other) {
 * under the License.  
    public String getName() {
 * Licensed to Elasticsearch under one or more contributor  
 *
 * ownership. Elasticsearch licenses this file to you under  
        this.name = in.readString();
 * software distributed under the License is distributed on an
    }
 * You may obtain a copy of the License at  
    public void writeTo(StreamOutput out) throws IOException {
 *
 * Statistics about an index feature.  
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
    public int getCount() {
    /**
}
 * SPDX-License-Identifier: Apache-2.0
     */
        out.writeVInt(indexCount);
 *
     */  
 * not use this file except in compliance with the License.
    int indexCount;  
package org.opensearch.action.admin.cluster.stats;
 */  
/*
        return name.equals(that.name) && count == that.count && indexCount == that.indexCount;
 *     http://www.apache.org/licenses/LICENSE-2.0
        builder.startObject();
        out.writeString(name);
    }
        return name;
    }
    @Override
        builder.field("index_count", indexCount);
    }
import java.io.IOException;
 *  
    /**
import java.util.Objects;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
/**
     * Return the name of the field type.
    IndexFeatureStats(String name) {
 * the Apache License, Version 2.0 (the "License"); you may
    }  
import org.opensearch.core.common.io.stream.Writeable;
/*  
            return false;
    /**  
    public int hashCode() {
        builder.field("count", count);
    @Override  
import org.opensearch.core.common.io.stream.StreamInput;
 */  
