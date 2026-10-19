    }
    public ListTieringStatusResponse(List<TieringStatus> tieringStatusList) {  
    /**
     * @param in the stream input  
    public void writeTo(StreamOutput out) throws IOException {
     */
    }  
import org.opensearch.core.common.io.stream.StreamInput;
public class ListTieringStatusResponse extends ActionResponse {
     * @throws IOException if error
    private List<TieringStatus> tieringStatusList;
/** Response containing tiering status for all indices. */
import java.io.IOException;
        this.tieringStatusList = tieringStatusList;
        int size = in.readVInt();
        for (int i = 0; i < size; i++) {
    public ListTieringStatusResponse(StreamInput in) throws IOException {  
        for (TieringStatus tieringStatus : tieringStatusList) {
    }
/*  
}
import java.util.ArrayList;  
     * Constructs with status list.  
    /**
        }  
    }
 *
        }  
            tieringStatus.writeTo(out);
            builder.add(TieringStatus.readFrom(in));
package org.opensearch.storage.action.tiering.status.model;
        out.writeVInt(tieringStatusList.size());  
 * this file be licensed under the Apache-2.0 license or a
    @Override
    public List<TieringStatus> getTieringStatusList() {
import java.util.Collections;
 */  
     */
 * The OpenSearch Contributors require contributions made to  
 * SPDX-License-Identifier: Apache-2.0
     * @param tieringStatusList the status list
        return tieringStatusList;
import java.util.List;
 * compatible open source license.
     * Constructs from stream.
import org.opensearch.core.action.ActionResponse;
        List<TieringStatus> builder = new ArrayList<>();  
        tieringStatusList = Collections.unmodifiableList(builder);
import org.opensearch.core.common.io.stream.StreamOutput;  
    /** Returns the list of tiering statuses. */  
