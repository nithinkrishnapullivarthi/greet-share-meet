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
 * AnnouncementResponseDTO
 */
<<<<<<< HEAD
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2020-10-14T11:20:10.394987-04:00[America/New_York]")
=======
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2020-10-18T16:37:25.301242500-05:00[America/Chicago]")
>>>>>>> 014a674... get announcements for matching interests

public class AnnouncementResponseDTO   {
  @JsonProperty("id")
  private Integer id;

  @JsonProperty("interest")
  private String interest;

  @JsonProperty("announcement")
  private String announcement;

  public AnnouncementResponseDTO id(Integer id) {
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

  public AnnouncementResponseDTO interest(String interest) {
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

  public AnnouncementResponseDTO announcement(String announcement) {
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
    AnnouncementResponseDTO announcementResponseDTO = (AnnouncementResponseDTO) o;
    return Objects.equals(this.id, announcementResponseDTO.id) &&
        Objects.equals(this.interest, announcementResponseDTO.interest) &&
        Objects.equals(this.announcement, announcementResponseDTO.announcement);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, interest, announcement);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AnnouncementResponseDTO {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    interest: ").append(toIndentedString(interest)).append("\n");
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

