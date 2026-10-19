                    pointReaderShim(
        return mock(Aggregator.class);
import org.opensearch.core.common.breaker.CircuitBreaker;
            resolution,
                );
                    )
        return searchContext;
                        getVSConfig("number", resolution, true, context)
                    )
                assertNull(pointReaderShim(mockSearchContext(null), null, getVSConfig("number", type, false, context)));
        when(searchContext.query()).thenReturn(query);
        }
import org.apache.lucene.index.LeafReaderContext;
        CircuitBreakerService mockCBS = mock(CircuitBreakerService.class);
import org.opensearch.search.aggregations.support.ValuesSourceConfig;
import org.apache.lucene.search.MatchAllDocsQuery;
 * this file be licensed under the Apache-2.0 license or a
        when(searchContext.bigArrays()).thenReturn(mockBigArrays);
import java.io.IOException;
            throw new UnsupportedOperationException();
                    pointReaderShim(mockSearchContext(new MatchAllDocsQuery()), null, getVSConfig("number", type, true, context))
                        mockSearchContext(new TermQuery(new Term("foo", "bar"))),
                        null,
        throws IOException {
 * The OpenSearch Contributors require contributions made to
        return ValuesSourceConfig.resolveFieldOnly(ft, context);
    public void testShortcutIsApplicable() throws IOException {
 */
            fieldName,
import static org.mockito.Mockito.mock;
        );
 * You may obtain a copy of the License at
import org.apache.lucene.search.Query;
        MappedFieldType ft = new NumberFieldMapper.NumberFieldType(
            true,
/*
    private ValuesSourceConfig getVSConfig(
            false,
            throw new UnsupportedOperationException();
    }
import org.opensearch.common.util.BigArrays;
            for (NumberFieldMapper.NumberType type : NumberFieldMapper.NumberType.values()) {
import org.opensearch.test.OpenSearchSingleNodeTestCase;
                    null,
    private Aggregator mockAggregator() {
        QueryShardContext context
 * SPDX-License-Identifier: Apache-2.0
 * Unless required by applicable law or agreed to in writing,
public class AggregatorBaseTests extends OpenSearchSingleNodeTestCase {
                assertNull(pointReaderShim(mockSearchContext(null), mockAggregator(), getVSConfig("number", type, true, context)));
        public InternalAggregation buildEmptyAggregation() {
            );
            }
 * under the License.
        boolean indexed,
 * not use this file except in compliance with the License.
                );
                        null,
    class BogusAggregator extends AggregatorBase {
 * license agreements. See the NOTICE file distributed with
import org.opensearch.index.mapper.MappedFieldType;
            for (DateFieldMapper.Resolution resolution : DateFieldMapper.Resolution.values()) {
                    getVSConfig("number", DateFieldMapper.Resolution.MILLISECONDS, true, context)
                pointReaderShim(
 */
                    )
        SearchContext searchContext = mock(SearchContext.class);
            fieldName,
        boolean indexed,
                assertNull(pointReaderShim(mockSearchContext(null), mockAggregator(), getVSConfig("number", type, true, context)));
import static org.mockito.Mockito.when;
    ) {
import java.util.Collections;
                assertNull(
 * specific language governing permissions and limitations
                    getVSConfig("number", DateFieldMapper.Resolution.NANOSECONDS, true, context)
                    pointReaderShim(
 * Modifications Copyright OpenSearch Contributors. See
 *     http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.index.engine.Engine;
 *
                equalTo(expected.toEpochMilli())
        try (Engine.Searcher searcher = indexService.getShard(0).acquireSearcher("test")) {
        @Override
                assertNull(pointReaderShim(mockSearchContext(null), mockAggregator(), getVSConfig("number", resolution, true, context)));
            numType,
 * software distributed under the License is distributed on an
}
        when(mockCBS.getBreaker(CircuitBreaker.REQUEST)).thenReturn(mock(CircuitBreaker.class));
                        getVSConfig("number", type, true, context)
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            super("bogus", AggregatorFactories.EMPTY, searchContext, parent, CardinalityUpperBound.NONE, Collections.emptyMap());
 *
    }
            Instant expected = Instant.from(DateFieldMapper.getDefaultDateTimeFormatter().parse("2020-01-01T00:00:00Z"));
                        mockSearchContext(new MatchAllDocsQuery()),
 * GitHub history for details.
            assertThat(
        }
 * the Apache License, Version 2.0 (the "License"); you may
        }
/*
import org.opensearch.index.IndexService;
package org.opensearch.search.aggregations;
            );
            false,
        String fieldName,
                        mockSearchContext(new TermQuery(new Term("foo", "bar"))),
                assertNull(pointReaderShim(mockSearchContext(null), null, getVSConfig("number", resolution, false, context)));
import static org.hamcrest.Matchers.equalTo;
import org.opensearch.index.mapper.DateFieldMapper;
                assertNotNull(pointReaderShim(mockSearchContext(null), null, getVSConfig("number", type, true, context)));
    }
        }
            throw new UnsupportedOperationException();
        String fieldName,
            LongPoint.encodeDimension(DateFieldMapper.Resolution.NANOSECONDS.convert(expected), scratch, 0);
        }
        BogusAggregator aggregator = new BogusAggregator(context, parent);
                    null,
        IndexService indexService = createIndexWithSimpleMappings("index", Settings.EMPTY, "bytes", "type=keyword");
        DateFieldMapper.Resolution resolution,
                ).apply(scratch),
            Collections.emptyMap()
        public InternalAggregation[] buildAggregations(long[] owningBucketOrds) throws IOException {
                );
    ) {
                assertNull(
            }
import org.opensearch.common.settings.Settings;
import org.opensearch.index.mapper.NumberFieldMapper;
    }
 * compatible open source license.
 */
            indexed,
                    mockSearchContext(new MatchAllDocsQuery()),
        return ValuesSourceConfig.resolveFieldOnly(ft, context);
                        getVSConfig("number", resolution, true, context)
            true,
import org.apache.lucene.search.TermQuery;
import org.apache.lucene.index.Term;
import org.opensearch.search.internal.SearchContext;
        @Override
        MappedFieldType ft = new DateFieldMapper.DateFieldType(
            null,
 * ownership. Elasticsearch licenses this file to you under
        BogusAggregator(SearchContext searchContext, Aggregator parent) throws IOException {
        protected LeafBucketCollector getLeafCollector(LeafReaderContext ctx, LeafBucketCollector sub) throws IOException {
            assertThat(
            true,
import java.time.Instant;
            QueryShardContext context = indexService.newQueryShardContext(0, searcher, () -> 42L, null);
import org.apache.lucene.document.LongPoint;
 * KIND, either express or implied.  See the License for the
        return aggregator.pointReaderIfAvailable(config);
            LongPoint.encodeDimension(DateFieldMapper.Resolution.MILLISECONDS.convert(expected), scratch, 0);
                equalTo(expected.toEpochMilli())
 * Licensed to Elasticsearch under one or more contributor
                    mockSearchContext(new MatchAllDocsQuery()),
import java.util.function.Function;
        QueryShardContext context
            null,
    }
import org.opensearch.index.query.QueryShardContext;
        BigArrays mockBigArrays = mock(BigArrays.class);
 * this work for additional information regarding copyright
            DateFieldMapper.getDefaultDateTimeFormatter(),
/*
            false,
        );
 *
    }
    private SearchContext mockSearchContext(Query query) {
                );
        NumberFieldMapper.NumberType numType,
                ).apply(scratch),
                assertNotNull(
        when(mockBigArrays.breakerService()).thenReturn(mockCBS);
    }
            // Check that we decode a dates "just like" the doc values instance.
    private Function<byte[], Number> pointReaderShim(SearchContext context, Aggregator parent, ValuesSourceConfig config)
import org.opensearch.core.indices.breaker.CircuitBreakerService;
    private ValuesSourceConfig getVSConfig(
            Collections.emptyMap()
                assertNull(
            indexed,
            byte[] scratch = new byte[8];
                        mockAggregator(),
                pointReaderShim(
        @Override
                    pointReaderShim(
