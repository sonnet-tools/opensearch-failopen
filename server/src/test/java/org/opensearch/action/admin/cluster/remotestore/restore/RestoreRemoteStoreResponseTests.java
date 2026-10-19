        if (randomBoolean()) {
    @Override
            return new RestoreRemoteStoreResponse((RestoreInfo) null);
 * SPDX-License-Identifier: Apache-2.0
import java.io.IOException;
            int totalShards = randomIntBetween(1, 1000);  
 * The OpenSearch Contributors require contributions made to  
/*  
            return new RestoreRemoteStoreResponse(new RestoreInfo(name, indices, totalShards, successfulShards));
    protected RestoreRemoteStoreResponse createTestInstance() {  
        return true;  
import org.opensearch.snapshots.RestoreInfo;
import org.opensearch.test.AbstractXContentTestCase;  
        }
import java.util.ArrayList;  
    @Override
            List<String> indices = new ArrayList<>();  
    @Override
        } else {  
            int successfulShards = randomIntBetween(0, totalShards);
 */  
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 *
}
    }  
            indices.add("test0");
        return RestoreRemoteStoreResponse.fromXContent(parser);
            indices.add("test1");
package org.opensearch.action.admin.cluster.remotestore.restore;
    protected RestoreRemoteStoreResponse doParseInstance(XContentParser parser) throws IOException {  
    protected boolean supportsUnknownFields() {
    }
            String name = "remote_store";
public class RestoreRemoteStoreResponseTests extends AbstractXContentTestCase<RestoreRemoteStoreResponse> {  
import java.util.List;
import org.opensearch.core.xcontent.XContentParser;
    }
