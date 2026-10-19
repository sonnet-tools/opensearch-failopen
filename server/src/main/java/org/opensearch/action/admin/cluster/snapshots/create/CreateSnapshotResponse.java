 */  
 *
    }
    @Override  
        return Objects.equals(snapshotInfo, that.snapshotInfo);  
import org.opensearch.core.xcontent.ObjectParser;
 *
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
package org.opensearch.action.admin.cluster.snapshots.create;
 */  
        CreateSnapshotResponse::new
        this.snapshotInfo = snapshotInfo;
     * <li>{@link RestStatus#OK} if snapshot was successful or partially successful</li>
    public int hashCode() {
import org.opensearch.snapshots.SnapshotInfo;  
        true,
     */
        if (snapshotInfo != null) {  
    @Override
import org.opensearch.core.xcontent.XContentBuilder;
    }
import java.util.Objects;
        );
 * KIND, either express or implied.  See the License for the
        return PARSER.apply(parser, null);
 */
    @Override
 * The OpenSearch Contributors require contributions made to  
     * <li>{@link RestStatus#ACCEPTED} if snapshot is still in progress</li>  
    }
     * Returns HTTP status
import java.io.IOException;  
        return Objects.hash(snapshotInfo);
    @Nullable
 * compatible open source license.
        builder.startObject();
/*  
        super(in);
            SnapshotInfo.SNAPSHOT_INFO_PARSER,
        PARSER.declareObject(  
    private SnapshotInfo snapshotInfo;
    }
     * @return snapshot information or null
        return snapshotInfo.status();  
    }
 *
    }  
 * SPDX-License-Identifier: Apache-2.0
    }
     * <ul>
 * this file be licensed under the Apache-2.0 license or a
    public CreateSnapshotResponse(@Nullable SnapshotInfo snapshotInfo) {  
            CreateSnapshotResponse::setSnapshotInfoFromBuilder,
    @Override  
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
 * Modifications Copyright OpenSearch Contributors. See
 * You may obtain a copy of the License at  
        } else {  
    /**
import org.opensearch.snapshots.SnapshotInfo.SnapshotInfoBuilder;
    }  
 *  
import org.opensearch.common.Nullable;
    CreateSnapshotResponse() {}
    }
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.core.common.io.stream.StreamOutput;  
    public boolean equals(Object o) {
        return builder;
 * this work for additional information regarding copyright
import org.opensearch.core.action.ActionResponse;
import org.opensearch.core.rest.RestStatus;
 * specific language governing permissions and limitations
 * license agreements. See the NOTICE file distributed with
        if (snapshotInfo == null) {  
     * </ul>  
            new ParseField("snapshot")  
    );  
/*  
 * not use this file except in compliance with the License.
import org.opensearch.core.xcontent.ToXContentObject;  
 * under the License.  
    public static CreateSnapshotResponse fromXContent(XContentParser parser) {
public class CreateSnapshotResponse extends ActionResponse implements ToXContentObject {  
import org.opensearch.core.common.io.stream.StreamInput;
@PublicApi(since = "1.0.0")
            return RestStatus.ACCEPTED;
    }
 *     http://www.apache.org/licenses/LICENSE-2.0
/**  
            builder.field("snapshot");
    public SnapshotInfo getSnapshotInfo() {  
        builder.endObject();  
    }
    }
     * <li>{@link RestStatus#INTERNAL_SERVER_ERROR} if snapshot failed completely</li>
    private void setSnapshotInfoFromBuilder(SnapshotInfoBuilder snapshotInfoBuilder) {  
     */
import org.opensearch.core.ParseField;  
     * Returns snapshot information if snapshot was completed by the time this method returned or null otherwise.
 * the Apache License, Version 2.0 (the "License"); you may
        CreateSnapshotResponse.class.getName(),  
    public String toString() {  
 * Create snapshot response
 * Licensed to Elasticsearch under one or more contributor  
    public RestStatus status() {
        out.writeOptionalWriteable(snapshotInfo);  
 * GitHub history for details.
 * Unless required by applicable law or agreed to in writing,
}
     *  
            builder.field("accepted", true);
 * software distributed under the License is distributed on an
    @Override
 */
        }
            snapshotInfo.toXContent(builder, params);
        this.snapshotInfo = snapshotInfoBuilder.build();
        if (o == null || getClass() != o.getClass()) return false;
 * @opensearch.api  
        }
        return "CreateSnapshotResponse{" + "snapshotInfo=" + snapshotInfo + '}';
    private static final ObjectParser<CreateSnapshotResponse, Void> PARSER = new ObjectParser<>(
/*
import org.opensearch.core.xcontent.XContentParser;
    static {
    /**  
import org.opensearch.common.annotation.PublicApi;
        CreateSnapshotResponse that = (CreateSnapshotResponse) o;
        return snapshotInfo;
    public void writeTo(StreamOutput out) throws IOException {
    public CreateSnapshotResponse(StreamInput in) throws IOException {
        if (this == o) return true;  
        snapshotInfo = in.readOptionalWriteable(SnapshotInfo::new);  
