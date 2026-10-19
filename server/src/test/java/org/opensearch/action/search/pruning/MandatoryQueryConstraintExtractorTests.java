        assertTrue(constraint.includeLower());
    }
 * The OpenSearch Contributors require contributions made to  
    }
        );  
        assertFalse(constraint.includeUpper());  
        RangeQueryConstraint constraint = (RangeQueryConstraint) constraints.get(0);
        assertThat(constraint.lowerValue(), equalTo("now-2m"));  
 * compatible open source license.
        SearchSourceBuilder source = new SearchSourceBuilder().query(QueryBuilders.rangeQuery("@timestamp").gte(100L).lte(200L));
        List<QueryConstraint> constraints = extractor.extractMandatoryConstraints(source, Set.of("@timestamp"));
    public void testExtractsDateMathRangeAsRawValues() {
        assertThat(constraints.size(), equalTo(1));
        assertThat(constraints.get(0), instanceOf(RangeQueryConstraint.class));
        assertThat(constraints.get(0), instanceOf(RangeQueryConstraint.class));
            QueryBuilders.rangeQuery("@timestamp")
        List<QueryConstraint> constraints = extractor.extractMandatoryConstraints(source, Set.of("@timestamp"));
        RangeQueryConstraint constraint = (RangeQueryConstraint) constraints.get(0);
    }
    private final MandatoryQueryConstraintExtractor extractor = new MandatoryQueryConstraintExtractor();
import org.opensearch.search.builder.SearchSourceBuilder;  
        );  
    public void testDoesNotExtractRangesFromOptionalBranches() {  
        SearchSourceBuilder source = new SearchSourceBuilder().query(  
                .format("strict_date_optional_time")  
                .filter(QueryBuilders.termQuery("service.name", "api"))  
import org.opensearch.test.OpenSearchTestCase;
        assertTrue(extractor.extractMandatoryConstraints(source, Set.of("@timestamp")).isEmpty());
                .timeZone("+01:00")
            QueryBuilders.boolQuery().should(QueryBuilders.rangeQuery("@timestamp").gte(100L).lte(200L))
    public void testExtractsConfiguredRangeFromMandatoryQueryBranches() {  
        assertThat(constraint.timeZone(), equalTo("+01:00"));  
                .should(QueryBuilders.rangeQuery("ignored").gte(1L))
                .relation("within")
import org.opensearch.index.query.QueryBuilders;
        SearchSourceBuilder source = new SearchSourceBuilder().query(QueryBuilders.rangeQuery("@timestamp").gte("now-2m").lte("now"));  
            QueryBuilders.constantScoreQuery(QueryBuilders.rangeQuery("@timestamp").from(100L).to(200L))
        RangeQueryConstraint constraint = (RangeQueryConstraint) constraints.get(0);
import org.opensearch.common.geo.ShapeRelation;
        assertThat(constraint.field(), equalTo("@timestamp"));
        assertTrue(extractor.extractMandatoryConstraints(source, Set.of("@timestamp")).isEmpty());
}  
        assertThat(constraint.field(), equalTo("@timestamp"));
        assertThat(constraint.format(), equalTo("strict_date_optional_time"));
 * SPDX-License-Identifier: Apache-2.0
    }
        assertTrue(constraint.includeUpper());  
    }  
        assertTrue(extractor.extractMandatoryConstraints(source, Set.of("@timestamp")).isEmpty());  
    public void testDoesNotExtractRangesFromNegativeBranches() {  
import static org.hamcrest.Matchers.equalTo;  
                .must(QueryBuilders.rangeQuery("@timestamp").gte(100L).lt(200L))
        assertThat(constraints.size(), equalTo(1));
        );
            QueryBuilders.boolQuery()
        assertThat(constraints.size(), equalTo(1));
        assertThat(constraints.get(0), instanceOf(RangeQueryConstraint.class));
    public void testIgnoresUnconfiguredFields() {
        SearchSourceBuilder source = new SearchSourceBuilder().query(
        assertTrue(constraint.includeLower());
        SearchSourceBuilder source = new SearchSourceBuilder().query(
        List<QueryConstraint> constraints = extractor.extractMandatoryConstraints(source, Set.of("@timestamp"));
        );  
    public void testDoesNotExtractRangesFromDisMaxBranches() {
                .add(QueryBuilders.rangeQuery("@timestamp").gte(100L).lte(200L))
                .add(QueryBuilders.termQuery("service.name", "api"))  
 * this file be licensed under the Apache-2.0 license or a
            QueryBuilders.disMaxQuery()
            QueryBuilders.boolQuery().mustNot(QueryBuilders.rangeQuery("@timestamp").gte(100L).lte(200L))
package org.opensearch.action.search.pruning;
        assertThat(constraint.upperValue(), equalTo("now"));
        );  
import java.util.List;  
/*  
                .gte("2024-01-01")
 *
        assertTrue(extractor.extractMandatoryConstraints(source, Set.of("event.ingested")).isEmpty());
        assertThat(constraints.get(0).field(), equalTo("@timestamp"));
 */  
        assertThat(constraint.lowerValue(), equalTo(100L));  
        assertThat(constraints.size(), equalTo(1));
public class MandatoryQueryConstraintExtractorTests extends OpenSearchTestCase {  
        );  
        SearchSourceBuilder source = new SearchSourceBuilder().query(  
    }  
    public void testExtractsRangeQueryInterpretationOptions() {
        assertThat(constraint.relation(), equalTo(ShapeRelation.WITHIN));
    }
    }  
        assertThat(constraint.upperValue(), equalTo(200L));
        List<QueryConstraint> constraints = extractor.extractMandatoryConstraints(source, Set.of("@timestamp"));
    public void testExtractsRangeFromConstantScoreFilter() {  
        SearchSourceBuilder source = new SearchSourceBuilder().query(
import java.util.Set;
        SearchSourceBuilder source = new SearchSourceBuilder().query(
import static org.hamcrest.Matchers.instanceOf;
