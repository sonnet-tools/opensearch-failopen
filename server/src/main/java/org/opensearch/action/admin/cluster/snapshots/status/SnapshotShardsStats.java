        return doneShards;
        int doneShards,
 * this work for additional information regarding copyright
import java.io.IOException;
     */
    public int hashCode() {
        this.startedShards = startedShards;
 * Unless required by applicable law or agreed to in writing,
            builder.field(Fields.STARTED, getStartedShards());
     * Number of shards with failed snapshot
        }
 * SPDX-License-Identifier: Apache-2.0
 *
            int doneShards = (int) parsedObjects[i++];
 */
                case STARTED:
            int i = 0;
        PARSER.declareInt(constructorArg(), new ParseField(Fields.INITIALIZING));
    /**
    }
                    finalizingShards++;
    }
 * software distributed under the License is distributed on an
    @Override
            int initializingShards = (int) parsedObjects[i++];
/*
 * Licensed to Elasticsearch under one or more contributor
            switch (shard.getStage()) {
import java.util.Collection;
    public int getStartedShards() {
        static final String FINALIZING = "finalizing";
        static final String SHARDS_STATS = "shards_stats";
    @Override
        if (finalizingShards != that.finalizingShards) return false;
 * the Apache License, Version 2.0 (the "License"); you may
            int finalizingShards = (int) parsedObjects[i++];
                    initializingShards++;
     * Inner Fields used for creating XContent and parsing
            int totalShards = (int) parsedObjects[i];
        SnapshotShardsStats that = (SnapshotShardsStats) o;
        return initializingShards;
 *
    /**
            builder.field(Fields.DONE, getDoneShards());
        PARSER.declareInt(constructorArg(), new ParseField(Fields.STARTED));
    ) {
        return startedShards;
 */
        if (startedShards != that.startedShards) return false;
     * Number of shards with the snapshot in the started stage
    public int getFailedShards() {
    );
     */
                case FAILURE:
        int failedShards,
        PARSER.declareInt(constructorArg(), new ParseField(Fields.TOTAL));
        result = 31 * result + totalShards;
        this.failedShards = failedShards;
    private int totalShards;
    private int initializingShards;
    /**
        if (doneShards != that.doneShards) return false;
     */
import static org.opensearch.core.xcontent.ConstructingObjectParser.constructorArg;
    public int getDoneShards() {
 *
    private int finalizingShards;
    }
     */
                    throw new IllegalArgumentException("Unknown stage type " + shard.getStage());
 * under the License.
        static final String DONE = "done";
        (Object[] parsedObjects) -> {
            builder.field(Fields.INITIALIZING, getInitializingShards());
     * @opensearch.internal
    static final class Fields {
                    failedShards++;
    }
    @Override
        return result;
                case INIT:
 * @opensearch.api
        static final String FAILED = "failed";
    }
        this.totalShards = totalShards;
     */
package org.opensearch.action.admin.cluster.snapshots.status;
/*
     * Total number of shards
        PARSER.declareInt(constructorArg(), new ParseField(Fields.FAILED));
    }
@PublicApi(since = "1.0.0")
            int failedShards = (int) parsedObjects[i++];
        if (this == o) return true;
 * KIND, either express or implied.  See the License for the
        result = 31 * result + finalizingShards;
        if (failedShards != that.failedShards) return false;
    private int startedShards;
        return failedShards;
    public static SnapshotShardsStats fromXContent(XContentParser parser) {
        builder.startObject();
    SnapshotShardsStats(Collection<SnapshotIndexShardStatus> shards) {
 * this file be licensed under the Apache-2.0 license or a
        return PARSER.apply(parser, null);
 */
        if (o == null || getClass() != o.getClass()) return false;
 * You may obtain a copy of the License at
    /**
            return new SnapshotShardsStats(initializingShards, startedShards, finalizingShards, doneShards, failedShards, totalShards);
        builder.endObject();
        result = 31 * result + startedShards;
        for (SnapshotIndexShardStatus shard : shards) {
    public boolean equals(Object o) {
 * GitHub history for details.
    }
    /**
        int result = initializingShards;
     */
     * Number of shards with the snapshot in the finalizing stage
    public SnapshotShardsStats(
import org.opensearch.common.annotation.PublicApi;
    public int getTotalShards() {
    }
/**
                    break;
    }
 * Modifications Copyright OpenSearch Contributors. See
        if (initializingShards != that.initializingShards) return false;
                    break;
        return totalShards;
                default:
                    doneShards++;
            builder.field(Fields.FINALIZING, getFinalizingShards());
    }
                    break;
    public int getInitializingShards() {
}
    private int failedShards;
            totalShards++;
import org.opensearch.core.xcontent.ConstructingObjectParser;
        PARSER.declareInt(constructorArg(), new ParseField(Fields.FINALIZING));
 * not use this file except in compliance with the License.
        Fields.SHARDS_STATS,
    }
        result = 31 * result + doneShards;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        result = 31 * result + failedShards;
    public int getFinalizingShards() {
    static {
        this.doneShards = doneShards;
            }
import org.opensearch.core.xcontent.XContentParser;
        int initializingShards,
                case FINALIZE:
        PARSER.declareInt(constructorArg(), new ParseField(Fields.DONE));
import org.opensearch.core.xcontent.XContentBuilder;
    /**
        static final String TOTAL = "total";
        }
 *     http://www.apache.org/licenses/LICENSE-2.0
     *
                case DONE:
        int startedShards,
 * license agreements. See the NOTICE file distributed with
                    break;
        this.finalizingShards = finalizingShards;
        return totalShards == that.totalShards;
                    startedShards++;
            int startedShards = (int) parsedObjects[i++];
        }
        int finalizingShards,
    }
        static final String INITIALIZING = "initializing";
     * Number of shards with completed snapshot
    }
    /**
import org.opensearch.core.xcontent.ToXContentObject;
    public XContentBuilder toXContent(XContentBuilder builder, ToXContent.Params params) throws IOException {
        return finalizingShards;
 * ownership. Elasticsearch licenses this file to you under
        int totalShards
 */
import org.opensearch.core.ParseField;
 *
        return builder;
     * Number of shards with the snapshot in the initializing stage
    static final ConstructingObjectParser<SnapshotShardsStats, Void> PARSER = new ConstructingObjectParser<>(
                    break;
/*
 * The OpenSearch Contributors require contributions made to
 * specific language governing permissions and limitations
import org.opensearch.core.xcontent.ToXContent;
    }
 * Status of a snapshot shards
        {
    private int doneShards;
        this.initializingShards = initializingShards;
            builder.field(Fields.TOTAL, getTotalShards());
        static final String STARTED = "started";
            builder.field(Fields.FAILED, getFailedShards());
public class SnapshotShardsStats implements ToXContentObject {
        true,
 * compatible open source license.
     */
