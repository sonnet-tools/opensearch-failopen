        assertThat(PercolatorHighlightSubFetchPhase.locatePercolatorQuery(bq.build()).size(), equalTo(2));
        bq.add(new MatchAllDocsQuery(), BooleanClause.Occur.FILTER);  
 * You may obtain a copy of the License at  
        assertThat(PercolatorHighlightSubFetchPhase.locatePercolatorQuery(functionScoreQuery).size(), equalTo(1));
        assertThat(PercolatorHighlightSubFetchPhase.locatePercolatorQuery(bq.build()).size(), equalTo(0));  
        assertNull(subFetchPhase.getProcessor(fetchContext));  
            "_name",  
import org.apache.lucene.search.BooleanQuery;
            new MatchAllDocsQuery(),
        assertNotNull(subFetchPhase.getProcessor(fetchContext));
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.apache.lucene.search.DisjunctionMaxQuery;
 * software distributed under the License is distributed on an
        assertThat(PercolatorHighlightSubFetchPhase.locatePercolatorQuery(bq.build()).get(0), sameInstance(percolateQuery));  
 * not use this file except in compliance with the License.
        Mockito.when(fetchContext.highlight()).thenReturn(new SearchHighlightContext(Collections.emptyList()));  
        boostQuery = new BoostQuery(percolateQuery, 1f);
            containsInAnyOrder(sameInstance(percolateQuery), sameInstance(percolateQuery2))
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.search.fetch.FetchContext;
        PercolateQuery percolateQuery2 = new PercolateQuery(
    public void testLocatePercolatorQuery() {
import org.opensearch.search.fetch.subphase.highlight.SearchHighlightContext;
 * KIND, either express or implied.  See the License for the
        bq.add(new MatchAllDocsQuery(), BooleanClause.Occur.FILTER);
import static org.hamcrest.Matchers.sameInstance;
 *
 * GitHub history for details.
            ctx -> null,
            null,  
 */
 */  
        assertThat(PercolatorHighlightSubFetchPhase.locatePercolatorQuery(bq.build()).size(), equalTo(0));
 *  
        PercolatorHighlightSubFetchPhase subFetchPhase = new PercolatorHighlightSubFetchPhase(emptyMap());
    }  
            new MatchAllDocsQuery(),  
        assertThat(PercolatorHighlightSubFetchPhase.locatePercolatorQuery(constantScoreQuery).size(), equalTo(0));  
package org.opensearch.percolator;
        constantScoreQuery = new ConstantScoreQuery(percolateQuery);
        );
