import org.opensearch.index.engine.dataformat.stub.MockCommitterEnginePlugin;
        FieldCapabilitiesResponse pluggableResponse = client().fieldCaps(new FieldCapabilitiesRequest().fields("num").indices("pluggable"))
    // field "attributes.foo.bar". The intermediate path "attributes.foo" has no ObjectMapper and
            .toString();
        assertEquals("object", fields.get("attributes").values().iterator().next().getType());
            .field("disable_objects", true)
            .setId("1")
            .startObject()
            "doc-values-only field must not be searchable on a normal index",
                    .endObject()
        FieldCapabilitiesResponse normalResponse = client().fieldCaps(new FieldCapabilitiesRequest().fields("num").indices("normal"))
        Map<String, Map<String, FieldCapabilities>> fields = response.get();
 * The OpenSearch Contributors require contributions made to
import org.opensearch.index.engine.dataformat.stub.MockDataFormatPlugin;
                    .endObject()
        assertAcked(client().admin().indices().prepareCreate("test").setMapping(mapping));
        client().prepareIndex("test")
        // phantom intermediate path has no ObjectMapper and must not exist
        assertEquals("object", fields.get("user").values().iterator().next().getType());
        // doc 1: creates the disable_objects leaf field
 */
    // The pluggable data format index needs a registered data format plus committer engine; without
        assertEquals("object", fields.get("user.address").values().iterator().next().getType());
            .actionGet();
            .actionGet();
        assertTrue("expected attributes.foo.bar in field caps", fields.containsKey("attributes.foo.bar"));
        // Normal index: same mapping, no pluggable setting. The field stays non-searchable.
            .field("type", "object")
    public void testSearchableReportedForDocValuesOnlyFieldOnPluggableIndex() throws Exception {
 *
            .field("disable_objects", true)
            .startObject("num")
                    .endObject()
public class TransportFieldCapabilitiesIndexActionTests extends OpenSearchSingleNodeTestCase {
            .endObject()
        assertFalse("attributes.foo should not exist in field caps", fields.containsKey("attributes.foo"));
    // with index:false, doc_values:true has isSearchable()==false but is searchable via doc values,
            .endObject()
        );
            .setId("1")
            .endObject()
            .startObject("properties")
            .setId("1")
        Map<String, Map<String, FieldCapabilities>> fields = response.get();
        assertTrue("expected attributes.foo.bar in field caps", fields.containsKey("attributes.foo.bar"));
    public void testFieldCapsDisableObjects() throws Exception {
            .startObject("attributes")
            .endObject()
    @Override
            .startObject("city")
        assertTrue("expected user.address as object", fields.containsKey("user.address"));
            .toString();
            .setSource("{\"user\":{\"address\":{\"city\":\"Chemnitz\"}}}", MediaTypeRegistry.JSON)
        FieldCapabilitiesResponse response = client().fieldCaps(new FieldCapabilitiesRequest().fields("*").indices("test")).actionGet();
            .field("type", "keyword")
    // correct parent entries in _field_caps.
        assertTrue("expected attributes in field caps", fields.containsKey("attributes"));
import org.opensearch.common.settings.Settings;
 * SPDX-License-Identifier: Apache-2.0
            .toString();
            .setSource(
import org.opensearch.core.xcontent.MediaTypeRegistry;
        assertAcked(client().admin().indices().prepareCreate("test").setMapping(mapping));
            .endObject()
        assertTrue("expected user.address.city", fields.containsKey("user.address.city"));
                    .startObject()
            .setSource(
    }
            normalResponse.get().get("num").get("long").isSearchable()
    }
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
import org.opensearch.plugins.Plugin;
            pluggableResponse.get().get("num").get("long").isSearchable()
    // _field_caps must not silently return empty results when walking the parent chain.
        client().admin().indices().prepareRefresh("test").get();
    // a committer factory EngineConfigFactory rejects index creation when pluggable is enabled.
            .endObject()
            .startObject("properties")
        client().prepareIndex("test")
                .indices()
    // Indexing a second document after a disable_objects field must not corrupt the flattened field
    // so field caps must report searchable=true on a pluggable index and searchable=false otherwise.
            .startObject("properties")
    public void testFieldCapsNormalNestedObjectUnaffected() throws Exception {
                    .startObject("foo")
    // triggered by an unrelated document.
        client().prepareIndex("normal").setSource("{\"num\": 42}", MediaTypeRegistry.JSON).get();
            .get();
    // With disable_objects=true, {"attributes": {"foo": {"bar": "baz"}}} is flattened into the leaf
            .startObject()
import org.opensearch.test.OpenSearchSingleNodeTestCase;
            .startObject("properties")
        // doc 2: unrelated - must not corrupt the existing mapping
    }
        // Pluggable indices are append-only, so a custom document id is rejected; let it auto-generate.
        assertAcked(
                    .startObject("attributes")
            .endObject()
            .field("index", false)
            .startObject()
        client().admin().indices().prepareRefresh("test").get();
        );
        // A doc-values-only long: not indexed for search, but backed by doc values.
            .get();
            .get();
            .startObject("attributes")
    protected Collection<Class<? extends Plugin>> getPlugins() {
    // field handling. Regular nested object fields (without disable_objects) must still produce the
        String mapping = XContentFactory.jsonBuilder()
            .endObject()
/*
        String mapping = XContentFactory.jsonBuilder()
            )
            .startObject("properties")
            .endObject()
                XContentFactory.jsonBuilder()
        assertTrue(
                    .endObject()
            .endObject()
            .endObject()
        client().admin().indices().prepareRefresh("pluggable").get();
                    .endObject()
            .startObject("address")
            .field("type", "long")
    @LockFeatureFlag(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG)
        String mapping = XContentFactory.jsonBuilder()
                    .startObject()
    // Regression test: the parentPath fix in ParametrizedFieldMapper must not break normal object
        client().prepareIndex("pluggable").setSource("{\"num\": 42}", MediaTypeRegistry.JSON).get();
        assertTrue("expected user as object", fields.containsKey("user"));
            .endObject()
}
        client().admin().indices().prepareRefresh("normal").get();
        String mapping = XContentFactory.jsonBuilder()
            )
        // Pluggable index: doc values make the field searchable, so field caps must report true.
            .toString();
        assertAcked(client().admin().indices().prepareCreate("test").setMapping(mapping));
        FieldCapabilitiesResponse response = client().fieldCaps(new FieldCapabilitiesRequest().fields("*").indices("test")).actionGet();
 * this file be licensed under the Apache-2.0 license or a
            .field("type", "object")
        FieldCapabilitiesResponse response = client().fieldCaps(new FieldCapabilitiesRequest().fields("*").indices("test")).actionGet();
                    .startObject("attributes")
            .startObject()
                .prepareCreate("pluggable")
            .endObject()
    // Covers the pluggable branch in TransportFieldCapabilitiesIndexAction#shardOperation. A long
            .endObject()
import java.util.Collection;
import org.opensearch.test.InternalSettingsPlugin;
        );
            client().admin()
package org.opensearch.action.fieldcaps;
                XContentFactory.jsonBuilder()
        assertAcked(client().admin().indices().prepareCreate("normal").setMapping(mapping));
        assertTrue("expected attributes.foo.bar.keyword in field caps", fields.containsKey("attributes.foo.bar.keyword"));
import org.opensearch.index.IndexSettings;
        client().prepareIndex("test")
        assertFalse("attributes.foo.foo.bar must not exist", fields.containsKey("attributes.foo.foo.bar"));
            "doc-values-only field must be searchable on a pluggable index",
                    .endObject()
            .field("type", "object")
        assertTrue("expected attributes in field caps", fields.containsKey("attributes"));
            .endObject()
            .startObject("user")
import org.opensearch.common.xcontent.XContentFactory;
    // name. Previously "attributes.foo.bar" became "attributes.foo.foo.bar" after a mapping merge
        return pluginList(InternalSettingsPlugin.class, MockDataFormatPlugin.class, MockCommitterEnginePlugin.class);
                .setMapping(mapping)
        client().prepareIndex("test").setId("2").setSource("{\"key\": 1}", MediaTypeRegistry.JSON).get();
                    .field("bar", "baz")
            .field("type", "object")
    public void testFieldCapsDisableObjectsAfterUnrelatedDocument() throws Exception {
            .field("doc_values", true)
import java.util.Map;
        assertFalse(
        client().admin().indices().prepareRefresh("test").get();
        Map<String, Map<String, FieldCapabilities>> fields = response.get();
    }
import org.opensearch.common.util.FeatureFlags;
                    .startObject("foo")
                .setSettings(Settings.builder().put(IndexSettings.PLUGGABLE_DATAFORMAT_ENABLED_SETTING.getKey(), true))
 * compatible open source license.
        assertTrue("expected key in field caps", fields.containsKey("key"));
            .startObject("properties")
            .endObject()
    }
                    .field("bar", "baz")
