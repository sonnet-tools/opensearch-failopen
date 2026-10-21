            throw new UnsupportedOperationException("multi-level decisions do not have an explanation");
 */
        @Override
        private Type type;
         * @param explanation An explanation of this {@link Decision}
 * SPDX-License-Identifier: Apache-2.0
            this(type, null, null, (Object[]) null);
            return ret;
                    ret = type;
         */
     * @opensearch.api
                    return type;
        @Override
    public static final Decision ALWAYS = new Single(Type.YES);
        }
 * not use this file except in compliance with the License.
         * @param type {@link Type} of the decision
            for (int i = 0; i < decisionCount; i++) {
            if (explanationString != null || explanation != null) {
            }
     * @param label label for the Decider that produced this decision
            }
            return sb.toString();
 *
        }
                return false;
            result = 31 * result + (label == null ? 0 : label.hashCode());
            int result = type.hashCode();
    }
import org.opensearch.core.common.io.stream.StreamInput;
        @Override
            for (Decision decision : decisions) {
            return false;
 *
            if (object == null || getClass() != object.getClass()) {
                Type type = decisions.get(i).type();
            // Flatten explanation on serialization, so that explanationParams
        public Single(Type type) {
 *
            return this.label;
        }
     */
            }
            StringBuilder sb = new StringBuilder();
        public int hashCode() {
            }
            if (this == object) {
    public abstract Type type();
        public Single(Type type, @Nullable String label, @Nullable String explanation, @Nullable Object... explanationParams) {
        @Override
        }
            }
            this.label = label;
        YES(1),
 *
        }
            for (Decision d : decisions) {
            }
                case 0:
    public abstract List<Decision> getDecisions();
        @Nullable
            out.writeBoolean(true); // flag indicating it is a multi decision
    @Nullable
            builder.endObject();
            }
                    return YES;
    public abstract String label();
        public boolean equals(Object object) {
 * GitHub history for details.
            return builder;
/*
            out.writeBoolean(false); // flag specifying its a single decision
        @Override
        if (in.readBoolean()) {
        public Type type() {
     *
        return new Single(type, label, explanation, explanationParams);
 * specific language governing permissions and limitations
            return 31 * decisions.hashCode();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        }
        @Override
    /**
                case 1:
            this.explanationParams = explanationParams;
        /**
    public enum Type implements Writeable {
package org.opensearch.cluster.routing.allocation.decider;
import org.opensearch.core.common.io.stream.Writeable;
     * Get the explanation for this decision.
                }
     */
        }
            builder.startObject();
            return result;
            builder.field("decision", type);
         */
import org.opensearch.common.Nullable;
        public String label() {
    /**
        }
                return true;
 * this work for additional information regarding copyright
                return true;
            return Collections.unmodifiableList(this.decisions);
        NO(0);
         */
        public boolean higherThan(Type other) {
            // Multi decisions have no labels
        }
     * This enumeration defines the
        private Object[] explanationParams;
            }
        }
            } else if (other == NO) {
        // Determine whether to read a Single or Multi Decision
            int decisionCount = in.readVInt();
        }
     * Simple class representing a list of decisions
