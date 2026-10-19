 * Unless required by applicable law or agreed to in writing,
import org.opensearch.core.xcontent.XContentParser;  
    @Override
                break;
import org.opensearch.core.common.io.stream.Writeable;
 */  
 * The OpenSearch Contributors require contributions made to  
                query = randomAlphaOfLength(query.length() + 3);
            default:
 * license agreements. See the NOTICE file distributed with
                break;
                break;
                filter = filter == null
/*
import static org.opensearch.index.query.IntervalsSourceProvider.Match;  
                useField = useField == null ? randomAlphaOfLength(5) : (useField + "foo");  
        String analyzer = instance.getAnalyzer();
                    : FilterIntervalsSourceProviderTests.mutateFilter(filter);  
                    mode = randomBoolean() ? IntervalMode.UNORDERED : IntervalMode.ORDERED;  
import org.opensearch.search.SearchModule;
 */  
    }
            case 0:  
 * KIND, either express or implied.  See the License for the
            parser.nextToken();  
/*  
    @Override  
 * software distributed under the License is distributed on an
 * under the License.  
    @Override
                analyzer = analyzer == null ? randomAlphaOfLength(5) : null;
                throw new AssertionError("Illegal randomisation branch");  
        String query = instance.getQuery();
        return IntervalQueryBuilderTests.createRandomMatch(0, randomBoolean());  
 * GitHub history for details.
/*  
                    mode = randomBoolean() ? IntervalMode.UNORDERED : IntervalMode.UNORDERED_NO_OVERLAP;
    protected Match doParseInstance(XContentParser parser) throws IOException {
 * specific language governing permissions and limitations
                } else {
        switch (between(0, 5)) {
 * this work for additional information regarding copyright
                maxGaps++;
            case 2:  
    protected Match mutateInstance(Match instance) throws IOException {
        }
                    mode = randomBoolean() ? IntervalMode.ORDERED : IntervalMode.UNORDERED_NO_OVERLAP;
        IntervalMode mode = instance.getMode();
 */
 *     http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
    }
 * this file be licensed under the Apache-2.0 license or a
 * ownership. Elasticsearch licenses this file to you under  
 * You may obtain a copy of the License at  
                break;
    @Override
 *
 * SPDX-License-Identifier: Apache-2.0
        return new NamedWriteableRegistry(SearchModule.getIntervalsSourceProviderNamedWritables());  
            case 4:  
 * not use this file except in compliance with the License.
                }
    @Override  
                    ? IntervalQueryBuilderTests.createRandomNonNullFilter(0, randomBoolean())
        if (parser.nextToken() == XContentParser.Token.START_OBJECT) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        int maxGaps = instance.getMaxGaps();  
                break;
                if (mode == IntervalMode.ORDERED) {
 * the Apache License, Version 2.0 (the "License"); you may
import java.io.IOException;
    }
 *  
    }
 * compatible open source license.
        IntervalsSourceProvider.IntervalFilter filter = instance.getFilter();  
        String useField = instance.getUseField();
            case 1:  
        Match Match = (Match) IntervalsSourceProvider.fromXContent(parser);
    }  
            case 3:  
        return Match;
    protected NamedWriteableRegistry getNamedWriteableRegistry() {
package org.opensearch.index.query;
    protected Match createTestInstance() {
                } else if (mode == IntervalMode.UNORDERED) {  
                break;
        return new Match(query, maxGaps, mode, analyzer, filter, useField);
        }
import org.opensearch.test.AbstractSerializingTestCase;
        return Match::new;
 * Licensed to Elasticsearch under one or more contributor  
 * Modifications Copyright OpenSearch Contributors. See
 *
        assertEquals(XContentParser.Token.END_OBJECT, parser.nextToken());  
}  
public class MatchIntervalsSourceProviderTests extends AbstractSerializingTestCase<Match> {
    protected Writeable.Reader<Match> instanceReader() {  
            case 5:
