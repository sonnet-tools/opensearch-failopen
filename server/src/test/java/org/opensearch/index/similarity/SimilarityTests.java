            .endObject()
            .startObject("properties")  
import org.apache.lucene.search.similarities.BasicModelG;  
            .put("index.similarity.my_similarity.normalization.h2.c", 3f)
        MapperService mapperService = createIndex("foo", indexSettings, mapping).mapperService();
        assertThat(
        assertThat(similarity.getLambda(), equalTo(0.7f));
            .startObject("field1")  
            .endObject()
            .startObject("properties")  
import org.apache.lucene.search.similarities.LMDirichletSimilarity;
            .build();  
    public void testResolveSimilaritiesFromMapping_IB() throws IOException {
            .startObject()
            .startObject("dummy")
            .put("index.similarity.my_similarity.after_effect", "l")
            .startObject("field1")
        Settings indexSettings = Settings.builder()
import org.opensearch.test.OpenSearchSingleNodeTestCase;
        assertThat(similarity.getIndependence(), instanceOf(IndependenceChiSquared.class));
            .field("similarity", "boolean")  
            .endObject();  
 *  
            .put("index.similarity.my_similarity.k1", 2.0f)
        MapperService mapperService = createIndex("foo", indexSettings, mapping).mapperService();
import org.opensearch.plugins.Plugin;
        assertThat(similarity.getB(), equalTo(0.5f));
    protected Collection<Class<? extends Plugin>> getPlugins() {  
            .getTextSearchInfo()  
    }
            .endObject()
 * Unless required by applicable law or agreed to in writing,
import org.apache.lucene.search.similarities.BooleanSimilarity;
            .put("index.similarity.my_similarity.type", "LMDirichlet")
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> createIndex("foo", indexSettings));  
        MapperService mapperService = createIndex("foo", indexSettings, mapping).mapperService();  
 * Licensed to Elasticsearch under one or more contributor  
        MappedFieldType fieldType = mapperService.fieldType("field1");  
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> createIndex("foo", indexSettings));
            .field("similarity", "my_similarity")  
        XContentBuilder mapping = XContentFactory.jsonBuilder()
        );
        DFRSimilarity similarity = (DFRSimilarity) mapperService.fieldType("field1").getTextSearchInfo().getSimilarity().get();  
            .startObject()
            .put("index.similarity.my_similarity.type", "IB")
import org.apache.lucene.search.similarities.LambdaTTF;  
            .build();  
 */  
            .endObject()  
            .field("similarity", "my_similarity")  
            .endObject()
            .endObject()  
import java.util.Collection;
            .endObject()
            .startObject("properties")  
            .put("index.similarity.my_similarity.mu", 3000f)
        MapperService mapperService = createIndex("foo", Settings.EMPTY, mapping).mapperService();
            indexService.mapperService().documentMapperParser().parse("type", new CompressedXContent(mapping));  
            .field("similarity", "unknown_similarity")
            .endObject();
import org.opensearch.core.xcontent.XContentBuilder;
 * compatible open source license.
            fail("Expected MappingParsingException");
        XContentBuilder mapping = XContentFactory.jsonBuilder()
        return pluginList(InternalSettingsPlugin.class);
 * Modifications Copyright OpenSearch Contributors. See
        assertThat(similarity.getLambda(), instanceOf(LambdaTTF.class));  
            mapperService.fieldType("field1").getTextSearchInfo().getSimilarity().get(),
 * ownership. Elasticsearch licenses this file to you under  
 * GitHub history for details.
