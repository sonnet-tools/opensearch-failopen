            );
                indexWriterFactory
                config(),
                IOUtils.close(compositeIndexWriter);
            }
        } finally {
            Engine.Index operation = indexForDoc(createParsedDoc(id, null, DEFAULT_CRITERIA));
            compositeIndexWriter.afterRefresh(true);
                newSoftDeletesPolicy(),
    }
                primaryTerm.get(),
                createWriter(),
            createWriter(),
            compositeIndexWriter.addDocuments(operation.docs(), operation.uid());
            compositeIndexWriter.deleteDocument(
                assertEquals(0, directoryReader.numDocs());
            IOUtils.closeWhileHandlingException(lock.getMapReadLock());
}
        }
            }
        }
            compositeIndexWriter.afterRefresh(true);
            );
            }
        try {
                2,
            refresher.join();
        CompositeIndexWriter compositeIndexWriter = null;
            operation = indexForDoc(createParsedDoc(id, null, DEFAULT_CRITERIA));
        CompositeIndexWriter compositeIndexWriter = null;
            try (DirectoryReader directoryReader = DirectoryReader.open(compositeIndexWriter.getAccumulatingIndexWriter())) {
            Engine.Index operation = indexForDoc(createParsedDoc(id, null, DEFAULT_CRITERIA));
                softDeletesField,
                newDeleteTombstoneDoc(id),
        try {
            compositeIndexWriter = new CompositeIndexWriter(
            config(),
                config(),
        } finally {
                newDeleteTombstoneDoc(id),
                operation.uid(),
/*
            Engine.Index operation = indexForDoc(createParsedDoc(id, null, DEFAULT_CRITERIA));
            compositeIndexWriter.afterRefresh(true);
        Engine.Index operation = indexForDoc(createParsedDoc(id, null, DEFAULT_CRITERIA));
            operation = indexForDoc(createParsedDoc(id, null, DEFAULT_CRITERIA));
            compositeIndexWriter.afterRefresh(true);
            latch.await();
                assertEquals(0, directoryReader.numDocs());
            );
            compositeIndexWriter.beforeRefresh();
    }
                indexWriterFactory
            compositeIndexWriter.beforeRefresh();
 */
                IOUtils.closeWhileHandlingException(compositeIndexWriter);
                newDeleteTombstoneDoc(id),
            } catch (Exception ignored) {}
        refresher.start();
                assertEquals(1, directoryReader.numDocs());
    public void testDeleteWithDocumentInChildWriter() throws IOException {
    public void testDeleteWithDocumentInParentWriter() throws IOException {
            }
            if (compositeIndexWriter != null) {
        } finally {
            compositeIndexWriter.addDocuments(operation.docs(), operation.uid());
            try (DirectoryReader directoryReader = DirectoryReader.open(compositeIndexWriter.getAccumulatingIndexWriter())) {
                newDeleteTombstoneDoc(id),
    public void testDeleteWithDocumentInOldChildWriter() throws IOException, InterruptedException {
        } finally {
        CompositeIndexWriter compositeIndexWriter = new CompositeIndexWriter(
            );
                2,
            );
            compositeIndexWriter.beforeRefresh();
            }
                softDeletesField
        }
                2,
                softDeletesField,
            compositeIndexWriter.softUpdateDocuments(operation.uid(), operation.docs(), 2, 2, primaryTerm.get(), softDeletesField);
                primaryTerm.get(),
                softDeletesField
                IOUtils.closeWhileHandlingException(compositeIndexWriter);
import org.apache.lucene.index.DirectoryReader;
        CompositeIndexWriter compositeIndexWriter = null;
        CountDownLatch latch = new CountDownLatch(1);
                config(),
            compositeIndexWriter.deleteDocument(
        try {
            IOUtils.closeWhileHandlingException(compositeIndexWriter);
    public void testUpdateWithDocumentInParentIndexWriter() throws IOException {
            compositeIndexWriter.afterRefresh(true);
                compositeIndexWriter.beforeRefresh();
 * compatible open source license.
            softDeletesField,
    }
            compositeIndexWriter.deleteDocument(
            try (DirectoryReader directoryReader = DirectoryReader.open(compositeIndexWriter.getAccumulatingIndexWriter())) {
                false,
                createWriter(),
        });
                softDeletesField,
        }
                operation.uid(),
        CompositeIndexWriter compositeIndexWriter = null;
    public void testUpdateWithDocumentInChildIndexWriter() throws IOException {
            );
                IOUtils.closeWhileHandlingException(compositeIndexWriter);
 * The OpenSearch Contributors require contributions made to
            compositeIndexWriter.beforeRefresh();
            compositeIndexWriter.addDocuments(operation.docs(), operation.uid());
                indexWriterFactory
            try {
            compositeIndexWriter.afterRefresh(true);
package org.opensearch.index.engine;
                createWriter(),
            indexWriterFactory
                newSoftDeletesPolicy(),
                primaryTerm.get(),
        final String id = "test";
                softDeletesField
    }
            }
            compositeIndexWriter.beforeRefresh();
                false,
            compositeIndexWriter.afterRefresh(true);
            compositeIndexWriter = new CompositeIndexWriter(
            operation = indexForDoc(createParsedDoc(id, null, DEFAULT_CRITERIA));
                createWriter(),
            try (DirectoryReader directoryReader = DirectoryReader.open(compositeIndexWriter.getAccumulatingIndexWriter())) {
                false,
        final String id = "test";
        AtomicBoolean run = new AtomicBoolean(true);
            if (compositeIndexWriter != null) {
        CompositeIndexWriter.CriteriaBasedIndexWriterLookup lock = compositeIndexWriter.acquireNewReadLock();
            compositeIndexWriter.afterRefresh(true);
            Engine.Index operation = indexForDoc(createParsedDoc(id, null, DEFAULT_CRITERIA));
 * this file be licensed under the Apache-2.0 license or a
        );
            compositeIndexWriter = new CompositeIndexWriter(
            }
                1,
                operation.uid(),
        }
            compositeIndexWriter.beforeRefresh();
                createWriter(),
        final String id = "test";
    }
            compositeIndexWriter.afterRefresh(true);
        try {
            try (DirectoryReader directoryReader = DirectoryReader.open(compositeIndexWriter.getAccumulatingIndexWriter())) {
                newSoftDeletesPolicy(),
                1,
                softDeletesField
            compositeIndexWriter.beforeRefresh();
            }
            );
            compositeIndexWriter.beforeRefresh();
 *
        final String id = "test";
            try (DirectoryReader directoryReader = DirectoryReader.open(compositeIndexWriter.getAccumulatingIndexWriter())) {
    }
            if (compositeIndexWriter != null) {
                operation.uid(),
public class CompositeIndexWriterForUpdateAndDeletesTests extends CriteriaBasedCompositeIndexWriterBaseTests {
            );
        compositeIndexWriter.addDocuments(operation.docs(), operation.uid());
import java.util.concurrent.CountDownLatch;
                indexWriterFactory
 * SPDX-License-Identifier: Apache-2.0
    public void testDeleteWithDocumentInBothChildAndParentWriter() throws IOException {
            compositeIndexWriter.afterRefresh(true);
        try {
                false,
                assertEquals(1, directoryReader.numDocs());
        CompositeIndexWriter compositeIndexWriter = null;
            compositeIndexWriter.beforeRefresh();
        } finally {
            if (compositeIndexWriter != null) {
        Thread refresher = new Thread(() -> {
                primaryTerm.get(),
                config(),
            Engine.Index operation = indexForDoc(createParsedDoc(id, null, DEFAULT_CRITERIA));
                softDeletesField,
                newSoftDeletesPolicy(),
import org.opensearch.common.util.io.IOUtils;
            compositeIndexWriter = new CompositeIndexWriter(
                1,
            compositeIndexWriter.deleteDocument(
                assertEquals(0, directoryReader.numDocs());
                1,
                newSoftDeletesPolicy(),
            compositeIndexWriter.softUpdateDocuments(operation.uid(), operation.docs(), 2, 2, primaryTerm.get(), softDeletesField);
            compositeIndexWriter.addDocuments(operation.docs(), operation.uid());
                IOUtils.closeWhileHandlingException(compositeIndexWriter);
            compositeIndexWriter.addDocuments(operation.docs(), operation.uid());
                indexWriterFactory
        try {
        }
import java.util.concurrent.atomic.AtomicBoolean;
                config(),
            }
import java.io.IOException;
            compositeIndexWriter = new CompositeIndexWriter(
        final String id = "test";
                2,
                softDeletesField,
            latch.countDown();
            run.set(false);
            newSoftDeletesPolicy(),
            compositeIndexWriter.softUpdateDocuments(operation.uid(), operation.docs(), 2, 2, primaryTerm.get(), softDeletesField);
            }
        } finally {
            if (compositeIndexWriter != null) {
        final String id = "test";
            }
                assertEquals(0, directoryReader.numDocs());
            );
