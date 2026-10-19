            .startObject("field1")
 */
            .startObject("field1")
            .startObject()
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> createIndex("foo", indexSettings));
import org.opensearch.index.mapper.MapperParsingException;
            .startObject("properties")
            .startObject("field1")
 * ownership. Elasticsearch licenses this file to you under
        MapperService mapperService = createIndex("foo", indexSettings, mapping).mapperService();
    public void testResolveDefaultSimilarities() {
            .field("similarity", "my_similarity")
import static org.hamcrest.CoreMatchers.equalTo;
        LMDirichletSimilarity similarity = (LMDirichletSimilarity) mapperService.fieldType("field1")
            .startObject()
        Settings indexSettings = Settings.builder()
        DFRSimilarity similarity = (DFRSimilarity) mapperService.fieldType("field1").getTextSearchInfo().getSimilarity().get();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    public void testUnknownParameters() throws IOException {
import org.apache.lucene.search.similarities.NormalizationH2;
            .put("index.similarity.my_similarity.type", "BM25")
 * Licensed to Elasticsearch under one or more contributor
            .getTextSearchInfo()
            .field("type", "text")
        Settings indexSettings = Settings.builder()
            .put("index.similarity.my_similarity.discount_overlaps", false)
            .build();
            .build();
 * compatible open source license.
            .field("similarity", "unknown_similarity")
            .build();
        XContentBuilder mapping = XContentFactory.jsonBuilder()
            .endObject()
            .startObject("properties")
            .build();
            .endObject()
    public void testResolveLegacySimilarity() throws IOException {
 * not use this file except in compliance with the License.
        IndexService indexService = createIndex("foo");
        String mapping = XContentFactory.jsonBuilder()
        Settings indexSettings = Settings.builder()
        assertThat(mapperService.fieldType("dummy").getTextSearchInfo().getSimilarity().get(), instanceOf(LegacyBM25Similarity.class));
            .field("similarity", "my_similarity")
            .field("similarity", "boolean")
            .put("index.similarity.my_similarity.normalization", "h2")
        Settings settings = Settings.builder()
        MapperService mapperService = createIndex("foo", indexSettings, mapping).mapperService();
            .field("type", "text")
        MapperService mapperService = createIndex("foo", Settings.EMPTY, mapping).mapperService();
            e.getMessage()
        MappedFieldType fieldType = mapperService.fieldType("field1");
import org.apache.lucene.search.similarities.BooleanSimilarity;
        assertThat(similarityService.getSimilarity("default"), equalTo(null));
            .startObject("field1")
        assertThat(similarity.getK1(), equalTo(2.0f));
        } catch (MapperParsingException e) {
    }
        assertThat(similarity.getMu(), equalTo(3000f));
        assertThat(mapperService.fieldType("field1").getTextSearchInfo().getSimilarity().get(), instanceOf(LMDirichletSimilarity.class));
        return pluginList(InternalSettingsPlugin.class);
 *
            .put("index.similarity.my_similarity.type", "LegacyBM25")
            .field("type", "text")
            .build();
            .endObject();
        assertThat(similarityService.getSimilarity("boolean").get(), instanceOf(BooleanSimilarity.class));
            .startObject()
        XContentBuilder mapping = XContentFactory.jsonBuilder()
            .get();
    }
        MapperService mapperService = createIndex("foo", indexSettings, mapping).mapperService();
            .endObject()
            .endObject()
        assertThat(mapperService.fieldType("field1").getTextSearchInfo().getSimilarity().get(), instanceOf(DFRSimilarity.class));
            .endObject();
            .endObject();
            .build();
        assertThat(similarity.getBasicModel(), instanceOf(BasicModelG.class));
        assertEquals(
    }
 */
package org.opensearch.index.similarity;
    }
            .put("index.similarity.my_similarity.type", "BM25")
    }
            .endObject()
            .build();
