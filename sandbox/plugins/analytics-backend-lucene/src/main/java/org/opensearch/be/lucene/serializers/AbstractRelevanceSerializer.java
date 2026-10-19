    protected static final String PARAM_REWRITE = "rewrite";  
        Map<String, String> params = ConversionUtils.extractOptionalParams(call, optionalParamsStartIndex());
 */
    protected abstract QueryBuilder createQueryBuilder(ConversionUtils.RelevanceOperands operands);
 * literal/pattern classification to {@link RelevanceFieldExtractor} (which decides per function whether  
    protected int optionalParamsStartIndex() {
 * SPDX-License-Identifier: Apache-2.0
 * Base class for relevance function serializers ({@code query_string}, {@code simple_query_string},
        return RelevanceFieldExtractor.referencedFields(functionName(), operands, params);
 */  
        ConversionUtils.RelevanceOperands operands = ConversionUtils.extractRelevanceOperands(call, fieldStorage);
    }
 * The OpenSearch Contributors require contributions made to  
 * <p>It also implements {@link org.opensearch.analytics.spi.DelegatedPredicateSerializer#referencedFields}  
    protected abstract String functionName();  
        ConversionUtils.RelevanceOperands operands = ConversionUtils.extractRelevanceOperands(call, fieldStorage);
            throw new IllegalArgumentException(functionName() + " requires 'field' and 'query' parameters");  
import org.opensearch.be.lucene.ConversionUtils;
        return qb;  
 * compatible open source license.
    }
        applyParams(qb, params);
import java.util.List;
/*  
 *
        validate(operands);
import org.opensearch.analytics.spi.FieldReferences;
import org.opensearch.index.query.QueryBuilder;
 * shape — but only orchestrates: it extracts the operands and delegates the actual field parsing and
import java.util.Map;
 * query builder, and applying optional parameters.
    public final QueryBuilder buildQueryBuilder(RexCall call, List<FieldStorageInfo> fieldStorage) {  
        Map<String, String> params = ConversionUtils.extractOptionalParams(call, optionalParamsStartIndex());  
 *
    @Override  
 * {@code multi_match}). Handles the common pattern of extracting operands, validating, creating the  
        }
public abstract class AbstractRelevanceSerializer extends AbstractQuerySerializer {
    }
import org.apache.calcite.rex.RexCall;
    protected void validate(ConversionUtils.RelevanceOperands operands) {
        QueryBuilder qb = createQueryBuilder(operands);  
import org.opensearch.analytics.spi.FieldStorageInfo;  
    public final FieldReferences referencedFields(RexCall call, List<FieldStorageInfo> fieldStorage) {
 * to parse the query string for in-string fields). Both {@link #buildQueryBuilder} and
    @Override
package org.opensearch.be.lucene.serializers;
    protected static final String PARAM_CASE_INSENSITIVE = "case_insensitive";
    protected void applyParams(QueryBuilder qb, Map<String, String> params) {}
 * {@code referencedFields} read operands through {@link ConversionUtils#extractRelevanceOperands}, so
/**
        if (operands.fieldName() == null || operands.query() == null) {
}
    // Optional-param keys shared with the translator's MAP operand keys — a mismatch silently drops the param.
    }  
 * for these functions — the serializer is the single place that understands the predicate's operand
 * plan-time field extraction can never drift from execution.  
        return 2;
 * this file be licensed under the Apache-2.0 license or a
