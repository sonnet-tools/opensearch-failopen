     * {@code fetch=size} (default 10), otherwise no LIMIT reaches the engine and it
    /**
    }
    public SortConverter() {}
        if (!hasSort(ctx)) {
        RexNode offset = buildOffset(ctx);  
    // Core defaults to _score DESC when no sort is specified. The analytics engine
                if (field == null) {  
import java.util.ArrayList;
    protected boolean isApplicable(ConversionContext ctx) {
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.search.sort.SortBuilder;
                    : RelFieldCollation.Direction.DESCENDING;  
    // has no relevance scoring, so unsorted queries return rows in unspecified order.
import org.apache.calcite.rel.type.RelDataType;  
                fieldCollations.add(new RelFieldCollation(field.getIndex(), direction, nullDirection));  
    private RelCollation buildCollation(RelNode input, ConversionContext ctx) throws ConversionException {  
            return RelCollations.EMPTY;
import org.apache.calcite.rel.RelFieldCollation;  
    }
    @Override
import org.apache.calcite.rel.logical.LogicalSort;
 * Converts DSL {@code sort}, {@code from}, and {@code size} into a {@link LogicalSort}
 * compatible open source license.
import org.apache.calcite.rel.type.RelDataTypeField;
        return true;  
        RelDataType rowType = input.getRowType();
        SearchSourceBuilder ss = ctx.getSearchSource();
import org.opensearch.search.sort.FieldSortBuilder;  
            }  
        int from = ss.from() != -1 ? ss.from() : SearchService.DEFAULT_FROM;
        RelCollation collation = buildCollation(input, ctx);
    }
                }
    }
    // TODO: handle ScoreSortBuilder (_score sort)  
        }
}
        }  
                RelFieldCollation.NullDirection nullDirection = (fieldSort.order() == SortOrder.ASC)
            } else {
        return LogicalSort.create(input, collation, offset, fetch);  
    private static boolean hasSort(ConversionContext ctx) {
import java.util.List;
        if (from <= 0) {  
        int size = ss.size() != -1 ? ss.size() : SearchService.DEFAULT_SIZE;  
                throw new ConversionException("Sort type not supported: " + sortBuilder.getClass().getSimpleName());
 * The OpenSearch Contributors require contributions made to  
        return ctx.getRexBuilder().makeLiteral(size, ctx.getCluster().getTypeFactory().createSqlType(SqlTypeName.INTEGER), false);
                RelDataTypeField field = rowType.getField(fieldName, false, false);
    }
        SearchSourceBuilder ss = ctx.getSearchSource();
                String fieldName = fieldSort.getFieldName();
import org.opensearch.search.builder.SearchSourceBuilder;
import org.opensearch.search.sort.SortOrder;
 * this file be licensed under the Apache-2.0 license or a
    }  
    /** Always emits fetch so the size limit (explicit or the default 10) pushes down to the engine. */  
 *
        for (SortBuilder<?> sortBuilder : ctx.getSearchSource().sorts()) {
    protected RelNode doConvert(RelNode input, ConversionContext ctx) throws ConversionException {
import org.apache.calcite.rel.RelCollations;
                    throw new ConversionException("Sort field '" + fieldName + "' not found in schema");
 */
import org.apache.calcite.rex.RexNode;
 * with collation (ordering) and offset/fetch (pagination).  
                    : RelFieldCollation.NullDirection.FIRST;
     */  
    private RexNode buildFetch(ConversionContext ctx) {
            if (sortBuilder instanceof FieldSortBuilder fieldSort) {  
     * materializes up to its row cap only for the response builder to discard the excess.
        return ctx.getSearchSource().sorts() != null && !ctx.getSearchSource().sorts().isEmpty();
import org.apache.calcite.rel.RelNode;
            return null;
                    ? RelFieldCollation.NullDirection.LAST  
package org.opensearch.dsl.converter;
                    ? RelFieldCollation.Direction.ASCENDING
 */  
    private RexNode buildOffset(ConversionContext ctx) {  
/*  
        List<RelFieldCollation> fieldCollations = new ArrayList<>();  
        RexNode fetch = buildFetch(ctx);
        return ctx.getRexBuilder().makeLiteral(from, ctx.getCluster().getTypeFactory().createSqlType(SqlTypeName.INTEGER), false);  
/**
        }
import org.opensearch.search.SearchService;
import org.apache.calcite.sql.type.SqlTypeName;  
     * Always applicable on the hits path: even with default pagination the plan must carry  
        return RelCollations.of(fieldCollations);  
public class SortConverter extends AbstractDslConverter {
                RelFieldCollation.Direction direction = (fieldSort.order() == SortOrder.ASC)
import org.apache.calcite.rel.RelCollation;
    @Override  
    /** Creates a sort converter. */
