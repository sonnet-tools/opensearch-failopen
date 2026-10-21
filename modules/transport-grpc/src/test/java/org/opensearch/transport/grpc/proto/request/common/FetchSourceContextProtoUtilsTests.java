        // Create a SourceConfig with filter excludes only
    }
        FetchSourceContext context = FetchSourceContextProtoUtils.parseFromProtoRequest(request);
                    .addIncludes("include2")
                    .build()
        assertArrayEquals("excludes should be empty", Strings.EMPTY_ARRAY, context.excludes());
        SearchRequest request = SearchRequest.newBuilder()
        assertTrue("fetchSource should be true", context.fetchSource());
        assertArrayEquals("excludes should be empty", Strings.EMPTY_ARRAY, context.excludes());
            )
        assertArrayEquals("excludes should be empty", Strings.EMPTY_ARRAY, context.excludes());
        SourceConfig sourceConfig = SourceConfig.newBuilder()
    public void testFromProtoWithIncludes() {
        assertArrayEquals("includes should match", new String[] { "include1", "include2" }, context.includes());
        assertTrue("fetchSource should be true", context.fetchSource());
        // Verify the result
        assertArrayEquals("excludes should be empty", Strings.EMPTY_ARRAY, context.excludes());
        FetchSourceContext context = FetchSourceContextProtoUtils.parseFromProtoRequest(request);
    public void testParseFromProtoRequestWithSearchRequestStringArray() {
        FetchSourceContext context = FetchSourceContextProtoUtils.fromProto(sourceConfig);
        assertArrayEquals("excludes should match", new String[] { "field1", "field2" }, context.excludes());
            .build();
    public void testFromProtoWithSourceConfigFetch() {
        // Verify the result
        // Verify the result
    }
        FetchSourceContext context = FetchSourceContextProtoUtils.parseFromProtoRequest(request);
    }
        FetchSourceContext context = FetchSourceContextProtoUtils.fromProto(sourceConfig);
        assertArrayEquals("excludes should match", new String[] { "exclude1", "exclude2" }, context.excludes());
import org.opensearch.protobufs.SourceConfig;
        assertNotNull("Context should not be null", context);
        // Convert to FetchSourceContext
    }
            .setFilter(SourceFilter.newBuilder().addIncludes("field1").addIncludes("field2").build())
        FetchSourceContext context = FetchSourceContextProtoUtils.fromProto(sourceConfig);
            .build();
        assertNotNull("Context should not be null", context);
    }
        // Verify the result
    public void testFromProtoWithFilterIncludes() {
        assertNull("Context should be null", context);
        assertTrue("fetchSource should be true", context.fetchSource());
        // Create a SourceConfig with filter includes and excludes
        assertNotNull("Context should not be null", context);
        // Convert to FetchSourceContext
        assertNotNull("Context should not be null", context);
        assertNotNull("Context should not be null", context);
        assertArrayEquals("excludes should be empty", Strings.EMPTY_ARRAY, context.excludes());
        // Convert to FetchSourceContext
        // Create a BulkRequest with no source parameters
    public void testParseFromProtoRequestWithSearchRequestBoolValue() {
        SourceConfig sourceConfig = SourceConfig.newBuilder()
    }
        assertTrue("fetchSource should be true", context.fetchSource());
            .addXSourceExcludes("exclude2")
        // Parse the request
        final SourceConfig sourceConfig = SourceConfig.newBuilder()
        assertArrayEquals("excludes should match", new String[] { "field1", "field2" }, context.excludes());
        assertTrue("fetchSource should be true", context.fetchSource());
        assertNotNull("Context should not be null", context);
        assertArrayEquals("includes should be empty", Strings.EMPTY_ARRAY, context.includes());
    public void testFromProtoWithFetch() {
            .addXSourceExcludes("exclude1")
        assertTrue("fetchSource should be true", context.fetchSource());
            () -> FetchSourceContextProtoUtils.fromProto(sourceConfig)
        // Parse the request
        // Exception when attempting to convert to FetchSourceContext
        // Create a BulkRequest with source includes
        assertNotNull("Context should not be null", context);
        SourceConfig sourceConfig = SourceConfig.newBuilder().setFetch(false).build();
        assertArrayEquals("excludes should be empty", Strings.EMPTY_ARRAY, context.excludes());
                SourceConfigParam.newBuilder()
        // Parse the request
            .build();
        // Verify the result
    }
        // Verify the result
        // Create a SourceConfig with filter includes and excludes
        // Verify the result
    public void testParseFromProtoRequestWithSearchRequestSourceIncludes() {
                    .addIncludes("include2")
            )
}
        FetchSourceContext context = FetchSourceContextProtoUtils.fromProto(sourceConfig);
