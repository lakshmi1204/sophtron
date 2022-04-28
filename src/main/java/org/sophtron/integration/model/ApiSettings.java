package org.sophtron.integration.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ApiSettings {

   private  String userId;
   private  String accessKey;
   private  String authHeaderPrefix;

}
