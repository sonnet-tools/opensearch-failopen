                return new org.opensearch.index.query.MatchAllQueryBuilder();  
            @Override  
        DoubleArray doubleArray = DoubleArray.newBuilder()
        // Verify that the registry still works after updating all converters  
                BoolQuery.newBuilder()
import org.opensearch.protobufs.FuzzyQuery;
    public void testNotSetHandledQueryCase() {
        QueryBuilder queryBuilder = registry.fromProto(queryContainer);
    public void testNestedQueryConversion() {
        };
    }  
        QueryContainer queryContainer = QueryContainer.newBuilder()  
            "org.opensearch.index.query.MatchPhraseQueryBuilder",  
        );
    }
        assertNotNull("QueryBuilder should not be null", queryBuilder);  
        // Verify the result  
                    )  
    public void testRegexpQueryConversion() {
    public void testScriptQueryConversion() {  
        assertNotNull("QueryBuilder should not be null", queryBuilder);  
                    .setBoost(2.0f)
    public void testRangeQueryConversion() {
            queryBuilder.getClass().getName()  
        GeoBounds geoBounds = GeoBounds.newBuilder().setCoords(coords).build();
        super.setUp();  
        QueryContainer queryContainer = QueryContainer.newBuilder().setGeoBoundingBox(geoBoundingBoxQuery).build();  
    public void testExistsQueryConversion() {
            .build();
        assertEquals("Should be a RegexpQueryBuilder", "org.opensearch.index.query.RegexpQueryBuilder", queryBuilder.getClass().getName());  
                    .setOperator(Operator.OPERATOR_AND)  
        assertNotNull("QueryBuilder should not be null", queryBuilder);
        // Convert using the registry
        // Convert using the registry  
import org.opensearch.protobufs.RegexpQuery;
    }
            )
        // Create a Match query container  
        // Test that it works  
        // Create a MatchAll query container
                    .build()
                MatchQuery.newBuilder()  
            public QueryBuilder fromProto(QueryContainer queryContainer) {  
import org.opensearch.protobufs.Fuzziness;
        // Create a Range query container with NumberRangeQuery  
        );
        IdsQuery idsQuery = IdsQuery.newBuilder().addValues("doc1").addValues("doc2").setBoost(1.5f).setXName("test_ids_query").build();
        assertNotNull("QueryBuilder should not be null after register and update operations", queryBuilder);
        // Convert using the registry  
        // Convert using the registry  
    }
        // Verify the result  
                            .build()
        assertEquals("Should be a PrefixQueryBuilder", "org.opensearch.index.query.PrefixQueryBuilder", queryBuilder.getClass().getName());
        QueryBuilder queryBuilder = registry.fromProto(queryContainer);
        } catch (Exception e) {
            public org.opensearch.index.query.QueryBuilder fromProto(QueryContainer queryContainer) {
        assertEquals(
        QueryContainer innerQueryContainer = QueryContainer.newBuilder().setTerm(termQuery).build();
                    .setBoost(1.5f)
            .setMatchPhrase(
        QueryBuilder queryBuilder = registry.fromProto(queryContainer);
        assertEquals("Should be a FuzzyQueryBuilder", "org.opensearch.index.query.FuzzyQueryBuilder", queryBuilder.getClass().getName());  
    public void setUp() throws Exception {
            .build();
        assertNotNull("Result should not be null", result);
        // Verify the result
                    .setField("title")
            )
                    .setBoost(1.0f)
        // Create a GeoDistance query with DoubleArray format  
            "Should be a TermsSetQueryBuilder",
        QueryContainer queryContainer = QueryContainer.newBuilder()
            "org.opensearch.index.query.MatchPhrasePrefixQueryBuilder",  
            public QueryContainer.QueryContainerCase getHandledQueryCase() {
    @Override
            fail("updateRegistryOnAllConverters should not throw an exception: " + e.getMessage());
        // Verify the result
        NumberRangeQueryAllOfFrom fromValue = NumberRangeQueryAllOfFrom.newBuilder().setDouble(10.0).build();
            }
                    .setBoost(1.5f)
            "Should be a MatchPhrasePrefixQueryBuilder",
                    .build()
                MultiMatchQuery.newBuilder()
            .setPrefix(PrefixQuery.newBuilder().setField("name").setValue("john").setBoost(1.1f).build())  
                MatchPhraseQuery.newBuilder()  
        // Convert using the registry
            )
            "org.opensearch.index.query.GeoDistanceQueryBuilder",
            @Override  
    }
import org.opensearch.protobufs.FieldValue;
import org.opensearch.protobufs.GeoBounds;
                                    .setField("status")
                                TermQuery.newBuilder()  
        assertEquals(
import org.opensearch.protobufs.InlineScript;
        QueryBuilder queryBuilder = registry.fromProto(queryContainer);  
    }
import org.opensearch.protobufs.WildcardQuery;
                                    .build()  
            }
        // Create a custom converter for testing
            registry.registerConverter(customConverter);  
            public QueryContainer.QueryContainerCase getHandledQueryCase() {
                // Return an exists query for testing
            fail("registerConverter should not throw an exception: " + e.getMessage());
        );
import org.opensearch.test.OpenSearchTestCase;  
        QueryBuilder queryBuilder = registry.fromProto(queryContainer);  
import org.opensearch.protobufs.BoolQuery;
            .addDoubleArray(-73.9851) // lon
}
            "org.opensearch.index.query.WildcardQueryBuilder",
            @Override
    public void testTermsQueryConversion() {
        QueryContainer queryContainer = QueryContainer.newBuilder()
            .setQuery(innerQueryContainer)
        );
            .build();
        assertEquals(
import org.opensearch.protobufs.DoubleArray;
            "org.opensearch.index.query.MatchBoolPrefixQueryBuilder",
                    .build()
        QueryContainer queryContainer = QueryContainer.newBuilder()
            .setTerm(
import org.opensearch.protobufs.NestedQuery;
        QueryContainer queryContainer = QueryContainer.newBuilder()
            .setExists(ExistsQuery.newBuilder().setField("test_field").setBoost(2.0f).setXName("test_exists").build())
    }  
        QueryBuilder queryBuilder = registry.fromProto(queryContainer);
            public QueryContainer.QueryContainerCase getHandledQueryCase() {
        // Verify the result
        QueryBuilder queryBuilder = registry.fromProto(queryContainer);
        QueryContainer queryContainer = QueryContainer.newBuilder()
        assertEquals(
            .setScoreMode(ChildScoreMode.CHILD_SCORE_MODE_AVG)
            }  
    public void testConverterRegistration() {  
            )  
        assertNotNull("QueryBuilder should not be null after updating registry on all converters", queryBuilder);
            @Override
    }
                    .build()
        QueryBuilderProtoConverter customConverter = new QueryBuilderProtoConverter() {
        QueryContainer baseQuery = QueryContainer.newBuilder().setMatchAll(MatchAllQuery.newBuilder().build()).build();
        // Convert using the registry  
        );
        );  
            .build();
            .setBool(  
    public void testWildcardQueryConversion() {  
            }
        GeoBoundingBoxQuery geoBoundingBoxQuery = GeoBoundingBoxQuery.newBuilder().putBoundingBox("location", geoBounds).build();
        QueryContainer queryContainer = QueryContainer.newBuilder().setGeoDistance(geoDistanceQuery).build();
        QueryContainer queryContainer = QueryContainer.newBuilder().build();
            .setExists(ExistsQuery.newBuilder().setField("test_field").build())
        // Create a Nested query container
            "org.opensearch.index.query.MatchAllQueryBuilder",  
        QueryBuilderProtoConverter customConverter = new QueryBuilderProtoConverter() {
    }
        assertNotNull("QueryBuilder should not be null", queryBuilder);
    }  
            // If we reach here, no exception was thrown
        ScriptQuery scriptQuery = ScriptQuery.newBuilder().setScript(script).setBoost(1.5f).setXName("test_script_query").build();
            "org.opensearch.index.query.MultiMatchQueryBuilder",  
            )
                    .addMust(QueryContainer.newBuilder().setMatchAll(MatchAllQuery.newBuilder().build()).build())
        );
            .build();  
            .build();  
 * this file be licensed under the Apache-2.0 license or a
            .build();
        // Create a Prefix query container
