 * the Apache License, Version 2.0 (the "License"); you may
import static org.hamcrest.Matchers.containsInAnyOrder;
        Mockito.when(fetchContext.highlight()).thenReturn(new SearchHighlightContext(Collections.emptyList()));
 *    http://www.apache.org/licenses/LICENSE-2.0
 * ownership. Elasticsearch licenses this file to you under
 * Unless required by applicable law or agreed to in writing,
            Collections.singletonList(new BytesArray("{}")),
        bq.add(percolateQuery2, BooleanClause.Occur.FILTER);
        assertThat(PercolatorHighlightSubFetchPhase.locatePercolatorQuery(bq.build()).size(), equalTo(1));
import org.opensearch.core.common.bytes.BytesArray;
        PercolateQuery percolateQuery2 = new PercolateQuery(
import org.apache.lucene.search.DisjunctionMaxQuery;
import java.util.Arrays;
        FunctionScoreQuery functionScoreQuery = new FunctionScoreQuery(new MatchAllDocsQuery(), new RandomScoreFunction(0, 0, null));
 */
        Mockito.when(fetchContext.query()).thenReturn(percolateQuery);
            Mockito.mock(IndexSearcher.class),
 * KIND, either express or implied.  See the License for the
            new MatchAllDocsQuery(),
        assertThat(PercolatorHighlightSubFetchPhase.locatePercolatorQuery(new MatchAllDocsQuery()).size(), equalTo(0));
            Collections.singletonList(new BytesArray("{}")),
import org.apache.lucene.search.BooleanQuery;
import java.util.Collections;
        assertThat(PercolatorHighlightSubFetchPhase.locatePercolatorQuery(boostQuery).size(), equalTo(0));
 * Modifications Copyright OpenSearch Contributors. See
        );
        assertThat(PercolatorHighlightSubFetchPhase.locatePercolatorQuery(constantScoreQuery).size(), equalTo(1));
package org.opensearch.percolator;
            "_name",
 * compatible open source license.
        assertThat(PercolatorHighlightSubFetchPhase.locatePercolatorQuery(constantScoreQuery).get(0), sameInstance(percolateQuery));
import org.opensearch.common.lucene.search.function.RandomScoreFunction;
        disjunctionMaxQuery = new DisjunctionMaxQuery(Arrays.asList(percolateQuery, new MatchAllDocsQuery()), 1f);
import static java.util.Collections.emptyMap;
 * The OpenSearch Contributors require contributions made to
import static org.hamcrest.Matchers.equalTo;
        FetchContext fetchContext = mock(FetchContext.class);
        assertNotNull(PercolatorHighlightSubFetchPhase.locatePercolatorQuery(null));
            ctx -> null,
import org.opensearch.search.fetch.subphase.highlight.SearchHighlightContext;
            Collections.singletonList(new BytesArray("{}")),
