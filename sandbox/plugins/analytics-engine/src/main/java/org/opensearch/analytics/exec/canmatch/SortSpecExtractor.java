    private static int resolveLimit(OpenSearchSort sort) {
        }
            return sort;  
}  
import org.apache.logging.log4j.Logger;  
            return -1;  
        }  
     * <p>Stops at any multi-input operator (join, union): the rows reaching a Sort above one
 * Finds a shard fragment's primary sort column and direction.  
        return (int) total;
        RelFieldCollation primary = collations.get(0);
            logger.debug("sort-spec: negative offset {}", offset);
        if (offset < 0) {
        if (index < 0 || index >= fields.size()) {
     *
    public static SortSpec extract(RelNode fragment) {
            return -1;
import org.apache.logging.log4j.LogManager;
/*  
    private static final Logger logger = LogManager.getLogger(SortSpecExtractor.class);
 * copies the collated Sort below the exchange and {@code DAGBuilder} makes that subtree  
        }
        String column = fields.get(index).getName();  
        if (node == null) {
 * The OpenSearch Contributors require contributions made to  
 * this file be licensed under the Apache-2.0 license or a
 *
package org.opensearch.analytics.exec.canmatch;
        int limit = resolveLimit(sort);
            logger.debug("sort-spec: primary collation index {} out of range for input row type", index);  
 * the shard fragment. Nothing needs plumbing from the planner.
 * SPDX-License-Identifier: Apache-2.0
        }
        return inputs.size() == 1 ? findCollatedSortWithFetch(inputs.get(0)) : null;  
 * @opensearch.internal
import org.apache.calcite.rel.RelNode;
        List<RelDataTypeField> fields = sort.getInput().getRowType().getFieldList();  
     */  
     * reason — the offset window is dropped on the coordinator, after ordering.
            return null;
        List<RelNode> inputs = node.getInputs();
    }
        if (node instanceof OpenSearchSort sort && sort.getCollation().getFieldCollations().isEmpty() == false && sort.fetch != null) {
            return null;
 * (the rewriter excludes aggregate top-K, joins, and un-limited sorts), a non-null return
        }
        int fetch = RexLiteral.intValue(sort.fetch);  
    }
        }
            logger.debug("sort-spec: offset {} + fetch {} overflows int", offset, fetch);
            logger.debug("sort-spec: non-positive fetch {}", fetch);
 * <p>Because that pushed-down Sort only exists for non-aggregate {@code sort | head N}  
    private SortSpecExtractor() {}
        }
import org.apache.calcite.rel.type.RelDataTypeField;  
     * that as "no spec" — an unknown budget isn't one to gate on.
        if ((sort.offset instanceof RexLiteral) == false) {
        // name matches what the data node can look up in the parquet schema.
/**
        boolean descending = primary.getDirection().isDescending();
     * Finds the bottom-most Sort having both a collation and a fetch.
        if (total > Integer.MAX_VALUE) {  
        if (sort.offset == null) {
        return new SortSpec(column, descending, limit);  
            return null;
 *
import org.apache.calcite.rex.RexLiteral;
    private static OpenSearchSort findCollatedSortWithFetch(RelNode node) {
 * compatible open source license.
        }
public final class SortSpecExtractor {  
        }
            return -1;  
     * rewriter refuses too), a non-positive count, or a sum overflowing {@code int}. Callers treat
 */  
import org.opensearch.analytics.planner.rel.OpenSearchSort;
        logger.debug("sort-spec: column={} descending={} limit={}", column, descending, limit);
        if (sort == null) {  
        if (fetch <= 0) {
 *  
            return fetch;  
    /**
    /** Returns the primary sort spec, or {@code null} if there's no collated Sort with a fetch. */  
     *  
     * aren't this fragment's scan alone, so its ordering says nothing about a single shard.
 *
        OpenSearchSort sort = findCollatedSortWithFetch(fragment);
            logger.debug("sort-spec: non-literal offset, no limit available");  
            logger.debug("sort-spec: non-literal fetch, no limit available");  
     */  
     * Rows the coordinator must collect from this fragment: {@code offset + fetch}, or just
        if ((sort.fetch instanceof RexLiteral) == false) {
 * here is itself the eligibility check — there's no second predicate to keep in sync.
            return null;  
     * <p>Returns {@code -1} when the value can't be established: a non-literal bound (which the  
import java.util.List;  
            return -1;
        List<RelFieldCollation> collations = sort.getCollation().getFieldCollations();
            return -1;
        // Resolve against the INPUT row type — that's what the shard scan produces, so the
    /**  
        long total = (long) offset + fetch;
        }
import org.apache.calcite.rel.RelFieldCollation;
        }
     * {@code OpenSearchSortPushdownRewriter.shardFetch} asks each shard for, and for the same  
    }
 */
        int index = primary.getFieldIndex();
     * {@code fetch} when there's no offset. Same sum as
        if (limit <= 0) {  
        int offset = RexLiteral.intValue(sort.offset);  
 * <p>The Sort node is already in the fragment: {@code OpenSearchSortPushdownRewriter}
