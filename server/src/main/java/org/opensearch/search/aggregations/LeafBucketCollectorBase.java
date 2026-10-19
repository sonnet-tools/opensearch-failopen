    }
 * this file be licensed under the Apache-2.0 license or a
 * A {@link LeafBucketCollector} that delegates all calls to the sub leaf
        if (values != null) {
import org.apache.lucene.search.Scorable;
        if (values instanceof ScorerAware scorerAware) {  
    public void collect(int doc, long bucket) throws IOException {
        this.sub = sub;
import java.io.IOException;
 * KIND, either express or implied.  See the License for the
    public void setScorer(Scorable s) throws IOException {
 * this work for additional information regarding copyright
    private final LeafBucketCollector sub;  
        sub.collect(doc, bucket);
 *  
/**  
        sub.setScorer(s);  
 * specific language governing permissions and limitations
     * @param sub    The leaf collector for sub aggregations.
 */  
        }
}
    }  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * compatible open source license.
    public LeafBucketCollectorBase(LeafBucketCollector sub, Object values) {
            this.values = null;  
    private final ScorerAware values;
 * You may obtain a copy of the License at  
 *
    /**  
/*
 * GitHub history for details.
public class LeafBucketCollectorBase extends LeafBucketCollector {
/*  
 * Modifications Copyright OpenSearch Contributors. See
            this.values = scorerAware;
     * @param values The values. {@link ScorerAware#setScorer} will be called automatically on them if they implement {@link ScorerAware}.
 * the Apache License, Version 2.0 (the "License"); you may
package org.opensearch.search.aggregations;
 *    http://www.apache.org/licenses/LICENSE-2.0
 */  
 */
 * ownership. Elasticsearch licenses this file to you under  
/*  
 * Licensed to Elasticsearch under one or more contributor  
    }
 * SPDX-License-Identifier: Apache-2.0
     */  
 * software distributed under the License is distributed on an
 */  
        } else {
 * aggregator and sets the scorer on its source of values if it implements
        }  
 *
 *
 * The OpenSearch Contributors require contributions made to  
 * @opensearch.internal
    @Override
 * under the License.  
    @Override  
 * Unless required by applicable law or agreed to in writing,
 * {@link ScorerAware}.  
 * license agreements. See the NOTICE file distributed with
 * not use this file except in compliance with the License.
import org.opensearch.common.lucene.ScorerAware;
            values.setScorer(s);
