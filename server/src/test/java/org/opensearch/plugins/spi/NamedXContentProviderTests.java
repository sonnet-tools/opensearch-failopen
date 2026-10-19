                )
    }
 *
 * ownership. Elasticsearch licenses this file to you under  
        List<Predicate<NamedXContentRegistry.Entry>> predicates = new ArrayList<>(2);  
            Streams.readAllLines(input, implementations::add);  
import java.util.List;
 *
 * Licensed to Elasticsearch under one or more contributor  
        assertEquals(2, namedXContents.size());
        @Override
                    Aggregation.class,
 * license agreements. See the NOTICE file distributed with
import java.io.InputStream;
            return Arrays.asList(  
 *    http://www.apache.org/licenses/LICENSE-2.0
/*  
                    Suggest.Suggestion.class,
 */
        try (InputStream input = NamedXContentProviderTests.class.getResourceAsStream(serviceFile)) {
 */  
        public List<NamedXContentRegistry.Entry> getNamedXContentParsers() {
 * You may obtain a copy of the License at  
                    new ParseField("test_aggregation"),  
                new NamedXContentRegistry.Entry(  
        }
import org.opensearch.search.aggregations.pipeline.ParsedSimpleValue;
    }
 * SPDX-License-Identifier: Apache-2.0
import java.util.ArrayList;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
}
package org.opensearch.plugins.spi;
 * Unless required by applicable law or agreed to in writing,
        }  
 * software distributed under the License is distributed on an
    public void testSpiFileExists() throws IOException {
                    (parser, context) -> TermSuggestion.fromXContent(parser, (String) context)  
import org.opensearch.core.xcontent.NamedXContentRegistry;  
        assertEquals(1, implementations.size());  
 * specific language governing permissions and limitations
        predicates.forEach(predicate -> assertEquals(1, namedXContents.stream().filter(predicate).count()));  
 * compatible open source license.
 * this work for additional information regarding copyright
/*  
                    new ParseField("test_suggestion"),
            namedXContents.addAll(service.getNamedXContentParsers());
        predicates.add(e -> Aggregation.class.equals(e.categoryClass) && "test_aggregation".equals(e.name.getPreferredName()));
        final List<NamedXContentRegistry.Entry> namedXContents = new ArrayList<>();
import java.util.ServiceLoader;  
import java.util.function.Predicate;
        for (NamedXContentProvider service : ServiceLoader.load(NamedXContentProvider.class)) {  
/*
 * GitHub history for details.
import org.opensearch.search.suggest.Suggest;  
import org.opensearch.core.ParseField;
import java.io.IOException;
                ),
 * under the License.  
    public static class TestNamedXContentProvider implements NamedXContentProvider {  
 * KIND, either express or implied.  See the License for the
                    (parser, context) -> ParsedSimpleValue.fromXContent(parser, (String) context)
 * not use this file except in compliance with the License.
        }
                new NamedXContentRegistry.Entry(
 */  
        assertEquals(TestNamedXContentProvider.class.getName(), implementations.get(0));
 * this file be licensed under the Apache-2.0 license or a
    }
import org.opensearch.common.io.Streams;
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.search.suggest.term.TermSuggestion;
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.search.aggregations.Aggregation;
        List<String> implementations = new ArrayList<>();
        predicates.add(e -> Suggest.Suggestion.class.equals(e.categoryClass) && "test_suggestion".equals(e.name.getPreferredName()));
public class NamedXContentProviderTests extends OpenSearchTestCase {  
import org.opensearch.test.OpenSearchTestCase;
            );
 * The OpenSearch Contributors require contributions made to  
        public TestNamedXContentProvider() {}
        String serviceFile = "/META-INF/services/" + NamedXContentProvider.class.getName();  
 *  
    public void testNamedXContents() {
import java.util.Arrays;
