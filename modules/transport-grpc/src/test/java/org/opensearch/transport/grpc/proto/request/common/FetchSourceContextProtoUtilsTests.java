        // Verify the result  
        assertArrayEquals("excludes should match", new String[] { "exclude1", "exclude2" }, context.excludes());
        // Create a SourceConfig with fetch=false
        // Parse the request
        assertTrue("fetchSource should be true", context.fetchSource());
        // Verify the result
        assertNotNull("Context should not be null", context);
        // Verify the result  
        // Verify the result
        assertNotNull("Context should not be null", context);  
        // Create a SourceConfig with filter includes and excludes
        // Parse the request
        // Create a SourceConfig with filter excludes
        // Create a SearchRequest with source excludes
        FetchSourceContext context = FetchSourceContextProtoUtils.fromProto(sourceConfig);
        FetchSourceContext context = FetchSourceContextProtoUtils.parseFromProtoRequest(request);  
        // Convert to FetchSourceContext  
        SourceConfig sourceConfig = SourceConfig.newBuilder()
        // Verify the result
                    .build()  
        assertNotNull("Context should not be null", context);
        assertArrayEquals("excludes should match", new String[] { "field1", "field2" }, context.excludes());  
        // Verify the result
        assertArrayEquals("excludes should be empty", Strings.EMPTY_ARRAY, context.excludes());  
                SourceFilter.newBuilder()  
    }
        assertTrue("fetchSource should be true", context.fetchSource());  
            .build();
        SearchRequest request = SearchRequest.newBuilder().addXSourceExcludes("field1").addXSourceExcludes("field2").build();  
        SearchRequest request = SearchRequest.newBuilder().addXSourceIncludes("field1").addXSourceIncludes("field2").build();
        assertArrayEquals("includes should match", new String[] { "field1", "field2" }, context.includes());
            () -> FetchSourceContextProtoUtils.fromProto(sourceConfig)
        // Parse the request
