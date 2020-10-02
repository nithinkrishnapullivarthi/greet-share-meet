package com.seproject.meetgreetapp;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import org.openapitools.jackson.nullable.JsonNullable;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Interests
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2020-10-01T20:18:34.565-05:00[America/Chicago]")

public class Interests   {
  @JsonProperty("interest")
  @Valid
  private List<String> interest = null;

  public Interests interest(List<String> interest) {
    this.interest = interest;
    return this;
  }

  public Interests addInterestItem(String interestItem) {
    if (this.interest == null) {
      this.interest = new ArrayList<>();
    }
    this.interest.add(interestItem);
    return this;
  }

  /**
   * Get interest
   * @return interest
  */
  @ApiModelProperty(value = "")


  public List<String> getInterest() {
    return interest;
  }

  public void setInterest(List<String> interest) {
    this.interest = interest;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Interests interests = (Interests) o;
    return Objects.equals(this.interest, interests.interest);
  }

  @Override
  public int hashCode() {
    return Objects.hash(interest);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Interests {\n");
    
    sb.append("    interest: ").append(toIndentedString(interest)).append("\n");
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

