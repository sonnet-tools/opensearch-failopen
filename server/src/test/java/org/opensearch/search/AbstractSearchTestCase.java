        @Override
            if (parser.nextToken() != XContentParser.Token.END_OBJECT) {
            QueryRescorerBuilderTests::randomRescoreBuilder,
                                    new TestSearchExtParser<>(TestSearchExtBuilder3::new)
            Set<String> elementNames = new HashSet<>(searchExtPlugin.getSupportedElements().keySet());
        TestSearchExtBuilder3(String field) {
                        break;
            }
    protected NamedWriteableRegistry namedWriteableRegistry;
        @Override
        public T apply(XContentParser parser) throws IOException {
 * specific language governing permissions and limitations
    private abstract static class TestSearchExtBuilder extends SearchExtBuilder {
import org.opensearch.search.rescore.QueryRescorerBuilderTests;
            if (parser.nextToken() != XContentParser.Token.END_OBJECT) {
                searchExtBuilders.add(searchExtPlugin.getSupportedElements().get(elementName).apply(randomAlphaOfLengthBetween(3, 10)));
            }
            super(NAME, in);
    private static class TestSearchExtPlugin extends Plugin implements SearchPlugin {
 * Modifications Copyright OpenSearch Contributors. See
            return Objects.hash(objectName, name);
            out.writeString(objectName);
        }
 * under the License.
                            );
        SearchModule searchModule = new SearchModule(Settings.EMPTY, Collections.singletonList(searchExtPlugin));
import java.io.IOException;
            }
                return true;
 * The OpenSearch Contributors require contributions made to
    protected NamedXContentRegistry xContentRegistry() {
                throw new ParsingException(parser.getTokenLocation(), "start_object expected, found " + parser.currentToken());
import org.opensearch.search.collapse.CollapseBuilderTests;
 *
        private TestSearchExtPlugin() {
        return RandomSearchRequestGenerator.randomSearchRequest(this::createSearchSourceBuilder);
            this.searchExtSpecs = new ArrayList<>(numSearchExts);
                }
        TestSearchExtBuilder1(StreamInput in) throws IOException {
            while (elementNames.size() > numSearchExts) {
        @Override
            this.name = name;
                        break;
            }
            }
            return builder;
        TestSearchExtBuilder2(StreamInput in) throws IOException {
    // is created reading from the stream (constructor that takes a StreamInput) which is a problem as we check that after reading
            CollapseBuilderTests::randomCollapseBuilder
            List<SearchExtBuilder> searchExtBuilders = new ArrayList<>();
                            );
package org.opensearch.search;
        entries.addAll(searchModule.getNamedWriteables());
import org.opensearch.indices.IndicesModule;
        TestSearchExtParser(Function<String, T> searchExtBuilderFunction) {
            HighlightBuilderTests::randomHighlighterBuilder,
            return searchExtBuilders;
        TestSearchExtBuilder(String name, StreamInput in) throws IOException {
 *
            }
            return name;
            }
                                    TestSearchExtBuilder3::new,
            if (parser.currentToken() != XContentParser.Token.START_OBJECT) {
    }
import java.util.HashSet;
            super(NAME, field);
            }
            randomExtBuilders,
                                )
                switch (randomIntBetween(0, 2)) {
            }
                        if (this.supportedElements.put(TestSearchExtBuilder3.NAME, TestSearchExtBuilder3::new) == null) {
        public String getWriteableName() {
        public List<SearchExtSpec<?>> getSearchExts() {
            for (int i = 0; i < numSearchExts; i++) {
import java.util.Set;
    }
        IndicesModule indicesModule = new IndicesModule(Collections.emptyList());
        }
        entries.addAll(indicesModule.getNamedWriteables());
                            this.searchExtSpecs.add(
import org.opensearch.common.settings.Settings;
            builder.endObject();
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
        private static final String NAME = "name3";
                                )
        private final Function<String, T> searchExtBuilderFunction;
        return RandomSearchRequestGenerator.randomSearchSourceBuilder(
import org.opensearch.plugins.SearchPlugin;
                    default:
        String parseField(XContentParser parser) throws IOException {
        }
                        if (this.supportedElements.put(TestSearchExtBuilder2.NAME, TestSearchExtBuilder2::new) == null) {
import java.util.function.Supplier;
import org.opensearch.core.xcontent.NamedXContentRegistry;
                        }
import org.opensearch.core.common.io.stream.StreamOutput;
import org.opensearch.test.OpenSearchTestCase;
    }
    private NamedXContentRegistry xContentRegistry;
    }
            if (parser.nextToken() != XContentParser.Token.START_OBJECT) {
import java.util.Objects;
        public void writeTo(StreamOutput out) throws IOException {
 * You may obtain a copy of the License at
    }
}
import org.opensearch.action.search.SearchRequest;
                    case 1:
            int numSearchExts = randomIntBetween(1, 3);
            return searchExtSpecs;
            builder.startObject(name);
    // Would be nice to have a single builder that gets its name as a parameter, but the name wouldn't get a value when the object
/*
        }
 * license agreements. See the NOTICE file distributed with
                            this.searchExtSpecs.add(
            TestSearchExtBuilder that = (TestSearchExtBuilder) o;
 * not use this file except in compliance with the License.
                        }
            this.objectName = in.readString();
        }
        }
            builder.startObject(objectName);
            for (String elementName : elementNames) {
    }
import org.opensearch.core.common.ParsingException;
    private static class TestSearchExtParser<T extends SearchExtBuilder> implements CheckedFunction<XContentParser, T, IOException> {
            return Objects.equals(objectName, that.objectName) && Objects.equals(name, that.name);
                                new SearchExtSpec<>(
/*
                                new SearchExtSpec<>(
        private final List<SearchExtSpec<? extends SearchExtBuilder>> searchExtSpecs;
    private static class TestSearchExtBuilder1 extends TestSearchExtBuilder {
                                )
        return xContentRegistry;
import java.util.ArrayList;
        }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            if (o == null || getClass() != o.getClass()) {
            this.supportedElements = new HashMap<>();
        );
import org.opensearch.search.suggest.SuggestBuilderTests;
        }
            String field = parser.currentName();
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
                                    new TestSearchExtParser<>(TestSearchExtBuilder1::new)
        }
 */
/*
    // a named writeable its name is the expected one. That's why we go for the following less dynamic approach.
        };
                                    TestSearchExtBuilder2.NAME,
        Map<String, Function<String, ? extends SearchExtBuilder>> getSupportedElements() {
import java.util.List;
        private final Map<String, Function<String, ? extends SearchExtBuilder>> supportedElements;
 * software distributed under the License is distributed on an
        TestSearchExtBuilder(String name, String objectName) {
 */
 * SPDX-License-Identifier: Apache-2.0
        private static final String NAME = "name2";
        }
            super(NAME, in);
