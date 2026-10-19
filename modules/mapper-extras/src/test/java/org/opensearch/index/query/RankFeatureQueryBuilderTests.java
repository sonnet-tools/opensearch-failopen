        return Arrays.asList(MapperExtrasModulePlugin.class, TestGeoShapeFieldMapperPlugin.class);  
        final String field = randomFrom(fields);  
                }
        ScoreFunction function;
        assertThat(query, either(instanceOf(MatchNoDocsQuery.class)).or(instanceOf(expectedClass)));
    public void testIllegalCombination() throws IOException {
 *    http://www.apache.org/licenses/LICENSE-2.0
        mapperService.merge(  
 * specific language governing permissions and limitations
import static org.hamcrest.Matchers.either;  
            fields.add("my_negative_feature_field");  
}  
            "_doc",
import org.opensearch.plugins.Plugin;  
                    }  
                function = new ScoreFunction.Log(1 + randomFloat());
                }
import org.opensearch.index.query.RankFeatureQueryBuilder.ScoreFunction;
                    "my_feature_vector_field",
            }""";
import org.opensearch.action.admin.indices.mapping.put.PutMappingRequest;
 *
                } else {  
 * Modifications Copyright OpenSearch Contributors. See
                break;  
 * ownership. Elasticsearch licenses this file to you under  
 *
import org.apache.lucene.search.Query;  
        }
    }
                        "scaling_factor": 4.5
    }
    protected RankFeatureQueryBuilder doCreateTestQueryBuilder() {
        fields.add("unmapped_field");  
 * Licensed to Elasticsearch under one or more contributor  
            case 2:
 */
 * the Apache License, Version 2.0 (the "License"); you may
        Query parsedQuery = parseQuery(query).toQuery(createShardContext());
        boolean mayUseNegativeField = true;  
    @Override  
        );
        fields.add("my_feature_vector_field.feature");
                mayUseNegativeField = false;  
                break;  
    @Override
        String query = """
            }""";
                    "field": "my_feature_field"
/*  
 * KIND, either express or implied.  See the License for the
                    function = new ScoreFunction.Saturation(randomFloat());
import java.util.Locale;  
 * SPDX-License-Identifier: Apache-2.0
            "[rank_feature] query only works on [rank_feature] fields and features of [rank_features] fields, not [text]",  
                break;
    }
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> parseQuery(query).toQuery(createShardContext()));
                ).toString()
                }
 * software distributed under the License is distributed on an
            {
import org.apache.lucene.document.FeatureField;
import java.io.IOException;
        String query = String.format(Locale.ROOT, """
import static org.hamcrest.CoreMatchers.instanceOf;
 * not use this file except in compliance with the License.
            "Cannot use the [log] function with a field that has a negative score impact as it would trigger negative scores",
    @Override
                "rank_feature" : {
                "rank_feature" : {
 * GitHub history for details.
    }
 * this work for additional information regarding copyright
            }""", TEXT_FIELD_NAME);  
 * under the License.  
        }  
import org.opensearch.index.mapper.MapperService;
    public void testDefaultScoreFunction() throws IOException {
                    "log" : {
        assertEquals(FeatureField.newSaturationQuery("_feature", "my_feature_field"), parsedQuery);  
                    "my_negative_feature_field",  
        assertEquals(
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> parseQuery(query).toQuery(createShardContext()));  
                    "type=rank_features"  
                if (randomBoolean()) {
            case 0:
            ),
 * The OpenSearch Contributors require contributions made to  
 * license agreements. See the NOTICE file distributed with
        Class<?> expectedClass = FeatureField.newSaturationQuery("", "", 1, 1).getClass();  
        return new RankFeatureQueryBuilder(field, function);
                PutMappingRequest.simpleMapping(  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    protected void initializeAdditionalMappings(MapperService mapperService) throws IOException {
            e.getMessage()  
    public void testIllegalField() throws IOException {  
    protected Collection<Class<? extends Plugin>> getPlugins() {
                    "type=rank_feature",
                    "field": "my_negative_feature_field",  
 */  
    }
    }  
            {  
public class RankFeatureQueryBuilderTests extends AbstractQueryTestCase<RankFeatureQueryBuilder> {
                "rank_feature" : {  
                }  
                function = new ScoreFunction.Linear();
import java.util.List;
 * this file be licensed under the Apache-2.0 license or a
 * Unless required by applicable law or agreed to in writing,
            new CompressedXContent(
                throw new AssertionError();
import org.opensearch.index.mapper.MapperExtrasModulePlugin;  
            default:
import java.util.Arrays;  
        );
 * You may obtain a copy of the License at  
package org.opensearch.index.query;
    @Override
import java.util.ArrayList;
import org.opensearch.test.TestGeoShapeFieldMapperPlugin;
        );
                    function = new ScoreFunction.Saturation();
import org.opensearch.test.AbstractQueryTestCase;
/*  
import org.opensearch.common.compress.CompressedXContent;
        List<String> fields = new ArrayList<>();
    protected void doAssertLuceneQuery(RankFeatureQueryBuilder queryBuilder, Query query, QueryShardContext context) throws IOException {
            MapperService.MergeReason.MAPPING_UPDATE  
                break;  
        String query = """  
    }
        assertEquals(
            {
import org.apache.lucene.search.MatchNoDocsQuery;
                    "field": "%s"
            case 1:  
import java.util.Collection;
            case 3:
            e.getMessage()
                    "type=rank_feature,positive_score_impact=false",
        switch (random().nextInt(4)) {
                    "my_feature_field",
        fields.add("my_feature_field");
 */  
        if (mayUseNegativeField) {
                function = new ScoreFunction.Sigmoid(randomFloat(), randomFloat());
 * compatible open source license.
/*
 *  
