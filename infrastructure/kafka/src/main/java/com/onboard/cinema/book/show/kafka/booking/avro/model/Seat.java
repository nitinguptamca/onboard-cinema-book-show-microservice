/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package com.onboard.cinema.book.show.kafka.booking.avro.model;

import org.apache.avro.generic.GenericArray;
import org.apache.avro.specific.SpecificData;
import org.apache.avro.util.Utf8;
import org.apache.avro.message.BinaryMessageEncoder;
import org.apache.avro.message.BinaryMessageDecoder;
import org.apache.avro.message.SchemaStore;

@org.apache.avro.specific.AvroGenerated
public class Seat extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = -3678221025839737721L;


  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"Seat\",\"namespace\":\"com.onboard.cinema.book.show.kafka.booking.avro.model\",\"fields\":[{\"name\":\"id\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"},\"logicalType\":\"uuid\"},{\"name\":\"showSeatId\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"quantity\",\"type\":\"int\"}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static final SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<Seat> ENCODER =
      new BinaryMessageEncoder<Seat>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<Seat> DECODER =
      new BinaryMessageDecoder<Seat>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageEncoder instance used by this class.
   * @return the message encoder used by this class
   */
  public static BinaryMessageEncoder<Seat> getEncoder() {
    return ENCODER;
  }

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   * @return the message decoder used by this class
   */
  public static BinaryMessageDecoder<Seat> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   * @return a BinaryMessageDecoder instance for this class backed by the given SchemaStore
   */
  public static BinaryMessageDecoder<Seat> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<Seat>(MODEL$, SCHEMA$, resolver);
  }

  /**
   * Serializes this Seat to a ByteBuffer.
   * @return a buffer holding the serialized data for this instance
   * @throws java.io.IOException if this instance could not be serialized
   */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /**
   * Deserializes a Seat from a ByteBuffer.
   * @param b a byte buffer holding serialized data for an instance of this class
   * @return a Seat instance decoded from the given buffer
   * @throws java.io.IOException if the given bytes could not be deserialized into an instance of this class
   */
  public static Seat fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

  private java.lang.String id;
  private java.lang.String showSeatId;
  private int quantity;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public Seat() {}

  /**
   * All-args constructor.
   * @param id The new value for id
   * @param showSeatId The new value for showSeatId
   * @param quantity The new value for quantity
   */
  public Seat(java.lang.String id, java.lang.String showSeatId, java.lang.Integer quantity) {
    this.id = id;
    this.showSeatId = showSeatId;
    this.quantity = quantity;
  }

  public org.apache.avro.specific.SpecificData getSpecificData() { return MODEL$; }
  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return id;
    case 1: return showSeatId;
    case 2: return quantity;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: id = value$ != null ? value$.toString() : null; break;
    case 1: showSeatId = value$ != null ? value$.toString() : null; break;
    case 2: quantity = (java.lang.Integer)value$; break;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  /**
   * Gets the value of the 'id' field.
   * @return The value of the 'id' field.
   */
  public java.lang.String getId() {
    return id;
  }


  /**
   * Sets the value of the 'id' field.
   * @param value the value to set.
   */
  public void setId(java.lang.String value) {
    this.id = value;
  }

  /**
   * Gets the value of the 'showSeatId' field.
   * @return The value of the 'showSeatId' field.
   */
  public java.lang.String getShowSeatId() {
    return showSeatId;
  }


  /**
   * Sets the value of the 'showSeatId' field.
   * @param value the value to set.
   */
  public void setShowSeatId(java.lang.String value) {
    this.showSeatId = value;
  }

  /**
   * Gets the value of the 'quantity' field.
   * @return The value of the 'quantity' field.
   */
  public int getQuantity() {
    return quantity;
  }


  /**
   * Sets the value of the 'quantity' field.
   * @param value the value to set.
   */
  public void setQuantity(int value) {
    this.quantity = value;
  }

  /**
   * Creates a new Seat RecordBuilder.
   * @return A new Seat RecordBuilder
   */
  public static com.onboard.cinema.book.show.kafka.booking.avro.model.Seat.Builder newBuilder() {
    return new com.onboard.cinema.book.show.kafka.booking.avro.model.Seat.Builder();
  }

  /**
   * Creates a new Seat RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new Seat RecordBuilder
   */
  public static com.onboard.cinema.book.show.kafka.booking.avro.model.Seat.Builder newBuilder(com.onboard.cinema.book.show.kafka.booking.avro.model.Seat.Builder other) {
    if (other == null) {
      return new com.onboard.cinema.book.show.kafka.booking.avro.model.Seat.Builder();
    } else {
      return new com.onboard.cinema.book.show.kafka.booking.avro.model.Seat.Builder(other);
    }
  }

  /**
   * Creates a new Seat RecordBuilder by copying an existing Seat instance.
   * @param other The existing instance to copy.
   * @return A new Seat RecordBuilder
   */
  public static com.onboard.cinema.book.show.kafka.booking.avro.model.Seat.Builder newBuilder(com.onboard.cinema.book.show.kafka.booking.avro.model.Seat other) {
    if (other == null) {
      return new com.onboard.cinema.book.show.kafka.booking.avro.model.Seat.Builder();
    } else {
      return new com.onboard.cinema.book.show.kafka.booking.avro.model.Seat.Builder(other);
    }
  }

  /**
   * RecordBuilder for Seat instances.
   */
  @org.apache.avro.specific.AvroGenerated
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<Seat>
    implements org.apache.avro.data.RecordBuilder<Seat> {

    private java.lang.String id;
    private java.lang.String showSeatId;
    private int quantity;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$, MODEL$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(com.onboard.cinema.book.show.kafka.booking.avro.model.Seat.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.id)) {
        this.id = data().deepCopy(fields()[0].schema(), other.id);
        fieldSetFlags()[0] = other.fieldSetFlags()[0];
      }
      if (isValidValue(fields()[1], other.showSeatId)) {
        this.showSeatId = data().deepCopy(fields()[1].schema(), other.showSeatId);
        fieldSetFlags()[1] = other.fieldSetFlags()[1];
      }
      if (isValidValue(fields()[2], other.quantity)) {
        this.quantity = data().deepCopy(fields()[2].schema(), other.quantity);
        fieldSetFlags()[2] = other.fieldSetFlags()[2];
      }
    }

    /**
     * Creates a Builder by copying an existing Seat instance
     * @param other The existing instance to copy.
     */
    private Builder(com.onboard.cinema.book.show.kafka.booking.avro.model.Seat other) {
      super(SCHEMA$, MODEL$);
      if (isValidValue(fields()[0], other.id)) {
        this.id = data().deepCopy(fields()[0].schema(), other.id);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.showSeatId)) {
        this.showSeatId = data().deepCopy(fields()[1].schema(), other.showSeatId);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.quantity)) {
        this.quantity = data().deepCopy(fields()[2].schema(), other.quantity);
        fieldSetFlags()[2] = true;
      }
    }

    /**
      * Gets the value of the 'id' field.
      * @return The value.
      */
    public java.lang.String getId() {
      return id;
    }


    /**
      * Sets the value of the 'id' field.
      * @param value The value of 'id'.
      * @return This builder.
      */
    public com.onboard.cinema.book.show.kafka.booking.avro.model.Seat.Builder setId(java.lang.String value) {
      validate(fields()[0], value);
      this.id = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'id' field has been set.
      * @return True if the 'id' field has been set, false otherwise.
      */
    public boolean hasId() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'id' field.
      * @return This builder.
      */
    public com.onboard.cinema.book.show.kafka.booking.avro.model.Seat.Builder clearId() {
      id = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'showSeatId' field.
      * @return The value.
      */
    public java.lang.String getShowSeatId() {
      return showSeatId;
    }


    /**
      * Sets the value of the 'showSeatId' field.
      * @param value The value of 'showSeatId'.
      * @return This builder.
      */
    public com.onboard.cinema.book.show.kafka.booking.avro.model.Seat.Builder setShowSeatId(java.lang.String value) {
      validate(fields()[1], value);
      this.showSeatId = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'showSeatId' field has been set.
      * @return True if the 'showSeatId' field has been set, false otherwise.
      */
    public boolean hasShowSeatId() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'showSeatId' field.
      * @return This builder.
      */
    public com.onboard.cinema.book.show.kafka.booking.avro.model.Seat.Builder clearShowSeatId() {
      showSeatId = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'quantity' field.
      * @return The value.
      */
    public int getQuantity() {
      return quantity;
    }


    /**
      * Sets the value of the 'quantity' field.
      * @param value The value of 'quantity'.
      * @return This builder.
      */
    public com.onboard.cinema.book.show.kafka.booking.avro.model.Seat.Builder setQuantity(int value) {
      validate(fields()[2], value);
      this.quantity = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /**
      * Checks whether the 'quantity' field has been set.
      * @return True if the 'quantity' field has been set, false otherwise.
      */
    public boolean hasQuantity() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'quantity' field.
      * @return This builder.
      */
    public com.onboard.cinema.book.show.kafka.booking.avro.model.Seat.Builder clearQuantity() {
      fieldSetFlags()[2] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Seat build() {
      try {
        Seat record = new Seat();
        record.id = fieldSetFlags()[0] ? this.id : (java.lang.String) defaultValue(fields()[0]);
        record.showSeatId = fieldSetFlags()[1] ? this.showSeatId : (java.lang.String) defaultValue(fields()[1]);
        record.quantity = fieldSetFlags()[2] ? this.quantity : (java.lang.Integer) defaultValue(fields()[2]);
        return record;
      } catch (org.apache.avro.AvroMissingFieldException e) {
        throw e;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<Seat>
    WRITER$ = (org.apache.avro.io.DatumWriter<Seat>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<Seat>
    READER$ = (org.apache.avro.io.DatumReader<Seat>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

  @Override protected boolean hasCustomCoders() { return true; }

  @Override public void customEncode(org.apache.avro.io.Encoder out)
    throws java.io.IOException
  {
    out.writeString(this.id);

    out.writeString(this.showSeatId);

    out.writeInt(this.quantity);

  }

  @Override public void customDecode(org.apache.avro.io.ResolvingDecoder in)
    throws java.io.IOException
  {
    org.apache.avro.Schema.Field[] fieldOrder = in.readFieldOrderIfDiff();
    if (fieldOrder == null) {
      this.id = in.readString();

      this.showSeatId = in.readString();

      this.quantity = in.readInt();

    } else {
      for (int i = 0; i < 3; i++) {
        switch (fieldOrder[i].pos()) {
        case 0:
          this.id = in.readString();
          break;

        case 1:
          this.showSeatId = in.readString();
          break;

        case 2:
          this.quantity = in.readInt();
          break;

        default:
          throw new java.io.IOException("Corrupt ResolvingDecoder.");
        }
      }
    }
  }
}