public abstract class AbstractSearchTestCase extends OpenSearchTestCase {
            int numSearchExts = randomIntBetween(1, elementNames.size());
 * Unless required by applicable law or agreed to in writing,
        searchExtPlugin = new TestSearchExtPlugin();
            return supportedElements;
import java.util.function.Function;
 * this file be licensed under the Apache-2.0 license or a
        @Override
 * Licensed to Elasticsearch under one or more contributor
import org.opensearch.core.xcontent.XContentParser;
 * ownership. Elasticsearch licenses this file to you under
            SuggestBuilderTests::randomSuggestBuilder,
                                    TestSearchExtBuilder2::new,
                    case 0:
        List<NamedWriteableRegistry.Entry> entries = new ArrayList<>();
        }
import org.opensearch.search.builder.SearchSourceBuilder;
        xContentRegistry = new NamedXContentRegistry(searchModule.getNamedXContents());
                    case 2:
            super(NAME, field);
import org.opensearch.core.xcontent.XContentBuilder;
        super.setUp();
        namedWriteableRegistry = new NamedWriteableRegistry(entries);
        }
        }
import org.opensearch.core.common.io.stream.StreamInput;
        TestSearchExtBuilder3(StreamInput in) throws IOException {
    private TestSearchExtPlugin searchExtPlugin;
 *
    public void setUp() throws Exception {
    @Override
    }
                                    new TestSearchExtParser<>(TestSearchExtBuilder2::new)
import java.util.HashMap;
                            );
import org.opensearch.search.fetch.subphase.highlight.HighlightBuilderTests;
    }
            return field;
 * GitHub history for details.
        public int hashCode() {
                                    TestSearchExtBuilder3.NAME,
            this.objectName = objectName;
 * KIND, either express or implied.  See the License for the
        @Override
                            this.searchExtSpecs.add(
                throw new ParsingException(parser.getTokenLocation(), "field_name expected, found " + parser.currentToken());
 *    http://www.apache.org/licenses/LICENSE-2.0
            builder.endObject();
                                new SearchExtSpec<>(
                        break;
                                    TestSearchExtBuilder1.NAME,
        }
        }
                        }
import org.opensearch.common.CheckedFunction;
                throw new ParsingException(parser.getTokenLocation(), "start_object expected, found " + parser.currentToken());
                throw new ParsingException(parser.getTokenLocation(), "end_object expected, found " + parser.currentToken());
        public boolean equals(Object o) {
                elementNames.remove(randomFrom(elementNames));
        @Override
                throw new ParsingException(parser.getTokenLocation(), "end_object expected, found " + parser.currentToken());
    }
            return searchExtBuilderFunction.apply(parseField(parser));
import org.opensearch.plugins.Plugin;
        TestSearchExtBuilder2(String field) {
                        throw new UnsupportedOperationException();
        }
        }
            super(NAME, field);
            if (this == o) {
        protected final String name;
 * this work for additional information regarding copyright
        private static final String NAME = "name1";
    private static class TestSearchExtBuilder2 extends TestSearchExtBuilder {
    private static class TestSearchExtBuilder3 extends TestSearchExtBuilder {
        TestSearchExtBuilder1(String field) {
            this.name = name;
                                    TestSearchExtBuilder1::new,
import java.util.Collections;
            super(NAME, in);
        Supplier<List<SearchExtBuilder>> randomExtBuilders = () -> {
        @Override
            this.searchExtBuilderFunction = searchExtBuilderFunction;
            if (parser.nextToken() != XContentParser.Token.FIELD_NAME) {
 * the Apache License, Version 2.0 (the "License"); you may
        }
        }
 */
            }
    protected SearchSourceBuilder createSearchSourceBuilder() {
    }
import java.util.Map;
        final String objectName;
    protected SearchRequest createSearchRequest() throws IOException {
                return false;
 * compatible open source license.
                        if (this.supportedElements.put(TestSearchExtBuilder1.NAME, TestSearchExtBuilder1::new) == null) {
