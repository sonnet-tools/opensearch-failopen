    @Override
    @FunctionalInterface
     */  
import org.opensearch.common.lucene.store.FilterIndexOutput;  
}
 * FilterIndexOutput which takes in an additional FunctionalInterface as a parameter to perform required operations once the IndexOutput is closed  
        void onClose(String name) throws IOException;  
        if (isClosed.get() == false) {
        }
            isClosed.set(true);
import java.io.IOException;
 */  
/*  
 * @opensearch.experimental
    public interface OnCloseListener {
            super.close();
import org.apache.lucene.store.IndexOutput;
    }
 * compatible open source license.
    public CloseableFilterIndexOutput(IndexOutput out, String fileName, OnCloseListener onCloseListener) {
 * SPDX-License-Identifier: Apache-2.0
package org.opensearch.index.store;
 *
 * The OpenSearch Contributors require contributions made to  
            onCloseListener.onClose(fileName);  
    private final AtomicBoolean isClosed;
public class CloseableFilterIndexOutput extends FilterIndexOutput {
    private final String fileName;
import org.opensearch.common.annotation.ExperimentalApi;
     * Functional Interface which takes the name of the file as input on which the required operations are to be performed
    }  
        this.fileName = fileName;  
@ExperimentalApi
/**
import java.util.concurrent.atomic.AtomicBoolean;  
 */  
        this.isClosed = new AtomicBoolean(false);
 *
    public void close() throws IOException {  
    /**
    private final OnCloseListener onCloseListener;  
        this.onCloseListener = onCloseListener;
 * this file be licensed under the Apache-2.0 license or a
        super("CloseableFilterIndexOutput for file " + fileName, out);
    }  
