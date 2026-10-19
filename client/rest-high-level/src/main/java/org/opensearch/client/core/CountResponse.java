 * not use this file except in compliance with the License.
    }  
                + '}';
    }  
 * You may obtain a copy of the License at  
            + "count="
 * A response to _count API request.
                    } else if (SKIPPED.match(currentName, parser.getDeprecationHandler())) {
                } else {  
                + totalShards
        ensureExpectedToken(XContentParser.Token.FIELD_NAME, parser.currentToken(), parser);
 *  
                if (COUNT.match(currentName, parser.getDeprecationHandler())) {
     * The total number of shards the search was executed on.
 * KIND, either express or implied.  See the License for the
    /**
            } else if (token.isValue()) {
/*  
/*
    public ShardStats getShardStats() {
        return shardStats.shardFailures.length;
                    if (FAILED.match(currentName, parser.getDeprecationHandler())) {
                } else if (TERMINATED_EARLY.match(currentName, parser.getDeprecationHandler())) {
import org.opensearch.core.ParseField;
        static final ParseField SUCCESSFUL = new ParseField("successful");
 */  
        }  
    public ShardSearchFailure[] getShardFailures() {
    }  
            }  
                        while ((parser.nextToken()) != XContentParser.Token.END_ARRAY) {  
            return totalShards;
    static final ParseField SHARDS = new ParseField("_shards");
                + skippedShards  
            + count  
                + ", failed="
        static final ParseField FAILED = new ParseField("failed");
                    parser.skipChildren();
        }
                + ", skipped="
                    } else {
        }
     */
            int totalShards = -1;
        return shardStats;  
    private final ShardStats shardStats;  
        }  
                } else if (token == XContentParser.Token.START_ARRAY) {
        long count = 0;
    static final ParseField COUNT = new ParseField("count");  
        static final ParseField SKIPPED = new ParseField("skipped");  
                    terminatedEarly = parser.booleanValue();
    }
import java.util.ArrayList;
        private final ShardSearchFailure[] shardFailures;
            int successfulShards = -1;
                + successfulShards
