    }  
/*
 *
        return Disjunction::new;
/*  
        return IntervalQueryBuilderTests.createRandomDisjunction(0, randomBoolean());
 */
    @Override
 * GitHub history for details.
        }
 *
 * not use this file except in compliance with the License.
import static org.opensearch.index.query.IntervalsSourceProvider.Disjunction;
    @Override  
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.search.SearchModule;
        IntervalsSourceProvider.IntervalFilter filter = instance.getFilter();
    protected Disjunction createTestInstance() {  
        return new NamedWriteableRegistry(SearchModule.getIntervalsSourceProviderNamedWritables());
import org.opensearch.core.common.io.stream.Writeable;
        return disjunction;
    @Override
public class DisjunctionIntervalsSourceProviderTests extends AbstractSerializingTestCase<Disjunction> {  
    @Override
        assertEquals(XContentParser.Token.END_OBJECT, parser.nextToken());
    }
 * under the License.  
 */  
 * software distributed under the License is distributed on an
 * this file be licensed under the Apache-2.0 license or a
    }
    }
/*  
 * compatible open source license.
 * specific language governing permissions and limitations
    protected Disjunction doParseInstance(XContentParser parser) throws IOException {
        if (randomBoolean()) {
 * license agreements. See the NOTICE file distributed with
 * You may obtain a copy of the License at  
    protected Disjunction mutateInstance(Disjunction instance) throws IOException {
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.test.AbstractSerializingTestCase;
            filter = filter == null
 * SPDX-License-Identifier: Apache-2.0
 */  
 * Unless required by applicable law or agreed to in writing,
 * Licensed to Elasticsearch under one or more contributor  
 * Modifications Copyright OpenSearch Contributors. See
        }
    protected NamedWriteableRegistry getNamedWriteableRegistry() {  
 *  
    protected Writeable.Reader<Disjunction> instanceReader() {
 * ownership. Elasticsearch licenses this file to you under  
            subSources = subSources == null ? IntervalQueryBuilderTests.createRandomSourceList(0, randomBoolean(), randomInt(5) + 1) : null;  
                ? IntervalQueryBuilderTests.createRandomNonNullFilter(0, randomBoolean())  
package org.opensearch.index.query;
 *     http://www.apache.org/licenses/LICENSE-2.0
 * KIND, either express or implied.  See the License for the
    @Override
        return new Disjunction(subSources, filter);  
import org.opensearch.core.xcontent.XContentParser;  
}
 * this work for additional information regarding copyright
        } else {
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
        List<IntervalsSourceProvider> subSources = instance.getSubSources();  
import java.io.IOException;
import java.util.List;
    }  
        Disjunction disjunction = (Disjunction) IntervalsSourceProvider.fromXContent(parser);  
            parser.nextToken();
        if (parser.nextToken() == XContentParser.Token.START_OBJECT) {  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                : FilterIntervalsSourceProviderTests.mutateFilter(filter);
