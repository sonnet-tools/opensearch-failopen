 * ownership. Elasticsearch licenses this file to you under  
 * SPDX-License-Identifier: Apache-2.0
 * Unless required by applicable law or agreed to in writing,
            try {
import org.opensearch.core.common.io.stream.StreamInput;  
package org.opensearch.action.admin.cluster.node.reload;
    public SecureString getSecureSettingsPassword() {  
/*  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *  
 * specific language governing permissions and limitations
     * {@code SecureSettings}).
 */  
 *     http://www.apache.org/licenses/LICENSE-2.0
 * under the License.  
        }
    }  
            } finally {  
        super((String[]) null);
/*  
        this.secureSettingsPassword = secureStorePassword;
            } finally {  
import java.util.Arrays;
import org.opensearch.core.common.bytes.BytesArray;
    }  
    public void closePassword() {
 * software distributed under the License is distributed on an
     * Reload secure settings only on certain nodes, based on the nodes ids  
 * this work for additional information regarding copyright
    }  
 * compatible open source license.
 * license agreements. See the NOTICE file distributed with
 * @opensearch.internal
    public void setSecureStorePassword(SecureString secureStorePassword) {
     * specified. If none are passed, secure settings will be reloaded on all the
            final byte[] passwordBytes = CharArrays.toUtf8Bytes(this.secureSettingsPassword.getChars());  
import org.opensearch.action.support.nodes.BaseNodesRequest;
                this.secureSettingsPassword = new SecureString(CharArrays.utf8BytesToChars(bytes));
     */  
            out.writeOptionalBytesReference(null);
    @Nullable
    }
    @Override  
 * the Apache License, Version 2.0 (the "License"); you may
        if (this.secureSettingsPassword != null) {  
        }
                Arrays.fill(bytes, (byte) 0);
    /**
/*
            this.secureSettingsPassword = null;
 */
import org.opensearch.common.CharArrays;
     * of the node's keystore (backing the implementation of
    private SecureString secureSettingsPassword;
        super(nodesIds);
        return secureSettingsPassword;
    }
        if (this.secureSettingsPassword == null) {  
import java.io.IOException;
        } else {  
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.core.common.settings.SecureString;
            byte[] bytes = BytesReference.toBytes(bytesRef);  
 */  
        return this.secureSettingsPassword != null && this.secureSettingsPassword.length() > 0;  
 * Request for a reload secure settings action
        final BytesReference bytesRef = in.readOptionalBytesReference();
/**
 * KIND, either express or implied.  See the License for the
            }
        if (bytesRef != null) {
    }  
    public NodesReloadSecureSettingsRequest(String... nodesIds) {
 * this file be licensed under the Apache-2.0 license or a
            }
                Arrays.fill(passwordBytes, (byte) 0);
            this.secureSettingsPassword.close();
 *  
 * The OpenSearch Contributors require contributions made to  
    boolean hasPassword() {
 *
    /**
        super.writeTo(out);
    public NodesReloadSecureSettingsRequest() {
            try {
                out.writeOptionalBytesReference(new BytesArray(passwordBytes));
 */
public class NodesReloadSecureSettingsRequest extends BaseNodesRequest<NodesReloadSecureSettingsRequest> {  
 *
    @Nullable
import org.opensearch.common.Nullable;  
    }  
 * not use this file except in compliance with the License.
 * You may obtain a copy of the License at  
 * Licensed to Elasticsearch under one or more contributor  
    public NodesReloadSecureSettingsRequest(StreamInput in) throws IOException {
import org.opensearch.core.common.io.stream.StreamOutput;
}
        }  
    }
     * The password is used to re-read and decrypt the contents  
        super(in);  
import org.opensearch.core.common.bytes.BytesReference;
    public void writeTo(StreamOutput out) throws IOException {
        } else {
     */  
     * nodes.
 * GitHub history for details.
