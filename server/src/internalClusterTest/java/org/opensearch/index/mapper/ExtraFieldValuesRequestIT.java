        assertThat(g2.getFields().keySet(), hasItems("field_type", "field_dim", "field_f0"));
                .extraFieldValues(new ExtraFieldValues(Map.of("field", new BytesValue(new BytesArray(new byte[] { 1, 2 })))))
                        .endObject()
        refresh(index);
    protected Collection<Class<? extends Plugin>> nodePlugins() {
                        .startObject("properties")  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
    }
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)  
        UpdateRequest ur = new UpdateRequest(index, "1").doc("{\"other\":\"y\"}", XContentType.JSON).docExtraFieldValues(efv);
import java.util.Map;
        UpdateRequest ur = new UpdateRequest(index, "1").doc("{\"other\":\"x\"}", XContentType.JSON)
 *
                .source("{\"other\":\"x\"}", XContentType.JSON)  
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
            .build();
            new IndexRequest(index).id("2")
    @Override
        String index = "test4";
    public void testBulkIndexRequestCarriesExtraFieldValues() throws Exception {
        assertAcked(
        Settings settings = Settings.builder()
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
        refresh(index);  
import org.opensearch.action.get.GetResponse;
        return Collections.singletonList(ExtraFieldValuesMapperPlugin.class);  
    public void testIndexRequestExtraFieldValues() throws Exception {  
        );
    }  
                        .field("type", "integer")  
        assertThat(get.getField("field_type").getValue().toString(), is("BYTES"));  
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
 * The OpenSearch Contributors require contributions made to  
        assertThat(get.getField("field_type").getValue().toString(), is("BYTES"));
                        .endObject()  
        assertThat(((Number) get.getField("field_len").getValue()).intValue(), is(1));
 * compatible open source license.
        assertThat(get.isExists(), is(true));
                )
    }  
        assertEquals(3.0f, ((Number) g2.getField("field_f0").getValue()).floatValue(), 0.0f);
                        .field("type", "float")
        GetResponse get = client().prepareGet(index, "1").setStoredFields("field_type", "field_len").get();
        ExtraFieldValues efv = new ExtraFieldValues(Map.of("field", new BytesValue(new BytesArray(new byte[] { 1, 2, 3, 4 }))));  
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)  
 * this file be licensed under the Apache-2.0 license or a
            testCase.prepareCreate(index)
            .build();
import org.opensearch.action.bulk.BulkRequest;
                        .field("type", "integer")
        bulk.add(
                        .field("store", true)
                .setSettings(settings)  
                        .field("type", "keyword")
        assertThat(g1.getFields().keySet(), hasItems("field_type", "field_len"));  
                        .endObject()  
import org.opensearch.action.index.IndexRequest;
        BulkResponse resp = client().bulk(bulk).actionGet();
                        .startObject("field_type")  
import org.opensearch.core.common.bytes.BytesArray;
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.action.bulk.BulkResponse;  
        client().update(ur).actionGet();  
import static org.hamcrest.Matchers.hasItems;
        assertTestMapping(this, index, settings);  
                .source("{\"other\":\"y\"}", XContentType.JSON)  
        GetResponse get = client().prepareGet(index, "1").setStoredFields("field_type", "field_len").get();  
        DocWriteResponse resp = client().index(req).actionGet();
            .upsert("{\"other\":\"x\"}", XContentType.JSON)  
        // create doc without "field"
                .extraFieldValues(new ExtraFieldValues(Map.of("field", FloatArrayValue.fromFloatArray(new float[] { 3.0f }))))
import org.opensearch.index.mapper.extrasource.FloatArrayValue;
        String index = "test";  
    }