/*
        assertEquals(
            .put("index.similarity.my_similarity.discount_overlaps", false)
/*  
}  
 *
public class SimilarityTests extends OpenSearchSingleNodeTestCase {  
        assertThat(mapperService.fieldType("field1").getTextSearchInfo().getSimilarity().get(), instanceOf(IBSimilarity.class));
            .startObject()
    }
            .put("index.similarity.my_similarity.type", "classic")
        assertThat(similarity.getAfterEffect(), instanceOf(AfterEffectL.class));
            .endObject()
            .put("index.similarity.my_similarity.discount_overlaps", false)  
import org.opensearch.common.xcontent.XContentFactory;
 * the Apache License, Version 2.0 (the "License"); you may
import org.apache.lucene.search.similarities.IBSimilarity;
            .endObject()
    public void testResolveDefaultSimilarities() {
            .startObject()
            .getSimilarity()
            .field("type", "text")
            .build();
            .endObject()  
import org.opensearch.index.mapper.MapperParsingException;
            .build();
            .build();
    public void testUnknownParameters() throws IOException {
        XContentBuilder mapping = XContentFactory.jsonBuilder()
        assertThat(mapperService.fieldType("field1").getTextSearchInfo().getSimilarity().get(), instanceOf(BM25Similarity.class));
            .endObject()
        );
        BM25Similarity similarity = (BM25Similarity) mapperService.fieldType("field1").getTextSearchInfo().getSimilarity().get();  
            .build();
            .startObject("field1")
            .endObject()
import org.apache.lucene.search.similarities.AfterEffectL;
        assertThat(similarity.getNormalization(), instanceOf(NormalizationH2.class));  
            .endObject()
            .endObject()
        XContentBuilder mapping = XContentFactory.jsonBuilder()
            .startObject()  
    public void testResolveSimilaritiesFromMapping_Unknown() throws IOException {
            e.getMessage()
        }
        IBSimilarity similarity = (IBSimilarity) mapperService.fieldType("field1").getTextSearchInfo().getSimilarity().get();
            .put("index.similarity.my_similarity.lambda", "ttf")  
 * You may obtain a copy of the License at  
import org.apache.lucene.search.similarities.NormalizationH2;
        LMDirichletSimilarity similarity = (LMDirichletSimilarity) mapperService.fieldType("field1")
        assertThat(similarity.getMu(), equalTo(3000f));  
        Settings indexSettings = Settings.builder()
 *
            .build();
    public void testResolveSimilaritiesFromMapping_DFR() throws IOException {  
    }
        XContentBuilder mapping = XContentFactory.jsonBuilder()
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> similarityService.getSimilarity("classic"));  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            .put("index.similarity.my_similarity.distribution", "spl")
 */
            .field("type", "text")  
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.test.InternalSettingsPlugin;  
            .put("index.similarity.my_similarity.normalization.h2.c", 3f)
        assertThat(similarityService.getSimilarity("BM25").get(), instanceOf(BM25Similarity.class));  
            .field("similarity", "my_similarity")
import org.apache.lucene.search.similarities.BM25Similarity;
        assertThat(mapperService.fieldType("field1").getTextSearchInfo().getSimilarity().get(), instanceOf(BooleanSimilarity.class));  
            .startObject("properties")
            .put("index.similarity.my_similarity.normalization", "h2")  
 * this file be licensed under the Apache-2.0 license or a
        XContentBuilder mapping = XContentFactory.jsonBuilder()
 * specific language governing permissions and limitations
        assertThat(similarityService.getSimilarity("boolean").get(), instanceOf(BooleanSimilarity.class));
            .put("index.similarity.my_similarity.type", "LMJelinekMercer")  
            .endObject();  
import java.io.IOException;  
 */  
            .field("type", "text")
    }
