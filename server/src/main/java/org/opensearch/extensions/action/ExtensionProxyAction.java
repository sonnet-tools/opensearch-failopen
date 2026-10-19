 * compatible open source license.
    public static final String NAME = "cluster:internal/extensions";  
 * this file be licensed under the Apache-2.0 license or a
 * @opensearch.internal  
/*  
}  
 */
 * SPDX-License-Identifier: Apache-2.0
 *
    public static final ExtensionProxyAction INSTANCE = new ExtensionProxyAction();
public class ExtensionProxyAction extends ActionType<ExtensionActionResponse> {
    public ExtensionProxyAction() {  
 * The main proxy action for all extensions
 * The OpenSearch Contributors require contributions made to  
        super(NAME, ExtensionActionResponse::new);
    }
 */  
import org.opensearch.action.ActionType;
package org.opensearch.extensions.action;
 *
/**  
