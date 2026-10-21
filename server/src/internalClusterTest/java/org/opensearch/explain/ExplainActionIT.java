        ExplainResponse response = client().prepareExplain("twitter", "1").setQuery(termsLookupQuery).get();
        assertTrue(response.isMatch());
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_SHARDS;
        Explanation result = Lucene.readExplanation(esBuffer);
 */
            .get();
 * Modifications Copyright OpenSearch Contributors. See
        response = client().prepareExplain(indexOrAlias(), "1")
 *
            .setFetchSource(true)
                jsonBuilder().startObject().startObject("obj1").field("field1", "value1").field("field2", "value2").endObject().endObject()
        assertThat(response.getGetResult().getFields().get("obj1.field1").getValue().toString(), equalTo("value1"));
        InputStreamStreamInput esBuffer = new InputStreamStreamInput(esInBuffer);
    }
        assertFalse(response.isMatch());
        client().prepareIndex("test")
        assertAcked(
        client().prepareIndex("test").setId("1").setSource("field1", "value1", "field2", "value1").get();
        assertFalse(response.isMatch());
        assertNotNull(response.getExplanation());
        assertAcked(
            .setMapping("user", "type=integer", "followers", "type=integer")
        response = client().prepareExplain(indexOrAlias(), "1").setQuery(QueryBuilders.termQuery("field", "value2")).get();
import static org.opensearch.index.query.QueryBuilders.queryStringQuery;
import java.util.Map;
        client().prepareIndex("test").setId("1").setSource("field1", "value1", "field2", "value1").get();
 * You may obtain a copy of the License at
        refresh();
        assertThat((String) response.getGetResult().getSource().get("field1"), equalTo("value1"));
import static org.hamcrest.Matchers.notNullValue;
 * ownership. Elasticsearch licenses this file to you under
    }
            .setFetchSource("obj1.field1", null)
            .get();
        Lucene.writeExplanation(out, exp);
        assertNotNull(response);
        assertNotNull(response);
            .get();
        assertNotNull(response);
            prepareCreate("test").setMapping("obj1.field1", "type=keyword,store=true", "obj1.field2", "type=keyword,store=true")
            .get();
        assertThat(response.getId(), equalTo("1"));
                .prepareCreate("test")
        assertNotNull(response);
/*
        assertThat(response.getExplanation().getValue(), equalTo(1.0f));
            .setStoredFields("obj1.field1")
        assertNotNull(response.getExplanation());
 * not use this file except in compliance with the License.
 *    http://www.apache.org/licenses/LICENSE-2.0
 * the Apache License, Version 2.0 (the "License"); you may
        assertThat(response.getId(), equalTo("1"));
            .get();
 * The OpenSearch Contributors require contributions made to
            prepareCreate("test").setMapping("field2", "type=text")
        assertThat(response.getGetResult().getSource().size(), equalTo(1));
        assertThat(exp.toString(), equalTo(result.toString()));
        assertAcked(prepareCreate("test").addAlias(new Alias("alias")).setSettings(Settings.builder().put("index.refresh_interval", -1)));
            .setQuery(QueryBuilders.matchAllQuery())
                .addAlias(new Alias("alias1").filter(QueryBuilders.termQuery("field2", "value2")))
        refresh();
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
    public void testQueryRewrite() {
        assertNotNull(response);
            )
        assertTrue(response.isMatch());
        assertTrue(response.isExists());
        assertThat(response.getGetResult().isExists(), equalTo(true));
import java.time.ZonedDateTime;
    public void testExplainWithSource() throws Exception {
        assertAcked(prepareCreate("test").addAlias(new Alias("alias")));
        exp = Explanation.match(2.0f, "some explanation", Explanation.match(2.0f, "another explanation"));
    public void testSimple() throws Exception {
 *
import java.time.format.DateTimeFormatter;
        assertFalse(response.isExists()); // not a match b/c not realtime
        assertNotNull(response);
        ensureGreen("test");
        assertNotNull(response.getExplanation());
        assertTrue(response.isMatch());
import org.opensearch.test.OpenSearchIntegTestCase;
        assertTrue(response.isMatch());
        assertFalse(response.isMatch());
        assertThat(response.getExplanation().getValue(), equalTo(1.0f));
 * this work for additional information regarding copyright
            .setStoredFields("obj1.field1")
import static java.util.Collections.singleton;
    }
        assertThat(explainResponse.isMatch(), equalTo(true));
        // read
        String v1 = response.getGetResult().field("obj1.field1").getValue();
        refresh();
        assertThat(response.getGetResult().getId(), equalTo("1"));
    public void testStreamExplain() throws Exception {
        assertTrue(response.getExplanation().isMatch());
        esInBuffer = new ByteArrayInputStream(outBuffer.toByteArray());
        refresh();
        client().prepareIndex("test").setId("1").setSource("field", "value1").get();
        assertThat(response.getIndex(), equalTo("test"));
        assertNotNull(response);
        esBuffer = new InputStreamStreamInput(esInBuffer);
        response = client().prepareExplain(indexOrAlias(), "1")
        assertThat(response.getIndex(), equalTo("twitter"));
        fields = new HashSet<>(response.getGetResult().getFields().keySet());
public class ExplainActionIT extends OpenSearchIntegTestCase {
        assertThat(response.getGetResult().getSource(), notNullValue());
            .get();
            .setQuery(QueryBuilders.matchAllQuery())
    private static String indexOrAlias() {
        // read complex
            )
        assertThat(response.getId(), equalTo("1"));
        Set<String> fields = new HashSet<>(response.getGetResult().getFields().keySet());
        TermsQueryBuilder termsLookupQuery = QueryBuilders.termsLookupQuery("user", new TermsLookup("twitter", "1", "followers"));
        client().prepareIndex("test")
    public void testExplainDateRangeInQueryString() {
    }
        response = client().prepareExplain(indexOrAlias(), "2").setQuery(QueryBuilders.matchAllQuery()).get();
        assertFalse(response.getExplanation().isMatch());
import org.apache.lucene.search.Explanation;
        assertTrue(response.getExplanation().isMatch());
        assertTrue(response.isMatch());
import java.io.ByteArrayInputStream;
    }
import java.util.HashSet;
        assertThat(response.getGetResult().getIndex(), equalTo("test"));
            .setStoredFields("obj1.field1", "obj1.field2")
        ensureGreen("test");
        assertThat(v2, equalTo("value2"));
import org.opensearch.action.admin.indices.alias.Alias;
 * license agreements. See the NOTICE file distributed with
        assertThat(v1, equalTo("value1"));
        assertThat(response.getExplanation().getValue(), equalTo(1.0f));
 * Unless required by applicable law or agreed to in writing,
            .setQuery(QueryBuilders.matchAllQuery())
        assertThat(((Map<String, Object>) response.getGetResult().getSource().get("obj1")).get("field1").toString(), equalTo("value1"));
        assertNotNull(response);
        refresh();
        assertFalse(response.isMatch());
            .get();
    @SuppressWarnings("unchecked")
        assertThat(response.getGetResult().isSourceEmpty(), equalTo(true));
        assertFalse(response.getExplanation().isMatch());
        response = client().prepareExplain(indexOrAlias(), "1").setQuery(QueryBuilders.matchAllQuery()).get();
        assertThat(response.getGetResult().getId(), equalTo("1"));
        assertTrue(response.isExists());
            .setId("1")
        return randomBoolean() ? "test" : "alias";
        assertNotNull(response);
package org.opensearch.explain;
        assertFalse(response.isExists());
 *
        assertTrue(response.getExplanation().isMatch());
                QueryBuilders.boolQuery().must(QueryBuilders.termQuery("field", "value1")).must(QueryBuilders.termQuery("field", "value2"))
        ensureGreen("test");
        assertThat(response.getId(), equalTo("1"));
        assertThat(response.getGetResult(), notNullValue());
        Lucene.writeExplanation(out, exp);
        client().admin()
            .setQuery(
        assertThat(response.getGetResult().getFields().get("obj1.field1").getValue().toString(), equalTo("value1"));
import org.opensearch.index.query.QueryBuilders;
            .setSource(
        assertNotNull(response.getExplanation());
        assertNotNull(response.getExplanation());
        result = Lucene.readExplanation(esBuffer);
            )
        ExplainResponse response = client().prepareExplain("alias1", "1")
        assertThat(response.getId(), equalTo("1"));
            .get();
 * specific language governing permissions and limitations
            .get();
        );
        ExplainResponse response = client().prepareExplain(indexOrAlias(), "1")
 * SPDX-License-Identifier: Apache-2.0
import java.io.ByteArrayOutputStream;
        assertFalse(response.isMatch());
        assertTrue(response.isMatch());
        assertThat(response.getGetResult().getId(), equalTo("1"));
        ExplainResponse response = client().prepareExplain(indexOrAlias(), "1").setQuery(QueryBuilders.matchAllQuery()).get();
        // write
            .indices()
 * this file be licensed under the Apache-2.0 license or a
        assertThat(response.getIndex(), equalTo("test"));
}
import org.opensearch.action.explain.ExplainResponse;
            .setSettings(Settings.builder().put(SETTING_NUMBER_OF_SHARDS, 2).put("index.number_of_routing_shards", 2))
        assertThat(response.getExplanation().getValue(), equalTo(1.0f));
        assertThat(fields, equalTo(singleton("obj1.field1")));
            .setQuery(QueryBuilders.matchAllQuery())
        Explanation exp = Explanation.match(2f, "some explanation");
            .setSource(
            .setFetchSource(true)
        refresh();
        ExplainResponse explainResponse = client().prepareExplain("test", "1").setQuery(queryStringQuery("past:[now-2M/d TO now/d]")).get();
                .setMapping("field2", "type=text")
        assertThat(response.getIndex(), equalTo("test"));
        assertThat(fields, equalTo(singleton("obj1.field1")));
            .setQuery(QueryBuilders.matchAllQuery())
        assertTrue(response.isExists());
 * KIND, either express or implied.  See the License for the
        assertFalse(response.isMatch()); // not a match b/c not realtime
 * Licensed to Elasticsearch under one or more contributor
    public void testExplainWithFilteredAliasFetchSource() throws Exception {
        assertNotNull(response.getExplanation());
        );
/*
 */
        assertNotNull(response.getExplanation());
        assertTrue(response.getExplanation().isMatch());
        assertThat(response.getExplanation().getDetails().length, equalTo(2));
import org.opensearch.common.settings.Settings;
        ByteArrayOutputStream outBuffer = new ByteArrayOutputStream();
            .setQuery(QueryBuilders.matchAllQuery())
        assertNotNull(response);
    }
        assertThat(response.getGetResult().isExists(), equalTo(true));
        assertThat(response.getIndex(), equalTo("test"));
