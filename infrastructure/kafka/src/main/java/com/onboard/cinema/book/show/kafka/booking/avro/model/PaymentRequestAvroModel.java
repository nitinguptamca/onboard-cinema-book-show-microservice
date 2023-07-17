/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package com.onboard.cinema.book.show.kafka.booking.avro.model;

import org.apache.avro.message.BinaryMessageDecoder;
import org.apache.avro.message.BinaryMessageEncoder;
import org.apache.avro.message.SchemaStore;
import org.apache.avro.specific.SpecificData;

@org.apache.avro.specific.AvroGenerated
public class PaymentRequestAvroModel extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = -3097977525716619740L;


  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"PaymentRequestAvroModel\",\"namespace\":\"com.onboard.cinema.book.show.kafka.booking.avro.model\",\"fields\":[{\"name\":\"id\",\"type\":{\"type\":\"string\",\"logicalType\":\"uuid\"}},{\"name\":\"sagaId\",\"type\":{\"type\":\"string\",\"logicalType\":\"uuid\"}},{\"name\":\"customerId\",\"type\":{\"type\":\"string\",\"logicalType\":\"uuid\"}},{\"name\":\"bookingId\",\"type\":{\"type\":\"string\",\"logicalType\":\"uuid\"}},{\"name\":\"movieId\",\"type\":{\"type\":\"string\",\"logicalType\":\"uuid\"}},{\"name\":\"showId\",\"type\":{\"type\":\"string\",\"logicalType\":\"uuid\"}},{\"name\":\"cinemaId\",\"type\":{\"type\":\"string\",\"logicalType\":\"uuid\"}},{\"name\":\"cinemaHallId\",\"type\":{\"type\":\"string\",\"logicalType\":\"uuid\"}},{\"name\":\"price\",\"type\":{\"type\":\"bytes\",\"logicalType\":\"decimal\",\"precision\":10,\"scale\":2}},{\"name\":\"createdAt\",\"type\":{\"type\":\"long\",\"logicalType\":\"timestamp-millis\"}},{\"name\":\"paymentBookingStatus\",\"type\":{\"type\":\"enum\",\"name\":\"PaymentBookingStatus\",\"symbols\":[\"PENDING\",\"CANCELLED\"]}}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static final SpecificData MODEL$ = new SpecificData();
  static {
    MODEL$.addLogicalTypeConversion(new org.apache.avro.data.TimeConversions.TimestampMillisConversion());
    MODEL$.addLogicalTypeConversion(new org.apache.avro.Conversions.DecimalConversion());
  }

  private static final BinaryMessageEncoder<PaymentRequestAvroModel> ENCODER =
      new BinaryMessageEncoder<PaymentRequestAvroModel>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<PaymentRequestAvroModel> DECODER =
      new BinaryMessageDecoder<PaymentRequestAvroModel>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageEncoder instance used by this class.
   * @return the message encoder used by this class
   */
  public static BinaryMessageEncoder<PaymentRequestAvroModel> getEncoder() {
    return ENCODER;
  }

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   * @return the message decoder used by this class
   */
  public static BinaryMessageDecoder<PaymentRequestAvroModel> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   * @return a BinaryMessageDecoder instance for this class backed by the given SchemaStore
   */
  public static BinaryMessageDecoder<PaymentRequestAvroModel> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<PaymentRequestAvroModel>(MODEL$, SCHEMA$, resolver);
  }

  /**
   * Serializes this PaymentRequestAvroModel to a ByteBuffer.
   * @return a buffer holding the serialized data for this instance
   * @throws java.io.IOException if this instance could not be serialized
   */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /**
   * Deserializes a PaymentRequestAvroModel from a ByteBuffer.
   * @param b a byte buffer holding serialized data for an instance of this class
   * @return a PaymentRequestAvroModel instance decoded from the given buffer
   * @throws java.io.IOException if the given bytes could not be deserialized into an instance of this class
   */
  public static PaymentRequestAvroModel fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

  private java.lang.String id;
  private java.lang.String sagaId;
  private java.lang.String customerId;
  private java.lang.String bookingId;
  private java.lang.String movieId;
  private java.lang.String showId;
  private java.lang.String cinemaId;
  private java.lang.String cinemaHallId;
  private java.math.BigDecimal price;
  private java.time.Instant createdAt;
  private com.onboard.cinema.book.show.kafka.booking.avro.model.PaymentBookingStatus paymentBookingStatus;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public PaymentRequestAvroModel() {}

  /**
   * All-args constructor.
   * @param id The new value for id
   * @param sagaId The new value for sagaId
   * @param customerId The new value for customerId
   * @param bookingId The new value for bookingId
   * @param movieId The new value for movieId
   * @param showId The new value for showId
   * @param cinemaId The new value for cinemaId
   * @param cinemaHallId The new value for cinemaHallId
   * @param price The new value for price
   * @param createdAt The new value for createdAt
   * @param paymentBookingStatus The new value for paymentBookingStatus
   */
  public PaymentRequestAvroModel(java.lang.String id, java.lang.String sagaId, java.lang.String customerId, java.lang.String bookingId, java.lang.String movieId, java.lang.String showId, java.lang.String cinemaId, java.lang.String cinemaHallId, java.math.BigDecimal price, java.time.Instant createdAt, com.onboard.cinema.book.show.kafka.booking.avro.model.PaymentBookingStatus paymentBookingStatus) {
    this.id = id;
    this.sagaId = sagaId;
    this.customerId = customerId;
    this.bookingId = bookingId;
    this.movieId = movieId;
    this.showId = showId;
    this.cinemaId = cinemaId;
    this.cinemaHallId = cinemaHallId;
    this.price = price;
    this.createdAt = createdAt.truncatedTo(java.time.temporal.ChronoUnit.MILLIS);
    this.paymentBookingStatus = paymentBookingStatus;
  }

  public org.apache.avro.specific.SpecificData getSpecificData() { return MODEL$; }
  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return id;
    case 1: return sagaId;
    case 2: return customerId;
    case 3: return bookingId;
    case 4: return movieId;
    case 5: return showId;
    case 6: return cinemaId;
    case 7: return cinemaHallId;
    case 8: return price;
    case 9: return createdAt;
    case 10: return paymentBookingStatus;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  private static final org.apache.avro.Conversion<?>[] conversions =
      new org.apache.avro.Conversion<?>[] {
      null,
      null,
      null,
      null,
      null,
      null,
      null,
      null,
      new org.apache.avro.Conversions.DecimalConversion(),
      new org.apache.avro.data.TimeConversions.TimestampMillisConversion(),
      null,
      null
  };

  @Override
  public org.apache.avro.Conversion<?> getConversion(int field) {
    return conversions[field];
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: id = value$ != null ? value$.toString() : null; break;
    case 1: sagaId = value$ != null ? value$.toString() : null; break;
    case 2: customerId = value$ != null ? value$.toString() : null; break;
    case 3: bookingId = value$ != null ? value$.toString() : null; break;
    case 4: movieId = value$ != null ? value$.toString() : null; break;
    case 5: showId = value$ != null ? value$.toString() : null; break;
    case 6: cinemaId = value$ != null ? value$.toString() : null; break;
    case 7: cinemaHallId = value$ != null ? value$.toString() : null; break;
    case 8: price = (java.math.BigDecimal)value$; break;
    case 9: createdAt = (java.time.Instant)value$; break;
    case 10: paymentBookingStatus = (com.onboard.cinema.book.show.kafka.booking.avro.model.PaymentBookingStatus)value$; break;
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
   * Gets the value of the 'sagaId' field.
   * @return The value of the 'sagaId' field.
   */
  public java.lang.String getSagaId() {
    return sagaId;
  }


  /**
   * Sets the value of the 'sagaId' field.
   * @param value the value to set.
   */
  public void setSagaId(java.lang.String value) {
    this.sagaId = value;
  }

  /**
   * Gets the value of the 'customerId' field.
   * @return The value of the 'customerId' field.
   */
  public java.lang.String getCustomerId() {
    return customerId;
  }


  /**
   * Sets the value of the 'customerId' field.
   * @param value the value to set.
   */
  public void setCustomerId(java.lang.String value) {
    this.customerId = value;
  }

  /**
   * Gets the value of the 'bookingId' field.
   * @return The value of the 'bookingId' field.
   */
  public java.lang.String getBookingId() {
    return bookingId;
  }


  /**
   * Sets the value of the 'bookingId' field.
   * @param value the value to set.
   */
  public void setBookingId(java.lang.String value) {
    this.bookingId = value;
  }

  /**
   * Gets the value of the 'movieId' field.
   * @return The value of the 'movieId' field.
   */
  public java.lang.String getMovieId() {
    return movieId;
  }


  /**
   * Sets the value of the 'movieId' field.
   * @param value the value to set.
   */
  public void setMovieId(java.lang.String value) {
    this.movieId = value;
  }

  /**
   * Gets the value of the 'showId' field.
   * @return The value of the 'showId' field.
   */
  public java.lang.String getShowId() {
    return showId;
  }


  /**
   * Sets the value of the 'showId' field.
   * @param value the value to set.
   */
  public void setShowId(java.lang.String value) {
    this.showId = value;
  }

  /**
   * Gets the value of the 'cinemaId' field.
   * @return The value of the 'cinemaId' field.
   */
  public java.lang.String getCinemaId() {
    return cinemaId;
  }


  /**
   * Sets the value of the 'cinemaId' field.
   * @param value the value to set.
   */
  public void setCinemaId(java.lang.String value) {
    this.cinemaId = value;
  }

  /**
   * Gets the value of the 'cinemaHallId' field.
   * @return The value of the 'cinemaHallId' field.
   */
  public java.lang.String getCinemaHallId() {
    return cinemaHallId;
  }


  /**
   * Sets the value of the 'cinemaHallId' field.
   * @param value the value to set.
   */
  public void setCinemaHallId(java.lang.String value) {
    this.cinemaHallId = value;
  }

  /**
   * Gets the value of the 'price' field.
   * @return The value of the 'price' field.
   */
  public java.math.BigDecimal getPrice() {
    return price;
  }


  /**
   * Sets the value of the 'price' field.
   * @param value the value to set.
   */
  public void setPrice(java.math.BigDecimal value) {
    this.price = value;
  }

  /**
   * Gets the value of the 'createdAt' field.
   * @return The value of the 'createdAt' field.
   */
  public java.time.Instant getCreatedAt() {
    return createdAt;
  }


  /**
   * Sets the value of the 'createdAt' field.
   * @param value the value to set.
   */
  public void setCreatedAt(java.time.Instant value) {
    this.createdAt = value.truncatedTo(java.time.temporal.ChronoUnit.MILLIS);
  }

  /**
   * Gets the value of the 'paymentBookingStatus' field.
   * @return The value of the 'paymentBookingStatus' field.
   */
  public com.onboard.cinema.book.show.kafka.booking.avro.model.PaymentBookingStatus getPaymentBookingStatus() {
    return paymentBookingStatus;
  }


  /**
   * Sets the value of the 'paymentBookingStatus' field.
   * @param value the value to set.
   */
  public void setPaymentBookingStatus(com.onboard.cinema.book.show.kafka.booking.avro.model.PaymentBookingStatus value) {
    this.paymentBookingStatus = value;
  }

  /**
   * Creates a new PaymentRequestAvroModel RecordBuilder.
   * @return A new PaymentRequestAvroModel RecordBuilder
   */
  public static com.onboard.cinema.book.show.kafka.booking.avro.model.PaymentRequestAvroModel.Builder newBuilder() {
    return new com.onboard.cinema.book.show.kafka.booking.avro.model.PaymentRequestAvroModel.Builder();
  }

  /**
   * Creates a new PaymentRequestAvroModel RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new PaymentRequestAvroModel RecordBuilder
   */
  public static com.onboard.cinema.book.show.kafka.booking.avro.model.PaymentRequestAvroModel.Builder newBuilder(com.onboard.cinema.book.show.kafka.booking.avro.model.PaymentRequestAvroModel.Builder other) {
    if (other == null) {
      return new com.onboard.cinema.book.show.kafka.booking.avro.model.PaymentRequestAvroModel.Builder();
    } else {
      return new com.onboard.cinema.book.show.kafka.booking.avro.model.PaymentRequestAvroModel.Builder(other);
    }
  }

  /**
   * Creates a new PaymentRequestAvroModel RecordBuilder by copying an existing PaymentRequestAvroModel instance.
   * @param other The existing instance to copy.
   * @return A new PaymentRequestAvroModel RecordBuilder
   */
  public static com.onboard.cinema.book.show.kafka.booking.avro.model.PaymentRequestAvroModel.Builder newBuilder(com.onboard.cinema.book.show.kafka.booking.avro.model.PaymentRequestAvroModel other) {
    if (other == null) {
      return new com.onboard.cinema.book.show.kafka.booking.avro.model.PaymentRequestAvroModel.Builder();
    } else {
      return new com.onboard.cinema.book.show.kafka.booking.avro.model.PaymentRequestAvroModel.Builder(other);
    }
  }

  /**
   * RecordBuilder for PaymentRequestAvroModel instances.
   */
  @org.apache.avro.specific.AvroGenerated
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<PaymentRequestAvroModel>
    implements org.apache.avro.data.RecordBuilder<PaymentRequestAvroModel> {

    private java.lang.String id;
    private java.lang.String sagaId;
    private java.lang.String customerId;
    private java.lang.String bookingId;
    private java.lang.String movieId;
    private java.lang.String showId;
    private java.lang.String cinemaId;
    private java.lang.String cinemaHallId;
    private java.math.BigDecimal price;
    private java.time.Instant createdAt;
    private com.onboard.cinema.book.show.kafka.booking.avro.model.PaymentBookingStatus paymentBookingStatus;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$, MODEL$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(com.onboard.cinema.book.show.kafka.booking.avro.model.PaymentRequestAvroModel.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.id)) {
        this.id = data().deepCopy(fields()[0].schema(), other.id);
        fieldSetFlags()[0] = other.fieldSetFlags()[0];
      }
      if (isValidValue(fields()[1], other.sagaId)) {
        this.sagaId = data().deepCopy(fields()[1].schema(), other.sagaId);
        fieldSetFlags()[1] = other.fieldSetFlags()[1];
      }
      if (isValidValue(fields()[2], other.customerId)) {
        this.customerId = data().deepCopy(fields()[2].schema(), other.customerId);
        fieldSetFlags()[2] = other.fieldSetFlags()[2];
      }
      if (isValidValue(fields()[3], other.bookingId)) {
        this.bookingId = data().deepCopy(fields()[3].schema(), other.bookingId);
        fieldSetFlags()[3] = other.fieldSetFlags()[3];
      }
      if (isValidValue(fields()[4], other.movieId)) {
        this.movieId = data().deepCopy(fields()[4].schema(), other.movieId);
        fieldSetFlags()[4] = other.fieldSetFlags()[4];
      }
      if (isValidValue(fields()[5], other.showId)) {
        this.showId = data().deepCopy(fields()[5].schema(), other.showId);
        fieldSetFlags()[5] = other.fieldSetFlags()[5];
      }
      if (isValidValue(fields()[6], other.cinemaId)) {
        this.cinemaId = data().deepCopy(fields()[6].schema(), other.cinemaId);
        fieldSetFlags()[6] = other.fieldSetFlags()[6];
      }
      if (isValidValue(fields()[7], other.cinemaHallId)) {
        this.cinemaHallId = data().deepCopy(fields()[7].schema(), other.cinemaHallId);
        fieldSetFlags()[7] = other.fieldSetFlags()[7];
      }
      if (isValidValue(fields()[8], other.price)) {
        this.price = data().deepCopy(fields()[8].schema(), other.price);
        fieldSetFlags()[8] = other.fieldSetFlags()[8];
      }
      if (isValidValue(fields()[9], other.createdAt)) {
        this.createdAt = data().deepCopy(fields()[9].schema(), other.createdAt);
        fieldSetFlags()[9] = other.fieldSetFlags()[9];
      }
      if (isValidValue(fields()[10], other.paymentBookingStatus)) {
        this.paymentBookingStatus = data().deepCopy(fields()[10].schema(), other.paymentBookingStatus);
        fieldSetFlags()[10] = other.fieldSetFlags()[10];
      }
    }

    /**
     * Creates a Builder by copying an existing PaymentRequestAvroModel instance
     * @param other The existing instance to copy.
     */
    private Builder(com.onboard.cinema.book.show.kafka.booking.avro.model.PaymentRequestAvroModel other) {
      super(SCHEMA$, MODEL$);
      if (isValidValue(fields()[0], other.id)) {
        this.id = data().deepCopy(fields()[0].schema(), other.id);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.sagaId)) {
        this.sagaId = data().deepCopy(fields()[1].schema(), other.sagaId);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.customerId)) {
        this.customerId = data().deepCopy(fields()[2].schema(), other.customerId);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.bookingId)) {
        this.bookingId = data().deepCopy(fields()[3].schema(), other.bookingId);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.movieId)) {
        this.movieId = data().deepCopy(fields()[4].schema(), other.movieId);
        fieldSetFlags()[4] = true;
      }
      if (isValidValue(fields()[5], other.showId)) {
        this.showId = data().deepCopy(fields()[5].schema(), other.showId);
        fieldSetFlags()[5] = true;
      }
      if (isValidValue(fields()[6], other.cinemaId)) {
        this.cinemaId = data().deepCopy(fields()[6].schema(), other.cinemaId);
        fieldSetFlags()[6] = true;
      }
      if (isValidValue(fields()[7], other.cinemaHallId)) {
        this.cinemaHallId = data().deepCopy(fields()[7].schema(), other.cinemaHallId);
        fieldSetFlags()[7] = true;
      }
      if (isValidValue(fields()[8], other.price)) {
        this.price = data().deepCopy(fields()[8].schema(), other.price);
        fieldSetFlags()[8] = true;
      }
      if (isValidValue(fields()[9], other.createdAt)) {
        this.createdAt = data().deepCopy(fields()[9].schema(), other.createdAt);
        fieldSetFlags()[9] = true;
      }
      if (isValidValue(fields()[10], other.paymentBookingStatus)) {
        this.paymentBookingStatus = data().deepCopy(fields()[10].schema(), other.paymentBookingStatus);
        fieldSetFlags()[10] = true;
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
    public com.onboard.cinema.book.show.kafka.booking.avro.model.PaymentRequestAvroModel.Builder setId(java.lang.String value) {
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
    public com.onboard.cinema.book.show.kafka.booking.avro.model.PaymentRequestAvroModel.Builder clearId() {
      id = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'sagaId' field.
      * @return The value.
      */
    public java.lang.String getSagaId() {
      return sagaId;
    }


    /**
      * Sets the value of the 'sagaId' field.
      * @param value The value of 'sagaId'.
      * @return This builder.
      */
    public com.onboard.cinema.book.show.kafka.booking.avro.model.PaymentRequestAvroModel.Builder setSagaId(java.lang.String value) {
      validate(fields()[1], value);
      this.sagaId = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'sagaId' field has been set.
      * @return True if the 'sagaId' field has been set, false otherwise.
      */
    public boolean hasSagaId() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'sagaId' field.
      * @return This builder.
      */
    public com.onboard.cinema.book.show.kafka.booking.avro.model.PaymentRequestAvroModel.Builder clearSagaId() {
      sagaId = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'customerId' field.
      * @return The value.
      */
    public java.lang.String getCustomerId() {
      return customerId;
    }


    /**
      * Sets the value of the 'customerId' field.
      * @param value The value of 'customerId'.
      * @return This builder.
      */
    public com.onboard.cinema.book.show.kafka.booking.avro.model.PaymentRequestAvroModel.Builder setCustomerId(java.lang.String value) {
      validate(fields()[2], value);
      this.customerId = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /**
      * Checks whether the 'customerId' field has been set.
      * @return True if the 'customerId' field has been set, false otherwise.
      */
    public boolean hasCustomerId() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'customerId' field.
      * @return This builder.
      */
    public com.onboard.cinema.book.show.kafka.booking.avro.model.PaymentRequestAvroModel.Builder clearCustomerId() {
      customerId = null;
      fieldSetFlags()[2] = false;
      return this;
    }

    /**
      * Gets the value of the 'bookingId' field.
      * @return The value.
      */
    public java.lang.String getBookingId() {
      return bookingId;
    }


    /**
      * Sets the value of the 'bookingId' field.
      * @param value The value of 'bookingId'.
      * @return This builder.
      */
    public com.onboard.cinema.book.show.kafka.booking.avro.model.PaymentRequestAvroModel.Builder setBookingId(java.lang.String value) {
      validate(fields()[3], value);
      this.bookingId = value;
      fieldSetFlags()[3] = true;
      return this;
    }

    /**
      * Checks whether the 'bookingId' field has been set.
      * @return True if the 'bookingId' field has been set, false otherwise.
      */
    public boolean hasBookingId() {
      return fieldSetFlags()[3];
    }


    /**
      * Clears the value of the 'bookingId' field.
      * @return This builder.
      */
    public com.onboard.cinema.book.show.kafka.booking.avro.model.PaymentRequestAvroModel.Builder clearBookingId() {
      bookingId = null;
      fieldSetFlags()[3] = false;
      return this;
    }

    /**
      * Gets the value of the 'movieId' field.
      * @return The value.
      */
    public java.lang.String getMovieId() {
      return movieId;
    }


    /**
      * Sets the value of the 'movieId' field.
      * @param value The value of 'movieId'.
      * @return This builder.
      */
    public com.onboard.cinema.book.show.kafka.booking.avro.model.PaymentRequestAvroModel.Builder setMovieId(java.lang.String value) {
      validate(fields()[4], value);
      this.movieId = value;
      fieldSetFlags()[4] = true;
      return this;
    }

    /**
      * Checks whether the 'movieId' field has been set.
      * @return True if the 'movieId' field has been set, false otherwise.
      */
    public boolean hasMovieId() {
      return fieldSetFlags()[4];
    }


    /**
      * Clears the value of the 'movieId' field.
      * @return This builder.
      */
    public com.onboard.cinema.book.show.kafka.booking.avro.model.PaymentRequestAvroModel.Builder clearMovieId() {
      movieId = null;
      fieldSetFlags()[4] = false;
      return this;
    }

    /**
      * Gets the value of the 'showId' field.
      * @return The value.
      */
    public java.lang.String getShowId() {
      return showId;
    }


    /**
      * Sets the value of the 'showId' field.
      * @param value The value of 'showId'.
      * @return This builder.
      */
    public com.onboard.cinema.book.show.kafka.booking.avro.model.PaymentRequestAvroModel.Builder setShowId(java.lang.String value) {
      validate(fields()[5], value);
      this.showId = value;
      fieldSetFlags()[5] = true;
      return this;
    }

    /**
      * Checks whether the 'showId' field has been set.
      * @return True if the 'showId' field has been set, false otherwise.
      */
    public boolean hasShowId() {
      return fieldSetFlags()[5];
    }


    /**
      * Clears the value of the 'showId' field.
      * @return This builder.
      */
    public com.onboard.cinema.book.show.kafka.booking.avro.model.PaymentRequestAvroModel.Builder clearShowId() {
      showId = null;
      fieldSetFlags()[5] = false;
      return this;
    }

    /**
      * Gets the value of the 'cinemaId' field.
      * @return The value.
      */
    public java.lang.String getCinemaId() {
      return cinemaId;
    }


    /**
      * Sets the value of the 'cinemaId' field.
      * @param value The value of 'cinemaId'.
      * @return This builder.
      */
    public com.onboard.cinema.book.show.kafka.booking.avro.model.PaymentRequestAvroModel.Builder setCinemaId(java.lang.String value) {
      validate(fields()[6], value);
      this.cinemaId = value;
      fieldSetFlags()[6] = true;
      return this;
    }

    /**
      * Checks whether the 'cinemaId' field has been set.
      * @return True if the 'cinemaId' field has been set, false otherwise.
      */
    public boolean hasCinemaId() {
      return fieldSetFlags()[6];
    }


    /**
      * Clears the value of the 'cinemaId' field.
      * @return This builder.
      */
    public com.onboard.cinema.book.show.kafka.booking.avro.model.PaymentRequestAvroModel.Builder clearCinemaId() {
      cinemaId = null;
      fieldSetFlags()[6] = false;
      return this;
    }

    /**
      * Gets the value of the 'cinemaHallId' field.
      * @return The value.
      */
    public java.lang.String getCinemaHallId() {
      return cinemaHallId;
    }


    /**
      * Sets the value of the 'cinemaHallId' field.
      * @param value The value of 'cinemaHallId'.
      * @return This builder.
      */
    public com.onboard.cinema.book.show.kafka.booking.avro.model.PaymentRequestAvroModel.Builder setCinemaHallId(java.lang.String value) {
      validate(fields()[7], value);
      this.cinemaHallId = value;
      fieldSetFlags()[7] = true;
      return this;
    }

    /**
      * Checks whether the 'cinemaHallId' field has been set.
      * @return True if the 'cinemaHallId' field has been set, false otherwise.
      */
    public boolean hasCinemaHallId() {
      return fieldSetFlags()[7];
    }


    /**
      * Clears the value of the 'cinemaHallId' field.
      * @return This builder.
      */
    public com.onboard.cinema.book.show.kafka.booking.avro.model.PaymentRequestAvroModel.Builder clearCinemaHallId() {
      cinemaHallId = null;
      fieldSetFlags()[7] = false;
      return this;
    }

    /**
      * Gets the value of the 'price' field.
      * @return The value.
      */
    public java.math.BigDecimal getPrice() {
      return price;
    }


    /**
      * Sets the value of the 'price' field.
      * @param value The value of 'price'.
      * @return This builder.
      */
    public com.onboard.cinema.book.show.kafka.booking.avro.model.PaymentRequestAvroModel.Builder setPrice(java.math.BigDecimal value) {
      validate(fields()[8], value);
      this.price = value;
      fieldSetFlags()[8] = true;
      return this;
    }

    /**
      * Checks whether the 'price' field has been set.
      * @return True if the 'price' field has been set, false otherwise.
      */
    public boolean hasPrice() {
      return fieldSetFlags()[8];
    }


    /**
      * Clears the value of the 'price' field.
      * @return This builder.
      */
    public com.onboard.cinema.book.show.kafka.booking.avro.model.PaymentRequestAvroModel.Builder clearPrice() {
      price = null;
      fieldSetFlags()[8] = false;
      return this;
    }

    /**
      * Gets the value of the 'createdAt' field.
      * @return The value.
      */
    public java.time.Instant getCreatedAt() {
      return createdAt;
    }


    /**
      * Sets the value of the 'createdAt' field.
      * @param value The value of 'createdAt'.
      * @return This builder.
      */
    public com.onboard.cinema.book.show.kafka.booking.avro.model.PaymentRequestAvroModel.Builder setCreatedAt(java.time.Instant value) {
      validate(fields()[9], value);
      this.createdAt = value.truncatedTo(java.time.temporal.ChronoUnit.MILLIS);
      fieldSetFlags()[9] = true;
      return this;
    }

    /**
      * Checks whether the 'createdAt' field has been set.
      * @return True if the 'createdAt' field has been set, false otherwise.
      */
    public boolean hasCreatedAt() {
      return fieldSetFlags()[9];
    }


    /**
      * Clears the value of the 'createdAt' field.
      * @return This builder.
      */
    public com.onboard.cinema.book.show.kafka.booking.avro.model.PaymentRequestAvroModel.Builder clearCreatedAt() {
      fieldSetFlags()[9] = false;
      return this;
    }

    /**
      * Gets the value of the 'paymentBookingStatus' field.
      * @return The value.
      */
    public com.onboard.cinema.book.show.kafka.booking.avro.model.PaymentBookingStatus getPaymentBookingStatus() {
      return paymentBookingStatus;
    }


    /**
      * Sets the value of the 'paymentBookingStatus' field.
      * @param value The value of 'paymentBookingStatus'.
      * @return This builder.
      */
    public com.onboard.cinema.book.show.kafka.booking.avro.model.PaymentRequestAvroModel.Builder setPaymentBookingStatus(com.onboard.cinema.book.show.kafka.booking.avro.model.PaymentBookingStatus value) {
      validate(fields()[10], value);
      this.paymentBookingStatus = value;
      fieldSetFlags()[10] = true;
      return this;
    }

    /**
      * Checks whether the 'paymentBookingStatus' field has been set.
      * @return True if the 'paymentBookingStatus' field has been set, false otherwise.
      */
    public boolean hasPaymentBookingStatus() {
      return fieldSetFlags()[10];
    }


    /**
      * Clears the value of the 'paymentBookingStatus' field.
      * @return This builder.
      */
    public com.onboard.cinema.book.show.kafka.booking.avro.model.PaymentRequestAvroModel.Builder clearPaymentBookingStatus() {
      paymentBookingStatus = null;
      fieldSetFlags()[10] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public PaymentRequestAvroModel build() {
      try {
        PaymentRequestAvroModel record = new PaymentRequestAvroModel();
        record.id = fieldSetFlags()[0] ? this.id : (java.lang.String) defaultValue(fields()[0]);
        record.sagaId = fieldSetFlags()[1] ? this.sagaId : (java.lang.String) defaultValue(fields()[1]);
        record.customerId = fieldSetFlags()[2] ? this.customerId : (java.lang.String) defaultValue(fields()[2]);
        record.bookingId = fieldSetFlags()[3] ? this.bookingId : (java.lang.String) defaultValue(fields()[3]);
        record.movieId = fieldSetFlags()[4] ? this.movieId : (java.lang.String) defaultValue(fields()[4]);
        record.showId = fieldSetFlags()[5] ? this.showId : (java.lang.String) defaultValue(fields()[5]);
        record.cinemaId = fieldSetFlags()[6] ? this.cinemaId : (java.lang.String) defaultValue(fields()[6]);
        record.cinemaHallId = fieldSetFlags()[7] ? this.cinemaHallId : (java.lang.String) defaultValue(fields()[7]);
        record.price = fieldSetFlags()[8] ? this.price : (java.math.BigDecimal) defaultValue(fields()[8]);
        record.createdAt = fieldSetFlags()[9] ? this.createdAt : (java.time.Instant) defaultValue(fields()[9]);
        record.paymentBookingStatus = fieldSetFlags()[10] ? this.paymentBookingStatus : (com.onboard.cinema.book.show.kafka.booking.avro.model.PaymentBookingStatus) defaultValue(fields()[10]);
        return record;
      } catch (org.apache.avro.AvroMissingFieldException e) {
        throw e;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<PaymentRequestAvroModel>
    WRITER$ = (org.apache.avro.io.DatumWriter<PaymentRequestAvroModel>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<PaymentRequestAvroModel>
    READER$ = (org.apache.avro.io.DatumReader<PaymentRequestAvroModel>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

}










