 *   <li><b>Value rewriting</b> — Each source CodecReader is wrapped with  
 *   <li><b>Segment cleanup</b> — Lucene's internal merge path handles segment lifecycle:
 *
 *
 *   <li><b>Document ordering</b> — {@code addIndexes(CodecReader...)} applies the writer's  
 *       IndexSort from scratch (full sort, not merge-sort). The {@code SortedNumericSortField}
 *       {@code commitMerge} removes old segments from the live list and decrements file references.</li>
 *   <li>{@link org.opensearch.be.lucene.merge.RowIdRemappingCodecReader} — FilterCodecReader
 * this file be licensed under the Apache-2.0 license or a
 * with IndexSort-based document reordering.
 *       on the row ID field reads the already-remapped values and sorts all documents by
package org.opensearch.be.lucene.merge;
/*  
 * compatible open source license.
 *   <li>{@link org.opensearch.be.lucene.merge.RowIdRemappingDocValuesProducer} — DocValuesProducer
 * <ul>
 *       {@code ___row_id} doc values with the remapped global values from the RowIdMapping.</li>
 * </ul>  
 */  
 *
 * Lucene merge implementation for the composite engine using {@code addIndexes(CodecReader...)}  
 *       {@link org.opensearch.be.lucene.merge.RowIdRemappingCodecReader} which replaces
 * <h2>How it works</h2>  
 *       that returns remapped row ID values.</li>
 *
 *   <li>{@link org.opensearch.be.lucene.merge.LuceneMerger} — Orchestrates the merge.</li>
 * <h2>Key classes</h2>
 * <ul>  
 * SPDX-License-Identifier: Apache-2.0
 * The OpenSearch Contributors require contributions made to  
/**
 *       that remaps {@code ___row_id} doc values.</li>  
 */
 * </ul>  
 *       ascending row ID, including cross-segment interleaving and within-segment reordering.</li>  
