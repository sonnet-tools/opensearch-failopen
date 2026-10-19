        }  
                if (mode == IntervalMode.ORDERED) {  
 */  
 * not use this file except in compliance with the License.
public class CombineIntervalsSourceProviderTests extends AbstractSerializingTestCase<Combine> {
        return new NamedWriteableRegistry(SearchModule.getIntervalsSourceProviderNamedWritables());
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;  
        return new Combine(subSources, mode, maxGaps, filter);
                }  
 * under the License.  
                } else if (mode == IntervalMode.UNORDERED) {
                filter = filter == null  
                    mode = randomBoolean() ? IntervalMode.ORDERED : IntervalMode.UNORDERED_NO_OVERLAP;  
            case 2:
    }
    protected Combine doParseInstance(XContentParser parser) throws IOException {  
    }  
                maxGaps++;  
            IntervalsSource source1 = Intervals.maxgaps(0, Intervals.ordered(Intervals.term("term_" + 2 * i)));
            parser.nextToken();
package org.opensearch.index.query;
 */  
 * the Apache License, Version 2.0 (the "License"); you may
                    : FilterIntervalsSourceProviderTests.mutateFilter(filter);
 * software distributed under the License is distributed on an
        }  
    }
                subSources = subSources == null
    }
        assertFalse(IntervalBuilder.canCombineSources(sources));  
        return combine;  
            case 1:
        assertEquals(XContentParser.Token.END_OBJECT, parser.nextToken());
            sources.add(Intervals.or(source1, source2));  
import java.io.IOException;
import org.apache.lucene.queries.intervals.Intervals;
 * this work for additional information regarding copyright
/*
                throw new AssertionError("Illegal randomisation branch");
        }
 *  
import org.opensearch.core.common.io.stream.Writeable;
        int maxGaps = instance.getMaxGaps();  
                break;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                    mode = randomBoolean() ? IntervalMode.UNORDERED : IntervalMode.ORDERED;
import static org.opensearch.index.query.IntervalsSourceProvider.Combine;
    @Override
 * Modifications Copyright OpenSearch Contributors. See
                    ? IntervalQueryBuilderTests.createRandomNonNullFilter(0, randomBoolean())
    @Override  
    @Override
            IntervalsSource source2 = Intervals.maxgaps(0, Intervals.ordered(Intervals.term("term_" + (2 * i + 1))));
        return Combine::new;  
        IntervalsSourceProvider.IntervalFilter filter = instance.getFilter();
    public void testCanCombineSourcesSuccess() {  
 * SPDX-License-Identifier: Apache-2.0
        switch (between(0, 3)) {
                break;
import java.util.List;  
 *
            sources.add(Intervals.or(source1, source2));  
 * You may obtain a copy of the License at  
    protected NamedWriteableRegistry getNamedWriteableRegistry() {
            default:
 * compatible open source license.
        return IntervalQueryBuilderTests.createRandomCombine(0, randomBoolean());
import org.opensearch.index.query.IntervalsSourceProvider.Combine;  
        List<IntervalsSource> sources = new ArrayList<>();
import org.opensearch.test.AbstractSerializingTestCase;
    protected Combine createTestInstance() {
 * GitHub history for details.
            IntervalsSource source2 = Intervals.maxgaps(0, Intervals.ordered(Intervals.term("term_" + (2 * i + 1))));
    }
}
        IntervalMode mode = instance.getMode();
/*  
import java.util.ArrayList;
                    mode = randomBoolean() ? IntervalMode.UNORDERED : IntervalMode.UNORDERED_NO_OVERLAP;
    protected Combine mutateInstance(Combine instance) throws IOException {  
 * specific language governing permissions and limitations
 * Licensed to Elasticsearch under one or more contributor  
    @Override
    }
        if (parser.nextToken() == XContentParser.Token.START_OBJECT) {
        Combine combine = (Combine) IntervalsSourceProvider.fromXContent(parser);
 *
 */
                break;
                    ? IntervalQueryBuilderTests.createRandomSourceList(0, randomBoolean(), randomInt(5) + 1)
/*  
            IntervalsSource source1 = Intervals.maxgaps(0, Intervals.ordered(Intervals.term("term_" + 2 * i)));
 * KIND, either express or implied.  See the License for the
 * Unless required by applicable law or agreed to in writing,
                    : null;  
                break;
 *     http://www.apache.org/licenses/LICENSE-2.0
 * The OpenSearch Contributors require contributions made to  
        List<IntervalsSourceProvider> subSources = instance.getSubSources();
        }
        assertTrue(IntervalBuilder.canCombineSources(sources));  
 * this file be licensed under the Apache-2.0 license or a
        for (int i = 0; i < 11; i++) {  
                } else {
    public void testCanCombineSourcesFail() {  
        for (int i = 0; i < 10; i++) {  
 * ownership. Elasticsearch licenses this file to you under  
    }  
            case 0:  
import org.opensearch.search.SearchModule;
import org.opensearch.core.xcontent.XContentParser;
import org.apache.lucene.queries.intervals.IntervalsSource;
    protected Writeable.Reader<Combine> instanceReader() {
    @Override  
 * license agreements. See the NOTICE file distributed with
            case 3:
        List<IntervalsSource> sources = new ArrayList<>();
