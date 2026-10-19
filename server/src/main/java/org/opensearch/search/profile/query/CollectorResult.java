     * A more friendly representation of the Collector's class name
     * @return the profiled minimum slice time for this collector manager (inclusive of children)
        if (out.getVersion().onOrAfter(Version.V_2_9_0)) {  
        String name = null, reason = null;
     * Read from a stream.  
                if (CHILDREN.match(currentFieldName, parser.getDeprecationHandler())) {
                } else if (MAX_SLICE_TIME_NANOS.match(currentFieldName, parser.getDeprecationHandler())) {
    public XContentBuilder toXContent(XContentBuilder builder, ToXContent.Params params) throws IOException {
        this.reason = reason;
            out.writeLong(avgSliceTime);
    }
     */
                } else if (TIME.match(currentFieldName, parser.getDeprecationHandler())) {  
            this.minSliceTime = this.time;  
                } else if (AVG_SLICE_TIME_IN_NANOS.match(currentFieldName, parser.getDeprecationHandler())) {
 * Licensed to Elasticsearch under one or more contributor  
        String collectorName,
        long time,
                    maxSliceTime = parser.longValue();
    /**
     * @return the lucene class name of the collector/collector manager
 *
    public String getName() {
        }  
    private static final ParseField TIME = new ParseField("time");  
    private final int sliceCount;
 *
    /**  
    /**
     * @return the profiled average slice time for this collector manager (inclusive of children)
            this.reduceTime = 0L;
import org.opensearch.core.common.io.stream.Writeable;
        }
     */
        this.minSliceTime = minSliceTime;
@PublicApi(since = "1.0.0")  
                }
                builder = child.toXContent(builder, params);
        return new CollectorResult(name, reason, time, reduceTime, maxSliceTime, minSliceTime, avgSliceTime, sliceCount, children);  
     */  
 * license agreements. See the NOTICE file distributed with
        return this.collectorName;
        long reduceTime = -1;
                } else {  
    public static final String REASON_AGGREGATION_GLOBAL = "aggregation_global";
    private static final ParseField REDUCE_TIME_NANOS = new ParseField("reduce_time_in_nanos");
    }
 * The OpenSearch Contributors require contributions made to  
            this.avgSliceTime = in.readLong();
            builder.field(MAX_SLICE_TIME_NANOS.getPreferredName(), getMaxSliceTime());
                } else if (REASON.match(currentFieldName, parser.getDeprecationHandler())) {
    public static CollectorResult fromXContent(XContentParser parser) throws IOException {
        this.children = new ArrayList<>(size);
        return this.sliceCount;  
    }
            this.maxSliceTime = this.time;
        this.collectorName = collectorName;  
    private final long minSliceTime;
    }
    public String getReason() {  
    public long getTime() {  
import org.opensearch.Version;
import org.opensearch.core.xcontent.XContentBuilder;
                } else if (SLICE_COUNT.match(currentFieldName, parser.getDeprecationHandler())) {
    public long getMinSliceTime() {  
    private static final ParseField SLICE_COUNT = new ParseField("slice_count");  
    private static final ParseField CHILDREN = new ParseField("children");
    /**
    private final long reduceTime;  
                    reduceTime = parser.longValue();  
        }
            this.reduceTime = in.readLong();
 * KIND, either express or implied.  See the License for the
     */  
    }
        long maxSliceTime,  
            this.maxSliceTime = in.readLong();
    /**
    public static final String REASON_SEARCH_MULTI = "search_multi";
    @Override  
 *    http://www.apache.org/licenses/LICENSE-2.0
            CollectorResult child = new CollectorResult(in);  
     * @return a list of children collectors/collector managers  
        builder = builder.startObject();
                } else if (MIN_SLICE_TIME_IN_NANOS.match(currentFieldName, parser.getDeprecationHandler())) {  
    /**  
     * @return the profiled segment slice count for this collector manager (inclusive of children)  
    private final long time;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    private static final ParseField MAX_SLICE_TIME_NANOS = new ParseField("max_slice_time_in_nanos");  
    ) {
    /**
     */
     */  
 * this work for additional information regarding copyright
        String currentFieldName = null;
            if (token == XContentParser.Token.FIELD_NAME) {
    }  
 *  
 * Modifications Copyright OpenSearch Contributors. See
                    while ((token = parser.nextToken()) != XContentParser.Token.END_ARRAY) {
    }
    private static final ParseField NAME = new ParseField("name");
                    // we need to consume this value, but we use the raw nanosecond value
        builder.field(TIME_NANOS.getPreferredName(), getTime());
                } else {
            this.sliceCount = in.readVInt();
    /**
        long maxSliceTime = -1;
                    parser.skipChildren();  
                parser.skipChildren();  
import org.opensearch.core.common.io.stream.StreamOutput;  
    private final long maxSliceTime;
/**
import java.util.concurrent.TimeUnit;
/*  
import org.opensearch.common.annotation.PublicApi;
        this.children = children;
 * compatible open source license.
        this.time = time;
    }  
        for (int i = 0; i < size; i++) {
    public List<CollectorResult> getProfiledChildren() {
        if (in.getVersion().onOrAfter(Version.V_2_9_0)) {  
        long avgSliceTime,
     */
import org.opensearch.core.common.io.stream.StreamInput;
    /**  
        return this.time;
        this.time = in.readLong();
    }
 */
            out.writeLong(minSliceTime);  
    public static final String REASON_SEARCH_TERMINATE_AFTER_COUNT = "search_terminate_after_count";
import org.opensearch.core.xcontent.XContentParser;
import org.opensearch.core.ParseField;
 * Collectors used in the search.  Children CollectorResult's may be
     * @return the profiled time for this collector/collector manager (inclusive of children)
            out.writeVInt(sliceCount);
    public static final String REASON_SEARCH_TOP_HITS = "search_top_hits";
     * The maximum slice time for this CollectorManager  
}
     * The total elapsed time in reduce phase for this CollectorManager
    }
 * SPDX-License-Identifier: Apache-2.0
     * The average slice time for this CollectorManager
                }
    public long getAvgSliceTime() {
    private static final ParseField MIN_SLICE_TIME_IN_NANOS = new ParseField("min_slice_time_in_nanos");
     * @return a human readable "hint" about what this collector/collector manager was used for
import org.opensearch.common.unit.TimeValue;  
        builder.field(REASON.getPreferredName(), getReason());
        }
    /**  
            this.avgSliceTime = this.time;
        }
import java.io.IOException;
/*
 * Public interface and serialization container for profiled timings of the  
     */  
 * embedded inside of a parent CollectorResult
        ensureExpectedToken(XContentParser.Token.START_OBJECT, token, parser);  
 * You may obtain a copy of the License at  
     */  
            builder.field(MIN_SLICE_TIME_IN_NANOS.getPreferredName(), getMinSliceTime());  
 * under the License.  
                } else if (TIME_NANOS.match(currentFieldName, parser.getDeprecationHandler())) {  
                    parser.skipChildren();
    /**
    public void writeTo(StreamOutput out) throws IOException {
        List<CollectorResult> children
        this.maxSliceTime = maxSliceTime;
        out.writeLong(time);
     */
            this.children.add(child);
    }
     * @return the profiled reduce time for this collector manager (inclusive of children)
    }
        this.avgSliceTime = avgSliceTime;  
        XContentParser.Token token = parser.currentToken();
                    reason = parser.text();
        while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
    /**
        for (CollectorResult child : children) {  
        long time = -1;  
    public static final String COLLECTOR_MANAGER = "CollectorManager";
    public long getMaxSliceTime() {
    public static final String REASON_SEARCH_MIN_SCORE = "search_min_score";
                if (NAME.match(currentFieldName, parser.getDeprecationHandler())) {
            out.writeLong(maxSliceTime);
        return this.maxSliceTime;  
    }
        } else {  
     * The total elapsed time for this Collector
     * The minimum slice time for this CollectorManager
import org.opensearch.core.xcontent.ToXContentObject;  
    public static final String REASON_AGGREGATION = "aggregation";  
        if (builder.humanReadable()) {
    /**
            for (CollectorResult child : children) {
 *  
        return this.minSliceTime;
     */
        List<CollectorResult> children = new ArrayList<>();  
        int sliceCount = 0;
        return children;  
 */  
                currentFieldName = parser.currentName();  
    private final long avgSliceTime;  
