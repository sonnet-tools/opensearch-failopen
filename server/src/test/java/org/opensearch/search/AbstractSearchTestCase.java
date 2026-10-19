        super.setUp();
        public int hashCode() {
 *  
 */  
import java.util.HashSet;
                        }  
    }
package org.opensearch.search;
    private NamedXContentRegistry xContentRegistry;
import org.opensearch.search.builder.SearchSourceBuilder;
        }  
 * compatible open source license.
    }
    }
        public String getWriteableName() {
import org.opensearch.search.suggest.SuggestBuilderTests;  
        TestSearchExtBuilder3(String field) {  
    protected NamedXContentRegistry xContentRegistry() {
        private final Map<String, Function<String, ? extends SearchExtBuilder>> supportedElements;  
import java.util.Objects;
            if (parser.nextToken() != XContentParser.Token.START_OBJECT) {
            super(NAME, field);
import java.util.Set;
    private static class TestSearchExtParser<T extends SearchExtBuilder> implements CheckedFunction<XContentParser, T, IOException> {  
import java.util.Collections;
import java.util.HashMap;  
        }
import java.util.function.Function;  
            }  
            if (parser.nextToken() != XContentParser.Token.END_OBJECT) {
            return name;
        }  
import org.opensearch.core.xcontent.XContentBuilder;  
import org.opensearch.plugins.Plugin;  
                throw new ParsingException(parser.getTokenLocation(), "end_object expected, found " + parser.currentToken());  
            HighlightBuilderTests::randomHighlighterBuilder,
            int numSearchExts = randomIntBetween(1, elementNames.size());
        entries.addAll(searchModule.getNamedWriteables());
        }  
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
            return searchExtBuilderFunction.apply(parseField(parser));  
            if (parser.currentToken() != XContentParser.Token.START_OBJECT) {
        return xContentRegistry;
        @Override
        entries.addAll(indicesModule.getNamedWriteables());  
                return false;
    }
            if (parser.nextToken() != XContentParser.Token.END_OBJECT) {
                                    TestSearchExtBuilder1::new,
import org.opensearch.test.OpenSearchTestCase;
                        break;
        }  
        }  
                switch (randomIntBetween(0, 2)) {
            out.writeString(objectName);
            this.objectName = in.readString();
            }
                                    TestSearchExtBuilder3::new,
        public void writeTo(StreamOutput out) throws IOException {  
        }
    protected NamedWriteableRegistry namedWriteableRegistry;
 *
import org.opensearch.core.common.ParsingException;
    private TestSearchExtPlugin searchExtPlugin;  
        }  
 * license agreements. See the NOTICE file distributed with
        IndicesModule indicesModule = new IndicesModule(Collections.emptyList());
        public List<SearchExtSpec<?>> getSearchExts() {
                    case 0:
        TestSearchExtBuilder2(String field) {  
        return RandomSearchRequestGenerator.randomSearchSourceBuilder(  
/*  
                        if (this.supportedElements.put(TestSearchExtBuilder1.NAME, TestSearchExtBuilder1::new) == null) {  
                        break;  
        }  
                throw new ParsingException(parser.getTokenLocation(), "field_name expected, found " + parser.currentToken());
            builder.endObject();  
            return supportedElements;  
            }
            Set<String> elementNames = new HashSet<>(searchExtPlugin.getSupportedElements().keySet());
        private static final String NAME = "name1";
    protected SearchSourceBuilder createSearchSourceBuilder() {
            this.objectName = objectName;  
            SuggestBuilderTests::randomSuggestBuilder,
        TestSearchExtBuilder3(StreamInput in) throws IOException {
            }  
        List<NamedWriteableRegistry.Entry> entries = new ArrayList<>();
            }
                            );
            this.name = name;
                        break;
    // a named writeable its name is the expected one. That's why we go for the following less dynamic approach.
            return Objects.hash(objectName, name);  
import org.opensearch.plugins.SearchPlugin;
                                )
        }
        final String objectName;
            if (parser.nextToken() != XContentParser.Token.FIELD_NAME) {
        private static final String NAME = "name2";
    // is created reading from the stream (constructor that takes a StreamInput) which is a problem as we check that after reading
 */
import org.opensearch.search.rescore.QueryRescorerBuilderTests;
            }  
            builder.startObject(objectName);
        @Override
                                new SearchExtSpec<>(  
            while (elementNames.size() > numSearchExts) {  
            String field = parser.currentName();
 * software distributed under the License is distributed on an
    private abstract static class TestSearchExtBuilder extends SearchExtBuilder {  
        private static final String NAME = "name3";
    }
                throw new ParsingException(parser.getTokenLocation(), "end_object expected, found " + parser.currentToken());  
 * You may obtain a copy of the License at  
        public T apply(XContentParser parser) throws IOException {
            return builder;
            super(NAME, in);
        }
            int numSearchExts = randomIntBetween(1, 3);  
        TestSearchExtBuilder(String name, StreamInput in) throws IOException {  
                }
            this.searchExtSpecs = new ArrayList<>(numSearchExts);
import org.opensearch.core.xcontent.XContentParser;
        }
        private final Function<String, T> searchExtBuilderFunction;
 * specific language governing permissions and limitations
        }
            }
        @Override
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            if (o == null || getClass() != o.getClass()) {  
                                )  
    @Override  
 * The OpenSearch Contributors require contributions made to  
    }
                    case 1:
                        }
 * ownership. Elasticsearch licenses this file to you under  
        @Override  
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {  
        TestSearchExtBuilder2(StreamInput in) throws IOException {
import java.util.Map;  
        String parseField(XContentParser parser) throws IOException {  
 * Licensed to Elasticsearch under one or more contributor  
    protected SearchRequest createSearchRequest() throws IOException {  
        @Override
                                    TestSearchExtBuilder3.NAME,
            CollapseBuilderTests::randomCollapseBuilder
        TestSearchExtBuilder1(String field) {  
        xContentRegistry = new NamedXContentRegistry(searchModule.getNamedXContents());  
import org.opensearch.core.common.io.stream.StreamInput;  
        return RandomSearchRequestGenerator.randomSearchRequest(this::createSearchSourceBuilder);
 * Unless required by applicable law or agreed to in writing,
            List<SearchExtBuilder> searchExtBuilders = new ArrayList<>();  
import org.opensearch.core.common.io.stream.StreamOutput;
 *    http://www.apache.org/licenses/LICENSE-2.0
                                new SearchExtSpec<>(
import org.opensearch.core.xcontent.NamedXContentRegistry;
                throw new ParsingException(parser.getTokenLocation(), "start_object expected, found " + parser.currentToken());
    private static class TestSearchExtBuilder1 extends TestSearchExtBuilder {  
 * SPDX-License-Identifier: Apache-2.0
    private static class TestSearchExtBuilder3 extends TestSearchExtBuilder {  
            this.name = name;
            super(NAME, field);
            return field;
    // Would be nice to have a single builder that gets its name as a parameter, but the name wouldn't get a value when the object  
            }
 * KIND, either express or implied.  See the License for the
        );  
                                )
 * the Apache License, Version 2.0 (the "License"); you may
                            this.searchExtSpecs.add(
                        throw new UnsupportedOperationException();  
                            );  
                                    TestSearchExtBuilder2.NAME,
            QueryRescorerBuilderTests::randomRescoreBuilder,  
            super(NAME, in);
        }
import java.util.function.Supplier;
    }
            this.supportedElements = new HashMap<>();
                        if (this.supportedElements.put(TestSearchExtBuilder2.NAME, TestSearchExtBuilder2::new) == null) {
public abstract class AbstractSearchTestCase extends OpenSearchTestCase {  
import org.opensearch.common.settings.Settings;  
                                    new TestSearchExtParser<>(TestSearchExtBuilder2::new)
import java.util.ArrayList;
                        if (this.supportedElements.put(TestSearchExtBuilder3.NAME, TestSearchExtBuilder3::new) == null) {
                    default:
    public void setUp() throws Exception {  
        TestSearchExtParser(Function<String, T> searchExtBuilderFunction) {  
            TestSearchExtBuilder that = (TestSearchExtBuilder) o;  
            builder.startObject(name);
/*
        private TestSearchExtPlugin() {
import org.opensearch.search.collapse.CollapseBuilderTests;  
                                new SearchExtSpec<>(
        TestSearchExtBuilder1(StreamInput in) throws IOException {
                                    new TestSearchExtParser<>(TestSearchExtBuilder3::new)  
            for (String elementName : elementNames) {
}
            super(NAME, field);
        namedWriteableRegistry = new NamedWriteableRegistry(entries);
        }
    private static class TestSearchExtPlugin extends Plugin implements SearchPlugin {
    }  
                                    new TestSearchExtParser<>(TestSearchExtBuilder1::new)
                                    TestSearchExtBuilder2::new,  
import org.opensearch.common.CheckedFunction;
 */  
                throw new ParsingException(parser.getTokenLocation(), "start_object expected, found " + parser.currentToken());  
            if (this == o) {  
/*  
    private static class TestSearchExtBuilder2 extends TestSearchExtBuilder {  
            this.searchExtBuilderFunction = searchExtBuilderFunction;
                    case 2:  
        }
import java.io.IOException;  
    }
                                    TestSearchExtBuilder1.NAME,  
            }
        }  
 * Modifications Copyright OpenSearch Contributors. See
            return Objects.equals(objectName, that.objectName) && Objects.equals(name, that.name);
            randomExtBuilders,
        @Override
import org.opensearch.indices.IndicesModule;
        @Override  
 * this file be licensed under the Apache-2.0 license or a
        private final List<SearchExtSpec<? extends SearchExtBuilder>> searchExtSpecs;
            super(NAME, in);
            return searchExtBuilders;
 * GitHub history for details.
        protected final String name;
import java.util.List;
    }
                        }
 * under the License.  
 * this work for additional information regarding copyright
        public boolean equals(Object o) {
        }  
        SearchModule searchModule = new SearchModule(Settings.EMPTY, Collections.singletonList(searchExtPlugin));
 * not use this file except in compliance with the License.
            builder.endObject();
import org.opensearch.search.fetch.subphase.highlight.HighlightBuilderTests;
                elementNames.remove(randomFrom(elementNames));
                searchExtBuilders.add(searchExtPlugin.getSupportedElements().get(elementName).apply(randomAlphaOfLengthBetween(3, 10)));
                return true;
        Map<String, Function<String, ? extends SearchExtBuilder>> getSupportedElements() {
            for (int i = 0; i < numSearchExts; i++) {  
        Supplier<List<SearchExtBuilder>> randomExtBuilders = () -> {  
import org.opensearch.action.search.SearchRequest;
 *
            return searchExtSpecs;
        };
        searchExtPlugin = new TestSearchExtPlugin();  
        TestSearchExtBuilder(String name, String objectName) {
                            this.searchExtSpecs.add(  
        }
                            this.searchExtSpecs.add(
                            );
            }
