            .get();
                    pe = te.postings(pe, PostingsEnum.FREQS);
                    .endObject()
        client().admin()  
                new SearchExtSpec<>(TermVectorsFetchSubPhase.NAME, TermVectorsFetchBuilder::new, TermVectorsFetchBuilder::fromXContent)  
    @SuppressWarnings("unchecked")
        @Override  
            )  
                return false;
import org.opensearch.common.document.DocumentField;  
    }
                    .field("type", "text")
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), false).build() },  
                }
 * license agreements. See the NOTICE file distributed with
                return true;
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), true).build() }
                Map<String, Integer> tv = new HashMap<>();
                hitField.getValues().add(tv);  
            return Objects.equals(field, that.field);
 * this file be licensed under the Apache-2.0 license or a
        private TermVectorsFetchBuilder(String field) {
 * under the License.  
        }  
        @Override
                    tv.put(term.utf8ToString(), pe.freq());
    public static Collection<Object[]> parameters() {
                hitField = new DocumentField(NAME, new ArrayList<>(1));
            out.writeString(field);
        }  
            .actionGet();
 * the Apache License, Version 2.0 (the "License"); you may
        client().index(indexRequest("test").id("1").source(jsonBuilder().startObject().field("test", "I am sam i am").endObject()))  
import org.opensearch.plugins.Plugin;
    public void testPlugin() throws Exception {
 * software distributed under the License is distributed on an
 */  
import org.opensearch.test.ParameterizedStaticSettingsOpenSearchIntegTestCase;
            if (hitField == null) {  
        assertThat(  
            }
import java.io.IOException;  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertSearchResponse;
                    .endObject()
        @Override  
 * You may obtain a copy of the License at  
            .setSource(new SearchSourceBuilder().ext(Collections.singletonList(new TermVectorsFetchBuilder("test"))))
import org.opensearch.core.xcontent.XContentBuilder;
import org.opensearch.test.OpenSearchIntegTestCase.ClusterScope;
    }  
        super(staticSettings);  
        }
        public String getWriteableName() {
import org.opensearch.search.builder.SearchSourceBuilder;
 * KIND, either express or implied.  See the License for the
            return field;
                @Override
                    .field("term_vector", "yes")
            return Objects.hash(field);  
        assertSearchResponse(response);  
 * ownership. Elasticsearch licenses this file to you under  
        }  
        indexRandomForConcurrentSearch("test");
 *    http://www.apache.org/licenses/LICENSE-2.0
 * Licensed to Elasticsearch under one or more contributor  
import java.util.List;  
import java.util.HashMap;
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
            ((Map<String, Integer>) response.getHits().getAt(0).field("term_vectors_fetch").getValues().get(0)).get("sam"),
            .prepareCreate("test")
                while ((term = te.next()) != null) {
import org.opensearch.core.common.io.stream.StreamInput;  
                public void process(HitContext hitContext) throws IOException {
            equalTo(2)  
        assertThat(
/*
        );  
            DocumentField hitField = hitContext.hit().getFields().get(NAME);
 *
            ((Map<String, Integer>) response.getHits().getAt(0).field("term_vectors_fetch").getValues().get(0)).get("i"),
import org.opensearch.test.OpenSearchIntegTestCase.Scope;  
            }
        @Override
            TermVectorsFetchBuilder fetchSubPhaseBuilder = (TermVectorsFetchBuilder) context.getSearchExt(NAME);  
            return new FetchSubPhaseProcessor() {
                field = parser.text();
import static org.hamcrest.CoreMatchers.equalTo;  
        private static final String NAME = "term_vectors_fetch";  
 * specific language governing permissions and limitations
        @Override
import static java.util.Collections.singletonList;
            this.field = in.readString();  
 *  
                throw new ParsingException(parser.getTokenLocation(), "Expected a VALUE_STRING but got " + token);  
            TermVectorsFetchBuilder that = (TermVectorsFetchBuilder) o;  
package org.opensearch.search.fetch;
            } else {
            return builder.field(TermVectorsFetchSubPhase.NAME, field);  
    @Override
        @Override
    private static final class TermVectorsFetchBuilder extends SearchExtBuilder {
        private void hitExecute(FetchContext context, HitContext hitContext) throws IOException {
                TermsEnum te = terms.iterator();  
            return TermVectorsFetchSubPhase.NAME;
    public static class FetchTermVectorsPlugin extends Plugin implements SearchPlugin {  
                    .startObject("test")  
    }
            if (token == XContentParser.Token.VALUE_STRING) {  
        );
}  
        @Override
        public boolean equals(Object o) {
                }
    }  
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
            String field;
        }
                    pe.nextDoc();  
    @ParametersFactory  
        assertThat(
 * Modifications Copyright OpenSearch Contributors. See
 *
            this.field = field;
 * Unless required by applicable law or agreed to in writing,
        }
import org.apache.lucene.index.PostingsEnum;
 */  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.apache.lucene.index.Terms;
                jsonBuilder().startObject()
        public FetchSubPhaseProcessor getProcessor(FetchContext searchContext) {  
import java.util.ArrayList;
        );
        }  
        }
            };
