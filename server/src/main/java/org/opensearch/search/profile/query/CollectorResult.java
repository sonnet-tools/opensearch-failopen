    }
    }
            this.reduceTime = in.readLong();
        for (int i = 0; i < size; i++) {
 */
     * @return a list of children collectors/collector managers
    public static final String REASON_SEARCH_COUNT = "search_count";
     * The total elapsed time in reduce phase for this CollectorManager
 * this work for additional information regarding copyright
    /**
        this.reduceTime = reduceTime;
     * A more friendly representation of the Collector's class name
        }
    private static final ParseField SLICE_COUNT = new ParseField("slice_count");
            this.sliceCount = in.readVInt();
        return new CollectorResult(name, reason, time, reduceTime, maxSliceTime, minSliceTime, avgSliceTime, sliceCount, children);
 * compatible open source license.
            this.minSliceTime = in.readLong();
        return this.reduceTime;
    public static final String REASON_AGGREGATION_GLOBAL = "aggregation_global";
     */
            if (token == XContentParser.Token.FIELD_NAME) {
            builder.field(TIME.getPreferredName(), new TimeValue(getTime(), TimeUnit.NANOSECONDS).toString());
/*
        if (in.getVersion().onOrAfter(Version.V_2_9_0)) {
        long maxSliceTime = -1;
        return this.maxSliceTime;
public class CollectorResult implements ToXContentObject, Writeable {
        this.reason = in.readString();
        long minSliceTime,
     */
                } else if (TIME_NANOS.match(currentFieldName, parser.getDeprecationHandler())) {
            this.maxSliceTime = in.readLong();
            this.maxSliceTime = this.time;
            child.writeTo(out);
     * The total elapsed time for this Collector
            out.writeLong(minSliceTime);
                }
            }
        builder.field(REASON.getPreferredName(), getReason());
    /**
     */
        int sliceCount = 0;
 * the Apache License, Version 2.0 (the "License"); you may
    /**
import org.opensearch.common.unit.TimeValue;
    /**
 * this file be licensed under the Apache-2.0 license or a
    public CollectorResult(String collectorName, String reason, long time, List<CollectorResult> children) {
    private final long avgSliceTime;
    public static final String COLLECTOR_MANAGER = "CollectorManager";
    }
    private static final ParseField MAX_SLICE_TIME_NANOS = new ParseField("max_slice_time_in_nanos");
     */
import java.util.List;
        long minSliceTime = -1;
