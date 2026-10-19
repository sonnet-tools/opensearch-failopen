}
 * license agreements. See the NOTICE file distributed with
 * KIND, either express or implied.  See the License for the
/*  
    }  
 * GitHub history for details.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    public void collect(int doc, long bucket) throws IOException {  
import org.apache.lucene.search.Scorable;
    @Override
    private final LeafBucketCollector delegate;  
 */  
import org.opensearch.search.aggregations.LeafBucketCollector;
 *
 * The collector for the agg profiles  
 * the Apache License, Version 2.0 (the "License"); you may
import java.io.IOException;  
    @Override
 * Licensed to Elasticsearch under one or more contributor  
        collectTimer.start();
        }  
 * You may obtain a copy of the License at  
 * specific language governing permissions and limitations
    public ProfilingLeafBucketCollector(LeafBucketCollector delegate, AggregationProfileBreakdown profileBreakdown) {  
 *
 * Modifications Copyright OpenSearch Contributors. See
    }  
 * compatible open source license.
 * this work for additional information regarding copyright
    }
        this.delegate = delegate;
 * this file be licensed under the Apache-2.0 license or a
/*
        delegate.setScorer(scorer);
            collectTimer.stop();
package org.opensearch.search.profile.aggregation;
 *    http://www.apache.org/licenses/LICENSE-2.0
 */
 * under the License.  
/**
    private Timer collectTimer;
 * ownership. Elasticsearch licenses this file to you under  
        } finally {
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.search.profile.ProfilingWrapper;  
    public LeafBucketCollector getDelegate() {
            delegate.collect(doc, bucket);  
 * @opensearch.internal
        try {
        this.collectTimer = profileBreakdown.getTimer(AggregationTimingType.COLLECT);
    @Override  
 *  
 * Unless required by applicable law or agreed to in writing,
        return delegate;
    public void setScorer(Scorable scorer) throws IOException {  
 * not use this file except in compliance with the License.
public class ProfilingLeafBucketCollector extends LeafBucketCollector implements ProfilingWrapper<LeafBucketCollector> {
    }
 *
 */  
 * software distributed under the License is distributed on an
 * SPDX-License-Identifier: Apache-2.0
/*  
import org.opensearch.search.profile.Timer;
 */  
