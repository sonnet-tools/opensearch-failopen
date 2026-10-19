public interface TranslogDeletionPolicyFactory {
/**
 * @opensearch.api
package org.opensearch.index.translog;
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.index.seqno.RetentionLeases;  
 *
 * SPDX-License-Identifier: Apache-2.0
 *  
 * compatible open source license.
@FunctionalInterface  
    TranslogDeletionPolicy create(IndexSettings settings, Supplier<RetentionLeases> supplier);  
import java.util.function.Supplier;
import org.opensearch.index.IndexSettings;
/*  
@PublicApi(since = "1.0.0")
 */
 * The OpenSearch Contributors require contributions made to  
 * Factory to instantiate a translog deletion policy
}
 */  
import org.opensearch.common.annotation.PublicApi;
