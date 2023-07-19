package com.mcode.alumninetwork3i.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "educations")
public class EducationEntity extends BaseEntity {

    @Column(name = "school_name")
    private String schoolName;

    private String degree;

    @Column(name = "type_of_study")
    private String typeOfStudy;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(name = "start_date")
    private Date startDate;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(name = "end_date")
    private Date endDate;

    @ManyToOne
    private UserEntity user;

    public EducationEntity(String schoolName,
                           String degree,
                           String typeOfStudy,
                           Date startDate,
                           Date endDate) {
        this.schoolName = schoolName;
        this.degree = degree;
        this.typeOfStudy = typeOfStudy;
        this.startDate = startDate;
        this.endDate = endDate;
    }
}
