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
 * VolunteerInterest
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2020-11-13T14:53:53.001239-05:00[America/New_York]")

public class VolunteerInterest   {
  @JsonProperty("id")
  private Integer id;

  @JsonProperty("interest")
  private String interest;

  @JsonProperty("category")
  private String category;

  public VolunteerInterest id(Integer id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
  */
  @ApiModelProperty(value = "")


  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public VolunteerInterest interest(String interest) {
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

  public VolunteerInterest category(String category) {
    this.category = category;
    return this;
  }

  /**
   * Get category
   * @return category
  */
  @ApiModelProperty(value = "")


  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    VolunteerInterest volunteerInterest = (VolunteerInterest) o;
    return Objects.equals(this.id, volunteerInterest.id) &&
        Objects.equals(this.interest, volunteerInterest.interest) &&
        Objects.equals(this.category, volunteerInterest.category);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, interest, category);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class VolunteerInterest {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    interest: ").append(toIndentedString(interest)).append("\n");
    sb.append("    category: ").append(toIndentedString(category)).append("\n");
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