/**  
            "Should be a MatchBoolPrefixQueryBuilder",  
    }
        // Convert using the registry
        assertEquals("Should be a BoolQueryBuilder", "org.opensearch.index.query.BoolQueryBuilder", queryBuilder.getClass().getName());
        // Convert using the registry
                    .setField("message")
 * SPDX-License-Identifier: Apache-2.0
        // Create a custom converter that returns QUERYCONTAINER_NOT_SET for getHandledQueryCase
            }  
public class QueryBuilderProtoConverterRegistryTests extends OpenSearchTestCase {  
            .build();
            @Override
    public void testMatchBoolPrefixQueryConversion() {
    }
                // No-op for test  
            queryBuilder.getClass().getName()
            "org.opensearch.index.query.ConstantScoreQueryBuilder",
        assertNotNull("QueryBuilder should not be null", queryBuilder);
    public void testFunctionScoreQueryConversion() {
        assertNotNull("QueryBuilder should not be null", queryBuilder);
            public QueryBuilder fromProto(QueryContainer queryContainer) {
                            .setTerm(
            "Should be a GeoDistanceQueryBuilder",
        // Convert using the registry
        QueryBuilderProtoConverter customConverter = new QueryBuilderProtoConverter() {
            )  
        assertEquals(  
    }  
            .setConstantScore(ConstantScoreQuery.newBuilder().setFilter(innerQueryContainer).setBoost(2.0f).build())  
import org.opensearch.protobufs.NumberRangeQueryAllOfTo;
    }  
import org.opensearch.protobufs.NumberRangeQuery;  
        QueryBuilder queryBuilder = registry.fromProto(queryContainer);
        QueryBuilder queryBuilder = registry.fromProto(queryContainer);
        assertNotNull("QueryBuilder should not be null", queryBuilder);
            @Override
        expectThrows(IllegalArgumentException.class, () -> registry.fromProto(null));  
                return QueryContainer.QueryContainerCase.MATCH_ALL;
                    .setValue(FieldValue.newBuilder().setString("opensearch").build())  
            "Should be a MatchNoneQueryBuilder",
        QueryBuilder queryBuilder = registry.fromProto(queryContainer);
import org.opensearch.protobufs.TextQueryType;
            .setRegexp(RegexpQuery.newBuilder().setField("test_field").setValue("test.*pattern").setBoost(1.2f).build())
        QueryContainer queryContainer = QueryContainer.newBuilder()
            .build();  
    }  
        assertNotNull("QueryBuilder should not be null", queryBuilder);
import org.opensearch.protobufs.TermQuery;
                    .setQuery(FieldValue.newBuilder().setString("hello world").build())
            .setValue(FieldValue.newBuilder().setString("john").build())
        // Verify the result
        QueryContainer queryContainer = QueryContainer.newBuilder()
        // Test that registerConverter method can be called without throwing exceptions  
                    .addShould(  
        assertEquals("Should be an ExistsQueryBuilder", "org.opensearch.index.query.ExistsQueryBuilder", queryBuilder.getClass().getName());  
        QueryContainer queryContainer = QueryContainer.newBuilder().setRange(rangeQuery).build();
        // Create a Term query container  
import org.opensearch.protobufs.ScriptQuery;  
            @Override  
            .setXName("location")  
            queryBuilder.getClass().getName()
    }
        assertNotNull("QueryBuilder should not be null after registering custom converter", queryBuilder);  
            .setMatch(
            }
                TermQuery.newBuilder().setField("test_field").setValue(FieldValue.newBuilder().setString("test_value").build()).build()  
        QueryBuilder queryBuilder = registry.fromProto(queryContainer);
                                    .setValue(FieldValue.newBuilder().setString("active").build())
        // Convert using the registry
        // Verify the result
            public QueryContainer.QueryContainerCase getHandledQueryCase() {
        QueryContainer queryContainer = QueryContainer.newBuilder().setMatchAll(MatchAllQuery.newBuilder().build()).build();  
            "Should be a GeoDistanceQueryBuilder",
            public QueryContainer.QueryContainerCase getHandledQueryCase() {  
        assertNotNull("QueryBuilder should not be null", queryBuilder);  
        };
    public void testMatchAllQueryConversion() {
        // Verify the result  
        assertNotNull("QueryBuilder should not be null", queryBuilder);
            }  
    public void testMatchPhrasePrefixQueryConversion() {  
        QueryBuilder queryBuilder = registry.fromProto(queryContainer);
import org.opensearch.protobufs.IdsQuery;
        assertNotNull("QueryBuilder should not be null", queryBuilder);  
        QueryContainer queryContainer = QueryContainer.newBuilder()
        // Create a TermsSet query container
            "org.opensearch.index.query.functionscore.FunctionScoreQueryBuilder",  
        // Verify the result
                return QueryContainer.QueryContainerCase.MATCH_ALL; // Use existing case for simplicity
            .build();  
import org.opensearch.protobufs.GeoBoundingBoxQuery;  
            private org.opensearch.transport.grpc.spi.QueryBuilderProtoConverterRegistry registryRef;  
        assertNotNull("QueryBuilder should not be null", queryBuilder);  
            @Override
        // Create a Terms query container
            .build();
        // Create a MatchBoolPrefix query container  
        FunctionScoreQuery functionScoreQuery = FunctionScoreQuery.newBuilder()  
            queryBuilder.getClass().getName()
        assertEquals(  
    }  
        // Create a custom converter that returns null for getHandledQueryCase  
        // Verify the result
            public void setRegistry(org.opensearch.transport.grpc.spi.QueryBuilderProtoConverterRegistry registry) {
            }  
            @Override  
        // Verify the result  
    public void testUpdateRegistryOnAllConverters() {  
        NumberRangeQueryAllOfTo toValue = NumberRangeQueryAllOfTo.newBuilder().setDouble(100.0).build();
    public void testNullQueryContainer() {
    public void testIdsQueryConversion() {  
import org.opensearch.protobufs.MatchAllQuery;
    }
        registry.registerConverter(customConverter);
    public void testTermQueryConversion() {
            queryBuilder.getClass().getName()
        // Convert using the registry  
            .build();
            @Override
        QueryBuilder queryBuilder = registry.fromProto(queryContainer);
 *
        assertEquals(
        RangeQuery rangeQuery = RangeQuery.newBuilder().setNumberRangeQuery(numberRangeQuery).build();  
        QueryBuilder result = registry.fromProto(queryContainer);  
    }  
        registry = new QueryBuilderProtoConverterRegistryImpl();
        TermQuery termQuery = TermQuery.newBuilder()
            queryBuilder.getClass().getName()
        LatLonGeoLocation latLonLocation = LatLonGeoLocation.newBuilder().setLat(40.7589).setLon(-73.9851).build();
        // Create a Term query as inner query for the nested query
                return new org.opensearch.index.query.MatchAllQueryBuilder();
            "Should be a GeoBoundingBoxQueryBuilder",
            .setXName("test_nested_query")
        } catch (Exception e) {
import org.opensearch.protobufs.GeoDistanceQuery;
        QueryContainer queryContainer = QueryContainer.newBuilder().setNested(nestedQuery).build();
        }  
                    .addFields("title")
                return new org.opensearch.index.query.ExistsQueryBuilder("test_field");  
    }
            "org.opensearch.index.query.MatchNoneQueryBuilder",
        QueryContainer queryContainer = QueryContainer.newBuilder().setTermsSet(termsSetQuery).build();
import org.opensearch.protobufs.TermsSetQuery;  
 * Test class for QueryBuilderProtoConverterRegistry to verify the map-based optimization.
            .build();  
        QueryContainer queryContainer = QueryContainer.newBuilder().setFunctionScore(functionScoreQuery).build();  
            .setQuery(baseQuery)
        // Convert using the registry  
        assertNotNull("QueryBuilder should not be null", queryBuilder);
        QueryBuilder queryBuilder = registry.fromProto(queryContainer);  
        };
            "Should be a MatchPhraseQueryBuilder",
        assertEquals("Should be a NestedQueryBuilder", "org.opensearch.index.query.NestedQueryBuilder", queryBuilder.getClass().getName());
                    .setField("title")
                    .setType(TextQueryType.TEXT_QUERY_TYPE_BEST_FIELDS)  
            .build();
        assertEquals("Should be an ExistsQueryBuilder", "org.opensearch.index.query.ExistsQueryBuilder", queryBuilder.getClass().getName());
        // Verify the result
    public void testMatchPhraseQueryConversion() {
    public void testNullHandledQueryCase() {
                return new org.opensearch.index.query.MatchAllQueryBuilder();
            .build();
            .setWildcard(WildcardQuery.newBuilder().setField("test_field").setValue("test*pattern").setBoost(0.8f).build())  
            public org.opensearch.index.query.QueryBuilder fromProto(QueryContainer queryContainer) {  
import org.opensearch.protobufs.CoordsGeoBounds;
    }
            // If we reach here, no exception was thrown  
        // Verify the result
                    .setField("title")
            .setMultiMatch(
    }
        };
 * compatible open source license.
        expectThrows(IllegalArgumentException.class, () -> registry.registerConverter(customConverter));  
        );
            .addTerms("important")
    public void testConstantScoreQueryConversion() {
    }
        try {
        QueryBuilder queryBuilder = registry.fromProto(queryContainer);
        NumberRangeQuery numberRangeQuery = NumberRangeQuery.newBuilder().setField("age").setFrom(fromValue).setTo(toValue).build();
                    .setOperator(Operator.OPERATOR_OR)  
        // Convert using the registry
                    .build()  
        QueryContainer queryContainer = QueryContainer.newBuilder()
        // Convert using the registry
        TermQuery termQuery = TermQuery.newBuilder()  
            .setDistance("10km")
    public void testGeoDistanceQueryConversionWithDoubleArray() {
import org.opensearch.protobufs.LatLonGeoLocation;  
        TermsQueryField termsQueryField = TermsQueryField.newBuilder().setValue(fva).build();  
    public void testPrefixQueryConversion() {  
 */
            queryBuilder.getClass().getName()  
        // Verify the result  
        // Verify the result  
        QueryBuilder queryBuilder = registry.fromProto(queryContainer);  
        // Convert using the registry
    public void testNullConverter() {
    }
        assertNotNull("QueryBuilder should not be null", queryBuilder);
                return new org.opensearch.index.query.MatchAllQueryBuilder();
    public void testMultiMatchQueryConversion() {
    }
                    .addFields("content")
        // Verify the result
        // Create an Exists query container  
        } catch (Exception e) {
import org.opensearch.protobufs.NumberRangeQueryAllOfFrom;
                    .setBoost(1.2f)
            // If we reach here, no exception was thrown
            "Should be a MultiMatchQueryBuilder",
            .build();
        GeoDistanceQuery geoDistanceQuery = GeoDistanceQuery.newBuilder()
            }  
            .setFuzzy(  
        QueryContainer queryContainer = QueryContainer.newBuilder()
        // Create a FunctionScore query container with a base MatchAll query  
        // Test that updateRegistryOnAllConverters method can be called without throwing exceptions
        Script script = Script.newBuilder().setInline(InlineScript.newBuilder().setSource("doc['field'].value > 100").build()).build();
            }
        QueryBuilder queryBuilder = registry.fromProto(queryContainer);
