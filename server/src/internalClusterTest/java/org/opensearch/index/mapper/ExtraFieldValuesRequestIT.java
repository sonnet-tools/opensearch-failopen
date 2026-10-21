        ExtraFieldValues efv = new ExtraFieldValues(Map.of("field", FloatArrayValue.fromFloatArray(new float[] { 10.5f, 20.25f })));
                .source("{\"other\":\"y\"}", XContentType.JSON)
                .setMapping(
        assertThat(get.isExists(), is(true));
    public void testIndexRequestExtraFieldValues() throws Exception {
        IndexRequest req = new IndexRequest(index).id("1").source("{\"other\":\"x\"}", XContentType.JSON).extraFieldValues(efv);
    }
        assertAcked(
        refresh(index);
        String index = "test4";
        assertThat(get.getField("field_type").getValue().toString(), is("BYTES"));
 *
        );
        UpdateRequest ur = new UpdateRequest(index, "1").doc("{\"other\":\"x\"}", XContentType.JSON)
import org.opensearch.common.xcontent.XContentType;
                        .field("type", ExtraFieldValuesMapperPlugin.EXTRA_FIELDS_TEST)
        ExtraFieldValues efv = new ExtraFieldValues(Map.of("field", new BytesValue(new BytesArray(new byte[] { 9 }))));
        refresh(index);
        assertThat(get.isExists(), is(true));
 * The OpenSearch Contributors require contributions made to
                        .endObject()
        GetResponse g2 = client().prepareGet(index, "2").setStoredFields("field_type", "field_dim", "field_f0").get();
        GetResponse get = client().prepareGet(index, "1").setStoredFields("field_type", "field_dim", "field_f0").get();
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
/*
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
                        .field("store", true)
        assertTestMapping(this, index, settings);
            new IndexRequest(index).id("1")
        GetResponse get = client().prepareGet(index, "1").setStoredFields("field_type", "field_len").get();
        assertTestMapping(this, index, settings);
                        .field("type", "integer")
            testCase.prepareCreate(index)
import static org.hamcrest.Matchers.is;
        refresh(index);
        assertThat(get.getField("field_type").getValue().toString(), is("BYTES"));
        bulk.add(
        ExtraFieldValues efv = new ExtraFieldValues(Map.of("field", new BytesValue(new BytesArray(new byte[] { 1, 2, 3, 4 }))));
            .build();
            .upsertExtraFieldValues(efv);
import static org.hamcrest.Matchers.anyOf;
import org.opensearch.action.get.GetResponse;
        assertThat(resp.buildFailureMessage(), resp.hasFailures(), is(false));
        client().prepareIndex(index).setId("1").setSource("{\"other\":\"x\"}", XContentType.JSON).get();
                .get()
 * compatible open source license.
        Settings settings = Settings.builder()
        assertThat(((Number) get.getField("field_dim").getValue()).intValue(), is(2));
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
import org.opensearch.action.bulk.BulkResponse;
import org.opensearch.core.common.bytes.BytesArray;
                .source("{\"other\":\"x\"}", XContentType.JSON)
import org.opensearch.index.mapper.extrasource.FloatArrayValue;
                        .field("type", "float")
                        .endObject()
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        bulk.add(
        assertThat(((Number) get.getField("field_len").getValue()).intValue(), is(1));
import java.util.Collections;
                    jsonBuilder().startObject()
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 1)
        refresh(index);
                        .startObject("field_type")
        GetResponse get = client().prepareGet(index, "1").setStoredFields("field_type", "field_len").get();
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
    @Override
    protected Collection<Class<? extends Plugin>> nodePlugins() {
    }
            .build();
        assertThat(get.isExists(), is(true));
        client().update(ur).actionGet();
                        .startObject("field_dim")
                        .endObject()
        GetResponse g1 = client().prepareGet(index, "1").setStoredFields("field_type", "field_len").get();
                        .field("store", true)
import org.opensearch.common.settings.Settings;
    }
        DocWriteResponse resp = client().index(req).actionGet();
        );
 */
            .build();
        // create doc without "field"
import org.opensearch.cluster.metadata.IndexMetadata;
import org.opensearch.index.mapper.extrasource.ExtraFieldValuesMapperPlugin;
import org.opensearch.index.mapper.extrasource.BytesValue;
        assertThat(g1.getFields().keySet(), hasItems("field_type", "field_len"));
        String index = "test2";
        assertThat(get.getField("field_type").getValue().toString(), is("FLOAT_ARRAY"));
                        .endObject()
    public void testUpdateRequestUpsertExtraFieldValues() throws Exception {
            new IndexRequest(index).id("2")
                        .endObject()
    public void testUpdateRequestDocExtraFieldValues() throws Exception {
        assertEquals(3.0f, ((Number) g2.getField("field_f0").getValue()).floatValue(), 0.0f);
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        assertThat(resp.getResult(), anyOf(is(DocWriteResponse.Result.CREATED), is(DocWriteResponse.Result.UPDATED)));
        return Collections.singletonList(ExtraFieldValuesMapperPlugin.class);
                .extraFieldValues(new ExtraFieldValues(Map.of("field", FloatArrayValue.fromFloatArray(new float[] { 3.0f }))))
        Settings settings = Settings.builder()
        );
                        .endObject()
        Settings settings = Settings.builder()
import org.opensearch.action.index.IndexRequest;
                        .startObject("field_len")
import org.opensearch.action.update.UpdateRequest;
        assertThat(((Number) get.getField("field_len").getValue()).intValue(), is(4));
                )
        assertTestMapping(this, index, settings);
        refresh(index);
    }
