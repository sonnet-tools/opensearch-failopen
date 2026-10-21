        );
            "org.opensearch.index.query.MatchBoolPrefixQueryBuilder",
        TermsQueryField termsQueryField = TermsQueryField.newBuilder().setValue(fva).build();
        // Create a MatchBoolPrefix query container
        QueryContainer queryContainer = QueryContainer.newBuilder()
        );
        assertEquals(
            .setMatchPhrasePrefix(
            public void setRegistry(org.opensearch.transport.grpc.spi.QueryBuilderProtoConverterRegistry registry) {
    public void testMatchAllQueryConversion() {
            "Should be a MultiMatchQueryBuilder",
            .build();
        QueryBuilder queryBuilder = registry.fromProto(queryContainer);
        assertEquals("Should be a NestedQueryBuilder", "org.opensearch.index.query.NestedQueryBuilder", queryBuilder.getClass().getName());
        assertEquals(
                    .build()
            .setValue(FieldValue.newBuilder().setString("active").build())
                    .setBoost(1.5f)
            "Should be a MatchPhrasePrefixQueryBuilder",
            @Override
        TermQuery termQuery = TermQuery.newBuilder()
        FieldValueArray fva = FieldValueArray.newBuilder().addFieldValueArray(fv1).addFieldValueArray(fv2).build();
        assertNotNull("QueryBuilder should not be null", queryBuilder);
        } catch (Exception e) {
        QueryContainer queryContainer = QueryContainer.newBuilder().setNested(nestedQuery).build();
            )
        QueryBuilder queryBuilder = registry.fromProto(queryContainer);
import org.opensearch.protobufs.TermQuery;
            .setPath("user")
    public void testMatchBoolPrefixQueryConversion() {
        // Create a Match query container
        // Verify the result
            )
            public QueryContainer.QueryContainerCase getHandledQueryCase() {
                // No-op for test
                    .setBoost(1.5f)
    }
        try {
            }
 * Test class for QueryBuilderProtoConverterRegistry to verify the map-based optimization.
            }
            queryBuilder.getClass().getName()
        } catch (Exception e) {
    }
        // Convert using the registry
            "org.opensearch.index.query.GeoDistanceQueryBuilder",
import org.opensearch.protobufs.MatchPhrasePrefixQuery;
import org.opensearch.protobufs.MultiMatchQuery;
    }
            .setXName("location")
        // Create an Exists query container
            public org.opensearch.index.query.QueryBuilder fromProto(QueryContainer queryContainer) {
 * SPDX-License-Identifier: Apache-2.0
        };
                return QueryContainer.QueryContainerCase.MATCH_ALL; // Use existing case for simplicity
                    .setQuery("opensearch tutorial")
    }
    public void testRegexpQueryConversion() {
            .putLocation("location", geoLocation)
            queryBuilder.getClass().getName()
                                TermQuery.newBuilder()
            .build();
import org.opensearch.protobufs.ExistsQuery;
        // Verify the result
        Script script = Script.newBuilder().setInline(InlineScript.newBuilder().setSource("doc['field'].value > 100").build()).build();
        QueryBuilder queryBuilder = registry.fromProto(queryContainer);
        );
        assertEquals("Should be a MatchQueryBuilder", "org.opensearch.index.query.MatchQueryBuilder", queryBuilder.getClass().getName());
            "org.opensearch.index.query.TermsSetQueryBuilder",
        assertNotNull("QueryBuilder should not be null", queryBuilder);
            "org.opensearch.index.query.GeoDistanceQueryBuilder",
    public void testConstantScoreQueryConversion() {
        // Register the custom converter
            .build();
    }
        assertEquals("Should be a RegexpQueryBuilder", "org.opensearch.index.query.RegexpQueryBuilder", queryBuilder.getClass().getName());
        // Create a Fuzzy query container
            .setXName("test_terms_set_query")
    }
        // Test that updateRegistryOnAllConverters method can be called without throwing exceptions
        // Create a Term query as inner query for the nested query
        );
        NumberRangeQueryAllOfTo toValue = NumberRangeQueryAllOfTo.newBuilder().setDouble(100.0).build();
        );
            .setMatchBoolPrefix(
        assertEquals("Should be an IdsQueryBuilder", "org.opensearch.index.query.IdsQueryBuilder", queryBuilder.getClass().getName());
                return QueryContainer.QueryContainerCase.MATCH_ALL;
        TermQuery termQuery = TermQuery.newBuilder()
        // Verify the result
            .addDoubleArray(40.7589)  // lat
            public void setRegistry(org.opensearch.transport.grpc.spi.QueryBuilderProtoConverterRegistry registry) {
        QueryContainer queryContainer = QueryContainer.newBuilder()
        // Create an empty query container (no query type set)
        assertNotNull("QueryBuilder should not be null", queryBuilder);
                    .setSlop(2)
            }
    public void testMatchPhrasePrefixQueryConversion() {
        // Convert using the registry
            public org.opensearch.index.query.QueryBuilder fromProto(QueryContainer queryContainer) {
            public QueryContainer.QueryContainerCase getHandledQueryCase() {
            .build();
                    .setBoost(1.0f)
                MatchPhraseQuery.newBuilder()
                    .addMust(QueryContainer.newBuilder().setMatchAll(MatchAllQuery.newBuilder().build()).build())
            .setBool(
        QueryBuilderProtoConverter customConverter = new QueryBuilderProtoConverter() {
        // Create a Terms query container
        GeoBounds geoBounds = GeoBounds.newBuilder().setCoords(coords).build();
                                    .setValue(FieldValue.newBuilder().setString("active").build())
import org.opensearch.protobufs.RegexpQuery;
            .build();
            .setMatchNone(org.opensearch.protobufs.MatchNoneQuery.newBuilder().build())
            }
            "Should be a MatchBoolPrefixQueryBuilder",
        QueryContainer queryContainer = QueryContainer.newBuilder()
            @Override
        assertEquals(
        assertEquals("Should be a FuzzyQueryBuilder", "org.opensearch.index.query.FuzzyQueryBuilder", queryBuilder.getClass().getName());
    }
        // Convert using the registry
        QueryContainer queryContainer = QueryContainer.newBuilder()
        IdsQuery idsQuery = IdsQuery.newBuilder().addValues("doc1").addValues("doc2").setBoost(1.5f).setXName("test_ids_query").build();
    }
            }
            .setQuery(baseQuery)
        assertEquals("Should be a PrefixQueryBuilder", "org.opensearch.index.query.PrefixQueryBuilder", queryBuilder.getClass().getName());
            .build();
            .setScoreMode(ChildScoreMode.CHILD_SCORE_MODE_AVG)
            }
import org.opensearch.protobufs.FuzzyQuery;
            )
        // Test the combination of registering a converter and then updating the registry
                MatchQuery.newBuilder()
            .setMinimumShouldMatchField("tag_count")
import org.opensearch.protobufs.TextQueryType;
        registry.registerConverter(customConverter);
        // Convert using the registry
        expectThrows(IllegalArgumentException.class, () -> registry.fromProto(null));
            .build();
            .setXName("test_nested_query")
            queryBuilder.getClass().getName()
        );
    }
                    .build()
        FieldValue fv1 = FieldValue.newBuilder().setString("electronics").build();
        assertNotNull("QueryBuilder should not be null", queryBuilder);
            fail("registerConverter should not throw an exception: " + e.getMessage());
        assertEquals("Should be an ExistsQueryBuilder", "org.opensearch.index.query.ExistsQueryBuilder", queryBuilder.getClass().getName());
                    .addFields("content")
            }
        QueryContainer queryContainer = QueryContainer.newBuilder().setMatchAll(MatchAllQuery.newBuilder().build()).build();
