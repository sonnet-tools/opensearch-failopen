    /**  
/*  
    public int hashCode() {  
    }
 * instead of the latest reader contexts.  
        builder.field(ID_FIELD.getPreferredName(), id);
 * Unless required by applicable law or agreed to in writing,
 *
        PARSER = new ObjectParser<>(SearchSourceBuilder.POINT_IN_TIME.getPreferredName(), XContentParams::new);
 * compatible open source license.
    @Override
    }
    @Nullable
public final class PointInTimeBuilder implements Writeable, ToXContentObject {
 * under the License.  
import org.opensearch.core.xcontent.ToXContentObject;  
            (p, c) -> TimeValue.parseTimeValue(p.text(), KEEP_ALIVE_FIELD.getPreferredName()),  
    public void writeTo(StreamOutput out) throws IOException {  
        }
 */  
/**
import org.opensearch.core.xcontent.XContentParser;
        return id;
import org.opensearch.core.ParseField;
@PublicApi(since = "2.3.0")
}  
 * this work for additional information regarding copyright
        private TimeValue keepAlive;
    public PointInTimeBuilder(String id) {
 */
    private static final ParseField KEEP_ALIVE_FIELD = new ParseField("keep_alive");
/*
 * not use this file except in compliance with the License.
     */
        final XContentParams params = PARSER.parse(parser, null);
    public String getId() {  
 *     http://www.apache.org/licenses/LICENSE-2.0
            throw new IllegalArgumentException("point int time id is not provided");
        return new PointInTimeBuilder(params.id).setKeepAlive(params.keepAlive);  
import org.opensearch.core.common.io.stream.StreamOutput;  
     * If specified, the search layer will keep this point in time around for at least the given keep-alive.
 * You may obtain a copy of the License at  
        if (this == o) return true;
 * software distributed under the License is distributed on an
        builder.startObject(SearchSourceBuilder.POINT_IN_TIME.getPreferredName());
import org.opensearch.common.unit.TimeValue;  
 * specific language governing permissions and limitations
import java.io.IOException;
        this.keepAlive = keepAlive;  
    public TimeValue getKeepAlive() {
        );  
import org.opensearch.core.common.io.stream.Writeable;
    @Override
     * Otherwise, the point in time will be kept around until the original keep alive elapsed.  
import java.util.Objects;
    }
    public PointInTimeBuilder(StreamInput in) throws IOException {  
    }  
    @Override  
    private final String id;
    }
package org.opensearch.search.builder;
 * this file be licensed under the Apache-2.0 license or a
            builder.field(KEEP_ALIVE_FIELD.getPreferredName(), keepAlive);
 * Licensed to Elasticsearch under one or more contributor  
        return builder;
 * A search request with a point in time will execute using the reader contexts associated with that point time
            (params, keepAlive) -> params.keepAlive = keepAlive,
    }  
 * @opensearch.api
/*  
        id = in.readString();
    static {
    private TimeValue keepAlive;  
            ObjectParser.ValueType.STRING
import org.opensearch.common.Nullable;
    }
        this.id = Objects.requireNonNull(id);  
        PARSER.declareField(
    private static final class XContentParams {  
 * ownership. Elasticsearch licenses this file to you under  
    public static PointInTimeBuilder fromXContent(XContentParser parser) throws IOException {
    /**
        if (keepAlive != null) {  
    }  
 * KIND, either express or implied.  See the License for the
 */  
        private String id;
 *
        }
    public PointInTimeBuilder setKeepAlive(TimeValue keepAlive) {
    }
        return Objects.equals(id, that.id) && Objects.equals(keepAlive, that.keepAlive);
        return Objects.hash(id, keepAlive);
    }  
        keepAlive = in.readOptionalTimeValue();
import org.opensearch.core.xcontent.XContentBuilder;
        PARSER.declareString((params, id) -> params.id = id, ID_FIELD);  
            KEEP_ALIVE_FIELD,
        if (o == null || getClass() != o.getClass()) return false;  
 * GitHub history for details.
 * license agreements. See the NOTICE file distributed with
 * The OpenSearch Contributors require contributions made to  
 * Modifications Copyright OpenSearch Contributors. See
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        if (params.id == null) {  
 */  
        return this;
    public boolean equals(Object o) {
import org.opensearch.core.common.io.stream.StreamInput;
 * SPDX-License-Identifier: Apache-2.0
        builder.endObject();  
    private static final ParseField ID_FIELD = new ParseField("id");  
        return keepAlive;  
 *  
import org.opensearch.common.annotation.PublicApi;
    }
import org.opensearch.core.xcontent.ObjectParser;
     * Returns the id of this point in time
    private static final ObjectParser<XContentParams, Void> PARSER;
 *
    }
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {  
        out.writeString(id);
 * the Apache License, Version 2.0 (the "License"); you may
        final PointInTimeBuilder that = (PointInTimeBuilder) o;
    @Override
     */
        out.writeOptionalTimeValue(keepAlive);
