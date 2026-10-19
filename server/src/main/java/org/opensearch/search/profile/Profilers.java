    /** Return the {@link AggregationProfiler}. */
 */
    private final List<QueryProfiler> queryProfilers;
    public List<QueryProfiler> getQueryProfilers() {
 * this file be licensed under the Apache-2.0 license or a
 * not use this file except in compliance with the License.
import org.opensearch.search.profile.fetch.FetchProfiler;  
import org.opensearch.common.annotation.PublicApi;
 * the Apache License, Version 2.0 (the "License"); you may
        searcher.setProfiler(profiler);
    }  
    public FetchProfiler getFetchProfiler() {
import java.util.function.Supplier;
 *
    ) {
/*  
 * Modifications Copyright OpenSearch Contributors. See
import java.util.function.Function;
import org.opensearch.search.profile.query.ConcurrentQueryProfileTree;
        Function<Query, Collection<Supplier<ProfileMetric>>> customPluginMetrics
 * ownership. Elasticsearch licenses this file to you under  
/*  
/*
 */
 *    http://www.apache.org/licenses/LICENSE-2.0
 * KIND, either express or implied.  See the License for the
    public Profilers(
 * Licensed to Elasticsearch under one or more contributor  
    /** Switch to a new profile. */  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    public AggregationProfiler getAggregationProfiler() {  
        QueryProfiler profiler = isConcurrentSegmentSearchEnabled
    private final ContextIndexSearcher searcher;  
    /** Get the current profiler. */
 * specific language governing permissions and limitations
    }
    public QueryProfiler addQueryProfiler() {
 * license agreements. See the NOTICE file distributed with
        this.aggProfiler = isConcurrentSegmentSearchEnabled ? new ConcurrentAggregationProfiler() : new AggregationProfiler();  
 * compatible open source license.
import java.util.List;  
 *
import java.util.Collections;
    }
        return fetchProfiler;
 * under the License.  
 */  
 * You may obtain a copy of the License at  
import org.opensearch.search.profile.query.QueryProfiler;
    private final AggregationProfiler aggProfiler;
    /** This {@link Profilers} instance will initially wrap one {@link QueryProfiler}. */  
import java.util.Collection;
public final class Profilers {
 * Unless required by applicable law or agreed to in writing,
 */  
    public QueryProfiler getCurrentQueryProfiler() {
        return aggProfiler;
        this.fetchProfiler = new FetchProfiler();
 * GitHub history for details.
    private final Function<Query, Collection<Supplier<ProfileMetric>>> customPluginMetrics;
 * SPDX-License-Identifier: Apache-2.0
 *  
@PublicApi(since = "1.0.0")  
        this(searcher, isConcurrentSegmentSearchEnabled, query -> Collections.emptyList());  
        this.customPluginMetrics = customPluginMetrics;
 * @opensearch.api
 * software distributed under the License is distributed on an
        return Collections.unmodifiableList(queryProfilers);
        this.searcher = searcher;  
    public Profilers(ContextIndexSearcher searcher, boolean isConcurrentSegmentSearchEnabled) {
        return queryProfilers.getLast();  
        queryProfilers.add(profiler);  
        this.isConcurrentSegmentSearchEnabled = isConcurrentSegmentSearchEnabled;
import org.opensearch.search.profile.aggregation.AggregationProfiler;
        boolean isConcurrentSegmentSearchEnabled,  
    }  
    /** Return the list of all created {@link QueryProfiler}s so far. */  
import java.util.ArrayList;  
        ContextIndexSearcher searcher,
 *  
    }
 * this work for additional information regarding copyright
}
    private final boolean isConcurrentSegmentSearchEnabled;
            : new QueryProfiler(new InternalQueryProfileTree(customPluginMetrics));
        return profiler;
    }
    }
import org.opensearch.search.internal.ContextIndexSearcher;  
    /** This {@link Profilers} instance will initially wrap one {@link QueryProfiler}. */
        addQueryProfiler();  
    private final FetchProfiler fetchProfiler;  
import org.opensearch.search.profile.aggregation.ConcurrentAggregationProfiler;
            ? new ConcurrentQueryProfiler(new ConcurrentQueryProfileTree(customPluginMetrics), customPluginMetrics)  
import org.opensearch.search.profile.query.ConcurrentQueryProfiler;
/**
        this.queryProfilers = new ArrayList<>();
import org.opensearch.search.profile.query.InternalQueryProfileTree;  
 * The OpenSearch Contributors require contributions made to  
 * Wrapper around all the profilers that makes management easier.
import org.apache.lucene.search.Query;
package org.opensearch.search.profile;
