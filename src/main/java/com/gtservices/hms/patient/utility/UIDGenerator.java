package com.gtservices.hms.patient.utility;

import java.util.UUID;

public class UIDGenerator
{
    public static String generatePatientUID()
    {
        return "PAT-" + UUID.randomUUID().toString().substring(0,8);

    }
}
