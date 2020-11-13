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
 * InterestsResponseDTO
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2020-11-13T15:25:12.604668-05:00[America/New_York]")

public class InterestsResponseDTO   {
  @JsonProperty("is_volunteer")
  private Boolean isVolunteer;

  @JsonProperty("interests")
  @Valid
  private List<Interest> interests = null;

  @JsonProperty("volunteer_interests")
  @Valid
  private List<VolunteerInterest> volunteerInterests = null;

  public InterestsResponseDTO isVolunteer(Boolean isVolunteer) {
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

  public InterestsResponseDTO interests(List<Interest> interests) {
    this.interests = interests;
    return this;
  }

  public InterestsResponseDTO addInterestsItem(Interest interestsItem) {
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

  public InterestsResponseDTO volunteerInterests(List<VolunteerInterest> volunteerInterests) {
    this.volunteerInterests = volunteerInterests;
    return this;
  }

  public InterestsResponseDTO addVolunteerInterestsItem(VolunteerInterest volunteerInterestsItem) {
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
    InterestsResponseDTO interestsResponseDTO = (InterestsResponseDTO) o;
    return Objects.equals(this.isVolunteer, interestsResponseDTO.isVolunteer) &&
        Objects.equals(this.interests, interestsResponseDTO.interests) &&
        Objects.equals(this.volunteerInterests, interestsResponseDTO.volunteerInterests);
  }

  @Override
  public int hashCode() {
    return Objects.hash(isVolunteer, interests, volunteerInterests);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class InterestsResponseDTO {\n");
    
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

