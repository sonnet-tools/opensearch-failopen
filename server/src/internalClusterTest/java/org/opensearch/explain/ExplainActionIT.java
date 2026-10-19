            .get();
            .get();
import org.opensearch.index.query.TermsQueryBuilder;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        assertThat(response.getId(), equalTo("1"));  
        // read
        assertThat(fields, equalTo(singleton("obj1.field1")));
        ExplainResponse response = client().prepareExplain(indexOrAlias(), "1")
        createIndex("test");
        assertThat(((Map<String, Object>) response.getGetResult().getSource().get("obj1")).get("field1").toString(), equalTo("value1"));  
        assertThat(explainResponse.isExists(), equalTo(true));  
import java.util.Map;
        assertThat(response.getId(), equalTo("1"));  
        assertThat(response.getExplanation().getValue(), equalTo(1.0f));  
            .setQuery(QueryBuilders.matchAllQuery())
        response = client().prepareExplain(indexOrAlias(), "2").setQuery(QueryBuilders.matchAllQuery()).get();
        ByteArrayOutputStream outBuffer = new ByteArrayOutputStream();  
        assertAcked(prepareCreate("test").addAlias(new Alias("alias")).setSettings(Settings.builder().put("index.refresh_interval", -1)));
        assertTrue(response.getExplanation().isMatch());
        ExplainResponse response = client().prepareExplain(indexOrAlias(), "1")  
        fields = new HashSet<>(response.getGetResult().getFields().keySet());  
    public void testQueryRewrite() {
            .setSource(  
import java.time.ZonedDateTime;
        ExplainResponse response = client().prepareExplain(indexOrAlias(), "1").setQuery(QueryBuilders.matchAllQuery()).get();
        assertTrue(response.isMatch());  
        ExplainResponse response = client().prepareExplain("alias1", "1").setQuery(QueryBuilders.matchAllQuery()).get();  
            .setStoredFields("obj1.field1", "obj1.field2")
        assertTrue(response.isMatch());  
        assertFalse(response.isMatch());  
        assertThat(response.getExplanation().getDetails().length, equalTo(2));  
        assertThat(response.getIndex(), equalTo("test"));  
        ExplainResponse response = client().prepareExplain("twitter", "1").setQuery(termsLookupQuery).get();
        assertNotNull(response);
        refresh();
        client().prepareIndex("test")
                .prepareCreate("test")
        assertThat(response.getGetResult().isExists(), equalTo(true));
 * the Apache License, Version 2.0 (the "License"); you may
        assertThat(response.getIndex(), equalTo("test"));
        Lucene.writeExplanation(out, exp);
        ensureGreen("test");
 *
import org.opensearch.action.explain.ExplainResponse;  
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_SHARDS;
        assertThat(response.getIndex(), equalTo("test"));
import static java.util.Collections.singleton;
        assertThat(response.getIndex(), equalTo("twitter"));
/*
    }  
        assertThat(response.getGetResult().getSource(), notNullValue());
        assertNotNull(response);  
        assertAcked(prepareCreate("test").addAlias(new Alias("alias")));
            .get();
            .prepareCreate("twitter")
 * GitHub history for details.
 * this file be licensed under the Apache-2.0 license or a
            .setFetchSource(null, "obj1.field2")
            .setQuery(QueryBuilders.matchAllQuery())  
            .setQuery(QueryBuilders.matchAllQuery())  
import java.io.ByteArrayInputStream;
 * specific language governing permissions and limitations
    public void testExplainWithFields() throws Exception {
        ZonedDateTime now = ZonedDateTime.now(ZoneOffset.UTC);  
        client().prepareIndex("test").setId("1").setSource("field1", "value1", "field2", "value1").get();  
            .setSource(
        assertTrue(response.isMatch());
        assertThat(response.getGetResult().isSourceEmpty(), equalTo(false));  
 *    http://www.apache.org/licenses/LICENSE-2.0
        assertThat(response.getGetResult().isExists(), equalTo(true));
        InputStreamStreamInput esBuffer = new InputStreamStreamInput(esInBuffer);  
        String v2 = response.getGetResult().field("obj1.field2").getValue();  
        assertThat(response.getGetResult().getFields().get("obj1.field1").getValue().toString(), equalTo("value1"));
        assertAcked(
        exp = Explanation.match(2.0f, "some explanation", Explanation.match(2.0f, "another explanation"));
        refresh();
        assertTrue(response.isExists());  
        Lucene.writeExplanation(out, exp);
        assertNotNull(response);  
        assertThat(exp.toString(), equalTo(result.toString()));
        assertTrue(response.isExists());
        response = client().prepareExplain(indexOrAlias(), "1")  
        );  
            )  
            .get();
        assertThat(response.getGetResult().getId(), equalTo("1"));
        assertThat(exp.toString(), equalTo(result.toString()));  
        refresh();  
import org.opensearch.common.lucene.Lucene;
        assertThat(response.getExplanation().getValue(), equalTo(1.0f));
/*  
import org.opensearch.common.settings.Settings;
        outBuffer = new ByteArrayOutputStream();
        assertThat(response.getGetResult().getSource().size(), equalTo(1));
import org.opensearch.indices.TermsLookup;
 * Modifications Copyright OpenSearch Contributors. See
import static org.opensearch.index.query.QueryBuilders.queryStringQuery;
        assertThat(explainResponse.isMatch(), equalTo(true));
        assertFalse(response.isMatch());
        ensureGreen("test");  
            )
            .setQuery(
    }  
            .setStoredFields("obj1.field1")  
        String aMonthFromNow = DateTimeFormatter.ISO_LOCAL_DATE.format(now.plusMonths(1));
    }
public class ExplainActionIT extends OpenSearchIntegTestCase {  
 */  
        esInBuffer = new ByteArrayInputStream(outBuffer.toByteArray());
                .setMapping("field2", "type=text")
        assertTrue(response.isExists());  
package org.opensearch.explain;
        assertFalse(response.getExplanation().isMatch());
        response = client().prepareExplain(indexOrAlias(), "1").setQuery(QueryBuilders.termQuery("field", "value2")).get();  
    public void testExplainDateRangeInQueryString() {  
            .get();
        assertThat(response.getGetResult().getId(), equalTo("1"));
        assertNotNull(response);
        assertThat(((Map<String, Object>) response.getGetResult().getSource().get("obj1")).get("field1").toString(), equalTo("value1"));
        assertTrue(response.isMatch());
        assertTrue(response.isExists());
        response = client().prepareExplain(indexOrAlias(), "1").setQuery(QueryBuilders.matchAllQuery()).get();  
        ExplainResponse response = client().prepareExplain("alias1", "1")
        response = client().prepareExplain(indexOrAlias(), "1")
 *  
                .indices()  
 * not use this file except in compliance with the License.
        assertNotNull(response);
                QueryBuilders.boolQuery().must(QueryBuilders.termQuery("field", "value1")).must(QueryBuilders.termQuery("field", "value2"))
            prepareCreate("test").setMapping("obj1.field1", "type=keyword,store=true", "obj1.field2", "type=keyword,store=true")  
            client().admin()
        assertThat(response.getGetResult().isExists(), equalTo(true));  
        assertThat(response.getIndex(), equalTo("test"));  
        assertThat(v1, equalTo("value1"));
        assertNotNull(response);  
            )  
        assertThat(v2, equalTo("value2"));
        assertThat(response.getIndex(), equalTo("test"));
            .setMapping("user", "type=integer", "followers", "type=integer")  
            .setQuery(QueryBuilders.matchAllQuery())
 * The OpenSearch Contributors require contributions made to  
        assertNotNull(response);
        assertThat(response.getExplanation().getValue(), equalTo(1.0f));  
 * ownership. Elasticsearch licenses this file to you under  
        response = client().prepareExplain(indexOrAlias(), "1")  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
        assertThat(response.getGetResult().getFields().get("obj1.field1").getValue().toString(), equalTo("value1"));
        // write
        String aMonthAgo = DateTimeFormatter.ISO_LOCAL_DATE.format(now.minusMonths(1));
import org.apache.lucene.search.Explanation;
        assertFalse(response.isExists()); // not a match b/c not realtime  
        assertThat(response.getGetResult().getId(), equalTo("1"));
            .setId("1")  
        assertThat(response.getId(), equalTo("2"));
        client().prepareIndex("test").setId("1").setSource("field1", "value1", "field2", "value1").get();
            .setQuery(QueryBuilders.matchAllQuery())
 * this work for additional information regarding copyright
        assertNotNull(response.getExplanation());
import org.opensearch.index.query.QueryBuilders;
import org.opensearch.action.admin.indices.alias.Alias;
 * software distributed under the License is distributed on an
import org.opensearch.core.common.io.stream.OutputStreamStreamOutput;
        assertTrue(response.isMatch());
        );
        client().prepareIndex("test").setId("1").setSource("past", aMonthAgo, "future", aMonthFromNow).get();
    @SuppressWarnings("unchecked")
    }  
        client().admin()  
        assertThat(response.getIndex(), equalTo("test"));
        assertFalse(response.isMatch());
        assertThat(response.getId(), equalTo("1"));
        assertThat(response.getId(), equalTo("1"));  
            .get();  
        client().prepareIndex("twitter").setId("1").setSource("followers", new int[] { 1, 2, 3 }).get();  
        // write complex
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;  
        assertFalse(response.getExplanation().isMatch());
        ExplainResponse explainResponse = client().prepareExplain("test", "1").setQuery(queryStringQuery("past:[now-2M/d TO now/d]")).get();
        assertThat(response.getGetResult().isSourceEmpty(), equalTo(true));  
