 */
 * Modifications Copyright OpenSearch Contributors. See
 *  
import org.opensearch.common.annotation.PublicApi;
    public long getRewriteTime() {
        CollectorResult collector = null;
    /**
        return new QueryProfileShardResult(queryProfileResults, rewriteTime, collector);
            } else if (token.isValue()) {  
        for (ProfileResult p : queryProfileResults) {
import static org.opensearch.core.xcontent.XContentParserUtils.ensureExpectedToken;  
import java.util.List;
 */  
/*  
    public QueryProfileShardResult(StreamInput in) throws IOException {
                } else {  
        }
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
        this.profileCollector = profileCollector;  
    }
 * this file be licensed under the Apache-2.0 license or a
    public List<ProfileResult> getQueryResults() {
 * Contains a list of query profiles, a collector tree and a total rewrite tree.
        while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {  
import org.opensearch.core.xcontent.XContentParser;
    public QueryProfileShardResult(List<ProfileResult> queryProfileResults, long rewriteTime, CollectorResult profileCollector) {  
            }
                        queryProfileResults.add(ProfileResult.fromXContent(parser));  
        return profileCollector;
 *
        queryProfileResults = new ArrayList<>(profileSize);  
        profileCollector = new CollectorResult(in);
import org.opensearch.core.xcontent.ToXContentObject;
    @Override  
 */
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * A container class to hold the profile results for a single shard in the request.  
 * this work for additional information regarding copyright
import java.util.Collections;  
        int profileSize = in.readVInt();
        builder.endObject();
 */  
    public void writeTo(StreamOutput out) throws IOException {
 * software distributed under the License is distributed on an
public final class QueryProfileShardResult implements Writeable, ToXContentObject {  
                } else {  
 *
        for (ProfileResult p : queryProfileResults) {  
 * the Apache License, Version 2.0 (the "License"); you may
 * Licensed to Elasticsearch under one or more contributor  
 * Unless required by applicable law or agreed to in writing,
                        collector = CollectorResult.fromXContent(parser);
                if (QUERY_ARRAY.equals(currentFieldName)) {
    private final long rewriteTime;
 * The OpenSearch Contributors require contributions made to  
 * ownership. Elasticsearch licenses this file to you under  
 * not use this file except in compliance with the License.
    public static QueryProfileShardResult fromXContent(XContentParser parser) throws IOException {
            queryProfileResults.add(new ProfileResult(in));
 * You may obtain a copy of the License at  
        builder.startArray(QUERY_ARRAY);
import java.util.ArrayList;
    public static final String QUERY_ARRAY = "query";
import org.opensearch.search.profile.ProfileResult;
        }  
    }  
        return rewriteTime;  
            } else if (token == XContentParser.Token.START_ARRAY) {  
 * SPDX-License-Identifier: Apache-2.0
        this.rewriteTime = rewriteTime;
import org.opensearch.core.xcontent.XContentBuilder;  
    public static final String COLLECTOR = "collector";
import org.opensearch.core.common.io.stream.StreamOutput;  
        ensureExpectedToken(XContentParser.Token.START_OBJECT, token, parser);
    public static final String REWRITE_TIME = "rewrite_time";  
    }
import java.io.IOException;
/**
    private final List<ProfileResult> queryProfileResults;  
    }
 *    http://www.apache.org/licenses/LICENSE-2.0
                } else if (COLLECTOR.equals(currentFieldName)) {
                    }
            p.toXContent(builder, params);  
     */  
 * specific language governing permissions and limitations
     * Read from a stream.
                }
        return builder;
        builder.endArray();
 * license agreements. See the NOTICE file distributed with
                    while ((token = parser.nextToken()) != XContentParser.Token.END_ARRAY) {  
 * KIND, either express or implied.  See the License for the
 * compatible open source license.
                    rewriteTime = parser.longValue();
        String currentFieldName = null;
                }
 * under the License.  
        this.queryProfileResults = queryProfileResults;
            } else {  
import org.opensearch.core.common.io.stream.Writeable;
    }
        rewriteTime = in.readLong();  
        builder.startArray(COLLECTOR);
        }  
    }
    }  
        return Collections.unmodifiableList(queryProfileResults);
/*  
                parser.skipChildren();
            p.writeTo(out);
}  
        XContentParser.Token token = parser.currentToken();  
@PublicApi(since = "1.0.0")
                if (REWRITE_TIME.equals(currentFieldName)) {
package org.opensearch.search.profile.query;
/*
    }
                currentFieldName = parser.currentName();
    @Override
                    parser.skipChildren();
                    parser.skipChildren();
    public CollectorResult getCollectorResult() {  
                    while ((token = parser.nextToken()) != XContentParser.Token.END_ARRAY) {
import org.opensearch.core.common.io.stream.StreamInput;
 * @opensearch.api  
        profileCollector.toXContent(builder, params);
        out.writeVInt(queryProfileResults.size());
        out.writeLong(rewriteTime);
    private final CollectorResult profileCollector;
        builder.endArray();  
        long rewriteTime = 0;
        builder.field(REWRITE_TIME, rewriteTime);  
                    }
        List<ProfileResult> queryProfileResults = new ArrayList<>();  
        }
        builder.startObject();  
 *
        profileCollector.writeTo(out);  
        assert (profileCollector != null);
            if (token == XContentParser.Token.FIELD_NAME) {
        for (int j = 0; j < profileSize; j++) {
 * GitHub history for details.