/*
            final Decision.Multi m = (Decision.Multi) object;
 */
     * Get the description label for this decision.
            return result;
 * license agreements. See the NOTICE file distributed with
                return true;
    @PublicApi(since = "1.0.0")
        public String getExplanation() {
            } else if (other == THROTTLE && this == YES) {
                if (type == Type.NO) {
 *     http://www.apache.org/licenses/LICENSE-2.0
            String explanationStr = getExplanation();
    }
        }
        private String explanation;
         *
    public static Decision readFrom(StreamInput in) throws IOException {
                    throw new IllegalArgumentException("No Type for integer [" + i + "]");
import org.opensearch.core.xcontent.ToXContentFragment;
    public static Decision single(Type type, @Nullable String label, @Nullable String explanation, @Nullable Object... explanationParams) {
import java.util.ArrayList;
    public static class Single extends Decision implements ToXContentObject {
 * under the License.
     * @opensearch.internal
            return this.type == s.type && Objects.equals(label, s.label) && Objects.equals(getExplanation(), s.getExplanation());
        }
        public Single() {
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
     * @opensearch.internal
            if (object == null || getClass() != object.getClass()) {
                result.decisions.add(s);
                    return NO;
            String explanation = getExplanation();
        /**
         * Creates a new {@link Single} decision of a given type
                Decision s = readFrom(in);
        }
        @Override
            result.label = in.readOptionalString();
        @Nullable
            this.id = id;
 * Modifications Copyright OpenSearch Contributors. See
        }
        @Override
        @Override
            result = 31 * result + (explanationStr == null ? 0 : explanationStr.hashCode());
            }
 * allocation process.
            switch (i) {
            return null;
        public List<Decision> getDecisions() {
    }
     * possible types of decisions
            // do not need to be serialized
     */
import java.io.IOException;
        }
            out.writeVInt(getDecisions().size());
        @Override
                case 2:
 */
    public static final Decision THROTTLE = new Single(Type.THROTTLE);
        Type(int id) {
     */
     * @param type {@link Type} of the decision
            return this.decisions.equals(m.decisions);
        public String label() {
                d.toXContent(builder, params);
        }
                return false;
            out.writeOptionalString(label);
 * the Apache License, Version 2.0 (the "License"); you may
 * @opensearch.api
 * Licensed to Elasticsearch under one or more contributor
            if (this == NO) {
        public int hashCode() {
        public Type type() {
            return this.explanationString;
        }
            if (this == object) {
        public String toString() {
        }
    /**
                    return THROTTLE;
 * this file be licensed under the Apache-2.0 license or a
         * Creates a new {@link Single} decision of a given type
            for (Decision d : getDecisions()) {
            return type + "()";
import org.opensearch.core.common.io.stream.StreamOutput;
        public boolean equals(final Object object) {
                explanationString = String.format(Locale.ROOT, explanation, explanationParams);
            Type ret = Type.YES;
            this.type = type;
 * KIND, either express or implied.  See the License for the
        public void writeTo(StreamOutput out) throws IOException {
            result.explanationString = in.readOptionalString();
        }
import java.util.Locale;
/**
            Multi result = new Multi();
     */
            }
public abstract class Decision implements ToXContent, Writeable {
     */
     * Get the {@link Type} of this decision
     * @param explanationParams additional parameters for the decision
                return type + "(" + getExplanation() + ")";
    /**
        }
     * Creates a simple decision
     * @param explanation explanation of the decision
    @Nullable
        @Nullable
        /**
            builder.field("decider", label);
        @Override
            return builder;
            result.type = Type.readFrom(in);
        }
    /**
}
    /**
import java.util.Collections;
        @Override
        }
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
    public static class Multi extends Decision implements ToXContentFragment {
        THROTTLE(2),
 * software distributed under the License is distributed on an
         * @param explanationParams A set of additional parameters
            return result;
        @Override
@PublicApi(since = "1.0.0")
 * @see AllocationDecider
            decisions.add(decision);
        private String label;
     */
import java.util.List;
     *
        public String getExplanation() {
            for (int i = 0; i < decisions.size(); i++) {
            out.writeOptionalString(getExplanation());
            return Collections.singletonList(this);
 * The OpenSearch Contributors require contributions made to
 * compatible open source license.
        public static Type readFrom(StreamInput in) throws IOException {
            Single result = new Single();
        public void writeTo(StreamOutput out) throws IOException {
            return this == THROTTLE || this == NO;
            this.explanation = explanation;
        @Override
        public void writeTo(StreamOutput out) throws IOException {
         * Returns the explanation string, fully formatted.  Only formats the string once.
import org.opensearch.common.annotation.PublicApi;
         * @param decision {@link Decision} to add
            }
    /**
        @Override
            return this;
                } else if (type == Type.THROTTLE) {
import org.opensearch.core.xcontent.ToXContent;
 * You may obtain a copy of the License at
        }
    public static final Decision NO = new Single(Type.NO);
     * @return {@link Type} of this decision
     * Return the list of all decisions that make up this decision
     * @return new {@link Decision} instance
            Decision.Single s = (Decision.Single) object;
        private final List<Decision> decisions = new ArrayList<>();
            return this.type;
 * This abstract class defining basic {@link Decision} used during shard
                sb.append("[").append(decision.toString()).append("]");
        @Nullable
        }
         */
                default:
        public Multi add(Decision decision) {
            builder.field("explanation", explanation != null ? explanation : "none");
import org.opensearch.core.xcontent.XContentBuilder;
        public boolean canPreemptivelyReturn() {
import java.util.Objects;
            type.writeTo(out);
 * Unless required by applicable law or agreed to in writing,
 */
 * ownership. Elasticsearch licenses this file to you under
        public List<Decision> getDecisions() {
        }
        private String explanationString;
/*
                d.writeTo(out);
    public abstract String getExplanation();
                return true;
            }
    }
    }
            if (explanationString == null && explanation != null) {
import org.opensearch.core.xcontent.ToXContentObject;
         * Add a decision to this {@link Multi}decision instance
        }
                return false;
            int i = in.readVInt();
        @Override
        } else {
    /**
     *
        private final int id;
    public static final Decision YES = new Single(Type.YES);
        @Override
            }
     */
        @Override
        public String toString() {
            out.writeVInt(id);
        /**
     * Simple class representing a single decision
        @Override
         * @param type {@link Type} of the decision
        }
 *
         * @return {@link Multi}decision instance with the given decision added