import org.opensearch.protobufs.MinimumShouldMatch;
            .addDoubleArray(-73.9851) // lon
        assertNotNull("QueryBuilder should not be null", queryBuilder);
        assertNotNull("QueryBuilder should not be null after registering custom converter", queryBuilder);
        QueryBuilder result = registry.fromProto(queryContainer);
    }
                    .setValue(FieldValue.newBuilder().setString("opensearch").build())
    }
            .setXName("location")
    public void testFuzzyQueryConversion() {
        // Convert using the registry
        QueryContainer queryContainer = QueryContainer.newBuilder().setGeoDistance(geoDistanceQuery).build();
        QueryBuilderProtoConverter customConverter = new QueryBuilderProtoConverter() {
                    .setField("title")
        // Convert using the registry
        RangeQuery rangeQuery = RangeQuery.newBuilder().setNumberRangeQuery(numberRangeQuery).build();
            .build();
        assertNotNull("QueryBuilder should not be null after updating registry on all converters", queryBuilder);
                return new org.opensearch.index.query.MatchAllQueryBuilder();
        QueryContainer queryContainer = QueryContainer.newBuilder()
            )
            @Override
    }
                    .setXName("test_matchphrase_query")
        assertNotNull("QueryBuilder should not be null", queryBuilder);
        // Verify the result
            .setWildcard(WildcardQuery.newBuilder().setField("test_field").setValue("test*pattern").setBoost(0.8f).build())
            .build();
        // Convert using the registry
    @Override
                    .setQuery(FieldValue.newBuilder().setString("hello world").build())
        // Convert using the registry
            .setQuery(innerQueryContainer)
        // Test that it works
            )
                    .setXName("test_multimatch_query")
        assertNotNull("QueryBuilder should not be null", queryBuilder);
            .setTerm(
        // Create a FunctionScore query container with a base MatchAll query
    public void testNullConverter() {
            )
        // Create a ConstantScore query container with a term query inside
        // Create an Ids query container
import org.opensearch.protobufs.Script;
        // Verify the result
            .setMatch(
    }
        expectThrows(IllegalArgumentException.class, () -> registry.registerConverter(customConverter));
                    .setBoost(2.0f)
        QueryContainer queryContainer = QueryContainer.newBuilder()
            public QueryContainer.QueryContainerCase getHandledQueryCase() {
            @Override
        ScriptQuery scriptQuery = ScriptQuery.newBuilder().setScript(script).setBoost(1.5f).setXName("test_script_query").build();
            public QueryContainer.QueryContainerCase getHandledQueryCase() {
            "org.opensearch.index.query.MatchPhraseQueryBuilder",
        QueryBuilder queryBuilder = registry.fromProto(queryContainer);
        assertEquals(
        );
        assertNotNull("QueryBuilder should not be null", queryBuilder);
            @Override
        };
            queryBuilder.getClass().getName()
        assertNotNull("QueryBuilder should not be null", queryBuilder);
        };
                    .setOperator(Operator.OPERATOR_AND)
                return new org.opensearch.index.query.ExistsQueryBuilder("test_field");
        // Convert using the registry
                    )
    }
            queryBuilder.getClass().getName()
            fail("registerConverter should not throw an exception: " + e.getMessage());
        assertNotNull("Result should not be null", result);
    public void testExistsQueryConversion() {
        assertNotNull("QueryBuilder should not be null", queryBuilder);
            .build();
        // Verify that the registry still works after both operations
        DoubleArray doubleArray = DoubleArray.newBuilder()
        // Create a custom converter for testing
        // Convert using the registry
        assertEquals("Should be an ExistsQueryBuilder", "org.opensearch.index.query.ExistsQueryBuilder", queryBuilder.getClass().getName());
        assertEquals(
                    .setMinimumShouldMatch(MinimumShouldMatch.newBuilder().setString("75%").build())
    }
import org.opensearch.protobufs.BoolQuery;
                            )
        assertNotNull("QueryBuilder should not be null", queryBuilder);
        // Verify the result
        QueryContainer queryContainer = QueryContainer.newBuilder().setTermsSet(termsSetQuery).build();
            "org.opensearch.index.query.functionscore.FunctionScoreQueryBuilder",
                    .setType(TextQueryType.TEXT_QUERY_TYPE_BEST_FIELDS)
            fail("updateRegistryOnAllConverters should not throw an exception: " + e.getMessage());
            .build();
        // Verify the result
        // Verify the result
            .setField("user.name")
            .setXName("test_function_score_query")
        QueryContainer queryContainer = QueryContainer.newBuilder().setMatchAll(MatchAllQuery.newBuilder().build()).build();
    }
                TermQuery.newBuilder().setField("test_field").setValue(FieldValue.newBuilder().setString("test_value").build()).build()
        QueryBuilderProtoConverter customConverter = new QueryBuilderProtoConverter() {
    }
        expectThrows(IllegalArgumentException.class, () -> registry.registerConverter(null));
        QueryBuilder queryBuilder = registry.fromProto(queryContainer);
            "org.opensearch.index.query.WildcardQueryBuilder",
        QueryBuilder queryBuilder = registry.fromProto(queryContainer);
            registry.updateRegistryOnAllConverters();
        );
                    .build()
            .build();
        // Create a Prefix query container
                    .setField("message")
