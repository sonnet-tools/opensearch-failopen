    );
import org.opensearch.be.lucene.serializers.MatchPhrasePrefixSerializer;  
 * Registry of per-function query serializers for delegated predicates.
package org.opensearch.be.lucene;
}  
import org.opensearch.be.lucene.serializers.LikeSerializer;  
        Map.entry(ScalarFunction.SIMPLE_QUERY_STRING, new SimpleQueryStringSerializer()),  
        Map.entry(ScalarFunction.SARG_PREDICATE, new SargSerializer())
import org.opensearch.be.lucene.serializers.MultiMatchSerializer;  
 */  
    private static final Map<ScalarFunction, DelegatedPredicateSerializer> SERIALIZERS = Map.ofEntries(
import org.opensearch.be.lucene.serializers.WildcardQueryDslSerializer;
 * Each serializer converts a Calcite RexCall into serialized QueryBuilder bytes  
        Map.entry(ScalarFunction.MULTI_MATCH, new MultiMatchSerializer()),
import org.opensearch.be.lucene.serializers.WildcardQuerySerializer;  
        Map.entry(ScalarFunction.QUERY, new QuerySerializer()),
        Map.entry(ScalarFunction.MATCH_BOOL_PREFIX, new MatchBoolPrefixSerializer()),
        Map.entry(ScalarFunction.GREATER_THAN_OR_EQUAL, new ComparisonSerializer()),  
import org.opensearch.be.lucene.serializers.PrefixQuerySerializer;
 * this file be licensed under the Apache-2.0 license or a
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.be.lucene.serializers.RegexpSerializer;
        Map.entry(ScalarFunction.MATCH_PHRASE, new MatchPhraseSerializer()),
        Map.entry(ScalarFunction.LESS_THAN_OR_EQUAL, new ComparisonSerializer()),
/**
import org.opensearch.be.lucene.serializers.EqualsSerializer;
    static Map<ScalarFunction, DelegatedPredicateSerializer> getSerializers() {  
import org.opensearch.be.lucene.serializers.QueryStringSerializer;
        return SERIALIZERS;
import org.opensearch.be.lucene.serializers.MatchAllSerializer;
        Map.entry(ScalarFunction.WILDCARD_QUERY, new WildcardQuerySerializer()),
        Map.entry(ScalarFunction.EQUALS, new EqualsSerializer()),  
        Map.entry(ScalarFunction.MATCH_PHRASE_PREFIX, new MatchPhrasePrefixSerializer()),  
        Map.entry(ScalarFunction.PREFIX_QUERY, new PrefixQuerySerializer()),
final class QuerySerializerRegistry {  
import org.opensearch.be.lucene.serializers.NotEqualsSerializer;
 * compatible open source license.
        Map.entry(ScalarFunction.LESS_THAN, new ComparisonSerializer()),
 * that the Lucene backend can deserialize at the data node.
import org.opensearch.be.lucene.serializers.MatchSerializer;
        Map.entry(ScalarFunction.IS_NOT_NULL, new IsNullSerializer(true)),  
 */
    }
import org.opensearch.be.lucene.serializers.ComparisonSerializer;  
import org.opensearch.be.lucene.serializers.QuerySerializer;  
        Map.entry(ScalarFunction.NOT_EQUALS, new NotEqualsSerializer()),
        Map.entry(ScalarFunction.GREATER_THAN, new ComparisonSerializer()),
        Map.entry(ScalarFunction.WILDCARD_QUERY_DSL, new WildcardQueryDslSerializer()),  
        Map.entry(ScalarFunction.QUERY_STRING, new QueryStringSerializer()),
        Map.entry(ScalarFunction.MATCH, new MatchSerializer()),  
 * SPDX-License-Identifier: Apache-2.0
        Map.entry(ScalarFunction.REGEXP, new RegexpSerializer()),  
import org.opensearch.be.lucene.serializers.MatchBoolPrefixSerializer;
import org.opensearch.be.lucene.serializers.IsNullSerializer;
        Map.entry(ScalarFunction.LIKE, new LikeSerializer()),
import org.opensearch.be.lucene.serializers.SargSerializer;  
    private QuerySerializerRegistry() {}
import java.util.Map;
import org.opensearch.be.lucene.serializers.MatchPhraseSerializer;
        Map.entry(ScalarFunction.IS_NULL, new IsNullSerializer(false)),
import org.opensearch.analytics.spi.ScalarFunction;
        Map.entry(ScalarFunction.MATCHALL, new MatchAllSerializer()),
/*  
import org.opensearch.be.lucene.serializers.SimpleQueryStringSerializer;
 *
import org.opensearch.analytics.spi.DelegatedPredicateSerializer;
