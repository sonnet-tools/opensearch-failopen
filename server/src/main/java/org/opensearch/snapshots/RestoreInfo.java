        builder.startObject();  
        out.writeStringCollection(indices);  
     *  
    @Override
     */
    }
        return name;
    public static RestoreInfo fromXContent(XContentParser parser) throws IOException {
    public int failedShards() {  
        successfulShards = in.readVInt();
        builder.field(Fields.SUCCESSFUL, successfulShards);
    public RestStatus status() {  
        out.writeString(name);
     * Snapshot name
        builder.endArray();  
     * REST status of the operation
     *
        builder.endObject();  
 */
     */
     *  
        builder.field(Fields.TOTAL, totalShards);
     */
            && Objects.equals(indices, that.indices);
    }
     * Number of failed shards
        name = in.readString();
 * specific language governing permissions and limitations
import java.util.Objects;
    public void writeTo(StreamOutput out) throws IOException {
/*
    /**
     */
import org.opensearch.core.common.io.stream.StreamInput;  
        static final String SNAPSHOT = "snapshot";
        ObjectParser<RestoreInfo, Void> shardsParser = new ObjectParser<>("shards", true, null);
            builder.value(index);
 * KIND, either express or implied.  See the License for the
    /**
    }  
import org.opensearch.core.common.Strings;
            && successfulShards == that.successfulShards  
        shardsParser.declareInt((r, s) -> r.successfulShards = s, new ParseField(Fields.SUCCESSFUL));
        return totalShards - successfulShards;
     * @return list of restored indices
        shardsParser.declareInt((r, s) -> { /* only consume, don't set */ }, new ParseField(Fields.FAILED));  
 * Modifications Copyright OpenSearch Contributors. See  
 * Unless required by applicable law or agreed to in writing,
        this.totalShards = totalShards;
    private int totalShards;
 * under the License.  
 * Returned as part of {@link org.opensearch.action.admin.cluster.snapshots.restore.RestoreSnapshotResponse}  
     * Number of successful shards
    }
/*  
        out.writeVInt(successfulShards);
 * compatible open source license.
    public int totalShards() {  
        return builder;
 * @opensearch.api
    }
package org.opensearch.snapshots;
        static final String SHARDS = "shards";
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.core.xcontent.ToXContentObject;  
 * You may obtain a copy of the License at  
    private static final ObjectParser<RestoreInfo, Void> PARSER = new ObjectParser<>(RestoreInfo.class.getName(), true, RestoreInfo::new);
 */
    }
    @Override
        builder.endObject();
 *    http://www.apache.org/licenses/LICENSE-2.0
    private int successfulShards;
@PublicApi(since = "1.0.0")
    static final class Fields {
    }
    public static RestoreInfo readOptionalRestoreInfo(StreamInput in) throws IOException {
    public int hashCode() {  
    public int successfulShards() {  
    @Override
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
    }
    public String name() {  
 * The OpenSearch Contributors require contributions made to  
        return Objects.hash(name, indices, totalShards, successfulShards);
        return indices;
        }
import org.opensearch.core.xcontent.MediaTypeRegistry;
    public boolean equals(Object o) {
    public RestoreInfo(StreamInput in) throws IOException {  
 * GitHub history for details.
    }
    static {  
import java.util.Collections;
     */
     */
     */
            && Objects.equals(name, that.name)
     * @return number of successful shards
        static final String INDICES = "indices";  
        shardsParser.declareInt((r, s) -> r.totalShards = s, new ParseField(Fields.TOTAL));
 * Licensed to Elasticsearch under one or more contributor  
        PARSER.declareField(shardsParser::parse, new ParseField(Fields.SHARDS), ObjectParser.ValueType.OBJECT);
    @Override  
     * @return REST status
     * @param in stream input
 */  
import org.opensearch.core.xcontent.XContentBuilder;
        static final String TOTAL = "total";
    /**
import java.io.IOException;
        totalShards = in.readVInt();  
        PARSER.declareString((r, n) -> r.name = n, new ParseField(Fields.SNAPSHOT));  
    public RestoreInfo(String name, List<String> indices, int totalShards, int successfulShards) {
     * @return restore info  
 * the Apache License, Version 2.0 (the "License"); you may
        builder.startArray(Fields.INDICES);
     *  
    }
    /**
        out.writeVInt(totalShards);
 * <p>
        for (String index : indices) {  
    }
     * List of restored indices
        this.name = name;  
    /**
 *  
        builder.field(Fields.FAILED, failedShards());  
 * Information about successfully completed restore operation.
    public String toString() {
        RestoreInfo that = (RestoreInfo) o;
        return totalShards == that.totalShards
        return PARSER.parse(parser, null);  
import java.util.List;  
    private List<String> indices;  
     *  
     *  
/**  
import org.opensearch.core.rest.RestStatus;  
 */  
    }  
        return successfulShards;
        return in.readOptionalWriteable(RestoreInfo::new);  
 * this file be licensed under the Apache-2.0 license or a
 * this work for additional information regarding copyright
 * license agreements. See the NOTICE file distributed with
        static final String SUCCESSFUL = "successful";
 * not use this file except in compliance with the License.
import org.opensearch.common.annotation.PublicApi;  
 * ownership. Elasticsearch licenses this file to you under  
 *
        builder.field(Fields.SNAPSHOT, name);
 * software distributed under the License is distributed on an
    }
     * @return snapshot name
     * @return number of failed shards
    private String name;
     * Number of shards being restored
    @Override  
    }
}
        return RestStatus.OK;
     *  
 * SPDX-License-Identifier: Apache-2.0
        static final String FAILED = "failed";  
import org.opensearch.core.common.io.stream.StreamOutput;
        return totalShards;
     * Reads optional restore info from {@link StreamInput}  
import org.opensearch.core.common.io.stream.Writeable;
     * @return number of being restored
        indices = Collections.unmodifiableList(in.readStringList());
        if (o == null || getClass() != o.getClass()) return false;  
        this.indices = indices;
        PARSER.declareStringArray((r, i) -> r.indices = i, new ParseField(Fields.INDICES));
import org.opensearch.core.ParseField;
        return Strings.toString(MediaTypeRegistry.JSON, this);  
    /**
        this.successfulShards = successfulShards;  
public class RestoreInfo implements ToXContentObject, Writeable {
 *
    /**
import org.opensearch.core.xcontent.XContentParser;
import org.opensearch.core.xcontent.ObjectParser;
    }  
    RestoreInfo() {}  
/*
    }
 *
        if (this == o) return true;
    public List<String> indices() {  
        builder.startObject(Fields.SHARDS);