/*
import org.apache.lucene.search.IndexSearcher;
        assertThat(PercolatorHighlightSubFetchPhase.locatePercolatorQuery(constantScoreQuery).size(), equalTo(1));
            "_name",
            "_name",
        Mockito.when(fetchContext.query()).thenReturn(percolateQuery);
 * compatible open source license.
 * SPDX-License-Identifier: Apache-2.0
/*  
import org.opensearch.test.OpenSearchTestCase;  
        disjunctionMaxQuery = new DisjunctionMaxQuery(Arrays.asList(percolateQuery, new MatchAllDocsQuery()), 1f);
        FetchContext fetchContext = mock(FetchContext.class);
public class PercolatorHighlightSubFetchPhaseTests extends OpenSearchTestCase {
            new MatchAllDocsQuery(),
 * Modifications Copyright OpenSearch Contributors. See  
        assertThat(PercolatorHighlightSubFetchPhase.locatePercolatorQuery(disjunctionMaxQuery).size(), equalTo(0));  
import org.opensearch.common.lucene.search.function.FunctionScoreQuery;
import org.mockito.Mockito;
import org.apache.lucene.search.ConstantScoreQuery;  
        );  
        functionScoreQuery = new FunctionScoreQuery(percolateQuery, new RandomScoreFunction(0, 0, null));
            PercolatorHighlightSubFetchPhase.locatePercolatorQuery(bq.build()),  
        );
            Mockito.mock(IndexSearcher.class),  
import static java.util.Collections.emptyMap;
            ctx -> null,
        assertThat(PercolatorHighlightSubFetchPhase.locatePercolatorQuery(disjunctionMaxQuery).get(0), sameInstance(percolateQuery));  
            null,
            Collections.singletonList(new BytesArray("{}")),  
        assertThat(PercolatorHighlightSubFetchPhase.locatePercolatorQuery(boostQuery).get(0), sameInstance(percolateQuery));  
        assertThat(PercolatorHighlightSubFetchPhase.locatePercolatorQuery(disjunctionMaxQuery).size(), equalTo(1));
    public void testHitsExecutionNeeded() {  
}
            new MatchAllDocsQuery()
        assertThat(PercolatorHighlightSubFetchPhase.locatePercolatorQuery(boostQuery).size(), equalTo(0));  
        PercolateQuery percolateQuery = new PercolateQuery(
import java.util.Collections;  
            ctx -> null,  
 * this work for additional information regarding copyright
        assertThat(PercolatorHighlightSubFetchPhase.locatePercolatorQuery(null).size(), equalTo(0));
            null,
 * Unless required by applicable law or agreed to in writing,
        bq.add(percolateQuery, BooleanClause.Occur.FILTER);
import static org.hamcrest.Matchers.equalTo;  
    }  
        assertThat(PercolatorHighlightSubFetchPhase.locatePercolatorQuery(boostQuery).size(), equalTo(1));
        assertNotNull(PercolatorHighlightSubFetchPhase.locatePercolatorQuery(null));
 * the Apache License, Version 2.0 (the "License"); you may
        bq = new BooleanQuery.Builder();
import org.apache.lucene.search.BoostQuery;
 * The OpenSearch Contributors require contributions made to  
import java.util.Arrays;
 * specific language governing permissions and limitations
 * this file be licensed under the Apache-2.0 license or a
        assertThat(PercolatorHighlightSubFetchPhase.locatePercolatorQuery(functionScoreQuery).get(0), sameInstance(percolateQuery));  
        DisjunctionMaxQuery disjunctionMaxQuery = new DisjunctionMaxQuery(Collections.singleton(new MatchAllDocsQuery()), 1f);
 *    http://www.apache.org/licenses/LICENSE-2.0
            Collections.singletonList(new BytesArray("{}")),
        Mockito.when(fetchContext.query()).thenReturn(new MatchAllDocsQuery());
            new MatchAllDocsQuery()
 *
        BoostQuery boostQuery = new BoostQuery(new MatchAllDocsQuery(), 1f);
            Collections.singletonList(new BytesArray("{}")),
 */
 * under the License.  
 * license agreements. See the NOTICE file distributed with
        assertThat(PercolatorHighlightSubFetchPhase.locatePercolatorQuery(bq.build()).size(), equalTo(1));
        PercolateQuery percolateQuery = new PercolateQuery(  
            Mockito.mock(IndexSearcher.class),
 * Licensed to Elasticsearch under one or more contributor  
        assertThat(PercolatorHighlightSubFetchPhase.locatePercolatorQuery(functionScoreQuery).size(), equalTo(0));  
        bq.add(percolateQuery2, BooleanClause.Occur.FILTER);  
        assertThat(PercolatorHighlightSubFetchPhase.locatePercolatorQuery(constantScoreQuery).get(0), sameInstance(percolateQuery));  
        );
        bq.add(percolateQuery, BooleanClause.Occur.FILTER);
        assertThat(
            new MatchAllDocsQuery()  
            Mockito.mock(IndexSearcher.class),
import org.apache.lucene.search.MatchAllDocsQuery;  
import org.opensearch.core.common.bytes.BytesArray;  
        BooleanQuery.Builder bq = new BooleanQuery.Builder();
        FunctionScoreQuery functionScoreQuery = new FunctionScoreQuery(new MatchAllDocsQuery(), new RandomScoreFunction(0, 0, null));
        assertThat(PercolatorHighlightSubFetchPhase.locatePercolatorQuery(new MatchAllDocsQuery()).size(), equalTo(0));  
        ConstantScoreQuery constantScoreQuery = new ConstantScoreQuery(new MatchAllDocsQuery());
import static org.mockito.Mockito.mock;
import org.apache.lucene.search.BooleanClause;  
/*
import static org.hamcrest.Matchers.containsInAnyOrder;
import org.opensearch.common.lucene.search.function.RandomScoreFunction;
