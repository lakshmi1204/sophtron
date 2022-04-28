package org.sophtron.integration.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInstitution {

    private String userInstitutionId;
    private String institutionId;
    private String userId;
    private String lastModified;
}
