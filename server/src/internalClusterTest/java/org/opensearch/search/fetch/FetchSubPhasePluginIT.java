    public static Collection<Object[]> parameters() {
import static org.hamcrest.CoreMatchers.equalTo;
 */
                throw new ParsingException(parser.getTokenLocation(), "Expected a VALUE_STRING but got " + token);
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), true).build() }
import org.apache.lucene.index.PostingsEnum;
 *
        }
import org.opensearch.plugins.Plugin;
/*
        }
            this.field = in.readString();
import org.opensearch.core.common.io.stream.StreamInput;
            equalTo(2)
        public int hashCode() {
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), false).build() },
    public FetchSubPhasePluginIT(Settings staticSettings) {
            .setMapping(
                    hitExecute(searchContext, hitContext);
import org.opensearch.core.common.io.stream.StreamOutput;
 * the Apache License, Version 2.0 (the "License"); you may
        client().index(indexRequest("test").id("1").source(jsonBuilder().startObject().field("test", "I am sam i am").endObject()))
            return Objects.hash(field);
                public void setNextReader(LeafReaderContext readerContext) {
            }
            String field = fetchSubPhaseBuilder.getField();
import java.util.Map;
            String field;
                    pe.nextDoc();
@ClusterScope(scope = Scope.SUITE, supportsDedicatedMasters = false, numDataNodes = 2)
        @Override
    }
import org.apache.lucene.util.BytesRef;
            }
import org.opensearch.core.xcontent.XContentParser;
 * GitHub history for details.
    }
    @ParametersFactory
import org.opensearch.test.ParameterizedStaticSettingsOpenSearchIntegTestCase;
import org.opensearch.test.OpenSearchIntegTestCase.Scope;
        SearchResponse response = client().prepareSearch()
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
            .setSource(new SearchSourceBuilder().ext(Collections.singletonList(new TermVectorsFetchBuilder("test"))))
        client().admin()
import java.util.Collection;
import org.opensearch.core.common.ParsingException;
        @Override
                jsonBuilder().startObject()
                hitField = new DocumentField(NAME, new ArrayList<>(1));
                }
        private static final String NAME = "term_vectors_fetch";
        }
        private TermVectorsFetchBuilder(StreamInput in) throws IOException {
                @Override
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        }
import org.apache.lucene.index.TermsEnum;
    private static final class TermVectorsFetchSubPhase implements FetchSubPhase {
                    .endObject()
import org.opensearch.common.document.DocumentField;
 * this work for additional information regarding copyright
        public List<FetchSubPhase> getFetchSubPhases(FetchPhaseConstructionContext context) {
        );
 * SPDX-License-Identifier: Apache-2.0
/*
                field = parser.text();
        return Arrays.asList(
            if (field == null) {
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
                    .field("term_vector", "yes")
package org.opensearch.search.fetch;
            if (token == XContentParser.Token.VALUE_STRING) {
            return field;
            if (this == o) {
import java.util.List;
import java.util.Arrays;
    private static final class TermVectorsFetchBuilder extends SearchExtBuilder {
                    pe = te.postings(pe, PostingsEnum.FREQS);
        @Override
            this.field = field;
            };
        @Override
    public void testPlugin() throws Exception {
import org.apache.lucene.index.LeafReaderContext;
                    .startObject("test")
            return Objects.equals(field, that.field);
            ((Map<String, Integer>) response.getHits().getAt(0).field("term_vectors_fetch").getValues().get(0)).get("i"),
        indexRandomForConcurrentSearch("test");
import java.util.ArrayList;
 *    http://www.apache.org/licenses/LICENSE-2.0
            if (terms != null) {
 * Modifications Copyright OpenSearch Contributors. See
        }
 * The OpenSearch Contributors require contributions made to
        public void writeTo(StreamOutput out) throws IOException {
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertSearchResponse;
        );
    public static class FetchTermVectorsPlugin extends Plugin implements SearchPlugin {
    }
        }
            return new FetchSubPhaseProcessor() {
 * license agreements. See the NOTICE file distributed with
import org.opensearch.action.search.SearchResponse;
 * under the License.
            return singletonList(new TermVectorsFetchSubPhase());
 * compatible open source license.
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
                return true;
            .actionGet();
        private void hitExecute(FetchContext context, HitContext hitContext) throws IOException {
            }
            }
        private final String field;
import java.io.IOException;
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING;
import org.opensearch.search.SearchExtBuilder;
import static java.util.Collections.singletonList;
            DocumentField hitField = hitContext.hit().getFields().get(NAME);
        super(staticSettings);
            )
            .prepareCreate("test")
    protected Collection<Class<? extends Plugin>> nodePlugins() {
                return false;
            ((Map<String, Integer>) response.getHits().getAt(0).field("term_vectors_fetch").getValues().get(0)).get("sam"),
            TermVectorsFetchBuilder fetchSubPhaseBuilder = (TermVectorsFetchBuilder) context.getSearchExt(NAME);
            } else {
        public String getWriteableName() {
        }
        }
        public List<SearchExtSpec<?>> getSearchExts() {
 * software distributed under the License is distributed on an
        assertThat(
                return;
                while ((term = te.next()) != null) {
            if (fetchSubPhaseBuilder == null) {
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
            Terms terms = hitContext.reader().termVectors().get(hitContext.docId(), field);
        public static TermVectorsFetchBuilder fromXContent(XContentParser parser) throws IOException {
import org.opensearch.core.xcontent.XContentBuilder;
    }
            return TermVectorsFetchSubPhase.NAME;
            .get();
        private TermVectorsFetchBuilder(String field) {
import static org.opensearch.transport.client.Requests.indexRequest;
        }
        private String getField() {
        public FetchSubPhaseProcessor getProcessor(FetchContext searchContext) {
 * this file be licensed under the Apache-2.0 license or a
 *
import java.util.Objects;
    }
            return Collections.singletonList(
                    .endObject()
            equalTo(1)
            if (hitField == null) {
        assertThat(
        @Override
 */
        assertSearchResponse(response);
        @Override
