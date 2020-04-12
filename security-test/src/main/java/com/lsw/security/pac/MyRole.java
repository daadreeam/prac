package com.lsw.security.pac;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MyRole {
    private Integer roleId;
    private String roleName;
}
