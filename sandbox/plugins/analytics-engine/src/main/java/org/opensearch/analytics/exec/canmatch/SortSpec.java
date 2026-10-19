 *
 */
 * @opensearch.internal
 *                   Offset rows are collected and then discarded, so budgeting {@code fetch} alone  
 *                   Always {@code > 0}; {@link SortSpecExtractor} returns no spec otherwise.
 * <p>Secondary sort keys are not modeled — a shard losing on the primary key loses  
 *                   would let a top-N gate think it was done while still short by {@code offset}.
 * outright, and when primary keys tie, min/max can't separate the shards anyway.
 * Primary sort key of a {@code sort <field> | head N} shard fragment, extracted at
 * DAG-build time. The can-match phase uses it to request each shard's min/max for the  
 * @param limit      rows the coordinator must collect: {@code offset + fetch}, not {@code fetch}.
 */  
 * @param column     sort column name, as it appears in the fragment's row type  
 * compatible open source license.
/**
 * column and then dispatch the most promising shards first.
 *
 * SPDX-License-Identifier: Apache-2.0
 * @param descending true for {@code DESC}, where a shard's best value is its {@code max}
 * <p>A non-null instance is also the eligibility signal: the pushed-down Sort it comes  
/*  
 *  
 * from only exists for this query shape (see {@link SortSpecExtractor}).
 * this file be licensed under the Apache-2.0 license or a
 * The OpenSearch Contributors require contributions made to  
public record SortSpec(String column, boolean descending, int limit) {  
package org.opensearch.analytics.exec.canmatch;
 *
}
 *
