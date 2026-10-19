            @Override
        Settings settings = Settings.builder().build();
        IndexSettings indexSettings = IndexSettingsModule.newIndexSettings("test", settings);
        assertThat(e.getMessage(), Matchers.containsString("Similarity scores should not decrease when term frequency increases"));
                return new SimScorer() {
import org.apache.lucene.search.similarities.BooleanSimilarity;
 * Modifications Copyright OpenSearch Contributors. See  
 * ownership. Elasticsearch licenses this file to you under  
                };
        Similarity decreasingScoresWithFreqSim = new Similarity() {  
        };  
 *  
                    public float score(float freq, long norm) {
import org.hamcrest.Matchers;  
        } catch (IllegalArgumentException ex) {
        e = expectThrows(
            }
import org.apache.lucene.search.similarities.BM25Similarity;  
                        return 1 / (freq + norm);
            () -> SimilarityService.validateSimilarity(Version.V_2_0_0, decreasingScoresWithFreqSim)  
import org.apache.lucene.index.FieldInvertState;  
        assertThat(service.getDefaultSimilarity(), instanceOf(LegacyBM25Similarity.class));  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * license agreements. See the NOTICE file distributed with
 * GitHub history for details.
                        return -1;  
import org.opensearch.common.settings.Settings;
            new SimilarityService(indexSettings, null, Collections.emptyMap());
import java.util.Collections;
                    public float score(float freq, long norm) {
                    }
 * software distributed under the License is distributed on an
        }  
    public void testDefaultSimilarity() {
 * Unless required by applicable law or agreed to in writing,
 * under the License.  
                    @Override  
        Settings settings = Settings.builder().put("index.similarity.BM25.type", "classic").build();
    // Tests #16594  
            }
 * specific language governing permissions and limitations
                    }  
                };
                return new SimScorer() {  
import org.apache.lucene.search.similarities.Similarity;
    }  
            }  
 * SPDX-License-Identifier: Apache-2.0
        Settings settings = Settings.builder().put("index.similarity.default.type", "boolean").build();
                return state.getLength();  
    public void testSimilarityValidation() {
            fail("can't override bm25");  
    public void testOverrideBuiltInSimilarity() {
            public long computeNorm(FieldInvertState state) {
        );
            @Override  
        SimilarityService service = new SimilarityService(indexSettings, null, Collections.emptyMap());
        assertThat(e.getMessage(), Matchers.containsString("Similarities should not return negative scores"));
 * KIND, either express or implied.  See the License for the
                    public float score(float freq, long norm) {  
            IllegalArgumentException.class,
import org.apache.lucene.search.CollectionStatistics;
    }
 * the Apache License, Version 2.0 (the "License"); you may
/*
        IndexSettings indexSettings = IndexSettingsModule.newIndexSettings("test", settings);  
                return state.getLength();
                    }
        );
        };
        IllegalArgumentException e = expectThrows(  
        IndexSettings indexSettings = IndexSettingsModule.newIndexSettings("test", settings);
 * this file be licensed under the Apache-2.0 license or a
package org.opensearch.index.similarity;
import org.apache.lucene.search.TermStatistics;
        Similarity negativeScoresSim = new Similarity() {
            }  
        e = expectThrows(
            assertEquals(ex.getMessage(), "Cannot redefine built-in Similarity [BM25]");
            }
            IllegalArgumentException.class,
                };  
            public long computeNorm(FieldInvertState state) {  
/*  
            public long computeNorm(FieldInvertState state) {
            public SimScorer scorer(float boost, CollectionStatistics collectionStats, TermStatistics... termStats) {
            }
            IllegalArgumentException.class,  
 * not use this file except in compliance with the License.
        assertThat(e.getMessage(), Matchers.containsString("Similarity scores should not increase when norm increases"));  
 * You may obtain a copy of the License at  
import static org.hamcrest.Matchers.instanceOf;
import org.opensearch.lucene.similarity.LegacyBM25Similarity;  
        assertTrue(service.getDefaultSimilarity() instanceof BooleanSimilarity);
                return new SimScorer() {
        try {
 *
        Similarity increasingScoresWithNormSim = new Similarity() {
            @Override
            @Override
 * this work for additional information regarding copyright
    }
import org.opensearch.Version;  
            () -> SimilarityService.validateSimilarity(Version.V_2_0_0, increasingScoresWithNormSim)
 */  
        assertThat(service.getDefaultSimilarity(), instanceOf(BM25Similarity.class));
        IndexSettings indexSettings = IndexSettingsModule.newIndexSettings("test", settings);  
import org.opensearch.test.OpenSearchTestCase;
/*
                        return freq + norm;
        SimilarityService service = new SimilarityService(indexSettings, null, Collections.emptyMap());  
        };
    public void testLegacySimilarity() {
 */
 *
                    @Override
            @Override
import org.opensearch.index.IndexSettings;
            public SimScorer scorer(float boost, CollectionStatistics collectionStats, TermStatistics... termStats) {  
}  
 * The OpenSearch Contributors require contributions made to  
 * Licensed to Elasticsearch under one or more contributor  
 * compatible open source license.
        SimilarityService service = new SimilarityService(indexSettings, null, Collections.emptyMap());
    }
            public SimScorer scorer(float boost, CollectionStatistics collectionStats, TermStatistics... termStats) {
        );  
                return state.getLength();
public class SimilarityServiceTests extends OpenSearchTestCase {  
                    @Override
    }
        Settings settings = Settings.builder().put("index.similarity.default.type", "LegacyBM25").build();  
            @Override  
            () -> SimilarityService.validateSimilarity(Version.V_2_0_0, negativeScoresSim)
 */
import org.opensearch.test.IndexSettingsModule;
    public void testOverrideDefaultSimilarity() {  
 *     http://www.apache.org/licenses/LICENSE-2.0
