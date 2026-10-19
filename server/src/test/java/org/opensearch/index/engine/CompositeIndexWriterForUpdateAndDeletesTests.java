            refresher.join();
            compositeIndexWriter.addDocuments(operation.docs(), operation.uid());
        CompositeIndexWriter compositeIndexWriter = null;  
                createWriter(),
            } catch (Exception ignored) {}
            );  
            compositeIndexWriter.softUpdateDocuments(operation.uid(), operation.docs(), 2, 2, primaryTerm.get(), softDeletesField);  
                createWriter(),  
    }
        AtomicBoolean run = new AtomicBoolean(true);
            compositeIndexWriter.beforeRefresh();  
            latch.countDown();
            compositeIndexWriter = new CompositeIndexWriter(
                indexWriterFactory  
            compositeIndexWriter.afterRefresh(true);
                newDeleteTombstoneDoc(id),
import java.util.concurrent.atomic.AtomicBoolean;  
            try (DirectoryReader directoryReader = DirectoryReader.open(compositeIndexWriter.getAccumulatingIndexWriter())) {
            }
public class CompositeIndexWriterForUpdateAndDeletesTests extends CriteriaBasedCompositeIndexWriterBaseTests {
            }
        try {
            compositeIndexWriter.addDocuments(operation.docs(), operation.uid());  
                primaryTerm.get(),
        try {
                softDeletesField,
            compositeIndexWriter.softUpdateDocuments(operation.uid(), operation.docs(), 2, 2, primaryTerm.get(), softDeletesField);  
            );  
            try (DirectoryReader directoryReader = DirectoryReader.open(compositeIndexWriter.getAccumulatingIndexWriter())) {
            indexWriterFactory  
            if (compositeIndexWriter != null) {  
                IOUtils.closeWhileHandlingException(compositeIndexWriter);
                config(),
        CompositeIndexWriter compositeIndexWriter = new CompositeIndexWriter(
import java.io.IOException;
            }  
}
        } finally {  
            }
                indexWriterFactory  
import org.apache.lucene.index.DirectoryReader;
            try {
            }
        final String id = "test";
            softDeletesField,
            try (DirectoryReader directoryReader = DirectoryReader.open(compositeIndexWriter.getAccumulatingIndexWriter())) {
        Engine.Index operation = indexForDoc(createParsedDoc(id, null, DEFAULT_CRITERIA));  
        CountDownLatch latch = new CountDownLatch(1);
                createWriter(),
            compositeIndexWriter = new CompositeIndexWriter(
        CompositeIndexWriter compositeIndexWriter = null;  
        }  
        } finally {
 * SPDX-License-Identifier: Apache-2.0
            operation = indexForDoc(createParsedDoc(id, null, DEFAULT_CRITERIA));
            compositeIndexWriter.beforeRefresh();
    public void testDeleteWithDocumentInChildWriter() throws IOException {  
    public void testDeleteWithDocumentInOldChildWriter() throws IOException, InterruptedException {
        CompositeIndexWriter compositeIndexWriter = null;
        CompositeIndexWriter compositeIndexWriter = null;
/*  
            if (compositeIndexWriter != null) {
            compositeIndexWriter.afterRefresh(true);
            compositeIndexWriter.beforeRefresh();  
 */  
            compositeIndexWriter.deleteDocument(
        final String id = "test";
        final String id = "test";
        });
package org.opensearch.index.engine;
            compositeIndexWriter.afterRefresh(true);  
        compositeIndexWriter.addDocuments(operation.docs(), operation.uid());
                2,  
            compositeIndexWriter.afterRefresh(true);
            compositeIndexWriter.deleteDocument(
                newSoftDeletesPolicy(),
        }
                softDeletesField,
            try (DirectoryReader directoryReader = DirectoryReader.open(compositeIndexWriter.getAccumulatingIndexWriter())) {  
                softDeletesField  
        try {  
                2,  
            compositeIndexWriter.addDocuments(operation.docs(), operation.uid());  
            compositeIndexWriter.beforeRefresh();  
                indexWriterFactory
            operation = indexForDoc(createParsedDoc(id, null, DEFAULT_CRITERIA));
                IOUtils.closeWhileHandlingException(compositeIndexWriter);
                IOUtils.closeWhileHandlingException(compositeIndexWriter);
            latch.await();  
        final String id = "test";
import java.util.concurrent.CountDownLatch;
            Engine.Index operation = indexForDoc(createParsedDoc(id, null, DEFAULT_CRITERIA));
                1,  
    public void testDeleteWithDocumentInParentWriter() throws IOException {
                operation.uid(),
                1,
                indexWriterFactory  
                indexWriterFactory
            compositeIndexWriter.beforeRefresh();
                false,  
        CompositeIndexWriter compositeIndexWriter = null;
            compositeIndexWriter.beforeRefresh();
                primaryTerm.get(),
    }  
        final String id = "test";  
    public void testUpdateWithDocumentInParentIndexWriter() throws IOException {
        } finally {
                primaryTerm.get(),
        } finally {
            compositeIndexWriter.addDocuments(operation.docs(), operation.uid());
            createWriter(),  
                IOUtils.close(compositeIndexWriter);
            );
                config(),
            compositeIndexWriter.afterRefresh(true);  
                assertEquals(1, directoryReader.numDocs());
                IOUtils.closeWhileHandlingException(compositeIndexWriter);  
                operation.uid(),  
            config(),
                newSoftDeletesPolicy(),
                createWriter(),  
                1,
                assertEquals(0, directoryReader.numDocs());  
        }  
            }
            compositeIndexWriter.beforeRefresh();
    public void testUpdateWithDocumentInChildIndexWriter() throws IOException {  
 * The OpenSearch Contributors require contributions made to  
            compositeIndexWriter.afterRefresh(true);
                assertEquals(0, directoryReader.numDocs());  
            Engine.Index operation = indexForDoc(createParsedDoc(id, null, DEFAULT_CRITERIA));
            Engine.Index operation = indexForDoc(createParsedDoc(id, null, DEFAULT_CRITERIA));  
        try {
                false,  
            compositeIndexWriter.afterRefresh(true);
                operation.uid(),
        try {  
            Engine.Index operation = indexForDoc(createParsedDoc(id, null, DEFAULT_CRITERIA));  
            }
    public void testDeleteWithDocumentInBothChildAndParentWriter() throws IOException {  
                assertEquals(0, directoryReader.numDocs());
                softDeletesField
                newSoftDeletesPolicy(),
                softDeletesField
 * compatible open source license.
            newSoftDeletesPolicy(),
        try {  
        } finally {
                softDeletesField,  
                softDeletesField
            compositeIndexWriter.beforeRefresh();  
                config(),  
        }
            compositeIndexWriter.beforeRefresh();  
            );  
                softDeletesField,
                createWriter(),  
        CompositeIndexWriter.CriteriaBasedIndexWriterLookup lock = compositeIndexWriter.acquireNewReadLock();  
                assertEquals(1, directoryReader.numDocs());  
    }
            try (DirectoryReader directoryReader = DirectoryReader.open(compositeIndexWriter.getAccumulatingIndexWriter())) {
                newDeleteTombstoneDoc(id),
            compositeIndexWriter.softUpdateDocuments(operation.uid(), operation.docs(), 2, 2, primaryTerm.get(), softDeletesField);
            compositeIndexWriter = new CompositeIndexWriter(
            compositeIndexWriter = new CompositeIndexWriter(
            Engine.Index operation = indexForDoc(createParsedDoc(id, null, DEFAULT_CRITERIA));
import org.opensearch.common.util.io.IOUtils;
            operation = indexForDoc(createParsedDoc(id, null, DEFAULT_CRITERIA));
    }
    }
                false,  
            );
 *
                newDeleteTombstoneDoc(id),
                2,  
            if (compositeIndexWriter != null) {  
        );
            compositeIndexWriter.afterRefresh(true);  
                2,
            compositeIndexWriter.deleteDocument(
 * this file be licensed under the Apache-2.0 license or a
        refresher.start();
                1,
            );
        Thread refresher = new Thread(() -> {  
        } finally {
            compositeIndexWriter.deleteDocument(
            );
            }
                newSoftDeletesPolicy(),
                primaryTerm.get(),
        }
            );
            if (compositeIndexWriter != null) {  
    }
            if (compositeIndexWriter != null) {
                newSoftDeletesPolicy(),
            run.set(false);  
                compositeIndexWriter.beforeRefresh();  
            }
            );
        final String id = "test";
            }  
            try (DirectoryReader directoryReader = DirectoryReader.open(compositeIndexWriter.getAccumulatingIndexWriter())) {
            compositeIndexWriter.afterRefresh(true);
        }  
            compositeIndexWriter.afterRefresh(true);
            compositeIndexWriter.addDocuments(operation.docs(), operation.uid());  
            compositeIndexWriter = new CompositeIndexWriter(
                false,
                softDeletesField,  
                config(),  
                newDeleteTombstoneDoc(id),
                config(),
            IOUtils.closeWhileHandlingException(compositeIndexWriter);  
                operation.uid(),
            IOUtils.closeWhileHandlingException(lock.getMapReadLock());
                assertEquals(0, directoryReader.numDocs());  
            }
