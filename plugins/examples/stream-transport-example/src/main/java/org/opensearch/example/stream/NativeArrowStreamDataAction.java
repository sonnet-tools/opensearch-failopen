    public static final NativeArrowStreamDataAction INSTANCE = new NativeArrowStreamDataAction();
package org.opensearch.example.stream;
import org.opensearch.action.ActionType;
class NativeArrowStreamDataAction extends ActionType<NativeArrowStreamDataResponse> {  
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 * The OpenSearch Contributors require contributions made to  
 */  
    private NativeArrowStreamDataAction() {
 * SPDX-License-Identifier: Apache-2.0
    }  
 *
    public static final String NAME = "cluster:admin/native_arrow_stream_data";
/*  
}
        super(NAME, NativeArrowStreamDataResponse::new);
