 * The OpenSearch Contributors require contributions made to  
        );
    @Override
import org.opensearch.core.xcontent.XContentBuilder;  
            "[rank_features] fields take hashes that map a feature to a strictly positive float, but got unexpected token " + "START_ARRAY",
            MapperParsingException.class,  
    @Override
 * license agreements. See the NOTICE file distributed with
 * GitHub history for details.
        for (IndexableField field : fields) {
import org.hamcrest.Matchers;
        FeatureField featureField1 = null;
    }
                b.startObject().startObject("field").field("bar", 10).endObject().endObject();
    }
    @Override  
            {
 *
        );
    }
 * Licensed to Elasticsearch under one or more contributor  
                featureField2 = (FeatureField) field;
import java.util.Arrays;
        return false;  
    }  
                throw new UnsupportedOperationException();
 * KIND, either express or implied.  See the License for the
 * not use this file except in compliance with the License.
 * You may obtain a copy of the License at  
        int freq1 = RankFeatureFieldMapperTests.getFrequency(featureField1.tokenStream(null, null));
        FeatureField featureField2 = (FeatureField) fields[1];
 */
import org.apache.lucene.index.IndexableField;
import java.util.List;
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
    }
package org.opensearch.index.mapper;
        IndexableField[] fields = doc1.rootDoc().getFields("field");  
            }
    @Override
 * compatible open source license.
        IllegalArgumentException iae = expectThrows(IllegalArgumentException.class, () -> super.assertExistsQuery(mapperService));  
        e = expectThrows(MapperParsingException.class, () -> mapper.parse(source(b -> {
        DocumentMapper mapper = createDocumentMapper(mapping(b -> {
            e.getCause().getMessage()
        );  
 * this file be licensed under the Apache-2.0 license or a
            b.startObject("field").field("type", "rank_features").endObject();  
            "[rank_features] fields do not support indexing multiple values for the same rank feature [foo.field.bar] in "
 *  
 * Modifications Copyright OpenSearch Contributors. See
        assertThat(featureField1.stringValue(), Matchers.equalTo("foo"));
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 */  
        MapperParsingException e = expectThrows(
}
        assertTrue(freq1 > freq2);
        ParsedDocument doc1 = mapper.parse(source(this::writeField));  
        int freq2 = RankFeatureFieldMapperTests.getFrequency(featureField2.tokenStream(null, null));  
        assertEquals(  
                featureField1 = (FeatureField) field;  
    public void testRejectMultiValuedFields() throws MapperParsingException, IOException {
/*  
            () -> mapper.parse(source(b -> b.startObject("field").field("foo", Arrays.asList(10, 20)).endObject()))
                + "the same document",  
        int freq1 = RankFeatureFieldMapperTests.getFrequency(featureField1.tokenStream(null, null));
/*
 * ownership. Elasticsearch licenses this file to you under  
 * Unless required by applicable law or agreed to in writing,
            fieldMapping(b -> b.field("type", "rank_features").field("positive_score_impact", false))  
        assertThat(fields[0], Matchers.instanceOf(FeatureField.class));
    protected void minimalMapping(XContentBuilder b) throws IOException {
    }
            if (field.stringValue().equals("foo")) {
    protected void assertExistsQuery(MapperService mapperService) {
        assertThat(featureField2.stringValue(), Matchers.equalTo("bar"));  
    public void testDefaults() throws Exception {  
import org.apache.lucene.document.FeatureField;
 */  
        DocumentMapper mapper = createDocumentMapper(fieldMapping(this::minimalMapping));
        int freq2 = RankFeatureFieldMapperTests.getFrequency(featureField2.tokenStream(null, null));  
        FeatureField featureField2 = null;  
    @Override
 * software distributed under the License is distributed on an
public class RankFeaturesFieldMapperTests extends MapperTestCase {  
            }
 * SPDX-License-Identifier: Apache-2.0
        ParsedDocument doc1 = mapper.parse(source(this::writeField));
        DocumentMapper mapper = createDocumentMapper(
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.plugins.Plugin;
    }
import java.util.Collection;  
        b.field("type", "rank_features");
            b.endArray();
            b.startArray("foo");  
/*  
    }
        checker.registerConflictCheck("positive_score_impact", b -> b.field("positive_score_impact", false));
    @Override
        }));  
        assertEquals(
            e.getCause().getMessage()
        assertEquals(2, fields.length);
        assertThat(fields[0], Matchers.instanceOf(FeatureField.class));
 * specific language governing permissions and limitations
 * under the License.  
        }  
    protected void writeFieldValue(XContentBuilder builder) throws IOException {  
            } else if (field.stringValue().equals("bar")) {
import java.io.IOException;
            }
        );
        assertEquals(2, fields.length);  
            b.startObject("foo").startObject("properties");
 * this work for additional information regarding copyright
        assertEquals(fieldMapping(this::minimalMapping).toString(), mapper.mappingSource().toString());
    protected void registerParameters(ParameterChecker checker) throws IOException {  
                b.startObject("field").field("type", "rank_features").endObject();  
    protected boolean supportsMeta() {
    public void testNegativeScoreImpact() throws Exception {
        assertTrue(freq1 < freq2);
            } else {  
        })));  
    }  
            {
        assertEquals("[rank_features] fields do not support [exists] queries", iae.getMessage());
    protected Collection<? extends Plugin> getPlugins() {
                b.startObject().startObject("field").field("bar", 20).endObject().endObject();  
        return List.of(new MapperExtrasModulePlugin());  
        builder.startObject().field("foo", 10).field("bar", 20).endObject();
        IndexableField[] fields = doc1.rootDoc().getFields("field");
        FeatureField featureField1 = (FeatureField) fields[0];  
            b.endObject().endObject();
