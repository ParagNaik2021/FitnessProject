package com.fitness.aiservice.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Map;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Activity {

// we use this in consumer to de-selriaize the incoming activity data from producer

    private String id;
    private String userId;
    private ActivityType type;
    private Integer duration;

    @JsonProperty("caloriesBurned")
    private Integer caloriesBurned;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime startTime;


  //  @Field("metrics")
    private Map<String, Object> additionalmetrics;

    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;
}
