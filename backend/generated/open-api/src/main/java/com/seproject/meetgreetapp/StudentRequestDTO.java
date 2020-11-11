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
 * StudentRequestDTO
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2020-11-10T18:48:06.388362-06:00[America/Chicago]")

public class StudentRequestDTO   {
  @JsonProperty("username")
  private String username;

  @JsonProperty("password")
  private String password;

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
  private List<String> interests = null;

  @JsonProperty("volunteer_interests")
  @Valid
  private List<String> volunteerInterests = null;

  public StudentRequestDTO username(String username) {
    this.username = username;
    return this;
  }

  /**
   * Get username
   * @return username
  */
  @ApiModelProperty(value = "")


  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public StudentRequestDTO password(String password) {
    this.password = password;
    return this;
  }

  /**
   * Get password
   * @return password
  */
  @ApiModelProperty(value = "")


  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public StudentRequestDTO name(String name) {
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

  public StudentRequestDTO department(String department) {
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

  public StudentRequestDTO email(String email) {
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

  public StudentRequestDTO isVolunteer(Boolean isVolunteer) {
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

  public StudentRequestDTO contact(String contact) {
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

  public StudentRequestDTO interests(List<String> interests) {
    this.interests = interests;
    return this;
  }

  public StudentRequestDTO addInterestsItem(String interestsItem) {
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


  public List<String> getInterests() {
    return interests;
  }

  public void setInterests(List<String> interests) {
    this.interests = interests;
  }

  public StudentRequestDTO volunteerInterests(List<String> volunteerInterests) {
    this.volunteerInterests = volunteerInterests;
    return this;
  }

  public StudentRequestDTO addVolunteerInterestsItem(String volunteerInterestsItem) {
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


  public List<String> getVolunteerInterests() {
    return volunteerInterests;
  }

  public void setVolunteerInterests(List<String> volunteerInterests) {
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
    StudentRequestDTO studentRequestDTO = (StudentRequestDTO) o;
    return Objects.equals(this.username, studentRequestDTO.username) &&
        Objects.equals(this.password, studentRequestDTO.password) &&
        Objects.equals(this.name, studentRequestDTO.name) &&
        Objects.equals(this.department, studentRequestDTO.department) &&
        Objects.equals(this.email, studentRequestDTO.email) &&
        Objects.equals(this.isVolunteer, studentRequestDTO.isVolunteer) &&
        Objects.equals(this.contact, studentRequestDTO.contact) &&
        Objects.equals(this.interests, studentRequestDTO.interests) &&
        Objects.equals(this.volunteerInterests, studentRequestDTO.volunteerInterests);
  }

  @Override
  public int hashCode() {
    return Objects.hash(username, password, name, department, email, isVolunteer, contact, interests, volunteerInterests);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class StudentRequestDTO {\n");
    
    sb.append("    username: ").append(toIndentedString(username)).append("\n");
    sb.append("    password: ").append(toIndentedString(password)).append("\n");
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

