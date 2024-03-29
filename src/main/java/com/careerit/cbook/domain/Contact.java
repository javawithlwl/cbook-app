package com.careerit.cbook.domain;

import lombok.Data;

import java.util.UUID;

@Data
public class Contact {

        private UUID cid;
        private String name;
        private String email;
        private String mobile;

}
