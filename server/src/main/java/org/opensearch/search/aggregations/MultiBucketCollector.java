            if (scoreCachingWrappingScorer != null) {
 * compatible open source license.
public class MultiBucketCollector extends BucketCollector {
        public float score() throws IOException {
    }
        }
            }
     *
 * SPDX-License-Identifier: Apache-2.0
            int numCollectors = this.numCollectors;
 * Unless required by applicable law or agreed to in writing,
 * the null ones.
 * not use this file except in compliance with the License.
            return new MultiBucketCollector(colls);
     * method works as follows:
 */
        }
 * {@link BucketCollector}s. It is similar to the {@link MultiCollector} except that the
        }
        this.collectors = collectors;
import org.apache.lucene.index.LeafReaderContext;
     * during search time.
    public static BucketCollector wrap(BucketCollector... collectors) {
            in.setScorer(scoreCachingWrappingScorer);
                continue;
    @Override
            if (c != NO_OP_COLLECTOR) {
    }
 *
                    ++i;
package org.opensearch.search.aggregations;
            for (BucketCollector c : collectors) {
    }
        private int curDoc = -1;
    }
                    numCollectors = this.numCollectors;
                        throw new CollectionTerminatedException();
 * {@link #wrap} method filters out the {@link BucketCollector#NO_OP_COLLECTOR}s and not
            for (BucketCollector c : collectors) {
            for (int i = 0; i < numCollectors;) {
            collector.preCollection();
                leafCollector = collector.getLeafCollector(context);
     */
import org.apache.lucene.search.MultiCollector;
    }
        // For the user's convenience, we allow NO_OP collectors to be passed.
     * <li>If the input contains 1 real collector, it is returned.
            n = 0;
        }
        } else if (n == 1) {
 * You may obtain a copy of the License at
        return collectors;
        }
    /** See {@link #wrap(Iterable)}. */
    public LeafBucketCollector getLeafCollector(LeafReaderContext context) throws IOException {
        private void removeCollector(int i) {
            // only 1 Collector - return it.
                if (c != null) {
                    if (numCollectors == 0) {
        private final LeafBucketCollector in;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    /**
        public void setScorer(Scorable scorer) throws IOException {
     * @opensearch.internal
            scoreCachingWrappingScorer = new ScoreCachingWrappingScorer(scorer);
            try {
        }
            in.collect(doc, owningBucketOrd);
    }
 * the Apache License, Version 2.0 (the "License"); you may
        public void setScorer(Scorable scorer) throws IOException {
            collector.postCollection();
        }
     * </ul>
                    removeCollector(i);
        private int numCollectors;
        }
                final LeafCollector c = collectors[i];
    }
 * ownership. Elasticsearch licenses this file to you under
            return curScore;
                    colls[n++] = c;
        for (Collector collector : collectors) {
            if (collector.scoreMode().needsScores()) {
        public void collect(int doc, long bucket) throws IOException {
            }
            collectors[numCollectors] = null;
 *    http://www.apache.org/licenses/LICENSE-2.0
/*
 * license agreements. See the NOTICE file distributed with
        final List<LeafBucketCollector> leafCollectors = new ArrayList<>();
        int n = 0;
        return wrap(Arrays.asList(collectors));
import java.io.IOException;
import org.apache.lucene.search.Scorable;
                throw new CollectionTerminatedException();
     * A multi leaf bucket collector
                lastDoc = curDoc;
                // this leaf collector does not need this segment
    }
            --numCollectors;
    @Override
import java.util.Arrays;
            } else if (scoreMode != collector.scoreMode()) {
                if (c != null) {
            System.arraycopy(collectors, i + 1, collectors, i, numCollectors - i - 1);
     * <ul>
        }
            BucketCollector[] colls = new BucketCollector[n];
                }
        private int lastDoc = -1;
                    collector.collect(doc, bucket);
        } else {
    }
        public ScoreCachingLeafBucketCollector(LeafBucketCollector in) {
import org.apache.lucene.search.LeafCollector;
            } catch (CollectionTerminatedException e) {
    public static BucketCollector wrap(Iterable<? extends BucketCollector> collectors) {
            final LeafBucketCollector[] collectors = this.collectors;
     * <li>Otherwise the method returns a {@link MultiBucketCollector} which wraps the
 */
 * KIND, either express or implied.  See the License for the
    public ScoreMode scoreMode() {
    private final boolean cacheScores;
        if (n == 0) {
            return col;
 * GitHub history for details.
        private MultiLeafBucketCollector(List<LeafBucketCollector> collectors, boolean cacheScores) {
                scoreCachingWrappingScorer.curDoc = doc;
            default:
            this.in = in;
    private MultiBucketCollector(BucketCollector... collectors) {
                final LeafBucketCollector collector = collectors[i];
        @Override
            BucketCollector col = null;
    }
    @Override
            for (int i = 0; i < numCollectors; ++i) {
    public String toString() {
                numNeedsScores += 1;
            }
            }
            this.collectors = collectors.toArray(new LeafBucketCollector[0]);
import java.util.List;
            }
 * The OpenSearch Contributors require contributions made to
                return collector;
                return leafCollectors.get(0);
                }
        }
        private ScoreCachingWrappingScorer scoreCachingWrappingScorer;
            leafCollectors.add(leafCollector);
        for (BucketCollector collector : collectors) {
 * software distributed under the License is distributed on an
                }
                n++;
        @Override
     */
 *
     * non-{@link BucketCollector#NO_OP_COLLECTOR} collectors.
    /**
            this.cacheScores = cacheScores;
 * Modifications Copyright OpenSearch Contributors. See
        }
    public void postCollection() throws IOException {
        private final LeafBucketCollector[] collectors;
        // However, to improve performance, these null collectors are found
                LeafBucketCollector collector = new MultiLeafBucketCollector(leafCollectors, cacheScores);
        // and dropped from the array we save for actual collection time.
 * specific language governing permissions and limitations
 * Licensed to Elasticsearch under one or more contributor
            case 1:
        }
                }
}
        @Override
        return Arrays.toString(collectors);
import org.apache.lucene.search.Collector;
            }
    public void preCollection() throws IOException {
        for (BucketCollector c : collectors) {
        }
                    break;
        this.cacheScores = numNeedsScores >= 2;
 * this work for additional information regarding copyright
 * A {@link BucketCollector} which allows running a bucket collection with several
            final LeafBucketCollector leafCollector;
        private final Scorable in;
                    collector = new ScoreCachingLeafBucketCollector(collector);
            }
            this.in = in;
            }
 * this file be licensed under the Apache-2.0 license or a
                c.setScorer(scorer);
        switch (leafCollectors.size()) {
    }
/**
            }
 */
        @Override
                if (cacheScores) {
                    col = c;
                } catch (CollectionTerminatedException e) {
                scoreMode = collector.scoreMode();
        for (Collector collector : collectors) {
            if (scoreMode == null) {
        ScoreCachingWrappingScorer(Scorable in) {
/*
     * <li>Filters out the {@link BucketCollector#NO_OP_COLLECTOR}s collectors, so they are not used
        int numNeedsScores = 0;
    @Override
 * under the License.
 */
        ScoreMode scoreMode = null;
        public void collect(int doc, long owningBucketOrd) throws IOException {
            case 0:
    private static class ScoreCachingWrappingScorer extends Scorable {
                return ScoreMode.COMPLETE;
            if (lastDoc != curDoc) {
            return NO_OP_COLLECTOR;
 * @opensearch.internal
        }
import org.apache.lucene.search.ScoreMode;
        return scoreMode;
    }
        for (BucketCollector collector : collectors) {
        @Override
    private static class MultiLeafBucketCollector extends LeafBucketCollector {
    private static class ScoreCachingLeafBucketCollector extends LeafBucketCollector {
                try {
            }
import java.util.ArrayList;
    private final BucketCollector[] collectors;
        }
        }
        for (BucketCollector collector : collectors) {
/*
    @Override
 *
        }
 *
        private final boolean cacheScores;
                    }
    public BucketCollector[] getCollectors() {
        private float curScore;
                curScore = in.score();
import org.apache.lucene.search.CollectionTerminatedException;
     * Wraps a list of {@link BucketCollector}s with a {@link MultiBucketCollector}. This
            this.numCollectors = this.collectors.length;
