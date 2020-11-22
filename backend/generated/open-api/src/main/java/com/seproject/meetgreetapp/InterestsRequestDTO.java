package com.seproject.meetgreetapp;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.seproject.meetgreetapp.Interest;
import com.seproject.meetgreetapp.VolunteerInterest;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import org.openapitools.jackson.nullable.JsonNullable;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * InterestsRequestDTO
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2020-11-21T23:33:17.103241-06:00[America/Chicago]")

public class InterestsRequestDTO   {
  @JsonProperty("is_volunteer")
  private Boolean isVolunteer;

  @JsonProperty("interests")
  @Valid
  private List<Interest> interests = null;

  @JsonProperty("volunteer_interests")
  @Valid
  private List<VolunteerInterest> volunteerInterests = null;

  public InterestsRequestDTO isVolunteer(Boolean isVolunteer) {
    this.isVolunteer = isVolunteer;
    return this;
  }

  /**
   * Get isVolunteer
   * @return isVolunteer
  */
  @ApiModelProperty(value = "")


  public Boolean getIsVolunteer() {
    return isVolunteer;
  }

  public void setIsVolunteer(Boolean isVolunteer) {
    this.isVolunteer = isVolunteer;
  }

  public InterestsRequestDTO interests(List<Interest> interests) {
    this.interests = interests;
    return this;
  }

  public InterestsRequestDTO addInterestsItem(Interest interestsItem) {
    if (this.interests == null) {
      this.interests = new ArrayList<>();
    }
    this.interests.add(interestsItem);
    return this;
  }

  /**
   * Get interests
   * @return interests
  */
  @ApiModelProperty(value = "")

  @Valid

  public List<Interest> getInterests() {
    return interests;
  }

  public void setInterests(List<Interest> interests) {
    this.interests = interests;
  }

  public InterestsRequestDTO volunteerInterests(List<VolunteerInterest> volunteerInterests) {
    this.volunteerInterests = volunteerInterests;
    return this;
  }

  public InterestsRequestDTO addVolunteerInterestsItem(VolunteerInterest volunteerInterestsItem) {
    if (this.volunteerInterests == null) {
      this.volunteerInterests = new ArrayList<>();
    }
    this.volunteerInterests.add(volunteerInterestsItem);
    return this;
  }

  /**
   * Get volunteerInterests
   * @return volunteerInterests
  */
  @ApiModelProperty(value = "")

  @Valid

  public List<VolunteerInterest> getVolunteerInterests() {
    return volunteerInterests;
  }

  public void setVolunteerInterests(List<VolunteerInterest> volunteerInterests) {
    this.volunteerInterests = volunteerInterests;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    InterestsRequestDTO interestsRequestDTO = (InterestsRequestDTO) o;
    return Objects.equals(this.isVolunteer, interestsRequestDTO.isVolunteer) &&
        Objects.equals(this.interests, interestsRequestDTO.interests) &&
        Objects.equals(this.volunteerInterests, interestsRequestDTO.volunteerInterests);
  }

  @Override
  public int hashCode() {
    return Objects.hash(isVolunteer, interests, volunteerInterests);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class InterestsRequestDTO {\n");
    
    sb.append("    isVolunteer: ").append(toIndentedString(isVolunteer)).append("\n");
    sb.append("    interests: ").append(toIndentedString(interests)).append("\n");
    sb.append("    volunteerInterests: ").append(toIndentedString(volunteerInterests)).append("\n");
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