/*
        );
        Settings indexSettings = Settings.builder()
        MapperService mapperService = createIndex("foo", settings, mapping).mapperService();
import org.opensearch.common.compress.CompressedXContent;
}
import org.opensearch.common.xcontent.XContentFactory;
            .get();
            .startObject()
import org.apache.lucene.search.similarities.DFISimilarity;
        XContentBuilder mapping = XContentFactory.jsonBuilder()
import org.opensearch.index.mapper.MapperService;
 * the Apache License, Version 2.0 (the "License"); you may
    }
            .field("type", "text")
            .put("index.similarity.my_similarity.independence_measure", "chisquared")
            .put("index.similarity.my_similarity.type", "classic")
import org.opensearch.index.mapper.MappedFieldType;
import org.apache.lucene.search.similarities.IBSimilarity;
    public void testResolveSimilaritiesFromMapping_IB() throws IOException {
import org.apache.lucene.search.similarities.DFRSimilarity;
        assertThat(mapperService.fieldType("field1").getTextSearchInfo().getSimilarity().get(), instanceOf(IBSimilarity.class));
 * KIND, either express or implied.  See the License for the
import org.opensearch.lucene.similarity.LegacyBM25Similarity;
 * Modifications Copyright OpenSearch Contributors. See
import org.apache.lucene.search.similarities.LambdaTTF;
            .startObject("properties")
            assertThat(e.getMessage(), equalTo("Unknown Similarity type [unknown_similarity] for field [field1]"));
        assertThat(similarity.getIndependence(), instanceOf(IndependenceChiSquared.class));
            .endObject();
    public void testResolveSimilaritiesFromMapping_bm25() throws IOException {
        assertThat(((NormalizationH2) similarity.getNormalization()).getC(), equalTo(3f));
            .endObject()
        assertThat(mapperService.fieldType("field1").getTextSearchInfo().getSimilarity().get(), instanceOf(BooleanSimilarity.class));
 * GitHub history for details.
            fail("Expected MappingParsingException");
            .field("type", "text")
import org.opensearch.test.InternalSettingsPlugin;
    public void testResolveSimilaritiesFromMapping_DFR() throws IOException {
            .endObject()
            .put("index.similarity.my_similarity.k1", 1.2f)
        assertThat(similarity.getDiscountOverlaps(), equalTo(false));
    public void testResolveSimilaritiesFromMapping_DFI() throws IOException {
            .getSimilarity()
            .field("type", "text")
            .startObject("field1")
import org.apache.lucene.search.similarities.BasicModelG;
 * license agreements. See the NOTICE file distributed with
 * The OpenSearch Contributors require contributions made to
                + "similarity instead.",
            .field("similarity", "my_similarity")
            .put("index.similarity.my_similarity.normalization", "h2")
            mapperService.fieldType("field1").getTextSearchInfo().getSimilarity().get(),
            "The [classic] similarity may not be used anymore. Please use the [BM25] similarity or build a custom [scripted] "
    }
 *
            .build();
            .startObject("properties")
            .put("index.similarity.my_similarity.normalization.h2.c", 3f)
/*
            .put("index.similarity.my_similarity.mu", 3000f)
            .endObject();
    public void testResolveSimilaritiesFromMapping_boolean() throws IOException {
            .startObject("properties")
            .field("similarity", "my_similarity")
        XContentBuilder mapping = XContentFactory.jsonBuilder()
        assertThat(similarity.getNormalization(), instanceOf(NormalizationH2.class));
            .startObject()
    public void testResolveSimilaritiesFromMapping_Unknown() throws IOException {
        assertEquals(
            .put("index.similarity.my_similarity.discount_overlaps", false)
            .startObject()
            e.getMessage()
    }
            .startObject()
            .put("index.similarity.my_similarity.type", "LMDirichlet")
        assertThat(similarityService.getSimilarity("BM25").get(), instanceOf(BM25Similarity.class));
    }
            .field("similarity", "my_similarity")
            .endObject()
        XContentBuilder mapping = XContentFactory.jsonBuilder()
public class SimilarityTests extends OpenSearchSingleNodeTestCase {
            .put("index.similarity.my_similarity.distribution", "spl")
 *     http://www.apache.org/licenses/LICENSE-2.0
    }
    public void testResolveSimilaritiesFromMapping_LMDirichlet() throws IOException {
            .put("index.similarity.my_similarity.normalization.h2.c", 3f)
        assertThat(mapperService.fieldType("field1").getTextSearchInfo().getSimilarity().get(), instanceOf(BM25Similarity.class));
        try {
        MapperService mapperService = createIndex("foo", indexSettings, mapping).mapperService();
        assertThat(similarity.getAfterEffect(), instanceOf(AfterEffectL.class));
            .field("type", "text")
 * under the License.
            .field("type", "text")
        assertThat(similarity.getNormalization(), instanceOf(NormalizationH2.class));
        assertThat(similarity.getB(), equalTo(0.5f));
    }
            .endObject();
            .put("index.similarity.my_similarity.k1", 2.0f)
        XContentBuilder mapping = XContentFactory.jsonBuilder()
            .endObject()
 * software distributed under the License is distributed on an
 * this file be licensed under the Apache-2.0 license or a
            .endObject()
        );
            .endObject()
        Settings indexSettings = Settings.builder()
import org.apache.lucene.search.similarities.DistributionSPL;
            .endObject();
    public void testResolveSimilaritiesFromMapping_classicIsForbidden() {
            .startObject("properties")
        assertThat(fieldType.getTextSearchInfo().getSimilarity().get(), instanceOf(DFISimilarity.class));
            .getTextSearchInfo()
 * specific language governing permissions and limitations
        Settings indexSettings = Settings.builder()
            .startObject("properties")
        assertEquals("Unknown settings for similarity of type [BM25]: [z]", e.getMessage());
        DFISimilarity similarity = (DFISimilarity) fieldType.getTextSearchInfo().getSimilarity().get();
            .put("index.similarity.my_similarity.type", "LMJelinekMercer")
            .endObject()
            .startObject("dummy")
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> createIndex("foo", indexSettings));
import org.apache.lucene.search.similarities.AfterEffectL;
/*
 * this work for additional information regarding copyright
            indexService.mapperService().documentMapperParser().parse("type", new CompressedXContent(mapping));
import org.apache.lucene.search.similarities.LMJelinekMercerSimilarity;
 */
        );
            .toString();
            .field("similarity", "my_similarity")
            .startObject("properties")
        Settings indexSettings = Settings.builder()
