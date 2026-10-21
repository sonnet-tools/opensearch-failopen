            b.endObject();
        assertThat(doc.rootDoc().getField("field.text.raw"), notNullValue());
        assertThat(doc.rootDoc().getField("field.bool").stringValue(), is("T"));
        assertThat(point.lat(), closeTo(42.0, 1e-5));
import org.apache.lucene.index.IndexableField;
import java.util.Collection;
import org.opensearch.common.geo.GeoPoint;
                        {
        assertThat(doc.rootDoc().getField("field.point"), notNullValue());
 * ownership. Elasticsearch licenses this file to you under
        assertThat(doc.rootDoc().getField("field.point"), notNullValue());
        assertThat(field, notNullValue());
        assertThat(doc.rootDoc().getField("field.bool"), notNullValue());
        GeoPoint point = new GeoPoint().resetFromIndexableField(doc.rootDoc().getField("field.point"));
import static org.hamcrest.Matchers.notNullValue;
            "At least one multi-field, [text], was "
 * KIND, either express or implied.  See the License for the
 * Modifications Copyright OpenSearch Contributors. See
                    b.endObject();
                        b.endObject();
        assertThat(raw.binaryValue(), is(new BytesRef("foo")));
                    {
        }));
 * not use this file except in compliance with the License.
                b.endObject();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        assertThat(doc.rootDoc().getField("field.text.raw").stringValue(), is("foo"));
        assertThat(raw, notNullValue());
        assertThat(doc.rootDoc().getField("field.text"), notNullValue());
 * SPDX-License-Identifier: Apache-2.0
                b.startObject("raw").field("type", "text").endObject();
                            b.field("type", "keyword");
 * Licensed to Elasticsearch under one or more contributor
 * the Apache License, Version 2.0 (the "License"); you may
        assertThat(doc.rootDoc().getField("field.raw").stringValue(), is("foo"));
            b.field("type", ExternalMapperPlugin.EXTERNAL);
        ParsedDocument doc = documentMapper.parse(source(b -> b.field("field", "1234")));
        assertWarnings(
 * this work for additional information regarding copyright
            {
        GeoPoint point = new GeoPoint().resetFromIndexableField(doc.rootDoc().getField("field.point"));
                + "encountered that itself contains a multi-field. Defining multi-fields within a multi-field is deprecated and will "
        IndexableField shape = doc.rootDoc().getField("field.shape");
        DocumentMapper documentMapper = createDocumentMapper(fieldMapping(b -> b.field("type", "external")));
                    }
        );
 *
                + "switching to [copy_to] if appropriate."
        assertThat(doc.rootDoc().getField("field.raw"), notNullValue());
                    b.field("type", "text");
 * this file be licensed under the Apache-2.0 license or a
        DocumentMapper documentMapper = createDocumentMapper(fieldMapping(b -> {
                b.startObject("text");
        assertWarnings(
 */
                    }
        assertThat(doc.rootDoc().getField("field.bool"), notNullValue());
    }
            b.endObject();
        assertThat(doc.rootDoc().getField(ExternalMetadataMapper.FIELD_NAME).stringValue(), is(ExternalMetadataMapper.FIELD_VALUE));
        DocumentMapper documentMapper = createDocumentMapper(fieldMapping(b -> {
                        b.startObject("generated").field("type", ExternalMapperPlugin.EXTERNAL_BIS).endObject();
        IndexableField raw = doc.rootDoc().getField("field.text.raw");
                + "should be removed from the mappings, either by flattening the chained [fields] blocks into a single level, or "
 */
    public void testExternalValues() throws Exception {
    public void testExternalValuesWithMultifield() throws Exception {
        assertThat(field.stringValue(), is("foo"));
                        b.startObject("raw").field("type", "text").endObject();
/*
                    b.startObject("fields");
        assertThat(doc.rootDoc().getField("field.bool"), notNullValue());
        assertThat(point.lat(), closeTo(42.0, 1E-5));
            }
        assertThat(doc.rootDoc().getField("field.shape"), notNullValue());
 *
                + "encountered that itself contains a multi-field. Defining multi-fields within a multi-field is deprecated and will "
        );
 * Unless required by applicable law or agreed to in writing,
                }
        return Collections.singletonList(new ExternalMapperPlugin());
    }
            b.startObject("fields");
 * software distributed under the License is distributed on an
            {
    public void testExternalValuesWithMultifieldTwoLevels() throws Exception {
import static org.hamcrest.Matchers.closeTo;
        ParsedDocument doc = documentMapper.parse(source(b -> b.field("field", "1234")));
 * license agreements. See the NOTICE file distributed with
                + "no longer be supported in 8.0. To resolve the issue, all instances of [fields] that occur within a [fields] block "
 *     http://www.apache.org/licenses/LICENSE-2.0
 * compatible open source license.
 * You may obtain a copy of the License at
                    {
 * The OpenSearch Contributors require contributions made to
        assertThat(shape, notNullValue());
        assertThat(doc.rootDoc().getField("field.text.generated.generated"), notNullValue());
                {
 *
                {
import java.util.Collections;
        assertThat(doc.rootDoc().getField("field.point"), notNullValue());
                + "no longer be supported in 8.0. To resolve the issue, all instances of [fields] that occur within a [fields] block "
        assertThat(doc.rootDoc().getField("field.bool").stringValue(), is("T"));
import static org.hamcrest.Matchers.is;
            b.field("type", ExternalMapperPlugin.EXTERNAL);
        IndexableField field = doc.rootDoc().getField("field.text");
                b.endObject();
                }
                    b.startObject("fields");
        assertThat(doc.rootDoc().getField("field.field"), notNullValue());
package org.opensearch.index.mapper;
        }));
    protected Collection<? extends Plugin> getPlugins() {
                    b.field("store", true);
        assertThat(doc.rootDoc().getField("field.field").stringValue(), is("foo"));
        assertThat(doc.rootDoc().getField("field.text.generated.generated").stringValue(), is("bar"));
                    b.endObject();
                + "should be removed from the mappings, either by flattening the chained [fields] blocks into a single level, or "
import org.opensearch.plugins.Plugin;
}
 * specific language governing permissions and limitations
public class ExternalFieldMapperTests extends MapperServiceTestCase {
/*
 */
                    b.field("type", "text");
 * GitHub history for details.
        ParsedDocument doc = documentMapper.parse(source(b -> b.field("field", "1234")));
            b.startObject("fields");
        assertThat(doc.rootDoc().getField("field.shape"), notNullValue());
import org.apache.lucene.util.BytesRef;
        assertThat(point.lon(), closeTo(51.0, 1e-5));
                + "switching to [copy_to] if appropriate."
                        b.startObject("raw");
 * under the License.
    }
    }
                            b.field("store", true);
/*
        assertThat(doc.rootDoc().getField("field.text").stringValue(), is("foo"));
            }
    @Override
            "At least one multi-field, [text], was "
                        }
        assertThat(doc.rootDoc().getField("field.bool").stringValue(), is("T"));
        assertThat(point.lon(), closeTo(51.0, 1E-5));
                b.startObject("text");
