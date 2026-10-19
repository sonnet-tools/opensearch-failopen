 * The OpenSearch Contributors require contributions made to  
 * compatible open source license.
import java.io.IOException;
import org.opensearch.core.rest.RestStatus;
 *
    public SnapshotInUseDeletionException(StreamInput in) throws IOException {
 * Thrown if requested snapshot/s can't be deleted
 * SPDX-License-Identifier: Apache-2.0
 * @opensearch.internal  
}
 * this file be licensed under the Apache-2.0 license or a
 */  
public class SnapshotInUseDeletionException extends SnapshotException {
    }
/*  
    }  
        return RestStatus.CONFLICT;
/**  
        super(in);  
        super(repositoryName, snapshotName, msg);
    @Override  
package org.opensearch.snapshots;
    }  
    public SnapshotInUseDeletionException(final String repositoryName, final String snapshotName, final String msg) {
 */
    public RestStatus status() {
import org.opensearch.core.common.io.stream.StreamInput;
 *