import org.opensearch.protobufs.MinimumShouldMatch;  
        QueryContainer queryContainer = QueryContainer.newBuilder().setGeoDistance(geoDistanceQuery).build();
        // Create a GeoDistance query container  
        // Update registry on all converters  
                FuzzyQuery.newBuilder()
        expectThrows(IllegalArgumentException.class, () -> registry.fromProto(queryContainer));  
    }
                    .setMinimumShouldMatch(MinimumShouldMatch.newBuilder().setString("75%").build())
        assertEquals(
    }  
        QueryContainer queryContainer = QueryContainer.newBuilder().setScript(scriptQuery).build();  
import org.opensearch.protobufs.FieldValueArray;
        // Create a Script query container with inline script
import org.opensearch.protobufs.ChildScoreMode;
        QueryContainer queryContainer = QueryContainer.newBuilder()  
                    .setXName("test_multimatch_query")  
        QueryContainer innerQueryContainer = QueryContainer.newBuilder().setTerm(termQuery).build();  
        GeoLocation geoLocation = GeoLocation.newBuilder().setCoords(doubleArray).build();  
        expectThrows(IllegalArgumentException.class, () -> registry.registerConverter(null));
        QueryBuilder queryBuilder = registry.fromProto(queryContainer);  
        QueryContainer queryContainer = QueryContainer.newBuilder()
            queryBuilder.getClass().getName()  
        assertNotNull("QueryBuilder should not be null", queryBuilder);
        // Create an empty query container (no query type set)
        // Convert using the registry
            .build();
        // Create a Regexp query container
            .setMatchBoolPrefix(
            .setField("user.name")
            }
            )
            .addTerms("urgent")
        GeoLocation geoLocation = GeoLocation.newBuilder().setLatlon(latLonLocation).build();  
