            () -> createMapperService(pluggableSettings(), template(m -> m.field("type", "geo_point").field("multi_value", true)))
        DocumentMapper mapper = createMapperService(pluggableSettings(), nameTemplate()).documentMapper();
    public void testRejectedForGeoPointOnPluggableIndex() {
        for (boolean multiValue : new boolean[] { true, false }) {  
    }
    }
            b.field("match", "attrs");
                + "\"type\":\"flat_object\"}}], caused by [Unused mapping attributes [{multi_value=true}]]"  
    public void testNameTemplateIgnoredAtDocumentTimeOnVanillaIndex() throws IOException {  
        );
    private XContentBuilder nameTemplate() throws IOException {
    }  
        assertWarnings(
    }
import org.opensearch.common.CheckedConsumer;
import java.io.IOException;  
                MapperParsingException.class,
    }
            b.startObject("mapping");
    @LockFeatureFlag(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG)
                containsString("dynamic template [tmpl] maps to type [flat_object], which does not support [multi_value]")
    private XContentBuilder template(CheckedConsumer<XContentBuilder, IOException> mapping) throws IOException {
 * this file be licensed under the Apache-2.0 license or a
        }  
        MapperParsingException e = expectThrows(
        DocumentMapper mapper = createMapperService(nameTemplate()).documentMapper();
        assertWarnings(
 * SPDX-License-Identifier: Apache-2.0
public class DynamicTemplateMultiValueTests extends MapperServiceTestCase {
    public void testNameTemplateRejectedAtDocumentTimeOnPluggableIndex() throws IOException {  
            template(m -> m.field("type", "keyword").field("multi_value", true))
    /** On a vanilla index multi_value is an unknown key like any other: deprecation warning only. */
    }
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.common.util.FeatureFlags;  
                    pluggableSettings(),
    private Settings pluggableSettings() {  
/*  
import org.opensearch.common.settings.Settings;
                    template(m -> m.field("type", "flat_object").field("multi_value", multiValue))
            MapperParsingException e = expectThrows(
        createMapperService(pluggableSettings(), template(m -> m.field("type", "keyword").field("multi_value", true).field("foo", "bar")));  
            );
            "dynamic template [tmpl] has invalid content [{\"match\":\"attrs\",\"mapping\":{\"multi_value\":true,"
    }
        );
        );
        });  
    public void testOnlyWarnsOnVanillaIndex() throws IOException {
                )  
    /** A {name} template is not checked at creation, so the unsupported multi_value is rejected when a document uses it. */
            () -> mapper.parse(source(b -> b.startObject("attrs").field("env", "prod").endObject()), new CapturingDocumentInput())
import org.opensearch.core.xcontent.XContentBuilder;
 */  
            b.endObject();
    public void testOtherInvalidParameterStillOnlyWarns() throws IOException {
        assertThat(e.getMessage(), containsString("maps to type [geo_point], which does not support [multi_value]"));  
        return Settings.builder().put(getIndexSettings()).put("index.pluggable.dataformat.enabled", true).build();
            "dynamic template [tmpl] has invalid content [{\"match\":\"attrs\",\"mapping\":{\"foo\":\"bar\",\"multi_value\":true,"
            );
    }
    /** An invalid sibling parameter is still only a warning, not reported as a multi_value error. */  
            b.startArray("dynamic_templates").startObject().startObject("tmpl");  
 *
            b.endObject().endObject().endArray();
            containsString("dynamic template [tmpl] maps to type [flat_object], which does not support [multi_value]")
    }
        return topMapping(b -> {
            pluggableSettings(),  
            MapperParsingException.class,  
    @LockFeatureFlag(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG)
        MapperService mapperService = createMapperService(
    public void testAcceptedForKeywordOnPluggableIndex() throws IOException {
        assertThat(mapperService.documentMapper().mappingSource().toString(), containsString("\"multi_value\":true"));  
        );
 * compatible open source license.
    @LockFeatureFlag(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG)  
/** Validation of {@code multi_value} in dynamic templates, on pluggable data format and vanilla indices. */
            assertThat(
        assertThat(  
                e.getMessage(),  
        MapperParsingException e = expectThrows(
    @LockFeatureFlag(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG)  
        return template(m -> m.field("type", "flat_object").field("multi_value", true).field("copy_to", "{name}_all"));  
        createMapperService(template(m -> m.field("type", "flat_object").field("multi_value", true)));  
    }
                () -> createMapperService(  
            mapping.accept(b);  
            e.getMessage(),
    @LockFeatureFlag(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG)
                + "\"type\":\"keyword\"}}], caused by [unknown parameter [foo] on mapper [__dynamic__tmpl] of type [keyword]]"  
import static org.hamcrest.Matchers.containsString;
package org.opensearch.index.mapper;
    public void testRejectedForFlatObjectOnPluggableIndex() throws IOException {
        );  
}
            MapperParsingException.class,  
        mapper.parse(source(b -> b.startObject("attrs").field("env", "prod").endObject()));
        );
