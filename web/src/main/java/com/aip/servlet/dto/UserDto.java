package com.aip.servlet.dto;

import com.aip.dao.model.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDto {

    @NotBlank
    private String firstName;
    private String lastName;
    private String middleName;
    private Integer officerType;
    private Integer officerCode;
    private Instant datePrinyat;
    private Instant dateUvolen;
    private Status status ;
    private Long version;
    private String login;
    private String password;
    private String role;
}
