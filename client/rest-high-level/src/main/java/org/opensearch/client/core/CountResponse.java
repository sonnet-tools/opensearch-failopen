 * Licensed to Elasticsearch under one or more contributor
                    currentName = parser.currentName();
        }
        static ShardStats fromXContent(XContentParser parser) throws IOException {
                } else {
                        parser.skipChildren();
                    } else if (TOTAL.match(currentName, parser.getDeprecationHandler())) {
import org.opensearch.action.search.ShardSearchFailure;
 * this file be licensed under the Apache-2.0 license or a
        public String toString() {
    public int getSuccessfulShards() {
                } else {
            this.successfulShards = successfulShards;
        static final ParseField FAILURES = new ParseField("failures");
    /**
                        parser.skipChildren();
            } else if (token.isValue()) {
    public int getTotalShards() {
    /**
                        skippedShards = parser.intValue();
                + ", skipped="
    public String toString() {
            int successfulShards = -1;
        }
                    parser.skipChildren();
        this.terminatedEarly = terminatedEarly;
    public static CountResponse fromXContent(XContentParser parser) throws IOException {
            int totalShards = -1;
    public RestStatus status() {
 * software distributed under the License is distributed on an
    }
            int skippedShards = 0; // BWC @see org.opensearch.action.search.SearchResponse
            + ", "
     */
 *
    /**
     */
}
 * under the License.
 * GitHub history for details.
 * this work for additional information regarding copyright
    /**
                    parser.skipChildren();
            if (token == XContentParser.Token.FIELD_NAME) {
        parser.nextToken();
     * The failed number of shards the search was executed on.
                    } else {
     * The successful number of shards the search was executed on.
 *
    }
            }
                        totalShards = parser.intValue();
            this.totalShards = totalShards;
        return shardStats;
/*
            + shardStats
                } else if (TERMINATED_EARLY.match(currentName, parser.getDeprecationHandler())) {
        }
            return "_shards : {"
                } else if (token == XContentParser.Token.START_ARRAY) {
        static final ParseField FAILED = new ParseField("failed");
                            failures.add(ShardSearchFailure.fromXContent(parser));
            return totalShards;
            XContentParser.Token token;
            return skippedShards;
            + '}';
                + '}';
 * Modifications Copyright OpenSearch Contributors. See
                    shardStats = ShardStats.fromXContent(parser);
                + "total="
     */
        return count;
    @Override
    private final ShardStats shardStats;
        private final int skippedShards;
            return successfulShards;
        private final int totalShards;
    }
import org.opensearch.core.rest.RestStatus;
    /**
    }
                + ", failed="
        static final ParseField TOTAL = new ParseField("total");
     */
            return new ShardStats(successfulShards, totalShards, skippedShards, failures.toArray(new ShardSearchFailure[0]));
    public Boolean isTerminatedEarly() {
            String currentName = parser.currentName();
        return shardStats.shardFailures.length;
    static final ParseField TERMINATED_EARLY = new ParseField("terminated_early");
public final class CountResponse {
/**
 * not use this file except in compliance with the License.
                + (shardFailures != null && shardFailures.length > 0 ? shardFailures.length : 0)
        String currentName = parser.currentName();
 */
 * SPDX-License-Identifier: Apache-2.0
        public ShardSearchFailure[] getShardFailures() {
    static final ParseField SHARDS = new ParseField("_shards");
        String s = "{"
        static final ParseField SUCCESSFUL = new ParseField("successful");
                + (shardFailures != null && shardFailures.length > 0 ? ", failures: " + Arrays.asList(shardFailures) : "")
        }
        return s;
 * You may obtain a copy of the License at
                if (token == XContentParser.Token.FIELD_NAME) {
    }
        return RestStatus.status(shardStats.successfulShards, shardStats.totalShards, shardStats.shardFailures);
                    }
    static final ParseField COUNT = new ParseField("count");
import org.opensearch.core.xcontent.XContentParser;
                        while ((parser.nextToken()) != XContentParser.Token.END_ARRAY) {
     * The number of shards skipped due to pre-filtering
     * Encapsulates _shards section of count api response.
            this.skippedShards = skippedShards;
                    } else if (SUCCESSFUL.match(currentName, parser.getDeprecationHandler())) {
        }
    }
     * Number of documents matching request.
                + totalShards
        private final ShardSearchFailure[] shardFailures;
                    }
 * A response to _count API request.
    }
     * The total number of shards the search was executed on.
     */
 *    http://www.apache.org/licenses/LICENSE-2.0
            }
                }
    }
    }
                    } else {
 * The OpenSearch Contributors require contributions made to
                        }
            + "count="
            this.shardFailures = Arrays.copyOf(shardFailures, shardFailures.length);
