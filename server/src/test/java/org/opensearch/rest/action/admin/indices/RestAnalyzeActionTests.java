        ) {
            }
        }
                    .startObject()
            )
 * specific language governing permissions and limitations
 *
                    .field("type", "stop")
 * GitHub history for details.
import org.opensearch.core.common.bytes.BytesArray;
            );
    public void testParseXContentForAnalyzeRequest() throws Exception {
            );
    }
import org.opensearch.index.analysis.NameOrDefinition;
            assertThat(e.getMessage(), containsString("unknown field [filters]"));
                    .field("tokenizer", "keyword")
    }
            assertThat(e.getMessage(), containsString("unknown field [token_filters]"));
 *
 *
 * ownership. Elasticsearch licenses this file to you under
            assertThat(analyzeRequest.tokenFilters().size(), equalTo(2));
                XContentFactory.jsonBuilder()
            for (NameOrDefinition filter : analyzeRequest.tokenFilters()) {
        }
                XContentFactory.jsonBuilder()
                XContentFactory.jsonBuilder()
import org.opensearch.transport.client.node.NodeClient;
                    .value("lowercase")
                    .startObject()
                    .array("token_filter", "lowercase")
            XContentParser invalidExplain = createParser(XContentFactory.jsonBuilder().startObject().field("explain", "fals").endObject())
            XContentParser content = createParser(
                    .field("text", "THIS IS A TEST")
            assertThat(e.getMessage(), containsString("unknown field [unknown]"));
                    .array("filters", "lowercase")
        try (NodeClient client = new NoOpNodeClient(this.getClass().getSimpleName())) {
                    .array("filter", "lowercase")
                    .startObject()
                    .array("stopwords", "foo", "buzz")
                    .endObject()
                assertThat(filter.name, equalTo("lowercase"));
        ) {
                XContentFactory.jsonBuilder()
import static org.hamcrest.Matchers.containsString;
            IOException e = expectThrows(IOException.class, () -> action.handleRequest(request, null, client));
    public void testParseXContentForAnalyzeRequestWithCustomFilters() throws Exception {
                IllegalArgumentException.class,
        }
        try (
                IllegalArgumentException.class,
            assertThat(analyzeRequest.text().length, equalTo(1));
        }
                    .startObject()
 */
            XContentParser parser = createParser(
                    .field("tokenizer", "keyword")
            IllegalArgumentException e = expectThrows(
public class RestAnalyzeActionTests extends OpenSearchTestCase {
            IllegalArgumentException e = expectThrows(
        }
                    .field("tokenizer", "keyword")
            assertThat(analyzeRequest.tokenFilters().size(), equalTo(1));
            assertThat(e.getMessage(), containsString("failed to parse field [explain]"));
 * this work for additional information regarding copyright
                    .field("tokenizer", "keyword")
                    .endObject()
    }
        try (
            assertThat(analyzeRequest.charFilters().get(0).definition, notNullValue());
            assertThat(e.getMessage(), containsString("normalizer doesn't support values of type: VALUE_BOOLEAN"));
 * You may obtain a copy of the License at
                    .endArray()
                IllegalArgumentException.class,
 * KIND, either express or implied.  See the License for the
 *    http://www.apache.org/licenses/LICENSE-2.0
        }
            assertThat(analyzeRequest.normalizer(), equalTo("normalizer"));
        try (
            assertThat(e.getMessage(), containsString("unknown field [token_filter]"));
import java.io.IOException;
            )
            AnalyzeAction.Request analyzeRequest = AnalyzeAction.Request.fromXContent(content, "for test");
            )
            assertThat(analyzeRequest.charFilters().size(), equalTo(1));
                    .startArray("filter")
import org.opensearch.common.xcontent.XContentFactory;
        ) {
                IllegalArgumentException.class,
import org.opensearch.rest.RestRequest;
import org.opensearch.test.client.NoOpNodeClient;
        ) {
        ) {
                    .array("token_filters", "lowercase")
package org.opensearch.rest.action.admin.indices;
            assertThat(analyzeRequest.text().length, equalTo(1));
            XContentParser parser = createParser(
                XContentFactory.jsonBuilder()
    }
            assertThat(analyzeRequest.tokenizer().name, equalTo("keyword"));
                    .endObject()
                () -> AnalyzeAction.Request.fromXContent(invalidContent, "for test")
    public void testParseXContentForAnalyzeRequestWithInvalidNormalizerThrowsException() throws Exception {
        try (
                    .field("text", "THIS IS A TEST")
            AnalyzeAction.Request analyzeRequest = AnalyzeAction.Request.fromXContent(content, "for test");
                    .endArray()
 * this file be licensed under the Apache-2.0 license or a
                XContentFactory.jsonBuilder()
            IllegalArgumentException e = expectThrows(
            assertThat(analyzeRequest.tokenizer().name, equalTo("keyword"));
            );
import org.opensearch.test.OpenSearchTestCase;
                () -> AnalyzeAction.Request.fromXContent(invalidExplain, "for test")
            MediaTypeRegistry.JSON
                () -> AnalyzeAction.Request.fromXContent(parser, "for test")
    }
                    .endObject()
import org.opensearch.test.rest.FakeRestRequest;
                    .field("text", "THIS IS A TEST")
        try (
        }
                    .startObject()
        try (
        ) {
 * compatible open source license.
            new BytesArray("{invalid_json}"),
 * not use this file except in compliance with the License.
                    .field("type", "mapping")
    public void testParseXContentForAnalyzeRequestWithInvalidJsonThrowsException() {
            );
                    .array("mappings", "ph => f", "qu => q")
 * software distributed under the License is distributed on an
 * SPDX-License-Identifier: Apache-2.0
                IllegalArgumentException.class,
        }
                IllegalArgumentException.class,
            assertThat(analyzeRequest.text(), equalTo(new String[] { "THIS IS A TEST" }));
            );
            IllegalArgumentException e = expectThrows(
        ).build();
 * Modifications Copyright OpenSearch Contributors. See
                () -> AnalyzeAction.Request.fromXContent(parser, "for test")
import static org.hamcrest.Matchers.notNullValue;
}
        }
import org.opensearch.action.admin.indices.analyze.AnalyzeAction;
 * The OpenSearch Contributors require contributions made to
            XContentParser invalidContent = createParser(
                    .endObject()
                    .startObject()
            XContentParser invalidExplain = createParser(XContentFactory.jsonBuilder().startObject().field("normalizer", true).endObject())
/*
/*
import org.opensearch.core.xcontent.XContentParser;
                    .field("tokenizer", "keyword")
 * license agreements. See the NOTICE file distributed with
 * the Apache License, Version 2.0 (the "License"); you may
            XContentParser content = createParser(
            IllegalArgumentException e = expectThrows(
        try (
            )
        ) {
                    .endObject()
        RestRequest request = new FakeRestRequest.Builder(xContentRegistry()).withContent(
            IllegalArgumentException e = expectThrows(
                () -> AnalyzeAction.Request.fromXContent(invalidExplain, "for test")
                IllegalArgumentException.class,
            )
                    .endObject()
import org.opensearch.core.xcontent.MediaTypeRegistry;
            );
            )
            assertThat(e.getMessage(), containsString("expecting double-quote"));
                    .field("text", "THIS IS A TEST")
                    .endObject()
            assertThat(analyzeRequest.tokenFilters().get(0).name, equalTo("lowercase"));
 */
                    .array("char_filters", "lowercase")
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            XContentParser parser = createParser(
                    .startObject()
        try (
import static org.hamcrest.Matchers.equalTo;
/*
                    .field("normalizer", "normalizer")
            assertThat(analyzeRequest.text(), equalTo(new String[] { "THIS IS A TEST" }));
                    .field("text", "THIS IS A TEST")
    public void testParseXContentForAnalyzeRequestWithUnknownParamThrowsException() throws Exception {
            IllegalArgumentException e = expectThrows(
 * Licensed to Elasticsearch under one or more contributor
        try (
    }
 * Unless required by applicable law or agreed to in writing,
                () -> AnalyzeAction.Request.fromXContent(parser, "for test")
        ) {
        RestAnalyzeAction action = new RestAnalyzeAction();
    }
            assertThat(analyzeRequest.tokenFilters().get(1).definition, notNullValue());
 * under the License.
                XContentFactory.jsonBuilder().startObject().field("text", "THIS IS A TEST").field("unknown", "keyword").endObject()
        ) {
    public void testParseXContentForAnalyzeRequestWithInvalidStringExplainParamThrowsException() throws Exception {
                    .field("tokenizer", "keyword")
            );
            assertThat(e.getMessage(), containsString("unknown field [char_filters]"));
 */
                    .startArray("char_filter")
                    .field("text", "THIS IS A TEST")
        }
            XContentParser parser = createParser(
    public void testDeprecatedParamIn2xException() throws Exception {
                    .startObject()
            )
                () -> AnalyzeAction.Request.fromXContent(parser, "for test")