import org.opensearch.protobufs.InlineScript;
            .build();
                            .build()
        assertNotNull("QueryBuilder should not be null", queryBuilder);
            .setMultiMatch(
import org.opensearch.protobufs.ConstantScoreQuery;
        FunctionScoreQuery functionScoreQuery = FunctionScoreQuery.newBuilder()
            public QueryBuilder fromProto(QueryContainer queryContainer) {
        QueryBuilder queryBuilder = registry.fromProto(queryContainer);
            // If we reach here, no exception was thrown
        LatLonGeoLocation latLonLocation = LatLonGeoLocation.newBuilder().setLat(40.7589).setLon(-73.9851).build();
    public void testConverterRegistration() {
            "org.opensearch.index.query.GeoBoundingBoxQueryBuilder",
    }
            .setBoost(2.0f)
            "Should be a GeoBoundingBoxQueryBuilder",
        QueryBuilderProtoConverter customConverter = new QueryBuilderProtoConverter() {
            // If we reach here, no exception was thrown
            queryBuilder.getClass().getName()
        QueryContainer baseQuery = QueryContainer.newBuilder().setMatchAll(MatchAllQuery.newBuilder().build()).build();
        // Convert using the registry
    }
        QueryBuilder queryBuilder = registry.fromProto(queryContainer);
    public void testNestedQueryConversion() {
        // Convert using the registry
        QueryContainer queryContainer = QueryContainer.newBuilder()
import org.opensearch.protobufs.CoordsGeoBounds;
            )
        assertEquals(
        assertNotNull("QueryBuilder should not be null", queryBuilder);
            registry.registerConverter(customConverter);
        } catch (Exception e) {
        expectThrows(IllegalArgumentException.class, () -> registry.registerConverter(customConverter));
        // Verify the result
        QueryContainer queryContainer = QueryContainer.newBuilder()
    }
        // Verify the result
        // Create a custom converter for testing
        // Verify the result
        // Convert using the registry
            }
        QueryContainer queryContainer = QueryContainer.newBuilder()
        QueryBuilder queryBuilder = registry.fromProto(queryContainer);
                    .setAnalyzer("standard")
                    .setFuzziness(Fuzziness.newBuilder().setString("AUTO").build())
        QueryContainer innerQueryContainer = QueryContainer.newBuilder().setTerm(termQuery).build();
                FuzzyQuery.newBuilder()
            .addTerms("important")
        QueryBuilder queryBuilder = registry.fromProto(queryContainer);
        // Create a Range query container with NumberRangeQuery
        // Verify the result
        // Convert using the registry
import org.opensearch.protobufs.MatchBoolPrefixQuery;
    public void testGeoDistanceQueryConversionWithDoubleArray() {
                // Return a simple match all query for testing
        assertNotNull("QueryBuilder should not be null", queryBuilder);
                MatchPhrasePrefixQuery.newBuilder().setField("title").setQuery("opensearch tuto").setSlop(2).setBoost(1.4f).build()
            .build();
        QueryBuilder queryBuilder = registry.fromProto(queryContainer);
            .build();
 */
                return new org.opensearch.index.query.MatchAllQueryBuilder();
import org.opensearch.protobufs.MatchQuery;
                    .addFields("title")
        // Verify the result
    }
        // Verify the result
        // Convert using the registry
        GeoLocation geoLocation = GeoLocation.newBuilder().setLatlon(latLonLocation).build();
import org.opensearch.protobufs.NumberRangeQuery;
            .setExists(ExistsQuery.newBuilder().setField("test_field").build())
        QueryBuilder queryBuilder = registry.fromProto(queryContainer);
            .setRegexp(RegexpQuery.newBuilder().setField("test_field").setValue("test.*pattern").setBoost(1.2f).build())
        // Verify the result
                return new org.opensearch.index.query.MatchAllQueryBuilder();
 *
            }
    public void testTermQueryConversion() {
                    .setField("title")
    }
