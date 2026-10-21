        for (int i = 0; i < values.length; ++i) {
        final Object[][] values = new Boolean[randomInt(10)][];
            assertEquals(values[i].length > 0, scriptValues.advanceExact(i));
            }
            throw new UnsupportedOperationException();
import org.opensearch.search.aggregations.support.values.ScriptBytesValues;
                return values.length == 0 ? null : values[0];
        }
                    return leafSearchLookup;
import org.opensearch.search.aggregations.support.values.ScriptLongValues;
    public void testDoubles() throws IOException {
/*
 * GitHub history for details.
 * not use this file except in compliance with the License.
                for (int j = 0; j < values[i].length; ++j) {
                }
            // Script values are supposed to support null, single values, arrays and collections
                longs[j] = randomLong();
import org.opensearch.script.AggregationScript;
 * SPDX-License-Identifier: Apache-2.0
    }
        }
import java.util.Arrays;
                for (int j = 0; j < values[i].length; ++j) {
 *    http://www.apache.org/licenses/LICENSE-2.0
        final Object[][] values = new Double[randomInt(10)][];
 *
                }
 * Unless required by applicable law or agreed to in writing,
import static org.mockito.Mockito.mock;
                    LeafSearchLookup leafSearchLookup = mock(LeafSearchLookup.class);
 * this file be licensed under the Apache-2.0 license or a
            Long[] longs = new Long[randomInt(8)];
                booleans[j] = randomBoolean();
            if (values[i].length > 0) {
    public void testLongs() throws IOException {
        @Override
        ScriptLongValues scriptValues = new ScriptLongValues(script);
        FakeAggregationScript script = new FakeAggregationScript(values);
                for (int j = 0; j < values[i].length; ++j) {
            values[i] = strings;
                assertEquals(values[i].length, scriptValues.docValueCount());
    }
 * software distributed under the License is distributed on an
import com.carrotsearch.randomizedtesting.generators.RandomStrings;
        FakeAggregationScript(Object[][] values) {
import java.io.IOException;
            if (values[i].length > 0) {
        ScriptLongValues scriptValues = new ScriptLongValues(script);
import static org.mockito.Mockito.when;
                    assertEquals(values[i][j], scriptValues.nextValue() == 1L);
 *
                doubles[j] = randomDouble();
            }
        private final Object[][] values;
 * the Apache License, Version 2.0 (the "License"); you may
        }
        }
        for (int i = 0; i < values.length; ++i) {
                }
import org.opensearch.search.aggregations.support.values.ScriptDoubleValues;
            if (values[i].length > 0) {
                assertEquals(values[i].length, scriptValues.docValueCount());
    private static class FakeAggregationScript extends AggregationScript {
 *
        }
            this.values = values;
        }
                @Override
        for (int i = 0; i < values.length; ++i) {
        for (int i = 0; i < values.length; ++i) {
            for (int j = 0; j < booleans.length; ++j) {
        int index;
            }, null);
 * KIND, either express or implied.  See the License for the
            if (values.length <= 1 && randomBoolean()) {
            for (int j = 0; j < longs.length; ++j) {
package org.opensearch.search.aggregations.support;
 * Modifications Copyright OpenSearch Contributors. See
        }
 * The OpenSearch Contributors require contributions made to
        }
        FakeAggregationScript script = new FakeAggregationScript(values);
            if (values[i].length > 0) {
 * Licensed to Elasticsearch under one or more contributor
                }
 * ownership. Elasticsearch licenses this file to you under
        for (int i = 0; i < values.length; ++i) {
            Double[] doubles = new Double[randomInt(8)];
                for (int j = 0; j < values[i].length; ++j) {
                assertEquals(values[i].length, scriptValues.docValueCount());
            final Object[] values = this.values[index];
            return randomBoolean() ? values : Arrays.asList(values);
import org.opensearch.search.lookup.SearchLookup;
        @Override
            }
        @Override
            }
            String[] strings = new String[randomInt(8)];
    }
        public double runAsDouble() {
 */
        ScriptBytesValues scriptValues = new ScriptBytesValues(script);
            }
            assertEquals(values[i].length > 0, scriptValues.advanceExact(i));
            Arrays.sort(booleans);
 * license agreements. See the NOTICE file distributed with
            values[i] = doubles;
import org.apache.lucene.search.Scorable;
            assertEquals(values[i].length > 0, scriptValues.advanceExact(i));
/*
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        ScriptDoubleValues scriptValues = new ScriptDoubleValues(script);
 */
        }
import java.util.Collections;
 * this work for additional information regarding copyright
                    when(leafSearchLookup.asMap()).thenReturn(Collections.emptyMap());
                    assertEquals(values[i][j], scriptValues.nextValue());
                strings[j] = RandomStrings.randomAsciiOfLength(random(), 5);
        for (int i = 0; i < values.length; ++i) {
        FakeAggregationScript script = new FakeAggregationScript(values);
            }
    }
    public void testBytes() throws IOException {
            Arrays.sort(doubles);
            super(Collections.emptyMap(), new SearchLookup(null, null, SearchLookup.UNKNOWN_SHARD_ID) {
        }
            for (int j = 0; j < doubles.length; ++j) {
 * specific language governing permissions and limitations
 * compatible open source license.
        @Override
            index = doc;
}
public class ScriptValuesTests extends OpenSearchTestCase {
        public Object execute() {
        for (int i = 0; i < values.length; ++i) {
import org.opensearch.search.lookup.LeafSearchLookup;
        public long runAsLong() {
import org.opensearch.test.OpenSearchTestCase;
                assertEquals(values[i].length, scriptValues.docValueCount());
            }
        final String[][] values = new String[randomInt(10)][];
            assertEquals(values[i].length > 0, scriptValues.advanceExact(i));
/*
            values[i] = booleans;
    public void testBooleans() throws IOException {
        @Override
            }
            throw new UnsupportedOperationException();
            for (int j = 0; j < strings.length; ++j) {
        FakeAggregationScript script = new FakeAggregationScript(values);
            index = -1;
            Boolean[] booleans = new Boolean[randomInt(8)];
 * You may obtain a copy of the License at
        }
                public LeafSearchLookup getLeafSearchLookup(LeafReaderContext context) {
import org.apache.lucene.util.BytesRef;
            values[i] = longs;
                }
            Arrays.sort(longs);
    }
        public void setDocument(int doc) {
        public void setScorer(Scorable scorer) {}
        }
            }
                    assertEquals(values[i][j], scriptValues.nextValue());
                    assertEquals(new BytesRef(values[i][j]), scriptValues.nextValue());
import org.apache.lucene.index.LeafReaderContext;
        final Object[][] values = new Long[randomInt(10)][];
        for (int i = 0; i < values.length; ++i) {
            Arrays.sort(strings);
 */
        }
 * under the License.