/*  
import org.opensearch.index.mapper.extrasource.BytesValue;
        assertThat(g2.getField("field_type").getValue().toString(), is("FLOAT_ARRAY"));  
import org.opensearch.action.update.UpdateRequest;  
        );
import static org.hamcrest.Matchers.anyOf;  
        assertTestMapping(this, index, settings);
        Settings settings = Settings.builder()  
import static org.hamcrest.Matchers.is;
        assertThat(get.getFields().keySet(), hasItems("field_type", "field_dim", "field_f0"));  
        assertEquals(10.5f, ((Number) get.getField("field_f0").getValue()).floatValue(), 0.0f);  
                .setMapping(
public class ExtraFieldValuesRequestIT extends OpenSearchIntegTestCase {
                        .field("type", ExtraFieldValuesMapperPlugin.EXTRA_FIELDS_TEST)  
        bulk.add(
                        .startObject("field_dim")
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 1)
}
import java.util.Collections;
        refresh(index);  
        refresh(index);
        GetResponse get = client().prepareGet(index, "1").setStoredFields("field_type", "field_dim", "field_f0").get();  
            new IndexRequest(index).id("1")
import org.opensearch.common.settings.Settings;
                        .startObject("field_f0")  
                        .startObject("field_len")
        assertThat(((Number) g1.getField("field_len").getValue()).intValue(), is(2));
        Settings settings = Settings.builder()
            .build();
    public void testUpdateRequestDocExtraFieldValues() throws Exception {
        assertThat(((Number) get.getField("field_dim").getValue()).intValue(), is(2));
        assertThat(get.isExists(), is(true));
        refresh(index);  
        assertThat(g1.getField("field_type").getValue().toString(), is("BYTES"));
            .upsertExtraFieldValues(efv);
        assertThat(get.isExists(), is(true));
        assertTestMapping(this, index, settings);
        assertThat(resp.getResult(), anyOf(is(DocWriteResponse.Result.CREATED), is(DocWriteResponse.Result.UPDATED)));
    public void testUpdateRequestUpsertExtraFieldValues() throws Exception {  
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        GetResponse g2 = client().prepareGet(index, "2").setStoredFields("field_type", "field_dim", "field_f0").get();
        assertThat(resp.buildFailureMessage(), resp.hasFailures(), is(false));
                        .field("store", true)
                        .endObject()  
        IndexRequest req = new IndexRequest(index).id("1").source("{\"other\":\"x\"}", XContentType.JSON).extraFieldValues(efv);
        client().update(ur).actionGet();  
        assertThat(((Number) g2.getField("field_dim").getValue()).intValue(), is(1));
import org.opensearch.index.mapper.extrasource.ExtraFieldValues;  
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
        assertThat(get.getFields().keySet(), hasItems("field_type", "field_len"));  
import org.opensearch.action.DocWriteResponse;
 */  
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
                        .field("store", true)  
        Settings settings = Settings.builder()
            .build();  
        BulkRequest bulk = new BulkRequest();
import org.opensearch.test.OpenSearchIntegTestCase;
package org.opensearch.index.mapper;
                        .field("store", true)
    }
        String index = "test2";
        String index = "test3";  
        ExtraFieldValues efv = new ExtraFieldValues(Map.of("field", FloatArrayValue.fromFloatArray(new float[] { 10.5f, 20.25f })));
                .get()
import org.opensearch.index.mapper.extrasource.ExtraFieldValuesMapperPlugin;
        ExtraFieldValues efv = new ExtraFieldValues(Map.of("field", new BytesValue(new BytesArray(new byte[] { 9 }))));  
                        .endObject()
        assertThat(get.getField("field_type").getValue().toString(), is("FLOAT_ARRAY"));
                        .endObject()
                        .endObject()
import java.util.Collection;  
        client().prepareIndex(index).setId("1").setSource("{\"other\":\"x\"}", XContentType.JSON).get();
                    jsonBuilder().startObject()
        );  
                        .startObject("field")
import org.opensearch.cluster.metadata.IndexMetadata;
        assertThat(((Number) get.getField("field_len").getValue()).intValue(), is(4));
import org.opensearch.plugins.Plugin;  
import org.opensearch.common.xcontent.XContentType;  
        assertTestMapping(this, index, settings);
    private static void assertTestMapping(OpenSearchIntegTestCase testCase, String index, Settings settings) throws Exception {  
        assertThat(get.getFields().keySet(), hasItems("field_type", "field_len"));
        GetResponse g1 = client().prepareGet(index, "1").setStoredFields("field_type", "field_len").get();
    }
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)  
