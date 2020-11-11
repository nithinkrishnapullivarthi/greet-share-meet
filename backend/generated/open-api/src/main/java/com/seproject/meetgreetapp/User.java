package com.seproject.meetgreetapp;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.seproject.meetgreetapp.Interest;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.openapitools.jackson.nullable.JsonNullable;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * User
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2020-11-10T18:48:06.388362-06:00[America/Chicago]")

public class User   {
  @JsonProperty("userName")
  private String userName;

  @JsonProperty("usertEmail")
  private String usertEmail;

  @JsonProperty("interest")
  private Interest interest;

  public User userName(String userName) {
    this.userName = userName;
    return this;
  }

  /**
   * Get userName
   * @return userName
  */
  @ApiModelProperty(value = "")


  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public User usertEmail(String usertEmail) {
    this.usertEmail = usertEmail;
    return this;
  }

  /**
   * Get usertEmail
   * @return usertEmail
  */
  @ApiModelProperty(value = "")


  public String getUsertEmail() {
    return usertEmail;
  }

  public void setUsertEmail(String usertEmail) {
    this.usertEmail = usertEmail;
  }

  public User interest(Interest interest) {
    this.interest = interest;
    return this;
  }

  /**
   * Get interest
   * @return interest
  */
  @ApiModelProperty(value = "")

  @Valid

  public Interest getInterest() {
    return interest;
  }

  public void setInterest(Interest interest) {
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
    User user = (User) o;
    return Objects.equals(this.userName, user.userName) &&
        Objects.equals(this.usertEmail, user.usertEmail) &&
        Objects.equals(this.interest, user.interest);
  }

  @Override
  public int hashCode() {
    return Objects.hash(userName, usertEmail, interest);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class User {\n");
    
    sb.append("    userName: ").append(toIndentedString(userName)).append("\n");
    sb.append("    usertEmail: ").append(toIndentedString(usertEmail)).append("\n");
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

