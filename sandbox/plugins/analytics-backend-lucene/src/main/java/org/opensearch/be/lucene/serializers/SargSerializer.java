            return rangeQuery(fieldName, ranges.get(0), type);
 *   <li><b>Intervals</b> ({@code col BETWEEN x AND y}, range unions) → a {@link RangeQueryBuilder} per
import org.opensearch.index.query.BoolQueryBuilder;
        }  
import org.opensearch.index.query.TermsQueryBuilder;
 * superset: {@code NOT IN} ({@link Sarg#isComplementedPoints()}), {@link Sarg#isAll()},
        String fieldName = FieldStorageInfo.resolve(fieldStorage, columnRef.getIndex()).getFieldName();  
        }  
        List<RexNode> operands = call.getOperands();
        }
import org.apache.calcite.rex.RexCall;
        if (range.hasUpperBound()) {
        }  
            throw new IllegalArgumentException("SEARCH delegation requires SEARCH($colIdx, Sarg literal); got " + call);
import org.opensearch.be.lucene.CalciteToOSMapperConversionUtils;
 *
import java.util.ArrayList;
 * compatible open source license.
import org.apache.calcite.rex.RexNode;
            for (Range r : ranges) {  
            || !(operands.get(1) instanceof RexLiteral sargLit)) {
 * <ul>  
    @Override
            qb.to(convert(range.upperEndpoint(), type), range.upperBoundType() == BoundType.CLOSED);
 * the predicate on the driving engine.  
import org.opensearch.analytics.spi.FieldStorageInfo;  
package org.opensearch.be.lucene.serializers;
/**
import java.util.List;
 *
 * capability check never marks Lucene viable for a Sarg on a numeric field.
    }  
    }
            throw new IllegalArgumentException("SEARCH second operand is not a Sarg literal: " + sargLit);
        }  
 * <p>Refuses (throws → falls back to native DataFusion) the cases that aren't a safe standalone  
import org.apache.calcite.rex.RexInputRef;
        return CalciteToOSMapperConversionUtils.sargEndpointToOpenSearchValue(endpoint, type);
 *
 *   <li><b>Points</b> ({@code col IN (a, b, c)}) → {@link TermsQueryBuilder} — exact set match.</li>
 * </ul>
/*  
            qb.from(convert(range.lowerEndpoint(), type), range.lowerBoundType() == BoundType.CLOSED);
        }
 * The OpenSearch Contributors require contributions made to  
        }  
import com.google.common.collect.Range;
    }
        if (!(sargLit.getValue() instanceof Sarg sarg)) {
 * this file be licensed under the Apache-2.0 license or a
        return qb;
 * {@link Sarg#isNone()}. The performance-delegation path tolerates a throwing serializer by leaving
            List<Object> values = new ArrayList<>(ranges.size());
 *       range (multiple ranges wrapped in a {@code should} bool), open/closed bounds preserved.</li>  
import com.google.common.collect.BoundType;
        if (sarg.isComplementedPoints() || sarg.isAll() || sarg.isNone()) {
                values.add(convert(r.lowerEndpoint(), type));
 * SPDX-License-Identifier: Apache-2.0
        for (Range r : ranges) {
        return bool;
    private static RangeQueryBuilder rangeQuery(String fieldName, Range range, RelDataType type) {
import org.opensearch.index.query.RangeQueryBuilder;
 * same-field range unions. Delegated as a <em>performance</em> pre-filter, so the Lucene query need  
import org.apache.calcite.rex.RexLiteral;  
 *
        RelDataType type = sargLit.getType();
import org.opensearch.index.query.QueryBuilder;  
import org.apache.calcite.rel.type.RelDataType;  
 */
public class SargSerializer extends AbstractQuerySerializer {
    @SuppressWarnings("rawtypes")
        if (range.hasLowerBound()) {
 * Serializer for {@code SEARCH(col, Sarg[...])} — Calcite's fold of {@code IN}, {@code BETWEEN}, and
            // NOT IN / all / none aren't a safe standalone superset — leave on DataFusion.
            bool.should(rangeQuery(fieldName, r, type));
            throw new IllegalArgumentException("Sarg shape not delegatable as a superset pre-filter: " + sarg);  
        RangeQueryBuilder qb = new RangeQueryBuilder(fieldName);  
}
        BoolQueryBuilder bool = new BoolQueryBuilder();  
        if (sarg.isPoints()) {
    @SuppressWarnings({ "rawtypes", "unchecked" })
 */  
import org.apache.calcite.util.Sarg;
        List<Range> ranges = new ArrayList<>(sarg.rangeSet.asRanges());
            }
    private static Object convert(Comparable<?> endpoint, RelDataType type) {
 * <p>Numeric/date fields can't reach here — the Lucene secondary only indexes keyword/text, so the  
            return new TermsQueryBuilder(fieldName, values);  
        if (ranges.size() == 1) {  
        if (operands.size() != 2
        }
 * only be a <b>superset</b> of matches (DataFusion re-verifies the exact predicate).
    public QueryBuilder buildQueryBuilder(RexCall call, List<FieldStorageInfo> fieldStorage) {  
            || !(operands.get(0) instanceof RexInputRef columnRef)  