import org.opensearch.plugins.Plugin;
import org.opensearch.common.settings.Settings;
 *
        assertThat(similarity.getDistribution(), instanceOf(DistributionSPL.class));
            .put("index.similarity.my_similarity.after_effect", "l")
        assertThat(similarity.getLambda(), instanceOf(LambdaTTF.class));
            .startObject("field1")
            .endObject()
            .put("index.similarity.my_similarity.type", "IB")
            .put("index.similarity.my_similarity.type", "DFR")
            .build();
        LMJelinekMercerSimilarity similarity = (LMJelinekMercerSimilarity) mapperService.fieldType("field1")
            .put("index.similarity.my_similarity.b", 0.5f)
            .field("similarity", "my_similarity")
    protected Collection<Class<? extends Plugin>> getPlugins() {
        MapperService mapperService = createIndex("foo", indexSettings, mapping).mapperService();
            .field("type", "text")
import static org.hamcrest.CoreMatchers.instanceOf;
        BM25Similarity similarity = (BM25Similarity) mapperService.fieldType("field1").getTextSearchInfo().getSimilarity().get();
        assertThat(
            .endObject()
            .endObject()
            instanceOf(LMJelinekMercerSimilarity.class)
            .put("index.similarity.my_similarity.discount_overlaps", false)
    @Override
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.test.OpenSearchSingleNodeTestCase;
            .endObject()
        assertThat(((NormalizationH2) similarity.getNormalization()).getC(), equalTo(3f));
            .put("index.similarity.my_similarity.z", 2.0f)
            .endObject()
        MapperService mapperService = createIndex("foo", indexSettings, mapping).mapperService();
            .put("index.similarity.my_similarity.lambda", "ttf")
        IBSimilarity similarity = (IBSimilarity) mapperService.fieldType("field1").getTextSearchInfo().getSimilarity().get();
import org.apache.lucene.search.similarities.BM25Similarity;
    }
            .getSimilarity()
    }
import java.util.Collection;
            .startObject()
import org.opensearch.index.IndexService;
            .endObject()
            "The [classic] similarity may not be used anymore. Please use the [BM25] similarity or build a custom [scripted] "
            .startObject("field1")
            .put("index.similarity.my_similarity.basic_model", "g")
 * Unless required by applicable law or agreed to in writing,
            .endObject();
            .startObject("properties")
        }
            .put("index.similarity.my_similarity.b", 0.75f)
    public void testResolveSimilaritiesFromMapping_LMJelinekMercer() throws IOException {
        Settings indexSettings = Settings.builder()
            .put("index.similarity.my_similarity.type", "DFI")
                + "similarity instead.",
            .startObject("field1")
        XContentBuilder mapping = XContentFactory.jsonBuilder()
        assertThat(similarity.getLambda(), equalTo(0.7f));
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> similarityService.getSimilarity("classic"));
import java.io.IOException;
import org.apache.lucene.search.similarities.IndependenceChiSquared;
            .put("index.similarity.my_similarity.lambda", 0.7f)
            .endObject()
            .startObject()
 * You may obtain a copy of the License at
        XContentBuilder mapping = XContentFactory.jsonBuilder()
import org.opensearch.core.xcontent.XContentBuilder;
        SimilarityService similarityService = createIndex("foo").similarityService();
import org.apache.lucene.search.similarities.LMDirichletSimilarity;