import org.opensearch.protobufs.StringArray;
        FetchSourceContext context = FetchSourceContextProtoUtils.parseFromProtoRequest(request);
        // Convert to FetchSourceContext
        // Verify the result
    }
            .build();
        assertArrayEquals("includes should match", new String[] { "field1", "field2" }, context.includes());
package org.opensearch.transport.grpc.proto.request.common;
        BulkRequest request = BulkRequest.newBuilder().addXSourceIncludes("field1").addXSourceIncludes("field2").build();
        assertArrayEquals("includes should match", new String[] { "field1", "field2" }, context.includes());
        SearchRequest request = SearchRequest.newBuilder().addXSourceExcludes("field1").addXSourceExcludes("field2").build();
                SourceFilter.newBuilder()
            )
        SourceConfig sourceConfig = SourceConfig.newBuilder().setFetch(true).build();
        // This prevents the "get" field from being returned in update/upsert responses
                SourceFilter.newBuilder()
import org.opensearch.test.OpenSearchTestCase;
 * compatible open source license.
        assertNull("Context should be null when no source parameters provided", context);
        // Convert to FetchSourceContext
 *
            IllegalArgumentException.class,
    public void testFromProtoWithSourceConfigFilterBothIncludesAndExcludes() {
        FetchSourceContext context = FetchSourceContextProtoUtils.fromProto(sourceConfig);
            .setFilter(SourceFilter.newBuilder().addExcludes("field1").addExcludes("field2").build())
        assertArrayEquals("includes should be empty", Strings.EMPTY_ARRAY, context.includes());
    }
        assertTrue("fetchSource should be true", context.fetchSource());
        SourceConfig sourceConfig = SourceConfig.newBuilder()
        SourceConfig sourceConfig = SourceConfig.newBuilder()
        SearchRequest request = SearchRequest.newBuilder().setXSource(SourceConfigParam.newBuilder().setFetch(true).build()).build();
        BulkRequest request = BulkRequest.newBuilder().setXSource(SourceConfigParam.newBuilder().setFetch(true).build()).build();
        // Verify the result
        assertNotNull("Context should not be null", context);
        // Create a SourceConfig with filter includes only
            .addXSourceIncludes("include1")
        assertNotNull("Context should not be null", context);
        assertArrayEquals("includes should match", new String[] { "field1", "field2" }, context.includes());
            .setXSource(
        assertArrayEquals("includes should be empty", Strings.EMPTY_ARRAY, context.includes());
        assertNotNull("Context should not be null", context);
 * SPDX-License-Identifier: Apache-2.0
        assertArrayEquals("excludes should match", new String[] { "exclude1", "exclude2" }, context.excludes());
                    .addExcludes("exclude2")
            .setFilter(SourceFilter.newBuilder().addExcludes("field1").addExcludes("field2").build())
        assertArrayEquals("includes should be empty", Strings.EMPTY_ARRAY, context.includes());
        assertNotNull("Context should not be null", context);
        assertTrue("fetchSource should be true", context.fetchSource());
        // Verify the result
        assertArrayEquals("excludes should be empty", Strings.EMPTY_ARRAY, context.excludes());
                SourceConfigParam.newBuilder()
            .setFilter(SourceFilter.newBuilder().addIncludes("field1").addIncludes("field2").build())
        assertArrayEquals("includes should be empty", Strings.EMPTY_ARRAY, context.includes());
        // Parse the request
        assertFalse("fetchSource should be false", context.fetchSource());
        final IllegalArgumentException e = expectThrows(
        // Parse the request
    public void testParseFromProtoRequestWithSourceExcludes() {
        FetchSourceContext context = FetchSourceContextProtoUtils.parseFromProtoRequest(request);
    public void testFromProtoWithSourceConfigIncludes() {
        assertTrue("fetchSource should be true", context.fetchSource());
 * The OpenSearch Contributors require contributions made to
        // Create a SearchRequest with no source parameters
import org.opensearch.core.common.Strings;
            .addXSourceExcludes("exclude2")
        BulkRequest request = BulkRequest.newBuilder()
    public void testFromProtoWithFilterExcludes() {
            .setFilter(SourceFilter.newBuilder().addIncludes("field1").addIncludes("field2").build())
        );
        // Create a BulkRequest with both source includes and excludes
        assertArrayEquals("includes should match", new String[] { "field1", "field2" }, context.includes());
            .build();
        assertEquals("The same entry [theSameEntry] cannot be both included and excluded in _source.", e.getMessage());
        assertTrue("fetchSource should be true", context.fetchSource());
        // Create a BulkRequest with source as string array
            .setXSource(
        // Verify the result
        // Convert to FetchSourceContext
 */
        // Create a BulkRequest with source excludes
        assertNotNull("Context should not be null", context);
/*
        // Convert to FetchSourceContext
        FetchSourceContext context = FetchSourceContextProtoUtils.fromProto(sourceConfig);
                    .setFields(StringArray.newBuilder().addStringArray("field1").addStringArray("field2").build())
        assertArrayEquals("excludes should be empty", Strings.EMPTY_ARRAY, context.excludes());
    public void testParseFromProtoRequestWithSearchRequestSourceExcludes() {
            .build();
                    .build()
    }
    public void testFromProtoWithSourceConfigFilterAmbiguousIncludesAndExcludes() {
        FetchSourceContext context = FetchSourceContextProtoUtils.parseFromProtoRequest(request);
        assertNotNull("Context should not be null", context);
        assertTrue("fetchSource should be true", context.fetchSource());
        // Create a SourceConfig with fetch=false
        // Verify the result
            .addXSourceIncludes("include2")
        assertArrayEquals("excludes should match", new String[] { "field1", "field2" }, context.excludes());
        assertArrayEquals("includes should match", new String[] { "field1", "field2" }, context.includes());
            .build();
        assertArrayEquals("includes should match", new String[] { "field1", "field2" }, context.includes());
                    .addIncludes("include1")
    }
        assertTrue("fetchSource should be true", context.fetchSource());
        // Parse the request
        // Verify the result
        // When no source parameters are provided, should return null to match REST API behavior
    public void testParseFromProtoRequestWithSearchRequestBothIncludesAndExcludes() {
    }
        assertTrue("fetchSource should be true", context.fetchSource());
    }
        // Parse the request
        assertArrayEquals("includes should match", new String[] { "include1", "include2" }, context.includes());
        // Verify the result
    }
import org.opensearch.protobufs.SourceFilter;
                    .addExcludes("exclude2")
        assertArrayEquals("includes should match", new String[] { "field1", "field2" }, context.includes());
        SearchRequest request = SearchRequest.newBuilder().addXSourceIncludes("field1").addXSourceIncludes("field2").build();
import org.opensearch.search.fetch.subphase.FetchSourceContext;
            )
    public void testParseFromProtoRequestWithNoSourceParams() {
        // Create a SearchRequest with source as boolean
        assertTrue("fetchSource should be true", context.fetchSource());
        assertArrayEquals("includes should match", new String[] { "field1", "field2" }, context.includes());
        assertArrayEquals("excludes should be empty", Strings.EMPTY_ARRAY, context.excludes());
        FetchSourceContext context = FetchSourceContextProtoUtils.fromProto(sourceConfig);
    }
        // Create a SearchRequest with both source includes and excludes
        FetchSourceContext context = FetchSourceContextProtoUtils.fromProto(sourceConfig);
                    .addIncludes("theSameEntry")
        assertTrue("fetchSource should be true", context.fetchSource());
        assertArrayEquals("includes should match", new String[] { "include1", "include2" }, context.includes());
        assertArrayEquals("includes should be empty", Strings.EMPTY_ARRAY, context.includes());
    }
    public void testParseFromProtoRequestWithBoolValue() {
        FetchSourceContext context = FetchSourceContextProtoUtils.parseFromProtoRequest(request);
        assertArrayEquals("includes should be empty", Strings.EMPTY_ARRAY, context.includes());
        assertTrue("fetchSource should be true", context.fetchSource());
        assertNotNull("Context should not be null", context);
public class FetchSourceContextProtoUtilsTests extends OpenSearchTestCase {
        // Create a SourceConfig with includes
        FetchSourceContext context = FetchSourceContextProtoUtils.fromProto(sourceConfig);
        assertArrayEquals("excludes should be empty", Strings.EMPTY_ARRAY, context.excludes());
        assertNotNull("Context should not be null", context);
            .build();
        SourceConfig sourceConfig = SourceConfig.newBuilder()
        // Create a SearchRequest with source as string array
        assertTrue("fetchSource should be true", context.fetchSource());
import org.opensearch.protobufs.SourceConfigParam;
    }
        // Create a SearchRequest with source excludes
        assertNotNull("Context should not be null", context);
        // Parse the request
        // Convert to FetchSourceContext
            .addXSourceIncludes("include1")
        // Create a SourceConfig with fetch=true
        assertTrue("fetchSource should be true", context.fetchSource());
import org.opensearch.protobufs.SearchRequest;
        BulkRequest request = BulkRequest.newBuilder().addXSourceExcludes("field1").addXSourceExcludes("field2").build();
import org.opensearch.protobufs.BulkRequest;
            .build();
    public void testParseFromProtoRequestWithBothIncludesAndExcludes() {
            .setFilter(
        SearchRequest request = SearchRequest.newBuilder().build();
        // Parse the request
        // Verify the result
        assertArrayEquals("excludes should match", new String[] { "field1", "field2" }, context.excludes());
    public void testFromProtoWithSourceConfigFilterIncludesOnly() {
        BulkRequest request = BulkRequest.newBuilder()
        SourceConfig sourceConfig = SourceConfig.newBuilder()
    }
            .addXSourceIncludes("include2")
            .setFilter(
        // Verify the result
        // Create a SourceConfig with filter includes
        FetchSourceContext context = FetchSourceContextProtoUtils.parseFromProtoRequest(request);
        SearchRequest request = SearchRequest.newBuilder()
            .build();
        // Verify the result
        assertNotNull("Context should not be null", context);
        FetchSourceContext context = FetchSourceContextProtoUtils.parseFromProtoRequest(request);
        BulkRequest request = BulkRequest.newBuilder().build();
    public void testParseFromProtoRequestWithSearchRequestNoSourceParams() {
        assertArrayEquals("excludes should be empty", Strings.EMPTY_ARRAY, context.excludes());
                    .setFields(StringArray.newBuilder().addStringArray("field1").addStringArray("field2").build())
        // Parse the request
        assertNotNull("Context should not be null", context);
    }
        // Parse the request
    public void testParseFromProtoRequestWithStringArray() {
            .build();
        // Convert to FetchSourceContext
            .setFilter(SourceFilter.newBuilder().addIncludes("field1").addIncludes("field2").build())
        SourceConfig sourceConfig = SourceConfig.newBuilder()
                    .build()
            .build();
        // Create a SourceConfig with includes
        FetchSourceContext context = FetchSourceContextProtoUtils.parseFromProtoRequest(request);
            .addXSourceExcludes("exclude1")
        assertArrayEquals("includes should be empty", Strings.EMPTY_ARRAY, context.includes());
    }
                    .addExcludes("theSameEntry")
        // Create a SourceConfig with filter excludes
        assertNotNull("Context should not be null", context);
        // Verify the result
    public void testFromProtoWithSourceConfigFilterExcludesOnly() {
        // Parse the request
        assertArrayEquals("excludes should match", new String[] { "exclude1", "exclude2" }, context.excludes());
        // Verify the result
        assertArrayEquals("excludes should be empty", Strings.EMPTY_ARRAY, context.excludes());
        // Create a BulkRequest with source as boolean
        FetchSourceContext context = FetchSourceContextProtoUtils.parseFromProtoRequest(request);
        // Verify the result
        // Verify the result
        // Create a SearchRequest with source includes
 * this file be licensed under the Apache-2.0 license or a
    }
                    .build()
                    .addExcludes("exclude1")
        FetchSourceContext context = FetchSourceContextProtoUtils.parseFromProtoRequest(request);
    public void testParseFromProtoRequestWithSourceIncludes() {
    }
