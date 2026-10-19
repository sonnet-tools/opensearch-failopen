    }  
 * The OpenSearch Contributors require contributions made to  
 * SPDX-License-Identifier: Apache-2.0
 */  
}
    public IndexCreateBlockException(Set<ClusterBlock> globalLevelBlocks) {  
    }
@PublicApi(since = "1.0.0")  
import org.opensearch.core.common.io.stream.StreamInput;
package org.opensearch.cluster.block;
        super(in);
public class IndexCreateBlockException extends ClusterBlockException {
 * Internal exception on obtaining an index create block
 * compatible open source license.
 * @opensearch.api
 *  
 * this file be licensed under the Apache-2.0 license or a
/*  
import java.io.IOException;
 *
    public IndexCreateBlockException(StreamInput in) throws IOException {
import org.opensearch.common.annotation.PublicApi;
/**
import java.util.Set;
 */
        super(globalLevelBlocks);
