// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: laptop_service.proto

package stubs;

/**
 * Protobuf type {@code CreateLaptopRequest}
 */
public  final class CreateLaptopRequest extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:CreateLaptopRequest)
    CreateLaptopRequestOrBuilder {
private static final long serialVersionUID = 0L;
  // Use CreateLaptopRequest.newBuilder() to construct.
  private CreateLaptopRequest(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private CreateLaptopRequest() {
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new CreateLaptopRequest();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private CreateLaptopRequest(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          case 10: {
            stubs.Laptop.Builder subBuilder = null;
            if (laptop_ != null) {
              subBuilder = laptop_.toBuilder();
            }
            laptop_ = input.readMessage(stubs.Laptop.parser(), extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom(laptop_);
              laptop_ = subBuilder.buildPartial();
            }

            break;
          }
          default: {
            if (!parseUnknownField(
                input, unknownFields, extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return stubs.LaptopServiceOuterClass.internal_static_CreateLaptopRequest_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return stubs.LaptopServiceOuterClass.internal_static_CreateLaptopRequest_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            stubs.CreateLaptopRequest.class, stubs.CreateLaptopRequest.Builder.class);
  }

  public static final int LAPTOP_FIELD_NUMBER = 1;
  private stubs.Laptop laptop_;
  /**
   * <code>.Laptop laptop = 1;</code>
   * @return Whether the laptop field is set.
   */
  public boolean hasLaptop() {
    return laptop_ != null;
  }
  /**
   * <code>.Laptop laptop = 1;</code>
   * @return The laptop.
   */
  public stubs.Laptop getLaptop() {
    return laptop_ == null ? stubs.Laptop.getDefaultInstance() : laptop_;
  }
  /**
   * <code>.Laptop laptop = 1;</code>
   */
  public stubs.LaptopOrBuilder getLaptopOrBuilder() {
    return getLaptop();
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (laptop_ != null) {
      output.writeMessage(1, getLaptop());
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (laptop_ != null) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(1, getLaptop());
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof stubs.CreateLaptopRequest)) {
      return super.equals(obj);
    }
    stubs.CreateLaptopRequest other = (stubs.CreateLaptopRequest) obj;

    if (hasLaptop() != other.hasLaptop()) return false;
    if (hasLaptop()) {
      if (!getLaptop()
          .equals(other.getLaptop())) return false;
    }
    if (!unknownFields.equals(other.unknownFields)) return false;
    return true;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    if (hasLaptop()) {
      hash = (37 * hash) + LAPTOP_FIELD_NUMBER;
      hash = (53 * hash) + getLaptop().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static stubs.CreateLaptopRequest parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static stubs.CreateLaptopRequest parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static stubs.CreateLaptopRequest parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static stubs.CreateLaptopRequest parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static stubs.CreateLaptopRequest parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static stubs.CreateLaptopRequest parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static stubs.CreateLaptopRequest parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static stubs.CreateLaptopRequest parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static stubs.CreateLaptopRequest parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static stubs.CreateLaptopRequest parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static stubs.CreateLaptopRequest parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static stubs.CreateLaptopRequest parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(stubs.CreateLaptopRequest prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code CreateLaptopRequest}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:CreateLaptopRequest)
      stubs.CreateLaptopRequestOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return stubs.LaptopServiceOuterClass.internal_static_CreateLaptopRequest_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return stubs.LaptopServiceOuterClass.internal_static_CreateLaptopRequest_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              stubs.CreateLaptopRequest.class, stubs.CreateLaptopRequest.Builder.class);
    }

    // Construct using stubs.CreateLaptopRequest.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      if (laptopBuilder_ == null) {
        laptop_ = null;
      } else {
        laptop_ = null;
        laptopBuilder_ = null;
      }
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return stubs.LaptopServiceOuterClass.internal_static_CreateLaptopRequest_descriptor;
    }

    @java.lang.Override
    public stubs.CreateLaptopRequest getDefaultInstanceForType() {
      return stubs.CreateLaptopRequest.getDefaultInstance();
    }

    @java.lang.Override
    public stubs.CreateLaptopRequest build() {
      stubs.CreateLaptopRequest result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public stubs.CreateLaptopRequest buildPartial() {
      stubs.CreateLaptopRequest result = new stubs.CreateLaptopRequest(this);
      if (laptopBuilder_ == null) {
        result.laptop_ = laptop_;
      } else {
        result.laptop_ = laptopBuilder_.build();
      }
      onBuilt();
      return result;
    }

    @java.lang.Override
    public Builder clone() {
      return super.clone();
    }
    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.setField(field, value);
    }
    @java.lang.Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return super.clearField(field);
    }
    @java.lang.Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return super.clearOneof(oneof);
    }
    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return super.setRepeatedField(field, index, value);
    }
    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.addRepeatedField(field, value);
    }
    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof stubs.CreateLaptopRequest) {
        return mergeFrom((stubs.CreateLaptopRequest)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(stubs.CreateLaptopRequest other) {
      if (other == stubs.CreateLaptopRequest.getDefaultInstance()) return this;
      if (other.hasLaptop()) {
        mergeLaptop(other.getLaptop());
      }
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      stubs.CreateLaptopRequest parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (stubs.CreateLaptopRequest) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private stubs.Laptop laptop_;
    private com.google.protobuf.SingleFieldBuilderV3<
        stubs.Laptop, stubs.Laptop.Builder, stubs.LaptopOrBuilder> laptopBuilder_;
    /**
     * <code>.Laptop laptop = 1;</code>
     * @return Whether the laptop field is set.
     */
    public boolean hasLaptop() {
      return laptopBuilder_ != null || laptop_ != null;
    }
    /**
     * <code>.Laptop laptop = 1;</code>
     * @return The laptop.
     */
    public stubs.Laptop getLaptop() {
      if (laptopBuilder_ == null) {
        return laptop_ == null ? stubs.Laptop.getDefaultInstance() : laptop_;
      } else {
        return laptopBuilder_.getMessage();
      }
    }
    /**
     * <code>.Laptop laptop = 1;</code>
     */
    public Builder setLaptop(stubs.Laptop value) {
      if (laptopBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        laptop_ = value;
        onChanged();
      } else {
        laptopBuilder_.setMessage(value);
      }

      return this;
    }
    /**
     * <code>.Laptop laptop = 1;</code>
     */
    public Builder setLaptop(
        stubs.Laptop.Builder builderForValue) {
      if (laptopBuilder_ == null) {
        laptop_ = builderForValue.build();
        onChanged();
      } else {
        laptopBuilder_.setMessage(builderForValue.build());
      }

      return this;
    }
    /**
     * <code>.Laptop laptop = 1;</code>
     */
    public Builder mergeLaptop(stubs.Laptop value) {
      if (laptopBuilder_ == null) {
        if (laptop_ != null) {
          laptop_ =
            stubs.Laptop.newBuilder(laptop_).mergeFrom(value).buildPartial();
        } else {
          laptop_ = value;
        }
        onChanged();
      } else {
        laptopBuilder_.mergeFrom(value);
      }

      return this;
    }
    /**
     * <code>.Laptop laptop = 1;</code>
     */
    public Builder clearLaptop() {
      if (laptopBuilder_ == null) {
        laptop_ = null;
        onChanged();
      } else {
        laptop_ = null;
        laptopBuilder_ = null;
      }

      return this;
    }
    /**
     * <code>.Laptop laptop = 1;</code>
     */
    public stubs.Laptop.Builder getLaptopBuilder() {
      
      onChanged();
      return getLaptopFieldBuilder().getBuilder();
    }
    /**
     * <code>.Laptop laptop = 1;</code>
     */
    public stubs.LaptopOrBuilder getLaptopOrBuilder() {
      if (laptopBuilder_ != null) {
        return laptopBuilder_.getMessageOrBuilder();
      } else {
        return laptop_ == null ?
            stubs.Laptop.getDefaultInstance() : laptop_;
      }
    }
    /**
     * <code>.Laptop laptop = 1;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        stubs.Laptop, stubs.Laptop.Builder, stubs.LaptopOrBuilder> 
        getLaptopFieldBuilder() {
      if (laptopBuilder_ == null) {
        laptopBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            stubs.Laptop, stubs.Laptop.Builder, stubs.LaptopOrBuilder>(
                getLaptop(),
                getParentForChildren(),
                isClean());
        laptop_ = null;
      }
      return laptopBuilder_;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFields(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:CreateLaptopRequest)
  }

  // @@protoc_insertion_point(class_scope:CreateLaptopRequest)
  private static final stubs.CreateLaptopRequest DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new stubs.CreateLaptopRequest();
  }

  public static stubs.CreateLaptopRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<CreateLaptopRequest>
      PARSER = new com.google.protobuf.AbstractParser<CreateLaptopRequest>() {
    @java.lang.Override
    public CreateLaptopRequest parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new CreateLaptopRequest(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<CreateLaptopRequest> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<CreateLaptopRequest> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public stubs.CreateLaptopRequest getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

