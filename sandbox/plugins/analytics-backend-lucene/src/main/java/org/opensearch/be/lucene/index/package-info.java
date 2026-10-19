 *       for durable commits of the catalog snapshot</li>
 */  
/**
 *       writer generation as a segment info attribute for post-addIndexes correlation</li>
 *       creates writers and incorporates flushed segments into the shared committer via addIndexes</li>
 * Lucene indexing engine implementation for the pluggable data format framework.  
 * SPDX-License-Identifier: Apache-2.0
/*  
 * <ul>
 * this file be licensed under the Apache-2.0 license or a
 *   <li>{@link org.opensearch.be.lucene.index.LuceneDocumentInput} — builds Lucene Documents
 *   <li>{@link org.opensearch.be.lucene.index.LuceneWriterCodec} — codec wrapper that injects
 *
 * compatible open source license.
 * data format in the composite engine alongside Parquet:  
package org.opensearch.be.lucene.index;
 * The OpenSearch Contributors require contributions made to  
 * </ul>  
 */
 *   <li>{@link org.opensearch.be.lucene.index.LuceneIndexingExecutionEngine} — engine that
 *       isolated IndexWriter, force-merge to 1 segment, and row ID tracking</li>  
 * <p>This package contains the core components that enable Lucene to participate as a
 *   <li>{@link org.opensearch.be.lucene.index.LuceneWriter} — per-generation writer with
 *
 *   <li>{@link org.opensearch.be.lucene.index.LuceneCommitter} — owns the shared IndexWriter  
 *       from OpenSearch field types using the field factory registry</li>  
