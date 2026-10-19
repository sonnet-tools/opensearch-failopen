                    .endObject()  
            .endObject()
        assertFalse("attributes.foo.foo.bar must not exist", fields.containsKey("attributes.foo.foo.bar"));
/*  
        // doc 1: creates the disable_objects leaf field  
            "doc-values-only field must not be searchable on a normal index",  
        assertTrue("expected attributes.foo.bar in field caps", fields.containsKey("attributes.foo.bar"));  
                    .startObject("foo")
                    .startObject()
            .endObject()  
    protected Collection<Class<? extends Plugin>> getPlugins() {
            .startObject()  
            client().admin()
    public void testFieldCapsNormalNestedObjectUnaffected() throws Exception {
        FieldCapabilitiesResponse pluggableResponse = client().fieldCaps(new FieldCapabilitiesRequest().fields("num").indices("pluggable"))  
        );
import org.opensearch.plugins.Plugin;
        client().prepareIndex("test")
            .setSource(  
        assertTrue(
            .field("type", "object")  
            .endObject()  
                    .endObject()
                .prepareCreate("pluggable")
    }
            .toString();
        return pluginList(InternalSettingsPlugin.class, MockDataFormatPlugin.class, MockCommitterEnginePlugin.class);
                XContentFactory.jsonBuilder()
    }
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;  
                    .endObject()
    // triggered by an unrelated document.  
        // phantom intermediate path has no ObjectMapper and must not exist  
        client().admin().indices().prepareRefresh("pluggable").get();
        assertEquals("object", fields.get("attributes").values().iterator().next().getType());
import org.opensearch.index.engine.dataformat.stub.MockCommitterEnginePlugin;  
            .startObject("attributes")
            pluggableResponse.get().get("num").get("long").isSearchable()
            .startObject()
import org.opensearch.test.InternalSettingsPlugin;  
        Map<String, Map<String, FieldCapabilities>> fields = response.get();
    // field "attributes.foo.bar". The intermediate path "attributes.foo" has no ObjectMapper and  
        assertFalse("attributes.foo should not exist in field caps", fields.containsKey("attributes.foo"));
        );
            .field("type", "long")
        assertTrue("expected user.address as object", fields.containsKey("user.address"));  
        String mapping = XContentFactory.jsonBuilder()  
    // field handling. Regular nested object fields (without disable_objects) must still produce the
    @Override  
    public void testFieldCapsDisableObjects() throws Exception {
    // so field caps must report searchable=true on a pluggable index and searchable=false otherwise.
            .setId("1")
            .startObject("properties")
    // name. Previously "attributes.foo.bar" became "attributes.foo.foo.bar" after a mapping merge
 * compatible open source license.
                .indices()  
            .field("disable_objects", true)
            .setSource(  
        // Pluggable indices are append-only, so a custom document id is rejected; let it auto-generate.
            .endObject()
        assertTrue("expected user as object", fields.containsKey("user"));
import org.opensearch.common.settings.Settings;
        assertAcked(client().admin().indices().prepareCreate("normal").setMapping(mapping));
    public void testSearchableReportedForDocValuesOnlyFieldOnPluggableIndex() throws Exception {
            .startObject("properties")
        // doc 2: unrelated - must not corrupt the existing mapping  
        assertEquals("object", fields.get("user.address").values().iterator().next().getType());
            .startObject("address")
        Map<String, Map<String, FieldCapabilities>> fields = response.get();
public class TransportFieldCapabilitiesIndexActionTests extends OpenSearchSingleNodeTestCase {
            .actionGet();
            .endObject()
    // Covers the pluggable branch in TransportFieldCapabilitiesIndexAction#shardOperation. A long  
        assertTrue("expected attributes in field caps", fields.containsKey("attributes"));
            .field("type", "keyword")  
                    .startObject("attributes")  
        assertAcked(client().admin().indices().prepareCreate("test").setMapping(mapping));
        assertTrue("expected attributes.foo.bar.keyword in field caps", fields.containsKey("attributes.foo.bar.keyword"));
            )  
        String mapping = XContentFactory.jsonBuilder()
        client().prepareIndex("test")  
        client().admin().indices().prepareRefresh("normal").get();
            .field("type", "object")  
package org.opensearch.action.fieldcaps;
    // The pluggable data format index needs a registered data format plus committer engine; without
                    .field("bar", "baz")
 */  
    @LockFeatureFlag(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG)  
import org.opensearch.index.engine.dataformat.stub.MockDataFormatPlugin;
                    .endObject()
    // a committer factory EngineConfigFactory rejects index creation when pluggable is enabled.
