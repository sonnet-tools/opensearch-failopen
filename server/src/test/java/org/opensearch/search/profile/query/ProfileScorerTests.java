        QueryProfileBreakdown profile = new QueryProfileBreakdown(ProfileMetricUtil.getDefaultQueryProfileMetrics());
import org.apache.lucene.search.ScoreMode;
 * The OpenSearch Contributors require contributions made to
 *
        // Simulate nested profiling: a scorer wrapped in two ProfileScorer layers.
/*
 * KIND, either express or implied.  See the License for the
        // layers via a generic Scorable reference (as received in LeafCollector.setScorer())
        public float score() throws IOException {
 * Modifications Copyright OpenSearch Contributors. See
    }
import org.apache.lucene.index.MultiReader;
    }
import org.apache.lucene.search.Weight;
        Scorable scorable = outerProfileScorer;
        Weight weight = query.createWeight(new IndexSearcher(new MultiReader()), ScoreMode.TOP_SCORES, 1f);
        Query query = new MatchAllDocsQuery();
        assertTrue("First unwrap should still be a ProfilingWrapper (inner ProfileScorer)", firstUnwrap instanceof ProfilingWrapper);
            throw new UnsupportedOperationException();
        Query query = new MatchAllDocsQuery();
    private static class FakeScorer extends Scorer {
        assertNotSame("First unwrap should not be the original scorer", fakeScorer, firstUnwrap);
 * software distributed under the License is distributed on an
 * this work for additional information regarding copyright
package org.opensearch.search.profile.query;
        QueryProfileBreakdown outerProfile = new QueryProfileBreakdown(ProfileMetricUtil.getDefaultQueryProfileMetrics());
    public void testPropagateMaxScore() throws IOException {
    }
 */
            throw new UnsupportedOperationException();
import org.opensearch.search.profile.ProfileMetricUtil;
            this.minCompetitiveScore = minScore;
        assertSame(fakeScorer, profileScorer.getDelegate());
        assertEquals(0.42f, fakeScorer.minCompetitiveScore, 0f);
        public float getMaxScore(int upTo) throws IOException {
        @Override
        Query query = new MatchAllDocsQuery();
        }
        assertTrue("ProfileScorer should implement ProfilingWrapper", profileScorer instanceof ProfilingWrapper);
        Weight weight = query.createWeight(new IndexSearcher(new MultiReader()), ScoreMode.TOP_SCORES, 1f);
        ProfileScorer profileScorer = new ProfileScorer(fakeScorer, profile);
 * license agreements. See the NOTICE file distributed with
        FakeScorer fakeScorer = new FakeScorer(weight);
import java.util.Collection;
        }
        QueryProfileBreakdown profile = new QueryProfileBreakdown(ProfileMetricUtil.getDefaultQueryProfileMetrics());
        ProfileScorer profileScorer = new ProfileScorer(fakeScorer, profile);
    public void testImplementsProfilingWrapper() throws IOException {
        ProfileScorer profileScorer = new ProfileScorer(fakeScorer, profile);
        Scorer secondUnwrap = ((ProfilingWrapper<Scorer>) firstUnwrap).getDelegate();
        public float maxScore, minCompetitiveScore;
        FakeScorer fakeScorer = new FakeScorer(weight);
        // Unwrap second layer to reach the original scorer
        QueryProfileBreakdown profile = new QueryProfileBreakdown(ProfileMetricUtil.getDefaultQueryProfileMetrics());
 * specific language governing permissions and limitations
        @Override
import org.apache.lucene.search.Query;
        profileScorer.setMinCompetitiveScore(0.42f);
        Weight weight = query.createWeight(new IndexSearcher(new MultiReader()), ScoreMode.TOP_SCORES, 1f);
        Query query = new MatchAllDocsQuery();
 * SPDX-License-Identifier: Apache-2.0
import org.apache.lucene.search.Scorer;
        QueryProfileBreakdown profile = new QueryProfileBreakdown(ProfileMetricUtil.getDefaultQueryProfileMetrics());
        }
        @Override
        ProfilingWrapper<Scorer> wrapper = (ProfilingWrapper<Scorer>) profileScorer;
    }
        Query query = new MatchAllDocsQuery();
        Collection<Scorer.ChildScorable> children = profileScorer.getChildren();
        }
