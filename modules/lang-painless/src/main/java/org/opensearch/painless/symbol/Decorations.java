            this.partialCanonicalTypeName = Objects.requireNonNull(partialCanonicalTypeName);  
 *  
            return partialCanonicalTypeName;
import org.opensearch.painless.symbol.FunctionTable.LocalFunction;  
    public static class StandardPainlessField implements Decoration {  
    }
    public interface AnyBreak extends Condition {
            this.painlessClassBinding = Objects.requireNonNull(painlessClassBinding);  
        public PainlessClassBinding getPainlessClassBinding() {  
    public static class TypeParameters implements Decoration {  
        public UpcastPainlessCast(PainlessCast upcastPainlessCast) {
import org.opensearch.painless.lookup.PainlessField;  
    public static class StandardPainlessConstructor implements Decoration {
        public PainlessMethod getIterablePainlessMethod() {
        public ParameterNames(List<String> parameterNames) {
    public interface Negate extends Condition {
 *
        }  
        }
    public static class SetterPainlessMethod implements Decoration {
            this.staticType = Objects.requireNonNull(staticType);
        private final Class<?> targetType;
    }  
    }
import org.opensearch.painless.lookup.PainlessCast;  
            return irNode;  
            return painlessClassBinding;
        private final String methodName;
    public static class AccessDepth implements Decoration {  
    }
        public Variable getSemanticVariable() {  
        public String getStaticCanonicalTypeName() {
    public interface InLoop extends Condition {
            this.typeParameters = Collections.unmodifiableList(new ArrayList<>(Objects.requireNonNull(typeParameters)));
            this.shiftType = Objects.requireNonNull(shiftType);  
    public static class UnaryType implements Decoration {  
            return PainlessLookupUtility.typeToCanonicalTypeName(unaryType);
            return setterPainlessMethod;
import java.util.Objects;  
            return expressionPainlessCast;  
        private final PainlessMethod standardPainlessMethod;
            this.standardConstant = Objects.requireNonNull(standardConstant);
    }  
        }  
            return PainlessLookupUtility.typeToCanonicalTypeName(comparisonType);
        private final Class<?> instanceType;
            return PainlessLookupUtility.typeToCanonicalTypeName(instanceType);  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        }
    }
 * The OpenSearch Contributors require contributions made to  
 * this file be licensed under the Apache-2.0 license or a
        public PainlessMethod getSetterPainlessMethod() {  
        private final PainlessCast expressionPainlessCast;
        public PainlessField getStandardPainlessField() {
    // additional output acquired during the semantic process  
        public UnaryType(Class<?> unaryType) {
    }
            this.reference = Objects.requireNonNull(reference);
        }  
    public static class MethodNameDecoration implements Decoration {  
        }  
    public static class ExpressionPainlessCast implements Decoration {  
        private final PainlessCast upcastPainlessCast;  
        }
    }
    }
        }  
            this.standardPainlessField = Objects.requireNonNull(standardPainlessField);
    }  
    // standard output for user expression node during semantic phase
    }
            this.irNode = Objects.requireNonNull(irNode);
            return iterablePainlessMethod;
        public LocalFunction getConverter() {
        public Class<?> getUnaryType() {
        private final Class<?> shiftType;  
        public CompoundType(Class<?> compoundType) {  
    }  
    public interface LastSource extends Condition {  
        public StandardPainlessConstructor(PainlessConstructor standardPainlessConstructor) {
        }
        public String getCompoundCanonicalTypeName() {
 * SPDX-License-Identifier: Apache-2.0
            this.standardPainlessMethod = Objects.requireNonNull(standardPainlessMethod);
        }
        }
        public EncodingDecoration(String encoding) {
        private final List<String> parameterNames;  
        public List<String> getParameterNames() {  
    public static class SemanticVariable implements Decoration {
    }
            this.methodName = Objects.requireNonNull(methodName);
        public String getPartialCanonicalTypeName() {  
        }  
        }
 */  
 * license agreements. See the NOTICE file distributed with
 * the Apache License, Version 2.0 (the "License"); you may
        private final Object standardConstant;
            return unaryType;  
    }
        public ShiftType(Class<?> shiftType) {
    }  
            this.localFunction = Objects.requireNonNull(localFunction);
        private final PainlessMethod getterPainlessMethod;
import org.opensearch.painless.lookup.PainlessInstanceBinding;
            this.instanceType = Objects.requireNonNull(instanceType);
        }
        }
    }  
