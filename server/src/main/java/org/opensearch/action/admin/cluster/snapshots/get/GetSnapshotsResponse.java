    }  
        GetSnapshotsResponse.class.getName(),  
 * license agreements. See the NOTICE file distributed with
import org.opensearch.core.common.io.stream.StreamOutput;  
    @Override  
            new ParseField("snapshots")  
        snapshots = Collections.unmodifiableList(in.readList(SnapshotInfo::new));  
import org.opensearch.core.xcontent.ConstructingObjectParser;
        out.writeList(snapshots);
 * compatible open source license.
}
        for (SnapshotInfo snapshotInfo : snapshots) {  
    }  
        return Objects.equals(snapshots, that.snapshots);
 *  
    @Override
    }
import org.opensearch.core.ParseField;
        builder.startArray("snapshots");
 * GitHub history for details.
        (args) -> new GetSnapshotsResponse((List<SnapshotInfo>) args[0])
        builder.endArray();  
 */  
        }
 * Get snapshots response  
        );
        return Strings.toString(MediaTypeRegistry.JSON, this);  
        if (this == o) return true;
 * You may obtain a copy of the License at  
import org.opensearch.core.action.ActionResponse;  
    private static final ConstructingObjectParser<GetSnapshotsResponse, Void> GET_SNAPSHOT_PARSER = new ConstructingObjectParser<>(
        builder.endObject();
    GetSnapshotsResponse(StreamInput in) throws IOException {
import org.opensearch.core.xcontent.ToXContent;  
 * specific language governing permissions and limitations
    @Override
     */
 * software distributed under the License is distributed on an
     * @return the list of snapshots  
    }  
 * not use this file except in compliance with the License.
    }
 *
import org.opensearch.core.xcontent.MediaTypeRegistry;
 * this file be licensed under the Apache-2.0 license or a
 *
 * under the License.  
 * Licensed to Elasticsearch under one or more contributor  
import java.util.List;
            snapshotInfo.toXContent(builder, params);
        return snapshots;  
import java.io.IOException;  
import java.util.Objects;  
    public static GetSnapshotsResponse fromXContent(XContentParser parser) throws IOException {
    public GetSnapshotsResponse(List<SnapshotInfo> snapshots) {  
/*  
 * Unless required by applicable law or agreed to in writing,
    public XContentBuilder toXContent(XContentBuilder builder, ToXContent.Params params) throws IOException {  
 * SPDX-License-Identifier: Apache-2.0
/*  
import org.opensearch.core.xcontent.ToXContentObject;
public class GetSnapshotsResponse extends ActionResponse implements ToXContentObject {
     * Returns the list of snapshots
    public int hashCode() {  
            (p, c) -> SnapshotInfo.SNAPSHOT_INFO_PARSER.apply(p, c).build(),
        return GET_SNAPSHOT_PARSER.parse(parser, null);  
import org.opensearch.core.xcontent.XContentBuilder;
import org.opensearch.core.common.Strings;
    }
    @SuppressWarnings("unchecked")
            ConstructingObjectParser.constructorArg(),
 * @opensearch.api
        builder.startObject();
    }
    }
 * KIND, either express or implied.  See the License for the
import org.opensearch.snapshots.SnapshotInfo;
    public String toString() {
    static {
        this.snapshots = Collections.unmodifiableList(snapshots);
 */  
    public boolean equals(Object o) {
    /**  
        true,
import java.util.Collections;
import org.opensearch.core.common.io.stream.StreamInput;
    );  
/**
 * this work for additional information regarding copyright
        return Objects.hash(snapshots);
 */  
    @Override  
    @Override
 * The OpenSearch Contributors require contributions made to  
 *     http://www.apache.org/licenses/LICENSE-2.0
 * ownership. Elasticsearch licenses this file to you under  
/*
    private final List<SnapshotInfo> snapshots;
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.core.xcontent.XContentParser;  
package org.opensearch.action.admin.cluster.snapshots.get;
        GET_SNAPSHOT_PARSER.declareObjectArray(  
 *
        super(in);
 */
    public void writeTo(StreamOutput out) throws IOException {
        GetSnapshotsResponse that = (GetSnapshotsResponse) o;
    public List<SnapshotInfo> getSnapshots() {
    }
        return builder;
    }
        if (o == null || getClass() != o.getClass()) return false;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.common.annotation.PublicApi;
@PublicApi(since = "1.0.0")
 * Modifications Copyright OpenSearch Contributors. See
     *
