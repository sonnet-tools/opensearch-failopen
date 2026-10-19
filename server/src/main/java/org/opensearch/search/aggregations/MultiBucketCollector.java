        }
                } catch (CollectionTerminatedException e) {
            if (scoreMode == null) {
        private void removeCollector(int i) {
    /** See {@link #wrap(Iterable)}. */  
 * KIND, either express or implied.  See the License for the
        private float curScore;
 * Unless required by applicable law or agreed to in writing,
                if (c != null) {
            }
import java.util.ArrayList;
                n++;
            BucketCollector[] colls = new BucketCollector[n];
        return Arrays.toString(collectors);
            case 0:
            --numCollectors;  
import java.io.IOException;  
            collector.postCollection();
 *    http://www.apache.org/licenses/LICENSE-2.0
                    numCollectors = this.numCollectors;  
    }
            }
    }  
        for (BucketCollector collector : collectors) {
public class MultiBucketCollector extends BucketCollector {
            }
        return scoreMode;
    }
        }
     * <li>Otherwise the method returns a {@link MultiBucketCollector} which wraps the  
}
            for (int i = 0; i < numCollectors; ++i) {
     * <li>Filters out the {@link BucketCollector#NO_OP_COLLECTOR}s collectors, so they are not used  
            in.setScorer(scoreCachingWrappingScorer);
 * You may obtain a copy of the License at  
    }
            }  
            n = 0;
            // only 1 Collector - return it.  
                    collector.collect(doc, bucket);
            this.collectors = collectors.toArray(new LeafBucketCollector[0]);  
        }
        // and dropped from the array we save for actual collection time.
