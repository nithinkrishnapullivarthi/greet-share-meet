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
 * AnnouncementRequestDTO
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2020-11-13T11:35:19.543595-05:00[America/New_York]")

public class AnnouncementRequestDTO   {
  @JsonProperty("studentId")
  private Integer studentId;

  @JsonProperty("interest")
  private String interest;

  @JsonProperty("interest_id")
  private Integer interestId;

  @JsonProperty("announcement")
  private String announcement;

  public AnnouncementRequestDTO studentId(Integer studentId) {
    this.studentId = studentId;
    return this;
  }

  /**
   * Get studentId
   * @return studentId
  */
  @ApiModelProperty(value = "")


  public Integer getStudentId() {
    return studentId;
  }

  public void setStudentId(Integer studentId) {
    this.studentId = studentId;
  }

  public AnnouncementRequestDTO interest(String interest) {
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

  public AnnouncementRequestDTO interestId(Integer interestId) {
    this.interestId = interestId;
    return this;
  }

  /**
   * Get interestId
   * @return interestId
  */
  @ApiModelProperty(value = "")


  public Integer getInterestId() {
    return interestId;
  }

  public void setInterestId(Integer interestId) {
    this.interestId = interestId;
  }

  public AnnouncementRequestDTO announcement(String announcement) {
    this.announcement = announcement;
    return this;
  }

  /**
   * Get announcement
   * @return announcement
  */
  @ApiModelProperty(value = "")


  public String getAnnouncement() {
    return announcement;
  }

  public void setAnnouncement(String announcement) {
    this.announcement = announcement;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AnnouncementRequestDTO announcementRequestDTO = (AnnouncementRequestDTO) o;
    return Objects.equals(this.studentId, announcementRequestDTO.studentId) &&
        Objects.equals(this.interest, announcementRequestDTO.interest) &&
        Objects.equals(this.interestId, announcementRequestDTO.interestId) &&
        Objects.equals(this.announcement, announcementRequestDTO.announcement);
  }

  @Override
  public int hashCode() {
    return Objects.hash(studentId, interest, interestId, announcement);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AnnouncementRequestDTO {\n");
    
    sb.append("    studentId: ").append(toIndentedString(studentId)).append("\n");
    sb.append("    interest: ").append(toIndentedString(interest)).append("\n");
    sb.append("    interestId: ").append(toIndentedString(interestId)).append("\n");
    sb.append("    announcement: ").append(toIndentedString(announcement)).append("\n");
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