import org.opensearch.protobufs.NestedQuery;
                return new org.opensearch.index.query.MatchAllQueryBuilder();
        assertEquals(
        } catch (Exception e) {
        QueryBuilder queryBuilder = registry.fromProto(queryContainer);
    public void setUp() throws Exception {
import org.opensearch.protobufs.Fuzziness;
            .build();
        QueryBuilder queryBuilder = registry.fromProto(queryContainer);
            queryBuilder.getClass().getName()
        assertNotNull("QueryBuilder should not be null", queryBuilder);
            fail("updateRegistryOnAllConverters should not throw an exception: " + e.getMessage());
        QueryContainer queryContainer = QueryContainer.newBuilder()
import org.opensearch.protobufs.IdsQuery;
        QueryContainer queryContainer = QueryContainer.newBuilder()
        // Create a Nested query container
 * this file be licensed under the Apache-2.0 license or a
    public void testNullQueryContainer() {
    }
import org.opensearch.protobufs.QueryContainer;
package org.opensearch.transport.grpc.proto.request.search.query;
        // Convert using the registry
        try {
 * The OpenSearch Contributors require contributions made to
        QueryContainer queryContainer = QueryContainer.newBuilder().setGeoBoundingBox(geoBoundingBoxQuery).build();
                    .build()
    public void testRegisterConverter() {
        // Verify the result
            "Should be a MatchNoneQueryBuilder",
import org.opensearch.protobufs.LatLonGeoLocation;
    public void testMatchQueryConversion() {
    public void testRangeQueryConversion() {
            @Override
        QueryBuilder queryBuilder = registry.fromProto(queryContainer);
    }
import org.opensearch.protobufs.GeoBounds;
        QueryContainer queryContainer = QueryContainer.newBuilder().setScript(scriptQuery).build();
import org.opensearch.protobufs.NumberRangeQueryAllOfFrom;
        // Create a MatchPhrasePrefix query container
        QueryContainer queryContainer = QueryContainer.newBuilder()
        assertNotNull("QueryBuilder should not be null", queryBuilder);
        // Create a GeoDistance query container
        );
    }
            .setBoost(1.5f)
        QueryBuilder queryBuilder = registry.fromProto(queryContainer);
import org.opensearch.protobufs.TermsQueryField;
import org.opensearch.protobufs.ChildScoreMode;
import org.opensearch.protobufs.RangeQuery;
            public QueryContainer.QueryContainerCase getHandledQueryCase() {
        // Create a Wildcard query container
import org.opensearch.protobufs.MatchPhraseQuery;
        // Verify that the registry still works after updating all converters
        // Create a Script query container with inline script
                    .setOperator(Operator.OPERATOR_OR)
        );
    public void testGeoBoundingBoxQueryConversion() {
                // Return a mock QueryBuilder for testing
        CoordsGeoBounds coords = CoordsGeoBounds.newBuilder().setTop(40.7).setLeft(-74.0).setBottom(40.6).setRight(-73.9).build();
    public void testWildcardQueryConversion() {
            }
            "Should be a TermsSetQueryBuilder",
        assertNotNull("QueryBuilder should not be null", queryBuilder);
            queryBuilder.getClass().getName()
            // If we reach here, no exception was thrown
    }
        assertEquals(
        }
            .build();
                    .build()
    public void testTermsQueryConversion() {
            .setDistance("10km")
        }
        // Verify the result
            public QueryBuilder fromProto(QueryContainer queryContainer) {
        QueryContainer queryContainer = QueryContainer.newBuilder()
        assertEquals("Should be a BoolQueryBuilder", "org.opensearch.index.query.BoolQueryBuilder", queryBuilder.getClass().getName());
    }
        try {
            }
    }
        assertNotNull("QueryBuilder should not be null", queryBuilder);
    }
        assertEquals("Should be a TermQueryBuilder", "org.opensearch.index.query.TermQueryBuilder", queryBuilder.getClass().getName());
        // Convert using the registry
        );
            registry.registerConverter(customConverter);
        try {
        FieldValue fv2 = FieldValue.newBuilder().setString("books").build();
        assertEquals("Should be a ScriptQueryBuilder", "org.opensearch.index.query.ScriptQueryBuilder", queryBuilder.getClass().getName());
 */
        GeoLocation geoLocation = GeoLocation.newBuilder().setCoords(doubleArray).build();
            }
        QueryBuilder queryBuilder = registry.fromProto(queryContainer);
            @Override
                    .setBoost(1.3f)
        NumberRangeQuery numberRangeQuery = NumberRangeQuery.newBuilder().setField("age").setFrom(fromValue).setTo(toValue).build();
