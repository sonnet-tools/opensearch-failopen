 * operation  
    OP_NEWER,
}  
/**
public enum OpVsEngineDocStatus {
 * the status of the current doc version in engine, compared to the version in an incoming
package org.opensearch.index.engine;
 */  
    /** no doc was found in engine */
    /** the op is older or the same as the one that last modified the doc found in engine*/
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
    DOC_NOT_FOUND
 * The OpenSearch Contributors require contributions made to  
 *
    /** the op is more recent than the one that last modified the doc found in engine*/  
 * SPDX-License-Identifier: Apache-2.0
    OP_STALE_OR_EQUAL,  
 */
/*  