public class FetchSourceContextProtoUtilsTests extends OpenSearchTestCase {
        // Parse the request  
    }  
            .setFilter(
        FetchSourceContext context = FetchSourceContextProtoUtils.parseFromProtoRequest(request);
                    .build()
    public void testParseFromProtoRequestWithSearchRequestSourceIncludes() {
        assertArrayEquals("excludes should be empty", Strings.EMPTY_ARRAY, context.excludes());  
    public void testParseFromProtoRequestWithNoSourceParams() {
        assertNotNull("Context should not be null", context);
    }
        FetchSourceContext context = FetchSourceContextProtoUtils.fromProto(sourceConfig);  
            .build();
        FetchSourceContext context = FetchSourceContextProtoUtils.fromProto(sourceConfig);
        // Convert to FetchSourceContext
        // Verify the result  
            .addXSourceIncludes("include2")
        assertNull("Context should be null when no source parameters provided", context);
            .build();  
        BulkRequest request = BulkRequest.newBuilder().addXSourceExcludes("field1").addXSourceExcludes("field2").build();  
        assertFalse("fetchSource should be false", context.fetchSource());  
    public void testParseFromProtoRequestWithSearchRequestStringArray() {  
            .addXSourceIncludes("include1")  
        final IllegalArgumentException e = expectThrows(  
        // Verify the result
        assertNotNull("Context should not be null", context);
        SearchRequest request = SearchRequest.newBuilder()
        // Convert to FetchSourceContext
        assertNotNull("Context should not be null", context);
        assertArrayEquals("includes should match", new String[] { "field1", "field2" }, context.includes());
        assertTrue("fetchSource should be true", context.fetchSource());
            .addXSourceIncludes("include2")
            .build();
        // Convert to FetchSourceContext  
        assertArrayEquals("excludes should be empty", Strings.EMPTY_ARRAY, context.excludes());  
                    .addIncludes("include1")
        assertNotNull("Context should not be null", context);  
        // Create a BulkRequest with both source includes and excludes
        // Convert to FetchSourceContext
        assertArrayEquals("includes should be empty", Strings.EMPTY_ARRAY, context.includes());
        // Verify the result
        // Verify the result
    public void testFromProtoWithIncludes() {
 * The OpenSearch Contributors require contributions made to  
                    .addExcludes("exclude2")  
        assertArrayEquals("excludes should be empty", Strings.EMPTY_ARRAY, context.excludes());
        assertTrue("fetchSource should be true", context.fetchSource());  
        SearchRequest request = SearchRequest.newBuilder().setXSource(SourceConfigParam.newBuilder().setFetch(true).build()).build();  
        // Create a BulkRequest with source includes  
            .setFilter(SourceFilter.newBuilder().addIncludes("field1").addIncludes("field2").build())  
        );  
 * SPDX-License-Identifier: Apache-2.0
        SourceConfig sourceConfig = SourceConfig.newBuilder().setFetch(true).build();
                    .build()  
        assertArrayEquals("excludes should be empty", Strings.EMPTY_ARRAY, context.excludes());
        assertNotNull("Context should not be null", context);
        assertArrayEquals("includes should match", new String[] { "include1", "include2" }, context.includes());  
    public void testParseFromProtoRequestWithBoolValue() {
        assertArrayEquals("excludes should be empty", Strings.EMPTY_ARRAY, context.excludes());
        // Parse the request
        assertNotNull("Context should not be null", context);
        assertNotNull("Context should not be null", context);
        FetchSourceContext context = FetchSourceContextProtoUtils.parseFromProtoRequest(request);  
 */  
        // Verify the result
    public void testParseFromProtoRequestWithSearchRequestNoSourceParams() {
                    .addExcludes("theSameEntry")
        // Create a SourceConfig with filter excludes only
        assertArrayEquals("excludes should be empty", Strings.EMPTY_ARRAY, context.excludes());
import org.opensearch.protobufs.SearchRequest;  
        assertNotNull("Context should not be null", context);  
        // Create a SearchRequest with no source parameters
        // Verify the result  
        assertNotNull("Context should not be null", context);
        // When no source parameters are provided, should return null to match REST API behavior  
        assertTrue("fetchSource should be true", context.fetchSource());  
        assertTrue("fetchSource should be true", context.fetchSource());
        assertNotNull("Context should not be null", context);  
        // Convert to FetchSourceContext
        assertNotNull("Context should not be null", context);  
            .build();
        assertArrayEquals("excludes should match", new String[] { "exclude1", "exclude2" }, context.excludes());
    public void testFromProtoWithSourceConfigFetch() {  
                    .addExcludes("exclude2")
        // Verify the result
        assertArrayEquals("excludes should be empty", Strings.EMPTY_ARRAY, context.excludes());
        FetchSourceContext context = FetchSourceContextProtoUtils.parseFromProtoRequest(request);
            .setXSource(  
        BulkRequest request = BulkRequest.newBuilder().setXSource(SourceConfigParam.newBuilder().setFetch(true).build()).build();  
        SourceConfig sourceConfig = SourceConfig.newBuilder()
                    .addExcludes("exclude1")  
            .addXSourceExcludes("exclude1")
        assertArrayEquals("includes should be empty", Strings.EMPTY_ARRAY, context.includes());
    public void testFromProtoWithFilterIncludes() {
                SourceFilter.newBuilder()
        assertEquals("The same entry [theSameEntry] cannot be both included and excluded in _source.", e.getMessage());
        // Verify the result
        // Parse the request  
        assertArrayEquals("includes should match", new String[] { "include1", "include2" }, context.includes());  
    }
    }
    }
package org.opensearch.transport.grpc.proto.request.common;
    }
    }
        BulkRequest request = BulkRequest.newBuilder().addXSourceIncludes("field1").addXSourceIncludes("field2").build();
        // Parse the request
        // Parse the request  
    public void testParseFromProtoRequestWithSearchRequestBoolValue() {
        // Parse the request
    }  
        BulkRequest request = BulkRequest.newBuilder().build();  
import org.opensearch.search.fetch.subphase.FetchSourceContext;
        BulkRequest request = BulkRequest.newBuilder()
        // Create a SearchRequest with source as string array
    }
}
                    .addIncludes("include2")
import org.opensearch.test.OpenSearchTestCase;  
            .build();
        assertTrue("fetchSource should be true", context.fetchSource());
        assertArrayEquals("excludes should match", new String[] { "field1", "field2" }, context.excludes());
    }
            .build();
        // Create a SourceConfig with filter includes only
        assertTrue("fetchSource should be true", context.fetchSource());
        BulkRequest request = BulkRequest.newBuilder()
        // Parse the request
    public void testParseFromProtoRequestWithSourceExcludes() {
        FetchSourceContext context = FetchSourceContextProtoUtils.fromProto(sourceConfig);
        // Create a BulkRequest with no source parameters
        assertArrayEquals("includes should match", new String[] { "field1", "field2" }, context.includes());  
            .setFilter(SourceFilter.newBuilder().addIncludes("field1").addIncludes("field2").build())
            .setFilter(SourceFilter.newBuilder().addExcludes("field1").addExcludes("field2").build())
        // Create a BulkRequest with source excludes
        assertTrue("fetchSource should be true", context.fetchSource());
        assertArrayEquals("includes should match", new String[] { "include1", "include2" }, context.includes());  
        assertArrayEquals("includes should be empty", Strings.EMPTY_ARRAY, context.includes());
        // Verify the result
    public void testParseFromProtoRequestWithBothIncludesAndExcludes() {  
        FetchSourceContext context = FetchSourceContextProtoUtils.parseFromProtoRequest(request);  
                SourceConfigParam.newBuilder()
        SourceConfig sourceConfig = SourceConfig.newBuilder()
        // Create a SearchRequest with both source includes and excludes
        // Convert to FetchSourceContext  
        assertArrayEquals("includes should match", new String[] { "field1", "field2" }, context.includes());  
        assertArrayEquals("includes should match", new String[] { "field1", "field2" }, context.includes());
        FetchSourceContext context = FetchSourceContextProtoUtils.fromProto(sourceConfig);
    }  
        // Create a BulkRequest with source as boolean
        assertArrayEquals("excludes should match", new String[] { "field1", "field2" }, context.excludes());
            .setFilter(SourceFilter.newBuilder().addIncludes("field1").addIncludes("field2").build())
    public void testFromProtoWithFilterExcludes() {  
        // Create a SourceConfig with filter includes  
        SearchRequest request = SearchRequest.newBuilder()
    public void testFromProtoWithSourceConfigIncludes() {
import org.opensearch.protobufs.SourceFilter;  
        assertNotNull("Context should not be null", context);
        // Verify the result  
        assertArrayEquals("includes should match", new String[] { "field1", "field2" }, context.includes());
        // Verify the result  
        FetchSourceContext context = FetchSourceContextProtoUtils.fromProto(sourceConfig);
        FetchSourceContext context = FetchSourceContextProtoUtils.parseFromProtoRequest(request);  
import org.opensearch.protobufs.BulkRequest;
                    .build()
        assertNotNull("Context should not be null", context);  
    }  
    public void testFromProtoWithFetch() {
        // Create a SourceConfig with includes  
        assertArrayEquals("excludes should be empty", Strings.EMPTY_ARRAY, context.excludes());
            .build();  
    }
        FetchSourceContext context = FetchSourceContextProtoUtils.fromProto(sourceConfig);  
        SourceConfig sourceConfig = SourceConfig.newBuilder()  
            )
 *
        // Create a SourceConfig with includes
        assertTrue("fetchSource should be true", context.fetchSource());
        // Create a SearchRequest with source as boolean
        // Exception when attempting to convert to FetchSourceContext
        assertTrue("fetchSource should be true", context.fetchSource());
            .build();  
        // Create a SourceConfig with filter includes and excludes  
        FetchSourceContext context = FetchSourceContextProtoUtils.parseFromProtoRequest(request);
    }  
        assertTrue("fetchSource should be true", context.fetchSource());
        assertNotNull("Context should not be null", context);
        FetchSourceContext context = FetchSourceContextProtoUtils.parseFromProtoRequest(request);
            .setXSource(  
        // Create a SearchRequest with source includes  
import org.opensearch.protobufs.SourceConfig;
        // Verify the result  
            .setFilter(
        assertTrue("fetchSource should be true", context.fetchSource());
        SourceConfig sourceConfig = SourceConfig.newBuilder()
import org.opensearch.protobufs.StringArray;
                    .addIncludes("include2")
        assertArrayEquals("includes should be empty", Strings.EMPTY_ARRAY, context.includes());
    public void testParseFromProtoRequestWithSourceIncludes() {
        // Verify the result
        assertArrayEquals("excludes should be empty", Strings.EMPTY_ARRAY, context.excludes());
            .addXSourceExcludes("exclude2")  
    }
        final SourceConfig sourceConfig = SourceConfig.newBuilder()  
            .build();
        // Create a BulkRequest with source as string array
import org.opensearch.core.common.Strings;
        // Parse the request
        assertArrayEquals("includes should match", new String[] { "field1", "field2" }, context.includes());  
    }
                SourceConfigParam.newBuilder()
        assertArrayEquals("excludes should match", new String[] { "field1", "field2" }, context.excludes());  
        // Verify the result  
        FetchSourceContext context = FetchSourceContextProtoUtils.parseFromProtoRequest(request);  
        SourceConfig sourceConfig = SourceConfig.newBuilder()
        FetchSourceContext context = FetchSourceContextProtoUtils.parseFromProtoRequest(request);  
            .addXSourceExcludes("exclude2")  
        assertTrue("fetchSource should be true", context.fetchSource());
            .addXSourceIncludes("include1")  
        // Parse the request  
        SearchRequest request = SearchRequest.newBuilder().build();  
        assertTrue("fetchSource should be true", context.fetchSource());
        assertArrayEquals("excludes should be empty", Strings.EMPTY_ARRAY, context.excludes());
        // Convert to FetchSourceContext
        assertArrayEquals("includes should be empty", Strings.EMPTY_ARRAY, context.includes());  
        assertArrayEquals("includes should be empty", Strings.EMPTY_ARRAY, context.includes());
        FetchSourceContext context = FetchSourceContextProtoUtils.parseFromProtoRequest(request);
        // Convert to FetchSourceContext  
    }
        SourceConfig sourceConfig = SourceConfig.newBuilder().setFetch(false).build();
        assertTrue("fetchSource should be true", context.fetchSource());
            )
        assertArrayEquals("includes should be empty", Strings.EMPTY_ARRAY, context.includes());
    }  
        assertTrue("fetchSource should be true", context.fetchSource());
                    .setFields(StringArray.newBuilder().addStringArray("field1").addStringArray("field2").build())
                    .setFields(StringArray.newBuilder().addStringArray("field1").addStringArray("field2").build())
    public void testFromProtoWithSourceConfigFilterIncludesOnly() {  
            .addXSourceExcludes("exclude1")
        assertTrue("fetchSource should be true", context.fetchSource());  
        assertNull("Context should be null", context);  
 * compatible open source license.
    public void testFromProtoWithSourceConfigFilterBothIncludesAndExcludes() {
        assertArrayEquals("excludes should be empty", Strings.EMPTY_ARRAY, context.excludes());  
            IllegalArgumentException.class,
import org.opensearch.protobufs.SourceConfigParam;
        assertArrayEquals("includes should be empty", Strings.EMPTY_ARRAY, context.includes());  
    public void testFromProtoWithSourceConfigFilterAmbiguousIncludesAndExcludes() {
        FetchSourceContext context = FetchSourceContextProtoUtils.fromProto(sourceConfig);
        assertArrayEquals("includes should match", new String[] { "field1", "field2" }, context.includes());
        // Verify the result
    }
            )
        // Create a SourceConfig with fetch=true  
        SourceConfig sourceConfig = SourceConfig.newBuilder()  
    public void testParseFromProtoRequestWithSearchRequestSourceExcludes() {
    }
/*  
            .build();
        assertNotNull("Context should not be null", context);
        FetchSourceContext context = FetchSourceContextProtoUtils.fromProto(sourceConfig);
    public void testParseFromProtoRequestWithStringArray() {  
            .build();
    public void testFromProtoWithSourceConfigFilterExcludesOnly() {
                    .addIncludes("theSameEntry")  
            )  
    }  
        assertArrayEquals("excludes should match", new String[] { "exclude1", "exclude2" }, context.excludes());
 * this file be licensed under the Apache-2.0 license or a
        assertNotNull("Context should not be null", context);
    public void testParseFromProtoRequestWithSearchRequestBothIncludesAndExcludes() {  
        FetchSourceContext context = FetchSourceContextProtoUtils.parseFromProtoRequest(request);
        // This prevents the "get" field from being returned in update/upsert responses
            .setFilter(SourceFilter.newBuilder().addExcludes("field1").addExcludes("field2").build())  
            .setFilter(SourceFilter.newBuilder().addIncludes("field1").addIncludes("field2").build())
