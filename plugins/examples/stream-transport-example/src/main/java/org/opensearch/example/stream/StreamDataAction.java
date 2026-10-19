 * compatible open source license.
package org.opensearch.example.stream;
}
    public static final StreamDataAction INSTANCE = new StreamDataAction();
    private StreamDataAction() {
 * SPDX-License-Identifier: Apache-2.0
 */  
 *
    public static final String NAME = "cluster:admin/stream_data";
/*  
 * The OpenSearch Contributors require contributions made to  
    }  
import org.opensearch.action.ActionType;
 * this file be licensed under the Apache-2.0 license or a
        super(NAME, StreamDataResponse::new);
class StreamDataAction extends ActionType<StreamDataResponse> {  