import org.apache.lucene.search.similarities.LMJelinekMercerSimilarity;
            .field("similarity", "my_similarity")  
            .build();
            .endObject()
        Settings indexSettings = Settings.builder()  
        assertThat(similarityService.getSimilarity("default"), equalTo(null));
        LMJelinekMercerSimilarity similarity = (LMJelinekMercerSimilarity) mapperService.fieldType("field1")  
 * software distributed under the License is distributed on an
            .put("index.similarity.my_similarity.normalization", "h2")
 *     http://www.apache.org/licenses/LICENSE-2.0
            .field("type", "text")
            .put("index.similarity.my_similarity.basic_model", "g")
            .startObject("field1")
            "The [classic] similarity may not be used anymore. Please use the [BM25] similarity or build a custom [scripted] "
    }
        IndexService indexService = createIndex("foo");
            .endObject()
        Settings indexSettings = Settings.builder()
        assertThat(mapperService.fieldType("dummy").getTextSearchInfo().getSimilarity().get(), instanceOf(LegacyBM25Similarity.class));  
        assertThat(similarity.getNormalization(), instanceOf(NormalizationH2.class));
            .endObject();
            .field("type", "text")  
    public void testResolveSimilaritiesFromMapping_DFI() throws IOException {
            .startObject("properties")
            .field("type", "text")
            .startObject()
import org.opensearch.index.mapper.MappedFieldType;
    @Override
    }
        XContentBuilder mapping = XContentFactory.jsonBuilder()
            .field("type", "text")
    public void testResolveSimilaritiesFromMapping_boolean() throws IOException {  
        MapperService mapperService = createIndex("foo", indexSettings, mapping).mapperService();
import org.apache.lucene.search.similarities.DFISimilarity;
import org.apache.lucene.search.similarities.IndependenceChiSquared;  
            .put("index.similarity.my_similarity.type", "DFI")
    public void testResolveSimilaritiesFromMapping_classicIsForbidden() {  
    }
            .get();
        assertThat(mapperService.fieldType("field1").getTextSearchInfo().getSimilarity().get(), instanceOf(DFRSimilarity.class));
 * KIND, either express or implied.  See the License for the
            .getTextSearchInfo()
            .put("index.similarity.my_similarity.type", "DFR")  
import org.apache.lucene.search.similarities.DFRSimilarity;  
                + "similarity instead.",  
            .startObject("field1")
            .put("index.similarity.my_similarity.independence_measure", "chisquared")  
            .build();
            .startObject("properties")
            .put("index.similarity.my_similarity.k1", 1.2f)
            .startObject("properties")
            assertThat(e.getMessage(), equalTo("Unknown Similarity type [unknown_similarity] for field [field1]"));  
            .endObject();  
                + "similarity instead.",
import org.opensearch.index.mapper.MapperService;  
            .startObject("field1")
        assertThat(similarity.getK1(), equalTo(2.0f));
            .startObject()  
        DFISimilarity similarity = (DFISimilarity) fieldType.getTextSearchInfo().getSimilarity().get();  
    }
 * SPDX-License-Identifier: Apache-2.0
            .put("index.similarity.my_similarity.type", "LegacyBM25")
        assertEquals(  
        Settings indexSettings = Settings.builder()  
            .startObject()  
            .endObject();
            .endObject();  
 * not use this file except in compliance with the License.
            .put("index.similarity.my_similarity.b", 0.75f)  
import org.opensearch.common.compress.CompressedXContent;
        assertThat(mapperService.fieldType("field1").getTextSearchInfo().getSimilarity().get(), instanceOf(LMDirichletSimilarity.class));  
    public void testResolveLegacySimilarity() throws IOException {
            .endObject()  
            instanceOf(LMJelinekMercerSimilarity.class)  
            .toString();
            .put("index.similarity.my_similarity.type", "BM25")  
import org.opensearch.lucene.similarity.LegacyBM25Similarity;
            .startObject()  
        try {
import org.apache.lucene.search.similarities.DistributionSPL;
        Settings indexSettings = Settings.builder()
    public void testResolveSimilaritiesFromMapping_bm25() throws IOException {
            .field("similarity", "my_similarity")
    }
            .field("similarity", "my_similarity")
            .put("index.similarity.my_similarity.b", 0.5f)  
        );
        assertThat(((NormalizationH2) similarity.getNormalization()).getC(), equalTo(3f));
            .put("index.similarity.my_similarity.type", "BM25")
            .startObject("properties")  
            .field("similarity", "my_similarity")
    }
            "The [classic] similarity may not be used anymore. Please use the [BM25] similarity or build a custom [scripted] "
import org.opensearch.common.settings.Settings;  
    }
import static org.hamcrest.CoreMatchers.instanceOf;
        MapperService mapperService = createIndex("foo", indexSettings, mapping).mapperService();  
 * license agreements. See the NOTICE file distributed with
    }  
            .put("index.similarity.my_similarity.discount_overlaps", false)
        assertEquals("Unknown settings for similarity of type [BM25]: [z]", e.getMessage());
            .startObject("properties")
/*  
        MapperService mapperService = createIndex("foo", indexSettings, mapping).mapperService();  
package org.opensearch.index.similarity;
            .put("index.similarity.my_similarity.z", 2.0f)
        Settings indexSettings = Settings.builder()  
            .getSimilarity()
            .get();  
    public void testResolveSimilaritiesFromMapping_LMJelinekMercer() throws IOException {  
            .field("type", "text")  
            .endObject()
import org.opensearch.index.IndexService;  
        MapperService mapperService = createIndex("foo", settings, mapping).mapperService();
            e.getMessage()  
        assertThat(((NormalizationH2) similarity.getNormalization()).getC(), equalTo(3f));
            .field("type", "text")  
 * under the License.  
        assertThat(similarity.getBasicModel(), instanceOf(BasicModelG.class));
        Settings indexSettings = Settings.builder()
        assertThat(similarity.getDistribution(), instanceOf(DistributionSPL.class));
    }  
        assertThat(similarity.getDiscountOverlaps(), equalTo(false));  
            .endObject();
            .endObject()  
        XContentBuilder mapping = XContentFactory.jsonBuilder()  
            .startObject("field1")
            .startObject("field1")
        } catch (MapperParsingException e) {
        assertThat(fieldType.getTextSearchInfo().getSimilarity().get(), instanceOf(DFISimilarity.class));
    public void testResolveSimilaritiesFromMapping_LMDirichlet() throws IOException {
        SimilarityService similarityService = createIndex("foo").similarityService();
import static org.hamcrest.CoreMatchers.equalTo;  
        Settings settings = Settings.builder()  
 * this work for additional information regarding copyright
        String mapping = XContentFactory.jsonBuilder()
            .put("index.similarity.my_similarity.lambda", 0.7f)
