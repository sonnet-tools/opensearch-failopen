            final int successful,  
 * license agreements. See the NOTICE file distributed with
        }
/*
         * not match {@link #failed()} as some responses group together shard failures.
     * @return a broadcast response parsed from the specified parser
import org.opensearch.core.action.support.DefaultShardOperationFailedException;
        Shards(
         */
         * @return the number of skipped shards
    public static class Shards {  
            return failed;
            return total;
        private static final ParseField FAILED_FIELD = new ParseField("failed");  
     * Parses a broadcast response.
         * The failures corresponding to the shards on which a request failed to be executed against. Note that the number of failures might
            final int total,
 * Modifications Copyright OpenSearch Contributors. See
        this.shards = Objects.requireNonNull(shards);
 * SPDX-License-Identifier: Apache-2.0
     * @param parser the parser  
            final int failed,
        private final int failed;
 * You may obtain a copy of the License at  
         * @return the number of successful shards  
        return PARSER.parse(parser, null);
import java.util.Collections;
        public int successful() {
/**
 */
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
     */
 *    http://www.apache.org/licenses/LICENSE-2.0
                (int) a[0], // total
 * software distributed under the License is distributed on an
 *  
import org.opensearch.core.ParseField;
    static final ConstructingObjectParser<BroadcastResponse, Void> PARSER = new ConstructingObjectParser<>(  
     *
            SHARDS_PARSER.declareInt(ConstructingObjectParser.constructorArg(), FAILED_FIELD);
 * GitHub history for details.
 * this file be licensed under the Apache-2.0 license or a
        /**  
        private static final ParseField SKIPPED_FIELD = new ParseField("skipped");
         * The total number of shards on which a request was executed against.
        public Collection<DefaultShardOperationFailedException> failures() {  
            return successful;  
        private final int successful;
                a[4] == null ? Collections.emptyList() : (Collection<DefaultShardOperationFailedException>) a[4]
         * The number of shards on which a request failed to be executed against.
                (int) a[3], // failed
                ConstructingObjectParser.optionalConstructorArg(),  
import org.opensearch.core.xcontent.XContentParser;
        static final ConstructingObjectParser<Shards, Void> SHARDS_PARSER = new ConstructingObjectParser<>(
    }
            SHARDS_PARSER.declareInt(ConstructingObjectParser.constructorArg(), SUCCESSFUL_FIELD);
            this.total = total;
 * under the License.  
    }  
    protected static <T extends BroadcastResponse> void declareShardsField(ConstructingObjectParser<T, Void> PARSER) {
     *
        PARSER.declareObject(ConstructingObjectParser.constructorArg(), Shards.SHARDS_PARSER, SHARDS_FIELD);  
 * Represents a response to a request that is broadcast to a collection of shards.  
 * Unless required by applicable law or agreed to in writing,
         * @return the total number of shards
 */
     * @throws IOException if an I/O exception occurs parsing the response
            );  
 * The OpenSearch Contributors require contributions made to  
 *
        /**
        "broadcast_response",
 * ownership. Elasticsearch licenses this file to you under  
         *  
        }
 * this work for additional information regarding copyright
 * Licensed to Elasticsearch under one or more contributor  
            this.successful = successful;  
                DefaultShardOperationFailedException.PARSER,
         *  
            this.failures = Collections.unmodifiableCollection(Objects.requireNonNull(failures));  
public class BroadcastResponse {
        public int skipped() {
            a -> new Shards(  
        return shards;  
        private final int total;
        a -> new BroadcastResponse((Shards) a[0])
         */  
        public int total() {  
         * @return the failures
            this.failed = failed;
                a[2] == null ? 0 : (int) a[2], // skipped  
            SHARDS_PARSER.declareObjectArray(
/*  
    );  
         */
     */  
        static {  
    /**  
     * Represents the shard-level summary of the response execution.
            )  
         *
    }
     */
         * @return the number of failed shards
    private final Shards shards;
        private static final ParseField TOTAL_FIELD = new ParseField("total");  
        }  
    public Shards shards() {
            SHARDS_PARSER.declareInt(ConstructingObjectParser.optionalConstructorArg(), SKIPPED_FIELD);  
    }  
        declareShardsField(PARSER);  
    static {
        }
import org.opensearch.core.xcontent.ConstructingObjectParser;  
            return failures;
        ) {
        ); // failures
        }
import java.io.IOException;  
 * KIND, either express or implied.  See the License for the
            final int skipped,
 * the Apache License, Version 2.0 (the "License"); you may
            final Collection<DefaultShardOperationFailedException> failures  
        private final int skipped;  
import java.util.Collection;
    public static BroadcastResponse fromXContent(final XContentParser parser) throws IOException {
        private static final ParseField FAILURES_FIELD = new ParseField("failures");
    /**  
        }
     * Represents the results of a collection of shards on which a request was executed against.
         *
         */
import java.util.Objects;  
         * The number of successful shards on which a request was executed against.
        private final Collection<DefaultShardOperationFailedException> failures;
            SHARDS_PARSER.declareInt(ConstructingObjectParser.constructorArg(), TOTAL_FIELD);
                FAILURES_FIELD
    }
 */  
            "shards",
                (int) a[1], // successful
        }
 * specific language governing permissions and limitations
            this.skipped = skipped;
         *  
 * compatible open source license.
        private static final ParseField SUCCESSFUL_FIELD = new ParseField("successful");
        /**  
 * not use this file except in compliance with the License.
        @SuppressWarnings("unchecked")  
        public int failed() {  
package org.opensearch.client.core;
    /**  
     * @return the shard-level response summary  
         * The number of shards skipped by the request.  
 *
 */  
}
        /**
         */
/*  
            return skipped;
    protected BroadcastResponse(final Shards shards) {  
    private static final ParseField SHARDS_FIELD = new ParseField("_shards");
        /**
    }
