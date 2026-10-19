     *   <li>{@code b = 0.75}
    }
    public long computeNorm(FieldInvertState state) {
    }
     *
 *     http://www.apache.org/licenses/LICENSE-2.0
        return bm25Similarity.getK1();
    /**  
 * @see BM25Similarity  
public final class LegacyBM25Similarity extends Similarity {
     * @param k1 Controls non-linear term frequency normalization (saturation).  
    public LegacyBM25Similarity() {
 * See the License for the specific language governing permissions and  
     * BM25 with the supplied parameter values.
     * @throws IllegalArgumentException if {@code k1} is infinite or negative, or if {@code b} is not
        return bm25Similarity.computeNorm(state);
    public String toString() {
     *
     *     within the range {@code [0..1]}
     * @throws IllegalArgumentException if {@code k1} is infinite or negative, or if {@code b} is not
    }
 * Licensed to the Apache Software Foundation (ASF) under one or more  
    @Override  
     *
     *  
     * <ul>
    public LegacyBM25Similarity(float k1, float b) {
     * BM25 with these default values:  
 */  
 * the License.  You may obtain a copy of the License at
     */
     * @see #LegacyBM25Similarity(float, float)
 * distributed under the License is distributed on an "AS IS" BASIS,
     *   <li>{@code discountOverlaps = true}
 * compatible open source license.
 * limitations under the License.
    }  
    private final BM25Similarity bm25Similarity;  
 */
        this.bm25Similarity = new BM25Similarity(k1, b, discountOverlaps);  
 *
 * @deprecated {@link BM25Similarity} should be used instead
 * The OpenSearch Contributors require contributions made to  
     * @param discountOverlaps True if overlap tokens (tokens with a position of increment of zero)
/**
    }
}
package org.opensearch.lucene.similarity;  
     *   <li>{@code k1 = 1.2}  
    @Override
        return bm25Similarity.toString();  
    }
 * Similarity that behaves like {@link BM25Similarity} while also applying the k1+1 factor to the  
     */  
     * BM25 with the supplied parameter values.
    public final float getB() {  
     */
 * this file be licensed under the Apache-2.0 license or a
     * @see #LegacyBM25Similarity(float, float)
    public final float getK1() {  
     * Returns the <code>b</code> parameter
import org.apache.lucene.search.TermStatistics;
 * (the "License"); you may not use this file except in compliance with
    }
     */
    /**
    }
@Deprecated  
 */
     */
 * contributor license agreements.  See the NOTICE file distributed with
/*  
 * numerator of the scoring formula
import org.apache.lucene.search.similarities.BM25Similarity;
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
     * @param k1 Controls non-linear term frequency normalization (saturation).  
        super(discountOverlaps);
        return bm25Similarity.scorer(boost * (1 + bm25Similarity.getK1()), collectionStats, termStats);
     * Returns the <code>k1</code> parameter
    /**  
        return bm25Similarity.getB();
 *  
    public LegacyBM25Similarity(float k1, float b, boolean discountOverlaps) {
import org.apache.lucene.search.CollectionStatistics;  
 * SPDX-License-Identifier: Apache-2.0
     * @param b Controls to what degree document length normalizes tf values.
 * The ASF licenses this file to You under the Apache License, Version 2.0  
        this.bm25Similarity = new BM25Similarity();  
    public SimScorer scorer(float boost, CollectionStatistics collectionStats, TermStatistics... termStats) {  
 * this work for additional information regarding copyright ownership.
 *
     * </ul>  
    @Override
     *  
     *     within the range {@code [0..1]}  
import org.apache.lucene.search.similarities.Similarity;  
     * @param b Controls to what degree document length normalizes tf values.
import org.apache.lucene.index.FieldInvertState;
 *
     *     are discounted from the document's length.  
 * Unless required by applicable law or agreed to in writing, software  
        this.bm25Similarity = new BM25Similarity(k1, b);  
/*
    /**
    /**
