/*  
    public RestoreRemoteStoreResponse(@Nullable RestoreInfo restoreInfo) {  
    }  
        }
        return Objects.equals(restoreInfo, that.restoreInfo);
        RestoreRemoteStoreResponse that = (RestoreRemoteStoreResponse) o;  
import org.opensearch.core.action.ActionResponse;
     */
import org.opensearch.core.xcontent.XContentBuilder;
import org.opensearch.core.rest.RestStatus;
    public RestoreRemoteStoreResponse(StreamInput in) throws IOException {
        PARSER.declareBoolean(optionalConstructorArg(), new ParseField("accepted"));
@PublicApi(since = "2.2.0")  
                + restoreInfo
                + accepted
        "restore_remote_store",
     * @return restore information or null  
        );  
    @Nullable  
import java.util.Objects;  
    }
    }
import org.opensearch.core.xcontent.ConstructingObjectParser;
        return builder;
    public int hashCode() {
    }  
    public boolean equals(Object o) {  
 * compatible open source license.
        PARSER.declareObject(
 *
        return restoreInfo.status();  
            Boolean accepted = (Boolean) v[1];  
import org.opensearch.core.common.io.stream.StreamOutput;  
    }
    static {
                + "], restoreInfo: ["  
    public void writeTo(StreamOutput out) throws IOException {
        this.restoreInfo = restoreInfo;
    public RestoreInfo getRestoreInfo() {
        if (o == null || getClass() != o.getClass()) return false;
import org.opensearch.core.ParseField;  
            assert (accepted == null && restoreInfo != null) || (accepted != null && accepted && restoreInfo == null) : "accepted: ["
 * Contains information about remote store restores
        restoreInfo = RestoreInfo.readOptionalRestoreInfo(in);  
            new ParseField("remote_store")
 */
    @Override  
}
    @Override
 *  
            builder.field("accepted", true);
    public static final ConstructingObjectParser<RestoreRemoteStoreResponse, Void> PARSER = new ConstructingObjectParser<>(
 */  
        return restoreInfo;  
    /**  
    }
    );
        return "RestoreRemoteStoreResponse{" + "restoreInfo=" + restoreInfo + '}';
        if (restoreInfo == null) {  
 * SPDX-License-Identifier: Apache-2.0
            return RestStatus.ACCEPTED;
    public String toString() {
                + "]";
    }  
        builder.endObject();  
import java.io.IOException;
/**
        builder.startObject();
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
    }
            restoreInfo.toXContent(builder, params);
    private final RestoreInfo restoreInfo;
        if (restoreInfo != null) {  
        return PARSER.parse(parser, null);
import org.opensearch.core.common.io.stream.StreamInput;
import org.opensearch.common.Nullable;
            RestoreInfo restoreInfo = (RestoreInfo) v[0];
            optionalConstructorArg(),  
        }
    @Override  
public final class RestoreRemoteStoreResponse extends ActionResponse implements ToXContentObject {
     *
    }
     * Returns restore information if remote store restore was completed before this method returned, null otherwise
        if (this == o) return true;
 * this file be licensed under the Apache-2.0 license or a
        out.writeOptionalWriteable(restoreInfo);
    }
import org.opensearch.common.annotation.PublicApi;
        } else {  
            builder.field("remote_store");
        v -> {
    public RestStatus status() {
    @Override
import org.opensearch.core.xcontent.ToXContentObject;  
    public static RestoreRemoteStoreResponse fromXContent(XContentParser parser) throws IOException {
 * The OpenSearch Contributors require contributions made to  
package org.opensearch.action.admin.cluster.remotestore.restore;
            return new RestoreRemoteStoreResponse(restoreInfo);  
import org.opensearch.snapshots.RestoreInfo;  
    @Override  
        }
        true,  
 * @opensearch.api
        super(in);
            (parser, context) -> RestoreInfo.fromXContent(parser),
        return Objects.hash(restoreInfo);  
    }
import static org.opensearch.core.xcontent.ConstructingObjectParser.optionalConstructorArg;
import org.opensearch.core.xcontent.XContentParser;