import org.opensearch.index.IndexSettings;
                    .endObject()
        client().prepareIndex("test").setId("2").setSource("{\"key\": 1}", MediaTypeRegistry.JSON).get();
            .toString();
 * The OpenSearch Contributors require contributions made to  
        client().prepareIndex("pluggable").setSource("{\"num\": 42}", MediaTypeRegistry.JSON).get();  
        assertTrue("expected attributes in field caps", fields.containsKey("attributes"));  
                    .startObject()
            .endObject()
import org.opensearch.common.xcontent.XContentFactory;  
        String mapping = XContentFactory.jsonBuilder()
            .startObject("city")
            .endObject()
            .get();
            .field("doc_values", true)  
            .endObject()
    }  
        Map<String, Map<String, FieldCapabilities>> fields = response.get();  
            .get();  
                    .field("bar", "baz")
        client().prepareIndex("test")
            .endObject()
        String mapping = XContentFactory.jsonBuilder()  
            .endObject()
            .endObject()
import org.opensearch.core.xcontent.MediaTypeRegistry;
        FieldCapabilitiesResponse response = client().fieldCaps(new FieldCapabilitiesRequest().fields("*").indices("test")).actionGet();
 *
        assertTrue("expected user.address.city", fields.containsKey("user.address.city"));
        assertEquals("object", fields.get("user").values().iterator().next().getType());  
            .endObject()  
        assertAcked(
        client().prepareIndex("normal").setSource("{\"num\": 42}", MediaTypeRegistry.JSON).get();  
            )  
        client().admin().indices().prepareRefresh("test").get();
            .endObject()  
            normalResponse.get().get("num").get("long").isSearchable()
            .get();
            .toString();  
        FieldCapabilitiesResponse normalResponse = client().fieldCaps(new FieldCapabilitiesRequest().fields("num").indices("normal"))  
            .endObject()
                XContentFactory.jsonBuilder()
 * SPDX-License-Identifier: Apache-2.0
                .setSettings(Settings.builder().put(IndexSettings.PLUGGABLE_DATAFORMAT_ENABLED_SETTING.getKey(), true))
            .actionGet();
            "doc-values-only field must be searchable on a pluggable index",  
        client().admin().indices().prepareRefresh("test").get();  
            .setId("1")
    // Regression test: the parentPath fix in ParametrizedFieldMapper must not break normal object
            .startObject("properties")
        FieldCapabilitiesResponse response = client().fieldCaps(new FieldCapabilitiesRequest().fields("*").indices("test")).actionGet();
        assertAcked(client().admin().indices().prepareCreate("test").setMapping(mapping));
        // Normal index: same mapping, no pluggable setting. The field stays non-searchable.
import java.util.Collection;  
            .startObject()
            .field("type", "object")
                    .startObject("foo")
        );
        assertFalse(
            .startObject("num")  
        assertTrue("expected key in field caps", fields.containsKey("key"));
            .field("disable_objects", true)
        FieldCapabilitiesResponse response = client().fieldCaps(new FieldCapabilitiesRequest().fields("*").indices("test")).actionGet();
            .startObject("attributes")  
            .endObject()
        assertTrue("expected attributes.foo.bar in field caps", fields.containsKey("attributes.foo.bar"));  
    // With disable_objects=true, {"attributes": {"foo": {"bar": "baz"}}} is flattened into the leaf
import java.util.Map;
        // A doc-values-only long: not indexed for search, but backed by doc values.
        client().admin().indices().prepareRefresh("test").get();  
    // correct parent entries in _field_caps.  
        assertAcked(client().admin().indices().prepareCreate("test").setMapping(mapping));
            .field("type", "object")  
    // with index:false, doc_values:true has isSearchable()==false but is searchable via doc values,
        // Pluggable index: doc values make the field searchable, so field caps must report true.  
import org.opensearch.test.OpenSearchSingleNodeTestCase;
    // Indexing a second document after a disable_objects field must not corrupt the flattened field
            .startObject("properties")
    }  
            .startObject("user")
            .startObject()  
 * this file be licensed under the Apache-2.0 license or a
            .endObject()  
    public void testFieldCapsDisableObjectsAfterUnrelatedDocument() throws Exception {
            .toString();
import org.opensearch.common.util.FeatureFlags;
                    .startObject("attributes")  
            .setSource("{\"user\":{\"address\":{\"city\":\"Chemnitz\"}}}", MediaTypeRegistry.JSON)
    }
            .setId("1")
                .setMapping(mapping)  
            .startObject("properties")
                    .endObject()  
            .startObject("properties")
    // _field_caps must not silently return empty results when walking the parent chain.
            .field("index", false)
}