import org.opensearch.protobufs.PrefixQuery;
                    .addShould(
        // Create a MatchAll query container
                                    .setField("status")
            queryBuilder.getClass().getName()
        // Create a TermsSet query container
        QueryContainer queryContainer = QueryContainer.newBuilder().setMatchAll(MatchAllQuery.newBuilder().build()).build();
    public void testIdsQueryConversion() {
        QueryContainer queryContainer = QueryContainer.newBuilder().setGeoDistance(geoDistanceQuery).build();
        // Convert using the registry
            .setExists(ExistsQuery.newBuilder().setField("test_field").setBoost(2.0f).setXName("test_exists").build())
                                    .build()
import org.opensearch.protobufs.WildcardQuery;
import org.opensearch.index.query.QueryBuilder;
        QueryBuilder queryBuilder = registry.fromProto(queryContainer);
        // Create a MatchPhrase query container
                BoolQuery.newBuilder()
            .build();
            "org.opensearch.index.query.ConstantScoreQueryBuilder",
        QueryBuilder queryBuilder = registry.fromProto(queryContainer);
        assertEquals(
        QueryContainer queryContainer = QueryContainer.newBuilder().setFunctionScore(functionScoreQuery).build();
            @Override
import org.opensearch.protobufs.GeoDistanceQuery;
    }
            queryBuilder.getClass().getName()
        QueryBuilder queryBuilder = registry.fromProto(queryContainer);
        assertEquals("Should be a TermQueryBuilder", "org.opensearch.index.query.TermQueryBuilder", queryBuilder.getClass().getName());
        // Register the custom converter
    }
            .build();
    public void testUnsupportedQueryType() {
                    .setQuery("hello world")
        QueryBuilder queryBuilder = registry.fromProto(queryContainer);
        QueryBuilder queryBuilder = registry.fromProto(queryContainer);
        );
                this.registryRef = registry;
public class QueryBuilderProtoConverterRegistryTests extends OpenSearchTestCase {
        QueryBuilder queryBuilder = registry.fromProto(queryContainer);
    }
import org.opensearch.protobufs.FieldValueArray;
        QueryContainer queryContainer = QueryContainer.newBuilder().build();
            .build();
        // Verify the result
            .setMatchPhrase(
    }
        GeoBoundingBoxQuery geoBoundingBoxQuery = GeoBoundingBoxQuery.newBuilder().putBoundingBox("location", geoBounds).build();
        // Verify the result
        assertEquals("Should be a TermsQueryBuilder", "org.opensearch.index.query.TermsQueryBuilder", queryBuilder.getClass().getName());
        // Test that registerConverter method can be called without throwing exceptions
        };
        // Create a GeoDistance query with DoubleArray format
        };
        assertNotNull("QueryBuilder should not be null", queryBuilder);
                        QueryContainer.newBuilder()
    public void testGeoDistanceQueryConversion() {
        assertNotNull("QueryBuilder should not be null", queryBuilder);
        // Verify that the registry still works after adding a converter
            "Should be a ConstantScoreQueryBuilder",
            .setTerms(org.opensearch.protobufs.TermsQuery.newBuilder().putTerms("category", termsQueryField).setBoost(1.5f).build())
        QueryContainer queryContainer = QueryContainer.newBuilder()
        // Verify the result
        QueryContainer queryContainer = QueryContainer.newBuilder().setRange(rangeQuery).build();
        // Create a GeoBoundingBox query container
            @Override
import org.opensearch.protobufs.ScriptQuery;
            queryBuilder.getClass().getName()
            public QueryBuilder fromProto(QueryContainer queryContainer) {
        // Verify the result
                    .build()
                MultiMatchQuery.newBuilder()
        QueryBuilder queryBuilder = registry.fromProto(queryContainer);
 * compatible open source license.
    public void testMultiMatchQueryConversion() {
        NumberRangeQueryAllOfFrom fromValue = NumberRangeQueryAllOfFrom.newBuilder().setDouble(10.0).build();
        assertEquals(
import org.opensearch.protobufs.GeoLocation;
        QueryContainer queryContainer = QueryContainer.newBuilder()
import org.opensearch.protobufs.FieldValue;
            // If we reach here, no exception was thrown
        QueryBuilderProtoConverter customConverter = new QueryBuilderProtoConverter() {
            "org.opensearch.index.query.MultiMatchQueryBuilder",
            .putLocation("location", geoLocation)
        // Create a Bool query container with nested queries
        NestedQuery nestedQuery = NestedQuery.newBuilder()
            "Should be a MatchAllQueryBuilder",
            registry.updateRegistryOnAllConverters();
            .build();
            .setTerm(
    public void testNullHandledQueryCase() {
                MatchBoolPrefixQuery.newBuilder()
import org.opensearch.transport.grpc.spi.QueryBuilderProtoConverter;
}
        QueryContainer queryContainer = QueryContainer.newBuilder()
            "Should be a GeoDistanceQueryBuilder",
/*
        assertEquals("Should be a RangeQueryBuilder", "org.opensearch.index.query.RangeQueryBuilder", queryBuilder.getClass().getName());
import org.opensearch.protobufs.NumberRangeQueryAllOfTo;
        QueryBuilder queryBuilder = registry.fromProto(queryContainer);
/**
        assertNotNull("QueryBuilder should not be null", queryBuilder);
        assertNotNull("QueryBuilder should not be null after register and update operations", queryBuilder);
        GeoDistanceQuery geoDistanceQuery = GeoDistanceQuery.newBuilder()
    public void testMatchNoneQueryConversion() {
        QueryBuilder queryBuilder = registry.fromProto(queryContainer);
            queryBuilder.getClass().getName()
                            .setTerm(
                TermQuery.newBuilder().setField("test_field").setValue(FieldValue.newBuilder().setString("test_value").build()).build()
                    .setBoost(1.2f)
import org.opensearch.protobufs.GeoBoundingBoxQuery;
        assertNotNull("QueryBuilder should not be null", queryBuilder);
    public void testScriptQueryConversion() {
            @Override
        expectThrows(IllegalArgumentException.class, () -> registry.fromProto(queryContainer));
        QueryBuilder queryBuilder = registry.fromProto(queryContainer);
            )
        assertNotNull("QueryBuilder should not be null", queryBuilder);
        super.setUp();
            "Should be a MatchPhraseQueryBuilder",
        registry = new QueryBuilderProtoConverterRegistryImpl();
            .build();
                return QueryContainer.QueryContainerCase.QUERYCONTAINER_NOT_SET;
import org.opensearch.protobufs.FunctionScoreQuery;
                    .setField("title")
        // Convert using the registry
    private QueryBuilderProtoConverterRegistryImpl registry;
        // Create a MultiMatch query container
        // Create a custom converter that returns null for getHandledQueryCase
    }
        }
            .setBoost(1.5f)
import org.opensearch.protobufs.DoubleArray;
    public void testUpdateRegistryOnAllConverters() {
    public void testFunctionScoreQueryConversion() {
    public void testNotSetHandledQueryCase() {
        // Convert using the registry
        QueryContainer queryContainer = QueryContainer.newBuilder().setIds(idsQuery).build();
        // Convert using the registry
            .setValue(FieldValue.newBuilder().setString("john").build())
            .build();
import org.opensearch.protobufs.MatchAllQuery;
                    .setQuery("search term")
        assertEquals(
        assertNotNull("QueryBuilder should not be null", queryBuilder);
        // Verify the result
            .build();
        // Verify the result
            private org.opensearch.transport.grpc.spi.QueryBuilderProtoConverterRegistry registryRef;
            "Should be a FunctionScoreQueryBuilder",
    }
            @Override
            .setPrefix(PrefixQuery.newBuilder().setField("name").setValue("john").setBoost(1.1f).build())
                return QueryContainer.QueryContainerCase.EXISTS; // Use existing case
        assertEquals(
            "org.opensearch.index.query.MatchPhrasePrefixQueryBuilder",
        GeoDistanceQuery geoDistanceQuery = GeoDistanceQuery.newBuilder()
        QueryBuilder queryBuilder = registry.fromProto(queryContainer);
        QueryContainer innerQueryContainer = QueryContainer.newBuilder().setTerm(termQuery).build();
            "Should be a GeoDistanceQueryBuilder",
        // Create a Regexp query container
        // Convert using the registry
        // Create a custom converter that returns QUERYCONTAINER_NOT_SET for getHandledQueryCase
                return null;
import org.opensearch.test.OpenSearchTestCase;
            queryBuilder.getClass().getName()
            .setField("status")
                // Return an exists query for testing
            "org.opensearch.index.query.MatchNoneQueryBuilder",
            .setField("tags")
        // Convert using the registry
        // Create a Term query container
            )
            .setFuzzy(
        // Convert using the registry
    public void testBoolQueryConversion() {
import org.opensearch.protobufs.TermsSetQuery;
        // Verify the result
            @Override
            .setConstantScore(ConstantScoreQuery.newBuilder().setFilter(innerQueryContainer).setBoost(2.0f).build())
    public void testPrefixQueryConversion() {
    public void testTermsSetQueryConversion() {
        // Update registry on all converters
    public void testRegisterConverterAndUpdateRegistry() {
    public void testMatchPhraseQueryConversion() {
            .addTerms("urgent")
            .setDistance("5mi")
        );
            "Should be a WildcardQueryBuilder",
        assertEquals(
        assertNotNull("QueryBuilder should not be null", queryBuilder);
        // Verify the result
        }
        TermsSetQuery termsSetQuery = TermsSetQuery.newBuilder()
            "org.opensearch.index.query.MatchAllQueryBuilder",
import org.opensearch.protobufs.Operator;
            .build();
        QueryContainer queryContainer = QueryContainer.newBuilder()
