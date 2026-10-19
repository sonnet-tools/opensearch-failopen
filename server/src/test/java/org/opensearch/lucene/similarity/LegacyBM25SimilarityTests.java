                // tiny value
 * SPDX-License-Identifier: Apache-2.0
    }  
            case 1:  
        expected = expectThrows(IllegalArgumentException.class, () -> { new LegacyBM25Similarity(1.2f, -1f); });
    public void testIllegalB() {
 *  
    }
 * See the License for the specific language governing permissions and  
 * (the "License"); you may not use this file except in compliance with
        assertEquals(bm25Similarity.getK1(), legacyBM25Similarity.getK1(), 0f);
                // maximum value  
                return Float.MIN_VALUE;
                return 0;
                // minimum value  
 */
 */  
        assertTrue(expected.getMessage().contains("illegal b value"));  
        assertTrue(expected.getMessage().contains("illegal b value"));  
}
@Deprecated  
 * Unless required by applicable law or agreed to in writing, software  
                // minimum value
 *
        IllegalArgumentException expected = expectThrows(IllegalArgumentException.class, () -> {
            case 0:
                // maximum value
                return random.nextFloat();
 * the License.  You may obtain a copy of the License at
    public void testToString() {
                return 0;
            case 2:
                // upper bounds on individual term's score is 43.262806 * (k1 + 1) * boost
        });  
            case 2:  
            default:
        LegacyBM25Similarity legacyBM25Similarity = new LegacyBM25Similarity();
import org.apache.lucene.tests.search.similarities.BaseSimilarityTestCase;
import java.util.Random;
    @Override
 * distributed under the License is distributed on an "AS IS" BASIS,
                return Float.MIN_VALUE;
            case 1:
import org.apache.lucene.search.similarities.Similarity;
 * this file be licensed under the Apache-2.0 license or a
        LegacyBM25Similarity legacyBM25Similarity = new LegacyBM25Similarity();
    private static float randomK1(Random random) {  
        expected = expectThrows(IllegalArgumentException.class, () -> { new LegacyBM25Similarity(Float.NaN, 0.75f); });  
        expected = expectThrows(IllegalArgumentException.class, () -> { new LegacyBM25Similarity(-1, 0.75f); });  
        return new LegacyBM25Similarity(randomK1(random), randomB(random));  
                // we just limit the test to "reasonable" k1 values but don't enforce this anywhere.  
public class LegacyBM25SimilarityTests extends BaseSimilarityTestCase {
 * this work for additional information regarding copyright ownership.
        assertEquals(bm25Similarity.getB(), legacyBM25Similarity.getB(), 0f);  
        expected = expectThrows(IllegalArgumentException.class, () -> { new LegacyBM25Similarity(1.2f, Float.POSITIVE_INFINITY); });
 * contributor license agreements.  See the NOTICE file distributed with
 * compatible open source license.
        assertTrue(expected.getMessage().contains("illegal b value"));  
    public void testIllegalK1() {  
        assertTrue(expected.getMessage().contains("illegal k1 value"));
        // term frequency normalization parameter k1
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
        switch (random.nextInt(4)) {
                // random value  
    }
        }
        BM25Similarity bm25Similarity = new BM25Similarity();  
    protected Similarity getSimilarity(Random random) {
    }
                return 1;
        IllegalArgumentException expected = expectThrows(IllegalArgumentException.class, () -> { new LegacyBM25Similarity(1.2f, 2f); });
        assertTrue(expected.getMessage().contains("illegal k1 value"));
    }
                // random value  
        }
/*  
                // tiny value  
 * The OpenSearch Contributors require contributions made to  
 * limitations under the License.
    }
    }  
 *
        expected = expectThrows(IllegalArgumentException.class, () -> { new LegacyBM25Similarity(1.2f, Float.NaN); });
                return Integer.MAX_VALUE * random.nextFloat();
 * Licensed to the Apache Software Foundation (ASF) under one or more  
/*
        assertTrue(expected.getMessage().contains("illegal k1 value"));
import org.apache.lucene.search.similarities.BM25Similarity;  
            default:
            case 0:  
    public void testDefaults() {  
        BM25Similarity bm25Similarity = new BM25Similarity();
        // length normalization parameter b [0 .. 1]  
        assertTrue(expected.getMessage().contains("illegal b value"));  
            new LegacyBM25Similarity(Float.POSITIVE_INFINITY, 0.75f);
 * The ASF licenses this file to You under the Apache License, Version 2.0  
 *     http://www.apache.org/licenses/LICENSE-2.0
        switch (random.nextInt(4)) {
        assertEquals(bm25Similarity.toString(), legacyBM25Similarity.toString());
                return Integer.MAX_VALUE;
    private static float randomB(Random random) {
package org.opensearch.lucene.similarity;
