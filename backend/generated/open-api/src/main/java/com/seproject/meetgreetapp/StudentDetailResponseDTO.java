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
 * StudentDetailResponseDTO
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2020-11-21T23:33:17.103241-06:00[America/Chicago]")

public class StudentDetailResponseDTO   {
  @JsonProperty("id")
  private Integer id;

  @JsonProperty("name")
  private String name;

  @JsonProperty("department")
  private String department;

  @JsonProperty("email")
  private String email;

  @JsonProperty("is_volunteer")
  private Boolean isVolunteer;

  @JsonProperty("contact")
  private String contact;

  @JsonProperty("interests")
  @Valid
  private List<Interest> interests = null;

  @JsonProperty("volunteer_interests")
  @Valid
  private List<VolunteerInterest> volunteerInterests = null;

  public StudentDetailResponseDTO id(Integer id) {
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

  public StudentDetailResponseDTO name(String name) {
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

  public StudentDetailResponseDTO department(String department) {
    this.department = department;
    return this;
  }

  /**
   * Get department
   * @return department
  */
  @ApiModelProperty(value = "")


  public String getDepartment() {
    return department;
  }

  public void setDepartment(String department) {
    this.department = department;
  }

  public StudentDetailResponseDTO email(String email) {
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

  public StudentDetailResponseDTO isVolunteer(Boolean isVolunteer) {
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

  public StudentDetailResponseDTO contact(String contact) {
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

  public StudentDetailResponseDTO interests(List<Interest> interests) {
    this.interests = interests;
    return this;
  }

  public StudentDetailResponseDTO addInterestsItem(Interest interestsItem) {
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

  public StudentDetailResponseDTO volunteerInterests(List<VolunteerInterest> volunteerInterests) {
    this.volunteerInterests = volunteerInterests;
    return this;
  }

  public StudentDetailResponseDTO addVolunteerInterestsItem(VolunteerInterest volunteerInterestsItem) {
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
    StudentDetailResponseDTO studentDetailResponseDTO = (StudentDetailResponseDTO) o;
    return Objects.equals(this.id, studentDetailResponseDTO.id) &&
        Objects.equals(this.name, studentDetailResponseDTO.name) &&
        Objects.equals(this.department, studentDetailResponseDTO.department) &&
        Objects.equals(this.email, studentDetailResponseDTO.email) &&
        Objects.equals(this.isVolunteer, studentDetailResponseDTO.isVolunteer) &&
        Objects.equals(this.contact, studentDetailResponseDTO.contact) &&
        Objects.equals(this.interests, studentDetailResponseDTO.interests) &&
        Objects.equals(this.volunteerInterests, studentDetailResponseDTO.volunteerInterests);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, department, email, isVolunteer, contact, interests, volunteerInterests);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class StudentDetailResponseDTO {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    department: ").append(toIndentedString(department)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    isVolunteer: ").append(toIndentedString(isVolunteer)).append("\n");
    sb.append("    contact: ").append(toIndentedString(contact)).append("\n");
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