import org.opensearch.core.common.io.stream.InputStreamStreamInput;
import java.util.Set;
 * software distributed under the License is distributed on an
        assertThat(exp.toString(), equalTo(result.toString()));
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        ByteArrayInputStream esInBuffer = new ByteArrayInputStream(outBuffer.toByteArray());
 * GitHub history for details.
            .setFetchSource(null, "obj1.field2")
import java.time.ZoneOffset;
        ExplainResponse response = client().prepareExplain(indexOrAlias(), "1")
        assertAcked(
        refresh();
                .addAlias(new Alias("alias"))
            .get();
        ensureGreen("test");
        assertThat(response.getId(), equalTo("2"));
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
        refresh();
        outBuffer = new ByteArrayOutputStream();
        ensureGreen("test");
        out = new OutputStreamStreamOutput(outBuffer);
        assertThat(response.getIndex(), equalTo("test"));
            .setId("1")
    }
import org.opensearch.index.query.TermsQueryBuilder;
            client().admin()
        assertTrue(response.isExists());
        assertTrue(response.isExists());
        String v2 = response.getGetResult().field("obj1.field2").getValue();
    }
        assertThat(response.getGetResult().isSourceEmpty(), equalTo(false));
    }
        assertFalse(response.isMatch());
        String aMonthFromNow = DateTimeFormatter.ISO_LOCAL_DATE.format(now.plusMonths(1));
        ZonedDateTime now = ZonedDateTime.now(ZoneOffset.UTC);
        assertFalse(response.getExplanation().isMatch());
 */
        response = client().prepareExplain(indexOrAlias(), "1")