import static org.opensearch.core.xcontent.XContentParserUtils.ensureExpectedToken;
            CollectorResult child = new CollectorResult(in);
            builder.field(SLICE_COUNT.getPreferredName(), getSliceCount());
        this.time = in.readLong();
    private final long minSliceTime;
     * The segment slice count for this CollectorManager
        this.minSliceTime = minSliceTime;
        out.writeString(reason);
    public long getReduceTime() {
        this.collectorName = collectorName;
                } else if (TIME.match(currentFieldName, parser.getDeprecationHandler())) {
        XContentParser.Token token = parser.currentToken();
    public long getAvgSliceTime() {
        if (getName().contains(COLLECTOR_MANAGER)) {
    /**
    private final long maxSliceTime;
import org.opensearch.core.xcontent.ToXContentObject;
        builder.field(TIME_NANOS.getPreferredName(), getTime());
            this.sliceCount = 1;
    private static final ParseField REDUCE_TIME_NANOS = new ParseField("reduce_time_in_nanos");
     */
        }
    public CollectorResult(StreamInput in) throws IOException {
            } else {
 * KIND, either express or implied.  See the License for the
     */
    /**
    private static final ParseField AVG_SLICE_TIME_IN_NANOS = new ParseField("avg_slice_time_in_nanos");
        return this.collectorName;
        this.collectorName = in.readString();
            this.minSliceTime = this.time;
     * @return the profiled maximum slice time for this collector manager (inclusive of children)
import org.opensearch.core.xcontent.ToXContent;
        out.writeVInt(children.size());
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
import org.opensearch.core.xcontent.XContentParser;
        this.time = time;
 * embedded inside of a parent CollectorResult
    }
        String name = null, reason = null;
     * The minimum slice time for this CollectorManager
    /**
 * not use this file except in compliance with the License.
            this.avgSliceTime = this.time;
                    name = parser.text();
    }
 *
        for (CollectorResult child : children) {
                    while ((token = parser.nextToken()) != XContentParser.Token.END_ARRAY) {
    /**
                } else if (MIN_SLICE_TIME_IN_NANOS.match(currentFieldName, parser.getDeprecationHandler())) {
        this.maxSliceTime = maxSliceTime;
                    minSliceTime = parser.longValue();
                parser.skipChildren();
     * @return the lucene class name of the collector/collector manager
    private static final ParseField TIME = new ParseField("time");
    public XContentBuilder toXContent(XContentBuilder builder, ToXContent.Params params) throws IOException {
        return this.sliceCount;
    }
     * @return the profiled minimum slice time for this collector manager (inclusive of children)
        int sliceCount,
            builder = builder.startArray(CHILDREN.getPreferredName());
                    parser.skipChildren();
    }
            builder.field(MAX_SLICE_TIME_NANOS.getPreferredName(), getMaxSliceTime());
        if (builder.humanReadable()) {
        builder.field(NAME.getPreferredName(), getName());
                } else {
    private static final ParseField MIN_SLICE_TIME_IN_NANOS = new ParseField("min_slice_time_in_nanos");
     */
/*
                currentFieldName = parser.currentName();
    public long getTime() {
    @Override
     */
     */
        List<CollectorResult> children
    public static CollectorResult fromXContent(XContentParser parser) throws IOException {
    /**
     * @return the profiled segment slice count for this collector manager (inclusive of children)
 *
    public long getMinSliceTime() {
 * @opensearch.api
 * The OpenSearch Contributors require contributions made to
 * Public interface and serialization container for profiled timings of the
        return this.avgSliceTime;
                } else {
        if (!children.isEmpty()) {
    private static final ParseField REASON = new ParseField("reason");
        return this.minSliceTime;
package org.opensearch.search.profile.query;
        long time = -1;
    /**
    /**
                } else if (MAX_SLICE_TIME_NANOS.match(currentFieldName, parser.getDeprecationHandler())) {
    }
    private final int sliceCount;
     */
import java.util.ArrayList;
                } else if (SLICE_COUNT.match(currentFieldName, parser.getDeprecationHandler())) {
 */
    private final String collectorName;
 */
        this.children = new ArrayList<>(size);
 * specific language governing permissions and limitations
import org.opensearch.core.ParseField;
 * You may obtain a copy of the License at
            builder.field(REDUCE_TIME_NANOS.getPreferredName(), getReduceTime());
    /**
    public long getMaxSliceTime() {
    private final long reduceTime;
 *
    }
        out.writeLong(time);
    public String getName() {
        long avgSliceTime,
    /**
     * @return the profiled average slice time for this collector manager (inclusive of children)
    /**
 * Modifications Copyright OpenSearch Contributors. See
    public static final String REASON_SEARCH_TERMINATE_AFTER_COUNT = "search_terminate_after_count";
                builder = child.toXContent(builder, params);
    private static final ParseField CHILDREN = new ParseField("children");
 * Collectors used in the search.  Children CollectorResult's may be
            builder.field(MIN_SLICE_TIME_IN_NANOS.getPreferredName(), getMinSliceTime());
     * A list of children collectors "embedded" inside this collector
@PublicApi(since = "1.0.0")
    @Override
            out.writeVInt(sliceCount);
     */
    /**
    public static final String REASON_SEARCH_MIN_SCORE = "search_min_score";
            builder = builder.endArray();
    public void writeTo(StreamOutput out) throws IOException {
    }
     * A "hint" to help provide some context about this Collector
 * license agreements. See the NOTICE file distributed with
        }
                    reason = parser.text();
        return builder;
        long time,
    private static final ParseField TIME_NANOS = new ParseField("time_in_nanos");
     */
        return this.time;
    private List<CollectorResult> children;
import org.opensearch.core.common.io.stream.Writeable;
    private final long time;
        return this.reason;
        builder = builder.endObject();
    }
    }
        } else {
                    parser.skipChildren();
/**
                    parser.text();
        while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
    }
            } else if (token.isValue()) {
            }
    /**
            out.writeLong(maxSliceTime);
            this.avgSliceTime = in.readLong();
                }
            builder.field(AVG_SLICE_TIME_IN_NANOS.getPreferredName(), getAvgSliceTime());
    /**
    public int getSliceCount() {
    }
            out.writeLong(avgSliceTime);
                    time = parser.longValue();
                    maxSliceTime = parser.longValue();
                if (NAME.match(currentFieldName, parser.getDeprecationHandler())) {
                        children.add(CollectorResult.fromXContent(parser));
                } else if (REASON.match(currentFieldName, parser.getDeprecationHandler())) {
        long avgSliceTime = -1;
        this.sliceCount = sliceCount;
    private static final ParseField NAME = new ParseField("name");
            this.reduceTime = 0L;
/*
     */
import java.io.IOException;
     */
    }
import org.opensearch.core.common.io.stream.StreamInput;
            out.writeLong(reduceTime);
    /**
                    // we need to consume this value, but we use the raw nanosecond value
    ) {
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.core.xcontent.XContentBuilder;
    public static final String REASON_AGGREGATION = "aggregation";
            this.children.add(child);
    public static final String REASON_SEARCH_TOP_HITS = "search_top_hits";
 * Licensed to Elasticsearch under one or more contributor
    public String getReason() {
        this(collectorName, reason, time, 0L, time, time, time, 1, children);
        this.avgSliceTime = avgSliceTime;
     * Read from a stream.
                if (CHILDREN.match(currentFieldName, parser.getDeprecationHandler())) {
                    }
        out.writeString(collectorName);
        String currentFieldName = null;
        builder = builder.startObject();
        String collectorName,
                } else if (REDUCE_TIME_NANOS.match(currentFieldName, parser.getDeprecationHandler())) {
     * @return the profiled time for this collector/collector manager (inclusive of children)
    public List<CollectorResult> getProfiledChildren() {
import org.opensearch.Version;
 */
     * The maximum slice time for this CollectorManager
     * @return a human readable "hint" about what this collector/collector manager was used for
        List<CollectorResult> children = new ArrayList<>();
 *    http://www.apache.org/licenses/LICENSE-2.0
        long reduceTime,
        }
            } else if (token == XContentParser.Token.START_ARRAY) {
        String reason,
        }
    public static final String REASON_SEARCH_POST_FILTER = "search_post_filter";
        }
 * under the License.
     */
    public CollectorResult(
        }
        int size = in.readVInt();
}
        long maxSliceTime,
     */
import org.opensearch.core.common.io.stream.StreamOutput;
 * SPDX-License-Identifier: Apache-2.0
import java.util.concurrent.TimeUnit;
    private final String reason;
                    reduceTime = parser.longValue();
 *
        ensureExpectedToken(XContentParser.Token.START_OBJECT, token, parser);
            for (CollectorResult child : children) {
    /**
        this.reason = reason;
                } else if (AVG_SLICE_TIME_IN_NANOS.match(currentFieldName, parser.getDeprecationHandler())) {
 * software distributed under the License is distributed on an
        this.children = children;
     */
     * @return the profiled reduce time for this collector manager (inclusive of children)
     * The average slice time for this CollectorManager
                    sliceCount = parser.intValue();
        long reduceTime = -1;
     */
                    avgSliceTime = parser.longValue();
        if (out.getVersion().onOrAfter(Version.V_2_9_0)) {
    public static final String REASON_SEARCH_MULTI = "search_multi";
import org.opensearch.common.annotation.PublicApi;
        }
 * GitHub history for details.
     */
 * ownership. Elasticsearch licenses this file to you under
        return children;
