    public static final class NestedPathFieldType extends StringFieldType {
     *
    public static String name(Version version) {  
        return NAME;  
    @Override
            FIELD_TYPE.setTokenized(false);
        }  
            FIELD_TYPE.setIndexOptions(IndexOptions.DOCS);
        }
 */
    public static final String LEGACY_NAME = "_type";
    private static final NestedPathFieldMapper LEGACY_INSTANCE = new NestedPathFieldMapper(LEGACY_NAME);  
    public static Query filter(Version version, String path) {
        @Override
    public static class Defaults {
    }
     * @opensearch.internal
    public static Field field(Version version, String path) {
import org.opensearch.index.engine.dataformat.FieldTypeCapabilities;  
        private NestedPathFieldType(String name) {
     */  
        return NAME;
        @Override
    }  
 *
            FIELD_TYPE.setStored(false);  
            FIELD_TYPE.freeze();
import org.apache.lucene.index.IndexOptions;  
    /** private ctor; using SINGLETON to control BWC */  
    private static final NestedPathFieldMapper INSTANCE = new NestedPathFieldMapper(NAME);
        public static final FieldType FIELD_TYPE = new FieldType();
        }  
         * this method, so classic nested queries are unaffected.
     * Default parameters for the field mapper  
            return LEGACY_NAME;
         * or search from any format, and its classic Lucene search field (this type is
         */  
        return new TermQuery(new Term(name(version), new BytesRef(path)));
import org.apache.lucene.index.Term;
import org.apache.lucene.document.Field;
    /** returns the field name */
import org.opensearch.index.query.QueryShardContext;
        }
    // OpenSearch version 2.0 removed types; this name is used for bwc
 * Replacement for TypesFieldMapper used in nested fields
        if (version.before(Version.V_2_0_0)) {
}  
         * Requests nothing from pluggable data formats. On a pluggable-format index this internal  
import org.apache.lucene.util.BytesRef;
import org.opensearch.search.lookup.SearchLookup;
 */  
import java.util.Collections;
        return new Field(name(version), path, Defaults.FIELD_TYPE);  
    }
 * SPDX-License-Identifier: Apache-2.0
        /**
 * @opensearch.internal
        static {  
import org.opensearch.Version;
    }
 * this file be licensed under the Apache-2.0 license or a
import org.apache.lucene.document.FieldType;
            super(name, true, false, false, TextSearchInfo.SIMPLE_MATCH_ONLY, Collections.emptyMap());  
        protected FieldTypeCapabilities.Capability searchCapability() {
 * The OpenSearch Contributors require contributions made to  
import org.apache.lucene.search.Query;
    public static final TypeParser PARSER = new FixedTypeParser(  
 *  
     * field type for the NestPath field  
    protected String contentType() {
            return NAME;
        public ValueFetcher valueFetcher(QueryShardContext context, SearchLookup searchLookup, String format) {
        c -> c.indexVersionCreated().before(Version.V_2_0_0) ? LEGACY_INSTANCE : INSTANCE
    }
        public String typeName() {
            throw new UnsupportedOperationException("Cannot run exists() query against the nested field path");
        @Override
         * searchable-only) would otherwise request a search capability no format is required to  
     */  
        }  
public class NestedPathFieldMapper extends MetadataFieldMapper {  
        }
    }
    /** helper method to create a lucene field based on the opensearch version */
            FIELD_TYPE.setOmitNorms(true);
         * field is used only as a parse-time scope marker for nested elements — it needs no storage
    }  
        public Set<FieldTypeCapabilities.Capability> requestedCapabilities() {
     * @opensearch.internal
        }  
import java.util.Set;
     *
    /** helper method to create a query based on the opensearch version */  
        }
    private NestedPathFieldMapper(String name) {
            return FieldTypeCapabilities.Capability.FULL_TEXT_SEARCH;
        @Override  
    );
import org.apache.lucene.search.TermQuery;  
 * compatible open source license.
        public Query existsQuery(QueryShardContext context) {  
/*  
    /**
            throw new UnsupportedOperationException("Cannot fetch values for internal field [" + name() + "].");  
package org.opensearch.index.mapper;
        super(new NestedPathFieldType(name));
        @Override  
            return Set.of();  
/**
    /**
         * serve, failing capability coverage on every such index. Only the pluggable path consults
    public static final String NAME = "_nested_path";  
