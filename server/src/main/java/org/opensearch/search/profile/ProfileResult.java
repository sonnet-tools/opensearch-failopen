            if (getAvgSliceTime() != null) {
        while (iterator.hasNext()) {
    ) {
        this.minSliceNodeTime = minSliceNodeTime;
        out.writeList(children);  
            }
     */
        out.writeString(description);
import static org.opensearch.core.xcontent.ConstructingObjectParser.optionalConstructorArg;
            builder.field(AVG_SLICE_NODE_TIME_RAW.getPreferredName(), getAvgSliceTime());
        this.type = type;  
        return maxSliceNodeTime;
    static final ParseField DEBUG = new ParseField("debug");
    static final ParseField MIN_SLICE_NODE_TIME_RAW = new ParseField("min_slice_time_in_nanos");  
    private final String type;
import java.io.IOException;
        this.maxSliceNodeTime = maxSliceNodeTime;  
public final class ProfileResult implements Writeable, ToXContentObject {
        Map<String, Long> breakdown,
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                builder.field(AVG_SLICE_NODE_TIME.getPreferredName(), new TimeValue(getAvgSliceTime(), TimeUnit.NANOSECONDS).toString());  
        children = in.readList(ProfileResult::new);
            Map.Entry<String, Long> entry = iterator.next();
     * Returns a list of all profiled children queries
        String type,
import org.opensearch.core.common.io.stream.StreamInput;
        Long maxSliceNodeTime,
import java.util.Collections;
        parser.declareObjectArray(optionalConstructorArg(), (p, c) -> fromXContent(p), CHILDREN);  
    /**
import java.util.LinkedHashMap;
    static final ParseField MAX_SLICE_NODE_TIME = new ParseField("max_slice_time");
import java.util.Map;  
    /**  
 * to a single node in the query tree.  It is built after the query has finished executing  
 * and is merely a structured representation, rather than the entity that collects the timing
        parser.declareLong(optionalConstructorArg(), MAX_SLICE_NODE_TIME_RAW);
    /**  
     * The debug information about the profiled execution.  
        out.writeString(type);
     */  
        parser.declareLong(constructorArg(), NODE_TIME_RAW);
import org.opensearch.core.xcontent.XContentBuilder;
     *
 *  
            this.avgSliceNodeTime = in.readOptionalLong();  
import org.opensearch.core.xcontent.XContentParser;
        if (false == children.isEmpty()) {  
            if (entry.getKey().endsWith(Timer.TIMING_TYPE_START_TIME_SUFFIX)) {  
        Map<String, Long> modifiedBreakdown = new LinkedHashMap<>(breakdown);  
 * "children" queries if applicable
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
    static final ParseField MAX_SLICE_NODE_TIME_RAW = new ParseField("max_slice_time_in_nanos");
    private Long avgSliceNodeTime;
 * @opensearch.api
    public ProfileResult(StreamInput in) throws IOException {
        InstantiatingObjectParser.Builder<ProfileResult, Void> parser = InstantiatingObjectParser.builder(
    }  
import java.util.concurrent.TimeUnit;
    }
        }  
        this.debug = debug == null ? Map.of() : debug;  
        return Collections.unmodifiableMap(debug);  
import org.opensearch.common.annotation.PublicApi;
import org.opensearch.core.xcontent.InstantiatingObjectParser;
        this.avgSliceNodeTime = avgSliceNodeTime;
        return nodeTime;  
    static final ParseField TYPE = new ParseField("type");
    }
 * not use this file except in compliance with the License.
        out.writeMap(debug, StreamOutput::writeString, StreamOutput::writeGenericValue);
    public static ProfileResult fromXContent(XContentParser p) throws IOException {
            ProfileResult.class
            for (ProfileResult child : children) {
 * KIND, either express or implied.  See the License for the
    private final Map<String, Long> breakdown;  
/*  
     */
        if (in.getVersion().onOrAfter(Version.V_2_10_0)) {  
            builder.endArray();
    }  
            }
            }
            builder.field(NODE_TIME.getPreferredName(), new TimeValue(getTime(), TimeUnit.NANOSECONDS).toString());
/**
    }  
        builder.field(NODE_TIME_RAW.getPreferredName(), getTime());  
            this.minSliceNodeTime = in.readOptionalLong();
    public ProfileResult(
/*  
    public Long getMinSliceTime() {
 * under the License.  
    }  
        PARSER = parser.build();
        Map<String, Long> breakdown,
     * Returns the total time (inclusive of children) for this query node.
        Iterator<Map.Entry<String, Long>> iterator = modifiedBreakdown.entrySet().iterator();  
        Long minSliceNodeTime,  
        }  
     */
 * this file be licensed under the Apache-2.0 license or a
     */
    /**
 * GitHub history for details.
        out.writeMap(breakdown, StreamOutput::writeString, StreamOutput::writeLong);
import java.util.Iterator;  
        Map<String, Object> debug,  
        parser.declareString(constructorArg(), TYPE);
        }  
}
            this.minSliceNodeTime = null;  
        }
import java.util.List;
        builder.field(TYPE.getPreferredName(), type);
        if (getMinSliceTime() != null) {
 * Each InternalProfileResult has a List of InternalProfileResults, which will contain
import org.opensearch.common.unit.TimeValue;  
        this.breakdown = Objects.requireNonNull(breakdown, "required breakdown argument missing");
    private Long minSliceNodeTime;
 *
@PublicApi(since = "1.0.0")  
        Map<String, Object> debug,
            true,
    public String getQueryName() {  
    }  
    static final ParseField NODE_TIME = new ParseField("time");  
        this.description = in.readString();
    static final ParseField CHILDREN = new ParseField("children");
    }  
 * SPDX-License-Identifier: Apache-2.0
     * The timing breakdown for this node.
    public long getTime() {
        );  
    static final ParseField MIN_SLICE_NODE_TIME = new ParseField("min_slice_time");
    private final Map<String, Object> debug;
    }
    public Map<String, Long> getTimeBreakdown() {
        this.children = children == null ? List.of() : children;
        String description,  
    static final ParseField BREAKDOWN = new ParseField("breakdown");
    /**  
    /**
                builder = child.toXContent(builder, params);  
 * <p>  
        out.writeLong(nodeTime);            // not Vlong because can be negative  
 */
        builder.field(DESCRIPTION.getPreferredName(), description);
        if (out.getVersion().onOrAfter(Version.V_2_10_0)) {
    }
 * Modifications Copyright OpenSearch Contributors. See
            this.maxSliceNodeTime = in.readOptionalLong();
            this.avgSliceNodeTime = null;
 * compatible open source license.
        long nodeTime,  
        breakdown = in.readMap(StreamInput::readString, StreamInput::readLong);  
        if (false == debug.isEmpty()) {
 *
    @Override
        return avgSliceNodeTime;  
import static org.opensearch.core.xcontent.ConstructingObjectParser.constructorArg;
                builder.field(MAX_SLICE_NODE_TIME.getPreferredName(), new TimeValue(getMaxSliceTime(), TimeUnit.NANOSECONDS).toString());  
        builder.field(BREAKDOWN.getPreferredName(), modifiedBreakdown);
        List<ProfileResult> children
import java.util.Objects;
    private void createBreakdownView(XContentBuilder builder) throws IOException {
        String description,
            }
        removeStartTimeFields(modifiedBreakdown);
            out.writeOptionalLong(minSliceNodeTime);  
import org.opensearch.core.common.io.stream.StreamOutput;  
 * the Apache License, Version 2.0 (the "License"); you may
 * specific language governing permissions and limitations
            builder.field(DEBUG.getPreferredName(), debug);  
    private static final InstantiatingObjectParser<ProfileResult, Void> PARSER;  
        parser.declareLong(optionalConstructorArg(), AVG_SLICE_NODE_TIME_RAW);  
        Long avgSliceNodeTime
            out.writeOptionalLong(avgSliceNodeTime);
 *  
        this.type = in.readString();  
    private Long maxSliceNodeTime;  
            this.maxSliceNodeTime = null;
        }
        debug = in.readMap(StreamInput::readString, StreamInput::readGenericValue);
        if (getAvgSliceTime() != null) {
        parser.declareObject(constructorArg(), (p, c) -> p.map(), BREAKDOWN);  
            builder.field(MIN_SLICE_NODE_TIME_RAW.getPreferredName(), getMinSliceTime());
        this.nodeTime = in.readLong();
        return description;  
            "profile_result",  
        parser.declareString(constructorArg(), DESCRIPTION);
        return PARSER.parse(p, null);
        this(type, description, breakdown, debug, nodeTime, children, null, null, null);
    ) {  
    }
 */  
import org.opensearch.Version;
     * Read from a stream.  
 * software distributed under the License is distributed on an
    }
        return Collections.unmodifiableMap(breakdown);
    static {
        return minSliceNodeTime;
 */  
 *    http://www.apache.org/licenses/LICENSE-2.0
    }  
        if (builder.humanReadable()) {  
        this.description = description;
import org.opensearch.core.ParseField;
        return type;
     * Retrieve the lucene description of this query (e.g. the "explain" text)  
        }
    static final ParseField AVG_SLICE_NODE_TIME = new ParseField("avg_slice_time");  
 * Unless required by applicable law or agreed to in writing,
        long nodeTime,
        if (getMaxSliceTime() != null) {
package org.opensearch.search.profile;
    static final ParseField DESCRIPTION = new ParseField("description");  
    @Override
import org.opensearch.core.xcontent.ToXContentObject;  
    static void removeStartTimeFields(Map<String, Long> modifiedBreakdown) {
        List<ProfileResult> children,
    public Long getMaxSliceTime() {  
    }  
    /**
            if (getMaxSliceTime() != null) {
        String type,  
     */
 * This class is the internal representation of a profiled Query, corresponding
 * You may obtain a copy of the License at  
 * The OpenSearch Contributors require contributions made to  
 * ownership. Elasticsearch licenses this file to you under  
    }
    public ProfileResult(
        builder.startObject();  
        }
    public Map<String, Object> getDebugInfo() {
            if (getMinSliceTime() != null) {
     * Retrieve the name of the entry (e.g. "TermQuery" or "LongTermsAggregator")
        parser.declareObject(optionalConstructorArg(), (p, c) -> p.map(), DEBUG);
            }
                iterator.remove();
    private final long nodeTime;
    private final String description;
     */
 * Licensed to Elasticsearch under one or more contributor  
            out.writeOptionalLong(maxSliceNodeTime);
    private final List<ProfileResult> children;  
        } else {
            builder.field(MAX_SLICE_NODE_TIME_RAW.getPreferredName(), getMaxSliceTime());
     * @return  elapsed time in nanoseconds  
    static final ParseField NODE_TIME_RAW = new ParseField("time_in_nanos");
    public List<ProfileResult> getProfiledChildren() {  
        createBreakdownView(builder);
        parser.declareLong(optionalConstructorArg(), MIN_SLICE_NODE_TIME_RAW);
 * profile (see InternalProfiler for that)
    }
 */
    public Long getAvgSliceTime() {
                builder.field(MIN_SLICE_NODE_TIME.getPreferredName(), new TimeValue(getMinSliceTime(), TimeUnit.NANOSECONDS).toString());  
    public void writeTo(StreamOutput out) throws IOException {  
        this.nodeTime = nodeTime;
    static final ParseField AVG_SLICE_NODE_TIME_RAW = new ParseField("avg_slice_time_in_nanos");
        return builder.endObject();
    }
        }  
    public String getLuceneDescription() {
    }
        return Collections.unmodifiableList(children);
            builder.startArray(CHILDREN.getPreferredName());
        }  
 * this work for additional information regarding copyright
 * license agreements. See the NOTICE file distributed with
import org.opensearch.core.common.io.stream.Writeable;
/*
