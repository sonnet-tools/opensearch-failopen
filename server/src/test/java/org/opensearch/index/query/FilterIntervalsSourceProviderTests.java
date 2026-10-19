    static IntervalFilter mutateFilter(IntervalFilter instance) {
import org.opensearch.script.ScriptType;
        return IntervalFilter::new;
}  
            } else {
/*  
    protected IntervalFilter createTestInstance() {
    @Override  
        } else {
 *
import org.opensearch.core.common.io.stream.Writeable;
 * Unless required by applicable law or agreed to in writing,
 * license agreements. See the NOTICE file distributed with
package org.opensearch.index.query;
 * KIND, either express or implied.  See the License for the
 * ownership. Elasticsearch licenses this file to you under  
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.script.Script;
 * the Apache License, Version 2.0 (the "License"); you may
 */
 * SPDX-License-Identifier: Apache-2.0
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                if (type.equals("containing")) {  
    protected Writeable.Reader<IntervalFilter> instanceReader() {
                    type = "overlapping";
                    filter = WildcardIntervalsSourceProviderTests.createRandomWildcard();
        return mutateFilter(instance);
        return IntervalFilter.fromXContent(parser);
        IntervalsSourceProvider filter = instance.getFilter();  
    @Override  
            return new IntervalFilter(filter, type);  
            if (randomBoolean()) {
 * under the License.  
 * The OpenSearch Contributors require contributions made to  
 * not use this file except in compliance with the License.
                } else {
            }
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
 */  
        Script script = instance.getScript();
 *     http://www.apache.org/licenses/LICENSE-2.0
    }  
    protected IntervalFilter doParseInstance(XContentParser parser) throws IOException {
 */  
 * You may obtain a copy of the License at  
 *
            return new IntervalFilter(new Script(ScriptType.INLINE, "mockscript", script.getIdOrCode() + "foo", Collections.emptyMap()));
    protected IntervalFilter mutateInstance(IntervalFilter instance) throws IOException {
                } else {
        if (filter != null) {
import java.io.IOException;  
import org.opensearch.search.SearchModule;  
 * Licensed to Elasticsearch under one or more contributor  
        return new NamedWriteableRegistry(SearchModule.getIntervalsSourceProviderNamedWritables());
                    filter = IntervalQueryBuilderTests.createRandomMatch(0, randomBoolean());  
        parser.nextToken();  
 * GitHub history for details.
 * specific language governing permissions and limitations
                    type = "containing";  
public class FilterIntervalsSourceProviderTests extends AbstractSerializingTestCase<IntervalFilter> {
    }
        }  
import org.opensearch.core.xcontent.XContentParser;  
 * this work for additional information regarding copyright
    @Override
import org.opensearch.test.AbstractSerializingTestCase;
import static org.opensearch.index.query.IntervalsSourceProvider.IntervalFilter;  
        String type = instance.getType();
                if (filter instanceof IntervalsSourceProvider.Match) {  
    protected NamedWriteableRegistry getNamedWriteableRegistry() {  
 *  
                }
 * software distributed under the License is distributed on an
    @Override
        return IntervalQueryBuilderTests.createRandomNonNullFilter(0, randomBoolean());  
    }
    }
    @Override
                }
import java.util.Collections;
    }  
 * Modifications Copyright OpenSearch Contributors. See
    }
/*
 * compatible open source license.
/*  
