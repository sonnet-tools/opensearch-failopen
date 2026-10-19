package org.opensearch.common.xcontent;
 * Consolidates the XContent constraints (primarily reflecting Jackson's {@link StreamReadConstraints} constraints)  
 * SPDX-License-Identifier: Apache-2.0
}
    final String DEFAULT_MAX_DEPTH_PROPERTY = "opensearch.xcontent.depth.max";
 * compatible open source license.
    );
        System.getProperty(DEFAULT_MAX_NAME_LEN_PROPERTY, "50000" /* StreamReadConstraints.DEFAULT_MAX_NAME_LEN */)  
    final int DEFAULT_MAX_DEPTH = Integer.parseInt(  
import org.opensearch.common.annotation.InternalApi;
    );
 */  
        System.getProperty(DEFAULT_BUFFER_SIZE_PROPERTY, "8000" /* UTF8Reader#DEFAULT_BUFFER_SIZE */)  
    final String DEFAULT_BUFFER_SIZE_PROPERTY = "opensearch.xcontent.buffer.size";  
    );
 *
    final String DEFAULT_MAX_NAME_LEN_PROPERTY = "opensearch.xcontent.name.length.max";  
    final int DEFAULT_CODEPOINT_LIMIT = Integer.parseInt(System.getProperty(DEFAULT_CODEPOINT_LIMIT_PROPERTY, "52428800" /* ~50 Mb */));
    final String DEFAULT_CODEPOINT_LIMIT_PROPERTY = "opensearch.xcontent.codepoint.max";
 *
        System.getProperty(DEFAULT_MAX_DEPTH_PROPERTY, "1000" /* StreamReadConstraints.DEFAULT_MAX_DEPTH */)
    final int DEFAULT_MAX_NAME_LEN = Integer.parseInt(
 */  
public interface XContentConstraints {
@InternalApi
 * The OpenSearch Contributors require contributions made to  
    final int DEFAULT_MAX_STRING_LEN = Integer.parseInt(System.getProperty(DEFAULT_MAX_STRING_LEN_PROPERTY, "50000000" /* ~50 Mb */));  
/**
/*  
    final String DEFAULT_MAX_STRING_LEN_PROPERTY = "opensearch.xcontent.string.length.max";
    final int DEFAULT_BUFFER_SIZE = Integer.parseInt(
 * @opensearch.internal
import tools.jackson.core.StreamReadConstraints;  
 * this file be licensed under the Apache-2.0 license or a
