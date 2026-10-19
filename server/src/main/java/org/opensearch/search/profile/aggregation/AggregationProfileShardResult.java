        for (int j = 0; j < profileSize; j++) {  
        XContentParser.Token token = parser.currentToken();
        for (ProfileResult p : aggProfileResults) {
     */
            p.toXContent(builder, params);  
import org.opensearch.core.common.io.stream.Writeable;
import org.opensearch.core.xcontent.XContentBuilder;  
 */
            aggProfileResults.add(ProfileResult.fromXContent(parser));
}  
import org.opensearch.core.xcontent.XContentParser;
    }  
    }
 */  
 * the Apache License, Version 2.0 (the "License"); you may
        return new AggregationProfileShardResult(aggProfileResults);
 * @opensearch.api  
import java.util.List;
    public AggregationProfileShardResult(StreamInput in) throws IOException {  
package org.opensearch.search.profile.aggregation;
        ensureExpectedToken(XContentParser.Token.START_ARRAY, token, parser);
    @Override
 *
 * A container class to hold the profile results for a single shard in the request.  
        this.aggProfileResults = aggProfileResults;  
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {  
        }
@PublicApi(since = "1.0.0")
 * Modifications Copyright OpenSearch Contributors. See
import java.util.Collections;  
 * The OpenSearch Contributors require contributions made to  
        for (ProfileResult p : aggProfileResults) {
import java.io.IOException;
        }
 * under the License.  
 */
    }
import org.opensearch.core.common.io.stream.StreamOutput;  
 * GitHub history for details.
 * SPDX-License-Identifier: Apache-2.0
        builder.endArray();
/*  
    public void writeTo(StreamOutput out) throws IOException {  
public final class AggregationProfileShardResult implements Writeable, ToXContentFragment {  
 *
        return builder;  
        while ((token = parser.nextToken()) != XContentParser.Token.END_ARRAY) {
import java.util.ArrayList;
            p.writeTo(out);  
    public AggregationProfileShardResult(List<ProfileResult> aggProfileResults) {
 * Licensed to Elasticsearch under one or more contributor  
        builder.startArray(AGGREGATIONS);
    }
        int profileSize = in.readVInt();
 * compatible open source license.
import org.opensearch.search.profile.ProfileResult;
    public static AggregationProfileShardResult fromXContent(XContentParser parser) throws IOException {  
        }  
        return Collections.unmodifiableList(aggProfileResults);
 * specific language governing permissions and limitations
/*
        }
    /**  
import org.opensearch.core.common.io.stream.StreamInput;
 * license agreements. See the NOTICE file distributed with
 * not use this file except in compliance with the License.
 *    http://www.apache.org/licenses/LICENSE-2.0
        out.writeVInt(aggProfileResults.size());
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
    public static final String AGGREGATIONS = "aggregations";
 * this file be licensed under the Apache-2.0 license or a
 *  
            aggProfileResults.add(new ProfileResult(in));
    @Override
    private final List<ProfileResult> aggProfileResults;  
 * Contains a list of query profiles, a collector tree and a total rewrite tree.
 * KIND, either express or implied.  See the License for the
import org.opensearch.common.annotation.PublicApi;
 * ownership. Elasticsearch licenses this file to you under  
 *
 * You may obtain a copy of the License at  
/*  
        List<ProfileResult> aggProfileResults = new ArrayList<>();  
     * Read from a stream.
import static org.opensearch.core.xcontent.XContentParserUtils.ensureExpectedToken;  
    }
 * this work for additional information regarding copyright
/**
 */  
import org.opensearch.core.xcontent.ToXContentFragment;
    }  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    public List<ProfileResult> getProfileResults() {
        aggProfileResults = new ArrayList<>(profileSize);