import static org.hamcrest.Matchers.equalTo;  
        assertFalse(response.isExists());
import java.time.format.DateTimeFormatter;
            .setFetchSource("obj1.field1", null)
        client().prepareIndex("test").setId("1").setSource("field", "value1").get();
        assertNotNull(response.getExplanation());
            .get();  
                .addAlias(new Alias("alias1").filter(QueryBuilders.termQuery("field2", "value2")))
    }
        assertAcked(  
            .setFetchSource(true)  
        assertFalse(response.isMatch());  
        assertTrue(response.getExplanation().isMatch());
            .setStoredFields("obj1.field1")
    public void testExplainWithFilteredAlias() {
        assertTrue(response.isMatch());
    }  
 * You may obtain a copy of the License at  
 */
        ensureGreen("test");
        assertThat(response.getId(), equalTo("1"));
    public void testExplainWithSource() throws Exception {  
 * license agreements. See the NOTICE file distributed with
        String v1 = response.getGetResult().field("obj1.field1").getValue();
                .addAlias(new Alias("alias"))
        assertThat(response.getGetResult().getId(), equalTo("1"));
        return randomBoolean() ? "test" : "alias";
        assertNotNull(response.getExplanation());
/*  
 * SPDX-License-Identifier: Apache-2.0
        refresh();
            .get();
    public void testExplainWithFilteredAliasFetchSource() throws Exception {  
            .get();
        refresh();  
        refresh();
        assertNotNull(response);
        assertNotNull(response);  
 *
    public void testStreamExplain() throws Exception {
        ensureGreen("test");
        assertThat(response.getGetResult(), notNullValue());
        refresh();
        );
import java.time.ZoneOffset;  
 */  
        assertTrue(response.getExplanation().isMatch());
        assertFalse(response.isMatch()); // not a match b/c not realtime  
        assertThat(response.getGetResult().getIndex(), equalTo("test"));  
            .setSettings(Settings.builder().put(SETTING_NUMBER_OF_SHARDS, 2).put("index.number_of_routing_shards", 2))
 * compatible open source license.
 * under the License.  
        assertNotNull(response);
                jsonBuilder().startObject().startObject("obj1").field("field1", "value1").field("field2", "value2").endObject().endObject()
        ByteArrayInputStream esInBuffer = new ByteArrayInputStream(outBuffer.toByteArray());
        assertThat(fields, equalTo(singleton("obj1.field1")));
    private static String indexOrAlias() {
        assertNotNull(response.getExplanation());  
 * Licensed to Elasticsearch under one or more contributor  
import java.util.Set;
            .get();
        OutputStreamStreamOutput out = new OutputStreamStreamOutput(outBuffer);
import org.opensearch.core.common.io.stream.InputStreamStreamInput;  
import org.opensearch.test.OpenSearchIntegTestCase;
import java.io.ByteArrayOutputStream;
        assertFalse(response.isMatch());
import java.util.HashSet;  
}
                jsonBuilder().startObject().startObject("obj1").field("field1", "value1").field("field2", "value2").endObject().endObject()
        assertNotNull(response);
 * Unless required by applicable law or agreed to in writing,
        assertAcked(
    }  
        out = new OutputStreamStreamOutput(outBuffer);  
                .addAlias(new Alias("alias1").filter(QueryBuilders.termQuery("field2", "value2")))  
        result = Lucene.readExplanation(esBuffer);
        assertFalse(response.isMatch());
            .setId("1")
        assertNotNull(response);
        refresh();
        ensureGreen("test");  
        assertFalse(response.getExplanation().isMatch());
            .setQuery(QueryBuilders.matchAllQuery())
        Set<String> fields = new HashSet<>(response.getGetResult().getFields().keySet());  
        client().prepareIndex("test")
        assertThat(response.getId(), equalTo("1"));
    public void testSimple() throws Exception {
        assertTrue(response.isExists());
            prepareCreate("test").setMapping("field2", "type=text")
        assertThat((String) response.getGetResult().getSource().get("field1"), equalTo("value1"));  
        TermsQueryBuilder termsLookupQuery = QueryBuilders.termsLookupQuery("user", new TermsLookup("twitter", "1", "followers"));  
        assertNotNull(response.getExplanation());  
            .indices()
        // read complex  
        assertNotNull(response);
        Explanation result = Lucene.readExplanation(esBuffer);
        assertNotNull(response.getExplanation());  
        assertTrue(response.getExplanation().isMatch());
        Explanation exp = Explanation.match(2f, "some explanation");  
            .setFetchSource(true)  
    }
        response = client().prepareExplain(indexOrAlias(), "1")
 * KIND, either express or implied.  See the License for the
        esBuffer = new InputStreamStreamInput(esInBuffer);
    }
import static org.hamcrest.Matchers.notNullValue;
        assertNotNull(response.getExplanation());
        assertThat(response.getExplanation().getValue(), equalTo(1.0f));
