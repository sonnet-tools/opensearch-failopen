                    optionals.set(1);  
            args.setMax_parts(max_parts);
        }  
            if (isSetO1()) hashCode = hashCode * 8191 + o1.hashCode();
                    throw new java.lang.IllegalStateException("Method call not finished!");  
        private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {  
            private static final java.util.Map<java.lang.String, _Fields> byName = new java.util.HashMap<java.lang.String, _Fields>();
                }  
            public get_table_req() {
                oprot.writeBitSet(optionals, 3);
                org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
                throw new java.io.IOException(te);
                        }
        }
            }
                } finally {
            // check for sub-struct validity
                        } else if (e instanceof org.apache.thrift.transport.TTransportException) {
         */  
                }  
        public boolean equals(get_partitions_args that) {
            metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
            return this.o1 != null;
                );  
                                }
        private static class get_partitions_by_filter_resultTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {  
            first = false;
            }
            (short) 3
    public static class create_database_result  
        private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
            }
            if (other.isSetO3()) {
            );  
                                }
        @org.apache.thrift.annotation.Nullable
    @SuppressWarnings({ "cast", "rawtypes", "serial", "unchecked", "unused" })
                    }
            @Override
            receiveBase(result, "add_partition");
                return new get_partitions_by_filter_result();
        private static class get_partitions_resultStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
                            _LOGGER.error("Exception writing to internal frame buffer", e);  
                java.lang.String tbl_name,  
                            case 1: // O1
        private static class add_partition_resultTupleScheme extends org.apache.thrift.scheme.TupleScheme<add_partition_result> {  
            }
        public static class create_table<I extends AsyncIface> extends org.apache.thrift.AsyncProcessFunction<
                try {
                                    }
            if (lastComparison != 0) {  
                    iprot.readStructBegin();
                    if (value == null) {  
                        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) {  
                sb.append(this.o2);  
        static {
        public boolean isSetSuccess() {  
        }
                            );
        implements
            org.apache.thrift.protocol.TType.LIST,
                org.apache.thrift.transport.TNonblockingTransport transport  
                    new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)
                        org.apache.thrift.TSerializable msg;
            }  
                                    struct.o1.read(iprot);
        private static class create_database_resultTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {  
            if (success != null) {
            if (!first) sb.append(", ");  
        @org.apache.thrift.annotation.Nullable
            return this.success != null;
        }
        public java.util.Iterator<Partition> getSuccessIterator() {
            public void start(I iface, create_table_args args, org.apache.thrift.async.AsyncMethodCallback<Void> resultHandler)
        );
        public static class add_partition_call extends org.apache.thrift.async.TAsyncMethodCall<Partition> {
                                }
                    case 2: // O2
            @Override
            }
            recv_create_database();
                        struct.o1.read(iprot);
                    iprot.readStructBegin();
            @Override
            if (isSetO4()) hashCode = hashCode * 8191 + o4.hashCode();
            tmpMap.put(  
        public boolean equals(java.lang.Object that) {  
                                org.apache.thrift.TApplicationException.INTERNAL_ERROR,
            return _Fields.findByThriftId(fieldId);  
                get_table_req_args args = new get_table_req_args();  
        static {
            if (!value) {
                org.apache.thrift.async.AsyncMethodCallback<java.util.List<Partition>> resultHandler,  
            public short getThriftFieldId() {  
                super("get_table_req");
                    optionals.set(1);
        }  
                    struct.o1.write(oprot);
        @org.apache.thrift.annotation.Nullable
             * if it is not found.
                    struct.o1.write(oprot);
        }
            SUCCESS((short) 0, "success"),
                    return isSetO1();  
        public java.lang.String toString() {
                return new create_database_argsStandardScheme();
            first = false;  
                    break;  
        public enum _Fields implements org.apache.thrift.TFieldIdEnum {
                org.apache.thrift.AsyncProcessFunction<I, ? extends org.apache.thrift.TBase, ?, ? extends org.apache.thrift.TBase>>
            _Fields(short thriftId, java.lang.String fieldName) {
            ) throws org.apache.thrift.TException {  
        /** Returns true if field max_parts is set (has been assigned a value) and false otherwise */
            return true;
                        setSuccess((java.util.List<Partition>) value);
                    case 2: // O2  
            }
                    @Override
                switch (fieldId) {
            if (isSetSuccess()) hashCode = hashCode * 8191 + success.hashCode();
            }
            }
            @Override
                org.apache.thrift.ProcessFunction<I, ? extends org.apache.thrift.TBase, ? extends org.apache.thrift.TBase>> processMap  
            }
            public static _Fields findByThriftIdOrThrow(int fieldId) {  
                    }
                            fcall.sendResponse(fb, result, org.apache.thrift.protocol.TMessageType.REPLY, seqid);
        }  
            return this.o2 != null;  
            }  
            public short getThriftFieldId() {
            }
            }
        public boolean isSetO3() {  
        }  
                            fcall.sendResponse(fb, msg, msgType, seqid);
            if (lastComparison != 0) {  
            public void write(org.apache.thrift.protocol.TProtocol prot, create_table_result struct) throws org.apache.thrift.TException {
            }
        @Override  
            }  
                            msg = result;  
            public void start(I iface, get_table_req_args args, org.apache.thrift.async.AsyncMethodCallback<GetTableResult> resultHandler)
                        return SUCCESS;  
                    struct.validate();  
                    if (incoming.get(0)) {
                                    struct.o2 = new MetaException();
                            result.setO2IsSet(true);
            // check for sub-struct validity
                return fields;  
                        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) {  
            short max_parts
                }
            }
        public static class get_partitions_by_filter_call extends org.apache.thrift.async.TAsyncMethodCall<java.util.List<Partition>> {
                        }  
                    optionals.set(0);  
                        switch (schemeField.id) {
                                    struct.o1.read(iprot);
                return _thriftId;
                    }  
        /**
                        }
             * Find the _Fields constant that matches fieldId, or null if its not found.  
            this.database = null;
                org.apache.thrift.async.TAsyncClient client,
        public short max_parts; // required  
            return _Fields.findByThriftId(fieldId);
            if (this_present_tbl_name || that_present_tbl_name) {  
        }  
        }
                        unsetO2();  
                sb.append(this.o3);
                return new add_partition_resultStandardScheme();
                        get_partitions_by_filter_result result = new get_partitions_by_filter_result();
                sb.append("null");
            boolean this_present_o1 = true && this.isSetO1();
        @Override  
            public create_database_args getEmptyArgsInstance() {
            protected boolean rethrowUnhandledExceptions() {
            @Override
            return true;  
        }  
        @org.apache.thrift.annotation.Nullable
                    org.apache.thrift.protocol.TField schemeField;
                        create_table_result result = new create_table_result();  
            @Override
                args.setDb_name(db_name);  
            @Override
                    break;
            add_partition_args,  
            return sb.toString();
        private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY =
            Comparable<get_partitions_by_filter_result> {
        public NoSuchObjectException getO4() {  
        public @org.apache.thrift.annotation.Nullable MetaException o1; // required
                        struct.req.read(iprot);  
            }
            @Override
                    case 3: // O3
        }
            if (!first) sb.append(", ");  
            tmpMap.put(  
            if (this.o3 == null) {
                prot.writeMessageEnd();
            if (isSetO3()) {
            }
        }
            public short getThriftFieldId() {
            __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __MAX_PARTS_ISSET_ID, value);
            if (lastComparison != 0) {
                this.db_name = other.db_name;
        public void validate() throws org.apache.thrift.TException {
                if (struct.isSetDb_name()) {
        /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
                }
        public @org.apache.thrift.annotation.Nullable MetaException o3; // required
                args.setMax_parts(max_parts);  
                            case 2: // O2  
            }  
                    return lastComparison;  
            }  
            }  
                if (!this.success.equals(that.success)) return false;
                    return getTbl();
            }
        public void setSuccessIsSet(boolean value) {
            setMax_partsIsSet(true);
                case O1:  
            java.lang.String db_name,  
                org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
                    iprot.readStructEnd();  
                }  
                }  
                }  
                                break;  
            first = false;
            }
        public void setFieldValue(_Fields field, @org.apache.thrift.annotation.Nullable java.lang.Object value) {
        }  
                    optionals.set(2);
                }
            return this.tbl_name;
                        return DATABASE;
        public void unsetO2() {  
                            result.setO1IsSet(true);
            sb.append(")");  
            Cloneable,
                }  
            } else {
                prot.writeMessageBegin(
        }  
            if (!value) {
                lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.success, other.success);
        );
            }
        @Override  
            public Void getResult() throws AlreadyExistsException, InvalidObjectException, MetaException, NoSuchObjectException,
            public boolean isOneway() {
        }
        public java.lang.Object getFieldValue(_Fields field) {  
                } finally {
                        struct.setNew_partIsSet(true);  
            Cloneable,
            }  
                    return lastComparison;  
        public get_partitions_args(get_partitions_args other) {
                )
    public static class get_partitions_result  
        public boolean isSetO1() {
            hashCode = hashCode * 8191 + ((isSetReq()) ? 131071 : 524287);
            if (this_present_db_name || that_present_db_name) {
                throw new java.io.IOException(te);
                this.o3 = null;  
        }  
            "o1",
            } catch (org.apache.thrift.TException te) {
            if (this.o1 == null) {  
        }
                )
                        } else if (e instanceof NoSuchObjectException) {
                                if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
                if (lastComparison != 0) {
        public boolean isSetO1() {
                        iprot.readFieldEnd();
        @Override
                    getFrameBuffer().array()  
                    optionals.set(0);
                            fb.close();  
                            case 3: // MAX_PARTS
                throw new java.io.IOException(te);
            public static _Fields findByName(java.lang.String name) {
        private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("create_table_args");
            static {  
        @Override
        public void unsetO1() {
                        } else if (e instanceof org.apache.thrift.TApplicationException) {  
            if (other.isSetReq()) {  
            this.filter = null;  
            if (result.o1 != null) {
                } finally {  
            }
            }  
            private final java.lang.String _fieldName;
            metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
            @Override
                )
                                    org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
                    }
            } catch (org.apache.thrift.TException te) {
            private short max_parts;
                read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));  
                                    org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
                    while (true) {
                : TUPLE_SCHEME_FACTORY).getScheme();
                        unsetFilter();
            }
            }  
            throw new java.lang.IllegalStateException();
                            onError(e);
                    org.apache.thrift.TFieldRequirementType.DEFAULT,
                }
            lastComparison = java.lang.Boolean.compare(isSetMax_parts(), other.isSetMax_parts());
        }  
                throw new java.io.IOException(te);
            if (!value) {  
        );
                                } else {  
                    new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, Table.class)  
                prot.writeMessageEnd();
            try {
            }  
                java.util.Map<
                }
                ? STANDARD_SCHEME_FACTORY
                            onError(e);  
                case DB_NAME:
        }  
                throw new java.io.IOException(te);
            }
            public create_table_call(  
        }
                for (_Fields field : java.util.EnumSet.allOf(_Fields.class)) {  
                                    struct.tbl_name = iprot.readString();
                                } else {  
            return false;
                )  
                                }
            @Override
        // isset id assignments
                    }
                                    struct.setO4IsSet(true);
            // check for sub-struct validity
            }
            try {  
                return getClass().getName().compareTo(other.getClass().getName());
            public static _Fields findByThriftId(int fieldId) {
             */
            if (!value) {
                            _LOGGER.error("TTransportException writing to internal frame buffer", e);
                this.database = database;
            if (!first) sb.append(", ");  
        }  
        public static class create_table_call extends org.apache.thrift.async.TAsyncMethodCall<Void> {  
        /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
            }
                                    struct.setO2IsSet(true);  
        public InvalidObjectException getO1() {
                return getClass().getName().compareTo(other.getClass().getName());  
        @org.apache.thrift.annotation.Nullable  
                if (struct.o1 != null) {
        public void clear() {
                                } else {
                    iprot.decrementRecursionDepth();
            if (this_present_o3 || that_present_o3) {
            return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme())  
            }
                        return O1;
                            msg = (org.apache.thrift.TApplicationException) e;  
        public enum _Fields implements org.apache.thrift.TFieldIdEnum {  
        ) throws MetaException, NoSuchObjectException, org.apache.thrift.TException;
            if (field == null) {
            java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<  
        }
                    if (incoming.get(1)) {
                if (struct.o3 != null) {
        public boolean isSetTbl() {  
        }
        public Partition add_partition(Partition new_part) throws InvalidObjectException, AlreadyExistsException, MetaException,
             */
        }  
            } catch (org.apache.thrift.TException te) {
            first = false;
                    case 2: // O2
        public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
                    org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
        }  
                    org.apache.thrift.TFieldRequirementType.DEFAULT,
                sb.append("null");
            if (that == null) return false;  
                    optionals.set(0);
            if (this_present_o2 || that_present_o2) {
                    } else {  
        ) throws org.apache.thrift.TException;  
            sendBase("add_partition", args);
                    struct.o1.write(oprot);
            @org.apache.thrift.annotation.Nullable
            org.apache.thrift.async.AsyncMethodCallback<java.util.List<Partition>> resultHandler
            @Override
        public add_partition_result(Partition success, InvalidObjectException o1, AlreadyExistsException o2, MetaException o3) {  
        @Override  
            this.max_parts = other.max_parts;
        public get_table_req_result(get_table_req_result other) {  
        public boolean isSetO2() {
                    case 1: // O1
                                e.getMessage()  
            sb.append("o3:");  
            }
                        unsetO1();
            public void read(org.apache.thrift.protocol.TProtocol iprot, get_partitions_args struct) throws org.apache.thrift.TException {
            this();  
            send_get_partitions_by_filter(db_name, tbl_name, filter, max_parts);
        @org.apache.thrift.annotation.Nullable
        public boolean equals(add_partition_args that) {  
            ) throws org.apache.thrift.TException {
                write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
        }
                }
            @Override
        /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
            add_partition_call method_call = new add_partition_call(new_part, resultHandler, this, ___protocolFactory, ___transport);
            if (result.isSetSuccess()) {
            int lastComparison = 0;
                if (!(this_present_o3 && that_present_o3)) return false;
                try {
        // isset id assignments
                }  
                            case 3: // O3
        public enum _Fields implements org.apache.thrift.TFieldIdEnum {  
        @Override  
                    struct.o3.write(oprot);
            throw new java.lang.IllegalStateException();
            org.apache.thrift.protocol.TType.STRUCT,
        }
                    }  
                }  
        public void create_database(Database database, org.apache.thrift.async.AsyncMethodCallback<Void> resultHandler)
                                if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {  
                        unsetO2();
            return _Fields.findByThriftId(fieldId);
            "max_parts",
                                }
                new org.apache.thrift.meta_data.FieldMetaData(
                this.o1 = new MetaException(other.o1);
                }
                                }
        @Override  
                return new create_database_result();
                sb.append("null");
        }
            org.apache.thrift.TBase<create_table_result, create_table_result._Fields>,
                return lastComparison;
                    new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, MetaException.class)  
    }  
        }
        public void send_create_database(Database database) throws org.apache.thrift.TException {
                sb.append(this.o2);
                                org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);  
                if (!this.o2.equals(that.o2)) return false;
                    throw new java.lang.IllegalStateException("Method call not finished!");
                                break;
            return _Fields.findByThriftId(fieldId);  
        @Override  
                        schemeField = iprot.readFieldBegin();  
                    } else {
        public void add_partition(Partition new_part, org.apache.thrift.async.AsyncMethodCallback<Partition> resultHandler)
        }
        @Override
            public short getThriftFieldId() {  
                            msgType = org.apache.thrift.protocol.TMessageType.EXCEPTION;
                            _LOGGER.error("TApplicationException inside handler", e);  
            // check for sub-struct validity
            // check for required fields
                return new add_partition_argsStandardScheme();
                if (struct.isSetTbl_name()) {
                read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));  
            }  
                            result.setO2IsSet(true);
                        byte msgType = org.apache.thrift.protocol.TMessageType.REPLY;
                        }  
            return new get_partitions_result(this);
        }
                                if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {  
                : TUPLE_SCHEME_FACTORY).getScheme();  
        public boolean isSetSuccess() {  
            this();
            } else {  
            this.___currentMethod = method_call;  
            org.apache.thrift.TBase<get_partitions_by_filter_result, get_partitions_by_filter_result._Fields>,
            } else {  
                        return O2;
            java.io.Serializable,  
        public boolean isSetSuccess() {  
                java.util.BitSet optionals = new java.util.BitSet();
        public void unsetO3() {
            }
                    struct.validate();  
        public java.lang.String toString() {
                                break;
                if (struct.isSetSuccess()) {
                    org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
            return this.max_parts;  
        public @org.apache.thrift.annotation.Nullable MetaException o1; // required  
            } else {  
        }
                        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) {
                    oprot.writeFieldEnd();  
                        struct.o3 = new MetaException();
            static {  
            get_partitions_by_filter_result result = new get_partitions_by_filter_result();
                throw result.o1;  
            _Fields(short thriftId, java.lang.String fieldName) {  
                }
            java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<
                    iprot.readStructEnd();
            if (result.o1 != null) {
                        try {
            _Fields(short thriftId, java.lang.String fieldName) {
            if (this_present_req || that_present_req) {
        public add_partition_result(add_partition_result other) {
                }
        }
                            _LOGGER.error("TTransportException writing to internal frame buffer", e);  
            org.apache.thrift.TException;
                iprot.incrementRecursionDepth();  
                )
            this.o2 = o2;
            public void write(org.apache.thrift.protocol.TProtocol prot, create_database_result struct)
        private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct(  
                sb.append("null");  
                            msgType = org.apache.thrift.protocol.TMessageType.EXCEPTION;  
            this.o2 = null;
                if (struct.tbl_name != null) {
                try {
            }
            args.setDatabase(database);  
            I,
                sb.append("null");
                        org.apache.thrift.TSerializable msg;  
            @Override
                get_partitions_args args,
                                if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {
            boolean first = true;  
                }  
        public java.lang.String toString() {  
                            result.setO2IsSet(true);
            private Table tbl;
        @org.apache.thrift.annotation.Nullable  
                        return SUCCESS;
        }
        }
            if (that instanceof get_partitions_by_filter_result) return this.equals((get_partitions_by_filter_result) that);
            public void write_args(org.apache.thrift.protocol.TProtocol prot) throws org.apache.thrift.TException {  
                for (_Fields field : java.util.EnumSet.allOf(_Fields.class)) {
                    while (true) {  
         * Performs a deep copy on <i>other</i>.  
                        struct.o2.read(iprot);  
                this.tbl = new Table(other.tbl);
            }
                    break;  
                }
            }
                    return isSetO3();
            boolean that_present_o2 = true && that.isSetO2();  
                    @Override  
                    struct.validate();  
        public enum _Fields implements org.apache.thrift.TFieldIdEnum {
                        add_partition_result result = new add_partition_result();
                        struct.o1 = new AlreadyExistsException();  
            return this;
            sb.append(")");
            return this.o3 != null;
            @Override
            if (other.isSetSuccess()) {
                return _fieldName;  
             * Find the _Fields constant that matches name, or null if its not found.
                java.util.BitSet optionals = new java.util.BitSet();
        }
        }
                lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.o3, other.o3);
            if (this.db_name == null) {  
                this.o2 = null;
                            msg = result;
            java.lang.StringBuilder sb = new java.lang.StringBuilder("get_table_req_result(");
        public int hashCode() {  
                    byName.put(field.getFieldName(), field);
                    iprot.readStructBegin();  
            tmpMap.put(
            @Override  
            (short) 1
                                if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {  
            hashCode = hashCode * 8191 + ((isSetO2()) ? 131071 : 524287);
                    if (value == null) {
            public get_partitions_argsTupleScheme getScheme() {
                org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
                                break;
                    struct.success.write(oprot);
        }  
            } else {
            new create_table_resultStandardSchemeFactory();
        private static class create_database_argsTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
            this.req = null;
        @org.apache.thrift.annotation.Nullable
        public _Fields fieldForId(int fieldId) {
            java.lang.String tbl_name,
                    case 0: // SUCCESS  
            boolean that_present_req = true && that.isSetReq();  
                                    struct.filter = iprot.readString();  
                                }  
                }
                try {
                return lastComparison;  
                    org.apache.thrift.TFieldRequirementType.DEFAULT,
        public get_partitions_by_filter_result() {}
        public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
                        struct.setO3IsSet(true);  
            public void read(org.apache.thrift.protocol.TProtocol prot, get_table_req_result struct) throws org.apache.thrift.TException {
            }
            this.o3 = o3;
                case SUCCESS:  
            if (!first) sb.append(", ");
                _Fields,
            try {
                throws org.apache.thrift.TException {
            public add_partition_argsStandardScheme getScheme() {
            if (!value) {
                oprot.writeBitSet(optionals, 4);
        }
                            _iter163.write(oprot);
            first = false;
        public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
        @Override  
            tmpMap.put(
                this.o1 = null;
                return false;  
                if (struct.isSetO2()) {  
                case TBL_NAME:
                this.db_name = db_name;
        public @org.apache.thrift.annotation.Nullable Partition success; // required  
            public get_table_req_resultStandardScheme getScheme() {
                case REQ:
            @Override
        /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */  
        public void clear() {  
                    oprot.writeFieldEnd();  
        }
            @Override  
            );
            args.setDb_name(db_name);
            if (isSetFilter()) {
            O2((short) 2, "o2"),
        );
            public void write(org.apache.thrift.protocol.TProtocol prot, get_partitions_by_filter_result struct)
            return this;  
                return result;  
            }
                        struct.setO2IsSet(true);
            throw new java.lang.IllegalStateException();
                sb.append("null");  
        private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new create_table_argsTupleSchemeFactory();
        @Override
                db_name,  
        private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, java.lang.ClassNotFoundException {
                return lastComparison;
            this.o3 = null;  
                case DATABASE:
            }
                return result;  
                            _LOGGER.error("TTransportException inside handler", e);  
                this.db_name = null;
                        setO3((MetaException) value);
                    }
        public int hashCode() {
                        byte msgType = org.apache.thrift.protocol.TMessageType.REPLY;  
            __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __MAX_PARTS_ISSET_ID);
                            result.setO3IsSet(true);  
            } else {
        }
                    org.apache.thrift.TFieldRequirementType.DEFAULT,
         */  
        public int compareTo(create_database_args other) {  
        @org.apache.thrift.annotation.Nullable  
                    iprot.decrementRecursionDepth();
            }  
            if (other.isSetDb_name()) {
                        }
            return hashCode;  
                if (struct.isSetReq()) {
            this.___currentMethod = method_call;
                case O3:
            throw new java.lang.IllegalStateException();
                this.o2 = new InvalidObjectException(other.o2);  
        private static class get_partitions_by_filter_argsStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
            if (isSetO3()) hashCode = hashCode * 8191 + o3.hashCode();
                sb.append(this.o1);
        }
        public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    public static class get_partitions_args  
                if (!this.tbl.equals(that.tbl)) return false;  
                oprot.writeFieldStop();  
                }  
                        oprot.writeListBegin(
        }
            private static final java.util.Map<java.lang.String, _Fields> byName = new java.util.HashMap<java.lang.String, _Fields>();
                java.util.BitSet optionals = new java.util.BitSet();  
            switch (field) {
            tmpMap.put(
            if (this.o2 == null) {  
            }  
                } finally {
                oprot.writeStructEnd();
                        schemeField = iprot.readFieldBegin();  
        }
             */
                _Fields.O3,
                    oprot.writeFieldBegin(SUCCESS_FIELD_DESC);
        @Override  
                    oprot.writeString(struct.filter);
                        switch (schemeField.id) {  
            sb.append("o2:");  
            this.max_parts = 0;
        }
                ? STANDARD_SCHEME_FACTORY  
                }  
            @Override  
                    break;  
            org.apache.thrift.protocol.TType.STRUCT,
                        struct.database = new Database();  
                    result.o2 = o2;
            }
                if (struct.tbl_name != null) {  
                return new create_table_resultTupleScheme();
        public java.lang.String toString() {
                    new java.util.HashMap<  
        public AlreadyExistsException getO1() {  
            boolean this_present_o1 = true && this.isSetO1();
            int hashCode = 1;
        private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
                throw new java.io.IOException(te);
                org.apache.thrift.TApplicationException.MISSING_RESULT,
                    java.util.BitSet incoming = iprot.readBitSet(1);  
            this.db_name = db_name;  
                if (struct.o1 != null) {
                args.setTbl_name(tbl_name);
            return hashCode;
            public void write_args(org.apache.thrift.protocol.TProtocol prot) throws org.apache.thrift.TException {
        @Override  
                oprot.writeBitSet(optionals, 1);  
                                if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {  
                write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));  
            }
                }
                case O2:
                if (struct.success != null) {
            if (this.o1 == null) {
        public @org.apache.thrift.annotation.Nullable java.lang.String filter; // required
                final int seqid
            this.db_name = db_name;
                if (lastComparison != 0) {  
                }
            public add_partition_resultTupleScheme getScheme() {
                oprot.writeBitSet(optionals, 3);
            }
                            _LOGGER.error("TApplicationException inside handler", e);
        private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, java.lang.ClassNotFoundException {  
            switch (field) {  
            boolean first = true;
                    oprot.writeFieldEnd();
        @Override  
                iprot.incrementRecursionDepth();
                                _elem158.read(iprot);  
             * Find the _Fields constant that matches fieldId, throwing an exception
            if (this.o3 == null) {
                if (lastComparison != 0) {
            } catch (org.apache.thrift.TException te) {
        public get_partitions_by_filter_args(
                                    struct.o4 = new NoSuchObjectException();  
public class ThriftHiveMetastore {  
            }
        }
            get_partitions_call method_call = new get_partitions_call(  
            receiveBase(result, "get_partitions_by_filter");
        public boolean isSet(_Fields field) {
            }  
             * Find the _Fields constant that matches name, or null if its not found.
                    default:
                            result.o2 = (InvalidObjectException) e;
                if (struct.o2 != null) {
             */  
                _Fields,
            public static _Fields findByThriftIdOrThrow(int fieldId) {
                    oprot.writeFieldEnd();
            return this;
                    oprot.writeFieldBegin(TBL_FIELD_DESC);
        public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
            this.filter = filter;
                        }
            boolean that_present_tbl_name = true && that.isSetTbl_name();
        public void setFieldValue(_Fields field, @org.apache.thrift.annotation.Nullable java.lang.Object value) {
                    oprot.writeFieldBegin(O1_FIELD_DESC);  
                    org.apache.thrift.TFieldRequirementType.DEFAULT,
            );  
                    case 3: // MAX_PARTS
            hashCode = hashCode * 8191 + ((isSetNew_part()) ? 131071 : 524287);  
            }  
            (short) 1
                (new Client(prot)).recv_create_table();
            }
                lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.o2, other.o2);
        public enum _Fields implements org.apache.thrift.TFieldIdEnum {  
                    new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, GetTableResult.class)
            org.apache.thrift.TException {
                sb.append(this.db_name);  
            return new get_partitions_args(this);  
                return _fieldName;  
                org.apache.thrift.transport.TNonblockingTransport transport
                            default:  
            }
                filter,
            }  
                new org.apache.thrift.meta_data.FieldMetaData(
            public static _Fields findByThriftIdOrThrow(int fieldId) {  
                            case 2: // TBL_NAME  
        public int hashCode() {
                    case 0: // SUCCESS  
                oprot.writeStructEnd();
            public static _Fields findByThriftIdOrThrow(int fieldId) {  
            this();
            if (other.isSetO2()) {
        public void setDb_nameIsSet(boolean value) {  
                (new Client(prot)).recv_create_database();
        private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY =
            }
                throw new java.io.IOException(te);  
        }
                if (!(this_present_o2 && that_present_o2)) return false;
            tmpMap.put(
            boolean that_present_o3 = true && that.isSetO3();
                if (fields == null) throw new java.lang.IllegalArgumentException("Field " + fieldId + " doesn't exist!");
        public get_partitions_result(java.util.List<Partition> success, NoSuchObjectException o1, MetaException o2) {  
                if (!this.tbl_name.equals(that.tbl_name)) return false;
            if (this_present_o1 || that_present_o1) {  
        }
            @Override  
            return this.new_part != null;  
            throws org.apache.thrift.TException;  
            }  
                }
            return sb.toString();
                    case 1: // O1
                return (new Client(prot)).recv_get_table_req();  
                } finally {  
        }
        /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
            org.apache.thrift.TBase<create_database_args, create_database_args._Fields>,
            );  
            }
                }
            try {
            }
            @Override
                                }  
            public void read(org.apache.thrift.protocol.TProtocol prot, get_table_req_args struct) throws org.apache.thrift.TException {
                oprot.writeStructBegin(STRUCT_DESC);
             * Find the _Fields constant that matches fieldId, throwing an exception  
            );  
            if (this == that) return true;
            }
                    org.apache.thrift.TFieldRequirementType.DEFAULT,  
            public java.util.List<Partition> getResult() throws MetaException, NoSuchObjectException, org.apache.thrift.TException {  
                                    struct.new_part = new Partition();
            private static final java.util.Map<java.lang.String, _Fields> byName = new java.util.HashMap<java.lang.String, _Fields>();  
            if (this_present_success || that_present_success) {
        /** Returns true if field o3 is set (has been assigned a value) and false otherwise */
                            msg = new org.apache.thrift.TApplicationException(
            );  
        /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */  
                    optionals.set(1);
            if (that == null) return false;
        }
        }
            }  
                if (!(this_present_db_name && that_present_db_name)) return false;  
        }
                        schemeField = iprot.readFieldBegin();
            return false;
                java.util.BitSet optionals = new java.util.BitSet();
                            for (int _i167 = 0; _i167 < _list165.size; ++_i167) {  
            @Override  
            sb.append("o2:");  
            private java.lang.String db_name;
        public boolean isSetO2() {
                        return O2;  
            this.tbl_name = null;
                }
                    return isSetSuccess();
             * if it is not found.  
            }  
            );  
                    oprot.writeFieldBegin(O2_FIELD_DESC);  
            }
            }
                if (lastComparison != 0) {  
                    getFrameBuffer().array()
            }
                    if (incoming.get(1)) {  
            hashCode = hashCode * 8191 + ((isSetO3()) ? 131071 : 524287);
        public @org.apache.thrift.annotation.Nullable Database database; // required
        }
                case O3:  
                    oprot.writeFieldEnd();  
        @Override
                new org.apache.thrift.meta_data.FieldMetaData(  
             * Find the _Fields constant that matches name, or null if its not found.  
                for (Partition other_element : other.success) {
                                    struct.setReqIsSet(true);
                }  
                switch (fieldId) {
                prot.incrementRecursionDepth();  
                case O2:
                throw new java.io.IOException(te);
                case O1:
            }
                return new get_partitions_argsTupleScheme();  
        }  
                        }
            }
                        return O3;
            }
            hashCode = hashCode * 8191 + ((isSetO1()) ? 131071 : 524287);
            private final short _thriftId;
            }
            return this.success;
                super(client, protocolFactory, transport, resultHandler, false);
            }
        private static class get_table_req_argsTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {  
        @Override
            @Override
            create_table_result> {
            }
        implements
        }
        }
            try {
                throw new java.io.IOException(te);  
                org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
                }
        }  
             * if it is not found.
                max_parts,  
                    I,
                            _LOGGER.error("Exception writing to internal frame buffer", ex);
        @Override
                org.apache.thrift.protocol.TProtocol prot = client.getProtocolFactory().getProtocol(memoryTransport);  
            (short) 2  
            boolean that_present_o1 = true && that.isSetO1();
            return this;  
            }
                case SUCCESS:  
                    break;
                }  
             */  
            O2((short) 2, "o2");
                case O2:
                _Fields fields = findByThriftId(fieldId);
            static {
            if (!value) {  
            lastComparison = java.lang.Boolean.compare(isSetO3(), other.isSetO3());  
        @Override
                write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
            switch (field) {  
                    ? extends org.apache.thrift.TBase,
                return _fieldName;
                    }
            org.apache.thrift.protocol.TType.STRUCT,
                case O1:  
                sb.append("null");
        }  
                args.write(prot);  
             */  
                    public void onComplete(GetTableResult o) {
                            msg = result;  
            switch (field) {  
                                    org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        }  
            } else {
                        }
        );  
            /**
        public void setFieldValue(_Fields field, @org.apache.thrift.annotation.Nullable java.lang.Object value) {  
                case O1:
                            _LOGGER.error("Exception writing to internal frame buffer", e);
                );
        public java.lang.Object getFieldValue(_Fields field) {
            }
                case O2:  
                try {
                case O1:  
                java.util.BitSet optionals = new java.util.BitSet();
        }
                org.apache.thrift.async.TAsyncClient client,
            public get_partitions_call(  
                                            struct.success.add(_elem153);  
            if (!getClass().equals(other.getClass())) {  
                        for (Partition _iter164 : struct.success) {
            sendBase("create_database", args);
                _Fields.O2,
                        return O3;  
                case O2:
                    return lastComparison;
                args.setNew_part(new_part);  
                _Fields.MAX_PARTS,
            if (that == null) return false;
        }  
            public short getThriftFieldId() {  
                if (struct.isSetSuccess()) {  
            this.o2 = null;  
            if (!getClass().equals(other.getClass())) {
                _Fields,
            throw new java.lang.IllegalStateException();  
            } else {
            @Override
            scheme(iprot).read(iprot, this);
                    return getReq();
                return fields;
                    } else {
                                break;
            (short) 4
        }  
            if (isSetNew_part()) {  
        public int compareTo(add_partition_result other) {
    @SuppressWarnings({ "cast", "rawtypes", "serial", "unchecked", "unused" })
        }
                super("create_table");
            return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme())
                    } else {  
                    byName.put(field.getFieldName(), field);
            this.o1 = null;
            }  
            processMap.put("create_table", new create_table());  
                return new org.apache.thrift.async.AsyncMethodCallback<java.util.List<Partition>>() {
        }
            }  
            Comparable<create_table_args> {  
            create_table_result result = new create_table_result();
                oprot.writeStructEnd();
            }
            }
            args.setDb_name(db_name);
                        ?,
            if (database != null) {
                            result.o2 = (NoSuchObjectException) e;
                }
            _Fields(short thriftId, java.lang.String fieldName) {
                sb.append("null");  
                    byName.put(field.getFieldName(), field);
                );  
        }
                );  
                case SUCCESS:
            }
            if (field == null) {
        public void unsetO2() {  
            );
            /**  
        private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("get_table_req_args");
                }  
        }  
            );
                    return lastComparison;
                org.apache.thrift.async.AsyncMethodCallback<java.util.List<Partition>> resultHandler
                                if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {  
        public @org.apache.thrift.annotation.Nullable java.lang.String db_name; // required  
        public Partition recv_add_partition() throws InvalidObjectException, AlreadyExistsException, MetaException,
                if (!(this_present_success && that_present_success)) return false;  
        private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, java.lang.ClassNotFoundException {  
            first = false;
            }
                        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) {
            }
        @Override
                iprot.incrementRecursionDepth();
        @org.apache.thrift.annotation.Nullable
                    if (value == null) {  
        public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
            }  
        }
                    prot.decrementRecursionDepth();
            if (result.o1 != null) {  
            throw new java.lang.IllegalStateException();
            ___manager.call(method_call);
            tmpMap.put(
                        iprot.readFieldEnd();
            public create_table_result getResult(I iface, create_table_args args) throws org.apache.thrift.TException {
                            onError(e);
        static {
                this.req = null;  
                for (Partition other_element : other.success) {
        public void create_database(Database database) throws AlreadyExistsException, InvalidObjectException, MetaException,
                    "filter",
                                    struct.setO2IsSet(true);  
                this.o2 = new NoSuchObjectException(other.o2);
        @org.apache.thrift.annotation.Nullable  
            @Override
            }
            }  
                    struct.o1.write(oprot);
                        } catch (org.apache.thrift.transport.TTransportException e) {  
            scheme(iprot).read(iprot, this);
            java.lang.String tbl_name,
                case MAX_PARTS:
                lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.database, other.database);  
                    break;
            if (other.isSetNew_part()) {
                if (!this.o4.equals(that.o4)) return false;
        @Override  
        @org.apache.thrift.annotation.Nullable
            }  
                lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.success, other.success);
        }
            checkReady();
                                } else {
        private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
                                    org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            public void read(org.apache.thrift.protocol.TProtocol iprot, create_database_args struct) throws org.apache.thrift.TException {
                    org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
            this.database = database;  
            Cloneable,  
                    oprot.writeFieldBegin(REQ_FIELD_DESC);
        public static class create_database_call extends org.apache.thrift.async.TAsyncMethodCall<Void> {  
            }  
            hashCode = hashCode * 8191 + ((isSetTbl()) ? 131071 : 524287);
        }
            @Override
                if (!this.new_part.equals(that.new_part)) return false;
            short max_parts,
             * if it is not found.
            }  
        private static final org.apache.thrift.protocol.TField MAX_PARTS_FIELD_DESC = new org.apache.thrift.protocol.TField(
        }  
                                    {  
                    iprot.readStructBegin();  
                    "o3",
            }
            @Override
                    public void onComplete(Partition o) {
        }
            public void write(org.apache.thrift.protocol.TProtocol oprot, get_partitions_by_filter_result struct)
            get_partitions_by_filter_args,
            org.apache.thrift.protocol.TType.STRUCT,
            lastComparison = java.lang.Boolean.compare(isSetSuccess(), other.isSetSuccess());  
            }
                                }  
            }
                }  
            this();
        public _Fields fieldForId(int fieldId) {
                if (lastComparison != 0) {  
        public @org.apache.thrift.annotation.Nullable AlreadyExistsException o2; // required
        }
                }
            @Override
        public void add_partition(Partition new_part, org.apache.thrift.async.AsyncMethodCallback<Partition> resultHandler)
        }  
            lastComparison = java.lang.Boolean.compare(isSetNew_part(), other.isSetNew_part());
        public void send_create_table(Table tbl) throws org.apache.thrift.TException {  
            if (this_present_o1 || that_present_o1) {  
                this.new_part = new_part;  
            /**  
                iprot.incrementRecursionDepth();  
        public static class get_table_req<I extends Iface> extends org.apache.thrift.ProcessFunction<  
                return new get_partitions_by_filter_resultTupleScheme();  
                    return getO2();  
                    iprot.readStructBegin();
                    optionals.set(2);  
            if (that instanceof get_partitions_by_filter_args) return this.equals((get_partitions_by_filter_args) that);  
            this.o1 = o1;
            boolean this_present_success = true && this.isSetSuccess();  
                java.lang.String filter,
        }  
        private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, java.lang.ClassNotFoundException {  
            static {
                return new get_partitions_by_filter_resultStandardScheme();
        public void unsetO2() {  
        }
                    }  
        }  
                    return lastComparison;
            if (lastComparison != 0) {
                java.lang.String,
                    public void onComplete(Void o) {
        }
            }
                if (struct.req != null) {
        public java.lang.Object getFieldValue(_Fields field) {
            org.apache.thrift.protocol.TType.I16,
            public org.apache.thrift.async.AsyncMethodCallback<java.util.List<Partition>> getResultHandler(
        @org.apache.thrift.annotation.Nullable
            "get_partitions_by_filter_args"
            if (lastComparison != 0) {
                                    struct.o2.read(iprot);
                        struct.db_name = iprot.readString();
                    struct.o2.write(oprot);
                }
            }  
            return 0;  
        @Override  
            this.success = null;
                                    struct.setSuccessIsSet(true);
        private static class create_table_argsTupleScheme extends org.apache.thrift.scheme.TupleScheme<create_table_args> {
                    struct.new_part.write(oprot);
        }
            if (isSetO2()) hashCode = hashCode * 8191 + o2.hashCode();
                    break;  
            if (!value) {  
        @Override
                        result.success = o;  
            java.lang.String tbl_name,
            }  
                                    struct.tbl = new Table();
            }
                                    }  
                        setSuccess((Partition) value);
        ) throws MetaException, NoSuchObjectException, org.apache.thrift.TException {
        @Override
            scheme(iprot).read(iprot, this);  
            private static final java.util.Map<java.lang.String, _Fields> byName = new java.util.HashMap<java.lang.String, _Fields>();
        /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
        private static final org.apache.thrift.protocol.TField O4_FIELD_DESC = new org.apache.thrift.protocol.TField(
                        unsetMax_parts();  
        }
                }  
            scheme(oprot).write(oprot, this);
                    return lastComparison;
            if (isSetTbl_name()) {
                }
                        } catch (java.lang.Exception ex) {
        }
                case TBL_NAME:
                "get_partitions_by_filter failed: unknown result"
                    while (true) {
            this.success = success;  
                _fieldName = fieldName;
            }
            private final java.lang.String _fieldName;
        }
            this.o2 = o2;
            I extends AsyncIface>
                this.o3 = new MetaException(other.o3);  
            if (result.o2 != null) {
                }
                    return lastComparison;
                    }
            SUCCESS((short) 0, "success"),  
            Cloneable,
                }
                    iprot.decrementRecursionDepth();  
                oprot.writeStructBegin(STRUCT_DESC);
                                    struct.setFilterIsSet(true);
                case O2:
                _Fields fields = findByThriftId(fieldId);
                return lastComparison;
                    return getO2();
            }
                    return lastComparison;
                            msg = result;
        public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
            } else {
        }
            }  
                try {
            tmpMap.put(
        }
                this.o1 = null;
        @org.apache.thrift.annotation.Nullable  
            if (lastComparison != 0) {
            new get_partitions_by_filter_resultStandardSchemeFactory();
        @org.apache.thrift.annotation.Nullable  
        @Override
                    if (value == null) {  
            boolean that_present_o2 = true && that.isSetO2();  
                _Fields,  
            SUCCESS((short) 0, "success"),  
                    struct.o2.write(oprot);
            processMap.put("get_partitions_by_filter", new get_partitions_by_filter());
                }  
            return new add_partition_result(this);
            java.lang.String tbl_name,
            }
            org.apache.thrift.TException;
                lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.o1, other.o1);  
                new org.apache.thrift.meta_data.FieldMetaData(
            if (this.o1 == null) {
                    new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, NoSuchObjectException.class)
                    iprot.readStructBegin();  
                        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) {  
                    return isSetReq();
                        setFilter((java.lang.String) value);  
            }  
                } finally {  
        }
                org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
        public get_partitions_args deepCopy() {
        public void setO2IsSet(boolean value) {  
            if (isSetO1()) {
                    struct.o2.write(oprot);  
        private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("add_partition_args");  
                sb.append(this.o1);  
            private java.lang.String tbl_name;  
        public void setTbl_nameIsSet(boolean value) {
                switch (fieldId) {  
            @Override
    public interface AsyncIface {  
                                        struct.success = new java.util.ArrayList<Partition>(_list160.size);
            // check for sub-struct validity
                        }  
            tmpMap.put(
        }
                    if (value == null) {
                                if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
            sb.append("success:");
        public boolean equals(java.lang.Object that) {
            O1((short) 1, "o1"),
            }
                add_partition_result result = getEmptyResultInstance();
            boolean first = true;
            boolean this_present_o2 = true && this.isSetO2();
            org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(create_database_result.class, metaDataMap);
                if (getState() != org.apache.thrift.async.TAsyncMethodCall.State.RESPONSE_READ) {
            }
                        } else {
        }
                org.apache.thrift.async.TAsyncClientManager clientManager,
            }
        public boolean isSet(_Fields field) {
        /** Returns true if field db_name is set (has been assigned a value) and false otherwise */
            boolean that_present_database = true && that.isSetDatabase();
            }
                        } else if (e instanceof org.apache.thrift.TApplicationException) {  
                    case 2: // TBL_NAME  
                throw new java.lang.IllegalArgumentException();  
            boolean this_present_req = true && this.isSetReq();
        }
            }
             */
            /**
            } catch (org.apache.thrift.TException te) {  
        }
                            _LOGGER.error("Exception inside handler", e);  
                    org.apache.thrift.AsyncProcessFunction<
            static {  
            /**  
        }
                    return lastComparison;  
                        struct.o4.read(iprot);
            }  
            if (this_present_o2 || that_present_o2) {
                if (!(this_present_o2 && that_present_o2)) return false;
                    oprot.writeString(struct.db_name);  
            if (this.success == null) {  
                        switch (schemeField.id) {  
                    java.util.BitSet incoming = iprot.readBitSet(4);
                            break;
                        } else {
        public java.util.Iterator<Partition> getSuccessIterator() {
            get_table_req_args,
                }  
            switch (field) {  
            if (isSetO1()) hashCode = hashCode * 8191 + o1.hashCode();  
            if (!first) sb.append(", ");
            if (field == null) {
            static {
        @org.apache.thrift.annotation.Nullable
            if (this == that) return true;
                            break;  
                case O2:
            metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);  
                    }  
            @Override
        static {
                    }  
        public java.lang.Object getFieldValue(_Fields field) {
            }
             */  
        );  
                return getClass().getName().compareTo(other.getClass().getName());
                try {  
                return result.success;
                        unsetSuccess();
            public add_partition_result getEmptyResultInstance() {
                    oprot.writeFieldEnd();  
            } catch (org.apache.thrift.TException te) {
            private final short _thriftId;  
            @Override  
            boolean this_present_success = true && this.isSetSuccess();
                            fb.close();
                            Partition _elem158;  
            if (isSetO1()) {
        public void unsetO2() {  
            if (this_present_database || that_present_database) {
            }
        }  
                final org.apache.thrift.server.AbstractNonblockingServer.AsyncFrameBuffer fb,  
                } catch (AlreadyExistsException o2) {  
        public create_table_result deepCopy() {
            boolean this_present_tbl_name = true && this.isSetTbl_name();  
        );
            return this.db_name;
            }  
            }
                org.apache.thrift.transport.TMemoryInputTransport memoryTransport = new org.apache.thrift.transport.TMemoryInputTransport(
            return recv_get_table_req();  
                if (struct.isSetO2()) {  
        private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
        public create_table_result setO3(@org.apache.thrift.annotation.Nullable MetaException o3) {  
        public boolean equals(get_table_req_args that) {
                __isset_bitfield = 0;  
                    }
                                    struct.setO1IsSet(true);
            if (success != null) {
                    {
                if (!(this_present_o2 && that_present_o2)) return false;
            public void read(org.apache.thrift.protocol.TProtocol iprot, create_table_args struct) throws org.apache.thrift.TException {
        public java.lang.Object getFieldValue(_Fields field) {
        public get_table_req_result setO1(@org.apache.thrift.annotation.Nullable MetaException o1) {  
                }  
        public add_partition_args(add_partition_args other) {
                        byte msgType = org.apache.thrift.protocol.TMessageType.REPLY;
                java.lang.String,
            }  
                switch (fieldId) {
            checkReady();  
            private java.lang.String tbl_name;  
                    }  
                    "max_parts",
            throws org.apache.thrift.TException {
                return false;  
            /**
        public static class get_partitions<I extends AsyncIface> extends org.apache.thrift.AsyncProcessFunction<
                oprot.writeStructEnd();
        public boolean equals(create_database_args that) {
            return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme())
            if (!value) {  
        // isset id assignments
            }
                    iprot.readStructEnd();
        public void unsetO3() {
                            msg = result;  
            lastComparison = java.lang.Boolean.compare(isSetO3(), other.isSetO3());
        public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
                        }  
            if (other.isSetO2()) {  
        }  
                )
                }
                throw new java.lang.IllegalArgumentException();  
                                    org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);  
                    return getDb_name();
                        struct.o4 = new NoSuchObjectException();  
                return byName.get(name);  
            (short) 0  
                case TBL_NAME:  
            }
        public void setTblIsSet(boolean value) {
        public java.util.List<Partition> get_partitions_by_filter(  
            }
                        }
            @Override  
                case FILTER:
                };
                return new get_table_req_resultTupleScheme();  
        }
                throw new java.lang.IllegalArgumentException();  
            "get_partitions_result"
        }
                    return isSetO2();  
                    if (incoming.get(1)) {  
        public void setO1IsSet(boolean value) {
                        }
            }  
                        } else if (e instanceof org.apache.thrift.transport.TTransportException) {
                        } catch (java.lang.Exception e) {  
            __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __MAX_PARTS_ISSET_ID);  
                                    struct.o3 = new MetaException();  
        public get_partitions_by_filter_args setMax_parts(short max_parts) {  
        public short max_parts; // required  
            this.o3 = null;
                tbl_name,
                    }  
                ? STANDARD_SCHEME_FACTORY  
                        return O2;
                    org.apache.thrift.protocol.TField schemeField;
                case TBL_NAME:  
            if (this.o4 == null) {  
            org.apache.thrift.TBase<add_partition_args, add_partition_args._Fields>,
            return hashCode;  
                }
                        struct.setO1IsSet(true);  
                        unsetO1();
                    case 1: // O1
            new get_partitions_resultStandardSchemeFactory();  
                }
            new add_partition_resultStandardSchemeFactory();  
                    return isSetDb_name();
            return this;  
        }  
            }
                                    struct.o2.read(iprot);  
            }
                    if (value == null) {
                        struct.setMax_partsIsSet(true);
            public void read(org.apache.thrift.protocol.TProtocol iprot, get_partitions_by_filter_result struct)
                        }  
                return lastComparison;  
        public @org.apache.thrift.annotation.Nullable AlreadyExistsException o1; // required  
                )
        public void clear() {
            return sb.toString();
            public boolean isOneway() {  
                this.o2 = new InvalidObjectException(other.o2);  
                                    struct.o2 = new AlreadyExistsException();
                        }
        }
            public get_partitions_by_filter_result getEmptyResultInstance() {
                    }  
            }
            public static _Fields findByName(java.lang.String name) {
            if (other.isSetSuccess()) {  
                case O3:
                this.success = null;  
            }
            "tbl_name",
            @Override  
            return hashCode;
                    }
            this.o3 = o3;  
            java.lang.String db_name,
                case NEW_PART:  
                                if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
        }
        static {
        public void setFieldValue(_Fields field, @org.apache.thrift.annotation.Nullable java.lang.Object value) {
        public void unsetDatabase() {
        public static class get_table_req<I extends AsyncIface> extends org.apache.thrift.AsyncProcessFunction<
                final org.apache.thrift.AsyncProcessFunction fcall = this;
            @Override  
            } else {  
        public boolean isSetO1() {
            this.success = null;
            org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(add_partition_result.class, metaDataMap);
                "get_partitions failed: unknown result"  
                        } catch (java.lang.Exception ex) {
                        }  
            if (lastComparison != 0) {
                    // check for required fields of primitive type, which can't be checked in the validate method  
                        struct.setO1IsSet(true);  
                if (!(this_present_max_parts && that_present_max_parts)) return false;
                    getFrameBuffer().array()  
        }
            if (this.tbl == null) {
            @Override
            );
            } catch (org.apache.thrift.TException te) {
                                    struct.setSuccessIsSet(true);  
            if (this_present_o1 || that_present_o1) {  
            public get_table_req_result getEmptyResultInstance() {  
             */
        public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
                    break;
                            onError(e);
            this.db_name = null;
            public get_table_req() {
        @org.apache.thrift.annotation.Nullable  
        }  
            public short getThriftFieldId() {
                                break;
            @Override
            first = false;
            java.lang.String db_name,
            public get_partitions_resultTupleScheme getScheme() {  
                )  
            }
                    "o1",  
                case MAX_PARTS:
        );
            public void read(org.apache.thrift.protocol.TProtocol prot, create_database_args struct) throws org.apache.thrift.TException {  
                this.o1 = null;
             */
                                    org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);  
            if (this_present_success || that_present_success) {
                    org.apache.thrift.TFieldRequirementType.DEFAULT,
                    }  
        }
                return new AsyncClient(protocolFactory, clientManager, transport);
            short max_parts,
            Cloneable,
        public void validate() throws org.apache.thrift.TException {
            java.lang.String filter,  
            org.apache.thrift.TException {  
        }  
                    org.apache.thrift.ProcessFunction<I, ? extends org.apache.thrift.TBase, ? extends org.apache.thrift.TBase>> processMap
                    if (incoming.get(0)) {
                                    struct.max_parts = iprot.readI16();
        public create_database_args setDatabase(@org.apache.thrift.annotation.Nullable Database database) {  
            }
        }  
                    while (true) {
                oprot.writeStructBegin(STRUCT_DESC);
                throw new java.io.IOException(te);  
                throw new java.lang.IllegalArgumentException();  
                    result.o1 = o1;
                            fb.close();
            "o2",
            }
                                } else {
                write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
                    return getFilter();
        public enum _Fields implements org.apache.thrift.TFieldIdEnum {
                        return SUCCESS;
        public get_partitions_by_filter_args() {}  
        }
                                }  
                case TBL:
        public enum _Fields implements org.apache.thrift.TFieldIdEnum {
                    oprot.writeFieldEnd();
            }  
                                break;
        }  
            @Override
            java.lang.String tbl_name,
            }  
            return this.o1;  
        }
        public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
            }
                    "o2",  
                this.o3 = null;
            boolean first = true;
                    "o4",  
            }
            }
                                if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {  
        );
            if (that instanceof add_partition_result) return this.equals((add_partition_result) that);  
        @Override
            if (other.isSetTbl()) {  
            __isset_bitfield = other.__isset_bitfield;
            java.lang.StringBuilder sb = new java.lang.StringBuilder("get_partitions_result(");
            public void write(org.apache.thrift.protocol.TProtocol oprot, add_partition_args struct) throws org.apache.thrift.TException {
                return new add_partition_args();
            static {  
            private Database database;
            if (!first) sb.append(", ");
                                break;
            if (this_present_o4 || that_present_o4) {  
            }  
                if (lastComparison != 0) {
                    break;
                if (struct.isSetMax_parts()) {
                org.apache.thrift.TException {  
            boolean first = true;
                                org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
                iprot.incrementRecursionDepth();  
                _Fields.SUCCESS,
        private static class get_partitions_by_filter_argsStandardScheme extends org.apache.thrift.scheme.StandardScheme<
            if (isSetO3()) hashCode = hashCode * 8191 + o3.hashCode();
                }  
        @Override
        }  
            if (!value) {  
                    }  
            public void start(
                this.o1 = new InvalidObjectException(other.o1);
                    iprot.readStructBegin();
            sb.append("o2:");
        @Override
                    org.apache.thrift.protocol.TField schemeField;
                    new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, AlreadyExistsException.class)
                    new org.apache.thrift.protocol.TMessage("get_partitions", org.apache.thrift.protocol.TMessageType.CALL, 0)  
            return hashCode;
                return fields;
                if (struct.isSetO3()) {
    }
                    struct.tbl.write(oprot);  
            }  
            int lastComparison = 0;
        }
                Partition new_part,
            return this.o3 != null;
            java.lang.StringBuilder sb = new java.lang.StringBuilder("add_partition_result(");  
                return _thriftId;
        }
            first = false;
                case NEW_PART:  
                            _LOGGER.error("Exception writing to internal frame buffer", ex);  
                case SUCCESS:
        @Override  
        }
            }
            int hashCode = 1;
                sb.append("null");  
        // isset id assignments
                    struct.o2.write(oprot);
                return byName.get(name);
                    iprot.decrementRecursionDepth();
            }
        public void setDb_nameIsSet(boolean value) {  
        @Override  
                this.o1 = null;
                return _thriftId;
                        setSuccess((java.util.List<Partition>) value);
        );  
                org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
        implements  
        }  
            @Override
                new org.apache.thrift.meta_data.FieldMetaData(
                }
        }
             * if it is not found.
        private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
            public create_database_call(  
                oprot.writeStructBegin(STRUCT_DESC);
            public static _Fields findByName(java.lang.String name) {  
                    return isSetMax_parts();
            scheme(iprot).read(iprot, this);  
            @org.apache.thrift.annotation.Nullable  
        }
            }  
            args.setTbl_name(tbl_name);
                "get_table_req failed: unknown result"
                case O4:  
            return this;  
            }  
            }  
                return byName.get(name);
        }
                new org.apache.thrift.meta_data.FieldMetaData(  
            boolean this_present_o2 = true && this.isSetO2();
                this.new_part = new Partition(other.new_part);  
    }  
            return this.success != null;
            tmpMap.put(
            private final java.lang.String _fieldName;
            }
                                        org.apache.thrift.protocol.TList _list160 = iprot.readListBegin();
                _Fields fields = findByThriftId(fieldId);
            private final java.lang.String _fieldName;  
                        try {  
                    struct.o1.write(oprot);
            return this;  
                : TUPLE_SCHEME_FACTORY).getScheme();
                this.o1 = null;
        }
            (short) 2
                if (!this.tbl_name.equals(that.tbl_name)) return false;
            }
                if (lastComparison != 0) {
            lastComparison = java.lang.Boolean.compare(isSetDb_name(), other.isSetDb_name());
             * if it is not found.
                    if (incoming.get(3)) {  
            if (this.tbl_name == null) {  
                                break;
        public short getMax_parts() {
                    } else {  
                get_partitions_by_filter_result result = getEmptyResultInstance();
            if (isSetSuccess()) {
            org.apache.thrift.TException {
            }
            }  
            (short) 2  
                            fcall.sendResponse(fb, result, org.apache.thrift.protocol.TMessageType.REPLY, seqid);
                return new create_table_args();
                    struct.o2.write(oprot);
            lastComparison = java.lang.Boolean.compare(isSetO2(), other.isSetO2());
            "o2",
                return byName.get(name);  
                org.apache.thrift.async.TAsyncClient client,  
                struct.validate();
        }
                    struct.o1.write(oprot);
                if (!this.o3.equals(that.o3)) return false;  
                case O1:  
                _Fields fields = findByThriftId(fieldId);
            switch (field) {  
         * Performs a deep copy on <i>other</i>.
                    struct.o2.write(oprot);  
        @Override
            receiveBase(result, "get_table_req");
            if (that == null) return false;  
        }  
                    oprot.writeFieldEnd();
            create_table_args args = new create_table_args();
            private org.apache.thrift.async.TAsyncClientManager clientManager;
                }
            O3((short) 3, "o3");
                                _elem166.read(iprot);
            public static _Fields findByThriftIdOrThrow(int fieldId) {
                            case 1: // REQ  
                oprot.writeBitSet(optionals, 1);
            boolean that_present_success = true && that.isSetSuccess();  
                    break;  
        }  
        private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY = new get_table_req_argsStandardSchemeFactory();  
        @Override  
                    org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
            return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme())
            public java.lang.String getFieldName() {
            lastComparison = java.lang.Boolean.compare(isSetO1(), other.isSetO1());
                    optionals.set(1);
                case REQ:
        @org.apache.thrift.annotation.Nullable  
                sb.append(this.new_part);
            }
                } finally {
        @Override
                    case 3: // O3
                            result.o1 = (NoSuchObjectException) e;  
             * Find the _Fields constant that matches name, or null if its not found.
                _thriftId = thriftId;
        @org.apache.thrift.annotation.Nullable
            ___manager.call(method_call);
            }
                    oprot.writeFieldEnd();
                if (!(this_present_success && that_present_success)) return false;  
                    struct.req.write(oprot);  
            int hashCode = 1;
        }  
                new org.apache.thrift.meta_data.FieldMetaData(
            add_partition_args args = new add_partition_args();  
                _fieldName = fieldName;
            return this.tbl;
                    optionals.set(1);  
            );
                                org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(get_partitions_by_filter_result.class, metaDataMap);
            }
            org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(get_partitions_args.class, metaDataMap);
                        unsetDb_name();
            checkReady();
                return false;  
            public short getThriftFieldId() {  
        /**
            if (isSetSuccess()) hashCode = hashCode * 8191 + success.hashCode();
                }
            @Override  
                }  
            }  
        );
            public create_database_result getEmptyResultInstance() {  
            try {  
            try {
            }  
        }
                                break;
                    case 1: // TBL
                return false;
                        unsetTbl_name();
                        setSuccess((GetTableResult) value);
                create_database_args args = new create_database_args();
            }
                    if (incoming.get(0)) {
        public MetaException getO3() {
                new org.apache.thrift.meta_data.FieldMetaData(  
                        struct.o3.read(iprot);
                        setO1((MetaException) value);  
        @Override  
                } catch (InvalidObjectException o2) {
                read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
        }
            }  
        private static final org.apache.thrift.protocol.TField O1_FIELD_DESC = new org.apache.thrift.protocol.TField(  
            int hashCode = 1;
                : TUPLE_SCHEME_FACTORY).getScheme();  
                        setO3((MetaException) value);  
                }  
            }
            @org.apache.thrift.annotation.Nullable
                write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));  
        @Override
                    )
                    } else {  
                    public void onError(java.lang.Exception e) {  
                lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.success, other.success);
                return false;  
        private static final org.apache.thrift.protocol.TField O3_FIELD_DESC = new org.apache.thrift.protocol.TField(
                        unsetDatabase();
            (short) 2
            @Override  
            public static _Fields findByThriftIdOrThrow(int fieldId) {
            public short getThriftFieldId() {
            this.o2 = o2;
                    if (incoming.get(2)) {  
            }
        public get_partitions_by_filter_result setO1(@org.apache.thrift.annotation.Nullable MetaException o1) {  
                            return;
        public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {  
                org.apache.thrift.TApplicationException.MISSING_RESULT,
            (short) 3
                if (!(this_present_o1 && that_present_o1)) return false;
                : TUPLE_SCHEME_FACTORY).getScheme();
                        unsetReq();  
        }
            }
            throws org.apache.thrift.TException {
            @Override  
            (short) 3
            switch (field) {  
        public int getSuccessSize() {
            scheme(iprot).read(iprot, this);
                            msg = new org.apache.thrift.TApplicationException(
                iprot.incrementRecursionDepth();
        public java.util.List<Partition> getSuccess() {
                lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.new_part, other.new_part);
                    }
                }
                    default:
            ) throws org.apache.thrift.TException {
    }
                case O2:
            }  
                    }  
                } finally {
                }
                try {
                    oprot.writeFieldBegin(O2_FIELD_DESC);
            }
            sb.append("req:");
            }
                            _LOGGER.error("Exception writing to internal frame buffer", e);
                            msgType = org.apache.thrift.protocol.TMessageType.EXCEPTION;  
             * Find the _Fields constant that matches fieldId, or null if its not found.  
                this.o2 = new AlreadyExistsException(other.o2);
            int lastComparison = 0;
            );  
        }
            }  
        }
                case SUCCESS:
                            _LOGGER.error("Exception inside handler", e);
        }
            java.io.Serializable,
        }
            }
            public void read(org.apache.thrift.protocol.TProtocol prot, get_partitions_args struct) throws org.apache.thrift.TException {
        public void get_partitions(
        }  
            }
            org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(get_table_req_result.class, metaDataMap);  
                    java.util.BitSet incoming = iprot.readBitSet(1);  
        @org.apache.thrift.annotation.Nullable  
            @Override  
                                break;  
        public _Fields fieldForId(int fieldId) {
            }  
            Cloneable,
        public boolean isSetO1() {
            @Override
            @Override
                            );
            return _Fields.findByThriftId(fieldId);  
        }  
                            fcall.sendResponse(fb, result, org.apache.thrift.protocol.TMessageType.REPLY, seqid);
        }
            }
            return _Fields.findByThriftId(fieldId);
            }  
                }  
                oprot.writeI16(struct.max_parts);
            return sb.toString();  
            metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);  
                _thriftId = thriftId;
            ___manager.call(method_call);
            boolean that_present_o3 = true && that.isSetO3();  
            boolean this_present_tbl = true && this.isSetTbl();
        }
                    result.success = iface.get_table_req(args.req);
            @org.apache.thrift.annotation.Nullable
            sb.append("o4:");
                _Fields,
        public MetaException getO2() {  
        public void validate() throws org.apache.thrift.TException {
                );
            _Fields(short thriftId, java.lang.String fieldName) {
                    optionals.set(3);
            hashCode = hashCode * 8191 + ((isSetDb_name()) ? 131071 : 524287);
                return byName.get(name);
                return lastComparison;
            // check for required fields
         * Performs a deep copy on <i>other</i>.
        public _Fields fieldForId(int fieldId) {  
            );  
                            msg = new org.apache.thrift.TApplicationException(  
            if (isSetTbl_name()) hashCode = hashCode * 8191 + tbl_name.hashCode();
            if (this.o2 == null) {
                oprot.writeBitSet(optionals, 3);
                case O1:  
            /**  
            switch (field) {
            public add_partition_result getEmptyResultInstance() {
                final int seqid
                case DATABASE:
        public void unsetSuccess() {
                    if (incoming.get(1)) {
        static {  
                                        for (int _i154 = 0; _i154 < _list152.size; ++_i154) {  
            /**  
            Cloneable,  
        );
            return this.req != null;
            boolean this_present_filter = true && this.isSetFilter();
        private static class add_partition_argsTupleScheme extends org.apache.thrift.scheme.TupleScheme<add_partition_args> {  
        public void unsetSuccess() {
                if (struct.isSetTbl()) {
        );  
        }
            return 0;
        public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
                _Fields.REQ,
                if (!this.filter.equals(that.filter)) return false;
            }
                if (struct.success != null) {  
                                    struct.success = new Partition();
                )
                    return getO1();
                }
            sb.append(")");
        public int hashCode() {
        );
                        java.lang.String,
            tmpMap.put(  
        }  
        @Override  
        // isset id assignments  
        @Override
        }  
            if (this.tbl_name == null) {
        }
        /** Returns true if field o2 is set (has been assigned a value) and false otherwise */
        }
                        struct.setO2IsSet(true);
            public static _Fields findByThriftId(int fieldId) {
            this.new_part = new_part;
                org.apache.thrift.protocol.TProtocolFactory protocolFactory,
            }  
        public java.util.List<Partition> get_partitions(java.lang.String db_name, java.lang.String tbl_name, short max_parts)  
                    oprot.writeString(struct.tbl_name);
                if (struct.isSetO3()) {  
        /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
        public InvalidObjectException getO2() {
            @Override
            create_database_result> {
             * Find the _Fields constant that matches fieldId, throwing an exception  
                                    struct.o1.read(iprot);  
            public void read(org.apache.thrift.protocol.TProtocol prot, get_partitions_by_filter_result struct)  
                if (struct.o2 != null) {
                org.apache.thrift.TApplicationException.MISSING_RESULT,
        private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
                write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));  
        }
            if (this.new_part == null) {
            }
        }
                    struct.validate();
            (short) 1
        public create_table_args deepCopy() {  
            Comparable<create_database_args> {
                return _thriftId;  
                    if (incoming.get(0)) {
            }
                }  
        public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
        public int compareTo(get_partitions_by_filter_result other) {
            public static _Fields findByThriftIdOrThrow(int fieldId) {  
            get_partitions_result result = new get_partitions_result();
                    default:  
            @Override
        @Override  
                if (struct.isSetO1()) {
            _Fields(short thriftId, java.lang.String fieldName) {  
                return result.success;
            java.util.Map<
                                    struct.setTbl_nameIsSet(true);
                I iface,  
                            );  
            if (lastComparison != 0) {
            }
                    oprot.writeFieldEnd();  
            tmpMap.put(
                switch (fieldId) {
                case REQ:
            "o4",
                            break;
                write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
            }
            first = false;  
        }
                _Fields.O3,
                lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.o3, other.o3);  
            if (that instanceof get_table_req_args) return this.equals((get_table_req_args) that);  
        public int compareTo(get_partitions_by_filter_args other) {
            }
        }
                try {
                if (struct.success != null) {  
        public GetTableResult getSuccess() {
            @Override
            ) throws org.apache.thrift.TException {  
                    org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
        }
        /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */  
            return this.tbl_name != null;
            public static _Fields findByThriftId(int fieldId) {  
                this.o2 = new MetaException(other.o2);
        public Client(org.apache.thrift.protocol.TProtocol iprot, org.apache.thrift.protocol.TProtocol oprot) {
        @org.apache.thrift.annotation.Nullable  
        }
            return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme())
                        struct.setSuccessIsSet(true);
            private Partition new_part;
        }
        }
            }
            return true;
            }
        @Override
        }  
        // isset id assignments
        }  
                } catch (MetaException o1) {  
                case DB_NAME:
        public boolean isSetMax_parts() {
                                } else {  
                                    struct.o1 = new MetaException();
                org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
                    new org.apache.thrift.meta_data.ListMetaData(
                _fieldName = fieldName;
                org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;  
            @Override
            if (that instanceof get_table_req_result) return this.equals((get_table_req_result) that);
            public static _Fields findByThriftId(int fieldId) {  
package org.opensearch.plugin.hive.metastore;  
                                break;
                            case 1: // NEW_PART
         * Performs a deep copy on <i>other</i>.
                        struct.tbl_name = iprot.readString();  
                return _thriftId;
            public boolean isOneway() {
                try {
            }
                    iprot.decrementRecursionDepth();  
                }
                            ? extends org.apache.thrift.TBase,
                        } else if (e instanceof org.apache.thrift.transport.TTransportException) {
             */  
            return this.db_name;
            public create_table_args getEmptyArgsInstance() {
        public static class Factory implements org.apache.thrift.TServiceClientFactory<Client> {
                )
            sb.append(")");
            return 0;  
            super(iprot, oprot);  
            }
                return lastComparison;
                    if (value == null) {  
                            break;
            O3((short) 3, "o3");
                super("create_database");
                sb.append(this.o2);
            return sb.toString();  
            public static _Fields findByThriftIdOrThrow(int fieldId) {  
            return true;
                if (struct.isSetO3()) {  
                super("add_partition");
        }
                                    org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
                }
                    optionals.set(0);  
                            fb.close();
                        switch (schemeField.id) {  
            checkReady();
            (short) 0  
                            case 1: // DATABASE
            Cloneable,
                                    struct.setO2IsSet(true);
        }
        private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {  
                    prot.decrementRecursionDepth();
        implements
            sb.append(")");
            );
            processMap.put("create_database", new create_database());  
                return new create_database_args();  
             * Find the _Fields constant that matches fieldId, or null if its not found.
        @Override  
                                }
                org.apache.thrift.TApplicationException.MISSING_RESULT,
        }
        }
            if (field == null) {
            if (isSetO1()) {  
                iface.get_partitions(args.db_name, args.tbl_name, args.max_parts, resultHandler);
            return _Fields.findByThriftId(fieldId);
        public static class create_database<I extends Iface> extends org.apache.thrift.ProcessFunction<
                switch (fieldId) {
            get_table_req_result> {  
            /**  
                tbl.validate();
                        } else if (e instanceof org.apache.thrift.TApplicationException) {
            scheme(iprot).read(iprot, this);
            NEW_PART((short) 1, "new_part");  
                }
                            _iter155.write(oprot);  
            @Override  
                oprot.writeFieldEnd();  
            }  
            if (that instanceof create_table_args) return this.equals((create_table_args) that);  
                case SUCCESS:
            sb.append(")");
            sb.append("o3:");
        );  
            /**
                                }
        @Override
        public void validate() throws org.apache.thrift.TException {
                            fb.close();
        public void setFieldValue(_Fields field, @org.apache.thrift.annotation.Nullable java.lang.Object value) {
                        switch (schemeField.id) {
        }
                    break;
            public boolean isOneway() {
                super(client, protocolFactory, transport, resultHandler, false);
            }  
            if (isSetO3()) hashCode = hashCode * 8191 + o3.hashCode();  
        /** Returns true if field filter is set (has been assigned a value) and false otherwise */  
                            result.o2 = (InvalidObjectException) e;  
                return getClass().getName().compareTo(other.getClass().getName());  
                                if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {
                )
            @Override
        public void setNew_partIsSet(boolean value) {  
                oprot.writeBitSet(optionals, 1);
            );
            public create_database_resultStandardScheme getScheme() {
            setMax_partsIsSet(true);
        /** Returns true if field o1 is set (has been assigned a value) and false otherwise */  
                org.apache.thrift.protocol.TProtocolFactory protocolFactory,
        }
            }
            this.db_name = db_name;
                                } else {
                if (!this.o2.equals(that.o2)) return false;  
                        struct.tbl_name = iprot.readString();
                oprot.writeFieldStop();  
                                            _elem161.read(iprot);
        /**
            setMax_partsIsSet(true);
        }
                            _LOGGER.error("TApplicationException inside handler", e);
            @Override
                    org.apache.thrift.protocol.TField schemeField;
            if (isSetDatabase()) {
    }
                sb.append("null");  
                    ?,  
        }
            public void write(org.apache.thrift.protocol.TProtocol prot, create_table_args struct) throws org.apache.thrift.TException {
            }
                    return isSetO1();
            int lastComparison = 0;
        }
                return new Client(iprot, oprot);  
                    }
        private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {  
            /**  
            /**
            }  
                req.validate();
        }  
                    return getSuccess();
                        return null;
        public boolean equals(java.lang.Object that) {  
        public get_partitions_result() {}
            public void start(I iface, create_database_args args, org.apache.thrift.async.AsyncMethodCallback<Void> resultHandler)
                java.lang.String tbl_name,
            }
            this();
                    return getO3();
                        byte msgType = org.apache.thrift.protocol.TMessageType.REPLY;
                    "o1",
        );
            org.apache.thrift.protocol.TType.STRING,
                        }  
                    result.o1 = o1;
            );
        }
                return new get_partitions_by_filter_argsStandardScheme();
                throw new java.lang.IllegalArgumentException();  
        }  
                } finally {
                _Fields.O1,
            new get_partitions_by_filter_argsTupleSchemeFactory();
                    oprot.writeFieldBegin(SUCCESS_FIELD_DESC);  
            }  
                    return isSetO1();
            this();
                switch (fieldId) {
        }  
                throw new java.io.IOException(te);
            }  
                }
                sb.append(this.success);
                if (!this.o1.equals(that.o1)) return false;
                if (struct.isSetReq()) {
                sb.append("null");
        }
                this.o4 = null;
        }
            sendBase("create_table", args);  
            return this.max_parts;
                    oprot.writeString(struct.tbl_name);  
                            fb.close();
                this.req = req;
        }  
                                        for (int _i162 = 0; _i162 < _list160.size; ++_i162) {
                    result.o3 = o3;  
                org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
                final org.apache.thrift.server.AbstractNonblockingServer.AsyncFrameBuffer fb,
        public java.lang.Object getFieldValue(_Fields field) {  
                if (!(this_present_o3 && that_present_o3)) return false;  
            @Override
            @Override  
            boolean first = true;  
                        struct.filter = iprot.readString();
            private GetTableRequest req;  
            int hashCode = 1;  
            lastComparison = java.lang.Boolean.compare(isSetO2(), other.isSetO2());
                oprot.writeStructEnd();  
                            org.apache.thrift.protocol.TList _list165 = iprot.readListBegin(org.apache.thrift.protocol.TType.STRUCT);
            public static _Fields findByThriftIdOrThrow(int fieldId) {
                                    struct.database.read(iprot);
            }  
                    optionals.set(2);
            if (this_present_max_parts || that_present_max_parts) {
            }
         */  
                max_parts,  
                    return getTbl_name();
                    }  
        public void validate() throws org.apache.thrift.TException {  
        private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
            if (lastComparison != 0) {
        @Override
        }
            sb.append("o1:");
                case O3:
        }
        /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
                    byName.put(field.getFieldName(), field);
                iprot.incrementRecursionDepth();
                        return O1;
                                    org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
            if (isSetTbl()) hashCode = hashCode * 8191 + tbl.hashCode();
                        get_partitions_result result = new get_partitions_result();
             */
                org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);  
                        struct.o3.read(iprot);
                    public void onError(java.lang.Exception e) {
             * Find the _Fields constant that matches fieldId, or null if its not found.
            this.o1 = o1;
                    prot.decrementRecursionDepth();
                final org.apache.thrift.server.AbstractNonblockingServer.AsyncFrameBuffer fb,
                resultHandler,
            java.io.Serializable,  
                return lastComparison;
                        switch (schemeField.id) {
            );
            }
            @Override  
            } else {
        /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
        }  
            }
        }
        }
        @org.apache.thrift.annotation.Nullable
        }
                            break;  
                                break;  
            ) throws org.apache.thrift.TException {
                throw result.o2;
            public java.lang.String getFieldName() {
        private static final org.apache.thrift.protocol.TField O1_FIELD_DESC = new org.apache.thrift.protocol.TField(
                    return getO2();
                        } catch (java.lang.Exception e) {
            }
                    return isSetO1();
        private static final org.apache.thrift.protocol.TField O1_FIELD_DESC = new org.apache.thrift.protocol.TField(
            lastComparison = java.lang.Boolean.compare(isSetO2(), other.isSetO2());
                if (struct.tbl != null) {
                struct.validate();
            if (this_present_o2 || that_present_o2) {
            public create_table_resultTupleScheme getScheme() {  
                prot.writeMessageBegin(  
                    break;
        }
    public static class get_partitions_by_filter_result
                }
        }
                        org.apache.thrift.AsyncProcessFunction<
        public java.lang.Object getFieldValue(_Fields field) {
            return true;  
            first = false;
            return this;  
            public Client getClient(org.apache.thrift.protocol.TProtocol iprot, org.apache.thrift.protocol.TProtocol oprot) {
        @Override
            _Fields(short thriftId, java.lang.String fieldName) {
        public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {  
                    struct.o2.write(oprot);
            public org.apache.thrift.async.AsyncMethodCallback<Void> getResultHandler(  
 * Autogenerated by Thrift Compiler (0.23.0)
            if (field == null) {
                                    struct.o2.read(iprot);
                                break;
            if (!value) {
                return new create_database_resultStandardScheme();  
            return this.o1;  
        }
            scheme(oprot).write(oprot, this);  
            return sb.toString();
            /**  
                    }
                    org.apache.thrift.protocol.TField schemeField;  
            org.apache.thrift.protocol.TType.STRUCT,
        public boolean isSetO2() {
            }
                        unsetO1();  
                    iprot.decrementRecursionDepth();
            get_partitions_args,  
                                        Partition _elem161;
                }
/**  
                    "success",  
            lastComparison = java.lang.Boolean.compare(isSetO4(), other.isSetO4());
        @Override  
        }
                            break;
            }
            I,
        public AsyncClient(  
                oprot.writeFieldStop();
            org.apache.thrift.TException {
                                org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            if (isSetSuccess()) hashCode = hashCode * 8191 + success.hashCode();
                                            _elem161 = new Partition();  
        private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY =
        }
                            _LOGGER.error("Exception inside handler", e);
            }  
            if (!value) {
            return false;
            if (isSetTbl()) {
        ) throws org.apache.thrift.TException {
                    oprot.writeFieldBegin(NEW_PART_FIELD_DESC);
                case O1:
            int hashCode = 1;
                this.success = __this__success;
            return _Fields.findByThriftId(fieldId);
                _fieldName = fieldName;  
                    break;  
            );  
                final org.apache.thrift.server.AbstractNonblockingServer.AsyncFrameBuffer fb,
                org.apache.thrift.transport.TMemoryInputTransport memoryTransport = new org.apache.thrift.transport.TMemoryInputTransport(
        private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, java.lang.ClassNotFoundException {
        }  
                    return getMax_parts();
            }  
                : TUPLE_SCHEME_FACTORY).getScheme();  
            public get_partitions_by_filter_resultTupleScheme getScheme() {
        /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
        @Override
            }
                    new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, NoSuchObjectException.class)
                        struct.success.read(iprot);
                    throw new java.lang.IllegalStateException("Method call not finished!");
            public static _Fields findByName(java.lang.String name) {
                                    struct.success.read(iprot);
            return sb.toString();
                    new org.apache.thrift.protocol.TMessage("add_partition", org.apache.thrift.protocol.TMessageType.CALL, 0)  
                                    struct.setO1IsSet(true);  
            ) {
                    byName.put(field.getFieldName(), field);
                if (struct.isSetFilter()) {
                        oprot.writeListEnd();
                struct.validate();  
        public GetTableResult recv_get_table_req() throws MetaException, NoSuchObjectException, org.apache.thrift.TException {  
            java.lang.String db_name,
                            _LOGGER.error("TTransportException writing to internal frame buffer", e);
                    break;
            private org.apache.thrift.protocol.TProtocolFactory protocolFactory;
                    break;
        private static final org.apache.thrift.protocol.TField O2_FIELD_DESC = new org.apache.thrift.protocol.TField(
            }
                    return isSetSuccess();
        public boolean isSetNew_part() {
                throws org.apache.thrift.TException {
            public boolean isOneway() {
            this.o1 = null;
            switch (field) {  
            } catch (org.apache.thrift.TException te) {
                    @Override
            return this;  
        }
            this.success = null;
                }
                    oprot.writeFieldBegin(DB_NAME_FIELD_DESC);  
                                if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {  
        private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY = new add_partition_argsStandardSchemeFactory();
            }
            boolean this_present_o2 = true && this.isSetO2();
                if (struct.isSetDb_name()) {
            /**
        );
                read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
                _fieldName = fieldName;
                                }  
        @Override
        public void send_add_partition(Partition new_part) throws org.apache.thrift.TException {
        }
            boolean this_present_new_part = true && this.isSetNew_part();
                }
                    // check for required fields of primitive type, which can't be checked in the validate method  
            // check for required fields  
                throw new java.lang.IllegalArgumentException();  
            }
        }  
            if (!getClass().equals(other.getClass())) {  
                return lastComparison;
                );
        private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY =
        public void get_partitions(
        public boolean isSetO1() {
            first = false;
            @Override  
        }
                    iprot.decrementRecursionDepth();  
            }
            first = false;  
            public create_table() {
                                    org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
                    return lastComparison;  
                            default:  
                    struct.req.write(oprot);  
                    struct.success.write(oprot);
                }
            first = false;  
            processMap.put("get_partitions", new get_partitions());  
            /**
            this.success = success;
                        iprot.readFieldEnd();  
                    optionals.set(0);  
                return fields;  
                        if (e instanceof MetaException) {
                }  
            get_partitions_args args = new get_partitions_args();  
            scheme(oprot).write(oprot, this);  
        @org.apache.thrift.annotation.Nullable
                case DB_NAME:
            public java.lang.String getFieldName() {
                if (struct.isSetSuccess()) {  
                return _thriftId;  
                if (struct.o2 != null) {
            org.apache.thrift.protocol.TType.STRUCT,
        }
                oprot.writeBitSet(optionals, 4);
            }
        }
            (short) 1
            @Override  
                _thriftId = thriftId;
                    java.util.BitSet incoming = iprot.readBitSet(1);
                                    struct.setSuccessIsSet(true);  
            org.apache.thrift.protocol.TType.STRUCT,
                );
            boolean this_present_database = true && this.isSetDatabase();  
                        setO1((NoSuchObjectException) value);  
                } finally {  
                lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.tbl_name, other.tbl_name);
        }  
            public get_partitions_by_filter_call(
                if (!(this_present_new_part && that_present_new_part)) return false;
            boolean that_present_o3 = true && that.isSetO3();
                        schemeField = iprot.readFieldBegin();
                try {
            }
                        result.success = o;
                super(client, protocolFactory, transport, resultHandler, false);
            }  
                                } else {  
            return this;
                        unsetSuccess();  
             */
            }  
            return this.o1;
        @Override  
        protected Processor(
                    org.apache.thrift.TFieldRequirementType.DEFAULT,
                return (new Client(prot)).recv_get_partitions();
                    break;  
                org.apache.thrift.transport.TNonblockingTransport transport
            return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme())  
        public get_partitions_result setSuccess(@org.apache.thrift.annotation.Nullable java.util.List<Partition> success) {
        public @org.apache.thrift.annotation.Nullable NoSuchObjectException o4; // required
                return new create_table_args();
            @Override  
                if (struct.isSetO3()) {
                prot.writeMessageBegin(
            } else {
            hashCode = hashCode * 8191 + ((isSetDb_name()) ? 131071 : 524287);
            }
                                _elem166 = new Partition();
            sb.append("database:");
        @Override  
        }  
                oprot.writeFieldStop();  
                ? STANDARD_SCHEME_FACTORY
            return this.database;  
                org.apache.thrift.protocol.TProtocolFactory protocolFactory  
            first = false;
                "add_partition failed: unknown result"
                    if (value == null) {
            if (isSetFilter()) hashCode = hashCode * 8191 + filter.hashCode();
            if (this_present_o2 || that_present_o2) {  
            lastComparison = java.lang.Boolean.compare(isSetO2(), other.isSetO2());
        );
            boolean that_present_o1 = true && that.isSetO1();
            public java.lang.String getFieldName() {
                }
            java.lang.String db_name,  
                        {
                            result.o1 = (InvalidObjectException) e;  
        public java.util.List<Partition> get_partitions(java.lang.String db_name, java.lang.String tbl_name, short max_parts)
                        get_table_req_result result = new get_table_req_result();  
            }
            }  
                        setTbl_name((java.lang.String) value);  
        public void setO1IsSet(boolean value) {
             * Find the _Fields constant that matches name, or null if its not found.
            if (other.isSetO3()) {  
            }
                if (fields == null) throw new java.lang.IllegalArgumentException("Field " + fieldId + " doesn't exist!");  
            return this.o2 != null;  
            if (lastComparison != 0) {
    }  
            int hashCode = 1;
                this.tbl = null;  
                }
            } else {
            }
                                org.apache.thrift.TApplicationException.INTERNAL_ERROR,
            } else {  
        public boolean isSetTbl_name() {  
                } catch (NoSuchObjectException o4) {  
                            result.o2 = (MetaException) e;
                            case 3: // FILTER
            }  
            switch (field) {  
        @Override  
                                    struct.o1 = new AlreadyExistsException();  
                case O2:
                            @org.apache.thrift.annotation.Nullable
                            _iter156.write(oprot);
                                } else {
        private static class create_table_argsStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {  
        public void clear() {
        );
        public void unsetO1() {
        public int hashCode() {
                oprot.writeStructEnd();
             */
        }
        @Override
                Database database,
                                e.getMessage()  
                                        iprot.readListEnd();
                throw new java.lang.IllegalArgumentException();
            }
        }
            if (isSetDatabase()) hashCode = hashCode * 8191 + database.hashCode();  
            org.apache.thrift.protocol.TType.STRUCT,  
                org.apache.thrift.async.TAsyncClient client,  
                if (!(this_present_db_name && that_present_db_name)) return false;
                        struct.o2 = new NoSuchObjectException();
                sb.append("null");  
            private final java.lang.String _fieldName;
                        struct.setFilterIsSet(true);  
            );
                return _thriftId;
            if (!value) {
            if (this == that) return true;  
                                }  
                throw new java.lang.IllegalArgumentException();
            org.apache.thrift.transport.TNonblockingTransport transport  
        @Override
                            Partition _elem166;
            @Override
                _fieldName = fieldName;
            @Override
            this.o2 = o2;
        implements
                    public void onError(java.lang.Exception e) {
            );  
                );
    }
                read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));  
            @Override
            return this;
            }  
             * Find the _Fields constant that matches name, or null if its not found.
                iface.get_partitions_by_filter(args.db_name, args.tbl_name, args.filter, args.max_parts, resultHandler);
            if (isSetO2()) hashCode = hashCode * 8191 + o2.hashCode();
                        }
                                break;
                args.write(prot);  
                            _LOGGER.error("Exception inside handler", e);
            this.success = success;
            boolean first = true;  
            "success",
        public boolean isSetO2() {
                    }  
        /** Returns true if field o2 is set (has been assigned a value) and false otherwise */
            }
                        struct.setDatabaseIsSet(true);
        }  
            }  
                return new create_database_args();
        public void setO2IsSet(boolean value) {  
        }
            "database",
            if (!value) {
                    prot.decrementRecursionDepth();  
        @Override
        public void get_partitions_by_filter(  
        @Override
                    org.apache.thrift.protocol.TField schemeField;  
                return _fieldName;
                    }  
        /**
            }
            org.apache.thrift.protocol.TType.STRUCT,
                        return O2;
        public @org.apache.thrift.annotation.Nullable java.lang.String db_name; // required
            );
                // constructor.
        public MetaException getO3() {
                this.tbl_name = null;  
            this.o4 = o4;
            throws org.apache.thrift.TException;  
                return false;  
                        }
            if (lastComparison != 0) {
                            new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, struct.success.size())
             */  
            return (this.success == null) ? 0 : this.success.size();  
                struct.validate();
            /**
            @org.apache.thrift.annotation.Nullable  
                if (struct.isSetTbl()) {
            scheme(oprot).write(oprot, this);
            boolean that_present_success = true && that.isSetSuccess();
            create_database_args,  
        @Override
        public void setFieldValue(_Fields field, @org.apache.thrift.annotation.Nullable java.lang.Object value) {
            return hashCode;
                        return null;
            org.apache.thrift.async.TAsyncClientManager clientManager,
                }
            tmpMap.put(
                lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.o2, other.o2);
            @Override
            sb.append("success:");
        public get_partitions_args() {}
        }
        }
                oprot.writeBitSet(optionals, 3);  
            @Override  
                        if (e instanceof MetaException) {  
                }
        public _Fields fieldForId(int fieldId) {
            boolean this_present_o3 = true && this.isSetO3();  
        public create_table_result setO2(@org.apache.thrift.annotation.Nullable InvalidObjectException o2) {
                    byName.put(field.getFieldName(), field);
                _Fields.O2,
                    struct.database.write(oprot);
            if (this_present_o1 || that_present_o1) {  
            super(protocolFactory, clientManager, transport);
            if (this.req == null) {
                new org.apache.thrift.meta_data.FieldMetaData(  
            @Override
        }
                    }
            /**
            if (!value) {
                                }
        }  
                    struct.o2.write(oprot);  
                        setO2((InvalidObjectException) value);
                            result.o4 = (NoSuchObjectException) e;
                    return isSetO2();
            }
            return true;  
                lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.o1, other.o1);  
                        return null;  
        );  
            if (!value) {
            this.tbl_name = null;
                    if (incoming.get(2)) {
                case O1:  
            boolean this_present_o1 = true && this.isSetO1();
        @Override  
            }  
                            msgType = org.apache.thrift.protocol.TMessageType.EXCEPTION;
            sb.append("max_parts:");  
        public void setReqIsSet(boolean value) {
            if (isSetDb_name()) hashCode = hashCode * 8191 + db_name.hashCode();
            @Override  
                this.success = new Partition(other.success);
            /**
        public static class get_partitions_by_filter<I extends AsyncIface> extends org.apache.thrift.AsyncProcessFunction<  
                if (!(this_present_max_parts && that_present_max_parts)) return false;
            checkReady();  
            @Override
            hashCode = hashCode * 8191 + ((isSetSuccess()) ? 131071 : 524287);
                    new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)
        @Override
        @Override
        public @org.apache.thrift.annotation.Nullable InvalidObjectException o2; // required  
             * if it is not found.
                }
            }
                            _LOGGER.error("Exception writing to internal frame buffer", ex);
            private short max_parts;
        public boolean isSetSuccess() {  
                        struct.o2.read(iprot);  
        public int compareTo(create_table_result other) {
                    )
                                    org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        /** Returns true if field o1 is set (has been assigned a value) and false otherwise */
        /** Returns true if field tbl_name is set (has been assigned a value) and false otherwise */
                read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
                                    struct.tbl.read(iprot);  
                return false;
                )
            );
            return this.o3 != null;
                throw result.o2;
        }
        }
            }  
                }
                    new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)
                    if (incoming.get(0)) {
        }
            }  
                                org.apache.thrift.TApplicationException.INTERNAL_ERROR,  
        }
            this.success = success;
            }
        public java.lang.String toString() {
            );
                    // check for required fields of primitive type, which can't be checked in the validate method  
                if (struct.isSetO1()) {  
            }
            org.apache.thrift.protocol.TType.STRING,  
            this.o1 = null;  
        public static class create_database<I extends AsyncIface> extends org.apache.thrift.AsyncProcessFunction<
            public create_database_argsStandardScheme getScheme() {  
                    org.apache.thrift.TFieldRequirementType.DEFAULT,
                    org.apache.thrift.TFieldRequirementType.DEFAULT,  
                try {
                    }
                if (fields == null) throw new java.lang.IllegalArgumentException("Field " + fieldId + " doesn't exist!");
                        } else if (e instanceof org.apache.thrift.TApplicationException) {  
        /**  
            @org.apache.thrift.annotation.Nullable
            }
        }
        ) {
            public get_table_req_args getEmptyArgsInstance() {  
        }
                args.setReq(req);
            }  
    }  
            TBL_NAME((short) 2, "tbl_name"),
                sb.append(this.req);
        }  
                    struct.o1.write(oprot);  
                }
    public interface Iface {
        }  
        }  
            }
                        struct.setO3IsSet(true);  
                return new create_database_result();
        public @org.apache.thrift.annotation.Nullable MetaException o3; // required  
        }
        }  
                            struct.success = new java.util.ArrayList<Partition>(_list165.size);  
                            case 0: // SUCCESS
            }
                        struct.setO2IsSet(true);
            );
            try {  
            } else {  
                    "o2",
        implements  
                                    struct.o3 = new MetaException();  
         */
                        for (Partition _iter156 : struct.success) {  
                    org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;  
                );
        public void unsetO3() {
            public get_partitions_by_filter() {
                    new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, AlreadyExistsException.class)
            this.tbl_name = tbl_name;  
                                    struct.o1 = new NoSuchObjectException();
                return lastComparison;
                                    struct.setMax_partsIsSet(true);  
                case SUCCESS:
            this.tbl = tbl;
            org.apache.thrift.protocol.TType.STRUCT,
            send_create_database(database);  
            public create_database_args getEmptyArgsInstance() {
            return this.o2 != null;  
                    if (incoming.get(1)) {
                org.apache.thrift.async.AsyncMethodCallback<Partition> resultHandler,  
                        struct.database.read(iprot);
            super(iface, getProcessMap(processMap));
            }
        }  
            public void write(org.apache.thrift.protocol.TProtocol oprot, get_partitions_by_filter_args struct)
            if (this.o3 == null) {
        @Override
        @Override  
                    struct.validate();  
                                break;
                            break;  
            public void write(org.apache.thrift.protocol.TProtocol oprot, get_partitions_result struct)  
                org.apache.thrift.transport.TMemoryInputTransport memoryTransport = new org.apache.thrift.transport.TMemoryInputTransport(  
            get_partitions_by_filter_args> {  
                    } else {
            public static _Fields findByName(java.lang.String name) {
                org.apache.thrift.transport.TNonblockingTransport transport
        }
                        return null;
                write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));  
        public enum _Fields implements org.apache.thrift.TFieldIdEnum {
                    org.apache.thrift.TFieldRequirementType.DEFAULT,  
            @Override
            send_get_table_req(req);
        public create_table_args() {}
                java.util.BitSet optionals = new java.util.BitSet();  
            if (isSetSuccess()) hashCode = hashCode * 8191 + success.hashCode();
                    struct.success.write(oprot);  
            return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __MAX_PARTS_ISSET_ID);
            processMap.put("add_partition", new add_partition());
            sb.append("tbl_name:");
                success.validate();  
        public void validate() throws org.apache.thrift.TException {  
            this.o1 = o1;
                        }
            }  
            boolean that_present_max_parts = true;  
            public void write(org.apache.thrift.protocol.TProtocol oprot, create_database_result struct)
                this.tbl_name = tbl_name;
                                    org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
                } catch (MetaException o1) {
        );  
        }
                                    struct.o2 = new NoSuchObjectException();
                                    org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __MAX_PARTS_ISSET_ID, value);  
            if (!getClass().equals(other.getClass())) {
                this.tbl = tbl;
        public @org.apache.thrift.annotation.Nullable java.lang.String tbl_name; // required
                case FILTER:
            private static final java.util.Map<java.lang.String, _Fields> byName = new java.util.HashMap<java.lang.String, _Fields>();  
                short max_parts,
                    return isSetO4();
            sb.append(")");
                        if (e instanceof InvalidObjectException) {
            get_partitions_by_filter_result> {
            }
                    result.o3 = o3;  
                    }
        }
            first = false;  
            return recv_add_partition();
            first = false;  
        );
        public void clear() {
                            ?,
                read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
            if (this_present_max_parts || that_present_max_parts) {
        private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, java.lang.ClassNotFoundException {
                        struct.o2.read(iprot);  
            public static _Fields findByThriftId(int fieldId) {
                                    struct.req.read(iprot);  
            java.lang.StringBuilder sb = new java.lang.StringBuilder("get_partitions_by_filter_args(");  
        }
                }  
                    }  
                if (struct.isSetO3()) {
                                } else {
            tmpMap.put(
        }  
                    }
            public org.apache.thrift.async.AsyncMethodCallback<java.util.List<Partition>> getResultHandler(  
            if (other.isSetO2()) {  
                    throw new java.lang.IllegalStateException("Method call not finished!");
            }  
                    case 1: // O1  
                                    struct.setO1IsSet(true);  
                    oprot.writeFieldBegin(O1_FIELD_DESC);  
                    {
            }
            }
            @Override
            }
                        } else if (e instanceof org.apache.thrift.transport.TTransportException) {
            return false;
        );
            return _Fields.findByThriftId(fieldId);  
                        schemeField = iprot.readFieldBegin();  
        @Override  
                if (getState() != org.apache.thrift.async.TAsyncMethodCall.State.RESPONSE_READ) {
        @Override
                prot.incrementRecursionDepth();
                };  
            super(iface, getProcessMap(processMap));  
            @Override  
            get_partitions_args,
            @Override
                        }
        }
                    optionals.set(0);
                this.success = __this__success;
                args.write(prot);  
            return false;
            this.o3 = null;
            public get_table_req_call(
            return this.o2;
            @Override  
                throw new java.io.IOException(te);
            get_table_req_args,
                    } else {  
        }  
                        if (e instanceof NoSuchObjectException) {
            return false;  
                    optionals.set(1);
            if (!first) sb.append(", ");  
            try {
                        create_database_result result = new create_database_result();
            if (other.isSetO1()) {  
                this.success = new java.util.ArrayList<Partition>();
            scheme(oprot).write(oprot, this);
                            _LOGGER.error("TTransportException writing to internal frame buffer", e);
                            default:
                if (struct.isSetO2()) {  
        }  
                    __this__success.add(new Partition(other_element));
                    } else {  
            this.o4 = null;
                            default:
            return true;  
                                    org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        /** Returns true if field success is set (has been assigned a value) and false otherwise */
            }
        private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct(  
                            msgType = org.apache.thrift.protocol.TMessageType.EXCEPTION;  
                            case 2: // O2
                    break;
                _fieldName = fieldName;
            if (this_present_tbl || that_present_tbl) {
                    iprot.decrementRecursionDepth();
            }
            "o1",
                    break;
             * Find the _Fields constant that matches fieldId, throwing an exception
                    default:
            get_table_req_result result = new get_table_req_result();
        private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
            }
        }
            return 0;
            @Override
        public void send_get_partitions_by_filter(  
            }  
        /** Returns true if field req is set (has been assigned a value) and false otherwise */
                            msgType = org.apache.thrift.protocol.TMessageType.EXCEPTION;
            public get_table_req_argsStandardScheme getScheme() {
            (short) 0
            return hashCode;
        public void setDatabaseIsSet(boolean value) {
                        unsetO2();
            ) {
                return lastComparison;
            } else {
            boolean first = true;  
                _Fields.FILTER,
        public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {  
            Cloneable,
        }
            }  
                this.o1 = null;
        // isset id assignments
                    struct.validate();
        public boolean isSet(_Fields field) {
                this.max_parts = max_parts;  
            org.apache.thrift.protocol.TType.STRUCT,
            }  
            if (!first) sb.append(", ");
            }  
        @Override
        /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
                    if (value == null) {
                }
                return byName.get(name);
        }
        private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new create_table_resultTupleSchemeFactory();  
                return lastComparison;
            switch (field) {  
                throws org.apache.thrift.TException {
            if (other.isSetO2()) {
        public create_table_result(AlreadyExistsException o1, InvalidObjectException o2, MetaException o3, NoSuchObjectException o4) {
            scheme(oprot).write(oprot, this);  
                        struct.new_part.read(iprot);
                }
            int lastComparison = 0;
            }  
        public get_partitions_args setTbl_name(@org.apache.thrift.annotation.Nullable java.lang.String tbl_name) {
                        struct.o1 = new MetaException();
            sb.append("o2:");
        public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
                }
                };
                if (!(this_present_o4 && that_present_o4)) return false;
        }
        }  
        }
            public void write_args(org.apache.thrift.protocol.TProtocol prot) throws org.apache.thrift.TException {  
                    java.util.BitSet incoming = iprot.readBitSet(3);  
                _Fields fields = findByThriftId(fieldId);
            if (isSetO2()) hashCode = hashCode * 8191 + o2.hashCode();
        @Override
            Void,
        }  
                create_table_result result = getEmptyResultInstance();  
            boolean that_present_o4 = true && that.isSetO4();
                    result.o2 = o2;
            }
                                } else {
        }
                    byName.put(field.getFieldName(), field);
        private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("create_table_result");
            if (field == null) {  
            java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<
            private static final java.util.Map<java.lang.String, _Fields> byName = new java.util.HashMap<java.lang.String, _Fields>();
                throw new java.io.IOException(te);
            if (isSetMax_parts()) {
                        struct.setSuccessIsSet(true);
            lastComparison = java.lang.Boolean.compare(isSetMax_parts(), other.isSetMax_parts());
            this.req = req;
                return (new Client(prot)).recv_add_partition();  
        }  
                    "o1",
        private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
        @Override  
                if (struct.isSetO2()) {
            get_partitions_by_filter_args,
                    if (incoming.get(3)) {
        }
                for (_Fields field : java.util.EnumSet.allOf(_Fields.class)) {
        public create_table_result(create_table_result other) {
            @Override
            @Override
        public get_partitions_by_filter_args setFilter(@org.apache.thrift.annotation.Nullable java.lang.String filter) {  
            tmpMap.put(  
        public Processor(I iface) {  
            }  
                throw new java.io.IOException(te);  
            // check for required fields
                                } else {
            @Override
            }
            __isset_bitfield = other.__isset_bitfield;  
                }
                    __this__success.add(new Partition(other_element));
            return false;  
                                break;  
                    byName.put(field.getFieldName(), field);  
                    struct.database.write(oprot);
            }
    public static class get_table_req_args
                            result.setO2IsSet(true);
        @Override
        public void setO3IsSet(boolean value) {
                oprot.writeStructEnd();
                        try {  
        public void unsetFilter() {
                }  
                lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.filter, other.filter);  
        public add_partition_result setO1(@org.apache.thrift.annotation.Nullable InvalidObjectException o1) {  
                get_table_req_result result = getEmptyResultInstance();  
            this.o1 = o1;
                    // check for required fields of primitive type, which can't be checked in the validate method  
                                if (schemeField.type == org.apache.thrift.protocol.TType.I16) {
                    oprot.writeFieldEnd();
                        unsetO3();  
            // check for sub-struct validity
            // check for sub-struct validity  
        }
                    optionals.set(3);  
                if (fields == null) throw new java.lang.IllegalArgumentException("Field " + fieldId + " doesn't exist!");
                    java.util.BitSet incoming = iprot.readBitSet(1);
            if (!first) sb.append(", ");
                final int seqid
            this.o2 = o2;  
            processMap.put("get_table_req", new get_table_req());  
                        struct.o2.read(iprot);  
        public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {  
            }  
                }
                return new org.apache.thrift.async.AsyncMethodCallback<java.util.List<Partition>>() {
                return new get_partitions_resultStandardScheme();
            if (that instanceof create_table_result) return this.equals((create_table_result) that);
            }
            sb.append("db_name:");
                return false;
            this.o4 = o4;
            public get_partitions_by_filter_result getResult(I iface, get_partitions_by_filter_args args)
                    return getTbl_name();
                if (struct.isSetO4()) {  
            if (isSetO3()) {
                _Fields.DB_NAME,
        }
             * if it is not found.
            this.___currentMethod = method_call;  
                    }
        }  
        }  
        public @org.apache.thrift.annotation.Nullable GetTableRequest req; // required  
                if (!(this_present_req && that_present_req)) return false;
            }
            "add_partition_result"
                )  
                    iprot.readStructEnd();
            }
                            fb.close();
                    if (incoming.get(1)) {  
                } catch (NoSuchObjectException o2) {  
            }  
                        } else if (e instanceof InvalidObjectException) {
                    case 3: // FILTER  
            processMap.put("add_partition", new add_partition());
                            case 4: // O4
                oprot.writeStructBegin(STRUCT_DESC);
                    result.o1 = o1;
                if (struct.o3 != null) {  
        }
                    "db_name",  
            lastComparison = java.lang.Boolean.compare(isSetO1(), other.isSetO1());
            ___manager.call(method_call);  
            if (isSetO2()) {  
            throw new java.lang.IllegalStateException();  
                    throw new java.lang.IllegalStateException("Method call not finished!");  
                        return O1;
                    }
        }
            new create_database_resultStandardSchemeFactory();  
                sb.append(this.filter);
            }
            get_table_req_call method_call = new get_table_req_call(req, resultHandler, this, ___protocolFactory, ___transport);  
                        }
            (short) 1
            }  
            tmpMap.put(
                    result.o2 = o2;  
                add_partition_args args = new add_partition_args();
                org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
            this.o1 = null;  
        }
                                break;  
            switch (field) {  
                                org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);  
                        return O4;
                    result.o2 = o2;  
                    struct.o3.write(oprot);  
            if (result.o2 != null) {  
                            break;
            public void read(org.apache.thrift.protocol.TProtocol iprot, add_partition_args struct) throws org.apache.thrift.TException {  
        public void setO1IsSet(boolean value) {
        public InvalidObjectException getO2() {  
            }
            return this.o2 != null;
                    @Override
            private final short _thriftId;
                            result.o3 = (MetaException) e;
            if (this.o2 == null) {
                if (struct.isSetO1()) {  
                            break;
                switch (fieldId) {  
        }  
        public @org.apache.thrift.annotation.Nullable NoSuchObjectException o2; // required
                return byName.get(name);
                if (lastComparison != 0) {
        }  
                }
                org.apache.thrift.transport.TNonblockingTransport transport
                if (!this.db_name.equals(that.db_name)) return false;  
            this.req = null;  
            throw new org.apache.thrift.TApplicationException(  
                            case 1: // O1
        public boolean equals(java.lang.Object that) {  
                return new get_table_req_argsTupleScheme();  
        public boolean isSet(_Fields field) {
        }  
        public boolean equals(java.lang.Object that) {
                final int seqid
                sb.append(this.o3);
                    optionals.set(3);
                iface,
                return _fieldName;
        public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
                oprot.writeFieldStop();  
            if (isSetSuccess()) {
            public create_database() {
                    struct.o2.write(oprot);  
            }  
            }  
                        } catch (org.apache.thrift.transport.TTransportException e) {
        /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */  
        public void unsetReq() {
        public boolean equals(get_partitions_result that) {
            receiveBase(result, "create_table");  
            @Override
        private static class add_partition_resultStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
                                        iprot.readListEnd();
                sb.append("null");
            if (!value) {
                if (!(this_present_success && that_present_success)) return false;  
            boolean that_present_filter = true && that.isSetFilter();
                    struct.o3.write(oprot);
            /**
        public java.lang.String toString() {
            public GetTableResult getResult() throws MetaException, NoSuchObjectException, org.apache.thrift.TException {
        public GetTableResult get_table_req(GetTableRequest req) throws MetaException, NoSuchObjectException, org.apache.thrift.TException;
        public java.util.List<Partition> get_partitions_by_filter(
                    org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;  
        @Override
            this.o2 = null;  
            first = false;
                return getClass().getName().compareTo(other.getClass().getName());  
                if (lastComparison != 0) {
        public @org.apache.thrift.annotation.Nullable Partition new_part; // required
        public void validate() throws org.apache.thrift.TException {
                new org.apache.thrift.meta_data.FieldMetaData(
                    case 4: // MAX_PARTS
            boolean this_present_max_parts = true;
            return this.filter != null;
            lastComparison = java.lang.Boolean.compare(isSetSuccess(), other.isSetSuccess());  
                                    struct.o1.read(iprot);
        }  
                    }
                        return O1;  
             */
                                break;
                struct.validate();  
            sb.append(")");
                )
        private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
            // check for sub-struct validity  
        }
                org.apache.thrift.protocol.TProtocol prot = client.getProtocolFactory().getProtocol(memoryTransport);
                    case 2: // TBL_NAME
        }
                this.tbl_name = null;  
            I,  
            }
        }
            }
                case TBL_NAME:
                    result.o3 = o3;
            tmpMap.put(  
                                if (schemeField.type == org.apache.thrift.protocol.TType.I16) {  
                throw result.o3;
                _Fields,
            if (isSetTbl_name()) hashCode = hashCode * 8191 + tbl_name.hashCode();
        }  
                throws org.apache.thrift.TException {
                        } else if (e instanceof AlreadyExistsException) {  
                    return lastComparison;
        }
        }
                    return isSetO3();
        }
                if (!this.o2.equals(that.o2)) return false;  
                                    struct.max_parts = iprot.readI16();
        private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new create_database_resultTupleSchemeFactory();
                            _LOGGER.error("Exception writing to internal frame buffer", e);  
        }
                org.apache.thrift.async.AsyncMethodCallback<java.util.List<Partition>> resultHandler,
        public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;  
        }
                }  
        }  
        public void setFieldValue(_Fields field, @org.apache.thrift.annotation.Nullable java.lang.Object value) {
        @Override  
                    iprot.readStructEnd();  
                            _iter164.write(oprot);
        private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
                try {
            @Override
            @Override
            java.io.Serializable,
            }  
    }
                    iprot.readStructEnd();  
            if (result.o3 != null) {
            }
                org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
            public create_table_argsStandardScheme getScheme() {
            switch (field) {  
                _Fields,
            }
            java.lang.StringBuilder sb = new java.lang.StringBuilder("get_partitions_by_filter_result(");
            @Override
                    if (incoming.get(3)) {
            public void read(org.apache.thrift.protocol.TProtocol prot, create_database_result struct) throws org.apache.thrift.TException {  
                    oprot.writeFieldBegin(O1_FIELD_DESC);
                if (lastComparison != 0) {  
        @Override
                final org.apache.thrift.AsyncProcessFunction fcall = this;
        public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
                    if (value == null) {
        }
                try {  
        /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
                    prot.decrementRecursionDepth();
                case O3:
            @Override
                    oprot.writeFieldEnd();  
                    } else {
                case TBL:
            }  
        }
                read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
            if (this_present_db_name || that_present_db_name) {
            public get_partitions_result getResult(I iface, get_partitions_args args) throws org.apache.thrift.TException {
                        return MAX_PARTS;  
                    // check for required fields of primitive type, which can't be checked in the validate method
                case O1:
        private static class get_partitions_argsTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {  
            );
                _thriftId = thriftId;  
            }  
                this.o1 = new NoSuchObjectException(other.o1);
                    break;
                    } else {
        private static class get_partitions_by_filter_resultTupleScheme extends org.apache.thrift.scheme.TupleScheme<
            java.lang.StringBuilder sb = new java.lang.StringBuilder("get_table_req_args(");
            }
                        org.apache.thrift.protocol.TType.LIST,  
                    result.o1 = o1;
                    }
                return getClass().getName().compareTo(other.getClass().getName());
                _Fields.O1,
            tmpMap.put(  
        }
                    prot.decrementRecursionDepth();
                if (struct.isSetO3()) {  
                final org.apache.thrift.AsyncProcessFunction fcall = this;  
            return this.o2;
            }
                    if (value == null) {
            if (lastComparison != 0) {
        private static class get_partitions_argsStandardScheme extends org.apache.thrift.scheme.StandardScheme<get_partitions_args> {
            return this;
            @Override
            }  
        /** Returns true if field database is set (has been assigned a value) and false otherwise */  
                }
                    org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
            I iface,  
            this.max_parts = other.max_parts;  
                        try {
                    org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;  
            }
                        iprot.readFieldEnd();
                                    struct.setO3IsSet(true);
                prot.incrementRecursionDepth();  
                        );  
                }  
             */
        public boolean equals(get_partitions_by_filter_args that) {
            Comparable<get_table_req_result> {
                return lastComparison;  
            }  
            if (!value) {
        }
                }
            @Override
        }
            }  
                    optionals.set(0);  
            }  
        implements
            private final short _thriftId;  
            this.o1 = o1;  
            }
        @Override
            int hashCode = 1;  
                    "tbl_name",
            boolean that_present_db_name = true && that.isSetDb_name();
                lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.o4, other.o4);
                        struct.setO1IsSet(true);
            }  
            }  
            if (!getClass().equals(other.getClass())) {  
                    "db_name",  
                }
            "filter",  
            return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __MAX_PARTS_ISSET_ID);  
            public Void getResult() throws AlreadyExistsException, InvalidObjectException, MetaException, org.apache.thrift.TException {
        }
            scheme(oprot).write(oprot, this);
        @Override  
            setMax_partsIsSet(false);
            }  
            // check for required fields
                                    struct.req = new GetTableRequest();
        @org.apache.thrift.annotation.Nullable  
        public void setFieldValue(_Fields field, @org.apache.thrift.annotation.Nullable java.lang.Object value) {
            static {
                    public void onComplete(Void o) {
            } else {
            @Override  
            if (field == null) {
            lastComparison = java.lang.Boolean.compare(isSetO2(), other.isSetO2());
                _thriftId = thriftId;  
            org.apache.thrift.protocol.TType.STRUCT,  
            public void write_args(org.apache.thrift.protocol.TProtocol prot) throws org.apache.thrift.TException {
        public java.lang.String toString() {  
                            msg = (org.apache.thrift.TApplicationException) e;  
             * Find the _Fields constant that matches fieldId, or null if its not found.  
            create_table_args,  
        public boolean isSetReq() {  
            public static _Fields findByName(java.lang.String name) {
                iprot.incrementRecursionDepth();  
        }  
                    default:  
                    while (true) {  
            java.io.Serializable,  
@SuppressWarnings({ "cast", "rawtypes", "serial", "unchecked", "unused" })
                    // check for required fields of primitive type, which can't be checked in the validate method
                    new org.apache.thrift.protocol.TMessage("get_partitions_by_filter", org.apache.thrift.protocol.TMessageType.CALL, 0)  
                prot.incrementRecursionDepth();
            public void write(org.apache.thrift.protocol.TProtocol oprot, get_partitions_args struct) throws org.apache.thrift.TException {
        }  
            org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(get_partitions_by_filter_args.class, metaDataMap);  
        public create_database_result deepCopy() {
            }
            }
            /**
            }  
            }  
                    }  
                    }
                        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) {  
            return 0;  
                }
        private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new add_partition_argsTupleSchemeFactory();  
                    optionals.set(0);
            if (lastComparison != 0) {  
            }  
                                if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {
            args.setMax_parts(max_parts);  
                struct.validate();  
        }  
            }
                        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) {  
            }
            java.lang.String tbl_name,
                return new org.apache.thrift.async.AsyncMethodCallback<Void>() {
        }  
        public GetTableRequest getReq() {
            tmpMap.put(  
        }
        }  
                            ? extends org.apache.thrift.TBase>>()  
                                    struct.setO2IsSet(true);
                    oprot.writeFieldBegin(O1_FIELD_DESC);
            }
                new org.apache.thrift.meta_data.FieldMetaData(
                        add_partition_result result = new add_partition_result();
            this.o3 = null;
                            _LOGGER.error("TTransportException inside handler", e);  
            try {  
        }
            }
            }
                            fb.close();
            public void write(org.apache.thrift.protocol.TProtocol prot, get_partitions_by_filter_args struct)  
            (short) 1
            (short) 0
        @org.apache.thrift.annotation.Nullable  
                }
            switch (field) {  
                    if (value == null) {
                }  
                    {  
                new org.apache.thrift.meta_data.FieldMetaData(
             * Find the _Fields constant that matches fieldId, throwing an exception
                    }
        private static final org.apache.thrift.protocol.TField TBL_NAME_FIELD_DESC = new org.apache.thrift.protocol.TField(
                    } else {
        public add_partition_result() {}
                            fcall.sendResponse(fb, msg, msgType, seqid);
                lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.db_name, other.db_name);
        @Override  
                } catch (MetaException o3) {
                    } else {
        }  
            if (!getClass().equals(other.getClass())) {
            if (!value) {
                    getFrameBuffer().array()
                    } else {
            }
                }
    }
            if (field == null) {
        implements
            Comparable<create_table_result> {
            } catch (org.apache.thrift.TException te) {  
            java.lang.String db_name,
        }
            public void read(org.apache.thrift.protocol.TProtocol iprot, create_database_result struct)
        public boolean isSetDb_name() {
        @Override  
                    return lastComparison;
                    }  
        }
            getProcessMap(
                    }
        }
                oprot.writeFieldStop();
            }
        public int hashCode() {
        // isset id assignments  
                            _LOGGER.error("TApplicationException inside handler", e);
        }
            if (this.database == null) {  
        @Override
                        return DB_NAME;  
            return this.new_part;
            java.lang.String tbl_name,
                        setO2((InvalidObjectException) value);  
            }  
                    prot.decrementRecursionDepth();
            );
                try {
                        struct.success = new Partition();
                }
        }
                                    org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            this.new_part = null;
            }
                try {
                    "o2",
                get_partitions_by_filter_args args,
            "tbl_name",
            }  
            }
        /** Returns true if field db_name is set (has been assigned a value) and false otherwise */
            }
        public void setSuccessIsSet(boolean value) {
                                org.apache.thrift.TApplicationException.INTERNAL_ERROR,
                        } catch (java.lang.Exception ex) {  
        public void recv_create_database() throws AlreadyExistsException, InvalidObjectException, MetaException,
        private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY =
                    struct.validate();
                if (fields == null) throw new java.lang.IllegalArgumentException("Field " + fieldId + " doesn't exist!");  
                            struct.success = new java.util.ArrayList<Partition>(_list157.size);
            if (!first) sb.append(", ");
            public create_table_result getEmptyResultInstance() {  
            }
                        unsetO1();
        }
        @Override  
            boolean this_present_success = true && this.isSetSuccess();  
                    if (value == null) {  
                            fcall.sendResponse(fb, msg, msgType, seqid);
                                        @org.apache.thrift.annotation.Nullable
        public get_table_req_result setO2(@org.apache.thrift.annotation.Nullable NoSuchObjectException o2) {
        public boolean isSetO3() {  
                                    struct.success = new GetTableResult();
            public java.lang.String getFieldName() {
            return this;  
        public void unsetO2() {  
            send_add_partition(new_part);
            return this.o1 != null;
            }
        public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
            }
                    default:  
            }
            }
                org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);  
        @Override  
                if (lastComparison != 0) {
                for (_Fields field : java.util.EnumSet.allOf(_Fields.class)) {
            if (this == that) return true;
            this.o2 = null;
            public create_database_result getEmptyResultInstance() {
        }  
                _fieldName = fieldName;  
            java.lang.String db_name,  
        }  
            metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);  
             * Find the _Fields constant that matches name, or null if its not found.  
        public void unsetNew_part() {  
            "get_table_req_result"  
            return 0;  
                    optionals.set(0);
            }
            return _Fields.findByThriftId(fieldId);  
                                    org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);  
                org.apache.thrift.transport.TMemoryInputTransport memoryTransport = new org.apache.thrift.transport.TMemoryInputTransport(  
                            _LOGGER.error("Exception writing to internal frame buffer", e);
            @Override
 *  @generated
            } else {
                return getClass().getName().compareTo(other.getClass().getName());
            );
        public void create_table(Table tbl) throws AlreadyExistsException, InvalidObjectException, MetaException, NoSuchObjectException,
        public int hashCode() {
                sb.append(this.success);  
            }
        @org.apache.thrift.annotation.Nullable
            return this.o1 != null;
                    return getSuccess();
                        {
            this.tbl_name = tbl_name;  
            tmpMap.put(
            this();
            }
            org.apache.thrift.protocol.TType.LIST,  
                prot.incrementRecursionDepth();
                        return null;
                            fcall.sendResponse(fb, result, org.apache.thrift.protocol.TMessageType.REPLY, seqid);
             * Find the _Fields constant that matches fieldId, or null if its not found.  
             */  
            @Override
                                } else {
            Comparable<get_partitions_by_filter_args> {
        @Override
            }  
                    }
        public boolean equals(java.lang.Object that) {  
                            case 1: // O1
            throw new java.lang.IllegalStateException();  
            throw new org.apache.thrift.TApplicationException(  
        public void create_table(Table tbl, org.apache.thrift.async.AsyncMethodCallback<Void> resultHandler)
            if (isSetO1()) hashCode = hashCode * 8191 + o1.hashCode();
        public get_partitions_result(get_partitions_result other) {
                return fields;
                    org.apache.thrift.protocol.TField schemeField;
                args.write(prot);
        );
                        unsetO1();
            get_partitions_by_filter_result> {
                    new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, InvalidObjectException.class)
                }
            // check for required fields
        }
                return new add_partition_result();  
                        struct.new_part = new Partition();
                try {
                                }  
            "o3",  
                case O1:  
        @Override  
                                } else {
                    struct.o2.write(oprot);
            }
        );
                )
                }
                throws org.apache.thrift.TException {  
        }
        @Override
                _Fields fields = findByThriftId(fieldId);
            create_table_call method_call = new create_table_call(tbl, resultHandler, this, ___protocolFactory, ___transport);
            if (result.o2 != null) {  
        }
            this.db_name = null;
            @Override
                    while (true) {
                        try {
                    }  
             * Find the _Fields constant that matches fieldId, throwing an exception
        @org.apache.thrift.annotation.Nullable  
            "o3",  
                    return isSetDb_name();
                sb.append(this.tbl);
                    case 1: // O1
                    public void onError(java.lang.Exception e) {  
            DB_NAME((short) 1, "db_name"),
                if (struct.db_name != null) {
                                } else {
        public java.lang.String toString() {
        public boolean equals(java.lang.Object that) {
        }  
        @Override
            org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(create_table_result.class, metaDataMap);  
        }
            @org.apache.thrift.annotation.Nullable  
                        for (Partition _iter163 : struct.success) {
        }
        public void setO1IsSet(boolean value) {  
                    oprot.writeFieldBegin(O1_FIELD_DESC);  
            switch (field) {  
            @Override  
                _Fields.O1,
                        byte msgType = org.apache.thrift.protocol.TMessageType.REPLY;
            try {
                }
            boolean first = true;  
            org.apache.thrift.protocol.TType.STRUCT,
                )
            org.apache.thrift.protocol.TType.I16,  
        public void unsetO2() {
        private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new get_partitions_resultTupleSchemeFactory();
                    struct.validate();
                }
                                    org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);  
                if (lastComparison != 0) {
            }  
            java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<  
                            );
            switch (field) {
                return lastComparison;
            sb.append("o1:");  
                )  
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING  
                    org.apache.thrift.protocol.TField schemeField;  
                    iprot.readStructBegin();
        public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
                        }
            first = false;
            @Override
                    if (value == null) {
                }  
            GetTableResult,
        }
        }
                    struct.o3.write(oprot);
                }
                        schemeField = iprot.readFieldBegin();
            throw new java.lang.IllegalStateException();  
                return false;  
                case O1:  
            lastComparison = java.lang.Boolean.compare(isSetO2(), other.isSetO2());  
                    return isSetO3();
                    return getO3();  
            return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme())  
        public java.util.List<Partition> getSuccess() {
        private byte __isset_bitfield = 0;  
            @Override  
            public boolean isOneway() {
                for (_Fields field : java.util.EnumSet.allOf(_Fields.class)) {  
                org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
        @Override
                throw new java.io.IOException(te);
        private static final org.slf4j.Logger _LOGGER = org.slf4j.LoggerFactory.getLogger(Processor.class.getName());
        }
            // check for required fields  
                throw new java.io.IOException(te);  
                if (lastComparison != 0) {  
        }
                lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.o2, other.o2);
                    case 1: // DATABASE  
             */
            "tbl",
                    prot.decrementRecursionDepth();  
        }
                throws org.apache.thrift.TException {
            TBL((short) 1, "tbl");
                }  
                    return isSetO2();  
                    org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
            new get_table_req_resultStandardSchemeFactory();
            }
        public @org.apache.thrift.annotation.Nullable java.lang.String tbl_name; // required
        public boolean equals(java.lang.Object that) {
                            _LOGGER.error("TTransportException writing to internal frame buffer", e);
        private static class create_table_resultStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
                return fields;  
            }  
        @Override
        public create_database_args() {}
                                    struct.setTbl_nameIsSet(true);  
                }
            }  
            public static _Fields findByName(java.lang.String name) {
            Cloneable,  
        }  
            scheme(iprot).read(iprot, this);  
            this.o1 = o1;  
                            _LOGGER.error("Exception writing to internal frame buffer", ex);  
            lastComparison = java.lang.Boolean.compare(isSetO1(), other.isSetO1());
            hashCode = hashCode * 8191 + ((isSetO2()) ? 131071 : 524287);
                    } else {
        }
                iface,
            if (lastComparison != 0) {
                }
                    } else {
            }  
                        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) {
                    if (value == null) {
            );
                }
                if (struct.isSetSuccess()) {
            if (this_present_o3 || that_present_o3) {
                        return TBL;  
                    return getO1();
                if (!this.o2.equals(that.o2)) return false;  
            metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
                if (fields == null) throw new java.lang.IllegalArgumentException("Field " + fieldId + " doesn't exist!");
                    org.apache.thrift.TFieldRequirementType.DEFAULT,  
            I,
            public short getThriftFieldId() {
        public void create_database(Database database, org.apache.thrift.async.AsyncMethodCallback<Void> resultHandler)
            java.io.Serializable,
                    struct.o2.write(oprot);  
                    "tbl",
                java.lang.String db_name,
                return false;  
                _Fields.O1,  
            private final java.lang.String _fieldName;
                                } else {
                            msg = result;
                    break;
            if (field == null) {
                final int seqid  
            }
            boolean that_present_o1 = true && that.isSetO1();
                );  
            "o1",  
            if (lastComparison != 0) {  
                org.apache.thrift.async.TAsyncClient client,
        }
            get_table_req_args args = new get_table_req_args();
                        ? extends org.apache.thrift.TBase>> processMap  
            }  
            this.o2 = null;
        public Partition getSuccess() {
            this.o2 = o2;
            @Override
            }
                    oprot.writeFieldEnd();
                            msg = (org.apache.thrift.TApplicationException) e;  
        }  
            );
                        setMax_parts((java.lang.Short) value);
                switch (fieldId) {
            if (this.success == null) {
        public get_partitions_by_filter_result deepCopy() {  
 */
            args.setTbl(tbl);
        }  
                    if (incoming.get(0)) {  
                return (new Client(prot)).recv_get_partitions_by_filter();
                        return NEW_PART;
    @SuppressWarnings({ "cast", "rawtypes", "serial", "unchecked", "unused" })
                    result.o1 = o1;
            org.apache.thrift.async.AsyncMethodCallback<java.util.List<Partition>> resultHandler  
        public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
            protected boolean rethrowUnhandledExceptions() {
                            fb.close();
            }  
            return this.o2;
                _thriftId = thriftId;  
            }
        public static class get_table_req_call extends org.apache.thrift.async.TAsyncMethodCall<GetTableResult> {
            public create_table_result getEmptyResultInstance() {
                org.apache.thrift.protocol.TProtocolFactory protocolFactory,
                if (struct.isSetDb_name()) {
                if (!this.o3.equals(that.o3)) return false;
                    return lastComparison;
                        try {
        }
                        return REQ;  
                                    struct.setO1IsSet(true);
                iface.create_table(args.tbl, resultHandler);  
        private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct(
        @Override
                        } else if (e instanceof MetaException) {
            }
                    if (incoming.get(2)) {  
                            result.o1 = (AlreadyExistsException) e;
        public java.lang.String getDb_name() {  
                    @Override  
            short max_parts,
        public java.lang.String toString() {
                struct.validate();
                        setTbl_name((java.lang.String) value);
            }
                return byName.get(name);
        }  
        }
            public add_partition_args getEmptyArgsInstance() {
                } catch (MetaException o3) {
            }
            try {
                oprot.writeStructBegin(STRUCT_DESC);  
            @Override
                }
            public boolean isOneway() {
            }
        private static final org.apache.thrift.protocol.TField TBL_FIELD_DESC = new org.apache.thrift.protocol.TField(  
                                } else {
                return result;
                struct.validate();
                case O4:  
            hashCode = hashCode * 8191 + ((isSetO1()) ? 131071 : 524287);
                }
                }
                prot.incrementRecursionDepth();
        @Override  
                try {
                if (!this.o3.equals(that.o3)) return false;
        private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {  
        public create_table_result setO1(@org.apache.thrift.annotation.Nullable AlreadyExistsException o1) {
             */  
                return byName.get(name);
        @Override
        private static class add_partition_resultTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
                new org.apache.thrift.meta_data.FieldMetaData(
                if (!this.success.equals(that.success)) return false;
        public @org.apache.thrift.annotation.Nullable GetTableResult success; // required
            int hashCode = 1;
                    oprot.writeString(struct.tbl_name);  
        @Override  
            if (this_present_filter || that_present_filter) {  
        public void validate() throws org.apache.thrift.TException {  
            if (that instanceof create_database_result) return this.equals((create_database_result) that);
            this.o2 = o2;  
                org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
            return this.o2 != null;  
        }  
                        switch (schemeField.id) {
        public create_database_result(AlreadyExistsException o1, InvalidObjectException o2, MetaException o3) {  
            }  
        private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
                    new org.apache.thrift.protocol.TMessage("get_table_req", org.apache.thrift.protocol.TMessageType.CALL, 0)
            java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<  
            throw new org.apache.thrift.TApplicationException(
            }
                }
                database.validate();
            private final short _thriftId;  
            if (this_present_success || that_present_success) {
        @Override
        public int compareTo(get_table_req_args other) {
                    }  
            switch (field) {
            "o2",
        public boolean equals(java.lang.Object that) {
            }
                    org.apache.thrift.TFieldRequirementType.DEFAULT,
                return getClass().getName().compareTo(other.getClass().getName());  
            }
            sb.append("o2:");
            private final java.lang.String _fieldName;  
                    byName.put(field.getFieldName(), field);
                                } else {
        }
                if (lastComparison != 0) {
            @Override
            return this.db_name != null;  
            if (other.isSetTbl_name()) {  
            }
                }  
        }  
            hashCode = hashCode * 8191 + ((isSetO1()) ? 131071 : 524287);  
            this();
                        return DB_NAME;
        }
        /** Returns true if field o2 is set (has been assigned a value) and false otherwise */
                } finally {
            if (this.filter == null) {
        }
            if (this_present_tbl_name || that_present_tbl_name) {
                                    struct.db_name = iprot.readString();
            }  
                        struct.setSuccessIsSet(true);  
            public void write_args(org.apache.thrift.protocol.TProtocol prot) throws org.apache.thrift.TException {
            return this.db_name != null;  
    public static class create_table_result
                case SUCCESS:
                return new add_partition_args();
                }  
            public get_table_req_result getEmptyResultInstance() {  
            return false;
            return this;
            @Override  
            public boolean isOneway() {  
        /** Returns true if field o3 is set (has been assigned a value) and false otherwise */
            }  
        }
            return _Fields.findByThriftId(fieldId);
        /**
        public NoSuchObjectException getO1() {
        }  
            receiveBase(result, "get_partitions");  
                        struct.setO1IsSet(true);
            I,
        public void unsetTbl_name() {
                }
                    default:
            }
            }
        }  
                return new get_partitions_by_filter_result();
            this.success = success;  
                        get_partitions_result result = new get_partitions_result();
            try {
        }  
        public java.lang.Object getFieldValue(_Fields field) {
            short max_parts  
                new org.apache.thrift.meta_data.FieldMetaData(
        public get_partitions_by_filter_args deepCopy() {
                    "tbl_name",
            if (isSetO2()) hashCode = hashCode * 8191 + o2.hashCode();  
        }  
                this.o4 = new NoSuchObjectException(other.o4);  
            scheme(iprot).read(iprot, this);
            public java.lang.String getFieldName() {
                if (lastComparison != 0) {
            }
                return _fieldName;  
            throw new java.lang.IllegalStateException();
                if (struct.isSetO1()) {  
            return this.o2;
    public static class add_partition_args  
                new org.apache.thrift.meta_data.FieldMetaData(
            @Override
        @org.apache.thrift.annotation.Nullable  
            boolean that_present_tbl = true && that.isSetTbl();  
                    return lastComparison;  
                            return;
            }
            if (other.isSetDb_name()) {  
            tmpMap.put(  
                    "success",
                        return null;
            }
            public java.lang.String getFieldName() {
                                if (schemeField.type == org.apache.thrift.protocol.TType.LIST) {
            }  
                case O1:
            }
            java.lang.String filter,  
                            msg = result;
        public void validate() throws org.apache.thrift.TException {
            }
            }  
            }  
            }  
        }  
                _thriftId = thriftId;
                if (struct.isSetTbl_name()) {
            this.db_name = null;
                _Fields.SUCCESS,
                if (struct.isSetO1()) {
                    }  
    }
        public void setSuccessIsSet(boolean value) {
        }
                    iprot.readStructBegin();  
                } catch (NoSuchObjectException o1) {  
            throw new java.lang.IllegalStateException();
            getProcessMap(
                _thriftId = thriftId;  
                                org.apache.thrift.TApplicationException.INTERNAL_ERROR,
                if (lastComparison != 0) {  
            public void write(org.apache.thrift.protocol.TProtocol oprot, create_database_args struct) throws org.apache.thrift.TException {
                                    struct.o2.read(iprot);
            first = false;
                lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.o1, other.o1);  
            public get_partitions_by_filter_resultStandardScheme getScheme() {
        public enum _Fields implements org.apache.thrift.TFieldIdEnum {  
            }
            @org.apache.thrift.annotation.Nullable
                    while (true) {
        @Override
                throws org.apache.thrift.TException {  
            this.o1 = o1;  
        }
                oprot.writeFieldStop();  
            private final short _thriftId;
                return null;
                this.max_parts = max_parts;  
        @Override
                        unsetO3();
        }
                ? STANDARD_SCHEME_FACTORY  
                    }
        }
            }
            }  
                return new get_table_req_args();
                        try {  
                for (_Fields field : java.util.EnumSet.allOf(_Fields.class)) {  
            }  
        @Override
            FILTER((short) 3, "filter"),  
        }
            public java.lang.String getFieldName() {
            }  
        public void validate() throws org.apache.thrift.TException {
                                } else {
        /** Returns true if field success is set (has been assigned a value) and false otherwise */
            }
        public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
            if (result.o3 != null) {
        public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;  
                }  
                        schemeField = iprot.readFieldBegin();
                    if (incoming.get(2)) {
        /** Returns true if field o1 is set (has been assigned a value) and false otherwise */  
            "get_partitions_by_filter_result"  
                throws org.apache.thrift.TException {  
                    "success",
                } catch (MetaException o3) {
        }
        }  
                                    struct.new_part.read(iprot);
                    org.apache.thrift.TFieldRequirementType.DEFAULT,
                    }  
        private static final org.apache.thrift.protocol.TField SUCCESS_FIELD_DESC = new org.apache.thrift.protocol.TField(
                final org.apache.thrift.server.AbstractNonblockingServer.AsyncFrameBuffer fb,
                    return getDb_name();
                return _fieldName;  
                new org.apache.thrift.meta_data.FieldMetaData(  
        public Partition add_partition(Partition new_part) throws InvalidObjectException, AlreadyExistsException, MetaException,
        }
                _Fields,
        public int hashCode() {  
        }  
                        struct.o1.read(iprot);
            boolean that_present_new_part = true && that.isSetNew_part();
            public static _Fields findByName(java.lang.String name) {
        public add_partition_result deepCopy() {  
            public void write(org.apache.thrift.protocol.TProtocol prot, get_partitions_args struct) throws org.apache.thrift.TException {
                            break;
                oprot.writeStructBegin(STRUCT_DESC);
            if (that == null) return false;
        }  
        }
                        struct.o2 = new InvalidObjectException();
                            result.o1 = (MetaException) e;
                _Fields.TBL_NAME,  
            return processMap;
            this.success = success;  
            if (that instanceof create_database_args) return this.equals((create_database_args) that);
             * Find the _Fields constant that matches fieldId, throwing an exception  
            // check for sub-struct validity  
                if (struct.isSetSuccess()) {
            return hashCode;
                    optionals.set(2);
                        }
                    throw new java.lang.IllegalStateException("Method call not finished!");
                ? STANDARD_SCHEME_FACTORY
                lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.o2, other.o2);
                            case 1: // O1  
            if (result.o2 != null) {
            "o3",  
                sb.append(this.o1);
            public get_partitions_by_filter_argsStandardScheme getScheme() {  
                throws org.apache.thrift.TException {
            if (isSetO2()) hashCode = hashCode * 8191 + o2.hashCode();
                if (lastComparison != 0) {  
                ___transport
            }
                                if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {  
            ___manager.call(method_call);
                            result.o2 = (AlreadyExistsException) e;
                }  
                            }
                }  
                        struct.tbl = new Table();
                } finally {
            boolean that_present_o1 = true && that.isSetO1();
                                    struct.setDb_nameIsSet(true);
            throw new java.lang.IllegalStateException();
                        } else if (e instanceof org.apache.thrift.TApplicationException) {  
                org.apache.thrift.async.TAsyncClient client,
                if (lastComparison != 0) {
            }
        @Override  
            recv_create_table();  
                    return lastComparison;
                }
                    optionals.set(1);  
                throw new java.io.IOException(te);
        @Override
            public void write(org.apache.thrift.protocol.TProtocol prot, create_database_args struct) throws org.apache.thrift.TException {
        }
        public void setO1IsSet(boolean value) {
            // check for required fields  
                return new add_partition_resultTupleScheme();
                    org.apache.thrift.protocol.TField schemeField;
            sb.append(this.max_parts);
                case O1:
            } else {  
            scheme(oprot).write(oprot, this);
                sb.append(this.success);  
            @org.apache.thrift.annotation.Nullable
                this.success = null;  
        private static class get_table_req_resultStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
                                    org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            this.o2 = null;
            this.o1 = null;
            sb.append("o3:");  
            this.o3 = o3;  
                org.apache.thrift.TException {
                        } else if (e instanceof MetaException) {  
                    oprot.writeFieldEnd();  
        }  
                        struct.setTbl_nameIsSet(true);
                    default:  
            if (this.o1 == null) {
            switch (field) {
                throws org.apache.thrift.TException {
                            fb.close();
                        try {  
            @org.apache.thrift.annotation.Nullable
                    if (incoming.get(0)) {  
            this.___currentMethod = method_call;
        }  
        private static class create_database_argsTupleScheme extends org.apache.thrift.scheme.TupleScheme<create_database_args> {
                    return getDatabase();  
                    case 1: // O1
        @Override  
            boolean that_present_max_parts = true;  
                return _fieldName;
        private static final org.apache.thrift.protocol.TField DATABASE_FIELD_DESC = new org.apache.thrift.protocol.TField(  
                return new org.apache.thrift.async.AsyncMethodCallback<Partition>() {
                sb.append("null");
            @Override  
        public int compareTo(create_table_args other) {
                );
            }
                return result.success;
                this,
            return this;
                    } else {  
            @Override
            this.o2 = null;
            }  
                    break;
            if (lastComparison != 0) {  
            metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
            );
        @Override
            public static _Fields findByThriftId(int fieldId) {
            @Override  
        public void setTbl_nameIsSet(boolean value) {
        private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY =  
                                    struct.o2.read(iprot);
                return lastComparison;  
                        switch (schemeField.id) {  
            return this.tbl_name != null;
        }
                prot.writeMessageEnd();  
                                }
            ) {
            }
                _Fields,
        @Override
                try {  
        public @org.apache.thrift.annotation.Nullable AlreadyExistsException o1; // required
                }
                        }  
        public boolean isSetMax_parts() {
                if (!this.success.equals(that.success)) return false;
        private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
                this.filter = filter;
            if (!first) sb.append(", ");  
                ? STANDARD_SCHEME_FACTORY
            }
                write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
                    // check for required fields of primitive type, which can't be checked in the validate method
            }  
            }
            return false;
                case O2:
            // check for required fields
        }
            public get_table_req_result getResult(I iface, get_table_req_args args) throws org.apache.thrift.TException {
                case SUCCESS:
                    new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I16)
                } catch (MetaException o2) {
                throw result.o2;
                sb.append("null");
                    return isSetTbl();
                    iprot.readStructBegin();  
        }
                            _LOGGER.error("TTransportException writing to internal frame buffer", e);  
        }
                    while (true) {
            } else {
                return lastComparison;
                if (!this.database.equals(that.database)) return false;
            @Override
        public void setO2IsSet(boolean value) {  
                    }  
                    new org.apache.thrift.protocol.TMessage("create_table", org.apache.thrift.protocol.TMessageType.CALL, 0)
                    java.util.BitSet incoming = iprot.readBitSet(3);  
                                }  
        public int getSuccessSize() {
            create_database_call method_call = new create_database_call(database, resultHandler, this, ___protocolFactory, ___transport);
                        struct.setO3IsSet(true);  
                } finally {
        private static class create_database_argsStandardScheme extends org.apache.thrift.scheme.StandardScheme<create_database_args> {
                    new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, MetaException.class)  
            return this;
            }  
                return new get_partitions_argsStandardScheme();
            }
        implements  
                prot.writeMessageBegin(
                    }
            "db_name",  
            boolean this_present_db_name = true && this.isSetDb_name();  
                // constructor.
                    }
            switch (field) {
        public void unsetSuccess() {
                        unsetSuccess();
            processMap.put("create_table", new create_table());
                if (struct.database != null) {
                    @Override  
                                if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {
             */
                    oprot.writeFieldEnd();  
                super("create_table");
            public void read(org.apache.thrift.protocol.TProtocol prot, get_partitions_result struct) throws org.apache.thrift.TException {
                super(client, protocolFactory, transport, resultHandler, false);  
                sb.append(this.success);  
        }
            get_partitions_by_filter_result> {  
                )
            tmpMap.put(
                if (struct.isSetNew_part()) {  
        }
                }
            }
        }
        @Override
                this.o1 = new MetaException(other.o1);
            }
        }
                prot.incrementRecursionDepth();  
            (short) 2
        @Override  
                if (!(this_present_database && that_present_database)) return false;  
        }
                        iprot.readFieldEnd();
            get_partitions_by_filter_call method_call = new get_partitions_by_filter_call(
            boolean this_present_tbl_name = true && this.isSetTbl_name();
                lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.db_name, other.db_name);
        @org.apache.thrift.annotation.Nullable  
                }
            hashCode = hashCode * 8191 + ((isSetSuccess()) ? 131071 : 524287);
                }
                    // check for required fields of primitive type, which can't be checked in the validate method
                this.o3 = new MetaException(other.o3);
            args.setNew_part(new_part);
                sb.append(this.o1);
                        schemeField = iprot.readFieldBegin();
                throws org.apache.thrift.TException {
            sendBase("get_table_req", args);  
                        setDb_name((java.lang.String) value);
                    } else {
        }
            this.filter = null;  
            }
                this,
                        struct.o2 = new NoSuchObjectException();  
            this.o1 = null;
                sb.append("null");
                org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;  
                }
                _Fields.DB_NAME,
                    return getNew_part();
            public static _Fields findByName(java.lang.String name) {  
        @org.apache.thrift.annotation.Nullable  
            this.new_part = new_part;
            }  
        public enum _Fields implements org.apache.thrift.TFieldIdEnum {
        );
                if (this.max_parts != that.max_parts) return false;  
            return;
        public void clear() {  
                                            _elem153 = new Partition();
                }
            if (other.isSetO1()) {  
                try {
            public void start(  
            }
        }
                new org.apache.thrift.meta_data.FieldMetaData(  
                    return lastComparison;
                return byName.get(name);  
                if (struct.o4 != null) {
                    struct.success.write(oprot);
                ? STANDARD_SCHEME_FACTORY  
        public get_table_req_args(GetTableRequest req) {  
                for (_Fields field : java.util.EnumSet.allOf(_Fields.class)) {
            private java.lang.String db_name;
                        struct.setMax_partsIsSet(true);
                            fcall.sendResponse(fb, msg, msgType, seqid);
        implements  
            @Override
            } else {
            @Override
                                org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        public create_table_args setTbl(@org.apache.thrift.annotation.Nullable Table tbl) {
                        setDatabase((Database) value);  
                org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);  
                read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
         */  
                if (lastComparison != 0) {  
        private static final org.apache.thrift.protocol.TField SUCCESS_FIELD_DESC = new org.apache.thrift.protocol.TField(
            if (this_present_o3 || that_present_o3) {
                        return null;  
                }  
                    oprot.writeI16(struct.max_parts);  
        public create_database_result setO1(@org.apache.thrift.annotation.Nullable AlreadyExistsException o1) {  
                } catch (AlreadyExistsException o1) {  
                        struct.o1.read(iprot);
                        switch (schemeField.id) {  
                                    struct.setO2IsSet(true);
            }  
                                break;  
                            result.o2 = (NoSuchObjectException) e;  
                prot.incrementRecursionDepth();  
            metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
            }
        public short getMax_parts() {
                    "req",
            (short) 1
        }
            static {
                throws org.apache.thrift.TException {
            if (isSetSuccess()) {
            private static final java.util.Map<java.lang.String, _Fields> byName = new java.util.HashMap<java.lang.String, _Fields>();
        static {
                            msgType = org.apache.thrift.protocol.TMessageType.EXCEPTION;  
                            fcall.sendResponse(fb, result, org.apache.thrift.protocol.TMessageType.REPLY, seqid);
                            case 4: // MAX_PARTS  
            public void read(org.apache.thrift.protocol.TProtocol iprot, get_table_req_result struct) throws org.apache.thrift.TException {  
                            _LOGGER.error("TTransportException inside handler", e);  
            @Override  
            }
        }
        private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY =
            try {
            ) {
                    break;
        }  
            }
                return fields;  
                if (lastComparison != 0) {  
                                if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {
            java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<
        @org.apache.thrift.annotation.Nullable
                    case 0: // SUCCESS
                                break;
        @Override
            } else {  
            }
                                    struct.setO1IsSet(true);
        }  
                org.apache.thrift.protocol.TProtocol prot = client.getProtocolFactory().getProtocol(memoryTransport);
            // check for required fields  
        public _Fields fieldForId(int fieldId) {
                    oprot.writeFieldEnd();
                    }
        public MetaException getO1() {
                return new create_table_result();  
            throw new java.lang.IllegalStateException();
                    // check for required fields of primitive type, which can't be checked in the validate method  
                I iface,
            switch (field) {  
                if (!this.o1.equals(that.o1)) return false;
        public int compareTo(get_table_req_result other) {
                case TBL_NAME:  
            args.setFilter(filter);  
        }
            @Override
                if (!(this_present_o2 && that_present_o2)) return false;
        public get_table_req_args(get_table_req_args other) {
                throw result.o1;
        public java.lang.String getDb_name() {  
                    if (incoming.get(0)) {  
            throw new java.lang.IllegalStateException();
        public void unsetTbl() {
                        setO4((NoSuchObjectException) value);
            create_database_result result = new create_database_result();  
                return new get_partitions_by_filter_args();
            if (other.isSetO1()) {  
                : TUPLE_SCHEME_FACTORY).getScheme();  
        }
            java.lang.String tbl_name,
        }
            this.success = null;
                            _LOGGER.error("Exception inside handler", e);
            @Override  
            if (isSetO1()) {
                    iprot.decrementRecursionDepth();  
        }
                                if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {
                __isset_bitfield = 0;  
            }  
                org.apache.thrift.async.AsyncMethodCallback<Void> resultHandler,
                }
                return false;
            add_partition_result> {
                            case 0: // SUCCESS
            this.max_parts = max_parts;
                oprot.writeFieldBegin(MAX_PARTS_FIELD_DESC);
                return result.success;
            this.database = null;  
            this.tbl_name = tbl_name;
        }
                oprot.writeBitSet(optionals, 4);  
                final org.apache.thrift.AsyncProcessFunction fcall = this;
        }
}  
            public void write(org.apache.thrift.protocol.TProtocol oprot, create_table_args struct) throws org.apache.thrift.TException {  
                if (struct.isSetNew_part()) {
            public add_partition() {
            @Override
                create_table_args args = new create_table_args();
                    "o2",
            public java.lang.String getFieldName() {
                    oprot.writeFieldEnd();
                if (fields == null) throw new java.lang.IllegalArgumentException("Field " + fieldId + " doesn't exist!");
                write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
                if (getState() != org.apache.thrift.async.TAsyncMethodCall.State.RESPONSE_READ) {  
                        }  
            create_table_result> {  
            }
                this.success = null;  
        public boolean isSetTbl_name() {  
            if (this.o2 == null) {
            if (this == that) return true;
            this.tbl = tbl;  
                )  
                        java.lang.String,
            return this;
                            case 2: // O2
        public boolean equals(create_table_result that) {  
            @Override  
            java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<  
        public java.lang.Object getFieldValue(_Fields field) {
        }
                }
        }
            public get_table_req_args getEmptyArgsInstance() {
                _Fields.SUCCESS,  
                get_partitions_args args = new get_partitions_args();
                read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
            if (other.isSetO3()) {
            if (other.isSetO1()) {
        }
            this.o1 = o1;
                _Fields.TBL,
                new org.apache.thrift.meta_data.FieldMetaData(
                return new Client(prot);
        }
        /** Returns true if field o1 is set (has been assigned a value) and false otherwise */  
                }
        public @org.apache.thrift.annotation.Nullable Table tbl; // required  
                if (struct.o2 != null) {
            return this.o3;
                case O1:
        }
            return true;  
                oprot.writeStructEnd();
        public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
                return lastComparison;
                    iprot.readStructEnd();  
            java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<
            if (lastComparison != 0) {  
                                    struct.setNew_partIsSet(true);  
        }
            if (lastComparison != 0) {  
            if (this.success == null) {  
                    "new_part",  
                } finally {
                this.filter = other.filter;
                case O2:  
        public AsyncProcessor(I iface) {
                    return getO1();
                    byName.put(field.getFieldName(), field);
            }
                    oprot.writeFieldBegin(O2_FIELD_DESC);
        }
            sb.append("success:");
                            result.setO1IsSet(true);  
        public _Fields fieldForId(int fieldId) {  
                        switch (schemeField.id) {
            public static _Fields findByThriftIdOrThrow(int fieldId) {
                Table tbl,
        }
            public void write(org.apache.thrift.protocol.TProtocol prot, get_partitions_result struct) throws org.apache.thrift.TException {
                    if (value == null) {
            ) {  
        implements
            public org.apache.thrift.async.AsyncMethodCallback<Partition> getResultHandler(  
            org.apache.thrift.protocol.TType.STRUCT,  
        public boolean equals(create_table_args that) {
                return lastComparison;
                iprot.incrementRecursionDepth();  
                    oprot.writeString(struct.db_name);
                        }
            return (this.success == null) ? 0 : this.success.size();  
        private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY = new create_table_argsStandardSchemeFactory();  
                                            struct.success.add(_elem161);
                                }
            }  
                return new get_table_req_resultStandardScheme();
        @Override
            I,  
                    return getO1();  
                    @Override  
        }  
                    break;
                        struct.o1.read(iprot);
        @Override  
                    struct.o1.write(oprot);  
            try {
            }
                        return O2;
        public void create_table(Table tbl, org.apache.thrift.async.AsyncMethodCallback<Void> resultHandler)
                        struct.success.read(iprot);  
        @Override
            boolean this_present_o3 = true && this.isSetO3();  
                        struct.o2 = new AlreadyExistsException();
                : TUPLE_SCHEME_FACTORY).getScheme();
                        struct.o3.read(iprot);
        }
                if (!(this_present_o2 && that_present_o2)) return false;
                        }
                    return lastComparison;  
                if (fields == null) throw new java.lang.IllegalArgumentException("Field " + fieldId + " doesn't exist!");  
        public void unsetTbl_name() {
            this.max_parts = max_parts;  
                        }
            public add_partition() {  
            @Override
        );  
                                } else {
        /** Returns true if field success is set (has been assigned a value) and false otherwise */
                if (struct.isSetO2()) {
            @Override
                                } else {  
        /** Returns true if field tbl_name is set (has been assigned a value) and false otherwise */
                    new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)
        @org.apache.thrift.annotation.Nullable
            return this.tbl_name;
                } finally {
            }  
            (short) 2  
                        oprot.writeI32(struct.success.size());  
                                e.getMessage()
        /** Returns true if field o4 is set (has been assigned a value) and false otherwise */
                    org.apache.thrift.TFieldRequirementType.DEFAULT,
            int lastComparison = 0;  
                this.o2 = new NoSuchObjectException(other.o2);
                if (struct.isSetMax_parts()) {
            lastComparison = java.lang.Boolean.compare(isSetSuccess(), other.isSetSuccess());  
            if (this_present_o2 || that_present_o2) {
            ) {
        }  
            if (isSetDb_name()) {  
                return fields;
                    }
            java.io.Serializable,  
                prot.incrementRecursionDepth();
                    oprot.writeFieldBegin(DB_NAME_FIELD_DESC);
                                } else {  
                            msg = (org.apache.thrift.TApplicationException) e;
        );
                    // check for required fields of primitive type, which can't be checked in the validate method
            return true;  
        public void setO1IsSet(boolean value) {
            Comparable<add_partition_args> {
        public boolean equals(add_partition_result that) {
                return null;  
                    if (value == null) {
             */  
                    org.apache.thrift.TFieldRequirementType.DEFAULT,
        public void setFieldValue(_Fields field, @org.apache.thrift.annotation.Nullable java.lang.Object value) {
            @Override
            /**
                throw result.o2;
        private static final org.apache.thrift.protocol.TField SUCCESS_FIELD_DESC = new org.apache.thrift.protocol.TField(  
                    oprot.writeFieldEnd();
            if (this == that) return true;  
            }
            }
                    if (value == null) {
            switch (field) {
    @SuppressWarnings({ "cast", "rawtypes", "serial", "unchecked", "unused" })
        }
        @org.apache.thrift.annotation.Nullable  
            }
        }  
            } catch (org.apache.thrift.TException te) {
        public java.lang.Object getFieldValue(_Fields field) {
            this.database = database;
                }
                    default:
            boolean first = true;
                            fcall.sendResponse(fb, msg, msgType, seqid);
                                break;  
        @Override
                        setO1((MetaException) value);  
                try {
        );  
                    org.apache.thrift.TFieldRequirementType.DEFAULT,
        }
            }
            }
                if (struct.isSetTbl_name()) {
            return this.filter;  
                    break;
            return this.o3;
                        return O1;  
                this.filter = null;
                        org.apache.thrift.TSerializable msg;  
            );
            java.util.Map<
                super("get_partitions");
        }
            } catch (org.apache.thrift.TException te) {
            @Override
        }
            @Override
            @org.apache.thrift.annotation.Nullable
        @Override
                : TUPLE_SCHEME_FACTORY).getScheme();
            O2((short) 2, "o2");
            if (result.o1 != null) {
            org.apache.thrift.protocol.TType.STRUCT,  
            if (isSetO1()) hashCode = hashCode * 8191 + o1.hashCode();
                )  
        }  
        }
            public static _Fields findByName(java.lang.String name) {
            private final short _thriftId;  
        private static class get_partitions_by_filter_argsTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
                args.setMax_parts(max_parts);
                        iprot.readFieldEnd();
        @Override
            }  
            }
            @Override  
                    if (incoming.get(0)) {
                sb.append("null");
            return new get_table_req_args(this);
            static {
                    java.util.BitSet incoming = iprot.readBitSet(4);
        }
            "o2",
        public java.lang.Object getFieldValue(_Fields field) {
                if (struct.o1 != null) {
                    new java.util.HashMap<
            } else {
                    @Override
                    new org.apache.thrift.meta_data.ListMetaData(
            ) throws org.apache.thrift.TException {  
                                org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);  
            int lastComparison = 0;  
            public void read(org.apache.thrift.protocol.TProtocol iprot, create_table_result struct) throws org.apache.thrift.TException {
        }
    @SuppressWarnings({ "cast", "rawtypes", "serial", "unchecked", "unused" })  
        private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct(
            }
                        unsetTbl_name();
                try {
        /**  
            }
            public void write_args(org.apache.thrift.protocol.TProtocol prot) throws org.apache.thrift.TException {
            }
        private static final org.apache.thrift.protocol.TField TBL_NAME_FIELD_DESC = new org.apache.thrift.protocol.TField(  
            _Fields(short thriftId, java.lang.String fieldName) {  
            }  
            hashCode = hashCode * 8191 + max_parts;
            this.db_name = null;
                            case 2: // O2
            this.success = null;
        public create_database_result() {}
                    if (value == null) {
                this.tbl_name = other.tbl_name;
        }
            lastComparison = java.lang.Boolean.compare(isSetSuccess(), other.isSetSuccess());  
                                e.getMessage()  
            public create_table() {  
                if (struct.isSetO1()) {  
                        struct.o2.read(iprot);
            private static final java.util.Map<java.lang.String, _Fields> byName = new java.util.HashMap<java.lang.String, _Fields>();  
                        struct.setO2IsSet(true);
            return 0;  
                ___protocolFactory,  
                                    org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        }
                }
        private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, java.lang.ClassNotFoundException {
                    new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, MetaException.class)
                if (lastComparison != 0) {  
        @Override  
                return false;
                )
                        return null;
                                org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);  
        public void send_get_table_req(GetTableRequest req) throws org.apache.thrift.TException {  
            this.o1 = o1;
            this.max_parts = max_parts;  
        @Override  
                new org.apache.thrift.meta_data.FieldMetaData(  
                this.success = new GetTableResult(other.success);
                                break;
            first = false;
                    iprot.readStructEnd();
        }  
            org.apache.thrift.TBase<get_table_req_result, get_table_req_result._Fields>,
                    org.apache.thrift.TFieldRequirementType.DEFAULT,
            if (isSetO1()) hashCode = hashCode * 8191 + o1.hashCode();
                    } else {  
                    optionals.set(0);
            if (lastComparison != 0) {
            return 0;
            @Override
                        org.apache.thrift.TSerializable msg;
        private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, java.lang.ClassNotFoundException {
                args.setFilter(filter);
            hashCode = hashCode * 8191 + ((isSetO2()) ? 131071 : 524287);
        private static final org.apache.thrift.protocol.TField O3_FIELD_DESC = new org.apache.thrift.protocol.TField(
            return processMap;  
        }
                if (!this.o1.equals(that.o1)) return false;
            private final java.lang.String _fieldName;
        public boolean equals(get_table_req_result that) {
        }
                this.o2 = null;
                    } else {  
                            break;
                sb.append(this.tbl_name);
                    }
                    iprot.readStructBegin();
            this.o2 = o2;
            sb.append("db_name:");  
                    break;
        @Override
            super(  
            sb.append(this.max_parts);
                super("get_table_req");
                write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));  
                    struct.o3.write(oprot);
                                    struct.database = new Database();  
                }
            org.apache.thrift.protocol.TType.STRUCT,
                if (!this.o2.equals(that.o2)) return false;  
        }
            }  
            setMax_partsIsSet(false);
        @org.apache.thrift.annotation.Nullable
                org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
            }
                            break;
                            fb.close();
            }
            sb.append("filter:");
                                } else {  
        public java.util.List<Partition> recv_get_partitions() throws NoSuchObjectException, MetaException, org.apache.thrift.TException {
                    return isSetTbl_name();
            @Override  
            create_table_args,
                        result.success = o;
                org.apache.thrift.AsyncProcessFunction<  
        }
                    new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, Partition.class)  
            this();  
            private final short _thriftId;
            private static final java.util.Map<java.lang.String, _Fields> byName = new java.util.HashMap<java.lang.String, _Fields>();
                            fb.close();
        }
            @Override  
            if (!value) {
            } catch (org.apache.thrift.TException te) {  
            /**
            org.apache.thrift.protocol.TType.STRUCT,  
        }  
                                break;  
            }
             * if it is not found.
                _Fields fields = findByThriftId(fieldId);  
            if (other.isSetDatabase()) {
        }
            public static _Fields findByName(java.lang.String name) {
            O2((short) 2, "o2"),
            }
                        org.apache.thrift.ProcessFunction<I, ? extends org.apache.thrift.TBase, ? extends org.apache.thrift.TBase>>()  
                                    struct.setSuccessIsSet(true);  
        public boolean equals(create_database_result that) {  
            return this.o1;  
                _Fields.O2,  
                        } catch (java.lang.Exception e) {
                    }
                if (struct.filter != null) {
            public java.util.List<Partition> getResult() throws NoSuchObjectException, MetaException, org.apache.thrift.TException {
            first = false;
        }
                return lastComparison;  
            @Override
                        struct.setO2IsSet(true);
        }
            I,
            if (isSetDb_name()) {  
        @Override
                if (struct.isSetO2()) {
            if (isSetO3()) {
            hashCode = hashCode * 8191 + ((isSetO2()) ? 131071 : 524287);
            public void write(org.apache.thrift.protocol.TProtocol prot, get_table_req_result struct) throws org.apache.thrift.TException {
            this.o1 = null;
            processMap.put("get_partitions", new get_partitions());
        @Override
            ___manager.call(method_call);  
            }
        private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct(
                                }
            return this.o1;  
                        } else if (e instanceof org.apache.thrift.TApplicationException) {
            public short getThriftFieldId() {
                            _LOGGER.error("Exception writing to internal frame buffer", ex);  
        public boolean isSet(_Fields field) {  
                                    org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            return sb.toString();
                for (_Fields field : java.util.EnumSet.allOf(_Fields.class)) {
            protected boolean rethrowUnhandledExceptions() {
                prot.incrementRecursionDepth();  
            I,
    public static class get_table_req_result
                this.o2 = null;  
        }
            @Override  
                    }  
            if (this.o1 == null) {  
                }
        }
                            msgType = org.apache.thrift.protocol.TMessageType.EXCEPTION;
                                } else {  
        }
                }
            ) {  
            java.lang.StringBuilder sb = new java.lang.StringBuilder("create_database_args(");
            lastComparison = java.lang.Boolean.compare(isSetO1(), other.isSetO1());
            ) {  
                        iprot.readFieldEnd();
                        struct.success = new GetTableResult();
            }
            }
                } finally {
                }  
            scheme(iprot).read(iprot, this);
            }
        }
                org.apache.thrift.protocol.TProtocolFactory protocolFactory,  
             */
                org.apache.thrift.ProcessFunction<I, ? extends org.apache.thrift.TBase, ? extends org.apache.thrift.TBase>>  
                case MAX_PARTS:
            }
                    }  
                this.tbl_name = tbl_name;
        public void setO2IsSet(boolean value) {  
                    new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, InvalidObjectException.class)
                    }  
                java.util.BitSet optionals = new java.util.BitSet();  
                    org.apache.thrift.protocol.TField schemeField;  
                                e.getMessage()
                        create_table_result result = new create_table_result();
                    struct.o1.write(oprot);
            sb.append(")");
                    }
            org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(create_database_args.class, metaDataMap);
                                org.apache.thrift.TApplicationException.INTERNAL_ERROR,
                        get_partitions_by_filter_result result = new get_partitions_by_filter_result();  
        public add_partition_args deepCopy() {
                        return O2;
            public get_partitions_argsStandardScheme getScheme() {  
                    if (value == null) {
             */
                if (lastComparison != 0) {
            sb.append("new_part:");  
                new_part.validate();  
            java.lang.StringBuilder sb = new java.lang.StringBuilder("add_partition_args(");  
                        setO1((InvalidObjectException) value);
        );
                            @org.apache.thrift.annotation.Nullable
        public _Fields fieldForId(int fieldId) {  
                    optionals.set(2);
                    return isSetSuccess();
        public @org.apache.thrift.annotation.Nullable NoSuchObjectException o2; // required
            boolean that_present_success = true && that.isSetSuccess();
            throw new java.lang.IllegalStateException();
                try {  
                    org.apache.thrift.TFieldRequirementType.DEFAULT,
                                if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {
                case DB_NAME:
                        }
            if (!value) {
        public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
                        iprot.readFieldEnd();
    @SuppressWarnings({ "cast", "rawtypes", "serial", "unchecked", "unused" })
        }
                    while (true) {  
                case O1:
                    "o3",
        private static class create_database_resultStandardScheme extends org.apache.thrift.scheme.StandardScheme<create_database_result> {
        public boolean isSetO4() {
        @org.apache.thrift.annotation.Nullable  
                    }
            boolean that_present_o2 = true && that.isSetO2();
    }  
        private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new get_table_req_resultTupleSchemeFactory();  
            setMax_partsIsSet(true);
                    if (value == null) {
            scheme(iprot).read(iprot, this);  
            boolean this_present_max_parts = true;
        }
            }  
                    oprot.writeFieldEnd();
            }
                    break;  
                if (lastComparison != 0) {
            O1((short) 1, "o1"),
                lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.tbl, other.tbl);
            java.lang.String filter,
            org.apache.thrift.protocol.TType.STRING,  
            this.o2 = null;
            ) throws org.apache.thrift.TException {
             * Find the _Fields constant that matches fieldId, or null if its not found.
                return lastComparison;  
            this.o3 = o3;
            add_partition_result result = new add_partition_result();
            @Override
                }
        }
        }
            throw new org.apache.thrift.TApplicationException(  
        @org.apache.thrift.annotation.Nullable
    }
                new org.apache.thrift.meta_data.FieldMetaData(
            return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme())
                                } else {
         */
            return true;  
                return lastComparison;
                )
                    return isSetMax_parts();  
                        struct.setSuccessIsSet(true);  
        public static class Factory implements org.apache.thrift.async.TAsyncClientFactory<AsyncClient> {  
        private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
            private final java.lang.String _fieldName;  
            org.apache.thrift.TBase<get_partitions_args, get_partitions_args._Fields>,
                }
                new org.apache.thrift.meta_data.FieldMetaData(  
                    new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, Partition.class)
                    result.success = iface.add_partition(args.new_part);  
            }  
                sb.append("null");  
        }
        private static class create_table_resultTupleScheme extends org.apache.thrift.scheme.TupleScheme<create_table_result> {
        @Override
            public get_partitions_result getEmptyResultInstance() {  
                    java.util.BitSet incoming = iprot.readBitSet(3);
            }  
                }  
        }
            boolean this_present_o1 = true && this.isSetO1();
                    } else {
            @Override
                    new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, NoSuchObjectException.class)  
                if (struct.isSetO1()) {  
        public int hashCode() {
            }
                    return getSuccess();
            @Override
            switch (field) {  
                if (struct.isSetO1()) {
            boolean this_present_o1 = true && this.isSetO1();
        public get_partitions_result setO2(@org.apache.thrift.annotation.Nullable MetaException o2) {
                if (fields == null) throw new java.lang.IllegalArgumentException("Field " + fieldId + " doesn't exist!");
                return new org.apache.thrift.async.AsyncMethodCallback<Void>() {  
        }
                return _thriftId;  
        }
                    result.o4 = o4;
                    return isSetO1();
                resultHandler,
            switch (field) {
            }
                                } else {  
                        struct.req = new GetTableRequest();
                    if (incoming.get(1)) {
                                    org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(add_partition_args.class, metaDataMap);  
            @Override  
                    if (value == null) {
                throw result.o2;
            Void,
                                org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            static {
            }
            create_database_result> {  
                this.success = null;  
                }
        @org.apache.thrift.annotation.Nullable
            public void read(org.apache.thrift.protocol.TProtocol prot, create_table_result struct) throws org.apache.thrift.TException {  
                lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.o1, other.o1);  
                throw result.o1;
                    "o2",
                    if (value == null) {
            throws NoSuchObjectException, MetaException, org.apache.thrift.TException {
                throw new java.lang.IllegalArgumentException();
        @Override  
                    return lastComparison;
        /** Returns true if field o1 is set (has been assigned a value) and false otherwise */  
                iface.create_database(args.database, resultHandler);  
                sb.append("null");
                    oprot.writeFieldBegin(TBL_NAME_FIELD_DESC);
                } finally {  
        }
        protected AsyncProcessor(
                return false;  
        public int compareTo(create_database_result other) {  
                if (!(this_present_success && that_present_success)) return false;
                org.apache.thrift.async.AsyncMethodCallback<GetTableResult> resultHandler,
            this.o4 = null;
        }
                            msg = result;
                        iprot.readFieldEnd();  
                        } catch (java.lang.Exception e) {
                }
        public void setO2IsSet(boolean value) {
        }
            org.apache.thrift.async.AsyncMethodCallback<java.util.List<Partition>> resultHandler
                return _fieldName;  
                this.o1 = new AlreadyExistsException(other.o1);  
            private static final java.util.Map<java.lang.String, _Fields> byName = new java.util.HashMap<java.lang.String, _Fields>();  
                }
            public void read(org.apache.thrift.protocol.TProtocol prot, get_partitions_by_filter_args struct)
            public static _Fields findByThriftId(int fieldId) {
                        } catch (java.lang.Exception ex) {
                                } else {
        implements
        }  
            if (lastComparison != 0) {
                    new org.apache.thrift.protocol.TMessage("create_database", org.apache.thrift.protocol.TMessageType.CALL, 0)
                if (struct.success != null) {
            lastComparison = java.lang.Boolean.compare(isSetTbl_name(), other.isSetTbl_name());  
                case MAX_PARTS:
        @org.apache.thrift.annotation.Nullable
        private static class get_table_req_resultTupleScheme extends org.apache.thrift.scheme.TupleScheme<get_table_req_result> {
            first = false;
                if (!(this_present_filter && that_present_filter)) return false;
            }
            }
            int lastComparison = 0;  
        public java.lang.String toString() {
                } finally {  
                if (getState() != org.apache.thrift.async.TAsyncMethodCall.State.RESPONSE_READ) {  
        public get_table_req_result() {}  
                _thriftId = thriftId;
                                        Partition _elem153;
        public _Fields fieldForId(int fieldId) {  
                return new create_table_argsStandardScheme();  
            if (result.isSetSuccess()) {  
        public get_partitions_by_filter_result(java.util.List<Partition> success, MetaException o1, NoSuchObjectException o2) {  
                                    org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            public Factory() {}  
            // check for sub-struct validity
                    } else {
                _Fields,
                if (!(this_present_o1 && that_present_o1)) return false;
                        struct.setDb_nameIsSet(true);
            if (isSetO2()) hashCode = hashCode * 8191 + o2.hashCode();
                            case 3: // O3
            MAX_PARTS((short) 3, "max_parts");  
            if (this == that) return true;
        public get_table_req_result deepCopy() {
        public void unsetMax_parts() {  
        public void unsetO1() {
        public create_table_result setO4(@org.apache.thrift.annotation.Nullable NoSuchObjectException o4) {
        }
            if (result.o2 != null) {  
            @Override
        public void validate() throws org.apache.thrift.TException {
                this.o2 = null;
                                    struct.setO2IsSet(true);  
            scheme(oprot).write(oprot, this);  
        }
        public get_partitions_result setO1(@org.apache.thrift.annotation.Nullable NoSuchObjectException o1) {  
            }
        }
                        } else if (e instanceof InvalidObjectException) {  
        public AlreadyExistsException getO1() {
            @org.apache.thrift.annotation.Nullable  
            // check for sub-struct validity
                    struct.o1.write(oprot);
                    return isSetDatabase();  
                    } else {
                    @Override  
            boolean that_present_db_name = true && that.isSetDb_name();  
                }
                }  
                throw result.o1;
            @Override  
                }  
                        return TBL_NAME;
                    oprot.writeFieldEnd();
        }
                    }  
        @Override
            this.success = null;  
            first = false;
                        }
            public org.apache.thrift.async.AsyncMethodCallback<Void> getResultHandler(
                sb.append("null");
                        struct.setO4IsSet(true);
                    if (value == null) {
                if (struct.o3 != null) {  
            if (!value) {
            }  
                if (!this.success.equals(that.success)) return false;  
                    if (incoming.get(0)) {
            java.io.Serializable,  
            hashCode = hashCode * 8191 + ((isSetO2()) ? 131071 : 524287);  
                    oprot.writeFieldBegin(SUCCESS_FIELD_DESC);
            hashCode = hashCode * 8191 + ((isSetO2()) ? 131071 : 524287);
        private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY =  
                        } else {
            if (isSetDb_name()) hashCode = hashCode * 8191 + db_name.hashCode();
            public void write(org.apache.thrift.protocol.TProtocol prot, get_table_req_args struct) throws org.apache.thrift.TException {
                    // check for required fields of primitive type, which can't be checked in the validate method
            this.o1 = null;
                                if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {  
                    ? extends org.apache.thrift.TBase>> processMap
            int lastComparison = 0;
                            result.o3 = (MetaException) e;
        }  
                iface.get_table_req(args.req, resultHandler);  
                                    struct.o1.read(iprot);
                }  
            /**
            return this.req;
                                    org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);  
                            _LOGGER.error("TTransportException inside handler", e);
                    return getMax_parts();
        public boolean isSet(_Fields field) {
                };
            public create_database_resultTupleScheme getScheme() {
                                    struct.o1 = new AlreadyExistsException();  
        }
                    oprot.writeFieldEnd();
                    }
             */  
            org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(create_table_args.class, metaDataMap);
        public Client(org.apache.thrift.protocol.TProtocol prot) {
            hashCode = hashCode * 8191 + max_parts;
                            I,  
        public static class get_partitions_call extends org.apache.thrift.async.TAsyncMethodCall<java.util.List<Partition>> {
        public MetaException getO3() {
                        get_table_req_result result = new get_table_req_result();
            );
            try {
            if (!value) {
                return getClass().getName().compareTo(other.getClass().getName());
        public void recv_create_table() throws AlreadyExistsException, InvalidObjectException, MetaException, NoSuchObjectException,  
            /**
                org.apache.thrift.protocol.TProtocol prot = client.getProtocolFactory().getProtocol(memoryTransport);
            this();
            hashCode = hashCode * 8191 + ((isSetFilter()) ? 131071 : 524287);
                                    struct.o3.read(iprot);
                case O4:  
        private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct(
            if (!first) sb.append(", ");  
                        struct.setO2IsSet(true);
        }  
            if (this == that) return true;  
         */
                        }
            "req",
            public get_partitions_result getEmptyResultInstance() {
            return new create_database_result(this);  
        @Override
                lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.max_parts, other.max_parts);
                        } catch (org.apache.thrift.transport.TTransportException e) {  
        }
                    oprot.writeString(struct.filter);  
        @org.apache.thrift.annotation.Nullable  
                        setReq((GetTableRequest) value);
                struct.validate();
            }
            if (isSetReq()) {
                return new org.apache.thrift.async.AsyncMethodCallback<GetTableResult>() {  
                            case 0: // SUCCESS
                    return lastComparison;  
                }
                )
                    struct.o1.write(oprot);
        public int hashCode() {
                            default:
                ? STANDARD_SCHEME_FACTORY  
        @Override
                )
            private final short _thriftId;
                        }  
                new org.apache.thrift.meta_data.FieldMetaData(  
                super("add_partition");  
            this.___currentMethod = method_call;  
        @org.apache.thrift.annotation.Nullable
                throw new java.io.IOException(te);
                    }
                    case 1: // DB_NAME
                sb.append(this.o2);
                    }  
            }
            throw new java.lang.IllegalStateException();
            if (isSetO2()) {  
        public static class get_partitions_by_filter<I extends Iface> extends org.apache.thrift.ProcessFunction<  
        public void create_table(Table tbl) throws AlreadyExistsException, InvalidObjectException, MetaException, NoSuchObjectException,  
            java.util.Map<
            return sb.toString();
        @Override  
            }  
                java.util.BitSet optionals = new java.util.BitSet();
            }
            return this.o4 != null;  
            if (result.o4 != null) {
            }
        }
            get_partitions_result> {  
                return new get_partitions_args();
        public create_database_result(create_database_result other) {
                return lastComparison;
        @Override
                    if (incoming.get(2)) {
                    break;
                        } catch (java.lang.Exception ex) {
        }
        private static class get_table_req_argsStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {  
        public void setFieldValue(_Fields field, @org.apache.thrift.annotation.Nullable java.lang.Object value) {
            this.o2 = null;
        public void setMax_partsIsSet(boolean value) {  
            "success",
                }  
            TBL_NAME((short) 2, "tbl_name"),
                    java.util.BitSet incoming = iprot.readBitSet(4);
            if (that instanceof add_partition_args) return this.equals((add_partition_args) that);
                oprot.writeStructBegin(STRUCT_DESC);  
                throw result.o1;
        public NoSuchObjectException getO2() {  
                        try {  
        }  
            org.apache.thrift.protocol.TType.STRING,
                        struct.o2 = new InvalidObjectException();
                    iface.create_database(args.database);  
                            _LOGGER.error("Exception writing to internal frame buffer", e);
        private static class add_partition_argsTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
        }
            public void read(org.apache.thrift.protocol.TProtocol prot, create_table_args struct) throws org.apache.thrift.TException {
            if (that == null) return false;
            return new get_table_req_result(this);
                return new get_partitions_result();
        }
                                break;  
            public create_database_argsTupleScheme getScheme() {  
            @Override  
        }
            lastComparison = java.lang.Boolean.compare(isSetTbl_name(), other.isSetTbl_name());  
        /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
                return getClass().getName().compareTo(other.getClass().getName());
            lastComparison = java.lang.Boolean.compare(isSetTbl(), other.isSetTbl());  
            return this.success;
            }
            throws org.apache.thrift.TException {
            } else {
                return false;  
                org.apache.thrift.transport.TMemoryInputTransport memoryTransport = new org.apache.thrift.transport.TMemoryInputTransport(
            }  
            /**
            org.apache.thrift.TBase<add_partition_result, add_partition_result._Fields>,  
            org.apache.thrift.TException;
            protected boolean rethrowUnhandledExceptions() {
            boolean this_present_o1 = true && this.isSetO1();  
            }
                java.util.List<Partition> __this__success = new java.util.ArrayList<Partition>(other.success.size());  
                    new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, Database.class)
            boolean that_present_o2 = true && that.isSetO2();  
                            case 1: // DB_NAME  
        private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, java.lang.ClassNotFoundException {
                    iprot.decrementRecursionDepth();  
                if (struct.o2 != null) {
            }  
                _Fields fields = findByThriftId(fieldId);  
            }
                                }  
                throw new java.io.IOException(te);
            if (this.o2 == null) {
            "o1",  
                    }
            private final java.lang.String _fieldName;
        static {
            this();
                    "o2",
            if (isSetO1()) {
                    org.apache.thrift.TFieldRequirementType.DEFAULT,  
            }
                sb.append("null");  
                        unsetO3();  
                        if (e instanceof AlreadyExistsException) {
            java.io.Serializable,
            hashCode = hashCode * 8191 + ((isSetO4()) ? 131071 : 524287);  
                return new get_partitions_by_filter_args();
                new org.apache.thrift.meta_data.FieldMetaData(
        }  
            } catch (org.apache.thrift.TException te) {  
                        return FILTER;
                prot.writeMessageBegin(
        public boolean isSetDb_name() {
                            return;
        }
        /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
                    return lastComparison;  
        ) {
                this.new_part = null;
                oprot.writeStructEnd();
                        schemeField = iprot.readFieldBegin();  
        }  
             */  
            if (this.success == null) {  
                if (this.max_parts != that.max_parts) return false;  
                    org.apache.thrift.TFieldRequirementType.DEFAULT,  
            public void read(org.apache.thrift.protocol.TProtocol prot, add_partition_result struct) throws org.apache.thrift.TException {
                super(client, protocolFactory, transport, resultHandler, false);  
        public @org.apache.thrift.annotation.Nullable java.util.List<Partition> success; // required  
                java.lang.String db_name,
                    if (incoming.get(1)) {
                    case 3: // O3
            if (isSetO2()) {  
                        unsetO4();
                    return lastComparison;  
            }
        }
            public create_database_result getResult(I iface, create_database_args args) throws org.apache.thrift.TException {  
        public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {  
            @Override  
            }
        public void clear() {
                            case 2: // TBL_NAME
            if (!first) sb.append(", ");  
                if (struct.isSetFilter()) {
        @Override
            return new get_partitions_by_filter_result(this);
            boolean that_present_o2 = true && that.isSetO2();  
                        }  
                org.apache.thrift.transport.TNonblockingTransport transport  
            }
            org.apache.thrift.async.AsyncMethodCallback<java.util.List<Partition>> resultHandler  
            }
                    case 1: // DB_NAME
            @Override  
                _fieldName = fieldName;
        private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY =
                    }
        @Override  
        public @org.apache.thrift.annotation.Nullable MetaException o3; // required
                            _LOGGER.error("TTransportException inside handler", e);
        }  
                            case 1: // O1
        /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
            args.setTbl_name(tbl_name);
            this.o1 = null;  
                        }  
        public void addToSuccess(Partition elem) {
                } catch (InvalidObjectException o1) {
                    }
            // check for required fields
             * Find the _Fields constant that matches fieldId, throwing an exception
            if (other.isSetSuccess()) {
        public java.lang.String getTbl_name() {
        public boolean isSetO3() {
            org.apache.thrift.protocol.TType.STRUCT,
            try {
            return 0;
            }  
            }  
            ) throws org.apache.thrift.TException {
            if (lastComparison != 0) {  
            }
            }
            switch (field) {  
        }  
        private static class get_table_req_resultTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {  
        }
                    prot.decrementRecursionDepth();
                        unsetNew_part();
                            case 2: // O2
                prot.writeMessageEnd();
            return true;
            this.o1 = null;  
        public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
            org.apache.thrift.TBase<create_database_result, create_database_result._Fields>,
        }  
                    }
            return false;  
        );  
            scheme(oprot).write(oprot, this);  
                            default:
        private static final org.apache.thrift.protocol.TField O3_FIELD_DESC = new org.apache.thrift.protocol.TField(
            }
        public create_database_result setO3(@org.apache.thrift.annotation.Nullable MetaException o3) {
                org.apache.thrift.protocol.TProtocol prot = client.getProtocolFactory().getProtocol(memoryTransport);
            }
                if (struct.isSetO2()) {
            }
            sb.append("success:");  
            }
            checkReady();
                return false;
        private static class add_partition_argsStandardScheme extends org.apache.thrift.scheme.StandardScheme<add_partition_args> {  
                }
        public void clear() {
        public @org.apache.thrift.annotation.Nullable java.util.List<Partition> success; // required  
            }
                            default:
                return false;
            if (lastComparison != 0) {
            }
            }
        private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {  
        }
            }  
                }  
                                    org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        public java.util.List<Partition> recv_get_partitions_by_filter() throws MetaException, NoSuchObjectException,
            }
        }  
        }
                    java.util.BitSet incoming = iprot.readBitSet(3);
            if (!getClass().equals(other.getClass())) {  
        }
            }  
                        oprot.writeListEnd();
                oprot.writeStructBegin(STRUCT_DESC);  
        /** Returns true if field o3 is set (has been assigned a value) and false otherwise */  
        public void unsetSuccess() {
                        } else if (e instanceof NoSuchObjectException) {
             */
                    if (value == null) {  
        );
                    if (incoming.get(2)) {  
            if (other.isSetO1()) {
        public add_partition_args(Partition new_part) {
                    public void onError(java.lang.Exception e) {
        }
            if (!value) {
            @Override
                    iface.create_table(args.tbl);
        public Table getTbl() {
        }
                    return isSetO1();
            } catch (org.apache.thrift.TException te) {  
            @org.apache.thrift.annotation.Nullable  
            @org.apache.thrift.annotation.Nullable
                        struct.o1 = new InvalidObjectException();  
            @Override
                }
                }  
                    }
        @org.apache.thrift.annotation.Nullable
                        } catch (org.apache.thrift.transport.TTransportException e) {
            }  
            tmpMap.put(
                                }  
        /**
                        return O3;  
            "o1",
        @Override  
        }
            switch (field) {
        public void unsetDb_name() {  
                    return lastComparison;
            first = false;
                            fcall.sendResponse(fb, result, org.apache.thrift.protocol.TMessageType.REPLY, seqid);  
                                e.getMessage()  
                    new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, AlreadyExistsException.class)
            @Override  
                                    struct.o4.read(iprot);
            if (isSetO4()) {  
            }
                        }
                }
            metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);  
                        unsetO2();  
                                        struct.success = new java.util.ArrayList<Partition>(_list152.size);  
        @Override
            public add_partition_args getEmptyArgsInstance() {
                    new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, MetaException.class)  
            Comparable<get_partitions_result> {
            public static _Fields findByThriftId(int fieldId) {  
         */
                _fieldName = fieldName;
                    }
        @Override
        public static class create_table<I extends Iface> extends org.apache.thrift.ProcessFunction<  
        }
            java.lang.String filter,  
                case O3:
                    return lastComparison;
                    struct.new_part.write(oprot);
                new org.apache.thrift.meta_data.FieldMetaData(
            } catch (org.apache.thrift.TException te) {  
        private static final org.apache.thrift.protocol.TField DB_NAME_FIELD_DESC = new org.apache.thrift.protocol.TField(
            public add_partition_resultStandardScheme getScheme() {
        @Override
                sb.append(this.o1);
        }
                                }
            MAX_PARTS((short) 4, "max_parts");
                if (struct.o1 != null) {
                try {  
        }  
            org.apache.thrift.TBase<get_partitions_by_filter_args, get_partitions_by_filter_args._Fields>,
                if (struct.o2 != null) {
        private static class get_partitions_by_filter_resultStandardScheme extends org.apache.thrift.scheme.StandardScheme<  
        private static class get_table_req_resultStandardScheme extends org.apache.thrift.scheme.StandardScheme<get_table_req_result> {  
                    new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, NoSuchObjectException.class)
            if (that == null) return false;
        private static class create_database_resultTupleScheme extends org.apache.thrift.scheme.TupleScheme<create_database_result> {
                ? STANDARD_SCHEME_FACTORY
            if (result.o3 != null) {  
        }
            if (other.isSetO2()) {
        }
            }  
                _Fields.DATABASE,  
        public int compareTo(get_partitions_args other) {
                throw result.o2;  
        static {
                        }
                super("get_partitions_by_filter");
        }
                        } else {
        }
            if (that == null) return false;
                final int seqid  
            if (this_present_o1 || that_present_o1) {
                    oprot.writeFieldBegin(DATABASE_FIELD_DESC);  
                        } else if (e instanceof NoSuchObjectException) {
            }
            public boolean isOneway() {  
        }
                        unsetTbl();  
            java.lang.StringBuilder sb = new java.lang.StringBuilder("create_database_result(");  
            (short) 2
                    break;
                }
                }
        ) throws org.apache.thrift.TException {
        public void unsetO4() {  
                if (struct.isSetDatabase()) {  
         * Performs a deep copy on <i>other</i>.
                prot.writeMessageEnd();
            "success",  
        public @org.apache.thrift.annotation.Nullable InvalidObjectException o2; // required
            return this.o1 != null;
                    while (true) {
            this.success = success;
                if (!(this_present_o2 && that_present_o2)) return false;
                sb.append(this.o2);
            }
        public boolean equals(get_partitions_by_filter_result that) {
                    oprot.writeFieldBegin(O2_FIELD_DESC);
        }
            if (other.isSetO2()) {  
            return new get_partitions_by_filter_args(this);
                }
                } catch (NoSuchObjectException o2) {
            @Override
        // isset id assignments  
                                    struct.tbl_name = iprot.readString();
            } catch (org.apache.thrift.TException te) {  
                    }  
                if (struct.isSetO4()) {
                    if (incoming.get(2)) {
            metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);  
            if (!value) {  
            get_partitions_result> {
                    }
            public create_table_args getEmptyArgsInstance() {  
                    return getO1();
                    break;  
                _Fields.O2,  
        @org.apache.thrift.annotation.Nullable
            if (lastComparison != 0) {
                for (_Fields field : java.util.EnumSet.allOf(_Fields.class)) {  
                            case 1: // DB_NAME
        }
            protected boolean rethrowUnhandledExceptions() {
                    }  
            }  
                throws org.apache.thrift.TException {
            } catch (org.apache.thrift.TException te) {
            if (!getClass().equals(other.getClass())) {
            }
        /** Returns true if field max_parts is set (has been assigned a value) and false otherwise */  
            throw new java.lang.IllegalStateException();
                                    struct.success.read(iprot);
            /**
            @Override
                    }
        /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
        }
                struct.validate();
                                }
                throw new java.io.IOException(te);
         * Performs a deep copy on <i>other</i>.
                            default:
            O4((short) 4, "o4");  
            "o2",
        private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, java.lang.ClassNotFoundException {
                    org.apache.thrift.TFieldRequirementType.DEFAULT,  
                        }
                return _thriftId;
            }  
            boolean this_present_o2 = true && this.isSetO2();
            "create_database_result"
                _Fields.TBL_NAME,  
            lastComparison = java.lang.Boolean.compare(isSetO1(), other.isSetO1());
                            onError(e);
                            msgType = org.apache.thrift.protocol.TMessageType.EXCEPTION;
                throw new java.lang.IllegalArgumentException();  
                return lastComparison;  
            "o2",  
                if (lastComparison != 0) {
                case NEW_PART:  
                                        org.apache.thrift.protocol.TList _list152 = iprot.readListBegin();
            public get_partitions_by_filter_args getEmptyArgsInstance() {  
        public get_partitions_args setDb_name(@org.apache.thrift.annotation.Nullable java.lang.String db_name) {
        }  
        public @org.apache.thrift.annotation.Nullable MetaException o2; // required
        private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct(  
        private static final org.apache.thrift.protocol.TField REQ_FIELD_DESC = new org.apache.thrift.protocol.TField(  
            return this;
                throws org.apache.thrift.TException {
                if (struct.isSetO2()) {  
                if (!this.db_name.equals(that.db_name)) return false;
        }  
                throw new java.lang.IllegalArgumentException();
                    } else {
            }  
            short max_parts,
        }
            org.apache.thrift.protocol.TType.STRUCT,  
                        org.apache.thrift.protocol.TType.LIST,  
            if (this.success == null) {  
            }  
    @SuppressWarnings({ "cast", "rawtypes", "serial", "unchecked", "unused" })
        @org.apache.thrift.annotation.Nullable
                        ? extends org.apache.thrift.TBase,
            this.o3 = null;
            } catch (org.apache.thrift.TException te) {
         */
                if (fields == null) throw new java.lang.IllegalArgumentException("Field " + fieldId + " doesn't exist!");  
            @Override
                if (fields == null) throw new java.lang.IllegalArgumentException("Field " + fieldId + " doesn't exist!");
                    if (value == null) {  
            @Override
        public create_table_args(create_table_args other) {
                    "o1",
        }  
            }  
            if (tbl != null) {  
        private static class create_table_resultStandardScheme extends org.apache.thrift.scheme.StandardScheme<create_table_result> {
                                break;
                } catch (AlreadyExistsException o1) {
                    return isSetO2();  
            @Override
            if (result.isSetSuccess()) {  
                _Fields.O4,
                getProcessMap(  
            @Override  
            I,
            java.io.Serializable,
        static {
            @Override  
                if (struct.isSetDb_name()) {
                                    org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        }  
        private static class get_partitions_argsTupleScheme extends org.apache.thrift.scheme.TupleScheme<get_partitions_args> {
            public create_table_argsTupleScheme getScheme() {
        public boolean isSetO1() {
                                    struct.o1 = new MetaException();
                if (struct.isSetO1()) {
            return this.database != null;
                    public void onComplete(java.util.List<Partition> o) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder("create_table_result(");
            return this.o4;
            );
                } finally {
        }  
            public org.apache.thrift.async.AsyncMethodCallback<GetTableResult> getResultHandler(
                lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.o2, other.o2);
            this.req = req;  
                }
                            result.setO1IsSet(true);
                    case 4: // O4
            }
            }
                        struct.o2 = new MetaException();  
                oprot.writeFieldStop();
            boolean this_present_o2 = true && this.isSetO2();
            if (isSetO2()) {
                java.util.BitSet optionals = new java.util.BitSet();
                        }
            }
            );
        @org.apache.thrift.annotation.Nullable
                    oprot.writeFieldBegin(O1_FIELD_DESC);  
                }
        private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new get_table_req_argsTupleSchemeFactory();
        }
        private static final org.apache.thrift.protocol.TField DB_NAME_FIELD_DESC = new org.apache.thrift.protocol.TField(
                    while (true) {
                                    struct.o2 = new InvalidObjectException();  
            }
                if (lastComparison != 0) {
            @Override
        public boolean isSet(_Fields field) {
            throw new java.lang.IllegalStateException();
        @org.apache.thrift.annotation.Nullable  
            }
            int lastComparison = 0;
                    while (true) {
        }  
                        result.success = o;  
            boolean first = true;  
        public add_partition_result setO2(@org.apache.thrift.annotation.Nullable AlreadyExistsException o2) {
        );
        public boolean isSetO2() {  
                new org.apache.thrift.meta_data.FieldMetaData(  
            /**  
                for (_Fields field : java.util.EnumSet.allOf(_Fields.class)) {  
        /**
            tmpMap.put(
            }  
            }
            throw new java.lang.IllegalStateException();
                if (!this.o1.equals(that.o1)) return false;
            O2((short) 2, "o2"),  
                if (lastComparison != 0) {
                            );
                lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.o3, other.o3);
            return new create_table_args(this);
        private static class add_partition_resultStandardScheme extends org.apache.thrift.scheme.StandardScheme<add_partition_result> {  
            java.util.Map<
                throw result.o3;  
        private static <  
                return new create_database_resultTupleScheme();  
                return new get_table_req_argsStandardScheme();  
            if (lastComparison != 0) {
            @org.apache.thrift.annotation.Nullable  
        }  
            if (!getClass().equals(other.getClass())) {
        public int compareTo(get_partitions_result other) {
             */  
                        }  
        public static class get_partitions<I extends Iface> extends org.apache.thrift.ProcessFunction<  
            sb.append("o1:");
            if (!value) {  
        private static final org.apache.thrift.protocol.TField NEW_PART_FIELD_DESC = new org.apache.thrift.protocol.TField(
            processMap.put("get_table_req", new get_table_req());
                                    {
        @Override  
                    org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
        }
             * Find the _Fields constant that matches fieldId, or null if its not found.
                case O2:
            } catch (org.apache.thrift.TException te) {  
                if (struct.isSetSuccess()) {
            this.o2 = o2;
            if (other.isSetFilter()) {  
            sb.append("o1:");
                    oprot.writeFieldEnd();  
        public create_database_args(Database database) {
            if (isSetNew_part()) hashCode = hashCode * 8191 + new_part.hashCode();
            @Override
                                }  
            }
            this.o1 = o1;
            java.lang.String db_name,  
            return recv_get_partitions_by_filter();  
        /**
        @org.apache.thrift.annotation.Nullable  
            }  
        private static class create_database_argsStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
            tmpMap.put(
        }
            DATABASE((short) 1, "database");
            return sb.toString();
                        struct.o1 = new NoSuchObjectException();
                return fields;
        }
                        try {
                            msg = result;
            scheme(iprot).read(iprot, this);
            }
                            default:
                                    struct.setDatabaseIsSet(true);
                        }
            if (this == that) return true;
                            msg = (org.apache.thrift.TApplicationException) e;
        @Override
            }
                try {
            }  
        }  
                    }  
                        struct.setTblIsSet(true);
                                    struct.o3.read(iprot);
             * Find the _Fields constant that matches name, or null if its not found.
                    default:  
        }  
        private static final org.apache.thrift.protocol.TField O2_FIELD_DESC = new org.apache.thrift.protocol.TField(  
        public void clear() {  
                    case 1: // REQ
            return (this.success == null) ? null : this.success.iterator();
                getProcessMap(
        private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new add_partition_resultTupleSchemeFactory();
            return this;
                                    struct.o1 = new InvalidObjectException();
            }
                            result.setO1IsSet(true);
        @Override  
            hashCode = hashCode * 8191 + ((isSetDatabase()) ? 131071 : 524287);
        private static final org.apache.thrift.protocol.TField O2_FIELD_DESC = new org.apache.thrift.protocol.TField(  
            tmpMap.put(
                case O3:
                if (!(this_present_o1 && that_present_o1)) return false;  
                    oprot.writeString(struct.db_name);  
            add_partition_result> {
                        oprot.writeListBegin(
            tmpMap.put(  
                }
                    result.o2 = o2;  
            if (!first) sb.append(", ");
            int hashCode = 1;
            org.apache.thrift.TBase<create_table_args, create_table_args._Fields>,  
            @org.apache.thrift.annotation.Nullable  
    @SuppressWarnings({ "cast", "rawtypes", "serial", "unchecked", "unused" })  
        private static final org.apache.thrift.protocol.TField O2_FIELD_DESC = new org.apache.thrift.protocol.TField(  
        public void get_partitions_by_filter(  
        public boolean isSet(_Fields field) {
                throw new java.lang.IllegalArgumentException();  
             */
            /**  
                    @Override  
                    oprot.writeFieldEnd();
                            result.setO3IsSet(true);  
            switch (field) {  
            sb.append("max_parts:");  
                                }  
                case DB_NAME:  
                    }
            hashCode = hashCode * 8191 + ((isSetTbl_name()) ? 131071 : 524287);
                    optionals.set(0);
        public get_partitions_by_filter_args(get_partitions_by_filter_args other) {
                case SUCCESS:
                _Fields.O1,
                if (struct.isSetSuccess()) {  
                    optionals.set(2);  
        private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY =  
                    byName.put(field.getFieldName(), field);  
                }  
            public get_partitions_by_filter() {
            this.o1 = null;
                throw result.o4;
        public get_table_req_args deepCopy() {  
            I,
        }
        }
        }  
            O1((short) 1, "o1"),  
        private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
            if (isSetMax_parts()) {  
            }  
                if (!this.o1.equals(that.o1)) return false;
         * Performs a deep copy on <i>other</i>.
                                if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {  
        private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
            @Override
                            }
                sb.append(this.o2);
                            _LOGGER.error("TApplicationException inside handler", e);
                    oprot.writeI16(struct.max_parts);  
            public void write(org.apache.thrift.protocol.TProtocol oprot, get_table_req_result struct) throws org.apache.thrift.TException {
                    org.apache.thrift.TFieldRequirementType.DEFAULT,  
            org.apache.thrift.TException {  
                try {
        /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
            public get_partitions_by_filter_argsTupleScheme getScheme() {  
                        }
                            case 1: // TBL  
                        struct.o3 = new MetaException();
        public create_database_result setO2(@org.apache.thrift.annotation.Nullable InvalidObjectException o2) {
            org.apache.thrift.protocol.TType.STRUCT,
                oprot.writeFieldStop();
                args.write(prot);
                    optionals.set(2);  
            }
            hashCode = hashCode * 8191 + ((isSetSuccess()) ? 131071 : 524287);
    public static class Client extends org.apache.thrift.TServiceClient implements Iface {
            }
        /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
            }
                case SUCCESS:  
        public java.lang.Object getFieldValue(_Fields field) {
        public create_database_args deepCopy() {
            }
            return 0;  
                short max_parts,  
            this.o2 = null;  
            "max_parts",
                                    org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
                                    struct.setMax_partsIsSet(true);
                : TUPLE_SCHEME_FACTORY).getScheme();
        public Database getDatabase() {
            }  
            lastComparison = java.lang.Boolean.compare(isSetFilter(), other.isSetFilter());
                    result.o2 = o2;
            Cloneable,
                sb.append("null");
                    default:
        ) throws org.apache.thrift.TException;
                }
                final org.apache.thrift.AsyncProcessFunction fcall = this;
                        } else if (e instanceof org.apache.thrift.transport.TTransportException) {
                    iprot.readStructEnd();
                        struct.setReqIsSet(true);
        // isset id assignments  
            }
            switch (field) {  
        public boolean equals(java.lang.Object that) {  
            switch (field) {
        private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY =  
            }  
                                }
                        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) {
                _Fields,  
                    iprot.readStructEnd();
        }
        }
            (short) 1  
                        schemeField = iprot.readFieldBegin();
            public add_partition_argsTupleScheme getScheme() {
                org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;  
            if (!first) sb.append(", ");
            this.o2 = o2;  
        }
                this.db_name = null;
                if (!this.o2.equals(that.o2)) return false;  
                        struct.setO1IsSet(true);
                case O2:
        public boolean isSet(_Fields field) {
                }  
                    @Override
            this.tbl_name = null;  
        }
                        unsetMax_parts();  
            public get_partitions_resultStandardScheme getScheme() {
            }
                    default:
            return this;
                    java.lang.String,
                    new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)  
            }  
                                    struct.db_name = iprot.readString();  
                if (lastComparison != 0) {
            throws org.apache.thrift.TException;  
            _Fields(short thriftId, java.lang.String fieldName) {  
                return byName.get(name);  
        }
        }  
                prot.writeMessageBegin(
                                    struct.setO3IsSet(true);
    public static class create_table_args
            super(
            return this;
            public static _Fields findByThriftId(int fieldId) {
        ) {
            "new_part",  
                final org.apache.thrift.AsyncProcessFunction fcall = this;
                    return getO1();
            );
                                    struct.setO1IsSet(true);  
                if (struct.isSetO1()) {
            if (isSetReq()) hashCode = hashCode * 8191 + req.hashCode();
            @Override
                java.lang.String,
                return fields;  
                            msg = result;
        }
                    org.apache.thrift.TFieldRequirementType.DEFAULT,
                }
        @Override
                    if (value == null) {
    }  
                            new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, struct.success.size())  
                oprot.writeFieldStop();
                args.setTbl(tbl);
                                    struct.o2.read(iprot);
                    org.apache.thrift.protocol.TField schemeField;
                            case 3: // O3
                    oprot.writeFieldBegin(O3_FIELD_DESC);
                        I,  
            if (lastComparison != 0) {  
            this();  
                super("create_database");  
            throw new java.lang.IllegalStateException();
        public GetTableResult get_table_req(GetTableRequest req) throws MetaException, NoSuchObjectException, org.apache.thrift.TException {
        private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, java.lang.ClassNotFoundException {  
                return getClass().getName().compareTo(other.getClass().getName());
                return new get_partitions_result();  
                    result.success = iface.get_partitions(args.db_name, args.tbl_name, args.max_parts);
                            );
                if (struct.isSetSuccess()) {
            if (lastComparison != 0) {
                );
                                } else {
                } finally {
                new org.apache.thrift.meta_data.FieldMetaData(
            }
             * Find the _Fields constant that matches name, or null if its not found.
                case DB_NAME:
                iface.add_partition(args.new_part, resultHandler);  
            (short) 3  
            boolean that_present_o1 = true && that.isSetO1();
        }
            if (field == null) {
                }  
        @Override  
                        iprot.readFieldEnd();
                    org.apache.thrift.TFieldRequirementType.DEFAULT,
             */
        @Override
                if (struct.isSetO1()) {
                        create_database_result result = new create_database_result();  
            "db_name",
            return this;
            _Fields(short thriftId, java.lang.String fieldName) {
                oprot.writeFieldEnd();
                return lastComparison;
            if (this == that) return true;
            java.util.List<Partition>,
        public void setO3IsSet(boolean value) {
                    return getO3();
            /**
                    org.apache.thrift.TFieldRequirementType.DEFAULT,
                try {
            return sb.toString();
        private static final org.apache.thrift.protocol.TField O2_FIELD_DESC = new org.apache.thrift.protocol.TField(
        }
            }
                return lastComparison;
                    oprot.writeString(struct.tbl_name);  
        public void get_table_req(GetTableRequest req, org.apache.thrift.async.AsyncMethodCallback<GetTableResult> resultHandler)  
            first = false;
                    }
        }
        }
             * Find the _Fields constant that matches name, or null if its not found.
                this.o3 = new MetaException(other.o3);  
                            msg = result;
            if (isSetO1()) {
                sb.append("null");
            Partition,
                        iprot.readFieldEnd();
            private java.lang.String filter;
            }
        static {  
        }
            }  
        @org.apache.thrift.annotation.Nullable
            sb.append("o1:");
                oprot.writeStructBegin(STRUCT_DESC);
            }
        }  
                        try {
                }
                    org.apache.thrift.TFieldRequirementType.DEFAULT,
        public add_partition_result setSuccess(@org.apache.thrift.annotation.Nullable Partition success) {
                    return isSetO2();  
             */
        public get_table_req_args() {}
        public void unsetO1() {
            if (isSetO2()) {  
            java.io.Serializable,
            }
        public boolean isSet(_Fields field) {  
            }
            try {  
        @org.apache.thrift.annotation.Nullable
            private final short _thriftId;
            @Override
            sb.append("o2:");  
        /** Returns true if field o1 is set (has been assigned a value) and false otherwise */  
            }  
            boolean this_present_o4 = true && this.isSetO4();
        public get_table_req_args setReq(@org.apache.thrift.annotation.Nullable GetTableRequest req) {
                } finally {
                java.lang.String,  
             * Find the _Fields constant that matches fieldId, or null if its not found.
                        setO1((AlreadyExistsException) value);
         */
                        return null;
                if (fields == null) throw new java.lang.IllegalArgumentException("Field " + fieldId + " doesn't exist!");  
                : TUPLE_SCHEME_FACTORY).getScheme();
        public @org.apache.thrift.annotation.Nullable NoSuchObjectException o1; // required
                                    struct.o3 = new MetaException();
                case FILTER:
                        }
                return _thriftId;
        @Override
            hashCode = hashCode * 8191 + ((isSetSuccess()) ? 131071 : 524287);
            @Override
        }
        private static <
                    struct.validate();
                                if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {  
                            result.o1 = (MetaException) e;
            (short) 2  
                return new get_partitions_by_filter_argsTupleScheme();
                        struct.o1 = new AlreadyExistsException();  
            /**  
            if (!first) sb.append(", ");
        public add_partition_args() {}  
            org.apache.thrift.protocol.TProtocolFactory protocolFactory,
                                }
        }
                                break;  
                    }  
                lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.max_parts, other.max_parts);  
                                    struct.o2 = new InvalidObjectException();  
                case O2:
            java.io.Serializable,
        private static final org.apache.thrift.protocol.TField O2_FIELD_DESC = new org.apache.thrift.protocol.TField(
            if (isSetSuccess()) {
            java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<  
                if (struct.isSetO1()) {
                    case 2: // O2  
    }
                            fb.close();
                sb.append("null");
        public void clear() {
                // it doesn't seem like you should have to do this, but java serialization is wacky, and doesn't call the default
            java.util.List<Partition>,  
            if (!value) {
                                    org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
                case MAX_PARTS:
            (short) 3
            return this;
                )  
            if (result.o1 != null) {  
        public get_partitions_args(java.lang.String db_name, java.lang.String tbl_name, short max_parts) {  
                this.o2 = null;
            first = false;
        }  
                return false;
            org.apache.thrift.TException {
                case O3:
            REQ((short) 1, "req");
                            result.o3 = (MetaException) e;
                    struct.o4.write(oprot);
                                break;
                        struct.max_parts = iprot.readI16();
            }
                            default:
                    return getO2();
                if (!(this_present_tbl_name && that_present_tbl_name)) return false;
    public static class get_partitions_by_filter_args  
        @org.apache.thrift.annotation.Nullable  
            }
            int hashCode = 1;
                    prot.decrementRecursionDepth();  
            @Override
                    } else {
                }  
                )
        }
                        struct.o1.read(iprot);
                    oprot.writeFieldEnd();
            return recv_get_partitions();
            }
        /** Returns true if field tbl is set (has been assigned a value) and false otherwise */
                _thriftId = thriftId;  
            if (this_present_success || that_present_success) {
        public void setO2IsSet(boolean value) {  
                    }  
            switch (field) {  
        private static final org.apache.thrift.protocol.TField O1_FIELD_DESC = new org.apache.thrift.protocol.TField(
        private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new get_partitions_argsTupleSchemeFactory();
                    oprot.writeFieldEnd();
                sb.append("null");  
                            msg = result;  
            (short) 1  
                read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
            public void read(org.apache.thrift.protocol.TProtocol iprot, get_partitions_result struct) throws org.apache.thrift.TException {  
                return fields;
                try {
            if (isSetO1()) hashCode = hashCode * 8191 + o1.hashCode();
        @Override  
                ___protocolFactory,  
            boolean this_present_db_name = true && this.isSetDb_name();
                                } else {
            this.success.add(elem);  
                _fieldName = fieldName;
                case MAX_PARTS:
            @Override
                            result.setO4IsSet(true);  
                _Fields.NEW_PART,
                this.database = null;
                        struct.o2.read(iprot);
                }
                _Fields fields = findByThriftId(fieldId);
        public void addToSuccess(Partition elem) {
            return this.success != null;
            metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);  
                org.apache.thrift.protocol.TProtocolFactory protocolFactory,
                    oprot.writeFieldEnd();
        }
                    return getO2();
         * Performs a deep copy on <i>other</i>.
                create_database_result result = getEmptyResultInstance();
            }
                if (!this.o1.equals(that.o1)) return false;
            return hashCode;  
        /**
                            default:  
            Comparable<create_database_result> {
                _Fields.O1,  
        public _Fields fieldForId(int fieldId) {
            @Override  
                                }  
        public void setFieldValue(_Fields field, @org.apache.thrift.annotation.Nullable java.lang.Object value) {
            }
            public short getThriftFieldId() {
        @Override  
            }  
        public int compareTo(add_partition_args other) {
                            _LOGGER.error("TTransportException inside handler", e);  
            @Override  
        public get_partitions_by_filter_args setDb_name(@org.apache.thrift.annotation.Nullable java.lang.String db_name) {
            throws org.apache.thrift.TException {  
                    oprot.writeFieldEnd();
            }
            sendBase("get_partitions", args);
            public void write(org.apache.thrift.protocol.TProtocol prot, add_partition_args struct) throws org.apache.thrift.TException {  
        public void get_table_req(GetTableRequest req, org.apache.thrift.async.AsyncMethodCallback<GetTableResult> resultHandler)
        }  
            return this.o2;
        @Override
            send_create_table(tbl);
            public static _Fields findByThriftIdOrThrow(int fieldId) {
            if (!getClass().equals(other.getClass())) {  
            } else {
                    }  
                args.setDb_name(db_name);  
            } else {
            this.max_parts = max_parts;
                new org.apache.thrift.meta_data.FieldMetaData(  
            } catch (org.apache.thrift.TException te) {  
                write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
 *
                    prot.decrementRecursionDepth();
        public void unsetO1() {
                if (lastComparison != 0) {
            public java.lang.String getFieldName() {
        }  
                        setO2((MetaException) value);
        /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
            return this;
            I,
            public static _Fields findByThriftId(int fieldId) {  
        }
        }
                _Fields fields = findByThriftId(fieldId);
            }
                    return lastComparison;
                    } else {  
                            return;  
        private static final int __MAX_PARTS_ISSET_ID = 0;
             * if it is not found.
        }
             */
                    }
        public NoSuchObjectException getO2() {  
            @Override
                return new create_table_result();
                        setNew_part((Partition) value);
        public void setO4IsSet(boolean value) {  
             * if it is not found.
        );
                    struct.tbl.write(oprot);  
            return this;  
                return lastComparison;  
            @Override
                    @Override
                                }  
                            msg = result;  
            try {
                if (!(this_present_o1 && that_present_o1)) return false;
            } catch (org.apache.thrift.TException te) {
             * Find the _Fields constant that matches fieldId, throwing an exception  
                            fb.close();  
            }
            return this.o1 != null;  
            }
        ) throws org.apache.thrift.TException {  
                return new create_database_argsTupleScheme();
                super("get_partitions_by_filter");  
            this.db_name = db_name;
            boolean this_present_success = true && this.isSetSuccess();  
            /**
            boolean this_present_o2 = true && this.isSetO2();
                            _LOGGER.error("TApplicationException inside handler", e);
                tbl_name,
         */  
            private final java.lang.String _fieldName;  
            private static final java.util.Map<java.lang.String, _Fields> byName = new java.util.HashMap<java.lang.String, _Fields>();
                sb.append(this.o3);
            receiveBase(result, "create_database");
            public get_partitions_args getEmptyArgsInstance() {  
                            msg = result;
            public void write(org.apache.thrift.protocol.TProtocol oprot, create_table_result struct) throws org.apache.thrift.TException {
            public java.lang.String getFieldName() {  
                };
        }  
        );
                return new get_partitions_args();
            @Override
                this.tbl_name = other.tbl_name;
                                break;
            get_table_req_result> {  
        @Override
                    iprot.readStructBegin();
            O3((short) 3, "o3"),
                if (getState() != org.apache.thrift.async.TAsyncMethodCall.State.RESPONSE_READ) {
                iprot.incrementRecursionDepth();
                return new get_table_req_result();
                        return TBL_NAME;
                    result.success = iface.get_partitions_by_filter(args.db_name, args.tbl_name, args.filter, args.max_parts);  
                        return null;
            boolean first = true;
                            result.setO2IsSet(true);  
                    } else {
                        schemeField = iprot.readFieldBegin();
        public void setO3IsSet(boolean value) {
                args.write(prot);
            hashCode = hashCode * 8191 + ((isSetO3()) ? 131071 : 524287);
            switch (field) {
        @Override  
                return lastComparison;
        /** Returns true if field o2 is set (has been assigned a value) and false otherwise */
                }
            super(prot, prot);
                    new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, MetaException.class)  
            public void write(org.apache.thrift.protocol.TProtocol oprot, add_partition_result struct) throws org.apache.thrift.TException {
        private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, java.lang.ClassNotFoundException {  
                    return lastComparison;
                _Fields fields = findByThriftId(fieldId);
            throw new java.lang.IllegalStateException();
        @org.apache.thrift.annotation.Nullable
        @org.apache.thrift.annotation.Nullable  
                                    struct.setTblIsSet(true);
            try {  
                    oprot.writeFieldBegin(SUCCESS_FIELD_DESC);
            java.lang.String filter,
                        struct.max_parts = iprot.readI16();  
                }
    }
                org.apache.thrift.protocol.TProtocolFactory protocolFactory,  
                    getFrameBuffer().array()
                                        @org.apache.thrift.annotation.Nullable  
                super(client, protocolFactory, transport, resultHandler, false);
            java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<  
        @Override
                        setO2((NoSuchObjectException) value);
        }
            @org.apache.thrift.annotation.Nullable
                return new get_partitions_resultTupleScheme();
                oprot.writeBitSet(optionals, 3);
        private static class create_table_argsTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {  
                    if (value == null) {
            "create_database_args"  
            metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);  
            if (other.isSetO1()) {
            this.tbl = null;
    }  
                iprot.incrementRecursionDepth();
                final org.apache.thrift.server.AbstractNonblockingServer.AsyncFrameBuffer fb,
                throw result.o1;
                org.apache.thrift.async.AsyncMethodCallback<Void> resultHandler,
                        iprot.readFieldEnd();  
            }
            hashCode = hashCode * 8191 + ((isSetTbl_name()) ? 131071 : 524287);
            if (req != null) {  
            try {
            @org.apache.thrift.annotation.Nullable
            java.lang.StringBuilder sb = new java.lang.StringBuilder("get_partitions_args(");
            } else {
                return false;  
        private static class create_database_resultStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {  
             * Find the _Fields constant that matches fieldId, throwing an exception  
                _Fields.SUCCESS,
                            msg = result;
                if (!(this_present_o1 && that_present_o1)) return false;
            }
            this.o3 = o3;
                new org.apache.thrift.meta_data.FieldMetaData(
                oprot.writeBitSet(optionals, 1);
            org.apache.thrift.TBase<get_partitions_result, get_partitions_result._Fields>,
            I,
        public void setMax_partsIsSet(boolean value) {
            @Override
                case O3:  
        }
                        struct.db_name = iprot.readString();  
            org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(get_partitions_result.class, metaDataMap);
                    oprot.writeFieldBegin(TBL_NAME_FIELD_DESC);
                java.util.BitSet optionals = new java.util.BitSet();
                return _thriftId;  
            if (that == null) return false;  
                java.util.BitSet optionals = new java.util.BitSet();  
                switch (fieldId) {
            @Override
                if (getState() != org.apache.thrift.async.TAsyncMethodCall.State.RESPONSE_READ) {
                try {  
                                if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {
                                _elem158 = new Partition();
                oprot.writeFieldStop();  
                    org.apache.thrift.TFieldRequirementType.DEFAULT,  
            tmpMap.put(  
                }  
        public enum _Fields implements org.apache.thrift.TFieldIdEnum {  
            }
        }
                return lastComparison;
            }
            }  
            O1((short) 1, "o1"),
            sb.append(")");  
            if (this.o1 == null) {
        }  
                oprot.writeStructBegin(STRUCT_DESC);  
                if (struct.isSetMax_parts()) {
                prot.incrementRecursionDepth();
            }  
                    }
                            msgType = org.apache.thrift.protocol.TMessageType.EXCEPTION;
                        unsetDb_name();  
                            case 2: // O2
        }
                return new add_partition_result();
                if (struct.isSetO2()) {
            O2((short) 2, "o2");
                throws org.apache.thrift.TException {  
                        }  
                sb.append(this.tbl_name);  
            return _Fields.findByThriftId(fieldId);  
                if (struct.isSetTbl_name()) {
                        struct.setO1IsSet(true);
            this.tbl = null;  
            @Override
            @org.apache.thrift.annotation.Nullable  
            try {
                            msg = (org.apache.thrift.TApplicationException) e;  
                    // check for required fields of primitive type, which can't be checked in the validate method
            }
                    public void onComplete(java.util.List<Partition> o) {  
                }  
                                if (schemeField.type == org.apache.thrift.protocol.TType.LIST) {  
                        } else {  
                : TUPLE_SCHEME_FACTORY).getScheme();
            }
            }  
            }  
            get_partitions_by_filter_result> {
            if (that instanceof get_partitions_result) return this.equals((get_partitions_result) that);
                        struct.tbl.read(iprot);  
                            fb.close();  
            return false;
            this.success = null;  
             * if it is not found.  
            sb.append("o1:");
            }
        }  
                return fields;
                this.o3 = null;  
            if (lastComparison != 0) {  
            short max_parts
        private static final org.apache.thrift.protocol.TField FILTER_FIELD_DESC = new org.apache.thrift.protocol.TField(
                    byName.put(field.getFieldName(), field);  
        public void unsetMax_parts() {
        }
            }  
            }
                    "database",
                    iprot.decrementRecursionDepth();
            public Partition getResult() throws InvalidObjectException, AlreadyExistsException, MetaException,  
            switch (field) {
        @Override
         * Performs a deep copy on <i>other</i>.  
            this.success = success;  
                                break;
            hashCode = hashCode * 8191 + ((isSetO3()) ? 131071 : 524287);  
            public void read(org.apache.thrift.protocol.TProtocol prot, add_partition_args struct) throws org.apache.thrift.TException {
            }
            }  
                case DATABASE:
            if (isSetTbl_name()) {
            _Fields(short thriftId, java.lang.String fieldName) {  
                    iprot.readStructEnd();
                org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
            } catch (org.apache.thrift.TException te) {
                _Fields.O2,
        }
        }
            }  
                        setO1((AlreadyExistsException) value);
        private static final org.slf4j.Logger _LOGGER = org.slf4j.LoggerFactory.getLogger(AsyncProcessor.class.getName());  
                }
        private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {  
            I extends Iface>  
        private static class get_partitions_argsStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
            if (other.isSetO4()) {
            throw new java.lang.IllegalStateException();
                )
            public add_partition_call(
            }
                return byName.get(name);  
                sb.append(this.o4);  
            if (!getClass().equals(other.getClass())) {  
            }
                            case 1: // O1
                                    struct.setO3IsSet(true);  
                                    org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            return this.success;
                        unsetO1();
        @Override  
            java.lang.StringBuilder sb = new java.lang.StringBuilder("create_table_args(");
                    return isSetSuccess();
        }
            return true;  
                    return lastComparison;
            } else {  
        public void unsetO1() {  
            private static final java.util.Map<java.lang.String, _Fields> byName = new java.util.HashMap<java.lang.String, _Fields>();  
        /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
                }
                oprot.writeI16(struct.max_parts);
            java.lang.String filter,  
                case O2:
        public void clear() {
             * Find the _Fields constant that matches name, or null if its not found.
                    new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I16)  
            @Override  
                    }
                            result.setO1IsSet(true);
                            fb.close();
            if (this.o2 == null) {
                        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) {
                            _LOGGER.error("Exception writing to internal frame buffer", ex);  
                        new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, Partition.class)
                        switch (schemeField.id) {
            }
                        }
                            result.setO3IsSet(true);
            );  
            lastComparison = java.lang.Boolean.compare(isSetO3(), other.isSetO3());  
            lastComparison = java.lang.Boolean.compare(isSetO1(), other.isSetO1());
                // it doesn't seem like you should have to do this, but java serialization is wacky, and doesn't call the default
        }  
                    case 2: // O2
            org.apache.thrift.TException {  
            @Override
            public void read(org.apache.thrift.protocol.TProtocol iprot, add_partition_result struct) throws org.apache.thrift.TException {  
                lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.tbl_name, other.tbl_name);
            private final short _thriftId;  
                    oprot.writeFieldBegin(O3_FIELD_DESC);
                case TBL:
                }
            org.apache.thrift.TBase<get_table_req_args, get_table_req_args._Fields>,  
            public void read(org.apache.thrift.protocol.TProtocol iprot, get_partitions_by_filter_args struct)  
            _Fields(short thriftId, java.lang.String fieldName) {
                    iprot.readStructEnd();
        public boolean equals(java.lang.Object that) {
        private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {  
            if (!value) {
        // isset id assignments  
            public get_partitions_args getEmptyArgsInstance() {
            }
        }  
                for (_Fields field : java.util.EnumSet.allOf(_Fields.class)) {
            return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme())
                    return isSetTbl_name();
                    new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, GetTableRequest.class)  
                        return SUCCESS;  
            return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme())
            }  
        @Override  
                this.req = new GetTableRequest(other.req);
                    {
        @Override  
            sb.append("tbl_name:");
            }
            /**  
            return 0;
        @Override
            }
        }  
                org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
        public void send_get_partitions(java.lang.String db_name, java.lang.String tbl_name, short max_parts)
                sb.append(this.o1);  
            @Override
        public get_partitions_result deepCopy() {  
        @Override
            }
        public create_database_args(create_database_args other) {  
        }
                    break;
            }  
            @Override  
                }
                        } else if (e instanceof org.apache.thrift.transport.TTransportException) {  
                        } catch (org.apache.thrift.transport.TTransportException e) {  
            this.o1 = null;  
                oprot.writeStructEnd();
                java.util.BitSet optionals = new java.util.BitSet();  
            create_database_args,
            public add_partition_result getResult(I iface, add_partition_args args) throws org.apache.thrift.TException {  
                        } else if (e instanceof MetaException) {
                            fb.close();
            public get_partitions_by_filter_result getEmptyResultInstance() {  
                throw result.o3;
                return _fieldName;
            if (this_present_o1 || that_present_o1) {  
            if (lastComparison != 0) {  
            }  
                    return getSuccess();
        public java.lang.String getFilter() {
        }
                return getClass().getName().compareTo(other.getClass().getName());
        @org.apache.thrift.annotation.Nullable  
                                if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {
                    return isSetO2();  
            @Override
                    case 2: // O2  
            return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme())
                        return null;
            }
        public java.lang.String toString() {
            if (!getClass().equals(other.getClass())) {
            }
            }
                oprot.writeStructEnd();
                        new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, Partition.class)
        public static class add_partition<I extends Iface> extends org.apache.thrift.ProcessFunction<
            this.o2 = o2;
                    oprot.writeFieldEnd();
            if (field == null) {  
                }  
                    "success",  
            }
                ___transport
            public java.lang.String getFieldName() {  
                    org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;  
            }
            private final short _thriftId;
            public boolean isOneway() {
        public boolean equals(java.lang.Object that) {
            @Override
                    break;  
        public get_partitions_args setMax_parts(short max_parts) {
            this.success = null;  
    public static class Processor<I extends Iface> extends org.apache.thrift.TBaseProcessor<I> implements org.apache.thrift.TProcessor {  
        private static class get_partitions_resultTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
        }
        }
            if (result.isSetSuccess()) {  
                success.validate();  
        public java.lang.String toString() {
        public void clear() {
                return _fieldName;
            public boolean isOneway() {
            }
            throw new java.lang.IllegalStateException();  
            }  
                this.database = new Database(other.database);
                sb.append("null");  
            public boolean isOneway() {
                        setO3((MetaException) value);
            @Override  
                    new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, MetaException.class)  
                    struct.o2.write(oprot);  
            @org.apache.thrift.annotation.Nullable
        @Override
        public boolean isSetFilter() {
            return new create_database_args(this);
        public _Fields fieldForId(int fieldId) {
            }  
                    }
                return result;
                oprot.writeStructBegin(STRUCT_DESC);
                switch (fieldId) {  
        public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
        }
            throws org.apache.thrift.TException {
                if (struct.db_name != null) {
            scheme(oprot).write(oprot, this);  
    public static class create_database_args
        public @org.apache.thrift.annotation.Nullable InvalidObjectException o1; // required
        }
        public void unsetDb_name() {  
        }
            }  
        private static final org.apache.thrift.protocol.TField MAX_PARTS_FIELD_DESC = new org.apache.thrift.protocol.TField(  
            return 0;
                    return lastComparison;  
            }  
            }
                    return isSetNew_part();
            boolean that_present_tbl_name = true && that.isSetTbl_name();
            hashCode = hashCode * 8191 + ((isSetO1()) ? 131071 : 524287);
                return result;
            public get_table_req_argsTupleScheme getScheme() {
                for (_Fields field : java.util.EnumSet.allOf(_Fields.class)) {
            }
            sendBase("get_partitions_by_filter", args);
        }
            );
            return this;
            }  
                } finally {
            if (this == that) return true;
            if (result.o2 != null) {
                                }
            new get_partitions_by_filter_resultTupleSchemeFactory();
                try {
                            msg = result;
            }
        }  
            public get_partitions() {  
                    struct.o1.write(oprot);
        }  
            /**  
                    oprot.writeFieldBegin(O2_FIELD_DESC);
                    oprot.writeFieldBegin(O3_FIELD_DESC);
            }
         * Performs a deep copy on <i>other</i>.
            if (!first) sb.append(", ");
            return hashCode;
            public create_table_resultStandardScheme getScheme() {  
            return hashCode;
            this.o2 = o2;
                    } else {
            try {
                        org.apache.thrift.TSerializable msg;
            return this.success != null;
                        byte msgType = org.apache.thrift.protocol.TMessageType.REPLY;
        public int hashCode() {
                    oprot.writeString(struct.db_name);  
            }
        private static class create_table_resultTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
                _thriftId = thriftId;
                throw new java.io.IOException(te);
        public void setFilterIsSet(boolean value) {
                        return null;
                        setO2((NoSuchObjectException) value);
        }
            switch (field) {  
                    struct.validate();
                if (lastComparison != 0) {
            switch (field) {
            public void start(I iface, add_partition_args args, org.apache.thrift.async.AsyncMethodCallback<Partition> resultHandler)
                            _LOGGER.error("Exception inside handler", e);
            if (new_part != null) {
                            fb.close();
                    return getO2();
                sb.append("null");
                    optionals.set(1);
                            default:
                        return MAX_PARTS;  
                    }
                        } catch (java.lang.Exception e) {  
                        unsetO2();  
                                    struct.o2 = new NoSuchObjectException();
                            msg = new org.apache.thrift.TApplicationException(
        private static class get_partitions_by_filter_resultStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
            return hashCode;  
            /**  
                        }  
                _Fields.O3,
            }
                    }
        /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
                    return lastComparison;
        @Override
                        org.apache.thrift.TSerializable msg;  
            first = false;
            boolean that_present_o1 = true && that.isSetO1();
                    return lastComparison;  
            }
                    case 0: // SUCCESS
                return new create_table_argsTupleScheme();  
        }
        }
                        } else if (e instanceof MetaException) {  
                                            _elem153.read(iprot);
                org.apache.thrift.async.AsyncMethodCallback<java.util.List<Partition>> resultHandler  
                        } else {
        private byte __isset_bitfield = 0;  
        }
            this.___currentMethod = method_call;
                    } else {
        @org.apache.thrift.annotation.Nullable  
            /**
            return;
                    if (value == null) {  
            this.tbl_name = tbl_name;  
        }  
                prot.writeMessageEnd();
                } finally {  
        private static class get_table_req_argsTupleScheme extends org.apache.thrift.scheme.TupleScheme<get_table_req_args> {
                    struct.o4.write(oprot);
                        struct.o3 = new MetaException();
                org.apache.thrift.transport.TMemoryInputTransport memoryTransport = new org.apache.thrift.transport.TMemoryInputTransport(
                }
            @Override  
        }  
                    }
            scheme(oprot).write(oprot, this);
        }
            public Client getClient(org.apache.thrift.protocol.TProtocol prot) {  
            @Override  
            get_partitions_by_filter_args args = new get_partitions_by_filter_args();  
                GetTableRequest req,  
            int lastComparison = 0;  
            }
        public get_table_req_result(GetTableResult success, MetaException o1, NoSuchObjectException o2) {
        }
            O1((short) 1, "o1"),  
                get_partitions_result result = getEmptyResultInstance();  
                    new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, InvalidObjectException.class)
        ) {
                    getFrameBuffer().array()
            new get_partitions_by_filter_argsStandardSchemeFactory();
                        unsetSuccess();
            Cloneable,  
            new create_database_argsStandardSchemeFactory();
        private static class create_table_argsStandardScheme extends org.apache.thrift.scheme.StandardScheme<create_table_args> {
                    } else {
            public static _Fields findByThriftId(int fieldId) {  
                switch (fieldId) {
                }
            } catch (org.apache.thrift.TException te) {
        @Override  
        }  
            }
        }  
                        }
        public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
                    "max_parts",  
            return this;
        }
                }
                    if (value == null) {
                _Fields fields = findByThriftId(fieldId);
                }
                new org.apache.thrift.meta_data.FieldMetaData(
            @Override
            get_partitions_by_filter_args> {  
                oprot.writeStructEnd();  
        }
            private final java.lang.String _fieldName;  
                }
            processMap.put("get_partitions_by_filter", new get_partitions_by_filter());
                            result.o1 = (AlreadyExistsException) e;  
            }
            return sb.toString();  
                _thriftId = thriftId;
            lastComparison = java.lang.Boolean.compare(isSetReq(), other.isSetReq());  
                throws org.apache.thrift.TException {  
            if (that instanceof get_partitions_args) return this.equals((get_partitions_args) that);
                        try {  
        public create_table_args(Table tbl) {  
        private static class get_partitions_by_filter_argsTupleScheme extends org.apache.thrift.scheme.TupleScheme<
                                org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        public get_partitions_by_filter_args setTbl_name(@org.apache.thrift.annotation.Nullable java.lang.String tbl_name) {
        }
                                    struct.o1.read(iprot);
            }
        @Override
            @Override
        public create_table_result() {}  
            }  
            }  
                                        }  
                case O2:
            first = false;  
                if (!this.req.equals(that.req)) return false;  
            first = false;  
            org.apache.thrift.protocol.TType.STRUCT,
                        struct.setDb_nameIsSet(true);  
                new org.apache.thrift.meta_data.FieldMetaData(
    public static class add_partition_result
                }
            return this.o3;  
                                struct.success.add(_elem166);  
                    oprot.writeFieldBegin(O4_FIELD_DESC);  
        public int hashCode() {
            org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(get_table_req_args.class, metaDataMap);
                        } catch (java.lang.Exception e) {  
                                org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            DB_NAME((short) 1, "db_name"),
             */  
                    return isSetFilter();  
            create_database_args args = new create_database_args();
        private static final org.apache.thrift.protocol.TField O1_FIELD_DESC = new org.apache.thrift.protocol.TField(
                    } else {
            throw new java.lang.IllegalStateException();
            public void read(org.apache.thrift.protocol.TProtocol iprot, get_table_req_args struct) throws org.apache.thrift.TException {
                sb.append(this.db_name);
        }  
        public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
            try {  
        }  
        );  
        public void setSuccessIsSet(boolean value) {
            hashCode = hashCode * 8191 + ((isSetO1()) ? 131071 : 524287);
                                if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {
        /** Returns true if field o2 is set (has been assigned a value) and false otherwise */
            "o1",
            }  
                lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.o1, other.o1);
        }
                                struct.success.add(_elem158);
                                    org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);  
                case O2:
        @Override  
            this.o3 = null;  
                    optionals.set(0);
                }  
        );
                this.success = new java.util.ArrayList<Partition>();
                            msg = new org.apache.thrift.TApplicationException(
        private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new create_database_argsTupleSchemeFactory();
                    }
            new get_partitions_argsStandardSchemeFactory();
                    "o3",
            @Override
                        switch (schemeField.id) {
            }
            }
        }
             * Find the _Fields constant that matches name, or null if its not found.
                    case 1: // NEW_PART
            if (that == null) return false;
            args.setReq(req);
        }
             * Find the _Fields constant that matches fieldId, or null if its not found.
        }  
                    org.apache.thrift.TFieldRequirementType.DEFAULT,
        }
                args.setDatabase(database);
            public static _Fields findByThriftId(int fieldId) {
                if (struct.new_part != null) {  
            if (lastComparison != 0) {
            public static _Fields findByName(java.lang.String name) {
        }
            if (that == null) return false;  
        private static class get_partitions_resultTupleScheme extends org.apache.thrift.scheme.TupleScheme<get_partitions_result> {
        private static class get_partitions_resultStandardScheme extends org.apache.thrift.scheme.StandardScheme<get_partitions_result> {  
                this.o2 = null;
            }
            this.o2 = null;
            Comparable<get_table_req_args> {  
                if (struct.isSetMax_parts()) {
                lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.success, other.success);
    @SuppressWarnings({ "cast", "rawtypes", "serial", "unchecked", "unused" })
                if (!(this_present_tbl && that_present_tbl)) return false;
            }
                ? STANDARD_SCHEME_FACTORY
            ) {
            } catch (org.apache.thrift.TException te) {
                        }  
        public static class add_partition<I extends AsyncIface> extends org.apache.thrift.AsyncProcessFunction<
                                } else {
                    org.apache.thrift.protocol.TField schemeField;
            if (!first) sb.append(", ");  
                if (lastComparison != 0) {  
                lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.o2, other.o2);
                            for (int _i159 = 0; _i159 < _list157.size; ++_i159) {
        @Override
            }
        @org.apache.thrift.annotation.Nullable  
                this.o1 = new AlreadyExistsException(other.o1);  
            );  
            return this.o2 != null;  
        public void create_database(Database database) throws AlreadyExistsException, InvalidObjectException, MetaException,
         * Performs a deep copy on <i>other</i>.  
            switch (field) {
        // isset id assignments
                oprot.writeFieldBegin(MAX_PARTS_FIELD_DESC);  
            send_get_partitions(db_name, tbl_name, max_parts);  
            }
            hashCode = hashCode * 8191 + ((isSetO1()) ? 131071 : 524287);
        }
                        oprot.writeI32(struct.success.size());
            @Override
    }
        public java.lang.String getTbl_name() {
                            result.setO2IsSet(true);
                    "o1",  
                    java.lang.String,  
            throws org.apache.thrift.TException;  
        /** Returns true if field new_part is set (has been assigned a value) and false otherwise */
            if (other.isSetTbl_name()) {
        public boolean isSet(_Fields field) {
        public get_partitions_by_filter_result setSuccess(@org.apache.thrift.annotation.Nullable java.util.List<Partition> success) {
                java.util.Map<  
                                    org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);  
        );
            /**
                        for (Partition _iter155 : struct.success) {
            @Override
            short max_parts  
            public static _Fields findByThriftIdOrThrow(int fieldId) {
                        setTbl((Table) value);
        public void validate() throws org.apache.thrift.TException {
                this.clientManager = clientManager;
        public get_partitions_by_filter_result(get_partitions_by_filter_result other) {
            if (that == null) return false;  
                case O2:
                    oprot.writeFieldEnd();
                            org.apache.thrift.protocol.TList _list157 = iprot.readListBegin(org.apache.thrift.protocol.TType.STRUCT);  
                    if (incoming.get(2)) {
            if (!value) {
            }  
            "success",
        }
                throw new java.io.IOException(te);  
    @SuppressWarnings({ "cast", "rawtypes", "serial", "unchecked", "unused" })  
                    struct.o3.write(oprot);
                }
            if (this_present_new_part || that_present_new_part) {  
            }
                        setO2((AlreadyExistsException) value);  
            }
                if (struct.isSetO2()) {  
                iprot.incrementRecursionDepth();
        public add_partition_result setO3(@org.apache.thrift.annotation.Nullable MetaException o3) {
                                    org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
                            onError(e);
                new org.apache.thrift.meta_data.FieldMetaData(
            }
                    prot.decrementRecursionDepth();
            boolean that_present_o2 = true && that.isSetO2();  
                return new get_table_req_result();
                        struct.o1.read(iprot);
            @org.apache.thrift.annotation.Nullable
            first = false;  
             * Find the _Fields constant that matches fieldId, or null if its not found.  
            org.apache.thrift.protocol.TType.STRING,
                if (struct.isSetO2()) {
            this.success.add(elem);  
            }  
                if (!(this_present_o3 && that_present_o3)) return false;  
        public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
            return (this.success == null) ? null : this.success.iterator();
            public short getThriftFieldId() {  
            lastComparison = java.lang.Boolean.compare(isSetDb_name(), other.isSetDb_name());
            }
        }
                            fcall.sendResponse(fb, msg, msgType, seqid);  
        }
            @Override
                        } catch (org.apache.thrift.transport.TTransportException e) {
                )  
             */
                }  
        public boolean isSet(_Fields field) {
            boolean that_present_success = true && that.isSetSuccess();
            return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme())
            if (this.success == null) {  
                }
                        );
                case O1:
            if (this_present_o2 || that_present_o2) {
                    oprot.writeFieldBegin(O2_FIELD_DESC);  
            if (!value) {  
                ? STANDARD_SCHEME_FACTORY
            return new create_table_result(this);  
                                } else {  
            public create_database() {
            @Override
            }
            public get_partitions_by_filter_args getEmptyArgsInstance() {  
                sb.append(this.database);  
            @org.apache.thrift.annotation.Nullable
        }
                                    struct.o3.read(iprot);
            }
    public static class AsyncProcessor<I extends AsyncIface> extends org.apache.thrift.TBaseAsyncProcessor<I> {
            SUCCESS((short) 0, "success"),
                oprot.writeFieldStop();
        }
            if (this == that) return true;  
        public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {  
                    struct.validate();
                }  
            if (lastComparison != 0) {
                        return O1;
                org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
            this.o1 = o1;
                    optionals.set(2);
                                    struct.setDb_nameIsSet(true);  
                org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
            org.apache.thrift.protocol.TType.STRUCT,
                this.db_name = db_name;  
                }
            }
        }  
            @org.apache.thrift.annotation.Nullable
            public AsyncClient getAsyncClient(org.apache.thrift.transport.TNonblockingTransport transport) {
        public MetaException getO1() {
            }
                    }
                return new get_table_req_args();  
            this.filter = filter;
            // check for required fields  
                        }
                if (struct.isSetO2()) {
            return this;
                } finally {
                get_partitions_by_filter_args args = new get_partitions_by_filter_args();
            // check for sub-struct validity  
            return this.o2;
            boolean this_present_o3 = true && this.isSetO3();
                this.protocolFactory = protocolFactory;  
            }  
        public get_partitions_by_filter_result setO2(@org.apache.thrift.annotation.Nullable NoSuchObjectException o2) {
                            return;
                        struct.setTbl_nameIsSet(true);
        private static final org.apache.thrift.protocol.TField SUCCESS_FIELD_DESC = new org.apache.thrift.protocol.TField(  
                        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) {
            @Override
        public boolean isSetDatabase() {
                            msgType = org.apache.thrift.protocol.TMessageType.EXCEPTION;  
            public get_partitions() {
            I iface,  
            }
            public void write(org.apache.thrift.protocol.TProtocol oprot, get_table_req_args struct) throws org.apache.thrift.TException {  
            (short) 1  
            }
            this.o2 = null;
        }  
        /**
        public boolean isSetO2() {
            );
                    return lastComparison;
                                if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {
            this.new_part = null;
            static {
    @SuppressWarnings({ "cast", "rawtypes", "serial", "unchecked", "unused" })
            sb.append("tbl:");
                )
            int lastComparison = 0;
        public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
                sb.append("null");
                        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) {
        }
            return this.o1;  
                            result.setO1IsSet(true);  
            sb.append(")");  
            O1((short) 1, "o1"),  
                return lastComparison;
            sb.append(")");  
                super("get_partitions");
                    return lastComparison;
            protected boolean rethrowUnhandledExceptions() {
                                if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
            java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<  
                case O1:
            return this;  
                return result;
                            return;
        @org.apache.thrift.annotation.Nullable  
            this.max_parts = 0;
                if (lastComparison != 0) {
            }
                return lastComparison;
            lastComparison = java.lang.Boolean.compare(isSetDatabase(), other.isSetDatabase());
                                org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);  
            }  
            if (other.isSetSuccess()) {
            return this;  
            @Override
                org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;  
            (short) 1  
                struct.validate();
                }
            if (field == null) {
            throws NoSuchObjectException, MetaException, org.apache.thrift.TException;
            if (this.db_name == null) {
                throws org.apache.thrift.TException {
                )  
                    }  
        private static final int __MAX_PARTS_ISSET_ID = 0;
        public enum _Fields implements org.apache.thrift.TFieldIdEnum {
             * Find the _Fields constant that matches fieldId, throwing an exception
                    return getO4();
         * Performs a deep copy on <i>other</i>.  
                throw new java.io.IOException(te);
                args.setTbl_name(tbl_name);
                if (struct.isSetDatabase()) {
                } catch (InvalidObjectException o2) {  
        public get_table_req_result setSuccess(@org.apache.thrift.annotation.Nullable GetTableResult success) {
                };
            processMap.put("create_database", new create_database());
            @Override  
            if (result.o1 != null) {  
                )
            public get_table_req_resultTupleScheme getScheme() {
                org.apache.thrift.protocol.TProtocol prot = client.getProtocolFactory().getProtocol(memoryTransport);  
            first = false;
                    iprot.decrementRecursionDepth();
            java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<
            return this.success;
            tmpMap.put(  
                db_name,
                prot.incrementRecursionDepth();
                    if (incoming.get(0)) {
                    public void onError(java.lang.Exception e) {
        private static class get_table_req_argsStandardScheme extends org.apache.thrift.scheme.StandardScheme<get_table_req_args> {
                lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.o1, other.o1);  
        @Override
                    java.util.BitSet incoming = iprot.readBitSet(3);  
            Comparable<get_partitions_args> {
                if (struct.o1 != null) {  
                struct.validate();  
            Comparable<add_partition_result> {  
                return _thriftId;  
        @Override
                )  
                if (struct.o1 != null) {  
                _Fields,
                            case 0: // SUCCESS
                }  
        @Override
            tmpMap.put(
            return new add_partition_args(this);  
        /** Returns true if field o2 is set (has been assigned a value) and false otherwise */
            this.tbl_name = null;
                                break;
                return lastComparison;  
         */  
                    result.o1 = o1;
    @SuppressWarnings({ "cast", "rawtypes", "serial", "unchecked", "unused" })
                        } catch (java.lang.Exception ex) {
            @org.apache.thrift.annotation.Nullable  
            return this.o1 != null;
        public void setFieldValue(_Fields field, @org.apache.thrift.annotation.Nullable java.lang.Object value) {
        @Override  
             * Find the _Fields constant that matches fieldId, throwing an exception
                }  
            tmpMap.put(
                read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
            }
        public AlreadyExistsException getO2() {  
            @Override
                lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.req, other.req);
            int hashCode = 1;
        private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("get_partitions_args");  
            (short) 4
                    }
        private static final org.apache.thrift.protocol.TField O1_FIELD_DESC = new org.apache.thrift.protocol.TField(
                        unsetO2();
                        setDb_name((java.lang.String) value);
             */
            switch (field) {  
        static {  
                                if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {
        /** Returns true if field success is set (has been assigned a value) and false otherwise */
                throw new java.io.IOException(te);  
                    }  
                _Fields.MAX_PARTS,
                return new add_partition_argsTupleScheme();
            } else {
                            msg = new org.apache.thrift.TApplicationException(
            switch (field) {
                )  
                return new create_table_resultStandardScheme();
            public void write(org.apache.thrift.protocol.TProtocol prot, add_partition_result struct) throws org.apache.thrift.TException {  
    public static class AsyncClient extends org.apache.thrift.async.TAsyncClient implements AsyncIface {
                    "o1",  
                _fieldName = fieldName;
            scheme(iprot).read(iprot, this);
            if (isSetO2()) {  
                        schemeField = iprot.readFieldBegin();
            add_partition_args,  
                if (!(this_present_o1 && that_present_o1)) return false;
        private static class add_partition_argsStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
            @Override  
        }  
                                        }
            public Factory(
            }
                case SUCCESS:
        public add_partition_args setNew_part(@org.apache.thrift.annotation.Nullable Partition new_part) {
             * Find the _Fields constant that matches fieldId, or null if its not found.
            return false;
            this.o3 = o3;  
                        struct.o1 = new MetaException();  
                        setMax_parts((java.lang.Short) value);
        public _Fields fieldForId(int fieldId) {
        }  
            }
                            msgType = org.apache.thrift.protocol.TMessageType.EXCEPTION;
                }
            if (!first) sb.append(", ");
                    struct.validate();
        public Partition getNew_part() {  
                    if (incoming.get(0)) {
        }  
                if (!(this_present_tbl_name && that_present_tbl_name)) return false;  
                this.db_name = other.db_name;
                sb.append("null");
                _Fields.O2,  
        }
            if (lastComparison != 0) {
                        if (e instanceof AlreadyExistsException) {
        }  
                return _fieldName;
            return this;
            (short) 1
            }
                    if (value == null) {  
                    org.apache.thrift.TFieldRequirementType.DEFAULT,
                    oprot.writeFieldBegin(FILTER_FIELD_DESC);  
        }
             */
            @Override
        private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {  
            this.o1 = o1;
                java.util.List<Partition> __this__success = new java.util.ArrayList<Partition>(other.success.size());  
            return this.tbl != null;
            }  
                    org.apache.thrift.TFieldRequirementType.DEFAULT,
                                    org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