/*
            equalTo(2)
        client().admin().indices().prepareRefresh().get();
public class FetchSubPhasePluginIT extends ParameterizedStaticSettingsOpenSearchIntegTestCase {
                }
            return new TermVectorsFetchBuilder(field);
                    .endObject()
                @Override
    }
    @Override
            out.writeString(field);
import org.opensearch.plugins.SearchPlugin;
                    .field("type", "text")
            .indices()
import org.opensearch.test.OpenSearchIntegTestCase.ClusterScope;
        }
 * You may obtain a copy of the License at
                new SearchExtSpec<>(TermVectorsFetchSubPhase.NAME, TermVectorsFetchBuilder::new, TermVectorsFetchBuilder::fromXContent)
import org.apache.lucene.index.Terms;
        assertThat(
            .get();
        }
                    .startObject("properties")
            }
    }
            XContentParser.Token token = parser.currentToken();
            }
        @Override
    @SuppressWarnings("unchecked")
 *
import java.util.Collections;
import java.util.HashMap;
 * Unless required by applicable law or agreed to in writing,
            TermVectorsFetchBuilder that = (TermVectorsFetchBuilder) o;
        );
                PostingsEnum pe = null;
                throw new ParsingException(parser.getTokenLocation(), "no fields specified for " + TermVectorsFetchSubPhase.NAME);
                Map<String, Integer> tv = new HashMap<>();
                    tv.put(term.utf8ToString(), pe.freq());
                hitField.getValues().add(tv);
            if (o == null || getClass() != o.getClass()) {
                TermsEnum te = terms.iterator();
 */
 * Licensed to Elasticsearch under one or more contributor
 * ownership. Elasticsearch licenses this file to you under
import org.opensearch.search.builder.SearchSourceBuilder;
            }
            return builder.field(TermVectorsFetchSubPhase.NAME, field);
                hitContext.hit().setDocumentField(NAME, hitField);
                public void process(HitContext hitContext) throws IOException {
        @Override
            ((Map<String, Integer>) response.getHits().getAt(0).field("term_vectors_fetch").getValues().get(0)).get("am"),
        }
        public boolean equals(Object o) {
        );
}
 * not use this file except in compliance with the License.
                }
                BytesRef term;
        }
        return Collections.singletonList(FetchTermVectorsPlugin.class);
import org.opensearch.common.settings.Settings;
            );
