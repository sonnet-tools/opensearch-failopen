        if (innerHits.getScriptFieldsCount() > 0) {
        }  
        }
        if (innerHits.hasCollapse()) {  
                ScriptField scriptFieldProto = entry.getValue();  
            innerHitBuilder.setSorts(SortBuilderProtoUtils.fromProto(innerHits.getSortList(), registry));
                docvalueFieldsList.add(FieldAndFormatProtoUtils.fromProto(fieldAndFormat));  
            innerHitBuilder.setInnerCollapse(CollapseBuilderProtoUtils.fromProto(innerHits.getCollapse(), registry));
        if (innerHits.hasTrackScores()) {  
import org.opensearch.transport.grpc.spi.QueryBuilderProtoConverterRegistry;
            innerHitBuilder.setFrom(innerHits.getFrom());
        }
    }
        }
 *  
    public static InnerHitBuilder fromProto(InnerHits innerHits, QueryBuilderProtoConverterRegistry registry) throws IOException {
    }  
/**
     */
        }
            innerHitBuilder.setName(innerHits.getName());
import org.opensearch.transport.grpc.proto.request.common.FetchSourceContextProtoUtils;
        // Utility class, no instances
        if (innerHits.getSortCount() > 0) {  
        if (innerHits.getFieldsCount() > 0) {
public class InnerHitsBuilderProtoUtils {
                    scriptFieldProto  
        }
                scriptFields.add(scriptField);
        if (innerHits.hasXSource()) {  
        if (innerHits.hasSeqNoPrimaryTerm()) {  
        }
        if (innerHits.hasExplain()) {  
 */  
        if (innerHits.getDocvalueFieldsCount() > 0) {  
        if (innerHits.getStoredFieldsCount() > 0) {  
                fieldsList.add(FieldAndFormatProtoUtils.fromProto(fieldAndFormat));
            innerHitBuilder.setIgnoreUnmapped(innerHits.getIgnoreUnmapped());
import java.util.ArrayList;
            innerHitBuilder.setSeqNoAndPrimaryTerm(innerHits.getSeqNoPrimaryTerm());
     * @param registry The registry for query conversion (needed for sorts and highlights with queries)
        }
            }  
}
import org.opensearch.protobufs.ScriptField;
import java.util.Map;
import java.io.IOException;  
package org.opensearch.transport.grpc.proto.request.search;
import java.util.HashSet;
            throw new IllegalArgumentException("InnerHits cannot be null");
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
            innerHitBuilder.setStoredFieldNames(innerHits.getStoredFieldsList());
                );
        }
import java.util.Set;
import java.util.List;  
        if (innerHits == null) {  
            innerHitBuilder.setVersion(innerHits.getVersion());
                SearchSourceBuilder.ScriptField scriptField = SearchSourceBuilderProtoUtils.ScriptFieldProtoUtils.fromProto(
        }
        if (innerHits.hasIgnoreUnmapped()) {  
            innerHitBuilder.setFetchSourceContext(FetchSourceContextProtoUtils.fromProto(innerHits.getXSource()));
            for (Map.Entry<String, ScriptField> entry : innerHits.getScriptFieldsMap().entrySet()) {
        if (innerHits.hasName()) {  
            List<FieldAndFormat> fieldsList = new ArrayList<>();
            innerHitBuilder.setExplain(innerHits.getExplain());
        }
 * Utility class for converting SearchSourceBuilder Protocol Buffers to objects
            innerHitBuilder.setScriptFields(scriptFields);
            for (org.opensearch.protobufs.FieldAndFormat fieldAndFormat : innerHits.getFieldsList()) {  
import org.opensearch.index.query.InnerHitBuilder;  
 */
     * @return the converted OpenSearch InnerHitBuilder
        }
            Set<SearchSourceBuilder.ScriptField> scriptFields = new HashSet<>();  
        }
    private InnerHitsBuilderProtoUtils() {
            }
import org.opensearch.search.builder.SearchSourceBuilder;  
        }
 * The OpenSearch Contributors require contributions made to  
        if (innerHits.hasVersion()) {  
    /**
            for (org.opensearch.protobufs.FieldAndFormat fieldAndFormat : innerHits.getDocvalueFieldsList()) {
        }
     * @param innerHits the protobuf InnerHits to convert  
 *
     * @throws IOException if there's an error during parsing  
            innerHitBuilder.setDocValueFields(docvalueFieldsList);
                String name = entry.getKey();
import org.opensearch.search.fetch.subphase.FieldAndFormat;
     * Converts a single protobuf InnerHits to an OpenSearch InnerHitBuilder.  
     *
            innerHitBuilder.setFetchFields(fieldsList);  
        if (innerHits.hasHighlight()) {  
import org.opensearch.protobufs.InnerHits;
            innerHitBuilder.setTrackScores(innerHits.getTrackScores());
/*  
import org.opensearch.transport.grpc.proto.request.search.sort.SortBuilderProtoUtils;  
            }
        }
        InnerHitBuilder innerHitBuilder = new InnerHitBuilder();
        return innerHitBuilder;
            List<FieldAndFormat> docvalueFieldsList = new ArrayList<>();
        if (innerHits.hasFrom()) {  
                    name,
     * Each InnerHits protobuf message represents ONE inner hit definition.
            innerHitBuilder.setHighlightBuilder(HighlightBuilderProtoUtils.fromProto(innerHits.getHighlight(), registry));
            innerHitBuilder.setSize(innerHits.getSize());
        if (innerHits.hasSize()) {  
 * SPDX-License-Identifier: Apache-2.0
        }