import org.opensearch.index.mapper.extrasource.ExtraFieldValues;
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        assertThat(get.getFields().keySet(), hasItems("field_type", "field_dim", "field_f0"));
                        .startObject("field_f0")
    }
import java.util.Collection;
import java.util.Map;
        BulkRequest bulk = new BulkRequest();
                        .endObject()
        client().update(ur).actionGet();
public class ExtraFieldValuesRequestIT extends OpenSearchIntegTestCase {
                        .field("type", "keyword")
        assertTestMapping(this, index, settings);
        assertEquals(10.5f, ((Number) get.getField("field_f0").getValue()).floatValue(), 0.0f);
                        .field("store", true)
                .setSettings(settings)
        assertThat(g1.getField("field_type").getValue().toString(), is("BYTES"));
    private static void assertTestMapping(OpenSearchIntegTestCase testCase, String index, Settings settings) throws Exception {
                .extraFieldValues(new ExtraFieldValues(Map.of("field", new BytesValue(new BytesArray(new byte[] { 1, 2 })))))
package org.opensearch.index.mapper;
import org.opensearch.action.bulk.BulkRequest;
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
        BulkResponse resp = client().bulk(bulk).actionGet();
import org.opensearch.action.DocWriteResponse;
import org.opensearch.test.OpenSearchIntegTestCase;
                        .field("store", true)
        assertThat(g2.getFields().keySet(), hasItems("field_type", "field_dim", "field_f0"));
                        .field("type", "integer")
        assertThat(((Number) g2.getField("field_dim").getValue()).intValue(), is(1));
                        .startObject("field")
                        .startObject("properties")
 * SPDX-License-Identifier: Apache-2.0
        String index = "test3";
 * this file be licensed under the Apache-2.0 license or a
        Settings settings = Settings.builder()
        UpdateRequest ur = new UpdateRequest(index, "1").doc("{\"other\":\"y\"}", XContentType.JSON).docExtraFieldValues(efv);
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
}
            .upsert("{\"other\":\"x\"}", XContentType.JSON)
import static org.hamcrest.Matchers.hasItems;
        assertThat(((Number) g1.getField("field_len").getValue()).intValue(), is(2));
            .build();
    }
    public void testBulkIndexRequestCarriesExtraFieldValues() throws Exception {
        assertThat(get.getFields().keySet(), hasItems("field_type", "field_len"));
        String index = "test";
        assertThat(g2.getField("field_type").getValue().toString(), is("FLOAT_ARRAY"));
import org.opensearch.plugins.Plugin;
        assertThat(get.getFields().keySet(), hasItems("field_type", "field_len"));
