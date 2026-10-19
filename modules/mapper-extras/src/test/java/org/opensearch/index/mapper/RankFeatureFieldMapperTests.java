 * under the License.  
            b.startArray("foo");  
        FeatureField featureField2 = (FeatureField) doc2.rootDoc().getFields("_feature")[0];  
public class RankFeatureFieldMapperTests extends MapperTestCase {
    @Override  
        assertEquals(1, fields.length);
        TermFrequencyAttribute freqAttribute = tk.addAttribute(TermFrequencyAttribute.class);
 * compatible open source license.
        TermQuery termQuery = (TermQuery) query;
/*
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * the Apache License, Version 2.0 (the "License"); you may
        DocumentMapper mapper = createDocumentMapper(fieldMapping(this::minimalMapping));
                b.startObject("field").field("type", "rank_feature").endObject();  
    public void testParseCreateFieldForPluggableFormat() throws Exception {
                b.startObject().field("field", 20).endObject();  
        assertEquals(  
    @Override
            b.endArray();
        int freq2 = getFrequency(featureField2.tokenStream(null, null));
    @Override
        assertNotNull(fieldMapper);
    protected void registerParameters(ParameterChecker checker) throws IOException {
            }
import org.apache.lucene.document.FeatureField;  
            e.getCause().getMessage()
        assertTrue(freq1 < freq2);  
 * KIND, either express or implied.  See the License for the
 */
 */  
 * this file be licensed under the Apache-2.0 license or a
        FeatureField featureField1 = (FeatureField) fields[0];
 * SPDX-License-Identifier: Apache-2.0
        assertEquals("field", termQuery.getTerm().text());
/*  
        builder.value(10);  
    }  
        IndexableField[] fields = doc1.rootDoc().getFields("_feature");  
    @Override
 * ownership. Elasticsearch licenses this file to you under  
 * The OpenSearch Contributors require contributions made to  
        int freq1 = getFrequency(featureField1.tokenStream(null, null));
import org.opensearch.plugins.Plugin;
    protected void assertExistsQuery(MappedFieldType fieldType, Query query, ParseContext.Document fields) {  
import org.apache.lucene.search.Query;
        assertNotNull(fields.getField("_feature"));
        ParsedDocument doc2 = mapper.parse(source(b -> b.field("field", 12)));
 *    http://www.apache.org/licenses/LICENSE-2.0
        checker.registerConflictCheck("positive_score_impact", b -> b.field("positive_score_impact", false));
        FeatureField featureField2 = (FeatureField) doc2.rootDoc().getFields("_feature")[0];
 *
        assertEquals(
import org.apache.lucene.analysis.TokenStream;
        );
    }
 */  
        int freq1 = getFrequency(featureField1.tokenStream(null, null));
    protected void writeFieldValue(XContentBuilder builder) throws IOException {
    static int getFrequency(TokenStream tk) throws IOException {
 * GitHub history for details.
        assertThat(query, instanceOf(TermQuery.class));
 * Licensed to Elasticsearch under one or more contributor  
            fieldMapping(b -> b.field("type", "rank_feature").field("positive_score_impact", false))
        );
        assertThat(fields[0], instanceOf(FeatureField.class));
            "[rank_feature] fields do not support indexing multiple values for the same field [foo.field] in the same document",
import java.util.Arrays;
        assertTrue(freq1 > freq2);
import static org.hamcrest.Matchers.instanceOf;  
            MapperParsingException.class,  
        );  
    }  
    @Override
    protected void minimalMapping(XContentBuilder b) throws IOException {
    }
        DocumentMapper mapper = createDocumentMapper(fieldMapping(this::minimalMapping));
    }
        assertTrue(tk.incrementToken());
        ParsedDocument doc2 = mapper.parse(source(b -> b.field("field", 12)));
 *  
        tk.reset();  
        MapperParsingException e = expectThrows(
    }
import java.io.IOException;
            {
        );  
    public void testRejectMultiValuedFields() throws MapperParsingException, IOException {
    }
        assertThat(fields[0], instanceOf(FeatureField.class));
 * not use this file except in compliance with the License.
        IndexableField[] fields = doc1.rootDoc().getFields("_feature");
package org.opensearch.index.mapper;
        FeatureField featureField1 = (FeatureField) fields[0];  
        })));  
 * license agreements. See the NOTICE file distributed with
        assertEquals("rank_feature", fieldMapper.typeName());
            "[rank_feature] fields do not support indexing multiple values for the same field [field] in the same document",
        return freq;
            }
        int freq = freqAttribute.getTermFrequency();
import java.util.List;
import org.apache.lucene.search.TermQuery;  
                b.startObject().field("field", 10).endObject();
}
        assertEquals("_feature", termQuery.getTerm().field());  
            () -> mapper.parse(source(b -> b.field("field", Arrays.asList(10, 20))))
import org.opensearch.core.xcontent.XContentBuilder;
        ParsedDocument doc1 = mapper.parse(source(b -> b.field("field", 10)));
 * this work for additional information regarding copyright
            b.startObject("field").field("type", "rank_feature").endObject();  
        assertFalse(tk.incrementToken());  
    }
        e = expectThrows(MapperParsingException.class, () -> mapper.parse(source(b -> {
    public void testNegativeScoreImpact() throws Exception {  
import java.util.Collection;  
        DocumentMapper mapper = createDocumentMapper(mapping(b -> {
        assertEquals(fieldMapping(this::minimalMapping).toString(), mapper.mappingSource().toString());
            e.getCause().getMessage()  
    protected Collection<? extends Plugin> getPlugins() {  
        RankFeatureFieldMapper fieldMapper = (RankFeatureFieldMapper) mapper.mappers().getMapper("field");  
 * specific language governing permissions and limitations
        return List.of(new MapperExtrasModulePlugin());
        }));  
    }  
/*  
            b.startObject("foo").startObject("properties");
        DocumentMapper mapper = createDocumentMapper(
        ParsedDocument doc1 = mapper.parse(source(b -> b.field("field", 10)));
    public void testDefaults() throws Exception {  
        int freq2 = getFrequency(featureField2.tokenStream(null, null));  
import org.apache.lucene.analysis.tokenattributes.TermFrequencyAttribute;
 * software distributed under the License is distributed on an
 *
import org.apache.lucene.index.IndexableField;
    }
            b.endObject().endObject();
        b.field("type", "rank_feature");  
 * You may obtain a copy of the License at  
            {
 * Unless required by applicable law or agreed to in writing,
 * Modifications Copyright OpenSearch Contributors. See
        assertEquals(1, fields.length);  
