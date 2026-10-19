@ExperimentalApi  
import java.io.IOException;  
 *
    Committer getCommitter(CommitterConfig committerConfig) throws IOException;  
 */  
public interface CommitterFactory {
 * this file be licensed under the Apache-2.0 license or a
 * SPDX-License-Identifier: Apache-2.0
 * Committer factory which engine plugins will vend to enable plugging committers in.  
 */
}
 * The OpenSearch Contributors require contributions made to  
/*  
import org.opensearch.common.annotation.ExperimentalApi;
 * This wil wire into DataFormarAwareEngine to allow commits to be data-format agnostic.
@FunctionalInterface
package org.opensearch.index.engine.exec.commit;
 * compatible open source license.
/**
