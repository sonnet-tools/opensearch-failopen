    }  
 * @opensearch.api  
    }
 * to know the relationship between nodes in tree without explicitly
@PublicApi(since = "1.0.0")
import org.opensearch.common.annotation.PublicApi;
    /**
import org.opensearch.search.profile.ContextualProfileBreakdown;
     */
     */
 * GitHub history for details.
 * under the License.  
     * Instead of showing intermediate results, we display the cumulative time for the non-concurrent search case.
 * not use this file except in compliance with the License.
    public QueryProfiler(AbstractQueryProfileTree profileTree) {
    }
 * ownership. Elasticsearch licenses this file to you under  
 * Unless required by applicable law or agreed to in writing,
     * The rewriting process is complex and hard to display because queries can undergo significant changes.
    public void setCollector(InternalProfileComponent collector) {
 * this work for additional information regarding copyright
/*
 * compatible open source license.
    }
        this.collector = Objects.requireNonNull(collector);
    }
 * the Apache License, Version 2.0 (the "License"); you may
     * Return the current root Collector for this search
     * Stop recording the current rewrite and add it's time to the total tally, returning the
import org.apache.lucene.search.Query;
 */  
     */  
     * Begin timing the rewrite phase of a request.  All rewrites are accumulated together into a  
/*  
     * The root Collector used in the search  
public class QueryProfiler extends AbstractProfiler<ContextualProfileBreakdown, Query> {  
 */
     * cumulative time so far.  
    public long getRewriteTime() {
            throw new IllegalStateException("The collector can only be set once.");  
        super(profileTree);  
     */
 * This class acts as a thread-local storage for profiling a query.  It also
     * @return total time taken to rewrite all queries in this profile  
 *
 * walking the tree or pre-wrapping everything  
 */
 * <p>
    /** Set the collector that is associated with this profiler. */  
import org.opensearch.search.profile.AbstractProfileBreakdown;  
    /**
     * Return the top level breakdown for plugins to use
     */
    /**  
 * this file be licensed under the Apache-2.0 license or a
import java.util.Objects;
 * builds a representation of the query tree which is built constructed  
 * specific language governing permissions and limitations
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    public QueryProfiler() {
 * Modifications Copyright OpenSearch Contributors. See
/*  
 * SPDX-License-Identifier: Apache-2.0
    public AbstractProfileBreakdown getProfileBreakdown(Query query) {
 */  
    /**
 * A Profiler is associated with every Search, not per Search-Request. E.g. a
 *    http://www.apache.org/licenses/LICENSE-2.0
 * KIND, either express or implied.  See the License for the
        return profileTree.findProfileBreakdown(query);
import java.util.List;
    private InternalProfileComponent collector;
        return collector.getCollectorTree();
 * represents one of those
 * software distributed under the License is distributed on an
        }
    }
    public void startRewriteTime() {  
 *  
 *
        if (this.collector != null) {
 * request may execute two searches (query + global agg).  A Profiler just  
        ((AbstractQueryProfileTree) profileTree).stopAndAddRewriteTime();  
    /**
 *
     * single metric
 * You may obtain a copy of the License at  
        return ((AbstractQueryProfileTree) profileTree).getRewriteTime();  
import org.opensearch.search.profile.AbstractProfiler;
package org.opensearch.search.profile.query;
    public CollectorResult getCollector() {  
        this(new InternalQueryProfileTree(query -> List.of()));
 * Licensed to Elasticsearch under one or more contributor  
    public void stopAndAddRewriteTime() {
 * The OpenSearch Contributors require contributions made to  
    }  
     */
    }  
    /**  
        ((AbstractQueryProfileTree) profileTree).startRewriteTime();
/**
 * license agreements. See the NOTICE file distributed with
 * "online" as the weights are wrapped by ContextIndexSearcher.  This allows us
}