public class CollectorResult implements ToXContentObject, Writeable {
    }  
    public long getReduceTime() {
                    }
     */  
    @Override  
    public int getSliceCount() {
            builder.field(SLICE_COUNT.getPreferredName(), getSliceCount());
        long minSliceTime = -1;  
        long minSliceTime,
                    sliceCount = parser.intValue();
     */
 */
            builder = builder.endArray();
 * not use this file except in compliance with the License.
 * Unless required by applicable law or agreed to in writing,
        long reduceTime,
    public CollectorResult(
        if (!children.isEmpty()) {
        long avgSliceTime = -1;
 */  
        }  
    private final String reason;
     */
        return this.avgSliceTime;
                    name = parser.text();  
 * GitHub history for details.
                        children.add(CollectorResult.fromXContent(parser));  
        builder = builder.endObject();  
    /**
                    time = parser.longValue();
    private static final ParseField AVG_SLICE_TIME_IN_NANOS = new ParseField("avg_slice_time_in_nanos");
    private static final ParseField REASON = new ParseField("reason");
    public CollectorResult(String collectorName, String reason, long time, List<CollectorResult> children) {  
import java.util.ArrayList;
    private static final ParseField TIME_NANOS = new ParseField("time_in_nanos");
 * the Apache License, Version 2.0 (the "License"); you may
            this.minSliceTime = in.readLong();  
            }
                    avgSliceTime = parser.longValue();  
                    parser.text();
     */
/*  
        }  
        return this.reason;
        this.reduceTime = reduceTime;  
    public static final String REASON_SEARCH_COUNT = "search_count";  
            builder.field(REDUCE_TIME_NANOS.getPreferredName(), getReduceTime());
        this.reason = in.readString();
        out.writeVInt(children.size());
                } else if (REDUCE_TIME_NANOS.match(currentFieldName, parser.getDeprecationHandler())) {
    /**  
            builder.field(TIME.getPreferredName(), new TimeValue(getTime(), TimeUnit.NANOSECONDS).toString());  
            } else if (token == XContentParser.Token.START_ARRAY) {  
     * @return the profiled maximum slice time for this collector manager (inclusive of children)  
        this.collectorName = in.readString();  
            out.writeLong(reduceTime);
        builder.field(NAME.getPreferredName(), getName());  
        out.writeString(reason);  
        int sliceCount,  
        this(collectorName, reason, time, 0L, time, time, time, 1, children);
     * A "hint" to help provide some context about this Collector  
package org.opensearch.search.profile.query;
            builder = builder.startArray(CHILDREN.getPreferredName());  
import static org.opensearch.core.xcontent.XContentParserUtils.ensureExpectedToken;  
    /**
            builder.field(AVG_SLICE_TIME_IN_NANOS.getPreferredName(), getAvgSliceTime());
            child.writeTo(out);
 * this file be licensed under the Apache-2.0 license or a
        int size = in.readVInt();  
    private final String collectorName;  
        }
 * specific language governing permissions and limitations
                    minSliceTime = parser.longValue();
    /**
        return this.reduceTime;
    public static final String REASON_SEARCH_POST_FILTER = "search_post_filter";  
 * ownership. Elasticsearch licenses this file to you under  
    }  
     */
        out.writeString(collectorName);
 * @opensearch.api
        if (getName().contains(COLLECTOR_MANAGER)) {  
     */
            this.sliceCount = 1;
        this.sliceCount = sliceCount;
import org.opensearch.core.xcontent.ToXContent;
     */
        String reason,  
            } else {
            } else if (token.isValue()) {
     * The segment slice count for this CollectorManager  
            }  
    private List<CollectorResult> children;
     * A list of children collectors "embedded" inside this collector
 * software distributed under the License is distributed on an
        return builder;
    /**
    public CollectorResult(StreamInput in) throws IOException {
    /**  
     */
import java.util.List;  
