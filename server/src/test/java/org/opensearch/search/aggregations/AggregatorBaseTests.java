                );
        }  
            null,
                    null,
        protected LeafBucketCollector getLeafCollector(LeafReaderContext ctx, LeafBucketCollector sub) throws IOException {
                    null,
        MappedFieldType ft = new DateFieldMapper.DateFieldType(
                    )
                    mockSearchContext(new MatchAllDocsQuery()),  
 * The OpenSearch Contributors require contributions made to  
                    )
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.search.aggregations.support.ValuesSourceConfig;
    ) {
import org.opensearch.index.query.QueryShardContext;
    }
                        mockSearchContext(new MatchAllDocsQuery()),  
        return aggregator.pointReaderIfAvailable(config);
 * this work for additional information regarding copyright
import org.apache.lucene.index.LeafReaderContext;
 * the Apache License, Version 2.0 (the "License"); you may
        QueryShardContext context
import java.util.function.Function;  
import org.apache.lucene.search.MatchAllDocsQuery;
package org.opensearch.search.aggregations;
                        mockAggregator(),
 */  
        }
                    getVSConfig("number", DateFieldMapper.Resolution.NANOSECONDS, true, context)
                assertNull(pointReaderShim(mockSearchContext(null), mockAggregator(), getVSConfig("number", type, true, context)));  
    private ValuesSourceConfig getVSConfig(
                        getVSConfig("number", resolution, true, context)
                        getVSConfig("number", type, true, context)  
        boolean indexed,
                assertNotNull(  
    private ValuesSourceConfig getVSConfig(
        BogusAggregator aggregator = new BogusAggregator(context, parent);  
            for (NumberFieldMapper.NumberType type : NumberFieldMapper.NumberType.values()) {
/*  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.core.common.breaker.CircuitBreaker;  
                    getVSConfig("number", DateFieldMapper.Resolution.MILLISECONDS, true, context)
        @Override  
    }  
 * Licensed to Elasticsearch under one or more contributor  
                        mockSearchContext(new TermQuery(new Term("foo", "bar"))),
            }
 */
import org.apache.lucene.search.TermQuery;  
 * Modifications Copyright OpenSearch Contributors. See
        NumberFieldMapper.NumberType numType,
            true,
        @Override
import org.apache.lucene.search.Query;
        when(searchContext.query()).thenReturn(query);
        public InternalAggregation[] buildAggregations(long[] owningBucketOrds) throws IOException {
import static org.mockito.Mockito.when;
            false,  
            QueryShardContext context = indexService.newQueryShardContext(0, searcher, () -> 42L, null);  
            false,  
            byte[] scratch = new byte[8];
import static org.mockito.Mockito.mock;  
    }
    }  
            indexed,  
        public InternalAggregation buildEmptyAggregation() {  
                assertNull(pointReaderShim(mockSearchContext(null), mockAggregator(), getVSConfig("number", type, true, context)));
                );
    public void testShortcutIsApplicable() throws IOException {
}
        QueryShardContext context  
        boolean indexed,
    }  
/*  
                    pointReaderShim(mockSearchContext(new MatchAllDocsQuery()), null, getVSConfig("number", type, true, context))
import org.opensearch.common.settings.Settings;
            DateFieldMapper.getDefaultDateTimeFormatter(),  
                ).apply(scratch),  
                assertNotNull(pointReaderShim(mockSearchContext(null), null, getVSConfig("number", type, true, context)));  
            null,
        BigArrays mockBigArrays = mock(BigArrays.class);
import org.opensearch.index.mapper.MappedFieldType;
                equalTo(expected.toEpochMilli())
import org.apache.lucene.document.LongPoint;
            Collections.emptyMap()
            fieldName,
    class BogusAggregator extends AggregatorBase {
import org.opensearch.index.IndexService;
                        null,
        return ValuesSourceConfig.resolveFieldOnly(ft, context);
                    )  
        );
        SearchContext searchContext = mock(SearchContext.class);  
                );
 *
 * software distributed under the License is distributed on an
    }
 *     http://www.apache.org/licenses/LICENSE-2.0
                assertNull(pointReaderShim(mockSearchContext(null), null, getVSConfig("number", type, false, context)));
                assertNull(
                    pointReaderShim(  
 * specific language governing permissions and limitations
import org.apache.lucene.index.Term;  
 *
            throw new UnsupportedOperationException();  
        when(searchContext.bigArrays()).thenReturn(mockBigArrays);  
        try (Engine.Searcher searcher = indexService.getShard(0).acquireSearcher("test")) {
        return ValuesSourceConfig.resolveFieldOnly(ft, context);
import org.opensearch.index.engine.Engine;  
/*
        CircuitBreakerService mockCBS = mock(CircuitBreakerService.class);  
            );
        String fieldName,
                pointReaderShim(
    }
                assertNull(
import org.opensearch.search.internal.SearchContext;  
            false,
                equalTo(expected.toEpochMilli())
        }  
            throw new UnsupportedOperationException();
            throw new UnsupportedOperationException();
                        null,
        }
            Instant expected = Instant.from(DateFieldMapper.getDefaultDateTimeFormatter().parse("2020-01-01T00:00:00Z"));
            true,
public class AggregatorBaseTests extends OpenSearchSingleNodeTestCase {  
 * KIND, either express or implied.  See the License for the
            indexed,
        when(mockCBS.getBreaker(CircuitBreaker.REQUEST)).thenReturn(mock(CircuitBreaker.class));
        );  
                assertNull(pointReaderShim(mockSearchContext(null), mockAggregator(), getVSConfig("number", resolution, true, context)));  
import org.opensearch.test.OpenSearchSingleNodeTestCase;
        return mock(Aggregator.class);
import java.time.Instant;
        DateFieldMapper.Resolution resolution,  
                );
            );
                assertNull(pointReaderShim(mockSearchContext(null), null, getVSConfig("number", resolution, false, context)));
                        getVSConfig("number", resolution, true, context)  
    private Aggregator mockAggregator() {
        IndexService indexService = createIndexWithSimpleMappings("index", Settings.EMPTY, "bytes", "type=keyword");  
import org.opensearch.index.mapper.DateFieldMapper;
                pointReaderShim(
                assertNull(
 * ownership. Elasticsearch licenses this file to you under  
        @Override
import org.opensearch.index.mapper.NumberFieldMapper;  
import static org.hamcrest.Matchers.equalTo;
        throws IOException {
 * GitHub history for details.
            LongPoint.encodeDimension(DateFieldMapper.Resolution.NANOSECONDS.convert(expected), scratch, 0);  
            // Check that we decode a dates "just like" the doc values instance.  
        }
            assertThat(
            Collections.emptyMap()  
            assertThat(
                        mockSearchContext(new TermQuery(new Term("foo", "bar"))),
    ) {  
                ).apply(scratch),  
            resolution,
 * not use this file except in compliance with the License.
        return searchContext;
 * compatible open source license.
        BogusAggregator(SearchContext searchContext, Aggregator parent) throws IOException {  
            fieldName,  
            numType,
import java.util.Collections;
import java.io.IOException;  
        String fieldName,  
        when(mockBigArrays.breakerService()).thenReturn(mockCBS);
 * SPDX-License-Identifier: Apache-2.0
                    pointReaderShim(  
 *  
 * license agreements. See the NOTICE file distributed with
 * under the License.  
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.common.util.BigArrays;
 */  
        MappedFieldType ft = new NumberFieldMapper.NumberFieldType(
            for (DateFieldMapper.Resolution resolution : DateFieldMapper.Resolution.values()) {  
            }
                    mockSearchContext(new MatchAllDocsQuery()),  
    private SearchContext mockSearchContext(Query query) {
    private Function<byte[], Number> pointReaderShim(SearchContext context, Aggregator parent, ValuesSourceConfig config)
            LongPoint.encodeDimension(DateFieldMapper.Resolution.MILLISECONDS.convert(expected), scratch, 0);  
 * You may obtain a copy of the License at  
import org.opensearch.core.indices.breaker.CircuitBreakerService;
            super("bogus", AggregatorFactories.EMPTY, searchContext, parent, CardinalityUpperBound.NONE, Collections.emptyMap());
            true,
                    pointReaderShim(
