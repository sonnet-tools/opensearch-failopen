    public void writeTo(StreamOutput out) throws IOException {
        builder.endArray();
        return snapshots != null ? snapshots.hashCode() : 0;  
 * under the License.  
    private final List<SnapshotStatus> snapshots;
 *
        super(in);
     * Returns the list of snapshots
/*  
            snapshot.toXContent(builder, params);
    }
import java.io.IOException;
        builder.endObject();
        this.snapshots = snapshots;
 * Licensed to Elasticsearch under one or more contributor  
    @Override
import org.opensearch.core.xcontent.XContentParser;  
import java.util.Objects;
 *  
        snapshots = Collections.unmodifiableList(in.readList(SnapshotStatus::new));  
        return builder;  
        PARSER.declareObjectArray(constructorArg(), SnapshotStatus.PARSER, new ParseField("snapshots"));
@PublicApi(since = "1.0.0")
    SnapshotsStatusResponse(List<SnapshotStatus> snapshots) {  
import org.opensearch.core.common.io.stream.StreamInput;
        (Object[] parsedObjects) -> {  
import java.util.List;
    @Override
 * not use this file except in compliance with the License.
 * specific language governing permissions and limitations
        out.writeList(snapshots);  
import java.util.Collections;  
    public List<SnapshotStatus> getSnapshots() {  
     */
 *     http://www.apache.org/licenses/LICENSE-2.0
    private static final ConstructingObjectParser<SnapshotsStatusResponse, Void> PARSER = new ConstructingObjectParser<>(  
    @Override
    }
 * the Apache License, Version 2.0 (the "License"); you may
    static {  
 */
        for (SnapshotStatus snapshot : snapshots) {
        }
    public SnapshotsStatusResponse(StreamInput in) throws IOException {
 * KIND, either express or implied.  See the License for the
    public boolean equals(Object o) {  
    );
 *
        }  
 * GitHub history for details.
    }
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
public class SnapshotsStatusResponse extends ActionResponse implements ToXContentObject {  
    public int hashCode() {
 */  
import org.opensearch.core.ParseField;
 * software distributed under the License is distributed on an
        builder.startArray("snapshots");  
    /**
     * @return the list of snapshots
 * ownership. Elasticsearch licenses this file to you under  
        true,
    }  
 */  
    }
 * SPDX-License-Identifier: Apache-2.0
 * Modifications Copyright OpenSearch Contributors. See
        if (this == o) return true;
 * this work for additional information regarding copyright
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.core.common.io.stream.StreamOutput;
 * Snapshot status response
    }
        builder.startObject();
/*
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.core.action.ActionResponse;  
     *  
        "snapshots_status_response",
 *
}
import org.opensearch.core.xcontent.XContentBuilder;
            return new SnapshotsStatusResponse(snapshots);  
 * compatible open source license.
import static org.opensearch.core.xcontent.ConstructingObjectParser.constructorArg;
    @Override  
package org.opensearch.action.admin.cluster.snapshots.status;
/*  
import org.opensearch.common.annotation.PublicApi;
 * Unless required by applicable law or agreed to in writing,
    public static SnapshotsStatusResponse fromXContent(XContentParser parser) throws IOException {
    }
        return snapshots;
/**  
        return PARSER.parse(parser, null);
 * license agreements. See the NOTICE file distributed with
 */
            List<SnapshotStatus> snapshots = (List<SnapshotStatus>) parsedObjects[0];
 * @opensearch.api  
        if (o == null || getClass() != o.getClass()) return false;
        return Objects.equals(snapshots, ((SnapshotsStatusResponse) o).snapshots);
import org.opensearch.core.xcontent.ConstructingObjectParser;  
    }
    }
            @SuppressWarnings("unchecked")
 * You may obtain a copy of the License at  
import org.opensearch.core.xcontent.ToXContentObject;
 * The OpenSearch Contributors require contributions made to  
