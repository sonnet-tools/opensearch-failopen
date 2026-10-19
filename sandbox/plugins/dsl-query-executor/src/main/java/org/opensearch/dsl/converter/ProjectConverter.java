            projects.add(rexBuilder.makeInputRef(field.getType(), field.getIndex()));
import org.apache.calcite.rel.RelNode;
import org.apache.calcite.rex.RexBuilder;
                if (pattern.contains("*")) {  
                    if (compiled.matcher(field.getName()).matches()) {  
 * Converts {@code _source} field selection to a {@link LogicalProject}.
            }
 * SPDX-License-Identifier: Apache-2.0
        return createProjection(input, includes, excludes, ctx.getRexBuilder());
            Set<String> excludeSet = (excludes != null && excludes.length > 0) ? buildExcludeSet(excludes, rowType) : Set.of();
        String[] parts = wildcardPattern.split("\\*", -1);
        RexBuilder rexBuilder,  
        return ctx.getSearchSource().fetchSource() != null;
import org.apache.calcite.rel.type.RelDataType;  
        }
                Pattern compiled = toWildcardRegex(pattern);
                    if (!excludeSet.contains(pattern)) {  
                } else {
        }
    }
                }  
 */  
        RelDataType rowType,
            }
/**  
        List<RexNode> projects,  
        Set<String> seen = new HashSet<>();  
            if (i > 0) {
    /** Creates a project converter. */  
    private static Pattern toWildcardRegex(String wildcardPattern) {
        }
    // nonexistent field names — consistent with OpenSearch core behavior.
            Set<String> excludeSet = buildExcludeSet(excludes, rowType);
                for (RelDataTypeField field : rowType.getFieldList()) {
        String fieldName,
 * compatible open source license.
        RelDataTypeField field = rowType.getField(fieldName, false, false);
                    }
    private RelNode createProjection(RelNode input, String[] includes, String[] excludes, RexBuilder rexBuilder)
        boolean hasIncludes = includes != null && includes.length > 0;  
        boolean hasExcludes = excludes != null && excludes.length > 0;
                        resolveField(pattern, rowType, rexBuilder, projects, fieldNames, seen);
    }  
}
    ) {
        for (String pattern : excludes) {
    }
            if (pattern.contains("*")) {  
            // Exclude-only mode: all fields except excluded  
        if (!hasIncludes && !hasExcludes) {  
import org.apache.calcite.rex.RexNode;  
        String[] includes = fetchSource.includes();
        Set<String> excludeSet = new HashSet<>();
        for (int i = 0; i < parts.length; i++) {
            for (String pattern : includes) {
            // Include mode: only listed fields, then apply excludes as post-filter  
        } else {
        }  
            return LogicalProject.create(input, List.of(), List.of(), List.of());
        List<RexNode> projects,
            fieldNames.add(field.getName());
import java.util.List;
    @Override
            }  
    }
        Set<String> seen,
 * The OpenSearch Contributors require contributions made to  
                    projects.add(rexBuilder.makeInputRef(field.getType(), field.getIndex()));
        RelDataType rowType = input.getRowType();  
                if (!excludeSet.contains(field.getName())) {  
        }  
        StringBuilder regex = new StringBuilder();  
                    resolveWildcard(pattern, rowType, rexBuilder, projects, fieldNames, seen, excludeSet);
        Pattern compiled = toWildcardRegex(pattern);
            return input;
        if (seen.add(field.getName())) {  
        String pattern,  
    public ProjectConverter() {}
        throws ConversionException {
package org.opensearch.dsl.converter;
        List<String> fieldNames,
                regex.append(".*");  
import java.util.ArrayList;  
    // Unlike includes (resolveField throws for unknown fields), excludes silently ignore
import org.apache.calcite.rel.type.RelDataTypeField;
        Set<String> seen  
    @Override  
        return LogicalProject.create(input, List.of(), projects, fieldNames);
    protected boolean isApplicable(ConversionContext ctx) {
    protected RelNode doConvert(RelNode input, ConversionContext ctx) throws ConversionException {  
 *
    }
        String[] excludes = fetchSource.excludes();
                    }
                    fieldNames.add(field.getName());
            if (compiled.matcher(field.getName()).matches() && !excludeSet.contains(field.getName()) && seen.add(field.getName())) {
        }
        if (includes != null && includes.length > 0) {
        List<String> fieldNames = new ArrayList<>();
    private Set<String> buildExcludeSet(String[] excludes, RelDataType rowType) {  
                excludeSet.add(pattern);
        return Pattern.compile(regex.toString());
import java.util.regex.Pattern;
        if (!fetchSource.fetchSource()) {  
 * Handles exact field names, wildcard patterns, and {@code _source: false}.
import java.util.Set;  
        List<String> fieldNames,
public class ProjectConverter extends AbstractDslConverter {
    }
            }
 * this file be licensed under the Apache-2.0 license or a
    ) throws ConversionException {
 */  
import org.opensearch.search.fetch.subphase.FetchSourceContext;
        // No error if nothing matches — consistent with OpenSearch core, which returns empty _source  
                }  
        return excludeSet;
        for (RelDataTypeField field : rowType.getFieldList()) {  
    private void resolveWildcard(
                projects.add(rexBuilder.makeInputRef(field.getType(), field.getIndex()));
        RelDataType rowType,
            for (RelDataTypeField field : rowType.getFieldList()) {
            regex.append(Pattern.quote(parts[i]));
            throw new ConversionException("Field '" + fieldName + "' not found in schema");
                fieldNames.add(field.getName());  
/*  
            }
        }
            } else {
    }  
import java.util.HashSet;
                        excludeSet.add(field.getName());
        Set<String> excludeSet  
        FetchSourceContext fetchSource = ctx.getSearchSource().fetchSource();
    private void resolveField(  
        List<RexNode> projects = new ArrayList<>();
        if (field == null) {  
import org.apache.calcite.rel.logical.LogicalProject;
                }  
        RexBuilder rexBuilder,
        }