import org.opensearch.common.lucene.Lucene;
        assertThat(response.getIndex(), equalTo("test"));
        OutputStreamStreamOutput out = new OutputStreamStreamOutput(outBuffer);
        createIndex("test");
                .indices()
            .prepareCreate("twitter")
        assertNotNull(response);
        client().prepareIndex("test").setId("1").setSource("past", aMonthAgo, "future", aMonthFromNow).get();
        // write complex
        response = client().prepareExplain(indexOrAlias(), "1")
        String aMonthAgo = DateTimeFormatter.ISO_LOCAL_DATE.format(now.minusMonths(1));
                jsonBuilder().startObject().startObject("obj1").field("field1", "value1").field("field2", "value2").endObject().endObject()
import org.opensearch.core.common.io.stream.OutputStreamStreamOutput;
        client().prepareIndex("twitter").setId("1").setSource("followers", new int[] { 1, 2, 3 }).get();
        assertNotNull(response);
        );
        assertThat(explainResponse.isExists(), equalTo(true));
import org.opensearch.indices.TermsLookup;
        assertThat(response.getGetResult().isExists(), equalTo(true));
        ExplainResponse response = client().prepareExplain("alias1", "1").setQuery(QueryBuilders.matchAllQuery()).get();
    public void testExplainWithFields() throws Exception {
/*
        assertNotNull(response);
        assertThat(response.getGetResult().getId(), equalTo("1"));
        assertThat(((Map<String, Object>) response.getGetResult().getSource().get("obj1")).get("field1").toString(), equalTo("value1"));
 * compatible open source license.
    public void testExplainWithFilteredAlias() {
                .addAlias(new Alias("alias1").filter(QueryBuilders.termQuery("field2", "value2")))
 * under the License.
import static org.hamcrest.Matchers.equalTo;
        assertThat(response.getId(), equalTo("1"));
