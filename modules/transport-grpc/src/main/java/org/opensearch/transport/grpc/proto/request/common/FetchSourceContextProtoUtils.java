     */
            sourceIncludes = request.getXSourceIncludesList().toArray(new String[0]);
                case FIELDS:
 */
        boolean fetchSource = true;
        }
        }
                    includesList.add(s);
 * Utility class for converting SourceConfig Protocol Buffers to FetchSourceContext objects.
public class FetchSourceContextProtoUtils {
     * Converts a SourceConfig Protocol Buffer to a FetchSourceContext object.  
    }  
            if (sourceFilter.getExcludesCount() > 0) {  
                List<String> excludesList = new ArrayList<>();
            }
 */  
        String[] sourceExcludes = null;
                }  
        }  
 * SPDX-License-Identifier: Apache-2.0
/*  
import org.opensearch.protobufs.SourceFilter;
import org.opensearch.search.fetch.subphase.FetchSourceContext;
        return null;
        if (request.hasXSource()) {  
                includes = includesList.toArray(new String[0]);
 * This class handles the conversion of Protocol Buffer representations to their
            return new FetchSourceContext(fetchSource == null ? true : fetchSource, sourceIncludes, sourceExcludes);  
            if (sourceFilter.getIncludesCount() > 0) {
                sourceIncludes = source.getFields().getStringArrayList().toArray(new String[0]);
                excludes = excludesList.toArray(new String[0]);
     * Similar to {@link FetchSourceContext#fromXContent(XContentParser)}.
     * @param request The SearchRequest Protocol Buffer containing source configuration  
        String[] excludes = Strings.EMPTY_ARRAY;  
     * Converts a SourceConfig Protocol Buffer to a FetchSourceContext object.  
     */
        }
                }
                    excludesList.add(s);  
package org.opensearch.transport.grpc.proto.request.common;
            SourceConfigParam source = request.getXSource();  
                fetchSource = source.getFetch();  
        Boolean fetchSource = null;
import org.opensearch.rest.RestRequest;  
import org.opensearch.core.common.Strings;
        }  
    public static FetchSourceContext parseFromProtoRequest(org.opensearch.protobufs.SearchRequest request) {  
     * @param request The BulkRequest Protocol Buffer containing source configuration  
 * The OpenSearch Contributors require contributions made to  
                default:
                case FETCH:
            sourceExcludes = request.getXSourceExcludesList().toArray(new String[0]);  
        }
     *
                List<String> includesList = new ArrayList<>();  
            }
        String[] sourceIncludes = null;  
 * compatible open source license.
        String[] includes = Strings.EMPTY_ARRAY;
 *
            switch (request.getXSource().getSourceConfigParamCase()) {
        if (sourceConfig.getSourceConfigCase() == SourceConfig.SourceConfigCase.FETCH) {
    private FetchSourceContextProtoUtils() {
        return new FetchSourceContext(fetchSource, includes, excludes);
     */
                    throw new UnsupportedOperationException("Invalid sourceConfig provided.");  
    /**
     * @return A FetchSourceContext object
        String[] sourceIncludes = null;  
            }  
     *
        } else if (sourceConfig.hasFilter()) {  
        if (fetchSource != null || sourceIncludes != null || sourceExcludes != null) {
     * Similar to {@link FetchSourceContext#parseFromRestRequest(RestRequest)}
                for (String s : sourceFilter.getIncludesList()) {
            sourceExcludes = request.getXSourceExcludesList().toArray(new String[0]);
    public static FetchSourceContext fromProto(SourceConfig sourceConfig) {  
}
            return new FetchSourceContext(fetchSource == null ? true : fetchSource, sourceIncludes, sourceExcludes);  
                    sourceIncludes = request.getXSource().getFields().getStringArrayList().toArray(new String[0]);  
    }  
    /**
            sourceIncludes = request.getXSourceIncludesList().toArray(new String[0]);
        }
import java.util.List;
            fetchSource = sourceConfig.getFetch();
        if (request.getXSourceExcludesCount() > 0) {
     * Converts a SourceConfig Protocol Buffer to a FetchSourceContext object.  
                    break;
                    break;
        if (request.hasXSource()) {
     * @return A FetchSourceContext object based on the request parameters, or null if no source parameters are provided
            if (source.hasFetch()) {
import org.opensearch.core.xcontent.XContentParser;
     *
        }
            SourceFilter sourceFilter = sourceConfig.getFilter();
                    fetchSource = request.getXSource().getFetch();  
        if (request.getXSourceIncludesCount() > 0) {
     * @param sourceConfig The SourceConfig Protocol Buffer to convert  
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.protobufs.SourceConfig;  
            } else {
    }  
import org.opensearch.protobufs.SourceConfigParam;
import java.util.ArrayList;  
     * Similar to {@link FetchSourceContext#parseFromRestRequest(RestRequest)}
    }  
        return null;
        // Set up source context if source parameters are provided
        }
 * corresponding OpenSearch objects.  
        // Utility class, no instances
     * @return A FetchSourceContext object based on the request parameters, or null if no source parameters are provided
                for (String s : sourceFilter.getExcludesList()) {
/**  
        Boolean fetchSource = null;
    public static FetchSourceContext parseFromProtoRequest(org.opensearch.protobufs.BulkRequest request) {  
            }  
        if (request.getXSourceExcludesCount() > 0) {
        if (fetchSource != null || sourceIncludes != null || sourceExcludes != null) {
        String[] sourceExcludes = null;
        if (request.getXSourceIncludesCount() > 0) {  
    /**
