            case UPGRADED:  
                break;  
            default:
 * compatible open source license.
public class RefreshVersionInClusterStateIT extends AbstractRollingTestCase {
    public void testRefresh() throws IOException {
                break;
                Response response = client().performRequest(new Request("GET", "/_cat/nodes?h=id,version"));
        }  
     */  
package org.opensearch.upgrades;
 *
import org.opensearch.client.Response;  
            case MIXED:
        switch (CLUSTER_TYPE) {
import org.opensearch.client.Request;
     * This test ensures that after the upgrade, all nodes report the current version
                    assertEquals(Version.fromString(elements[1]), Version.CURRENT);
    /*
                    String[] elements = nodeLine.split(" +");  
 * SPDX-License-Identifier: Apache-2.0
                for (String nodeLine : Streams.readAllLines(response.getEntity().getContent())) {
            case OLD:  
import org.opensearch.common.io.Streams;
 */  
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.Version;
}
    }
 * this file be licensed under the Apache-2.0 license or a
                throw new UnsupportedOperationException("Unknown cluster type [" + CLUSTER_TYPE + "]");
                }
import java.io.IOException;  
/*  
