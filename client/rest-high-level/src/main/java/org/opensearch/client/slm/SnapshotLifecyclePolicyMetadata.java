            this.startTime = startTime;
            SnapshotLifecyclePolicy policy = (SnapshotLifecyclePolicy) a[0];
    }
/*
                String state = (String) a[2];
}
        this.policyStats.toXContent(builder, params);
 */
        @Override
            long modifiedDate = (long) a[2];
        private static final ParseField UUID = new ParseField("uuid");
    }
    static final ParseField POLICY_STATS = new ParseField("stats");
        @Override
import org.opensearch.core.xcontent.ToXContentObject;
    }
            && Objects.equals(lastSuccess, other.lastSuccess)
    static final ParseField VERSION = new ParseField("version");
    private final long version;
            && Objects.equals(lastFailure, other.lastFailure)
            this.state = state;
            return builder;
        return lastFailure;
    }
        this.version = version;
        PARSER.declareLong(ConstructingObjectParser.constructorArg(), NEXT_EXECUTION_MILLIS);
        SnapshotLifecycleStats.SnapshotPolicyStats policyStats
        return Objects.hash(policy, version, modifiedDate, lastSuccess, lastFailure, nextExecution, policyStats);
        return version;
        private final String failure;
        return lastSuccess;
        private static final ConstructingObjectParser<SnapshotInProgress, Void> PARSER = new ConstructingObjectParser<>(
 * this file be licensed under the Apache-2.0 license or a
            "snapshot_in_progress",
        return policy;
            builder.timeField(START_TIME.getPreferredName(), "start_time", startTime);
        public String toString() {
import org.opensearch.core.xcontent.XContentParser;
        this.lastFailure = lastFailure;
        }
import org.opensearch.snapshots.SnapshotId;
        PARSER.declareObject(ConstructingObjectParser.optionalConstructorArg(), SnapshotInvocationRecord::parse, LAST_FAILURE);
        if (Objects.nonNull(lastFailure)) {
        return policy.getName();
            SnapshotInProgress sip = (SnapshotInProgress) a[6];
        private final SnapshotId snapshotId;
    public static final ConstructingObjectParser<SnapshotLifecyclePolicyMetadata, String> PARSER = new ConstructingObjectParser<>(
    @SuppressWarnings("unchecked")
        return this.policyStats;
    public SnapshotLifecycleStats.SnapshotPolicyStats getPolicyStats() {
    @Nullable
package org.opensearch.client.slm;
        if (getClass() != obj.getClass()) {
    static final ParseField SNAPSHOT_IN_PROGRESS = new ParseField("in_progress");
    ) {
        builder.endObject();
        public int hashCode() {
        PARSER.declareObject(ConstructingObjectParser.constructorArg(), SnapshotLifecyclePolicy::parse, POLICY);
        return builder;
            SnapshotInvocationRecord lastSuccess = (SnapshotInvocationRecord) a[3];
            }
    }
import org.opensearch.common.Nullable;
        private static final ParseField STATE = new ParseField("state");
 * GitHub history for details.
            }
        @Override
        PARSER.declareObject(ConstructingObjectParser.optionalConstructorArg(), SnapshotInvocationRecord::parse, LAST_SUCCESS);
            builder.field(LAST_SUCCESS.getPreferredName(), lastSuccess);
    @Nullable
            builder.startObject();
        }
            return new SnapshotLifecyclePolicyMetadata(policy, version, modifiedDate, lastSuccess, lastFailure, nextExecution, sip, stats);
            if (obj.getClass() != getClass()) {
    private final long nextExecution;
 * SPDX-License-Identifier: Apache-2.0
    }
    public boolean equals(Object obj) {
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
        }
        private static final ParseField FAILURE = new ParseField("failure");
    public int hashCode() {
            this.snapshotId = snapshotId;
        }
    public static class SnapshotInProgress implements ToXContentObject {
        );
            this.failure = failure;
        this.nextExecution = nextExecution;
        long version,
    @Override
        SnapshotInvocationRecord lastFailure,
    static final ParseField MODIFIED_DATE = new ParseField("modified_date");
    public long getNextExecution() {
 * software distributed under the License is distributed on an
            PARSER.declareString(ConstructingObjectParser.constructorArg(), STATE);
 *
        PARSER.declareObject(
    static final ParseField MODIFIED_DATE_MILLIS = new ParseField("modified_date_millis");
        public boolean equals(Object obj) {
 * under the License.
        );
 * You may obtain a copy of the License at
 * this work for additional information regarding copyright
                && Objects.equals(state, other.state)
 *
 * Modifications Copyright OpenSearch Contributors. See
            }
        private static final ParseField NAME = new ParseField("name");
import org.opensearch.core.ParseField;
            if (failure != null) {
        long modifiedDate,
            SnapshotInvocationRecord lastFailure = (SnapshotInvocationRecord) a[4];
    private final long modifiedDate;
 * the Apache License, Version 2.0 (the "License"); you may
    public SnapshotInvocationRecord getLastFailure() {
        builder.startObject(POLICY_STATS.getPreferredName());
        }
 * KIND, either express or implied.  See the License for the
 * ownership. Elasticsearch licenses this file to you under
                return false;
        PARSER.declareLong(ConstructingObjectParser.constructorArg(), VERSION);
        }
    static final ParseField NEXT_EXECUTION_MILLIS = new ParseField("next_execution_millis");
 *
                String failure = (String) a[4];
            (p, c) -> SnapshotLifecycleStats.SnapshotPolicyStats.parse(p, "policy"),
            builder.field(SNAPSHOT_IN_PROGRESS.getPreferredName(), snapshotInProgress);
    public SnapshotLifecyclePolicy getPolicy() {
        return this.snapshotInProgress;
        if (obj == null) {
import java.io.IOException;
 */
                SnapshotId id = new SnapshotId((String) a[0], (String) a[1]);
        long nextExecution,
                && Objects.equals(failure, other.failure);
        PARSER.declareObject(ConstructingObjectParser.optionalConstructorArg(), SnapshotInProgress::parse, SNAPSHOT_IN_PROGRESS);
        SnapshotLifecyclePolicyMetadata other = (SnapshotLifecyclePolicyMetadata) obj;
        return Objects.equals(policy, other.policy)
        "snapshot_policy_metadata",
    static {
    }
            return false;
            && Objects.equals(nextExecution, other.nextExecution)
    @Nullable
    private final SnapshotLifecycleStats.SnapshotPolicyStats policyStats;
                return new SnapshotInProgress(id, state, start, failure);
        this.policy = policy;
    }
    @Override
            return Strings.toString(MediaTypeRegistry.JSON, this);
        static {
            SnapshotInProgress other = (SnapshotInProgress) obj;
        builder.field(VERSION.getPreferredName(), version);
    }
        PARSER.declareLong(ConstructingObjectParser.constructorArg(), MODIFIED_DATE_MILLIS);
        builder.timeField(MODIFIED_DATE_MILLIS.getPreferredName(), MODIFIED_DATE.getPreferredName(), modifiedDate);
 * not use this file except in compliance with the License.
        if (snapshotInProgress != null) {
        }
    public long getModifiedDate() {
            SnapshotLifecycleStats.SnapshotPolicyStats stats = (SnapshotLifecycleStats.SnapshotPolicyStats) a[7];
    public SnapshotInProgress getSnapshotInProgress() {
        private static SnapshotInProgress parse(XContentParser parser, String name) {
        }
            ConstructingObjectParser.constructorArg(),
 * specific language governing permissions and limitations
import org.opensearch.core.xcontent.XContentBuilder;
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.core.xcontent.ConstructingObjectParser;
    }
import org.opensearch.core.common.Strings;
    }
            if (obj == null) {
        private final String state;
            long nextExecution = (long) a[5];
            builder.endObject();
 * Licensed to Elasticsearch under one or more contributor
            && Objects.equals(policyStats, other.policyStats);
            PARSER.declareLong(ConstructingObjectParser.constructorArg(), START_TIME);
    static final ParseField LAST_SUCCESS = new ParseField("last_success");
        this.policyStats = policyStats;
        return this.nextExecution;
    static final ParseField NEXT_EXECUTION = new ParseField("next_execution");
 * license agreements. See the NOTICE file distributed with
            builder.field(LAST_FAILURE.getPreferredName(), lastFailure);
    public static SnapshotLifecyclePolicyMetadata parse(XContentParser parser, String id) {
/*
            true,
            a -> {
        this.lastSuccess = lastSuccess;
    }
    public String getName() {
        SnapshotLifecyclePolicy policy,
    );
import java.util.Objects;
import org.opensearch.core.xcontent.MediaTypeRegistry;
    private final SnapshotInvocationRecord lastSuccess;
                builder.field(FAILURE.getPreferredName(), failure);
            PARSER.declareString(ConstructingObjectParser.optionalConstructorArg(), FAILURE);
        builder.timeField(NEXT_EXECUTION_MILLIS.getPreferredName(), NEXT_EXECUTION.getPreferredName(), nextExecution);
        }
    static final ParseField POLICY = new ParseField("policy");
 * The OpenSearch Contributors require contributions made to
 * compatible open source license.
        }
    }
    }
            return false;
            return Objects.hash(snapshotId, state, startTime, failure);
    private final SnapshotInvocationRecord lastFailure;
            && Objects.equals(modifiedDate, other.modifiedDate)
            builder.field(STATE.getPreferredName(), state);
        return PARSER.apply(parser, id);
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
 */
    private final SnapshotLifecyclePolicy policy;
    static final ParseField LAST_FAILURE = new ParseField("last_failure");
    private final SnapshotInProgress snapshotInProgress;
        }
        private final long startTime;
            return PARSER.apply(parser, null);
 *    http://www.apache.org/licenses/LICENSE-2.0
        return modifiedDate;
public class SnapshotLifecyclePolicyMetadata implements ToXContentObject {
    @Nullable
/*
            long version = (long) a[1];
            builder.field(NAME.getPreferredName(), snapshotId.getName());
        builder.field(POLICY.getPreferredName(), policy);
            POLICY_STATS
            PARSER.declareString(ConstructingObjectParser.constructorArg(), UUID);
            }
                long start = (long) a[3];
    @Override
        builder.endObject();
    public long getVersion() {
        this.modifiedDate = modifiedDate;
        }
        if (Objects.nonNull(lastSuccess)) {
        public SnapshotInProgress(SnapshotId snapshotId, String state, long startTime, @Nullable String failure) {
    }
        builder.startObject();
            return Objects.equals(snapshotId, other.snapshotId)
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        SnapshotInvocationRecord lastSuccess,
                return false;
        @Nullable SnapshotInProgress snapshotInProgress,
        private static final ParseField START_TIME = new ParseField("start_time_millis");
        this.snapshotInProgress = snapshotInProgress;
    public SnapshotLifecyclePolicyMetadata(
    public SnapshotInvocationRecord getLastSuccess() {
        a -> {
    }
        @Override
            builder.field(UUID.getPreferredName(), snapshotId.getUUID());
        }
            PARSER.declareString(ConstructingObjectParser.constructorArg(), NAME);
                && startTime == other.startTime
            && Objects.equals(version, other.version)