/*  
        public PainlessMethod getStandardPainlessMethod() {
        public StandardPainlessMethod(PainlessMethod standardPainlessMethod) {  
    }
 * GitHub history for details.
        }  
            this.standardPainlessConstructor = Objects.requireNonNull(standardPainlessConstructor);  
        public Class<?> getStaticType() {
    public interface Internal extends Condition {  
        public String getShiftCanonicalTypeName() {
        }  
        }  
        public TargetType(Class<?> targetType) {
            this.comparisonType = Objects.requireNonNull(comparisonType);
    }  
 * under the License.  
        public String getReturnCanonicalTypeName() {
        }
        }
        public CapturesDecoration(List<Variable> captures) {
    }
    public static class ReferenceDecoration implements Decoration {
        public IterablePainlessMethod(PainlessMethod iterablePainlessMethod) {  
        private final PainlessConstructor standardPainlessConstructor;  
            return valueType;  
import org.opensearch.painless.symbol.Decorator.Condition;
    }
    public static class ShiftType implements Decoration {
        public TypeParameters(List<Class<?>> typeParameters) {
        private final Variable semanticVariable;  
            return reference;
    public interface IsDocument extends Condition {  
            return PainlessLookupUtility.typeToCanonicalTypeName(valueType);
    public static class CapturesDecoration implements Decoration {
    }
        }
        private final String encoding;
            return binaryType;
        }
        }
            return accessDepth;  
        public PainlessConstructor getStandardPainlessConstructor() {  
        }
            return comparisonType;  
    public static class StandardPainlessInstanceBinding implements Decoration {
 * specific language governing permissions and limitations
        public Converter(LocalFunction converter) {
        }
        }
        }
    }
    public static class ReturnType implements Decoration {
            return converter;  
            this.parameterNames = Collections.unmodifiableList(new ArrayList<>(Objects.requireNonNull(parameterNames)));  
    }
            return localFunction;  
    // standard output for user statement nodes during semantic phase
    public interface LoopEscape extends Condition {
            this.expressionPainlessCast = Objects.requireNonNull(expressionPainlessCast);
        public Class<?> getInstanceType() {
    }  
        public PainlessCast getUpcastPainlessCast() {  
            this.valueType = Objects.requireNonNull(valueType);
        public int getAccessDepth() {
            return compoundType;
        }
            this.returnType = Objects.requireNonNull(returnType);  
        public Class<?> getComparisonType() {
    }
        private final List<Variable> captures;  
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.painless.ir.IRNode;
import org.opensearch.painless.lookup.PainlessLookupUtility;
        public String getEncoding() {
    }
        }
        public PainlessMethod getGetterPainlessMethod() {
            return standardConstant;
            this.targetType = Objects.requireNonNull(targetType);
    public interface Shortcut extends Condition {  
        }  
        public String getUnaryCanonicalTypeName() {  
        }
        public StandardLocalFunction(LocalFunction localFunction) {
        }
            return returnType;
        public SetterPainlessMethod(PainlessMethod setterPainlessMethod) {
        }
        }
    }  
        }
    }  
    }  
 * not use this file except in compliance with the License.
            this.encoding = Objects.requireNonNull(encoding);
    public static class Converter implements Decoration {
            return downcastPainlessCast;
    public interface ContinuousLoop extends Condition {
            return standardPainlessMethod;
        private final PainlessCast downcastPainlessCast;
    public static class StandardLocalFunction implements Decoration {  
            return PainlessLookupUtility.typeToCanonicalTypeName(staticType);  
        }  
        private final LocalFunction converter;
        }
    public interface MapShortcut extends Condition {
 * ownership. Elasticsearch licenses this file to you under  
        }  
            this.downcastPainlessCast = Objects.requireNonNull(downcastPainlessCast);
 *     http://www.apache.org/licenses/LICENSE-2.0
    }
            this.binaryType = Objects.requireNonNull(binaryType);
        private final List<Class<?>> typeParameters;
    public interface AnyContinue extends Condition {  
            this.accessDepth = accessDepth;
    public static class PartialCanonicalTypeName implements Decoration {
    }
        }
        private final FunctionRef reference;
package org.opensearch.painless.symbol;
        }
import org.opensearch.painless.FunctionRef;
        }  
        public Object getStandardConstant() {
    }
        private final Class<?> unaryType;
        public PainlessCast getExpressionPainlessCast() {
        public DowncastPainlessCast(PainlessCast downcastPainlessCast) {  
        private final Class<?> staticType;
        public StandardPainlessInstanceBinding(PainlessInstanceBinding painlessInstanceBinding) {  
        }
        private final PainlessMethod setterPainlessMethod;  
        private final int accessDepth;
        public PainlessCast getDowncastPainlessCast() {
            this.semanticVariable = semanticVariable;  
    // standard input for user expression nodes during semantic phase
        public String getBinaryCanonicalTypeName() {
        public String getValueCanonicalTypeName() {  
    }
    public static class InstanceType implements Decoration {
 * KIND, either express or implied.  See the License for the
    public static class IterablePainlessMethod implements Decoration {
    }
    }
        private final Class<?> valueType;
 * compatible open source license.
        public Class<?> getReturnType() {  
    public interface MethodEscape extends Condition {  
        }  
            return encoding;  
    public interface BeginLoop extends Condition {
        public String getMethodName() {
            this.compoundType = Objects.requireNonNull(compoundType);
            this.unaryType = Objects.requireNonNull(unaryType);
    public interface DefOptimized extends Condition {
    }
        public AccessDepth(int accessDepth) {
    public static class StaticType implements Decoration {
        public StandardPainlessField(PainlessField standardPainlessField) {
    }
    public static class UpcastPainlessCast implements Decoration {
import org.opensearch.painless.symbol.SemanticScope.Variable;
        }
/*
        public SemanticVariable(Variable semanticVariable) {
        public StandardConstant(Object standardConstant) {  
        public ComparisonType(Class<?> comparisonType) {
        public Class<?> getBinaryType() {
 */  
            return PainlessLookupUtility.typeToCanonicalTypeName(compoundType);  
    public static class ComparisonType implements Decoration {  
        }  
    public static class ParameterNames implements Decoration {
        }
        }  
    }
 * this work for additional information regarding copyright
        private final Class<?> returnType;  
            return standardPainlessConstructor;
        public BinaryType(Class<?> binaryType) {  
        private final LocalFunction localFunction;
 */
    // collect additional information about where doc is used
            return typeParameters;  
        public Class<?> getCompoundType() {
            return captures;
    public interface AllEscape extends Condition {
            return PainlessLookupUtility.typeToCanonicalTypeName(shiftType);
        public FunctionRef getReference() {
        private final Class<?> compoundType;
    }
            return PainlessLookupUtility.typeToCanonicalTypeName(returnType);
    // standard output for user tree to ir tree phase
            return staticType;
        }
        }  
        public IRNode getIRNode() {
            this.upcastPainlessCast = Objects.requireNonNull(upcastPainlessCast);  
        public Class<?> getTargetType() {
    public static class BinaryType implements Decoration {
        }
        public ReferenceDecoration(FunctionRef reference) {  
            return targetType;  
    }
        }  
            return upcastPainlessCast;
 * software distributed under the License is distributed on an
    }
        public StaticType(Class<?> staticType) {  
    public static class ValueType implements Decoration {  
        }
    public static class CompoundType implements Decoration {
        public Class<?> getShiftType() {  
    public interface Read extends Condition {
 * You may obtain a copy of the License at  
    public static class IRNodeDecoration implements Decoration {  
        public Class<?> getValueType() {
        public InstanceType(Class<?> instanceType) {  
        public StandardPainlessClassBinding(PainlessClassBinding painlessClassBinding) {
    public static class GetterPainlessMethod implements Decoration {  
            return parameterNames;
    public static class EncodingDecoration implements Decoration {  
    public interface ListShortcut extends Condition {
        public String getComparisonCanonicalTypeName() {  
    }  
        public List<Variable> getCaptures() {  
        public MethodNameDecoration(String methodName) {
        }
            return PainlessLookupUtility.typeToCanonicalTypeName(targetType);
            return shiftType;
    public static class StandardConstant implements Decoration {
public class Decorations {
    }  
    }  
import java.util.List;
        public ReturnType(Class<?> returnType) {
 * Unless required by applicable law or agreed to in writing,
        public IRNodeDecoration(IRNode irNode) {
        }
        }
            this.painlessInstanceBinding = Objects.requireNonNull(painlessInstanceBinding);
    }
        public ValueType(Class<?> valueType) {
        }
        }
        private final String partialCanonicalTypeName;  
        public PainlessInstanceBinding getPainlessInstanceBinding() {
        }  
import org.opensearch.painless.lookup.PainlessClassBinding;
        }
        }  
 *
    }  
        }
        private final PainlessClassBinding painlessClassBinding;  
        }  
            return PainlessLookupUtility.typeToCanonicalTypeName(binaryType);  
import java.util.Collections;
            return standardPainlessField;  
        }
        }
    }  
        }
        private final Class<?> comparisonType;
/*  
        public GetterPainlessMethod(PainlessMethod getterPainlessMethod) {
            return methodName;  
    public interface Write extends Condition {
 * Modifications Copyright OpenSearch Contributors. See
        }
    // standard input for user statement nodes during semantic phase
    }
    }
        public String getTargetCanonicalTypeName() {  
        public LocalFunction getLocalFunction() {
    public static class StandardPainlessMethod implements Decoration {
        private final PainlessInstanceBinding painlessInstanceBinding;
    }
    public static class DowncastPainlessCast implements Decoration {
            this.converter = converter;
            this.iterablePainlessMethod = Objects.requireNonNull(iterablePainlessMethod);
        }  
import org.opensearch.painless.lookup.PainlessConstructor;
    }
    public interface LastLoop extends Condition {  
        }
        public PartialCanonicalTypeName(String partialCanonicalTypeName) {
    public interface Compound extends Condition {
import org.opensearch.painless.symbol.Decorator.Decoration;
    }
    public static class TargetType implements Decoration {  
            this.getterPainlessMethod = Objects.requireNonNull(getterPainlessMethod);
        }
        }
        public ExpressionPainlessCast(PainlessCast expressionPainlessCast) {
import org.opensearch.painless.lookup.PainlessMethod;  
            return semanticVariable;
}  
        }  
            return painlessInstanceBinding;
    public interface Explicit extends Condition {
        }  
import java.util.ArrayList;  
        private final PainlessMethod iterablePainlessMethod;
        }
        }
    }
        }
        private final PainlessField standardPainlessField;
        public List<Class<?>> getTypeParameters() {
            this.setterPainlessMethod = Objects.requireNonNull(setterPainlessMethod);  
            this.captures = Collections.unmodifiableList(new ArrayList<>(Objects.requireNonNull(captures)));  
            return getterPainlessMethod;  
        private final Class<?> binaryType;
            return instanceType;
        }  
        private final IRNode irNode;
    }  
    public static class StandardPainlessClassBinding implements Decoration {
        }  
        }
    }  
        public String getInstanceCanonicalTypeName() {
