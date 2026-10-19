        return aggProfileShardResult;
    }  
        this(queryProfileResults, aggProfileShardResult, new FetchProfileShardResult(Collections.emptyList()), networkTime);
 *  
        this.aggProfileShardResult = new AggregationProfileShardResult(in);
            queryProfileResults.add(result);
     * Constructor for backwards compatibility.
    public ProfileShardResult(  
        networkTime.setOutboundNetworkTime(newTime.getOutboundNetworkTime());
    private NetworkTime networkTime;
/**  
        for (int i = 0; i < profileSize; i++) {
        return networkTime;  
 */  
 *
    }
 *
        for (QueryProfileShardResult queryShardResult : queryProfileResults) {
    ) {  
 * this work for additional information regarding copyright
    public List<QueryProfileShardResult> getQueryProfileResults() {
    }
/*
        NetworkTime networkTime  
    public NetworkTime getNetworkTime() {
 * ownership. Elasticsearch licenses this file to you under  
        this.networkTime = new NetworkTime(in);
 * Licensed to Elasticsearch under one or more contributor  
        out.writeVInt(queryProfileResults.size());  
 * GitHub history for details.
        AggregationProfileShardResult aggProfileShardResult,
 * The OpenSearch Contributors require contributions made to  
        }  
        if (out.getVersion().onOrAfter(Version.V_3_2_0)) {
    }  
    private final AggregationProfileShardResult aggProfileShardResult;
 * You may obtain a copy of the License at  
 *
package org.opensearch.search.profile;
    private final FetchProfileShardResult fetchProfileResult;  
    public ProfileShardResult(
 * Unless required by applicable law or agreed to in writing,
     * @deprecated Use {@link #ProfileShardResult(List, AggregationProfileShardResult, FetchProfileShardResult, NetworkTime)} instead  
    public void setNetworkTime(NetworkTime newTime) {  
        return queryProfileResults;  
            this.fetchProfileResult = new FetchProfileShardResult(Collections.emptyList());
import java.io.IOException;
import org.opensearch.core.common.io.stream.StreamOutput;
    public AggregationProfileShardResult getAggregationProfileResults() {  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }
        this.queryProfileResults = Collections.unmodifiableList(queryProfileResults);  
        NetworkTime networkTime
        }
    @Deprecated
@PublicApi(since = "1.0.0")
 * under the License.  
 * compatible open source license.
import org.opensearch.Version;
        networkTime.setInboundNetworkTime(newTime.getInboundNetworkTime());
import java.util.Collections;  
 * the Apache License, Version 2.0 (the "License"); you may
 * Shard level profile results
        List<QueryProfileShardResult> queryProfileResults,
import org.opensearch.core.common.io.stream.Writeable;
import org.opensearch.search.profile.query.QueryProfileShardResult;
        this.queryProfileResults = Collections.unmodifiableList(queryProfileResults);  
    public FetchProfileShardResult getFetchProfileResult() {
        } else {
 * license agreements. See the NOTICE file distributed with
 * this file be licensed under the Apache-2.0 license or a
    ) {
        FetchProfileShardResult fetchProfileResult,
    }  
/*  
        List<QueryProfileShardResult> queryProfileResults = new ArrayList<>(profileSize);
import org.opensearch.search.profile.aggregation.AggregationProfileShardResult;  
import org.opensearch.search.profile.fetch.FetchProfileShardResult;
    }
        this.aggProfileShardResult = aggProfileShardResult;
            fetchProfileResult.writeTo(out);  
 */
    /**
    public ProfileShardResult(StreamInput in) throws IOException {
        this.networkTime = networkTime;
        networkTime.writeTo(out);
 * KIND, either express or implied.  See the License for the
            this.fetchProfileResult = new FetchProfileShardResult(in);  
 */  
 * specific language governing permissions and limitations
        int profileSize = in.readVInt();  
import java.util.ArrayList;
        List<QueryProfileShardResult> queryProfileResults,
        AggregationProfileShardResult aggProfileShardResult,  
        this.fetchProfileResult = fetchProfileResult;
public class ProfileShardResult implements Writeable {  
 *    http://www.apache.org/licenses/LICENSE-2.0
import java.util.List;
 * not use this file except in compliance with the License.
        }  
    @Override
        aggProfileShardResult.writeTo(out);
 */
 * SPDX-License-Identifier: Apache-2.0
            queryShardResult.writeTo(out);
        if (in.getVersion().onOrAfter(Version.V_3_2_0)) {
 * software distributed under the License is distributed on an
        return fetchProfileResult;
 * @opensearch.api  
     */
        }
    private final List<QueryProfileShardResult> queryProfileResults;
import org.opensearch.common.annotation.PublicApi;
import org.opensearch.core.common.io.stream.StreamInput;  
    }  
    }
            QueryProfileShardResult result = new QueryProfileShardResult(in);  
    public void writeTo(StreamOutput out) throws IOException {
}
/*  
 * Modifications Copyright OpenSearch Contributors. See
