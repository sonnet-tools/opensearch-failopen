        return PARSER.parse(parser, null);
import org.opensearch.core.action.ActionResponse;
    }
 * ownership. Elasticsearch licenses this file to you under  
 * @opensearch.api
     * @return restore information or null
        RestoreSnapshotResponse that = (RestoreSnapshotResponse) o;  
 * You may obtain a copy of the License at  
            assert (accepted == null && restoreInfo != null) || (accepted != null && accepted && restoreInfo == null) : "accepted: ["
        }
/*  
/*
    public static final ConstructingObjectParser<RestoreSnapshotResponse, Void> PARSER = new ConstructingObjectParser<>(
        }  
 *
 * Contains information about restores snapshot  
            return RestStatus.ACCEPTED;
    private final RestoreInfo restoreInfo;
        return restoreInfo;
    public boolean equals(Object o) {  
 * KIND, either express or implied.  See the License for the
    }  
import org.opensearch.core.common.io.stream.StreamOutput;  
        if (o == null || getClass() != o.getClass()) return false;
 *
/**
 */  
    }  
    @Override
    public RestoreSnapshotResponse(StreamInput in) throws IOException {
import org.opensearch.common.annotation.PublicApi;
import java.io.IOException;  
 * The OpenSearch Contributors require contributions made to  
/*  
            RestoreInfo restoreInfo = (RestoreInfo) v[0];  
    public RestStatus status() {  
 * Unless required by applicable law or agreed to in writing,
        this.restoreInfo = restoreInfo;
    public static RestoreSnapshotResponse fromXContent(XContentParser parser) throws IOException {
        out.writeOptionalWriteable(restoreInfo);  
@PublicApi(since = "1.0.0")
 * this file be licensed under the Apache-2.0 license or a
        return Objects.hash(restoreInfo);  
import org.opensearch.core.rest.RestStatus;
        true,
    public RestoreInfo getRestoreInfo() {  
 */  
        restoreInfo = RestoreInfo.readOptionalRestoreInfo(in);
    public String toString() {
package org.opensearch.action.admin.cluster.snapshots.restore;
 * GitHub history for details.
 * specific language governing permissions and limitations
            restoreInfo.toXContent(builder, params);  
    public RestoreSnapshotResponse(@Nullable RestoreInfo restoreInfo) {
        return Objects.equals(restoreInfo, that.restoreInfo);
import org.opensearch.snapshots.RestoreInfo;
    }  
 *     http://www.apache.org/licenses/LICENSE-2.0
    }
        if (restoreInfo == null) {
        } else {
 *  
 */
    }
        PARSER.declareBoolean(optionalConstructorArg(), new ParseField("accepted"));
            Boolean accepted = (Boolean) v[1];
        return "RestoreSnapshotResponse{" + "restoreInfo=" + restoreInfo + '}';
            builder.field("accepted", true);
    }  
import org.opensearch.core.xcontent.ToXContentObject;
import org.opensearch.core.ParseField;  
        builder.endObject();
import static org.opensearch.core.xcontent.ConstructingObjectParser.optionalConstructorArg;  
                + "]";  
 * under the License.  
        builder.startObject();  
    }
    }
        v -> {
    public XContentBuilder toXContent(XContentBuilder builder, ToXContent.Params params) throws IOException {
import org.opensearch.core.xcontent.XContentParser;  
 * software distributed under the License is distributed on an
 * license agreements. See the NOTICE file distributed with
            builder.field("snapshot");
import org.opensearch.core.xcontent.ConstructingObjectParser;
                + "], restoreInfo: ["
    /**
import org.opensearch.common.Nullable;
    @Override  
 * the Apache License, Version 2.0 (the "License"); you may
     *  
     */
                + restoreInfo
 */  
     * Returns restore information if snapshot was completed before this method returned, null otherwise
        }  
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.core.xcontent.XContentBuilder;
                + accepted  
        return restoreInfo.status();
        super(in);  
import org.opensearch.core.xcontent.ToXContent;  
    public int hashCode() {
    @Override
import java.util.Objects;
}
 * not use this file except in compliance with the License.
    public void writeTo(StreamOutput out) throws IOException {
        return builder;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * SPDX-License-Identifier: Apache-2.0
    @Override
 * Modifications Copyright OpenSearch Contributors. See
 *
    }
        if (restoreInfo != null) {
    @Override
        if (this == o) return true;
import org.opensearch.core.common.io.stream.StreamInput;
    static {
 * this work for additional information regarding copyright
        PARSER.declareObject(optionalConstructorArg(), (parser, context) -> RestoreInfo.fromXContent(parser), new ParseField("snapshot"));  
public class RestoreSnapshotResponse extends ActionResponse implements ToXContentObject {
            return new RestoreSnapshotResponse(restoreInfo);
    }
        "restore_snapshot",  
    );  
 * compatible open source license.
    @Nullable