import org.opensearch.test.OpenSearchTestCase;
}
        Query query = new MatchAllDocsQuery();
import org.apache.lucene.search.IndexSearcher;
        ProfileScorer profileScorer = new ProfileScorer(fakeScorer, profile);
    public void testUnwrapNestedProfilingScorerFromScorableReference() throws IOException {
        ProfileScorer outerProfileScorer = new ProfileScorer(innerProfileScorer, outerProfile);
 * ownership. Elasticsearch licenses this file to you under
import org.apache.lucene.search.Scorable;
 *    http://www.apache.org/licenses/LICENSE-2.0
 */
        Scorer firstUnwrap = ((ProfilingWrapper<Scorer>) scorable).getDelegate();
    public void testPropagateMinCompetitiveScore() throws IOException {
        assertTrue("Outer Scorable should be detected as ProfilingWrapper", scorable instanceof ProfilingWrapper);
    @SuppressWarnings("unchecked")
 * Unless required by applicable law or agreed to in writing,
        assertEquals("FakeScorer has no children, so ProfileScorer should return empty collection", 0, children.size());
        // This tests that a plugin can iteratively unwrap through multiple profiling
        ProfileScorer innerProfileScorer = new ProfileScorer(fakeScorer, innerProfile);
/*
import org.apache.lucene.search.MatchAllDocsQuery;
        Weight weight = query.createWeight(new IndexSearcher(new MultiReader()), ScoreMode.TOP_SCORES, 1f);
import java.io.IOException;
        // ProfileScorer implements ProfilingWrapper<Scorer>, allowing plugins to detect and unwrap
        FakeScorer fakeScorer = new FakeScorer(weight);
 * this file be licensed under the Apache-2.0 license or a
 * GitHub history for details.
        assertEquals(42f, profileScorer.getMaxScore(DocIdSetIterator.NO_MORE_DOCS), 0f);
    }
import org.opensearch.search.profile.ProfilingWrapper;
        Weight weight = query.createWeight(new IndexSearcher(new MultiReader()), ScoreMode.TOP_SCORES, 1f);
        // Create nested profiling: FakeScorer -> innerProfileScorer -> outerProfileScorer
    }
/*
    @SuppressWarnings("unchecked")
        @Override
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * not use this file except in compliance with the License.
        // profiling wrappers using instanceof without reflection
        // Unwrap first layer
        FakeScorer fakeScorer = new FakeScorer(weight);
        profileScorer.setMinCompetitiveScore(0.42f);
        assertSame("ProfilingWrapper.getDelegate() should return the original scorer", fakeScorer, wrapper.getDelegate());
 * Licensed to Elasticsearch under one or more contributor
        FakeScorer fakeScorer = new FakeScorer(weight);
 *
    public void testGetChildren_delegatesToWrappedScorer() throws IOException {
        fakeScorer.maxScore = 42f;
        assertFalse("Original scorer should not implement ProfilingWrapper", secondUnwrap instanceof ProfilingWrapper);
        // getChildren() should delegate to the wrapped scorer's getChildren()
        ProfileScorer profileScorer = new ProfileScorer(fakeScorer, profile);
        public DocIdSetIterator iterator() {
        // Plugin only sees a Scorable reference
        Weight weight = query.createWeight(new IndexSearcher(new MultiReader()), ScoreMode.TOP_SCORES, 1f);
        @Override
        protected FakeScorer(Weight weight) {
        public void setMinCompetitiveScore(float minScore) {
        FakeScorer fakeScorer = new FakeScorer(weight);
        }
import org.apache.lucene.search.DocIdSetIterator;
    public void testGetDelegate() throws IOException {
        QueryProfileBreakdown profile = new QueryProfileBreakdown(ProfileMetricUtil.getDefaultQueryProfileMetrics());
        }
            super();
        QueryProfileBreakdown innerProfile = new QueryProfileBreakdown(ProfileMetricUtil.getDefaultQueryProfileMetrics());
 * compatible open source license.
        assertSame("Second unwrap should be the original FakeScorer", fakeScorer, secondUnwrap);
 * the Apache License, Version 2.0 (the "License"); you may
 */
            return 1f;
 * You may obtain a copy of the License at
 * under the License.
 *
            return maxScore;
    }
public class ProfileScorerTests extends OpenSearchTestCase {
        // Verify getDelegate returns the original scorer
        public int docID() {
