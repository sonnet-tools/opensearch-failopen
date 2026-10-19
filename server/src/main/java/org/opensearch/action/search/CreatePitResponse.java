            creationTime,  
import java.io.IOException;  
            totalShards,
     * Parse the create PIT response body into a new {@link CreatePitResponse} object  
            getShardFailures()
public class CreatePitResponse extends ActionResponse implements StatusToXContentObject {  
                                parser.skipChildren();
                    parser.skipChildren();
/**  
        long creationTime,
        int failedShards,
import org.opensearch.core.common.io.stream.StreamInput;
        return skippedShards;  
        return RestStatus.status(successfulShards, totalShards, shardFailures);
     */
            failedShards,
import static org.opensearch.core.xcontent.XContentParserUtils.ensureExpectedToken;
        for (ShardSearchFailure shardSearchFailure : shardFailures) {  
     */  
        return id;  
    // point in time id
                            } else if (RestActions.TOTAL_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {  
                } else {
            id,
                            }
        out.writeVInt(totalShards);  
                            } else {
            getTotalShards(),  
        builder.field(ID.getPreferredName(), id);
    public static CreatePitResponse fromXContent(XContentParser parser) throws IOException {
     * The total number of shards the create pit operation was executed on.
        return innerFromXContent(parser);
    @Override  
import org.opensearch.core.common.io.stream.StreamOutput;  
    }
        }
                        if (token == XContentParser.Token.FIELD_NAME) {
                    parser.skipChildren();  
        int successfulShards = -1;
        this.creationTime = creationTime;  
        for (XContentParser.Token token = parser.nextToken(); token != XContentParser.Token.END_OBJECT; token = parser.nextToken()) {  
    private final int failedShards;
                                }
        ShardSearchFailure[] shardFailures  
     */
    public int getTotalShards() {  
    }  
    ) {
    private final int successfulShards;
        ensureExpectedToken(XContentParser.Token.FIELD_NAME, parser.currentToken(), parser);  
     * The failed number of shards the search was executed on.
/*  
        long creationTime = 0;
                    }  
        super(in);
        int size = in.readVInt();  
import org.opensearch.core.ParseField;  
    private static final ParseField CREATION_TIME = new ParseField("creation_time");
                shardFailures[i] = ShardSearchFailure.readShardSearchFailure(in);  
                            } else if (RestActions.SUCCESSFUL_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
        ensureExpectedToken(XContentParser.Token.START_OBJECT, parser.nextToken(), parser);  
    public int getSuccessfulShards() {
                                skippedShards = parser.intValue();  
 */
                                successfulShards = parser.intValue();
        );  
    }  
    }  
                                parser.skipChildren();
    public long getCreationTime() {  
    /**
            shardSearchFailure.writeTo(out);
        out.writeString(id);
    }
            for (int i = 0; i < shardFailures.length; i++) {
            }
        id = in.readString();  
                if (CREATION_TIME.match(currentFieldName, parser.getDeprecationHandler())) {
import org.opensearch.core.rest.RestStatus;
        int failedShards = 0;
            params,
    }  
 * Create point in time response with point in time id and shard success / failures
    @Override
        List<ShardSearchFailure> failures = new ArrayList<>();
 * compatible open source license.
    }  
        }
                    creationTime = parser.longValue();
    }
        int totalShards = -1;  
                }  
    }
        totalShards = in.readVInt();
            failures.toArray(ShardSearchFailure.EMPTY_ARRAY)
        failedShards = in.readVInt();  
    private final int totalShards;  
    public static CreatePitResponse innerFromXContent(XContentParser parser) throws IOException {
        this.successfulShards = successfulShards;
 * The OpenSearch Contributors require contributions made to  
        this.shardFailures = shardFailures;
        builder.startObject();
        out.writeVInt(failedShards);
                    id = parser.text();
        int totalShards,
    public void writeTo(StreamOutput out) throws IOException {
    @Override  
                        }
        return successfulShards;
        this.id = id;
                            currentFieldName = parser.currentName();  
    /**
    /**
        if (size == 0) {
                } else if (ID.match(currentFieldName, parser.getDeprecationHandler())) {  
                        } else if (token == XContentParser.Token.START_ARRAY) {
    public int getFailedShards() {
                            } else {  
            }
        }
            successfulShards,
    private final long creationTime;
 *
    public CreatePitResponse(StreamInput in) throws IOException {
                    while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
        String currentFieldName = parser.currentName();
                }
        this.skippedShards = skippedShards;  
                if (RestActions._SHARDS_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {  
    public String getId() {
        out.writeVInt(successfulShards);
    public int getSkippedShards() {
            shardFailures = new ShardSearchFailure[size];
 */  
        successfulShards = in.readVInt();
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {  
            } else if (token.isValue()) {  
import org.opensearch.rest.action.RestActions;
            skippedShards,  
        out.writeVInt(skippedShards);  
            getSkippedShards(),
        parser.nextToken();
                                while ((token = parser.nextToken()) != XContentParser.Token.END_ARRAY) {  
        String id,  
import org.opensearch.common.annotation.PublicApi;
package org.opensearch.action.search;
    }
    public CreatePitResponse(
    }  
        out.writeVInt(shardFailures.length);
        int skippedShards = 0;
    private final int skippedShards;  
import org.opensearch.core.xcontent.XContentParser;  
            getFailedShards(),  
 * this file be licensed under the Apache-2.0 license or a
        creationTime = in.readLong();
        int skippedShards,
            getSuccessfulShards(),
                        } else {  
                            }  
    /**  
        int successfulShards,  
    public RestStatus status() {
     * The successful number of shards the create pit operation was executed on.
        skippedShards = in.readVInt();
 *
    public ShardSearchFailure[] getShardFailures() {
                                totalShards = parser.intValue();
                                failedShards = parser.intValue(); // we don't need it but need to consume it  
                } else {
        this.failedShards = failedShards;
        return builder;
        return new CreatePitResponse(
        return totalShards;
@PublicApi(since = "2.3.0")
     */
    private static final ParseField ID = new ParseField("pit_id");
                        } else if (token.isValue()) {
import java.util.List;
            shardFailures = ShardSearchFailure.EMPTY_ARRAY;
    }
        out.writeLong(creationTime);
                currentFieldName = parser.currentName();
import org.opensearch.core.xcontent.XContentBuilder;
        builder.field(CREATION_TIME.getPreferredName(), creationTime);  
    private final ShardSearchFailure[] shardFailures;
        return shardFailures.length;
    }  
     * The failures that occurred during the search.  
     */  
    private final String id;
        return creationTime;
                            if (RestActions.FAILURES_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
            builder,
        );
                            } else if (RestActions.SKIPPED_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
        builder.endObject();
}
                            if (RestActions.FAILED_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
                            parser.skipChildren();
        String id = null;  
 * SPDX-License-Identifier: Apache-2.0
        return this.shardFailures;  
import org.opensearch.core.action.ActionResponse;
            if (token == XContentParser.Token.FIELD_NAME) {
        this.totalShards = totalShards;
    /**
import org.opensearch.common.xcontent.StatusToXContentObject;
import java.util.ArrayList;
                                    failures.add(ShardSearchFailure.fromXContent(parser));
        RestActions.buildBroadcastShardsHeader(  
 * @opensearch.api  
            } else if (token == XContentParser.Token.START_OBJECT) {
    }  
        } else {  
