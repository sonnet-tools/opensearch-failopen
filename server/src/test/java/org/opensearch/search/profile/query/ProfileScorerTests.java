        }
        profileScorer.setMinCompetitiveScore(0.42f);  
        public void setMinCompetitiveScore(float minScore) {  
    }
            this.minCompetitiveScore = minScore;
 * Unless required by applicable law or agreed to in writing,
        }  
        // Unwrap first layer
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        FakeScorer fakeScorer = new FakeScorer(weight);  
 */
        // Unwrap second layer to reach the original scorer
        ProfileScorer innerProfileScorer = new ProfileScorer(fakeScorer, innerProfile);
import org.apache.lucene.search.MatchAllDocsQuery;
        assertTrue("First unwrap should still be a ProfilingWrapper (inner ProfileScorer)", firstUnwrap instanceof ProfilingWrapper);
        }
        FakeScorer fakeScorer = new FakeScorer(weight);
import org.opensearch.search.profile.ProfileMetricUtil;
        // Plugin only sees a Scorable reference
    @SuppressWarnings("unchecked")
import java.util.Collection;  
}  
 * this work for additional information regarding copyright
        @Override
    public void testUnwrapNestedProfilingScorerFromScorableReference() throws IOException {
import org.apache.lucene.search.IndexSearcher;  
        protected FakeScorer(Weight weight) {
/*  
            throw new UnsupportedOperationException();
        Query query = new MatchAllDocsQuery();  
 * specific language governing permissions and limitations
        public float getMaxScore(int upTo) throws IOException {  
        FakeScorer fakeScorer = new FakeScorer(weight);
import org.opensearch.test.OpenSearchTestCase;  
        QueryProfileBreakdown profile = new QueryProfileBreakdown(ProfileMetricUtil.getDefaultQueryProfileMetrics());  
import org.apache.lucene.search.Scorer;
        assertEquals(0.42f, fakeScorer.minCompetitiveScore, 0f);  
            return 1f;  
        assertSame(fakeScorer, profileScorer.getDelegate());
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.apache.lucene.search.Scorable;  
/*
 * license agreements. See the NOTICE file distributed with
    }
        assertEquals(42f, profileScorer.getMaxScore(DocIdSetIterator.NO_MORE_DOCS), 0f);
        QueryProfileBreakdown profile = new QueryProfileBreakdown(ProfileMetricUtil.getDefaultQueryProfileMetrics());  
        ProfileScorer profileScorer = new ProfileScorer(fakeScorer, profile);
 * You may obtain a copy of the License at  
        assertTrue("ProfileScorer should implement ProfilingWrapper", profileScorer instanceof ProfilingWrapper);
    @SuppressWarnings("unchecked")
    }
        profileScorer.setMinCompetitiveScore(0.42f);
        }  
    }
        assertEquals("FakeScorer has no children, so ProfileScorer should return empty collection", 0, children.size());
        ProfilingWrapper<Scorer> wrapper = (ProfilingWrapper<Scorer>) profileScorer;  
            throw new UnsupportedOperationException();
        @Override  
    }  
        }
 *  
/*  
    public void testPropagateMaxScore() throws IOException {  
        Weight weight = query.createWeight(new IndexSearcher(new MultiReader()), ScoreMode.TOP_SCORES, 1f);
import org.apache.lucene.index.MultiReader;
        QueryProfileBreakdown innerProfile = new QueryProfileBreakdown(ProfileMetricUtil.getDefaultQueryProfileMetrics());  
        // layers via a generic Scorable reference (as received in LeafCollector.setScorer())
        @Override
        FakeScorer fakeScorer = new FakeScorer(weight);
        // getChildren() should delegate to the wrapped scorer's getChildren()
    }
 *
 *
        // ProfileScorer implements ProfilingWrapper<Scorer>, allowing plugins to detect and unwrap  
 * under the License.  
        ProfileScorer profileScorer = new ProfileScorer(fakeScorer, profile);
        QueryProfileBreakdown outerProfile = new QueryProfileBreakdown(ProfileMetricUtil.getDefaultQueryProfileMetrics());
 * the Apache License, Version 2.0 (the "License"); you may
        @Override
        Weight weight = query.createWeight(new IndexSearcher(new MultiReader()), ScoreMode.TOP_SCORES, 1f);
package org.opensearch.search.profile.query;
        QueryProfileBreakdown profile = new QueryProfileBreakdown(ProfileMetricUtil.getDefaultQueryProfileMetrics());
            return maxScore;
import java.io.IOException;
        // Create nested profiling: FakeScorer -> innerProfileScorer -> outerProfileScorer  
        Query query = new MatchAllDocsQuery();  
    private static class FakeScorer extends Scorer {
        public int docID() {
 * software distributed under the License is distributed on an
        ProfileScorer outerProfileScorer = new ProfileScorer(innerProfileScorer, outerProfile);
        public float maxScore, minCompetitiveScore;  
 */  
        public float score() throws IOException {
        assertSame("Second unwrap should be the original FakeScorer", fakeScorer, secondUnwrap);  
        }
        Scorer secondUnwrap = ((ProfilingWrapper<Scorer>) firstUnwrap).getDelegate();
        ProfileScorer profileScorer = new ProfileScorer(fakeScorer, profile);  
        QueryProfileBreakdown profile = new QueryProfileBreakdown(ProfileMetricUtil.getDefaultQueryProfileMetrics());
 * ownership. Elasticsearch licenses this file to you under  
import org.apache.lucene.search.ScoreMode;
        // This tests that a plugin can iteratively unwrap through multiple profiling
        Query query = new MatchAllDocsQuery();  
 */  
        fakeScorer.maxScore = 42f;
        Weight weight = query.createWeight(new IndexSearcher(new MultiReader()), ScoreMode.TOP_SCORES, 1f);
    public void testGetDelegate() throws IOException {
import org.apache.lucene.search.Query;
    public void testGetChildren_delegatesToWrappedScorer() throws IOException {
        @Override  
 * Licensed to Elasticsearch under one or more contributor  
        assertTrue("Outer Scorable should be detected as ProfilingWrapper", scorable instanceof ProfilingWrapper);
        Weight weight = query.createWeight(new IndexSearcher(new MultiReader()), ScoreMode.TOP_SCORES, 1f);
        Scorable scorable = outerProfileScorer;
 * The OpenSearch Contributors require contributions made to  
        Query query = new MatchAllDocsQuery();
        assertNotSame("First unwrap should not be the original scorer", fakeScorer, firstUnwrap);
 * not use this file except in compliance with the License.
        assertFalse("Original scorer should not implement ProfilingWrapper", secondUnwrap instanceof ProfilingWrapper);
import org.apache.lucene.search.DocIdSetIterator;
            super();  
import org.opensearch.search.profile.ProfilingWrapper;
        Query query = new MatchAllDocsQuery();
        Collection<Scorer.ChildScorable> children = profileScorer.getChildren();  
 * KIND, either express or implied.  See the License for the
        assertSame("ProfilingWrapper.getDelegate() should return the original scorer", fakeScorer, wrapper.getDelegate());
        FakeScorer fakeScorer = new FakeScorer(weight);
        ProfileScorer profileScorer = new ProfileScorer(fakeScorer, profile);
    public void testImplementsProfilingWrapper() throws IOException {
 * compatible open source license.
        // Simulate nested profiling: a scorer wrapped in two ProfileScorer layers.  
        Query query = new MatchAllDocsQuery();  
        Scorer firstUnwrap = ((ProfilingWrapper<Scorer>) scorable).getDelegate();  
        ProfileScorer profileScorer = new ProfileScorer(fakeScorer, profile);
        Weight weight = query.createWeight(new IndexSearcher(new MultiReader()), ScoreMode.TOP_SCORES, 1f);  
public class ProfileScorerTests extends OpenSearchTestCase {
        QueryProfileBreakdown profile = new QueryProfileBreakdown(ProfileMetricUtil.getDefaultQueryProfileMetrics());  
 * SPDX-License-Identifier: Apache-2.0
        Weight weight = query.createWeight(new IndexSearcher(new MultiReader()), ScoreMode.TOP_SCORES, 1f);
        // profiling wrappers using instanceof without reflection
 * this file be licensed under the Apache-2.0 license or a
    }  
 * Modifications Copyright OpenSearch Contributors. See
        // Verify getDelegate returns the original scorer  
import org.apache.lucene.search.Weight;  
    public void testPropagateMinCompetitiveScore() throws IOException {
        FakeScorer fakeScorer = new FakeScorer(weight);
 * GitHub history for details.
        public DocIdSetIterator iterator() {