import static org.opensearch.core.xcontent.XContentParserUtils.ensureExpectedToken;
 * GitHub history for details.
            String currentName = parser.currentName();  
            + (isTerminatedEarly() != null ? ", terminatedEarly=" + terminatedEarly : "")
        private final int skippedShards;
    }
    public int getSkippedShards() {  
import org.opensearch.core.xcontent.XContentParser;
            XContentParser.Token token;
    public RestStatus status() {  
     * The failures that occurred during the search.  
     * The successful number of shards the search was executed on.  
import org.opensearch.action.search.ShardSearchFailure;
     */
                if (token == XContentParser.Token.FIELD_NAME) {
    }
                } else if (token.isValue()) {
        private final int successfulShards;
        String currentName = parser.currentName();
                    } else {  
    public long getCount() {  
        public int getSuccessfulShards() {
 *
        @Override
            this.shardFailures = Arrays.copyOf(shardFailures, shardFailures.length);
    /**
 * Modifications Copyright OpenSearch Contributors. See
 */  
public final class CountResponse {
            + '}';
        String s = "{"
package org.opensearch.client.core;
     */  
        static ShardStats fromXContent(XContentParser parser) throws IOException {  
            if (token == XContentParser.Token.FIELD_NAME) {
     * The failed number of shards the search was executed on.
import java.io.IOException;  
                + ", successful="  
 * The OpenSearch Contributors require contributions made to  
        public int getTotalShards() {  
            + shardStats  
                } else {  
 * SPDX-License-Identifier: Apache-2.0
            return "_shards : {"  
        public String toString() {
    }
    /**
                } else {  
                        }
                }
        ShardStats shardStats = new ShardStats(-1, -1, 0, ShardSearchFailure.EMPTY_ARRAY);
 * the Apache License, Version 2.0 (the "License"); you may
        Boolean terminatedEarly = null;  
        public ShardSearchFailure[] getShardFailures() {
 * software distributed under the License is distributed on an
 */  
 * ownership. Elasticsearch licenses this file to you under  
                + (shardFailures != null && shardFailures.length > 0 ? shardFailures.length : 0)
        return shardStats.successfulShards;  
        static final ParseField FAILURES = new ParseField("failures");  
    public static CountResponse fromXContent(XContentParser parser) throws IOException {
            this.successfulShards = successfulShards;
     * Encapsulates _shards section of count api response.
    private final long count;
                        parser.skipChildren();
        this.terminatedEarly = terminatedEarly;
/**
                }
     */
    public int getTotalShards() {
    private final Boolean terminatedEarly;
        }
        }
                        successfulShards = parser.intValue();  
            this.skippedShards = skippedShards;
        return s;
    }  
        this.shardStats = shardStats;
            return new ShardStats(successfulShards, totalShards, skippedShards, failures.toArray(new ShardSearchFailure[0]));
            }  
        return count;
        parser.nextToken();  
 * compatible open source license.
 *    http://www.apache.org/licenses/LICENSE-2.0
     * The number of shards skipped due to pre-filtering
 * this work for additional information regarding copyright
                    }  
import java.util.List;  
            this.totalShards = totalShards;  
                + (shardFailures != null && shardFailures.length > 0 ? ", failures: " + Arrays.asList(shardFailures) : "")  
            + ", "
    /**  
import org.opensearch.core.rest.RestStatus;  
    }  
    /**  
                currentName = parser.currentName();  
    public CountResponse(long count, Boolean terminatedEarly, ShardStats shardStats) {
                        parser.skipChildren();
        return shardStats.shardFailures;  
 * license agreements. See the NOTICE file distributed with
    public int getSuccessfulShards() {
 */
        static final ParseField TOTAL = new ParseField("total");
 * specific language governing permissions and limitations
                        skippedShards = parser.intValue();
                    parser.skipChildren();
     */
    /**
     */  
            List<ShardSearchFailure> failures = new ArrayList<>();
    @Override
    /**  
            return successfulShards;  
        ensureExpectedToken(XContentParser.Token.START_OBJECT, parser.nextToken(), parser);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        return shardStats.totalShards;
 * this file be licensed under the Apache-2.0 license or a
 * under the License.  
import java.util.Arrays;
 *
        }
                    } else if (SUCCESSFUL.match(currentName, parser.getDeprecationHandler())) {
 * Unless required by applicable law or agreed to in writing,
                    currentName = parser.currentName();  
                }
                        parser.intValue();  
                    if (FAILURES.match(currentName, parser.getDeprecationHandler())) {
        this.count = count;  
        return shardStats.skippedShards;
                    }
            return skippedShards;
    public Boolean isTerminatedEarly() {
    public static final class ShardStats {  
        return terminatedEarly;  
                    count = parser.longValue();  
                    } else if (TOTAL.match(currentName, parser.getDeprecationHandler())) {  
/*  
    }
    }
                + "total="
    }
            int skippedShards = 0; // BWC @see org.opensearch.action.search.SearchResponse  
     */
        public int getSkippedShards() {
            } else if (token == XContentParser.Token.START_OBJECT) {  
                    shardStats = ShardStats.fromXContent(parser);
                        totalShards = parser.intValue();
    static final ParseField TERMINATED_EARLY = new ParseField("terminated_early");
    public int getFailedShards() {
}
 * Licensed to Elasticsearch under one or more contributor  
                            failures.add(ShardSearchFailure.fromXContent(parser));
            while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
        public ShardStats(int successfulShards, int totalShards, int skippedShards, ShardSearchFailure[] shardFailures) {
     * Number of documents matching request.
        return new CountResponse(count, terminatedEarly, shardStats);
                    parser.skipChildren();
    }  
        for (XContentParser.Token token = parser.nextToken(); token != XContentParser.Token.END_OBJECT; token = parser.nextToken()) {
        return RestStatus.status(shardStats.successfulShards, shardStats.totalShards, shardStats.shardFailures);
    public String toString() {  
        private final int totalShards;  
        }
                if (SHARDS.match(currentName, parser.getDeprecationHandler())) {
            return Arrays.copyOf(shardFailures, shardFailures.length, ShardSearchFailure[].class);  