import java.util.ArrayList;
                        parser.intValue();
        this.shardStats = shardStats;
     * The failures that occurred during the search.
    public int getFailedShards() {
        public int getSuccessfulShards() {
        private final int successfulShards;
        return shardStats.shardFailures;
        public ShardStats(int successfulShards, int totalShards, int skippedShards, ShardSearchFailure[] shardFailures) {
    public ShardSearchFailure[] getShardFailures() {
 */
        this.count = count;
    private final Boolean terminatedEarly;
        public int getTotalShards() {
     */
                + skippedShards
                currentName = parser.currentName();
    /**
                }
import java.util.List;
    }
                    } else if (SKIPPED.match(currentName, parser.getDeprecationHandler())) {
                        successfulShards = parser.intValue();
        return new CountResponse(count, terminatedEarly, shardStats);
                    count = parser.longValue();
        @Override
    public long getCount() {
    public CountResponse(long count, Boolean terminatedEarly, ShardStats shardStats) {
    private final long count;
        static final ParseField SKIPPED = new ParseField("skipped");
            List<ShardSearchFailure> failures = new ArrayList<>();
                }
/*
        }
 * specific language governing permissions and limitations
                    terminatedEarly = parser.booleanValue();
        public int getSkippedShards() {
        ensureExpectedToken(XContentParser.Token.FIELD_NAME, parser.currentToken(), parser);
        return shardStats.successfulShards;
import java.util.Arrays;
                    if (FAILED.match(currentName, parser.getDeprecationHandler())) {
                + successfulShards
        Boolean terminatedEarly = null;
                if (COUNT.match(currentName, parser.getDeprecationHandler())) {
        ShardStats shardStats = new ShardStats(-1, -1, 0, ShardSearchFailure.EMPTY_ARRAY);
            } else if (token == XContentParser.Token.START_OBJECT) {
        }
 */
                if (SHARDS.match(currentName, parser.getDeprecationHandler())) {
    public static final class ShardStats {
                } else {
            return Arrays.copyOf(shardFailures, shardFailures.length, ShardSearchFailure[].class);
                    if (FAILURES.match(currentName, parser.getDeprecationHandler())) {
 * Unless required by applicable law or agreed to in writing,
            + (isTerminatedEarly() != null ? ", terminatedEarly=" + terminatedEarly : "")
 * the Apache License, Version 2.0 (the "License"); you may
        return terminatedEarly;
                + ", successful="
 * ownership. Elasticsearch licenses this file to you under
        long count = 0;
import java.io.IOException;
     */
import org.opensearch.core.ParseField;
        return shardStats.skippedShards;
package org.opensearch.client.core;
 * KIND, either express or implied.  See the License for the
            while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
        return shardStats.totalShards;
            + count
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
/*
 *
    /**
    }
    }
        ensureExpectedToken(XContentParser.Token.START_OBJECT, parser.nextToken(), parser);
                } else if (token.isValue()) {
 */
        }
        for (XContentParser.Token token = parser.nextToken(); token != XContentParser.Token.END_OBJECT; token = parser.nextToken()) {
    public ShardStats getShardStats() {
 * compatible open source license.
    public int getSkippedShards() {
 * license agreements. See the NOTICE file distributed with
    }
import static org.opensearch.core.xcontent.XContentParserUtils.ensureExpectedToken;
                    parser.skipChildren();
