        }
        source.query().visit(visitor);
            field,  
        if (range.from() == null && range.to() == null) {
        String field = range.fieldName();
                    return this;
        private List<QueryConstraint> constraints() {
            return List.copyOf(constraints);  
                default:  
        private final Set<String> pruningFields;
    /**
                if (constraint != null) {  
        MandatoryQueryConstraintVisitor visitor = new MandatoryQueryConstraintVisitor(pruningFields);
                    constraints.add(constraint);
            range.includeUpper(),
    }  
            range.includeLower(),  
    public List<QueryConstraint> extractMandatoryConstraints(SearchSourceBuilder source, Set<String> pruningFields) {
import java.util.ArrayList;
            }
 *
import org.apache.lucene.search.BooleanClause;
     * Extracts mandatory constraints for the configured pruning fields.
/**
}
        public QueryBuilderVisitor getChildVisitor(BooleanClause.Occur occur) {
import org.opensearch.search.builder.SearchSourceBuilder;
            this.pruningFields = pruningFields;
        if (field == null || pruningFields.contains(field) == false) {  
        return new RangeQueryConstraint(
        }  
        public void accept(QueryBuilder queryBuilder) {  
 * The extractor relies on {@link QueryBuilder#visit(QueryBuilderVisitor)} to traverse the query tree. It only follows
            if (queryBuilder instanceof RangeQueryBuilder) {
 */
            range.timeZone(),  
                }
        );
import org.opensearch.index.query.QueryBuilderVisitor;  
            range.relation()
            range.to(),
package org.opensearch.action.search.pruning;
 * children visited as {@link BooleanClause.Occur#MUST} or {@link BooleanClause.Occur#FILTER}; optional or negative  
            return null;
 * SPDX-License-Identifier: Apache-2.0
        private final List<QueryConstraint> constraints = new ArrayList<>();
            }  
 * Conservative query-tree walker that extracts constraints from mandatory query positions.  
        }  
import java.util.Set;  
                case FILTER:
    private static final class MandatoryQueryConstraintVisitor implements QueryBuilderVisitor {  
            return null;
                case MUST:  
    }
        if (source == null || source.query() == null || pruningFields == null || pruningFields.isEmpty()) {  
     */  
        return visitor.constraints();  
        }
            range.from(),
            switch (occur) {
 * this file be licensed under the Apache-2.0 license or a
        @Override  
        private MandatoryQueryConstraintVisitor(Set<String> pruningFields) {
    private static RangeQueryConstraint buildRangeConstraint(RangeQueryBuilder range, Set<String> pruningFields) {
                    return QueryBuilderVisitor.NO_OP_VISITOR;
import org.opensearch.index.query.RangeQueryBuilder;
    @Override
public final class MandatoryQueryConstraintExtractor implements QueryConstraintExtractor {  
 *
        }
 */  
    }
 * clauses are ignored because they are not required for every matching document.
        @Override
import org.opensearch.index.query.QueryBuilder;
import java.util.List;
 * compatible open source license.
        }
            range.format(),
            return List.of();
        }  
                RangeQueryConstraint constraint = buildRangeConstraint((RangeQueryBuilder) queryBuilder, pruningFields);
/*  
 * The OpenSearch Contributors require contributions made to  
