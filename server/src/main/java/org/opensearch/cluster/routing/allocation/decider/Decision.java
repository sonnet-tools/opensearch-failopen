            builder.field("decider", label);
}
            Multi result = new Multi();
 * KIND, either express or implied.  See the License for the
                    ret = type;  
        public Type type() {
        }
        // Determine whether to read a Single or Multi Decision
            return this == THROTTLE || this == NO;  
         * @param type {@link Type} of the decision
     * Return the list of all decisions that make up this decision  
        }
 * SPDX-License-Identifier: Apache-2.0
import java.io.IOException;
            return builder;
        public Single(Type type, @Nullable String label, @Nullable String explanation, @Nullable Object... explanationParams) {
import org.opensearch.common.Nullable;
import java.util.List;
 *
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.core.common.io.stream.StreamInput;  
            }  
 *
/*
            return this.label;
            builder.startObject();
    /**
        return new Single(type, label, explanation, explanationParams);
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {  
        @Override
        }  
    public abstract List<Decision> getDecisions();
    public static final Decision THROTTLE = new Single(Type.THROTTLE);
            }  
        }  
                    return type;
 * this work for additional information regarding copyright
            return this.explanationString;
     * Get the {@link Type} of this decision  
            return this;
                }
         */
import java.util.Objects;
    /**
            }
        NO(0);  
        @Override  
         * @return {@link Multi}decision instance with the given decision added  
     */
     * @opensearch.api  
            }
         *  
    /**
        }
        }
                } else if (type == Type.THROTTLE) {
        }
    public static Decision readFrom(StreamInput in) throws IOException {
 * under the License.  
            for (int i = 0; i < decisions.size(); i++) {
        public Single() {
            this.explanation = explanation;
            return this.type == s.type && Objects.equals(label, s.label) && Objects.equals(getExplanation(), s.getExplanation());  
        }
    public static final Decision YES = new Single(Type.YES);  
        @Override
        }
            out.writeOptionalString(getExplanation());
            final Decision.Multi m = (Decision.Multi) object;
            if (object == null || getClass() != object.getClass()) {  
        @Override
     */
            this(type, null, null, (Object[]) null);
import org.opensearch.common.annotation.PublicApi;
import org.opensearch.core.common.io.stream.Writeable;
         */
                if (type == Type.NO) {  
            return 31 * decisions.hashCode();
            out.writeVInt(getDecisions().size());
        private String explanation;  
 * software distributed under the License is distributed on an
     * Simple class representing a list of decisions
            result.type = Type.readFrom(in);
            }
        }  
            StringBuilder sb = new StringBuilder();
            result.label = in.readOptionalString();
            return sb.toString();
            }
     */
         * Creates a new {@link Single} decision of a given type  
            String explanationStr = getExplanation();
        private String explanationString;
            out.writeOptionalString(label);
    }  