import org.opensearch.index.query.QueryBuilder;  
        assertNotNull("QueryBuilder should not be null", queryBuilder);  
                MatchPhrasePrefixQuery.newBuilder().setField("title").setQuery("opensearch tuto").setSlop(2).setBoost(1.4f).build()
        // Create a MatchPhrasePrefix query container
                this.registryRef = registry;
import org.opensearch.protobufs.FunctionScoreQuery;  
        // Convert using the registry
            .setField("status")
        // Create an Ids query container
            .build();
                    .setBoost(1.3f)
    }
            queryBuilder.getClass().getName()
            .build();
            "Should be a MatchAllQueryBuilder",
            queryBuilder.getClass().getName()
        // Create a Wildcard query container
            .setXName("test_terms_set_query")
            queryBuilder.getClass().getName()
        // Create a MatchPhrase query container  
        QueryBuilder queryBuilder = registry.fromProto(queryContainer);
        assertEquals(  
            registry.registerConverter(customConverter);
            "Should be a WildcardQueryBuilder",  
        // Create a GeoBoundingBox query container
                // Return a mock QueryBuilder for testing
import org.opensearch.protobufs.QueryContainer;
        );  
            .putLocation("location", geoLocation)
                    .setAnalyzer("standard")  
            queryBuilder.getClass().getName()  
        // Register the custom converter  
            // If we reach here, no exception was thrown  
        // Verify the result  
            .setMatchPhrasePrefix(  
            )  
        // Create a Bool query container with nested queries
        // Verify the result  
        // Verify the result
        } catch (Exception e) {
        assertNotNull("QueryBuilder should not be null", queryBuilder);
import org.opensearch.protobufs.RangeQuery;  
            .build();
    public void testGeoDistanceQueryConversion() {
        }  
            .setBoost(1.5f)  
            registry.updateRegistryOnAllConverters();
            .putLocation("location", geoLocation)
    }  
        // Verify the result
    }  
    }
        // Convert using the registry
        // Convert using the registry  
        try {
        QueryContainer queryContainer = QueryContainer.newBuilder()
        QueryBuilder queryBuilder = registry.fromProto(queryContainer);
            .build();  
        QueryContainer queryContainer = QueryContainer.newBuilder()
        QueryContainer queryContainer = QueryContainer.newBuilder().setIds(idsQuery).build();
            .setValue(FieldValue.newBuilder().setString("active").build())  
        GeoDistanceQuery geoDistanceQuery = GeoDistanceQuery.newBuilder()
            public void setRegistry(org.opensearch.transport.grpc.spi.QueryBuilderProtoConverterRegistry registry) {  
import org.opensearch.protobufs.PrefixQuery;
        assertEquals("Should be a TermQueryBuilder", "org.opensearch.index.query.TermQueryBuilder", queryBuilder.getClass().getName());  
            queryBuilder.getClass().getName()
import org.opensearch.protobufs.MatchBoolPrefixQuery;
                return null;
        }
            public QueryBuilder fromProto(QueryContainer queryContainer) {
        assertNotNull("QueryBuilder should not be null", queryBuilder);
 */  
        assertEquals(
            .setMinimumShouldMatchField("tag_count")  
import org.opensearch.protobufs.GeoLocation;  
package org.opensearch.transport.grpc.proto.request.search.query;
        assertNotNull("QueryBuilder should not be null", queryBuilder);  
        NestedQuery nestedQuery = NestedQuery.newBuilder()
            registry.updateRegistryOnAllConverters();  
        QueryContainer queryContainer = QueryContainer.newBuilder().setMatchAll(MatchAllQuery.newBuilder().build()).build();  
        // Create a ConstantScore query container with a term query inside  
    private QueryBuilderProtoConverterRegistryImpl registry;
        FieldValueArray fva = FieldValueArray.newBuilder().addFieldValueArray(fv1).addFieldValueArray(fv2).build();
        QueryBuilder queryBuilder = registry.fromProto(queryContainer);
            .build();  
                return QueryContainer.QueryContainerCase.QUERYCONTAINER_NOT_SET;  
        // Create a custom converter for testing
        assertEquals("Should be a TermsQueryBuilder", "org.opensearch.index.query.TermsQueryBuilder", queryBuilder.getClass().getName());
        try {
        // Verify the result
            .build();  
            "Should be a FunctionScoreQueryBuilder",
                return QueryContainer.QueryContainerCase.EXISTS; // Use existing case  
import org.opensearch.protobufs.TermsQueryField;
            .setXName("location")  
            "Should be a ConstantScoreQueryBuilder",  
            .setField("tags")  
/*  
        expectThrows(IllegalArgumentException.class, () -> registry.registerConverter(customConverter));
    }
        // Convert using the registry
        QueryBuilder queryBuilder = registry.fromProto(queryContainer);
        assertEquals("Should be an IdsQueryBuilder", "org.opensearch.index.query.IdsQueryBuilder", queryBuilder.getClass().getName());
        );
            )
    public void testGeoBoundingBoxQueryConversion() {
        QueryBuilder queryBuilder = registry.fromProto(queryContainer);
            .setTerm(
        );
import org.opensearch.protobufs.Script;
                TermQuery.newBuilder().setField("test_field").setValue(FieldValue.newBuilder().setString("test_value").build()).build()  
            .setTerms(org.opensearch.protobufs.TermsQuery.newBuilder().putTerms("category", termsQueryField).setBoost(1.5f).build())  
                            )
            "org.opensearch.index.query.GeoDistanceQueryBuilder",
            @Override
        // Test the combination of registering a converter and then updating the registry
        assertEquals("Should be a ScriptQueryBuilder", "org.opensearch.index.query.ScriptQueryBuilder", queryBuilder.getClass().getName());
                    .setSlop(2)
import org.opensearch.transport.grpc.spi.QueryBuilderProtoConverter;
        // Convert using the registry  
    public void testUnsupportedQueryType() {  
    public void testTermsSetQueryConversion() {  
            .build();
        TermsSetQuery termsSetQuery = TermsSetQuery.newBuilder()
        QueryBuilderProtoConverter customConverter = new QueryBuilderProtoConverter() {  
        // Verify the result
        QueryBuilder queryBuilder = registry.fromProto(queryContainer);
        // Create a Fuzzy query container
            .addDoubleArray(40.7589)  // lat  
        QueryContainer queryContainer = QueryContainer.newBuilder()
        assertNotNull("QueryBuilder should not be null", queryBuilder);  
        assertEquals("Should be a RangeQueryBuilder", "org.opensearch.index.query.RangeQueryBuilder", queryBuilder.getClass().getName());  
        QueryBuilder queryBuilder = registry.fromProto(queryContainer);  
        QueryBuilder queryBuilder = registry.fromProto(queryContainer);  
        // Convert using the registry  
        FieldValue fv1 = FieldValue.newBuilder().setString("electronics").build();  
        assertNotNull("QueryBuilder should not be null", queryBuilder);
        QueryBuilder queryBuilder = registry.fromProto(queryContainer);  
    public void testFuzzyQueryConversion() {  
        // Convert using the registry
        }
            .setPath("user")  
        CoordsGeoBounds coords = CoordsGeoBounds.newBuilder().setTop(40.7).setLeft(-74.0).setBottom(40.6).setRight(-73.9).build();  
        // Create a MultiMatch query container
        QueryContainer queryContainer = QueryContainer.newBuilder()  
        assertEquals(
            "org.opensearch.index.query.TermsSetQueryBuilder",
        QueryContainer queryContainer = QueryContainer.newBuilder().setMatchAll(MatchAllQuery.newBuilder().build()).build();
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.protobufs.MultiMatchQuery;
        );
        assertNotNull("QueryBuilder should not be null", queryBuilder);
        assertEquals(
        // Verify the result
    }  
import org.opensearch.protobufs.Operator;  
        try {
import org.opensearch.protobufs.ExistsQuery;  
        // Verify the result  
        // Convert using the registry
                    .setXName("test_matchphrase_query")  
            fail("updateRegistryOnAllConverters should not throw an exception: " + e.getMessage());  
                    .setQuery("search term")  
            .setBoost(2.0f)
        assertNotNull("QueryBuilder should not be null", queryBuilder);
import org.opensearch.protobufs.MatchPhrasePrefixQuery;  
    }  
            .setMatchNone(org.opensearch.protobufs.MatchNoneQuery.newBuilder().build())
                // Return a simple match all query for testing
        assertEquals("Should be a TermQueryBuilder", "org.opensearch.index.query.TermQueryBuilder", queryBuilder.getClass().getName());  
            "org.opensearch.index.query.GeoBoundingBoxQueryBuilder",  
                    .build()
            }
        QueryBuilder queryBuilder = registry.fromProto(queryContainer);
    public void testMatchNoneQueryConversion() {  
    public void testBoolQueryConversion() {  
            fail("registerConverter should not throw an exception: " + e.getMessage());  
import org.opensearch.protobufs.MatchPhraseQuery;
        QueryBuilderProtoConverter customConverter = new QueryBuilderProtoConverter() {  
        FieldValue fv2 = FieldValue.newBuilder().setString("books").build();
        // Verify the result
                    .setQuery("hello world")
            .setDistance("5mi")
import org.opensearch.protobufs.MatchQuery;
    public void testMatchQueryConversion() {
            .setXName("test_function_score_query")  
            .build();  
        // Verify that the registry still works after both operations
        assertEquals(  
        };
            @Override
                        QueryContainer.newBuilder()
    public void testRegisterConverter() {
                    .setFuzziness(Fuzziness.newBuilder().setString("AUTO").build())
                    .setQuery("opensearch tutorial")
        // Verify that the registry still works after adding a converter
            .setBoost(1.5f)
    public void testRegisterConverterAndUpdateRegistry() {  
        assertEquals("Should be a MatchQueryBuilder", "org.opensearch.index.query.MatchQueryBuilder", queryBuilder.getClass().getName());
    }
        // Register the custom converter
                MatchBoolPrefixQuery.newBuilder()  
import org.opensearch.protobufs.ConstantScoreQuery;  
        assertNotNull("QueryBuilder should not be null", queryBuilder);
        );  
        assertNotNull("QueryBuilder should not be null", queryBuilder);
