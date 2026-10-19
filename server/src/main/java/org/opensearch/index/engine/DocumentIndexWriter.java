import org.opensearch.index.mapper.ParseContext;
    Releasable obtainWriteLockOnAllMap();
    void deleteDocument(  
        boolean isStaleOperation,
import org.apache.lucene.index.Term;
    IndexWriter getAccumulatingIndexWriter();
    void close() throws IOException;
 *
    long commit() throws IOException;
 */  
        long primaryTerm,
        Term uid,
 *
/*  
import org.apache.lucene.document.Field;
}
        Field... softDeletesField
import org.apache.lucene.index.IndexWriter;
        List<ParseContext.Document> docs,
    long ramBytesUsed();  
import java.util.Map;
import java.io.Closeable;
import org.opensearch.common.lease.Releasable;
    boolean hasUncommittedChanges();
    Throwable getTragicException();
        ParseContext.Document doc,  
    ) throws IOException;
        long seqNo,
    long addDocument(ParseContext.Document doc, Term uid) throws IOException;
 */  
    void forceMergeDeletes(boolean doWait) throws IOException;
import org.apache.lucene.index.LiveIndexWriterConfig;  
    boolean hasNewIndexingOrUpdates();  
 * compatible open source license.
    long getFlushingBytes();  
 * this file be licensed under the Apache-2.0 license or a
import java.io.IOException;
        throws IOException;
    ) throws IOException;
    long addDocuments(List<ParseContext.Document> docs, Term uid) throws IOException;
public interface DocumentIndexWriter extends Closeable, ReferenceManager.RefreshListener {
import java.util.List;  
    void softUpdateDocuments(  
/**  
        long version,  
        long version,
    boolean isWriteLockedByCurrentThread();
        long primaryTerm,  
    Iterable<Map.Entry<String, String>> getLiveCommitData();  
    void forceMerge(int maxNumSegments, boolean doWait) throws IOException;
import org.apache.lucene.search.ReferenceManager;
 * The OpenSearch Contributors require contributions made to  
    void deleteUnusedFiles() throws IOException;  
        Field... softDeletesField  
    void maybeMerge() throws IOException;  
    LiveIndexWriterConfig getConfig();
 * SPDX-License-Identifier: Apache-2.0
    void softUpdateDocument(Term uid, ParseContext.Document doc, long version, long seqNo, long primaryTerm, Field... softDeletesField)  
        Term uid,
    boolean validateImmutableFieldNotUpdated(ParseContext.Document previousDocument, BytesRef currentUID);  
    boolean hasPendingMerges();  
 * Primary interface for document indexing operation in OpenSearch. This interface is mapped after Lucene's IndexWriter.
    long getPendingNumDocs();
        long seqNo,
    void setLiveCommitData(Iterable<Map.Entry<String, String>> commitUserData);
    void rollback() throws IOException;
import org.apache.lucene.util.BytesRef;  
package org.opensearch.index.engine;
