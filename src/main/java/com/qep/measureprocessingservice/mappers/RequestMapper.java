package com.qep.measureprocessingservice.mappers;

import com.google.gson.annotations.JsonAdapter;
import com.qep.measureprocessingservice.LabelsDeserializer;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter @Setter @NoArgsConstructor
public class RequestMapper {
    String resourceType;

    List<Parameter> parameter;
}
