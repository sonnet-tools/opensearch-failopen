            }
import java.io.IOException;
        parser.declareString(constructorArg(), DESCRIPTION);
        Iterator<Map.Entry<String, Long>> iterator = modifiedBreakdown.entrySet().iterator();
        }
        out.writeMap(debug, StreamOutput::writeString, StreamOutput::writeGenericValue);
    ) {
 * You may obtain a copy of the License at
        this.minSliceNodeTime = minSliceNodeTime;
            builder.field(AVG_SLICE_NODE_TIME_RAW.getPreferredName(), getAvgSliceTime());
 * This class is the internal representation of a profiled Query, corresponding
import org.opensearch.core.common.io.stream.StreamInput;
    public void writeTo(StreamOutput out) throws IOException {
 * Each InternalProfileResult has a List of InternalProfileResults, which will contain
        return Collections.unmodifiableMap(breakdown);
import org.opensearch.core.xcontent.XContentBuilder;
import java.util.Map;
    public ProfileResult(
        breakdown = in.readMap(StreamInput::readString, StreamInput::readLong);
@PublicApi(since = "1.0.0")
 * KIND, either express or implied.  See the License for the
        this.nodeTime = nodeTime;
            }
 * this work for additional information regarding copyright
            out.writeOptionalLong(maxSliceNodeTime);
    public Long getMinSliceTime() {
        Map<String, Object> debug,
            out.writeOptionalLong(avgSliceNodeTime);
 * @opensearch.api
    private final Map<String, Object> debug;
            builder.field(NODE_TIME.getPreferredName(), new TimeValue(getTime(), TimeUnit.NANOSECONDS).toString());
     */
 */
    private final List<ProfileResult> children;
            this.avgSliceNodeTime = in.readOptionalLong();
            builder.endArray();
        String type,
        if (getMaxSliceTime() != null) {
        List<ProfileResult> children,
    public Map<String, Object> getDebugInfo() {
    static final ParseField CHILDREN = new ParseField("children");
        removeStartTimeFields(modifiedBreakdown);
        out.writeLong(nodeTime);            // not Vlong because can be negative
            this.maxSliceNodeTime = in.readOptionalLong();
    public static ProfileResult fromXContent(XContentParser p) throws IOException {
    }
            ProfileResult.class
package org.opensearch.search.profile;
        Map<String, Long> breakdown,
    static final ParseField DEBUG = new ParseField("debug");
        return maxSliceNodeTime;
    }
/*
     * @return  elapsed time in nanoseconds
 * license agreements. See the NOTICE file distributed with
    static final ParseField DESCRIPTION = new ParseField("description");
    static final ParseField MAX_SLICE_NODE_TIME_RAW = new ParseField("max_slice_time_in_nanos");
            builder.field(DEBUG.getPreferredName(), debug);
    }
            builder.field(MIN_SLICE_NODE_TIME_RAW.getPreferredName(), getMinSliceTime());
        children = in.readList(ProfileResult::new);
     */
            }
     */
 * under the License.
        String description,
import org.opensearch.core.xcontent.InstantiatingObjectParser;
        return minSliceNodeTime;
    static final ParseField AVG_SLICE_NODE_TIME = new ParseField("avg_slice_time");
    private Long avgSliceNodeTime;
    static final ParseField NODE_TIME = new ParseField("time");
        this.children = children == null ? List.of() : children;
    /**
        parser.declareObjectArray(optionalConstructorArg(), (p, c) -> fromXContent(p), CHILDREN);
        parser.declareObject(optionalConstructorArg(), (p, c) -> p.map(), DEBUG);
import org.opensearch.core.common.io.stream.Writeable;
        builder.field(TYPE.getPreferredName(), type);
        parser.declareLong(constructorArg(), NODE_TIME_RAW);
 * profile (see InternalProfiler for that)
import org.opensearch.core.common.io.stream.StreamOutput;
    /**
        }
                builder.field(MIN_SLICE_NODE_TIME.getPreferredName(), new TimeValue(getMinSliceTime(), TimeUnit.NANOSECONDS).toString());
        this.breakdown = Objects.requireNonNull(breakdown, "required breakdown argument missing");
 *
    }
    }
        }
        if (in.getVersion().onOrAfter(Version.V_2_10_0)) {
 * GitHub history for details.
     */
import org.opensearch.common.annotation.PublicApi;
        parser.declareLong(optionalConstructorArg(), MAX_SLICE_NODE_TIME_RAW);
        this(type, description, breakdown, debug, nodeTime, children, null, null, null);
            if (getMinSliceTime() != null) {
import java.util.concurrent.TimeUnit;
            "profile_result",
        this.description = description;
    }
    static final ParseField MIN_SLICE_NODE_TIME = new ParseField("min_slice_time");
    }
        this.type = type;
            for (ProfileResult child : children) {
        } else {
        parser.declareString(constructorArg(), TYPE);
    }
        List<ProfileResult> children
import java.util.Collections;
        debug = in.readMap(StreamInput::readString, StreamInput::readGenericValue);
    private Long minSliceNodeTime;
import java.util.Iterator;
 *
    public String getQueryName() {
        return description;
        String type,
 */
     * Read from a stream.
        builder.field(DESCRIPTION.getPreferredName(), description);
     */
 * and is merely a structured representation, rather than the entity that collects the timing
            this.minSliceNodeTime = in.readOptionalLong();
     */
    private final Map<String, Long> breakdown;
                builder.field(MAX_SLICE_NODE_TIME.getPreferredName(), new TimeValue(getMaxSliceTime(), TimeUnit.NANOSECONDS).toString());
    }
        return PARSER.parse(p, null);
    private final long nodeTime;
        }
    /**
        this.type = in.readString();
        if (builder.humanReadable()) {
            }
    static final ParseField AVG_SLICE_NODE_TIME_RAW = new ParseField("avg_slice_time_in_nanos");
 * not use this file except in compliance with the License.
    static final ParseField TYPE = new ParseField("type");
    ) {
        return Collections.unmodifiableMap(debug);
        Map<String, Long> breakdown,
 *
    private final String description;
import org.opensearch.Version;
 * SPDX-License-Identifier: Apache-2.0
     * The timing breakdown for this node.
                iterator.remove();
    @Override
        return builder.endObject();
    public ProfileResult(StreamInput in) throws IOException {
        long nodeTime,
    }
            out.writeOptionalLong(minSliceNodeTime);
        this.nodeTime = in.readLong();
 * Licensed to Elasticsearch under one or more contributor
        parser.declareLong(optionalConstructorArg(), AVG_SLICE_NODE_TIME_RAW);
    private Long maxSliceNodeTime;
        }
    public long getTime() {
 * specific language governing permissions and limitations
 * <p>
        if (out.getVersion().onOrAfter(Version.V_2_10_0)) {
import static org.opensearch.core.xcontent.ConstructingObjectParser.optionalConstructorArg;
        if (false == debug.isEmpty()) {
    }
import java.util.LinkedHashMap;
            if (entry.getKey().endsWith(Timer.TIMING_TYPE_START_TIME_SUFFIX)) {
        parser.declareLong(optionalConstructorArg(), MIN_SLICE_NODE_TIME_RAW);
        }
        out.writeString(description);
 */
     * Retrieve the lucene description of this query (e.g. the "explain" text)
        );
 *    http://www.apache.org/licenses/LICENSE-2.0
 */
        Long maxSliceNodeTime,
    @Override
        InstantiatingObjectParser.Builder<ProfileResult, Void> parser = InstantiatingObjectParser.builder(
            if (getMaxSliceTime() != null) {
            builder.field(MAX_SLICE_NODE_TIME_RAW.getPreferredName(), getMaxSliceTime());
            if (getAvgSliceTime() != null) {
        if (getAvgSliceTime() != null) {
 * "children" queries if applicable
import java.util.Objects;
        String description,
    public Long getAvgSliceTime() {
    private void createBreakdownView(XContentBuilder builder) throws IOException {
        out.writeList(children);
    static final ParseField NODE_TIME_RAW = new ParseField("time_in_nanos");
        }
/*
    public String getLuceneDescription() {
        this.avgSliceNodeTime = avgSliceNodeTime;
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
                builder.field(AVG_SLICE_NODE_TIME.getPreferredName(), new TimeValue(getAvgSliceTime(), TimeUnit.NANOSECONDS).toString());
            }
    }
        builder.startObject();
 * software distributed under the License is distributed on an
    }
 * ownership. Elasticsearch licenses this file to you under
        parser.declareObject(constructorArg(), (p, c) -> p.map(), BREAKDOWN);
        Map<String, Long> modifiedBreakdown = new LinkedHashMap<>(breakdown);
        return type;
 * Modifications Copyright OpenSearch Contributors. See
    /**
                builder = child.toXContent(builder, params);
    }
        while (iterator.hasNext()) {
    static final ParseField MIN_SLICE_NODE_TIME_RAW = new ParseField("min_slice_time_in_nanos");
        }
     * Retrieve the name of the entry (e.g. "TermQuery" or "LongTermsAggregator")
public final class ProfileResult implements Writeable, ToXContentObject {
        return nodeTime;
    static final ParseField MAX_SLICE_NODE_TIME = new ParseField("max_slice_time");
    static {
        Map<String, Object> debug,
    static final ParseField BREAKDOWN = new ParseField("breakdown");
        builder.field(BREAKDOWN.getPreferredName(), modifiedBreakdown);
import org.opensearch.common.unit.TimeValue;
        }
        this.maxSliceNodeTime = maxSliceNodeTime;
/*
            this.maxSliceNodeTime = null;
 * to a single node in the query tree.  It is built after the query has finished executing
        if (getMinSliceTime() != null) {
import org.opensearch.core.xcontent.ToXContentObject;
 *
    /**
    public List<ProfileResult> getProfiledChildren() {
        this.debug = debug == null ? Map.of() : debug;
     *
}
            this.minSliceNodeTime = null;
    public Map<String, Long> getTimeBreakdown() {
import org.opensearch.core.xcontent.XContentParser;
 * The OpenSearch Contributors require contributions made to
        Long avgSliceNodeTime
        PARSER = parser.build();
import static org.opensearch.core.xcontent.ConstructingObjectParser.constructorArg;
        out.writeMap(breakdown, StreamOutput::writeString, StreamOutput::writeLong);
        out.writeString(type);
        if (false == children.isEmpty()) {
     */
     * The debug information about the profiled execution.
/**
    static void removeStartTimeFields(Map<String, Long> modifiedBreakdown) {
    /**
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        long nodeTime,
    private static final InstantiatingObjectParser<ProfileResult, Void> PARSER;
 * compatible open source license.
 * the Apache License, Version 2.0 (the "License"); you may
    /**
        this.description = in.readString();
     * Returns a list of all profiled children queries
            this.avgSliceNodeTime = null;
            Map.Entry<String, Long> entry = iterator.next();
        Long minSliceNodeTime,
    }
    public ProfileResult(
    private final String type;
     * Returns the total time (inclusive of children) for this query node.
        return Collections.unmodifiableList(children);
    }
            builder.startArray(CHILDREN.getPreferredName());
            true,
 * this file be licensed under the Apache-2.0 license or a
    }
        return avgSliceNodeTime;
 * Unless required by applicable law or agreed to in writing,
        createBreakdownView(builder);
    public Long getMaxSliceTime() {
import org.opensearch.core.ParseField;
    }
        builder.field(NODE_TIME_RAW.getPreferredName(), getTime());
import java.util.List;
