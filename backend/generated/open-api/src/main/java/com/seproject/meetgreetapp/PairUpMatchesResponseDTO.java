package com.seproject.meetgreetapp;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.openapitools.jackson.nullable.JsonNullable;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * PairUpMatchesResponseDTO
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2020-10-21T14:20:59.893016-04:00[America/New_York]")

public class PairUpMatchesResponseDTO   {
  @JsonProperty("name")
  private String name;

  @JsonProperty("contact")
  private String contact;

  @JsonProperty("email")
  private String email;

  @JsonProperty("interest")
  private String interest;

  @JsonProperty("startDateAndTime")
  private String startDateAndTime;

  @JsonProperty("endDateAndTime")
  private String endDateAndTime;

  public PairUpMatchesResponseDTO name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Get name
   * @return name
  */
  @ApiModelProperty(value = "")


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public PairUpMatchesResponseDTO contact(String contact) {
    this.contact = contact;
    return this;
  }

  /**
   * Get contact
   * @return contact
  */
  @ApiModelProperty(value = "")


  public String getContact() {
    return contact;
  }

  public void setContact(String contact) {
    this.contact = contact;
  }

  public PairUpMatchesResponseDTO email(String email) {
    this.email = email;
    return this;
  }

  /**
   * Get email
   * @return email
  */
  @ApiModelProperty(value = "")


  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public PairUpMatchesResponseDTO interest(String interest) {
    this.interest = interest;
    return this;
  }

  /**
   * Get interest
   * @return interest
  */
  @ApiModelProperty(value = "")


  public String getInterest() {
    return interest;
  }

  public void setInterest(String interest) {
    this.interest = interest;
  }

  public PairUpMatchesResponseDTO startDateAndTime(String startDateAndTime) {
    this.startDateAndTime = startDateAndTime;
    return this;
  }

  /**
   * Get startDateAndTime
   * @return startDateAndTime
  */
  @ApiModelProperty(value = "")


  public String getStartDateAndTime() {
    return startDateAndTime;
  }

  public void setStartDateAndTime(String startDateAndTime) {
    this.startDateAndTime = startDateAndTime;
  }

  public PairUpMatchesResponseDTO endDateAndTime(String endDateAndTime) {
    this.endDateAndTime = endDateAndTime;
    return this;
  }

  /**
   * Get endDateAndTime
   * @return endDateAndTime
  */
  @ApiModelProperty(value = "")


  public String getEndDateAndTime() {
    return endDateAndTime;
  }

  public void setEndDateAndTime(String endDateAndTime) {
    this.endDateAndTime = endDateAndTime;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PairUpMatchesResponseDTO pairUpMatchesResponseDTO = (PairUpMatchesResponseDTO) o;
    return Objects.equals(this.name, pairUpMatchesResponseDTO.name) &&
        Objects.equals(this.contact, pairUpMatchesResponseDTO.contact) &&
        Objects.equals(this.email, pairUpMatchesResponseDTO.email) &&
        Objects.equals(this.interest, pairUpMatchesResponseDTO.interest) &&
        Objects.equals(this.startDateAndTime, pairUpMatchesResponseDTO.startDateAndTime) &&
        Objects.equals(this.endDateAndTime, pairUpMatchesResponseDTO.endDateAndTime);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, contact, email, interest, startDateAndTime, endDateAndTime);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PairUpMatchesResponseDTO {\n");
    
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    contact: ").append(toIndentedString(contact)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    interest: ").append(toIndentedString(interest)).append("\n");
    sb.append("    startDateAndTime: ").append(toIndentedString(startDateAndTime)).append("\n");
    sb.append("    endDateAndTime: ").append(toIndentedString(endDateAndTime)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