import java.util.Objects;
import org.opensearch.common.settings.Settings;
        }
            String field = fetchSubPhaseBuilder.getField();
        client().admin().indices().prepareRefresh().get();  
import org.apache.lucene.index.TermsEnum;  
            equalTo(2)
        public int hashCode() {
                hitContext.hit().setDocumentField(NAME, hitField);
            }  
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
import static org.opensearch.transport.client.Requests.indexRequest;
    }
                @Override
@ClusterScope(scope = Scope.SUITE, supportsDedicatedMasters = false, numDataNodes = 2)
        return Arrays.asList(
        }
 * not use this file except in compliance with the License.
import java.util.Arrays;
import org.opensearch.core.xcontent.XContentParser;  
import org.opensearch.core.common.io.stream.StreamOutput;
        public List<FetchSubPhase> getFetchSubPhases(FetchPhaseConstructionContext context) {
            ((Map<String, Integer>) response.getHits().getAt(0).field("term_vectors_fetch").getValues().get(0)).get("am"),  
import org.apache.lucene.index.LeafReaderContext;  
    }
            );
                    hitExecute(searchContext, hitContext);  
            return new TermVectorsFetchBuilder(field);
import java.util.Collection;  
            }
            if (terms != null) {
            }
        private final String field;
import org.opensearch.action.search.SearchResponse;
                BytesRef term;
 * this work for additional information regarding copyright
            }
                PostingsEnum pe = null;  
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING;  
import org.opensearch.core.common.ParsingException;
                }
        public static TermVectorsFetchBuilder fromXContent(XContentParser parser) throws IOException {  
        public List<SearchExtSpec<?>> getSearchExts() {
 */
import org.opensearch.plugins.SearchPlugin;
        return Collections.singletonList(FetchTermVectorsPlugin.class);
                    .startObject("properties")
            Terms terms = hitContext.reader().termVectors().get(hitContext.docId(), field);
            .get();
public class FetchSubPhasePluginIT extends ParameterizedStaticSettingsOpenSearchIntegTestCase {  
            if (field == null) {
        private TermVectorsFetchBuilder(StreamInput in) throws IOException {
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.search.SearchExtBuilder;  
 * The OpenSearch Contributors require contributions made to  
            return Collections.singletonList(
            return singletonList(new TermVectorsFetchSubPhase());  
import java.util.Map;
import org.apache.lucene.util.BytesRef;
    }  
            equalTo(1)
        }
    protected Collection<Class<? extends Plugin>> nodePlugins() {  
import java.util.Collections;
        private String getField() {  
 * GitHub history for details.
                    .endObject()  
            .setMapping(  
            }  
/*  
            .indices()
    private static final class TermVectorsFetchSubPhase implements FetchSubPhase {
        );
                return;
        public void writeTo(StreamOutput out) throws IOException {  
            XContentParser.Token token = parser.currentToken();
        }
                public void setNextReader(LeafReaderContext readerContext) {  
        @Override
 * compatible open source license.
        SearchResponse response = client().prepareSearch()  
                throw new ParsingException(parser.getTokenLocation(), "no fields specified for " + TermVectorsFetchSubPhase.NAME);  
            if (fetchSubPhaseBuilder == null) {
        }
            if (o == null || getClass() != o.getClass()) {  
/*  
    public FetchSubPhasePluginIT(Settings staticSettings) {
            if (this == o) {  
