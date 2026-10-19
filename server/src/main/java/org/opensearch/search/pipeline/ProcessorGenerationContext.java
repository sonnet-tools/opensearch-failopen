 * SPDX-License-Identifier: Apache-2.0
}
import org.opensearch.common.Nullable;
 *
/*  
 * A DTO to hold the context used for a system generated factory to evaluate should we generate the processor
 */  
package org.opensearch.search.pipeline;
 * compatible open source license.
 * The OpenSearch Contributors require contributions made to  
public record ProcessorGenerationContext(SearchRequest searchRequest, @Nullable String parentAction) {
 */  
import org.opensearch.action.search.SearchRequest;
 * this file be licensed under the Apache-2.0 license or a
/**