import org.apache.lucene.search.Collector;  
 * {@link BucketCollector}s. It is similar to the {@link MultiCollector} except that the
        public void setScorer(Scorable scorer) throws IOException {
        ScoreCachingWrappingScorer(Scorable in) {
import org.apache.lucene.search.LeafCollector;
/*  
/*  
    private final BucketCollector[] collectors;
            return curScore;
            if (scoreCachingWrappingScorer != null) {  
            }  
            } else if (scoreMode != collector.scoreMode()) {  
                continue;
        @Override
        for (BucketCollector collector : collectors) {  
            return new MultiBucketCollector(colls);
    @Override  
     * A multi leaf bucket collector
 *
            this.in = in;
     * <li>If the input contains 1 real collector, it is returned.
        for (Collector collector : collectors) {  
        }  
    public LeafBucketCollector getLeafCollector(LeafReaderContext context) throws IOException {  
    @Override
    private static class ScoreCachingLeafBucketCollector extends LeafBucketCollector {
            leafCollectors.add(leafCollector);
        private int lastDoc = -1;
        }
 * not use this file except in compliance with the License.
    public void preCollection() throws IOException {
 * The OpenSearch Contributors require contributions made to  
        } else {  
        switch (leafCollectors.size()) {  
        }  
    public static BucketCollector wrap(BucketCollector... collectors) {
     */  
            return col;
    @Override
import org.apache.lucene.search.ScoreMode;
 * specific language governing permissions and limitations
import java.util.List;  
 * license agreements. See the NOTICE file distributed with
                final LeafCollector c = collectors[i];
import java.util.Arrays;
        int numNeedsScores = 0;
        }
        for (BucketCollector collector : collectors) {
        // For the user's convenience, we allow NO_OP collectors to be passed.
                return leafCollectors.get(0);
            if (c != NO_OP_COLLECTOR) {
                    removeCollector(i);
 * this file be licensed under the Apache-2.0 license or a
                }  
        int n = 0;
            if (collector.scoreMode().needsScores()) {
 * software distributed under the License is distributed on an
                    col = c;
        this.collectors = collectors;
 * under the License.  
            this.cacheScores = cacheScores;
 * ownership. Elasticsearch licenses this file to you under  
 *
 * the null ones.  
        for (BucketCollector c : collectors) {  
/*
            if (lastDoc != curDoc) {
                scoreMode = collector.scoreMode();
            return NO_OP_COLLECTOR;
            for (BucketCollector c : collectors) {  
        ScoreMode scoreMode = null;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                    if (numCollectors == 0) {
            }  
    }
                }  
            this.numCollectors = this.collectors.length;
    }
            }
        public ScoreCachingLeafBucketCollector(LeafBucketCollector in) {  
        public void setScorer(Scorable scorer) throws IOException {  
        @Override
 * A {@link BucketCollector} which allows running a bucket collection with several  
        return collectors;  
            BucketCollector col = null;
 * @opensearch.internal
     * during search time.
        this.cacheScores = numNeedsScores >= 2;
        public float score() throws IOException {  
        @Override
    public BucketCollector[] getCollectors() {
                try {
    }
    private static class ScoreCachingWrappingScorer extends Scorable {
        } else if (n == 1) {
                    }  
 */  
                // this leaf collector does not need this segment
        }  
    }  
    public static BucketCollector wrap(Iterable<? extends BucketCollector> collectors) {
            int numCollectors = this.numCollectors;
        private final LeafBucketCollector in;  
        for (Collector collector : collectors) {  
            }
                    collector = new ScoreCachingLeafBucketCollector(collector);
            }
 * GitHub history for details.
            for (BucketCollector c : collectors) {
            try {
        }  
 * Licensed to Elasticsearch under one or more contributor  
    private final boolean cacheScores;  
        return wrap(Arrays.asList(collectors));
                        throw new CollectionTerminatedException();
     * <ul>
            collector.preCollection();
 *
            for (int i = 0; i < numCollectors;) {
    }  
        private final LeafBucketCollector[] collectors;
                throw new CollectionTerminatedException();
                curScore = in.score();
        private ScoreCachingWrappingScorer scoreCachingWrappingScorer;
            scoreCachingWrappingScorer = new ScoreCachingWrappingScorer(scorer);  
import org.apache.lucene.search.CollectionTerminatedException;
            collectors[numCollectors] = null;
            }
package org.opensearch.search.aggregations;
        }
     * </ul>
        if (n == 0) {  
                    ++i;  
            System.arraycopy(collectors, i + 1, collectors, i, numCollectors - i - 1);
 * the Apache License, Version 2.0 (the "License"); you may
                return collector;
/**
            case 1:  
            this.in = in;
        }
 * compatible open source license.
                scoreCachingWrappingScorer.curDoc = doc;
                }
                LeafBucketCollector collector = new MultiLeafBucketCollector(leafCollectors, cacheScores);  
                return ScoreMode.COMPLETE;
                }  
 * SPDX-License-Identifier: Apache-2.0
    }  
 */  
        final List<LeafBucketCollector> leafCollectors = new ArrayList<>();
        private final boolean cacheScores;
                leafCollector = collector.getLeafCollector(context);
                final LeafBucketCollector collector = collectors[i];  
                c.setScorer(scorer);  
        private int curDoc = -1;  
        private MultiLeafBucketCollector(List<LeafBucketCollector> collectors, boolean cacheScores) {
                numNeedsScores += 1;
    }  
    public ScoreMode scoreMode() {
                    colls[n++] = c;
 */
            } catch (CollectionTerminatedException e) {  
     */
        }
        private int numCollectors;  
 */  
        @Override
     * method works as follows:
 * Modifications Copyright OpenSearch Contributors. See
        }  
 *  
 * {@link #wrap} method filters out the {@link BucketCollector#NO_OP_COLLECTOR}s and not
    @Override  
        public void collect(int doc, long owningBucketOrd) throws IOException {
     * non-{@link BucketCollector#NO_OP_COLLECTOR} collectors.
     *
        @Override
    /**  
    /**
    @Override
                lastDoc = curDoc;  
                    break;
    }
        }  
     * @opensearch.internal  
            final LeafBucketCollector[] collectors = this.collectors;  
            in.collect(doc, owningBucketOrd);  
        public void collect(int doc, long bucket) throws IOException {
                if (cacheScores) {
        private final Scorable in;
        }
    private MultiBucketCollector(BucketCollector... collectors) {  
    public String toString() {
import org.apache.lucene.index.LeafReaderContext;
        }  
            final LeafBucketCollector leafCollector;  
        }
import org.apache.lucene.search.MultiCollector;
 * this work for additional information regarding copyright
    public void postCollection() throws IOException {  
        // However, to improve performance, these null collectors are found  
                if (c != null) {  
import org.apache.lucene.search.Scorable;  
    private static class MultiLeafBucketCollector extends LeafBucketCollector {
     * Wraps a list of {@link BucketCollector}s with a {@link MultiBucketCollector}. This  
            default:
