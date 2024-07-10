package com.example.academicSystem.domain.result;



import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="result")
public class Result {
    @EmbeddedId
    private ResultId resultId;

    private Double obtainedGrade;

    public Result() {
    }

    public Result(ResultId resultId, Double obtainedGrade) {
        this.resultId = resultId;
        this.obtainedGrade = obtainedGrade;
    }

    public ResultId getResultId() {
        return resultId;
    }

    public void setResultId(ResultId resultId) {
        this.resultId = resultId;
    }

    public Double getObtainedGrade() {
        return obtainedGrade;
    }

    public void setObtainedGrade(Double obtainedGrade) {
        this.obtainedGrade = obtainedGrade;
    }
}
