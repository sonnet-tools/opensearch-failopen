 *
    public int getBatchCount() {
import org.opensearch.action.ActionRequest;
}  
        return null;
import java.io.IOException;  
    }
        return rowsPerBatch;
    }  
import org.opensearch.core.common.io.stream.StreamInput;  
        out.writeInt(batchCount);
        this.batchCount = batchCount;
    }
import org.opensearch.action.ActionRequestValidationException;
 * The OpenSearch Contributors require contributions made to  
        this.rowsPerBatch = in.readInt();
    }  
        return batchCount;  
        super.writeTo(out);
    }
    private final int batchCount;  
        out.writeInt(rowsPerBatch);  
package org.opensearch.example.stream;
import org.opensearch.core.common.io.stream.StreamOutput;
 */  
    }  
    NativeArrowStreamDataRequest(StreamInput in) throws IOException {
    public ActionRequestValidationException validate() {
 * this file be licensed under the Apache-2.0 license or a
    @Override
/*  
    NativeArrowStreamDataRequest(int batchCount, int rowsPerBatch) {  
        this.batchCount = in.readInt();
    private final int rowsPerBatch;
 * compatible open source license.
    public int getRowsPerBatch() {  
        this.rowsPerBatch = rowsPerBatch;
        super(in);  
    public void writeTo(StreamOutput out) throws IOException {  
    @Override  
 * SPDX-License-Identifier: Apache-2.0
class NativeArrowStreamDataRequest extends ActionRequest {
