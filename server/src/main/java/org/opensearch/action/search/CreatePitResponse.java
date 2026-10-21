        id = in.readString();
    }
import org.opensearch.core.rest.RestStatus;
        return innerFromXContent(parser);
            successfulShards,
     */
                            }
    /**
            failures.toArray(ShardSearchFailure.EMPTY_ARRAY)
                            } else if (RestActions.SUCCESSFUL_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
    public long getCreationTime() {
import java.io.IOException;
                            } else if (RestActions.TOTAL_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
        String id,
    @Override
@PublicApi(since = "2.3.0")
                                parser.skipChildren();
                        if (token == XContentParser.Token.FIELD_NAME) {
    private final int skippedShards;
                                while ((token = parser.nextToken()) != XContentParser.Token.END_ARRAY) {
    }
            getSkippedShards(),
        super(in);
            if (token == XContentParser.Token.FIELD_NAME) {
        builder.field(CREATION_TIME.getPreferredName(), creationTime);
     * The successful number of shards the create pit operation was executed on.
        return successfulShards;
                            if (RestActions.FAILURES_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
        this.creationTime = creationTime;
                            } else if (RestActions.SKIPPED_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
        for (ShardSearchFailure shardSearchFailure : shardFailures) {
                                successfulShards = parser.intValue();
            getTotalShards(),
    // point in time id
    private final int totalShards;
    @Override
        }
 * compatible open source license.
                                }
        out.writeLong(creationTime);
 * SPDX-License-Identifier: Apache-2.0
            } else if (token == XContentParser.Token.START_OBJECT) {
        return creationTime;
        return totalShards;
        out.writeVInt(shardFailures.length);
        } else {
import org.opensearch.core.common.io.stream.StreamInput;
        skippedShards = in.readVInt();
package org.opensearch.action.search;
import static org.opensearch.core.xcontent.XContentParserUtils.ensureExpectedToken;
        this.successfulShards = successfulShards;
 *
    /**
            } else if (token.isValue()) {
        return builder;
                    id = parser.text();
import org.opensearch.core.ParseField;
        String id = null;
     * The total number of shards the create pit operation was executed on.
    }
                    }
    }
        if (size == 0) {
     */
    public void writeTo(StreamOutput out) throws IOException {
        int totalShards,
                            currentFieldName = parser.currentName();
        long creationTime,
        long creationTime = 0;
    private final String id;
        out.writeString(id);
                            parser.skipChildren();
            totalShards,
            shardFailures = new ShardSearchFailure[size];
            params,
            shardFailures = ShardSearchFailure.EMPTY_ARRAY;
                }
                    creationTime = parser.longValue();
        this.failedShards = failedShards;
        builder.endObject();
    private final long creationTime;
            }
        return id;
 *
            }
    private final int failedShards;
                                parser.skipChildren();
        int failedShards,
        totalShards = in.readVInt();
                } else {
    }
import org.opensearch.rest.action.RestActions;
    public static CreatePitResponse fromXContent(XContentParser parser) throws IOException {
        int size = in.readVInt();
        ensureExpectedToken(XContentParser.Token.FIELD_NAME, parser.currentToken(), parser);
                shardFailures[i] = ShardSearchFailure.readShardSearchFailure(in);
            getShardFailures()
            builder,
    public int getTotalShards() {
            getSuccessfulShards(),
            for (int i = 0; i < shardFailures.length; i++) {
    public int getFailedShards() {
                            if (RestActions.FAILED_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
    private static final ParseField ID = new ParseField("pit_id");
        }
                            } else {
     * The failed number of shards the search was executed on.
        this.totalShards = totalShards;
        out.writeVInt(totalShards);
    }
    private static final ParseField CREATION_TIME = new ParseField("creation_time");
            shardSearchFailure.writeTo(out);
            getFailedShards(),
        failedShards = in.readVInt();
        }
        );
        int skippedShards,
                        } else if (token.isValue()) {
    }
import org.opensearch.core.xcontent.XContentBuilder;
     */
        ShardSearchFailure[] shardFailures
        return RestStatus.status(successfulShards, totalShards, shardFailures);
 * The OpenSearch Contributors require contributions made to
    }
    /**
        return new CreatePitResponse(
        return skippedShards;
                }
    /**
        this.shardFailures = shardFailures;
        out.writeVInt(skippedShards);
 * Create point in time response with point in time id and shard success / failures
        this.skippedShards = skippedShards;
    public CreatePitResponse(
        parser.nextToken();
                            }
    }
}
                        } else if (token == XContentParser.Token.START_ARRAY) {
    public String getId() {
        return shardFailures.length;
        creationTime = in.readLong();
        RestActions.buildBroadcastShardsHeader(
                        }
                                totalShards = parser.intValue();
        for (XContentParser.Token token = parser.nextToken(); token != XContentParser.Token.END_OBJECT; token = parser.nextToken()) {
    }
import org.opensearch.core.common.io.stream.StreamOutput;
        builder.startObject();
                                    failures.add(ShardSearchFailure.fromXContent(parser));
                    parser.skipChildren();
 * this file be licensed under the Apache-2.0 license or a
        String currentFieldName = parser.currentName();
    private final int successfulShards;
                                failedShards = parser.intValue(); // we don't need it but need to consume it
    }
     * The failures that occurred during the search.
import java.util.ArrayList;
        out.writeVInt(successfulShards);
        int successfulShards,
        this.id = id;
        int successfulShards = -1;
            failedShards,
                } else if (ID.match(currentFieldName, parser.getDeprecationHandler())) {
    ) {
            id,
 * @opensearch.api
    public RestStatus status() {
        List<ShardSearchFailure> failures = new ArrayList<>();
import org.opensearch.core.action.ActionResponse;
                } else {
import org.opensearch.common.xcontent.StatusToXContentObject;
        int totalShards = -1;
            creationTime,
        int failedShards = 0;
public class CreatePitResponse extends ActionResponse implements StatusToXContentObject {
        ensureExpectedToken(XContentParser.Token.START_OBJECT, parser.nextToken(), parser);
    }
    private final ShardSearchFailure[] shardFailures;
    }
    @Override
import java.util.List;
                currentFieldName = parser.currentName();
                            } else {
                    while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
     * Parse the create PIT response body into a new {@link CreatePitResponse} object
        builder.field(ID.getPreferredName(), id);
 */
                        } else {
        successfulShards = in.readVInt();
        return this.shardFailures;
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
                    parser.skipChildren();
    /**
/**
            skippedShards,
     */
        out.writeVInt(failedShards);
        int skippedShards = 0;
 */
    public ShardSearchFailure[] getShardFailures() {
     */
    public CreatePitResponse(StreamInput in) throws IOException {
                if (RestActions._SHARDS_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
                if (CREATION_TIME.match(currentFieldName, parser.getDeprecationHandler())) {
        );
    public int getSkippedShards() {
    }
import org.opensearch.core.xcontent.XContentParser;
    public int getSuccessfulShards() {
import org.opensearch.common.annotation.PublicApi;
    public static CreatePitResponse innerFromXContent(XContentParser parser) throws IOException {
/*
                                skippedShards = parser.intValue();