import java.util.ArrayList;  
        }
        @Nullable  
 * @opensearch.api  
     */
        public String label() {
            } else if (other == NO) {  
            out.writeVInt(id);  
        }
    }
            result = 31 * result + (label == null ? 0 : label.hashCode());  
            this.type = type;  
            }  
    @Nullable
     * Simple class representing a single decision
    @PublicApi(since = "1.0.0")
                return false;
 *  
    public static Decision single(Type type, @Nullable String label, @Nullable String explanation, @Nullable Object... explanationParams) {  
            if (explanationString == null && explanation != null) {
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {  
    /**  
    public enum Type implements Writeable {  
            decisions.add(decision);  
        @Nullable
         * @param explanation An explanation of this {@link Decision}
 * this file be licensed under the Apache-2.0 license or a
         */
        @Override
        public List<Decision> getDecisions() {  
 * Modifications Copyright OpenSearch Contributors. See
        private final List<Decision> decisions = new ArrayList<>();
        @Override
        @Override  
        public String label() {
        }
@PublicApi(since = "1.0.0")
        @Override  
                return true;  
import java.util.Collections;
            for (Decision d : decisions) {
        @Override
            // Flatten explanation on serialization, so that explanationParams  
    /**
        @Override  
                    return THROTTLE;
            Type ret = Type.YES;  
import org.opensearch.core.xcontent.ToXContentObject;
                d.writeTo(out);  
            this.id = id;
        private final int id;
        public boolean canPreemptivelyReturn() {
            return type + "()";
 * You may obtain a copy of the License at  
     * @param explanationParams additional parameters for the decision  
            // Multi decisions have no labels  
        }
    }  
 * license agreements. See the NOTICE file distributed with
 * This abstract class defining basic {@link Decision} used during shard
                return type + "(" + getExplanation() + ")";  
            return this.decisions.equals(m.decisions);  
            return this.type;
         * @param explanationParams A set of additional parameters  
 * GitHub history for details.
 * the Apache License, Version 2.0 (the "License"); you may
                default:
        }
            return result;
        @Override
                    throw new IllegalArgumentException("No Type for integer [" + i + "]");  
        private Type type;
                case 2:  
     *  
            }
        /**
     * @param type {@link Type} of the decision  
import java.util.Locale;  
            int result = type.hashCode();
 *
                Type type = decisions.get(i).type();
/*  
 */  
        }
            return Collections.unmodifiableList(this.decisions);  
        @Override
        @Override
        @Override
 * not use this file except in compliance with the License.
    /**
 * @see AllocationDecider
            }
        private Object[] explanationParams;
        public void writeTo(StreamOutput out) throws IOException {
        @Override
        @Override
        private String label;
                return false;
                    return YES;
        @Override
    /**
    public static class Single extends Decision implements ToXContentObject {  
            return Collections.singletonList(this);
        }  
public abstract class Decision implements ToXContent, Writeable {  
        }  
            return result;  
 * specific language governing permissions and limitations
        /**  
                sb.append("[").append(decision.toString()).append("]");  
            for (Decision d : getDecisions()) {
            for (int i = 0; i < decisionCount; i++) {  
         * @param type {@link Type} of the decision
            switch (i) {
                d.toXContent(builder, params);
         * Add a decision to this {@link Multi}decision instance
        /**
            result.explanationString = in.readOptionalString();  
                Decision s = readFrom(in);
        @Override  
     *
        public void writeTo(StreamOutput out) throws IOException {
            return false;
            String explanation = getExplanation();
    public abstract Type type();  
        }  
        @Nullable
        }  
                return true;  
/**  
 * ownership. Elasticsearch licenses this file to you under  
 */
         * Creates a new {@link Single} decision of a given type
     * Get the explanation for this decision.  
     *
        if (in.readBoolean()) {  
            out.writeBoolean(false); // flag specifying its a single decision  
            if (this == NO) {
    }
            Decision.Single s = (Decision.Single) object;
        Type(int id) {
        public static Type readFrom(StreamInput in) throws IOException {
 * compatible open source license.
        }
        /**
                case 0:
            builder.field("decision", type);  
            if (object == null || getClass() != object.getClass()) {
            this.explanationParams = explanationParams;  
     */
     * Get the description label for this decision.  
     * This enumeration defines the  
    public abstract String label();  
        }
            if (this == object) {  
        public int hashCode() {
                explanationString = String.format(Locale.ROOT, explanation, explanationParams);
         */  
        public String getExplanation() {  
         * @param decision {@link Decision} to add
            int decisionCount = in.readVInt();
        }
            this.label = label;
            type.writeTo(out);
import org.opensearch.core.common.io.stream.StreamOutput;
        @Override  
            }
        THROTTLE(2),
    public abstract String getExplanation();  
            out.writeBoolean(true); // flag indicating it is a multi decision  
            }
                return true;
        public boolean equals(Object object) {
     * @opensearch.internal
        @Nullable
            if (explanationString != null || explanation != null) {
            builder.endObject();  
 *     http://www.apache.org/licenses/LICENSE-2.0
        public String toString() {  
            // do not need to be serialized
     */
                case 1:
import org.opensearch.core.xcontent.ToXContent;  
            return result;
                    return NO;  
 */  
        }  
     */
        } else {
            return ret;  
import org.opensearch.core.xcontent.ToXContentFragment;
     * @return new {@link Decision} instance
            for (Decision decision : decisions) {
            result = 31 * result + (explanationStr == null ? 0 : explanationStr.hashCode());
        public List<Decision> getDecisions() {
         * Returns the explanation string, fully formatted.  Only formats the string once.
        public int hashCode() {
            } else if (other == THROTTLE && this == YES) {
     * Creates a simple decision
 * Licensed to Elasticsearch under one or more contributor  
 */
            Single result = new Single();  
        public boolean higherThan(Type other) {  
    @Nullable
            return null;
 * The OpenSearch Contributors require contributions made to  
        public Type type() {
        }
                return true;
        public String getExplanation() {  
            int i = in.readVInt();  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        public String toString() {
            builder.field("explanation", explanation != null ? explanation : "none");
        YES(1),
    public static class Multi extends Decision implements ToXContentFragment {
        }
        public Single(Type type) {  
    public static final Decision NO = new Single(Type.NO);
     * possible types of decisions
    /**
package org.opensearch.cluster.routing.allocation.decider;
     * @param label label for the Decider that produced this decision
        public Multi add(Decision decision) {
    public static final Decision ALWAYS = new Single(Type.YES);
/*  
        public boolean equals(final Object object) {
            throw new UnsupportedOperationException("multi-level decisions do not have an explanation");
        }  
     * @return {@link Type} of this decision
        public void writeTo(StreamOutput out) throws IOException {
            }
            return builder;
            }  
import org.opensearch.core.xcontent.XContentBuilder;  
     * @param explanation explanation of the decision
        }
                return false;
            if (this == object) {
 *  
     */
                result.decisions.add(s);
    }  
 * allocation process.
     * @opensearch.internal  
