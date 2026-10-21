                        org.apache.thrift.protocol.TType.LIST,
                write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
        );
            (short) 1
            return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __MAX_PARTS_ISSET_ID);
                    case 0: // SUCCESS
            create_table_result> {
                getProcessMap(
            TBL_NAME((short) 2, "tbl_name"),
                    new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, NoSuchObjectException.class)
            }
                    return getO4();
                sb.append("null");
                            fcall.sendResponse(fb, result, org.apache.thrift.protocol.TMessageType.REPLY, seqid);
        }
                throw new java.io.IOException(te);
            }
                }
        private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new add_partition_resultTupleSchemeFactory();
            boolean that_present_o2 = true && that.isSetO2();
                case O2:
                        for (Partition _iter163 : struct.success) {
                    return getO3();
            if (lastComparison != 0) {
            throw new java.lang.IllegalStateException();
            this.max_parts = max_parts;
            }
                    return getTbl_name();
            this.filter = filter;
            if (isSetO2()) hashCode = hashCode * 8191 + o2.hashCode();
                    iprot.readStructEnd();
            }
            /**
            lastComparison = java.lang.Boolean.compare(isSetFilter(), other.isSetFilter());
        private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new add_partition_argsTupleSchemeFactory();
            java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<
            "db_name",
        }
                return fields;
        private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
                }
        implements
        }
            }
            private static final java.util.Map<java.lang.String, _Fields> byName = new java.util.HashMap<java.lang.String, _Fields>();
                prot.writeMessageBegin(
            public get_partitions_by_filter_result getEmptyResultInstance() {
        }
                throw new java.lang.IllegalArgumentException();
                    "o2",
            private short max_parts;
                            result.o2 = (NoSuchObjectException) e;
                }
            ) throws org.apache.thrift.TException {
            @org.apache.thrift.annotation.Nullable
                org.apache.thrift.TApplicationException.MISSING_RESULT,
                    "new_part",
                case SUCCESS:
        @Override
                case O1:
                _Fields.O2,
                                } else {
        // isset id assignments
                        } catch (java.lang.Exception e) {
                    return getTbl_name();
        @org.apache.thrift.annotation.Nullable
                if (struct.isSetO2()) {
                return _thriftId;
            } else {
            }
            }
                    oprot.writeString(struct.tbl_name);
                return new get_table_req_args();
        public create_table_result setO4(@org.apache.thrift.annotation.Nullable NoSuchObjectException o4) {
                }
        private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("create_table_result");
    public static class Client extends org.apache.thrift.TServiceClient implements Iface {
        /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
            }
            try {
                        }
        private static class get_partitions_argsTupleScheme extends org.apache.thrift.scheme.TupleScheme<get_partitions_args> {
            "o1",
            boolean that_present_new_part = true && that.isSetNew_part();
            add_partition_result> {
                oprot.writeStructEnd();
        private static class get_partitions_argsStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
        public void clear() {
            metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
        private static class create_table_argsStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
                                }
            org.apache.thrift.async.TAsyncClientManager clientManager,
            if (this.tbl_name == null) {
            return this;
            return hashCode;
            if (result.o2 != null) {
        public static class get_partitions<I extends Iface> extends org.apache.thrift.ProcessFunction<
        public _Fields fieldForId(int fieldId) {
            this();
        // isset id assignments
        @Override
        public _Fields fieldForId(int fieldId) {
            boolean that_present_o2 = true && that.isSetO2();
                        return TBL_NAME;
        }
                _Fields,
                prot.writeMessageEnd();
            public static _Fields findByThriftIdOrThrow(int fieldId) {
            }
        }
                    oprot.writeFieldEnd();
                    oprot.writeFieldEnd();
            }
            @Override
        }
                        struct.o1 = new AlreadyExistsException();
            return _Fields.findByThriftId(fieldId);
        public void setFieldValue(_Fields field, @org.apache.thrift.annotation.Nullable java.lang.Object value) {
                new org.apache.thrift.meta_data.FieldMetaData(
        @Override
        }
            this();
                        return null;
                    } else {
                        } else if (e instanceof org.apache.thrift.TApplicationException) {
        public void setNew_partIsSet(boolean value) {
                iface,
            // check for required fields
        }
                if (struct.isSetNew_part()) {
            // check for required fields
                if (struct.isSetReq()) {
                        struct.o4 = new NoSuchObjectException();
            public void read(org.apache.thrift.protocol.TProtocol prot, create_database_args struct) throws org.apache.thrift.TException {
            return false;
                    iprot.decrementRecursionDepth();
        private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY =
            }
                }
                        } catch (java.lang.Exception ex) {
                } catch (InvalidObjectException o2) {
            tmpMap.put(
                _Fields.SUCCESS,
            @Override
                    return getO2();
                    return isSetO1();
            boolean first = true;
                            onError(e);
            java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<
            return _Fields.findByThriftId(fieldId);
                    case 1: // O1
            @Override
                case O1:
        public void setO1IsSet(boolean value) {
                oprot.writeFieldEnd();
                    org.apache.thrift.TFieldRequirementType.DEFAULT,
                                } else {
                struct.validate();
                        struct.filter = iprot.readString();
                }
            @Override
                    return lastComparison;
                read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
                    oprot.writeString(struct.tbl_name);
            if (lastComparison != 0) {
                return false;
            lastComparison = java.lang.Boolean.compare(isSetTbl_name(), other.isSetTbl_name());
            @Override
            short max_parts
                }
                    @Override
            }
            boolean this_present_o1 = true && this.isSetO1();
        }
        }
                        }
             * Find the _Fields constant that matches fieldId, or null if its not found.
            }
            Cloneable,
            private final java.lang.String _fieldName;
                            _LOGGER.error("TTransportException inside handler", e);
                args.setTbl_name(tbl_name);
        @Override
        private static final org.apache.thrift.protocol.TField O1_FIELD_DESC = new org.apache.thrift.protocol.TField(
            first = false;
        public MetaException getO2() {
                : TUPLE_SCHEME_FACTORY).getScheme();
            public Factory(
            }
            return this.tbl_name;
        /** Returns true if field o2 is set (has been assigned a value) and false otherwise */
                return lastComparison;
                return new get_partitions_argsStandardScheme();
             */
    public static class create_database_args
        @Override
                tbl_name,
                }
            "filter",
            private final short _thriftId;
                    org.apache.thrift.TFieldRequirementType.DEFAULT,
            if (field == null) {
                    }
        public boolean isSetO2() {
                    struct.tbl.write(oprot);
        }
            lastComparison = java.lang.Boolean.compare(isSetO2(), other.isSetO2());
        }
            scheme(oprot).write(oprot, this);
                case DB_NAME:
                }
                    struct.o2.write(oprot);
            lastComparison = java.lang.Boolean.compare(isSetSuccess(), other.isSetSuccess());
        @org.apache.thrift.annotation.Nullable
            }
                    java.util.BitSet incoming = iprot.readBitSet(1);
            if (isSetO1()) hashCode = hashCode * 8191 + o1.hashCode();
                sb.append(this.o1);
            if (this_present_max_parts || that_present_max_parts) {
        public @org.apache.thrift.annotation.Nullable MetaException o2; // required
                throw result.o2;
                    struct.req.write(oprot);
                new org.apache.thrift.meta_data.FieldMetaData(
                write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
                                }
        @Override
            }
             */
        static {
                _Fields.REQ,
            this.o1 = o1;
                case SUCCESS:
            _Fields(short thriftId, java.lang.String fieldName) {
                        }
                _Fields,
                )
             * Find the _Fields constant that matches name, or null if its not found.
            lastComparison = java.lang.Boolean.compare(isSetO1(), other.isSetO1());
            return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme())
            try {
                        oprot.writeI32(struct.success.size());
                        setO2((AlreadyExistsException) value);
                    break;
                oprot.writeFieldStop();
                new org.apache.thrift.meta_data.FieldMetaData(
                case O2:
                iprot.incrementRecursionDepth();
                            fb.close();
                    return isSetFilter();
                    oprot.writeFieldBegin(NEW_PART_FIELD_DESC);
        public int hashCode() {
            // check for sub-struct validity
                return byName.get(name);
            }
        public InvalidObjectException getO2() {
            }
                this.success = __this__success;
            public java.lang.String getFieldName() {
                        );
    }
            }
                this.o2 = null;
            @Override
                sb.append(this.tbl_name);
            if (!first) sb.append(", ");
                org.apache.thrift.async.TAsyncClient client,
        public void validate() throws org.apache.thrift.TException {
                                    struct.success.read(iprot);
                                org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
                if (getState() != org.apache.thrift.async.TAsyncMethodCall.State.RESPONSE_READ) {
            throw new java.lang.IllegalStateException();
            super(
                            msgType = org.apache.thrift.protocol.TMessageType.EXCEPTION;
                org.apache.thrift.protocol.TProtocolFactory protocolFactory,
                if (struct.isSetO2()) {
        public void add_partition(Partition new_part, org.apache.thrift.async.AsyncMethodCallback<Partition> resultHandler)
            try {
        }
                oprot.writeFieldStop();
        public void validate() throws org.apache.thrift.TException {
        /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
            Void,
                case O1:
                    public void onError(java.lang.Exception e) {
        public enum _Fields implements org.apache.thrift.TFieldIdEnum {
        @Override
        public boolean isSet(_Fields field) {
                create_table_result result = getEmptyResultInstance();
        }
            }
                java.lang.String db_name,
                        byte msgType = org.apache.thrift.protocol.TMessageType.REPLY;
                new org.apache.thrift.meta_data.FieldMetaData(
                org.apache.thrift.protocol.TProtocolFactory protocolFactory
            if (isSetSuccess()) {
            }
            private final java.lang.String _fieldName;
            get_partitions_by_filter_args args = new get_partitions_by_filter_args();
                    return lastComparison;
            }
                    return isSetO1();
            } else {
                lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.tbl_name, other.tbl_name);
                }
                }
            }
        }
        @Override
            if (!first) sb.append(", ");
        public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
        @org.apache.thrift.annotation.Nullable
                "get_partitions failed: unknown result"
            if (this_present_o1 || that_present_o1) {
            sb.append("max_parts:");
        public get_partitions_result setO1(@org.apache.thrift.annotation.Nullable NoSuchObjectException o1) {
                return new get_partitions_argsTupleScheme();
            if (!first) sb.append(", ");
                return byName.get(name);
        public _Fields fieldForId(int fieldId) {
            public void write_args(org.apache.thrift.protocol.TProtocol prot) throws org.apache.thrift.TException {
            if (this.o2 == null) {
        /** Returns true if field o1 is set (has been assigned a value) and false otherwise */
        @Override
        public void create_database(Database database) throws AlreadyExistsException, InvalidObjectException, MetaException,
                    struct.o1.write(oprot);
        }
                    byName.put(field.getFieldName(), field);
        private static class create_database_argsStandardScheme extends org.apache.thrift.scheme.StandardScheme<create_database_args> {
                        setSuccess((java.util.List<Partition>) value);
                return new create_database_result();
                return result.success;
        public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
        }
                this.o2 = new NoSuchObjectException(other.o2);
                if (struct.tbl_name != null) {
            sb.append(")");
            hashCode = hashCode * 8191 + ((isSetO1()) ? 131071 : 524287);
            }
        );
            }
        @Override
        public @org.apache.thrift.annotation.Nullable AlreadyExistsException o1; // required
            return this;
        }
        public static class create_database<I extends Iface> extends org.apache.thrift.ProcessFunction<
        public java.lang.String getDb_name() {
            }
                    while (true) {
                        org.apache.thrift.ProcessFunction<I, ? extends org.apache.thrift.TBase, ? extends org.apache.thrift.TBase>>()
            }
            java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<
                        return O1;
                iprot.incrementRecursionDepth();
            }
                                    struct.database = new Database();
            private final short _thriftId;
            public static _Fields findByName(java.lang.String name) {
                org.apache.thrift.TException {
                                    struct.o1.read(iprot);
                try {
            processMap.put("get_table_req", new get_table_req());
                _fieldName = fieldName;
            }
            if (lastComparison != 0) {
            boolean that_present_db_name = true && that.isSetDb_name();
        public void setFieldValue(_Fields field, @org.apache.thrift.annotation.Nullable java.lang.Object value) {
                    if (value == null) {
            metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
            first = false;
                return lastComparison;
            return this;
                    return getFilter();
            try {
                if (!this.o2.equals(that.o2)) return false;
        public add_partition_result deepCopy() {
            public java.lang.String getFieldName() {
                throw result.o3;
                                    org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        }
            /**
            public get_table_req_result getEmptyResultInstance() {
            }
            } else {
                        unsetDb_name();
                    @Override
                        struct.setO2IsSet(true);
        }
            }
                        setO1((NoSuchObjectException) value);
            create_database_result> {
            public get_table_req_result getEmptyResultInstance() {
                        }
                    iprot.readStructBegin();
                lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.tbl_name, other.tbl_name);
                            _LOGGER.error("TTransportException inside handler", e);
                args.setNew_part(new_part);
            @Override
                sb.append(this.new_part);
            switch (field) {
        /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
                                }
        public int hashCode() {
            this.o1 = o1;
                    prot.decrementRecursionDepth();
            hashCode = hashCode * 8191 + ((isSetSuccess()) ? 131071 : 524287);
             * Find the _Fields constant that matches fieldId, throwing an exception
                    }
                _thriftId = thriftId;
        public static class create_table<I extends Iface> extends org.apache.thrift.ProcessFunction<
        }
        private static class create_table_argsStandardScheme extends org.apache.thrift.scheme.StandardScheme<create_table_args> {
            if (field == null) {
                }
        private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY = new add_partition_argsStandardSchemeFactory();
            return this.o1 != null;
            if (that instanceof get_partitions_args) return this.equals((get_partitions_args) that);
        }
        @Override
            this.max_parts = max_parts;
            throws org.apache.thrift.TException {
        }
            return (this.success == null) ? 0 : this.success.size();
                    default:
            this.o3 = null;
                case O1:
                    return getO1();
                    }
            public get_partitions() {
                    break;
                org.apache.thrift.protocol.TProtocol prot = client.getProtocolFactory().getProtocol(memoryTransport);
            org.apache.thrift.TException {
                                }
                sb.append("null");
                return new Client(prot);
                            case 2: // O2
                            result.o1 = (MetaException) e;
            if (this.o2 == null) {
            public get_partitions_result getEmptyResultInstance() {
                    return getDb_name();
                        } else if (e instanceof NoSuchObjectException) {
            }
        public get_partitions_result(get_partitions_result other) {
            @Override
                        struct.tbl_name = iprot.readString();
            @Override
                    break;
            _Fields(short thriftId, java.lang.String fieldName) {
            switch (field) {
                this.o2 = null;
                if (lastComparison != 0) {
                            ?,
            public void write(org.apache.thrift.protocol.TProtocol oprot, get_partitions_by_filter_args struct)
            private static final java.util.Map<java.lang.String, _Fields> byName = new java.util.HashMap<java.lang.String, _Fields>();
        public void send_get_table_req(GetTableRequest req) throws org.apache.thrift.TException {
                    org.apache.thrift.TFieldRequirementType.DEFAULT,
                    oprot.writeFieldBegin(O2_FIELD_DESC);
                iface.create_table(args.tbl, resultHandler);
             * Find the _Fields constant that matches fieldId, or null if its not found.
            public void write(org.apache.thrift.protocol.TProtocol prot, get_partitions_result struct) throws org.apache.thrift.TException {
        public void unsetO2() {
                for (Partition other_element : other.success) {
            }
                                    org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            if (this_present_o2 || that_present_o2) {
        }
            if (!value) {
                            msg = result;
            @Override
                case TBL:
            public static _Fields findByThriftId(int fieldId) {
            boolean this_present_o1 = true && this.isSetO1();
                return getClass().getName().compareTo(other.getClass().getName());
        public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
                if (struct.isSetO2()) {
            @Override
            I,
                lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.o1, other.o1);
                        }
                try {
                iprot.incrementRecursionDepth();
                    iprot.decrementRecursionDepth();
                                org.apache.thrift.TApplicationException.INTERNAL_ERROR,
        }
            } catch (org.apache.thrift.TException te) {
            try {
                    org.apache.thrift.ProcessFunction<I, ? extends org.apache.thrift.TBase, ? extends org.apache.thrift.TBase>> processMap
            if (lastComparison != 0) {
                    // check for required fields of primitive type, which can't be checked in the validate method
                            _LOGGER.error("Exception writing to internal frame buffer", ex);
            }
            }
                    org.apache.thrift.TFieldRequirementType.DEFAULT,
                    oprot.writeFieldEnd();
                    oprot.writeFieldEnd();
            sb.append("o1:");
            static {
                                } else {
        public void setO2IsSet(boolean value) {
            boolean this_present_tbl = true && this.isSetTbl();
                    if (value == null) {
                    if (value == null) {
            @Override
            if (isSetO1()) hashCode = hashCode * 8191 + o1.hashCode();
            }
            return 0;
        @Override
        public void clear() {
                            default:
            if (success != null) {
            }
                            msg = new org.apache.thrift.TApplicationException(
             */
        public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
        @Override
                };
            } else {
            }
                return lastComparison;
                )
    public static class AsyncClient extends org.apache.thrift.async.TAsyncClient implements AsyncIface {
            if (isSetO2()) {
                _fieldName = fieldName;
                switch (fieldId) {
            if (lastComparison != 0) {
            if (other.isSetO1()) {
                        struct.setO3IsSet(true);
                return lastComparison;
                                }
        private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, java.lang.ClassNotFoundException {
            return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __MAX_PARTS_ISSET_ID);
        );
        @Override
        /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
            }
        public boolean isSet(_Fields field) {
                                break;
                )
                throws org.apache.thrift.TException {
                write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
            }
                database.validate();
            java.lang.StringBuilder sb = new java.lang.StringBuilder("get_partitions_result(");
                lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.db_name, other.db_name);
            java.lang.String db_name,
                        if (e instanceof AlreadyExistsException) {
                return getClass().getName().compareTo(other.getClass().getName());
            public get_table_req_resultStandardScheme getScheme() {
                sb.append("null");
            protected boolean rethrowUnhandledExceptions() {
                    throw new java.lang.IllegalStateException("Method call not finished!");
            _Fields(short thriftId, java.lang.String fieldName) {
                _Fields.TBL_NAME,
            if (that instanceof get_partitions_by_filter_result) return this.equals((get_partitions_by_filter_result) that);
                oprot.writeStructEnd();
                    }
                    org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
            SUCCESS((short) 0, "success"),
                            _LOGGER.error("Exception inside handler", e);
        @org.apache.thrift.annotation.Nullable
        }
                    oprot.writeString(struct.db_name);
            @Override
                if (!this.tbl.equals(that.tbl)) return false;
            this.success = success;
            short max_parts
        }
                success.validate();
            public add_partition() {
        }
                if (getState() != org.apache.thrift.async.TAsyncMethodCall.State.RESPONSE_READ) {
            tmpMap.put(
            /**
                    optionals.set(0);
                for (_Fields field : java.util.EnumSet.allOf(_Fields.class)) {
                    byName.put(field.getFieldName(), field);
        public Database getDatabase() {
                _Fields fields = findByThriftId(fieldId);
            } catch (org.apache.thrift.TException te) {
            }
                args.write(prot);
                        add_partition_result result = new add_partition_result();
            return _Fields.findByThriftId(fieldId);
        public boolean isSet(_Fields field) {
                new org.apache.thrift.meta_data.FieldMetaData(
                        unsetO2();
                    optionals.set(3);
                    break;
        public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
                                    struct.setFilterIsSet(true);
                oprot.writeStructBegin(STRUCT_DESC);
                switch (fieldId) {
            );
            @Override
                            fb.close();
            __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __MAX_PARTS_ISSET_ID, value);
            org.apache.thrift.protocol.TType.STRUCT,
        public get_partitions_args setMax_parts(short max_parts) {
                                } else {
                    return isSetO3();
            throw new java.lang.IllegalStateException();
        }
        }
            }
                    org.apache.thrift.TFieldRequirementType.DEFAULT,
                    return lastComparison;
                        schemeField = iprot.readFieldBegin();
        }
                        }
            );
            Cloneable,
            }
            boolean this_present_db_name = true && this.isSetDb_name();
                }
                    }
            }
        /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
            throw new java.lang.IllegalStateException();
                                } else {
            public void read(org.apache.thrift.protocol.TProtocol iprot, get_table_req_args struct) throws org.apache.thrift.TException {
                            _iter163.write(oprot);
                final org.apache.thrift.server.AbstractNonblockingServer.AsyncFrameBuffer fb,
            args.setTbl(tbl);
            }
            boolean first = true;
                oprot.writeBitSet(optionals, 3);
                throw result.o2;
            }
            super(
                final org.apache.thrift.AsyncProcessFunction fcall = this;
            if (that == null) return false;
            public void write(org.apache.thrift.protocol.TProtocol oprot, get_table_req_args struct) throws org.apache.thrift.TException {
                switch (fieldId) {
                return getClass().getName().compareTo(other.getClass().getName());
            if (!value) {
                                if (schemeField.type == org.apache.thrift.protocol.TType.I16) {
            }
        @org.apache.thrift.annotation.Nullable
        public NoSuchObjectException getO2() {
            "tbl_name",
                    @Override
            private final java.lang.String _fieldName;
                            onError(e);
                    if (value == null) {
                if (struct.success != null) {
                    return lastComparison;
        @org.apache.thrift.annotation.Nullable
            org.apache.thrift.protocol.TType.STRUCT,
        @Override
        }
            }
                final int seqid
                    "o1",
        @org.apache.thrift.annotation.Nullable
            public void write(org.apache.thrift.protocol.TProtocol prot, create_database_args struct) throws org.apache.thrift.TException {
        @org.apache.thrift.annotation.Nullable
            if (this == that) return true;
    public static class create_database_result
            throw new java.lang.IllegalStateException();
        @Override
    @SuppressWarnings({ "cast", "rawtypes", "serial", "unchecked", "unused" })
                        new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, Partition.class)
                return new get_partitions_by_filter_args();
            return this.o4 != null;
                case O3:
        }
            if (result.o2 != null) {
                    oprot.writeFieldBegin(O1_FIELD_DESC);
            }
                }
                try {
                                if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {
        public Partition add_partition(Partition new_part) throws InvalidObjectException, AlreadyExistsException, MetaException,
                    break;
                    if (incoming.get(0)) {
                lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.o2, other.o2);
                if (struct.isSetReq()) {
            @Override
            org.apache.thrift.TBase<get_partitions_result, get_partitions_result._Fields>,
                if (struct.o1 != null) {
            @Override
            }
         * Performs a deep copy on <i>other</i>.
                if (getState() != org.apache.thrift.async.TAsyncMethodCall.State.RESPONSE_READ) {
            }
            hashCode = hashCode * 8191 + ((isSetO3()) ? 131071 : 524287);
                oprot.writeBitSet(optionals, 1);
            }
            switch (field) {
            }
                _Fields.O2,
        }
                                    struct.db_name = iprot.readString();
        protected AsyncProcessor(
                            return;
                return new get_table_req_resultStandardScheme();
            processMap.put("create_database", new create_database());
            return this.req;
                }
                    if (incoming.get(0)) {
            } else {
            if (result.o2 != null) {
            @org.apache.thrift.annotation.Nullable
                prot.incrementRecursionDepth();
            }
                return _fieldName;
            }
            new get_partitions_by_filter_argsStandardSchemeFactory();
            scheme(oprot).write(oprot, this);
                    "success",
            }
            if (this.new_part == null) {
            java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<
                if (struct.isSetO1()) {
                max_parts,
                                } else {
            this.o4 = null;
            if (other.isSetDb_name()) {
            scheme(iprot).read(iprot, this);
            @Override
        public static class get_partitions_by_filter<I extends AsyncIface> extends org.apache.thrift.AsyncProcessFunction<
                    // check for required fields of primitive type, which can't be checked in the validate method
            public void write(org.apache.thrift.protocol.TProtocol oprot, create_table_result struct) throws org.apache.thrift.TException {
            );
                if (!(this_present_success && that_present_success)) return false;
            scheme(iprot).read(iprot, this);
                            Partition _elem166;
                                    struct.o1 = new InvalidObjectException();
        @Override
        }
                    return lastComparison;
                    struct.new_part.write(oprot);
            lastComparison = java.lang.Boolean.compare(isSetMax_parts(), other.isSetMax_parts());
        public void unsetSuccess() {
        public void clear() {
                _Fields fields = findByThriftId(fieldId);
             */
                    org.apache.thrift.TFieldRequirementType.DEFAULT,
                                }
    }
            "create_database_result"
            switch (field) {
            } else {
                    oprot.writeFieldBegin(O2_FIELD_DESC);
                    ? extends org.apache.thrift.TBase>> processMap
            if (result.o1 != null) {
        public @org.apache.thrift.annotation.Nullable AlreadyExistsException o1; // required
            _Fields(short thriftId, java.lang.String fieldName) {
                    return isSetO2();
                oprot.writeBitSet(optionals, 3);
                    if (incoming.get(1)) {
            if (!first) sb.append(", ");
            if (that instanceof get_table_req_args) return this.equals((get_table_req_args) that);
            public static _Fields findByName(java.lang.String name) {
                        return O1;
                        }
                            result.setO1IsSet(true);
            }
            boolean that_present_o1 = true && that.isSetO1();
            if (!getClass().equals(other.getClass())) {
            // check for sub-struct validity
            sb.append("o2:");
            this.o2 = null;
                    @Override
                return new create_database_args();
                } finally {
                            }
                sb.append(this.tbl);
            if (that instanceof get_partitions_by_filter_args) return this.equals((get_partitions_by_filter_args) that);
            if (this.success == null) {
                    }
            @Override
            /**
                    result.success = iface.add_partition(args.new_part);
                        create_database_result result = new create_database_result();
            this.max_parts = max_parts;
            if (this.success == null) {
                )
            tmpMap.put(
            public void write(org.apache.thrift.protocol.TProtocol prot, get_table_req_result struct) throws org.apache.thrift.TException {
            I extends Iface>
                _Fields.TBL,
            I,
                "get_partitions_by_filter failed: unknown result"
                try {
            get_table_req_result> {
        }
                if (lastComparison != 0) {
            }
                org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
        }
        public java.lang.Object getFieldValue(_Fields field) {
        }
            if (isSetFilter()) {
                )
                };
                    if (incoming.get(2)) {
            @Override
            boolean this_present_success = true && this.isSetSuccess();
                            return;
        }
        @Override
                if (!this.o1.equals(that.o1)) return false;
            ) {
                sb.append("null");
        }
            @Override
                _Fields.O2,
        private static final org.apache.thrift.protocol.TField O1_FIELD_DESC = new org.apache.thrift.protocol.TField(
        }
            this.db_name = null;
                return new create_table_argsStandardScheme();
            }
                this.clientManager = clientManager;
                        unsetTbl_name();
        /**
            }
                ___protocolFactory,
                if (struct.filter != null) {
        }
                new org.apache.thrift.meta_data.FieldMetaData(
                this.o1 = null;
                    case 4: // MAX_PARTS
            return this.o1 != null;
        }
        public java.lang.String toString() {
            if (this_present_o1 || that_present_o1) {
                }
            args.setFilter(filter);
                        result.success = o;
            if (this_present_filter || that_present_filter) {
                if (!this.success.equals(that.success)) return false;
        static {
            FILTER((short) 3, "filter"),
            throw new org.apache.thrift.TApplicationException(
                org.apache.thrift.TApplicationException.MISSING_RESULT,
                    oprot.writeFieldEnd();
            hashCode = hashCode * 8191 + max_parts;
            sb.append("o2:");
                }
            }
        private static final org.apache.thrift.protocol.TField SUCCESS_FIELD_DESC = new org.apache.thrift.protocol.TField(
                    result.o2 = o2;
                        } else if (e instanceof org.apache.thrift.TApplicationException) {
                }
            switch (field) {
            new get_partitions_by_filter_resultTupleSchemeFactory();
            return _Fields.findByThriftId(fieldId);
                    optionals.set(2);
                            msg = (org.apache.thrift.TApplicationException) e;
        @org.apache.thrift.annotation.Nullable
            /**
            @Override
            short max_parts
                org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
            this.max_parts = other.max_parts;
        public create_database_result setO1(@org.apache.thrift.annotation.Nullable AlreadyExistsException o1) {
        @Override
        public @org.apache.thrift.annotation.Nullable InvalidObjectException o2; // required
                    break;
        }
            public get_table_req_argsTupleScheme getScheme() {
                                    org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        public boolean isSetSuccess() {
            "get_partitions_result"
            /**
                case O2:
        /** Returns true if field db_name is set (has been assigned a value) and false otherwise */
                case SUCCESS:
                                    struct.o3.read(iprot);
        }
            int hashCode = 1;
            }
                        struct.setO4IsSet(true);
            switch (field) {
                    case 1: // O1
            /**
            checkReady();
        @Override
            }
            O2((short) 2, "o2");
                                }
                if (getState() != org.apache.thrift.async.TAsyncMethodCall.State.RESPONSE_READ) {
            lastComparison = java.lang.Boolean.compare(isSetO2(), other.isSetO2());
                }
                    return getO3();
            sb.append(")");
            }
                    }
                final org.apache.thrift.server.AbstractNonblockingServer.AsyncFrameBuffer fb,
            send_create_table(tbl);
            }
                if (struct.isSetFilter()) {
            public void read(org.apache.thrift.protocol.TProtocol iprot, get_partitions_result struct) throws org.apache.thrift.TException {
                    return getO1();
                                if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {
        );
                throw new java.lang.IllegalArgumentException();
                sb.append("null");
        public create_table_args(create_table_args other) {
                if (!(this_present_new_part && that_present_new_part)) return false;
                                    org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            public static _Fields findByName(java.lang.String name) {
                }
                            result.setO3IsSet(true);
            public void start(I iface, create_table_args args, org.apache.thrift.async.AsyncMethodCallback<Void> resultHandler)
                                    struct.o1.read(iprot);
            tmpMap.put(
                                } else {
                iprot.incrementRecursionDepth();
            public java.lang.String getFieldName() {
                        try {
                lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.o2, other.o2);
            this.___currentMethod = method_call;
            return false;
                switch (fieldId) {
                sb.append(this.o2);
                                    struct.setTbl_nameIsSet(true);
        public static class Factory implements org.apache.thrift.async.TAsyncClientFactory<AsyncClient> {
            );
                            break;
            "max_parts",
            if (database != null) {
                }
                return (new Client(prot)).recv_get_partitions_by_filter();
                : TUPLE_SCHEME_FACTORY).getScheme();
                throw result.o1;
        }
            ) {
        private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new create_table_resultTupleSchemeFactory();
            switch (field) {
                            case 2: // O2
        @Override
            }
                    return getO3();
            @Override
                    }
            scheme(oprot).write(oprot, this);
                    break;
            (short) 1
            java.lang.String filter,
            return true;
            get_partitions_result> {
                    iprot.readStructEnd();
                        return null;
            public get_partitions_by_filter_resultTupleScheme getScheme() {
            add_partition_result> {
                return getClass().getName().compareTo(other.getClass().getName());
                    }
            java.lang.String tbl_name,
                )
        public get_table_req_result(get_table_req_result other) {
            }
            public void write(org.apache.thrift.protocol.TProtocol prot, get_partitions_by_filter_result struct)
                try {
            public Client getClient(org.apache.thrift.protocol.TProtocol iprot, org.apache.thrift.protocol.TProtocol oprot) {
        // isset id assignments
        @Override
            "o3",
        @Override
                if (lastComparison != 0) {
        public AsyncProcessor(I iface) {
        }
                oprot.writeFieldEnd();
                        return NEW_PART;
            /**
                if (fields == null) throw new java.lang.IllegalArgumentException("Field " + fieldId + " doesn't exist!");
                            result.setO1IsSet(true);
                return _thriftId;
        @Override
                                    struct.tbl.read(iprot);
            sb.append("o1:");
                    "req",
            create_table_args args = new create_table_args();
        public void clear() {
                            break;
                org.apache.thrift.transport.TNonblockingTransport transport
                    org.apache.thrift.TFieldRequirementType.DEFAULT,
                case O1:
            );
            org.apache.thrift.TBase<create_table_args, create_table_args._Fields>,
                } catch (NoSuchObjectException o2) {
            private final java.lang.String _fieldName;
        public GetTableResult get_table_req(GetTableRequest req) throws MetaException, NoSuchObjectException, org.apache.thrift.TException {
            sendBase("create_database", args);
        private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
                        } else if (e instanceof org.apache.thrift.TApplicationException) {
        public NoSuchObjectException getO1() {
                        struct.o2.read(iprot);
            }
            tmpMap.put(
            tmpMap.put(
        @Override
                }
            }
            }
            switch (field) {
            return _Fields.findByThriftId(fieldId);
            } else {
            } catch (org.apache.thrift.TException te) {
            int lastComparison = 0;
        }
            return _Fields.findByThriftId(fieldId);
        public @org.apache.thrift.annotation.Nullable NoSuchObjectException o1; // required
                            default:
            switch (field) {
                    }
            boolean that_present_tbl = true && that.isSetTbl();
            @Override
                            fcall.sendResponse(fb, result, org.apache.thrift.protocol.TMessageType.REPLY, seqid);
        ) throws org.apache.thrift.TException {
                _Fields.SUCCESS,
        }
                            msg = result;
                return new add_partition_argsStandardScheme();
                    return getO2();
        public boolean isSetTbl() {
                final org.apache.thrift.server.AbstractNonblockingServer.AsyncFrameBuffer fb,
            }
                );
            }
                new org.apache.thrift.meta_data.FieldMetaData(
            return this.tbl_name;
        public @org.apache.thrift.annotation.Nullable GetTableRequest req; // required
                    }
        public @org.apache.thrift.annotation.Nullable Database database; // required
        }
                                }
                    struct.o3.write(oprot);
            public static _Fields findByThriftIdOrThrow(int fieldId) {
                if (struct.isSetTbl_name()) {
        public void create_database(Database database, org.apache.thrift.async.AsyncMethodCallback<Void> resultHandler)
        public AsyncClient(
                    } else {
                _Fields fields = findByThriftId(fieldId);
                    new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, Partition.class)
                if (lastComparison != 0) {
        }
                if (lastComparison != 0) {
                }
                if (!(this_present_o3 && that_present_o3)) return false;
        private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY =
                    struct.o2.write(oprot);
        public void setSuccessIsSet(boolean value) {
                    }
                return new get_table_req_resultTupleScheme();
            static {
        }
        );
        }
        }
                if (lastComparison != 0) {
                    "database",
            return (this.success == null) ? null : this.success.iterator();
            throw new org.apache.thrift.TApplicationException(
            O2((short) 2, "o2"),
                            msg = new org.apache.thrift.TApplicationException(
            "get_table_req_result"
                super("get_table_req");
        }
                ? STANDARD_SCHEME_FACTORY
        @Override
        @Override
                    oprot.writeFieldBegin(O1_FIELD_DESC);
                org.apache.thrift.ProcessFunction<I, ? extends org.apache.thrift.TBase, ? extends org.apache.thrift.TBase>>
                            msg = (org.apache.thrift.TApplicationException) e;
            tmpMap.put(
                                struct.success.add(_elem166);
        }
                    org.apache.thrift.TFieldRequirementType.DEFAULT,
            if (this.o2 == null) {
            return this.database != null;
                    oprot.writeFieldBegin(O3_FIELD_DESC);
            int hashCode = 1;
            DATABASE((short) 1, "database");
                switch (fieldId) {
        public void add_partition(Partition new_part, org.apache.thrift.async.AsyncMethodCallback<Partition> resultHandler)
            /**
        }
        private static class create_table_resultTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
                    }
            }
             */
                ___protocolFactory,
            this.success = null;
                prot.incrementRecursionDepth();
                                        @org.apache.thrift.annotation.Nullable
                            result.o1 = (MetaException) e;
                    struct.success.write(oprot);
                        struct.o2.read(iprot);
            sb.append("success:");
                            for (int _i167 = 0; _i167 < _list165.size; ++_i167) {
            "req",
            new get_partitions_by_filter_argsTupleSchemeFactory();
        }
        ) {
        public void setO2IsSet(boolean value) {
                    }
        public get_table_req_result setO2(@org.apache.thrift.annotation.Nullable NoSuchObjectException o2) {
                return new create_table_args();
                        return SUCCESS;
                    public void onError(java.lang.Exception e) {
            org.apache.thrift.protocol.TType.STRING,
                        struct.db_name = iprot.readString();
            }
            org.apache.thrift.protocol.TType.STRING,
            @Override
            if (this_present_db_name || that_present_db_name) {
        @Override
        @Override
            java.util.List<Partition>,
        /** Returns true if field database is set (has been assigned a value) and false otherwise */
            @Override
                }
                super("add_partition");
        public create_database_result setO2(@org.apache.thrift.annotation.Nullable InvalidObjectException o2) {
            @Override
        private static class create_database_resultStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
        public Partition add_partition(Partition new_part) throws InvalidObjectException, AlreadyExistsException, MetaException,
            java.lang.String db_name,
                struct.validate();
            @Override
                args.write(prot);
        implements
            }
                _fieldName = fieldName;
            if (!value) {
        public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
            try {
                    new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I16)
        @Override
                            default:
                if (struct.isSetDb_name()) {
            sb.append("o1:");
                    if (incoming.get(2)) {
                org.apache.thrift.async.TAsyncClient client,
        public get_partitions_by_filter_args deepCopy() {
            if (isSetO2()) {
        }
        @Override
                    break;
             */
                prot.writeMessageBegin(
                        struct.setO1IsSet(true);
                this.success = new java.util.ArrayList<Partition>();
            }
                    iprot.decrementRecursionDepth();
            @org.apache.thrift.annotation.Nullable
        }
        /** Returns true if field o2 is set (has been assigned a value) and false otherwise */
                        struct.tbl.read(iprot);
        }
                switch (fieldId) {
        public void setFieldValue(_Fields field, @org.apache.thrift.annotation.Nullable java.lang.Object value) {
        private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY = new create_table_argsStandardSchemeFactory();
                throw new java.lang.IllegalArgumentException();
                    new org.apache.thrift.protocol.TMessage("get_partitions", org.apache.thrift.protocol.TMessageType.CALL, 0)
            public boolean isOneway() {
            lastComparison = java.lang.Boolean.compare(isSetTbl(), other.isSetTbl());
                        ? extends org.apache.thrift.TBase,
            public boolean isOneway() {
                        struct.req.read(iprot);
                    new java.util.HashMap<
            if (this_present_o3 || that_present_o3) {
            Comparable<get_partitions_result> {
                if (struct.isSetDb_name()) {
            }
        }
                    new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, AlreadyExistsException.class)
                            }
        public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
            return this.db_name;
        @Override
            switch (field) {
        }
        public void setO3IsSet(boolean value) {
                    }
                throw result.o2;
                return false;
                try {
            Cloneable,
            protected boolean rethrowUnhandledExceptions() {
                        } catch (org.apache.thrift.transport.TTransportException e) {
                                org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
                        iprot.readFieldEnd();
                oprot.writeFieldStop();
                    }
                    )
                    oprot.writeFieldBegin(SUCCESS_FIELD_DESC);
            create_database_call method_call = new create_database_call(database, resultHandler, this, ___protocolFactory, ___transport);
            private final short _thriftId;
                }
            try {
        @Override
                } catch (InvalidObjectException o2) {
                _Fields.SUCCESS,
                case REQ:
                final org.apache.thrift.server.AbstractNonblockingServer.AsyncFrameBuffer fb,
            if (isSetO2()) {
            java.io.Serializable,
        public boolean isSetSuccess() {
        }
            if (isSetO3()) hashCode = hashCode * 8191 + o3.hashCode();
            return _Fields.findByThriftId(fieldId);
            this.tbl = tbl;
                            );
                        setO1((AlreadyExistsException) value);
        public get_table_req_result setSuccess(@org.apache.thrift.annotation.Nullable GetTableResult success) {
        }
        public add_partition_args() {}
                _Fields.O2,
            @Override
                        unsetSuccess();
                    org.apache.thrift.TFieldRequirementType.DEFAULT,
            @Override
                    "o1",
            @Override
                }
                        } else if (e instanceof org.apache.thrift.transport.TTransportException) {
        public get_partitions_args() {}
                            case 3: // MAX_PARTS
                            result.setO3IsSet(true);
            static {
                                    org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        // isset id assignments
                        return DB_NAME;
            throw new java.lang.IllegalStateException();
        private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, java.lang.ClassNotFoundException {
                    @Override
            return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme())
        public boolean equals(get_partitions_by_filter_args that) {
            } catch (org.apache.thrift.TException te) {
        }
                } finally {
        private static class add_partition_argsTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
        public void addToSuccess(Partition elem) {
                        struct.setTbl_nameIsSet(true);
                    default:
            "database",
            }
        @Override
                    }
        implements
            lastComparison = java.lang.Boolean.compare(isSetO2(), other.isSetO2());
        }
        /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
                return lastComparison;
                org.apache.thrift.transport.TMemoryInputTransport memoryTransport = new org.apache.thrift.transport.TMemoryInputTransport(
                struct.validate();
        @Override
                ? STANDARD_SCHEME_FACTORY
            } catch (org.apache.thrift.TException te) {
            }
            }
            (short) 4
                                } else {
                            default:
    public static class get_table_req_result
                        } catch (org.apache.thrift.transport.TTransportException e) {
                    return lastComparison;
                    return lastComparison;
            sb.append(this.max_parts);
            this.success = null;
        }
            first = false;
                    iprot.readStructBegin();
                read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
                                    org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        }
            }
                switch (fieldId) {
        public void setFieldValue(_Fields field, @org.apache.thrift.annotation.Nullable java.lang.Object value) {
                _thriftId = thriftId;
                    optionals.set(0);
            checkReady();
            }
                    org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
            public get_table_req() {
                            _LOGGER.error("TTransportException inside handler", e);
        public Partition recv_add_partition() throws InvalidObjectException, AlreadyExistsException, MetaException,
                return fields;
                    new org.apache.thrift.protocol.TMessage("get_partitions_by_filter", org.apache.thrift.protocol.TMessageType.CALL, 0)
                            fcall.sendResponse(fb, msg, msgType, seqid);
        public void clear() {
                    new org.apache.thrift.meta_data.ListMetaData(
            public get_table_req_call(
            }
    }
                        } else if (e instanceof InvalidObjectException) {
            return this;
                                }
            }
        );
        }
        public boolean isSet(_Fields field) {
                        } else {
        private static final org.apache.thrift.protocol.TField O1_FIELD_DESC = new org.apache.thrift.protocol.TField(
            }
        public MetaException getO3() {
                return _fieldName;
        @Override
        }
                        org.apache.thrift.TSerializable msg;
        );
                        byte msgType = org.apache.thrift.protocol.TMessageType.REPLY;
            );
                sb.append("null");
            }
            }
            public void write(org.apache.thrift.protocol.TProtocol oprot, create_table_args struct) throws org.apache.thrift.TException {
                throw new java.lang.IllegalArgumentException();
                    break;
                        schemeField = iprot.readFieldBegin();
            return this.o2 != null;
                                    struct.max_parts = iprot.readI16();
        }
            scheme(oprot).write(oprot, this);
        }
        @Override
                            fcall.sendResponse(fb, result, org.apache.thrift.protocol.TMessageType.REPLY, seqid);
             */
                                    struct.o2 = new MetaException();
                    org.apache.thrift.TFieldRequirementType.DEFAULT,
                        iprot.readFieldEnd();
            if (!value) {
                        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) {
        public java.lang.String toString() {
            if (result.o1 != null) {
        }
        private static final org.apache.thrift.protocol.TField O2_FIELD_DESC = new org.apache.thrift.protocol.TField(
                } finally {
        public void validate() throws org.apache.thrift.TException {
            scheme(oprot).write(oprot, this);
        }
                        unsetTbl_name();
            if (!getClass().equals(other.getClass())) {
            }
            @Override
                        get_partitions_result result = new get_partitions_result();
            boolean this_present_o1 = true && this.isSetO1();
                if (!(this_present_max_parts && that_present_max_parts)) return false;
        public @org.apache.thrift.annotation.Nullable java.lang.String db_name; // required
            }
        @Override
        public boolean isSetDb_name() {
    @SuppressWarnings({ "cast", "rawtypes", "serial", "unchecked", "unused" })
            if (req != null) {
        private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY =
            _Fields(short thriftId, java.lang.String fieldName) {
                _Fields,
        public java.lang.Object getFieldValue(_Fields field) {
            lastComparison = java.lang.Boolean.compare(isSetO1(), other.isSetO1());
                _fieldName = fieldName;
                if (!(this_present_db_name && that_present_db_name)) return false;
                if (!this.o1.equals(that.o1)) return false;
            }
        public create_database_args setDatabase(@org.apache.thrift.annotation.Nullable Database database) {
                this.new_part = null;
                    if (value == null) {
        }
        public java.lang.String toString() {
            }
                if (!(this_present_o1 && that_present_o1)) return false;
        public get_partitions_by_filter_args setFilter(@org.apache.thrift.annotation.Nullable java.lang.String filter) {
        public java.lang.String toString() {
        public get_partitions_by_filter_args setMax_parts(short max_parts) {
                    new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, Partition.class)
                        } else if (e instanceof MetaException) {
            if (field == null) {
            }
                case FILTER:
                            case 0: // SUCCESS
        public int compareTo(create_database_result other) {
                    }
            }
            }
            new create_table_resultStandardSchemeFactory();
                    struct.new_part.write(oprot);
            } catch (org.apache.thrift.TException te) {
            }
                oprot.writeStructBegin(STRUCT_DESC);
            setMax_partsIsSet(false);
            try {
                    iprot.decrementRecursionDepth();
            sb.append(")");
        public boolean isSetO2() {
                                } else {
            java.lang.String db_name,
            public static _Fields findByThriftId(int fieldId) {
                    if (value == null) {
                if (!this.database.equals(that.database)) return false;
            first = false;
            processMap.put("get_partitions", new get_partitions());
                    @Override
            org.apache.thrift.protocol.TType.STRUCT,
                    oprot.writeFieldBegin(O3_FIELD_DESC);
            }
            org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(add_partition_args.class, metaDataMap);
                    struct.o1.write(oprot);
            this.database = null;
                                if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {
                return byName.get(name);
                case SUCCESS:
                if (struct.isSetDatabase()) {
                )
             */
        }
            }
                if (struct.o2 != null) {
            }
                }
            @Override
                    byName.put(field.getFieldName(), field);
                        setTbl((Table) value);
                new org.apache.thrift.meta_data.FieldMetaData(
                org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
                    while (true) {
        }
                    struct.o1.write(oprot);
        private static class create_database_resultTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
                try {
                    optionals.set(1);
        }
                    }
                    } else {
            if (other.isSetO1()) {
        public @org.apache.thrift.annotation.Nullable GetTableResult success; // required
            }
                return new get_table_req_args();
            public java.lang.String getFieldName() {
                if (lastComparison != 0) {
            @Override
        /**
            O3((short) 3, "o3"),
        public int hashCode() {
                    default:
        public enum _Fields implements org.apache.thrift.TFieldIdEnum {
                        {
                throws org.apache.thrift.TException {
            this.o2 = o2;
            sb.append(")");
            this.success.add(elem);
        );
                prot.writeMessageEnd();
                        return TBL_NAME;
            create_database_args args = new create_database_args();
        }
        public get_partitions_args deepCopy() {
                }
            }
                        }
            tmpMap.put(
             */
            this();
            return this;
            ) {
        }
                    if (value == null) {
                                    struct.tbl_name = iprot.readString();
                    break;
            );
                    oprot.writeString(struct.tbl_name);
            return this.success;
                    org.apache.thrift.TFieldRequirementType.DEFAULT,
                        unsetO3();
                                if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
                            );
                return lastComparison;
            get_partitions_by_filter_result> {
                try {
                try {
                }
            if (result.isSetSuccess()) {
                    result.success = iface.get_partitions(args.db_name, args.tbl_name, args.max_parts);
                            _iter164.write(oprot);
                org.apache.thrift.async.AsyncMethodCallback<java.util.List<Partition>> resultHandler,
                new org.apache.thrift.meta_data.FieldMetaData(
                return getClass().getName().compareTo(other.getClass().getName());
                    if (incoming.get(2)) {
                return _thriftId;
            ___manager.call(method_call);
        public java.util.List<Partition> get_partitions_by_filter(
                    oprot.writeFieldBegin(DB_NAME_FIELD_DESC);
                try {
            }
        public create_database_result deepCopy() {
            public void write(org.apache.thrift.protocol.TProtocol prot, create_database_result struct)
            if (lastComparison != 0) {
                            msgType = org.apache.thrift.protocol.TMessageType.EXCEPTION;
                    struct.o1.write(oprot);
            }
                    }
                if (struct.isSetO3()) {
                for (_Fields field : java.util.EnumSet.allOf(_Fields.class)) {
                    if (value == null) {
                        unsetNew_part();
            O1((short) 1, "o1"),
            java.lang.String db_name,
            if (other.isSetO3()) {
        @Override
            }
                sb.append(this.o2);
                new org.apache.thrift.meta_data.FieldMetaData(
            @Override
                    return lastComparison;
                    }
                if (!(this_present_tbl && that_present_tbl)) return false;
                org.apache.thrift.AsyncProcessFunction<I, ? extends org.apache.thrift.TBase, ?, ? extends org.apache.thrift.TBase>>
        public get_partitions_by_filter_args() {}
            } catch (org.apache.thrift.TException te) {
            public Void getResult() throws AlreadyExistsException, InvalidObjectException, MetaException, org.apache.thrift.TException {
        private static class create_database_resultTupleScheme extends org.apache.thrift.scheme.TupleScheme<create_database_result> {
                    default:
                    return getReq();
            private static final java.util.Map<java.lang.String, _Fields> byName = new java.util.HashMap<java.lang.String, _Fields>();
            protected boolean rethrowUnhandledExceptions() {
    public interface AsyncIface {
                    } else {
        @org.apache.thrift.annotation.Nullable
            }
                            fb.close();
                    oprot.writeFieldBegin(O2_FIELD_DESC);
                this.o3 = null;
                "add_partition failed: unknown result"
        implements
            @Override
            get_partitions_args,
                    getFrameBuffer().array()
                    iprot.readStructBegin();
                                } else {
        private static final org.apache.thrift.protocol.TField TBL_NAME_FIELD_DESC = new org.apache.thrift.protocol.TField(
                                        }
            if (isSetTbl()) hashCode = hashCode * 8191 + tbl.hashCode();
            }
            SUCCESS((short) 0, "success"),
                org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
        static {
            sb.append(")");
            boolean that_present_tbl_name = true && that.isSetTbl_name();
                if (!this.tbl_name.equals(that.tbl_name)) return false;
        public create_table_result() {}
                this.database = new Database(other.database);
            }
                    result.o2 = o2;
                                } else {
        @org.apache.thrift.annotation.Nullable
            public get_table_req_argsStandardScheme getScheme() {
                    oprot.writeFieldBegin(SUCCESS_FIELD_DESC);
        public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
            );
                }
                    {
        public get_partitions_by_filter_result setSuccess(@org.apache.thrift.annotation.Nullable java.util.List<Partition> success) {
                    "o2",
                case MAX_PARTS:
                        }
            if (result.o2 != null) {
        }
                if (!this.o2.equals(that.o2)) return false;
        public int hashCode() {
                case REQ:
        @Override
                }
                super("get_partitions");
                try {
                        struct.o2.read(iprot);
            static {
            "tbl_name",
        @Override
                                    {
        @Override
            boolean first = true;
                if (fields == null) throw new java.lang.IllegalArgumentException("Field " + fieldId + " doesn't exist!");
            @Override
            }
                java.lang.String,
                                break;
                                    struct.o3.read(iprot);
                                    struct.o1.read(iprot);
             * Find the _Fields constant that matches fieldId, or null if its not found.
                    iprot.readStructEnd();
                        create_database_result result = new create_database_result();
        }
            }
                case O2:
            public static _Fields findByName(java.lang.String name) {
        public create_database_args() {}
        private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
                                break;
        public short getMax_parts() {
                        setO1((MetaException) value);
                    if (value == null) {
                if (struct.isSetO3()) {
            this.db_name = db_name;
            first = false;
                return lastComparison;
                        create_table_result result = new create_table_result();
            }
                    iprot.readStructEnd();
                                struct.success.add(_elem158);
        }
            first = false;
                        switch (schemeField.id) {
                }
            int hashCode = 1;
            org.apache.thrift.TException {
            this.o2 = o2;
         */
                args.setDb_name(db_name);
                            result.setO1IsSet(true);
                this.o3 = new MetaException(other.o3);
                return _thriftId;
        public boolean isSetO1() {
                        oprot.writeListBegin(
                    return lastComparison;
            return hashCode;
            public create_table_call(
            }
                case SUCCESS:
            @Override
        }
                    case 1: // DB_NAME
        }
        public Partition getNew_part() {
                        return DATABASE;
                if (struct.isSetO1()) {
            boolean this_present_filter = true && this.isSetFilter();
        private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct(
            }
        );
            NEW_PART((short) 1, "new_part");
            if (!value) {
                super(client, protocolFactory, transport, resultHandler, false);
                                } else {
                    break;
                sb.append(this.success);
            return 0;
                    oprot.writeFieldBegin(O4_FIELD_DESC);
                            msg = result;
            }
            private short max_parts;
                if (struct.isSetO2()) {
            }
            first = false;
                        }
            (short) 0
                org.apache.thrift.transport.TNonblockingTransport transport
                            case 1: // O1
                        struct.setO1IsSet(true);
                    while (true) {
                                }
            @Override
            receiveBase(result, "create_database");
            }
                } finally {
            static {
                        oprot.writeI32(struct.success.size());
         * Performs a deep copy on <i>other</i>.
                    struct.success.write(oprot);
                if (struct.isSetO2()) {
            }
                }
                add_partition_result result = getEmptyResultInstance();
            @org.apache.thrift.annotation.Nullable
                sb.append("null");
            public java.lang.String getFieldName() {
            int lastComparison = 0;
        @Override
            private static final java.util.Map<java.lang.String, _Fields> byName = new java.util.HashMap<java.lang.String, _Fields>();
            }
            if (!first) sb.append(", ");
                        return FILTER;
            }
            return hashCode;
                    "db_name",
            if (this == that) return true;
                            fb.close();
                throws org.apache.thrift.TException {
                                }
                        } else if (e instanceof org.apache.thrift.transport.TTransportException) {
                                break;
            return this;
        public void unsetSuccess() {
                    case 2: // O2
            return this.o3;
            metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
                )
                    result.o1 = o1;
            return 0;
            I iface,
                )
                    case 3: // MAX_PARTS
            if (!first) sb.append(", ");
            if (isSetO2()) {
            this.o1 = null;
            }
        private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY =
            if (!first) sb.append(", ");
            return this.tbl_name != null;
        public void setTbl_nameIsSet(boolean value) {
                getProcessMap(
        public @org.apache.thrift.annotation.Nullable MetaException o1; // required
        /** Returns true if field o1 is set (has been assigned a value) and false otherwise */
            }
            if (!getClass().equals(other.getClass())) {
            );
                } finally {
            org.apache.thrift.protocol.TType.STRUCT,
        public java.lang.Object getFieldValue(_Fields field) {
                                    struct.success.read(iprot);
        }
                if (struct.o4 != null) {
                struct.validate();
                    oprot.writeFieldEnd();
                java.util.List<Partition> __this__success = new java.util.ArrayList<Partition>(other.success.size());
        }
                return new add_partition_result();
                    if (incoming.get(0)) {
                )
            this.o2 = o2;
                        } catch (org.apache.thrift.transport.TTransportException e) {
             * if it is not found.
        }
        public boolean isSetO3() {
            public boolean isOneway() {
            return _Fields.findByThriftId(fieldId);
            if (this_present_o3 || that_present_o3) {
            }
                args.setReq(req);
                            );
                return new get_table_req_result();
            TBL((short) 1, "tbl");
                    optionals.set(3);
                return _fieldName;
        @Override
        }
        public boolean isSet(_Fields field) {
            return this;
            (short) 2
        public java.lang.String toString() {
            org.apache.thrift.protocol.TType.STRING,
                    return isSetO2();
                return lastComparison;
    }
                _Fields.O1,
                case DB_NAME:
                    } else {
            sb.append(")");
                    oprot.writeFieldBegin(O1_FIELD_DESC);
        }
        public void setFieldValue(_Fields field, @org.apache.thrift.annotation.Nullable java.lang.Object value) {
        @Override
            @Override
            @org.apache.thrift.annotation.Nullable
                this.db_name = null;
                    new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, MetaException.class)
                            _LOGGER.error("Exception inside handler", e);
            throws org.apache.thrift.TException {
        }
                                    org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
                        struct.success.read(iprot);
                    org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
                if (!(this_present_success && that_present_success)) return false;
                    return isSetDatabase();
            this.o1 = null;
            protected boolean rethrowUnhandledExceptions() {
                this.o1 = null;
        public void unsetO2() {
                filter,
                case O3:
        );
    }
            if (this_present_success || that_present_success) {
            this.db_name = null;
        }
                            msg = new org.apache.thrift.TApplicationException(
        }
            switch (field) {
        public boolean equals(java.lang.Object that) {
        public add_partition_result setO3(@org.apache.thrift.annotation.Nullable MetaException o3) {
        public get_partitions_by_filter_result setO1(@org.apache.thrift.annotation.Nullable MetaException o1) {
            O1((short) 1, "o1"),
                case O1:
                sb.append("null");
        public java.lang.Object getFieldValue(_Fields field) {
            private Database database;
                        setO2((MetaException) value);
        private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
                    org.apache.thrift.TFieldRequirementType.DEFAULT,
        private static final org.apache.thrift.protocol.TField SUCCESS_FIELD_DESC = new org.apache.thrift.protocol.TField(
                if (struct.isSetO1()) {
            public void read(org.apache.thrift.protocol.TProtocol iprot, get_partitions_by_filter_result struct)
                _Fields fields = findByThriftId(fieldId);
        }
                    throw new java.lang.IllegalStateException("Method call not finished!");
                    {
                    return isSetNew_part();
                iface.get_table_req(args.req, resultHandler);
        private static class create_database_argsTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
            // check for sub-struct validity
            return this.db_name != null;
            lastComparison = java.lang.Boolean.compare(isSetO2(), other.isSetO2());
                if (!(this_present_o1 && that_present_o1)) return false;
        public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
            "o2",
                            onError(e);
        }
        );
            }
                                org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
                        }
                    iprot.readStructBegin();
        private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, java.lang.ClassNotFoundException {
            switch (field) {
            }
                _Fields fields = findByThriftId(fieldId);
        );
                req.validate();
        @Override
        public int hashCode() {
            ) {
                    } else {
                }
        private static class create_table_argsTupleScheme extends org.apache.thrift.scheme.TupleScheme<create_table_args> {
            try {
                case SUCCESS:
                if (!(this_present_req && that_present_req)) return false;
            } else {
            }
             * Find the _Fields constant that matches fieldId, or null if its not found.
                _thriftId = thriftId;
        private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
            Comparable<get_table_req_args> {
                case SUCCESS:
            return this.o1 != null;
                if (struct.o3 != null) {
                            _LOGGER.error("Exception inside handler", e);
                if (struct.o3 != null) {
            this.o2 = o2;
            if (isSetDatabase()) hashCode = hashCode * 8191 + database.hashCode();
            @Override
                lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.filter, other.filter);
                case SUCCESS:
            java.lang.String db_name,
            @Override
                this.database = null;
        private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct(
                    new org.apache.thrift.protocol.TMessage("create_database", org.apache.thrift.protocol.TMessageType.CALL, 0)
        /** Returns true if field o2 is set (has been assigned a value) and false otherwise */
                if (lastComparison != 0) {
                    if (incoming.get(2)) {
                final int seqid
        }
                    return getMax_parts();
            }
            this.req = null;
            @Override
            @org.apache.thrift.annotation.Nullable
            } else {
        @Override
        );
            public java.lang.String getFieldName() {
        }
            sb.append("o2:");
            get_partitions_args,
                        }
                        setNew_part((Partition) value);
        }
            public static _Fields findByThriftIdOrThrow(int fieldId) {
        );
                    }
        public void get_partitions_by_filter(
                        unsetO1();
                oprot.writeStructEnd();
                case NEW_PART:
                case O1:
            }
        @Override
            }
            lastComparison = java.lang.Boolean.compare(isSetO4(), other.isSetO4());
            } else {
                        setO1((InvalidObjectException) value);
            static {
            return new get_partitions_result(this);
        private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY =
        }
            if (!value) {
                new org.apache.thrift.meta_data.FieldMetaData(
                        struct.o1.read(iprot);
            O1((short) 1, "o1"),
                if (struct.isSetNew_part()) {
                    org.apache.thrift.protocol.TField schemeField;
            O2((short) 2, "o2"),
            lastComparison = java.lang.Boolean.compare(isSetSuccess(), other.isSetSuccess());
        }
            }
                };
                )
            org.apache.thrift.protocol.TType.STRUCT,
            @Override
            public get_partitions_args getEmptyArgsInstance() {
        }
            sb.append(")");
            return false;
            }
                                    struct.o2 = new InvalidObjectException();
        private static final org.apache.thrift.protocol.TField O2_FIELD_DESC = new org.apache.thrift.protocol.TField(
                }
            }
        public add_partition_result setSuccess(@org.apache.thrift.annotation.Nullable Partition success) {
            @Override
                    struct.o2.write(oprot);
            public static _Fields findByThriftIdOrThrow(int fieldId) {
            this.o2 = o2;
                    getFrameBuffer().array()
            }
            public create_database_args getEmptyArgsInstance() {
            }
            }
            org.apache.thrift.TException {
            }
                return _fieldName;
                    result.o2 = o2;
            public static _Fields findByName(java.lang.String name) {
                    new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)
                return _thriftId;
            boolean this_present_o2 = true && this.isSetO2();
            @Override
                }
            this.o1 = null;
                    oprot.writeFieldEnd();
                return false;
            }
        /** Returns true if field tbl_name is set (has been assigned a value) and false otherwise */
            new get_partitions_by_filter_resultStandardSchemeFactory();
        public enum _Fields implements org.apache.thrift.TFieldIdEnum {
                                            _elem161 = new Partition();
            }
        public create_table_args(Table tbl) {
                if (struct.isSetSuccess()) {
                    case 1: // REQ
            sb.append("o3:");
                read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
                    iprot.readStructEnd();
        public @org.apache.thrift.annotation.Nullable Partition success; // required
                }
            private final java.lang.String _fieldName;
                    iprot.decrementRecursionDepth();
            }
                throw result.o3;
            }
                    return isSetO2();
            scheme(iprot).read(iprot, this);
        @Override
            if (isSetTbl_name()) {
            if (this_present_req || that_present_req) {
                org.apache.thrift.protocol.TProtocolFactory protocolFactory,
                if (struct.db_name != null) {
                : TUPLE_SCHEME_FACTORY).getScheme();
            tmpMap.put(
            if (lastComparison != 0) {
        public boolean isSetDatabase() {
                    }
        }
                    "max_parts",
            }
                }
        public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
            }
            boolean that_present_req = true && that.isSetReq();
                    oprot.writeFieldBegin(O2_FIELD_DESC);
            @Override
        }
            first = false;
                return new get_partitions_by_filter_resultStandardScheme();
            if (!value) {
            throw new java.lang.IllegalStateException();
        }
                super("add_partition");
            } else {
                for (_Fields field : java.util.EnumSet.allOf(_Fields.class)) {
            (short) 1
        }
                    optionals.set(0);
            return true;
        public java.util.List<Partition> get_partitions(java.lang.String db_name, java.lang.String tbl_name, short max_parts)
                lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.o3, other.o3);
                                        Partition _elem153;
                return false;
                    new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, Database.class)
                case O1:
            java.lang.StringBuilder sb = new java.lang.StringBuilder("create_database_result(");
                        } catch (java.lang.Exception e) {
                java.lang.String,
        }
                        }
            hashCode = hashCode * 8191 + ((isSetO2()) ? 131071 : 524287);
            sb.append("new_part:");
                    }
        public create_table_args setTbl(@org.apache.thrift.annotation.Nullable Table tbl) {
                        switch (schemeField.id) {
                    getFrameBuffer().array()
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
                }
                                org.apache.thrift.TApplicationException.INTERNAL_ERROR,
                if (struct.isSetO2()) {
             * Find the _Fields constant that matches fieldId, throwing an exception
                ___transport
                }
                new_part.validate();
                            onError(e);
            recv_create_table();
                                break;
            }
                _Fields.O2,
                ? STANDARD_SCHEME_FACTORY
            private final short _thriftId;
        public int compareTo(add_partition_args other) {
                java.lang.String,
                }
                        struct.req = new GetTableRequest();
                case FILTER:
                if (struct.o3 != null) {
            return new create_database_args(this);
            @Override
            );
                _thriftId = thriftId;
        public @org.apache.thrift.annotation.Nullable NoSuchObjectException o2; // required
                        }
        public get_table_req_result() {}
                return new add_partition_args();
            }
                return false;
                    org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
                        switch (schemeField.id) {
                case O2:
            return this.max_parts;
                    "o2",
            this.db_name = null;
            }
        }
        }
                );
            if (this_present_tbl_name || that_present_tbl_name) {
                    return isSetO1();
            java.util.Map<
                    "o1",
            }
            }
                oprot.writeFieldStop();
            java.lang.StringBuilder sb = new java.lang.StringBuilder("get_partitions_args(");
                return new get_partitions_resultTupleScheme();
            return this;
                throw new java.io.IOException(te);
            }
            sb.append("tbl:");
            }
            public void read(org.apache.thrift.protocol.TProtocol iprot, get_partitions_args struct) throws org.apache.thrift.TException {
                                    org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
                                e.getMessage()
            org.apache.thrift.protocol.TType.STRUCT,
            }
                            break;
                                if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {
                if (!(this_present_o2 && that_present_o2)) return false;
                );
                            msgType = org.apache.thrift.protocol.TMessageType.EXCEPTION;
            boolean this_present_success = true && this.isSetSuccess();
                        return SUCCESS;
                }
                            msg = (org.apache.thrift.TApplicationException) e;
            @org.apache.thrift.annotation.Nullable
            public void read(org.apache.thrift.protocol.TProtocol iprot, get_partitions_by_filter_args struct)
                _Fields fields = findByThriftId(fieldId);
            static {
        }
                        get_partitions_result result = new get_partitions_result();
                }
                    } else {
            if (other.isSetTbl()) {
            short max_parts,
        public void setO2IsSet(boolean value) {
            __isset_bitfield = other.__isset_bitfield;
        private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY =
                    optionals.set(2);
        @Override
                            case 0: // SUCCESS
                        for (Partition _iter164 : struct.success) {
        @org.apache.thrift.annotation.Nullable
            }
                sb.append(this.success);
                    struct.o1.write(oprot);
            if (isSetO2()) {
        public get_partitions_result() {}
                        setDb_name((java.lang.String) value);
            this.tbl = null;
                throws org.apache.thrift.TException {
        }
            boolean that_present_o2 = true && that.isSetO2();
                    iprot.readStructBegin();
        }
        }
            args.setDb_name(db_name);
            scheme(iprot).read(iprot, this);
            private java.lang.String db_name;
        public @org.apache.thrift.annotation.Nullable java.lang.String filter; // required
            Comparable<create_table_args> {
                lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.o1, other.o1);
            if (this.success == null) {
            org.apache.thrift.protocol.TType.I16,
                case O1:
        );
            );
            this.o1 = null;
            this.o1 = o1;
                }
        /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
                            return;
        @Override
        }
            public void write_args(org.apache.thrift.protocol.TProtocol prot) throws org.apache.thrift.TException {
                if (struct.isSetTbl()) {
                tbl.validate();
            return this.o1 != null;
                        return null;
            /**
        /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
            if (!first) sb.append(", ");
                if (lastComparison != 0) {
                                    org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
        public int compareTo(create_table_args other) {
                                    struct.setSuccessIsSet(true);
            }
                            case 1: // O1
                args.write(prot);
                __isset_bitfield = 0;
 */
                        }
        }
                                    org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            tmpMap.put(
            hashCode = hashCode * 8191 + ((isSetSuccess()) ? 131071 : 524287);
        }
            "tbl",
            if (isSetMax_parts()) {
                        }
                        setSuccess((GetTableResult) value);
    @SuppressWarnings({ "cast", "rawtypes", "serial", "unchecked", "unused" })
                                if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
                java.lang.String tbl_name,
                    return isSetMax_parts();
        }
        public get_partitions_by_filter_result setO2(@org.apache.thrift.annotation.Nullable NoSuchObjectException o2) {
                this.max_parts = max_parts;
                sb.append("null");
        @Override
                    struct.o1.write(oprot);
                new org.apache.thrift.meta_data.FieldMetaData(
                new org.apache.thrift.meta_data.FieldMetaData(
                    org.apache.thrift.TFieldRequirementType.DEFAULT,
        public void unsetMax_parts() {
            this.success = success;
        }
        public get_partitions_by_filter_result() {}
                                } else {
        }
             */
                sb.append(this.o4);
        }
            @Override
                    org.apache.thrift.protocol.TField schemeField;
            int hashCode = 1;
                args.write(prot);
        public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
            @Override
                _Fields.O1,
                if (struct.isSetSuccess()) {
            this.db_name = null;
                    case 0: // SUCCESS
                org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
        }
            private org.apache.thrift.protocol.TProtocolFactory protocolFactory;
                                e.getMessage()
        }
                for (_Fields field : java.util.EnumSet.allOf(_Fields.class)) {
            this();
        @org.apache.thrift.annotation.Nullable
                    new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, GetTableResult.class)
        /**
            public void read(org.apache.thrift.protocol.TProtocol iprot, add_partition_result struct) throws org.apache.thrift.TException {
                    java.util.BitSet incoming = iprot.readBitSet(3);
        @org.apache.thrift.annotation.Nullable
        }
                return fields;
        @org.apache.thrift.annotation.Nullable
            @Override
                    break;
            if (this == that) return true;
                                    struct.o1.read(iprot);
                case O3:
        private static class get_partitions_resultStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
             */
                    }
                                    org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
                    }
        }
        /**
                        return O3;
                    } else {
            public boolean isOneway() {
            }
            if (other.isSetO2()) {
            switch (field) {
            }
        public boolean isSet(_Fields field) {
        }
            switch (field) {
            return this.o1 != null;
        );
            org.apache.thrift.TBase<create_database_result, create_database_result._Fields>,
            org.apache.thrift.protocol.TType.STRUCT,
                }
                    iprot.readStructEnd();
            org.apache.thrift.protocol.TType.STRUCT,
            }
                lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.o1, other.o1);
            (short) 2
            org.apache.thrift.TException {
                            fcall.sendResponse(fb, msg, msgType, seqid);
            }
                    java.util.BitSet incoming = iprot.readBitSet(3);
            first = false;
        @Override
        public java.lang.String toString() {
        @Override
                    result.o1 = o1;
            /**
        public create_table_result deepCopy() {
        }
                        }
            super(protocolFactory, clientManager, transport);
        public void unsetFilter() {
            if (lastComparison != 0) {
            this.o1 = o1;
                    org.apache.thrift.TFieldRequirementType.DEFAULT,
            first = false;
            );
            if (!value) {
                }
            if (other.isSetO3()) {
                }
             * Find the _Fields constant that matches name, or null if its not found.
        public int hashCode() {
                sb.append("null");
            switch (field) {
            boolean this_present_o3 = true && this.isSetO3();
                                }
        }
            }
                        setTbl_name((java.lang.String) value);
            }
                }
            ) {
                return byName.get(name);
             * if it is not found.
                    org.apache.thrift.protocol.TField schemeField;
                    }
                }
            }
                    optionals.set(0);
                }
            }
                throw new java.io.IOException(te);
            this.o1 = null;
        @Override
        public create_database_result(create_database_result other) {
            this.o3 = null;
        }
                        struct.setO3IsSet(true);
                );
            return this.req != null;
            return true;
        }
            short max_parts
        }
                            result.o4 = (NoSuchObjectException) e;
            public get_partitions_by_filter_call(
                prot.writeMessageEnd();
                return new get_partitions_by_filter_resultTupleScheme();
            return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme())
            int lastComparison = 0;
            );
                    } else {
        public void validate() throws org.apache.thrift.TException {
                this.o1 = new AlreadyExistsException(other.o1);
            @Override
                return new create_table_result();
            first = false;
            return _Fields.findByThriftId(fieldId);
                org.apache.thrift.async.AsyncMethodCallback<Void> resultHandler,
        private static class get_table_req_resultTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
                        unsetSuccess();
            }
            return this.o2 != null;
        public @org.apache.thrift.annotation.Nullable InvalidObjectException o1; // required
                add_partition_args args = new add_partition_args();
                                break;
            this.o4 = o4;
            }
        private static class get_table_req_argsStandardScheme extends org.apache.thrift.scheme.StandardScheme<get_table_req_args> {
                                    org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            switch (field) {
            }
            if (!value) {
                _fieldName = fieldName;
        public boolean equals(get_partitions_result that) {
            }
                    "o3",
                }
                    new org.apache.thrift.meta_data.ListMetaData(
            }
        public MetaException getO3() {
                java.lang.String,
                case SUCCESS:
                return new get_table_req_result();
        @org.apache.thrift.annotation.Nullable
                )
            if (!getClass().equals(other.getClass())) {
                if (lastComparison != 0) {
                max_parts,
            public void write(org.apache.thrift.protocol.TProtocol oprot, get_partitions_by_filter_result struct)
            @Override
        }
                                }
            return recv_get_partitions();
        }
            tmpMap.put(
                    case 1: // O1
                        struct.o3.read(iprot);
            sb.append("o2:");
                    break;
            return true;
        }
                    if (incoming.get(1)) {
        private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
            public create_table_args getEmptyArgsInstance() {
            if (this.tbl_name == null) {
                    prot.decrementRecursionDepth();
            java.io.Serializable,
            }
            boolean this_present_req = true && this.isSetReq();
        public get_partitions_by_filter_args setTbl_name(@org.apache.thrift.annotation.Nullable java.lang.String tbl_name) {
                    if (incoming.get(2)) {
            public get_partitions_argsStandardScheme getScheme() {
            if (other.isSetSuccess()) {
                return new create_table_resultStandardScheme();
            }
        }
            int lastComparison = 0;
            this.o2 = o2;
                        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) {
                sb.append(this.db_name);
            }
             */
        }
                } finally {
        @Override
                    }
                            case 1: // O1
            }
            }
                    getFrameBuffer().array()
            if (isSetO3()) {
            new get_table_req_resultStandardSchemeFactory();
                try {
            args.setTbl_name(tbl_name);
                    if (value == null) {
                if (struct.o2 != null) {
                this.o1 = new AlreadyExistsException(other.o1);
            throws org.apache.thrift.TException;
            return this.database;
            @Override
                            fcall.sendResponse(fb, msg, msgType, seqid);
            public add_partition_args getEmptyArgsInstance() {
            @Override
        @Override
                if (!(this_present_o2 && that_present_o2)) return false;
        @org.apache.thrift.annotation.Nullable
            (short) 0
                db_name,
                        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) {
            @Override
                    "o1",
        public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
                    new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, MetaException.class)
        }
        /** Returns true if field db_name is set (has been assigned a value) and false otherwise */
            if (result.isSetSuccess()) {
            get_partitions_by_filter_call method_call = new get_partitions_by_filter_call(
            }
                }
    public static class get_partitions_by_filter_args
                java.util.BitSet optionals = new java.util.BitSet();
            @Override
            }
                final org.apache.thrift.AsyncProcessFunction fcall = this;
                }
                    }
            ) throws org.apache.thrift.TException {
            public java.lang.String getFieldName() {
                if (struct.isSetSuccess()) {
                org.apache.thrift.transport.TNonblockingTransport transport
                    }
                            msg = result;
        public void setFieldValue(_Fields field, @org.apache.thrift.annotation.Nullable java.lang.Object value) {
            }
                    java.util.BitSet incoming = iprot.readBitSet(3);
                    iprot.readStructBegin();
            hashCode = hashCode * 8191 + ((isSetO2()) ? 131071 : 524287);
                    optionals.set(1);
                        return O3;
                            _iter156.write(oprot);
            if (other.isSetSuccess()) {
                        struct.o2 = new MetaException();
            if (this.o2 == null) {
            super(iface, getProcessMap(processMap));
                    break;
            public void write(org.apache.thrift.protocol.TProtocol oprot, get_partitions_args struct) throws org.apache.thrift.TException {
        public boolean isSet(_Fields field) {
                if (this.max_parts != that.max_parts) return false;
        @Override
            public void write(org.apache.thrift.protocol.TProtocol prot, create_table_result struct) throws org.apache.thrift.TException {
                        iprot.readFieldEnd();
                sb.append(this.o2);
                                break;
                                if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {
                } catch (AlreadyExistsException o2) {
            }
                        struct.setO1IsSet(true);
            // check for sub-struct validity
                        );
            (short) 0
                )
        }
        private static final org.apache.thrift.protocol.TField TBL_FIELD_DESC = new org.apache.thrift.protocol.TField(
            private final java.lang.String _fieldName;
                throws org.apache.thrift.TException {
                for (_Fields field : java.util.EnumSet.allOf(_Fields.class)) {
            if (isSetReq()) hashCode = hashCode * 8191 + req.hashCode();
        }
        }
            sendBase("get_partitions_by_filter", args);
        ) throws MetaException, NoSuchObjectException, org.apache.thrift.TException {
                            new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, struct.success.size())
            }
                                break;
            }
            }
                return new get_partitions_resultStandardScheme();
            org.apache.thrift.protocol.TType.STRUCT,
            }
                        return REQ;
            }
            }
                throw result.o2;
        }
                this.success = null;
        }
            } catch (org.apache.thrift.TException te) {
            public void write_args(org.apache.thrift.protocol.TProtocol prot) throws org.apache.thrift.TException {
                throw new java.io.IOException(te);
            org.apache.thrift.TBase<create_database_args, create_database_args._Fields>,
            return true;
                oprot.writeBitSet(optionals, 3);
        }
        /** Returns true if field o1 is set (has been assigned a value) and false otherwise */
            }
            org.apache.thrift.async.AsyncMethodCallback<java.util.List<Partition>> resultHandler
                        switch (schemeField.id) {
                                break;
            }
        public _Fields fieldForId(int fieldId) {
            }
                if (struct.o1 != null) {
        }
            if (other.isSetTbl_name()) {
            sb.append(")");
        }
            if (this_present_o2 || that_present_o2) {
            hashCode = hashCode * 8191 + ((isSetFilter()) ? 131071 : 524287);
            boolean this_present_database = true && this.isSetDatabase();
        );
            }
        );
            return new create_database_result(this);
            @Override
                                }
        private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
            return this.success;
            @Override
            return false;
            /**
            this.success = success;
        public enum _Fields implements org.apache.thrift.TFieldIdEnum {
            // check for required fields
         */
                if (lastComparison != 0) {
                org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
        public java.util.List<Partition> getSuccess() {
                }
            (short) 1
                                if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {
            if (!value) {
            );
        }
                throw new java.io.IOException(te);
                throw new java.lang.IllegalArgumentException();
                    @Override
                                    org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        public void unsetO4() {
        @Override
            sb.append("o3:");
                                }
                    optionals.set(2);
                if (!this.o1.equals(that.o1)) return false;
        public boolean isSetMax_parts() {
                        struct.o1 = new MetaException();
            tmpMap.put(
                        struct.o1.read(iprot);
            @Override
            return new add_partition_result(this);
                    org.apache.thrift.TFieldRequirementType.DEFAULT,
            int lastComparison = 0;
            org.apache.thrift.protocol.TType.I16,
        @Override
        public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
            Cloneable,
                org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
        );
        static {
                    public void onComplete(java.util.List<Partition> o) {
            TBL_NAME((short) 2, "tbl_name"),
        public static class get_partitions_by_filter_call extends org.apache.thrift.async.TAsyncMethodCall<java.util.List<Partition>> {
        private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
        }
            java.lang.String tbl_name,
                    if (incoming.get(2)) {
            public void read(org.apache.thrift.protocol.TProtocol prot, create_database_result struct) throws org.apache.thrift.TException {
                        struct.setSuccessIsSet(true);
                oprot.writeStructBegin(STRUCT_DESC);
                if (lastComparison != 0) {
            public java.util.List<Partition> getResult() throws NoSuchObjectException, MetaException, org.apache.thrift.TException {
            try {
            }
                    }
            java.lang.String filter,
        }
                    iprot.decrementRecursionDepth();
                    struct.o3.write(oprot);
                                break;
                    } else {
                            _LOGGER.error("Exception writing to internal frame buffer", e);
        }
            public get_partitions_call(
            return hashCode;
        }
        }
                return _thriftId;
            }
            if (that == null) return false;
        }
            create_database_result result = new create_database_result();
                            _LOGGER.error("Exception inside handler", e);
            args.setNew_part(new_part);
        @Override
            public void read(org.apache.thrift.protocol.TProtocol iprot, create_table_args struct) throws org.apache.thrift.TException {
        private static final org.apache.thrift.protocol.TField DB_NAME_FIELD_DESC = new org.apache.thrift.protocol.TField(
            public create_database() {
            int lastComparison = 0;
            throws org.apache.thrift.TException;
                        } else if (e instanceof org.apache.thrift.transport.TTransportException) {
                            case 1: // NEW_PART
         * Performs a deep copy on <i>other</i>.
            public short getThriftFieldId() {
            } catch (org.apache.thrift.TException te) {
                case O2:
            return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme())
                oprot.writeStructEnd();
        }
                            case 1: // O1
            @Override
                : TUPLE_SCHEME_FACTORY).getScheme();
                );
            boolean this_present_o2 = true && this.isSetO2();
                    return lastComparison;
                return _fieldName;
            return this.max_parts;
        public int hashCode() {
        public boolean equals(java.lang.Object that) {
                        struct.new_part.read(iprot);
                return new get_table_req_argsTupleScheme();
            }
            get_partitions_result> {
            switch (field) {
            public org.apache.thrift.async.AsyncMethodCallback<java.util.List<Partition>> getResultHandler(
            }
                case O2:
            public void read(org.apache.thrift.protocol.TProtocol prot, create_table_result struct) throws org.apache.thrift.TException {
            @org.apache.thrift.annotation.Nullable
                if (!this.db_name.equals(that.db_name)) return false;
            return hashCode;
            args.setTbl_name(tbl_name);
            DB_NAME((short) 1, "db_name"),
                    } else {
        }
        }
        public int compareTo(get_partitions_args other) {
            public void read(org.apache.thrift.protocol.TProtocol prot, get_partitions_result struct) throws org.apache.thrift.TException {
                            _LOGGER.error("Exception writing to internal frame buffer", e);
                throw result.o2;
            @Override
                case O2:
                org.apache.thrift.protocol.TProtocolFactory protocolFactory,
            }
                                } else {
        }
            if (this_present_o2 || that_present_o2) {
                    while (true) {
        }
                if (struct.o1 != null) {
                        struct.database.read(iprot);
            if (isSetO2()) hashCode = hashCode * 8191 + o2.hashCode();
        public @org.apache.thrift.annotation.Nullable MetaException o1; // required
            switch (field) {
        }
            private Partition new_part;
        public int compareTo(get_table_req_args other) {
                    struct.o1.write(oprot);
            }
                    optionals.set(2);
            this();
            }
            send_create_database(database);
                        } catch (java.lang.Exception ex) {
                    break;
            }
                                }
                    }
                _Fields.O4,
                for (Partition other_element : other.success) {
            __isset_bitfield = other.__isset_bitfield;
                final int seqid
            );
            I,
        private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY =
            /**
                this.tbl_name = tbl_name;
            public static _Fields findByThriftIdOrThrow(int fieldId) {
                return new create_database_result();
            } else {
            if (isSetO1()) hashCode = hashCode * 8191 + o1.hashCode();
                oprot.writeFieldBegin(MAX_PARTS_FIELD_DESC);
        ) {
                prot.writeMessageEnd();
            @Override
        }
            lastComparison = java.lang.Boolean.compare(isSetDb_name(), other.isSetDb_name());
            public create_database_result getEmptyResultInstance() {
                case TBL_NAME:
            sb.append(")");
                        return null;
            org.apache.thrift.protocol.TType.LIST,
        public void validate() throws org.apache.thrift.TException {
             */
        }
        }
            this.db_name = db_name;
            boolean that_present_o3 = true && that.isSetO3();
            private final short _thriftId;
            }
            try {
            return this.o1 != null;
        }
                    case 2: // TBL_NAME
                                if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
                if (fields == null) throw new java.lang.IllegalArgumentException("Field " + fieldId + " doesn't exist!");
                }
            @org.apache.thrift.annotation.Nullable
            } catch (org.apache.thrift.TException te) {
                    optionals.set(0);
        }
                    } else {
        }
            "get_partitions_by_filter_result"
            boolean this_present_o1 = true && this.isSetO1();
                this,
            @Override
            /**
            public get_partitions_resultStandardScheme getScheme() {
                sb.append(this.o3);
                    prot.decrementRecursionDepth();
        }
            @Override
                    public void onComplete(GetTableResult o) {
            @Override
                if (struct.isSetSuccess()) {
                _Fields.O1,
            sb.append("tbl_name:");
            throw new java.lang.IllegalStateException();
            tmpMap.put(
                prot.incrementRecursionDepth();
                            _LOGGER.error("Exception writing to internal frame buffer", e);
                super(client, protocolFactory, transport, resultHandler, false);
            this.success.add(elem);
            this.o2 = null;
        @org.apache.thrift.annotation.Nullable
            first = false;
                    if (value == null) {
                    org.apache.thrift.TFieldRequirementType.DEFAULT,
            // check for required fields
            }
                );
                                if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {
            } else {
        @Override
                return new org.apache.thrift.async.AsyncMethodCallback<Partition>() {
            tmpMap.put(
             */
            @org.apache.thrift.annotation.Nullable
            return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme())
            return this.o2;
            return _Fields.findByThriftId(fieldId);
            metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
                                break;
                    org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
                }
        private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
                _Fields,
                    oprot.writeFieldBegin(TBL_NAME_FIELD_DESC);
                if (!(this_present_o1 && that_present_o1)) return false;
                                } else {
            first = false;
            metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
            this.o1 = o1;
                : TUPLE_SCHEME_FACTORY).getScheme();
        public boolean equals(java.lang.Object that) {
                    iprot.readStructEnd();
            }
        }
        public create_database_result() {}
            } else {
            if (this_present_o2 || that_present_o2) {
            }
            @Override
                    public void onComplete(Void o) {
            } catch (org.apache.thrift.TException te) {
            I extends AsyncIface>
                                org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
                }
            if (field == null) {
        /** Returns true if field filter is set (has been assigned a value) and false otherwise */
            return _Fields.findByThriftId(fieldId);
        }
        }
        @Override
         */
                    struct.o1.write(oprot);
                java.util.BitSet optionals = new java.util.BitSet();
                        return null;
        public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
        /** Returns true if field max_parts is set (has been assigned a value) and false otherwise */
                throw new java.io.IOException(te);
                return new create_database_resultStandardScheme();
                org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
        public create_database_args(Database database) {
            /**
        private static final org.apache.thrift.protocol.TField O1_FIELD_DESC = new org.apache.thrift.protocol.TField(
            setMax_partsIsSet(true);
            args.setMax_parts(max_parts);
                                }
            new get_partitions_resultStandardSchemeFactory();
    public static class get_partitions_by_filter_result
                    }
            scheme(iprot).read(iprot, this);
            java.io.Serializable,
                prot.incrementRecursionDepth();
        }
                                            struct.success.add(_elem161);
            return new add_partition_args(this);
            }
        private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct(
    public static class add_partition_result
            get_table_req_args args = new get_table_req_args();
        public void addToSuccess(Partition elem) {
                new org.apache.thrift.meta_data.FieldMetaData(
                }
        public void setDb_nameIsSet(boolean value) {
        }
                this.new_part = new Partition(other.new_part);
            public static _Fields findByThriftIdOrThrow(int fieldId) {
            }
            return new get_partitions_by_filter_result(this);
            public void read(org.apache.thrift.protocol.TProtocol iprot, get_table_req_result struct) throws org.apache.thrift.TException {
                Database database,
                    )
            first = false;
                oprot.writeFieldStop();
                }
                                        @org.apache.thrift.annotation.Nullable
        @org.apache.thrift.annotation.Nullable
                prot.incrementRecursionDepth();
                    // check for required fields of primitive type, which can't be checked in the validate method
            boolean that_present_max_parts = true;
                        struct.o1.read(iprot);
                    org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
            /**
            boolean this_present_o4 = true && this.isSetO4();
            public static _Fields findByThriftId(int fieldId) {
            if (field == null) {
            this.o3 = o3;
                throw new java.lang.IllegalArgumentException();
            ) throws org.apache.thrift.TException {
                    return lastComparison;
        @Override
                    optionals.set(0);
                prot.incrementRecursionDepth();
                        unsetFilter();
        /**
            sb.append("success:");
                create_database_args args = new create_database_args();
                    }
                _fieldName = fieldName;
            @Override
        public void validate() throws org.apache.thrift.TException {
            __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __MAX_PARTS_ISSET_ID);
                if (!(this_present_o1 && that_present_o1)) return false;
                                } else {
                                } else {
        /** Returns true if field tbl is set (has been assigned a value) and false otherwise */
                                    org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
                this.tbl = new Table(other.tbl);
            return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme())
                return new get_partitions_result();
            get_partitions_by_filter_result result = new get_partitions_by_filter_result();
        }
        /** Returns true if field o3 is set (has been assigned a value) and false otherwise */
        @Override
        public void unsetSuccess() {
    public static class get_partitions_args
        }
                        } catch (java.lang.Exception ex) {
                    oprot.writeString(struct.filter);
            if (isSetO1()) {
                return false;
                        schemeField = iprot.readFieldBegin();
        private static class get_partitions_by_filter_argsTupleScheme extends org.apache.thrift.scheme.TupleScheme<
                    break;
            return new get_table_req_result(this);
        );
        public boolean isSetO1() {
        @Override
                    if (value == null) {
        public int compareTo(get_table_req_result other) {
            }
            sb.append(this.max_parts);
                    org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
                return result;
                    return getO1();
            return true;
                return false;
        // isset id assignments
                    return isSetSuccess();
        }
        public void send_get_partitions(java.lang.String db_name, java.lang.String tbl_name, short max_parts)
                }
                    "tbl_name",
                try {
        public enum _Fields implements org.apache.thrift.TFieldIdEnum {
                        return null;
        }
                } finally {
            int lastComparison = 0;
            @Override
            DB_NAME((short) 1, "db_name"),
            }
            @Override
                oprot.writeStructBegin(STRUCT_DESC);
            this.o3 = o3;
            sb.append("req:");
                }
                throw new java.io.IOException(te);
            org.apache.thrift.protocol.TType.STRING,
            private final java.lang.String _fieldName;
            }
                org.apache.thrift.protocol.TProtocol prot = client.getProtocolFactory().getProtocol(memoryTransport);
        }
                    }
                    break;
                : TUPLE_SCHEME_FACTORY).getScheme();
            }
        private static class get_partitions_resultTupleScheme extends org.apache.thrift.scheme.TupleScheme<get_partitions_result> {
                        } else if (e instanceof org.apache.thrift.TApplicationException) {
                if (!this.o1.equals(that.o1)) return false;
            }
                if (lastComparison != 0) {
        private static <
                _Fields.DB_NAME,
                return new add_partition_resultStandardScheme();
            }
                                        struct.success = new java.util.ArrayList<Partition>(_list152.size);
                : TUPLE_SCHEME_FACTORY).getScheme();
                                    struct.new_part.read(iprot);
                }
         */
            this.tbl = null;
            ) throws org.apache.thrift.TException {
            java.lang.String db_name,
             * Find the _Fields constant that matches fieldId, or null if its not found.
            public get_partitions_result getResult(I iface, get_partitions_args args) throws org.apache.thrift.TException {
            first = false;
        private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY =
            throw new java.lang.IllegalStateException();
            first = false;
        private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY = new get_table_req_argsStandardSchemeFactory();
                oprot.writeFieldStop();
                    new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, AlreadyExistsException.class)
        @Override
            hashCode = hashCode * 8191 + ((isSetO3()) ? 131071 : 524287);
                    struct.validate();
                    byName.put(field.getFieldName(), field);
                    } else {
            if (result.isSetSuccess()) {
        /** Returns true if field o1 is set (has been assigned a value) and false otherwise */
                case O1:
            public get_table_req_args getEmptyArgsInstance() {
                    break;
            public void write(org.apache.thrift.protocol.TProtocol prot, get_partitions_by_filter_args struct)
                    optionals.set(0);
        private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
                }
                }
            return this.o3 != null;
        public int hashCode() {
            processMap.put("get_partitions", new get_partitions());
            return this;
                switch (fieldId) {
        public AlreadyExistsException getO1() {
                throw new java.io.IOException(te);
        }
            private java.lang.String tbl_name;
            hashCode = hashCode * 8191 + ((isSetO3()) ? 131071 : 524287);
        public int compareTo(get_partitions_by_filter_args other) {
        }
                java.util.BitSet optionals = new java.util.BitSet();
                        switch (schemeField.id) {
                sb.append("null");
            }
                oprot.writeStructBegin(STRUCT_DESC);
        public void unsetO3() {
                org.apache.thrift.protocol.TProtocolFactory protocolFactory,
            sendBase("create_table", args);
            }
            int hashCode = 1;
            }
            }
                    break;
            org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(create_table_result.class, metaDataMap);
            }
            public static _Fields findByThriftId(int fieldId) {
        // isset id assignments
                sb.append(this.db_name);
                        unsetSuccess();
                }
                        try {
        }
            public get_partitions_by_filter_args getEmptyArgsInstance() {
            MAX_PARTS((short) 4, "max_parts");
             */
            this.o2 = null;
                sb.append("null");
                            default:
            public get_partitions_by_filter() {
                _Fields.FILTER,
            );
                        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) {
                this.o1 = null;
                oprot.writeStructEnd();
                if (!this.success.equals(that.success)) return false;
            @Override
                    oprot.writeFieldEnd();
                                        iprot.readListEnd();
            if (this.o1 == null) {
                return lastComparison;
            public get_partitions_args getEmptyArgsInstance() {
            if (isSetSuccess()) {
                                if (schemeField.type == org.apache.thrift.protocol.TType.LIST) {
                switch (fieldId) {
        @Override
            tmpMap.put(
            if (that == null) return false;
            metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
        @Override
                    return lastComparison;
                case O1:
                return fields;
                                    struct.o2 = new AlreadyExistsException();
                if (struct.isSetO2()) {
@SuppressWarnings({ "cast", "rawtypes", "serial", "unchecked", "unused" })
                            org.apache.thrift.protocol.TList _list165 = iprot.readListBegin(org.apache.thrift.protocol.TType.STRUCT);
                    } else {
                sb.append(this.o1);
            @Override
                if (lastComparison != 0) {
                    } else {
        @Override
            first = false;
                org.apache.thrift.protocol.TProtocol prot = client.getProtocolFactory().getProtocol(memoryTransport);
            @org.apache.thrift.annotation.Nullable
        public void setFieldValue(_Fields field, @org.apache.thrift.annotation.Nullable java.lang.Object value) {
            "o2",
                            fb.close();
            } else {
                oprot.writeStructEnd();
            if (isSetSuccess()) hashCode = hashCode * 8191 + success.hashCode();
        public void setSuccessIsSet(boolean value) {
                        struct.o3 = new MetaException();
            if (!value) {
        }
        public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
        }
                            msgType = org.apache.thrift.protocol.TMessageType.EXCEPTION;
             * if it is not found.
            }
                        switch (schemeField.id) {
                        add_partition_result result = new add_partition_result();
                                }
        }
            return sb.toString();
                        result.success = o;
                org.apache.thrift.transport.TMemoryInputTransport memoryTransport = new org.apache.thrift.transport.TMemoryInputTransport(
                if (!this.db_name.equals(that.db_name)) return false;
                throw result.o1;
                    org.apache.thrift.TFieldRequirementType.DEFAULT,
                write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
                        return O1;
                } catch (AlreadyExistsException o1) {
                    byName.put(field.getFieldName(), field);
            return new create_table_result(this);
            short max_parts,
                sb.append(this.o3);
        public @org.apache.thrift.annotation.Nullable java.util.List<Partition> success; // required
                    iprot.readStructBegin();
            private java.lang.String filter;
                        byte msgType = org.apache.thrift.protocol.TMessageType.REPLY;
            ) throws org.apache.thrift.TException {
        }
            return this.o3 != null;
            }
        }
                    }
            tmpMap.put(
                    org.apache.thrift.TFieldRequirementType.DEFAULT,
            if (lastComparison != 0) {
            this.tbl_name = null;
                        unsetO1();
                    org.apache.thrift.TFieldRequirementType.DEFAULT,
             * Find the _Fields constant that matches name, or null if its not found.
                if (lastComparison != 0) {
                    result.o3 = o3;
            Void,
        }
                    struct.database.write(oprot);
            scheme(oprot).write(oprot, this);
            this();
            /**
        public void setO4IsSet(boolean value) {
                        schemeField = iprot.readFieldBegin();
        @Override
                    oprot.writeFieldEnd();
                                    org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
                if (!this.o1.equals(that.o1)) return false;
            new add_partition_resultStandardSchemeFactory();
            this.o3 = null;
        }
            protected boolean rethrowUnhandledExceptions() {
                new org.apache.thrift.meta_data.FieldMetaData(
        // isset id assignments
            throw new org.apache.thrift.TApplicationException(
            }
            public short getThriftFieldId() {
            public short getThriftFieldId() {
            short max_parts,
                    __this__success.add(new Partition(other_element));
                sb.append(this.tbl_name);
        }
            }
            @Override
                    oprot.writeFieldEnd();
        public void unsetDb_name() {
                    // check for required fields of primitive type, which can't be checked in the validate method
                    oprot.writeFieldEnd();
            }
                case O3:
                            msgType = org.apache.thrift.protocol.TMessageType.EXCEPTION;
                                    struct.setO1IsSet(true);
            public boolean isOneway() {
                _Fields.O3,
            (short) 3
        public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
        public java.lang.String toString() {
            }
                super("get_partitions");
                            case 1: // O1
            }
        public boolean isSet(_Fields field) {
        }
                                }
        }
        @org.apache.thrift.annotation.Nullable
            if (!first) sb.append(", ");
                                if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {
            setMax_partsIsSet(false);
            Cloneable,
            if (other.isSetTbl_name()) {
            public short getThriftFieldId() {
                            msgType = org.apache.thrift.protocol.TMessageType.EXCEPTION;
            org.apache.thrift.protocol.TType.STRUCT,
            }
                new org.apache.thrift.meta_data.FieldMetaData(
            public static _Fields findByName(java.lang.String name) {
                        } catch (java.lang.Exception ex) {
                        return O1;
        }
                    }
                )
        }
            if (isSetO1()) hashCode = hashCode * 8191 + o1.hashCode();
            if (isSetO3()) {
            }
                    "o2",
                    org.apache.thrift.protocol.TField schemeField;
                    oprot.writeString(struct.filter);
             * Find the _Fields constant that matches fieldId, throwing an exception
            processMap.put("get_table_req", new get_table_req());
        }
                iface.create_database(args.database, resultHandler);
                return (new Client(prot)).recv_get_table_req();
             * Find the _Fields constant that matches fieldId, or null if its not found.
            (short) 1
                        switch (schemeField.id) {
        }
        }
        @Override
            if (!first) sb.append(", ");
                iprot.incrementRecursionDepth();
        @Override
                }
                    }
            public void write_args(org.apache.thrift.protocol.TProtocol prot) throws org.apache.thrift.TException {
                    while (true) {
            }
        }
            if (!value) {
                read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
                    }
                sb.append("null");
        public java.lang.Object getFieldValue(_Fields field) {
            }
                    iprot.readStructBegin();
        private static class create_table_resultStandardScheme extends org.apache.thrift.scheme.StandardScheme<create_table_result> {
            I,
            @Override
            @Override
            }
                oprot.writeStructEnd();
                throw new java.io.IOException(te);
            create_table_args,
        @Override
                                    struct.setO2IsSet(true);
                        } catch (java.lang.Exception ex) {
                _Fields,
            public get_table_req_args getEmptyArgsInstance() {
            }
        public java.lang.String toString() {
        /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
        /**
            this.o2 = null;
        implements
                            fb.close();
                    struct.o2.write(oprot);
                        java.lang.String,
            @Override
                if (!this.o2.equals(that.o2)) return false;
        }
            sb.append("o3:");
        @Override
                oprot.writeStructBegin(STRUCT_DESC);
                    return isSetDb_name();
            if (that == null) return false;
                sb.append("null");
            java.lang.String tbl_name,
            }
                lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.success, other.success);
                    }
                            break;
            }
            }
                    oprot.writeFieldBegin(DB_NAME_FIELD_DESC);
        }
            (short) 1
                org.apache.thrift.async.TAsyncClient client,
            GetTableResult,
                    optionals.set(0);
        @Override
            lastComparison = java.lang.Boolean.compare(isSetO1(), other.isSetO1());
        public get_partitions_result deepCopy() {
                this.filter = null;
            boolean that_present_max_parts = true;
            }
            receiveBase(result, "get_table_req");
        }
        public int hashCode() {
                            );
            if (lastComparison != 0) {
                return lastComparison;
                    oprot.writeFieldEnd();
                                }
            return false;
                        I,
                    } else {
                org.apache.thrift.transport.TMemoryInputTransport memoryTransport = new org.apache.thrift.transport.TMemoryInputTransport(
                    oprot.writeFieldBegin(O2_FIELD_DESC);
            if (that == null) return false;
            public org.apache.thrift.async.AsyncMethodCallback<Void> getResultHandler(
            private java.lang.String tbl_name;
            if (this_present_success || that_present_success) {
                    // check for required fields of primitive type, which can't be checked in the validate method
            if (lastComparison != 0) {
            @Override
                if (struct.isSetSuccess()) {
                read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
            lastComparison = java.lang.Boolean.compare(isSetO2(), other.isSetO2());
            if (isSetTbl()) {
        public void unsetTbl_name() {
            public java.util.List<Partition> getResult() throws MetaException, NoSuchObjectException, org.apache.thrift.TException {
                return lastComparison;
            }
            }
        public void unsetTbl_name() {
            }
        }
        public int hashCode() {
                get_partitions_by_filter_args args = new get_partitions_by_filter_args();
                return lastComparison;
        @Override
        @Override
            this();
            private final short _thriftId;
                        return O1;
        public void unsetNew_part() {
                        }
        }
                                } else {
        private static class get_partitions_by_filter_resultTupleScheme extends org.apache.thrift.scheme.TupleScheme<
        }
                return result;
            boolean that_present_tbl_name = true && that.isSetTbl_name();
            @org.apache.thrift.annotation.Nullable
        public boolean isSetReq() {
                            break;
                    prot.decrementRecursionDepth();
            create_database_result> {
        ) {
                        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) {
                    org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
            if (that instanceof add_partition_result) return this.equals((add_partition_result) that);
            public static _Fields findByThriftId(int fieldId) {
                try {
            throw new java.lang.IllegalStateException();
            return 0;
        public void validate() throws org.apache.thrift.TException {
                            break;
                : TUPLE_SCHEME_FACTORY).getScheme();
                super("create_database");
            hashCode = hashCode * 8191 + ((isSetO2()) ? 131071 : 524287);
            hashCode = hashCode * 8191 + ((isSetO1()) ? 131071 : 524287);
        }
            if (this.o1 == null) {
            "success",
        }
                                    struct.setSuccessIsSet(true);
                try {
                        }
            private org.apache.thrift.async.TAsyncClientManager clientManager;
        private static final org.apache.thrift.protocol.TField O4_FIELD_DESC = new org.apache.thrift.protocol.TField(
                switch (fieldId) {
                new org.apache.thrift.meta_data.FieldMetaData(
            @Override
        }
                    oprot.writeFieldEnd();
            }
            }
            }
            }
            java.lang.String tbl_name,
        }
            }
        @Override
        public AlreadyExistsException getO2() {
                    // check for required fields of primitive type, which can't be checked in the validate method
                org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
                                break;
            return this.tbl_name != null;
            boolean first = true;
        public int compareTo(get_partitions_by_filter_result other) {
                                _elem158.read(iprot);
        private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct(
        private static class get_table_req_resultTupleScheme extends org.apache.thrift.scheme.TupleScheme<get_table_req_result> {
                        return O3;
            }
        }
         * Performs a deep copy on <i>other</i>.
                final org.apache.thrift.AsyncProcessFunction fcall = this;
        }
            );
                    oprot.writeFieldEnd();
                        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) {
                        setO3((MetaException) value);
                }
                    }
        }
                    byName.put(field.getFieldName(), field);
                        return O2;
        public @org.apache.thrift.annotation.Nullable Partition new_part; // required
                if (lastComparison != 0) {
        public create_table_result(AlreadyExistsException o1, InvalidObjectException o2, MetaException o3, NoSuchObjectException o4) {
            }
                throw new java.io.IOException(te);
        public _Fields fieldForId(int fieldId) {
        public get_table_req_args(get_table_req_args other) {
            }
                throw new java.io.IOException(te);
                    new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, NoSuchObjectException.class)
                    }
                }
            _Fields(short thriftId, java.lang.String fieldName) {
                lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.req, other.req);
                        struct.o1 = new MetaException();
                                    struct.setO3IsSet(true);
                if (!(this_present_tbl_name && that_present_tbl_name)) return false;
        }
                sb.append(this.o1);
            org.apache.thrift.TBase<get_partitions_by_filter_args, get_partitions_by_filter_args._Fields>,
            this.filter = null;
                this.tbl_name = other.tbl_name;
        }
        @org.apache.thrift.annotation.Nullable
        private static final org.apache.thrift.protocol.TField O2_FIELD_DESC = new org.apache.thrift.protocol.TField(
            }
                        } else if (e instanceof org.apache.thrift.TApplicationException) {
            this();
        @Override
                }
            lastComparison = java.lang.Boolean.compare(isSetO1(), other.isSetO1());
            this.success = null;
         */
                        return DB_NAME;
            this.req = req;
            public static _Fields findByName(java.lang.String name) {
                } finally {
                        struct.o3 = new MetaException();
            org.apache.thrift.TBase<get_partitions_by_filter_result, get_partitions_by_filter_result._Fields>,
        public void send_get_partitions_by_filter(
                                    org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
                    return lastComparison;
                case MAX_PARTS:
            private static final java.util.Map<java.lang.String, _Fields> byName = new java.util.HashMap<java.lang.String, _Fields>();
                _Fields fields = findByThriftId(fieldId);
                case O4:
                                    org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
                if (this.max_parts != that.max_parts) return false;
            I,
                } finally {
                                    struct.o1.read(iprot);
                if (!this.success.equals(that.success)) return false;
                sb.append("null");
        public void create_table(Table tbl, org.apache.thrift.async.AsyncMethodCallback<Void> resultHandler)
            hashCode = hashCode * 8191 + max_parts;
                                }
        public java.lang.Object getFieldValue(_Fields field) {
            );
                        create_table_result result = new create_table_result();
                }
        private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct(
        public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
            if (!value) {
        }
                    return getDb_name();
            boolean that_present_o3 = true && that.isSetO3();
        private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new get_partitions_argsTupleSchemeFactory();
                );
                    java.util.BitSet incoming = iprot.readBitSet(4);
            public void write(org.apache.thrift.protocol.TProtocol oprot, create_database_result struct)
            return this;
                    result.o1 = o1;
                // it doesn't seem like you should have to do this, but java serialization is wacky, and doesn't call the default
            if (that instanceof add_partition_args) return this.equals((add_partition_args) that);
            }
                                    struct.setReqIsSet(true);
                    case 1: // O1
        }
                        }
                                if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {
        public void setMax_partsIsSet(boolean value) {
                    default:
            if (isSetO1()) {
                read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
                get_table_req_args args = new get_table_req_args();
                        unsetO2();
        public void unsetSuccess() {
                oprot.writeStructBegin(STRUCT_DESC);
                new org.apache.thrift.meta_data.FieldMetaData(
                                break;
                this.o2 = null;
                }
                )
                    public void onComplete(Partition o) {
                throw new java.io.IOException(te);
                }
            return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme())
                case DATABASE:
                        unsetO3();
            switch (field) {
        public java.lang.String toString() {
                    struct.validate();
            return this.success != null;
            if (lastComparison != 0) {
                            _LOGGER.error("TTransportException inside handler", e);
            }
            try {
                };
        private static class add_partition_argsStandardScheme extends org.apache.thrift.scheme.StandardScheme<add_partition_args> {
                        } else if (e instanceof InvalidObjectException) {
        private static class create_database_resultStandardScheme extends org.apache.thrift.scheme.StandardScheme<create_database_result> {
                try {
        @org.apache.thrift.annotation.Nullable
        private static final org.apache.thrift.protocol.TField NEW_PART_FIELD_DESC = new org.apache.thrift.protocol.TField(
            public static _Fields findByThriftId(int fieldId) {
            this.max_parts = 0;
                            msgType = org.apache.thrift.protocol.TMessageType.EXCEPTION;
                    struct.validate();
            get_partitions_call method_call = new get_partitions_call(
                        setSuccess((java.util.List<Partition>) value);
            org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(get_partitions_result.class, metaDataMap);
            public java.lang.String getFieldName() {
                    iprot.readStructEnd();
             * Find the _Fields constant that matches fieldId, throwing an exception
        private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
        }
                struct.validate();
        public get_table_req_args deepCopy() {
                                e.getMessage()
                        struct.setMax_partsIsSet(true);
        public boolean equals(java.lang.Object that) {
            @Override
        private static class create_database_argsTupleScheme extends org.apache.thrift.scheme.TupleScheme<create_database_args> {
        private static class get_partitions_by_filter_argsStandardScheme extends org.apache.thrift.scheme.StandardScheme<
        @Override
                case O3:
            return sb.toString();
             * Find the _Fields constant that matches fieldId, or null if its not found.
            throw new java.lang.IllegalStateException();
            this.o3 = o3;
            public void read(org.apache.thrift.protocol.TProtocol prot, get_partitions_by_filter_result struct)
                org.apache.thrift.protocol.TProtocol prot = client.getProtocolFactory().getProtocol(memoryTransport);
                    }
        public boolean isSetO4() {
            sb.append("o2:");
                    return lastComparison;
                }
            tmpMap.put(
                        try {
                    if (value == null) {
            }
        public void unsetDatabase() {
                    case 2: // O2
        public create_table_args deepCopy() {
        }
             */
            if (lastComparison != 0) {
                return false;
                            result.o3 = (MetaException) e;
                }
            org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(create_database_args.class, metaDataMap);
            new get_partitions_argsStandardSchemeFactory();
            if (this.filter == null) {
                            result.o2 = (NoSuchObjectException) e;
            return hashCode;
            public static _Fields findByThriftId(int fieldId) {
            }
        }
        @Override
        private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct(
        private static final org.apache.thrift.protocol.TField SUCCESS_FIELD_DESC = new org.apache.thrift.protocol.TField(
            boolean that_present_o1 = true && that.isSetO1();
        @org.apache.thrift.annotation.Nullable
            } catch (org.apache.thrift.TException te) {
                if (!this.o3.equals(that.o3)) return false;
            private GetTableRequest req;
        @Override
                struct.validate();
                return (new Client(prot)).recv_get_partitions();
            }
                if (struct.isSetO1()) {
            public Void getResult() throws AlreadyExistsException, InvalidObjectException, MetaException, NoSuchObjectException,
                throw new java.io.IOException(te);
            public Factory() {}
        public void setFieldValue(_Fields field, @org.apache.thrift.annotation.Nullable java.lang.Object value) {
                                    struct.setO2IsSet(true);
                )
            }
            return this;
        private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY =
        public void setFieldValue(_Fields field, @org.apache.thrift.annotation.Nullable java.lang.Object value) {
                    org.apache.thrift.TFieldRequirementType.DEFAULT,
            @org.apache.thrift.annotation.Nullable
        }
            }
                                    org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        public _Fields fieldForId(int fieldId) {
                            result.setO2IsSet(true);
                        org.apache.thrift.AsyncProcessFunction<
                                    struct.o4.read(iprot);
            public get_partitions_resultTupleScheme getScheme() {
        @Override
        public boolean equals(create_table_args that) {
                prot.writeMessageBegin(
             * if it is not found.
            public get_partitions_by_filter_resultStandardScheme getScheme() {
                this.o1 = new NoSuchObjectException(other.o1);
            @Override
                        struct.setNew_partIsSet(true);
                final org.apache.thrift.AsyncProcessFunction fcall = this;
        private static final int __MAX_PARTS_ISSET_ID = 0;
                    "max_parts",
        }
            }
                    {
            }
                        unsetO1();
                if (!this.o3.equals(that.o3)) return false;
            /**
            org.apache.thrift.transport.TNonblockingTransport transport
            switch (field) {
            org.apache.thrift.protocol.TType.STRUCT,
        }
                };
                : TUPLE_SCHEME_FACTORY).getScheme();
            @Override
        /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
                    new org.apache.thrift.protocol.TMessage("add_partition", org.apache.thrift.protocol.TMessageType.CALL, 0)
                                    struct.o1.read(iprot);
        public get_partitions_by_filter_result(java.util.List<Partition> success, MetaException o1, NoSuchObjectException o2) {
                        for (Partition _iter155 : struct.success) {
        }
        public add_partition_result(Partition success, InvalidObjectException o1, AlreadyExistsException o2, MetaException o3) {
                org.apache.thrift.async.AsyncMethodCallback<Void> resultHandler,
        public int getSuccessSize() {
                }
        @Override
        /** Returns true if field o2 is set (has been assigned a value) and false otherwise */
                            _LOGGER.error("Exception writing to internal frame buffer", e);
        }
        }
            (short) 1
        }
                return new create_database_resultTupleScheme();
                        iprot.readFieldEnd();
             */
                }
        @Override
        private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("get_partitions_args");
                oprot.writeStructBegin(STRUCT_DESC);
            }
            return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme())
        public void setO2IsSet(boolean value) {
             * if it is not found.
        }
            }
        public void unsetO1() {
            }
                return byName.get(name);
        }
                prot.writeMessageEnd();
            _Fields(short thriftId, java.lang.String fieldName) {
            if (this.o3 == null) {
            get_table_req_args,
        }
            if (this.db_name == null) {
            }
            first = false;
                    oprot.writeFieldBegin(SUCCESS_FIELD_DESC);
                if (!this.req.equals(that.req)) return false;
                throws org.apache.thrift.TException {
            }
            if (isSetNew_part()) {
            "o1",
                for (_Fields field : java.util.EnumSet.allOf(_Fields.class)) {
                if (struct.req != null) {
                oprot.writeFieldStop();
            if (result.o2 != null) {
                    if (value == null) {
            public add_partition_result getEmptyResultInstance() {
        }
            }
            if (this.o2 == null) {
        public @org.apache.thrift.annotation.Nullable MetaException o3; // required
                prot.incrementRecursionDepth();
            public create_database_resultStandardScheme getScheme() {
            }
            }
                sb.append("null");
                            result.o3 = (MetaException) e;
        public Table getTbl() {
            } catch (org.apache.thrift.TException te) {
                throws org.apache.thrift.TException {
        @Override
                case O2:
                        } else {
                if (struct.isSetTbl()) {
            throws NoSuchObjectException, MetaException, org.apache.thrift.TException {
                }
            @Override
            return this.o1;
                if (!(this_present_o1 && that_present_o1)) return false;
                return fields;
 * Autogenerated by Thrift Compiler (0.23.0)
            }
                                    struct.setMax_partsIsSet(true);
        @org.apache.thrift.annotation.Nullable
                    org.apache.thrift.TFieldRequirementType.DEFAULT,
                    iface.create_table(args.tbl);
            metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
         * Performs a deep copy on <i>other</i>.
                                } else {
            if (lastComparison != 0) {
                return _thriftId;
 *  @generated
            }
                    iprot.decrementRecursionDepth();
            Comparable<get_table_req_result> {
                    struct.validate();
                java.util.BitSet optionals = new java.util.BitSet();
            this();
        }
            }
        }
            if (!first) sb.append(", ");
                            msg = result;
            ) {
                    oprot.writeFieldBegin(TBL_NAME_FIELD_DESC);
        public void setFieldValue(_Fields field, @org.apache.thrift.annotation.Nullable java.lang.Object value) {
                    default:
            return true;
                if (!this.new_part.equals(that.new_part)) return false;
        @Override
                this.o2 = new AlreadyExistsException(other.o2);
            tmpMap.put(
            }
            "o2",
            if (this.o1 == null) {
                        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) {
            }
        @org.apache.thrift.annotation.Nullable
            java.io.Serializable,
                sb.append("null");
                    oprot.writeFieldEnd();
        public static class create_database<I extends AsyncIface> extends org.apache.thrift.AsyncProcessFunction<
            hashCode = hashCode * 8191 + ((isSetTbl()) ? 131071 : 524287);
            }
        public boolean isSet(_Fields field) {
            public add_partition_argsStandardScheme getScheme() {
            boolean this_present_max_parts = true;
                    oprot.writeI16(struct.max_parts);
        private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY =
                // it doesn't seem like you should have to do this, but java serialization is wacky, and doesn't call the default
            }
        public GetTableResult recv_get_table_req() throws MetaException, NoSuchObjectException, org.apache.thrift.TException {
                oprot.writeBitSet(optionals, 3);
                create_database_result result = getEmptyResultInstance();
                    {
                if (!this.o2.equals(that.o2)) return false;
                    return lastComparison;
            ___manager.call(method_call);
            create_table_call method_call = new create_table_call(tbl, resultHandler, this, ___protocolFactory, ___transport);
            public boolean isOneway() {
            }
                                if (schemeField.type == org.apache.thrift.protocol.TType.I16) {
                        return O2;
            java.io.Serializable,
            @Override
            return this.o1;
        public boolean equals(java.lang.Object that) {
        }
            if (that == null) return false;
                )
                            fb.close();
        }
        }
            public static _Fields findByName(java.lang.String name) {
        @Override
                throw result.o1;
            public void read(org.apache.thrift.protocol.TProtocol prot, create_table_args struct) throws org.apache.thrift.TException {
            @Override
            tmpMap.put(
                        }
                        setSuccess((Partition) value);
            "new_part",
                    return isSetO1();
             * Find the _Fields constant that matches fieldId, throwing an exception
                        org.apache.thrift.TSerializable msg;
                            _LOGGER.error("Exception writing to internal frame buffer", ex);
            (short) 1
        }
            @Override
                                e.getMessage()
                }
                    optionals.set(2);
                return lastComparison;
            if (isSetO1()) {
                            fb.close();
                    break;
                            case 2: // O2
            return this.new_part != null;
            org.apache.thrift.async.AsyncMethodCallback<java.util.List<Partition>> resultHandler
                            new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, struct.success.size())
        }
                }
                        unsetO2();
                case DB_NAME:
            if (that instanceof create_table_result) return this.equals((create_table_result) that);
            return hashCode;
            return this.o2 != null;
                return new get_partitions_by_filter_args();
                    @Override
                oprot.writeBitSet(optionals, 4);
    }
                struct.validate();
            public static _Fields findByThriftIdOrThrow(int fieldId) {
                    }
        }
                    org.apache.thrift.TFieldRequirementType.DEFAULT,
                return fields;
                } finally {
            if (isSetReq()) {
                            return;
                        try {
            if (this_present_o1 || that_present_o1) {
                return lastComparison;
            this.success = null;
                    org.apache.thrift.TFieldRequirementType.DEFAULT,
            }
        public java.util.List<Partition> get_partitions(java.lang.String db_name, java.lang.String tbl_name, short max_parts)
            first = false;
            if (result.o2 != null) {
            this.o1 = o1;
        public void setO2IsSet(boolean value) {
                                } else {
                this.o3 = null;
                    public void onError(java.lang.Exception e) {
            I,
                        unsetO2();
            }
            boolean this_present_o1 = true && this.isSetO1();
            (short) 0
        public void unsetO3() {
                return fields;
                }
            public static _Fields findByThriftIdOrThrow(int fieldId) {
        /** Returns true if field success is set (has been assigned a value) and false otherwise */
                        } else {
        public void setFilterIsSet(boolean value) {
                            _LOGGER.error("TApplicationException inside handler", e);
    public static class get_table_req_args
                this.db_name = other.db_name;
        @org.apache.thrift.annotation.Nullable
        public get_partitions_by_filter_args(get_partitions_by_filter_args other) {
        private static class create_database_argsStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
            if (!value) {
                get_partitions_args args = new get_partitions_args();
                                break;
        }
            return this.filter != null;
            "o2",
                    // check for required fields of primitive type, which can't be checked in the validate method
                    return lastComparison;
                                    struct.o2 = new NoSuchObjectException();
                    new org.apache.thrift.protocol.TMessage("create_table", org.apache.thrift.protocol.TMessageType.CALL, 0)
                return lastComparison;
        public void clear() {
            hashCode = hashCode * 8191 + ((isSetDb_name()) ? 131071 : 524287);
                                }
                    if (incoming.get(0)) {
        }
            @Override
             * if it is not found.
            }
                }
            int hashCode = 1;
            @Override
        }
                        schemeField = iprot.readFieldBegin();
                    byName.put(field.getFieldName(), field);
                struct.validate();
            return _Fields.findByThriftId(fieldId);
            if (!value) {
                    if (value == null) {
                            default:
            this.database = database;
        }
        public create_database_args deepCopy() {
                I iface,
        @Override
            @Override
                    }
        public void unsetDb_name() {
        public boolean equals(java.lang.Object that) {
                                org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
                            msg = result;
        static {
            Cloneable,
            if (this == that) return true;
                    optionals.set(0);
                org.apache.thrift.transport.TMemoryInputTransport memoryTransport = new org.apache.thrift.transport.TMemoryInputTransport(
    public static class Processor<I extends Iface> extends org.apache.thrift.TBaseProcessor<I> implements org.apache.thrift.TProcessor {
                this.db_name = other.db_name;
                    byName.put(field.getFieldName(), field);
            return recv_get_table_req();
                if (struct.isSetFilter()) {
            public void read(org.apache.thrift.protocol.TProtocol iprot, create_table_result struct) throws org.apache.thrift.TException {
                    return getSuccess();
            org.apache.thrift.protocol.TType.STRUCT,
            return this.o1;
            }
                    // check for required fields of primitive type, which can't be checked in the validate method
            public create_table() {
        public boolean isSetO1() {
                        unsetO2();
                        } catch (java.lang.Exception e) {
            } catch (org.apache.thrift.TException te) {
            }
        public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
        public void unsetMax_parts() {
                                org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        }
        }
            this.new_part = null;
            return this.o2;
        @Override
                        struct.success = new Partition();
             * Find the _Fields constant that matches name, or null if its not found.
            if (!value) {
            }
                        switch (schemeField.id) {
                                } else {
                org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
        }
                    new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, GetTableRequest.class)
        public java.lang.Object getFieldValue(_Fields field) {
                oprot.writeStructEnd();
            }
            public void write(org.apache.thrift.protocol.TProtocol prot, get_partitions_args struct) throws org.apache.thrift.TException {
            }
            scheme(oprot).write(oprot, this);
                try {
            }
                sb.append(this.o1);
                }
                                    struct.req = new GetTableRequest();
                    return lastComparison;
        public @org.apache.thrift.annotation.Nullable java.util.List<Partition> success; // required
            }
            }
         */
                get_partitions_result result = getEmptyResultInstance();
                this.db_name = null;
        public boolean equals(create_database_args that) {
        private static final org.apache.thrift.protocol.TField TBL_NAME_FIELD_DESC = new org.apache.thrift.protocol.TField(
            if (this_present_database || that_present_database) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder("create_table_args(");
                }
                                break;
            }
            first = false;
            }
                throw new java.io.IOException(te);
                if (struct.isSetO1()) {
        }
                            msg = (org.apache.thrift.TApplicationException) e;
    }
            }
                return _fieldName;
            if (!value) {
        }
        @Override
            this.o4 = null;
            public add_partition_args getEmptyArgsInstance() {
                        iprot.readFieldEnd();
        public MetaException getO1() {
                    org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
                                    struct.setO2IsSet(true);
                    ?,
                }
        @Override
            }
                    prot.decrementRecursionDepth();
            // check for required fields
                                e.getMessage()
                if (struct.tbl_name != null) {
             * Find the _Fields constant that matches fieldId, or null if its not found.
                    result.o3 = o3;
            add_partition_result result = new add_partition_result();
        public @org.apache.thrift.annotation.Nullable MetaException o3; // required
            );
        public enum _Fields implements org.apache.thrift.TFieldIdEnum {
                                break;
        private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new create_table_argsTupleSchemeFactory();
                    } else {
        private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
            }
            }
        public int compareTo(add_partition_result other) {
            if (lastComparison != 0) {
                sb.append("null");
            return;
                                    struct.setNew_partIsSet(true);
            }
                    result.success = iface.get_table_req(args.req);
                            _LOGGER.error("TTransportException inside handler", e);
            );
        }
            public org.apache.thrift.async.AsyncMethodCallback<GetTableResult> getResultHandler(
        public GetTableRequest getReq() {
        public add_partition_result setO1(@org.apache.thrift.annotation.Nullable InvalidObjectException o1) {
        private static final org.apache.thrift.protocol.TField O3_FIELD_DESC = new org.apache.thrift.protocol.TField(
            get_table_req_args,
                    } else {
        );
                    "tbl",
        }
            }
                    iprot.readStructEnd();
        }
            this.o3 = o3;
                                if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {
            // check for sub-struct validity
        }
                    return lastComparison;
                _Fields fields = findByThriftId(fieldId);
                            ? extends org.apache.thrift.TBase,
            }
                if (struct.isSetO1()) {
                };
                java.util.BitSet optionals = new java.util.BitSet();
            processMap.put("get_partitions_by_filter", new get_partitions_by_filter());
            if (!getClass().equals(other.getClass())) {
                    struct.validate();
                }
                )
        @Override
            return this.o1;
            throw new java.lang.IllegalStateException();
                sb.append(this.o1);
                    } else {
                throws org.apache.thrift.TException {
                                    struct.req.read(iprot);
            this.tbl_name = null;
            this.database = database;
        }
        /** Returns true if field tbl_name is set (has been assigned a value) and false otherwise */
                        struct.setO2IsSet(true);
        public void clear() {
        @Override
                case O2:
            first = false;
            if (!first) sb.append(", ");
        @Override
            );
        }
        public _Fields fieldForId(int fieldId) {
            boolean that_present_o1 = true && that.isSetO1();
            // check for required fields
                        setMax_parts((java.lang.Short) value);
                            struct.success = new java.util.ArrayList<Partition>(_list165.size);
            }
                return null;
            try {
                }
            return 0;
                case O1:
            } else {
                    result.o4 = o4;
                write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
                    }
        /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
            if (result.o1 != null) {
                            case 1: // O1
                    break;
                        unsetO1();
            @Override
            Partition,
            }
            }
                        }
                return byName.get(name);
            if (!value) {
            if (that instanceof create_table_args) return this.equals((create_table_args) that);
                this.o3 = new MetaException(other.o3);
            );
                            break;
        }
                        } else if (e instanceof org.apache.thrift.transport.TTransportException) {
                        for (Partition _iter156 : struct.success) {
            args.setDb_name(db_name);
            public void write(org.apache.thrift.protocol.TProtocol oprot, get_partitions_result struct)
            java.io.Serializable,
                    case 1: // O1
         * Performs a deep copy on <i>other</i>.
                                    struct.setO2IsSet(true);
                    if (incoming.get(1)) {
            } else {
        @Override
        }
                                } else {
        }
                    }
            }
                            case 2: // O2
                    org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
        }
        public int compareTo(create_table_result other) {
                super("create_database");
                java.util.BitSet optionals = new java.util.BitSet();
        }
    @SuppressWarnings({ "cast", "rawtypes", "serial", "unchecked", "unused" })
            @Override
                        schemeField = iprot.readFieldBegin();
        }
    public static class get_partitions_result
                if (lastComparison != 0) {
                prot.writeMessageBegin(
                }
                                            _elem153.read(iprot);
                            _iter155.write(oprot);
                    }
                    oprot.writeFieldBegin(TBL_FIELD_DESC);
        }
                                org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
                }
                try {
                return lastComparison;
                this.database = database;
            switch (field) {
            }
            }
        /** Returns true if field o1 is set (has been assigned a value) and false otherwise */
            if (isSetO2()) hashCode = hashCode * 8191 + o2.hashCode();
                if (struct.isSetO1()) {
            boolean first = true;
            }
                                    org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
        public get_table_req_args(GetTableRequest req) {
            }
        private static final org.apache.thrift.protocol.TField O2_FIELD_DESC = new org.apache.thrift.protocol.TField(
                sb.append(this.o2);
            this.o2 = null;
            }
 *
            Comparable<get_partitions_by_filter_args> {
                        struct.setTblIsSet(true);
            if (!value) {
                super("get_table_req");
            private static final java.util.Map<java.lang.String, _Fields> byName = new java.util.HashMap<java.lang.String, _Fields>();
        private static class get_table_req_argsTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
                    if (value == null) {
                if (!(this_present_o2 && that_present_o2)) return false;
            if (field == null) {
            if (!value) {
        public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
            }
            public boolean isOneway() {
        }
        }
                    struct.o4.write(oprot);
                if (fields == null) throw new java.lang.IllegalArgumentException("Field " + fieldId + " doesn't exist!");
            get_partitions_by_filter_args> {
                    byName.put(field.getFieldName(), field);
                        }
                                } else {
        }
            if (this_present_db_name || that_present_db_name) {
                }
                            msg = result;
                _Fields.DB_NAME,
                )
            public boolean isOneway() {
            throws org.apache.thrift.TException;
                    case 4: // O4
                if (struct.isSetMax_parts()) {
                case REQ:
                        org.apache.thrift.TSerializable msg;
                    throw new java.lang.IllegalStateException("Method call not finished!");
                }
                short max_parts,
            org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(create_table_args.class, metaDataMap);
                try {
                if (getState() != org.apache.thrift.async.TAsyncMethodCall.State.RESPONSE_READ) {
        private static final org.apache.thrift.protocol.TField O1_FIELD_DESC = new org.apache.thrift.protocol.TField(
            }
        private static class add_partition_argsStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
            org.apache.thrift.TBase<get_table_req_args, get_table_req_args._Fields>,
        public @org.apache.thrift.annotation.Nullable MetaException o3; // required
        }
            if (lastComparison != 0) {
        @Override
        private static <
                new org.apache.thrift.meta_data.FieldMetaData(
            }
            return true;
             * Find the _Fields constant that matches fieldId, or null if its not found.
                        struct.o2 = new InvalidObjectException();
                    result.o3 = o3;
            org.apache.thrift.async.AsyncMethodCallback<java.util.List<Partition>> resultHandler
                if (struct.success != null) {
                        struct.setO2IsSet(true);
        private static class add_partition_argsTupleScheme extends org.apache.thrift.scheme.TupleScheme<add_partition_args> {
        @Override
                                if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {
            public create_table_argsTupleScheme getScheme() {
            }
            public org.apache.thrift.async.AsyncMethodCallback<java.util.List<Partition>> getResultHandler(
                _thriftId = thriftId;
            @Override
                    if (value == null) {
                } finally {
                        }
                }
                if (lastComparison != 0) {
            public static _Fields findByThriftId(int fieldId) {
                org.apache.thrift.protocol.TProtocol prot = client.getProtocolFactory().getProtocol(memoryTransport);
                } finally {
                lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.max_parts, other.max_parts);
                    optionals.set(0);
            @org.apache.thrift.annotation.Nullable
            public void write(org.apache.thrift.protocol.TProtocol oprot, add_partition_result struct) throws org.apache.thrift.TException {
            this.o3 = o3;
        }
                return new org.apache.thrift.async.AsyncMethodCallback<Void>() {
                            );
            }
            @Override
            java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<
                    org.apache.thrift.protocol.TField schemeField;
                org.apache.thrift.async.AsyncMethodCallback<java.util.List<Partition>> resultHandler,
                case O2:
            add_partition_args,
        public boolean equals(get_partitions_args that) {
            }
             */
            // check for required fields
            processMap.put("get_partitions_by_filter", new get_partitions_by_filter());
                return null;
                if (fields == null) throw new java.lang.IllegalArgumentException("Field " + fieldId + " doesn't exist!");
            }
        ) throws MetaException, NoSuchObjectException, org.apache.thrift.TException;
            static {
        private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new get_table_req_argsTupleSchemeFactory();
            java.io.Serializable,
                        struct.max_parts = iprot.readI16();
            return false;
            if (isSetO2()) hashCode = hashCode * 8191 + o2.hashCode();
                                    struct.o2 = new InvalidObjectException();
        }
                    return isSetTbl_name();
            if (!value) {
        public boolean isSetMax_parts() {
        }
                args.setTbl_name(tbl_name);
            } else {
        }
                }
                }
            }
                            result.setO2IsSet(true);
                        } else if (e instanceof NoSuchObjectException) {
                throws org.apache.thrift.TException {
        @Override
                            msg = (org.apache.thrift.TApplicationException) e;
                throw result.o2;
        public get_partitions_result(java.util.List<Partition> success, NoSuchObjectException o1, MetaException o2) {
                if (!(this_present_o2 && that_present_o2)) return false;
            send_get_partitions_by_filter(db_name, tbl_name, filter, max_parts);
        private static final org.apache.thrift.protocol.TField O3_FIELD_DESC = new org.apache.thrift.protocol.TField(
            java.io.Serializable,
                case DB_NAME:
        }
            org.apache.thrift.TBase<add_partition_result, add_partition_result._Fields>,
        @Override
                        struct.new_part = new Partition();
            }
            throw new java.lang.IllegalStateException();
                    optionals.set(1);
                            fcall.sendResponse(fb, result, org.apache.thrift.protocol.TMessageType.REPLY, seqid);
        public void setTblIsSet(boolean value) {
            add_partition_args args = new add_partition_args();
                    }
            if (this_present_success || that_present_success) {
            if (that == null) return false;
            Comparable<create_database_result> {
        }
                        try {
                prot.incrementRecursionDepth();
                return new get_partitions_by_filter_result();
                    default:
            }
            private static final java.util.Map<java.lang.String, _Fields> byName = new java.util.HashMap<java.lang.String, _Fields>();
                    // check for required fields of primitive type, which can't be checked in the validate method
            }
                super(client, protocolFactory, transport, resultHandler, false);
            }
            @Override
        public short max_parts; // required
            }
        @org.apache.thrift.annotation.Nullable
                    // check for required fields of primitive type, which can't be checked in the validate method
            scheme(iprot).read(iprot, this);
                            ? extends org.apache.thrift.TBase>>()
                return (new Client(prot)).recv_add_partition();
            if (this == that) return true;
                this.o2 = null;
                                _elem166 = new Partition();
        }
                        iprot.readFieldEnd();
        }
                                }
                    iprot.readStructEnd();
        }
                        }
            }
            if (lastComparison != 0) {
        public get_partitions_result setO2(@org.apache.thrift.annotation.Nullable MetaException o2) {
        @org.apache.thrift.annotation.Nullable
        @org.apache.thrift.annotation.Nullable
                throws org.apache.thrift.TException {
            throws org.apache.thrift.TException {
                    throw new java.lang.IllegalStateException("Method call not finished!");
                _fieldName = fieldName;
            }
            if (!getClass().equals(other.getClass())) {
                }
            switch (field) {
            return this.tbl != null;
                    }
        public void validate() throws org.apache.thrift.TException {
            org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(add_partition_result.class, metaDataMap);
        @Override
                    org.apache.thrift.protocol.TField schemeField;
        }
        );
                            Partition _elem158;
        public java.util.List<Partition> getSuccess() {
                this.o2 = new InvalidObjectException(other.o2);
                    if (incoming.get(0)) {
/**
            boolean that_present_filter = true && that.isSetFilter();
            }
                return lastComparison;
                }
            sb.append(")");
                if (struct.isSetTbl_name()) {
            if (other.isSetO2()) {
            if (that instanceof get_partitions_result) return this.equals((get_partitions_result) that);
            }
                lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.o1, other.o1);
        implements
                                            _elem153 = new Partition();
            boolean this_present_new_part = true && this.isSetNew_part();
                    struct.o2.write(oprot);
        }
                    oprot.writeFieldBegin(O2_FIELD_DESC);
        public create_table_result setO1(@org.apache.thrift.annotation.Nullable AlreadyExistsException o1) {
                return byName.get(name);
            return (this.success == null) ? 0 : this.success.size();
        }
                                        iprot.readListEnd();
                    }
            }
        );
            this.tbl_name = tbl_name;
                    if (incoming.get(0)) {
                    return getTbl();
            );
                    return isSetO4();
            @Override
                org.apache.thrift.async.AsyncMethodCallback<java.util.List<Partition>> resultHandler
            if (isSetO1()) {
                lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.o3, other.o3);
                    throw new java.lang.IllegalStateException("Method call not finished!");
            }
                            fcall.sendResponse(fb, msg, msgType, seqid);
             * Find the _Fields constant that matches fieldId, throwing an exception
        /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
            }
                            msg = new org.apache.thrift.TApplicationException(
                oprot.writeFieldStop();
        public static class create_table<I extends AsyncIface> extends org.apache.thrift.AsyncProcessFunction<
        }
            return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme())
            }
            }
            if (!value) {
                _Fields,
                    new org.apache.thrift.protocol.TMessage("get_table_req", org.apache.thrift.protocol.TMessageType.CALL, 0)
                if (fields == null) throw new java.lang.IllegalArgumentException("Field " + fieldId + " doesn't exist!");
                    oprot.writeFieldEnd();
        }
            O1((short) 1, "o1"),
                    struct.validate();
            }
        }
                iface.get_partitions(args.db_name, args.tbl_name, args.max_parts, resultHandler);
            Cloneable,
                if (!(this_present_success && that_present_success)) return false;
            @Override
        public boolean isSetO3() {
                } finally {
                this.tbl = null;
                            msgType = org.apache.thrift.protocol.TMessageType.EXCEPTION;
        @Override
                        switch (schemeField.id) {
                    org.apache.thrift.TFieldRequirementType.DEFAULT,
    @SuppressWarnings({ "cast", "rawtypes", "serial", "unchecked", "unused" })
                            _LOGGER.error("Exception inside handler", e);
                    return isSetReq();
    }
        }
                }
            }
                if (!(this_present_o2 && that_present_o2)) return false;
            return this;
        private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
                java.util.BitSet optionals = new java.util.BitSet();
                            fcall.sendResponse(fb, msg, msgType, seqid);
                    return lastComparison;
                }
        private static class get_partitions_by_filter_resultStandardScheme extends org.apache.thrift.scheme.StandardScheme<
                java.util.BitSet optionals = new java.util.BitSet();
                    java.util.BitSet incoming = iprot.readBitSet(1);
                );
                args.setTbl(tbl);
            if (that instanceof get_table_req_result) return this.equals((get_table_req_result) that);
            if (this_present_tbl_name || that_present_tbl_name) {
                org.apache.thrift.protocol.TProtocol prot = client.getProtocolFactory().getProtocol(memoryTransport);
            _Fields(short thriftId, java.lang.String fieldName) {
    public static class AsyncProcessor<I extends AsyncIface> extends org.apache.thrift.TBaseAsyncProcessor<I> {
                }
                            _LOGGER.error("Exception writing to internal frame buffer", ex);
                    org.apache.thrift.protocol.TField schemeField;
                    if (value == null) {
                if (!this.o4.equals(that.o4)) return false;
            }
            java.io.Serializable,
        private static class add_partition_resultStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
                throw new java.io.IOException(te);
            }
        public boolean isSetO1() {
            }
        }
                }
                new org.apache.thrift.meta_data.FieldMetaData(
                    if (incoming.get(0)) {
                    struct.o2.write(oprot);
                                    struct.o2.read(iprot);
        }
        }
             */
            if (result.o1 != null) {
            sb.append("o1:");
            MAX_PARTS((short) 3, "max_parts");
        public enum _Fields implements org.apache.thrift.TFieldIdEnum {
                case O2:
                }
        @Override
            }
            }
            org.apache.thrift.TException;
                                    struct.o4 = new NoSuchObjectException();
                    new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)
                try {
            if (success != null) {
            public Client getClient(org.apache.thrift.protocol.TProtocol prot) {
                                            _elem161.read(iprot);
            if (this.req == null) {
            (short) 2
            "max_parts",
                    struct.o4.write(oprot);
                this.success = new java.util.ArrayList<Partition>();
            switch (field) {
            if (isSetSuccess()) {
        @Override
            }
            scheme(iprot).read(iprot, this);
                lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.o3, other.o3);
        public java.lang.Object getFieldValue(_Fields field) {
        public void clear() {
                    }
        @Override
                            case 1: // DB_NAME
            this.o1 = o1;
                }
                    return isSetSuccess();
                if (!(this_present_o1 && that_present_o1)) return false;
            }
            if (that == null) return false;
            }
        }
                    return isSetO3();
                            _LOGGER.error("Exception writing to internal frame buffer", ex);
        public enum _Fields implements org.apache.thrift.TFieldIdEnum {
        }
            public get_partitions() {
            create_table_args,
        public static class add_partition<I extends Iface> extends org.apache.thrift.ProcessFunction<
                    case 0: // SUCCESS
            if (isSetMax_parts()) {
            return 0;
            hashCode = hashCode * 8191 + ((isSetSuccess()) ? 131071 : 524287);
                    new java.util.HashMap<
        public void validate() throws org.apache.thrift.TException {
                        setO2((NoSuchObjectException) value);
            public void write(org.apache.thrift.protocol.TProtocol oprot, add_partition_args struct) throws org.apache.thrift.TException {
            org.apache.thrift.TException {
    }
                _Fields,
                )
                    struct.validate();
                                } else {
        public MetaException getO1() {
                    org.apache.thrift.TFieldRequirementType.DEFAULT,
        private static class get_table_req_resultStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
                        try {
                    struct.o3.write(oprot);
            I,
            java.lang.StringBuilder sb = new java.lang.StringBuilder("get_partitions_by_filter_args(");
        @org.apache.thrift.annotation.Nullable
            public create_table_result getEmptyResultInstance() {
                    oprot.writeFieldBegin(O1_FIELD_DESC);
                this.o3 = new MetaException(other.o3);
        }
                        return null;
        public void setFieldValue(_Fields field, @org.apache.thrift.annotation.Nullable java.lang.Object value) {
            int lastComparison = 0;
                } catch (MetaException o3) {
            }
            public create_database_argsTupleScheme getScheme() {
            }
                iprot.incrementRecursionDepth();
                sb.append(this.filter);
                } finally {
        }
            }
                }
            }
            this.o2 = o2;
                switch (fieldId) {
                org.apache.thrift.async.AsyncMethodCallback<java.util.List<Partition>> resultHandler
            public create_database_result getResult(I iface, create_database_args args) throws org.apache.thrift.TException {
        }
                        try {
            }
        private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new create_database_argsTupleSchemeFactory();
        public void get_table_req(GetTableRequest req, org.apache.thrift.async.AsyncMethodCallback<GetTableResult> resultHandler)
            if (isSetO3()) hashCode = hashCode * 8191 + o3.hashCode();
        }
    @SuppressWarnings({ "cast", "rawtypes", "serial", "unchecked", "unused" })
            );
                _thriftId = thriftId;
                return result.success;
                    org.apache.thrift.protocol.TField schemeField;
            public create_database() {
        private static class add_partition_resultStandardScheme extends org.apache.thrift.scheme.StandardScheme<add_partition_result> {
                }
        }
        /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
            }
                    return getO2();
                }
                            default:
            first = false;
            org.apache.thrift.protocol.TType.STRUCT,
         * Performs a deep copy on <i>other</i>.
        }
        /**
                    if (value == null) {
        public java.util.List<Partition> recv_get_partitions_by_filter() throws MetaException, NoSuchObjectException,
            }
            }
            }
            throw new java.lang.IllegalStateException();
                                    org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            SUCCESS((short) 0, "success"),
            @Override
                        schemeField = iprot.readFieldBegin();
                    case 1: // DATABASE
        }
                    getFrameBuffer().array()
                return new get_partitions_result();
                        return TBL;
            }
        private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
            return recv_add_partition();
            boolean this_present_o2 = true && this.isSetO2();
                new org.apache.thrift.meta_data.FieldMetaData(
        /**
            public boolean isOneway() {
            throw new java.lang.IllegalStateException();
            }
            "create_database_args"
            ___manager.call(method_call);
            }
        /** Returns true if field success is set (has been assigned a value) and false otherwise */
            boolean first = true;
                    ? extends org.apache.thrift.TBase,
        private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
            @org.apache.thrift.annotation.Nullable
                lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.o2, other.o2);
            Cloneable,
                        return null;
            int lastComparison = 0;
                        struct.success.read(iprot);
        public MetaException getO3() {
        public create_table_result(create_table_result other) {
                        if (e instanceof InvalidObjectException) {
            private final short _thriftId;
                }
                _fieldName = fieldName;
    }
        }
        private byte __isset_bitfield = 0;
            int hashCode = 1;
        @org.apache.thrift.annotation.Nullable
        // isset id assignments
                _Fields.O3,
                    }
        }
            new create_database_argsStandardSchemeFactory();
        }
        }
                        } else if (e instanceof MetaException) {
            if (isSetDb_name()) {
                        struct.o1 = new InvalidObjectException();
                        org.apache.thrift.protocol.TType.LIST,
            }
                                if (schemeField.type == org.apache.thrift.protocol.TType.LIST) {
            }
                        }
            public void read(org.apache.thrift.protocol.TProtocol prot, get_partitions_by_filter_args struct)
                throw result.o1;
            boolean this_present_success = true && this.isSetSuccess();
            this.tbl_name = null;
            checkReady();
                }
                }
                java.util.List<Partition> __this__success = new java.util.ArrayList<Partition>(other.success.size());
                        }
                        struct.o1.read(iprot);
                    struct.tbl.write(oprot);
        }
                        ?,
            @Override
                final org.apache.thrift.AsyncProcessFunction fcall = this;
        public get_partitions_by_filter_args setDb_name(@org.apache.thrift.annotation.Nullable java.lang.String db_name) {
            if (this.o3 == null) {
                        struct.o3.read(iprot);
                if (lastComparison != 0) {
        private static final org.apache.thrift.protocol.TField O1_FIELD_DESC = new org.apache.thrift.protocol.TField(
                    oprot.writeFieldEnd();
            }
                prot.incrementRecursionDepth();
        public boolean isSetTbl_name() {
            O2((short) 2, "o2"),
                args.write(prot);
                case NEW_PART:
                            result.setO3IsSet(true);
            boolean this_present_o2 = true && this.isSetO2();
                                if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {
                if (lastComparison != 0) {
                sb.append("null");
             */
            public create_table_result getResult(I iface, create_table_args args) throws org.apache.thrift.TException {
        /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
        public java.lang.String getTbl_name() {
            @Override
        public GetTableResult get_table_req(GetTableRequest req) throws MetaException, NoSuchObjectException, org.apache.thrift.TException;
            return this.tbl;
                    }
                                    struct.success = new GetTableResult();
        private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, java.lang.ClassNotFoundException {
                create_table_args args = new create_table_args();
            tmpMap.put(
                    java.util.BitSet incoming = iprot.readBitSet(3);
        public boolean isSetO2() {
                    struct.o1.write(oprot);
                    if (incoming.get(0)) {
            @Override
            if (other.isSetDb_name()) {
            if (lastComparison != 0) {
                this.o1 = null;
                            result.setO1IsSet(true);
                case O1:
                        struct.o3 = new MetaException();
            if (lastComparison != 0) {
            }
            send_get_partitions(db_name, tbl_name, max_parts);
                    oprot.writeFieldEnd();
            return sb.toString();
                        switch (schemeField.id) {
            return 0;
            return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme())
                            _LOGGER.error("Exception inside handler", e);
                oprot.writeFieldStop();
                        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) {
                        struct.setMax_partsIsSet(true);
        @Override
                for (_Fields field : java.util.EnumSet.allOf(_Fields.class)) {
        public int compareTo(create_database_args other) {
        }
                            @org.apache.thrift.annotation.Nullable
        public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
            org.apache.thrift.protocol.TType.STRING,
            sb.append("tbl_name:");
                        unsetO4();
            return hashCode;
        public _Fields fieldForId(int fieldId) {
                    return isSetMax_parts();
                    "filter",
        public create_database_result(AlreadyExistsException o1, InvalidObjectException o2, MetaException o3) {
                        unsetSuccess();
                oprot.writeBitSet(optionals, 4);
            if (result.o3 != null) {
            return this.success != null;
                if (struct.isSetO1()) {
            } else {
                    return isSetDb_name();
            }
            }
                sb.append(this.success);
            if (this == that) return true;
            sb.append("filter:");
                return _fieldName;
                case O1:
            boolean that_present_success = true && that.isSetSuccess();
                new org.apache.thrift.meta_data.FieldMetaData(
        }
            }
            try {
                    return isSetTbl();
            if (this_present_tbl || that_present_tbl) {
        /**
                            _LOGGER.error("TTransportException writing to internal frame buffer", e);
        }
                    optionals.set(2);
        }
                    iprot.readStructBegin();
                                    struct.setO1IsSet(true);
                        org.apache.thrift.TSerializable msg;
            if (this == that) return true;
            if (other.isSetDatabase()) {
            }
                                } else {
            try {
            return sb.toString();
            @Override
            return this.o2 != null;
        @Override
            (short) 1
        }
                // constructor.
                    return isSetSuccess();
        }
                lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.success, other.success);
                } finally {
        @org.apache.thrift.annotation.Nullable
            return 0;
                            break;
            this.tbl_name = tbl_name;
        }
            @Override
                    }
            }
            );
            static {
            @Override
                _Fields.O2,
        }
            this.new_part = null;
        }
            // check for sub-struct validity
                    return lastComparison;
                return new org.apache.thrift.async.AsyncMethodCallback<GetTableResult>() {
            boolean this_present_o1 = true && this.isSetO1();
            }
                        struct.max_parts = iprot.readI16();
                write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
            java.util.List<Partition>,
            public short getThriftFieldId() {
            /**
                    optionals.set(0);
        }
                oprot.writeI16(struct.max_parts);
                    "success",
                        return O1;
            this.o2 = null;
                }
                return new get_partitions_by_filter_argsStandardScheme();
            }
                return _thriftId;
             */
            }
                    org.apache.thrift.TFieldRequirementType.DEFAULT,
            boolean this_present_tbl_name = true && this.isSetTbl_name();
                        struct.setO1IsSet(true);
            private Table tbl;
                                    }
            }
                org.apache.thrift.transport.TNonblockingTransport transport
            if (that instanceof create_database_result) return this.equals((create_database_result) that);
            if (lastComparison != 0) {
                if (!this.o2.equals(that.o2)) return false;
             */
                if (struct.isSetDb_name()) {
        private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, java.lang.ClassNotFoundException {
                _Fields fields = findByThriftId(fieldId);
            java.lang.String filter,
        }
            }
        }
            return sb.toString();
                return lastComparison;
        static {
            this.success = success;
        }
        }
                throw new java.io.IOException(te);
            throw new java.lang.IllegalStateException();
        @org.apache.thrift.annotation.Nullable
            }
            this.___currentMethod = method_call;
        }
            scheme(iprot).read(iprot, this);
            }
                    optionals.set(1);
                        struct.setSuccessIsSet(true);
            org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(create_database_result.class, metaDataMap);
        }
            }
                return lastComparison;
            @Override
            send_add_partition(new_part);
                org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
            }
                    case 2: // O2
                    }
                            fb.close();
            }
            );
            this.filter = filter;
        }
                                    struct.setO1IsSet(true);
                return false;
        @Override
            }
            first = false;
                        unsetO2();
             */
        implements
            this.___currentMethod = method_call;
            this.o4 = o4;
        }
            @Override
        }
            }
                                _elem166.read(iprot);
        }
                        }
            lastComparison = java.lang.Boolean.compare(isSetDatabase(), other.isSetDatabase());
                return getClass().getName().compareTo(other.getClass().getName());
             * Find the _Fields constant that matches name, or null if its not found.
                if (struct.o2 != null) {
                    prot.decrementRecursionDepth();
                case TBL_NAME:
            }
                        iprot.readFieldEnd();
                        java.lang.String,
            }
                                    struct.setSuccessIsSet(true);
            "o2",
                        }
            @Override
        private static class get_partitions_argsStandardScheme extends org.apache.thrift.scheme.StandardScheme<get_partitions_args> {
                _Fields,
        }
        private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
        public boolean isSetO1() {
        );
        @Override
                super("get_partitions_by_filter");
                }
            boolean first = true;
            _Fields(short thriftId, java.lang.String fieldName) {
                                        }
            public static _Fields findByName(java.lang.String name) {
            @Override
                                }
            this.___currentMethod = method_call;
            tmpMap.put(
                }
                                    struct.o3 = new MetaException();
            sb.append("success:");
            this.req = null;
        /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
        @Override
        /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
            super(iface, getProcessMap(processMap));
                    return isSetTbl_name();
            this.o2 = o2;
                _thriftId = thriftId;
                                    struct.o2.read(iprot);
        @Override
        public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
                } finally {
        }
                }
            @Override
                    return lastComparison;
                if (lastComparison != 0) {
                        setO2((InvalidObjectException) value);
            switch (field) {
        public void get_partitions(
        public void create_database(Database database) throws AlreadyExistsException, InvalidObjectException, MetaException,
                    default:
             * Find the _Fields constant that matches name, or null if its not found.
            }
        public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
                        return null;
                    if (incoming.get(1)) {
                            msg = new org.apache.thrift.TApplicationException(
            }
                        return SUCCESS;
                    }
                            case 4: // MAX_PARTS
        public void unsetO1() {
                    new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, MetaException.class)
            scheme(iprot).read(iprot, this);
        );
                }
                                }
            return this.o2 != null;
                this.req = req;
        @Override
            org.apache.thrift.protocol.TType.STRUCT,
            if (isSetDb_name()) hashCode = hashCode * 8191 + db_name.hashCode();
                super(client, protocolFactory, transport, resultHandler, false);
                get_partitions_by_filter_result result = getEmptyResultInstance();
            @Override
                    iprot.readStructEnd();
        @Override
                _Fields.MAX_PARTS,
            get_table_req_call method_call = new get_table_req_call(req, resultHandler, this, ___protocolFactory, ___transport);
                        unsetReq();
                                    struct.o1 = new MetaException();
                }
            if (!getClass().equals(other.getClass())) {
        }
                            result.o2 = (MetaException) e;
        @Override
                if (fields == null) throw new java.lang.IllegalArgumentException("Field " + fieldId + " doesn't exist!");
                return new create_table_result();
                            result.o2 = (InvalidObjectException) e;
                                break;
                            result.setO2IsSet(true);
                case O4:
                    }
            (short) 3
        }
                    optionals.set(1);
                    result.success = iface.get_partitions_by_filter(args.db_name, args.tbl_name, args.filter, args.max_parts);
        public short max_parts; // required
        public static class get_partitions_call extends org.apache.thrift.async.TAsyncMethodCall<java.util.List<Partition>> {
            /**
                throw new java.lang.IllegalArgumentException();
        public void setO2IsSet(boolean value) {
                try {
            lastComparison = java.lang.Boolean.compare(isSetO3(), other.isSetO3());
        /** Returns true if field o3 is set (has been assigned a value) and false otherwise */
            }
                if (!(this_present_max_parts && that_present_max_parts)) return false;
                this.o2 = new MetaException(other.o2);
                }
                    struct.o3.write(oprot);
        public void unsetReq() {
        }
        }
            tmpMap.put(
                if (!(this_present_db_name && that_present_db_name)) return false;
                for (_Fields field : java.util.EnumSet.allOf(_Fields.class)) {
                            result.o2 = (AlreadyExistsException) e;
                                    struct.success = new Partition();
                    public void onError(java.lang.Exception e) {
            lastComparison = java.lang.Boolean.compare(isSetO3(), other.isSetO3());
                if (lastComparison != 0) {
                java.lang.String tbl_name,
                return false;
            throw new java.lang.IllegalStateException();
            java.io.Serializable,
         */
        }
            @Override
            scheme(iprot).read(iprot, this);
                            _LOGGER.error("TTransportException writing to internal frame buffer", e);
        private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
                    break;
                this.success = __this__success;
        }
                if (struct.isSetO2()) {
        public boolean isSet(_Fields field) {
                org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
                        }
                if (struct.isSetO4()) {
                            msg = result;
                org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
        }
                oprot.writeBitSet(optionals, 1);
            throw new java.lang.IllegalStateException();
        public create_table_result setO2(@org.apache.thrift.annotation.Nullable InvalidObjectException o2) {
            return this;
                                    org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
                if (!this.success.equals(that.success)) return false;
        public _Fields fieldForId(int fieldId) {
                    iface.create_database(args.database);
                        get_table_req_result result = new get_table_req_result();
            boolean first = true;
            return (this.success == null) ? null : this.success.iterator();
            if (lastComparison != 0) {
                                } else {
                return new AsyncClient(protocolFactory, clientManager, transport);
                    }
                super("create_table");
                    iprot.readStructEnd();
        public void create_table(Table tbl) throws AlreadyExistsException, InvalidObjectException, MetaException, NoSuchObjectException,
             * Find the _Fields constant that matches name, or null if its not found.
                        struct.setO1IsSet(true);
                this.o2 = null;
                oprot.writeStructBegin(STRUCT_DESC);
        @org.apache.thrift.annotation.Nullable
        }
                struct.validate();
            if (isSetSuccess()) hashCode = hashCode * 8191 + success.hashCode();
                args.write(prot);
                            result.o1 = (InvalidObjectException) e;
        }
            java.lang.String filter,
        public void unsetO2() {
                }
            if (other.isSetO1()) {
                org.apache.thrift.transport.TNonblockingTransport transport
            }
                }
                }
            if (isSetNew_part()) hashCode = hashCode * 8191 + new_part.hashCode();
        private static class create_table_argsTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
        }
        public int hashCode() {
                        }
            first = false;
            org.apache.thrift.protocol.TType.STRUCT,
            }
                sb.append(this.database);
                try {
            org.apache.thrift.TException {
            this.o2 = null;
                                    struct.o2.read(iprot);
                        try {
        }
            }
                return lastComparison;
        private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY =
            boolean first = true;
                    } else {
        }
        }
            if (this_present_o1 || that_present_o1) {
                    case 2: // TBL_NAME
            sb.append(")");
            lastComparison = java.lang.Boolean.compare(isSetMax_parts(), other.isSetMax_parts());
                this.success = null;
            try {
                    if (value == null) {
            }
            // check for required fields
                oprot.writeStructBegin(STRUCT_DESC);
        }
        // isset id assignments
            if (this_present_max_parts || that_present_max_parts) {
        }
                if (lastComparison != 0) {
            this.o2 = null;
                if (lastComparison != 0) {
            public GetTableResult getResult() throws MetaException, NoSuchObjectException, org.apache.thrift.TException {
            if (that == null) return false;
                            fb.close();
                                    struct.o2 = new NoSuchObjectException();
        public boolean isSetDb_name() {
            /**
                    "tbl_name",
            if (!value) {
                    return lastComparison;
            public short getThriftFieldId() {
            org.apache.thrift.TBase<create_table_result, create_table_result._Fields>,
            @Override
            return this;
                                        org.apache.thrift.protocol.TList _list160 = iprot.readListBegin();
            java.util.Map<
            }
            get_partitions_by_filter_result> {
            return this.success;
            @Override
        @Override
            @Override
            return this.success != null;
            @Override
    @SuppressWarnings({ "cast", "rawtypes", "serial", "unchecked", "unused" })
        }
                    }
            boolean that_present_success = true && that.isSetSuccess();
            boolean this_present_o2 = true && this.isSetO2();
            return processMap;
        private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, java.lang.ClassNotFoundException {
        public create_database_args(create_database_args other) {
            @Override
        public _Fields fieldForId(int fieldId) {
            this.o1 = o1;
            }
                try {
            if (that == null) return false;
            }
                }
            return this;
             * if it is not found.
                }
            throws NoSuchObjectException, MetaException, org.apache.thrift.TException;
                return result.success;
        public add_partition_result(add_partition_result other) {
                    return lastComparison;
            if (isSetO1()) hashCode = hashCode * 8191 + o1.hashCode();
            processMap.put("add_partition", new add_partition());
                            msg = result;
        private static final org.apache.thrift.protocol.TField DATABASE_FIELD_DESC = new org.apache.thrift.protocol.TField(
            private final short _thriftId;
        private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, java.lang.ClassNotFoundException {
                )
                    org.apache.thrift.AsyncProcessFunction<
                        }
        }
            } catch (org.apache.thrift.TException te) {
            scheme(oprot).write(oprot, this);
            @Override
            }
            boolean this_present_success = true && this.isSetSuccess();
            }
                } catch (NoSuchObjectException o4) {
                org.apache.thrift.TApplicationException.MISSING_RESULT,
                    return getO2();
                    return lastComparison;
                            _LOGGER.error("Exception writing to internal frame buffer", e);
                write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
                        if (e instanceof MetaException) {
                )
                                    struct.o3 = new MetaException();
        @Override
        public java.util.Iterator<Partition> getSuccessIterator() {
            }
                if (!(this_present_o3 && that_present_o3)) return false;
        public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
            }
                    return lastComparison;
            @Override
        @Override
                if (struct.success != null) {
        }
        public create_table_args() {}
            this.tbl = tbl;
                            case 3: // FILTER
                return new add_partition_resultTupleScheme();
                org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
        public InvalidObjectException getO1() {
            _Fields(short thriftId, java.lang.String fieldName) {
                                    struct.setTbl_nameIsSet(true);
                if (!this.filter.equals(that.filter)) return false;
                if (struct.new_part != null) {
                            result.setO4IsSet(true);
            tmpMap.put(
            ___manager.call(method_call);
            }
        @org.apache.thrift.annotation.Nullable
        @org.apache.thrift.annotation.Nullable
             */
                oprot.writeStructEnd();
                        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) {
                            fb.close();
            }
            }
             * if it is not found.
            }
            if (tbl != null) {
        }
            }
                        setFilter((java.lang.String) value);
        @Override
            tmpMap.put(
            this.o1 = null;
            public void read(org.apache.thrift.protocol.TProtocol prot, add_partition_args struct) throws org.apache.thrift.TException {
                                break;
        private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, java.lang.ClassNotFoundException {
                new org.apache.thrift.meta_data.FieldMetaData(
                    "success",
            if (!value) {
        private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
        private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("add_partition_args");
                            _LOGGER.error("TApplicationException inside handler", e);
                    @Override
                _Fields.NEW_PART,
                        struct.o2.read(iprot);
                } catch (MetaException o1) {
                org.apache.thrift.async.TAsyncClient client,
                if (struct.o1 != null) {
                    case 3: // FILTER
            }
        }
             * Find the _Fields constant that matches fieldId, throwing an exception
        private static class get_table_req_argsTupleScheme extends org.apache.thrift.scheme.TupleScheme<get_table_req_args> {
                    prot.decrementRecursionDepth();
        );
        @org.apache.thrift.annotation.Nullable
        /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
            this.success = success;
        public get_partitions_args(get_partitions_args other) {
             * Find the _Fields constant that matches name, or null if its not found.
            }
                return new get_partitions_by_filter_argsTupleScheme();
        public @org.apache.thrift.annotation.Nullable AlreadyExistsException o2; // required
                sb.append(this.o1);
                if (struct.isSetO1()) {
                sb.append(this.o2);
                    return getSuccess();
        }
        @Override
        }
                sb.append(this.o2);
            "success",
                    oprot.writeFieldBegin(O1_FIELD_DESC);
                return new create_table_args();
            }
                                break;
            I,
            public get_partitions_by_filter_args getEmptyArgsInstance() {
                org.apache.thrift.async.TAsyncClient client,
                    case 1: // TBL
            ) throws org.apache.thrift.TException {
                    result.o1 = o1;
            metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
        public @org.apache.thrift.annotation.Nullable NoSuchObjectException o2; // required
            if (this == that) return true;
                    new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, MetaException.class)
            checkReady();
                prot.incrementRecursionDepth();
                        struct.tbl_name = iprot.readString();
                        unsetTbl();
            }
        }
                        struct.setSuccessIsSet(true);
            sendBase("get_table_req", args);
                        struct.o2.read(iprot);
                new org.apache.thrift.meta_data.FieldMetaData(
                ___transport
                lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.o2, other.o2);
        public void get_table_req(GetTableRequest req, org.apache.thrift.async.AsyncMethodCallback<GetTableResult> resultHandler)
            Cloneable,
        public add_partition_result() {}
        }
            if (this.o2 == null) {
                    }
        }
            }
        }
                Table tbl,
        /** Returns true if field o3 is set (has been assigned a value) and false otherwise */
            }
            public void write(org.apache.thrift.protocol.TProtocol prot, create_table_args struct) throws org.apache.thrift.TException {
            scheme(oprot).write(oprot, this);
                    if (value == null) {
                _fieldName = fieldName;
            public get_table_req() {
            int hashCode = 1;
        public java.util.List<Partition> recv_get_partitions() throws NoSuchObjectException, MetaException, org.apache.thrift.TException {
                if (struct.isSetMax_parts()) {
                    break;
                    prot.decrementRecursionDepth();
        }
            }
                oprot.writeFieldStop();
            }
            boolean that_present_success = true && that.isSetSuccess();
            } catch (org.apache.thrift.TException te) {
            public void start(I iface, add_partition_args args, org.apache.thrift.async.AsyncMethodCallback<Partition> resultHandler)
        private static final org.slf4j.Logger _LOGGER = org.slf4j.LoggerFactory.getLogger(Processor.class.getName());
         */
        static {
        public void setTbl_nameIsSet(boolean value) {
        @org.apache.thrift.annotation.Nullable
                                if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {
            try {
            O3((short) 3, "o3");
        }
                return getClass().getName().compareTo(other.getClass().getName());
                return lastComparison;
                    optionals.set(2);
            this.o2 = o2;
            @Override
        public get_table_req_result deepCopy() {
                iprot.incrementRecursionDepth();
            }
                }
        private static final org.apache.thrift.protocol.TField REQ_FIELD_DESC = new org.apache.thrift.protocol.TField(
                                break;
            public create_table() {
                }
            }
                        try {
        @Override
        }
                        try {
        public get_partitions_args(java.lang.String db_name, java.lang.String tbl_name, short max_parts) {
                case TBL_NAME:
                    }
                throws org.apache.thrift.TException {
        );
                        } catch (java.lang.Exception e) {
        public InvalidObjectException getO2() {
            }
        private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new get_partitions_resultTupleSchemeFactory();
            @Override
            @Override
        @Override
                        result.success = o;
        private static final org.apache.thrift.protocol.TField MAX_PARTS_FIELD_DESC = new org.apache.thrift.protocol.TField(
            "o1",
            if (this_present_o1 || that_present_o1) {
            org.apache.thrift.async.AsyncMethodCallback<java.util.List<Partition>> resultHandler
                    }
                        org.apache.thrift.TSerializable msg;
                                }
                    if (incoming.get(0)) {
            boolean that_present_success = true && that.isSetSuccess();
            }
            hashCode = hashCode * 8191 + ((isSetDb_name()) ? 131071 : 524287);
        @org.apache.thrift.annotation.Nullable
        public void unsetO3() {
        public void setO1IsSet(boolean value) {
            (short) 3
                            _LOGGER.error("TTransportException writing to internal frame buffer", e);
            int hashCode = 1;
        static {
                sb.append("null");
            );
                return _fieldName;
            @Override
            if (field == null) {
        public boolean equals(create_database_result that) {
            org.apache.thrift.TBase<get_table_req_result, get_table_req_result._Fields>,
        private static final int __MAX_PARTS_ISSET_ID = 0;
         */
        }
                this.tbl_name = null;
            }
        public boolean equals(add_partition_args that) {
                        schemeField = iprot.readFieldBegin();
        }
            hashCode = hashCode * 8191 + ((isSetDatabase()) ? 131071 : 524287);
            this.max_parts = 0;
        public boolean equals(java.lang.Object that) {
            this.o3 = o3;
            }
                case O2:
                if (struct.isSetO1()) {
                    prot.decrementRecursionDepth();
            }
                lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.success, other.success);
                    }
            public void write(org.apache.thrift.protocol.TProtocol oprot, get_table_req_result struct) throws org.apache.thrift.TException {
            return false;
                                } else {
                    case 3: // O3
        /** Returns true if field o2 is set (has been assigned a value) and false otherwise */
        public get_partitions_by_filter_result deepCopy() {
        }
            }
            return this;
            }
        public short getMax_parts() {
             * if it is not found.
                return new add_partition_result();
        public boolean isSetO1() {
            hashCode = hashCode * 8191 + ((isSetO1()) ? 131071 : 524287);
        public Partition getSuccess() {
                this.tbl_name = other.tbl_name;
                    if (value == null) {
                        if (e instanceof MetaException) {
            /**
            }
            throw new java.lang.IllegalStateException();
                                _elem158 = new Partition();
                } catch (NoSuchObjectException o2) {
                return result;
                                    struct.o2.read(iprot);
                }
        public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
                // constructor.
                    optionals.set(3);
                }
            this.o2 = null;
                        oprot.writeListEnd();
                final int seqid
            @Override
            public boolean isOneway() {
                        result.success = o;
                                    struct.setO3IsSet(true);
        }
                    }
        public void send_create_database(Database database) throws org.apache.thrift.TException {
                                if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {
        /** Returns true if field max_parts is set (has been assigned a value) and false otherwise */
            private static final java.util.Map<java.lang.String, _Fields> byName = new java.util.HashMap<java.lang.String, _Fields>();
            if (this_present_o4 || that_present_o4) {
            if (lastComparison != 0) {
        }
                                break;
                                if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {
            tmpMap.put(
        private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
                case DB_NAME:
                        struct.success = new GetTableResult();
                            msg = result;
                org.apache.thrift.transport.TMemoryInputTransport memoryTransport = new org.apache.thrift.transport.TMemoryInputTransport(
        @org.apache.thrift.annotation.Nullable
        }
        }
                        struct.o2 = new InvalidObjectException();
                    return getO1();
                    }
            receiveBase(result, "add_partition");
        }
            return this;
                                    struct.o2.read(iprot);
        }
                this.filter = other.filter;
                db_name,
                lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.success, other.success);
                org.apache.thrift.protocol.TProtocolFactory protocolFactory,
            @Override
            this.success = null;
                this.db_name = db_name;
                        struct.setDatabaseIsSet(true);
        /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
                    I,
            }
            first = false;
            /**
        public @org.apache.thrift.annotation.Nullable java.lang.String tbl_name; // required
        public get_table_req_args() {}
                this.o3 = null;
                        struct.o1 = new AlreadyExistsException();
            return hashCode;
        }
            hashCode = hashCode * 8191 + ((isSetO1()) ? 131071 : 524287);
                super(client, protocolFactory, transport, resultHandler, false);
                                break;
            return this;
                    org.apache.thrift.TFieldRequirementType.DEFAULT,
            create_database_args,
            sb.append("o4:");
            return this.success;
        private static final org.apache.thrift.protocol.TField SUCCESS_FIELD_DESC = new org.apache.thrift.protocol.TField(
        );
            }
        public @org.apache.thrift.annotation.Nullable Table tbl; // required
            java.io.Serializable,
            private final java.lang.String _fieldName;
            @Override
            }
                org.apache.thrift.ProcessFunction<I, ? extends org.apache.thrift.TBase, ? extends org.apache.thrift.TBase>> processMap
                    } else {
                org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
                    return getNew_part();
            return this;
                lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.o1, other.o1);
        }
            @Override
                            case 3: // O3
            if (isSetDb_name()) {
                    iprot.readStructBegin();
            return new get_partitions_by_filter_args(this);
                }
        }
                            result.setO2IsSet(true);
                            msgType = org.apache.thrift.protocol.TMessageType.EXCEPTION;
            }
                this.tbl = tbl;
                                org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
                            fb.close();
        }
        );
            return this;
                for (_Fields field : java.util.EnumSet.allOf(_Fields.class)) {
        private static final org.apache.thrift.protocol.TField O2_FIELD_DESC = new org.apache.thrift.protocol.TField(
                iface.add_partition(args.new_part, resultHandler);
            setMax_partsIsSet(true);
                    } else {
            Comparable<create_database_args> {
            boolean first = true;
                                            struct.success.add(_elem153);
            throw new java.lang.IllegalStateException();
            if (lastComparison != 0) {
            public void write(org.apache.thrift.protocol.TProtocol oprot, create_database_args struct) throws org.apache.thrift.TException {
                    org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
        }
                        schemeField = iprot.readFieldBegin();
        public java.lang.Object getFieldValue(_Fields field) {
            (short) 2
        /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
                _thriftId = thriftId;
                    return lastComparison;
                        unsetO3();
            private static final java.util.Map<java.lang.String, _Fields> byName = new java.util.HashMap<java.lang.String, _Fields>();
                    oprot.writeFieldEnd();
                                if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {
                try {
        }
            }
                sb.append("null");
            );
                }
                        setO2((NoSuchObjectException) value);
                                    org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            sb.append("success:");
                read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
                return lastComparison;
                if (struct.isSetO2()) {
                    return lastComparison;
            sb.append("db_name:");
            public create_database_result getEmptyResultInstance() {
            @Override
            if (this == that) return true;
                _fieldName = fieldName;
                }
                    new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, MetaException.class)
                throw result.o1;
                _thriftId = thriftId;
                        get_partitions_by_filter_result result = new get_partitions_by_filter_result();
            return new get_table_req_args(this);
            // check for sub-struct validity
        public boolean equals(java.lang.Object that) {
            metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
        }
                        setDatabase((Database) value);
        @org.apache.thrift.annotation.Nullable
            if (lastComparison != 0) {
                }
        }
            }
            lastComparison = java.lang.Boolean.compare(isSetO1(), other.isSetO1());
            public add_partition_result getEmptyResultInstance() {
                            _LOGGER.error("TApplicationException inside handler", e);
                if (!(this_present_database && that_present_database)) return false;
            public void write_args(org.apache.thrift.protocol.TProtocol prot) throws org.apache.thrift.TException {
        }
            switch (field) {
        }
                case TBL:
                        unsetMax_parts();
            java.lang.StringBuilder sb = new java.lang.StringBuilder("create_database_args(");
            boolean this_present_o3 = true && this.isSetO3();
        }
                                    struct.setO2IsSet(true);
                new org.apache.thrift.meta_data.FieldMetaData(
                    }
            );
                return false;
        }
        private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("create_table_args");
        @org.apache.thrift.annotation.Nullable
                                    struct.o1 = new AlreadyExistsException();
            switch (field) {
            public static _Fields findByThriftIdOrThrow(int fieldId) {
                }
                }
        public void clear() {
             * Find the _Fields constant that matches fieldId, throwing an exception
        public void setSuccessIsSet(boolean value) {
            return sb.toString();
         * Performs a deep copy on <i>other</i>.
                if (struct.isSetMax_parts()) {
                        try {
                    byName.put(field.getFieldName(), field);
        private byte __isset_bitfield = 0;
    @SuppressWarnings({ "cast", "rawtypes", "serial", "unchecked", "unused" })
                    struct.o1.write(oprot);
                throw new java.lang.IllegalArgumentException();
            }
        public int compareTo(get_partitions_result other) {
                if (struct.isSetO1()) {
        private static class get_table_req_resultStandardScheme extends org.apache.thrift.scheme.StandardScheme<get_table_req_result> {
                oprot.writeBitSet(optionals, 4);
            }
            public boolean isOneway() {
                    new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, Table.class)
            O1((short) 1, "o1"),
        private static final org.apache.thrift.protocol.TField MAX_PARTS_FIELD_DESC = new org.apache.thrift.protocol.TField(
            this.o2 = o2;
        public void setDatabaseIsSet(boolean value) {
            public static _Fields findByThriftId(int fieldId) {
                this.success = new GetTableResult(other.success);
            processMap.put("add_partition", new add_partition());
                            result.setO1IsSet(true);
                        schemeField = iprot.readFieldBegin();
                java.util.BitSet optionals = new java.util.BitSet();
                    if (value == null) {
                                    struct.db_name = iprot.readString();
        /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
                case O2:
                        struct.o2 = new AlreadyExistsException();
                                } else {
                    if (incoming.get(1)) {
                )
                        }
                    default:
                    oprot.writeFieldEnd();
        }
            private final java.lang.String _fieldName;
            this.tbl_name = tbl_name;
                    return lastComparison;
                : TUPLE_SCHEME_FACTORY).getScheme();
             * if it is not found.
        private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new get_table_req_resultTupleSchemeFactory();
            }
            public void read(org.apache.thrift.protocol.TProtocol iprot, create_database_result struct)
                        } catch (java.lang.Exception e) {
                )
            if (isSetO3()) hashCode = hashCode * 8191 + o3.hashCode();
            boolean that_present_o1 = true && that.isSetO1();
                            struct.success = new java.util.ArrayList<Partition>(_list157.size);
                    struct.o3.write(oprot);
            return false;
                            result.o1 = (NoSuchObjectException) e;
                    getFrameBuffer().array()
                                org.apache.thrift.TApplicationException.INTERNAL_ERROR,
            int hashCode = 1;
                    struct.o2.write(oprot);
            java.lang.String tbl_name,
            org.apache.thrift.protocol.TType.STRUCT,
            if (isSetTbl_name()) {
        private static final org.apache.thrift.protocol.TField O2_FIELD_DESC = new org.apache.thrift.protocol.TField(
                            default:
                throws org.apache.thrift.TException {
            }
        }
                    return getO2();
                                    struct.setO1IsSet(true);
        }
                    struct.o2.write(oprot);
                if (fields == null) throw new java.lang.IllegalArgumentException("Field " + fieldId + " doesn't exist!");
                    return lastComparison;
            @Override
        }
        @org.apache.thrift.annotation.Nullable
                            case 1: // REQ
                    while (true) {
                    default:
            public static _Fields findByThriftId(int fieldId) {
            }
                iface.get_partitions_by_filter(args.db_name, args.tbl_name, args.filter, args.max_parts, resultHandler);
        @Override
                            I,
        }
                throw new java.io.IOException(te);
            java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<
            create_database_args,
                    return isSetO3();
        public boolean isSetO2() {
                    org.apache.thrift.TFieldRequirementType.DEFAULT,
                } catch (MetaException o3) {
            }
            boolean that_present_o2 = true && that.isSetO2();
                }
        }
            "o1",
                    result.o2 = o2;
            boolean first = true;
                read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
            java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<
            @Override
        }
    }
            public static _Fields findByThriftIdOrThrow(int fieldId) {
                    java.util.BitSet incoming = iprot.readBitSet(4);
                sb.append(this.success);
                            case 4: // O4
            public static _Fields findByThriftIdOrThrow(int fieldId) {
            I,
                    new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I16)
            if (this.success == null) {
            /**
        );
                    oprot.writeFieldBegin(DATABASE_FIELD_DESC);
        public boolean equals(create_table_result that) {
        private static class get_partitions_resultStandardScheme extends org.apache.thrift.scheme.StandardScheme<get_partitions_result> {
                        iprot.readFieldEnd();
            (short) 3
                throw new java.io.IOException(te);
        }
        public java.lang.Object getFieldValue(_Fields field) {
            }
                            msgType = org.apache.thrift.protocol.TMessageType.EXCEPTION;
                    if (incoming.get(3)) {
                                break;
            static {
                    java.util.BitSet incoming = iprot.readBitSet(1);
            if (!first) sb.append(", ");
                _Fields.O1,
                throw new java.io.IOException(te);
                                org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            checkReady();
                    iprot.decrementRecursionDepth();
            if (isSetDb_name()) hashCode = hashCode * 8191 + db_name.hashCode();
        public NoSuchObjectException getO4() {
            public static _Fields findByName(java.lang.String name) {
            this();
            boolean first = true;
        /** Returns true if field o2 is set (has been assigned a value) and false otherwise */
            lastComparison = java.lang.Boolean.compare(isSetSuccess(), other.isSetSuccess());
            this.success = null;
                                    struct.setO2IsSet(true);
            }
            try {
        }
                    new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, InvalidObjectException.class)
                        } catch (org.apache.thrift.transport.TTransportException e) {
                                }
            return this.o3;
                    case 0: // SUCCESS
                            fb.close();
                }
        implements
                ? STANDARD_SCHEME_FACTORY
                if (struct.isSetSuccess()) {
            if (isSetTbl_name()) hashCode = hashCode * 8191 + tbl_name.hashCode();
            /**
                }
                                break;
        public void unsetTbl() {
        private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
            }
    @SuppressWarnings({ "cast", "rawtypes", "serial", "unchecked", "unused" })
                case DATABASE:
            receiveBase(result, "get_partitions");
            if (!value) {
            "db_name",
        public void unsetO1() {
                    struct.validate();
        static {
        public get_partitions_args setTbl_name(@org.apache.thrift.annotation.Nullable java.lang.String tbl_name) {
                struct.validate();
                GetTableRequest req,
        // isset id assignments
            } else {
            if (result.o3 != null) {
                this.protocolFactory = protocolFactory;
            return this.db_name != null;
                try {
            java.util.Map<
                                break;
        }
                }
        }
                if (!(this_present_o4 && that_present_o4)) return false;
                    optionals.set(1);
                this.new_part = new_part;
                    // check for required fields of primitive type, which can't be checked in the validate method
                        oprot.writeListEnd();
                                if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
                    if (incoming.get(0)) {
                    }
            ___manager.call(method_call);
        public get_partitions_result setSuccess(@org.apache.thrift.annotation.Nullable java.util.List<Partition> success) {
             */
                    return isSetO1();
        }
                    optionals.set(0);
        public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
                }
            }
            @Override
            // check for required fields
            );
            return hashCode;
                write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
        public void clear() {
            );
            private static final java.util.Map<java.lang.String, _Fields> byName = new java.util.HashMap<java.lang.String, _Fields>();
            }
            java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<
                case SUCCESS:
            }
            boolean this_present_db_name = true && this.isSetDb_name();
                        get_table_req_result result = new get_table_req_result();
            throw new java.lang.IllegalStateException();
                    if (value == null) {
            public short getThriftFieldId() {
        public boolean isSetO2() {
            add_partition_call method_call = new add_partition_call(new_part, resultHandler, this, ___protocolFactory, ___transport);
            public org.apache.thrift.async.AsyncMethodCallback<Void> getResultHandler(
        }
            }
                                    org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
                oprot.writeBitSet(optionals, 3);
                prot.writeMessageBegin(
            sendBase("add_partition", args);
                ? STANDARD_SCHEME_FACTORY
            switch (field) {
        }
            int hashCode = 1;
            public Partition getResult() throws InvalidObjectException, AlreadyExistsException, MetaException,
            return this.o1;
            switch (field) {
                    __this__success.add(new Partition(other_element));
            } catch (org.apache.thrift.TException te) {
            if (!getClass().equals(other.getClass())) {
            }
                            result.setO1IsSet(true);
            } catch (org.apache.thrift.TException te) {
                            msg = (org.apache.thrift.TApplicationException) e;
                    "db_name",
        @Override
            "o3",
                            msg = result;
        public get_table_req_args setReq(@org.apache.thrift.annotation.Nullable GetTableRequest req) {
            "o2",
            if (lastComparison != 0) {
            org.apache.thrift.protocol.TType.STRUCT,
            }
                        struct.o2 = new NoSuchObjectException();
                }
                    java.lang.String,
            new create_database_resultStandardSchemeFactory();
            org.apache.thrift.protocol.TType.STRUCT,
        public int getSuccessSize() {
                )
        implements
                return new org.apache.thrift.async.AsyncMethodCallback<java.util.List<Partition>>() {
                                    struct.setMax_partsIsSet(true);
                        } else if (e instanceof NoSuchObjectException) {
            }
            // check for sub-struct validity
                this.success = null;
                    case 1: // O1
            switch (field) {
        }
                return fields;
        public boolean isSetFilter() {
        private static class add_partition_resultTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
                    if (value == null) {
            }
            // check for sub-struct validity
            public create_table_resultStandardScheme getScheme() {
                if (struct.isSetO1()) {
            this.o2 = o2;
        }
             * Find the _Fields constant that matches fieldId, throwing an exception
                            fcall.sendResponse(fb, result, org.apache.thrift.protocol.TMessageType.REPLY, seqid);
            metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
                    while (true) {
            org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(get_partitions_args.class, metaDataMap);
                );
             */
                for (_Fields field : java.util.EnumSet.allOf(_Fields.class)) {
                    new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, NoSuchObjectException.class)
                read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
                I iface,
        public boolean isSet(_Fields field) {
                                    struct.tbl = new Table();
            first = false;
                return lastComparison;
            if (this.success == null) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder("add_partition_args(");
            private final java.lang.String _fieldName;
                }
                            fb.close();
                            result.setO2IsSet(true);
            REQ((short) 1, "req");
            if (!getClass().equals(other.getClass())) {
                        byte msgType = org.apache.thrift.protocol.TMessageType.REPLY;
            public get_partitions_argsTupleScheme getScheme() {
                )
        }
                    break;
        }
        public create_table_result setO3(@org.apache.thrift.annotation.Nullable MetaException o3) {
                throw new java.io.IOException(te);
                                break;
                if (!this.tbl_name.equals(that.tbl_name)) return false;
                this.tbl_name = null;
            int lastComparison = 0;
                return result;
            }
                this.tbl_name = tbl_name;
            }
                }
            this.tbl_name = tbl_name;
            // check for sub-struct validity
        }
            this.o1 = null;
                                e.getMessage()
                    oprot.writeString(struct.db_name);
            /**
                    }
                                    org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            @Override
                __isset_bitfield = 0;
                get_table_req_result result = getEmptyResultInstance();
                            return;
            org.apache.thrift.protocol.TType.STRUCT,
                } finally {
                } catch (MetaException o1) {
                        }
            return new create_table_args(this);
            public add_partition_resultTupleScheme getScheme() {
            this.o1 = o1;
            }
        public @org.apache.thrift.annotation.Nullable java.lang.String db_name; // required
            if (!value) {
                    java.util.BitSet incoming = iprot.readBitSet(4);
                _fieldName = fieldName;
            }
        public boolean isSetO3() {
            add_partition_args,
                    optionals.set(2);
        public Client(org.apache.thrift.protocol.TProtocol prot) {
        public void validate() throws org.apache.thrift.TException {
                        byte msgType = org.apache.thrift.protocol.TMessageType.REPLY;
        public static class Factory implements org.apache.thrift.TServiceClientFactory<Client> {
                    oprot.writeFieldEnd();
                            fb.close();
                prot.incrementRecursionDepth();
            public static _Fields findByName(java.lang.String name) {
            sendBase("get_partitions", args);
                    new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, AlreadyExistsException.class)
                    @Override
            boolean that_present_o3 = true && that.isSetO3();
                        struct.database = new Database();
        );
        @Override
                case O2:
            lastComparison = java.lang.Boolean.compare(isSetO1(), other.isSetO1());
            "add_partition_result"
            (short) 2
        }
        public void setFieldValue(_Fields field, @org.apache.thrift.annotation.Nullable java.lang.Object value) {
                    break;
            Comparable<get_partitions_by_filter_result> {
        @Override
                java.util.Map<
            public get_partitions_by_filter_result getEmptyResultInstance() {
        public void setO3IsSet(boolean value) {
            if (!first) sb.append(", ");
                throws org.apache.thrift.TException {
                        } else {
            if (isSetO1()) {
                            _LOGGER.error("Exception writing to internal frame buffer", ex);
    }
            @Override
                } catch (InvalidObjectException o1) {
                            org.apache.thrift.protocol.TList _list157 = iprot.readListBegin(org.apache.thrift.protocol.TType.STRUCT);
            if (other.isSetO2()) {
                        struct.setReqIsSet(true);
        public void unsetO2() {
                        struct.o4.read(iprot);
        public java.lang.String toString() {
            this.o3 = null;
                _Fields,
            }
            }
                            msg = result;
                    return isSetO2();
                case TBL_NAME:
            if (this.o1 == null) {
                    if (value == null) {
                            case 3: // O3
                _Fields fields = findByThriftId(fieldId);
            boolean that_present_database = true && that.isSetDatabase();
            tmpMap.put(
        }
            if (this.db_name == null) {
        public Processor(I iface) {
        public @org.apache.thrift.annotation.Nullable NoSuchObjectException o4; // required
                            break;
            hashCode = hashCode * 8191 + ((isSetO2()) ? 131071 : 524287);
                try {
            }
                    }
                    iprot.readStructBegin();
                    } else {
            hashCode = hashCode * 8191 + ((isSetO1()) ? 131071 : 524287);
                throw new java.io.IOException(te);
                )
                case NEW_PART:
        /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
        @Override
        @org.apache.thrift.annotation.Nullable
            public short getThriftFieldId() {
            }
            first = false;
            }
        }
            Comparable<add_partition_args> {
            private static final java.util.Map<java.lang.String, _Fields> byName = new java.util.HashMap<java.lang.String, _Fields>();
                return new get_table_req_argsStandardScheme();
            return false;
                            break;
            if (!first) sb.append(", ");
        }
        }
                case O3:
                return new create_database_args();
            } else {
            return this.o4;
            O1((short) 1, "o1"),
            lastComparison = java.lang.Boolean.compare(isSetReq(), other.isSetReq());
            this.success = success;
        }
        public void unsetO1() {
        public boolean isSetTbl_name() {
                case MAX_PARTS:
        public void setO1IsSet(boolean value) {
            if (!value) {
             */
                throw new java.lang.IllegalArgumentException();
                    struct.o3.write(oprot);
                    "o1",
            }
            hashCode = hashCode * 8191 + ((isSetO2()) ? 131071 : 524287);
        }
            );
            } else {
                write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
        }
                }
            private final short _thriftId;
        public void clear() {
        public get_partitions_by_filter_args(
                    result.o1 = o1;
                    break;
            } else {
            int lastComparison = 0;
                if (getState() != org.apache.thrift.async.TAsyncMethodCall.State.RESPONSE_READ) {
                new org.apache.thrift.meta_data.FieldMetaData(
                if (struct.isSetO3()) {
            SUCCESS((short) 0, "success"),
                            _LOGGER.error("Exception writing to internal frame buffer", ex);
            if (lastComparison != 0) {
        }
        }
            if (!getClass().equals(other.getClass())) {
            }
            hashCode = hashCode * 8191 + ((isSetSuccess()) ? 131071 : 524287);
        public java.lang.String toString() {
            this.o1 = null;
            "success",
                new org.apache.thrift.meta_data.FieldMetaData(
            this.db_name = db_name;
        /**
            return this.o2;
                        struct.o1 = new NoSuchObjectException();
                args.setFilter(filter);
            this.new_part = new_part;
            return 0;
                        return O2;
        public enum _Fields implements org.apache.thrift.TFieldIdEnum {
                case O2:
            int hashCode = 1;
                }
        }
        }
            }
            if (field == null) {
        public static class get_table_req_call extends org.apache.thrift.async.TAsyncMethodCall<GetTableResult> {
        // isset id assignments
        }
                        setO3((MetaException) value);
    }
            this.o2 = null;
        private static class get_table_req_argsStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
        private static class create_table_resultTupleScheme extends org.apache.thrift.scheme.TupleScheme<create_table_result> {
        }
                this.o1 = null;
                            msgType = org.apache.thrift.protocol.TMessageType.EXCEPTION;
                sb.append("null");
        }
            public get_partitions_by_filter_argsStandardScheme getScheme() {
        }
            args.setDatabase(database);
             * if it is not found.
                    }
                return getClass().getName().compareTo(other.getClass().getName());
        }
            }
            }
        }
        @Override
                super(client, protocolFactory, transport, resultHandler, false);
                try {
                if (lastComparison != 0) {
            get_partitions_by_filter_result> {
            if (this.o1 == null) {
                return lastComparison;
                                    struct.setTblIsSet(true);
                java.lang.String db_name,
                                    struct.o2.read(iprot);
                    new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, NoSuchObjectException.class)
            switch (field) {
                org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
                lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.o1, other.o1);
                throw new java.io.IOException(te);
                        }
                success.validate();
        private static class get_partitions_resultTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
                throw new java.lang.IllegalArgumentException();
        }
            if (result.o3 != null) {
            if (this == that) return true;
                org.apache.thrift.TApplicationException.MISSING_RESULT,
                    new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, MetaException.class)
            java.lang.StringBuilder sb = new java.lang.StringBuilder("get_table_req_result(");
                }
            Comparable<get_partitions_args> {
                lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.db_name, other.db_name);
            receiveBase(result, "create_table");
            public get_partitions_result getEmptyResultInstance() {
            public java.lang.String getFieldName() {
            return sb.toString();
            return true;
                    case 1: // DB_NAME
                        struct.setO2IsSet(true);
                    return isSetO1();
            }
            // check for sub-struct validity
                    while (true) {
                this,
            boolean that_present_o2 = true && that.isSetO2();
            if (isSetO1()) hashCode = hashCode * 8191 + o1.hashCode();
            try {
            @Override
        }
                        } catch (java.lang.Exception ex) {
            hashCode = hashCode * 8191 + ((isSetO1()) ? 131071 : 524287);
                                org.apache.thrift.TApplicationException.INTERNAL_ERROR,
                prot.writeMessageBegin(
        }
                return lastComparison;
            (short) 3
                }
                    if (incoming.get(2)) {
                return lastComparison;
                    oprot.writeFieldEnd();
            public static _Fields findByThriftIdOrThrow(int fieldId) {
                        schemeField = iprot.readFieldBegin();
            public add_partition_call(
                    iprot.decrementRecursionDepth();
            I iface,
                if (struct.success != null) {
        public java.lang.String getDb_name() {
                        } else if (e instanceof MetaException) {
                        ? extends org.apache.thrift.TBase>> processMap
            public short getThriftFieldId() {
                org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
            }
                        }
            /**
        }
            this.___currentMethod = method_call;
                    } else {
                    if (incoming.get(1)) {
            ___manager.call(method_call);
                            msg = result;
            }
        public void unsetO2() {
            return false;
            this.o1 = null;
                return lastComparison;
            Comparable<add_partition_result> {
                                    org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            throws org.apache.thrift.TException;
        private static class get_partitions_by_filter_resultStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
                java.util.BitSet optionals = new java.util.BitSet();
        }
                        return null;
            hashCode = hashCode * 8191 + ((isSetO2()) ? 131071 : 524287);
                new org.apache.thrift.meta_data.FieldMetaData(
        public _Fields fieldForId(int fieldId) {
                        try {
            org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(get_table_req_result.class, metaDataMap);
                        return O2;
                if (!this.o2.equals(that.o2)) return false;
        }
        public static class get_table_req<I extends Iface> extends org.apache.thrift.ProcessFunction<
        static {
            } else {
                    break;
                    public void onComplete(Void o) {
                    }
        }
            @Override
                            _LOGGER.error("TTransportException writing to internal frame buffer", e);
                        setO1((AlreadyExistsException) value);
                                    struct.o3.read(iprot);
                case O1:
            __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __MAX_PARTS_ISSET_ID);
        }
        }
                    if (incoming.get(3)) {
            org.apache.thrift.TBase<get_partitions_args, get_partitions_args._Fields>,
            if (this.o4 == null) {
            }
                                }
            @Override
        public boolean isSetNew_part() {
            Comparable<create_table_result> {
            }
        public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
                    while (true) {
            @Override
                } finally {
        public static class get_partitions<I extends AsyncIface> extends org.apache.thrift.AsyncProcessFunction<
                            result.o1 = (AlreadyExistsException) e;
        private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, java.lang.ClassNotFoundException {
                    } else {
                    new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)
                        } else if (e instanceof org.apache.thrift.transport.TTransportException) {
            this.max_parts = other.max_parts;
            @Override
                if (!(this_present_tbl_name && that_present_tbl_name)) return false;
                    optionals.set(1);
        }
            }
        public void setO1IsSet(boolean value) {
        public add_partition_args(Partition new_part) {
                    }
        }
                                org.apache.thrift.TApplicationException.INTERNAL_ERROR,
            } catch (org.apache.thrift.TException te) {
                }
                prot.incrementRecursionDepth();
                        struct.setO2IsSet(true);
                    iprot.readStructBegin();
                    oprot.writeFieldEnd();
        private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new create_database_resultTupleSchemeFactory();
                case TBL_NAME:
                return getClass().getName().compareTo(other.getClass().getName());
            return this.o2 != null;
            org.apache.thrift.TBase<add_partition_args, add_partition_args._Fields>,
            args.setMax_parts(max_parts);
            @Override
            @Override
                        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) {
                        return O2;
        }
                    struct.validate();
        }
            get_table_req_result result = new get_table_req_result();
                    if (value == null) {
                java.util.BitSet optionals = new java.util.BitSet();
            _Fields(short thriftId, java.lang.String fieldName) {
            if (this_present_o1 || that_present_o1) {
                    oprot.writeFieldEnd();
                    oprot.writeFieldBegin(REQ_FIELD_DESC);
            @Override
        @Override
        @org.apache.thrift.annotation.Nullable
                get_partitions_args args,
        }
        public enum _Fields implements org.apache.thrift.TFieldIdEnum {
                return new get_partitions_args();
        public get_table_req_result setO1(@org.apache.thrift.annotation.Nullable MetaException o1) {
            get_partitions_args args = new get_partitions_args();
                    result.o2 = o2;
            if (other.isSetSuccess()) {
            public static _Fields findByThriftId(int fieldId) {
        public void setDb_nameIsSet(boolean value) {
            this();
            public add_partition_resultStandardScheme getScheme() {
        public Client(org.apache.thrift.protocol.TProtocol iprot, org.apache.thrift.protocol.TProtocol oprot) {
                                break;
            java.util.Map<
            if (result.o4 != null) {
            }
                : TUPLE_SCHEME_FACTORY).getScheme();
                _Fields.O3,
            public void read(org.apache.thrift.protocol.TProtocol prot, get_table_req_result struct) throws org.apache.thrift.TException {
            create_table_result> {
            if (result.isSetSuccess()) {
        private static class get_partitions_by_filter_argsStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
                );
        }
        // isset id assignments
            this.o2 = o2;
                if (struct.isSetMax_parts()) {
        implements
                (new Client(prot)).recv_create_database();
            public get_partitions_by_filter() {
                            _LOGGER.error("TTransportException writing to internal frame buffer", e);
                                    struct.setSuccessIsSet(true);
                            fcall.sendResponse(fb, result, org.apache.thrift.protocol.TMessageType.REPLY, seqid);
                                break;
                if (struct.o2 != null) {
                }
                return _thriftId;
                case O3:
                                    struct.setO4IsSet(true);
                            msg = result;
                            @org.apache.thrift.annotation.Nullable
                        struct.db_name = iprot.readString();
            if (other.isSetSuccess()) {
        public void send_create_table(Table tbl) throws org.apache.thrift.TException {
                short max_parts,
            return 0;
                if (struct.isSetO2()) {
                _Fields fields = findByThriftId(fieldId);
        @Override
                case O1:
                            _LOGGER.error("Exception writing to internal frame buffer", e);
                        } else if (e instanceof org.apache.thrift.transport.TTransportException) {
        private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("get_table_req_args");
                }
                this.o1 = new MetaException(other.o1);
        @Override
            @org.apache.thrift.annotation.Nullable
        }
                }
            scheme(iprot).read(iprot, this);
        static {
                java.util.Map<
            public void read(org.apache.thrift.protocol.TProtocol iprot, add_partition_args struct) throws org.apache.thrift.TException {
            }
            this.db_name = db_name;
        public get_table_req_result(GetTableResult success, MetaException o1, NoSuchObjectException o2) {
            if (other.isSetO1()) {
                        struct.setDb_nameIsSet(true);
        private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
                        iprot.readFieldEnd();
            public void write(org.apache.thrift.protocol.TProtocol prot, add_partition_result struct) throws org.apache.thrift.TException {
        }
                }
            boolean this_present_o3 = true && this.isSetO3();
            org.apache.thrift.protocol.TProtocolFactory protocolFactory,
            lastComparison = java.lang.Boolean.compare(isSetO2(), other.isSetO2());
                for (_Fields field : java.util.EnumSet.allOf(_Fields.class)) {
                                        Partition _elem161;
        }
                return byName.get(name);
                }
                    return getDatabase();
                return result;
            public create_database_resultTupleScheme getScheme() {
            if (this_present_o2 || that_present_o2) {
                if (struct.isSetO2()) {
        public enum _Fields implements org.apache.thrift.TFieldIdEnum {
        public void create_database(Database database, org.apache.thrift.async.AsyncMethodCallback<Void> resultHandler)
                            fb.close();
        }
            throw new java.lang.IllegalStateException();
                _Fields,
                org.apache.thrift.TException {
                        struct.setSuccessIsSet(true);
                }
                                if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {
            return processMap;
                    case 2: // O2
            processMap.put("create_table", new create_table());
             * Find the _Fields constant that matches fieldId, throwing an exception
        );
                }
            send_get_table_req(req);
            if (this_present_success || that_present_success) {
            public create_table_result getEmptyResultInstance() {
        }
            }
        }
                }
                write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
        @org.apache.thrift.annotation.Nullable
                        } catch (org.apache.thrift.transport.TTransportException e) {
            this.___currentMethod = method_call;
                        iprot.readFieldEnd();
        }
                return false;
            }
            if (this_present_o3 || that_present_o3) {
                case DATABASE:
            org.apache.thrift.TException;
        );
                final int seqid
                args.setDb_name(db_name);
            this.o1 = null;
                        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) {
            @Override
        @org.apache.thrift.annotation.Nullable
            if (isSetSuccess()) {
            hashCode = hashCode * 8191 + ((isSetTbl_name()) ? 131071 : 524287);
        }
                if (fields == null) throw new java.lang.IllegalArgumentException("Field " + fieldId + " doesn't exist!");
            @Override
            org.apache.thrift.TException;
        }
                org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
                    return getSuccess();
        @Override
            "success",
                this.db_name = db_name;
                        } else {
             */
        }
            return this.o1;
        public add_partition_result setO2(@org.apache.thrift.annotation.Nullable AlreadyExistsException o2) {
            processMap.put("create_table", new create_table());
        public void setO1IsSet(boolean value) {
                oprot.writeFieldStop();
            switch (field) {
                return fields;
                if (struct.isSetSuccess()) {
                    java.lang.String,
                return byName.get(name);
                } finally {
        /** Returns true if field success is set (has been assigned a value) and false otherwise */
                org.apache.thrift.async.AsyncMethodCallback<Partition> resultHandler,
                            result.o3 = (MetaException) e;
                        return MAX_PARTS;
                org.apache.thrift.protocol.TProtocolFactory protocolFactory,
        @Override
            public AsyncClient getAsyncClient(org.apache.thrift.transport.TNonblockingTransport transport) {
                                if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {
            }
                            _LOGGER.error("TTransportException inside handler", e);
            O3((short) 3, "o3");
            checkReady();
                this.req = null;
                if (lastComparison != 0) {
                sb.append(this.o3);
                    org.apache.thrift.TFieldRequirementType.DEFAULT,
        );
        public void setSuccessIsSet(boolean value) {
        public boolean isSetSuccess() {
    }
            this.filter = null;
        public void get_partitions(
            }
                throw result.o3;
        }
                    case 3: // O3
                if (fields == null) throw new java.lang.IllegalArgumentException("Field " + fieldId + " doesn't exist!");
            if (this.o3 == null) {
                return lastComparison;
                return lastComparison;
                        }
                    }
        }
        public boolean equals(java.lang.Object that) {
                        } else if (e instanceof MetaException) {
                    struct.database.write(oprot);
        }
            org.apache.thrift.protocol.TType.STRUCT,
                            result.setO2IsSet(true);
                    oprot.writeFieldEnd();
                        }
                if (!(this_present_filter && that_present_filter)) return false;
        public @org.apache.thrift.annotation.Nullable java.lang.String tbl_name; // required
            @Override
            /**
            tmpMap.put(
                _thriftId = thriftId;
                case O1:
                }
                        struct.setTbl_nameIsSet(true);
        public get_partitions_by_filter_result(get_partitions_by_filter_result other) {
                _thriftId = thriftId;
                } catch (MetaException o3) {
            public create_database_argsStandardScheme getScheme() {
                iprot.incrementRecursionDepth();
            if (that == null) return false;
                write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
                    result.o1 = o1;
            }
            tmpMap.put(
                return _thriftId;
                sb.append("null");
        }
            switch (field) {
                            fb.close();
                    }
                                    struct.max_parts = iprot.readI16();
            O4((short) 4, "o4");
            public get_table_req_result getResult(I iface, get_table_req_args args) throws org.apache.thrift.TException {
            return this;
                    } else {
                } finally {
        private static class get_partitions_by_filter_argsTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
            public void start(I iface, create_database_args args, org.apache.thrift.async.AsyncMethodCallback<Void> resultHandler)
                )
            }
                    org.apache.thrift.protocol.TField schemeField;
        public add_partition_args(add_partition_args other) {
            this.success = success;
            }
            }
                                if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {
                    break;
            if (other.isSetReq()) {
                sb.append("null");
                                    struct.setO3IsSet(true);
            this();
                            break;
                try {
                        struct.o2.read(iprot);
                    org.apache.thrift.TFieldRequirementType.DEFAULT,
                    } else {
                            case 0: // SUCCESS
             * Find the _Fields constant that matches fieldId, or null if its not found.
            }
                return fields;
        protected Processor(
                return getClass().getName().compareTo(other.getClass().getName());
        }
        private static class get_partitions_argsTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
            }
            }
                    struct.validate();
        }
                throws org.apache.thrift.TException {
                    struct.o1.write(oprot);
                }
                this.filter = filter;
                org.apache.thrift.transport.TMemoryInputTransport memoryTransport = new org.apache.thrift.transport.TMemoryInputTransport(
            }
        @Override
                                } else {
                        unsetMax_parts();
                            _LOGGER.error("TApplicationException inside handler", e);
                case O4:
            }
        @Override
            if (other.isSetNew_part()) {
                args.setDatabase(database);
                        return O2;
                org.apache.thrift.async.AsyncMethodCallback<GetTableResult> resultHandler,
                            _LOGGER.error("TApplicationException inside handler", e);
                    // check for required fields of primitive type, which can't be checked in the validate method
            java.lang.String db_name,
            }
                        return null;
                    if (incoming.get(2)) {
            } else {
        }
            }
            this.max_parts = max_parts;
            }
            }
                new org.apache.thrift.meta_data.FieldMetaData(
            hashCode = hashCode * 8191 + ((isSetTbl_name()) ? 131071 : 524287);
             * Find the _Fields constant that matches fieldId, or null if its not found.
            return this.o2;
            public void read(org.apache.thrift.protocol.TProtocol prot, get_partitions_args struct) throws org.apache.thrift.TException {
            public static _Fields findByThriftId(int fieldId) {
                case O3:
                                if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {
        public boolean equals(get_table_req_args that) {
            hashCode = hashCode * 8191 + ((isSetO4()) ? 131071 : 524287);
                write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
                return lastComparison;
                    "o3",
                    struct.validate();
                    iprot.decrementRecursionDepth();
        }
                args.setMax_parts(max_parts);
        private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
        private static class add_partition_resultTupleScheme extends org.apache.thrift.scheme.TupleScheme<add_partition_result> {
                this.max_parts = max_parts;
        }
                if (!(this_present_o2 && that_present_o2)) return false;
            }
                org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
            @org.apache.thrift.annotation.Nullable
                this.o2 = new InvalidObjectException(other.o2);
            java.lang.String tbl_name,
                org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
                return lastComparison;
                ? STANDARD_SCHEME_FACTORY
                case O2:
            java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<
                );
                        }
                return result;
            public void start(I iface, get_table_req_args args, org.apache.thrift.async.AsyncMethodCallback<GetTableResult> resultHandler)
                if (lastComparison != 0) {
        private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
                return _fieldName;
            return true;
            }
                case MAX_PARTS:
            I,
                        struct.setO2IsSet(true);
            if (lastComparison != 0) {
        }
            this.o1 = o1;
            private final short _thriftId;
            if (this == that) return true;
        }
            this.o1 = o1;
        }
            return 0;
                    if (incoming.get(1)) {
            this.success = null;
            private java.lang.String db_name;
                return false;
            }
                            fcall.sendResponse(fb, msg, msgType, seqid);
            return this.db_name;
                Partition new_part,
            this.database = null;
            return 0;
            }
                super("create_table");
                                        for (int _i154 = 0; _i154 < _list152.size; ++_i154) {
                (new Client(prot)).recv_create_table();
    public static class create_table_args
        }
            if (lastComparison != 0) {
            @Override
                this.o1 = new InvalidObjectException(other.o1);
                    org.apache.thrift.protocol.TField schemeField;
        }
                if (lastComparison != 0) {
            public void start(
                sb.append("null");
                    oprot.writeFieldEnd();
                        }
            if (lastComparison != 0) {
                lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.database, other.database);
                this.o2 = null;
                final org.apache.thrift.AsyncProcessFunction fcall = this;
                    new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, InvalidObjectException.class)
                                    org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            public void write(org.apache.thrift.protocol.TProtocol prot, get_table_req_args struct) throws org.apache.thrift.TException {
            private final java.lang.String _fieldName;
        @Override
        public add_partition_args setNew_part(@org.apache.thrift.annotation.Nullable Partition new_part) {
                    public void onError(java.lang.Exception e) {
            return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme())
                _Fields.MAX_PARTS,
                                    org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
                    }
            @org.apache.thrift.annotation.Nullable
        }
                        struct.o1.read(iprot);
            java.lang.String filter,
            }
            return recv_get_partitions_by_filter();
        /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
            public create_table_resultTupleScheme getScheme() {
                    return getSuccess();
                }
            if (this.tbl == null) {
            }
             */
            return this;
                            onError(e);
                                break;
                case TBL_NAME:
                    if (incoming.get(0)) {
        public boolean equals(get_table_req_result that) {
                ? STANDARD_SCHEME_FACTORY
                    }
                case SUCCESS:
            @org.apache.thrift.annotation.Nullable
        }
        public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
            }
                : TUPLE_SCHEME_FACTORY).getScheme();
        }
            private final java.lang.String _fieldName;
            }
                        return null;
                return false;
                            case 2: // O2
                        new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, Partition.class)
                            _LOGGER.error("TApplicationException inside handler", e);
             */
        @Override
                    java.util.BitSet incoming = iprot.readBitSet(1);
package org.opensearch.plugin.hive.metastore;
    }
                return byName.get(name);
            /**
        @org.apache.thrift.annotation.Nullable
            if (isSetFilter()) hashCode = hashCode * 8191 + filter.hashCode();
        /** Returns true if field new_part is set (has been assigned a value) and false otherwise */
            O2((short) 2, "o2");
                            case 1: // DB_NAME
                            case 1: // TBL
                throws org.apache.thrift.TException {
            (short) 2
        public @org.apache.thrift.annotation.Nullable InvalidObjectException o2; // required
                            for (int _i159 = 0; _i159 < _list157.size; ++_i159) {
            get_table_req_result> {
                oprot.writeStructEnd();
            public void write(org.apache.thrift.protocol.TProtocol prot, add_partition_args struct) throws org.apache.thrift.TException {
                        unsetO1();
            @Override
                    return isSetO2();
            }
            ) throws org.apache.thrift.TException {
        }
                if (struct.isSetO2()) {
            }
        @Override
            @Override
            }
            } else {
                }
            public void read(org.apache.thrift.protocol.TProtocol iprot, create_database_args struct) throws org.apache.thrift.TException {
            );
                                    struct.setO1IsSet(true);
            this.tbl_name = null;
            boolean that_present_o1 = true && that.isSetO1();
                    }
                        return O4;
        @Override
                    if (value == null) {
                        byte msgType = org.apache.thrift.protocol.TMessageType.REPLY;
                if (struct.tbl != null) {
                if (struct.isSetDb_name()) {
            @Override
        private static final org.apache.thrift.protocol.TField DB_NAME_FIELD_DESC = new org.apache.thrift.protocol.TField(
                                    org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
                org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
            @Override
            "o4",
            java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<
                    return lastComparison;
            public java.lang.String getFieldName() {
                )
                        return MAX_PARTS;
        public void recv_create_table() throws AlreadyExistsException, InvalidObjectException, MetaException, NoSuchObjectException,
            first = false;
                        }
            public create_database_call(
                _Fields.TBL_NAME,
        }
            /**
            }
                sb.append("null");
            }
                        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) {
                if (!this.o1.equals(that.o1)) return false;
                        struct.tbl = new Table();
            throws org.apache.thrift.TException {
            if (!first) sb.append(", ");
        public _Fields fieldForId(int fieldId) {
        /** Returns true if field success is set (has been assigned a value) and false otherwise */
                    struct.success.write(oprot);
            @Override
            if (this_present_o2 || that_present_o2) {
            I,
                    return isSetSuccess();
                if (fields == null) throw new java.lang.IllegalArgumentException("Field " + fieldId + " doesn't exist!");
        }
                oprot.writeFieldStop();
            public static _Fields findByName(java.lang.String name) {
                    }
            }
            /**
                ? STANDARD_SCHEME_FACTORY
                resultHandler,
                try {
            static {
            return this.o3;
                case O1:
            return sb.toString();
        public void setReqIsSet(boolean value) {
            if (!first) sb.append(", ");
            @Override
                }
        public void validate() throws org.apache.thrift.TException {
                }
            sb.append(")");
                                    struct.setO1IsSet(true);
                case TBL:
            return sb.toString();
            (short) 2
                    org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
                                if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
                get_partitions_by_filter_args args,
                }
                                        org.apache.thrift.protocol.TList _list152 = iprot.readListBegin();
            return this;
            }
            this.o2 = null;
                            case 2: // O2
            @org.apache.thrift.annotation.Nullable
            java.lang.StringBuilder sb = new java.lang.StringBuilder("add_partition_result(");
            }
            }
                throw result.o4;
            }
                    }
            }
            }
                            result.o1 = (AlreadyExistsException) e;
                    throw new java.lang.IllegalStateException("Method call not finished!");
                    struct.validate();
            @Override
            sb.append("o1:");
        @org.apache.thrift.annotation.Nullable
                        unsetDb_name();
            }
        private static final org.apache.thrift.protocol.TField O3_FIELD_DESC = new org.apache.thrift.protocol.TField(
            }
                final org.apache.thrift.server.AbstractNonblockingServer.AsyncFrameBuffer fb,
        }
            if (!getClass().equals(other.getClass())) {
            }
                    java.util.BitSet incoming = iprot.readBitSet(3);
        ) throws org.apache.thrift.TException {
                this.o2 = new NoSuchObjectException(other.o2);
            public get_partitions_by_filter_argsTupleScheme getScheme() {
                    return isSetO2();
                }
            sb.append("o1:");
                oprot.writeFieldBegin(MAX_PARTS_FIELD_DESC);
        public java.util.Iterator<Partition> getSuccessIterator() {
        public GetTableResult getSuccess() {
        }
            if (field == null) {
            }
            if (that == null) return false;
            throw new java.lang.IllegalStateException();
            (short) 1
                    }
            metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
        }
                if (fields == null) throw new java.lang.IllegalArgumentException("Field " + fieldId + " doesn't exist!");
                    oprot.writeString(struct.tbl_name);
                lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.o2, other.o2);
                        }
                        get_partitions_by_filter_result result = new get_partitions_by_filter_result();
                } catch (MetaException o2) {
            }
        /** Returns true if field o1 is set (has been assigned a value) and false otherwise */
                        if (e instanceof NoSuchObjectException) {
            "o1",
        @org.apache.thrift.annotation.Nullable
                } finally {
                org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
            getProcessMap(
                return new add_partition_argsTupleScheme();
                resultHandler,
                if (lastComparison != 0) {
                    struct.o1.write(oprot);
            @org.apache.thrift.annotation.Nullable
            @Override
            if (this.o1 == null) {
                        struct.setDb_nameIsSet(true);
            }
            org.apache.thrift.protocol.TType.STRUCT,
        }
        }
                        } else {
                if (struct.isSetO3()) {
            @Override
        }
        }
            @Override
                    return lastComparison;
             */
            if (isSetO4()) hashCode = hashCode * 8191 + o4.hashCode();
            setMax_partsIsSet(true);
        }
        }
            } else {
                if (struct.isSetDatabase()) {
        }
            }
                        setO2((InvalidObjectException) value);
            return hashCode;
                            break;
        }
            public get_table_req_resultTupleScheme getScheme() {
            return this.success != null;
                }
        }
                    optionals.set(1);
    @SuppressWarnings({ "cast", "rawtypes", "serial", "unchecked", "unused" })
        /**
            public void start(
                    iprot.decrementRecursionDepth();
        }
                                } else {
        public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
            if (!first) sb.append(", ");
            org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(get_table_req_args.class, metaDataMap);
                case FILTER:
                return fields;
                    }
        public void validate() throws org.apache.thrift.TException {
        @org.apache.thrift.annotation.Nullable
                case MAX_PARTS:
        }
                }
            // check for required fields
            public void read(org.apache.thrift.protocol.TProtocol prot, add_partition_result struct) throws org.apache.thrift.TException {
                read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
        @Override
            @Override
            }
            return sb.toString();
            }
                }
                    }
            public add_partition_argsTupleScheme getScheme() {
                if (struct.isSetO3()) {
        }
                }
                        struct.o2 = new NoSuchObjectException();
                    if (incoming.get(0)) {
        private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
        public void setMax_partsIsSet(boolean value) {
                        }
                }
            try {
            switch (field) {
                oprot.writeStructEnd();
                }
            boolean that_present_o4 = true && that.isSetO4();
            lastComparison = java.lang.Boolean.compare(isSetO3(), other.isSetO3());
            this.o1 = null;
            @Override
            boolean that_present_o2 = true && that.isSetO2();
        );
                throw new java.lang.IllegalArgumentException();
            ) {
                    }
                if (struct.isSetSuccess()) {
                return new create_table_resultTupleScheme();
        }
                case O2:
            public create_database_args getEmptyArgsInstance() {
                _Fields.O1,
                ? STANDARD_SCHEME_FACTORY
            if (other.isSetO4()) {
                                        struct.success = new java.util.ArrayList<Partition>(_list160.size);
        }
        public boolean isSet(_Fields field) {
            hashCode = hashCode * 8191 + ((isSetNew_part()) ? 131071 : 524287);
            }
            public boolean isOneway() {
                return result.success;
            public get_partitions_by_filter_result getResult(I iface, get_partitions_by_filter_args args)
                }
            }
                throws org.apache.thrift.TException {
                        setO3((MetaException) value);
        }
            @Override
                this.success = null;
             * Find the _Fields constant that matches name, or null if its not found.
            }
            if (field == null) {
                    return getO1();
            if (this_present_new_part || that_present_new_part) {
            );
            boolean that_present_o1 = true && that.isSetO1();
        public void create_table(Table tbl) throws AlreadyExistsException, InvalidObjectException, MetaException, NoSuchObjectException,
            I,
        }
        public add_partition_args deepCopy() {
                        switch (schemeField.id) {
            @Override
        /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
            return this;
                lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.o4, other.o4);
                    struct.o2.write(oprot);
             */
            }
                    }
                )
                    "o4",
            public java.lang.String getFieldName() {
                            case 3: // O3
                this.o4 = new NoSuchObjectException(other.o4);
        @org.apache.thrift.annotation.Nullable
                    if (value == null) {
            }
                                org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        }
        public java.lang.Object getFieldValue(_Fields field) {
        public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
        }
                )
        /** Returns true if field o4 is set (has been assigned a value) and false otherwise */
                struct.validate();
        @Override
            public short getThriftFieldId() {
            return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme())
            return this.filter;
        }
            lastComparison = java.lang.Boolean.compare(isSetSuccess(), other.isSetSuccess());
            );
            hashCode = hashCode * 8191 + ((isSetReq()) ? 131071 : 524287);
                } finally {
                    "o1",
        }
            this.req = req;
            args.setReq(req);
            O2((short) 2, "o2");
                this.o1 = null;
        @Override
                    "o2",
        public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
                read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
                    }
            java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<
        }
             * Find the _Fields constant that matches fieldId, or null if its not found.
        }
        private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, java.lang.ClassNotFoundException {
                    if (value == null) {
    public interface Iface {
        }
                        } else if (e instanceof AlreadyExistsException) {
                return new add_partition_args();
                            onError(e);
        static {
    }
            first = false;
        }
                _Fields,
            @Override
        }
             * Find the _Fields constant that matches name, or null if its not found.
            } catch (org.apache.thrift.TException te) {
        ) throws org.apache.thrift.TException {
                java.util.BitSet optionals = new java.util.BitSet();
                ? STANDARD_SCHEME_FACTORY
                _Fields.O1,
        public boolean equals(java.lang.Object that) {
            }
                } finally {
                        }
                            msg = result;
                org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
                            _LOGGER.error("TTransportException writing to internal frame buffer", e);
            if (isSetO2()) hashCode = hashCode * 8191 + o2.hashCode();
                org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
                        }
            throws org.apache.thrift.TException {
            this.o3 = null;
            /**
                oprot.writeBitSet(optionals, 1);
        }
                _Fields.SUCCESS,
            (short) 2
            }
                throw new java.io.IOException(te);
                    }
        public int hashCode() {
            Cloneable,
            if (isSetSuccess()) hashCode = hashCode * 8191 + success.hashCode();
        public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
            this.o2 = null;
            if (result.o1 != null) {
                    public void onError(java.lang.Exception e) {
                oprot.writeStructBegin(STRUCT_DESC);
                org.apache.thrift.AsyncProcessFunction<
                new org.apache.thrift.meta_data.FieldMetaData(
        }
                }
    }
                lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.tbl, other.tbl);
            if (isSetO2()) {
        public boolean isSetSuccess() {
                }
        public create_database_result setO3(@org.apache.thrift.annotation.Nullable MetaException o3) {
        private static final org.apache.thrift.protocol.TField FILTER_FIELD_DESC = new org.apache.thrift.protocol.TField(
                    prot.decrementRecursionDepth();
                    return getO1();
            }
            }
                            msg = result;
            }
            }
            recv_create_database();
                    struct.req.write(oprot);
                        schemeField = iprot.readFieldBegin();
                if (struct.isSetTbl_name()) {
            return this.o2;
        }
                return new create_database_argsStandardScheme();
                if (struct.database != null) {
            if (isSetO4()) {
        ) throws org.apache.thrift.TException;
                case O3:
                return false;
            return true;
            }
                sb.append("null");
            if (!value) {
                iprot.incrementRecursionDepth();
            public short getThriftFieldId() {
        @org.apache.thrift.annotation.Nullable
            lastComparison = java.lang.Boolean.compare(isSetDb_name(), other.isSetDb_name());
                throw result.o1;
        public static class get_table_req<I extends AsyncIface> extends org.apache.thrift.AsyncProcessFunction<
            }
                        if (e instanceof AlreadyExistsException) {
            @Override
                        return SUCCESS;
            return true;
                        }
            get_partitions_by_filter_result> {
            lastComparison = java.lang.Boolean.compare(isSetTbl_name(), other.isSetTbl_name());
                                    struct.o1 = new NoSuchObjectException();
                    prot.decrementRecursionDepth();
            if (other.isSetO2()) {
                    oprot.writeFieldEnd();
                            return;
             */
            scheme(iprot).read(iprot, this);
            tmpMap.put(
            }
                        unsetDatabase();
                    "o3",
                    break;
            java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<
                                break;
                                break;
            return this;
            }
        private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, java.lang.ClassNotFoundException {
                    byName.put(field.getFieldName(), field);
        public java.util.List<Partition> get_partitions_by_filter(
            @Override
                "get_table_req failed: unknown result"
        /**
        public void clear() {
        public java.lang.String toString() {
                    if (incoming.get(1)) {
            private final short _thriftId;
            if (other.isSetO2()) {
                return new Client(iprot, oprot);
            }
            public void read(org.apache.thrift.protocol.TProtocol prot, get_table_req_args struct) throws org.apache.thrift.TException {
                    return getO2();
                    iprot.decrementRecursionDepth();
                return _thriftId;
                final int seqid
            return this;
        }
                        struct.setFilterIsSet(true);
                                    struct.setDatabaseIsSet(true);
                org.apache.thrift.async.TAsyncClientManager clientManager,
                if (struct.o1 != null) {
                read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
            scheme(oprot).write(oprot, this);
            );
             * Find the _Fields constant that matches name, or null if its not found.
            return this;
            this.new_part = new_part;
            return false;
                                    {
        }
                            default:
            }
        public void setO3IsSet(boolean value) {
         * Performs a deep copy on <i>other</i>.
        }
            java.lang.String db_name,
                            default:
        private static final org.slf4j.Logger _LOGGER = org.slf4j.LoggerFactory.getLogger(AsyncProcessor.class.getName());
            } catch (org.apache.thrift.TException te) {
                }
                                    }
                org.apache.thrift.async.TAsyncClient client,
        public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
        }
                }
                                    struct.o3 = new MetaException();
                            fb.close();
            }
                                    struct.o1 = new MetaException();
            }
                    @Override
            @Override
        }
            if (isSetO1()) {
                        setO1((MetaException) value);
            int lastComparison = 0;
            this.o1 = o1;
                ? STANDARD_SCHEME_FACTORY
                return false;
             * Find the _Fields constant that matches name, or null if its not found.
                            default:
            }
        implements
                _Fields.DATABASE,
                    "o2",
                org.apache.thrift.transport.TNonblockingTransport transport
                if (!(this_present_success && that_present_success)) return false;
                        }
            if (isSetTbl_name()) hashCode = hashCode * 8191 + tbl_name.hashCode();
                                } else {
                return new org.apache.thrift.async.AsyncMethodCallback<Void>() {
        }
                try {
            private final short _thriftId;
        }
    public static class add_partition_args
                sb.append("null");
            return this.o2;
            @Override
                if (struct.isSetO3()) {
            if (other.isSetFilter()) {
            // check for sub-struct validity
            }
            get_partitions_result result = new get_partitions_result();
                    public void onComplete(java.util.List<Partition> o) {
            }
                return _thriftId;
            /**
        }
            return sb.toString();
            }
                this.success = new Partition(other.success);
                tbl_name,
            public java.lang.String getFieldName() {
                case DB_NAME:
        public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
            try {
        public boolean equals(get_partitions_by_filter_result that) {
        public boolean isSetO2() {
            } catch (org.apache.thrift.TException te) {
            }
        );
             */
                if (struct.o1 != null) {
                )
            (short) 4
            protected boolean rethrowUnhandledExceptions() {
            }
            Cloneable,
        @Override
         */
        public static class add_partition<I extends AsyncIface> extends org.apache.thrift.AsyncProcessFunction<
        }
                return new create_database_argsTupleScheme();
        }
            if (field == null) {
        }
            if (that instanceof create_database_args) return this.equals((create_database_args) that);
            java.io.Serializable,
                }
                )
            boolean this_present_o2 = true && this.isSetO2();
            boolean this_present_tbl_name = true && this.isSetTbl_name();
                        struct.setO3IsSet(true);
                throw new java.io.IOException(te);
        public static class get_partitions_by_filter<I extends Iface> extends org.apache.thrift.ProcessFunction<
                    oprot.writeString(struct.db_name);
        );
                                    struct.tbl_name = iprot.readString();
                        org.apache.thrift.TSerializable msg;
            @Override
            }
            /**
                    struct.o2.write(oprot);
                sb.append(this.req);
                lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.o2, other.o2);
            public add_partition_result getResult(I iface, add_partition_args args) throws org.apache.thrift.TException {
            if (lastComparison != 0) {
                        switch (schemeField.id) {
                switch (fieldId) {
                }
                                org.apache.thrift.TApplicationException.INTERNAL_ERROR,
            }
            if (!first) sb.append(", ");
            if (isSetSuccess()) hashCode = hashCode * 8191 + success.hashCode();
            return false;
            switch (field) {
            }
            return this;
                                        for (int _i162 = 0; _i162 < _list160.size; ++_i162) {
                }
                    prot.decrementRecursionDepth();
        public static class create_database_call extends org.apache.thrift.async.TAsyncMethodCall<Void> {
                oprot.writeStructBegin(STRUCT_DESC);
                    case 2: // O2
        }
                sb.append("null");
        public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
            "o1",
        @Override
                    case 2: // O2
                                    struct.filter = iprot.readString();
            @Override
            sb.append("o2:");
                                    org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
             * if it is not found.
            get_partitions_by_filter_args,
                final org.apache.thrift.server.AbstractNonblockingServer.AsyncFrameBuffer fb,
            org.apache.thrift.protocol.TType.LIST,
        }
        ) {
            return new get_partitions_args(this);
                    break;
                        oprot.writeListBegin(
            } catch (org.apache.thrift.TException te) {
                if (struct.db_name != null) {
            scheme(oprot).write(oprot, this);
         * Performs a deep copy on <i>other</i>.
            }
            switch (field) {
            org.apache.thrift.TException {
                    break;
    }
            create_table_result result = new create_table_result();
            ) {
                    result.o2 = o2;
        public void setO1IsSet(boolean value) {
            throw new org.apache.thrift.TApplicationException(
                    case 1: // NEW_PART
            if (isSetO2()) hashCode = hashCode * 8191 + o2.hashCode();
            public org.apache.thrift.async.AsyncMethodCallback<Partition> getResultHandler(
            "get_partitions_by_filter_args"
        public void unsetO1() {
            sb.append("database:");
            }
                                org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        public NoSuchObjectException getO2() {
            "o3",
                return byName.get(name);
            try {
                        } catch (java.lang.Exception e) {
                                    struct.database.read(iprot);
                }
            boolean that_present_db_name = true && that.isSetDb_name();
             */
            if (new_part != null) {
                    default:
                    byName.put(field.getFieldName(), field);
            }
            if (field == null) {
                    }
            public create_table_argsStandardScheme getScheme() {
            java.lang.StringBuilder sb = new java.lang.StringBuilder("get_table_req_args(");
            java.lang.String filter,
                    oprot.writeFieldEnd();
                    oprot.writeString(struct.db_name);
                if (!this.o3.equals(that.o3)) return false;
                        setTbl_name((java.lang.String) value);
                oprot.writeI16(struct.max_parts);
            }
                    if (value == null) {
            first = false;
        public AlreadyExistsException getO1() {
            }
                lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.max_parts, other.max_parts);
        @Override
            (short) 1
        public void unsetO2() {
            return this.o3 != null;
                    while (true) {
            org.apache.thrift.protocol.TType.STRUCT,
                                if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {
                    new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)
        public enum _Fields implements org.apache.thrift.TFieldIdEnum {
            if (result.o1 != null) {
            // check for required fields
        }
            }
                return byName.get(name);
                iprot.incrementRecursionDepth();
            }
            try {
         */
                    while (true) {
                if (struct.isSetO4()) {
        implements
                    oprot.writeI16(struct.max_parts);
                    oprot.writeFieldBegin(O1_FIELD_DESC);
        public void unsetO1() {
                return new org.apache.thrift.async.AsyncMethodCallback<java.util.List<Partition>>() {
                iface,
        public boolean equals(java.lang.Object that) {
                                    org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        @Override
                        struct.setO1IsSet(true);
                new org.apache.thrift.meta_data.FieldMetaData(
                        iprot.readFieldEnd();
                    }
        @Override
                }
            org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(get_partitions_by_filter_args.class, metaDataMap);
                if (struct.isSetTbl_name()) {
        }
                return _fieldName;
                    default:
            @Override
            @Override
                        unsetO1();
            }
            lastComparison = java.lang.Boolean.compare(isSetNew_part(), other.isSetNew_part());
                return _fieldName;
            ) throws org.apache.thrift.TException {
            return this.new_part;
                    oprot.writeFieldBegin(SUCCESS_FIELD_DESC);
        }
            }
            super(prot, prot);
        public void create_table(Table tbl, org.apache.thrift.async.AsyncMethodCallback<Void> resultHandler)
                }
            }
             */
            }
                return getClass().getName().compareTo(other.getClass().getName());
            switch (field) {
                this.req = new GetTableRequest(other.req);
         * Performs a deep copy on <i>other</i>.
        @Override
                if (struct.o2 != null) {
                throw new java.lang.IllegalArgumentException();
                    org.apache.thrift.TFieldRequirementType.DEFAULT,
                                    struct.setDb_nameIsSet(true);
        }
                                    struct.o1 = new AlreadyExistsException();
                    return getMax_parts();
            }
        }
            if (!value) {
                        }
            if (other.isSetO3()) {
                    org.apache.thrift.protocol.TField schemeField;
                        setDb_name((java.lang.String) value);
            } else {
        private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct(
                _Fields,
                                }
            static {
            tmpMap.put(
            this.o1 = null;
            java.lang.String tbl_name,
            boolean this_present_max_parts = true;
                            );
        );
            tmpMap.put(
                return new get_partitions_by_filter_result();
                iprot.incrementRecursionDepth();
            @Override
                        setReq((GetTableRequest) value);
            }
            public create_table_args getEmptyArgsInstance() {
        public void send_add_partition(Partition new_part) throws org.apache.thrift.TException {
        public get_partitions_args setDb_name(@org.apache.thrift.annotation.Nullable java.lang.String db_name) {
                if (lastComparison != 0) {
            @Override
            }
                        struct.o1.read(iprot);
            org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(get_partitions_by_filter_result.class, metaDataMap);
                return new get_partitions_args();
        }
                if (lastComparison != 0) {
                }
                    "success",
            if (lastComparison != 0) {
                        setO4((NoSuchObjectException) value);
                } finally {
            throw new java.lang.IllegalStateException();
            _Fields(short thriftId, java.lang.String fieldName) {
            }
                    }
                    if (incoming.get(3)) {
                    while (true) {
                }
        }
            get_partitions_by_filter_args> {
            }
            }
                                if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {
        /** Returns true if field req is set (has been assigned a value) and false otherwise */
            public void write_args(org.apache.thrift.protocol.TProtocol prot) throws org.apache.thrift.TException {
        public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
                return false;
        }
            public add_partition() {
            setMax_partsIsSet(true);
                java.lang.String filter,
                throws org.apache.thrift.TException {
                    new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)
            /**
                return new create_table_argsTupleScheme();
            get_partitions_by_filter_args,
                _Fields fields = findByThriftId(fieldId);
        public boolean equals(java.lang.Object that) {
            );
                } catch (NoSuchObjectException o1) {
                args.setMax_parts(max_parts);
            @Override
        }
                oprot.writeStructEnd();
            }
            }
        private static class get_partitions_by_filter_resultTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
            /**
                }
                            msgType = org.apache.thrift.protocol.TMessageType.EXCEPTION;
                            msg = new org.apache.thrift.TApplicationException(
        }
                return false;
                }
            sb.append("max_parts:");
            return sb.toString();
        }
            first = false;
                );
                iprot.incrementRecursionDepth();
         */
            if (this.database == null) {
            }
                }
            this.success = success;
                    } else {
            @org.apache.thrift.annotation.Nullable
                }
            }
                    @Override
            processMap.put("create_database", new create_database());
                        iprot.readFieldEnd();
            @Override
                struct.validate();
                }
                        setMax_parts((java.lang.Short) value);
         * Performs a deep copy on <i>other</i>.
        }
                    struct.o2.write(oprot);
             * Find the _Fields constant that matches fieldId, throwing an exception
        }
                            result.o2 = (InvalidObjectException) e;
        public java.lang.String getTbl_name() {
            this.success = null;
            Cloneable,
            ) {
            if (other.isSetO1()) {
                ? STANDARD_SCHEME_FACTORY
            if (isSetDatabase()) {
                            default:
            } catch (org.apache.thrift.TException te) {
            private static final java.util.Map<java.lang.String, _Fields> byName = new java.util.HashMap<java.lang.String, _Fields>();
                                }
                if (struct.o2 != null) {
        }
                    org.apache.thrift.protocol.TField schemeField;
            @org.apache.thrift.annotation.Nullable
                _fieldName = fieldName;
                    } else {
            (short) 1
        public java.lang.String getFilter() {
            scheme(oprot).write(oprot, this);
            } else {
            return this;
                return getClass().getName().compareTo(other.getClass().getName());
        public java.lang.Object getFieldValue(_Fields field) {
                return fields;
            @Override
                _thriftId = thriftId;
        @Override
        }
        public void recv_create_database() throws AlreadyExistsException, InvalidObjectException, MetaException,
                        } catch (org.apache.thrift.transport.TTransportException e) {
            return this;
            this.o3 = null;
            java.lang.String tbl_name,
        /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
            return this;
                    case 3: // O3
        public void get_partitions_by_filter(
                            case 2: // TBL_NAME
        }
                                    org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        @org.apache.thrift.annotation.Nullable
        private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, java.lang.ClassNotFoundException {
        }
        public static class create_table_call extends org.apache.thrift.async.TAsyncMethodCall<Void> {
                        {
                                    struct.new_part = new Partition();
            if (isSetO3()) {
                        struct.o3.read(iprot);
                oprot.writeBitSet(optionals, 1);
                                }
            super(iprot, oprot);
public class ThriftHiveMetastore {
                this.o4 = null;
                    oprot.writeFieldBegin(O3_FIELD_DESC);
            java.lang.StringBuilder sb = new java.lang.StringBuilder("get_partitions_by_filter_result(");
            java.lang.StringBuilder sb = new java.lang.StringBuilder("create_table_result(");
            sb.append("db_name:");
            if (!getClass().equals(other.getClass())) {
            }
        ) throws org.apache.thrift.TException;
            __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __MAX_PARTS_ISSET_ID, value);
            }
                case SUCCESS:
        @Override
                    new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, InvalidObjectException.class)
                return _fieldName;
            @org.apache.thrift.annotation.Nullable
            return;
                }
        public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
        @org.apache.thrift.annotation.Nullable
            );
                super("get_partitions_by_filter");
        public boolean equals(add_partition_result that) {
                        } else if (e instanceof org.apache.thrift.TApplicationException) {
                            case 2: // TBL_NAME
                lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.new_part, other.new_part);
                    struct.o2.write(oprot);
            @Override
            receiveBase(result, "get_partitions_by_filter");
        public static class add_partition_call extends org.apache.thrift.async.TAsyncMethodCall<Partition> {
            getProcessMap(
                    oprot.writeFieldEnd();
                            case 0: // SUCCESS
            return hashCode;
            if (other.isSetO2()) {
                case MAX_PARTS:
        }
             * Find the _Fields constant that matches fieldId, throwing an exception
            @Override
            if (other.isSetO1()) {
            if (this.success == null) {
            public short getThriftFieldId() {
                    } else {
                                org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
        }
    public static class create_table_result
        }
    @SuppressWarnings({ "cast", "rawtypes", "serial", "unchecked", "unused" })
            );
            }
            short max_parts,
                    oprot.writeFieldBegin(FILTER_FIELD_DESC);
            }
                }
        }
                for (_Fields field : java.util.EnumSet.allOf(_Fields.class)) {
        }
                            case 1: // DATABASE
                    } else {
        }
                this.o1 = new MetaException(other.o1);
            try {
            if (this == that) return true;
                                    struct.setDb_nameIsSet(true);
                prot.writeMessageEnd();
}
                if (!(this_present_o3 && that_present_o3)) return false;
                    struct.success.write(oprot);
            metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
                } catch (AlreadyExistsException o1) {
            // check for required fields
    @SuppressWarnings({ "cast", "rawtypes", "serial", "unchecked", "unused" })
        }
        private static class create_table_resultStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
