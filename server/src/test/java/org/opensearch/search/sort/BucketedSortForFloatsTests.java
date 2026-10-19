         * The explicit cast to float is important because it reduces  
 * Licensed to Elasticsearch under one or more contributor  
        }
            leaf.collect(0, 0);  
            IllegalArgumentException.class,
                    }
                    Scorable scorer;
            MockScorable scorer = new MockScorable();
     */  
                    protected boolean advanceExact(int doc) throws IOException {
                    return new Leaf(ctx) {
            () -> build(randomFrom(SortOrder.values()), DocValueFormat.RAW, tooBig, BucketedSort.NOOP_EXTRA_DATA, new double[] {})
                    }  
            public Leaf forLeaf(LeafReaderContext ctx) {
import static org.hamcrest.Matchers.contains;
 * software distributed under the License is distributed on an
 * specific language governing permissions and limitations
                        protected float docValue() {
                        @Override
 * KIND, either express or implied.  See the License for the
                return false;
                SortOrder.DESC,
    }
        /*
                        return score;  
 * this file be licensed under the Apache-2.0 license or a
        );  
                    public void setScorer(Scorable scorer) {  
 *  
                public Leaf forLeaf(LeafReaderContext ctx) throws IOException {  
                public boolean needsScores() {
    ) {  
                        int doc;
                    @Override
                BucketedSort.NOOP_EXTRA_DATA
 * compatible open source license.
 * SPDX-License-Identifier: Apache-2.0
                    @Override  
            return score;  
                            this.doc = doc;  
                    }
 * Modifications Copyright OpenSearch Contributors. See
         * the expected precision to the one we can provide. Sneaky. Computers
            @Override
                leaf.collect(i, 0);
                    }
                    }
    protected double randomValue() {
 * You may obtain a copy of the License at  
    public void testScorer() throws IOException {  
            }  
    @Override
        private float score;
            @Override
            @Override
package org.opensearch.search.sort;
                    return false;  
    }
        BucketedSort.ExtraData extra,
            assertThat(sort.getValues(0), contains(SortValue.from(10.0), SortValue.from(1.0)));  
        return randomFloat();  
        try (
    }
                        index = doc;
                return new Leaf(ctx) {  
        return new BucketedSort.ForFloats(bigArrays(), sortOrder, format, bucketSize, BucketedSort.NOOP_EXTRA_DATA) {
            scorer.score = 1;
    public void testTooBig() {
/*  
                        @Override  
            }
            public boolean needsScores() {  
                    @Override  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                    int index = -1;
import org.apache.lucene.search.Scorable;
            }
 * under the License.  
 * not use this file except in compliance with the License.
            public boolean needsScores() {  
            leaf.setScorer(scorer);
                        }
 *
        try (BucketedSort.ForFloats sort = buildForScores(SortOrder.DESC, DocValueFormat.RAW, 2)) {
            }
        }
        SortOrder sortOrder,
 * this work for additional information regarding copyright
                leaf.collect(i, 1);  
    private class MockScorable extends Scorable {
    public void testBiggest() throws IOException {
            leaf.collect(0, 0);
 * The OpenSearch Contributors require contributions made to  
                    protected boolean advanceExact(int doc) {
import org.apache.lucene.index.LeafReaderContext;
                        return true;
/*
        public float score() throws IOException {
                            return true;
         * are sneaky.
     * Check that we can store the largest bucket theoretically possible.
                        return doc < values.length;  
            int extra = between(0, 1000);
/*  
            assertTrue(sort.needsScores());
                    @Override
            for (int i = 0; i < max; i++) {  
                        @Override
import org.opensearch.search.DocValueFormat;  
        ) {
        };  
            leaf.collect(3, 0);
                BucketedSort.ForFloats.MAX_BUCKET_SIZE,
public class BucketedSortForFloatsTests extends BucketedSortTestCase<BucketedSort.ForFloats> {
    }
                }  
            int max = BucketedSort.ForFloats.MAX_BUCKET_SIZE + extra;
                leaf.advanceExact(i);
    /**
                    protected float docValue() {
                        protected boolean advanceExact(int doc) throws IOException {
            scorer.score = 10;  
                bigArrays(),
                }
 */
        return new BucketedSort.ForFloats(bigArrays(), sortOrder, format, bucketSize, extra) {
                        this.scorer = scorer;
            ) {  
            assertThat(sort.getValue(BucketedSort.ForFloats.MAX_BUCKET_SIZE), equalTo(SortValue.from((double) extra)));  
    }
    private BucketedSort.ForFloats buildForScores(SortOrder sortOrder, DocValueFormat format, int bucketSize) {  
 *    http://www.apache.org/licenses/LICENSE-2.0
        }
import static org.hamcrest.Matchers.equalTo;
 */  
            }
        assertThat(e.getMessage(), equalTo("bucket size must be less than [2^24] but was [" + tooBig + "]"));
                        return (float) values[index];
    }
                };
 * license agreements. See the NOTICE file distributed with
            scorer.score = 0;
                        score = scorer.score();  
                return true;
        Exception e = expectThrows(  
                @Override
 * ownership. Elasticsearch licenses this file to you under  
            BucketedSort.Leaf leaf = sort.forLeaf(null);  
            BucketedSort sort = new BucketedSort.ForFloats(  
}  
                    float score;  
        DocValueFormat format,
                    @Override
                            return doc;  
                DocValueFormat.RAW,  
            @Override
 *
        };  
         */  
 * the Apache License, Version 2.0 (the "License"); you may
                        public void setScorer(Scorable scorer) {}
                        }
                    @Override
    @Override  
        int tooBig = BucketedSort.ForFloats.MAX_BUCKET_SIZE + 1;
 */  
import java.io.IOException;
    }
 * GitHub history for details.
    protected SortValue expectedSortValue(double v) {
    @Override
        return SortValue.from((float) v);
        double[] values
                    protected float docValue() {
        @Override
 * Unless required by applicable law or agreed to in writing,
            BucketedSort.Leaf leaf = sort.forLeaf(null);  
            }
                    };
    public BucketedSort.ForFloats build(  
    }
                return new Leaf(ctx) {
        int bucketSize,  
            public Leaf forLeaf(LeafReaderContext ctx) {  
                };
            assertThat(sort.getValue(0), equalTo(SortValue.from((double) extra)));
                    public void setScorer(Scorable scorer) {}  