public class PercolatorHighlightSubFetchPhaseTests extends OpenSearchTestCase {
        PercolatorHighlightSubFetchPhase subFetchPhase = new PercolatorHighlightSubFetchPhase(emptyMap());
import org.opensearch.common.lucene.search.function.FunctionScoreQuery;
import org.apache.lucene.search.IndexSearcher;
        assertThat(
        assertNull(subFetchPhase.getProcessor(fetchContext));
        PercolateQuery percolateQuery = new PercolateQuery(
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
import org.mockito.Mockito;
        ConstantScoreQuery constantScoreQuery = new ConstantScoreQuery(new MatchAllDocsQuery());
            new MatchAllDocsQuery(),
            null,
    }
 * You may obtain a copy of the License at
        );
        assertThat(PercolatorHighlightSubFetchPhase.locatePercolatorQuery(null).size(), equalTo(0));
            containsInAnyOrder(sameInstance(percolateQuery), sameInstance(percolateQuery2))
            new MatchAllDocsQuery()
 * Licensed to Elasticsearch under one or more contributor
        functionScoreQuery = new FunctionScoreQuery(percolateQuery, new RandomScoreFunction(0, 0, null));
    public void testLocatePercolatorQuery() {
            null,
        PercolateQuery percolateQuery = new PercolateQuery(
        assertThat(PercolatorHighlightSubFetchPhase.locatePercolatorQuery(bq.build()).get(0), sameInstance(percolateQuery));
        bq = new BooleanQuery.Builder();
 *
        assertThat(PercolatorHighlightSubFetchPhase.locatePercolatorQuery(bq.build()).size(), equalTo(0));
import org.apache.lucene.search.ConstantScoreQuery;
import org.opensearch.search.fetch.FetchContext;
 */
            "_name",
 * license agreements. See the NOTICE file distributed with
import org.apache.lucene.search.MatchAllDocsQuery;
        assertThat(PercolatorHighlightSubFetchPhase.locatePercolatorQuery(boostQuery).size(), equalTo(1));
import org.opensearch.test.OpenSearchTestCase;
 * under the License.
/*
        Mockito.when(fetchContext.query()).thenReturn(new MatchAllDocsQuery());
    public void testHitsExecutionNeeded() {
            Mockito.mock(IndexSearcher.class),
            new MatchAllDocsQuery(),
 * GitHub history for details.
/*
        constantScoreQuery = new ConstantScoreQuery(percolateQuery);
 */
            new MatchAllDocsQuery()
        assertThat(PercolatorHighlightSubFetchPhase.locatePercolatorQuery(constantScoreQuery).size(), equalTo(0));
 *
        assertNotNull(subFetchPhase.getProcessor(fetchContext));
import static org.mockito.Mockito.mock;
        bq.add(new MatchAllDocsQuery(), BooleanClause.Occur.FILTER);
        assertThat(PercolatorHighlightSubFetchPhase.locatePercolatorQuery(functionScoreQuery).size(), equalTo(0));
        assertThat(PercolatorHighlightSubFetchPhase.locatePercolatorQuery(boostQuery).get(0), sameInstance(percolateQuery));
            Mockito.mock(IndexSearcher.class),
 * SPDX-License-Identifier: Apache-2.0
        );
    }
        assertThat(PercolatorHighlightSubFetchPhase.locatePercolatorQuery(disjunctionMaxQuery).get(0), sameInstance(percolateQuery));
        bq.add(percolateQuery, BooleanClause.Occur.FILTER);
}
        assertThat(PercolatorHighlightSubFetchPhase.locatePercolatorQuery(functionScoreQuery).size(), equalTo(1));
        assertThat(PercolatorHighlightSubFetchPhase.locatePercolatorQuery(functionScoreQuery).get(0), sameInstance(percolateQuery));
        bq.add(percolateQuery, BooleanClause.Occur.FILTER);
 * software distributed under the License is distributed on an
        );
 * this file be licensed under the Apache-2.0 license or a
 * this work for additional information regarding copyright
        assertThat(PercolatorHighlightSubFetchPhase.locatePercolatorQuery(disjunctionMaxQuery).size(), equalTo(0));
        assertThat(PercolatorHighlightSubFetchPhase.locatePercolatorQuery(disjunctionMaxQuery).size(), equalTo(1));
import static org.hamcrest.Matchers.sameInstance;
import org.apache.lucene.search.BoostQuery;
        assertThat(PercolatorHighlightSubFetchPhase.locatePercolatorQuery(bq.build()).size(), equalTo(0));
 *
        boostQuery = new BoostQuery(percolateQuery, 1f);
import org.apache.lucene.search.BooleanClause;
            PercolatorHighlightSubFetchPhase.locatePercolatorQuery(bq.build()),
        BoostQuery boostQuery = new BoostQuery(new MatchAllDocsQuery(), 1f);
 * specific language governing permissions and limitations
        assertThat(PercolatorHighlightSubFetchPhase.locatePercolatorQuery(bq.build()).size(), equalTo(2));
        bq.add(new MatchAllDocsQuery(), BooleanClause.Occur.FILTER);
            null,
/*
            "_name",
            new MatchAllDocsQuery()
 * not use this file except in compliance with the License.
        BooleanQuery.Builder bq = new BooleanQuery.Builder();
        DisjunctionMaxQuery disjunctionMaxQuery = new DisjunctionMaxQuery(Collections.singleton(new MatchAllDocsQuery()), 1f);
            ctx -> null,
            ctx -> null,
