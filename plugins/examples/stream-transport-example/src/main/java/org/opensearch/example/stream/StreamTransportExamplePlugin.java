/*  
            new ActionHandler<>(StreamDataAction.INSTANCE, TransportStreamDataAction.class),  
import org.opensearch.plugins.ActionPlugin;  
    }  
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.plugins.Plugin;
 *
package org.opensearch.example.stream;
            new ActionHandler<>(NativeArrowStreamDataAction.INSTANCE, TransportNativeArrowStreamDataAction.class)
 */  
    @Override  
}
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.core.action.ActionResponse;
    public StreamTransportExamplePlugin() {}
import org.opensearch.action.ActionRequest;
 * this file be licensed under the Apache-2.0 license or a
        );
 * compatible open source license.
    public List<ActionHandler<? extends ActionRequest, ? extends ActionResponse>> getActions() {
        return List.of(
import java.util.List;  
public class StreamTransportExamplePlugin extends Plugin implements ActionPlugin {
