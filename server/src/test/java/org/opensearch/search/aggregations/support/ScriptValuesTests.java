            }
            Arrays.sort(strings);
 * ownership. Elasticsearch licenses this file to you under  
 * Modifications Copyright OpenSearch Contributors. See
    public void testBooleans() throws IOException {
    }
                booleans[j] = randomBoolean();
 * specific language governing permissions and limitations
            if (values[i].length > 0) {
                    assertEquals(new BytesRef(values[i][j]), scriptValues.nextValue());
                doubles[j] = randomDouble();  
        }
            }
    }  
                }  
                for (int j = 0; j < values[i].length; ++j) {
                @Override
import org.opensearch.search.lookup.SearchLookup;
                return values.length == 0 ? null : values[0];
            if (values[i].length > 0) {
                    return leafSearchLookup;
        for (int i = 0; i < values.length; ++i) {  
                assertEquals(values[i].length, scriptValues.docValueCount());  
        public long runAsLong() {
            assertEquals(values[i].length > 0, scriptValues.advanceExact(i));
                assertEquals(values[i].length, scriptValues.docValueCount());
 * GitHub history for details.
                }
import java.io.IOException;
import org.opensearch.search.aggregations.support.values.ScriptDoubleValues;
 * Licensed to Elasticsearch under one or more contributor  
        for (int i = 0; i < values.length; ++i) {  
            throw new UnsupportedOperationException();
 * not use this file except in compliance with the License.
            for (int j = 0; j < doubles.length; ++j) {
 * this work for additional information regarding copyright
                for (int j = 0; j < values[i].length; ++j) {
            Long[] longs = new Long[randomInt(8)];  
public class ScriptValuesTests extends OpenSearchTestCase {  
            Double[] doubles = new Double[randomInt(8)];
        @Override  
import static org.mockito.Mockito.when;
            super(Collections.emptyMap(), new SearchLookup(null, null, SearchLookup.UNKNOWN_SHARD_ID) {
                    assertEquals(values[i][j], scriptValues.nextValue());  
            values[i] = doubles;  
            }
        }
        }  
            Arrays.sort(booleans);  
 * KIND, either express or implied.  See the License for the
            for (int j = 0; j < longs.length; ++j) {
 * the Apache License, Version 2.0 (the "License"); you may
            }  
 * software distributed under the License is distributed on an
 * under the License.  
 * The OpenSearch Contributors require contributions made to  
        }
            this.values = values;
            for (int j = 0; j < booleans.length; ++j) {  
                assertEquals(values[i].length, scriptValues.docValueCount());
import org.opensearch.search.aggregations.support.values.ScriptLongValues;  
        final Object[][] values = new Boolean[randomInt(10)][];  
        @Override
        for (int i = 0; i < values.length; ++i) {
        for (int i = 0; i < values.length; ++i) {
        for (int i = 0; i < values.length; ++i) {  
 * You may obtain a copy of the License at  
            Boolean[] booleans = new Boolean[randomInt(8)];
        }
                }
            }  
    }  
import com.carrotsearch.randomizedtesting.generators.RandomStrings;
            }, null);
        final Object[][] values = new Long[randomInt(10)][];
            return randomBoolean() ? values : Arrays.asList(values);
        ScriptBytesValues scriptValues = new ScriptBytesValues(script);
 * license agreements. See the NOTICE file distributed with
            final Object[] values = this.values[index];  
 */  
            if (values[i].length > 0) {
        }
        }
                longs[j] = randomLong();
        }  
        }  
            values[i] = strings;
                }  
 * this file be licensed under the Apache-2.0 license or a
        FakeAggregationScript script = new FakeAggregationScript(values);
        public Object execute() {
        ScriptLongValues scriptValues = new ScriptLongValues(script);
        public void setDocument(int doc) {
 *
                for (int j = 0; j < values[i].length; ++j) {
        public double runAsDouble() {  
        final String[][] values = new String[randomInt(10)][];
 */
/*  
import static org.mockito.Mockito.mock;  
        }  
        for (int i = 0; i < values.length; ++i) {
                    when(leafSearchLookup.asMap()).thenReturn(Collections.emptyMap());
 * Unless required by applicable law or agreed to in writing,
 *  
    }
            if (values[i].length > 0) {  
}
        }
/*
    public void testLongs() throws IOException {  
        ScriptDoubleValues scriptValues = new ScriptDoubleValues(script);  
                    LeafSearchLookup leafSearchLookup = mock(LeafSearchLookup.class);  
        ScriptLongValues scriptValues = new ScriptLongValues(script);
        for (int i = 0; i < values.length; ++i) {
/*  
    }
                for (int j = 0; j < values[i].length; ++j) {  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        FakeAggregationScript script = new FakeAggregationScript(values);  
        for (int i = 0; i < values.length; ++i) {
 *    http://www.apache.org/licenses/LICENSE-2.0
package org.opensearch.search.aggregations.support;
            }  
            index = doc;  
import org.apache.lucene.index.LeafReaderContext;  
            assertEquals(values[i].length > 0, scriptValues.advanceExact(i));
            for (int j = 0; j < strings.length; ++j) {
        @Override  
        public void setScorer(Scorable scorer) {}
import java.util.Arrays;  
import java.util.Collections;
        final Object[][] values = new Double[randomInt(10)][];
            }
    public void testBytes() throws IOException {  
            if (values.length <= 1 && randomBoolean()) {
import org.apache.lucene.util.BytesRef;
        FakeAggregationScript script = new FakeAggregationScript(values);
    public void testDoubles() throws IOException {
            values[i] = booleans;
        int index;
            assertEquals(values[i].length > 0, scriptValues.advanceExact(i));  
import org.opensearch.test.OpenSearchTestCase;  
 */  
            throw new UnsupportedOperationException();
                strings[j] = RandomStrings.randomAsciiOfLength(random(), 5);
            Arrays.sort(longs);
    private static class FakeAggregationScript extends AggregationScript {
        }
import org.opensearch.search.aggregations.support.values.ScriptBytesValues;
        }
 *
        @Override
                    assertEquals(values[i][j], scriptValues.nextValue());
            assertEquals(values[i].length > 0, scriptValues.advanceExact(i));
        FakeAggregationScript(Object[][] values) {
        private final Object[][] values;
import org.opensearch.search.lookup.LeafSearchLookup;
 * compatible open source license.
                public LeafSearchLookup getLeafSearchLookup(LeafReaderContext context) {
        @Override
                    assertEquals(values[i][j], scriptValues.nextValue() == 1L);
import org.opensearch.script.AggregationScript;  
            values[i] = longs;
            Arrays.sort(doubles);
                assertEquals(values[i].length, scriptValues.docValueCount());  
            }  
        FakeAggregationScript script = new FakeAggregationScript(values);
 * SPDX-License-Identifier: Apache-2.0
import org.apache.lucene.search.Scorable;
            // Script values are supposed to support null, single values, arrays and collections
                }  
            index = -1;  
            }
            String[] strings = new String[randomInt(8)];  
