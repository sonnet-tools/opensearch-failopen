        private final String methodName;
        public UnaryType(Class<?> unaryType) {
        public List<String> getParameterNames() {
    public interface AnyContinue extends Condition {
        private final List<Class<?>> typeParameters;
            this.converter = converter;
        }
            return typeParameters;
        private final Class<?> staticType;
 * Licensed to Elasticsearch under one or more contributor
        private final List<String> parameterNames;
        public StandardPainlessClassBinding(PainlessClassBinding painlessClassBinding) {
            return parameterNames;
    public static class IRNodeDecoration implements Decoration {
    public interface Explicit extends Condition {
    }
        public String getValueCanonicalTypeName() {
 * this file be licensed under the Apache-2.0 license or a
        public ValueType(Class<?> valueType) {
        public EncodingDecoration(String encoding) {
        public PainlessClassBinding getPainlessClassBinding() {
        public PainlessConstructor getStandardPainlessConstructor() {
    }
        public StandardPainlessField(PainlessField standardPainlessField) {
 */
            return semanticVariable;
    }
        public Class<?> getValueType() {
    }
        }
            this.staticType = Objects.requireNonNull(staticType);
    public interface Negate extends Condition {
    }
        public String getUnaryCanonicalTypeName() {
        public BinaryType(Class<?> binaryType) {
    }
    }
    public static class StandardLocalFunction implements Decoration {
    public interface IsDocument extends Condition {
        }
        }
    public interface Compound extends Condition {
    }
    public interface ListShortcut extends Condition {
    }
        }
        public StandardPainlessConstructor(PainlessConstructor standardPainlessConstructor) {
        }
/*
        }
            return painlessClassBinding;
        public PainlessMethod getStandardPainlessMethod() {
        public GetterPainlessMethod(PainlessMethod getterPainlessMethod) {
    public static class StandardPainlessClassBinding implements Decoration {
    public static class TargetType implements Decoration {
            return compoundType;
        public int getAccessDepth() {
        }
        public StandardPainlessMethod(PainlessMethod standardPainlessMethod) {
import org.opensearch.painless.lookup.PainlessConstructor;
    // additional output acquired during the semantic process
    }
        }
        }
        }
        }
 * the Apache License, Version 2.0 (the "License"); you may
            return comparisonType;
        private final Class<?> instanceType;
 * compatible open source license.
        }
        }
        private final Class<?> returnType;
        public Class<?> getCompoundType() {
        private final PainlessCast expressionPainlessCast;
    public interface BeginLoop extends Condition {
        public Variable getSemanticVariable() {
            this.encoding = Objects.requireNonNull(encoding);
    public static class StandardPainlessField implements Decoration {
    }
        }
    }
package org.opensearch.painless.symbol;
import org.opensearch.painless.symbol.SemanticScope.Variable;
    }
    public static class SetterPainlessMethod implements Decoration {
    }
        }
 */
        public String getPartialCanonicalTypeName() {
        }
    public interface LoopEscape extends Condition {
    public interface MethodEscape extends Condition {
 * Unless required by applicable law or agreed to in writing,
        public String getReturnCanonicalTypeName() {
import org.opensearch.painless.FunctionRef;
    public interface MapShortcut extends Condition {
        public Class<?> getTargetType() {
            return PainlessLookupUtility.typeToCanonicalTypeName(returnType);
    public interface LastLoop extends Condition {
    public static class PartialCanonicalTypeName implements Decoration {
    }
 * this work for additional information regarding copyright
        }
        }
        public CapturesDecoration(List<Variable> captures) {
        public List<Class<?>> getTypeParameters() {
        }
        }
        }
            return unaryType;
            return PainlessLookupUtility.typeToCanonicalTypeName(compoundType);
        private final PainlessMethod iterablePainlessMethod;
            this.typeParameters = Collections.unmodifiableList(new ArrayList<>(Objects.requireNonNull(typeParameters)));
            this.shiftType = Objects.requireNonNull(shiftType);
        }
            return reference;
        private final Class<?> compoundType;
        }
            return downcastPainlessCast;
            this.painlessInstanceBinding = Objects.requireNonNull(painlessInstanceBinding);
        public String getInstanceCanonicalTypeName() {
        public PartialCanonicalTypeName(String partialCanonicalTypeName) {
    // standard output for user statement nodes during semantic phase
    }
        }
        private final PainlessConstructor standardPainlessConstructor;
    public static class Converter implements Decoration {
        }
import java.util.ArrayList;
        }
            this.getterPainlessMethod = Objects.requireNonNull(getterPainlessMethod);
import org.opensearch.painless.ir.IRNode;
        public InstanceType(Class<?> instanceType) {
import java.util.Objects;
        public ParameterNames(List<String> parameterNames) {
 *
            return PainlessLookupUtility.typeToCanonicalTypeName(unaryType);
        }
    public interface InLoop extends Condition {
        public Class<?> getComparisonType() {
            this.reference = Objects.requireNonNull(reference);
 * SPDX-License-Identifier: Apache-2.0
    }
        }
            return setterPainlessMethod;
        }
            return encoding;
    }
import org.opensearch.painless.symbol.FunctionTable.LocalFunction;
            this.accessDepth = accessDepth;
        }
        public Class<?> getUnaryType() {
            return PainlessLookupUtility.typeToCanonicalTypeName(shiftType);
 * ownership. Elasticsearch licenses this file to you under
    public interface Shortcut extends Condition {
        }
    public static class StaticType implements Decoration {
            this.partialCanonicalTypeName = Objects.requireNonNull(partialCanonicalTypeName);
            this.standardPainlessMethod = Objects.requireNonNull(standardPainlessMethod);
    }
            this.semanticVariable = semanticVariable;
 * You may obtain a copy of the License at
        private final Object standardConstant;
 * not use this file except in compliance with the License.
    public static class CapturesDecoration implements Decoration {
    public static class SemanticVariable implements Decoration {
    }
            return binaryType;
        }
        }
        }
    public static class ReturnType implements Decoration {
        }
import java.util.Collections;
    }
}
/*
        public PainlessMethod getGetterPainlessMethod() {
        }
        public String getMethodName() {
        private final FunctionRef reference;
        public PainlessCast getUpcastPainlessCast() {
        }
            return converter;
    }
            return staticType;
        }
 * GitHub history for details.
            return localFunction;
        public Class<?> getInstanceType() {
        public String getShiftCanonicalTypeName() {
        public Class<?> getStaticType() {
            return standardConstant;
    public static class ParameterNames implements Decoration {
    }
    }
            return returnType;
import org.opensearch.painless.lookup.PainlessClassBinding;
    }
    }
        private final Class<?> unaryType;
        public String getBinaryCanonicalTypeName() {
            return partialCanonicalTypeName;
    // standard output for user tree to ir tree phase
            this.localFunction = Objects.requireNonNull(localFunction);
    public static class AccessDepth implements Decoration {
            this.downcastPainlessCast = Objects.requireNonNull(downcastPainlessCast);
        }
        }
            this.painlessClassBinding = Objects.requireNonNull(painlessClassBinding);
        public Class<?> getBinaryType() {
    public static class GetterPainlessMethod implements Decoration {
        private final PainlessCast downcastPainlessCast;
        }
    public interface ContinuousLoop extends Condition {
            this.comparisonType = Objects.requireNonNull(comparisonType);
        public StaticType(Class<?> staticType) {
        }
    }
        }
import org.opensearch.painless.lookup.PainlessLookupUtility;
        }
        }
        public IRNode getIRNode() {
        }
        private final PainlessInstanceBinding painlessInstanceBinding;
    }
        }
        private final PainlessCast upcastPainlessCast;
        private final Class<?> targetType;
import org.opensearch.painless.symbol.Decorator.Condition;
    public static class UpcastPainlessCast implements Decoration {
 *
    public static class ShiftType implements Decoration {
    public interface DefOptimized extends Condition {
 */
    }
    }
            this.captures = Collections.unmodifiableList(new ArrayList<>(Objects.requireNonNull(captures)));
    }
            return PainlessLookupUtility.typeToCanonicalTypeName(binaryType);
        public PainlessField getStandardPainlessField() {
        private final List<Variable> captures;
    // collect additional information about where doc is used
            return irNode;
            this.compoundType = Objects.requireNonNull(compoundType);
    }
        }
    }
    public static class EncodingDecoration implements Decoration {
        private final Class<?> valueType;
    }
            return shiftType;
 * software distributed under the License is distributed on an
        }
        public IRNodeDecoration(IRNode irNode) {
        public Class<?> getReturnType() {
            return targetType;
            return PainlessLookupUtility.typeToCanonicalTypeName(targetType);
 *
        }
        public SemanticVariable(Variable semanticVariable) {
        private final Class<?> binaryType;
            return standardPainlessField;
        }
        public String getStaticCanonicalTypeName() {
        private final PainlessMethod standardPainlessMethod;
    public static class StandardConstant implements Decoration {
 *     http://www.apache.org/licenses/LICENSE-2.0
            return valueType;
            this.targetType = Objects.requireNonNull(targetType);
            this.methodName = Objects.requireNonNull(methodName);
        public Converter(LocalFunction converter) {
            return PainlessLookupUtility.typeToCanonicalTypeName(instanceType);
        public ShiftType(Class<?> shiftType) {
import org.opensearch.painless.lookup.PainlessCast;
    }
        public MethodNameDecoration(String methodName) {
    }
        }
    }
            this.iterablePainlessMethod = Objects.requireNonNull(iterablePainlessMethod);
        public LocalFunction getLocalFunction() {
        public String getComparisonCanonicalTypeName() {
        public String getCompoundCanonicalTypeName() {
        public List<Variable> getCaptures() {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        public SetterPainlessMethod(PainlessMethod setterPainlessMethod) {
            return expressionPainlessCast;
    }
    public static class ExpressionPainlessCast implements Decoration {
        }
        public PainlessMethod getSetterPainlessMethod() {
        }
        public StandardConstant(Object standardConstant) {
    }
        public PainlessCast getExpressionPainlessCast() {
        }
            this.standardPainlessField = Objects.requireNonNull(standardPainlessField);
        }
    public static class CompoundType implements Decoration {
 * specific language governing permissions and limitations
 * license agreements. See the NOTICE file distributed with
    public interface Internal extends Condition {
 * KIND, either express or implied.  See the License for the
        private final int accessDepth;
            this.returnType = Objects.requireNonNull(returnType);
            this.instanceType = Objects.requireNonNull(instanceType);
 * Modifications Copyright OpenSearch Contributors. See
        }
    public static class ComparisonType implements Decoration {
            return methodName;
    }
        public StandardLocalFunction(LocalFunction localFunction) {
public class Decorations {
    }
    public static class StandardPainlessMethod implements Decoration {
        public PainlessMethod getIterablePainlessMethod() {
        private final PainlessField standardPainlessField;
    }
    public interface AnyBreak extends Condition {
    public static class TypeParameters implements Decoration {
            return accessDepth;
    }
            return PainlessLookupUtility.typeToCanonicalTypeName(valueType);
    }
        }
        public ReferenceDecoration(FunctionRef reference) {
        }
        public String getEncoding() {
        }
        public ExpressionPainlessCast(PainlessCast expressionPainlessCast) {
    }
    }
    public static class BinaryType implements Decoration {
        public Object getStandardConstant() {
            this.setterPainlessMethod = Objects.requireNonNull(setterPainlessMethod);
        }
    public interface Write extends Condition {
            return getterPainlessMethod;
            return instanceType;
        public String getTargetCanonicalTypeName() {
        private final Class<?> shiftType;
 * under the License.
        }
        public UpcastPainlessCast(PainlessCast upcastPainlessCast) {
    public static class IterablePainlessMethod implements Decoration {
    public static class UnaryType implements Decoration {
            return painlessInstanceBinding;
/*
        }
    }
            this.binaryType = Objects.requireNonNull(binaryType);
            this.irNode = Objects.requireNonNull(irNode);
    public static class ValueType implements Decoration {
        private final PainlessClassBinding painlessClassBinding;
            return PainlessLookupUtility.typeToCanonicalTypeName(comparisonType);
import org.opensearch.painless.lookup.PainlessMethod;
    // standard input for user statement nodes during semantic phase
        private final LocalFunction converter;
            return standardPainlessMethod;
    }
    public interface Read extends Condition {
        public ReturnType(Class<?> returnType) {
        private final String partialCanonicalTypeName;
        private final PainlessMethod setterPainlessMethod;
 * The OpenSearch Contributors require contributions made to
        }
            return PainlessLookupUtility.typeToCanonicalTypeName(staticType);
    public interface AllEscape extends Condition {
    public static class DowncastPainlessCast implements Decoration {
    }
        public IterablePainlessMethod(PainlessMethod iterablePainlessMethod) {
        private final Variable semanticVariable;
        }
        private final Class<?> comparisonType;
    public interface LastSource extends Condition {
        }
    // standard input for user expression nodes during semantic phase
            this.valueType = Objects.requireNonNull(valueType);
            return upcastPainlessCast;
            this.standardPainlessConstructor = Objects.requireNonNull(standardPainlessConstructor);
    }
import java.util.List;
            this.standardConstant = Objects.requireNonNull(standardConstant);
            return captures;
        public Class<?> getShiftType() {
        }
        private final PainlessMethod getterPainlessMethod;
    public static class StandardPainlessConstructor implements Decoration {
import org.opensearch.painless.lookup.PainlessField;
    public static class StandardPainlessInstanceBinding implements Decoration {
        }
        private final String encoding;
        public PainlessInstanceBinding getPainlessInstanceBinding() {
        }
        }
        public PainlessCast getDowncastPainlessCast() {
        public TargetType(Class<?> targetType) {
    public static class InstanceType implements Decoration {
        public FunctionRef getReference() {
import org.opensearch.painless.symbol.Decorator.Decoration;
        public LocalFunction getConverter() {
        }
        }
        }
            this.expressionPainlessCast = Objects.requireNonNull(expressionPainlessCast);
        }
    }
        public ComparisonType(Class<?> comparisonType) {
    public static class ReferenceDecoration implements Decoration {
            return iterablePainlessMethod;
        public DowncastPainlessCast(PainlessCast downcastPainlessCast) {
    }
    public static class MethodNameDecoration implements Decoration {
            return standardPainlessConstructor;
        private final LocalFunction localFunction;
            this.unaryType = Objects.requireNonNull(unaryType);
    }
    // standard output for user expression node during semantic phase
            this.parameterNames = Collections.unmodifiableList(new ArrayList<>(Objects.requireNonNull(parameterNames)));
        public StandardPainlessInstanceBinding(PainlessInstanceBinding painlessInstanceBinding) {
        }
import org.opensearch.painless.lookup.PainlessInstanceBinding;
        public TypeParameters(List<Class<?>> typeParameters) {
        }
        public CompoundType(Class<?> compoundType) {
        }
        private final IRNode irNode;
            this.upcastPainlessCast = Objects.requireNonNull(upcastPainlessCast);
    }
    }
        public AccessDepth(int accessDepth) {
