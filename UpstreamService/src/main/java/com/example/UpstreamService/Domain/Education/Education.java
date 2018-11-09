package com.example.UpstreamService.Domain.Education;
import com.example.UpstreamService.Domain.Education.Chicklets;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Education {
    String sectionId;
    String userId;
    String operationType;
    Chicklets chicklets[];

/*    public Education(String sectionId, String userId, String operationType, Chicklets chicklets) {
        this.sectionId = sectionId;
        this.userId = userId;
        this.operationType = operationType;
        this.chicklets = chicklets;
    }

    public String getSectionId() {
        return sectionId;
    }

    public void setSectionId(String sectionId) {
        this.sectionId = sectionId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getOperationType() {
        return operationType;
    }

    public void setOperationType(String operationType) {
        this.operationType = operationType;
    }

    public Chicklets getChicklets() {
        return chicklets;
    }

    public void setChicklets(Chicklets chicklets) {
        this.chicklets = chicklets;
    }*/
}
