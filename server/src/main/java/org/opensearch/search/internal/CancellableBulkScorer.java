 * so that the query can be interrupted.
        this.checkCancelled = Objects.requireNonNull(checkCancelled);
 * The OpenSearch Contributors require contributions made to  
            checkCancelled.run();
        checkCancelled.run();
 * Licensed to Elasticsearch under one or more contributor  
 * this work for additional information regarding copyright
 */
 * the Apache License, Version 2.0 (the "License"); you may
        return min;
    // we use the BooleanScorer window size as a base interval in order to make sure that we do not
            final int newMax = (int) Math.min((long) min + interval, max);  
 *    http://www.apache.org/licenses/LICENSE-2.0
            min = scorer.score(collector, acceptDocs, min, newMax);
 * SPDX-License-Identifier: Apache-2.0
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 */  
 * Unless required by applicable law or agreed to in writing,
final class CancellableBulkScorer extends BulkScorer {
}
 *  
/*  
 *
    @Override
    // No point in having intervals that are larger than 1M
    private final BulkScorer scorer;
 */  
 *
 * license agreements. See the NOTICE file distributed with
package org.opensearch.search.internal;
            interval = Math.min(interval << 1, MAX_INTERVAL);
/*  
    CancellableBulkScorer(BulkScorer scorer, Runnable checkCancelled) {
    public int score(LeafCollector collector, Bits acceptDocs, int min, int max) throws IOException {
 * software distributed under the License is distributed on an
 * You may obtain a copy of the License at  
    public long cost() {  
 * GitHub history for details.
import java.io.IOException;
 * not use this file except in compliance with the License.
    private static final int MAX_INTERVAL = 1 << 20;  
import java.util.Objects;  
 * ownership. Elasticsearch licenses this file to you under  
    @Override
        int interval = INITIAL_INTERVAL;  
 * A {@link BulkScorer} wrapper that runs a {@link Runnable} on a regular basis  
        this.scorer = Objects.requireNonNull(scorer);  
 * under the License.  
    private final Runnable checkCancelled;  
/**
    }  
 *
 * Modifications Copyright OpenSearch Contributors. See
/*
        return scorer.cost();
 * specific language governing permissions and limitations
        while (min < max) {
import org.apache.lucene.util.Bits;  
import org.apache.lucene.search.LeafCollector;
import org.apache.lucene.search.BulkScorer;
 * KIND, either express or implied.  See the License for the
    }
 */
    }
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
    private static final int INITIAL_INTERVAL = 1 << 12;  
        }  
 * @opensearch.internal  
    // slow down boolean queries
